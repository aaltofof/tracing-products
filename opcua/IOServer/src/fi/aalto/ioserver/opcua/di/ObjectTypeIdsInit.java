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

import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import com.prosysopc.ua.stack.builtintypes.UnsignedInteger;

class ObjectTypeIdsInit {
  static ExpandedNodeId initTopologyElementType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(1001L));
  }

  static ExpandedNodeId initIVendorNameplateType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15035L));
  }

  static ExpandedNodeId initITagNameplateType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15048L));
  }

  static ExpandedNodeId initIDeviceHealthType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15051L));
  }

  static ExpandedNodeId initISupportInfoType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15054L));
  }

  static ExpandedNodeId initComponentType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15063L));
  }

  static ExpandedNodeId initDeviceType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(1002L));
  }

  static ExpandedNodeId initSoftwareType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15106L));
  }

  static ExpandedNodeId initBlockType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(1003L));
  }

  static ExpandedNodeId initDeviceHealthDiagnosticAlarmType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15143L));
  }

  static ExpandedNodeId initFailureAlarmType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15292L));
  }

  static ExpandedNodeId initCheckFunctionAlarmType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15441L));
  }

  static ExpandedNodeId initOffSpecAlarmType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15590L));
  }

  static ExpandedNodeId initMaintenanceRequiredAlarmType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(15739L));
  }

  static ExpandedNodeId initConfigurableObjectType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(1004L));
  }

  static ExpandedNodeId initFunctionalGroupType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(1005L));
  }

  static ExpandedNodeId initProtocolType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(1006L));
  }

  static ExpandedNodeId initNetworkType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(6247L));
  }

  static ExpandedNodeId initConnectionPointType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(6308L));
  }

  static ExpandedNodeId initTransferServicesType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(6526L));
  }

  static ExpandedNodeId initLockingServicesType() {
    return new ExpandedNodeId("http://opcfoundation.org/UA/DI/", UnsignedInteger.valueOf(6388L));
  }
}
