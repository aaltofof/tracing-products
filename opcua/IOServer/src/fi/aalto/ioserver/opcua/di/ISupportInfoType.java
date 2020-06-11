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

import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Optional;
import com.prosysopc.ua.types.opcua.BaseInterfaceType;
import com.prosysopc.ua.types.opcua.FolderType;
import java.lang.String;

/**
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15054")
public interface ISupportInfoType extends BaseInterfaceType {
  String DEVICE_TYPE_IMAGE = "DeviceTypeImage";

  String DOCUMENTATION = "Documentation";

  String PROTOCOL_SUPPORT = "ProtocolSupport";

  String IMAGE_SET = "ImageSet";

  @Optional
  FolderType getDeviceTypeImageNode();

  @Optional
  FolderType getDocumentationNode();

  @Optional
  FolderType getProtocolSupportNode();

  @Optional
  FolderType getImageSetNode();
}
