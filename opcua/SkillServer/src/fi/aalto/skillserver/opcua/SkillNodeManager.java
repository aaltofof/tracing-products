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
package fi.aalto.skillserver.opcua;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaNodeFactoryException;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.UaInstantiationException;
import com.prosysopc.ua.server.UaServer;
import com.prosysopc.ua.server.instantiation.NodeBuilderConfiguration;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.core.Identifiers;
import com.prosysopc.ua.types.opcua.server.TransitionEventTypeNode;

import fi.aalto.skillserver.opcua.skillprofile.server.SkillTypeNode;

/**
 * SkillNodeManager
 * 
 * Node manager for all skill nodes.
 *
 */
public class SkillNodeManager extends NodeManagerUaNode {

	public static final String NAMESPACE = "http://www.aalto.fi/OPCUA/EnAS-Skills";
	private static final Logger logger = LoggerFactory.getLogger(SkillNodeManager.class);
	private final SkillEventManagerListener skillEventManagerListener = new SkillEventManagerListener();
	private UaNode basicSkillsFolder;
	private UaNode composedSkillsFolder;
	private final int ns = getNamespaceIndex();

	public SkillNodeManager(UaServer server, String namespaceUri) {
		super(server, namespaceUri);
	}

	@Override
	protected void init() throws StatusException, UaNodeFactoryException {
		super.init();
		createAddressSpace();
	}

	/**
	 * Stores the different skill folders for later use.
	 * 
	 * @throws StatusException
	 * @throws UaInstantiationException
	 */
	private void createAddressSpace() throws StatusException, UaInstantiationException {

		this.getEventManager().setListener(skillEventManagerListener);

		basicSkillsFolder = getServer().getNodeManagerRoot().getNode(new NodeId(2, 47));
		composedSkillsFolder = getServer().getNodeManagerRoot().getNode(new NodeId(2, 48));
	}

	/**
	 * Creates a new skill node with the given name and type.
	 * 
	 * @param name Skill name.
	 * @param type Type of the skill to create. (Basic(Sens) or Composed(Sens))
	 * @return The newly created skill node.
	 * @throws StatusException
	 */
	public SkillTypeNode createSkill(String name, String type) throws StatusException {
		UaNode folder;
		boolean isSens = false;
		switch (type.toLowerCase(Locale.ROOT)) {
		case "basic":
			folder = basicSkillsFolder;
			break;

		case "basicsens":
			folder = basicSkillsFolder;
			isSens = true;
			break;

		case "composed":
			folder = composedSkillsFolder;
			break;
			
		case "composedsens":
			folder = composedSkillsFolder;
			isSens = true;
			break;

		default:
			folder = basicSkillsFolder;
			logger.error("Unknown skill type requested: {}. Going with basic.", type);
			break;
		}
		if (isSens) {
			// If this skill is a sensor and has return data, we must configure the node builder to create the optional node.
			NodeBuilderConfiguration nbconfig = new NodeBuilderConfiguration();
			nbconfig.addOptional(getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "ReturnData"));
			this.setNodeBuilderConfiguration(nbconfig);
		}
		else {
			// If not, use default.
			this.setNodeBuilderConfiguration(null);
		}
		SkillTypeNode skill = createInstance(SkillTypeNode.class, name, new NodeId(ns, name));
		skill.isSensor = isSens;
		this.addNodeAndReference(folder, skill, Identifiers.Organizes);
		this.addReference(folder, skill, Identifiers.HasEventSource, false);
		return skill;
	}

	/**
	 * Deletes the given skill from the address space.
	 * 
	 * @param skill Skill to delete.
	 */
	public void deleteSkill(SkillTypeNode skill) {
		if (skill != null) {
			try {
				this.deleteNode(skill, true, true);
			} catch (Exception e) {
				//
			}
		}
	}

	/**
	 * Used to trigger the TransitionEvent on a Skill state machine state change
	 * 
	 * @param skill      The skill that changed state
	 * @param transition The state machine transition name
	 * @param from       The transition "from" state
	 * @param to         The transition "to" state
	 * @throws StatusException
	 */
	public void transitionEvent(SkillTypeNode skill, LocalizedText transition, LocalizedText from, LocalizedText to)
			throws StatusException {
		if (from != null) {
			TransitionEventTypeNode event = createEvent(TransitionEventTypeNode.class);
			// According to TransitionEventType definition (B.4.16 in UA Spec part 5)
			event.setSourceNode(skill.getStateMachineNode().getNodeId());
			event.setTransition(transition);
			event.setFromState(from);
			event.setToState(to);
			// According to BaseEventType definition (6.4.2 in UA Spec part 5)
			event.setSourceName(skill.getDisplayName().getText()); // Set source name to the name of the skill
			event.setMessage(new LocalizedText(from.getText() + " -> " + to.getText()));
			event.setSeverity(1); // Information only
			event.triggerEvent(null);
		}
	}

}
