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

/* loaded from: classes.dex */
public class OptionalCodec implements ObjectSerializer, ObjectDeserializer {
    public static OptionalCodec instance = new OptionalCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object of;
        Object empty;
        Object of2;
        Object empty2;
        Object of3;
        Object empty3;
        Object of4;
        Object empty4;
        if (type == IoOoo.oIX0oI()) {
            Integer castToInt = TypeUtils.castToInt(defaultJSONParser.parseObject((Class) Integer.class));
            if (castToInt == null) {
                empty4 = OptionalInt.empty();
                return (T) empty4;
            }
            of4 = OptionalInt.of(castToInt.intValue());
            return (T) of4;
        }
        if (type == oOo.oIX0oI()) {
            Long castToLong = TypeUtils.castToLong(defaultJSONParser.parseObject((Class) Long.class));
            if (castToLong == null) {
                empty3 = OptionalLong.empty();
                return (T) empty3;
            }
            of3 = OptionalLong.of(castToLong.longValue());
            return (T) of3;
        }
        if (type == xOoOIoI.oIX0oI()) {
            Double castToDouble = TypeUtils.castToDouble(defaultJSONParser.parseObject((Class) Double.class));
            if (castToDouble == null) {
                empty2 = OptionalDouble.empty();
                return (T) empty2;
            }
            of2 = OptionalDouble.of(castToDouble.doubleValue());
            return (T) of2;
        }
        Object parseObject = defaultJSONParser.parseObject(TypeUtils.unwrapOptional(type));
        if (parseObject == null) {
            empty = Optional.empty();
            return (T) empty;
        }
        of = Optional.of(parseObject);
        return (T) of;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        boolean isPresent;
        long asLong;
        boolean isPresent2;
        int asInt;
        boolean isPresent3;
        double asDouble;
        boolean isPresent4;
        Object obj3;
        if (obj == null) {
            jSONSerializer.writeNull();
            return;
        }
        if (x0xO.oIX0oI(obj)) {
            Optional oIX0oI2 = O00XxXI.oIX0oI(obj);
            isPresent4 = oIX0oI2.isPresent();
            if (isPresent4) {
                obj3 = oIX0oI2.get();
            } else {
                obj3 = null;
            }
            jSONSerializer.write(obj3);
            return;
        }
        if (I0.oIX0oI(obj)) {
            OptionalDouble oIX0oI3 = ooOx.oIX0oI(obj);
            isPresent3 = oIX0oI3.isPresent();
            if (isPresent3) {
                asDouble = oIX0oI3.getAsDouble();
                jSONSerializer.write(Double.valueOf(asDouble));
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        if (xX0IIXIx0.oIX0oI(obj)) {
            OptionalInt oIX0oI4 = xOOOX.oIX0oI(obj);
            isPresent2 = oIX0oI4.isPresent();
            if (isPresent2) {
                asInt = oIX0oI4.getAsInt();
                jSONSerializer.out.writeInt(asInt);
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        if (Ioxxx.oIX0oI(obj)) {
            OptionalLong oIX0oI5 = xxIO.oIX0oI(obj);
            isPresent = oIX0oI5.isPresent();
            if (isPresent) {
                asLong = oIX0oI5.getAsLong();
                jSONSerializer.out.writeLong(asLong);
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        throw new JSONException("not support optional : " + obj.getClass());
    }
}
