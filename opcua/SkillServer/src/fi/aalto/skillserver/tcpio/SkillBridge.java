/*******************************************************************************
 * Copyright 2020 Information Technologies in Industrial Automation, Aalto Univeristy
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package fi.aalto.skillserver.tcpio;

import java.io.*;
import java.net.*;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.stack.builtintypes.DateTime;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.core.StatusCodes;
import com.prosysopc.ua.types.opcua.server.StateTypeNode;
import com.prosysopc.ua.types.opcua.server.TransitionTypeNode;

import fi.aalto.skillserver.opcua.SkillNodeManager;
import fi.aalto.skillserver.opcua.skillprofile.Ids;
import fi.aalto.skillserver.opcua.skillprofile.server.SkillTypeNode;

/**
 * SkillBridge
 * 
 * The Java part of the bridge between NXT and Java.
 * Takes care of all communication between the two and
 * ensures the skill is synchronised to the implementation
 * running in NXT.
 *
 */
public class SkillBridge extends Thread {

	private final Socket socket;
	private final SkillNodeManager nodeManager;
	private SkillTypeNode skillNode = null;
	private static Logger logger = LoggerFactory.getLogger(SkillBridge.class);
	private PrintWriter out;
	private BufferedReader in;
	private String skillName;
	private String startParameter = "";
	private int startRet = 0;
	private int stopRet = 0;
	private int resetRet = 0;
	private int lockRet = 0;
	private String prevState = "none"; 

