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
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import com.prosysopc.ua.stack.builtintypes.Structure;
import com.prosysopc.ua.stack.encoding.EncoderContext;
import com.prosysopc.ua.typedictionary.FieldSpecification;
import com.prosysopc.ua.typedictionary.StructureSpecification;
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
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=15888")
public class TransferResultErrorDataType extends FetchResultDataType {
  @Deprecated
  public static final ExpandedNodeId BINARY = Ids.TransferResultErrorDataType_DefaultBinary;

  @Deprecated
  public static final ExpandedNodeId XML = Ids.TransferResultErrorDataType_DefaultXml;

  @Deprecated
  public static final ExpandedNodeId JSON = Ids.TransferResultErrorDataType_DefaultJson;

  @Deprecated
  public static final ExpandedNodeId ID = Ids.TransferResultErrorDataType;

  public static final StructureSpecification SPECIFICATION;

  static {
    StructureSpecification.Builder b = StructureSpecification.builder();
    b.addField(Fields.Status.getSpecification());
    b.addField(Fields.Diagnostics.getSpecification());
    b.setBinaryEncodeId(UaNodeId.fromLocal(BINARY));
    b.setXmlEncodeId(UaNodeId.fromLocal(XML));
    b.setJsonEncodeId(UaNodeId.fromLocal(JSON));
    b.setTypeId(UaNodeId.fromLocal(ID));
    b.setName("TransferResultErrorDataType");
    b.setStructureType(StructureSpecification.StructureType.NORMAL);
    b.setSerializerSupplier(new StructureSpecification.StructureSerializerSupplier() {
      @Override
      public StructureSerializer get(StructureSpecification specification, EncoderContext ctx) {
        return new Serializers.TransferResultErrorDataTypeSerializer();
      }
    });
    b.setBuilderSupplier(new StructureSpecification.StructureBuilderSupplier() {
      @Override
      public Structure.Builder get() {
        return TransferResultErrorDataType.builder();
      }
    });
    SPECIFICATION = b.build();
  }

  private Integer status;

  private DiagnosticInfo diagnostics;

  public TransferResultErrorDataType() {
  }

  public TransferResultErrorDataType(Integer status, DiagnosticInfo diagnostics) {
    this.status = status;
    this.diagnostics = diagnostics;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status=status;
  }

  public DiagnosticInfo getDiagnostics() {
    return this.diagnostics;
  }

  public void setDiagnostics(DiagnosticInfo diagnostics) {
    this.diagnostics=diagnostics;
  }

  @Override
  public TransferResultErrorDataType clone() {
    TransferResultErrorDataType result = (TransferResultErrorDataType) super.clone();
    result.status = StructureUtils.clone(this.status);
    result.diagnostics = StructureUtils.clone(this.diagnostics);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    TransferResultErrorDataType other = (TransferResultErrorDataType) obj;
    if (!StructureUtils.scalarOrArrayEquals(getStatus(), other.getStatus())) {
      return false;
    }
    if (!StructureUtils.scalarOrArrayEquals(getDiagnostics(), other.getDiagnostics())) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return StructureUtils.hashCode(this.getStatus(), this.getDiagnostics());
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
    if (Fields.Status.getSpecification().equals(field)) {
      return getStatus();
    }
    if (Fields.Diagnostics.getSpecification().equals(field)) {
      return getDiagnostics();
    }
    throw new IllegalArgumentException("Unknown field: " + field);
  }

  @Override
  public void set(FieldSpecification field, Object value) {
    if (Fields.Status.getSpecification().equals(field)) {
      setStatus((Integer) value);
      return;
    }
    if (Fields.Diagnostics.getSpecification().equals(field)) {
      setDiagnostics((DiagnosticInfo) value);
      return;
    }
    throw new IllegalArgumentException("Unknown field: " + field);
  }

  @Override
  public Builder toBuilder() {
    Builder b = TransferResultErrorDataType.builder();
    b.setStatus(getStatus());
    b.setDiagnostics(getDiagnostics());
    return b;
  }

  public enum Fields {
    Status("Status", Integer.class, false, UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=6")), -1),

    Diagnostics("Diagnostics", DiagnosticInfo.class, false, UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/;i=25")), -1);

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
    private Integer status;

    private DiagnosticInfo diagnostics;

    protected Builder() {
    }

    public Builder setStatus(Integer status) {
      this.status=status;
      return this;
    }

    public Builder setDiagnostics(DiagnosticInfo diagnostics) {
      this.diagnostics=diagnostics;
      return this;
    }

    @Override
    public Builder set(FieldSpecification field, Object value) {
      if (Fields.Status.getSpecification().equals(field)) {
        setStatus((Integer) value);
        return this;
      }
      if (Fields.Diagnostics.getSpecification().equals(field)) {
        setDiagnostics((DiagnosticInfo) value);
        return this;
      }
      throw new IllegalArgumentException("Unknown field: " + field);
    }

    @Override
    public TransferResultErrorDataType build() {
      return new TransferResultErrorDataType(status, diagnostics);
    }
  }
}
