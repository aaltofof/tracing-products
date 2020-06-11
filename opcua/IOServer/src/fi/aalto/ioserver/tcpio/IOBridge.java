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
package fi.aalto.ioserver.tcpio;

import java.io.*;
import java.net.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.types.opcua.server.BaseVariableTypeNode;
import fi.aalto.ioserver.opcua.IONodeManager;
import fi.aalto.ioserver.opcua.iceblocktype.server.IceBlockTypeNode;

/**
 * IOBridge
 * 
 * The Java part of the bridge between NXT and Java.
 * Takes care of all communication between the two and
 * ensures the IO states are synchronised with the physical IceBlock.
 *
 */
public class IOBridge extends Thread {

	private final Socket socket;
	private final IONodeManager nodeManager;
	private IceBlockTypeNode iceBlock = null;
	private static Logger logger = LoggerFactory.getLogger(IOBridge.class);
	private PrintWriter out;
	private BufferedReader in;
	private String iceBlockName;
	private BaseVariableTypeNode DI0;
	private BaseVariableTypeNode DI1;
	private BaseVariableTypeNode DI2;
	private BaseVariableTypeNode DI3;
	private BaseVariableTypeNode DO0;
	private BaseVariableTypeNode DO1;
	private BaseVariableTypeNode DO2;
	private BaseVariableTypeNode DO3;
	private Boolean[] lastState = {false, false, false, false, false, false, false, false};

