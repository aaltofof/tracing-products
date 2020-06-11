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
// Generated from SkillProfile
// by Prosys OPC UA Java SDK Codegen
//
package fi.aalto.skillserver.opcua.skillprofile.server;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.core.StatusCodes;
import fi.aalto.skillserver.tcpio.SkillBridge;
import java.lang.Override;

/**
 * Generated on 2020-04-23 14:43:02
 */

/**
 * 
 * Contains manual edits. DO NOT OVERWRITE!
 *
 */

@TypeDefinitionId("nsu=http://www.aalto.fi/OPCUA/SkillProfile/;i=11")
public class SkillStateMachineTypeNode extends SkillStateMachineTypeNodeBase {
	
	// Store reference to skill bridge instance of this skill.
	private SkillBridge bridge;
	
	protected SkillStateMachineTypeNode(NodeManagerUaNode nodeManager, NodeId nodeId, QualifiedName browseName,
			LocalizedText displayName) {
		super(nodeManager, nodeId, browseName, displayName);
	}
	
	public void setBridge(SkillBridge bridge) {
		this.bridge = bridge;
	}

  @Override
  public void afterCreate() {
    // Use this method to initialize the nodes, when they are all created.
    // Note that 'super.afterCreate()' performs default initializations, so consider
    // whether your own initializations should be done before or after it.
    super.afterCreate();
  }

  /*
   * Use the bridge to send the method call to nxt when called.
   */
  @Override
  protected void onLock(ServiceContext serviceContext) throws StatusException {
		try {
			this.bridge.sendLock();
		} catch (StatusException e) {
			throw e;
		} catch (Exception e) {
			throw new StatusException(e.toString(), StatusCodes.Bad_InternalError);
		}
	}

	@Override
	protected void onreset(ServiceContext serviceContext) throws StatusException {
		try {
			this.bridge.sendReset();
		} catch (StatusException e) {
			throw e;
		} catch (Exception e) {
			throw new StatusException(e.toString(), StatusCodes.Bad_InternalError);
		}
	}

	@Override
	protected void onstart(ServiceContext serviceContext) throws StatusException {
		try {
			this.bridge.sendStart();
		} catch (StatusException e) {
			throw e;
		} catch (Exception e) {
			throw new StatusException(e.toString(), StatusCodes.Bad_InternalError);
		}
	}

	@Override
	protected void onstop(ServiceContext serviceContext) throws StatusException {
		try {
			this.bridge.sendStop();
		} catch (StatusException e) {
			throw e;
		} catch (Exception e) {
			throw new StatusException(e.toString(), StatusCodes.Bad_InternalError);
		}
	}
}
