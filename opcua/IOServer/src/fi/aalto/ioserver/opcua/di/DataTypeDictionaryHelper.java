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

import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import com.prosysopc.ua.typedictionary.GeneratedDataTypeDictionary;
import java.lang.String;

/**
 * Generated on 2020-03-07 22:47:52
 */
public class DataTypeDictionaryHelper {
  public static GeneratedDataTypeDictionary createDataTypeDictionary() {
    GeneratedDataTypeDictionary r = new GeneratedDataTypeDictionary("http://opcfoundation.org/UA/DI/");
    r.addTypeInformation(eni("nsu=http://opcfoundation.org/UA/DI/;i=6244"), "DeviceHealthEnumeration", DeviceHealthEnumeration.class);
    r.addTypeInformation(eni("nsu=http://opcfoundation.org/UA/DI/;i=6522"), "FetchResultDataType", FetchResultDataType.class);
    r.addTypeInformation(eni("nsu=http://opcfoundation.org/UA/DI/;i=15888"), "TransferResultErrorDataType", TransferResultErrorDataType.class);
    r.addTypeInformation(eni("nsu=http://opcfoundation.org/UA/DI/;i=15889"), "TransferResultDataDataType", TransferResultDataDataType.class);
    r.addTypeInformation(eni("nsu=http://opcfoundation.org/UA/DI/;i=6525"), "ParameterResultDataType", ParameterResultDataType.class);
    return r;
  }

  private static ExpandedNodeId eni(String id) {
    return ExpandedNodeId.parseExpandedNodeId(id);
  }
}
