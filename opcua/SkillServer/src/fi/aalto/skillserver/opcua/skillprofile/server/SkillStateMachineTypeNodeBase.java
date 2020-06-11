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
package fi.aalto.skillserver.opcua.skillprofile.server;

import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaMethod;
import com.prosysopc.ua.nodes.UaVariable;
import com.prosysopc.ua.server.GeneratedNodeInitializer;
import com.prosysopc.ua.server.NodeManagerUaNode;
import com.prosysopc.ua.server.ServiceContext;
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.LocalizedText;
import com.prosysopc.ua.stack.builtintypes.NodeId;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.server.FiniteStateMachineTypeNode;
import com.prosysopc.ua.types.opcua.server.FiniteStateVariableTypeNode;
import com.prosysopc.ua.types.opcua.server.FiniteTransitionVariableTypeNode;
import fi.aalto.skillserver.opcua.skillprofile.SkillStateMachineType;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;

/**
 * Generated on 2020-04-29 17:57:49
 */
@TypeDefinitionId("nsu=http://www.aalto.fi/OPCUA/SkillProfile/;i=11")
public abstract class SkillStateMachineTypeNodeBase extends FiniteStateMachineTypeNode implements SkillStateMachineType {
  private static GeneratedNodeInitializer<SkillStateMachineTypeNode> skillStateMachineTypeNodeInitializer;

  private static SkillStateMachineTypeLockMethod lockMethodImplementation;

  private static SkillStateMachineTyperesetMethod resetMethodImplementation;

  private static SkillStateMachineTypestartMethod startMethodImplementation;

  private static SkillStateMachineTypestopMethod stopMethodImplementation;

