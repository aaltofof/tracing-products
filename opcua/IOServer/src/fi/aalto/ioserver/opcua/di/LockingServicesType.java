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

import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaMethod;
import com.prosysopc.ua.nodes.UaProperty;
import com.prosysopc.ua.types.opcua.BaseObjectType;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;

/**
 * An interface for Locking.
 * <p>
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6388")
public interface LockingServicesType extends BaseObjectType {
  String LOCKED = "Locked";

  String LOCKING_CLIENT = "LockingClient";

  String LOCKING_USER = "LockingUser";

  String REMAINING_LOCK_TIME = "RemainingLockTime";

  String INIT_LOCK = "InitLock";

  String RENEW_LOCK = "RenewLock";

  String EXIT_LOCK = "ExitLock";

  String BREAK_LOCK = "BreakLock";

  @Mandatory
  UaProperty getLockedNode();

  @Mandatory
  Boolean isLocked();

  @Mandatory
  void setLocked(Boolean value) throws StatusException;

  @Mandatory
  UaProperty getLockingClientNode();

  @Mandatory
  String getLockingClient();

  @Mandatory
  void setLockingClient(String value) throws StatusException;

  @Mandatory
  UaProperty getLockingUserNode();

  @Mandatory
  String getLockingUser();

  @Mandatory
  void setLockingUser(String value) throws StatusException;

  @Mandatory
  UaProperty getRemainingLockTimeNode();

  @Mandatory
  Double getRemainingLockTime();

  @Mandatory
  void setRemainingLockTime(Double value) throws StatusException;

  @Mandatory
  UaMethod getInitLockNode();

  Integer initLock(String context) throws StatusException, ServiceException;

  @Mandatory
  UaMethod getRenewLockNode();

  Integer renewLock() throws StatusException, ServiceException;

  @Mandatory
  UaMethod getExitLockNode();

  Integer exitLock() throws StatusException, ServiceException;

  @Mandatory
  UaMethod getBreakLockNode();

  Integer breakLock() throws StatusException, ServiceException;
}
