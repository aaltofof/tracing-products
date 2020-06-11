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
// Generated from SkillProfile
// by Prosys OPC UA Java SDK Codegen
//
package fi.aalto.skillserver.opcua.skillprofile;

import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import com.prosysopc.ua.stack.builtintypes.UnsignedInteger;

class MethodIdsInit {
  static ExpandedNodeId initSkillType_StateMachine_Lock() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(25L));
  }

  static ExpandedNodeId initSkillType_StateMachine_reset() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(26L));
  }

  static ExpandedNodeId initSkillType_SetStartParameter() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(10L));
  }

  static ExpandedNodeId initSkillType_StateMachine_start() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(27L));
  }

  static ExpandedNodeId initSkillType_StateMachine_stop() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(28L));
  }

  static ExpandedNodeId initSkillStateMachineType_reset() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(23L));
  }

  static ExpandedNodeId initSkillStateMachineType_stop() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(22L));
  }

  static ExpandedNodeId initSkillStateMachineType_start() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(21L));
  }

  static ExpandedNodeId initSkillStateMachineType_IdleToExecuting_start() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(21L));
  }

  static ExpandedNodeId initSkillStateMachineType_IdleToLocked_Lock() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(24L));
  }

  static ExpandedNodeId initSkillStateMachineType_Lock() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(24L));
  }

  static ExpandedNodeId initSkillStateMachineType_LockedToIdle_reset() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(23L));
  }

  static ExpandedNodeId initSkillStateMachineType_ExecutingToIdle_stop() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(22L));
  }
}
