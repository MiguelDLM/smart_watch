package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicCodec implements ObjectSerializer, ObjectDeserializer {
    public static final AtomicCodec instance = new AtomicCodec();

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        defaultJSONParser.parseArray((Collection) jSONArray);
        int i = 0;
        if (type == AtomicIntegerArray.class) {
            T atomicIntegerArray = new AtomicIntegerArray(jSONArray.size());
            while (i < jSONArray.size()) {
                atomicIntegerArray.set(i, jSONArray.getInteger(i).intValue());
                i++;
            }
            return atomicIntegerArray;
        }
        T atomicLongArray = new AtomicLongArray(jSONArray.size());
        while (i < jSONArray.size()) {
            atomicLongArray.set(i, jSONArray.getLong(i).longValue());
            i++;
        }
        return atomicLongArray;
    }

    public int getFastMatchToken() {
        return 14;
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        String str;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj instanceof AtomicInteger) {
            serializeWriter.writeInt(((AtomicInteger) obj).get());
        } else if (obj instanceof AtomicLong) {
            serializeWriter.writeLong(((AtomicLong) obj).get());
        } else if (obj instanceof AtomicBoolean) {
            if (((AtomicBoolean) obj).get()) {
                str = "true";
            } else {
                str = "false";
            }
            serializeWriter.append((CharSequence) str);
        } else if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
        } else {
            int i2 = 0;
            if (obj instanceof AtomicIntegerArray) {
                AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                int length = atomicIntegerArray.length();
                serializeWriter.write(91);
                while (i2 < length) {
                    int i3 = atomicIntegerArray.get(i2);
                    if (i2 != 0) {
                        serializeWriter.write(44);
                    }
                    serializeWriter.writeInt(i3);
                    i2++;
                }
                serializeWriter.write(93);
                return;
            }
            AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
            int length2 = atomicLongArray.length();
            serializeWriter.write(91);
            while (i2 < length2) {
                long j = atomicLongArray.get(i2);
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(j);
                i2++;
            }
            serializeWriter.write(93);
        }
    }
}
