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
 * Adds the concept of Blocks needed for block-oriented FieldDevices
 * <p>
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=1003")
public interface BlockType extends TopologyElementType {
  String REVISION_COUNTER = "RevisionCounter";

  String ACTUAL_MODE = "ActualMode";

  String PERMITTED_MODE = "PermittedMode";

  String NORMAL_MODE = "NormalMode";

  String TARGET_MODE = "TargetMode";

  @Optional
  UaProperty getRevisionCounterNode();

  @Optional
  Integer getRevisionCounter();

  @Optional
  void setRevisionCounter(Integer value) throws StatusException;

  @Optional
  UaProperty getActualModeNode();

  @Optional
  LocalizedText getActualMode();

  @Optional
  void setActualMode(LocalizedText value) throws StatusException;

  @Optional
  UaProperty getPermittedModeNode();

  @Optional
  LocalizedText[] getPermittedMode();

  @Optional
  void setPermittedMode(LocalizedText[] value) throws StatusException;

  @Optional
  UaProperty getNormalModeNode();

  @Optional
  LocalizedText[] getNormalMode();

  @Optional
  void setNormalMode(LocalizedText[] value) throws StatusException;

  @Optional
  UaProperty getTargetModeNode();

  @Optional
  LocalizedText[] getTargetMode();

  @Optional
  void setTargetMode(LocalizedText[] value) throws StatusException;
}
