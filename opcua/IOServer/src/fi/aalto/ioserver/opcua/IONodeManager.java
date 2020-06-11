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
package fi.aalto.ioserver.opcua;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.nodes.UaNode;
import com.prosysopc.ua.nodes.UaNodeFactoryException;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.UaInstantiationException;
import com.prosysopc.ua.server.UaServer;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.core.Identifiers;

import fi.aalto.ioserver.opcua.iceblocktype.server.IceBlockTypeNode;

/**
 * IONodeManager
 * 
 * Node manager for all IceBlock nodes.
 *
 */
public class IONodeManager extends NodeManagerUaNode {

	public static final String NAMESPACE = "http://www.aalto.fi/OPCUA/EnAS-IceBlocks";
	private final IOEventManagerListener ioEventManagerListener = new IOEventManagerListener();
	private UaNode deviceSet;
	private final int ns = getNamespaceIndex();

	public IONodeManager(UaServer server, String namespaceUri) {
		super(server, namespaceUri);
	}

	@Override
	protected void init() throws StatusException, UaNodeFactoryException {
		super.init();
		createAddressSpace();
	}

	/**
	 * Stores the DeviceSet node for later use.
	 * 
	 * @throws StatusException
	 * @throws UaInstantiationException
	 */
	private void createAddressSpace() throws StatusException, UaInstantiationException {
		this.getEventManager().setListener(ioEventManagerListener);
		deviceSet = getServer().getNodeManagerRoot().getNode(new NodeId(2, 5001));
	}

	/**
	 * Creates a new IceBlock node with the given name and type.
	 * 
	 * @param name IceBlock name.
	 * @param type Type of the IceBlock to create. (Currently only IOREAD)
	 * @return The newly created IceBlock node.
	 * @throws StatusException
	 */
	public IceBlockTypeNode createIceBlock(String name, String type) throws Exception {
		if(!"IOREAD".contentEquals(type)) {
			throw new Exception("Unknown type '" + type + "'. Only 'IOREAD' supported.");
		}

		IceBlockTypeNode IB = createInstance(IceBlockTypeNode.class, name, new NodeId(ns, name));
		this.addNodeAndReference(deviceSet, IB, Identifiers.Organizes);
		return IB;
	}

	/**
	 * Deletes the given IceBlock from the address space.
	 * 
	 * @param iceBlock IceBlock to delete.
	 */
	public void deleteIceBlock(IceBlockTypeNode iceBlock) {
		if (iceBlock != null) {
			try {
				this.deleteNode(iceBlock, true, true);
			} catch (Exception e) {
				//
			}
		}
	}

}
