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

import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaMethod;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.types.opcua.FiniteStateMachineType;
import com.prosysopc.ua.types.opcua.FiniteStateVariableType;
import com.prosysopc.ua.types.opcua.FiniteTransitionVariableType;
import java.lang.String;

/**
 * Generated on 2020-04-29 17:57:49
 */
@TypeDefinitionId("nsu=http://www.aalto.fi/OPCUA/SkillProfile/;i=11")
public interface SkillStateMachineType extends FiniteStateMachineType {
  String CURRENT_STATE = "CurrentState";

  String LAST_TRANSITION = "LastTransition";

  String LOCK = "lock";

  String RESET = "reset";

  String START = "start";

  String STOP = "stop";

  @Mandatory
  FiniteStateVariableType getCurrentStateNode();

  @Mandatory
  LocalizedText getCurrentState();

  @Mandatory
  void setCurrentState(LocalizedText value) throws StatusException;

  @Mandatory
  FiniteTransitionVariableType getLastTransitionNode();

  @Mandatory
  LocalizedText getLastTransition();

  @Mandatory
  void setLastTransition(LocalizedText value) throws StatusException;

  @Mandatory
  UaMethod getLockNode();

  void lock() throws StatusException, ServiceException;

  @Mandatory
  UaMethod getresetNode();

  void reset() throws StatusException, ServiceException;

  @Mandatory
  UaMethod getstartNode();

  void start() throws StatusException, ServiceException;

  @Mandatory
  UaMethod getstopNode();

  void stop() throws StatusException, ServiceException;
}
