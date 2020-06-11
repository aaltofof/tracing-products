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
// Generated from by Prosys OPC UA Java SDK Codegen
//
package fi.aalto.ioserver.opcua.di.server;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.Structure;
import com.prosysopc.ua.stack.core.StatusCodes;
import fi.aalto.ioserver.opcua.di.TransferServicesType;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;

/**
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6526")
public class TransferServicesTypeNode extends TransferServicesTypeNodeBase {
  protected TransferServicesTypeNode(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    // Use this method to initialize the nodes, when they are all created.
    // Note that 'super.afterCreate()' performs default initializations, so consider
    // whether your own initializations should be done before or after it.
    super.afterCreate();
  }

  @Override
  protected TransferServicesType.TransferToDeviceMethodOutputs onTransferToDevice(ServiceContext serviceContext)
      throws StatusException {
    //Implement the generated method here (and remove the code below) OR set implementation via static method setTransferToDeviceMethodImplementation 
    throw new StatusException(StatusCodes.Bad_NotImplemented);
  }

  @Override
  protected TransferServicesType.TransferFromDeviceMethodOutputs onTransferFromDevice(ServiceContext serviceContext)
      throws StatusException {
    //Implement the generated method here (and remove the code below) OR set implementation via static method setTransferFromDeviceMethodImplementation 
    throw new StatusException(StatusCodes.Bad_NotImplemented);
  }

  @Override
  protected Structure onFetchTransferResultData(ServiceContext serviceContext, Integer transferID,
      Integer sequenceNumber, Integer maxParameterResultsToReturn, Boolean omitGoodResults) throws
      StatusException {
    //Implement the generated method here (and remove the code below) OR set implementation via static method setFetchTransferResultDataMethodImplementation 
    throw new StatusException(StatusCodes.Bad_NotImplemented);
  }
}