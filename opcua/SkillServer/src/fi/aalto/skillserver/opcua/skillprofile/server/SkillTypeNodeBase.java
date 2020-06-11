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
import com.prosysopc.ua.nodes.Optional;
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
import com.prosysopc.ua.types.opcua.server.BaseDataVariableTypeNode;
import com.prosysopc.ua.types.opcua.server.BaseObjectTypeNode;
import fi.aalto.skillserver.opcua.skillprofile.SkillType;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

/**
 * Generated on 2020-04-29 17:57:49
 */
@TypeDefinitionId("nsu=http://www.aalto.fi/OPCUA/SkillProfile/;i=1")
public abstract class SkillTypeNodeBase extends BaseObjectTypeNode implements SkillType {
  private static GeneratedNodeInitializer<SkillTypeNode> skillTypeNodeInitializer;

  private static SkillTypeSetStartParameterMethod setStartParameterMethodImplementation;

  protected SkillTypeNodeBase(NodeManagerUaNode nodeManager, NodeId nodeId,
      QualifiedName browseName, LocalizedText displayName) {
    super(nodeManager, nodeId, browseName, displayName);
  }

  @Override
  public void afterCreate() {
    super.afterCreate();

    // Call afterCreate for each sub-node (if the node has any)
    callAfterCreateIfExists(getReturnDataNode());
    callAfterCreateIfExists(getStateMachineNode());
    GeneratedNodeInitializer<SkillTypeNode> impl = getSkillTypeNodeInitializer();
    if(impl != null) {
      impl.init((SkillTypeNode)this);
    }
  }

  public static GeneratedNodeInitializer<SkillTypeNode> getSkillTypeNodeInitializer() {
    return skillTypeNodeInitializer;
  }

  public static void setSkillTypeNodeInitializer(GeneratedNodeInitializer<SkillTypeNode> skillTypeNodeInitializerNewValue) {
    skillTypeNodeInitializer=skillTypeNodeInitializerNewValue;
  }

  @Optional
  @Override
  public BaseDataVariableTypeNode getReturnDataNode() {
    QualifiedName browseName = getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "ReturnData");
    return (BaseDataVariableTypeNode) getComponent(browseName);
  }

  @Optional
  @Override
  public String getReturnData() {
    UaVariable node = getReturnDataNode();
    if (node == null) {
      return null;
    }
    Object value = node.getValue().getValue().getValue();
    return (String) value;
  }

  @Optional
  @Override
  public void setReturnData(String value) {
    UaVariable node = getReturnDataNode();
    if (node == null) {
      throw new RuntimeException("Setting ReturnData failed: does not exist (Optional Nodes must be configured in NodeBuilder)");
    }
    try {
      node.setValue(value);
    } catch(StatusException e) {
      throw new RuntimeException("Setting ReturnData failed unexpectedly", e);
    }
  }

  @Mandatory
  @Override
  public SkillStateMachineTypeNode getStateMachineNode() {
    QualifiedName browseName = getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "StateMachine");
    return (SkillStateMachineTypeNode) getComponent(browseName);
  }

  @Override
  public Variant[] callMethod(ServiceContext serviceContext, NodeId methodId,
      Variant[] inputArguments, StatusCode[] inputArgumentResults,
      DiagnosticInfo[] inputArgumentDiagnosticInfos) throws StatusException {
    if (isComponentMatch(getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "SetStartParameter"), methodId)) {
      doSetStartParameter(serviceContext, (String) inputArguments[0].getValue());
      return null;
    }
    return super.callMethod(serviceContext, methodId, inputArguments, inputArgumentResults, inputArgumentDiagnosticInfos);
  }

  @Mandatory
  @Override
  public UaMethod getSetStartParameterNode() {
    QualifiedName browseName = getQualifiedName("http://www.aalto.fi/OPCUA/SkillProfile/", "SetStartParameter");
    return (UaMethod) getComponent(browseName);
  }

  protected abstract void onSetStartParameter(ServiceContext serviceContext, String startParameter)
      throws StatusException;

  @Override
  public void setStartParameter(String startParameter) throws StatusException {
    doSetStartParameter(ServiceContext.INTERNAL_OPERATION_CONTEXT, startParameter);
  }

  private void doSetStartParameter(ServiceContext serviceContext, String startParameter) throws
      StatusException {
    SkillTypeSetStartParameterMethod impl = getSetStartParameterMethodImplementation();
    if(impl != null) {
      impl.setStartParameter(serviceContext, (SkillTypeNode)this, startParameter);
    } else {
      onSetStartParameter(serviceContext, startParameter);
    }
  }

  public static SkillTypeSetStartParameterMethod getSetStartParameterMethodImplementation() {
    return setStartParameterMethodImplementation;
  }

  public static void setSetStartParameterMethodImplementation(SkillTypeSetStartParameterMethod setStartParameterMethodImplementationNewValue) {
    setStartParameterMethodImplementation=setStartParameterMethodImplementationNewValue;
  }
}
