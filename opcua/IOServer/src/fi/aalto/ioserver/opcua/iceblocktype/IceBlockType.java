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
package fi.aalto.ioserver.opcua.iceblocktype;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.types.opcua.BaseObjectType;
import fi.aalto.ioserver.opcua.di.DeviceType;
import java.lang.Integer;
import java.lang.String;

/**
 * Generated on 2020-03-08 11:04:38
 */
@TypeDefinitionId("nsu=http://www.aalto.fi/OPCUA/IceBlockType/;i=1")
public interface IceBlockType extends DeviceType {
  String COMPONENT_NAME = "ComponentName";

  String DEVICE_MANUAL = "DeviceManual";

  String DEVICE_REVISION = "DeviceRevision";

  String HARDWARE_REVISION = "HardwareRevision";

  String IP_ADDRESS = "IpAddress";

  String MANUFACTURER = "Manufacturer";

  String MODEL = "Model";

  String REVISION_COUNTER = "RevisionCounter";

  String SERIAL_NUMBER = "SerialNumber";

  String SOFTWARE_REVISION = "SoftwareRevision";

  String PARAMETER_SET = "ParameterSet";

  @Mandatory
  UaProperty getComponentNameNode();

  @Mandatory
  LocalizedText getComponentName();

  @Mandatory
  void setComponentName(LocalizedText value) throws StatusException;

  @Mandatory
  UaProperty getDeviceManualNode();

  @Mandatory
  String getDeviceManual();

  @Mandatory
  void setDeviceManual(String value) throws StatusException;

  @Mandatory
  UaProperty getDeviceRevisionNode();

  @Mandatory
  String getDeviceRevision();

  @Mandatory
  void setDeviceRevision(String value) throws StatusException;

  @Mandatory
  UaProperty getHardwareRevisionNode();

  @Mandatory
  String getHardwareRevision();

  @Mandatory
  void setHardwareRevision(String value) throws StatusException;

  @Mandatory
  UaProperty getIpAddressNode();

  @Mandatory
  String getIpAddress();

  @Mandatory
  void setIpAddress(String value) throws StatusException;

  @Mandatory
  UaProperty getManufacturerNode();

  @Mandatory
  LocalizedText getManufacturer();

  @Mandatory
  void setManufacturer(LocalizedText value) throws StatusException;

  @Mandatory
  UaProperty getModelNode();

  @Mandatory
  LocalizedText getModel();

  @Mandatory
  void setModel(LocalizedText value) throws StatusException;

  @Mandatory
  UaProperty getRevisionCounterNode();

  @Mandatory
  Integer getRevisionCounter();

  @Mandatory
  void setRevisionCounter(Integer value) throws StatusException;

  @Mandatory
  UaProperty getSerialNumberNode();

  @Mandatory
  String getSerialNumber();

  @Mandatory
  void setSerialNumber(String value) throws StatusException;

  @Mandatory
  UaProperty getSoftwareRevisionNode();

  @Mandatory
  String getSoftwareRevision();

  @Mandatory
  void setSoftwareRevision(String value) throws StatusException;

  @Mandatory
  BaseObjectType getParameterSetNode();
}
