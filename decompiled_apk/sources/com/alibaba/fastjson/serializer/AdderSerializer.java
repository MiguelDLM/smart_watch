package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class AdderSerializer implements ObjectSerializer {
    public static final AdderSerializer instance = new AdderSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        double doubleValue;
        long longValue;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (oIX0oI.oIX0oI(obj)) {
            longValue = II0xO0.oIX0oI(obj).longValue();
            serializeWriter.writeFieldValue('{', "value", longValue);
            serializeWriter.write(125);
        } else if (oxoX.oIX0oI(obj)) {
            doubleValue = X0o0xo.oIX0oI(obj).doubleValue();
            serializeWriter.writeFieldValue('{', "value", doubleValue);
            serializeWriter.write(125);
        }
    }
}
