package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Type;
import java.util.Map;

public class DefaultFieldDeserializer extends FieldDeserializer {
    protected boolean customDeserilizer = false;
    protected ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        boolean z = false;
        JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            Class<?> deserializeUsing = annotation.deserializeUsing();
            if (!(deserializeUsing == null || deserializeUsing == Void.class)) {
                z = true;
            }
            this.customDeserilizer = z;
        }
    }

    public int getFastMatchToken() {
        ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        if (objectDeserializer != null) {
            return objectDeserializer.getFastMatchToken();
        }
        return 2;
    }

    public ObjectDeserializer getFieldValueDeserilizer(ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation == null || annotation.deserializeUsing() == Void.class) {
                FieldInfo fieldInfo = this.fieldInfo;
                this.fieldValueDeserilizer = parserConfig.getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
            } else {
                try {
                    this.fieldValueDeserilizer = (ObjectDeserializer) annotation.deserializeUsing().newInstance();
                } catch (Exception e) {
                    throw new JSONException("create deserializeUsing ObjectDeserializer error", e);
                }
            }
        }
        return this.fieldValueDeserilizer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        r10 = r7.fieldInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseField(com.alibaba.fastjson.parser.DefaultJSONParser r8, java.lang.Object r9, java.lang.reflect.Type r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r7 = this;
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r7.fieldValueDeserilizer
            if (r0 != 0) goto L_0x000b
            com.alibaba.fastjson.parser.ParserConfig r0 = r8.getConfig()
            r7.getFieldValueDeserilizer(r0)
        L_0x000b:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r7.fieldValueDeserilizer
            com.alibaba.fastjson.util.FieldInfo r1 = r7.fieldInfo
            java.lang.reflect.Type r1 = r1.fieldType
            boolean r2 = r10 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x0031
            com.alibaba.fastjson.parser.ParseContext r2 = r8.getContext()
            if (r2 == 0) goto L_0x001d
            r2.type = r10
        L_0x001d:
            if (r1 == r10) goto L_0x0031
            java.lang.Class<?> r2 = r7.clazz
            java.lang.reflect.Type r1 = com.alibaba.fastjson.util.FieldInfo.getFieldType(r2, r10, r1)
            boolean r10 = r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer
            if (r10 == 0) goto L_0x0031
            com.alibaba.fastjson.parser.ParserConfig r10 = r8.getConfig()
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r10.getDeserializer((java.lang.reflect.Type) r1)
        L_0x0031:
            r3 = r1
            boolean r10 = r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer
            if (r10 == 0) goto L_0x0045
            com.alibaba.fastjson.util.FieldInfo r10 = r7.fieldInfo
            int r1 = r10.parserFeatures
            if (r1 == 0) goto L_0x0045
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r0 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0
            java.lang.String r10 = r10.name
            java.lang.Object r10 = r0.deserialze(r8, r3, r10, r1)
            goto L_0x0066
        L_0x0045:
            com.alibaba.fastjson.util.FieldInfo r10 = r7.fieldInfo
            java.lang.String r5 = r10.format
            if (r5 != 0) goto L_0x004f
            int r1 = r10.parserFeatures
            if (r1 == 0) goto L_0x0060
        L_0x004f:
            boolean r1 = r0 instanceof com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
            if (r1 == 0) goto L_0x0060
            r1 = r0
            com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer r1 = (com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer) r1
            java.lang.String r4 = r10.name
            int r6 = r10.parserFeatures
            r2 = r8
            java.lang.Object r10 = r1.deserialze(r2, r3, r4, r5, r6)
            goto L_0x0066
        L_0x0060:
            java.lang.String r10 = r10.name
            java.lang.Object r10 = r0.deserialze(r8, r3, r10)
        L_0x0066:
            boolean r0 = r10 instanceof byte[]
            r1 = 0
            if (r0 == 0) goto L_0x00b4
            com.alibaba.fastjson.util.FieldInfo r0 = r7.fieldInfo
            java.lang.String r0 = r0.format
            java.lang.String r2 = "gzip"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0083
            com.alibaba.fastjson.util.FieldInfo r0 = r7.fieldInfo
            java.lang.String r0 = r0.format
            java.lang.String r2 = "gzip,base64"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00b4
        L_0x0083:
            byte[] r10 = (byte[]) r10
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x00a4 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x00a4 }
            r2.<init>(r10)     // Catch:{ IOException -> 0x00a4 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x00a4 }
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00a4 }
            r10.<init>()     // Catch:{ IOException -> 0x00a4 }
        L_0x0094:
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x00a4 }
            int r3 = r0.read(r2)     // Catch:{ IOException -> 0x00a4 }
            r4 = -1
            if (r3 != r4) goto L_0x00a6
            byte[] r10 = r10.toByteArray()     // Catch:{ IOException -> 0x00a4 }
            goto L_0x00b4
        L_0x00a4:
            r8 = move-exception
            goto L_0x00ac
        L_0x00a6:
            if (r3 <= 0) goto L_0x0094
            r10.write(r2, r1, r3)     // Catch:{ IOException -> 0x00a4 }
            goto L_0x0094
        L_0x00ac:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException
            java.lang.String r10 = "unzip bytes error."
            r9.<init>(r10, r8)
            throw r9
        L_0x00b4:
            int r0 = r8.getResolveStatus()
            r2 = 1
            if (r0 != r2) goto L_0x00cb
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r9 = r8.getLastResolveTask()
            r9.fieldDeserializer = r7
            com.alibaba.fastjson.parser.ParseContext r10 = r8.getContext()
            r9.ownerContext = r10
            r8.setResolveStatus(r1)
            goto L_0x00d8
        L_0x00cb:
            if (r9 != 0) goto L_0x00d5
            com.alibaba.fastjson.util.FieldInfo r8 = r7.fieldInfo
            java.lang.String r8 = r8.name
            r11.put(r8, r10)
            goto L_0x00d8
        L_0x00d5:
            r7.setValue((java.lang.Object) r9, (java.lang.Object) r10)
        L_0x00d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer.parseField(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.Object, java.lang.reflect.Type, java.util.Map):void");
    }

    public void parseFieldUnwrapped(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        throw new JSONException("TODO");
    }
}
