package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class OptionalCodec implements ObjectSerializer, ObjectDeserializer {
    public static OptionalCodec instance = new OptionalCodec();

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == IoOoo.oIX0oI()) {
            Integer castToInt = TypeUtils.castToInt(defaultJSONParser.parseObject(Integer.class));
            if (castToInt == null) {
                return OptionalInt.empty();
            }
            return OptionalInt.of(castToInt.intValue());
        } else if (type == oOo.oIX0oI()) {
            Long castToLong = TypeUtils.castToLong(defaultJSONParser.parseObject(Long.class));
            if (castToLong == null) {
                return OptionalLong.empty();
            }
            return OptionalLong.of(castToLong.longValue());
        } else if (type == xOoOIoI.oIX0oI()) {
            Double castToDouble = TypeUtils.castToDouble(defaultJSONParser.parseObject(Double.class));
            if (castToDouble == null) {
                return OptionalDouble.empty();
            }
            return OptionalDouble.of(castToDouble.doubleValue());
        } else {
            Object parseObject = defaultJSONParser.parseObject(TypeUtils.unwrapOptional(type));
            if (parseObject == null) {
                return Optional.empty();
            }
            return Optional.of(parseObject);
        }
    }

    public int getFastMatchToken() {
        return 12;
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        Object obj3;
        if (obj == null) {
            jSONSerializer.writeNull();
        } else if (x0xO.oIX0oI(obj)) {
            Optional oIX0oI2 = O00XxXI.oIX0oI(obj);
            if (oIX0oI2.isPresent()) {
                obj3 = oIX0oI2.get();
            } else {
                obj3 = null;
            }
            jSONSerializer.write(obj3);
        } else if (I0.oIX0oI(obj)) {
            OptionalDouble oIX0oI3 = ooOx.oIX0oI(obj);
            if (oIX0oI3.isPresent()) {
                jSONSerializer.write((Object) Double.valueOf(oIX0oI3.getAsDouble()));
            } else {
                jSONSerializer.writeNull();
            }
        } else if (xX0IIXIx0.oIX0oI(obj)) {
            OptionalInt oIX0oI4 = xOOOX.oIX0oI(obj);
            if (oIX0oI4.isPresent()) {
                jSONSerializer.out.writeInt(oIX0oI4.getAsInt());
                return;
            }
            jSONSerializer.writeNull();
        } else if (Ioxxx.oIX0oI(obj)) {
            OptionalLong oIX0oI5 = xxIO.oIX0oI(obj);
            if (oIX0oI5.isPresent()) {
                jSONSerializer.out.writeLong(oIX0oI5.getAsLong());
                return;
            }
            jSONSerializer.writeNull();
        } else {
            throw new JSONException("not support optional : " + obj.getClass());
        }
    }
}