  protected SkillStateMachineTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getCurrentStateNode());
    callAfterCreateIfExists(getLastTransitionNode());
    GeneratedNodeInitializer<SkillStateMachineTypeNode> impl = getSkillStateMachineTypeNodeInitializer();
    if(impl != null) {
      impl.init((SkillStateMachineTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<SkillStateMachineTypeNode> getSkillStateMachineTypeNodeInitializer() {
    return skillStateMachineTypeNodeInitializer;
  }

  public static void setSkillStateMachineTypeNodeInitializer(GeneratedNodeInitializer<SkillStateMachineTypeNode> skillStateMachineTypeNodeInitializerNewValue) {
    skillStateMachineTypeNodeInitializer=skillStateMachineTypeNodeInitializerNewValue;
  }

  @Mandatory
  @Override
  public FiniteStateVariableTypeNode getCurrentStateNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/", "CurrentState");
    return (FiniteStateVariableTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public LocalizedText getCurrentState() {
    UaVariable node = getCurrentStateNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node CurrentState does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText) value;
  }

  @Mandatory
  @Override
  public void setCurrentState(LocalizedText value) {
    UaVariable node = getCurrentStateNode();
    if (node == null) {
      throw new RuntimeException("Setting CurrentState failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting CurrentState failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public FiniteTransitionVariableTypeNode getLastTransitionNode() {
    QualifiedName browseName = getQualifiedName("http://opcfoundation.org/UA/", "LastTransition");
    return (FiniteTransitionVariableTypeNode) getComponent(browseName);
  }

  @Mandatory
  @Override
  public LocalizedText getLastTransition() {
    UaVariable node = getLastTransitionNode();
    if (node == null) {
      throw new RuntimeException("Mandatory node LastTransition does not exist");
    }
    Object value = node.getValue().getValue().getValue();
    return (LocalizedText) value;
  }

  @Mandatory
  @Override
  public void setLastTransition(LocalizedText value) {
    UaVariable node = getLastTransitionNode();
    if (node == null) {
      throw new RuntimeException("Setting LastTransition failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting LastTransition failed unexpectedly", e);
    }
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    if (isComponentMatch(getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "lock"), methodId)) {
      doLock(serviceContext);
      return null;
    }
    if (isComponentMatch(getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "reset"), methodId)) {
      doreset(serviceContext);
      return null;
    }
    if (isComponentMatch(getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "start"), methodId)) {
      dostart(serviceContext);
      return null;
    }
    if (isComponentMatch(getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "stop"), methodId)) {
      dostop(serviceContext);
      return null;
    }
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }

  @Mandatory
  @Override
  public UaMethod getLockNode() {
    QualifiedName browseName = getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "lock");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract void onLock(ServiceContext serviceContext) throws StatusException;

  @Override
  public void lock() throws StatusException {
    doLock(ServiceContext.INTERNAL_OPERATION_CONTEXT);
  }

  private void doLock(ServiceContext serviceContext) throws StatusException {
    SkillStateMachineTypeLockMethod impl = getLockMethodImplementation();
    if(impl != null) {
      impl.lock(serviceContext, (SkillStateMachineTypeNode)this);
    } else {
      onLock(serviceContext);
    }
  }

  public static SkillStateMachineTypeLockMethod getLockMethodImplementation() {
    return lockMethodImplementation;
  }

  public static void setLockMethodImplementation(SkillStateMachineTypeLockMethod lockMethodImplementationNewValue) {
    lockMethodImplementation=lockMethodImplementationNewValue;
  }

  @Mandatory
  @Override
  public UaMethod getresetNode() {
    QualifiedName browseName = getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "reset");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract void onreset(ServiceContext serviceContext) throws StatusException;

  @Override
  public void reset() throws StatusException {
    doreset(ServiceContext.INTERNAL_OPERATION_CONTEXT);
  }

  private void doreset(ServiceContext serviceContext) throws StatusException {
    SkillStateMachineTyperesetMethod impl = getResetMethodImplementation();
    if(impl != null) {
      impl.reset(serviceContext, (SkillStateMachineTypeNode)this);
    } else {
      onreset(serviceContext);
    }
  }

  public static SkillStateMachineTyperesetMethod getResetMethodImplementation() {
    return resetMethodImplementation;
  }

  public static void setResetMethodImplementation(SkillStateMachineTyperesetMethod resetMethodImplementationNewValue) {
    resetMethodImplementation=resetMethodImplementationNewValue;
  }

  @Mandatory
  @Override
  public UaMethod getstartNode() {
    QualifiedName browseName = getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "start");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract void onstart(ServiceContext serviceContext) throws StatusException;

  @Override
  public void start() throws StatusException {
    dostart(ServiceContext.INTERNAL_OPERATION_CONTEXT);
  }

  private void dostart(ServiceContext serviceContext) throws StatusException {
    SkillStateMachineTypestartMethod impl = getStartMethodImplementation();
    if(impl != null) {
      impl.start(serviceContext, (SkillStateMachineTypeNode)this);
    } else {
      onstart(serviceContext);
    }
  }

  public static SkillStateMachineTypestartMethod getStartMethodImplementation() {
    return startMethodImplementation;
  }

  public static void setStartMethodImplementation(SkillStateMachineTypestartMethod startMethodImplementationNewValue) {
    startMethodImplementation=startMethodImplementationNewValue;
  }

  @Mandatory
  @Override
  public UaMethod getstopNode() {
    QualifiedName browseName = getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "stop");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract void onstop(ServiceContext serviceContext) throws StatusException;

  @Override
  public void stop() throws StatusException {
    dostop(ServiceContext.INTERNAL_OPERATION_CONTEXT);
  }

  private void dostop(ServiceContext serviceContext) throws StatusException {
    SkillStateMachineTypestopMethod impl = getStopMethodImplementation();
    if(impl != null) {
      impl.stop(serviceContext, (SkillStateMachineTypeNode)this);
    } else {
      onstop(serviceContext);
    }
  }

  public static SkillStateMachineTypestopMethod getStopMethodImplementation() {
    return stopMethodImplementation;
  }

  public static void setStopMethodImplementation(SkillStateMachineTypestopMethod stopMethodImplementationNewValue) {
    stopMethodImplementation=stopMethodImplementationNewValue;
  }
}
