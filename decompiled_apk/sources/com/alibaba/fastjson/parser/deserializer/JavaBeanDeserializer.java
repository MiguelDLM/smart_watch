package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    private final ParserConfig.AutoTypeCheckHandler autoTypeCheckHandler;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private Map<String, FieldDeserializer> fieldDeserializerMap;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] hashArray;
    private transient short[] hashArrayMapping;
    private transient long[] smartMatchHashArray;
    private transient short[] smartMatchHashArrayMapping;
    protected final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    private Object createFactoryInstance(ParserConfig parserConfig, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        return this.beanInfo.factoryMethod.invoke(null, obj);
    }

    public static JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public static boolean isSetFlag(int i, int[] iArr) {
        int i2;
        if (iArr == null || (i2 = i / 32) >= iArr.length) {
            return false;
        }
        if (((1 << (i % 32)) & iArr[i2]) == 0) {
            return false;
        }
        return true;
    }

    public static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
        int i = jSONLexerBase.token();
        if (i == 8) {
            jSONLexerBase.nextToken(16);
            jSONLexerBase.token();
            return;
        }
        if (i != 14) {
            defaultJSONParser.throwException(i);
        }
        if (jSONLexerBase.getCurrent() == '[') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(14);
        } else {
            jSONLexerBase.nextToken(14);
        }
        if (jSONLexerBase.token() == 15) {
            jSONLexerBase.nextToken();
            return;
        }
        int i2 = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i2)));
            i2++;
            if (jSONLexerBase.token() != 16) {
                break;
            }
            if (jSONLexerBase.getCurrent() == '[') {
                jSONLexerBase.next();
                jSONLexerBase.setToken(14);
            } else {
                jSONLexerBase.nextToken(14);
            }
        }
        int i3 = jSONLexerBase.token();
        if (i3 != 15) {
            defaultJSONParser.throwException(i3);
        }
        if (jSONLexerBase.getCurrent() == ',') {
            jSONLexerBase.next();
            jSONLexerBase.setToken(16);
        } else {
            jSONLexerBase.nextToken(16);
        }
    }

    public void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() == i) {
        } else {
            throw new JSONException("syntax error");
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object newInstance;
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo.defaultConstructor;
        Object obj = null;
        if (constructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        Method method = javaBeanInfo.factoryMethod;
        if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            if (javaBeanInfo.defaultConstructorParameterSize != 0) {
                ParseContext context = defaultJSONParser.getContext();
                if (context != null && context.object != null) {
                    if (type instanceof Class) {
                        String name = ((Class) type).getName();
                        String substring = name.substring(0, name.lastIndexOf(36));
                        Object obj2 = context.object;
                        String name2 = obj2.getClass().getName();
                        if (!name2.equals(substring)) {
                            ParseContext parseContext = context.parent;
                            if (parseContext == null || parseContext.object == null || !("java.util.ArrayList".equals(name2) || "java.util.List".equals(name2) || "java.util.Collection".equals(name2) || "java.util.Map".equals(name2) || "java.util.HashMap".equals(name2))) {
                                obj = obj2;
                            } else if (parseContext.object.getClass().getName().equals(substring)) {
                                obj = parseContext.object;
                            }
                            obj2 = obj;
                        }
                        if (obj2 != null && (!(obj2 instanceof Collection) || !((Collection) obj2).isEmpty())) {
                            newInstance = constructor.newInstance(obj2);
                        } else {
                            throw new JSONException("can't create non-static inner class instance.");
                        }
                    } else {
                        throw new JSONException("can't create non-static inner class instance.");
                    }
                } else {
                    throw new JSONException("can't create non-static inner class instance.");
                }
            } else if (constructor != null) {
                newInstance = constructor.newInstance(null);
            } else {
                newInstance = method.invoke(null, null);
            }
            if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                for (FieldInfo fieldInfo : this.beanInfo.fields) {
                    if (fieldInfo.fieldClass == String.class) {
                        try {
                            fieldInfo.set(newInstance, "");
                        } catch (Exception e) {
                            throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                        }
                    }
                }
            }
            return newInstance;
        } catch (JSONException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e3);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        char c;
        Enum<?> scanEnum;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            String scanTypeName = jSONLexer.scanTypeName(defaultJSONParser.symbolTable);
            if (scanTypeName != null) {
                ObjectDeserializer seeAlso = getSeeAlso(defaultJSONParser.getConfig(), this.beanInfo, scanTypeName);
                if (seeAlso == null) {
                    seeAlso = defaultJSONParser.getConfig().getDeserializer(defaultJSONParser.getConfig().checkAutoType(scanTypeName, TypeUtils.getClass(type), jSONLexer.getFeatures()));
                }
                if (seeAlso instanceof JavaBeanDeserializer) {
                    return (T) ((JavaBeanDeserializer) seeAlso).deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                }
            }
            T t = (T) createInstance(defaultJSONParser, type);
            int length = this.sortedFieldDeserializers.length;
            int i = 0;
            while (true) {
                int i2 = 16;
                if (i >= length) {
                    break;
                }
                if (i == length - 1) {
                    c = ']';
                } else {
                    c = ',';
                }
                FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i];
                Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                if (cls == Integer.TYPE) {
                    fieldDeserializer.setValue((Object) t, jSONLexer.scanInt(c));
                } else if (cls == String.class) {
                    fieldDeserializer.setValue((Object) t, jSONLexer.scanString(c));
                } else if (cls == Long.TYPE) {
                    fieldDeserializer.setValue(t, jSONLexer.scanLong(c));
                } else if (cls.isEnum()) {
                    char current = jSONLexer.getCurrent();
                    if (current != '\"' && current != 'n') {
                        if (current >= '0' && current <= '9') {
                            scanEnum = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c));
                        } else {
                            scanEnum = scanEnum(jSONLexer, c);
                        }
                    } else {
                        scanEnum = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c);
                    }
                    fieldDeserializer.setValue(t, scanEnum);
                } else if (cls == Boolean.TYPE) {
                    fieldDeserializer.setValue(t, jSONLexer.scanBoolean(c));
                } else if (cls == Float.TYPE) {
                    fieldDeserializer.setValue(t, Float.valueOf(jSONLexer.scanFloat(c)));
                } else if (cls == Double.TYPE) {
                    fieldDeserializer.setValue(t, Double.valueOf(jSONLexer.scanDouble(c)));
                } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                    fieldDeserializer.setValue(t, new Date(jSONLexer.scanLong(c)));
                } else if (cls == BigDecimal.class) {
                    fieldDeserializer.setValue(t, jSONLexer.scanDecimal(c));
                } else {
                    jSONLexer.nextToken(14);
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldInfo.fieldType, fieldInfo.name));
                    if (jSONLexer.token() == 15) {
                        break;
                    }
                    if (c == ']') {
                        i2 = 15;
                    }
                    check(jSONLexer, i2);
                }
                i++;
            }
            jSONLexer.nextToken(16);
            return t;
        }
        throw new JSONException("error");
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, null);
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, null);
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    public Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean, parserConfig.isJacksonCompatible()));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return (T) deserialze(defaultJSONParser, type, obj, null, i, null);
    }

    public FieldDeserializer getFieldDeserializer(String str, int[] iArr) {
        FieldDeserializer fieldDeserializer;
        if (str == null) {
            return null;
        }
        Map<String, FieldDeserializer> map = this.fieldDeserializerMap;
        if (map != null && (fieldDeserializer = map.get(str)) != null) {
            return fieldDeserializer;
        }
        int length = this.sortedFieldDeserializers.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int compareTo = this.sortedFieldDeserializers[i2].fieldInfo.name.compareTo(str);
            if (compareTo < 0) {
                i = i2 + 1;
            } else {
                if (compareTo <= 0) {
                    if (isSetFlag(i2, iArr)) {
                        return null;
                    }
                    return this.sortedFieldDeserializers[i2];
                }
                length = i2 - 1;
            }
        }
        Map<String, FieldDeserializer> map2 = this.alterNameFieldDeserializers;
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARN: Type inference failed for: r19v0, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean parseField(com.alibaba.fastjson.parser.DefaultJSONParser r22, java.lang.String r23, java.lang.Object r24, java.lang.reflect.Type r25, java.util.Map<java.lang.String, java.lang.Object> r26, int[] r27) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.parseField(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.util.Map, int[]):boolean");
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i, int[] iArr) {
        return deserialze(defaultJSONParser, type, obj, obj2, i, iArr);
    }

    public Enum scanEnum(JSONLexerBase jSONLexerBase, char[] cArr, ObjectDeserializer objectDeserializer) {
        EnumDeserializer enumDeserializer = objectDeserializer instanceof EnumDeserializer ? (EnumDeserializer) objectDeserializer : null;
        if (enumDeserializer == null) {
            jSONLexerBase.matchStat = -1;
            return null;
        }
        long scanEnumSymbol = jSONLexerBase.scanEnumSymbol(cArr);
        if (jSONLexerBase.matchStat <= 0) {
            return null;
        }
        Enum enumByHashCode = enumDeserializer.getEnumByHashCode(scanEnumSymbol);
        if (enumByHashCode == null) {
            if (scanEnumSymbol == TypeUtils.fnv1a_64_magic_hashcode) {
                return null;
            }
            if (jSONLexerBase.isEnabled(Feature.ErrorOnEnumNotMatch)) {
                throw new JSONException("not match enum value, " + enumDeserializer.enumClass);
            }
        }
        return enumByHashCode;
    }

    public FieldDeserializer smartMatch(String str, int[] iArr) {
        boolean z;
        if (str == null) {
            return null;
        }
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str, iArr);
        if (fieldDeserializer == null) {
            int i = 0;
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i2 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i2 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i2] = fieldDeserializerArr[i2].fieldInfo.nameHashCode;
                    i2++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_lower(str));
            if (binarySearch < 0) {
                binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_extract(str));
            }
            if (binarySearch < 0) {
                z = str.startsWith("is");
                if (z) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv1a_64_extract(str.substring(2)));
                }
            } else {
                z = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    short[] sArr = new short[this.smartMatchHashArray.length];
                    Arrays.fill(sArr, (short) -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, fieldDeserializerArr2[i].fieldInfo.nameHashCode);
                        if (binarySearch2 >= 0) {
                            sArr[binarySearch2] = (short) i;
                        }
                        i++;
                    }
                    this.smartMatchHashArrayMapping = sArr;
                }
                short s = this.smartMatchHashArrayMapping[binarySearch];
                if (s != -1 && !isSetFlag(s, iArr)) {
                    fieldDeserializer = this.sortedFieldDeserializers[s];
                }
            }
            if (fieldDeserializer != null) {
                FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                if ((fieldInfo.parserFeatures & Feature.DisableFieldSmartMatch.mask) != 0) {
                    return null;
                }
                Class<?> cls = fieldInfo.fieldClass;
                if (z && cls != Boolean.TYPE && cls != Boolean.class) {
                    return null;
                }
            }
        }
        return fieldDeserializer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x03aa, code lost:
    
        if (r11.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas) != false) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0974, code lost:
    
        r14.object = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0504, code lost:
    
        if (r2 != null) goto L390;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0506, code lost:
    
        r1 = r6.checkAutoType(r0, r1, r11.getFeatures());
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x0518, code lost:
    
        r2 = r1;
        r1 = r34.getConfig().getDeserializer(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x051f, code lost:
    
        r2 = (T) r1.deserialze(r34, r2, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0525, code lost:
    
        if ((r1 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L401;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0527, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0529, code lost:
    
        if (r14 == null) goto L401;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x052b, code lost:
    
        r1 = r1.getFieldDeserializer(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x052f, code lost:
    
        if (r1 == null) goto L401;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0531, code lost:
    
        r1.setValue((java.lang.Object) r2, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0534, code lost:
    
        if (r4 == null) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0536, code lost:
    
        r4.object = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x053a, code lost:
    
        r34.setContext(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x053d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x050f, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x039c, code lost:
    
        r5 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x054e, code lost:
    
        r29 = r5;
        r0 = r17;
        r13 = r30;
        r39 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x06ec, code lost:
    
        if (r29 != null) goto L654;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x08f4, code lost:
    
        r1 = (T) r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x08f6, code lost:
    
        r0 = r33.beanInfo.buildMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x08fa, code lost:
    
        if (r0 != null) goto L661;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x08fc, code lost:
    
        if (r4 == null) goto L659;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x08fe, code lost:
    
        r4.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0900, code lost:
    
        r34.setContext(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0903, code lost:
    
        return (T) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0905, code lost:
    
        r0 = (T) r0.invoke(r1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0909, code lost:
    
        if (r4 == null) goto L665;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x090b, code lost:
    
        r4.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x090d, code lost:
    
        r34.setContext(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0910, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0911, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x091a, code lost:
    
        throw new com.alibaba.fastjson.JSONException("build object error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x06ee, code lost:
    
        if (r0 != null) goto L512;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x06f0, code lost:
    
        r1 = (T) createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r34, r35);
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x06f4, code lost:
    
        if (r4 != null) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x06f6, code lost:
    
        r4 = r34.setContext(r15, r1, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x06fa, code lost:
    
        if (r4 == null) goto L508;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x06fc, code lost:
    
        r4.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x06fe, code lost:
    
        r34.setContext(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0701, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0705, code lost:
    
        r1 = r33.beanInfo;
        r2 = r1.creatorConstructorParameters;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x070b, code lost:
    
        if (r2 == null) goto L562;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x070d, code lost:
    
        r1 = new java.lang.Object[r2.length];
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0712, code lost:
    
        if (r5 >= r2.length) goto L745;
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x0714, code lost:
    
        r6 = r0.remove(r2[r5]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x071a, code lost:
    
        if (r6 != null) goto L546;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x071c, code lost:
    
        r7 = r33.beanInfo;
        r10 = r7.creatorConstructorParameterTypes[r5];
        r7 = r7.fields[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x0728, code lost:
    
        if (r10 != java.lang.Byte.TYPE) goto L523;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x072a, code lost:
    
        r6 = java.lang.Byte.valueOf(r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x07a5, code lost:
    
        r1[r5] = r6;
        r5 = r5 + 1;
        r39 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0731, code lost:
    
        if (r10 != java.lang.Short.TYPE) goto L526;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0733, code lost:
    
        r6 = java.lang.Short.valueOf(r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x073a, code lost:
    
        if (r10 != java.lang.Integer.TYPE) goto L529;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x073c, code lost:
    
        r6 = java.lang.Integer.valueOf(r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0743, code lost:
    
        if (r10 != java.lang.Long.TYPE) goto L532;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0745, code lost:
    
        r6 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x074c, code lost:
    
        if (r10 != java.lang.Float.TYPE) goto L535;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x074e, code lost:
    
        r6 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0755, code lost:
    
        if (r10 != java.lang.Double.TYPE) goto L538;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0757, code lost:
    
        r6 = java.lang.Double.valueOf(XIXIX.OOXIXo.f3760XO);
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x075e, code lost:
    
        if (r10 != java.lang.Boolean.TYPE) goto L541;
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x0760, code lost:
    
        r6 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0763, code lost:
    
        if (r10 != r13) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x076c, code lost:
    
        if ((r7.parserFeatures & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x076e, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x0771, code lost:
    
        r7 = r33.beanInfo.creatorConstructorParameterTypes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0775, code lost:
    
        if (r7 == null) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0778, code lost:
    
        if (r5 >= r7.length) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x077a, code lost:
    
        r7 = r7[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x077e, code lost:
    
        if ((r7 instanceof java.lang.Class) == false) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0780, code lost:
    
        r7 = (java.lang.Class) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0786, code lost:
    
        if (r7.isInstance(r6) != false) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x078a, code lost:
    
        if ((r6 instanceof java.util.List) == false) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x078c, code lost:
    
        r10 = (java.util.List) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0794, code lost:
    
        if (r10.size() != 1) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x079f, code lost:
    
        if (r7.isInstance(r10.get(0)) == false) goto L748;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x07a1, code lost:
    
        r6 = r10.get(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0815, code lost:
    
        r3 = r33.beanInfo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0819, code lost:
    
        if (r3.creatorConstructor == null) goto L642;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x081d, code lost:
    
        if (r3.f5143kotlin == false) goto L631;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x081f, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x0821, code lost:
    
        if (r3 >= r1.length) goto L749;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0825, code lost:
    
        if (r1[r3] != null) goto L751;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x0827, code lost:
    
        r5 = r33.beanInfo;
        r6 = r5.fields;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x082b, code lost:
    
        if (r6 == null) goto L752;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x082e, code lost:
    
        if (r3 >= r6.length) goto L753;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x0834, code lost:
    
        if (r6[r3].fieldClass != r13) goto L631;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0836, code lost:
    
        r3 = r5.kotlinDefaultConstructor;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0838, code lost:
    
        if (r3 == null) goto L631;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x083a, code lost:
    
        r3 = r3.newInstance(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x083f, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x0841, code lost:
    
        if (r5 >= r1.length) goto L754;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x0843, code lost:
    
        r6 = r1[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0845, code lost:
    
        if (r6 == null) goto L755;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x0847, code lost:
    
        r7 = r33.beanInfo.fields;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x084b, code lost:
    
        if (r7 == null) goto L756;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x084e, code lost:
    
        if (r5 >= r7.length) goto L757;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x0850, code lost:
    
        r7[r5].set(r3, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x085c, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x085f, code lost:
    
        r1 = (T) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0870, code lost:
    
        if (r2 == null) goto L652;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0872, code lost:
    
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x087e, code lost:
    
        if (r0.hasNext() == false) goto L760;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0880, code lost:
    
        r2 = r0.next();
        r3 = getFieldDeserializer(r2.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x0890, code lost:
    
        if (r3 == null) goto L762;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x0892, code lost:
    
        r3.setValue(r1, r2.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x08ef, code lost:
    
        if (r4 == null) goto L655;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x08f1, code lost:
    
        r4.object = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x085a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x08c0, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r2 + ", " + r33.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x0856, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0857, code lost:
    
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0861, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0862, code lost:
    
        r3 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0865, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x0868, code lost:
    
        r1 = r33.beanInfo.creatorConstructor.newInstance(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x08c1, code lost:
    
        r0 = r3.factoryMethod;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x08c3, code lost:
    
        if (r0 == null) goto L651;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x08ca, code lost:
    
        r1 = r0.invoke(null, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x08cc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x08ec, code lost:
    
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r33.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:417:0x08ed, code lost:
    
        r1 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x07ad, code lost:
    
        r1 = r1.fields;
        r5 = r1.length;
        r6 = new java.lang.Object[r5];
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:419:0x07b4, code lost:
    
        if (r7 >= r5) goto L764;
     */
    /* JADX WARN: Code restructure failed: missing block: B:420:0x07b6, code lost:
    
        r10 = r1[r7];
        r12 = r0.get(r10.name);
     */
    /* JADX WARN: Code restructure failed: missing block: B:421:0x07be, code lost:
    
        if (r12 != null) goto L766;
     */
    /* JADX WARN: Code restructure failed: missing block: B:422:0x07c0, code lost:
    
        r14 = r10.fieldType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:423:0x07c4, code lost:
    
        if (r14 != java.lang.Byte.TYPE) goto L569;
     */
    /* JADX WARN: Code restructure failed: missing block: B:424:0x07c6, code lost:
    
        r12 = (byte) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:426:0x080e, code lost:
    
        r6[r7] = r12;
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x07ce, code lost:
    
        if (r14 != java.lang.Short.TYPE) goto L572;
     */
    /* JADX WARN: Code restructure failed: missing block: B:429:0x07d0, code lost:
    
        r12 = (short) 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:432:0x07d8, code lost:
    
        if (r14 != java.lang.Integer.TYPE) goto L575;
     */
    /* JADX WARN: Code restructure failed: missing block: B:433:0x07da, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:436:0x07e2, code lost:
    
        if (r14 != java.lang.Long.TYPE) goto L578;
     */
    /* JADX WARN: Code restructure failed: missing block: B:437:0x07e4, code lost:
    
        r12 = 0L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:440:0x07eb, code lost:
    
        if (r14 != java.lang.Float.TYPE) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:441:0x07ed, code lost:
    
        r12 = java.lang.Float.valueOf(0.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x07f4, code lost:
    
        if (r14 != java.lang.Double.TYPE) goto L584;
     */
    /* JADX WARN: Code restructure failed: missing block: B:445:0x07f6, code lost:
    
        r12 = java.lang.Double.valueOf(XIXIX.OOXIXo.f3760XO);
     */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x07fd, code lost:
    
        if (r14 != java.lang.Boolean.TYPE) goto L587;
     */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x07ff, code lost:
    
        r12 = java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:451:0x0802, code lost:
    
        if (r14 != r13) goto L774;
     */
    /* JADX WARN: Code restructure failed: missing block: B:453:0x080b, code lost:
    
        if ((r10.parserFeatures & com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty.mask) == 0) goto L775;
     */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x080d, code lost:
    
        r12 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:460:0x0814, code lost:
    
        r1 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:461:0x0702, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:462:0x0703, code lost:
    
        r14 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:514:0x0960, code lost:
    
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r11.token()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:518:0x06e8, code lost:
    
        r0 = r20;
        r4 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:602:0x01f3, code lost:
    
        if (r7 == (-2)) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:741:0x0374, code lost:
    
        if (r7 == (-2)) goto L147;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0974  */
    /* JADX WARN: Removed duplicated region for block: B:483:0x059a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:495:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x06df A[Catch: all -> 0x06bf, TryCatch #18 {all -> 0x06bf, blocks: (B:144:0x0930, B:500:0x06d5, B:505:0x06df, B:517:0x06e5, B:508:0x091d, B:510:0x0925, B:513:0x0942, B:514:0x0960, B:561:0x06af, B:563:0x06b5, B:567:0x06bb, B:568:0x06cd, B:571:0x0961, B:572:0x0968), top: B:143:0x0930 }] */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0651 A[Catch: all -> 0x0605, TryCatch #3 {all -> 0x0605, blocks: (B:498:0x05ec, B:525:0x060c, B:528:0x0651, B:529:0x065f, B:536:0x0616, B:538:0x061a, B:540:0x061e, B:542:0x0622, B:544:0x0626, B:546:0x062a, B:549:0x0632, B:551:0x063a, B:553:0x0641, B:555:0x0646, B:556:0x064c, B:559:0x0687), top: B:497:0x05ec }] */
    /* JADX WARN: Removed duplicated region for block: B:531:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x0664 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:534:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:557:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:588:0x058b  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.alibaba.fastjson.parser.ParseContext] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r2v43, types: [com.alibaba.fastjson.parser.deserializer.ObjectDeserializer] */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.alibaba.fastjson.parser.DefaultJSONParser] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r34, java.lang.reflect.Type r35, java.lang.Object r36, java.lang.Object r37, int r38, int[] r39) {
        /*
            Method dump skipped, instructions count: 2431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0078 A[LOOP:2: B:27:0x0076->B:28:0x0078, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public JavaBeanDeserializer(com.alibaba.fastjson.parser.ParserConfig r10, com.alibaba.fastjson.util.JavaBeanInfo r11) {
        /*
            r9 = this;
            r9.<init>()
            java.lang.Class<?> r0 = r11.clazz
            r9.clazz = r0
            r9.beanInfo = r11
            com.alibaba.fastjson.annotation.JSONType r0 = r11.jsonType
            r1 = 0
            if (r0 == 0) goto L23
            java.lang.Class r0 = r0.autoTypeCheckHandler()
            java.lang.Class<com.alibaba.fastjson.parser.ParserConfig$AutoTypeCheckHandler> r2 = com.alibaba.fastjson.parser.ParserConfig.AutoTypeCheckHandler.class
            if (r0 == r2) goto L23
            com.alibaba.fastjson.annotation.JSONType r0 = r11.jsonType     // Catch: java.lang.Exception -> L23
            java.lang.Class r0 = r0.autoTypeCheckHandler()     // Catch: java.lang.Exception -> L23
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.Exception -> L23
            com.alibaba.fastjson.parser.ParserConfig$AutoTypeCheckHandler r0 = (com.alibaba.fastjson.parser.ParserConfig.AutoTypeCheckHandler) r0     // Catch: java.lang.Exception -> L23
            goto L24
        L23:
            r0 = r1
        L24:
            r9.autoTypeCheckHandler = r0
            com.alibaba.fastjson.util.FieldInfo[] r0 = r11.sortedFields
            int r2 = r0.length
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r2 = new com.alibaba.fastjson.parser.deserializer.FieldDeserializer[r2]
            r9.sortedFieldDeserializers = r2
            int r0 = r0.length
            r2 = 0
            r3 = 0
        L30:
            if (r3 >= r0) goto L6c
            com.alibaba.fastjson.util.FieldInfo[] r4 = r11.sortedFields
            r4 = r4[r3]
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r5 = r10.createFieldDeserializer(r10, r11, r4)
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r6 = r9.sortedFieldDeserializers
            r6[r3] = r5
            r6 = 128(0x80, float:1.8E-43)
            if (r0 <= r6) goto L54
            java.util.Map<java.lang.String, com.alibaba.fastjson.parser.deserializer.FieldDeserializer> r6 = r9.fieldDeserializerMap
            if (r6 != 0) goto L4d
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r9.fieldDeserializerMap = r6
        L4d:
            java.util.Map<java.lang.String, com.alibaba.fastjson.parser.deserializer.FieldDeserializer> r6 = r9.fieldDeserializerMap
            java.lang.String r7 = r4.name
            r6.put(r7, r5)
        L54:
            java.lang.String[] r4 = r4.alternateNames
            int r6 = r4.length
            r7 = 0
        L58:
            if (r7 >= r6) goto L69
            r8 = r4[r7]
            if (r1 != 0) goto L63
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
        L63:
            r1.put(r8, r5)
            int r7 = r7 + 1
            goto L58
        L69:
            int r3 = r3 + 1
            goto L30
        L6c:
            r9.alterNameFieldDeserializers = r1
            com.alibaba.fastjson.util.FieldInfo[] r10 = r11.fields
            int r0 = r10.length
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r0 = new com.alibaba.fastjson.parser.deserializer.FieldDeserializer[r0]
            r9.fieldDeserializers = r0
            int r10 = r10.length
        L76:
            if (r2 >= r10) goto L89
            com.alibaba.fastjson.util.FieldInfo[] r0 = r11.fields
            r0 = r0[r2]
            java.lang.String r0 = r0.name
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r0 = r9.getFieldDeserializer(r0)
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r1 = r9.fieldDeserializers
            r1[r2] = r0
            int r2 = r2 + 1
            goto L76
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.<init>(com.alibaba.fastjson.parser.ParserConfig, com.alibaba.fastjson.util.JavaBeanInfo):void");
    }

    public FieldDeserializer getFieldDeserializer(long j) {
        int i = 0;
        if (this.hashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i2 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i2 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i2] = TypeUtils.fnv1a_64(fieldDeserializerArr[i2].fieldInfo.name);
                i2++;
            }
            Arrays.sort(jArr);
            this.hashArray = jArr;
        }
        int binarySearch = Arrays.binarySearch(this.hashArray, j);
        if (binarySearch < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            short[] sArr = new short[this.hashArray.length];
            Arrays.fill(sArr, (short) -1);
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i >= fieldDeserializerArr2.length) {
                    break;
                }
                int binarySearch2 = Arrays.binarySearch(this.hashArray, TypeUtils.fnv1a_64(fieldDeserializerArr2[i].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    sArr[binarySearch2] = (short) i;
                }
                i++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[binarySearch];
        if (s != -1) {
            return this.sortedFieldDeserializers[s];
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x00b0, code lost:
    
        r7.setLong(r0, ((java.lang.Number) r1).longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x009b, code lost:
    
        if ((r1 instanceof java.lang.Number) == false) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x009d, code lost:
    
        r7.setInt(r0, ((java.lang.Number) r1).intValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0087, code lost:
    
        if (r1 != java.lang.Boolean.FALSE) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x008f, code lost:
    
        if (r1 != java.lang.Boolean.TRUE) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0091, code lost:
    
        r7.setBoolean(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0089, code lost:
    
        r7.setBoolean(r0, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0067, code lost:
    
        if (com.alibaba.fastjson.JSONValidator.from(r6).validate() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        if (r6.method != null) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
    
        r9 = r7.getType();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
    
        if (r9 != java.lang.Boolean.TYPE) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0097, code lost:
    
        if (r9 != java.lang.Integer.TYPE) goto L223;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00aa, code lost:
    
        if (r9 != java.lang.Long.TYPE) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bf, code lost:
    
        if (r9 != java.lang.Float.TYPE) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ec, code lost:
    
        if (r9 != java.lang.Double.TYPE) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0117, code lost:
    
        if (r1 == null) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011d, code lost:
    
        if (r8 != r1.getClass()) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x011f, code lost:
    
        r7.set(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f0, code lost:
    
        if ((r1 instanceof java.lang.Number) == false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f2, code lost:
    
        r7.setDouble(r0, ((java.lang.Number) r1).doubleValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ff, code lost:
    
        if ((r1 instanceof java.lang.String) == false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0101, code lost:
    
        r1 = (java.lang.String) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0107, code lost:
    
        if (r1.length() > 10) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0109, code lost:
    
        r5 = com.alibaba.fastjson.util.TypeUtils.parseDouble(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0112, code lost:
    
        r7.setDouble(r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x010e, code lost:
    
        r5 = java.lang.Double.parseDouble(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00c3, code lost:
    
        if ((r1 instanceof java.lang.Number) == false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00c5, code lost:
    
        r7.setFloat(r0, ((java.lang.Number) r1).floatValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00d2, code lost:
    
        if ((r1 instanceof java.lang.String) == false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00d4, code lost:
    
        r1 = (java.lang.String) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00da, code lost:
    
        if (r1.length() > 10) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00dc, code lost:
    
        r1 = com.alibaba.fastjson.util.TypeUtils.parseFloat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00e5, code lost:
    
        r7.setFloat(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00e1, code lost:
    
        r1 = java.lang.Float.parseFloat(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00ae, code lost:
    
        if ((r1 instanceof java.lang.Number) == false) goto L227;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object createInstance(java.util.Map<java.lang.String, java.lang.Object> r13, com.alibaba.fastjson.parser.ParserConfig r14) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.createInstance(java.util.Map, com.alibaba.fastjson.parser.ParserConfig):java.lang.Object");
    }
}
