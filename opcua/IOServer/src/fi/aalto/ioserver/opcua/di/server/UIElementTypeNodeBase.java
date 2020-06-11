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

import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.types.opcua.server.BaseDataVariableTypeNode;
import fi.aalto.ioserver.opcua.di.UIElementType;
import java.lang.Override;

/**
 * The base type for all UI Element Types.
 * <p>
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6246")
public abstract class UIElementTypeNodeBase extends BaseDataVariableTypeNode implements UIElementType {
  private static GeneratedNodeInitializer<UIElementTypeNode> uIElementTypeNodeInitializer;

  protected UIElementTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<UIElementTypeNode> impl = getUIElementTypeNodeInitializer();
    if(impl != null) {
      impl.init((UIElementTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<UIElementTypeNode> getUIElementTypeNodeInitializer() {
    return uIElementTypeNodeInitializer;
  }

  public static void setUIElementTypeNodeInitializer(GeneratedNodeInitializer<UIElementTypeNode> uIElementTypeNodeInitializerNewValue) {
    uIElementTypeNodeInitializer=uIElementTypeNodeInitializerNewValue;
  }
}
