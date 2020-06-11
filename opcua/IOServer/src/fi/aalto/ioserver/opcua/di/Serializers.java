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
import com.prosysopc.ua.stack.builtintypes.DiagnosticInfo;
import com.prosysopc.ua.stack.builtintypes.QualifiedName;
import com.prosysopc.ua.stack.builtintypes.StatusCode;
import com.prosysopc.ua.stack.encoding.DecodingException;
import com.prosysopc.ua.stack.encoding.EncodingException;
import com.prosysopc.ua.stack.encoding.IDecoder;
import com.prosysopc.ua.stack.encoding.IEncodeable;
import com.prosysopc.ua.stack.encoding.IEncoder;
import com.prosysopc.ua.stack.encoding.binary.IEncodeableSerializer;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

/**
 * Generated on 2020-03-07 22:47:52
 */
public class Serializers {
  public static final IEncodeableSerializer[] SERIALIZERS;

  static {
    List<IEncodeableSerializer> l = new ArrayList<IEncodeableSerializer>();
    l.add(new TransferResultErrorDataTypeSerializer());
    l.add(new TransferResultDataDataTypeSerializer());
    l.add(new ParameterResultDataTypeSerializer());
    SERIALIZERS = l.toArray(new IEncodeableSerializer[0]);
  }

  public static class TransferResultErrorDataTypeSerializer extends StructureSerializer {
    @SuppressWarnings("deprecation")
	public TransferResultErrorDataTypeSerializer() {
      super(TransferResultErrorDataType.class, TransferResultErrorDataType.BINARY, TransferResultErrorDataType.XML);
    }

    @Override
    public void calcEncodeable(IEncodeable encodeable, IEncoder calculator) throws
        EncodingException {
      super.calcEncodeable(encodeable, calculator);
      TransferResultErrorDataType obj = (TransferResultErrorDataType) encodeable;
      calculator.put(null, (obj == null) ? null : obj.getStatus(), Integer.class);
      calculator.put(null, (obj == null) ? null : obj.getDiagnostics(), DiagnosticInfo.class);
    }

    @Override
    public void getEncodeable(IDecoder decoder, IEncodeable encodeable) throws DecodingException {
      TransferResultErrorDataType result = (TransferResultErrorDataType) encodeable;
      super.getEncodeable(decoder, result);
      result.setStatus(decoder.get("Status", Integer.class));
      result.setDiagnostics(decoder.get("Diagnostics", DiagnosticInfo.class));
    }

    @Override
    public IEncodeable newEncodeable() {
      return new TransferResultErrorDataType();
    }

    @Override
    public void putEncodeable(IEncodeable encodeable, IEncoder encoder) throws EncodingException {
      super.putEncodeable(encodeable, encoder);
      TransferResultErrorDataType obj = (TransferResultErrorDataType) encodeable;
      encoder.put("Status", (obj == null) ? null : obj.getStatus(), Integer.class);
      encoder.put("Diagnostics", (obj == null) ? null : obj.getDiagnostics(), DiagnosticInfo.class);
    }
  }

  public static class TransferResultDataDataTypeSerializer extends StructureSerializer {
    @SuppressWarnings("deprecation")
	public TransferResultDataDataTypeSerializer() {
      super(TransferResultDataDataType.class, TransferResultDataDataType.BINARY, TransferResultDataDataType.XML);
    }

    @Override
    public void calcEncodeable(IEncodeable encodeable, IEncoder calculator) throws
        EncodingException {
      super.calcEncodeable(encodeable, calculator);
      TransferResultDataDataType obj = (TransferResultDataDataType) encodeable;
      calculator.put(null, (obj == null) ? null : obj.getSequenceNumber(), Integer.class);
      calculator.put(null, (obj == null) ? null : obj.getEndOfResults(), Boolean.class);
      calculator.put(null, (obj == null) ? null : obj.getParameterDefs(), ParameterResultDataType[].class);
    }

    @Override
    public void getEncodeable(IDecoder decoder, IEncodeable encodeable) throws DecodingException {
      TransferResultDataDataType result = (TransferResultDataDataType) encodeable;
      super.getEncodeable(decoder, result);
      result.setSequenceNumber(decoder.get("SequenceNumber", Integer.class));
      result.setEndOfResults(decoder.get("EndOfResults", Boolean.class));
      result.setParameterDefs(decoder.get("ParameterDefs", ParameterResultDataType[].class));
    }

    @Override
    public IEncodeable newEncodeable() {
      return new TransferResultDataDataType();
    }

    @Override
    public void putEncodeable(IEncodeable encodeable, IEncoder encoder) throws EncodingException {
      super.putEncodeable(encodeable, encoder);
      TransferResultDataDataType obj = (TransferResultDataDataType) encodeable;
      encoder.put("SequenceNumber", (obj == null) ? null : obj.getSequenceNumber(), Integer.class);
      encoder.put("EndOfResults", (obj == null) ? null : obj.getEndOfResults(), Boolean.class);
      encoder.put("ParameterDefs", (obj == null) ? null : obj.getParameterDefs(), ParameterResultDataType[].class);
    }
  }

  public static class ParameterResultDataTypeSerializer extends StructureSerializer {
    @SuppressWarnings("deprecation")
	public ParameterResultDataTypeSerializer() {
      super(ParameterResultDataType.class, ParameterResultDataType.BINARY, ParameterResultDataType.XML);
    }

    @Override
    public void calcEncodeable(IEncodeable encodeable, IEncoder calculator) throws
        EncodingException {
      super.calcEncodeable(encodeable, calculator);
      ParameterResultDataType obj = (ParameterResultDataType) encodeable;
      calculator.put(null, (obj == null) ? null : obj.getNodePath(), QualifiedName[].class);
      calculator.put(null, (obj == null) ? null : obj.getStatusCode(), StatusCode.class);
      calculator.put(null, (obj == null) ? null : obj.getDiagnostics(), DiagnosticInfo.class);
    }

    @Override
    public void getEncodeable(IDecoder decoder, IEncodeable encodeable) throws DecodingException {
      ParameterResultDataType result = (ParameterResultDataType) encodeable;
      super.getEncodeable(decoder, result);
      result.setNodePath(decoder.get("NodePath", QualifiedName[].class));
      result.setStatusCode(decoder.get("StatusCode", StatusCode.class));
      result.setDiagnostics(decoder.get("Diagnostics", DiagnosticInfo.class));
    }

    @Override
    public IEncodeable newEncodeable() {
      return new ParameterResultDataType();
    }

    @Override
    public void putEncodeable(IEncodeable encodeable, IEncoder encoder) throws EncodingException {
      super.putEncodeable(encodeable, encoder);
      ParameterResultDataType obj = (ParameterResultDataType) encodeable;
      encoder.put("NodePath", (obj == null) ? null : obj.getNodePath(), QualifiedName[].class);
      encoder.put("StatusCode", (obj == null) ? null : obj.getStatusCode(), StatusCode.class);
      encoder.put("Diagnostics", (obj == null) ? null : obj.getDiagnostics(), DiagnosticInfo.class);
    }
  }
}