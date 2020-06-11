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

/**
 * Generated on 2020-03-07 22:47:52
 */
public interface MethodIds {
  ExpandedNodeId TopologyElementType_MethodSet_MethodIdentifier = MethodIdsInit.initTopologyElementType_MethodSet_MethodIdentifier();

  ExpandedNodeId TopologyElementType_Lock_ExitLock = MethodIdsInit.initTopologyElementType_Lock_ExitLock();

  ExpandedNodeId TopologyElementType_Lock_BreakLock = MethodIdsInit.initTopologyElementType_Lock_BreakLock();

  ExpandedNodeId TopologyElementType_Lock_RenewLock = MethodIdsInit.initTopologyElementType_Lock_RenewLock();

  ExpandedNodeId TopologyElementType_Lock_InitLock = MethodIdsInit.initTopologyElementType_Lock_InitLock();

  ExpandedNodeId NetworkType_Lock_RenewLock = MethodIdsInit.initNetworkType_Lock_RenewLock();

  ExpandedNodeId NetworkType_Lock_ExitLock = MethodIdsInit.initNetworkType_Lock_ExitLock();

  ExpandedNodeId NetworkType_Lock_InitLock = MethodIdsInit.initNetworkType_Lock_InitLock();

  ExpandedNodeId NetworkType_Lock_BreakLock = MethodIdsInit.initNetworkType_Lock_BreakLock();

  ExpandedNodeId TransferServicesType_FetchTransferResultData = MethodIdsInit.initTransferServicesType_FetchTransferResultData();

  ExpandedNodeId TransferServicesType_TransferToDevice = MethodIdsInit.initTransferServicesType_TransferToDevice();

  ExpandedNodeId TransferServicesType_TransferFromDevice = MethodIdsInit.initTransferServicesType_TransferFromDevice();

  ExpandedNodeId LockingServicesType_BreakLock = MethodIdsInit.initLockingServicesType_BreakLock();

  ExpandedNodeId LockingServicesType_ExitLock = MethodIdsInit.initLockingServicesType_ExitLock();

  ExpandedNodeId LockingServicesType_RenewLock = MethodIdsInit.initLockingServicesType_RenewLock();

  ExpandedNodeId LockingServicesType_InitLock = MethodIdsInit.initLockingServicesType_InitLock();
}