	/**
	 * Initialises this bridge instance.
	 * 
	 * @param socket The socket the NXT implementation connected to.
	 * @param nodemanager Nodemanager instance managing the skills.
	 */
	public SkillBridge(Socket socket, SkillNodeManager nodemanager) {
		this.socket = socket;
		this.nodeManager = nodemanager;
		this.setName("SB-" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
	}

	/**
	 * Main function that is run when the bridge thread starts.
	 * Handles the communication to and from the NXT side.
	 */
	public void run() {
		try {
			logger.debug("New SkillBridge started!");

			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String inputLine;
			while (true) {
				// Wait for incoming data and parse it.
				if ((inputLine = in.readLine()) != null) {
					try {
						String[] data = inputLine.split(";");
						if (data.length < 2)
							throw new Exception("Data length below 2");
						switch (data[1]) {
						// Initial contact, create the skill in the address space.
						case "INIT":
							if (initSkill(data[0], data[2]))
								out.println(skillName + ";RET;OK");
							else
								out.println(skillName + ";RET;FAILED");
							break;

						// Update the skill state and transition data.
						case "UPDATE":
							updateSkill(data[0], data[2], data[3], data[4]);
							break;

						// Returned status from a method call.
						case "CALLRET":
							callReturn(data[0], data[2], data[3]);
							break;

						default:
							break;
						}

					} catch (Exception e) {
						logger.error("Error parsing data: {}", inputLine);
					}
				} else {
					socket.close();
					in.close();
					out.close();
					nodeManager.deleteSkill(skillNode);
					throw new NullPointerException("readLine returned NULL");

				}
			}
		} catch (Exception e) {
			logger.warn("Skill bridge down! Reason: {}", e.getMessage());
			nodeManager.deleteSkill(skillNode);
		}
	}

	/**
	 * Handles the response data from NXT after a method has been called.
	 * The call fails if remote control is not enabled in the NXT app.
	 * 
	 * @param name Name of the skill that sent the data.
	 * @param callType The method that this response belongs to.
	 * @param callResult The result of the method call.
	 */
	private void callReturn(String name, String callType, String callResult) {
		if (skillName.contentEquals(name)) {
			int result = 0;
			if (callResult.contentEquals("FAILED"))
				result = -1;
			else if (callResult.contentEquals("OK"))
				result = 1;
			switch (callType) {
			case "START":
				startRet = result;
				break;

			case "STOP":
				stopRet = result;
				break;

			case "RESET":
				resetRet = result;
				break;

			case "LOCK":
				lockRet = result;
				break;

			default:
				break;
			}
		}
	}

	/**
	 * Closes the connection to NXT and deletes the corresponding
	 * skill from the address space.
	 */
	public void close() {
		try {
			socket.close();
			in.close();
			out.close();
			nodeManager.deleteSkill(skillNode);
		} catch (IOException e) {
			logger.error("Skill Bridge close failed!");
			logger.error("Details: {}", e.getMessage());
		}
	}

	/**
	 * Creates the skill in the address space with
	 * the specified name and type. Also renames the
	 * thread for easier recognition.
	 * 
	 * @param name Name of the skill to create.
	 * @param type Type of the skill to create. (Basic(Sens) or Composed(Sens))
	 * @return True if skill was created successfully.
	 */
	private boolean initSkill(String name, String type) {
		this.skillName = name;
		this.setName("SB-" + skillName);
		try {
			if (skillNode == null) {
				skillNode = nodeManager.createSkill(name, type);
				skillNode.setBridge(this);
				logger.info("New SkillBridge created for skill '{}' of type '{}' connecting from {}", name, type,
						this.socket.getInetAddress().getHostAddress() + ":" + this.socket.getPort());
				return true;
			} else
				throw new Exception("Tried to assign new skill to already assigned skill node");
		} catch (Exception e) {
			logger.error("initSkill failed: {}", e.getMessage());
		}
		return false;
	}

	/**
	 * Updates the state and last transition of the skill.
	 * Also triggers a transition event to notify about
	 * the state change.
	 * If the skill is a sensor, also updates the return data.
	 * 
	 * @param name Name of the skill that sent the data.
	 * @param CurrentState The new state of the skill state machine.
	 * @param LastTransition The transition that just occurred.
	 * @param ReturnData The return data from sensor.
	 * @return True if the skill was updated successfully.
	 */
	private boolean updateSkill(String name, String CurrentState, String LastTransition, String ReturnData) {
		try {
			if (skillName.contentEquals(name)) {
				if (CurrentState.isEmpty())
					throw new Exception("CurrentState empty");
				if (LastTransition.isEmpty())
					throw new Exception("LastTransition empty");
				
				// If the state hasn't changed, don't update it
				if (!prevState.contentEquals(CurrentState)) {
					prevState = CurrentState;
					// We have to find the correct state node as defined in the skill model.
					// This so we get the correct ID etc. associated with it.
					StateTypeNode currState;
					switch (CurrentState.toLowerCase(Locale.ROOT)) {
					case "locked":
						currState = nodeManager.getNode(Ids.SkillStateMachineType_Locked, StateTypeNode.class);
						break;

					case "idle":
						currState = nodeManager.getNode(Ids.SkillStateMachineType_Idle, StateTypeNode.class);
						break;

					case "executing":
						currState = nodeManager.getNode(Ids.SkillStateMachineType_Executing, StateTypeNode.class);
						break;

					default:
						throw new Exception("Unknown current state: " + CurrentState);
					}
					// The same also applies for the transition.
					TransitionTypeNode lastTrans = null;
					switch (LastTransition.toLowerCase(Locale.ROOT)) {
					case "executingtoidle":
						lastTrans = nodeManager.getNode(Ids.SkillStateMachineType_ExecutingToIdle,
								TransitionTypeNode.class);
						break;

					case "executingtolocked":
						lastTrans = nodeManager.getNode(Ids.SkillStateMachineType_ExecutingToLocked,
								TransitionTypeNode.class);
						break;

					case "idletoexecuting":
						lastTrans = nodeManager.getNode(Ids.SkillStateMachineType_IdleToExecuting,
								TransitionTypeNode.class);
						break;

					case "idletolocked":
						lastTrans = nodeManager.getNode(Ids.SkillStateMachineType_IdleToLocked,
								TransitionTypeNode.class);
						break;

					case "lockedtoidle":
						lastTrans = nodeManager.getNode(Ids.SkillStateMachineType_LockedToIdle,
								TransitionTypeNode.class);
						break;

					case "none":
						break;

					default:
						throw new Exception("Unknown last transition: " + LastTransition);
					}
					// Save the original state
					LocalizedText fromState = skillNode.getStateMachineNode().getCurrentState();
					// Update the current state and transition to match the new ones.
					skillNode.getStateMachineNode().setCurrentState(currState.getDisplayName());
					skillNode.getStateMachineNode().getCurrentStateNode().setId(currState.getNodeId());
					skillNode.getStateMachineNode().getCurrentStateNode().setNumber(currState.getStateNumber());
					skillNode.getStateMachineNode().getCurrentStateNode().setName(currState.getBrowseName());
					if (lastTrans == null) {
						skillNode.getStateMachineNode().setLastTransition(LocalizedText.EMPTY);
					} else {
						skillNode.getStateMachineNode().setLastTransition(lastTrans.getDisplayName());
						skillNode.getStateMachineNode().getLastTransitionNode().setId(lastTrans.getNodeId());
						skillNode.getStateMachineNode().getLastTransitionNode()
								.setNumber(lastTrans.getTransitionNumber());
						skillNode.getStateMachineNode().getLastTransitionNode().setName(lastTrans.getBrowseName());
						skillNode.getStateMachineNode().getLastTransitionNode()
								.setTransitionTime(DateTime.currentTime());
						// Trigger the transition event so that clients get notified about what happened.
						nodeManager.transitionEvent(skillNode, lastTrans.getDisplayName(), fromState,
								currState.getDisplayName());
					} 
				}
				// If this skill has the return data variable, update it.
				if(skillNode.isSensor) {
					skillNode.setReturnData(ReturnData);
				}
				return true;
			} else
				throw new Exception("Tried to update wrong skill: " + name + " -> " + skillName);
		} catch (Exception e) {
			logger.error("updateSkill failed: {}", e.getMessage());
		}
		return false;
	}

	/**
	 * Set the start parameter (when calling the UA Method).
	 * 
	 * @param param The start parameter to send together with the start call.
	 */
	public void setStartParam(String param) {
		this.startParameter = param;
	}

	/**
	 * Sends the start command to NXT.
	 * Runs when the UA method with same name is called.
	 * 
	 * @throws StatusException
	 */
	public void sendStart() throws StatusException {
		startRet = 0;
		try {
			// Start can only be called while idle.
			if (!skillNode.getStateMachineNode().getCurrentStateNode().getId()
					.equals(nodeManager.getNode(Ids.SkillStateMachineType_Idle, StateTypeNode.class).getNodeId()))
				throw new StatusException(StatusCodes.Bad_InvalidState);
			// Send the call to NXT.
			out.println(skillName + ";CALL;START;" + startParameter);
			do {
				// Wait for the response from NXT. (Handled by callReturn())
				sleep(50);
			} while (startRet == 0);
			if (startRet < 0)
				throw new StatusException("Automatic execution active. Remote control disabled.",
						StatusCodes.Bad_RequestNotAllowed);

		} catch (StatusException e) {
			throw e;
		} catch (Exception e) {
			throw new StatusException(e.toString(), StatusCodes.Bad_InternalError);
		}
	}

	/**
	 * Sends the stop command to NXT.
	 * Runs when the UA method with same name is called.
	 * 
	 * @throws StatusException
	 */
	public void sendStop() throws StatusException {
		stopRet = 0;
		try {
			// Stop can only be called while executing.
			if (!skillNode.getStateMachineNode().getCurrentStateNode().getId()
					.equals(nodeManager.getNode(Ids.SkillStateMachineType_Executing, StateTypeNode.class).getNodeId()))
				throw new StatusException(StatusCodes.Bad_InvalidState);
			out.println(skillName + ";CALL;STOP");
			do {
				sleep(50);
			} while (stopRet == 0);
			if (stopRet < 0)
				throw new StatusException("Automatic execution active. Remote control disabled.",
						StatusCodes.Bad_RequestNotAllowed);

		} catch (StatusException e) {
			throw e;
		} catch (Exception e) {
			throw new StatusException(e.toString(), StatusCodes.Bad_InternalError);
		}
	}

	/**
	 * Sends the reset command to NXT.
	 * Runs when the UA method with same name is called.
	 * 
	 * @throws StatusException
	 */
	public void sendReset() throws StatusException {
		resetRet = 0;
		try {
			// Reset can only be called while locked.
			if (!skillNode.getStateMachineNode().getCurrentStateNode().getId()
					.equals(nodeManager.getNode(Ids.SkillStateMachineType_Locked, StateTypeNode.class).getNodeId()))
				throw new StatusException(StatusCodes.Bad_InvalidState);
			out.println(skillName + ";CALL;RESET");
			do {
				sleep(50);
			} while (resetRet == 0);
			if (resetRet < 0)
				throw new StatusException("Automatic execution active. Remote control disabled.",
						StatusCodes.Bad_RequestNotAllowed);

		} catch (StatusException e) {
			throw e;
		} catch (Exception e) {
			throw new StatusException(e.toString(), StatusCodes.Bad_InternalError);
		}
	}

	/**
	 * Sends the lock command to NXT.
	 * Runs when the UA method with same name is called.
	 * 
	 * @throws StatusException
	 */
	public void sendLock() throws StatusException {
		lockRet = 0;
		try {
			// Lock can only be called while idle.
			if (!skillNode.getStateMachineNode().getCurrentStateNode().getId()
					.equals(nodeManager.getNode(Ids.SkillStateMachineType_Idle, StateTypeNode.class).getNodeId()))
				throw new StatusException(StatusCodes.Bad_InvalidState);
			out.println(skillName + ";CALL;LOCK");
			do {
				sleep(50);
			} while (lockRet == 0);
			if (lockRet < 0)
				throw new StatusException("Automatic execution active. Remote control disabled.",
						StatusCodes.Bad_RequestNotAllowed);

		} catch (StatusException e) {
			throw e;
		} catch (Exception e) {
			throw new StatusException(e.toString(), StatusCodes.Bad_InternalError);
		}
	}

}
