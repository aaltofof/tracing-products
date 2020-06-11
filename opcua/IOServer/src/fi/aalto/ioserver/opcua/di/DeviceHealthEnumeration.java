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
import com.prosysopc.ua.UaNodeId;
import com.prosysopc.ua.stack.builtintypes.Enumeration;
import com.prosysopc.ua.stack.builtintypes.ExpandedNodeId;
import com.prosysopc.ua.stack.builtintypes.UnsignedInteger;
import com.prosysopc.ua.typedictionary.EnumerationSpecification;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Override;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated on 2020-03-07 22:47:52
 */
@TypeDefinitionId("nsu=http://opcfoundation.org/UA/DI/;i=6244")
public enum DeviceHealthEnumeration implements Enumeration {
  NORMAL(0),

  FAILURE(1),

  CHECK_FUNCTION(2),

  OFF_SPEC(3),

  MAINTENANCE_REQUIRED(4);

  public static final EnumerationSpecification SPECIFICATION;

  public static final EnumSet<DeviceHealthEnumeration> NONE = EnumSet.noneOf(DeviceHealthEnumeration.class);

  public static final EnumSet<DeviceHealthEnumeration> ALL = EnumSet.allOf(DeviceHealthEnumeration.class);

  private static final Map<Integer, DeviceHealthEnumeration> map;

  static {
    EnumerationSpecification.Builder b = EnumerationSpecification.builder();
    b.setName("DeviceHealthEnumeration");
    b.setTypeId(UaNodeId.fromLocal(ExpandedNodeId.parseExpandedNodeId("nsu=http://opcfoundation.org/UA/DI/;i=6244")));
    b.addMapping(0, "NORMAL");
    b.addMapping(1, "FAILURE");
    b.addMapping(2, "CHECK_FUNCTION");
    b.addMapping(3, "OFF_SPEC");
    b.addMapping(4, "MAINTENANCE_REQUIRED");
    b.setBuilderSupplier(new EnumerationSpecification.EnumerationBuilderSupplier() {
      @Override
      public Enumeration.Builder get() {
        return DeviceHealthEnumeration.builder();
      }
    });
    SPECIFICATION = b.build();
  }
  static {
    map = new HashMap<Integer,DeviceHealthEnumeration>();
    for (DeviceHealthEnumeration i : DeviceHealthEnumeration.values()) {
      map.put(i.value, i);
    }
  }

  private final int value;

  DeviceHealthEnumeration(int value) {
    this.value = value;
  }

  @Override
  public EnumerationSpecification specification() {
    return SPECIFICATION;
  }

  public static DeviceHealthEnumeration valueOf(int value) {
    return map.get(value);
  }

  public static DeviceHealthEnumeration valueOf(Integer value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static DeviceHealthEnumeration valueOf(UnsignedInteger value) {
    return value == null ? null : valueOf(value.intValue());
  }

  public static DeviceHealthEnumeration[] valueOf(int[] value) {
    DeviceHealthEnumeration[] result = new DeviceHealthEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static DeviceHealthEnumeration[] valueOf(Integer[] value) {
    DeviceHealthEnumeration[] result = new DeviceHealthEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static DeviceHealthEnumeration[] valueOf(UnsignedInteger[] value) {
    DeviceHealthEnumeration[] result = new DeviceHealthEnumeration[value.length];
    for (int i = 0; i < value.length; i++) {
      result[i] = valueOf(value[i]);
    }
    return result;
  }

  public static UnsignedInteger getMask(DeviceHealthEnumeration... list) {
    int result = 0;
    for (DeviceHealthEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static UnsignedInteger getMask(Collection<DeviceHealthEnumeration> list) {
    int result = 0;
    for (DeviceHealthEnumeration c : list) {
      result |= c.value;
    }
    return UnsignedInteger.getFromBits(result);
  }

  public static EnumSet<DeviceHealthEnumeration> getSet(UnsignedInteger mask) {
    return getSet(mask.intValue());
  }

  public static EnumSet<DeviceHealthEnumeration> getSet(int mask) {
    List<DeviceHealthEnumeration> res = new ArrayList<DeviceHealthEnumeration>();
    for (DeviceHealthEnumeration l : DeviceHealthEnumeration.values()) {
      if ((mask & l.value) == l.value) {
        res.add(l);
      }
    }
    return EnumSet.copyOf(res);
  }

  @Override
  public int getValue() {
    return value;
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Builder toBuilder() {
    Builder b = builder();
    b.setValue(this.getValue());
    return b;
  }

  public static class Builder implements Enumeration.Builder {
    private DeviceHealthEnumeration value;

    private Builder() {
    }

    @Override
    public DeviceHealthEnumeration build() {
      return value;
    }

    @Override
    public Builder setValue(int value) {
      this.value=DeviceHealthEnumeration.valueOf(value);
      if (this.value == null) {
        throw new IllegalArgumentException("Unknown enum DeviceHealthEnumeration int value: " + value);
      }
      return this;
    }
  }
}
