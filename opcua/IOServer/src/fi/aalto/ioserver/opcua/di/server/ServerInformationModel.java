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
package fi.aalto.ioserver.opcua.di.server;

import com.prosysopc.ua.server.ServerCodegenModel;
import com.prosysopc.ua.server.ServerCodegenModelProvider;
import fi.aalto.ioserver.opcua.di.DataTypeDictionaryHelper;
import fi.aalto.ioserver.opcua.di.DeviceHealthEnumeration;
import fi.aalto.ioserver.opcua.di.FetchResultDataType;
import fi.aalto.ioserver.opcua.di.ParameterResultDataType;
import fi.aalto.ioserver.opcua.di.Serializers;
import fi.aalto.ioserver.opcua.di.TransferResultDataDataType;
import fi.aalto.ioserver.opcua.di.TransferResultErrorDataType;
import java.lang.Override;
import java.lang.RuntimeException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Generated on 2020-03-07 22:47:52
 */
public class ServerInformationModel implements ServerCodegenModelProvider {
  public static final ServerCodegenModel MODEL;

  static {
    ServerCodegenModel.Builder b = ServerCodegenModel.builder();
    b.addClass(TopologyElementTypeNode.class);
    b.addClass(IVendorNameplateTypeNode.class);
    b.addClass(ITagNameplateTypeNode.class);
    b.addClass(IDeviceHealthTypeNode.class);
    b.addClass(ISupportInfoTypeNode.class);
    b.addClass(ComponentTypeNode.class);
    b.addClass(DeviceTypeNode.class);
    b.addClass(SoftwareTypeNode.class);
    b.addClass(BlockTypeNode.class);
    b.addClass(DeviceHealthDiagnosticAlarmTypeNode.class);
    b.addClass(FailureAlarmTypeNode.class);
    b.addClass(CheckFunctionAlarmTypeNode.class);
    b.addClass(OffSpecAlarmTypeNode.class);
    b.addClass(MaintenanceRequiredAlarmTypeNode.class);
    b.addClass(ConfigurableObjectTypeNode.class);
    b.addClass(FunctionalGroupTypeNode.class);
    b.addClass(ProtocolTypeNode.class);
    b.addClass(UIElementTypeNode.class);
    b.addClass(NetworkTypeNode.class);
    b.addClass(ConnectionPointTypeNode.class);
    b.addClass(TransferServicesTypeNode.class);
    b.addClass(LockingServicesTypeNode.class);
    b.addSerializers(Serializers.SERIALIZERS);
    b.setDataTypeDictionary(DataTypeDictionaryHelper.createDataTypeDictionary());
    b.addStructureSpecification(FetchResultDataType.SPECIFICATION);
    b.addStructureSpecification(TransferResultErrorDataType.SPECIFICATION);
    b.addStructureSpecification(TransferResultDataDataType.SPECIFICATION);
    b.addStructureSpecification(ParameterResultDataType.SPECIFICATION);
    b.addEnumerationSpecification(DeviceHealthEnumeration.SPECIFICATION);
    MODEL = b.build();
  }

  @Override
  public ServerCodegenModel get() {
    return MODEL;
  }

  /**
   * Returns URI for the NodeSet XML file 'Opc.Ua.Di.NodeSet2.xml', assuming it is put into classpath next to classfile of this class. You can use the 'server_model' codegen target to do it automatically as part of the code generation. If the file is not found this method will throw RuntimeException.
   */
  public static URI getLocationURI() {
    URL nodeset = ServerInformationModel.class.getResource("Opc.Ua.Di.NodeSet2.xml");
    if (nodeset == null) {
      throw new RuntimeException("Cannot find nodeset 'Opc.Ua.Di.NodeSet2.xml' in classpath next to "+ServerInformationModel.class);
    }
    try {
      return nodeset.toURI();
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
