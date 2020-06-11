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
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.BaseInterfaceTypeNode;
import com.prosysopc.ua.types.opcua.server.FolderTypeNode;
import fi.aalto.ioserver.opcua.di.ISupportInfoType;
import java.lang.Override;

/**
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15054")
public abstract class ISupportInfoTypeNodeBase extends BaseInterfaceTypeNode implements ISupportInfoType {
  private static GeneratedNodeInitializer<ISupportInfoTypeNode> iSupportInfoTypeNodeInitializer;

  protected ISupportInfoTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getDeviceTypeImageNode());
    callAfterCreateIfExists(getDocumentationNode());
    callAfterCreateIfExists(getProtocolSupportNode());
    callAfterCreateIfExists(getImageSetNode());
    GeneratedNodeInitializer<ISupportInfoTypeNode> impl = getISupportInfoTypeNodeInitializer();
    if(impl != null) {
      impl.init((ISupportInfoTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<ISupportInfoTypeNode> getISupportInfoTypeNodeInitializer() {
    return iSupportInfoTypeNodeInitializer;
  }

  public static void setISupportInfoTypeNodeInitializer(GeneratedNodeInitializer<ISupportInfoTypeNode> iSupportInfoTypeNodeInitializerNewValue) {
    iSupportInfoTypeNodeInitializer=iSupportInfoTypeNodeInitializerNewValue;
  }

  @Optional
  @Override
  public FolderTypeNode getDeviceTypeImageNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "DeviceTypeImage");
    return (FolderTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public FolderTypeNode getDocumentationNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "Documentation");
    return (FolderTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public FolderTypeNode getProtocolSupportNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "ProtocolSupport");
    return (FolderTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public FolderTypeNode getImageSetNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "ImageSet");
    return (FolderTypeNode) getComponent(browseName);
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}