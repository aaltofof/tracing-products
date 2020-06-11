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
package fi.aalto.ioserver.opcua.di;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.types.opcua.BaseDataVariableType;
import com.prosysopc.ua.types.opcua.FolderType;
import java.lang.Integer;
import java.lang.String;

/**
 * Defines the basic information components for all configurable elements in a device topology
 * <p>
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=1002")
public interface DeviceType extends ComponentType {
  String MANUFACTURER = "Manufacturer";

  String MANUFACTURER_URI = "ManufacturerUri";

  String MODEL = "Model";

  String HARDWARE_REVISION = "HardwareRevision";

  String SOFTWARE_REVISION = "SoftwareRevision";

  String DEVICE_REVISION = "DeviceRevision";

  String PRODUCT_CODE = "ProductCode";

  String DEVICE_MANUAL = "DeviceManual";

  String DEVICE_CLASS = "DeviceClass";

  String SERIAL_NUMBER = "SerialNumber";

  String PRODUCT_INSTANCE_URI = "ProductInstanceUri";

  String REVISION_COUNTER = "RevisionCounter";

  String C_P_IDENTIFIER = "<CPIdentifier>";

  String DEVICE_HEALTH_ALARMS = "DeviceHealthAlarms";

  String DEVICE_TYPE_IMAGE = "DeviceTypeImage";

  String DOCUMENTATION = "Documentation";

  String PROTOCOL_SUPPORT = "ProtocolSupport";

  String IMAGE_SET = "ImageSet";

  String DEVICE_HEALTH = "DeviceHealth";

  @Mandatory
  UaProperty getManufacturerNode();

  @Mandatory
  LocalizedText getManufacturer();

  @Mandatory
  void setManufacturer(LocalizedText value) throws StatusException;

  @Optional
  UaProperty getManufacturerUriNode();

  @Optional
  String getManufacturerUri();

  @Optional
  void setManufacturerUri(String value) throws StatusException;

  @Mandatory
  UaProperty getModelNode();

  @Mandatory
  LocalizedText getModel();

  @Mandatory
  void setModel(LocalizedText value) throws StatusException;

  @Mandatory
  UaProperty getHardwareRevisionNode();

  @Mandatory
  String getHardwareRevision();

  @Mandatory
  void setHardwareRevision(String value) throws StatusException;

  @Mandatory
  UaProperty getSoftwareRevisionNode();

  @Mandatory
  String getSoftwareRevision();

  @Mandatory
  void setSoftwareRevision(String value) throws StatusException;

  @Mandatory
  UaProperty getDeviceRevisionNode();

  @Mandatory
  String getDeviceRevision();

  @Mandatory
  void setDeviceRevision(String value) throws StatusException;

  @Optional
  UaProperty getProductCodeNode();

  @Optional
  String getProductCode();

  @Optional
  void setProductCode(String value) throws StatusException;

  @Mandatory
  UaProperty getDeviceManualNode();

  @Mandatory
  String getDeviceManual();

  @Mandatory
  void setDeviceManual(String value) throws StatusException;

  @Optional
  UaProperty getDeviceClassNode();

  @Optional
  String getDeviceClass();

  @Optional
  void setDeviceClass(String value) throws StatusException;

  @Mandatory
  UaProperty getSerialNumberNode();

  @Mandatory
  String getSerialNumber();

  @Mandatory
  void setSerialNumber(String value) throws StatusException;

  @Optional
  UaProperty getProductInstanceUriNode();

  @Optional
  String getProductInstanceUri();

  @Optional
  void setProductInstanceUri(String value) throws StatusException;

  @Mandatory
  UaProperty getRevisionCounterNode();

  @Mandatory
  Integer getRevisionCounter();

  @Mandatory
  void setRevisionCounter(Integer value) throws StatusException;

  @Optional
  BaseDataVariableType getDeviceHealthNode();

  @Optional
  DeviceHealthEnumeration getDeviceHealth();

  @Optional
  void setDeviceHealth(DeviceHealthEnumeration value) throws StatusException;

  @Optional
  FolderType getDeviceHealthAlarmsNode();

  @Optional
  FolderType getDeviceTypeImageNode();

  @Optional
  FolderType getDocumentationNode();

  @Optional
  FolderType getProtocolSupportNode();

  @Optional
  FolderType getImageSetNode();
}
