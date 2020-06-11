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

import com.prosysopc.ua.MethodOutputArguments;
import com.prosysopc.ua.ServiceException;
import com.prosysopc.ua.StatusException;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.nodes.Mandatory;
import com.prosysopc.ua.nodes.UaMethod;
import com.prosysopc.ua.stack.builtintypes.Structure;
import com.prosysopc.ua.stack.builtintypes.Variant;
import com.prosysopc.ua.types.opcua.BaseObjectType;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;

/**
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6526")
public interface TransferServicesType extends BaseObjectType {
  String TRANSFER_TO_DEVICE = "TransferToDevice";

  String TRANSFER_FROM_DEVICE = "TransferFromDevice";

  String FETCH_TRANSFER_RESULT_DATA = "FetchTransferResultData";

  @Mandatory
  UaMethod getTransferToDeviceNode();

  TransferToDeviceMethodOutputs transferToDevice() throws StatusException, ServiceException;

  @Mandatory
  UaMethod getTransferFromDeviceNode();

  TransferFromDeviceMethodOutputs transferFromDevice() throws StatusException, ServiceException;

  @Mandatory
  UaMethod getFetchTransferResultDataNode();

  Structure fetchTransferResultData(Integer transferID, Integer sequenceNumber,
      Integer maxParameterResultsToReturn, Boolean omitGoodResults) throws StatusException,
      ServiceException;

  class TransferToDeviceMethodOutputs implements MethodOutputArguments {
    protected Integer transferID;

    protected Integer initTransferStatus;

    public TransferToDeviceMethodOutputs(Integer transferID, Integer initTransferStatus) {
      this.transferID = transferID;
      this.initTransferStatus = initTransferStatus;
    }

    public Integer getTransferID() {
      return this.transferID;
    }

    public Integer getInitTransferStatus() {
      return this.initTransferStatus;
    }

    public final Variant[] asVariantArray() {
      return new Variant[]{new Variant(transferID), new Variant(initTransferStatus)};
    }
  }

  class TransferFromDeviceMethodOutputs implements MethodOutputArguments {
    protected Integer transferID;

    protected Integer initTransferStatus;

    public TransferFromDeviceMethodOutputs(Integer transferID, Integer initTransferStatus) {
      this.transferID = transferID;
      this.initTransferStatus = initTransferStatus;
    }

    public Integer getTransferID() {
      return this.transferID;
    }

    public Integer getInitTransferStatus() {
      return this.initTransferStatus;
    }

    public final Variant[] asVariantArray() {
      return new Variant[]{new Variant(transferID), new Variant(initTransferStatus)};
    }
  }
}
