package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class AdderSerializer implements ObjectSerializer {
    public static final AdderSerializer instance = new AdderSerializer();

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (oIX0oI.oIX0oI(obj)) {
            serializeWriter.writeFieldValue('{', "value", II0xO0.oIX0oI(obj).longValue());
            serializeWriter.write(125);
        } else if (oxoX.oIX0oI(obj)) {
            serializeWriter.writeFieldValue('{', "value", X0o0xo.oIX0oI(obj).doubleValue());
            serializeWriter.write(125);
        }
    }
}