	/**
	 * Initialises this bridge instance.
	 * 
	 * @param socket The socket the NXT implementation connected to.
	 * @param nodemanager Nodemanager instance managing the IceBlocks.
	 */
	public IOBridge(Socket socket, IONodeManager nodemanager) {
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
			logger.debug("New IOBridge started!");

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
						// Initial contact, create the IceBlock in the address space.
						case "INIT":
							if (initIceBlock(data[0], data[2]))
								out.println(iceBlockName + ";RET;OK");
							else
								out.println(iceBlockName + ";RET;FAILED");
							break;

						// Initialize the IO port names
						case "NAMES":
							if (initNames(data[0], Integer.parseInt(data[2]), data[3], data[4]))
								out.println(iceBlockName + ";RET;OK");
							else
								out.println(iceBlockName + ";RET;FAILED");
							break;

						// Update the IO port states
						case "UPDATE":
							if (updateIceBlock(data))
								out.println(iceBlockName + ";RET;OK");
							else
								out.println(iceBlockName + ";RET;FAILED");
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
					nodeManager.deleteIceBlock(iceBlock);
					throw new NullPointerException("readLine returned NULL");

				}
			}
		} catch (Exception e) {
			logger.warn("IO bridge down! Reason: {}", e.getMessage());
			nodeManager.deleteIceBlock(iceBlock);
		}
	}

	/**
	 * Closes the connection to NXT and deletes the corresponding
	 * IceBlock from the address space.
	 */
	public void close() {
		try {
			socket.close();
			in.close();
			out.close();
			nodeManager.deleteIceBlock(iceBlock);
		} catch (IOException e) {
			logger.error("IO Bridge close failed!");
			logger.error("Details: {}", e.getMessage());
		}
	}

	/**
	 * Creates the IceBlock in the address space with
	 * the specified name and type. Also renames the
	 * thread for easier recognition.
	 * 
	 * @param name Name of the IceBlock to create.
	 * @param type Type of the IceBlock to create.
	 * @return True if the IceBlock was created successfully.
	 */
	private boolean initIceBlock(String name, String type) {
		this.iceBlockName = name;
		this.setName("IOB-" + iceBlockName);
		try {
			if (iceBlock == null) {
				iceBlock = nodeManager.createIceBlock(name, type);
				logger.info("New IO Bridge created for IceBlock '{}' of type '{}' connecting from {}", name, type,
						this.socket.getInetAddress().getHostAddress() + ":" + this.socket.getPort());
				DI0 = (BaseVariableTypeNode) iceBlock.getParameterSetNode().getComponent(new QualifiedName(3, "DI0"));
				DI1 = (BaseVariableTypeNode) iceBlock.getParameterSetNode().getComponent(new QualifiedName(3, "DI1"));
				DI2 = (BaseVariableTypeNode) iceBlock.getParameterSetNode().getComponent(new QualifiedName(3, "DI2"));
				DI3 = (BaseVariableTypeNode) iceBlock.getParameterSetNode().getComponent(new QualifiedName(3, "DI3"));
				DO0 = (BaseVariableTypeNode) iceBlock.getParameterSetNode().getComponent(new QualifiedName(3, "DO0"));
				DO1 = (BaseVariableTypeNode) iceBlock.getParameterSetNode().getComponent(new QualifiedName(3, "DO1"));
				DO2 = (BaseVariableTypeNode) iceBlock.getParameterSetNode().getComponent(new QualifiedName(3, "DO2"));
				DO3 = (BaseVariableTypeNode) iceBlock.getParameterSetNode().getComponent(new QualifiedName(3, "DO3"));
				DI0.setValue(false);
				DI1.setValue(false);
				DI2.setValue(false);
				DI3.setValue(false);
				DO0.setValue(false);
				DO1.setValue(false);
				DO2.setValue(false);
				DO3.setValue(false);
				iceBlock.setDeviceRevision("");
				iceBlock.setHardwareRevision("");
				iceBlock.setIpAddress(socket.getInetAddress().getHostAddress());
				iceBlock.setSerialNumber("");
				iceBlock.setSoftwareRevision("");
				iceBlock.setComponentName(new LocalizedText(iceBlockName));
				
				return true;
			} else
				throw new Exception("Tried to assign new IceBlock to already assigned device node");
		} catch (Exception e) {
			logger.error("initIceBlock failed: {}", e.getMessage());
		}
		return false;
	}

	/**
	 * Initializes the names of the IO ports of the IceBlock
	 * 
	 * @param ibName Name of the IceBlock
	 * @param ioNum Number of the IO port to rename (0-4)
	 * @param diName Name of the Digital Input
	 * @param doName Name of the Digital Output
	 * @return True if the names were updated successfully
	 */
	private boolean initNames(String ibName, int ioNum, String diName, String doName) {
		try {
			if (iceBlockName.contentEquals(ibName)) {
				switch (ioNum) {
				case 0:
					DI0.setDisplayName(new LocalizedText(diName));
					DO0.setDisplayName(new LocalizedText(doName));
					return true;

				case 1:
					DI1.setDisplayName(new LocalizedText(diName));
					DO1.setDisplayName(new LocalizedText(doName));
					return true;

				case 2:
					DI2.setDisplayName(new LocalizedText(diName));
					DO2.setDisplayName(new LocalizedText(doName));
					return true;

				case 3:
					DI3.setDisplayName(new LocalizedText(diName));
					DO3.setDisplayName(new LocalizedText(doName));
					return true;

				default:
					break;
				}
			}
		} catch (Exception e) {
			logger.error("initNames failed for IB '{}', IO num '{}', DI Name: '{}' and DO Name: '{}'", ibName, ioNum,
					diName, doName);
			logger.error("Reason: {}", e.toString());
		}
		return false;
	}

	/**
	 * Updates the IO port states of the IceBlock
	 * @param data Incoming data string from NXT
	 * @return True if states updated successfully
	 */
	private boolean updateIceBlock(String[] data) {
		try {
			if (iceBlockName.contentEquals(data[0])) {
				if (data.length != 10)
					throw new Exception("data.length = " + data.length + " != 10");
				Boolean di0 = Boolean.valueOf(data[2]);
				Boolean di1 = Boolean.valueOf(data[3]);
				Boolean di2 = Boolean.valueOf(data[4]);
				Boolean di3 = Boolean.valueOf(data[5]);
				Boolean do0 = Boolean.valueOf(data[6]);
				Boolean do1 = Boolean.valueOf(data[7]);
				Boolean do2 = Boolean.valueOf(data[8]);
				Boolean do3 = Boolean.valueOf(data[9]);
				if (di0 != lastState[0]) {
					DI0.setValue(di0);
					lastState[0] = di0;					
				}
				if(di1 != lastState[1]) {
					DI1.setValue(di1);
					lastState[1] = di1;					
				}
				if(di2 != lastState[2]) {
					DI2.setValue(di2);
					lastState[2] = di2;
				}
				if(di3 != lastState[3]) {
					DI3.setValue(di3);
					lastState[3] = di3;
				}
				if(do0 != lastState[4]) {
					DO0.setValue(do0);
					lastState[4] = do0;
				}
				if(do1 != lastState[5]) {
					DO1.setValue(do1);
					lastState[5] = do1;					
				}
				if(do2 != lastState[6]) {
					DO2.setValue(do2);
					lastState[6] = do2;
				}
				if(do3 != lastState[7]) {
					DO3.setValue(do3);
					lastState[7] = do3;					
				}
				return true;
			} else
				throw new Exception("Tried to update wrong IceBlock: " + data[0] + " -> " + iceBlockName);
		} catch (Exception e) {
			logger.error("updateIceBlock failed: {}", e.getMessage());
		}
		return false;
	}

}
