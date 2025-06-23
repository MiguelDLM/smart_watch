package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.spi.Module;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class SerializeConfig {
    private static boolean awtError = false;
    public static final SerializeConfig globalInstance = new SerializeConfig();
    private static boolean guavaError = false;
    private static boolean jdk8Error = false;
    private static boolean jodaError = false;
    private static boolean oracleJdbcError = false;
    private static boolean springfoxError = false;
    private boolean asm;
    private ASMSerializerFactory asmFactory;
    private long[] denyClasses;
    private final boolean fieldBased;
    private final IdentityHashMap<Type, IdentityHashMap<Type, ObjectSerializer>> mixInSerializers;
    private List<Module> modules;
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<Type, ObjectSerializer> serializers;
    protected String typeKey;

    public SerializeConfig() {
        this(8192);
    }

    private final JavaBeanSerializer createASMSerializer(SerializeBeanInfo serializeBeanInfo) throws Exception {
        JavaBeanSerializer createJavaBeanSerializer = this.asmFactory.createJavaBeanSerializer(serializeBeanInfo);
        int i = 0;
        while (true) {
            FieldSerializer[] fieldSerializerArr = createJavaBeanSerializer.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                return createJavaBeanSerializer;
            }
            Class<?> cls = fieldSerializerArr[i].fieldInfo.fieldClass;
            if (cls.isEnum() && !(getObjectWriter(cls) instanceof EnumSerializer)) {
                createJavaBeanSerializer.writeDirect = false;
            }
            i++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.reflect.Method} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.reflect.Method} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.reflect.Field[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.reflect.Method} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.reflect.Method} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.reflect.Method} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.reflect.Method} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.reflect.Method} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Member getEnumValueField(java.lang.Class r10) {
        /*
            java.lang.reflect.Method[] r0 = r10.getMethods()
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r5 = r2
            r4 = 0
        L_0x0009:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r6 = com.alibaba.fastjson.annotation.JSONField.class
            if (r4 >= r1) goto L_0x0027
            r7 = r0[r4]
            java.lang.Class r8 = r7.getReturnType()
            java.lang.Class<java.lang.Void> r9 = java.lang.Void.class
            if (r8 != r9) goto L_0x0018
            goto L_0x0024
        L_0x0018:
            java.lang.annotation.Annotation r6 = r7.getAnnotation(r6)
            com.alibaba.fastjson.annotation.JSONField r6 = (com.alibaba.fastjson.annotation.JSONField) r6
            if (r6 == 0) goto L_0x0024
            if (r5 == 0) goto L_0x0023
            return r2
        L_0x0023:
            r5 = r7
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x0009
        L_0x0027:
            java.lang.reflect.Field[] r10 = r10.getFields()
            int r0 = r10.length
        L_0x002c:
            if (r3 >= r0) goto L_0x003f
            r1 = r10[r3]
            java.lang.annotation.Annotation r4 = r1.getAnnotation(r6)
            com.alibaba.fastjson.annotation.JSONField r4 = (com.alibaba.fastjson.annotation.JSONField) r4
            if (r4 == 0) goto L_0x003c
            if (r5 == 0) goto L_0x003b
            return r2
        L_0x003b:
            r5 = r1
        L_0x003c:
            int r3 = r3 + 1
            goto L_0x002c
        L_0x003f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeConfig.getEnumValueField(java.lang.Class):java.lang.reflect.Member");
    }

    public static SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    private void initSerializers() {
        put((Type) Boolean.class, (ObjectSerializer) BooleanCodec.instance);
        put((Type) Character.class, (ObjectSerializer) CharacterCodec.instance);
        put((Type) Byte.class, (ObjectSerializer) IntegerCodec.instance);
        put((Type) Short.class, (ObjectSerializer) IntegerCodec.instance);
        put((Type) Integer.class, (ObjectSerializer) IntegerCodec.instance);
        put((Type) Long.class, (ObjectSerializer) LongCodec.instance);
        put((Type) Float.class, (ObjectSerializer) FloatCodec.instance);
        put((Type) Double.class, (ObjectSerializer) DoubleSerializer.instance);
        put((Type) BigDecimal.class, (ObjectSerializer) BigDecimalCodec.instance);
        put((Type) BigInteger.class, (ObjectSerializer) BigIntegerCodec.instance);
        put((Type) String.class, (ObjectSerializer) StringCodec.instance);
        put((Type) byte[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) short[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) int[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) long[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) float[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) double[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) boolean[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) char[].class, (ObjectSerializer) PrimitiveArraySerializer.instance);
        put((Type) Object[].class, (ObjectSerializer) ObjectArrayCodec.instance);
        MiscCodec miscCodec = MiscCodec.instance;
        put((Type) Class.class, (ObjectSerializer) miscCodec);
        put((Type) SimpleDateFormat.class, (ObjectSerializer) miscCodec);
        put((Type) Currency.class, (ObjectSerializer) new MiscCodec());
        put((Type) TimeZone.class, (ObjectSerializer) miscCodec);
        put((Type) InetAddress.class, (ObjectSerializer) miscCodec);
        put((Type) Inet4Address.class, (ObjectSerializer) miscCodec);
        put((Type) Inet6Address.class, (ObjectSerializer) miscCodec);
        put((Type) InetSocketAddress.class, (ObjectSerializer) miscCodec);
        put((Type) File.class, (ObjectSerializer) miscCodec);
        AppendableSerializer appendableSerializer = AppendableSerializer.instance;
        put((Type) Appendable.class, (ObjectSerializer) appendableSerializer);
        put((Type) StringBuffer.class, (ObjectSerializer) appendableSerializer);
        put((Type) StringBuilder.class, (ObjectSerializer) appendableSerializer);
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        put((Type) Charset.class, (ObjectSerializer) toStringSerializer);
        put((Type) Pattern.class, (ObjectSerializer) toStringSerializer);
        put((Type) Locale.class, (ObjectSerializer) toStringSerializer);
        put((Type) URI.class, (ObjectSerializer) toStringSerializer);
        put((Type) URL.class, (ObjectSerializer) toStringSerializer);
        put((Type) UUID.class, (ObjectSerializer) toStringSerializer);
        AtomicCodec atomicCodec = AtomicCodec.instance;
        put((Type) AtomicBoolean.class, (ObjectSerializer) atomicCodec);
        put((Type) AtomicInteger.class, (ObjectSerializer) atomicCodec);
        put((Type) AtomicLong.class, (ObjectSerializer) atomicCodec);
        ReferenceCodec referenceCodec = ReferenceCodec.instance;
        put((Type) AtomicReference.class, (ObjectSerializer) referenceCodec);
        put((Type) AtomicIntegerArray.class, (ObjectSerializer) atomicCodec);
        put((Type) AtomicLongArray.class, (ObjectSerializer) atomicCodec);
        put((Type) WeakReference.class, (ObjectSerializer) referenceCodec);
        put((Type) SoftReference.class, (ObjectSerializer) referenceCodec);
        put((Type) LinkedList.class, (ObjectSerializer) CollectionCodec.instance);
    }

    public void addFilter(Class<?> cls, SerializeFilter serializeFilter) {
        ObjectSerializer objectWriter = getObjectWriter(cls);
        if (objectWriter instanceof SerializeFilterable) {
            SerializeFilterable serializeFilterable = (SerializeFilterable) objectWriter;
            if (this == globalInstance || serializeFilterable != MapSerializer.instance) {
                serializeFilterable.addFilter(serializeFilter);
                return;
            }
            MapSerializer mapSerializer = new MapSerializer();
            put((Type) cls, (ObjectSerializer) mapSerializer);
            mapSerializer.addFilter(serializeFilter);
        }
    }

    public void clearSerializers() {
        this.serializers.clear();
        initSerializers();
    }

    public void config(Class<?> cls, SerializerFeature serializerFeature, boolean z) {
        ObjectSerializer objectWriter = getObjectWriter(cls, false);
        if (objectWriter == null) {
            SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, (Map<String, String>) null, this.propertyNamingStrategy);
            if (z) {
                buildBeanInfo.features = serializerFeature.mask | buildBeanInfo.features;
            } else {
                buildBeanInfo.features = (~serializerFeature.mask) & buildBeanInfo.features;
            }
            put((Type) cls, createJavaBeanSerializer(buildBeanInfo));
        } else if (objectWriter instanceof JavaBeanSerializer) {
            SerializeBeanInfo serializeBeanInfo = ((JavaBeanSerializer) objectWriter).beanInfo;
            int i = serializeBeanInfo.features;
            if (z) {
                serializeBeanInfo.features = serializerFeature.mask | i;
            } else {
                serializeBeanInfo.features = (~serializerFeature.mask) & i;
            }
            if (i != serializeBeanInfo.features && objectWriter.getClass() != JavaBeanSerializer.class) {
                put((Type) cls, createJavaBeanSerializer(serializeBeanInfo));
            }
        }
    }

    public void configEnumAsJavaBean(Class<? extends Enum>... clsArr) {
        for (Class<? extends Enum> cls : clsArr) {
            put((Type) cls, createJavaBeanSerializer((Class<?>) cls));
        }
    }

    public final ObjectSerializer createJavaBeanSerializer(Class<?> cls) {
        String name = cls.getName();
        if (Arrays.binarySearch(this.denyClasses, TypeUtils.fnv1a_64(name)) < 0) {
            SerializeBeanInfo buildBeanInfo = TypeUtils.buildBeanInfo(cls, (Map<String, String>) null, this.propertyNamingStrategy, this.fieldBased);
            if (buildBeanInfo.fields.length != 0 || !Iterable.class.isAssignableFrom(cls)) {
                return createJavaBeanSerializer(buildBeanInfo);
            }
            return MiscCodec.instance;
        }
        throw new JSONException("not support class : " + name);
    }

    public final ObjectSerializer get(Type type) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.serializers.get(type);
        }
        IdentityHashMap identityHashMap = this.mixInSerializers.get(type);
        if (identityHashMap == null) {
            return null;
        }
        return (ObjectSerializer) identityHashMap.get(mixInAnnotations);
    }

    public ObjectSerializer getEnumSerializer() {
        return EnumSerializer.instance;
    }

    public ObjectSerializer getObjectWriter(Class<?> cls) {
        return getObjectWriter(cls, true);
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public boolean isAsmEnable() {
        return this.asm;
    }

    public boolean put(Object obj, Object obj2) {
        return put((Type) obj, (ObjectSerializer) obj2);
    }

    public void register(Module module) {
        this.modules.add(module);
    }

    public void setAsmEnable(boolean z) {
        if (!ASMUtils.IS_ANDROID) {
            this.asm = z;
        }
    }

    public void setPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy2) {
        this.propertyNamingStrategy = propertyNamingStrategy2;
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }

    public SerializeConfig(boolean z) {
        this(8192, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.Class} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: com.alibaba.fastjson.serializer.JavaBeanSerializer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: com.alibaba.fastjson.serializer.ArraySerializer} */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v4, types: [java.lang.reflect.Member] */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x04af  */
    /* JADX WARNING: Removed duplicated region for block: B:318:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.fastjson.serializer.ObjectSerializer getObjectWriter(java.lang.Class<?> r26, boolean r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            java.lang.String r2 = "java.util.concurrent.atomic.DoubleAdder"
            java.lang.String r3 = "java.util.concurrent.atomic.LongAdder"
            r4 = 1
            java.lang.Class<com.alibaba.fastjson.serializer.AutowiredObjectSerializer> r5 = com.alibaba.fastjson.serializer.AutowiredObjectSerializer.class
            com.alibaba.fastjson.serializer.ObjectSerializer r6 = r25.get(r26)
            if (r6 == 0) goto L_0x0012
            return r6
        L_0x0012:
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ ClassCastException -> 0x004b }
            java.lang.ClassLoader r6 = r6.getContextClassLoader()     // Catch:{ ClassCastException -> 0x004b }
            java.util.Set r6 = com.alibaba.fastjson.util.ServiceLoader.load(r5, (java.lang.ClassLoader) r6)     // Catch:{ ClassCastException -> 0x004b }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ ClassCastException -> 0x004b }
        L_0x0022:
            boolean r7 = r6.hasNext()     // Catch:{ ClassCastException -> 0x004b }
            if (r7 == 0) goto L_0x004c
            java.lang.Object r7 = r6.next()     // Catch:{ ClassCastException -> 0x004b }
            boolean r8 = r7 instanceof com.alibaba.fastjson.serializer.AutowiredObjectSerializer     // Catch:{ ClassCastException -> 0x004b }
            if (r8 != 0) goto L_0x0031
            goto L_0x0022
        L_0x0031:
            com.alibaba.fastjson.serializer.AutowiredObjectSerializer r7 = (com.alibaba.fastjson.serializer.AutowiredObjectSerializer) r7     // Catch:{ ClassCastException -> 0x004b }
            java.util.Set r8 = r7.getAutowiredFor()     // Catch:{ ClassCastException -> 0x004b }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ ClassCastException -> 0x004b }
        L_0x003b:
            boolean r9 = r8.hasNext()     // Catch:{ ClassCastException -> 0x004b }
            if (r9 == 0) goto L_0x0022
            java.lang.Object r9 = r8.next()     // Catch:{ ClassCastException -> 0x004b }
            java.lang.reflect.Type r9 = (java.lang.reflect.Type) r9     // Catch:{ ClassCastException -> 0x004b }
            r0.put((java.lang.reflect.Type) r9, (com.alibaba.fastjson.serializer.ObjectSerializer) r7)     // Catch:{ ClassCastException -> 0x004b }
            goto L_0x003b
        L_0x004b:
        L_0x004c:
            com.alibaba.fastjson.serializer.ObjectSerializer r6 = r25.get(r26)
            if (r6 != 0) goto L_0x0097
            java.lang.Class<com.alibaba.fastjson.JSON> r7 = com.alibaba.fastjson.JSON.class
            java.lang.ClassLoader r7 = r7.getClassLoader()
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r8 = r8.getContextClassLoader()
            if (r7 == r8) goto L_0x0097
            java.util.Set r5 = com.alibaba.fastjson.util.ServiceLoader.load(r5, (java.lang.ClassLoader) r7)     // Catch:{ ClassCastException -> 0x0093 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ ClassCastException -> 0x0093 }
        L_0x006a:
            boolean r6 = r5.hasNext()     // Catch:{ ClassCastException -> 0x0093 }
            if (r6 == 0) goto L_0x0093
            java.lang.Object r6 = r5.next()     // Catch:{ ClassCastException -> 0x0093 }
            boolean r7 = r6 instanceof com.alibaba.fastjson.serializer.AutowiredObjectSerializer     // Catch:{ ClassCastException -> 0x0093 }
            if (r7 != 0) goto L_0x0079
            goto L_0x006a
        L_0x0079:
            com.alibaba.fastjson.serializer.AutowiredObjectSerializer r6 = (com.alibaba.fastjson.serializer.AutowiredObjectSerializer) r6     // Catch:{ ClassCastException -> 0x0093 }
            java.util.Set r7 = r6.getAutowiredFor()     // Catch:{ ClassCastException -> 0x0093 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ ClassCastException -> 0x0093 }
        L_0x0083:
            boolean r8 = r7.hasNext()     // Catch:{ ClassCastException -> 0x0093 }
            if (r8 == 0) goto L_0x006a
            java.lang.Object r8 = r7.next()     // Catch:{ ClassCastException -> 0x0093 }
            java.lang.reflect.Type r8 = (java.lang.reflect.Type) r8     // Catch:{ ClassCastException -> 0x0093 }
            r0.put((java.lang.reflect.Type) r8, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)     // Catch:{ ClassCastException -> 0x0093 }
            goto L_0x0083
        L_0x0093:
            com.alibaba.fastjson.serializer.ObjectSerializer r6 = r25.get(r26)
        L_0x0097:
            java.util.List<com.alibaba.fastjson.spi.Module> r5 = r0.modules
            java.util.Iterator r5 = r5.iterator()
        L_0x009d:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00b3
            java.lang.Object r6 = r5.next()
            com.alibaba.fastjson.spi.Module r6 = (com.alibaba.fastjson.spi.Module) r6
            com.alibaba.fastjson.serializer.ObjectSerializer r6 = r6.createSerializer(r0, r1)
            if (r6 == 0) goto L_0x009d
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)
            return r6
        L_0x00b3:
            if (r6 != 0) goto L_0x04b3
            java.lang.String r5 = r26.getName()
            java.lang.Class<java.util.Map> r7 = java.util.Map.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x00c9
            com.alibaba.fastjson.serializer.MapSerializer r2 = com.alibaba.fastjson.serializer.MapSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
        L_0x00c6:
            r6 = r2
            goto L_0x04ad
        L_0x00c9:
            java.lang.Class<java.util.List> r7 = java.util.List.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x00d7
            com.alibaba.fastjson.serializer.ListSerializer r2 = com.alibaba.fastjson.serializer.ListSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x00d7:
            java.lang.Class<java.util.Collection> r7 = java.util.Collection.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x00e5
            com.alibaba.fastjson.serializer.CollectionCodec r2 = com.alibaba.fastjson.serializer.CollectionCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x00e5:
            java.lang.Class<java.util.Date> r7 = java.util.Date.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x00f3
            com.alibaba.fastjson.serializer.DateCodec r2 = com.alibaba.fastjson.serializer.DateCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x00f3:
            java.lang.Class<com.alibaba.fastjson.JSONAware> r7 = com.alibaba.fastjson.JSONAware.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x0101
            com.alibaba.fastjson.serializer.JSONAwareSerializer r2 = com.alibaba.fastjson.serializer.JSONAwareSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x0101:
            java.lang.Class<com.alibaba.fastjson.serializer.JSONSerializable> r7 = com.alibaba.fastjson.serializer.JSONSerializable.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x010f
            com.alibaba.fastjson.serializer.JSONSerializableSerializer r2 = com.alibaba.fastjson.serializer.JSONSerializableSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x010f:
            java.lang.Class<com.alibaba.fastjson.JSONStreamAware> r7 = com.alibaba.fastjson.JSONStreamAware.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x011d
            com.alibaba.fastjson.serializer.MiscCodec r2 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x011d:
            boolean r7 = r26.isEnum()
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r8 = com.alibaba.fastjson.annotation.JSONType.class
            r9 = 0
            if (r7 == 0) goto L_0x0182
            java.lang.reflect.Type r2 = com.alibaba.fastjson.JSON.getMixInAnnotations(r26)
            java.lang.Class r2 = (java.lang.Class) r2
            if (r2 == 0) goto L_0x0135
            java.lang.annotation.Annotation r3 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r2, r8)
            com.alibaba.fastjson.annotation.JSONType r3 = (com.alibaba.fastjson.annotation.JSONType) r3
            goto L_0x013b
        L_0x0135:
            java.lang.annotation.Annotation r3 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r1, r8)
            com.alibaba.fastjson.annotation.JSONType r3 = (com.alibaba.fastjson.annotation.JSONType) r3
        L_0x013b:
            if (r3 == 0) goto L_0x014c
            boolean r3 = r3.serializeEnumAsJavaBean()
            if (r3 == 0) goto L_0x014c
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r25.createJavaBeanSerializer((java.lang.Class<?>) r26)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x014c:
            if (r2 == 0) goto L_0x0169
            java.lang.reflect.Member r2 = getEnumValueField(r2)
            if (r2 == 0) goto L_0x016d
            boolean r3 = r2 instanceof java.lang.reflect.Method     // Catch:{ Exception -> 0x0167 }
            if (r3 == 0) goto L_0x016d
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2     // Catch:{ Exception -> 0x0167 }
            java.lang.String r3 = r2.getName()     // Catch:{ Exception -> 0x0167 }
            java.lang.Class[] r2 = r2.getParameterTypes()     // Catch:{ Exception -> 0x0167 }
            java.lang.reflect.Method r9 = r1.getMethod(r3, r2)     // Catch:{ Exception -> 0x0167 }
            goto L_0x016d
        L_0x0167:
            goto L_0x016d
        L_0x0169:
            java.lang.reflect.Member r9 = getEnumValueField(r26)
        L_0x016d:
            if (r9 == 0) goto L_0x0179
            com.alibaba.fastjson.serializer.EnumSerializer r2 = new com.alibaba.fastjson.serializer.EnumSerializer
            r2.<init>(r9)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x0179:
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r25.getEnumSerializer()
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x0182:
            java.lang.Class r7 = r26.getSuperclass()
            if (r7 == 0) goto L_0x01ae
            boolean r10 = r7.isEnum()
            if (r10 == 0) goto L_0x01ae
            java.lang.annotation.Annotation r2 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r7, r8)
            com.alibaba.fastjson.annotation.JSONType r2 = (com.alibaba.fastjson.annotation.JSONType) r2
            if (r2 == 0) goto L_0x01a5
            boolean r2 = r2.serializeEnumAsJavaBean()
            if (r2 == 0) goto L_0x01a5
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r25.createJavaBeanSerializer((java.lang.Class<?>) r26)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x01a5:
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r25.getEnumSerializer()
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x01ae:
            boolean r7 = r26.isArray()
            if (r7 == 0) goto L_0x01c7
            java.lang.Class r2 = r26.getComponentType()
            com.alibaba.fastjson.serializer.ObjectSerializer r3 = r0.getObjectWriter(r2)
            com.alibaba.fastjson.serializer.ArraySerializer r4 = new com.alibaba.fastjson.serializer.ArraySerializer
            r4.<init>(r2, r3)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r4)
            r6 = r4
            goto L_0x04ad
        L_0x01c7:
            java.lang.Class<java.lang.Throwable> r7 = java.lang.Throwable.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x01e9
            com.alibaba.fastjson.PropertyNamingStrategy r2 = r0.propertyNamingStrategy
            com.alibaba.fastjson.serializer.SerializeBeanInfo r2 = com.alibaba.fastjson.util.TypeUtils.buildBeanInfo(r1, r9, r2)
            int r3 = r2.features
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName
            int r4 = r4.mask
            r3 = r3 | r4
            r2.features = r3
            com.alibaba.fastjson.serializer.JavaBeanSerializer r3 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r3.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r2)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r3)
            r6 = r3
            goto L_0x04ad
        L_0x01e9:
            java.lang.Class<java.util.TimeZone> r7 = java.util.TimeZone.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 != 0) goto L_0x04a6
            java.lang.Class<java.util.Map$Entry> r7 = java.util.Map.Entry.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x01fb
            goto L_0x04a6
        L_0x01fb:
            java.lang.Class<java.lang.Appendable> r7 = java.lang.Appendable.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x020a
            com.alibaba.fastjson.serializer.AppendableSerializer r2 = com.alibaba.fastjson.serializer.AppendableSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x020a:
            java.lang.Class<java.nio.charset.Charset> r7 = java.nio.charset.Charset.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x0219
            com.alibaba.fastjson.serializer.ToStringSerializer r2 = com.alibaba.fastjson.serializer.ToStringSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x0219:
            java.lang.Class<java.util.Enumeration> r7 = java.util.Enumeration.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x0228
            com.alibaba.fastjson.serializer.EnumerationSerializer r2 = com.alibaba.fastjson.serializer.EnumerationSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x0228:
            java.lang.Class<java.util.Calendar> r7 = java.util.Calendar.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 != 0) goto L_0x049f
            java.lang.Class<javax.xml.datatype.XMLGregorianCalendar> r7 = javax.xml.datatype.XMLGregorianCalendar.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x023a
            goto L_0x049f
        L_0x023a:
            boolean r7 = com.alibaba.fastjson.util.TypeUtils.isClob(r26)
            if (r7 == 0) goto L_0x0247
            com.alibaba.fastjson.serializer.ClobSerializer r2 = com.alibaba.fastjson.serializer.ClobSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x0247:
            boolean r7 = com.alibaba.fastjson.util.TypeUtils.isPath(r26)
            if (r7 == 0) goto L_0x0254
            com.alibaba.fastjson.serializer.ToStringSerializer r2 = com.alibaba.fastjson.serializer.ToStringSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x0254:
            java.lang.Class<java.util.Iterator> r7 = java.util.Iterator.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x0263
            com.alibaba.fastjson.serializer.MiscCodec r2 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x0263:
            java.lang.Class<org.w3c.dom.Node> r7 = org.w3c.dom.Node.class
            boolean r7 = r7.isAssignableFrom(r1)
            if (r7 == 0) goto L_0x0272
            com.alibaba.fastjson.serializer.MiscCodec r2 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x0272:
            java.lang.String r7 = "java.awt."
            boolean r7 = r5.startsWith(r7)
            r8 = 4
            r10 = 0
            if (r7 == 0) goto L_0x02ab
            boolean r7 = com.alibaba.fastjson.serializer.AwtCodec.support(r26)
            if (r7 == 0) goto L_0x02ab
            boolean r7 = awtError
            if (r7 != 0) goto L_0x02ab
            java.lang.String r7 = "java.awt.Color"
            java.lang.String r11 = "java.awt.Font"
            java.lang.String r12 = "java.awt.Point"
            java.lang.String r13 = "java.awt.Rectangle"
            java.lang.String[] r7 = new java.lang.String[]{r7, r11, r12, r13}     // Catch:{ all -> 0x02a9 }
            r11 = 0
        L_0x0293:
            if (r11 >= r8) goto L_0x02ab
            r12 = r7[r11]     // Catch:{ all -> 0x02a9 }
            boolean r13 = r12.equals(r5)     // Catch:{ all -> 0x02a9 }
            if (r13 == 0) goto L_0x02a7
            java.lang.Class r7 = java.lang.Class.forName(r12)     // Catch:{ all -> 0x02a9 }
            com.alibaba.fastjson.serializer.AwtCodec r6 = com.alibaba.fastjson.serializer.AwtCodec.instance     // Catch:{ all -> 0x02a9 }
            r0.put((java.lang.reflect.Type) r7, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)     // Catch:{ all -> 0x02a9 }
            return r6
        L_0x02a7:
            int r11 = r11 + r4
            goto L_0x0293
        L_0x02a9:
            awtError = r4
        L_0x02ab:
            boolean r7 = jdk8Error
            r11 = 11
            r12 = 2
            if (r7 != 0) goto L_0x033d
            java.lang.String r7 = "java.time."
            boolean r7 = r5.startsWith(r7)
            java.lang.String r13 = "java.util.Optional"
            if (r7 != 0) goto L_0x02ce
            boolean r7 = r5.startsWith(r13)
            if (r7 != 0) goto L_0x02ce
            boolean r7 = r5.equals(r3)
            if (r7 != 0) goto L_0x02ce
            boolean r7 = r5.equals(r2)
            if (r7 == 0) goto L_0x033d
        L_0x02ce:
            java.lang.String r14 = "java.time.LocalDateTime"
            java.lang.String r15 = "java.time.LocalDate"
            java.lang.String r16 = "java.time.LocalTime"
            java.lang.String r17 = "java.time.ZonedDateTime"
            java.lang.String r18 = "java.time.OffsetDateTime"
            java.lang.String r19 = "java.time.OffsetTime"
            java.lang.String r20 = "java.time.ZoneOffset"
            java.lang.String r21 = "java.time.ZoneRegion"
            java.lang.String r22 = "java.time.Period"
            java.lang.String r23 = "java.time.Duration"
            java.lang.String r24 = "java.time.Instant"
            java.lang.String[] r7 = new java.lang.String[]{r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24}     // Catch:{ all -> 0x033b }
            r14 = 0
        L_0x02e9:
            if (r14 >= r11) goto L_0x02ff
            r15 = r7[r14]     // Catch:{ all -> 0x033b }
            boolean r16 = r15.equals(r5)     // Catch:{ all -> 0x033b }
            if (r16 == 0) goto L_0x02fd
            java.lang.Class r2 = java.lang.Class.forName(r15)     // Catch:{ all -> 0x033b }
            com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec r6 = com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.instance     // Catch:{ all -> 0x033b }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)     // Catch:{ all -> 0x033b }
            return r6
        L_0x02fd:
            int r14 = r14 + r4
            goto L_0x02e9
        L_0x02ff:
            java.lang.String r7 = "java.util.OptionalDouble"
            java.lang.String r14 = "java.util.OptionalInt"
            java.lang.String r15 = "java.util.OptionalLong"
            java.lang.String[] r7 = new java.lang.String[]{r13, r7, r14, r15}     // Catch:{ all -> 0x033b }
            r13 = 0
        L_0x030a:
            if (r13 >= r8) goto L_0x0320
            r14 = r7[r13]     // Catch:{ all -> 0x033b }
            boolean r15 = r14.equals(r5)     // Catch:{ all -> 0x033b }
            if (r15 == 0) goto L_0x031e
            java.lang.Class r2 = java.lang.Class.forName(r14)     // Catch:{ all -> 0x033b }
            com.alibaba.fastjson.parser.deserializer.OptionalCodec r6 = com.alibaba.fastjson.parser.deserializer.OptionalCodec.instance     // Catch:{ all -> 0x033b }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)     // Catch:{ all -> 0x033b }
            return r6
        L_0x031e:
            int r13 = r13 + r4
            goto L_0x030a
        L_0x0320:
            java.lang.String[] r2 = new java.lang.String[]{r3, r2}     // Catch:{ all -> 0x033b }
            r3 = 0
        L_0x0325:
            if (r3 >= r12) goto L_0x033d
            r7 = r2[r3]     // Catch:{ all -> 0x033b }
            boolean r8 = r7.equals(r5)     // Catch:{ all -> 0x033b }
            if (r8 == 0) goto L_0x0339
            java.lang.Class r2 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x033b }
            com.alibaba.fastjson.serializer.AdderSerializer r6 = com.alibaba.fastjson.serializer.AdderSerializer.instance     // Catch:{ all -> 0x033b }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)     // Catch:{ all -> 0x033b }
            return r6
        L_0x0339:
            int r3 = r3 + r4
            goto L_0x0325
        L_0x033b:
            jdk8Error = r4
        L_0x033d:
            boolean r2 = oracleJdbcError
            if (r2 != 0) goto L_0x036a
            java.lang.String r2 = "oracle.sql."
            boolean r2 = r5.startsWith(r2)
            if (r2 == 0) goto L_0x036a
            java.lang.String r2 = "oracle.sql.DATE"
            java.lang.String r3 = "oracle.sql.TIMESTAMP"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0368 }
            r3 = 0
        L_0x0352:
            if (r3 >= r12) goto L_0x036a
            r7 = r2[r3]     // Catch:{ all -> 0x0368 }
            boolean r8 = r7.equals(r5)     // Catch:{ all -> 0x0368 }
            if (r8 == 0) goto L_0x0366
            java.lang.Class r2 = java.lang.Class.forName(r7)     // Catch:{ all -> 0x0368 }
            com.alibaba.fastjson.serializer.DateCodec r6 = com.alibaba.fastjson.serializer.DateCodec.instance     // Catch:{ all -> 0x0368 }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)     // Catch:{ all -> 0x0368 }
            return r6
        L_0x0366:
            int r3 = r3 + r4
            goto L_0x0352
        L_0x0368:
            oracleJdbcError = r4
        L_0x036a:
            boolean r2 = springfoxError
            if (r2 != 0) goto L_0x0382
            java.lang.String r2 = "springfox.documentation.spring.web.json.Json"
            boolean r3 = r5.equals(r2)
            if (r3 == 0) goto L_0x0382
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0380 }
            com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer r6 = com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer.instance     // Catch:{ ClassNotFoundException -> 0x0380 }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)     // Catch:{ ClassNotFoundException -> 0x0380 }
            return r6
        L_0x0380:
            springfoxError = r4
        L_0x0382:
            boolean r2 = guavaError
            if (r2 != 0) goto L_0x03b6
            java.lang.String r2 = "com.google.common.collect."
            boolean r2 = r5.startsWith(r2)
            if (r2 == 0) goto L_0x03b6
            java.lang.String r2 = "com.google.common.collect.HashMultimap"
            java.lang.String r3 = "com.google.common.collect.LinkedListMultimap"
            java.lang.String r7 = "com.google.common.collect.LinkedHashMultimap"
            java.lang.String r8 = "com.google.common.collect.ArrayListMultimap"
            java.lang.String r13 = "com.google.common.collect.TreeMultimap"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r7, r8, r13}     // Catch:{ ClassNotFoundException -> 0x03b4 }
            r3 = 0
        L_0x039d:
            r7 = 5
            if (r3 >= r7) goto L_0x03b6
            r7 = r2[r3]     // Catch:{ ClassNotFoundException -> 0x03b4 }
            boolean r8 = r7.equals(r5)     // Catch:{ ClassNotFoundException -> 0x03b4 }
            if (r8 == 0) goto L_0x03b2
            java.lang.Class r2 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x03b4 }
            com.alibaba.fastjson.serializer.GuavaCodec r6 = com.alibaba.fastjson.serializer.GuavaCodec.instance     // Catch:{ ClassNotFoundException -> 0x03b4 }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)     // Catch:{ ClassNotFoundException -> 0x03b4 }
            return r6
        L_0x03b2:
            int r3 = r3 + r4
            goto L_0x039d
        L_0x03b4:
            guavaError = r4
        L_0x03b6:
            java.lang.String r2 = "net.sf.json.JSONNull"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x03c4
            com.alibaba.fastjson.serializer.MiscCodec r2 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x03c4:
            java.lang.String r2 = "org.json.JSONObject"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x03d2
            com.alibaba.fastjson.serializer.JSONObjectCodec r2 = com.alibaba.fastjson.serializer.JSONObjectCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x03d2:
            boolean r2 = jodaError
            if (r2 != 0) goto L_0x0411
            java.lang.String r2 = "org.joda."
            boolean r2 = r5.startsWith(r2)
            if (r2 == 0) goto L_0x0411
            java.lang.String r13 = "org.joda.time.LocalDate"
            java.lang.String r14 = "org.joda.time.LocalDateTime"
            java.lang.String r15 = "org.joda.time.LocalTime"
            java.lang.String r16 = "org.joda.time.Instant"
            java.lang.String r17 = "org.joda.time.DateTime"
            java.lang.String r18 = "org.joda.time.Period"
            java.lang.String r19 = "org.joda.time.Duration"
            java.lang.String r20 = "org.joda.time.DateTimeZone"
            java.lang.String r21 = "org.joda.time.UTCDateTimeZone"
            java.lang.String r22 = "org.joda.time.tz.CachedDateTimeZone"
            java.lang.String r23 = "org.joda.time.tz.FixedDateTimeZone"
            java.lang.String[] r2 = new java.lang.String[]{r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23}     // Catch:{ ClassNotFoundException -> 0x040f }
            r3 = 0
        L_0x03f9:
            if (r3 >= r11) goto L_0x0411
            r7 = r2[r3]     // Catch:{ ClassNotFoundException -> 0x040f }
            boolean r8 = r7.equals(r5)     // Catch:{ ClassNotFoundException -> 0x040f }
            if (r8 == 0) goto L_0x040d
            java.lang.Class r2 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x040f }
            com.alibaba.fastjson.serializer.JodaCodec r6 = com.alibaba.fastjson.serializer.JodaCodec.instance     // Catch:{ ClassNotFoundException -> 0x040f }
            r0.put((java.lang.reflect.Type) r2, (com.alibaba.fastjson.serializer.ObjectSerializer) r6)     // Catch:{ ClassNotFoundException -> 0x040f }
            return r6
        L_0x040d:
            int r3 = r3 + r4
            goto L_0x03f9
        L_0x040f:
            jodaError = r4
        L_0x0411:
            java.lang.String r2 = "java.nio.HeapByteBuffer"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x041f
            com.alibaba.fastjson.serializer.ByteBufferCodec r2 = com.alibaba.fastjson.serializer.ByteBufferCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x041f:
            java.lang.String r2 = "org.javamoney.moneta.Money"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x042d
            com.alibaba.fastjson.support.moneta.MonetaCodec r2 = com.alibaba.fastjson.support.moneta.MonetaCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x042d:
            java.lang.String r2 = "com.google.protobuf.Descriptors$FieldDescriptor"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x043b
            com.alibaba.fastjson.serializer.ToStringSerializer r2 = com.alibaba.fastjson.serializer.ToStringSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x043b:
            java.lang.Class[] r2 = r26.getInterfaces()
            int r3 = r2.length
            if (r3 != r4) goto L_0x0452
            r3 = r2[r10]
            boolean r3 = r3.isAnnotation()
            if (r3 == 0) goto L_0x0452
            com.alibaba.fastjson.serializer.AnnotationSerializer r2 = com.alibaba.fastjson.serializer.AnnotationSerializer.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            com.alibaba.fastjson.serializer.AnnotationSerializer r1 = com.alibaba.fastjson.serializer.AnnotationSerializer.instance
            return r1
        L_0x0452:
            boolean r3 = com.alibaba.fastjson.util.TypeUtils.isProxy(r26)
            if (r3 == 0) goto L_0x0464
            java.lang.Class r2 = r26.getSuperclass()
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r0.getObjectWriter(r2)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x0464:
            boolean r3 = java.lang.reflect.Proxy.isProxyClass(r26)
            if (r3 == 0) goto L_0x0494
            int r3 = r2.length
            if (r3 != r12) goto L_0x0470
            r9 = r2[r4]
            goto L_0x048a
        L_0x0470:
            int r3 = r2.length
            r5 = r9
        L_0x0472:
            if (r10 >= r3) goto L_0x0489
            r7 = r2[r10]
            java.lang.String r8 = r7.getName()
            java.lang.String r11 = "org.springframework.aop."
            boolean r8 = r8.startsWith(r11)
            if (r8 == 0) goto L_0x0483
            goto L_0x0487
        L_0x0483:
            if (r5 == 0) goto L_0x0486
            goto L_0x048a
        L_0x0486:
            r5 = r7
        L_0x0487:
            int r10 = r10 + r4
            goto L_0x0472
        L_0x0489:
            r9 = r5
        L_0x048a:
            if (r9 == 0) goto L_0x0494
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r0.getObjectWriter(r9)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            return r2
        L_0x0494:
            if (r27 == 0) goto L_0x04ad
            com.alibaba.fastjson.serializer.ObjectSerializer r2 = r25.createJavaBeanSerializer((java.lang.Class<?>) r26)
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x049f:
            com.alibaba.fastjson.serializer.CalendarCodec r2 = com.alibaba.fastjson.serializer.CalendarCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x04a6:
            com.alibaba.fastjson.serializer.MiscCodec r2 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.put((java.lang.reflect.Type) r1, (com.alibaba.fastjson.serializer.ObjectSerializer) r2)
            goto L_0x00c6
        L_0x04ad:
            if (r6 != 0) goto L_0x04b3
            com.alibaba.fastjson.serializer.ObjectSerializer r6 = r25.get(r26)
        L_0x04b3:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeConfig.getObjectWriter(java.lang.Class, boolean):com.alibaba.fastjson.serializer.ObjectSerializer");
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.serializers.put(type, objectSerializer);
        }
        IdentityHashMap identityHashMap = this.mixInSerializers.get(type);
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap(4);
            this.mixInSerializers.put(type, identityHashMap);
        }
        return identityHashMap.put(mixInAnnotations, objectSerializer);
    }

    public SerializeConfig(int i) {
        this(i, false);
    }

    public SerializeConfig(int i, boolean z) {
        this.asm = !ASMUtils.IS_ANDROID;
        this.typeKey = JSON.DEFAULT_TYPE_KEY;
        this.denyClasses = new long[]{4165360493669296979L, 4446674157046724083L};
        this.modules = new ArrayList();
        this.fieldBased = z;
        this.serializers = new IdentityHashMap<>(i);
        this.mixInSerializers = new IdentityHashMap<>(16);
        try {
            if (this.asm) {
                this.asmFactory = new ASMSerializerFactory();
            }
        } catch (Throwable unused) {
            this.asm = false;
        }
        initSerializers();
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x015e A[SYNTHETIC, Splitter:B:112:0x015e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.fastjson.serializer.ObjectSerializer createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo r15) {
        /*
            r14 = this;
            com.alibaba.fastjson.annotation.JSONType r0 = r15.jsonType
            boolean r1 = r14.asm
            r2 = 0
            if (r1 == 0) goto L_0x000d
            boolean r1 = r14.fieldBased
            if (r1 != 0) goto L_0x000d
            r1 = 1
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            java.lang.Class<java.lang.Void> r3 = java.lang.Void.class
            if (r0 == 0) goto L_0x0056
            java.lang.Class r4 = r0.serializer()
            if (r4 == r3) goto L_0x0024
            java.lang.Object r4 = r4.newInstance()     // Catch:{ all -> 0x0023 }
            boolean r5 = r4 instanceof com.alibaba.fastjson.serializer.ObjectSerializer     // Catch:{ all -> 0x0023 }
            if (r5 == 0) goto L_0x0024
            com.alibaba.fastjson.serializer.ObjectSerializer r4 = (com.alibaba.fastjson.serializer.ObjectSerializer) r4     // Catch:{ all -> 0x0023 }
            return r4
        L_0x0023:
        L_0x0024:
            boolean r4 = r0.asm()
            if (r4 != 0) goto L_0x002b
            r1 = 0
        L_0x002b:
            if (r1 == 0) goto L_0x004c
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r0.serialzeFeatures()
            int r5 = r4.length
            r6 = 0
        L_0x0033:
            if (r6 >= r5) goto L_0x004c
            r7 = r4[r6]
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringValueAsString
            if (r8 == r7) goto L_0x004b
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString
            if (r8 == r7) goto L_0x004b
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue
            if (r8 == r7) goto L_0x004b
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            if (r8 != r7) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            int r6 = r6 + 1
            goto L_0x0033
        L_0x004b:
            r1 = 0
        L_0x004c:
            if (r1 == 0) goto L_0x0056
            java.lang.Class[] r0 = r0.serialzeFilters()
            int r0 = r0.length
            if (r0 == 0) goto L_0x0056
            r1 = 0
        L_0x0056:
            java.lang.Class<?> r0 = r15.beanType
            int r4 = r0.getModifiers()
            boolean r4 = java.lang.reflect.Modifier.isPublic(r4)
            if (r4 != 0) goto L_0x0068
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r0.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r15)
            return r0
        L_0x0068:
            if (r1 == 0) goto L_0x0074
            com.alibaba.fastjson.serializer.ASMSerializerFactory r4 = r14.asmFactory
            com.alibaba.fastjson.util.ASMClassLoader r4 = r4.classLoader
            boolean r4 = r4.isExternalClass(r0)
            if (r4 != 0) goto L_0x007c
        L_0x0074:
            java.lang.Class<java.io.Serializable> r4 = java.io.Serializable.class
            if (r0 == r4) goto L_0x007c
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            if (r0 != r4) goto L_0x007d
        L_0x007c:
            r1 = 0
        L_0x007d:
            if (r1 == 0) goto L_0x008a
            java.lang.String r4 = r0.getSimpleName()
            boolean r4 = com.alibaba.fastjson.util.ASMUtils.checkName(r4)
            if (r4 != 0) goto L_0x008a
            r1 = 0
        L_0x008a:
            if (r1 == 0) goto L_0x0095
            java.lang.Class<?> r4 = r15.beanType
            boolean r4 = r4.isInterface()
            if (r4 == 0) goto L_0x0095
            r1 = 0
        L_0x0095:
            if (r1 == 0) goto L_0x015b
            com.alibaba.fastjson.util.FieldInfo[] r4 = r15.fields
            int r5 = r4.length
            r6 = 0
        L_0x009b:
            if (r6 >= r5) goto L_0x015b
            r7 = r4[r6]
            java.lang.reflect.Field r8 = r7.field
            if (r8 == 0) goto L_0x00b1
            java.lang.Class r8 = r8.getType()
            java.lang.Class<?> r9 = r7.fieldClass
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00b1
            goto L_0x015c
        L_0x00b1:
            java.lang.reflect.Method r8 = r7.method
            if (r8 == 0) goto L_0x00c3
            java.lang.Class r9 = r8.getReturnType()
            java.lang.Class<?> r10 = r7.fieldClass
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00c3
            goto L_0x015c
        L_0x00c3:
            java.lang.Class<?> r9 = r7.fieldClass
            boolean r9 = r9.isEnum()
            if (r9 == 0) goto L_0x00d7
            java.lang.Class<?> r9 = r7.fieldClass
            com.alibaba.fastjson.serializer.ObjectSerializer r9 = r14.get(r9)
            com.alibaba.fastjson.serializer.EnumSerializer r10 = com.alibaba.fastjson.serializer.EnumSerializer.instance
            if (r9 == r10) goto L_0x00d7
            goto L_0x015c
        L_0x00d7:
            com.alibaba.fastjson.annotation.JSONField r9 = r7.getAnnotation()
            if (r9 != 0) goto L_0x00df
            goto L_0x0157
        L_0x00df:
            java.lang.String r10 = r9.format()
            int r11 = r10.length()
            if (r11 == 0) goto L_0x00f7
            java.lang.Class<?> r7 = r7.fieldClass
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            if (r7 != r11) goto L_0x015c
            java.lang.String r7 = "trim"
            boolean r7 = r7.equals(r10)
            if (r7 == 0) goto L_0x015c
        L_0x00f7:
            java.lang.String r7 = r9.name()
            boolean r7 = com.alibaba.fastjson.util.ASMUtils.checkName(r7)
            if (r7 == 0) goto L_0x015c
            boolean r7 = r9.jsonDirect()
            if (r7 != 0) goto L_0x015c
            java.lang.Class r7 = r9.serializeUsing()
            if (r7 != r3) goto L_0x015c
            boolean r7 = r9.unwrapped()
            if (r7 == 0) goto L_0x0114
            goto L_0x015c
        L_0x0114:
            com.alibaba.fastjson.serializer.SerializerFeature[] r7 = r9.serialzeFeatures()
            int r10 = r7.length
            r11 = 0
        L_0x011a:
            if (r11 >= r10) goto L_0x0137
            r12 = r7[r11]
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringValueAsString
            if (r13 == r12) goto L_0x0136
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString
            if (r13 == r12) goto L_0x0136
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue
            if (r13 == r12) goto L_0x0136
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible
            if (r13 == r12) goto L_0x0136
            com.alibaba.fastjson.serializer.SerializerFeature r13 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName
            if (r13 != r12) goto L_0x0133
            goto L_0x0136
        L_0x0133:
            int r11 = r11 + 1
            goto L_0x011a
        L_0x0136:
            r1 = 0
        L_0x0137:
            boolean r7 = com.alibaba.fastjson.util.TypeUtils.isAnnotationPresentOneToMany(r8)
            if (r7 != 0) goto L_0x015c
            boolean r7 = com.alibaba.fastjson.util.TypeUtils.isAnnotationPresentManyToMany(r8)
            if (r7 == 0) goto L_0x0144
            goto L_0x015c
        L_0x0144:
            java.lang.String r7 = r9.defaultValue()
            if (r7 == 0) goto L_0x0157
            java.lang.String r7 = ""
            java.lang.String r8 = r9.defaultValue()
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0157
            goto L_0x015c
        L_0x0157:
            int r6 = r6 + 1
            goto L_0x009b
        L_0x015b:
            r2 = r1
        L_0x015c:
            if (r2 == 0) goto L_0x018d
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = r14.createASMSerializer(r15)     // Catch:{ ClassCastException | ClassFormatError | ClassNotFoundException -> 0x018d, OutOfMemoryError -> 0x017d, all -> 0x0165 }
            if (r0 == 0) goto L_0x018d
            return r0
        L_0x0165:
            r15 = move-exception
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "create asm serializer error, verson 1.2.83, class "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0, r15)
            throw r1
        L_0x017d:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "Metaspace"
            int r1 = r1.indexOf(r2)
            r2 = -1
            if (r1 != r2) goto L_0x018c
            goto L_0x018d
        L_0x018c:
            throw r0
        L_0x018d:
            com.alibaba.fastjson.serializer.JavaBeanSerializer r0 = new com.alibaba.fastjson.serializer.JavaBeanSerializer
            r0.<init>((com.alibaba.fastjson.serializer.SerializeBeanInfo) r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeConfig.createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo):com.alibaba.fastjson.serializer.ObjectSerializer");
    }
}
