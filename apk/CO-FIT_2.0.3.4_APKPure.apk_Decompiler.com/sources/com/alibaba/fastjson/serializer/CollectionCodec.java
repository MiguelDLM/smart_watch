package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CollectionCodec instance = new CollectionCodec();

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        } else if (type == JSONArray.class) {
            T jSONArray = new JSONArray();
            defaultJSONParser.parseArray((Collection) jSONArray);
            return jSONArray;
        } else {
            if (defaultJSONParser.lexer.token() == 21) {
                defaultJSONParser.lexer.nextToken();
                t = TypeUtils.createSet(type);
            } else {
                t = TypeUtils.createCollection(type);
            }
            defaultJSONParser.parseArray(TypeUtils.getCollectionItemType(type), t, obj);
            return t;
        }
    }

    public int getFastMatchToken() {
        return 14;
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        Type type2;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        if (serializeWriter.isEnabled(serializerFeature) || SerializerFeature.isEnabled(i, serializerFeature)) {
            type2 = TypeUtils.getCollectionItemType(type);
        } else {
            type2 = null;
        }
        Collection collection = (Collection) obj;
        SerialContext serialContext = jSONSerializer.context;
        int i2 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        if (serializeWriter.isEnabled(serializerFeature)) {
            if (HashSet.class.isAssignableFrom(collection.getClass())) {
                serializeWriter.append((CharSequence) "Set");
            } else if (TreeSet.class == collection.getClass()) {
                serializeWriter.append((CharSequence) "TreeSet");
            }
        }
        try {
            serializeWriter.append('[');
            for (Object next : collection) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    serializeWriter.append(',');
                }
                if (next == null) {
                    serializeWriter.writeNull();
                } else {
                    Class<?> cls = next.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.writeInt(((Integer) next).intValue());
                    } else if (cls == Long.class) {
                        serializeWriter.writeLong(((Long) next).longValue());
                        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
                            serializeWriter.write(76);
                        }
                    } else {
                        ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(cls);
                        if (!SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName) || !(objectWriter instanceof JavaBeanSerializer)) {
                            objectWriter.write(jSONSerializer, next, Integer.valueOf(i2), type2, i);
                        } else {
                            ((JavaBeanSerializer) objectWriter).writeNoneASM(jSONSerializer, next, Integer.valueOf(i2), type2, i);
                        }
                    }
                }
                i2 = i3;
            }
            serializeWriter.append(']');
            jSONSerializer.context = serialContext;
        } catch (Throwable th) {
            jSONSerializer.context = serialContext;
            throw th;
        }
    }
}
