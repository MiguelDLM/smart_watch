package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.HttpUrl;

public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        boolean z;
        Type type2;
        boolean z2;
        int i2;
        Object obj3;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj4 = obj;
        int i3 = i;
        SerializeWriter serializeWriter = jSONSerializer2.out;
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        if (serializeWriter.isEnabled(serializerFeature) || SerializerFeature.isEnabled(i3, serializerFeature)) {
            z = true;
        } else {
            z = false;
        }
        SerializeWriter serializeWriter2 = jSONSerializer2.out;
        if (z) {
            type2 = TypeUtils.getCollectionItemType(type);
        } else {
            type2 = null;
        }
        Type type3 = type2;
        if (obj4 == null) {
            serializeWriter2.writeNull(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj4;
        if (list.size() == 0) {
            serializeWriter2.append((CharSequence) HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        SerialContext serialContext = jSONSerializer2.context;
        jSONSerializer2.setContext(serialContext, obj4, obj2, 0);
        try {
            char c = ',';
            if (serializeWriter2.isEnabled(SerializerFeature.PrettyFormat)) {
                serializeWriter2.append('[');
                jSONSerializer.incrementIndent();
                int i4 = 0;
                for (Object next : list) {
                    if (i4 != 0) {
                        serializeWriter2.append(c);
                    }
                    jSONSerializer.println();
                    if (next == null) {
                        jSONSerializer2.out.writeNull();
                    } else if (jSONSerializer2.containsReference(next)) {
                        jSONSerializer2.writeReference(next);
                    } else {
                        ObjectSerializer objectWriter = jSONSerializer2.getObjectWriter(next.getClass());
                        SerialContext serialContext2 = r1;
                        SerialContext serialContext3 = new SerialContext(serialContext, obj, obj2, 0, 0);
                        jSONSerializer2.context = serialContext2;
                        objectWriter.write(jSONSerializer, next, Integer.valueOf(i4), type3, i);
                    }
                    i4++;
                    Object obj5 = obj;
                    c = ',';
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter2.append(']');
                jSONSerializer2.context = serialContext;
                return;
            }
            char c2 = ',';
            serializeWriter2.append('[');
            int size = list.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj6 = list.get(i5);
                if (i5 != 0) {
                    serializeWriter2.append(c2);
                }
                if (obj6 == null) {
                    serializeWriter2.append((CharSequence) "null");
                } else {
                    Class<?> cls = obj6.getClass();
                    if (cls == Integer.class) {
                        serializeWriter2.writeInt(((Integer) obj6).intValue());
                    } else if (cls == Long.class) {
                        long longValue = ((Long) obj6).longValue();
                        if (z) {
                            serializeWriter2.writeLong(longValue);
                            serializeWriter2.write(76);
                        } else {
                            serializeWriter2.writeLong(longValue);
                        }
                    } else if ((SerializerFeature.DisableCircularReferenceDetect.mask & i3) != 0) {
                        i2 = i5;
                        jSONSerializer2.getObjectWriter(obj6.getClass()).write(jSONSerializer, obj6, Integer.valueOf(i5), type3, i);
                        z2 = z;
                        i5 = i2 + 1;
                        z = z2;
                        c2 = ',';
                    } else {
                        i2 = i5;
                        if (!serializeWriter2.disableCircularReferenceDetect) {
                            obj3 = obj6;
                            z2 = z;
                            SerialContext serialContext4 = r1;
                            SerialContext serialContext5 = new SerialContext(serialContext, obj, obj2, 0, 0);
                            jSONSerializer2.context = serialContext4;
                        } else {
                            obj3 = obj6;
                            z2 = z;
                        }
                        if (jSONSerializer2.containsReference(obj3)) {
                            jSONSerializer2.writeReference(obj3);
                        } else {
                            ObjectSerializer objectWriter2 = jSONSerializer2.getObjectWriter(obj3.getClass());
                            if ((SerializerFeature.WriteClassName.mask & i3) == 0 || !(objectWriter2 instanceof JavaBeanSerializer)) {
                                objectWriter2.write(jSONSerializer, obj3, Integer.valueOf(i2), type3, i);
                            } else {
                                ((JavaBeanSerializer) objectWriter2).writeNoneASM(jSONSerializer, obj3, Integer.valueOf(i2), type3, i);
                            }
                        }
                        i5 = i2 + 1;
                        z = z2;
                        c2 = ',';
                    }
                }
                i2 = i5;
                z2 = z;
                i5 = i2 + 1;
                z = z2;
                c2 = ',';
            }
            serializeWriter2.append(']');
            jSONSerializer2.context = serialContext;
        } catch (Throwable th) {
            jSONSerializer2.context = serialContext;
            throw th;
        }
    }
}
