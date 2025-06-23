package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FieldSerializer implements Comparable<FieldSerializer> {
    protected boolean browserCompatible;
    protected boolean disableCircularReferenceDetect = false;
    private final String double_quoted_fieldPrefix;
    protected int features;
    protected BeanContext fieldContext;
    public final FieldInfo fieldInfo;
    private String format;
    protected boolean persistenceXToMany = false;
    private RuntimeSerializerInfo runtimeInfo;
    protected boolean serializeUsing = false;
    private String single_quoted_fieldPrefix;
    private String un_quoted_fieldPrefix;
    protected boolean writeEnumUsingName = false;
    protected boolean writeEnumUsingToString = false;
    protected final boolean writeNull;

    public static class RuntimeSerializerInfo {
        final ObjectSerializer fieldSerializer;
        final Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer objectSerializer, Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }

    public FieldSerializer(Class<?> cls, FieldInfo fieldInfo2) {
        boolean z;
        JSONType jSONType;
        boolean z2 = false;
        this.fieldInfo = fieldInfo2;
        this.fieldContext = new BeanContext(cls, fieldInfo2);
        if (!(cls == null || (jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class)) == null)) {
            for (SerializerFeature serializerFeature : jSONType.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                } else if (serializerFeature == SerializerFeature.DisableCircularReferenceDetect) {
                    this.disableCircularReferenceDetect = true;
                } else {
                    SerializerFeature serializerFeature2 = SerializerFeature.BrowserCompatible;
                    if (serializerFeature == serializerFeature2) {
                        this.features |= serializerFeature2.mask;
                        this.browserCompatible = true;
                    } else {
                        SerializerFeature serializerFeature3 = SerializerFeature.WriteMapNullValue;
                        if (serializerFeature == serializerFeature3) {
                            this.features |= serializerFeature3.mask;
                        }
                    }
                }
            }
        }
        fieldInfo2.setAccessible();
        this.double_quoted_fieldPrefix = '\"' + fieldInfo2.name + "\":";
        JSONField annotation = fieldInfo2.getAnnotation();
        if (annotation != null) {
            SerializerFeature[] serialzeFeatures = annotation.serialzeFeatures();
            int length = serialzeFeatures.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if ((serialzeFeatures[i].getMask() & SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            String format2 = annotation.format();
            this.format = format2;
            if (format2.trim().length() == 0) {
                this.format = null;
            }
            for (SerializerFeature serializerFeature4 : annotation.serialzeFeatures()) {
                if (serializerFeature4 == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature4 == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                } else if (serializerFeature4 == SerializerFeature.DisableCircularReferenceDetect) {
                    this.disableCircularReferenceDetect = true;
                } else if (serializerFeature4 == SerializerFeature.BrowserCompatible) {
                    this.browserCompatible = true;
                }
            }
            this.features = SerializerFeature.of(annotation.serialzeFeatures()) | this.features;
        } else {
            z = false;
        }
        this.writeNull = z;
        this.persistenceXToMany = (TypeUtils.isAnnotationPresentOneToMany(fieldInfo2.method) || TypeUtils.isAnnotationPresentManyToMany(fieldInfo2.method)) ? true : z2;
    }

    public Object getPropertyValue(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object obj2 = this.fieldInfo.get(obj);
        if (this.format == null || obj2 == null) {
            return obj2;
        }
        Class<?> cls = this.fieldInfo.fieldClass;
        if (cls != Date.class && cls != java.sql.Date.class) {
            return obj2;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.format, JSON.defaultLocale);
        simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
        return simpleDateFormat.format(obj2);
    }

    public Object getPropertyValueDirect(Object obj) throws InvocationTargetException, IllegalAccessException {
        Object obj2 = this.fieldInfo.get(obj);
        if (!this.persistenceXToMany || TypeUtils.isHibernateInitialized(obj2)) {
            return obj2;
        }
        return null;
    }

    public void writePrefix(JSONSerializer jSONSerializer) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (!serializeWriter.quoteFieldNames) {
            if (this.un_quoted_fieldPrefix == null) {
                this.un_quoted_fieldPrefix = this.fieldInfo.name + ":";
            }
            serializeWriter.write(this.un_quoted_fieldPrefix);
        } else if (SerializerFeature.isEnabled(serializeWriter.features, this.fieldInfo.serialzeFeatures, SerializerFeature.UseSingleQuotes)) {
            if (this.single_quoted_fieldPrefix == null) {
                this.single_quoted_fieldPrefix = '\'' + this.fieldInfo.name + "':";
            }
            serializeWriter.write(this.single_quoted_fieldPrefix);
        } else {
            serializeWriter.write(this.double_quoted_fieldPrefix);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeValue(com.alibaba.fastjson.serializer.JSONSerializer r13, java.lang.Object r14) throws java.lang.Exception {
        /*
            r12 = this;
            com.alibaba.fastjson.serializer.FieldSerializer$RuntimeSerializerInfo r0 = r12.runtimeInfo
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            java.lang.Class<java.lang.Long> r2 = java.lang.Long.class
            if (r0 != 0) goto L_0x0090
            java.lang.Class<java.lang.Double> r0 = java.lang.Double.class
            java.lang.Class<java.lang.Float> r3 = java.lang.Float.class
            if (r14 != 0) goto L_0x003f
            com.alibaba.fastjson.util.FieldInfo r4 = r12.fieldInfo
            java.lang.Class<?> r4 = r4.fieldClass
            java.lang.Class r5 = java.lang.Byte.TYPE
            if (r4 != r5) goto L_0x0019
            java.lang.Class<java.lang.Byte> r4 = java.lang.Byte.class
            goto L_0x0043
        L_0x0019:
            java.lang.Class r5 = java.lang.Short.TYPE
            if (r4 != r5) goto L_0x0020
            java.lang.Class<java.lang.Short> r4 = java.lang.Short.class
            goto L_0x0043
        L_0x0020:
            java.lang.Class r5 = java.lang.Integer.TYPE
            if (r4 != r5) goto L_0x0027
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            goto L_0x0043
        L_0x0027:
            java.lang.Class r5 = java.lang.Long.TYPE
            if (r4 != r5) goto L_0x002d
            r4 = r2
            goto L_0x0043
        L_0x002d:
            java.lang.Class r5 = java.lang.Float.TYPE
            if (r4 != r5) goto L_0x0033
            r4 = r3
            goto L_0x0043
        L_0x0033:
            java.lang.Class r5 = java.lang.Double.TYPE
            if (r4 != r5) goto L_0x0039
            r4 = r0
            goto L_0x0043
        L_0x0039:
            java.lang.Class r5 = java.lang.Boolean.TYPE
            if (r4 != r5) goto L_0x0043
            r4 = r1
            goto L_0x0043
        L_0x003f:
            java.lang.Class r4 = r14.getClass()
        L_0x0043:
            com.alibaba.fastjson.util.FieldInfo r5 = r12.fieldInfo
            com.alibaba.fastjson.annotation.JSONField r5 = r5.getAnnotation()
            if (r5 == 0) goto L_0x0061
            java.lang.Class r6 = r5.serializeUsing()
            java.lang.Class<java.lang.Void> r7 = java.lang.Void.class
            if (r6 == r7) goto L_0x0061
            java.lang.Class r0 = r5.serializeUsing()
            java.lang.Object r0 = r0.newInstance()
            com.alibaba.fastjson.serializer.ObjectSerializer r0 = (com.alibaba.fastjson.serializer.ObjectSerializer) r0
            r3 = 1
            r12.serializeUsing = r3
            goto L_0x0089
        L_0x0061:
            java.lang.String r5 = r12.format
            if (r5 == 0) goto L_0x0082
            java.lang.Class r5 = java.lang.Double.TYPE
            if (r4 == r5) goto L_0x007a
            if (r4 != r0) goto L_0x006c
            goto L_0x007a
        L_0x006c:
            java.lang.Class r0 = java.lang.Float.TYPE
            if (r4 == r0) goto L_0x0072
            if (r4 != r3) goto L_0x0082
        L_0x0072:
            com.alibaba.fastjson.serializer.FloatCodec r0 = new com.alibaba.fastjson.serializer.FloatCodec
            java.lang.String r3 = r12.format
            r0.<init>((java.lang.String) r3)
            goto L_0x0083
        L_0x007a:
            com.alibaba.fastjson.serializer.DoubleSerializer r0 = new com.alibaba.fastjson.serializer.DoubleSerializer
            java.lang.String r3 = r12.format
            r0.<init>((java.lang.String) r3)
            goto L_0x0083
        L_0x0082:
            r0 = 0
        L_0x0083:
            if (r0 != 0) goto L_0x0089
            com.alibaba.fastjson.serializer.ObjectSerializer r0 = r13.getObjectWriter(r4)
        L_0x0089:
            com.alibaba.fastjson.serializer.FieldSerializer$RuntimeSerializerInfo r3 = new com.alibaba.fastjson.serializer.FieldSerializer$RuntimeSerializerInfo
            r3.<init>(r0, r4)
            r12.runtimeInfo = r3
        L_0x0090:
            com.alibaba.fastjson.serializer.FieldSerializer$RuntimeSerializerInfo r0 = r12.runtimeInfo
            boolean r3 = r12.disableCircularReferenceDetect
            if (r3 == 0) goto L_0x00a0
            com.alibaba.fastjson.util.FieldInfo r3 = r12.fieldInfo
            int r3 = r3.serialzeFeatures
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            int r4 = r4.mask
            r3 = r3 | r4
            goto L_0x00a4
        L_0x00a0:
            com.alibaba.fastjson.util.FieldInfo r3 = r12.fieldInfo
            int r3 = r3.serialzeFeatures
        L_0x00a4:
            int r4 = r12.features
            r10 = r3 | r4
            if (r14 != 0) goto L_0x0125
            com.alibaba.fastjson.serializer.SerializeWriter r14 = r13.out
            com.alibaba.fastjson.util.FieldInfo r2 = r12.fieldInfo
            java.lang.Class<?> r2 = r2.fieldClass
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            if (r2 != r3) goto L_0x00c0
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES
            boolean r2 = r14.isEnabled((int) r2)
            if (r2 == 0) goto L_0x00c0
            r14.writeNull()
            return
        L_0x00c0:
            java.lang.Class<?> r2 = r0.runtimeFieldClass
            java.lang.Class<java.lang.Number> r3 = java.lang.Number.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 == 0) goto L_0x00d4
            int r13 = r12.features
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero
            int r0 = r0.mask
            r14.writeNull(r13, r0)
            return
        L_0x00d4:
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r3 != r2) goto L_0x00e2
            int r13 = r12.features
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty
            int r0 = r0.mask
            r14.writeNull(r13, r0)
            return
        L_0x00e2:
            if (r1 != r2) goto L_0x00ee
            int r13 = r12.features
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse
            int r0 = r0.mask
            r14.writeNull(r13, r0)
            return
        L_0x00ee:
            java.lang.Class<java.util.Collection> r1 = java.util.Collection.class
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 != 0) goto L_0x011b
            boolean r1 = r2.isArray()
            if (r1 == 0) goto L_0x00fd
            goto L_0x011b
        L_0x00fd:
            com.alibaba.fastjson.serializer.ObjectSerializer r5 = r0.fieldSerializer
            int r0 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES
            boolean r0 = r14.isEnabled((int) r0)
            if (r0 == 0) goto L_0x010f
            boolean r0 = r5 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer
            if (r0 == 0) goto L_0x010f
            r14.writeNull()
            return
        L_0x010f:
            com.alibaba.fastjson.util.FieldInfo r14 = r12.fieldInfo
            java.lang.String r8 = r14.name
            java.lang.reflect.Type r9 = r14.fieldType
            r7 = 0
            r6 = r13
            r5.write(r6, r7, r8, r9, r10)
            return
        L_0x011b:
            int r13 = r12.features
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty
            int r0 = r0.mask
            r14.writeNull(r13, r0)
            return
        L_0x0125:
            com.alibaba.fastjson.util.FieldInfo r1 = r12.fieldInfo
            boolean r1 = r1.isEnum
            if (r1 == 0) goto L_0x014b
            boolean r1 = r12.writeEnumUsingName
            if (r1 == 0) goto L_0x013b
            com.alibaba.fastjson.serializer.SerializeWriter r13 = r13.out
            java.lang.Enum r14 = (java.lang.Enum) r14
            java.lang.String r14 = r14.name()
            r13.writeString((java.lang.String) r14)
            return
        L_0x013b:
            boolean r1 = r12.writeEnumUsingToString
            if (r1 == 0) goto L_0x014b
            com.alibaba.fastjson.serializer.SerializeWriter r13 = r13.out
            java.lang.Enum r14 = (java.lang.Enum) r14
            java.lang.String r14 = r14.toString()
            r13.writeString((java.lang.String) r14)
            return
        L_0x014b:
            java.lang.Class r1 = r14.getClass()
            java.lang.Class<?> r3 = r0.runtimeFieldClass
            if (r1 == r3) goto L_0x015e
            boolean r3 = r12.serializeUsing
            if (r3 == 0) goto L_0x0158
            goto L_0x015e
        L_0x0158:
            com.alibaba.fastjson.serializer.ObjectSerializer r0 = r13.getObjectWriter(r1)
        L_0x015c:
            r5 = r0
            goto L_0x0161
        L_0x015e:
            com.alibaba.fastjson.serializer.ObjectSerializer r0 = r0.fieldSerializer
            goto L_0x015c
        L_0x0161:
            java.lang.String r0 = r12.format
            if (r0 == 0) goto L_0x017d
            boolean r3 = r5 instanceof com.alibaba.fastjson.serializer.DoubleSerializer
            if (r3 != 0) goto L_0x017d
            boolean r3 = r5 instanceof com.alibaba.fastjson.serializer.FloatCodec
            if (r3 != 0) goto L_0x017d
            boolean r1 = r5 instanceof com.alibaba.fastjson.serializer.ContextObjectSerializer
            if (r1 == 0) goto L_0x0179
            com.alibaba.fastjson.serializer.ContextObjectSerializer r5 = (com.alibaba.fastjson.serializer.ContextObjectSerializer) r5
            com.alibaba.fastjson.serializer.BeanContext r0 = r12.fieldContext
            r5.write(r13, r14, r0)
            goto L_0x017c
        L_0x0179:
            r13.writeWithFormat(r14, r0)
        L_0x017c:
            return
        L_0x017d:
            com.alibaba.fastjson.util.FieldInfo r0 = r12.fieldInfo
            boolean r3 = r0.unwrapped
            if (r3 == 0) goto L_0x01a5
            boolean r3 = r5 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer
            if (r3 == 0) goto L_0x0194
            com.alibaba.fastjson.serializer.JavaBeanSerializer r5 = (com.alibaba.fastjson.serializer.JavaBeanSerializer) r5
            java.lang.String r8 = r0.name
            java.lang.reflect.Type r9 = r0.fieldType
            r11 = 1
            r6 = r13
            r7 = r14
            r5.write(r6, r7, r8, r9, r10, r11)
            return
        L_0x0194:
            boolean r3 = r5 instanceof com.alibaba.fastjson.serializer.MapSerializer
            if (r3 == 0) goto L_0x01a5
            com.alibaba.fastjson.serializer.MapSerializer r5 = (com.alibaba.fastjson.serializer.MapSerializer) r5
            java.lang.String r8 = r0.name
            java.lang.reflect.Type r9 = r0.fieldType
            r11 = 1
            r6 = r13
            r7 = r14
            r5.write(r6, r7, r8, r9, r10, r11)
            return
        L_0x01a5:
            int r3 = r12.features
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName
            int r4 = r4.mask
            r3 = r3 & r4
            if (r3 == 0) goto L_0x01c3
            java.lang.Class<?> r3 = r0.fieldClass
            if (r1 == r3) goto L_0x01c3
            boolean r1 = r5 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer
            if (r1 == 0) goto L_0x01c3
            com.alibaba.fastjson.serializer.JavaBeanSerializer r5 = (com.alibaba.fastjson.serializer.JavaBeanSerializer) r5
            java.lang.String r8 = r0.name
            java.lang.reflect.Type r9 = r0.fieldType
            r11 = 0
            r6 = r13
            r7 = r14
            r5.write(r6, r7, r8, r9, r10, r11)
            return
        L_0x01c3:
            boolean r1 = r12.browserCompatible
            if (r1 == 0) goto L_0x01f4
            java.lang.Class<?> r0 = r0.fieldClass
            java.lang.Class r1 = java.lang.Long.TYPE
            if (r0 == r1) goto L_0x01cf
            if (r0 != r2) goto L_0x01f4
        L_0x01cf:
            r0 = r14
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r2 = 9007199254740991(0x1fffffffffffff, double:4.4501477170144023E-308)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x01e8
            r2 = -9007199254740991(0xffe0000000000001, double:-8.988465674311582E307)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x01f4
        L_0x01e8:
            com.alibaba.fastjson.serializer.SerializeWriter r13 = r13.getWriter()
            java.lang.String r14 = java.lang.Long.toString(r0)
            r13.writeString((java.lang.String) r14)
            return
        L_0x01f4:
            com.alibaba.fastjson.util.FieldInfo r0 = r12.fieldInfo
            java.lang.String r8 = r0.name
            java.lang.reflect.Type r9 = r0.fieldType
            r6 = r13
            r7 = r14
            r5.write(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.FieldSerializer.writeValue(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object):void");
    }

    public int compareTo(FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }
}
