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

import com.prosysopc.ua.StructureSerializer;
import com.prosysopc.ua.StructureUtils;
import com.prosysopc.ua.TypeDefinitionId;
import com.prosysopc.ua.UaNodeId;
import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import com.prosysopc.ua.stack.builtintypes.Structure;
import com.prosysopc.ua.stack.encoding.EncoderContext;
import com.prosysopc.ua.typedictionary.FieldSpecification;
import com.prosysopc.ua.typedictionary.StructureSpecification;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15889")
public class TransferResultDataDataType extends FetchResultDataType {
  @Deprecated
  public static final ExpandedNodeId BINARY = Ids.TransferResultDataDataType_DefaultBinary;

  @Deprecated
  public static final ExpandedNodeId XML = Ids.TransferResultDataDataType_DefaultXml;

  @Deprecated
  public static final ExpandedNodeId JSON = Ids.TransferResultDataDataType_DefaultJson;

  @Deprecated
  public static final ExpandedNodeId ID = Ids.TransferResultDataDataType;

  public static final StructureSpecification SPECIFICATION;

  static {
    StructureSpecification.Builder b = StructureSpecification.builder();
    b.addField(Fields.SequenceNumber.getSpecification());
    b.addField(Fields.EndOfResults.getSpecification());
    b.addField(Fields.ParameterDefs.getSpecification());
    b.setBinaryEncodeId(UaNodeId.fromLocal(BINARY));
    b.setXmlEncodeId(UaNodeId.fromLocal(XML));
    b.setJsonEncodeId(UaNodeId.fromLocal(JSON));
    b.setTypeId(UaNodeId.fromLocal(ID));
    b.setName("TransferResultDataDataType");
    b.setStructureType(StructureSpecification.StructureType.NORMAL);
    b.setSerializerSupplier(new StructureSpecification.StructureSerializerSupplier() {
      @Override
      public StructureSerializer get(StructureSpecification specification, EncoderContext ctx) {
        return new Serializers.TransferResultDataDataTypeSerializer();
      }
    });
    b.setBuilderSupplier(new StructureSpecification.StructureBuilderSupplier() {
      @Override
      public Structure.Builder get() {
        return TransferResultDataDataType.builder();
      }
    });
    SPECIFICATION = b.build();
  }

  private Integer sequenceNumber;

  private Boolean endOfResults;

  private ParameterResultDataType[] parameterDefs;

  public TransferResultDataDataType() {
  }

  public TransferResultDataDataType(Integer sequenceNumber, Boolean endOfResults,
      ParameterResultDataType[] parameterDefs) {
    this.sequenceNumber = sequenceNumber;
    this.endOfResults = endOfResults;
    this.parameterDefs = parameterDefs;
  }

  public Integer getSequenceNumber() {
    return this.sequenceNumber;
  }

