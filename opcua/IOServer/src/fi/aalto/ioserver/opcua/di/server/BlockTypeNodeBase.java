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
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import fi.aalto.ioserver.opcua.di.BlockType;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;

/**
 * Adds the concept of Blocks needed for block-oriented FieldDevices
 * <p>
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=1003")
public abstract class BlockTypeNodeBase extends TopologyElementTypeNode implements BlockType {
  private static GeneratedNodeInitializer<BlockTypeNode> blockTypeNodeInitializer;

  protected BlockTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    GeneratedNodeInitializer<BlockTypeNode> impl = getBlockTypeNodeInitializer();
    if(impl != null) {
      impl.init((BlockTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<BlockTypeNode> getBlockTypeNodeInitializer() {
    return blockTypeNodeInitializer;
  }

  public static void setBlockTypeNodeInitializer(GeneratedNodeInitializer<BlockTypeNode> blockTypeNodeInitializerNewValue) {
    blockTypeNodeInitializer=blockTypeNodeInitializerNewValue;
  }

  @Optional
  @Override
  public UaProperty getRevisionCounterNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "RevisionCounter");
    return getProperty(browseName);
  }

  @Optional
  @Override
  public Integer getRevisionCounter() {
    UaVariable node = getRevisionCounterNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Optional
  @Override
  public void setRevisionCounter(Integer value) {
    UaVariable node = getRevisionCounterNode();
    if (node == null) {
      throw new RuntimeException("Setting RevisionCounter failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting RevisionCounter failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public UaProperty getActualModeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "ActualMode");
    return getProperty(browseName);
  }

  @Optional
  @Override
  public LocalizedText getActualMode() {
    UaVariable node = getActualModeNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText) value;
  }

  @Optional
  @Override
  public void setActualMode(LocalizedText value) {
    UaVariable node = getActualModeNode();
    if (node == null) {
      throw new RuntimeException("Setting ActualMode failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting ActualMode failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public UaProperty getPermittedModeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "PermittedMode");
    return getProperty(browseName);
  }

  @Optional
  @Override
  public LocalizedText[] getPermittedMode() {
    UaVariable node = getPermittedModeNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText[]) value;
  }

  @Optional
  @Override
  public void setPermittedMode(LocalizedText[] value) {
    UaVariable node = getPermittedModeNode();
    if (node == null) {
      throw new RuntimeException("Setting PermittedMode failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting PermittedMode failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public UaProperty getNormalModeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "NormalMode");
    return getProperty(browseName);
  }

  @Optional
  @Override
  public LocalizedText[] getNormalMode() {
    UaVariable node = getNormalModeNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText[]) value;
  }

  @Optional
  @Override
  public void setNormalMode(LocalizedText[] value) {
    UaVariable node = getNormalModeNode();
    if (node == null) {
      throw new RuntimeException("Setting NormalMode failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting NormalMode failed unexpectedly", e);
    }
  }

  @Optional
  @Override
  public UaProperty getTargetModeNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "TargetMode");
    return getProperty(browseName);
  }

  @Optional
  @Override
  public LocalizedText[] getTargetMode() {
    UaVariable node = getTargetModeNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText[]) value;
  }

  @Optional
  @Override
  public void setTargetMode(LocalizedText[] value) {
    UaVariable node = getTargetModeNode();
    if (node == null) {
      throw new RuntimeException("Setting TargetMode failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting TargetMode failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
