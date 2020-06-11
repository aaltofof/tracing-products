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

class ObjectIdsInit {
  static ExpandedNodeId initSkillType_StateMachine() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(12L));
  }

  static ExpandedNodeId initSkillStateMachineType_LockedToIdle_Locked() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(29L));
  }

  static ExpandedNodeId initSkillStateMachineType_LockedToIdle_Idle() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(30L));
  }

  static ExpandedNodeId initSkillStateMachineType_IdleToExecuting_Executing() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(31L));
  }

  static ExpandedNodeId initSkillStateMachineType_Idle() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(30L));
  }

  static ExpandedNodeId initSkillStateMachineType_LockedToIdle() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(35L));
  }

  static ExpandedNodeId initSkillStateMachineType_IdleToLocked_Locked() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(29L));
  }

  static ExpandedNodeId initSkillStateMachineType_IdleToLocked_Idle() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(30L));
  }

  static ExpandedNodeId initSkillStateMachineType_ExecutingToIdle_Executing() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(31L));
  }

  static ExpandedNodeId initSkillStateMachineType_ExecutingToIdle_Idle() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(30L));
  }

  static ExpandedNodeId initSkillStateMachineType_Locked() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(29L));
  }

  static ExpandedNodeId initSkillStateMachineType_ExecutingToLocked_Locked() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(29L));
  }

  static ExpandedNodeId initSkillStateMachineType_IdleToExecuting_Idle() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(30L));
  }

  static ExpandedNodeId initSkillStateMachineType_ExecutingToIdle() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(33L));
  }

  static ExpandedNodeId initSkillStateMachineType_ExecutingToLocked_Executing() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(31L));
  }

  static ExpandedNodeId initSkillStateMachineType_IdleToLocked() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(34L));
  }

  static ExpandedNodeId initSkillStateMachineType_Executing() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(31L));
  }

  static ExpandedNodeId initSkillStateMachineType_ExecutingToLocked() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(36L));
  }

  static ExpandedNodeId initSkillStateMachineType_IdleToExecuting() {
    return new ExpandedNodeId("http://www.aalto.fi/OPCUA/SkillProfile/", UnsignedInteger.valueOf(32L));
  }
}
