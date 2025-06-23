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
        return this.beanInfo.factoryMethod.invoke((Object) null, new Object[]{obj});
    }

    public static JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class deserializer : jSONType.seeAlso()) {
            ObjectDeserializer deserializer2 = parserConfig.getDeserializer((Type) deserializer);
            if (deserializer2 instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer2;
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
        if (((1 << (i % 32)) & iArr[i2]) != 0) {
            return true;
        }
        return false;
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
            } else if (jSONLexerBase.getCurrent() == '[') {
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
            return;
        }
        jSONLexerBase.nextToken(16);
    }

    public void check(JSONLexer jSONLexer, int i) {
        if (jSONLexer.token() != i) {
            throw new JSONException("syntax error");
        }
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object obj;
        if (!(type instanceof Class) || !this.clazz.isInterface()) {
            JavaBeanInfo javaBeanInfo = this.beanInfo;
            Constructor<?> constructor = javaBeanInfo.defaultConstructor;
            Object obj2 = null;
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
                    if (context != null) {
                        if (context.object != null) {
                            if (type instanceof Class) {
                                String name = ((Class) type).getName();
                                String substring = name.substring(0, name.lastIndexOf(36));
                                Object obj3 = context.object;
                                String name2 = obj3.getClass().getName();
                                if (!name2.equals(substring)) {
                                    ParseContext parseContext = context.parent;
                                    if (parseContext == null || parseContext.object == null || (!"java.util.ArrayList".equals(name2) && !"java.util.List".equals(name2) && !"java.util.Collection".equals(name2) && !"java.util.Map".equals(name2) && !"java.util.HashMap".equals(name2))) {
                                        obj2 = obj3;
                                    } else if (parseContext.object.getClass().getName().equals(substring)) {
                                        obj2 = parseContext.object;
                                    }
                                    obj3 = obj2;
                                }
                                if (obj3 == null || ((obj3 instanceof Collection) && ((Collection) obj3).isEmpty())) {
                                    throw new JSONException("can't create non-static inner class instance.");
                                }
                                obj = constructor.newInstance(new Object[]{obj3});
                            } else {
                                throw new JSONException("can't create non-static inner class instance.");
                            }
                        }
                    }
                    throw new JSONException("can't create non-static inner class instance.");
                } else if (constructor != null) {
                    obj = constructor.newInstance((Object[]) null);
                } else {
                    obj = method.invoke((Object) null, (Object[]) null);
                }
                if (defaultJSONParser != null && defaultJSONParser.lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            try {
                                fieldInfo.set(obj, "");
                            } catch (Exception e) {
                                throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                            }
                        }
                    }
                }
                return obj;
            } catch (JSONException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e3);
            }
        } else {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser, type, obj, 0);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        char c;
        Enum<?> enumR;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 14) {
            String scanTypeName = jSONLexer.scanTypeName(defaultJSONParser.symbolTable);
            if (scanTypeName != null) {
                Object seeAlso = getSeeAlso(defaultJSONParser.getConfig(), this.beanInfo, scanTypeName);
                if (seeAlso == null) {
                    seeAlso = defaultJSONParser.getConfig().getDeserializer((Type) defaultJSONParser.getConfig().checkAutoType(scanTypeName, TypeUtils.getClass(type), jSONLexer.getFeatures()));
                }
                if (seeAlso instanceof JavaBeanDeserializer) {
                    return ((JavaBeanDeserializer) seeAlso).deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                }
            }
            T createInstance = createInstance(defaultJSONParser, type);
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
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanInt(c));
                } else if (cls == String.class) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanString(c));
                } else if (cls == Long.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanLong(c));
                } else if (cls.isEnum()) {
                    char current = jSONLexer.getCurrent();
                    if (current == '\"' || current == 'n') {
                        enumR = jSONLexer.scanEnum(cls, defaultJSONParser.getSymbolTable(), c);
                    } else if (current < '0' || current > '9') {
                        enumR = scanEnum(jSONLexer, c);
                    } else {
                        enumR = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.getConfig())).valueOf(jSONLexer.scanInt(c));
                    }
                    fieldDeserializer.setValue((Object) createInstance, (Object) enumR);
                } else if (cls == Boolean.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, jSONLexer.scanBoolean(c));
                } else if (cls == Float.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, (Object) Float.valueOf(jSONLexer.scanFloat(c)));
                } else if (cls == Double.TYPE) {
                    fieldDeserializer.setValue((Object) createInstance, (Object) Double.valueOf(jSONLexer.scanDouble(c)));
                } else if (cls == Date.class && jSONLexer.getCurrent() == '1') {
                    fieldDeserializer.setValue((Object) createInstance, (Object) new Date(jSONLexer.scanLong(c)));
                } else if (cls == BigDecimal.class) {
                    fieldDeserializer.setValue((Object) createInstance, (Object) jSONLexer.scanDecimal(c));
                } else {
                    jSONLexer.nextToken(14);
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    fieldDeserializer.setValue((Object) createInstance, defaultJSONParser.parseObject(fieldInfo.fieldType, (Object) fieldInfo.name));
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
            return createInstance;
        }
        throw new JSONException("error");
    }

    public int getFastMatchToken() {
        return 12;
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return getFieldDeserializer(str, (int[]) null);
    }

    public Type getFieldType(int i) {
        return this.sortedFieldDeserializers[i].fieldInfo.fieldType;
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        return parseField(defaultJSONParser, str, obj, type, map, (int[]) null);
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, int i) {
        return parseRest(defaultJSONParser, type, obj, obj2, i, new int[0]);
    }

    public Enum<?> scanEnum(JSONLexer jSONLexer, char c) {
        throw new JSONException("illegal enum. " + jSONLexer.info());
    }

    public FieldDeserializer smartMatch(String str) {
        return smartMatch(str, (int[]) null);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, JavaBeanInfo.build(cls, type, parserConfig.propertyNamingStrategy, parserConfig.fieldBased, parserConfig.compatibleWithJavaBean, parserConfig.isJacksonCompatible()));
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, int i) {
        return deserialze(defaultJSONParser, type, obj, (Object) null, i, (int[]) null);
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
            } else if (compareTo > 0) {
                length = i2 - 1;
            } else if (isSetFlag(i2, iArr)) {
                return null;
            } else {
                return this.sortedFieldDeserializers[i2];
            }
        }
        Map<String, FieldDeserializer> map2 = this.alterNameFieldDeserializers;
        if (map2 != null) {
            return map2.get(str);
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r19v3 */
    /* JADX WARNING: type inference failed for: r19v4 */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean parseField(com.alibaba.fastjson.parser.DefaultJSONParser r22, java.lang.String r23, java.lang.Object r24, java.lang.reflect.Type r25, java.util.Map<java.lang.String, java.lang.Object> r26, int[] r27) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r11 = r23
            r12 = r24
            r13 = r25
            r14 = r26
            r15 = r27
            r16 = 0
            r9 = 1
            com.alibaba.fastjson.parser.JSONLexer r8 = r0.lexer
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.DisableFieldSmartMatch
            int r2 = r2.mask
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty
            int r3 = r3.mask
            boolean r4 = r8.isEnabled((int) r2)
            if (r4 != 0) goto L_0x0041
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r1.beanInfo
            int r4 = r4.parserFeatures
            r2 = r2 & r4
            if (r2 == 0) goto L_0x0029
            goto L_0x0041
        L_0x0029:
            boolean r2 = r8.isEnabled((int) r3)
            if (r2 != 0) goto L_0x003c
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r1.beanInfo
            int r2 = r2.parserFeatures
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0037
            goto L_0x003c
        L_0x0037:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r2 = r1.smartMatch(r11, r15)
            goto L_0x0045
        L_0x003c:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r2 = r1.smartMatch(r11)
            goto L_0x0045
        L_0x0041:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r2 = r1.getFieldDeserializer((java.lang.String) r11)
        L_0x0045:
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.SupportNonPublicField
            int r3 = r3.mask
            if (r2 != 0) goto L_0x0059
            boolean r4 = r8.isEnabled((int) r3)
            if (r4 != 0) goto L_0x0061
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r1.beanInfo
            int r4 = r4.parserFeatures
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0059
            goto L_0x0061
        L_0x0059:
            r18 = r2
        L_0x005b:
            r20 = r8
            r19 = 1
            goto L_0x0123
        L_0x0061:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> r3 = r1.extraFieldDeserializers
            if (r3 != 0) goto L_0x00d1
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap
            r4 = 1061158912(0x3f400000, float:0.75)
            r3.<init>(r9, r4, r9)
            java.lang.Class<?> r4 = r1.clazz
        L_0x006e:
            if (r4 == 0) goto L_0x00cc
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            if (r4 == r5) goto L_0x00cc
            java.lang.reflect.Field[] r5 = r4.getDeclaredFields()
            int r6 = r5.length
            r7 = 0
        L_0x007a:
            if (r7 >= r6) goto L_0x00c4
            r10 = r5[r7]
            java.lang.String r9 = r10.getName()
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r18 = r1.getFieldDeserializer((java.lang.String) r9)
            if (r18 == 0) goto L_0x008e
        L_0x0088:
            r18 = r2
            r19 = r5
        L_0x008c:
            r2 = 1
            goto L_0x00bd
        L_0x008e:
            int r18 = r10.getModifiers()
            r19 = r18 & 16
            if (r19 != 0) goto L_0x0088
            r18 = r18 & 8
            if (r18 == 0) goto L_0x009b
            goto L_0x0088
        L_0x009b:
            r18 = r2
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r2 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r2 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r10, r2)
            com.alibaba.fastjson.annotation.JSONField r2 = (com.alibaba.fastjson.annotation.JSONField) r2
            if (r2 == 0) goto L_0x00b7
            java.lang.String r2 = r2.name()
            r19 = r5
            java.lang.String r5 = ""
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x00b9
            r9 = r2
            goto L_0x00b9
        L_0x00b7:
            r19 = r5
        L_0x00b9:
            r3.put(r9, r10)
            goto L_0x008c
        L_0x00bd:
            int r7 = r7 + r2
            r2 = r18
            r5 = r19
            r9 = 1
            goto L_0x007a
        L_0x00c4:
            r18 = r2
            java.lang.Class r4 = r4.getSuperclass()
            r9 = 1
            goto L_0x006e
        L_0x00cc:
            r18 = r2
            r1.extraFieldDeserializers = r3
            goto L_0x00d3
        L_0x00d1:
            r18 = r2
        L_0x00d3:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> r2 = r1.extraFieldDeserializers
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L_0x005b
            boolean r3 = r2 instanceof com.alibaba.fastjson.parser.deserializer.FieldDeserializer
            if (r3 == 0) goto L_0x00e6
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r2 = (com.alibaba.fastjson.parser.deserializer.FieldDeserializer) r2
            r20 = r8
            r19 = 1
            goto L_0x0125
        L_0x00e6:
            r7 = r2
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            r9 = 1
            r7.setAccessible(r9)
            com.alibaba.fastjson.util.FieldInfo r10 = new com.alibaba.fastjson.util.FieldInfo
            java.lang.Class r4 = r7.getDeclaringClass()
            java.lang.Class r5 = r7.getType()
            java.lang.reflect.Type r6 = r7.getGenericType()
            r17 = 0
            r18 = 0
            r19 = 0
            r2 = r10
            r3 = r23
            r20 = r8
            r8 = r19
            r19 = 1
            r9 = r17
            r15 = r10
            r10 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r2 = new com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer
            com.alibaba.fastjson.parser.ParserConfig r3 = r22.getConfig()
            java.lang.Class<?> r4 = r1.clazz
            r2.<init>(r3, r4, r15)
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> r3 = r1.extraFieldDeserializers
            r3.put(r11, r2)
            goto L_0x0125
        L_0x0123:
            r2 = r18
        L_0x0125:
            r3 = -1
            if (r2 != 0) goto L_0x021e
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.IgnoreNotMatch
            r4 = r20
            boolean r2 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r2)
            if (r2 == 0) goto L_0x01f9
            r2 = 0
            r5 = -1
        L_0x0134:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r6 = r1.sortedFieldDeserializers
            int r7 = r6.length
            if (r2 >= r7) goto L_0x01e3
            r6 = r6[r2]
            com.alibaba.fastjson.util.FieldInfo r7 = r6.fieldInfo
            boolean r8 = r7.unwrapped
            if (r8 == 0) goto L_0x01b8
            boolean r8 = r6 instanceof com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer
            if (r8 == 0) goto L_0x01b8
            java.lang.reflect.Field r8 = r7.field
            java.lang.String r9 = "parse unwrapped field error."
            if (r8 == 0) goto L_0x01ba
            r8 = r6
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r8 = (com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer) r8
            com.alibaba.fastjson.parser.ParserConfig r10 = r22.getConfig()
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r10 = r8.getFieldValueDeserilizer(r10)
            boolean r15 = r10 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer
            if (r15 == 0) goto L_0x018a
            r15 = r10
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r15 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r15
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r15 = r15.getFieldDeserializer((java.lang.String) r11)
            if (r15 == 0) goto L_0x01b8
            java.lang.reflect.Field r5 = r7.field     // Catch:{ Exception -> 0x0177 }
            java.lang.Object r5 = r5.get(r12)     // Catch:{ Exception -> 0x0177 }
            if (r5 != 0) goto L_0x0179
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r10 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r10     // Catch:{ Exception -> 0x0177 }
            java.lang.reflect.Type r5 = r7.fieldType     // Catch:{ Exception -> 0x0177 }
            java.lang.Object r5 = r10.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r0, (java.lang.reflect.Type) r5)     // Catch:{ Exception -> 0x0177 }
            r6.setValue((java.lang.Object) r12, (java.lang.Object) r5)     // Catch:{ Exception -> 0x0177 }
            goto L_0x0179
        L_0x0177:
            r0 = move-exception
            goto L_0x0184
        L_0x0179:
            int r6 = r8.getFastMatchToken()     // Catch:{ Exception -> 0x0177 }
            r4.nextTokenWithColon(r6)     // Catch:{ Exception -> 0x0177 }
            r15.parseField(r0, r5, r13, r14)     // Catch:{ Exception -> 0x0177 }
            goto L_0x01b0
        L_0x0184:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            r2.<init>(r9, r0)
            throw r2
        L_0x018a:
            boolean r8 = r10 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer
            if (r8 == 0) goto L_0x01b8
            com.alibaba.fastjson.parser.deserializer.MapDeserializer r10 = (com.alibaba.fastjson.parser.deserializer.MapDeserializer) r10
            java.lang.reflect.Field r5 = r7.field     // Catch:{ Exception -> 0x01a4 }
            java.lang.Object r5 = r5.get(r12)     // Catch:{ Exception -> 0x01a4 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x01a4 }
            if (r5 != 0) goto L_0x01a6
            java.lang.reflect.Type r5 = r7.fieldType     // Catch:{ Exception -> 0x01a4 }
            java.util.Map r5 = r10.createMap(r5)     // Catch:{ Exception -> 0x01a4 }
            r6.setValue((java.lang.Object) r12, (java.lang.Object) r5)     // Catch:{ Exception -> 0x01a4 }
            goto L_0x01a6
        L_0x01a4:
            r0 = move-exception
            goto L_0x01b2
        L_0x01a6:
            r4.nextTokenWithColon()     // Catch:{ Exception -> 0x01a4 }
            java.lang.Object r6 = r22.parse(r23)     // Catch:{ Exception -> 0x01a4 }
            r5.put(r11, r6)     // Catch:{ Exception -> 0x01a4 }
        L_0x01b0:
            r5 = r2
            goto L_0x01b8
        L_0x01b2:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            r2.<init>(r9, r0)
            throw r2
        L_0x01b8:
            r8 = 2
            goto L_0x01df
        L_0x01ba:
            java.lang.reflect.Method r6 = r7.method
            java.lang.Class[] r6 = r6.getParameterTypes()
            int r6 = r6.length
            r8 = 2
            if (r6 != r8) goto L_0x01df
            r4.nextTokenWithColon()
            java.lang.Object r5 = r22.parse(r23)
            java.lang.reflect.Method r6 = r7.method     // Catch:{ Exception -> 0x01d8 }
            java.lang.Object[] r7 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x01d8 }
            r7[r16] = r11     // Catch:{ Exception -> 0x01d8 }
            r7[r19] = r5     // Catch:{ Exception -> 0x01d8 }
            r6.invoke(r12, r7)     // Catch:{ Exception -> 0x01d8 }
            r5 = r2
            goto L_0x01df
        L_0x01d8:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            r2.<init>(r9, r0)
            throw r2
        L_0x01df:
            int r2 = r2 + 1
            goto L_0x0134
        L_0x01e3:
            if (r5 == r3) goto L_0x01f5
            r6 = r27
            if (r6 == 0) goto L_0x01f4
            int r0 = r5 / 32
            int r5 = r5 % 32
            r2 = r6[r0]
            int r3 = r19 << r5
            r2 = r2 | r3
            r6[r0] = r2
        L_0x01f4:
            return r19
        L_0x01f5:
            r0.parseExtra(r12, r11)
            return r16
        L_0x01f9:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "setter not found, class "
            r2.append(r3)
            java.lang.Class<?> r3 = r1.clazz
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            java.lang.String r3 = ", property "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x021e:
            r6 = r27
            r4 = r20
            r5 = 0
        L_0x0223:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r7 = r1.sortedFieldDeserializers
            int r8 = r7.length
            if (r5 >= r8) goto L_0x0230
            r7 = r7[r5]
            if (r7 != r2) goto L_0x022d
            goto L_0x0231
        L_0x022d:
            int r5 = r5 + 1
            goto L_0x0223
        L_0x0230:
            r5 = -1
        L_0x0231:
            if (r5 == r3) goto L_0x0247
            if (r6 == 0) goto L_0x0247
            java.lang.String r3 = "_"
            boolean r3 = r11.startsWith(r3)
            if (r3 == 0) goto L_0x0247
            boolean r3 = isSetFlag(r5, r6)
            if (r3 == 0) goto L_0x0247
            r0.parseExtra(r12, r11)
            return r16
        L_0x0247:
            int r3 = r2.getFastMatchToken()
            r4.nextTokenWithColon(r3)
            r2.parseField(r0, r12, r13, r14)
            if (r6 == 0) goto L_0x025e
            int r0 = r5 / 32
            int r5 = r5 % 32
            r2 = r6[r0]
            int r3 = r19 << r5
            r2 = r2 | r3
            r6[r0] = r2
        L_0x025e:
            return r19
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
                    Arrays.fill(sArr, -1);
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
                if (!(!z || cls == Boolean.TYPE || cls == Boolean.class)) {
                    return null;
                }
            }
        }
        return fieldDeserializer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:159:0x01f3, code lost:
        if (r7 == -2) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0374, code lost:
        if (r7 == -2) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x03aa, code lost:
        if (r11.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas) != false) goto L_0x02e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:?, code lost:
        r11.nextTokenWithColon(4);
        r0 = r11.token();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x03c0, code lost:
        if (r0 != 4) goto L_0x0471;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x03c2, code lost:
        r0 = r11.stringVal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x03cc, code lost:
        if ("@".equals(r0) == false) goto L_0x03d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x03ce, code lost:
        r1 = r15.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x03db, code lost:
        if ("..".equals(r0) == false) goto L_0x03f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x03dd, code lost:
        r1 = r15.parent;
        r2 = r1.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x03e1, code lost:
        if (r2 == null) goto L_0x03e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x03e3, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x03e5, code lost:
        r9.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r9.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x03f7, code lost:
        if ("$".equals(r0) == false) goto L_0x0411;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x03f9, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x03fa, code lost:
        r2 = r1.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x03fc, code lost:
        if (r2 == null) goto L_0x0400;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x03fe, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x0400, code lost:
        r2 = r1.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x0402, code lost:
        if (r2 == null) goto L_0x0405;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x0405, code lost:
        r9.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r9.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x0417, code lost:
        if (r0.indexOf(92) <= 0) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x0419, code lost:
        r2 = new java.lang.StringBuilder();
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x0423, code lost:
        if (r3 >= r0.length()) goto L_0x0437;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x0425, code lost:
        r5 = r0.charAt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x0429, code lost:
        if (r5 != '\\') goto L_0x0431;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x042b, code lost:
        r3 = r3 + 1;
        r5 = r0.charAt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x0431, code lost:
        r2.append(r5);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x0437, code lost:
        r0 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x043b, code lost:
        r1 = r9.resolveReference(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x043f, code lost:
        if (r1 == null) goto L_0x0442;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x0442, code lost:
        r9.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r15, r0));
        r9.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x044d, code lost:
        r1 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:?, code lost:
        r11.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x0457, code lost:
        if (r11.token() != 13) goto L_0x0469;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x0459, code lost:
        r11.nextToken(16);
        r9.setContext(r15, r1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x0461, code lost:
        if (r4 == null) goto L_0x0465;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x0463, code lost:
        r4.object = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x0465, code lost:
        r9.setContext(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x0468, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x0470, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x048b, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x0518, code lost:
        r2 = r1;
        r1 = r34.getConfig().getDeserializer((java.lang.reflect.Type) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:?, code lost:
        r2 = r1.deserialze(r9, r2, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x0525, code lost:
        if ((r1 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L_0x0534;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:?, code lost:
        r1 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:416:0x0529, code lost:
        if (r14 == null) goto L_0x0534;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x052b, code lost:
        r1 = r1.getFieldDeserializer(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x052f, code lost:
        if (r1 == null) goto L_0x0534;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:0x0531, code lost:
        r1.setValue((java.lang.Object) r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:420:0x0534, code lost:
        if (r4 == null) goto L_0x053a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x0536, code lost:
        r4.object = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:0x053a, code lost:
        r9.setContext(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:423:0x053d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:524:0x06e8, code lost:
        r0 = r20;
        r4 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:536:0x0702, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:537:0x0703, code lost:
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:635:0x0834, code lost:
        if (r6[r3].fieldClass != r13) goto L_0x0868;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:637:?, code lost:
        r3 = (r5 = r8.beanInfo).kotlinDefaultConstructor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:638:0x0838, code lost:
        if (r3 == null) goto L_0x0868;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:639:0x083a, code lost:
        r3 = r3.newInstance((java.lang.Object[]) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:640:0x083f, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:643:0x0841, code lost:
        if (r5 >= r1.length) goto L_0x085f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:644:0x0843, code lost:
        r6 = r1[r5];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:645:0x0845, code lost:
        if (r6 == null) goto L_0x085c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:646:0x0847, code lost:
        r7 = r8.beanInfo.fields;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:647:0x084b, code lost:
        if (r7 == null) goto L_0x085c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:649:0x084e, code lost:
        if (r5 >= r7.length) goto L_0x085c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:650:0x0850, code lost:
        r7[r5].set(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:651:0x0856, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:652:0x0857, code lost:
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:653:0x085a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:654:0x085c, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:655:0x085f, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:656:0x0861, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:657:0x0862, code lost:
        r3 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:671:0x08c0, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error, " + r2 + ", " + r8.beanInfo.creatorConstructor.toGenericString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:679:0x08cc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:683:0x08ec, code lost:
        throw new com.alibaba.fastjson.JSONException("create factory method error, " + r8.beanInfo.factoryMethod.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:716:0x0960, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r11.token()));
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:527:0x06f0, B:676:0x08c6] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x049b A[Catch:{ all -> 0x053e }] */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0584  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x058b  */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x059a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:460:0x05e8  */
    /* JADX WARNING: Removed duplicated region for block: B:494:0x0651 A[Catch:{ all -> 0x0605 }] */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x065e A[Catch:{ all -> 0x0605 }] */
    /* JADX WARNING: Removed duplicated region for block: B:499:0x066d A[Catch:{ all -> 0x0605 }] */
    /* JADX WARNING: Removed duplicated region for block: B:500:0x067f A[Catch:{ all -> 0x0605 }] */
    /* JADX WARNING: Removed duplicated region for block: B:520:0x06dd A[Catch:{ all -> 0x06bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:521:0x06df A[Catch:{ all -> 0x06bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:662:0x0872 A[SYNTHETIC, Splitter:B:662:0x0872] */
    /* JADX WARNING: Removed duplicated region for block: B:724:0x0974  */
    /* JADX WARNING: Removed duplicated region for block: B:731:0x0664 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r34, java.lang.reflect.Type r35, java.lang.Object r36, java.lang.Object r37, int r38, int[] r39) {
        /*
            r33 = this;
            r8 = r33
            r9 = r34
            r0 = r35
            r10 = r36
            java.lang.Class<com.alibaba.fastjson.JSON> r1 = com.alibaba.fastjson.JSON.class
            if (r0 == r1) goto L_0x097a
            java.lang.Class<com.alibaba.fastjson.JSONObject> r1 = com.alibaba.fastjson.JSONObject.class
            if (r0 != r1) goto L_0x0012
            goto L_0x097a
        L_0x0012:
            com.alibaba.fastjson.parser.JSONLexer r1 = r9.lexer
            r11 = r1
            com.alibaba.fastjson.parser.JSONLexerBase r11 = (com.alibaba.fastjson.parser.JSONLexerBase) r11
            com.alibaba.fastjson.parser.ParserConfig r12 = r34.getConfig()
            int r1 = r11.token()
            r2 = 8
            r13 = 16
            r14 = 0
            if (r1 != r2) goto L_0x002a
            r11.nextToken(r13)
            return r14
        L_0x002a:
            com.alibaba.fastjson.parser.ParseContext r2 = r34.getContext()
            if (r37 == 0) goto L_0x0034
            if (r2 == 0) goto L_0x0034
            com.alibaba.fastjson.parser.ParseContext r2 = r2.parent
        L_0x0034:
            r15 = r2
            r7 = 13
            if (r1 != r7) goto L_0x004e
            r11.nextToken(r13)     // Catch:{ all -> 0x0043 }
            if (r37 != 0) goto L_0x0048
            java.lang.Object r0 = r33.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r34, (java.lang.reflect.Type) r35)     // Catch:{ all -> 0x0043 }
            goto L_0x004a
        L_0x0043:
            r0 = move-exception
            r5 = r37
            goto L_0x0972
        L_0x0048:
            r0 = r37
        L_0x004a:
            r9.setContext(r15)
            return r0
        L_0x004e:
            r2 = 14
            if (r1 != r2) goto L_0x006f
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean     // Catch:{ all -> 0x0043 }
            int r4 = r3.mask     // Catch:{ all -> 0x0043 }
            com.alibaba.fastjson.util.JavaBeanInfo r5 = r8.beanInfo     // Catch:{ all -> 0x0043 }
            int r5 = r5.parserFeatures     // Catch:{ all -> 0x0043 }
            r5 = r5 & r4
            if (r5 != 0) goto L_0x0067
            boolean r3 = r11.isEnabled((com.alibaba.fastjson.parser.Feature) r3)     // Catch:{ all -> 0x0043 }
            if (r3 != 0) goto L_0x0067
            r3 = r38 & r4
            if (r3 == 0) goto L_0x006f
        L_0x0067:
            java.lang.Object r0 = r33.deserialzeArrayMapping(r34, r35, r36, r37)     // Catch:{ all -> 0x0043 }
            r9.setContext(r15)
            return r0
        L_0x006f:
            r3 = 12
            java.lang.Class<java.lang.Integer> r6 = java.lang.Integer.class
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r7 = 4
            if (r1 == r3) goto L_0x015c
            if (r1 == r13) goto L_0x015c
            boolean r0 = r11.isBlankInput()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0084
            r9.setContext(r15)
            return r14
        L_0x0084:
            if (r1 != r7) goto L_0x00c1
            java.lang.String r0 = r11.stringVal()     // Catch:{ all -> 0x00b7 }
            int r3 = r0.length()     // Catch:{ all -> 0x00b7 }
            if (r3 != 0) goto L_0x0097
            r11.nextToken()     // Catch:{ all -> 0x0043 }
            r9.setContext(r15)
            return r14
        L_0x0097:
            com.alibaba.fastjson.util.JavaBeanInfo r3 = r8.beanInfo     // Catch:{ all -> 0x00b7 }
            com.alibaba.fastjson.annotation.JSONType r3 = r3.jsonType     // Catch:{ all -> 0x00b7 }
            if (r3 == 0) goto L_0x00c1
            java.lang.Class[] r3 = r3.seeAlso()     // Catch:{ all -> 0x00b7 }
            int r13 = r3.length     // Catch:{ all -> 0x00b7 }
            r7 = 0
        L_0x00a3:
            if (r7 >= r13) goto L_0x00c1
            r4 = r3[r7]     // Catch:{ all -> 0x00b7 }
            java.lang.Class<java.lang.Enum> r14 = java.lang.Enum.class
            boolean r14 = r14.isAssignableFrom(r4)     // Catch:{ all -> 0x00b7 }
            if (r14 == 0) goto L_0x00bd
            java.lang.Enum r0 = java.lang.Enum.valueOf(r4, r0)     // Catch:{ IllegalArgumentException -> 0x00bd }
            r9.setContext(r15)
            return r0
        L_0x00b7:
            r0 = move-exception
            r5 = r37
            r14 = 0
            goto L_0x0972
        L_0x00bd:
            int r7 = r7 + 1
            r14 = 0
            goto L_0x00a3
        L_0x00c1:
            if (r1 != r2) goto L_0x00d6
            char r0 = r11.getCurrent()     // Catch:{ all -> 0x00b7 }
            r2 = 93
            if (r0 != r2) goto L_0x00d6
            r11.next()     // Catch:{ all -> 0x00b7 }
            r11.nextToken()     // Catch:{ all -> 0x00b7 }
            r9.setContext(r15)
            r1 = 0
            return r1
        L_0x00d6:
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r8.beanInfo     // Catch:{ all -> 0x00b7 }
            java.lang.reflect.Method r2 = r0.factoryMethod     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x011f
            com.alibaba.fastjson.util.FieldInfo[] r0 = r0.fields     // Catch:{ all -> 0x00b7 }
            int r2 = r0.length     // Catch:{ all -> 0x00b7 }
            r3 = 1
            if (r2 != r3) goto L_0x011f
            r2 = 0
            r0 = r0[r2]     // Catch:{ Exception -> 0x00ff }
            java.lang.Class<?> r0 = r0.fieldClass     // Catch:{ Exception -> 0x00ff }
            if (r0 != r6) goto L_0x0101
            r2 = 2
            if (r1 != r2) goto L_0x011f
            int r0 = r11.intValue()     // Catch:{ Exception -> 0x00ff }
            r11.nextToken()     // Catch:{ Exception -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00ff }
            java.lang.Object r0 = r8.createFactoryInstance(r12, r0)     // Catch:{ Exception -> 0x00ff }
            r9.setContext(r15)
            return r0
        L_0x00ff:
            r0 = move-exception
            goto L_0x0115
        L_0x0101:
            if (r0 != r5) goto L_0x011f
            r0 = 4
            if (r1 != r0) goto L_0x011f
            java.lang.String r0 = r11.stringVal()     // Catch:{ Exception -> 0x00ff }
            r11.nextToken()     // Catch:{ Exception -> 0x00ff }
            java.lang.Object r0 = r8.createFactoryInstance(r12, r0)     // Catch:{ Exception -> 0x00ff }
            r9.setContext(r15)
            return r0
        L_0x0115:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00b7 }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x00b7 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x00b7 }
            throw r1     // Catch:{ all -> 0x00b7 }
        L_0x011f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            r0.<init>()     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = "syntax error, expect {, actual "
            r0.append(r1)     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = r11.tokenName()     // Catch:{ all -> 0x00b7 }
            r0.append(r1)     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = ", pos "
            r0.append(r1)     // Catch:{ all -> 0x00b7 }
            int r1 = r11.pos()     // Catch:{ all -> 0x00b7 }
            r0.append(r1)     // Catch:{ all -> 0x00b7 }
            boolean r1 = r10 instanceof java.lang.String     // Catch:{ all -> 0x00b7 }
            if (r1 == 0) goto L_0x0148
            java.lang.String r1 = ", fieldName "
            r0.append(r1)     // Catch:{ all -> 0x00b7 }
            r0.append(r10)     // Catch:{ all -> 0x00b7 }
        L_0x0148:
            java.lang.String r1 = ", fastjson-version "
            r0.append(r1)     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = "1.2.83"
            r0.append(r1)     // Catch:{ all -> 0x00b7 }
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x00b7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b7 }
            r1.<init>(r0)     // Catch:{ all -> 0x00b7 }
            throw r1     // Catch:{ all -> 0x00b7 }
        L_0x015c:
            int r1 = r9.resolveStatus     // Catch:{ all -> 0x096d }
            r2 = 2
            if (r1 != r2) goto L_0x0165
            r4 = 0
            r9.resolveStatus = r4     // Catch:{ all -> 0x00b7 }
            goto L_0x0166
        L_0x0165:
            r4 = 0
        L_0x0166:
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x096d }
            java.lang.String r14 = r1.typeKey     // Catch:{ all -> 0x096d }
            r1 = r37
            r2 = r39
            r3 = 0
            r4 = 0
            r7 = 0
            r17 = 0
        L_0x0173:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r13 = r8.sortedFieldDeserializers     // Catch:{ all -> 0x0969 }
            int r0 = r13.length     // Catch:{ all -> 0x0969 }
            if (r7 >= r0) goto L_0x01a5
            r0 = 16
            if (r3 >= r0) goto L_0x01a5
            r0 = r13[r7]     // Catch:{ all -> 0x019c }
            com.alibaba.fastjson.util.FieldInfo r13 = r0.fieldInfo     // Catch:{ all -> 0x019c }
            r37 = r7
            java.lang.Class<?> r7 = r13.fieldClass     // Catch:{ all -> 0x019c }
            com.alibaba.fastjson.annotation.JSONField r21 = r13.getAnnotation()     // Catch:{ all -> 0x019c }
            if (r21 == 0) goto L_0x01a1
            r39 = r7
            boolean r7 = r0 instanceof com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer     // Catch:{ all -> 0x019c }
            if (r7 == 0) goto L_0x01a3
            r7 = r0
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r7 = (com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer) r7     // Catch:{ all -> 0x019c }
            boolean r7 = r7.customDeserilizer     // Catch:{ all -> 0x019c }
        L_0x0195:
            r32 = r2
            r2 = r39
            r39 = r32
            goto L_0x01af
        L_0x019c:
            r0 = move-exception
            r5 = r1
        L_0x019e:
            r14 = r4
            goto L_0x0972
        L_0x01a1:
            r39 = r7
        L_0x01a3:
            r7 = 0
            goto L_0x0195
        L_0x01a5:
            r37 = r7
            r39 = r2
            r0 = 0
            r2 = 0
            r7 = 0
            r13 = 0
            r21 = 0
        L_0x01af:
            r22 = 0
            r24 = 0
            r25 = 0
            if (r0 == 0) goto L_0x0378
            r27 = r1
            char[] r1 = r13.name_chars     // Catch:{ all -> 0x01ca }
            if (r7 == 0) goto L_0x01d0
            boolean r7 = r11.matchField((char[]) r1)     // Catch:{ all -> 0x01ca }
            if (r7 == 0) goto L_0x01d0
            r28 = r12
        L_0x01c5:
            r1 = 0
            r7 = 1
        L_0x01c7:
            r12 = 0
            goto L_0x037f
        L_0x01ca:
            r0 = move-exception
            r14 = r4
            r5 = r27
            goto L_0x0972
        L_0x01d0:
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ all -> 0x01ca }
            r28 = r12
            r12 = -2
            if (r2 == r7) goto L_0x035c
            if (r2 != r6) goto L_0x01db
            goto L_0x035c
        L_0x01db:
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch:{ all -> 0x01ca }
            if (r2 == r7) goto L_0x033e
            java.lang.Class<java.lang.Long> r7 = java.lang.Long.class
            if (r2 != r7) goto L_0x01e5
            goto L_0x033e
        L_0x01e5:
            if (r2 != r5) goto L_0x0213
            java.lang.String r1 = r11.scanFieldString(r1)     // Catch:{ all -> 0x01ca }
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x01f3
        L_0x01ef:
            r7 = 1
            r12 = 1
            goto L_0x037f
        L_0x01f3:
            if (r7 != r12) goto L_0x0211
        L_0x01f5:
            int r3 = r3 + 1
            r12 = r35
            r30 = r37
            r19 = r3
            r13 = r5
            r20 = r17
            r21 = r28
            r0 = 13
            r1 = 0
            r2 = 16
            r3 = 0
            r5 = 1
            r18 = 4
            r17 = r39
            r28 = r6
            goto L_0x0930
        L_0x0211:
            r7 = 0
            goto L_0x01c7
        L_0x0213:
            java.lang.Class<java.util.Date> r7 = java.util.Date.class
            if (r2 != r7) goto L_0x0227
            java.lang.String r7 = r13.format     // Catch:{ all -> 0x01ca }
            if (r7 != 0) goto L_0x0227
            java.util.Date r1 = r11.scanFieldDate(r1)     // Catch:{ all -> 0x01ca }
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x0224
            goto L_0x01ef
        L_0x0224:
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x0227:
            java.lang.Class<java.math.BigDecimal> r7 = java.math.BigDecimal.class
            if (r2 != r7) goto L_0x0237
            java.math.BigDecimal r1 = r11.scanFieldDecimal(r1)     // Catch:{ all -> 0x01ca }
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x0234
            goto L_0x01ef
        L_0x0234:
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x0237:
            java.lang.Class<java.math.BigInteger> r7 = java.math.BigInteger.class
            if (r2 != r7) goto L_0x0247
            java.math.BigInteger r1 = r11.scanFieldBigInteger(r1)     // Catch:{ all -> 0x01ca }
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x0244
            goto L_0x01ef
        L_0x0244:
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x0247:
            java.lang.Class r7 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x01ca }
            if (r2 == r7) goto L_0x0324
            java.lang.Class<java.lang.Boolean> r7 = java.lang.Boolean.class
            if (r2 != r7) goto L_0x0251
            goto L_0x0324
        L_0x0251:
            java.lang.Class r7 = java.lang.Float.TYPE     // Catch:{ all -> 0x01ca }
            if (r2 == r7) goto L_0x0306
            java.lang.Class<java.lang.Float> r7 = java.lang.Float.class
            if (r2 != r7) goto L_0x025b
            goto L_0x0306
        L_0x025b:
            java.lang.Class r7 = java.lang.Double.TYPE     // Catch:{ all -> 0x01ca }
            if (r2 == r7) goto L_0x02e8
            java.lang.Class<java.lang.Double> r7 = java.lang.Double.class
            if (r2 != r7) goto L_0x0265
            goto L_0x02e8
        L_0x0265:
            boolean r7 = r2.isEnum()     // Catch:{ all -> 0x01ca }
            if (r7 == 0) goto L_0x0299
            com.alibaba.fastjson.parser.ParserConfig r7 = r34.getConfig()     // Catch:{ all -> 0x01ca }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r7 = r7.getDeserializer((java.lang.reflect.Type) r2)     // Catch:{ all -> 0x01ca }
            boolean r7 = r7 instanceof com.alibaba.fastjson.parser.deserializer.EnumDeserializer     // Catch:{ all -> 0x01ca }
            if (r7 == 0) goto L_0x0299
            if (r21 == 0) goto L_0x0281
            java.lang.Class r7 = r21.deserializeUsing()     // Catch:{ all -> 0x01ca }
            java.lang.Class<java.lang.Void> r12 = java.lang.Void.class
            if (r7 != r12) goto L_0x0299
        L_0x0281:
            boolean r7 = r0 instanceof com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer     // Catch:{ all -> 0x01ca }
            if (r7 == 0) goto L_0x037c
            r7 = r0
            com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer r7 = (com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer) r7     // Catch:{ all -> 0x01ca }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r7 = r7.fieldValueDeserilizer     // Catch:{ all -> 0x01ca }
            java.lang.Enum r1 = r8.scanEnum(r11, r1, r7)     // Catch:{ all -> 0x01ca }
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x0294
            goto L_0x01ef
        L_0x0294:
            r12 = -2
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x0299:
            java.lang.Class<int[]> r7 = int[].class
            if (r2 != r7) goto L_0x02ac
            int[] r1 = r11.scanFieldIntArray(r1)     // Catch:{ all -> 0x01ca }
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x02a7
            goto L_0x01ef
        L_0x02a7:
            r12 = -2
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x02ac:
            java.lang.Class<float[]> r7 = float[].class
            if (r2 != r7) goto L_0x02bf
            float[] r1 = r11.scanFieldFloatArray(r1)     // Catch:{ all -> 0x01ca }
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x02ba
            goto L_0x01ef
        L_0x02ba:
            r12 = -2
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x02bf:
            java.lang.Class<float[][]> r7 = float[][].class
            if (r2 != r7) goto L_0x02d2
            float[][] r1 = r11.scanFieldFloatArray2(r1)     // Catch:{ all -> 0x01ca }
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x02cd
            goto L_0x01ef
        L_0x02cd:
            r12 = -2
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x02d2:
            boolean r1 = r11.matchField((char[]) r1)     // Catch:{ all -> 0x01ca }
            if (r1 == 0) goto L_0x02da
            goto L_0x01c5
        L_0x02da:
            r21 = r3
            r30 = r5
            r29 = r6
        L_0x02e0:
            r5 = r27
            r6 = r28
            r1 = 13
            goto L_0x055d
        L_0x02e8:
            double r30 = r11.scanFieldDouble(r1)     // Catch:{ all -> 0x01ca }
            int r1 = (r30 > r25 ? 1 : (r30 == r25 ? 0 : -1))
            if (r1 != 0) goto L_0x02f7
            int r1 = r11.matchStat     // Catch:{ all -> 0x01ca }
            r7 = 5
            if (r1 != r7) goto L_0x02f7
            r1 = 0
            goto L_0x02fb
        L_0x02f7:
            java.lang.Double r1 = java.lang.Double.valueOf(r30)     // Catch:{ all -> 0x01ca }
        L_0x02fb:
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x0301
            goto L_0x01ef
        L_0x0301:
            r12 = -2
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x0306:
            float r1 = r11.scanFieldFloat(r1)     // Catch:{ all -> 0x01ca }
            int r7 = (r1 > r24 ? 1 : (r1 == r24 ? 0 : -1))
            if (r7 != 0) goto L_0x0315
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            r12 = 5
            if (r7 != r12) goto L_0x0315
            r1 = 0
            goto L_0x0319
        L_0x0315:
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch:{ all -> 0x01ca }
        L_0x0319:
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x031f
            goto L_0x01ef
        L_0x031f:
            r12 = -2
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x0324:
            boolean r1 = r11.scanFieldBoolean(r1)     // Catch:{ all -> 0x01ca }
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            r12 = 5
            if (r7 != r12) goto L_0x032f
            r1 = 0
            goto L_0x0333
        L_0x032f:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x01ca }
        L_0x0333:
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x0339
            goto L_0x01ef
        L_0x0339:
            r12 = -2
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x033e:
            long r30 = r11.scanFieldLong(r1)     // Catch:{ all -> 0x01ca }
            int r1 = (r30 > r22 ? 1 : (r30 == r22 ? 0 : -1))
            if (r1 != 0) goto L_0x034d
            int r1 = r11.matchStat     // Catch:{ all -> 0x01ca }
            r7 = 5
            if (r1 != r7) goto L_0x034d
            r1 = 0
            goto L_0x0351
        L_0x034d:
            java.lang.Long r1 = java.lang.Long.valueOf(r30)     // Catch:{ all -> 0x01ca }
        L_0x0351:
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x0357
            goto L_0x01ef
        L_0x0357:
            r12 = -2
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x035c:
            int r1 = r11.scanFieldInt(r1)     // Catch:{ all -> 0x01ca }
            if (r1 != 0) goto L_0x0369
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            r12 = 5
            if (r7 != r12) goto L_0x0369
            r1 = 0
            goto L_0x036d
        L_0x0369:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01ca }
        L_0x036d:
            int r7 = r11.matchStat     // Catch:{ all -> 0x01ca }
            if (r7 <= 0) goto L_0x0373
            goto L_0x01ef
        L_0x0373:
            r12 = -2
            if (r7 != r12) goto L_0x0211
            goto L_0x01f5
        L_0x0378:
            r27 = r1
            r28 = r12
        L_0x037c:
            r1 = 0
            goto L_0x0211
        L_0x037f:
            if (r7 != 0) goto L_0x058b
            r21 = r3
            com.alibaba.fastjson.parser.SymbolTable r3 = r9.symbolTable     // Catch:{ all -> 0x053e }
            java.lang.String r3 = r11.scanSymbol(r3)     // Catch:{ all -> 0x053e }
            if (r3 != 0) goto L_0x03ae
            r29 = r6
            int r6 = r11.token()     // Catch:{ all -> 0x01ca }
            r30 = r5
            r5 = 13
            if (r6 != r5) goto L_0x03a0
            r5 = 16
            r11.nextToken(r5)     // Catch:{ all -> 0x01ca }
        L_0x039c:
            r5 = r27
            goto L_0x054e
        L_0x03a0:
            r5 = 16
            if (r6 != r5) goto L_0x03b2
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x01ca }
            boolean r5 = r11.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ all -> 0x01ca }
            if (r5 == 0) goto L_0x03b2
            goto L_0x02e0
        L_0x03ae:
            r30 = r5
            r29 = r6
        L_0x03b2:
            java.lang.String r5 = "$ref"
            if (r5 != r3) goto L_0x048c
            if (r15 == 0) goto L_0x048c
            r5 = 4
            r11.nextTokenWithColon(r5)     // Catch:{ all -> 0x01ca }
            int r0 = r11.token()     // Catch:{ all -> 0x01ca }
            if (r0 != r5) goto L_0x0471
            java.lang.String r0 = r11.stringVal()     // Catch:{ all -> 0x01ca }
            java.lang.String r1 = "@"
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x01ca }
            if (r1 == 0) goto L_0x03d5
            java.lang.Object r0 = r15.object     // Catch:{ all -> 0x01ca }
            r1 = r0
        L_0x03d1:
            r0 = 13
            goto L_0x0450
        L_0x03d5:
            java.lang.String r1 = ".."
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x01ca }
            if (r1 == 0) goto L_0x03f1
            com.alibaba.fastjson.parser.ParseContext r1 = r15.parent     // Catch:{ all -> 0x01ca }
            java.lang.Object r2 = r1.object     // Catch:{ all -> 0x01ca }
            if (r2 == 0) goto L_0x03e5
        L_0x03e3:
            r1 = r2
            goto L_0x03d1
        L_0x03e5:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x01ca }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x01ca }
            r9.addResolveTask(r2)     // Catch:{ all -> 0x01ca }
            r0 = 1
            r9.resolveStatus = r0     // Catch:{ all -> 0x01ca }
            goto L_0x044d
        L_0x03f1:
            java.lang.String r1 = "$"
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x01ca }
            if (r1 == 0) goto L_0x0411
            r1 = r15
        L_0x03fa:
            com.alibaba.fastjson.parser.ParseContext r2 = r1.parent     // Catch:{ all -> 0x01ca }
            if (r2 == 0) goto L_0x0400
            r1 = r2
            goto L_0x03fa
        L_0x0400:
            java.lang.Object r2 = r1.object     // Catch:{ all -> 0x01ca }
            if (r2 == 0) goto L_0x0405
            goto L_0x03e3
        L_0x0405:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x01ca }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x01ca }
            r9.addResolveTask(r2)     // Catch:{ all -> 0x01ca }
            r0 = 1
            r9.resolveStatus = r0     // Catch:{ all -> 0x01ca }
            goto L_0x044d
        L_0x0411:
            r1 = 92
            int r2 = r0.indexOf(r1)     // Catch:{ all -> 0x01ca }
            if (r2 <= 0) goto L_0x043b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ca }
            r2.<init>()     // Catch:{ all -> 0x01ca }
            r3 = 0
        L_0x041f:
            int r5 = r0.length()     // Catch:{ all -> 0x01ca }
            if (r3 >= r5) goto L_0x0437
            char r5 = r0.charAt(r3)     // Catch:{ all -> 0x01ca }
            if (r5 != r1) goto L_0x0431
            int r3 = r3 + 1
            char r5 = r0.charAt(r3)     // Catch:{ all -> 0x01ca }
        L_0x0431:
            r2.append(r5)     // Catch:{ all -> 0x01ca }
            r5 = 1
            int r3 = r3 + r5
            goto L_0x041f
        L_0x0437:
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x01ca }
        L_0x043b:
            java.lang.Object r1 = r9.resolveReference(r0)     // Catch:{ all -> 0x01ca }
            if (r1 == 0) goto L_0x0442
            goto L_0x03d1
        L_0x0442:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r1 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x01ca }
            r1.<init>(r15, r0)     // Catch:{ all -> 0x01ca }
            r9.addResolveTask(r1)     // Catch:{ all -> 0x01ca }
            r0 = 1
            r9.resolveStatus = r0     // Catch:{ all -> 0x01ca }
        L_0x044d:
            r1 = r27
            goto L_0x03d1
        L_0x0450:
            r11.nextToken(r0)     // Catch:{ all -> 0x019c }
            int r2 = r11.token()     // Catch:{ all -> 0x019c }
            if (r2 != r0) goto L_0x0469
            r0 = 16
            r11.nextToken(r0)     // Catch:{ all -> 0x019c }
            r9.setContext(r15, r1, r10)     // Catch:{ all -> 0x019c }
            if (r4 == 0) goto L_0x0465
            r4.object = r1
        L_0x0465:
            r9.setContext(r15)
            return r1
        L_0x0469:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x019c }
            java.lang.String r2 = "illegal ref"
            r0.<init>(r2)     // Catch:{ all -> 0x019c }
            throw r0     // Catch:{ all -> 0x019c }
        L_0x0471:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x01ca }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ca }
            r2.<init>()     // Catch:{ all -> 0x01ca }
            java.lang.String r3 = "illegal ref, "
            r2.append(r3)     // Catch:{ all -> 0x01ca }
            java.lang.String r0 = com.alibaba.fastjson.parser.JSONToken.name(r0)     // Catch:{ all -> 0x01ca }
            r2.append(r0)     // Catch:{ all -> 0x01ca }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x01ca }
            r1.<init>(r0)     // Catch:{ all -> 0x01ca }
            throw r1     // Catch:{ all -> 0x01ca }
        L_0x048c:
            if (r14 == 0) goto L_0x0497
            boolean r5 = r14.equals(r3)     // Catch:{ all -> 0x01ca }
            if (r5 != 0) goto L_0x0495
            goto L_0x0497
        L_0x0495:
            r0 = 4
            goto L_0x049c
        L_0x0497:
            java.lang.String r5 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x053e }
            if (r5 != r3) goto L_0x0584
            goto L_0x0495
        L_0x049c:
            r11.nextTokenWithColon(r0)     // Catch:{ all -> 0x053e }
            int r1 = r11.token()     // Catch:{ all -> 0x053e }
            if (r1 != r0) goto L_0x057a
            java.lang.String r0 = r11.stringVal()     // Catch:{ all -> 0x053e }
            r1 = 16
            r11.nextToken(r1)     // Catch:{ all -> 0x053e }
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x053e }
            java.lang.String r1 = r1.typeName     // Catch:{ all -> 0x053e }
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x053e }
            if (r1 != 0) goto L_0x04c0
            com.alibaba.fastjson.parser.Feature r1 = com.alibaba.fastjson.parser.Feature.IgnoreAutoType     // Catch:{ all -> 0x053e }
            boolean r1 = r9.isEnabled(r1)     // Catch:{ all -> 0x053e }
            if (r1 == 0) goto L_0x04c6
        L_0x04c0:
            r5 = r27
            r6 = r28
            goto L_0x0543
        L_0x04c6:
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x053e }
            r6 = r28
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r1 = getSeeAlso(r6, r1, r0)     // Catch:{ all -> 0x053e }
            if (r1 != 0) goto L_0x051e
            java.lang.Class r1 = com.alibaba.fastjson.util.TypeUtils.getClass(r35)     // Catch:{ all -> 0x01ca }
            com.alibaba.fastjson.parser.ParserConfig$AutoTypeCheckHandler r2 = r8.autoTypeCheckHandler     // Catch:{ all -> 0x01ca }
            if (r2 == 0) goto L_0x04e1
            int r3 = r11.getFeatures()     // Catch:{ all -> 0x01ca }
            java.lang.Class r2 = r2.handler(r0, r1, r3)     // Catch:{ all -> 0x01ca }
            goto L_0x04e2
        L_0x04e1:
            r2 = 0
        L_0x04e2:
            if (r2 != 0) goto L_0x0504
            java.lang.String r3 = "java.util.HashMap"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x01ca }
            if (r3 != 0) goto L_0x04f4
            java.lang.String r3 = "java.util.LinkedHashMap"
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x01ca }
            if (r3 == 0) goto L_0x0504
        L_0x04f4:
            int r0 = r11.token()     // Catch:{ all -> 0x01ca }
            r1 = 13
            if (r0 != r1) goto L_0x0501
            r11.nextToken()     // Catch:{ all -> 0x01ca }
            goto L_0x039c
        L_0x0501:
            r5 = r27
            goto L_0x055d
        L_0x0504:
            if (r2 != 0) goto L_0x050f
            int r2 = r11.getFeatures()     // Catch:{ all -> 0x01ca }
            java.lang.Class r1 = r6.checkAutoType(r0, r1, r2)     // Catch:{ all -> 0x01ca }
            goto L_0x0510
        L_0x050f:
            r1 = r2
        L_0x0510:
            com.alibaba.fastjson.parser.ParserConfig r2 = r34.getConfig()     // Catch:{ all -> 0x01ca }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r2 = r2.getDeserializer((java.lang.reflect.Type) r1)     // Catch:{ all -> 0x01ca }
            r32 = r2
            r2 = r1
            r1 = r32
            goto L_0x051f
        L_0x051e:
            r2 = 0
        L_0x051f:
            java.lang.Object r2 = r1.deserialze(r9, r2, r10)     // Catch:{ all -> 0x053e }
            boolean r3 = r1 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer     // Catch:{ all -> 0x053e }
            if (r3 == 0) goto L_0x0534
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r1 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r1     // Catch:{ all -> 0x01ca }
            if (r14 == 0) goto L_0x0534
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r1 = r1.getFieldDeserializer((java.lang.String) r14)     // Catch:{ all -> 0x01ca }
            if (r1 == 0) goto L_0x0534
            r1.setValue((java.lang.Object) r2, (java.lang.String) r0)     // Catch:{ all -> 0x01ca }
        L_0x0534:
            if (r4 == 0) goto L_0x053a
            r5 = r27
            r4.object = r5
        L_0x053a:
            r9.setContext(r15)
            return r2
        L_0x053e:
            r0 = move-exception
            r5 = r27
            goto L_0x019e
        L_0x0543:
            int r0 = r11.token()     // Catch:{ all -> 0x055a }
            r1 = 13
            if (r0 != r1) goto L_0x055d
            r11.nextToken()     // Catch:{ all -> 0x055a }
        L_0x054e:
            r12 = r35
            r29 = r5
            r0 = r17
            r13 = r30
            r39 = 0
            goto L_0x06ec
        L_0x055a:
            r0 = move-exception
            goto L_0x019e
        L_0x055d:
            r12 = r35
            r27 = r5
            r20 = r17
            r19 = r21
            r28 = r29
            r13 = r30
            r0 = 13
            r1 = 0
            r2 = 16
            r3 = 0
            r5 = 1
            r18 = 4
            r30 = r37
            r17 = r39
            r21 = r6
            goto L_0x0930
        L_0x057a:
            r5 = r27
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x055a }
            java.lang.String r1 = "syntax error"
            r0.<init>(r1)     // Catch:{ all -> 0x055a }
            throw r0     // Catch:{ all -> 0x055a }
        L_0x0584:
            r5 = r27
            r6 = r28
            r16 = 13
            goto L_0x0598
        L_0x058b:
            r21 = r3
            r30 = r5
            r29 = r6
            r5 = r27
            r6 = r28
            r16 = 13
            r3 = 0
        L_0x0598:
            if (r5 != 0) goto L_0x05e1
            if (r17 != 0) goto L_0x05e1
            java.lang.Object r5 = r33.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r34, (java.lang.reflect.Type) r35)     // Catch:{ all -> 0x05dd }
            if (r5 != 0) goto L_0x05b6
            r27 = r4
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x05b1 }
            r28 = r6
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r6 = r8.fieldDeserializers     // Catch:{ all -> 0x05b1 }
            int r6 = r6.length     // Catch:{ all -> 0x05b1 }
            r4.<init>(r6)     // Catch:{ all -> 0x05b1 }
            r17 = r4
            goto L_0x05ba
        L_0x05b1:
            r0 = move-exception
        L_0x05b2:
            r14 = r27
            goto L_0x0972
        L_0x05b6:
            r27 = r4
            r28 = r6
        L_0x05ba:
            com.alibaba.fastjson.parser.ParseContext r4 = r9.setContext(r15, r5, r10)     // Catch:{ all -> 0x05b1 }
            if (r39 != 0) goto L_0x05d5
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r6 = r8.fieldDeserializers     // Catch:{ all -> 0x055a }
            int r6 = r6.length     // Catch:{ all -> 0x055a }
            int r6 = r6 / 32
            r20 = 1
            int r6 = r6 + 1
            int[] r6 = new int[r6]     // Catch:{ all -> 0x055a }
            r27 = r4
            r32 = r6
            r6 = r5
            r5 = r17
            r17 = r32
            goto L_0x05e6
        L_0x05d5:
            r27 = r4
        L_0x05d7:
            r6 = r5
            r5 = r17
            r17 = r39
            goto L_0x05e6
        L_0x05dd:
            r0 = move-exception
        L_0x05de:
            r27 = r4
            goto L_0x05b2
        L_0x05e1:
            r27 = r4
            r28 = r6
            goto L_0x05d7
        L_0x05e6:
            if (r7 == 0) goto L_0x067f
            if (r12 != 0) goto L_0x0608
            r12 = r35
            r0.parseField(r9, r6, r12, r5)     // Catch:{ all -> 0x0605 }
            r20 = r5
            r19 = r21
            r21 = r28
            r28 = r29
            r13 = r30
            r39 = 0
            r0 = 13
            r18 = 4
            r30 = r37
        L_0x0601:
            r29 = r6
            goto L_0x06d5
        L_0x0605:
            r0 = move-exception
            r5 = r6
            goto L_0x05b2
        L_0x0608:
            r12 = r35
            if (r6 != 0) goto L_0x0614
            java.lang.String r0 = r13.name     // Catch:{ all -> 0x0605 }
            r5.put(r0, r1)     // Catch:{ all -> 0x0605 }
        L_0x0611:
            r7 = r30
            goto L_0x064f
        L_0x0614:
            if (r1 != 0) goto L_0x062e
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0605 }
            if (r2 == r3) goto L_0x0611
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x0605 }
            if (r2 == r3) goto L_0x0611
            java.lang.Class r3 = java.lang.Float.TYPE     // Catch:{ all -> 0x0605 }
            if (r2 == r3) goto L_0x0611
            java.lang.Class r3 = java.lang.Double.TYPE     // Catch:{ all -> 0x0605 }
            if (r2 == r3) goto L_0x0611
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0605 }
            if (r2 == r3) goto L_0x0611
            r0.setValue((java.lang.Object) r6, (java.lang.Object) r1)     // Catch:{ all -> 0x0605 }
            goto L_0x0611
        L_0x062e:
            r7 = r30
            if (r2 != r7) goto L_0x064c
            com.alibaba.fastjson.parser.Feature r2 = com.alibaba.fastjson.parser.Feature.TrimStringFieldValue     // Catch:{ all -> 0x0605 }
            int r2 = r2.mask     // Catch:{ all -> 0x0605 }
            r3 = r38 & r2
            if (r3 != 0) goto L_0x0646
            com.alibaba.fastjson.util.JavaBeanInfo r3 = r8.beanInfo     // Catch:{ all -> 0x0605 }
            int r3 = r3.parserFeatures     // Catch:{ all -> 0x0605 }
            r3 = r3 & r2
            if (r3 != 0) goto L_0x0646
            int r3 = r13.parserFeatures     // Catch:{ all -> 0x0605 }
            r2 = r2 & r3
            if (r2 == 0) goto L_0x064c
        L_0x0646:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0605 }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x0605 }
        L_0x064c:
            r0.setValue((java.lang.Object) r6, (java.lang.Object) r1)     // Catch:{ all -> 0x0605 }
        L_0x064f:
            if (r17 == 0) goto L_0x065e
            int r0 = r37 / 32
            int r1 = r37 % 32
            r2 = r17[r0]     // Catch:{ all -> 0x0605 }
            r4 = 1
            int r1 = r4 << r1
            r1 = r1 | r2
            r17[r0] = r1     // Catch:{ all -> 0x0605 }
            goto L_0x065f
        L_0x065e:
            r4 = 1
        L_0x065f:
            int r0 = r11.matchStat     // Catch:{ all -> 0x0605 }
            r13 = 4
            if (r0 != r13) goto L_0x066d
            r20 = r5
            r29 = r6
            r13 = r7
            r39 = 0
            goto L_0x06e8
        L_0x066d:
            r30 = r37
            r20 = r5
            r13 = r7
            r19 = r21
            r21 = r28
            r28 = r29
            r39 = 0
            r0 = 13
            r18 = 4
            goto L_0x0601
        L_0x067f:
            r12 = r35
            r7 = r30
            r4 = 1
            r13 = 4
            if (r5 != 0) goto L_0x0690
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0605 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r1 = r8.fieldDeserializers     // Catch:{ all -> 0x0605 }
            int r1 = r1.length     // Catch:{ all -> 0x0605 }
            r0.<init>(r1)     // Catch:{ all -> 0x0605 }
            goto L_0x0691
        L_0x0690:
            r0 = r5
        L_0x0691:
            r1 = r33
            r2 = r34
            r19 = r21
            r39 = 0
            r13 = 1
            r4 = r6
            r20 = r5
            r5 = r35
            r21 = r28
            r28 = r29
            r29 = r6
            r6 = r0
            r30 = r37
            r13 = r7
            r0 = 13
            r18 = 4
            r7 = r17
            boolean r1 = r1.parseField(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x06bf }
            if (r1 != 0) goto L_0x06cd
            int r1 = r11.token()     // Catch:{ all -> 0x06bf }
            if (r1 != r0) goto L_0x06c6
            r11.nextToken()     // Catch:{ all -> 0x06bf }
            goto L_0x06e8
        L_0x06bf:
            r0 = move-exception
            r14 = r27
        L_0x06c2:
            r5 = r29
            goto L_0x0972
        L_0x06c6:
            r1 = 0
            r2 = 16
        L_0x06c9:
            r3 = 0
            r5 = 1
            goto L_0x092c
        L_0x06cd:
            int r1 = r11.token()     // Catch:{ all -> 0x06bf }
            r2 = 17
            if (r1 == r2) goto L_0x0961
        L_0x06d5:
            int r1 = r11.token()     // Catch:{ all -> 0x06bf }
            r2 = 16
            if (r1 != r2) goto L_0x06df
            r1 = 0
            goto L_0x06c9
        L_0x06df:
            int r1 = r11.token()     // Catch:{ all -> 0x06bf }
            if (r1 != r0) goto L_0x091b
            r11.nextToken(r2)     // Catch:{ all -> 0x06bf }
        L_0x06e8:
            r0 = r20
            r4 = r27
        L_0x06ec:
            if (r29 != 0) goto L_0x08f4
            if (r0 != 0) goto L_0x0705
            java.lang.Object r1 = r33.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r34, (java.lang.reflect.Type) r35)     // Catch:{ all -> 0x0702 }
            if (r4 != 0) goto L_0x06fa
            com.alibaba.fastjson.parser.ParseContext r4 = r9.setContext(r15, r1, r10)     // Catch:{ all -> 0x019c }
        L_0x06fa:
            if (r4 == 0) goto L_0x06fe
            r4.object = r1
        L_0x06fe:
            r9.setContext(r15)
            return r1
        L_0x0702:
            r0 = move-exception
            r14 = r4
            goto L_0x06c2
        L_0x0705:
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r8.beanInfo     // Catch:{ all -> 0x0702 }
            java.lang.String[] r2 = r1.creatorConstructorParameters     // Catch:{ all -> 0x0702 }
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x07ad
            int r1 = r2.length     // Catch:{ all -> 0x0702 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0702 }
            r5 = 0
        L_0x0711:
            int r6 = r2.length     // Catch:{ all -> 0x0702 }
            if (r5 >= r6) goto L_0x0815
            r6 = r2[r5]     // Catch:{ all -> 0x0702 }
            java.lang.Object r6 = r0.remove(r6)     // Catch:{ all -> 0x0702 }
            if (r6 != 0) goto L_0x0771
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r8.beanInfo     // Catch:{ all -> 0x0702 }
            java.lang.reflect.Type[] r10 = r7.creatorConstructorParameterTypes     // Catch:{ all -> 0x0702 }
            r10 = r10[r5]     // Catch:{ all -> 0x0702 }
            com.alibaba.fastjson.util.FieldInfo[] r7 = r7.fields     // Catch:{ all -> 0x0702 }
            r7 = r7[r5]     // Catch:{ all -> 0x0702 }
            java.lang.Class r11 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0702 }
            if (r10 != r11) goto L_0x072f
            java.lang.Byte r6 = java.lang.Byte.valueOf(r39)     // Catch:{ all -> 0x0702 }
            goto L_0x076f
        L_0x072f:
            java.lang.Class r11 = java.lang.Short.TYPE     // Catch:{ all -> 0x0702 }
            if (r10 != r11) goto L_0x0738
            java.lang.Short r6 = java.lang.Short.valueOf(r39)     // Catch:{ all -> 0x0702 }
            goto L_0x076f
        L_0x0738:
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0702 }
            if (r10 != r11) goto L_0x0741
            java.lang.Integer r6 = java.lang.Integer.valueOf(r39)     // Catch:{ all -> 0x0702 }
            goto L_0x076f
        L_0x0741:
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0702 }
            if (r10 != r11) goto L_0x074a
            java.lang.Long r6 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0702 }
            goto L_0x076f
        L_0x074a:
            java.lang.Class r11 = java.lang.Float.TYPE     // Catch:{ all -> 0x0702 }
            if (r10 != r11) goto L_0x0753
            java.lang.Float r6 = java.lang.Float.valueOf(r24)     // Catch:{ all -> 0x0702 }
            goto L_0x076f
        L_0x0753:
            java.lang.Class r11 = java.lang.Double.TYPE     // Catch:{ all -> 0x0702 }
            if (r10 != r11) goto L_0x075c
            java.lang.Double r6 = java.lang.Double.valueOf(r25)     // Catch:{ all -> 0x0702 }
            goto L_0x076f
        L_0x075c:
            java.lang.Class r11 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0702 }
            if (r10 != r11) goto L_0x0763
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0702 }
            goto L_0x076f
        L_0x0763:
            if (r10 != r13) goto L_0x076f
            int r7 = r7.parserFeatures     // Catch:{ all -> 0x0702 }
            com.alibaba.fastjson.parser.Feature r10 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty     // Catch:{ all -> 0x0702 }
            int r10 = r10.mask     // Catch:{ all -> 0x0702 }
            r7 = r7 & r10
            if (r7 == 0) goto L_0x076f
            r6 = r3
        L_0x076f:
            r11 = 0
            goto L_0x07a5
        L_0x0771:
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r8.beanInfo     // Catch:{ all -> 0x0702 }
            java.lang.reflect.Type[] r7 = r7.creatorConstructorParameterTypes     // Catch:{ all -> 0x0702 }
            if (r7 == 0) goto L_0x076f
            int r10 = r7.length     // Catch:{ all -> 0x0702 }
            if (r5 >= r10) goto L_0x076f
            r7 = r7[r5]     // Catch:{ all -> 0x0702 }
            boolean r10 = r7 instanceof java.lang.Class     // Catch:{ all -> 0x0702 }
            if (r10 == 0) goto L_0x076f
            java.lang.Class r7 = (java.lang.Class) r7     // Catch:{ all -> 0x0702 }
            boolean r10 = r7.isInstance(r6)     // Catch:{ all -> 0x0702 }
            if (r10 != 0) goto L_0x076f
            boolean r10 = r6 instanceof java.util.List     // Catch:{ all -> 0x0702 }
            if (r10 == 0) goto L_0x076f
            r10 = r6
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x0702 }
            int r11 = r10.size()     // Catch:{ all -> 0x0702 }
            r12 = 1
            if (r11 != r12) goto L_0x076f
            r11 = 0
            java.lang.Object r12 = r10.get(r11)     // Catch:{ all -> 0x0702 }
            boolean r7 = r7.isInstance(r12)     // Catch:{ all -> 0x0702 }
            if (r7 == 0) goto L_0x07a5
            java.lang.Object r6 = r10.get(r11)     // Catch:{ all -> 0x0702 }
        L_0x07a5:
            r1[r5] = r6     // Catch:{ all -> 0x0702 }
            int r5 = r5 + 1
            r39 = 0
            goto L_0x0711
        L_0x07ad:
            r11 = 0
            com.alibaba.fastjson.util.FieldInfo[] r1 = r1.fields     // Catch:{ all -> 0x0702 }
            int r5 = r1.length     // Catch:{ all -> 0x0702 }
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x0702 }
            r7 = 0
        L_0x07b4:
            if (r7 >= r5) goto L_0x0814
            r10 = r1[r7]     // Catch:{ all -> 0x0702 }
            java.lang.String r12 = r10.name     // Catch:{ all -> 0x0702 }
            java.lang.Object r12 = r0.get(r12)     // Catch:{ all -> 0x0702 }
            if (r12 != 0) goto L_0x080e
            java.lang.reflect.Type r14 = r10.fieldType     // Catch:{ all -> 0x0702 }
            java.lang.Class r11 = java.lang.Byte.TYPE     // Catch:{ all -> 0x0702 }
            if (r14 != r11) goto L_0x07cc
            r11 = 0
            java.lang.Byte r12 = java.lang.Byte.valueOf(r11)     // Catch:{ all -> 0x0702 }
            goto L_0x080e
        L_0x07cc:
            java.lang.Class r11 = java.lang.Short.TYPE     // Catch:{ all -> 0x0702 }
            if (r14 != r11) goto L_0x07d6
            r11 = 0
            java.lang.Short r12 = java.lang.Short.valueOf(r11)     // Catch:{ all -> 0x0702 }
            goto L_0x080e
        L_0x07d6:
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0702 }
            if (r14 != r11) goto L_0x07e0
            r11 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0702 }
            goto L_0x080e
        L_0x07e0:
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x0702 }
            if (r14 != r11) goto L_0x07e9
            java.lang.Long r12 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0702 }
            goto L_0x080e
        L_0x07e9:
            java.lang.Class r11 = java.lang.Float.TYPE     // Catch:{ all -> 0x0702 }
            if (r14 != r11) goto L_0x07f2
            java.lang.Float r12 = java.lang.Float.valueOf(r24)     // Catch:{ all -> 0x0702 }
            goto L_0x080e
        L_0x07f2:
            java.lang.Class r11 = java.lang.Double.TYPE     // Catch:{ all -> 0x0702 }
            if (r14 != r11) goto L_0x07fb
            java.lang.Double r12 = java.lang.Double.valueOf(r25)     // Catch:{ all -> 0x0702 }
            goto L_0x080e
        L_0x07fb:
            java.lang.Class r11 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x0702 }
            if (r14 != r11) goto L_0x0802
            java.lang.Boolean r12 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0702 }
            goto L_0x080e
        L_0x0802:
            if (r14 != r13) goto L_0x080e
            int r10 = r10.parserFeatures     // Catch:{ all -> 0x0702 }
            com.alibaba.fastjson.parser.Feature r11 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty     // Catch:{ all -> 0x0702 }
            int r11 = r11.mask     // Catch:{ all -> 0x0702 }
            r10 = r10 & r11
            if (r10 == 0) goto L_0x080e
            r12 = r3
        L_0x080e:
            r6[r7] = r12     // Catch:{ all -> 0x0702 }
            int r7 = r7 + 1
            r11 = 0
            goto L_0x07b4
        L_0x0814:
            r1 = r6
        L_0x0815:
            com.alibaba.fastjson.util.JavaBeanInfo r3 = r8.beanInfo     // Catch:{ all -> 0x0702 }
            java.lang.reflect.Constructor<?> r5 = r3.creatorConstructor     // Catch:{ all -> 0x0702 }
            if (r5 == 0) goto L_0x08c1
            boolean r3 = r3.f1149kotlin     // Catch:{ all -> 0x0702 }
            if (r3 == 0) goto L_0x0868
            r3 = 0
        L_0x0820:
            int r5 = r1.length     // Catch:{ all -> 0x0702 }
            if (r3 >= r5) goto L_0x0868
            r5 = r1[r3]     // Catch:{ all -> 0x0702 }
            if (r5 != 0) goto L_0x0865
            com.alibaba.fastjson.util.JavaBeanInfo r5 = r8.beanInfo     // Catch:{ all -> 0x0702 }
            com.alibaba.fastjson.util.FieldInfo[] r6 = r5.fields     // Catch:{ all -> 0x0702 }
            if (r6 == 0) goto L_0x0865
            int r7 = r6.length     // Catch:{ all -> 0x0702 }
            if (r3 >= r7) goto L_0x0865
            r3 = r6[r3]     // Catch:{ all -> 0x0702 }
            java.lang.Class<?> r3 = r3.fieldClass     // Catch:{ all -> 0x0702 }
            if (r3 != r13) goto L_0x0868
            java.lang.reflect.Constructor<?> r3 = r5.kotlinDefaultConstructor     // Catch:{ Exception -> 0x0861 }
            if (r3 == 0) goto L_0x0868
            r5 = 0
            java.lang.Object r3 = r3.newInstance(r5)     // Catch:{ Exception -> 0x0861 }
            r5 = 0
        L_0x0840:
            int r6 = r1.length     // Catch:{ Exception -> 0x085a }
            if (r5 >= r6) goto L_0x085f
            r6 = r1[r5]     // Catch:{ Exception -> 0x085a }
            if (r6 == 0) goto L_0x085c
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r8.beanInfo     // Catch:{ Exception -> 0x085a }
            com.alibaba.fastjson.util.FieldInfo[] r7 = r7.fields     // Catch:{ Exception -> 0x085a }
            if (r7 == 0) goto L_0x085c
            int r10 = r7.length     // Catch:{ Exception -> 0x085a }
            if (r5 >= r10) goto L_0x085c
            r7 = r7[r5]     // Catch:{ Exception -> 0x085a }
            r7.set(r3, r6)     // Catch:{ Exception -> 0x085a }
            goto L_0x085c
        L_0x0856:
            r0 = move-exception
            r5 = r3
            goto L_0x019e
        L_0x085a:
            r0 = move-exception
            goto L_0x089a
        L_0x085c:
            int r5 = r5 + 1
            goto L_0x0840
        L_0x085f:
            r1 = r3
            goto L_0x0870
        L_0x0861:
            r0 = move-exception
            r3 = r29
            goto L_0x089a
        L_0x0865:
            int r3 = r3 + 1
            goto L_0x0820
        L_0x0868:
            com.alibaba.fastjson.util.JavaBeanInfo r3 = r8.beanInfo     // Catch:{ Exception -> 0x0861 }
            java.lang.reflect.Constructor<?> r3 = r3.creatorConstructor     // Catch:{ Exception -> 0x0861 }
            java.lang.Object r1 = r3.newInstance(r1)     // Catch:{ Exception -> 0x0861 }
        L_0x0870:
            if (r2 == 0) goto L_0x08ef
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x019c }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x019c }
        L_0x087a:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x019c }
            if (r2 == 0) goto L_0x08ef
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x019c }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x019c }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x019c }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x019c }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r3 = r8.getFieldDeserializer((java.lang.String) r3)     // Catch:{ all -> 0x019c }
            if (r3 == 0) goto L_0x087a
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x019c }
            r3.setValue((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x019c }
            goto L_0x087a
        L_0x089a:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0856 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0856 }
            r5.<init>()     // Catch:{ all -> 0x0856 }
            java.lang.String r6 = "create instance error, "
            r5.append(r6)     // Catch:{ all -> 0x0856 }
            r5.append(r2)     // Catch:{ all -> 0x0856 }
            java.lang.String r2 = ", "
            r5.append(r2)     // Catch:{ all -> 0x0856 }
            com.alibaba.fastjson.util.JavaBeanInfo r2 = r8.beanInfo     // Catch:{ all -> 0x0856 }
            java.lang.reflect.Constructor<?> r2 = r2.creatorConstructor     // Catch:{ all -> 0x0856 }
            java.lang.String r2 = r2.toGenericString()     // Catch:{ all -> 0x0856 }
            r5.append(r2)     // Catch:{ all -> 0x0856 }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x0856 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0856 }
            throw r1     // Catch:{ all -> 0x0856 }
        L_0x08c1:
            java.lang.reflect.Method r0 = r3.factoryMethod     // Catch:{ all -> 0x0702 }
            if (r0 == 0) goto L_0x08ed
            r2 = 0
            java.lang.Object r0 = r0.invoke(r2, r1)     // Catch:{ Exception -> 0x08cc }
            r1 = r0
            goto L_0x08ef
        L_0x08cc:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0702 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0702 }
            r2.<init>()     // Catch:{ all -> 0x0702 }
            java.lang.String r3 = "create factory method error, "
            r2.append(r3)     // Catch:{ all -> 0x0702 }
            com.alibaba.fastjson.util.JavaBeanInfo r3 = r8.beanInfo     // Catch:{ all -> 0x0702 }
            java.lang.reflect.Method r3 = r3.factoryMethod     // Catch:{ all -> 0x0702 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0702 }
            r2.append(r3)     // Catch:{ all -> 0x0702 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0702 }
            r0.<init>(r2, r1)     // Catch:{ all -> 0x0702 }
            throw r0     // Catch:{ all -> 0x0702 }
        L_0x08ed:
            r1 = r29
        L_0x08ef:
            if (r4 == 0) goto L_0x08f6
            r4.object = r1     // Catch:{ all -> 0x019c }
            goto L_0x08f6
        L_0x08f4:
            r1 = r29
        L_0x08f6:
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r8.beanInfo     // Catch:{ all -> 0x019c }
            java.lang.reflect.Method r0 = r0.buildMethod     // Catch:{ all -> 0x019c }
            if (r0 != 0) goto L_0x0904
            if (r4 == 0) goto L_0x0900
            r4.object = r1
        L_0x0900:
            r9.setContext(r15)
            return r1
        L_0x0904:
            r3 = 0
            java.lang.Object r0 = r0.invoke(r1, r3)     // Catch:{ Exception -> 0x0911 }
            if (r4 == 0) goto L_0x090d
            r4.object = r1
        L_0x090d:
            r9.setContext(r15)
            return r0
        L_0x0911:
            r0 = move-exception
            r2 = r0
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x019c }
            java.lang.String r3 = "build object error"
            r0.<init>(r3, r2)     // Catch:{ all -> 0x019c }
            throw r0     // Catch:{ all -> 0x019c }
        L_0x091b:
            r1 = 0
            r3 = 0
            int r4 = r11.token()     // Catch:{ all -> 0x06bf }
            r5 = 18
            if (r4 == r5) goto L_0x0942
            int r4 = r11.token()     // Catch:{ all -> 0x06bf }
            r5 = 1
            if (r4 == r5) goto L_0x0942
        L_0x092c:
            r4 = r27
            r27 = r29
        L_0x0930:
            int r7 = r30 + 1
            r0 = r12
            r5 = r13
            r2 = r17
            r3 = r19
            r17 = r20
            r12 = r21
            r1 = r27
            r6 = r28
            goto L_0x0173
        L_0x0942:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x06bf }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x06bf }
            r1.<init>()     // Catch:{ all -> 0x06bf }
            java.lang.String r2 = "syntax error, unexpect token "
            r1.append(r2)     // Catch:{ all -> 0x06bf }
            int r2 = r11.token()     // Catch:{ all -> 0x06bf }
            java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.name(r2)     // Catch:{ all -> 0x06bf }
            r1.append(r2)     // Catch:{ all -> 0x06bf }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x06bf }
            r0.<init>(r1)     // Catch:{ all -> 0x06bf }
            throw r0     // Catch:{ all -> 0x06bf }
        L_0x0961:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x06bf }
            java.lang.String r1 = "syntax error, unexpect token ':'"
            r0.<init>(r1)     // Catch:{ all -> 0x06bf }
            throw r0     // Catch:{ all -> 0x06bf }
        L_0x0969:
            r0 = move-exception
            r5 = r1
            goto L_0x05de
        L_0x096d:
            r0 = move-exception
            r3 = 0
            r5 = r37
            r14 = r3
        L_0x0972:
            if (r14 == 0) goto L_0x0976
            r14.object = r5
        L_0x0976:
            r9.setContext(r15)
            throw r0
        L_0x097a:
            java.lang.Object r0 = r34.parse()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object, int, int[]):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0078 A[LOOP:2: B:24:0x0076->B:25:0x0078, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaBeanDeserializer(com.alibaba.fastjson.parser.ParserConfig r10, com.alibaba.fastjson.util.JavaBeanInfo r11) {
        /*
            r9 = this;
            r9.<init>()
            java.lang.Class<?> r0 = r11.clazz
            r9.clazz = r0
            r9.beanInfo = r11
            com.alibaba.fastjson.annotation.JSONType r0 = r11.jsonType
            r1 = 0
            if (r0 == 0) goto L_0x0023
            java.lang.Class r0 = r0.autoTypeCheckHandler()
            java.lang.Class<com.alibaba.fastjson.parser.ParserConfig$AutoTypeCheckHandler> r2 = com.alibaba.fastjson.parser.ParserConfig.AutoTypeCheckHandler.class
            if (r0 == r2) goto L_0x0023
            com.alibaba.fastjson.annotation.JSONType r0 = r11.jsonType     // Catch:{ Exception -> 0x0023 }
            java.lang.Class r0 = r0.autoTypeCheckHandler()     // Catch:{ Exception -> 0x0023 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x0023 }
            com.alibaba.fastjson.parser.ParserConfig$AutoTypeCheckHandler r0 = (com.alibaba.fastjson.parser.ParserConfig.AutoTypeCheckHandler) r0     // Catch:{ Exception -> 0x0023 }
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            r9.autoTypeCheckHandler = r0
            com.alibaba.fastjson.util.FieldInfo[] r0 = r11.sortedFields
            int r2 = r0.length
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r2 = new com.alibaba.fastjson.parser.deserializer.FieldDeserializer[r2]
            r9.sortedFieldDeserializers = r2
            int r0 = r0.length
            r2 = 0
            r3 = 0
        L_0x0030:
            if (r3 >= r0) goto L_0x006c
            com.alibaba.fastjson.util.FieldInfo[] r4 = r11.sortedFields
            r4 = r4[r3]
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r5 = r10.createFieldDeserializer(r10, r11, r4)
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r6 = r9.sortedFieldDeserializers
            r6[r3] = r5
            r6 = 128(0x80, float:1.794E-43)
            if (r0 <= r6) goto L_0x0054
            java.util.Map<java.lang.String, com.alibaba.fastjson.parser.deserializer.FieldDeserializer> r6 = r9.fieldDeserializerMap
            if (r6 != 0) goto L_0x004d
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r9.fieldDeserializerMap = r6
        L_0x004d:
            java.util.Map<java.lang.String, com.alibaba.fastjson.parser.deserializer.FieldDeserializer> r6 = r9.fieldDeserializerMap
            java.lang.String r7 = r4.name
            r6.put(r7, r5)
        L_0x0054:
            java.lang.String[] r4 = r4.alternateNames
            int r6 = r4.length
            r7 = 0
        L_0x0058:
            if (r7 >= r6) goto L_0x0069
            r8 = r4[r7]
            if (r1 != 0) goto L_0x0063
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
        L_0x0063:
            r1.put(r8, r5)
            int r7 = r7 + 1
            goto L_0x0058
        L_0x0069:
            int r3 = r3 + 1
            goto L_0x0030
        L_0x006c:
            r9.alterNameFieldDeserializers = r1
            com.alibaba.fastjson.util.FieldInfo[] r10 = r11.fields
            int r0 = r10.length
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r0 = new com.alibaba.fastjson.parser.deserializer.FieldDeserializer[r0]
            r9.fieldDeserializers = r0
            int r10 = r10.length
        L_0x0076:
            if (r2 >= r10) goto L_0x0089
            com.alibaba.fastjson.util.FieldInfo[] r0 = r11.fields
            r0 = r0[r2]
            java.lang.String r0 = r0.name
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r0 = r9.getFieldDeserializer((java.lang.String) r0)
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r1 = r9.fieldDeserializers
            r1[r2] = r0
            int r2 = r2 + 1
            goto L_0x0076
        L_0x0089:
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
            Arrays.fill(sArr, -1);
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

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        if (com.alibaba.fastjson.JSONValidator.from(r6).validate() != false) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object createInstance(java.util.Map<java.lang.String, java.lang.Object> r13, com.alibaba.fastjson.parser.ParserConfig r14) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r12 = this;
            com.alibaba.fastjson.util.JavaBeanInfo r0 = r12.beanInfo
            java.lang.reflect.Constructor<?> r1 = r0.creatorConstructor
            r2 = 1
            r3 = 0
            r4 = 0
            if (r1 != 0) goto L_0x0174
            java.lang.reflect.Method r1 = r0.factoryMethod
            if (r1 != 0) goto L_0x0174
            java.lang.Class<?> r0 = r12.clazz
            java.lang.Object r0 = r12.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r4, (java.lang.reflect.Type) r0)
            java.util.Set r13 = r13.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x001b:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x015f
            java.lang.Object r1 = r13.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r5 = r1.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r1 = r1.getValue()
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r5 = r12.smartMatch(r5)
            if (r5 != 0) goto L_0x0038
            goto L_0x001b
        L_0x0038:
            com.alibaba.fastjson.util.FieldInfo r6 = r5.fieldInfo
            java.lang.reflect.Field r7 = r6.field
            java.lang.reflect.Type r8 = r6.fieldType
            java.lang.Class<?> r9 = r6.fieldClass
            com.alibaba.fastjson.annotation.JSONField r10 = r6.getAnnotation()
            java.lang.Class<?> r11 = r6.declaringClass
            if (r11 == 0) goto L_0x0077
            boolean r9 = r9.isInstance(r1)
            if (r9 == 0) goto L_0x0058
            if (r10 == 0) goto L_0x0077
            java.lang.Class r9 = r10.deserializeUsing()
            java.lang.Class<java.lang.Void> r10 = java.lang.Void.class
            if (r9 == r10) goto L_0x0077
        L_0x0058:
            boolean r6 = r1 instanceof java.lang.String
            if (r6 == 0) goto L_0x006a
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            com.alibaba.fastjson.JSONValidator r7 = com.alibaba.fastjson.JSONValidator.from((java.lang.String) r6)
            boolean r7 = r7.validate()
            if (r7 == 0) goto L_0x006a
            goto L_0x006e
        L_0x006a:
            java.lang.String r6 = com.alibaba.fastjson.JSON.toJSONString(r1)
        L_0x006e:
            com.alibaba.fastjson.parser.DefaultJSONParser r1 = new com.alibaba.fastjson.parser.DefaultJSONParser
            r1.<init>((java.lang.String) r6)
            r5.parseField(r1, r0, r8, r4)
            goto L_0x001b
        L_0x0077:
            if (r7 == 0) goto L_0x0124
            java.lang.reflect.Method r9 = r6.method
            if (r9 != 0) goto L_0x0124
            java.lang.Class r9 = r7.getType()
            java.lang.Class r10 = java.lang.Boolean.TYPE
            if (r9 != r10) goto L_0x0095
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            if (r1 != r9) goto L_0x008d
            r7.setBoolean(r0, r3)
            goto L_0x001b
        L_0x008d:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            if (r1 != r9) goto L_0x0124
            r7.setBoolean(r0, r2)
            goto L_0x001b
        L_0x0095:
            java.lang.Class r10 = java.lang.Integer.TYPE
            if (r9 != r10) goto L_0x00a8
            boolean r9 = r1 instanceof java.lang.Number
            if (r9 == 0) goto L_0x0124
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r7.setInt(r0, r1)
            goto L_0x001b
        L_0x00a8:
            java.lang.Class r10 = java.lang.Long.TYPE
            if (r9 != r10) goto L_0x00bb
            boolean r9 = r1 instanceof java.lang.Number
            if (r9 == 0) goto L_0x0124
            java.lang.Number r1 = (java.lang.Number) r1
            long r5 = r1.longValue()
            r7.setLong(r0, r5)
            goto L_0x001b
        L_0x00bb:
            java.lang.Class r10 = java.lang.Float.TYPE
            r11 = 10
            if (r9 != r10) goto L_0x00ea
            boolean r9 = r1 instanceof java.lang.Number
            if (r9 == 0) goto L_0x00d0
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            r7.setFloat(r0, r1)
            goto L_0x001b
        L_0x00d0:
            boolean r9 = r1 instanceof java.lang.String
            if (r9 == 0) goto L_0x0124
            java.lang.String r1 = (java.lang.String) r1
            int r5 = r1.length()
            if (r5 > r11) goto L_0x00e1
            float r1 = com.alibaba.fastjson.util.TypeUtils.parseFloat(r1)
            goto L_0x00e5
        L_0x00e1:
            float r1 = java.lang.Float.parseFloat(r1)
        L_0x00e5:
            r7.setFloat(r0, r1)
            goto L_0x001b
        L_0x00ea:
            java.lang.Class r10 = java.lang.Double.TYPE
            if (r9 != r10) goto L_0x0117
            boolean r9 = r1 instanceof java.lang.Number
            if (r9 == 0) goto L_0x00fd
            java.lang.Number r1 = (java.lang.Number) r1
            double r5 = r1.doubleValue()
            r7.setDouble(r0, r5)
            goto L_0x001b
        L_0x00fd:
            boolean r9 = r1 instanceof java.lang.String
            if (r9 == 0) goto L_0x0124
            java.lang.String r1 = (java.lang.String) r1
            int r5 = r1.length()
            if (r5 > r11) goto L_0x010e
            double r5 = com.alibaba.fastjson.util.TypeUtils.parseDouble(r1)
            goto L_0x0112
        L_0x010e:
            double r5 = java.lang.Double.parseDouble(r1)
        L_0x0112:
            r7.setDouble(r0, r5)
            goto L_0x001b
        L_0x0117:
            if (r1 == 0) goto L_0x0124
            java.lang.Class r9 = r1.getClass()
            if (r8 != r9) goto L_0x0124
            r7.set(r0, r1)
            goto L_0x001b
        L_0x0124:
            java.lang.String r6 = r6.format
            if (r6 == 0) goto L_0x0131
            java.lang.Class<java.util.Date> r7 = java.util.Date.class
            if (r8 != r7) goto L_0x0131
            java.util.Date r1 = com.alibaba.fastjson.util.TypeUtils.castToDate(r1, r6)
            goto L_0x015a
        L_0x0131:
            if (r6 == 0) goto L_0x014b
            boolean r7 = r8 instanceof java.lang.Class
            if (r7 == 0) goto L_0x014b
            r7 = r8
            java.lang.Class r7 = (java.lang.Class) r7
            java.lang.String r7 = r7.getName()
            java.lang.String r9 = "java.time.LocalDateTime"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x014b
            java.lang.Object r1 = com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.castToLocalDateTime(r1, r6)
            goto L_0x015a
        L_0x014b:
            boolean r6 = r8 instanceof java.lang.reflect.ParameterizedType
            if (r6 == 0) goto L_0x0156
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8
            java.lang.Object r1 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r1, (java.lang.reflect.ParameterizedType) r8, (com.alibaba.fastjson.parser.ParserConfig) r14)
            goto L_0x015a
        L_0x0156:
            java.lang.Object r1 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r1, (java.lang.reflect.Type) r8, (com.alibaba.fastjson.parser.ParserConfig) r14)
        L_0x015a:
            r5.setValue((java.lang.Object) r0, (java.lang.Object) r1)
            goto L_0x001b
        L_0x015f:
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r12.beanInfo
            java.lang.reflect.Method r13 = r13.buildMethod
            if (r13 == 0) goto L_0x0173
            java.lang.Object r13 = r13.invoke(r0, r4)     // Catch:{ Exception -> 0x016a }
            return r13
        L_0x016a:
            r13 = move-exception
            com.alibaba.fastjson.JSONException r14 = new com.alibaba.fastjson.JSONException
            java.lang.String r0 = "build object error"
            r14.<init>(r0, r13)
            throw r14
        L_0x0173:
            return r0
        L_0x0174:
            com.alibaba.fastjson.util.FieldInfo[] r0 = r0.fields
            int r1 = r0.length
            java.lang.Object[] r5 = new java.lang.Object[r1]
            r7 = r4
            r6 = 0
        L_0x017b:
            if (r6 >= r1) goto L_0x01e9
            r8 = r0[r6]
            java.lang.String r9 = r8.name
            java.lang.Object r9 = r13.get(r9)
            if (r9 != 0) goto L_0x01e5
            java.lang.Class<?> r10 = r8.fieldClass
            java.lang.Class r11 = java.lang.Integer.TYPE
            if (r10 != r11) goto L_0x0192
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            goto L_0x01d5
        L_0x0192:
            java.lang.Class r11 = java.lang.Long.TYPE
            if (r10 != r11) goto L_0x019d
            r9 = 0
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            goto L_0x01d5
        L_0x019d:
            java.lang.Class r11 = java.lang.Short.TYPE
            if (r10 != r11) goto L_0x01a6
            java.lang.Short r9 = java.lang.Short.valueOf(r3)
            goto L_0x01d5
        L_0x01a6:
            java.lang.Class r11 = java.lang.Byte.TYPE
            if (r10 != r11) goto L_0x01af
            java.lang.Byte r9 = java.lang.Byte.valueOf(r3)
            goto L_0x01d5
        L_0x01af:
            java.lang.Class r11 = java.lang.Float.TYPE
            if (r10 != r11) goto L_0x01b9
            r9 = 0
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            goto L_0x01d5
        L_0x01b9:
            java.lang.Class r11 = java.lang.Double.TYPE
            if (r10 != r11) goto L_0x01c4
            r9 = 0
            java.lang.Double r9 = java.lang.Double.valueOf(r9)
            goto L_0x01d5
        L_0x01c4:
            java.lang.Class r11 = java.lang.Character.TYPE
            if (r10 != r11) goto L_0x01cf
            r9 = 48
            java.lang.Character r9 = java.lang.Character.valueOf(r9)
            goto L_0x01d5
        L_0x01cf:
            java.lang.Class r11 = java.lang.Boolean.TYPE
            if (r10 != r11) goto L_0x01d5
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
        L_0x01d5:
            if (r7 != 0) goto L_0x01dc
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
        L_0x01dc:
            java.lang.String r8 = r8.name
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)
            r7.put(r8, r10)
        L_0x01e5:
            r5[r6] = r9
            int r6 = r6 + r2
            goto L_0x017b
        L_0x01e9:
            if (r7 == 0) goto L_0x0222
            java.util.Set r13 = r13.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x01f3:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x0222
            java.lang.Object r0 = r13.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r6 = r0.getKey()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r0 = r0.getValue()
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r6 = r12.smartMatch(r6)
            if (r6 == 0) goto L_0x01f3
            com.alibaba.fastjson.util.FieldInfo r6 = r6.fieldInfo
            java.lang.String r6 = r6.name
            java.lang.Object r6 = r7.get(r6)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L_0x01f3
            int r6 = r6.intValue()
            r5[r6] = r0
            goto L_0x01f3
        L_0x0222:
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r12.beanInfo
            java.lang.reflect.Constructor<?> r0 = r13.creatorConstructor
            if (r0 == 0) goto L_0x02cc
            boolean r13 = r13.f1149kotlin
            if (r13 == 0) goto L_0x025d
            r13 = 0
            r0 = 0
        L_0x022e:
            if (r13 >= r1) goto L_0x025e
            r6 = r5[r13]
            if (r6 != 0) goto L_0x0247
            com.alibaba.fastjson.util.JavaBeanInfo r6 = r12.beanInfo
            com.alibaba.fastjson.util.FieldInfo[] r6 = r6.fields
            if (r6 == 0) goto L_0x025b
            int r7 = r6.length
            if (r13 >= r7) goto L_0x025b
            r6 = r6[r13]
            java.lang.Class<?> r6 = r6.fieldClass
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            if (r6 != r7) goto L_0x025b
            r0 = 1
            goto L_0x025b
        L_0x0247:
            java.lang.Class r7 = r6.getClass()
            com.alibaba.fastjson.util.JavaBeanInfo r8 = r12.beanInfo
            com.alibaba.fastjson.util.FieldInfo[] r8 = r8.fields
            r8 = r8[r13]
            java.lang.Class<?> r8 = r8.fieldClass
            if (r7 == r8) goto L_0x025b
            java.lang.Object r6 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r6, r8, (com.alibaba.fastjson.parser.ParserConfig) r14)
            r5[r13] = r6
        L_0x025b:
            int r13 = r13 + r2
            goto L_0x022e
        L_0x025d:
            r0 = 0
        L_0x025e:
            java.lang.String r13 = "create instance error, "
            if (r0 == 0) goto L_0x02a4
            com.alibaba.fastjson.util.JavaBeanInfo r14 = r12.beanInfo
            java.lang.reflect.Constructor<?> r14 = r14.kotlinDefaultConstructor
            if (r14 == 0) goto L_0x02a4
            java.lang.Object r14 = r14.newInstance(r4)     // Catch:{ Exception -> 0x0281 }
        L_0x026c:
            if (r3 >= r1) goto L_0x0285
            r0 = r5[r3]     // Catch:{ Exception -> 0x0281 }
            if (r0 == 0) goto L_0x0283
            com.alibaba.fastjson.util.JavaBeanInfo r4 = r12.beanInfo     // Catch:{ Exception -> 0x0281 }
            com.alibaba.fastjson.util.FieldInfo[] r4 = r4.fields     // Catch:{ Exception -> 0x0281 }
            if (r4 == 0) goto L_0x0283
            int r6 = r4.length     // Catch:{ Exception -> 0x0281 }
            if (r3 >= r6) goto L_0x0283
            r4 = r4[r3]     // Catch:{ Exception -> 0x0281 }
            r4.set(r14, r0)     // Catch:{ Exception -> 0x0281 }
            goto L_0x0283
        L_0x0281:
            r14 = move-exception
            goto L_0x0287
        L_0x0283:
            int r3 = r3 + r2
            goto L_0x026c
        L_0x0285:
            r4 = r14
            goto L_0x02f5
        L_0x0287:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r13)
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r12.beanInfo
            java.lang.reflect.Constructor<?> r13 = r13.creatorConstructor
            java.lang.String r13 = r13.toGenericString()
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            r0.<init>(r13, r14)
            throw r0
        L_0x02a4:
            com.alibaba.fastjson.util.JavaBeanInfo r14 = r12.beanInfo     // Catch:{ Exception -> 0x02ae }
            java.lang.reflect.Constructor<?> r14 = r14.creatorConstructor     // Catch:{ Exception -> 0x02ae }
            java.lang.Object r13 = r14.newInstance(r5)     // Catch:{ Exception -> 0x02ae }
            r4 = r13
            goto L_0x02f5
        L_0x02ae:
            r14 = move-exception
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r13)
            com.alibaba.fastjson.util.JavaBeanInfo r13 = r12.beanInfo
            java.lang.reflect.Constructor<?> r13 = r13.creatorConstructor
            java.lang.String r13 = r13.toGenericString()
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            r0.<init>(r13, r14)
            throw r0
        L_0x02cc:
            java.lang.reflect.Method r13 = r13.factoryMethod
            if (r13 == 0) goto L_0x02f5
            java.lang.Object r4 = r13.invoke(r4, r5)     // Catch:{ Exception -> 0x02d5 }
            goto L_0x02f5
        L_0x02d5:
            r13 = move-exception
            com.alibaba.fastjson.JSONException r14 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "create factory method error, "
            r0.append(r1)
            com.alibaba.fastjson.util.JavaBeanInfo r1 = r12.beanInfo
            java.lang.reflect.Method r1 = r1.factoryMethod
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0, r13)
            throw r14
        L_0x02f5:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.createInstance(java.util.Map, com.alibaba.fastjson.parser.ParserConfig):java.lang.Object");
    }
}