  public void setSequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber=sequenceNumber;
  }

  public Boolean getEndOfResults() {
    return this.endOfResults;
  }

  public void setEndOfResults(Boolean endOfResults) {
    this.endOfResults=endOfResults;
  }

  public ParameterResultDataType[] getParameterDefs() {
    return this.parameterDefs;
  }

  public void setParameterDefs(ParameterResultDataType[] parameterDefs) {
    this.parameterDefs=parameterDefs;
  }

  @Override
  public TransferResultDataDataType clone() {
    TransferResultDataDataType result = (TransferResultDataDataType) super.clone();
    result.sequenceNumber = StructureUtils.clone(this.sequenceNumber);
    result.endOfResults = StructureUtils.clone(this.endOfResults);
    result.parameterDefs = StructureUtils.clone(this.parameterDefs);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    TransferResultDataDataType other = (TransferResultDataDataType) obj;
    if (!StructureUtils.scalarOrArrayEquals(getSequenceNumber(), other.getSequenceNumber())) {
      return false;
    }
    if (!StructureUtils.scalarOrArrayEquals(getEndOfResults(), other.getEndOfResults())) {
      return false;
    }
    if (!StructureUtils.scalarOrArrayEquals(getParameterDefs(), other.getParameterDefs())) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return StructureUtils.hashCode(this.getSequenceNumber(), this.getEndOfResults(), this.getParameterDefs());
  }

  @Override
  @Deprecated
  public ExpandedNodeId getBinaryEncodeId() {
    return BINARY;
  }

  @Override
  @Deprecated
  public ExpandedNodeId getXmlEncodeId() {
    return XML;
  }

  @Override
  @Deprecated
  public ExpandedNodeId getJsonEncodeId() {
    return JSON;
  }

  @Override
  @Deprecated
  public ExpandedNodeId getTypeId() {
    return ID;
  }

  @Override
  public StructureSpecification specification() {
    return SPECIFICATION;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Object get(FieldSpecification field) {
    if (Fields.SequenceNumber.getSpecification().equals(field)) {
      return getSequenceNumber();
    }
    if (Fields.EndOfResults.getSpecification().equals(field)) {
      return getEndOfResults();
    }
    if (Fields.ParameterDefs.getSpecification().equals(field)) {
      return getParameterDefs();
    }
    throw new IllegalArgumentException("Unknown field: " + field);
  }

  @Override
  public void set(FieldSpecification field, Object value) {
    if (Fields.SequenceNumber.getSpecification().equals(field)) {
      setSequenceNumber((Integer) value);
      return;
    }
    if (Fields.EndOfResults.getSpecification().equals(field)) {
      setEndOfResults((Boolean) value);
      return;
    }
    if (Fields.ParameterDefs.getSpecification().equals(field)) {
      setParameterDefs((ParameterResultDataType[]) value);
      return;
    }
    throw new IllegalArgumentException("Unknown field: " + field);
  }

  @Override
  public Builder toBuilder() {
    Builder b = TransferResultDataDataType.builder();
    b.setSequenceNumber(getSequenceNumber());
    b.setEndOfResults(getEndOfResults());
    b.setParameterDefs(getParameterDefs());
    return b;
  }

  public enum Fields {
    SequenceNumber("SequenceNumber", Integer.class, false, UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=6")), -1),

    EndOfResults("EndOfResults", Boolean.class, false, UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=1")), -1),

    ParameterDefs("ParameterDefs", ParameterResultDataType[].class, false, UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/DI/;i=6525")), 1);

    private final FieldSpecification value;

    Fields(String name, Class<?> javaClass, boolean isOptional, UaNodeId dataTypeId,
        int valueRank) {
      FieldSpecification.Builder b = FieldSpecification.builder();
      b.setName(name);
      b.setJavaClass(javaClass);
      b.setIsOptional(isOptional);
      b.setDataTypeId(dataTypeId);
      b.setValueRank(valueRank);
      this.value = b.build();
    }

    public FieldSpecification getSpecification() {
      return value;
    }
  }

  public static class Builder extends FetchResultDataType.Builder {
    private Integer sequenceNumber;

    private Boolean endOfResults;

    private ParameterResultDataType[] parameterDefs;

    protected Builder() {
    }

    public Builder setSequenceNumber(Integer sequenceNumber) {
      this.sequenceNumber=sequenceNumber;
      return this;
    }

    public Builder setEndOfResults(Boolean endOfResults) {
      this.endOfResults=endOfResults;
      return this;
    }

    public Builder setParameterDefs(ParameterResultDataType[] parameterDefs) {
      this.parameterDefs=parameterDefs;
      return this;
    }

    @Override
    public Builder set(FieldSpecification field, Object value) {
      if (Fields.SequenceNumber.getSpecification().equals(field)) {
        setSequenceNumber((Integer) value);
        return this;
      }
      if (Fields.EndOfResults.getSpecification().equals(field)) {
        setEndOfResults((Boolean) value);
        return this;
      }
      if (Fields.ParameterDefs.getSpecification().equals(field)) {
        setParameterDefs((ParameterResultDataType[]) value);
        return this;
      }
      throw new IllegalArgumentException("Unknown field: " + field);
    }

    @Override
    public TransferResultDataDataType build() {
      return new TransferResultDataDataType(sequenceNumber, endOfResults, parameterDefs);
    }
  }
}
