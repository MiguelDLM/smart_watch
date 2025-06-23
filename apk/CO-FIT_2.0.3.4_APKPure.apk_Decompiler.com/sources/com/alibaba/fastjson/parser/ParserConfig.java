package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONPDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.spi.Module;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.Function;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.ModuleUtil;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

public class ParserConfig {
    public static final String AUTOTYPE_ACCEPT = "fastjson.parser.autoTypeAccept";
    public static final String AUTOTYPE_SUPPORT_PROPERTY = "fastjson.parser.autoTypeSupport";
    public static final boolean AUTO_SUPPORT = "true".equals(IOUtils.getStringProperty(AUTOTYPE_SUPPORT_PROPERTY));
    private static final String[] AUTO_TYPE_ACCEPT_LIST;
    public static final String[] DENYS = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY));
    public static final String[] DENYS_INTERNAL = splitItemsFormProperty(IOUtils.getStringProperty(DENY_PROPERTY_INTERNAL));
    public static final String DENY_PROPERTY = "fastjson.parser.deny";
    public static final String DENY_PROPERTY_INTERNAL = "fastjson.parser.deny.internal";
    private static final long[] INTERNAL_WHITELIST_HASHCODES = {-6976602508726000783L, -6293031534589903644L, 59775428743665658L, 7267793227937552092L};
    public static final boolean SAFE_MODE = "true".equals(IOUtils.getStringProperty(SAFE_MODE_PROPERTY));
    public static final String SAFE_MODE_PROPERTY = "fastjson.parser.safeMode";
    private static boolean awtError = false;
    public static ParserConfig global = new ParserConfig();
    private static boolean guavaError = false;
    private static Function<Class<?>, Boolean> isPrimitiveFuncation = new Function<Class<?>, Boolean>() {
        public Boolean apply(Class<?> cls) {
            return Boolean.valueOf(cls == Date.class || cls == Time.class || cls == Timestamp.class);
        }
    };
    private static boolean jdk8Error = false;
    private static boolean jodaError = false;
    private long[] acceptHashCodes;
    private boolean asmEnable;
    protected ASMDeserializerFactory asmFactory;
    private volatile List<AutoTypeCheckHandler> autoTypeCheckHandlers;
    private boolean autoTypeSupport;
    public boolean compatibleWithJavaBean;
    protected ClassLoader defaultClassLoader;
    private long[] denyHashCodes;
    /* access modifiers changed from: private */
    public final IdentityHashMap<Type, ObjectDeserializer> deserializers;
    public final boolean fieldBased;
    private final Callable<Void> initDeserializersWithJavaSql;
    private long[] internalDenyHashCodes;
    private boolean jacksonCompatible;
    private final IdentityHashMap<Type, IdentityHashMap<Type, ObjectDeserializer>> mixInDeserializers;
    private List<Module> modules;
    public PropertyNamingStrategy propertyNamingStrategy;
    private boolean safeMode;
    public final SymbolTable symbolTable;
    private final ConcurrentMap<String, Class<?>> typeMapping;

    public interface AutoTypeCheckHandler {
        Class<?> handler(String str, Class<?> cls, int i);
    }

    static {
        String[] splitItemsFormProperty = splitItemsFormProperty(IOUtils.getStringProperty(AUTOTYPE_ACCEPT));
        if (splitItemsFormProperty == null) {
            splitItemsFormProperty = new String[0];
        }
        AUTO_TYPE_ACCEPT_LIST = splitItemsFormProperty;
    }

    public ParserConfig() {
        this(false);
    }

    private void addItemsToAccept(String[] strArr) {
        if (strArr != null) {
            for (String addAccept : strArr) {
                addAccept(addAccept);
            }
        }
    }

    private void addItemsToDeny(String[] strArr) {
        if (strArr != null) {
            for (String addDeny : strArr) {
                addDeny(addDeny);
            }
        }
    }

    private void addItemsToDeny0(String[] strArr) {
        if (strArr != null) {
            for (String addDenyInternal : strArr) {
                addDenyInternal(addDenyInternal);
            }
        }
    }

    private static Method getEnumCreator(Class cls, Class cls2) {
        for (Method method : cls.getMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && method.getReturnType() == cls2 && method.getParameterTypes().length == 1 && ((JSONCreator) method.getAnnotation(JSONCreator.class)) != null) {
                return method;
            }
        }
        return null;
    }

    public static Field getFieldFromCache(String str, Map<String, Field> map) {
        Field field = map.get(str);
        if (field == null) {
            field = map.get("_" + str);
        }
        if (field == null) {
            field = map.get("m_" + str);
        }
        if (field != null) {
            return field;
        }
        char charAt = str.charAt(0);
        if (charAt >= 'a' && charAt <= 'z') {
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            field = map.get(new String(charArray));
        }
        if (str.length() <= 2) {
            return field;
        }
        char charAt2 = str.charAt(1);
        if (charAt < 'a' || charAt > 'z' || charAt2 < 'A' || charAt2 > 'Z') {
            return field;
        }
        for (Map.Entry next : map.entrySet()) {
            if (str.equalsIgnoreCase((String) next.getKey())) {
                return (Field) next.getValue();
            }
        }
        return field;
    }

    public static ParserConfig getGlobalInstance() {
        return global;
    }

    private void initDeserializers() {
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap = this.deserializers;
        MiscCodec miscCodec = MiscCodec.instance;
        identityHashMap.put(SimpleDateFormat.class, miscCodec);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap2 = this.deserializers;
        CalendarCodec calendarCodec = CalendarCodec.instance;
        identityHashMap2.put(Calendar.class, calendarCodec);
        this.deserializers.put(XMLGregorianCalendar.class, calendarCodec);
        this.deserializers.put(JSONObject.class, MapDeserializer.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap3 = this.deserializers;
        CollectionCodec collectionCodec = CollectionCodec.instance;
        identityHashMap3.put(JSONArray.class, collectionCodec);
        this.deserializers.put(Map.class, MapDeserializer.instance);
        this.deserializers.put(HashMap.class, MapDeserializer.instance);
        this.deserializers.put(LinkedHashMap.class, MapDeserializer.instance);
        this.deserializers.put(TreeMap.class, MapDeserializer.instance);
        this.deserializers.put(ConcurrentMap.class, MapDeserializer.instance);
        this.deserializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
        this.deserializers.put(Collection.class, collectionCodec);
        this.deserializers.put(List.class, collectionCodec);
        this.deserializers.put(ArrayList.class, collectionCodec);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap4 = this.deserializers;
        JavaObjectDeserializer javaObjectDeserializer = JavaObjectDeserializer.instance;
        identityHashMap4.put(Object.class, javaObjectDeserializer);
        this.deserializers.put(String.class, StringCodec.instance);
        this.deserializers.put(StringBuffer.class, StringCodec.instance);
        this.deserializers.put(StringBuilder.class, StringCodec.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap5 = this.deserializers;
        Class cls = Character.TYPE;
        CharacterCodec characterCodec = CharacterCodec.instance;
        identityHashMap5.put(cls, characterCodec);
        this.deserializers.put(Character.class, characterCodec);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap6 = this.deserializers;
        Class cls2 = Byte.TYPE;
        NumberDeserializer numberDeserializer = NumberDeserializer.instance;
        identityHashMap6.put(cls2, numberDeserializer);
        this.deserializers.put(Byte.class, numberDeserializer);
        this.deserializers.put(Short.TYPE, numberDeserializer);
        this.deserializers.put(Short.class, numberDeserializer);
        this.deserializers.put(Integer.TYPE, IntegerCodec.instance);
        this.deserializers.put(Integer.class, IntegerCodec.instance);
        this.deserializers.put(Long.TYPE, LongCodec.instance);
        this.deserializers.put(Long.class, LongCodec.instance);
        this.deserializers.put(BigInteger.class, BigIntegerCodec.instance);
        this.deserializers.put(BigDecimal.class, BigDecimalCodec.instance);
        this.deserializers.put(Float.TYPE, FloatCodec.instance);
        this.deserializers.put(Float.class, FloatCodec.instance);
        this.deserializers.put(Double.TYPE, numberDeserializer);
        this.deserializers.put(Double.class, numberDeserializer);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap7 = this.deserializers;
        Class cls3 = Boolean.TYPE;
        BooleanCodec booleanCodec = BooleanCodec.instance;
        identityHashMap7.put(cls3, booleanCodec);
        this.deserializers.put(Boolean.class, booleanCodec);
        this.deserializers.put(Class.class, miscCodec);
        this.deserializers.put(char[].class, new CharArrayCodec());
        this.deserializers.put(AtomicBoolean.class, booleanCodec);
        this.deserializers.put(AtomicInteger.class, IntegerCodec.instance);
        this.deserializers.put(AtomicLong.class, LongCodec.instance);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap8 = this.deserializers;
        ReferenceCodec referenceCodec = ReferenceCodec.instance;
        identityHashMap8.put(AtomicReference.class, referenceCodec);
        this.deserializers.put(WeakReference.class, referenceCodec);
        this.deserializers.put(SoftReference.class, referenceCodec);
        this.deserializers.put(UUID.class, miscCodec);
        this.deserializers.put(TimeZone.class, miscCodec);
        this.deserializers.put(Locale.class, miscCodec);
        this.deserializers.put(Currency.class, miscCodec);
        this.deserializers.put(Inet4Address.class, miscCodec);
        this.deserializers.put(Inet6Address.class, miscCodec);
        this.deserializers.put(InetSocketAddress.class, miscCodec);
        this.deserializers.put(File.class, miscCodec);
        this.deserializers.put(URI.class, miscCodec);
        this.deserializers.put(URL.class, miscCodec);
        this.deserializers.put(Pattern.class, miscCodec);
        this.deserializers.put(Charset.class, miscCodec);
        this.deserializers.put(JSONPath.class, miscCodec);
        this.deserializers.put(Number.class, numberDeserializer);
        IdentityHashMap<Type, ObjectDeserializer> identityHashMap9 = this.deserializers;
        AtomicCodec atomicCodec = AtomicCodec.instance;
        identityHashMap9.put(AtomicIntegerArray.class, atomicCodec);
        this.deserializers.put(AtomicLongArray.class, atomicCodec);
        this.deserializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
        this.deserializers.put(Serializable.class, javaObjectDeserializer);
        this.deserializers.put(Cloneable.class, javaObjectDeserializer);
        this.deserializers.put(Comparable.class, javaObjectDeserializer);
        this.deserializers.put(Closeable.class, javaObjectDeserializer);
        this.deserializers.put(JSONPObject.class, new JSONPDeserializer());
        ModuleUtil.callWhenHasJavaSql(this.initDeserializersWithJavaSql);
    }

    public static boolean isPrimitive2(Class<?> cls) {
        boolean z;
        if (cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls.isEnum()) {
            z = true;
        } else {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        if (!z) {
            valueOf = (Boolean) ModuleUtil.callWhenHasJavaSql(isPrimitiveFuncation, cls);
        }
        if (valueOf != null) {
            return valueOf.booleanValue();
        }
        return false;
    }

    public static void parserAllFieldToCache(Class<?> cls, Map<String, Field> map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
            parserAllFieldToCache(cls.getSuperclass(), map);
        }
    }

    private static String[] splitItemsFormProperty(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(",");
    }

    public void addAccept(String str) {
        if (str != null && str.length() != 0) {
            long fnv1a_64 = TypeUtils.fnv1a_64(str);
            if (Arrays.binarySearch(this.acceptHashCodes, fnv1a_64) < 0) {
                long[] jArr = this.acceptHashCodes;
                int length = jArr.length;
                long[] jArr2 = new long[(length + 1)];
                jArr2[length] = fnv1a_64;
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                Arrays.sort(jArr2);
                this.acceptHashCodes = jArr2;
            }
        }
    }

    public void addAutoTypeCheckHandler(AutoTypeCheckHandler autoTypeCheckHandler) {
        List list = this.autoTypeCheckHandlers;
        if (list == null) {
            list = new CopyOnWriteArrayList();
            this.autoTypeCheckHandlers = list;
        }
        list.add(autoTypeCheckHandler);
    }

    public void addDeny(String str) {
        if (str != null && str.length() != 0) {
            long fnv1a_64 = TypeUtils.fnv1a_64(str);
            if (Arrays.binarySearch(this.denyHashCodes, fnv1a_64) < 0) {
                long[] jArr = this.denyHashCodes;
                int length = jArr.length;
                long[] jArr2 = new long[(length + 1)];
                jArr2[length] = fnv1a_64;
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                Arrays.sort(jArr2);
                this.denyHashCodes = jArr2;
            }
        }
    }

    public void addDenyInternal(String str) {
        if (str != null && str.length() != 0) {
            long fnv1a_64 = TypeUtils.fnv1a_64(str);
            long[] jArr = this.internalDenyHashCodes;
            if (jArr == null) {
                this.internalDenyHashCodes = new long[]{fnv1a_64};
            } else if (Arrays.binarySearch(jArr, fnv1a_64) < 0) {
                long[] jArr2 = this.internalDenyHashCodes;
                int length = jArr2.length;
                long[] jArr3 = new long[(1 + length)];
                jArr3[length] = fnv1a_64;
                System.arraycopy(jArr2, 0, jArr3, 0, jArr2.length);
                Arrays.sort(jArr3);
                this.internalDenyHashCodes = jArr3;
            }
        }
    }

    public Class<?> checkAutoType(Class cls) {
        if (get(cls) != null) {
            return cls;
        }
        return checkAutoType(cls.getName(), (Class<?>) null, JSON.DEFAULT_PARSER_FEATURE);
    }

    public void clearDeserializers() {
        this.deserializers.clear();
        initDeserializers();
    }

    public void configFromPropety(Properties properties) {
        addItemsToDeny(splitItemsFormProperty(properties.getProperty(DENY_PROPERTY)));
        addItemsToAccept(splitItemsFormProperty(properties.getProperty(AUTOTYPE_ACCEPT)));
        String property = properties.getProperty(AUTOTYPE_SUPPORT_PROPERTY);
        if ("true".equals(property)) {
            this.autoTypeSupport = true;
        } else if ("false".equals(property)) {
            this.autoTypeSupport = false;
        }
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, FieldInfo fieldInfo) {
        Class<?> deserializeUsing;
        Class<?> cls = javaBeanInfo.clazz;
        Class<?> cls2 = fieldInfo.fieldClass;
        JSONField annotation = fieldInfo.getAnnotation();
        Class<?> cls3 = null;
        if (!(annotation == null || (deserializeUsing = annotation.deserializeUsing()) == Void.class)) {
            cls3 = deserializeUsing;
        }
        if (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) {
            return new ArrayListTypeFieldDeserializer(parserConfig, cls, fieldInfo);
        }
        return new DefaultFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public ObjectDeserializer createJavaBeanDeserializer(Class<?> cls, Type type) {
        JSONField annotation;
        Method method;
        ASMDeserializerFactory aSMDeserializerFactory;
        boolean z = this.asmEnable & (!this.fieldBased);
        Class<Void> cls2 = Void.class;
        boolean z2 = false;
        if (z) {
            JSONType jSONType = (JSONType) TypeUtils.getAnnotation(cls, JSONType.class);
            if (jSONType != null) {
                Class<?> deserializer = jSONType.deserializer();
                if (deserializer != cls2) {
                    try {
                        Object newInstance = deserializer.newInstance();
                        if (newInstance instanceof ObjectDeserializer) {
                            return (ObjectDeserializer) newInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (!jSONType.asm() || jSONType.parseFeatures().length != 0) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                Class<?> builderClass = JavaBeanInfo.getBuilderClass(cls, jSONType);
                if (builderClass == null) {
                    builderClass = cls;
                }
                while (true) {
                    if (Modifier.isPublic(builderClass.getModifiers())) {
                        builderClass = builderClass.getSuperclass();
                        if (builderClass != Object.class) {
                            if (builderClass == null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            }
        }
        if (cls.getTypeParameters().length != 0) {
            z = false;
        }
        if (z && (aSMDeserializerFactory = this.asmFactory) != null && aSMDeserializerFactory.classLoader.isExternalClass(cls)) {
            z = false;
        }
        if (z) {
            z = ASMUtils.checkName(cls.getSimpleName());
        }
        if (z) {
            if (cls.isInterface()) {
                z = false;
            }
            JavaBeanInfo build = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, this.jacksonCompatible);
            if (z && build.fields.length > 200) {
                z = false;
            }
            Constructor<?> constructor = build.defaultConstructor;
            if (z && constructor == null && !cls.isInterface()) {
                z = false;
            }
            FieldInfo[] fieldInfoArr = build.fields;
            int length = fieldInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                FieldInfo fieldInfo = fieldInfoArr[i];
                if (!fieldInfo.getOnly) {
                    Class<?> cls3 = fieldInfo.fieldClass;
                    if (!Modifier.isPublic(cls3.getModifiers()) || ((cls3.isMemberClass() && !Modifier.isStatic(cls3.getModifiers())) || ((fieldInfo.getMember() != null && !ASMUtils.checkName(fieldInfo.getMember().getName())) || (((annotation = fieldInfo.getAnnotation()) != null && (!ASMUtils.checkName(annotation.name()) || annotation.format().length() != 0 || annotation.deserializeUsing() != cls2 || annotation.parseFeatures().length != 0 || annotation.unwrapped())) || (((method = fieldInfo.method) != null && method.getParameterTypes().length > 1) || (cls3.isEnum() && !(getDeserializer((Type) cls3) instanceof EnumDeserializer))))))) {
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            z = false;
        }
        if (z && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
            z = false;
        }
        if (!z || !TypeUtils.isXmlField(cls)) {
            z2 = z;
        }
        if (!z2) {
            return new JavaBeanDeserializer(this, cls, type);
        }
        JavaBeanInfo build2 = JavaBeanInfo.build(cls, type, this.propertyNamingStrategy);
        try {
            return this.asmFactory.createJavaBeanDeserializer(this, build2);
        } catch (NoSuchMethodException unused2) {
            return new JavaBeanDeserializer(this, cls, type);
        } catch (JSONException unused3) {
            return new JavaBeanDeserializer(this, build2);
        } catch (Exception e) {
            throw new JSONException("create asm deserializer error, " + cls.getName(), e);
        }
    }

    public ObjectDeserializer get(Type type) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations == null) {
            return this.deserializers.get(type);
        }
        IdentityHashMap identityHashMap = this.mixInDeserializers.get(type);
        if (identityHashMap == null) {
            return null;
        }
        return (ObjectDeserializer) identityHashMap.get(mixInAnnotations);
    }

    public ClassLoader getDefaultClassLoader() {
        return this.defaultClassLoader;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDerializers() {
        return this.deserializers;
    }

    public ObjectDeserializer getDeserializer(Type type) {
        ObjectDeserializer objectDeserializer = get(type);
        if (objectDeserializer != null) {
            return objectDeserializer;
        }
        if (type instanceof Class) {
            return getDeserializer((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return getDeserializer((Class) rawType, type);
            }
            return getDeserializer(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getDeserializer(upperBounds[0]);
            }
        }
        return JavaObjectDeserializer.instance;
    }

    public IdentityHashMap<Type, ObjectDeserializer> getDeserializers() {
        return this.deserializers;
    }

    public ObjectDeserializer getEnumDeserializer(Class<?> cls) {
        return new EnumDeserializer(cls);
    }

    public void initJavaBeanDeserializers(Class<?>... clsArr) {
        if (clsArr != null) {
            for (Class<?> cls : clsArr) {
                if (cls != null) {
                    putDeserializer(cls, createJavaBeanDeserializer(cls, cls));
                }
            }
        }
    }

    public boolean isAsmEnable() {
        return this.asmEnable;
    }

    public boolean isAutoTypeSupport() {
        return this.autoTypeSupport;
    }

    public boolean isJacksonCompatible() {
        return this.jacksonCompatible;
    }

    public boolean isPrimitive(Class<?> cls) {
        return isPrimitive2(cls);
    }

    public boolean isSafeMode() {
        return this.safeMode;
    }

    public void putDeserializer(Type type, ObjectDeserializer objectDeserializer) {
        Type mixInAnnotations = JSON.getMixInAnnotations(type);
        if (mixInAnnotations != null) {
            IdentityHashMap identityHashMap = this.mixInDeserializers.get(type);
            if (identityHashMap == null) {
                identityHashMap = new IdentityHashMap(4);
                this.mixInDeserializers.put(type, identityHashMap);
            }
            identityHashMap.put(mixInAnnotations, objectDeserializer);
            return;
        }
        this.deserializers.put(type, objectDeserializer);
    }

    public void register(String str, Class cls) {
        this.typeMapping.putIfAbsent(str, cls);
    }

    public void setAsmEnable(boolean z) {
        this.asmEnable = z;
    }

    public void setAutoTypeSupport(boolean z) {
        this.autoTypeSupport = z;
    }

    public void setDefaultClassLoader(ClassLoader classLoader) {
        this.defaultClassLoader = classLoader;
    }

    public void setJacksonCompatible(boolean z) {
        this.jacksonCompatible = z;
    }

    public void setSafeMode(boolean z) {
        this.safeMode = z;
    }

    public ParserConfig(boolean z) {
        this((ASMDeserializerFactory) null, (ClassLoader) null, z);
    }

    public void register(Module module) {
        this.modules.add(module);
    }

    public ParserConfig(ClassLoader classLoader) {
        this((ASMDeserializerFactory) null, classLoader, false);
    }

    public Class<?> checkAutoType(String str, Class<?> cls) {
        return checkAutoType(str, cls, JSON.DEFAULT_PARSER_FEATURE);
    }

    public ParserConfig(ASMDeserializerFactory aSMDeserializerFactory) {
        this(aSMDeserializerFactory, (ClassLoader) null, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02d2, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02d3, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02d5, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02fc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0307, code lost:
        com.alibaba.fastjson.util.IOUtils.close(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x030a, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02d2 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:142:0x02b0] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02fc A[ExcHandler: all (th java.lang.Throwable), Splitter:B:157:0x02e4] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0317 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x03cf A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x03ec  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<?> checkAutoType(java.lang.String r25, java.lang.Class<?> r26, int r27) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            r2 = r26
            r3 = r27
            r4 = 0
            if (r0 != 0) goto L_0x000c
            return r4
        L_0x000c:
            java.util.List<com.alibaba.fastjson.parser.ParserConfig$AutoTypeCheckHandler> r5 = r1.autoTypeCheckHandlers
            if (r5 == 0) goto L_0x0029
            java.util.List<com.alibaba.fastjson.parser.ParserConfig$AutoTypeCheckHandler> r5 = r1.autoTypeCheckHandlers
            java.util.Iterator r5 = r5.iterator()
        L_0x0016:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0029
            java.lang.Object r6 = r5.next()
            com.alibaba.fastjson.parser.ParserConfig$AutoTypeCheckHandler r6 = (com.alibaba.fastjson.parser.ParserConfig.AutoTypeCheckHandler) r6
            java.lang.Class r6 = r6.handler(r0, r2, r3)
            if (r6 == 0) goto L_0x0016
            return r6
        L_0x0029:
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.SafeMode
            int r5 = r5.mask
            boolean r6 = r1.safeMode
            if (r6 != 0) goto L_0x0416
            r6 = r3 & r5
            if (r6 != 0) goto L_0x0416
            int r6 = com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0416
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.SupportAutoType
            int r5 = r5.mask
            boolean r6 = r1.autoTypeSupport
            r7 = 0
            r8 = 1
            if (r6 != 0) goto L_0x004f
            r3 = r3 & r5
            if (r3 != 0) goto L_0x004f
            int r3 = com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE
            r3 = r3 & r5
            if (r3 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r3 = 0
            goto L_0x0050
        L_0x004f:
            r3 = 1
        L_0x0050:
            int r5 = r25.length()
            r6 = 192(0xc0, float:2.69E-43)
            java.lang.String r9 = "autoType is not support. "
            if (r5 >= r6) goto L_0x0401
            int r5 = r25.length()
            r6 = 3
            if (r5 < r6) goto L_0x0401
            if (r2 != 0) goto L_0x0065
        L_0x0063:
            r5 = 0
            goto L_0x00c9
        L_0x0065:
            java.lang.String r5 = r26.getName()
            long r10 = com.alibaba.fastjson.util.TypeUtils.fnv1a_64(r5)
            r12 = -8024746738719829346(0x90a25f5baa21529e, double:-1.514751450580626E-228)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0063
            r12 = 3247277300971823414(0x2d10a5801b9d6136, double:1.2768618085266423E-91)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0063
            r12 = -5811778396720452501(0xaf586a571e302c6b, double:-1.2869594668238042E-80)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0063
            r12 = -1368967840069965882(0xed007300a7b227c6, double:-1.1341028219519378E217)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0063
            r12 = 2980334044947851925(0x295c4605fd1eaa95, double:1.8810554767322845E-109)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0063
            r12 = 5183404141909004468(0x47ef269aadc650b4, double:3.312520992710671E38)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0063
            r12 = 7222019943667248779(0x6439c4dff712ae8b, double:6.373467611436065E174)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0063
            r12 = -2027296626235911549(0xe3dd9875a2dc5283, double:-1.1437309411088266E173)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0063
            r12 = -2114196234051346931(0xe2a8ddba03e69e0d, double:-1.8328867399748285E167)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0063
            r12 = -2939497380989775398(0xd734ceb4c3e9d1da, double:-1.2509996135591577E112)
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x00c8
            goto L_0x0063
        L_0x00c8:
            r5 = 1
        L_0x00c9:
            r10 = 36
            r11 = 46
            java.lang.String r10 = r0.replace(r10, r11)
            char r12 = r10.charAt(r7)
            long r12 = (long) r12
            r14 = -3750763034362895579(0xcbf29ce484222325, double:-7.302176725335867E57)
            long r12 = r12 ^ r14
            r16 = 1099511628211(0x100000001b3, double:5.43230922702E-312)
            long r12 = r12 * r16
            r18 = -5808493101479473382(0xaf64164c86024f1a, double:-2.1176223865607047E-80)
            int r20 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r20 == 0) goto L_0x03ec
            int r18 = r10.length()
            int r6 = r18 + -1
            char r6 = r10.charAt(r6)
            r19 = r5
            long r4 = (long) r6
            long r4 = r4 ^ r12
            long r4 = r4 * r16
            r12 = 655701488918567152(0x9198507b5af98f0, double:7.914409534561175E-265)
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x03d7
            char r4 = r10.charAt(r7)
            long r4 = (long) r4
            long r4 = r4 ^ r14
            long r4 = r4 * r16
            char r6 = r10.charAt(r8)
            long r12 = (long) r6
            long r4 = r4 ^ r12
            long r4 = r4 * r16
            r6 = 2
            char r6 = r10.charAt(r6)
            long r12 = (long) r6
            long r4 = r4 ^ r12
            long r4 = r4 * r16
            long r12 = com.alibaba.fastjson.util.TypeUtils.fnv1a_64(r10)
            long[] r6 = INTERNAL_WHITELIST_HASHCODES
            int r6 = java.util.Arrays.binarySearch(r6, r12)
            if (r6 < 0) goto L_0x012c
            r6 = 1
            goto L_0x012d
        L_0x012c:
            r6 = 0
        L_0x012d:
            long[] r14 = r1.internalDenyHashCodes
            if (r14 == 0) goto L_0x016b
            r20 = r4
            r14 = 3
        L_0x0134:
            int r15 = r10.length()
            if (r14 >= r15) goto L_0x016b
            char r15 = r10.charAt(r14)
            r22 = r12
            long r11 = (long) r15
            long r11 = r20 ^ r11
            long r11 = r11 * r16
            long[] r13 = r1.internalDenyHashCodes
            int r13 = java.util.Arrays.binarySearch(r13, r11)
            if (r13 >= 0) goto L_0x0156
            int r14 = r14 + 1
            r20 = r11
            r12 = r22
            r11 = 46
            goto L_0x0134
        L_0x0156:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x016b:
            r22 = r12
            if (r6 != 0) goto L_0x01cb
            if (r3 != 0) goto L_0x0173
            if (r19 == 0) goto L_0x01cb
        L_0x0173:
            r12 = r4
            r11 = 3
        L_0x0175:
            int r14 = r10.length()
            if (r11 >= r14) goto L_0x01cb
            char r14 = r10.charAt(r11)
            long r14 = (long) r14
            long r12 = r12 ^ r14
            long r12 = r12 * r16
            long[] r14 = r1.acceptHashCodes
            int r14 = java.util.Arrays.binarySearch(r14, r12)
            if (r14 < 0) goto L_0x0194
            java.lang.ClassLoader r14 = r1.defaultClassLoader
            java.lang.Class r14 = com.alibaba.fastjson.util.TypeUtils.loadClass(r0, r14, r8)
            if (r14 == 0) goto L_0x0194
            return r14
        L_0x0194:
            long[] r14 = r1.denyHashCodes
            int r14 = java.util.Arrays.binarySearch(r14, r12)
            if (r14 < 0) goto L_0x01c2
            java.lang.Class r14 = com.alibaba.fastjson.util.TypeUtils.getClassFromMapping(r25)
            if (r14 != 0) goto L_0x01c2
            long[] r14 = r1.acceptHashCodes
            r7 = r22
            int r14 = java.util.Arrays.binarySearch(r14, r7)
            if (r14 < 0) goto L_0x01ad
            goto L_0x01c4
        L_0x01ad:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x01c2:
            r7 = r22
        L_0x01c4:
            int r11 = r11 + 1
            r22 = r7
            r7 = 0
            r8 = 1
            goto L_0x0175
        L_0x01cb:
            java.lang.Class r7 = com.alibaba.fastjson.util.TypeUtils.getClassFromMapping(r25)
            if (r7 != 0) goto L_0x01d7
            com.alibaba.fastjson.util.IdentityHashMap<java.lang.reflect.Type, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer> r7 = r1.deserializers
            java.lang.Class r7 = r7.findClass(r0)
        L_0x01d7:
            if (r2 != 0) goto L_0x01e6
            if (r7 == 0) goto L_0x01e6
            java.lang.Class<java.lang.Throwable> r8 = java.lang.Throwable.class
            boolean r8 = r8.isAssignableFrom(r7)
            if (r8 == 0) goto L_0x01e6
            if (r3 != 0) goto L_0x01e6
            r7 = 0
        L_0x01e6:
            if (r7 != 0) goto L_0x01f0
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r7 = r1.typeMapping
            java.lang.Object r7 = r7.get(r0)
            java.lang.Class r7 = (java.lang.Class) r7
        L_0x01f0:
            if (r6 == 0) goto L_0x01fa
            java.lang.ClassLoader r6 = r1.defaultClassLoader
            r7 = 1
            java.lang.Class r6 = com.alibaba.fastjson.util.TypeUtils.loadClass(r0, r6, r7)
            r7 = r6
        L_0x01fa:
            java.lang.String r6 = " -> "
            java.lang.String r8 = "type not match. "
            if (r7 == 0) goto L_0x0231
            if (r2 == 0) goto L_0x0230
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            if (r7 == r3) goto L_0x0230
            java.lang.Class<java.util.LinkedHashMap> r3 = java.util.LinkedHashMap.class
            if (r7 == r3) goto L_0x0230
            boolean r3 = r2.isAssignableFrom(r7)
            if (r3 == 0) goto L_0x0211
            goto L_0x0230
        L_0x0211:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            r4.append(r0)
            r4.append(r6)
            java.lang.String r0 = r26.getName()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        L_0x0230:
            return r7
        L_0x0231:
            java.lang.String r11 = "Error"
            java.lang.String r12 = "Exception"
            if (r3 != 0) goto L_0x02b0
            r13 = 3
        L_0x0238:
            int r14 = r10.length()
            if (r13 >= r14) goto L_0x02b0
            char r14 = r10.charAt(r13)
            long r14 = (long) r14
            long r4 = r4 ^ r14
            long r4 = r4 * r16
            long[] r14 = r1.denyHashCodes
            int r14 = java.util.Arrays.binarySearch(r14, r4)
            if (r14 < 0) goto L_0x0272
            boolean r2 = r0.endsWith(r12)
            if (r2 != 0) goto L_0x025a
            boolean r2 = r0.endsWith(r11)
            if (r2 == 0) goto L_0x025c
        L_0x025a:
            r2 = 0
            goto L_0x0271
        L_0x025c:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x0271:
            return r2
        L_0x0272:
            long[] r14 = r1.acceptHashCodes
            int r14 = java.util.Arrays.binarySearch(r14, r4)
            if (r14 < 0) goto L_0x02ad
            java.lang.ClassLoader r3 = r1.defaultClassLoader
            r4 = 1
            java.lang.Class r3 = com.alibaba.fastjson.util.TypeUtils.loadClass(r0, r3, r4)
            if (r3 != 0) goto L_0x0284
            return r2
        L_0x0284:
            if (r2 == 0) goto L_0x02ac
            boolean r4 = r2.isAssignableFrom(r3)
            if (r4 != 0) goto L_0x028d
            goto L_0x02ac
        L_0x028d:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            r4.append(r0)
            r4.append(r6)
            java.lang.String r0 = r26.getName()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        L_0x02ac:
            return r3
        L_0x02ad:
            int r13 = r13 + 1
            goto L_0x0238
        L_0x02b0:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0304, all -> 0x02d2 }
            r4.<init>()     // Catch:{ Exception -> 0x0304, all -> 0x02d2 }
            r5 = 47
            r10 = 46
            java.lang.String r5 = r0.replace(r10, r5)     // Catch:{ Exception -> 0x0304, all -> 0x02d2 }
            r4.append(r5)     // Catch:{ Exception -> 0x0304, all -> 0x02d2 }
            java.lang.String r5 = ".class"
            r4.append(r5)     // Catch:{ Exception -> 0x0304, all -> 0x02d2 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0304, all -> 0x02d2 }
            java.lang.ClassLoader r5 = r1.defaultClassLoader     // Catch:{ Exception -> 0x0304, all -> 0x02d2 }
            if (r5 == 0) goto L_0x02d8
            java.io.InputStream r4 = r5.getResourceAsStream(r4)     // Catch:{ Exception -> 0x02d5, all -> 0x02d2 }
            goto L_0x02e2
        L_0x02d2:
            r0 = move-exception
            r4 = 0
            goto L_0x0307
        L_0x02d5:
            r4 = 0
        L_0x02d6:
            r15 = 0
            goto L_0x030b
        L_0x02d8:
            java.lang.Class<com.alibaba.fastjson.parser.ParserConfig> r5 = com.alibaba.fastjson.parser.ParserConfig.class
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ Exception -> 0x0304, all -> 0x02d2 }
            java.io.InputStream r4 = r5.getResourceAsStream(r4)     // Catch:{ Exception -> 0x0304, all -> 0x02d2 }
        L_0x02e2:
            if (r4 == 0) goto L_0x02fe
            com.alibaba.fastjson.asm.ClassReader r5 = new com.alibaba.fastjson.asm.ClassReader     // Catch:{ Exception -> 0x02d6, all -> 0x02fc }
            r10 = 1
            r5.<init>(r4, r10)     // Catch:{ Exception -> 0x02d6, all -> 0x02fc }
            com.alibaba.fastjson.asm.TypeCollector r13 = new com.alibaba.fastjson.asm.TypeCollector     // Catch:{ Exception -> 0x02d6, all -> 0x02fc }
            java.lang.String r14 = "<clinit>"
            r15 = 0
            java.lang.Class[] r10 = new java.lang.Class[r15]     // Catch:{ Exception -> 0x030b, all -> 0x02fc }
            r13.<init>(r14, r10)     // Catch:{ Exception -> 0x030b, all -> 0x02fc }
            r5.accept(r13)     // Catch:{ Exception -> 0x030b, all -> 0x02fc }
            boolean r5 = r13.hasJsonType()     // Catch:{ Exception -> 0x030b, all -> 0x02fc }
            goto L_0x0300
        L_0x02fc:
            r0 = move-exception
            goto L_0x0307
        L_0x02fe:
            r15 = 0
            r5 = 0
        L_0x0300:
            com.alibaba.fastjson.util.IOUtils.close(r4)
            goto L_0x030f
        L_0x0304:
            r15 = 0
            r4 = 0
            goto L_0x030b
        L_0x0307:
            com.alibaba.fastjson.util.IOUtils.close(r4)
            throw r0
        L_0x030b:
            com.alibaba.fastjson.util.IOUtils.close(r4)
            r5 = 0
        L_0x030f:
            if (r3 != 0) goto L_0x0315
            if (r5 != 0) goto L_0x0315
            if (r19 == 0) goto L_0x0323
        L_0x0315:
            if (r3 != 0) goto L_0x031c
            if (r5 == 0) goto L_0x031a
            goto L_0x031c
        L_0x031a:
            r7 = 0
            goto L_0x031d
        L_0x031c:
            r7 = 1
        L_0x031d:
            java.lang.ClassLoader r4 = r1.defaultClassLoader
            java.lang.Class r7 = com.alibaba.fastjson.util.TypeUtils.loadClass(r0, r4, r7)
        L_0x0323:
            if (r7 == 0) goto L_0x03a9
            if (r5 == 0) goto L_0x032d
            if (r3 == 0) goto L_0x032c
            com.alibaba.fastjson.util.TypeUtils.addMapping(r0, r7)
        L_0x032c:
            return r7
        L_0x032d:
            java.lang.Class<java.lang.ClassLoader> r4 = java.lang.ClassLoader.class
            boolean r4 = r4.isAssignableFrom(r7)
            if (r4 != 0) goto L_0x0394
            java.lang.Class<javax.sql.DataSource> r4 = javax.sql.DataSource.class
            boolean r4 = r4.isAssignableFrom(r7)
            if (r4 != 0) goto L_0x0394
            java.lang.Class<javax.sql.RowSet> r4 = javax.sql.RowSet.class
            boolean r4 = r4.isAssignableFrom(r7)
            if (r4 != 0) goto L_0x0394
            if (r2 == 0) goto L_0x0372
            boolean r4 = r2.isAssignableFrom(r7)
            if (r4 == 0) goto L_0x0353
            if (r3 == 0) goto L_0x0352
            com.alibaba.fastjson.util.TypeUtils.addMapping(r0, r7)
        L_0x0352:
            return r7
        L_0x0353:
            com.alibaba.fastjson.JSONException r3 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            r4.append(r0)
            r4.append(r6)
            java.lang.String r0 = r26.getName()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        L_0x0372:
            com.alibaba.fastjson.PropertyNamingStrategy r2 = r1.propertyNamingStrategy
            com.alibaba.fastjson.util.JavaBeanInfo r2 = com.alibaba.fastjson.util.JavaBeanInfo.build(r7, r7, r2)
            java.lang.reflect.Constructor<?> r2 = r2.creatorConstructor
            if (r2 == 0) goto L_0x03a9
            if (r3 != 0) goto L_0x037f
            goto L_0x03a9
        L_0x037f:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x0394:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x03a9:
            if (r3 != 0) goto L_0x03cf
            boolean r2 = r0.endsWith(r12)
            if (r2 != 0) goto L_0x03b7
            boolean r2 = r0.endsWith(r11)
            if (r2 == 0) goto L_0x03b9
        L_0x03b7:
            r2 = 0
            goto L_0x03ce
        L_0x03b9:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x03ce:
            return r2
        L_0x03cf:
            if (r7 == 0) goto L_0x03d6
            if (r3 == 0) goto L_0x03d6
            com.alibaba.fastjson.util.TypeUtils.addMapping(r0, r7)
        L_0x03d6:
            return r7
        L_0x03d7:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x03ec:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x0401:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r9)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x0416:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "safeMode not support autoType : "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ParserConfig.checkAutoType(java.lang.String, java.lang.Class, int):java.lang.Class");
    }

    private ParserConfig(ASMDeserializerFactory aSMDeserializerFactory, ClassLoader classLoader, boolean z) {
        this.deserializers = new IdentityHashMap<>();
        this.mixInDeserializers = new IdentityHashMap<>(16);
        this.typeMapping = new ConcurrentHashMap(16, 0.75f, 1);
        this.asmEnable = !ASMUtils.IS_ANDROID;
        this.symbolTable = new SymbolTable(4096);
        this.autoTypeSupport = AUTO_SUPPORT;
        this.jacksonCompatible = false;
        this.compatibleWithJavaBean = TypeUtils.compatibleWithJavaBean;
        this.modules = new ArrayList();
        this.safeMode = SAFE_MODE;
        this.denyHashCodes = new long[]{-9164606388214699518L, -8754006975464705441L, -8720046426850100497L, -8649961213709896794L, -8614556368991373401L, -8382625455832334425L, -8165637398350707645L, -8109300701639721088L, -7966123100503199569L, -7921218830998286408L, -7775351613326101303L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6316154655839304624L, -6179589609550493385L, -6149130139291498841L, -6149093380703242441L, -6088208984980396913L, -6025144546313590215L, -5939269048541779808L, -5885964883385605994L, -5767141746063564198L, -5764804792063216819L, -5472097725414717105L, -5194641081268104286L, -5076846148177416215L, -4837536971810737970L, -4836620931940850535L, -4733542790109620528L, -4703320437989596122L, -4608341446948126581L, -4537258998789938600L, -4438775680185074100L, -4314457471973557243L, -4150995715611818742L, -4082057040235125754L, -3975378478825053783L, -3967588558552655563L, -3935185854875733362L, TypeUtils.fnv1a_64_magic_hashcode, -3319207949486691020L, -3077205613010077203L, -3053747177772160511L, -2995060141064716555L, -2825378362173150292L, -2533039401923731906L, -2439930098895578154L, -2378990704010641148L, -2364987994247679115L, -2262244760619952081L, -2192804397019347313L, -2095516571388852610L, -1872417015366588117L, -1800035667138631116L, -1650485814983027158L, -1589194880214235129L, -1363634950764737555L, -965955008570215305L, -905177026366752536L, -831789045734283466L, -803541446955902575L, -731978084025273882L, -666475508176557463L, -582813228520337988L, -254670111376247151L, -219577392946377768L, -190281065685395680L, -26639035867733124L, -9822483067882491L, 4750336058574309L, 33238344207745342L, 156405680656087946L, 218512992947536312L, 313864100207897507L, 386461436234701831L, 744602970950881621L, 823641066473609950L, 860052378298585747L, 1073634739308289776L, 1153291637701043748L, 1203232727967308606L, 1214780596910349029L, 1268707909007641340L, 1459860845934817624L, 1502845958873959152L, 1534439610567445754L, 1698504441317515818L, 1818089308493370394L, 2078113382421334967L, 2164696723069287854L, 2622551729063269307L, 2653453629929770569L, 2660670623866180977L, 2731823439467737506L, 2836431254737891113L, 2930861374593775110L, 3058452313624178956L, 3085473968517218653L, 3089451460101527857L, 3114862868117605599L, 3129395579983849527L, 3256258368248066264L, 3452379460455804429L, 3547627781654598988L, 3637939656440441093L, 3688179072722109200L, 3718352661124136681L, 3730752432285826863L, 3740226159580918099L, 3794316665763266033L, 3977090344859527316L, 4000049462512838776L, 4046190361520671643L, 4147696707147271408L, 4193204392725694463L, 4215053018660518963L, 4241163808635564644L, 4254584350247334433L, 4319304524795015394L, 4814658433570175913L, 4841947709850912914L, 4904007817188630457L, 5100336081510080343L, 5120543992130540564L, 5274044858141538265L, 5347909877633654828L, 5450448828334921485L, 5474268165959054640L, 5545425291794704408L, 5596129856135573697L, 5688200883751798389L, 5751393439502795295L, 5916409771425455946L, 5944107969236155580L, 6007332606592876737L, 6090377589998869205L, 6280357960959217660L, 6456855723474196908L, 6511035576063254270L, 6534946468240507089L, 6584624952928234050L, 6734240326434096246L, 6742705432718011780L, 6800727078373023163L, 6854854816081053523L, 7045245923763966215L, 7123326897294507060L, 7164889056054194741L, 7179336928365889465L, 7240293012336844478L, 7347653049056829645L, 7375862386996623731L, 7442624256860549330L, 7617522210483516279L, 7658177784286215602L, 8055461369741094911L, 8064026652676081192L, 8389032537095247355L, 8409640769019589119L, 8488266005336625107L, 8537233257283452655L, 8711531061028787095L, 8735538376409180149L, 8838294710098435315L, 8861402923078831179L, 9140390920032557669L, 9140416208800006522L, 9144212112462101475L};
        long[] jArr = new long[AUTO_TYPE_ACCEPT_LIST.length];
        int i = 0;
        while (true) {
            String[] strArr = AUTO_TYPE_ACCEPT_LIST;
            if (i >= strArr.length) {
                break;
            }
            jArr[i] = TypeUtils.fnv1a_64(strArr[i]);
            i++;
        }
        Arrays.sort(jArr);
        this.acceptHashCodes = jArr;
        this.initDeserializersWithJavaSql = new Callable<Void>() {
            public Void call() {
                ParserConfig.this.deserializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
                ParserConfig.this.deserializers.put(Date.class, SqlDateDeserializer.instance);
                ParserConfig.this.deserializers.put(Time.class, TimeDeserializer.instance);
                ParserConfig.this.deserializers.put(java.util.Date.class, DateCodec.instance);
                return null;
            }
        };
        this.fieldBased = z;
        if (aSMDeserializerFactory == null && !ASMUtils.IS_ANDROID) {
            if (classLoader == null) {
                try {
                    aSMDeserializerFactory = new ASMDeserializerFactory(new ASMClassLoader());
                } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
                }
            } else {
                aSMDeserializerFactory = new ASMDeserializerFactory(classLoader);
            }
        }
        this.asmFactory = aSMDeserializerFactory;
        if (aSMDeserializerFactory == null) {
            this.asmEnable = false;
        }
        initDeserializers();
        addItemsToDeny(DENYS);
        addItemsToDeny0(DENYS_INTERNAL);
        addItemsToAccept(AUTO_TYPE_ACCEPT_LIST);
    }

    /* JADX WARNING: type inference failed for: r25v0, types: [java.lang.reflect.Type] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alibaba.fastjson.parser.deserializer.ObjectDeserializer getDeserializer(java.lang.Class<?> r24, java.lang.reflect.Type r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            java.lang.String r3 = "java.util.Optional"
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r0.get(r2)
            if (r4 != 0) goto L_0x001d
            boolean r5 = r2 instanceof com.alibaba.fastjson.util.ParameterizedTypeImpl
            if (r5 == 0) goto L_0x001d
            r4 = r2
            com.alibaba.fastjson.util.ParameterizedTypeImpl r4 = (com.alibaba.fastjson.util.ParameterizedTypeImpl) r4
            java.lang.reflect.Type r4 = com.alibaba.fastjson.TypeReference.intern(r4)
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r0.get(r4)
        L_0x001d:
            if (r4 == 0) goto L_0x0020
            return r4
        L_0x0020:
            if (r2 != 0) goto L_0x0023
            r2 = r1
        L_0x0023:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r0.get(r2)
            if (r4 == 0) goto L_0x002a
            return r4
        L_0x002a:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r5 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r6 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r1, r5)
            com.alibaba.fastjson.annotation.JSONType r6 = (com.alibaba.fastjson.annotation.JSONType) r6
            if (r6 == 0) goto L_0x0041
            java.lang.Class r6 = r6.mappingTo()
            java.lang.Class<java.lang.Void> r7 = java.lang.Void.class
            if (r6 == r7) goto L_0x0041
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r0.getDeserializer(r6, r6)
            return r1
        L_0x0041:
            boolean r6 = r2 instanceof java.lang.reflect.WildcardType
            if (r6 != 0) goto L_0x004d
            boolean r6 = r2 instanceof java.lang.reflect.TypeVariable
            if (r6 != 0) goto L_0x004d
            boolean r6 = r2 instanceof java.lang.reflect.ParameterizedType
            if (r6 == 0) goto L_0x0051
        L_0x004d:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r23.get(r24)
        L_0x0051:
            if (r4 == 0) goto L_0x0054
            return r4
        L_0x0054:
            java.util.List<com.alibaba.fastjson.spi.Module> r6 = r0.modules
            java.util.Iterator r6 = r6.iterator()
        L_0x005a:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0070
            java.lang.Object r4 = r6.next()
            com.alibaba.fastjson.spi.Module r4 = (com.alibaba.fastjson.spi.Module) r4
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r4.createDeserializer(r0, r1)
            if (r4 == 0) goto L_0x005a
            r0.putDeserializer(r2, r4)
            return r4
        L_0x0070:
            java.lang.String r6 = r24.getName()
            r7 = 36
            r8 = 46
            java.lang.String r6 = r6.replace(r7, r8)
            java.lang.String r7 = "java.awt."
            boolean r7 = r6.startsWith(r7)
            r8 = 4
            r9 = 0
            r10 = 1
            if (r7 == 0) goto L_0x00b9
            boolean r7 = com.alibaba.fastjson.serializer.AwtCodec.support(r24)
            if (r7 == 0) goto L_0x00b9
            boolean r7 = awtError
            if (r7 != 0) goto L_0x00b9
            java.lang.String r4 = "java.awt.Rectangle"
            java.lang.String r7 = "java.awt.Color"
            java.lang.String r11 = "java.awt.Point"
            java.lang.String r12 = "java.awt.Font"
            java.lang.String[] r4 = new java.lang.String[]{r11, r12, r4, r7}
            r7 = 0
        L_0x009e:
            if (r7 >= r8) goto L_0x00b7
            r11 = r4[r7]     // Catch:{ all -> 0x00b5 }
            boolean r12 = r11.equals(r6)     // Catch:{ all -> 0x00b5 }
            if (r12 == 0) goto L_0x00b2
            java.lang.Class r4 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x00b5 }
            com.alibaba.fastjson.serializer.AwtCodec r7 = com.alibaba.fastjson.serializer.AwtCodec.instance     // Catch:{ all -> 0x00b5 }
            r0.putDeserializer(r4, r7)     // Catch:{ all -> 0x00b5 }
            return r7
        L_0x00b2:
            int r7 = r7 + 1
            goto L_0x009e
        L_0x00b5:
            awtError = r10
        L_0x00b7:
            com.alibaba.fastjson.serializer.AwtCodec r4 = com.alibaba.fastjson.serializer.AwtCodec.instance
        L_0x00b9:
            boolean r7 = jdk8Error
            if (r7 != 0) goto L_0x0125
            java.lang.String r7 = "java.time."
            boolean r7 = r6.startsWith(r7)     // Catch:{ all -> 0x0123 }
            if (r7 == 0) goto L_0x00fb
            java.lang.String r11 = "java.time.LocalDateTime"
            java.lang.String r12 = "java.time.LocalDate"
            java.lang.String r13 = "java.time.LocalTime"
            java.lang.String r14 = "java.time.ZonedDateTime"
            java.lang.String r15 = "java.time.OffsetDateTime"
            java.lang.String r16 = "java.time.OffsetTime"
            java.lang.String r17 = "java.time.ZoneOffset"
            java.lang.String r18 = "java.time.ZoneRegion"
            java.lang.String r19 = "java.time.ZoneId"
            java.lang.String r20 = "java.time.Period"
            java.lang.String r21 = "java.time.Duration"
            java.lang.String r22 = "java.time.Instant"
            java.lang.String[] r3 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22}     // Catch:{ all -> 0x0123 }
            r7 = 0
        L_0x00e2:
            r8 = 12
            if (r7 >= r8) goto L_0x0125
            r8 = r3[r7]     // Catch:{ all -> 0x0123 }
            boolean r11 = r8.equals(r6)     // Catch:{ all -> 0x0123 }
            if (r11 == 0) goto L_0x00f8
            java.lang.Class r3 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x0123 }
            com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec r4 = com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.instance     // Catch:{ all -> 0x0123 }
            r0.putDeserializer(r3, r4)     // Catch:{ all -> 0x0123 }
            return r4
        L_0x00f8:
            int r7 = r7 + 1
            goto L_0x00e2
        L_0x00fb:
            boolean r7 = r6.startsWith(r3)     // Catch:{ all -> 0x0123 }
            if (r7 == 0) goto L_0x0125
            java.lang.String r7 = "java.util.OptionalDouble"
            java.lang.String r11 = "java.util.OptionalInt"
            java.lang.String r12 = "java.util.OptionalLong"
            java.lang.String[] r3 = new java.lang.String[]{r3, r7, r11, r12}     // Catch:{ all -> 0x0123 }
            r7 = 0
        L_0x010c:
            if (r7 >= r8) goto L_0x0125
            r11 = r3[r7]     // Catch:{ all -> 0x0123 }
            boolean r12 = r11.equals(r6)     // Catch:{ all -> 0x0123 }
            if (r12 == 0) goto L_0x0120
            java.lang.Class r3 = java.lang.Class.forName(r11)     // Catch:{ all -> 0x0123 }
            com.alibaba.fastjson.parser.deserializer.OptionalCodec r4 = com.alibaba.fastjson.parser.deserializer.OptionalCodec.instance     // Catch:{ all -> 0x0123 }
            r0.putDeserializer(r3, r4)     // Catch:{ all -> 0x0123 }
            return r4
        L_0x0120:
            int r7 = r7 + 1
            goto L_0x010c
        L_0x0123:
            jdk8Error = r10
        L_0x0125:
            boolean r3 = jodaError
            if (r3 != 0) goto L_0x0163
            java.lang.String r3 = "org.joda.time."
            boolean r3 = r6.startsWith(r3)     // Catch:{ all -> 0x0161 }
            if (r3 == 0) goto L_0x0163
            java.lang.String r11 = "org.joda.time.DateTime"
            java.lang.String r12 = "org.joda.time.LocalDate"
            java.lang.String r13 = "org.joda.time.LocalDateTime"
            java.lang.String r14 = "org.joda.time.LocalTime"
            java.lang.String r15 = "org.joda.time.Instant"
            java.lang.String r16 = "org.joda.time.Period"
            java.lang.String r17 = "org.joda.time.Duration"
            java.lang.String r18 = "org.joda.time.DateTimeZone"
            java.lang.String r19 = "org.joda.time.format.DateTimeFormatter"
            java.lang.String[] r3 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19}     // Catch:{ all -> 0x0161 }
            r7 = 0
        L_0x0148:
            r8 = 9
            if (r7 >= r8) goto L_0x0163
            r8 = r3[r7]     // Catch:{ all -> 0x0161 }
            boolean r11 = r8.equals(r6)     // Catch:{ all -> 0x0161 }
            if (r11 == 0) goto L_0x015e
            java.lang.Class r3 = java.lang.Class.forName(r8)     // Catch:{ all -> 0x0161 }
            com.alibaba.fastjson.serializer.JodaCodec r4 = com.alibaba.fastjson.serializer.JodaCodec.instance     // Catch:{ all -> 0x0161 }
            r0.putDeserializer(r3, r4)     // Catch:{ all -> 0x0161 }
            return r4
        L_0x015e:
            int r7 = r7 + 1
            goto L_0x0148
        L_0x0161:
            jodaError = r10
        L_0x0163:
            boolean r3 = guavaError
            if (r3 != 0) goto L_0x0198
            java.lang.String r3 = "com.google.common.collect."
            boolean r3 = r6.startsWith(r3)
            if (r3 == 0) goto L_0x0198
            java.lang.String r3 = "com.google.common.collect.HashMultimap"
            java.lang.String r7 = "com.google.common.collect.LinkedListMultimap"
            java.lang.String r8 = "com.google.common.collect.LinkedHashMultimap"
            java.lang.String r11 = "com.google.common.collect.ArrayListMultimap"
            java.lang.String r12 = "com.google.common.collect.TreeMultimap"
            java.lang.String[] r3 = new java.lang.String[]{r3, r7, r8, r11, r12}     // Catch:{ ClassNotFoundException -> 0x0196 }
            r7 = 0
        L_0x017e:
            r8 = 5
            if (r7 >= r8) goto L_0x0198
            r8 = r3[r7]     // Catch:{ ClassNotFoundException -> 0x0196 }
            boolean r11 = r8.equals(r6)     // Catch:{ ClassNotFoundException -> 0x0196 }
            if (r11 == 0) goto L_0x0193
            java.lang.Class r3 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0196 }
            com.alibaba.fastjson.serializer.GuavaCodec r4 = com.alibaba.fastjson.serializer.GuavaCodec.instance     // Catch:{ ClassNotFoundException -> 0x0196 }
            r0.putDeserializer(r3, r4)     // Catch:{ ClassNotFoundException -> 0x0196 }
            return r4
        L_0x0193:
            int r7 = r7 + 1
            goto L_0x017e
        L_0x0196:
            guavaError = r10
        L_0x0198:
            java.lang.String r3 = "java.nio.ByteBuffer"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01a5
            com.alibaba.fastjson.serializer.ByteBufferCodec r4 = com.alibaba.fastjson.serializer.ByteBufferCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x01a5:
            java.lang.String r3 = "java.nio.file.Path"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01b2
            com.alibaba.fastjson.serializer.MiscCodec r4 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x01b2:
            java.lang.Class<java.util.Map$Entry> r3 = java.util.Map.Entry.class
            if (r1 != r3) goto L_0x01bb
            com.alibaba.fastjson.serializer.MiscCodec r4 = com.alibaba.fastjson.serializer.MiscCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x01bb:
            java.lang.String r3 = "org.javamoney.moneta.Money"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01c8
            com.alibaba.fastjson.support.moneta.MonetaCodec r4 = com.alibaba.fastjson.support.moneta.MonetaCodec.instance
            r0.putDeserializer(r1, r4)
        L_0x01c8:
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r3 = r3.getContextClassLoader()
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer> r6 = com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer.class
            java.util.Set r3 = com.alibaba.fastjson.util.ServiceLoader.load(r6, (java.lang.ClassLoader) r3)     // Catch:{ Exception -> 0x01fe }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x01fe }
        L_0x01da:
            boolean r6 = r3.hasNext()     // Catch:{ Exception -> 0x01fe }
            if (r6 == 0) goto L_0x01ff
            java.lang.Object r6 = r3.next()     // Catch:{ Exception -> 0x01fe }
            com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer r6 = (com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer) r6     // Catch:{ Exception -> 0x01fe }
            java.util.Set r7 = r6.getAutowiredFor()     // Catch:{ Exception -> 0x01fe }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x01fe }
        L_0x01ee:
            boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x01fe }
            if (r8 == 0) goto L_0x01da
            java.lang.Object r8 = r7.next()     // Catch:{ Exception -> 0x01fe }
            java.lang.reflect.Type r8 = (java.lang.reflect.Type) r8     // Catch:{ Exception -> 0x01fe }
            r0.putDeserializer(r8, r6)     // Catch:{ Exception -> 0x01fe }
            goto L_0x01ee
        L_0x01fe:
        L_0x01ff:
            if (r4 != 0) goto L_0x0205
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = r0.get(r2)
        L_0x0205:
            if (r4 == 0) goto L_0x0208
            return r4
        L_0x0208:
            boolean r3 = r24.isEnum()
            if (r3 == 0) goto L_0x0279
            boolean r3 = r0.jacksonCompatible
            if (r3 == 0) goto L_0x022c
            java.lang.reflect.Method[] r3 = r24.getMethods()
            int r4 = r3.length
        L_0x0217:
            if (r9 >= r4) goto L_0x022c
            r6 = r3[r9]
            boolean r6 = com.alibaba.fastjson.util.TypeUtils.isJacksonCreator(r6)
            if (r6 == 0) goto L_0x0229
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r0.createJavaBeanDeserializer(r1, r2)
            r0.putDeserializer(r2, r1)
            return r1
        L_0x0229:
            int r9 = r9 + 1
            goto L_0x0217
        L_0x022c:
            java.lang.reflect.Type r3 = com.alibaba.fastjson.JSON.getMixInAnnotations(r24)
            java.lang.Class r3 = (java.lang.Class) r3
            if (r3 == 0) goto L_0x0236
            r4 = r3
            goto L_0x0237
        L_0x0236:
            r4 = r1
        L_0x0237:
            java.lang.annotation.Annotation r4 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r4, r5)
            com.alibaba.fastjson.annotation.JSONType r4 = (com.alibaba.fastjson.annotation.JSONType) r4
            if (r4 == 0) goto L_0x024e
            java.lang.Class r4 = r4.deserializer()
            java.lang.Object r4 = r4.newInstance()     // Catch:{ all -> 0x024d }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r4 = (com.alibaba.fastjson.parser.deserializer.ObjectDeserializer) r4     // Catch:{ all -> 0x024d }
            r0.putDeserializer(r1, r4)     // Catch:{ all -> 0x024d }
            return r4
        L_0x024d:
        L_0x024e:
            if (r3 == 0) goto L_0x0265
            java.lang.reflect.Method r3 = getEnumCreator(r3, r1)
            if (r3 == 0) goto L_0x0263
            java.lang.String r4 = r3.getName()     // Catch:{ Exception -> 0x0263 }
            java.lang.Class[] r3 = r3.getParameterTypes()     // Catch:{ Exception -> 0x0263 }
            java.lang.reflect.Method r3 = r1.getMethod(r4, r3)     // Catch:{ Exception -> 0x0263 }
            goto L_0x0269
        L_0x0263:
            r3 = 0
            goto L_0x0269
        L_0x0265:
            java.lang.reflect.Method r3 = getEnumCreator(r1, r1)
        L_0x0269:
            if (r3 == 0) goto L_0x0274
            com.alibaba.fastjson.parser.deserializer.EnumCreatorDeserializer r2 = new com.alibaba.fastjson.parser.deserializer.EnumCreatorDeserializer
            r2.<init>(r3)
            r0.putDeserializer(r1, r2)
            return r2
        L_0x0274:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r23.getEnumDeserializer(r24)
            goto L_0x02d6
        L_0x0279:
            boolean r3 = r24.isArray()
            if (r3 == 0) goto L_0x0282
            com.alibaba.fastjson.serializer.ObjectArrayCodec r1 = com.alibaba.fastjson.serializer.ObjectArrayCodec.instance
            goto L_0x02d6
        L_0x0282:
            java.lang.Class<java.util.Set> r3 = java.util.Set.class
            if (r1 == r3) goto L_0x02d4
            java.lang.Class<java.util.HashSet> r3 = java.util.HashSet.class
            if (r1 == r3) goto L_0x02d4
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            if (r1 == r3) goto L_0x02d4
            java.lang.Class<java.util.List> r4 = java.util.List.class
            if (r1 == r4) goto L_0x02d4
            java.lang.Class<java.util.ArrayList> r4 = java.util.ArrayList.class
            if (r1 != r4) goto L_0x0297
            goto L_0x02d4
        L_0x0297:
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x02a0
            com.alibaba.fastjson.serializer.CollectionCodec r1 = com.alibaba.fastjson.serializer.CollectionCodec.instance
            goto L_0x02d6
        L_0x02a0:
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x02ab
            com.alibaba.fastjson.parser.deserializer.MapDeserializer r1 = com.alibaba.fastjson.parser.deserializer.MapDeserializer.instance
            goto L_0x02d6
        L_0x02ab:
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x02ba
            com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer r3 = new com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer
            r3.<init>(r0, r1)
        L_0x02b8:
            r1 = r3
            goto L_0x02d6
        L_0x02ba:
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.PropertyProcessable> r3 = com.alibaba.fastjson.parser.deserializer.PropertyProcessable.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x02c8
            com.alibaba.fastjson.parser.deserializer.PropertyProcessableDeserializer r3 = new com.alibaba.fastjson.parser.deserializer.PropertyProcessableDeserializer
            r3.<init>(r1)
            goto L_0x02b8
        L_0x02c8:
            java.lang.Class<java.net.InetAddress> r3 = java.net.InetAddress.class
            if (r1 != r3) goto L_0x02cf
            com.alibaba.fastjson.serializer.MiscCodec r1 = com.alibaba.fastjson.serializer.MiscCodec.instance
            goto L_0x02d6
        L_0x02cf:
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r0.createJavaBeanDeserializer(r1, r2)
            goto L_0x02d6
        L_0x02d4:
            com.alibaba.fastjson.serializer.CollectionCodec r1 = com.alibaba.fastjson.serializer.CollectionCodec.instance
        L_0x02d6:
            r0.putDeserializer(r2, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ParserConfig.getDeserializer(java.lang.Class, java.lang.reflect.Type):com.alibaba.fastjson.parser.deserializer.ObjectDeserializer");
    }

    public ObjectDeserializer getDeserializer(FieldInfo fieldInfo) {
        return getDeserializer(fieldInfo.fieldClass, fieldInfo.fieldType);
    }
}
