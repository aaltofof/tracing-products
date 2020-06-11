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
package fi.aalto.ioserver.opcua.iceblocktype.server;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
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
import com.prosysopc.ua.types.opcua.server.BaseObjectTypeNode;
import fi.aalto.ioserver.opcua.di.server.DeviceTypeNode;
import fi.aalto.ioserver.opcua.iceblocktype.IceBlockType;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

/**
 * Generated on 2020-03-08 11:04:38
 */
@TypeDefinitionId("nsu=http://www.aalto.fi/OPCUA/IceBlockType/;i=1")
public abstract class IceBlockTypeNodeBase extends DeviceTypeNode implements IceBlockType {
  private static GeneratedNodeInitializer<IceBlockTypeNode> iceBlockTypeNodeInitializer;

  protected IceBlockTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getParameterSetNode());
    GeneratedNodeInitializer<IceBlockTypeNode> impl = getIceBlockTypeNodeInitializer();
    if(impl != null) {
      impl.init((IceBlockTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<IceBlockTypeNode> getIceBlockTypeNodeInitializer() {
    return iceBlockTypeNodeInitializer;
  }

  public static void setIceBlockTypeNodeInitializer(GeneratedNodeInitializer<IceBlockTypeNode> iceBlockTypeNodeInitializerNewValue) {
    iceBlockTypeNodeInitializer=iceBlockTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public UaProperty getComponentNameNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "ComponentName");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public LocalizedText getComponentName() {
    UaVariable node = getComponentNameNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node ComponentName does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText) value;
  }

  @Mandatory
  @Override
  public void setComponentName(LocalizedText value) {
    UaVariable node = getComponentNameNode();
    if (node == null) {
      throw new RuntimeException("Setting ComponentName failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting ComponentName failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getDeviceManualNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "DeviceManual");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public String getDeviceManual() {
    UaVariable node = getDeviceManualNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node DeviceManual does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Mandatory
  @Override
  public void setDeviceManual(String value) {
    UaVariable node = getDeviceManualNode();
    if (node == null) {
      throw new RuntimeException("Setting DeviceManual failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting DeviceManual failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getDeviceRevisionNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "DeviceRevision");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public String getDeviceRevision() {
    UaVariable node = getDeviceRevisionNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node DeviceRevision does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Mandatory
  @Override
  public void setDeviceRevision(String value) {
    UaVariable node = getDeviceRevisionNode();
    if (node == null) {
      throw new RuntimeException("Setting DeviceRevision failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting DeviceRevision failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getHardwareRevisionNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "HardwareRevision");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public String getHardwareRevision() {
    UaVariable node = getHardwareRevisionNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node HardwareRevision does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Mandatory
  @Override
  public void setHardwareRevision(String value) {
    UaVariable node = getHardwareRevisionNode();
    if (node == null) {
      throw new RuntimeException("Setting HardwareRevision failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting HardwareRevision failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getIpAddressNode() {
    QualifiedName browseName = getQualifiedName("http://www.aalto.fi/OPCUA/IceBlockType/", "IpAddress");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public String getIpAddress() {
    UaVariable node = getIpAddressNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node IpAddress does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Mandatory
  @Override
  public void setIpAddress(String value) {
    UaVariable node = getIpAddressNode();
    if (node == null) {
      throw new RuntimeException("Setting IpAddress failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting IpAddress failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getManufacturerNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "Manufacturer");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public LocalizedText getManufacturer() {
    UaVariable node = getManufacturerNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node Manufacturer does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText) value;
  }

  @Mandatory
  @Override
  public void setManufacturer(LocalizedText value) {
    UaVariable node = getManufacturerNode();
    if (node == null) {
      throw new RuntimeException("Setting Manufacturer failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting Manufacturer failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getModelNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "Model");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public LocalizedText getModel() {
    UaVariable node = getModelNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node Model does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText) value;
  }

  @Mandatory
  @Override
  public void setModel(LocalizedText value) {
    UaVariable node = getModelNode();
    if (node == null) {
      throw new RuntimeException("Setting Model failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting Model failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getRevisionCounterNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "RevisionCounter");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public Integer getRevisionCounter() {
    UaVariable node = getRevisionCounterNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node RevisionCounter does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (Integer) value;
  }

  @Mandatory
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

  @Mandatory
  @Override
  public UaProperty getSerialNumberNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "SerialNumber");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public String getSerialNumber() {
    UaVariable node = getSerialNumberNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node SerialNumber does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Mandatory
  @Override
  public void setSerialNumber(String value) {
    UaVariable node = getSerialNumberNode();
    if (node == null) {
      throw new RuntimeException("Setting SerialNumber failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SerialNumber failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public UaProperty getSoftwareRevisionNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "SoftwareRevision");
    return getProperty(browseName);
  }

  @Mandatory
  @Override
  public String getSoftwareRevision() {
    UaVariable node = getSoftwareRevisionNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node SoftwareRevision does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Mandatory
  @Override
  public void setSoftwareRevision(String value) {
    UaVariable node = getSoftwareRevisionNode();
    if (node == null) {
      throw new RuntimeException("Setting SoftwareRevision failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting SoftwareRevision failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public BaseObjectTypeNode getParameterSetNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/DI/", "ParameterSet");
    return (BaseObjectTypeNode) getComponent(browseName);
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }
}
