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
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import java.lang.Integer;
import java.lang.String;

/**
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15063")
public interface ComponentType extends TopologyElementType {
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

  String ASSET_ID = "AssetId";

  String COMPONENT_NAME = "ComponentName";

  @Optional
  UaProperty getManufacturerNode();

  @Optional
  LocalizedText getManufacturer();

  @Optional
  void setManufacturer(LocalizedText value) throws StatusException;

  @Optional
  UaProperty getManufacturerUriNode();

  @Optional
  String getManufacturerUri();

  @Optional
  void setManufacturerUri(String value) throws StatusException;

  @Optional
  UaProperty getModelNode();

  @Optional
  LocalizedText getModel();

  @Optional
  void setModel(LocalizedText value) throws StatusException;

  @Optional
  UaProperty getHardwareRevisionNode();

  @Optional
  String getHardwareRevision();

  @Optional
  void setHardwareRevision(String value) throws StatusException;

  @Optional
  UaProperty getSoftwareRevisionNode();

  @Optional
  String getSoftwareRevision();

  @Optional
  void setSoftwareRevision(String value) throws StatusException;

  @Optional
  UaProperty getDeviceRevisionNode();

  @Optional
  String getDeviceRevision();

  @Optional
  void setDeviceRevision(String value) throws StatusException;

  @Optional
  UaProperty getProductCodeNode();

  @Optional
  String getProductCode();

  @Optional
  void setProductCode(String value) throws StatusException;

  @Optional
  UaProperty getDeviceManualNode();

  @Optional
  String getDeviceManual();

  @Optional
  void setDeviceManual(String value) throws StatusException;

  @Optional
  UaProperty getDeviceClassNode();

  @Optional
  String getDeviceClass();

  @Optional
  void setDeviceClass(String value) throws StatusException;

  @Optional
  UaProperty getSerialNumberNode();

  @Optional
  String getSerialNumber();

  @Optional
  void setSerialNumber(String value) throws StatusException;

  @Optional
  UaProperty getProductInstanceUriNode();

  @Optional
  String getProductInstanceUri();

  @Optional
  void setProductInstanceUri(String value) throws StatusException;

  @Optional
  UaProperty getRevisionCounterNode();

  @Optional
  Integer getRevisionCounter();

  @Optional
  void setRevisionCounter(Integer value) throws StatusException;

  @Optional
  UaProperty getAssetIdNode();

  @Optional
  String getAssetId();

  @Optional
  void setAssetId(String value) throws StatusException;

  @Optional
  UaProperty getComponentNameNode();

  @Optional
  LocalizedText getComponentName();

  @Optional
  void setComponentName(LocalizedText value) throws StatusException;
}
