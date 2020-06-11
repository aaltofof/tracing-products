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

/**
 * Generated on 2020-04-29 17:57:49
 */
public interface MethodIds {
  ExpandedNodeId SkillType_StateMachine_Lock = MethodIdsInit.initSkillType_StateMachine_Lock();

  ExpandedNodeId SkillType_StateMachine_reset = MethodIdsInit.initSkillType_StateMachine_reset();

  ExpandedNodeId SkillType_SetStartParameter = MethodIdsInit.initSkillType_SetStartParameter();

  ExpandedNodeId SkillType_StateMachine_start = MethodIdsInit.initSkillType_StateMachine_start();

  ExpandedNodeId SkillType_StateMachine_stop = MethodIdsInit.initSkillType_StateMachine_stop();

  ExpandedNodeId SkillStateMachineType_reset = MethodIdsInit.initSkillStateMachineType_reset();

  ExpandedNodeId SkillStateMachineType_stop = MethodIdsInit.initSkillStateMachineType_stop();

  ExpandedNodeId SkillStateMachineType_start = MethodIdsInit.initSkillStateMachineType_start();

  ExpandedNodeId SkillStateMachineType_IdleToExecuting_start = MethodIdsInit.initSkillStateMachineType_IdleToExecuting_start();

  ExpandedNodeId SkillStateMachineType_IdleToLocked_Lock = MethodIdsInit.initSkillStateMachineType_IdleToLocked_Lock();

  ExpandedNodeId SkillStateMachineType_Lock = MethodIdsInit.initSkillStateMachineType_Lock();

  ExpandedNodeId SkillStateMachineType_LockedToIdle_reset = MethodIdsInit.initSkillStateMachineType_LockedToIdle_reset();

  ExpandedNodeId SkillStateMachineType_ExecutingToIdle_stop = MethodIdsInit.initSkillStateMachineType_ExecutingToIdle_stop();
}
