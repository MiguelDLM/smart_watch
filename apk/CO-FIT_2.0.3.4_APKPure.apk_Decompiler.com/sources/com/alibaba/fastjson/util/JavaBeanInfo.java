package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public Type[] creatorConstructorParameterTypes;
    public String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;

    /* renamed from: kotlin  reason: collision with root package name */
    public boolean f1149kotlin;
    public Constructor<?> kotlinDefaultConstructor;
    public String[] orders;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    public JavaBeanInfo(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, JSONType jSONType, List<FieldInfo> list) {
        JSONField jSONField;
        this.clazz = cls;
        this.builderClass = cls2;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
        this.buildMethod = method2;
        this.jsonType = jSONType;
        if (jSONType != null) {
            String typeName2 = jSONType.typeName();
            String typeKey2 = jSONType.typeKey();
            this.typeKey = typeKey2.length() <= 0 ? null : typeKey2;
            if (typeName2.length() != 0) {
                this.typeName = typeName2;
            } else {
                this.typeName = cls.getName();
            }
            String[] orders2 = jSONType.orders();
            this.orders = orders2.length == 0 ? null : orders2;
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            this.orders = null;
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[list.size()];
        this.fields = fieldInfoArr;
        list.toArray(fieldInfoArr);
        FieldInfo[] fieldInfoArr2 = new FieldInfo[fieldInfoArr.length];
        int i = 0;
        if (this.orders != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
            for (FieldInfo fieldInfo : fieldInfoArr) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            int i2 = 0;
            for (String str : this.orders) {
                FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    fieldInfoArr2[i2] = fieldInfo2;
                    linkedHashMap.remove(str);
                    i2++;
                }
            }
            for (FieldInfo fieldInfo3 : linkedHashMap.values()) {
                fieldInfoArr2[i2] = fieldInfo3;
                i2++;
            }
        } else {
            System.arraycopy(fieldInfoArr, 0, fieldInfoArr2, 0, fieldInfoArr.length);
            Arrays.sort(fieldInfoArr2);
        }
        this.sortedFields = Arrays.equals(this.fields, fieldInfoArr2) ? this.fields : fieldInfoArr2;
        if (constructor != null) {
            this.defaultConstructorParameterSize = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.defaultConstructorParameterSize = method.getParameterTypes().length;
        } else {
            this.defaultConstructorParameterSize = 0;
        }
        if (constructor2 != null) {
            this.creatorConstructorParameterTypes = constructor2.getParameterTypes();
            boolean isKotlin = TypeUtils.isKotlin(cls);
            this.f1149kotlin = isKotlin;
            if (isKotlin) {
                this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(cls);
                try {
                    this.kotlinDefaultConstructor = cls.getConstructor((Class[]) null);
                } catch (Throwable unused) {
                }
                Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations((Constructor) constructor2);
                int i3 = 0;
                while (i3 < this.creatorConstructorParameters.length && i3 < parameterAnnotations.length) {
                    Annotation[] annotationArr = parameterAnnotations[i3];
                    int length = annotationArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            jSONField = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i4];
                        if (annotation instanceof JSONField) {
                            jSONField = (JSONField) annotation;
                            break;
                        }
                        i4++;
                    }
                    if (jSONField != null) {
                        String name = jSONField.name();
                        if (name.length() > 0) {
                            this.creatorConstructorParameters[i3] = name;
                        }
                    }
                    i3++;
                }
                return;
            }
            if (this.creatorConstructorParameterTypes.length == this.fields.length) {
                while (true) {
                    Type[] typeArr = this.creatorConstructorParameterTypes;
                    if (i >= typeArr.length) {
                        return;
                    }
                    if (typeArr[i] != this.fields[i].fieldClass) {
                        break;
                    }
                    i++;
                }
            }
            this.creatorConstructorParameters = ASMUtils.lookupParameterNames(constructor2);
        }
    }

    public static boolean add(List<FieldInfo> list, FieldInfo fieldInfo) {
        int size = list.size() - 1;
        while (size >= 0) {
            FieldInfo fieldInfo2 = list.get(size);
            if (!fieldInfo2.name.equals(fieldInfo.name) || (fieldInfo2.getOnly && !fieldInfo.getOnly)) {
                size--;
            } else if (fieldInfo2.fieldClass.isAssignableFrom(fieldInfo.fieldClass)) {
                list.set(size, fieldInfo);
                return true;
            } else if (fieldInfo2.compareTo(fieldInfo) >= 0) {
                return false;
            } else {
                list.set(size, fieldInfo);
                return true;
            }
        }
        list.add(fieldInfo);
        return true;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return build(cls, type, propertyNamingStrategy, false, TypeUtils.compatibleWithJavaBean, false);
    }

    private static Map<TypeVariable, Type> buildGenericInfo(Class<?> cls) {
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = null;
        if (superclass == null) {
            return null;
        }
        while (true) {
            Class<? super Object> cls2 = superclass;
            Class<?> cls3 = cls;
            cls = cls2;
            if (cls == null || cls == Object.class) {
                return hashMap;
            }
            if (cls3.getGenericSuperclass() instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) cls3.getGenericSuperclass()).getActualTypeArguments();
                TypeVariable[] typeParameters = cls.getTypeParameters();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    if (hashMap.containsKey(actualTypeArguments[i])) {
                        hashMap.put(typeParameters[i], hashMap.get(actualTypeArguments[i]));
                    } else {
                        hashMap.put(typeParameters[i], actualTypeArguments[i]);
                    }
                }
            }
            superclass = cls.getSuperclass();
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        if (java.util.concurrent.atomic.AtomicBoolean.class.equals(r2) == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void computeFields(java.lang.Class<?> r20, java.lang.reflect.Type r21, com.alibaba.fastjson.PropertyNamingStrategy r22, java.util.List<com.alibaba.fastjson.util.FieldInfo> r23, java.lang.reflect.Field[] r24) {
        /*
            r0 = r22
            r1 = r24
            java.util.Map r15 = buildGenericInfo(r20)
            int r14 = r1.length
            r16 = 0
            r13 = 0
        L_0x000c:
            if (r13 >= r14) goto L_0x00da
            r5 = r1[r13]
            int r2 = r5.getModifiers()
            r3 = r2 & 8
            if (r3 == 0) goto L_0x0020
        L_0x0018:
            r2 = r23
            r17 = r13
            r18 = r14
            goto L_0x00d4
        L_0x0020:
            r2 = r2 & 16
            if (r2 == 0) goto L_0x0050
            java.lang.Class r2 = r5.getType()
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 != 0) goto L_0x0050
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            boolean r3 = r3.isAssignableFrom(r2)
            if (r3 != 0) goto L_0x0050
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r3 = java.util.concurrent.atomic.AtomicLong.class
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x0050
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r3 = java.util.concurrent.atomic.AtomicInteger.class
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x0050
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r3 = java.util.concurrent.atomic.AtomicBoolean.class
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0018
        L_0x0050:
            java.util.Iterator r2 = r23.iterator()
        L_0x0054:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x006d
            java.lang.Object r3 = r2.next()
            com.alibaba.fastjson.util.FieldInfo r3 = (com.alibaba.fastjson.util.FieldInfo) r3
            java.lang.String r3 = r3.name
            java.lang.String r4 = r5.getName()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0054
            goto L_0x0018
        L_0x006d:
            java.lang.String r2 = r5.getName()
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r3 = com.alibaba.fastjson.annotation.JSONField.class
            java.lang.annotation.Annotation r3 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r5, r3)
            r12 = r3
            com.alibaba.fastjson.annotation.JSONField r12 = (com.alibaba.fastjson.annotation.JSONField) r12
            if (r12 == 0) goto L_0x00a9
            boolean r3 = r12.deserialize()
            if (r3 != 0) goto L_0x0083
            goto L_0x0018
        L_0x0083:
            int r3 = r12.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r12.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            com.alibaba.fastjson.parser.Feature[] r6 = r12.parseFeatures()
            int r6 = com.alibaba.fastjson.parser.Feature.of(r6)
            java.lang.String r7 = r12.name()
            int r7 = r7.length()
            if (r7 == 0) goto L_0x00a5
            java.lang.String r2 = r12.name()
        L_0x00a5:
            r8 = r3
            r9 = r4
            r10 = r6
            goto L_0x00ac
        L_0x00a9:
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x00ac:
            if (r0 == 0) goto L_0x00b2
            java.lang.String r2 = r0.translate(r2)
        L_0x00b2:
            r3 = r2
            com.alibaba.fastjson.util.FieldInfo r11 = new com.alibaba.fastjson.util.FieldInfo
            r17 = 0
            r18 = 0
            r4 = 0
            r2 = r11
            r6 = r20
            r7 = r21
            r19 = r11
            r11 = r17
            r17 = r13
            r13 = r18
            r18 = r14
            r14 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r2 = r23
            r3 = r19
            add(r2, r3)
        L_0x00d4:
            int r13 = r17 + 1
            r14 = r18
            goto L_0x000c
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.JavaBeanInfo.computeFields(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy, java.util.List, java.lang.reflect.Field[]):void");
    }

    public static Class<?> getBuilderClass(JSONType jSONType) {
        return getBuilderClass((Class<?>) null, jSONType);
    }

    public static Constructor<?> getCreatorConstructor(Constructor[] constructorArr) {
        Constructor<?> constructor = null;
        for (Constructor<?> constructor2 : constructorArr) {
            if (((JSONCreator) constructor2.getAnnotation(JSONCreator.class)) != null) {
                if (constructor == null) {
                    constructor = constructor2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        if (constructor != null) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Annotation[][] parameterAnnotations = TypeUtils.getParameterAnnotations((Constructor) constructor3);
            if (parameterAnnotations.length != 0) {
                int length = parameterAnnotations.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Annotation[] annotationArr = parameterAnnotations[i];
                        int length2 = annotationArr.length;
                        int i2 = 0;
                        while (i2 < length2) {
                            if (annotationArr[i2] instanceof JSONField) {
                                i++;
                            } else {
                                i2++;
                            }
                        }
                        break;
                    } else if (constructor == null) {
                        constructor = constructor3;
                    } else {
                        throw new JSONException("multi-JSONCreator");
                    }
                }
            }
        }
        return constructor;
    }

    public static Constructor<?> getDefaultConstructor(Class<?> cls, Constructor<?>[] constructorArr) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        int length = constructorArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Constructor<?> constructor2 = constructorArr[i];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i++;
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : constructorArr) {
            Class[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    private static Method getFactoryMethod(Class<?> cls, Method[] methodArr, boolean z) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((JSONCreator) TypeUtils.getAnnotation(method2, JSONCreator.class)) != null) {
                if (method == null) {
                    method = method2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        if (method != null || !z) {
            return method;
        }
        for (Method method3 : methodArr) {
            if (TypeUtils.isJacksonCreator(method3)) {
                return method3;
            }
        }
        return method;
    }

    private static FieldInfo getField(List<FieldInfo> list, String str) {
        for (FieldInfo next : list) {
            if (next.name.equals(str)) {
                return next;
            }
            Field field = next.field;
            if (field != null && next.getAnnotation() != null && field.getName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static JavaBeanInfo build(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy, boolean z, boolean z2) {
        return build(cls, type, propertyNamingStrategy, z, z2, false);
    }

    public static Class<?> getBuilderClass(Class<?> cls, JSONType jSONType) {
        Class<?> builder;
        if (cls != null && cls.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest")) {
            return TypeUtils.loadClass("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
        }
        if (jSONType == null || (builder = jSONType.builder()) == Void.class) {
            return null;
        }
        return builder;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v1, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v2, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v3, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v4, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v5, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v6, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v7, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v8, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v9, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v11, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v12, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v13, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v14, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v15, resolved type: java.lang.reflect.Field} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v154, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v155, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v157, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v70, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r6v6, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r6v24 */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = r12.naming();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x08cf, code lost:
        r0 = r0.substring(3);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x05ba  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x05c7  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x07b2  */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x0954  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0961  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x0986  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0989  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0a23  */
    /* JADX WARNING: Removed duplicated region for block: B:414:0x0a3a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x0bb1  */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x0bbd  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.fastjson.util.JavaBeanInfo build(java.lang.Class<?> r57, java.lang.reflect.Type r58, com.alibaba.fastjson.PropertyNamingStrategy r59, boolean r60, boolean r61, boolean r62) {
        /*
            r13 = r57
            r14 = r58
            r9 = r62
            r15 = 1
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r0 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r13, r0)
            r12 = r0
            com.alibaba.fastjson.annotation.JSONType r12 = (com.alibaba.fastjson.annotation.JSONType) r12
            if (r12 == 0) goto L_0x001e
            com.alibaba.fastjson.PropertyNamingStrategy r0 = r12.naming()
            if (r0 == 0) goto L_0x001e
            com.alibaba.fastjson.PropertyNamingStrategy r1 = com.alibaba.fastjson.PropertyNamingStrategy.CamelCase
            if (r0 == r1) goto L_0x001e
            r11 = r0
            goto L_0x0020
        L_0x001e:
            r11 = r59
        L_0x0020:
            java.lang.Class r10 = getBuilderClass(r13, r12)
            java.lang.reflect.Field[] r8 = r57.getDeclaredFields()
            java.lang.reflect.Method[] r7 = r57.getMethods()
            java.util.Map r16 = buildGenericInfo(r57)
            boolean r17 = com.alibaba.fastjson.util.TypeUtils.isKotlin(r57)
            java.lang.reflect.Constructor[] r0 = r57.getDeclaredConstructors()
            if (r17 == 0) goto L_0x0041
            int r1 = r0.length
            if (r1 != r15) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r18 = 0
            goto L_0x0053
        L_0x0041:
            if (r10 != 0) goto L_0x004a
            java.lang.reflect.Constructor r1 = getDefaultConstructor(r13, r0)
        L_0x0047:
            r18 = r1
            goto L_0x0053
        L_0x004a:
            java.lang.reflect.Constructor[] r1 = r10.getDeclaredConstructors()
            java.lang.reflect.Constructor r1 = getDefaultConstructor(r10, r1)
            goto L_0x0047
        L_0x0053:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r19 = 0
            r20 = 0
            if (r60 == 0) goto L_0x0085
            r0 = r13
        L_0x005f:
            if (r0 == 0) goto L_0x006d
            java.lang.reflect.Field[] r1 = r0.getDeclaredFields()
            computeFields(r13, r14, r11, r5, r1)
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x005f
        L_0x006d:
            if (r18 == 0) goto L_0x0072
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r18)
        L_0x0072:
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r4 = 0
            r0 = r9
            r1 = r57
            r2 = r10
            r3 = r18
            r8 = r5
            r5 = r20
            r6 = r19
            r7 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0085:
            boolean r1 = r57.isInterface()
            if (r1 != 0) goto L_0x0098
            int r1 = r57.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isAbstract(r1)
            if (r1 == 0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r1 = 0
            goto L_0x0099
        L_0x0098:
            r1 = 1
        L_0x0099:
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            r59 = r11
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r15 = com.alibaba.fastjson.annotation.JSONField.class
            if (r18 != 0) goto L_0x00a7
            if (r10 == 0) goto L_0x00a9
        L_0x00a7:
            if (r1 == 0) goto L_0x0488
        L_0x00a9:
            java.lang.reflect.Type r4 = com.alibaba.fastjson.JSON.getMixInAnnotations(r57)
            boolean r6 = r4 instanceof java.lang.Class
            if (r6 == 0) goto L_0x00c7
            java.lang.Class r4 = (java.lang.Class) r4
            java.lang.reflect.Constructor[] r4 = r4.getConstructors()
            java.lang.reflect.Constructor r4 = getCreatorConstructor(r4)
            if (r4 == 0) goto L_0x00c7
            java.lang.Class[] r4 = r4.getParameterTypes()     // Catch:{ NoSuchMethodException -> 0x00c6 }
            java.lang.reflect.Constructor r4 = r13.getConstructor(r4)     // Catch:{ NoSuchMethodException -> 0x00c6 }
            goto L_0x00c8
        L_0x00c6:
        L_0x00c7:
            r4 = 0
        L_0x00c8:
            if (r4 != 0) goto L_0x00ce
            java.lang.reflect.Constructor r4 = getCreatorConstructor(r0)
        L_0x00ce:
            r24 = r4
            if (r24 == 0) goto L_0x01c8
            if (r1 != 0) goto L_0x01c8
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r24)
            java.lang.Class[] r9 = r24.getParameterTypes()
            int r0 = r9.length
            if (r0 <= 0) goto L_0x01b1
            java.lang.annotation.Annotation[][] r6 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Constructor) r24)
            r0 = 0
            r4 = 0
        L_0x00e4:
            int r1 = r9.length
            if (r4 >= r1) goto L_0x01b1
            int r1 = r6.length
            if (r4 >= r1) goto L_0x01b1
            r1 = r6[r4]
            int r14 = r1.length
            r26 = r2
            r2 = 0
        L_0x00f0:
            r27 = r3
            if (r2 >= r14) goto L_0x0106
            r3 = r1[r2]
            r62 = r1
            boolean r1 = r3 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r1 == 0) goto L_0x00ff
            com.alibaba.fastjson.annotation.JSONField r3 = (com.alibaba.fastjson.annotation.JSONField) r3
            goto L_0x0107
        L_0x00ff:
            r1 = 1
            int r2 = r2 + r1
            r1 = r62
            r3 = r27
            goto L_0x00f0
        L_0x0106:
            r3 = 0
        L_0x0107:
            r14 = r9[r4]
            java.lang.reflect.Type[] r1 = r24.getGenericParameterTypes()
            r28 = r1[r4]
            if (r3 == 0) goto L_0x0138
            java.lang.String r1 = r3.name()
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r1, r8)
            int r2 = r3.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r29 = r3.serialzeFeatures()
            int r29 = com.alibaba.fastjson.serializer.SerializerFeature.of(r29)
            com.alibaba.fastjson.parser.Feature[] r30 = r3.parseFeatures()
            int r30 = com.alibaba.fastjson.parser.Feature.of(r30)
            java.lang.String r3 = r3.name()
            r31 = r30
            r30 = r29
            r29 = r2
            goto L_0x0140
        L_0x0138:
            r1 = 0
            r3 = 0
            r29 = 0
            r30 = 0
            r31 = 0
        L_0x0140:
            if (r3 == 0) goto L_0x014b
            int r2 = r3.length()
            if (r2 != 0) goto L_0x0149
            goto L_0x014b
        L_0x0149:
            r2 = r3
            goto L_0x0153
        L_0x014b:
            if (r0 != 0) goto L_0x0151
            java.lang.String[] r0 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r24)
        L_0x0151:
            r2 = r0[r4]
        L_0x0153:
            if (r1 != 0) goto L_0x016b
            if (r0 != 0) goto L_0x0162
            if (r17 == 0) goto L_0x015e
            java.lang.String[] r0 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(r57)
            goto L_0x0162
        L_0x015e:
            java.lang.String[] r0 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r24)
        L_0x0162:
            int r3 = r0.length
            if (r3 <= r4) goto L_0x016b
            r1 = r0[r4]
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r1, r8)
        L_0x016b:
            r32 = r0
            r33 = r1
            com.alibaba.fastjson.util.FieldInfo r3 = new com.alibaba.fastjson.util.FieldInfo
            r0 = r3
            r1 = r2
            r34 = r15
            r15 = r26
            r2 = r57
            r62 = r9
            r35 = r27
            r9 = r3
            r3 = r14
            r22 = r4
            r14 = 0
            r4 = r28
            r14 = r5
            r5 = r33
            r23 = r6
            r6 = r29
            r27 = r15
            r15 = r7
            r7 = r30
            r28 = r11
            r11 = r8
            r8 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r14, r9)
            r0 = 1
            int r4 = r22 + 1
            r9 = r62
            r8 = r11
            r5 = r14
            r7 = r15
            r6 = r23
            r2 = r27
            r11 = r28
            r0 = r32
            r15 = r34
            r3 = r35
            goto L_0x00e4
        L_0x01b1:
            r27 = r2
            r35 = r3
            r14 = r5
            r28 = r11
            r34 = r15
            r15 = r7
            r11 = r8
        L_0x01bc:
            r38 = r27
            r29 = r28
            r37 = r35
            r27 = r11
            r11 = r34
            goto L_0x0495
        L_0x01c8:
            r27 = r2
            r35 = r3
            r14 = r5
            r28 = r11
            r34 = r15
            r15 = r7
            r11 = r8
            java.lang.reflect.Method r20 = getFactoryMethod(r13, r15, r9)
            if (r20 == 0) goto L_0x028f
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r20)
            java.lang.Class[] r8 = r20.getParameterTypes()
            int r0 = r8.length
            if (r0 <= 0) goto L_0x01bc
            java.lang.annotation.Annotation[][] r15 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Method) r20)
            r6 = 0
            r7 = 0
        L_0x01e9:
            int r0 = r8.length
            if (r7 >= r0) goto L_0x027e
            r0 = r15[r7]
            int r1 = r0.length
            r4 = 0
        L_0x01f0:
            if (r4 >= r1) goto L_0x01ff
            r2 = r0[r4]
            boolean r3 = r2 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r3 == 0) goto L_0x01fc
            r0 = r2
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            goto L_0x0200
        L_0x01fc:
            r2 = 1
            int r4 = r4 + r2
            goto L_0x01f0
        L_0x01ff:
            r0 = 0
        L_0x0200:
            if (r0 != 0) goto L_0x0213
            if (r9 == 0) goto L_0x020b
            boolean r1 = com.alibaba.fastjson.util.TypeUtils.isJacksonCreator(r20)
            if (r1 == 0) goto L_0x020b
            goto L_0x0213
        L_0x020b:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "illegal json creator"
            r0.<init>(r1)
            throw r0
        L_0x0213:
            if (r0 == 0) goto L_0x0234
            java.lang.String r1 = r0.name()
            int r2 = r0.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r3 = r0.serialzeFeatures()
            int r3 = com.alibaba.fastjson.serializer.SerializerFeature.of(r3)
            com.alibaba.fastjson.parser.Feature[] r0 = r0.parseFeatures()
            int r0 = com.alibaba.fastjson.parser.Feature.of(r0)
            r18 = r0
            r16 = r2
            r17 = r3
            goto L_0x023b
        L_0x0234:
            r1 = 0
            r16 = 0
            r17 = 0
            r18 = 0
        L_0x023b:
            if (r1 == 0) goto L_0x0247
            int r0 = r1.length()
            if (r0 != 0) goto L_0x0244
            goto L_0x0247
        L_0x0244:
            r19 = r6
            goto L_0x0251
        L_0x0247:
            if (r6 != 0) goto L_0x024d
            java.lang.String[] r6 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r20)
        L_0x024d:
            r0 = r6[r7]
            r1 = r0
            goto L_0x0244
        L_0x0251:
            r3 = r8[r7]
            java.lang.reflect.Type[] r0 = r20.getGenericParameterTypes()
            r4 = r0[r7]
            java.lang.reflect.Field r5 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r1, r11)
            com.alibaba.fastjson.util.FieldInfo r6 = new com.alibaba.fastjson.util.FieldInfo
            r0 = r6
            r2 = r57
            r9 = r6
            r6 = r16
            r16 = r7
            r7 = r17
            r17 = r8
            r8 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r14, r9)
            r0 = 1
            int r7 = r16 + 1
            r9 = r62
            r8 = r17
            r6 = r19
            goto L_0x01e9
        L_0x027e:
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r4 = 0
            r6 = 0
            r3 = 0
            r0 = r9
            r1 = r57
            r2 = r10
            r5 = r20
            r7 = r12
            r8 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x028f:
            if (r1 != 0) goto L_0x01bc
            java.lang.String r9 = r57.getName()
            if (r17 == 0) goto L_0x02ae
            int r1 = r0.length
            if (r1 <= 0) goto L_0x02ae
            java.lang.String[] r1 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(r57)
            java.lang.reflect.Constructor r0 = com.alibaba.fastjson.util.TypeUtils.getKotlinConstructor(r0, r1)
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r0)
            r24 = r0
            r7 = r1
            r5 = r27
            r8 = r28
            goto L_0x037a
        L_0x02ae:
            int r1 = r0.length
            r4 = 0
            r6 = 0
        L_0x02b1:
            if (r4 >= r1) goto L_0x0375
            r2 = r0[r4]
            java.lang.Class[] r3 = r2.getParameterTypes()
            java.lang.String r5 = "org.springframework.security.web.authentication.WebAuthenticationDetails"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x02e8
            int r5 = r3.length
            r7 = 2
            if (r5 != r7) goto L_0x02e5
            r5 = 0
            r7 = r3[r5]
            r8 = r28
            if (r7 != r8) goto L_0x02df
            r5 = 1
            r3 = r3[r5]
            if (r3 != r8) goto L_0x02df
            r2.setAccessible(r5)
            java.lang.String[] r1 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r2)
            r7 = r1
            r24 = r2
            r5 = r27
            goto L_0x037a
        L_0x02df:
            r23 = r0
            r5 = r27
            goto L_0x036b
        L_0x02e5:
            r8 = r28
            goto L_0x02df
        L_0x02e8:
            r8 = r28
            java.lang.String r5 = "org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0328
            int r5 = r3.length
            r7 = 3
            if (r5 != r7) goto L_0x02df
            r5 = 0
            r7 = r3[r5]
            r5 = r27
            r23 = r0
            if (r7 != r5) goto L_0x036b
            r7 = 1
            r0 = r3[r7]
            if (r0 != r5) goto L_0x036b
            r0 = 2
            r3 = r3[r0]
            r0 = r35
            if (r3 != r0) goto L_0x0325
            r2.setAccessible(r7)
            r1 = 3
            java.lang.String[] r3 = new java.lang.String[r1]
            java.lang.String r1 = "principal"
            r4 = 0
            r3[r4] = r1
            java.lang.String r1 = "credentials"
            r3[r7] = r1
            java.lang.String r1 = "authorities"
            r4 = 2
            r3[r4] = r1
            r35 = r0
            r24 = r2
            r7 = r3
            goto L_0x037a
        L_0x0325:
            r35 = r0
            goto L_0x036b
        L_0x0328:
            r23 = r0
            r5 = r27
            r0 = r35
            java.lang.String r7 = "org.springframework.security.core.authority.SimpleGrantedAuthority"
            boolean r7 = r9.equals(r7)
            if (r7 == 0) goto L_0x034b
            int r7 = r3.length
            r35 = r0
            r0 = 1
            if (r7 != r0) goto L_0x036b
            r7 = 0
            r3 = r3[r7]
            if (r3 != r8) goto L_0x036b
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r3 = "authority"
            r1[r7] = r3
            r7 = r1
            r24 = r2
            goto L_0x037a
        L_0x034b:
            r35 = r0
            r0 = 1
            int r3 = r2.getModifiers()
            r3 = r3 & r0
            if (r3 == 0) goto L_0x036b
            java.lang.String[] r0 = com.alibaba.fastjson.util.ASMUtils.lookupParameterNames(r2)
            if (r0 == 0) goto L_0x036b
            int r3 = r0.length
            if (r3 != 0) goto L_0x035f
            goto L_0x036b
        L_0x035f:
            if (r24 == 0) goto L_0x0368
            if (r6 == 0) goto L_0x0368
            int r3 = r0.length
            int r7 = r6.length
            if (r3 > r7) goto L_0x0368
            goto L_0x036b
        L_0x0368:
            r6 = r0
            r24 = r2
        L_0x036b:
            r0 = 1
            int r4 = r4 + r0
            r27 = r5
            r28 = r8
            r0 = r23
            goto L_0x02b1
        L_0x0375:
            r5 = r27
            r8 = r28
            r7 = r6
        L_0x037a:
            if (r7 == 0) goto L_0x0381
            java.lang.Class[] r6 = r24.getParameterTypes()
            goto L_0x0382
        L_0x0381:
            r6 = 0
        L_0x0382:
            if (r7 == 0) goto L_0x0471
            int r0 = r6.length
            int r1 = r7.length
            if (r0 != r1) goto L_0x0471
            java.lang.annotation.Annotation[][] r22 = com.alibaba.fastjson.util.TypeUtils.getParameterAnnotations((java.lang.reflect.Constructor) r24)
            r4 = 0
        L_0x038d:
            int r0 = r6.length
            if (r4 >= r0) goto L_0x0448
            r0 = r22[r4]
            r1 = r7[r4]
            int r2 = r0.length
            r3 = 0
        L_0x0396:
            if (r3 >= r2) goto L_0x03ad
            r23 = r2
            r2 = r0[r3]
            r62 = r0
            boolean r0 = r2 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r0 == 0) goto L_0x03a6
            r0 = r2
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            goto L_0x03ae
        L_0x03a6:
            r0 = 1
            int r3 = r3 + r0
            r0 = r62
            r2 = r23
            goto L_0x0396
        L_0x03ad:
            r0 = 0
        L_0x03ae:
            r3 = r6[r4]
            java.lang.reflect.Type[] r2 = r24.getGenericParameterTypes()
            r23 = r2[r4]
            java.lang.reflect.Field r2 = com.alibaba.fastjson.util.TypeUtils.getField(r13, r1, r11)
            if (r2 == 0) goto L_0x03c9
            if (r0 != 0) goto L_0x03c9
            r27 = r11
            r11 = r34
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r2, r11)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            goto L_0x03cd
        L_0x03c9:
            r27 = r11
            r11 = r34
        L_0x03cd:
            if (r0 != 0) goto L_0x03f1
            java.lang.String r0 = "org.springframework.security.core.userdetails.User"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x03ea
            java.lang.String r0 = "password"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x03ea
            com.alibaba.fastjson.parser.Feature r0 = com.alibaba.fastjson.parser.Feature.InitStringFieldAsEmpty
            int r0 = r0.mask
            r30 = r0
            r28 = 0
            r29 = 0
            goto L_0x0413
        L_0x03ea:
            r28 = 0
            r29 = 0
            r30 = 0
            goto L_0x0413
        L_0x03f1:
            java.lang.String r28 = r0.name()
            int r29 = r28.length()
            if (r29 == 0) goto L_0x03fd
            r1 = r28
        L_0x03fd:
            int r28 = r0.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r29 = r0.serialzeFeatures()
            int r29 = com.alibaba.fastjson.serializer.SerializerFeature.of(r29)
            com.alibaba.fastjson.parser.Feature[] r0 = r0.parseFeatures()
            int r0 = com.alibaba.fastjson.parser.Feature.of(r0)
            r30 = r0
        L_0x0413:
            com.alibaba.fastjson.util.FieldInfo r0 = new com.alibaba.fastjson.util.FieldInfo
            r62 = r0
            r37 = r35
            r31 = r2
            r2 = r57
            r32 = r4
            r4 = r23
            r38 = r5
            r5 = r31
            r23 = r6
            r6 = r28
            r28 = r7
            r7 = r29
            r29 = r8
            r8 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            add(r14, r0)
            r0 = 1
            int r4 = r32 + 1
            r34 = r11
            r6 = r23
            r11 = r27
            r7 = r28
            r8 = r29
            r5 = r38
            goto L_0x038d
        L_0x0448:
            r38 = r5
            r29 = r8
            r27 = r11
            r11 = r34
            r37 = r35
            if (r17 != 0) goto L_0x0495
            java.lang.String r0 = r57.getName()
            java.lang.String r1 = "javax.servlet.http.Cookie"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0495
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r5 = 0
            r6 = 0
            r3 = 0
            r0 = r9
            r1 = r57
            r2 = r10
            r4 = r24
            r7 = r12
            r8 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0471:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "default constructor not found. "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0488:
            r38 = r2
            r37 = r3
            r14 = r5
            r27 = r8
            r29 = r11
            r11 = r15
            r15 = r7
            r24 = 0
        L_0x0495:
            if (r18 == 0) goto L_0x049a
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r18)
        L_0x049a:
            java.lang.String r9 = "set"
            if (r10 == 0) goto L_0x069b
            java.lang.Class<com.alibaba.fastjson.annotation.JSONPOJOBuilder> r8 = com.alibaba.fastjson.annotation.JSONPOJOBuilder.class
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r10, r8)
            com.alibaba.fastjson.annotation.JSONPOJOBuilder r0 = (com.alibaba.fastjson.annotation.JSONPOJOBuilder) r0
            if (r0 == 0) goto L_0x04ad
            java.lang.String r6 = r0.withPrefix()
            goto L_0x04ae
        L_0x04ad:
            r6 = 0
        L_0x04ae:
            if (r6 != 0) goto L_0x04b3
            java.lang.String r6 = "with"
        L_0x04b3:
            r7 = r6
            java.lang.reflect.Method[] r6 = r10.getMethods()
            int r5 = r6.length
            r4 = 0
        L_0x04ba:
            if (r4 >= r5) goto L_0x0653
            r2 = r6[r4]
            int r0 = r2.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 == 0) goto L_0x04e3
        L_0x04c8:
            r43 = r59
            r33 = r4
            r34 = r5
            r35 = r6
            r22 = r7
            r40 = r8
            r48 = r9
            r42 = r10
            r46 = r11
            r44 = r27
            r45 = r29
            r0 = 1
            r27 = r12
            goto L_0x0639
        L_0x04e3:
            java.lang.Class r0 = r2.getReturnType()
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x04ee
            goto L_0x04c8
        L_0x04ee:
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Method) r2, r11)
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            if (r0 != 0) goto L_0x04fa
            com.alibaba.fastjson.annotation.JSONField r0 = com.alibaba.fastjson.util.TypeUtils.getSuperMethodAnnotation(r13, r2)
        L_0x04fa:
            r22 = r0
            if (r22 == 0) goto L_0x058c
            boolean r0 = r22.deserialize()
            if (r0 != 0) goto L_0x0505
            goto L_0x04c8
        L_0x0505:
            int r23 = r22.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r22.serialzeFeatures()
            int r28 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r22.parseFeatures()
            int r30 = com.alibaba.fastjson.parser.Feature.of(r0)
            java.lang.String r0 = r22.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x056d
            java.lang.String r1 = r22.name()
            com.alibaba.fastjson.util.FieldInfo r3 = new com.alibaba.fastjson.util.FieldInfo
            r31 = 0
            r32 = 0
            r33 = 0
            r0 = r3
            r39 = r3
            r3 = r33
            r33 = r4
            r4 = r57
            r34 = r5
            r5 = r58
            r35 = r6
            r6 = r23
            r62 = r7
            r7 = r28
            r40 = r8
            r8 = r30
            r41 = r9
            r9 = r22
            r42 = r10
            r10 = r31
            r43 = r59
            r46 = r11
            r44 = r27
            r45 = r29
            r11 = r32
            r27 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r39
            add(r14, r0)
            r22 = r62
            r48 = r41
        L_0x056a:
            r0 = 1
            goto L_0x0639
        L_0x056d:
            r43 = r59
            r33 = r4
            r34 = r5
            r35 = r6
            r62 = r7
            r40 = r8
            r41 = r9
            r42 = r10
            r46 = r11
            r44 = r27
            r45 = r29
            r27 = r12
            r6 = r23
            r7 = r28
            r8 = r30
            goto L_0x05a7
        L_0x058c:
            r43 = r59
            r33 = r4
            r34 = r5
            r35 = r6
            r62 = r7
            r40 = r8
            r41 = r9
            r42 = r10
            r46 = r11
            r44 = r27
            r45 = r29
            r27 = r12
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x05a7:
            java.lang.String r0 = r2.getName()
            r12 = r41
            boolean r1 = r0.startsWith(r12)
            if (r1 == 0) goto L_0x05c7
            int r1 = r0.length()
            r3 = 3
            if (r1 <= r3) goto L_0x05c7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r0 = r0.substring(r3)
            r1.<init>(r0)
        L_0x05c3:
            r11 = r62
        L_0x05c5:
            r0 = 0
            goto L_0x05f9
        L_0x05c7:
            int r1 = r62.length()
            if (r1 != 0) goto L_0x05d3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            goto L_0x05c3
        L_0x05d3:
            r11 = r62
            boolean r1 = r0.startsWith(r11)
            if (r1 != 0) goto L_0x05e0
        L_0x05db:
            r22 = r11
            r48 = r12
            goto L_0x056a
        L_0x05e0:
            int r1 = r0.length()
            int r3 = r11.length()
            if (r1 > r3) goto L_0x05eb
            goto L_0x05db
        L_0x05eb:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r3 = r11.length()
            java.lang.String r0 = r0.substring(r3)
            r1.<init>(r0)
            goto L_0x05c5
        L_0x05f9:
            char r3 = r1.charAt(r0)
            int r4 = r11.length()
            if (r4 == 0) goto L_0x060a
            boolean r4 = java.lang.Character.isUpperCase(r3)
            if (r4 != 0) goto L_0x060a
            goto L_0x05db
        L_0x060a:
            char r3 = java.lang.Character.toLowerCase(r3)
            r1.setCharAt(r0, r3)
            java.lang.String r1 = r1.toString()
            com.alibaba.fastjson.util.FieldInfo r10 = new com.alibaba.fastjson.util.FieldInfo
            r23 = 0
            r28 = 0
            r3 = 0
            r0 = r10
            r4 = r57
            r5 = r58
            r9 = r22
            r47 = r10
            r10 = r23
            r22 = r11
            r11 = r28
            r48 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r47
            add(r14, r0)
            goto L_0x056a
        L_0x0639:
            int r4 = r33 + 1
            r7 = r22
            r12 = r27
            r5 = r34
            r6 = r35
            r8 = r40
            r10 = r42
            r59 = r43
            r27 = r44
            r29 = r45
            r11 = r46
            r9 = r48
            goto L_0x04ba
        L_0x0653:
            r43 = r59
            r0 = r8
            r48 = r9
            r46 = r11
            r44 = r27
            r45 = r29
            r27 = r12
            r12 = r10
            java.lang.annotation.Annotation r0 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.Class<?>) r12, r0)
            com.alibaba.fastjson.annotation.JSONPOJOBuilder r0 = (com.alibaba.fastjson.annotation.JSONPOJOBuilder) r0
            if (r0 == 0) goto L_0x066e
            java.lang.String r6 = r0.buildMethod()
            goto L_0x066f
        L_0x066e:
            r6 = 0
        L_0x066f:
            if (r6 == 0) goto L_0x067a
            int r0 = r6.length()
            if (r0 != 0) goto L_0x0678
            goto L_0x067a
        L_0x0678:
            r11 = 0
            goto L_0x067d
        L_0x067a:
            java.lang.String r6 = "build"
            goto L_0x0678
        L_0x067d:
            java.lang.reflect.Method r19 = r12.getMethod(r6, r11)     // Catch:{ NoSuchMethodException | SecurityException -> 0x0682 }
            goto L_0x0683
        L_0x0682:
        L_0x0683:
            if (r19 != 0) goto L_0x068d
            java.lang.String r0 = "create"
            java.lang.reflect.Method r19 = r12.getMethod(r0, r11)     // Catch:{ NoSuchMethodException | SecurityException -> 0x068c }
            goto L_0x068d
        L_0x068c:
        L_0x068d:
            if (r19 == 0) goto L_0x0693
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r19)
            goto L_0x06a9
        L_0x0693:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "buildMethod not found."
            r0.<init>(r1)
            throw r0
        L_0x069b:
            r43 = r59
            r48 = r9
            r46 = r11
            r44 = r27
            r45 = r29
            r11 = 0
            r27 = r12
            r12 = r10
        L_0x06a9:
            int r10 = r15.length
            r9 = 0
        L_0x06ab:
            java.lang.String r8 = "get"
            r7 = 4
            if (r9 >= r10) goto L_0x0a8b
            r2 = r15[r9]
            java.lang.String r0 = r2.getName()
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x06de
        L_0x06c0:
            r34 = r9
            r35 = r10
            r30 = r11
            r31 = r12
            r25 = r15
            r33 = r38
        L_0x06cc:
            r53 = r43
            r32 = r45
            r52 = r46
            r41 = r48
            r0 = 1
            r26 = 0
            r29 = 2
        L_0x06d9:
            r36 = 3
            r15 = r13
            goto L_0x0a74
        L_0x06de:
            java.lang.Class r1 = r2.getReturnType()
            java.lang.Class r3 = java.lang.Void.TYPE
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x06f5
            java.lang.Class r3 = r2.getDeclaringClass()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x06f5
            goto L_0x06c0
        L_0x06f5:
            java.lang.Class r1 = r2.getDeclaringClass()
            r6 = r38
            if (r1 != r6) goto L_0x070a
        L_0x06fd:
            r33 = r6
            r34 = r9
            r35 = r10
            r30 = r11
            r31 = r12
            r25 = r15
            goto L_0x06cc
        L_0x070a:
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r3 = r1.length
            if (r3 == 0) goto L_0x0a58
            int r3 = r1.length
            r5 = 2
            if (r3 <= r5) goto L_0x0716
            goto L_0x06fd
        L_0x0716:
            r4 = r46
            java.lang.annotation.Annotation r3 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Method) r2, r4)
            r21 = r3
            com.alibaba.fastjson.annotation.JSONField r21 = (com.alibaba.fastjson.annotation.JSONField) r21
            r22 = 0
            r23 = 0
            r28 = 0
            if (r21 == 0) goto L_0x079e
            int r3 = r1.length
            if (r3 != r5) goto L_0x079e
            r3 = 0
            r5 = r1[r3]
            r3 = r45
            if (r5 != r3) goto L_0x078d
            r5 = 1
            r11 = r1[r5]
            if (r11 != r6) goto L_0x077c
            com.alibaba.fastjson.util.FieldInfo r11 = new com.alibaba.fastjson.util.FieldInfo
            r30 = 0
            r31 = 0
            java.lang.String r1 = ""
            r5 = 0
            r0 = r11
            r32 = r3
            r3 = r5
            r8 = r4
            r4 = r57
            r29 = 2
            r5 = r58
            r33 = r6
            r6 = r22
            r7 = r23
            r49 = r8
            r8 = r28
            r34 = r9
            r9 = r21
            r35 = r10
            r10 = r30
            r50 = r11
            r30 = 0
            r11 = r31
            r31 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r50
            add(r14, r0)
        L_0x076f:
            r25 = r15
            r53 = r43
            r41 = r48
            r52 = r49
            r0 = 1
            r26 = 0
            goto L_0x06d9
        L_0x077c:
            r32 = r3
            r49 = r4
            r33 = r6
            r34 = r9
            r35 = r10
            r31 = r12
            r29 = 2
            r30 = 0
            goto L_0x07ad
        L_0x078d:
            r32 = r3
            r49 = r4
            r33 = r6
            r34 = r9
            r35 = r10
            r30 = r11
            r31 = r12
        L_0x079b:
            r29 = 2
            goto L_0x07ad
        L_0x079e:
            r49 = r4
            r33 = r6
            r34 = r9
            r35 = r10
            r30 = r11
            r31 = r12
            r32 = r45
            goto L_0x079b
        L_0x07ad:
            int r3 = r1.length
            r4 = 1
            if (r3 == r4) goto L_0x07b2
        L_0x07b1:
            goto L_0x076f
        L_0x07b2:
            if (r21 != 0) goto L_0x07ba
            com.alibaba.fastjson.annotation.JSONField r3 = com.alibaba.fastjson.util.TypeUtils.getSuperMethodAnnotation(r13, r2)
            r9 = r3
            goto L_0x07bc
        L_0x07ba:
            r9 = r21
        L_0x07bc:
            if (r9 != 0) goto L_0x07c5
            int r3 = r0.length()
            if (r3 >= r7) goto L_0x07c5
            goto L_0x07b1
        L_0x07c5:
            if (r9 == 0) goto L_0x0822
            boolean r3 = r9.deserialize()
            if (r3 != 0) goto L_0x07ce
            goto L_0x07b1
        L_0x07ce:
            int r6 = r9.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r3 = r9.serialzeFeatures()
            int r10 = com.alibaba.fastjson.serializer.SerializerFeature.of(r3)
            com.alibaba.fastjson.parser.Feature[] r3 = r9.parseFeatures()
            int r11 = com.alibaba.fastjson.parser.Feature.of(r3)
            java.lang.String r3 = r9.name()
            int r3 = r3.length()
            if (r3 == 0) goto L_0x081c
            java.lang.String r1 = r9.name()
            com.alibaba.fastjson.util.FieldInfo r12 = new com.alibaba.fastjson.util.FieldInfo
            r21 = 0
            r22 = 0
            r3 = 0
            r0 = r12
            r4 = r57
            r5 = r58
            r7 = r10
            r8 = r11
            r10 = r21
            r11 = r22
            r13 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            add(r14, r13)
            r0 = 1
            r26 = 0
            r36 = 3
            r25 = r15
            r53 = r43
            r41 = r48
        L_0x0816:
            r52 = r49
            r15 = r57
            goto L_0x0a74
        L_0x081c:
            r22 = r6
            r23 = r10
            r28 = r11
        L_0x0822:
            r13 = r48
            if (r9 != 0) goto L_0x0839
            boolean r3 = r0.startsWith(r13)
            if (r3 == 0) goto L_0x082d
            goto L_0x0839
        L_0x082d:
            r0 = 1
            r26 = 0
            r36 = 3
            r41 = r13
            r25 = r15
            r53 = r43
            goto L_0x0816
        L_0x0839:
            if (r31 == 0) goto L_0x083c
            goto L_0x082d
        L_0x083c:
            r3 = 3
            char r4 = r0.charAt(r3)
            if (r17 == 0) goto L_0x0864
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r3 = 0
        L_0x0849:
            int r5 = r15.length
            if (r3 >= r5) goto L_0x0866
            r5 = r15[r3]
            java.lang.String r5 = r5.getName()
            boolean r5 = r5.startsWith(r8)
            if (r5 == 0) goto L_0x0861
            r5 = r15[r3]
            java.lang.String r5 = r5.getName()
            r6.add(r5)
        L_0x0861:
            r5 = 1
            int r3 = r3 + r5
            goto L_0x0849
        L_0x0864:
            r6 = r30
        L_0x0866:
            boolean r3 = java.lang.Character.isUpperCase(r4)
            java.lang.String r5 = "is"
            java.lang.String r8 = "g"
            if (r3 != 0) goto L_0x0874
            r3 = 512(0x200, float:7.175E-43)
            if (r4 <= r3) goto L_0x087a
        L_0x0874:
            r12 = r57
            r11 = r44
            goto L_0x0921
        L_0x087a:
            r3 = 95
            if (r4 != r3) goto L_0x08db
            if (r17 == 0) goto L_0x08c0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r8)
            r4 = 1
            java.lang.String r7 = r0.substring(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            boolean r3 = r6.contains(r3)
            if (r3 == 0) goto L_0x08a4
            r3 = 3
            java.lang.String r0 = r0.substring(r3)
        L_0x089f:
            r12 = r57
            r11 = r44
            goto L_0x08b9
        L_0x08a4:
            r3 = 3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r5)
            java.lang.String r0 = r0.substring(r3)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            goto L_0x089f
        L_0x08b9:
            java.lang.reflect.Field r6 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r0, r11)
        L_0x08bd:
            r10 = 3
            goto L_0x0952
        L_0x08c0:
            r3 = 3
            r12 = r57
            r11 = r44
            java.lang.String r4 = r0.substring(r7)
            java.lang.reflect.Field r6 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r4, r11)
            if (r6 != 0) goto L_0x08d9
            java.lang.String r0 = r0.substring(r3)
            java.lang.reflect.Field r6 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r0, r11)
            if (r6 != 0) goto L_0x08bd
        L_0x08d9:
            r0 = r4
            goto L_0x08bd
        L_0x08db:
            r3 = 3
            r12 = r57
            r11 = r44
            r6 = 102(0x66, float:1.43E-43)
            if (r4 != r6) goto L_0x08eb
            java.lang.String r0 = r0.substring(r3)
        L_0x08e8:
            r6 = r30
            goto L_0x08bd
        L_0x08eb:
            int r4 = r0.length()
            r6 = 5
            if (r4 < r6) goto L_0x0905
            char r4 = r0.charAt(r7)
            boolean r4 = java.lang.Character.isUpperCase(r4)
            if (r4 == 0) goto L_0x0905
            java.lang.String r0 = r0.substring(r3)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
            goto L_0x08e8
        L_0x0905:
            java.lang.String r0 = r0.substring(r3)
            java.lang.reflect.Field r6 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r0, r11)
            if (r6 != 0) goto L_0x08bd
            r44 = r11
            r41 = r13
            r25 = r15
            r53 = r43
            r52 = r49
        L_0x0919:
            r0 = 1
            r26 = 0
            r36 = 3
            r15 = r12
            goto L_0x0a74
        L_0x0921:
            if (r17 == 0) goto L_0x093c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r8)
            r4 = 1
            java.lang.String r0 = r0.substring(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(r0)
            goto L_0x08e8
        L_0x093c:
            boolean r3 = com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean
            if (r3 == 0) goto L_0x094c
            r10 = 3
            java.lang.String r0 = r0.substring(r10)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
        L_0x0949:
            r6 = r30
            goto L_0x0952
        L_0x094c:
            r10 = 3
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(r0)
            goto L_0x0949
        L_0x0952:
            if (r6 != 0) goto L_0x0958
            java.lang.reflect.Field r6 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r0, r11)
        L_0x0958:
            r8 = 0
            if (r6 != 0) goto L_0x0986
            r1 = r1[r8]
            java.lang.Class r3 = java.lang.Boolean.TYPE
            if (r1 != r3) goto L_0x0986
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            char r3 = r0.charAt(r8)
            char r3 = java.lang.Character.toUpperCase(r3)
            r1.append(r3)
            r3 = 1
            java.lang.String r4 = r0.substring(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r12, r1, r11)
            r3 = r1
            goto L_0x0987
        L_0x0986:
            r3 = r6
        L_0x0987:
            if (r3 == 0) goto L_0x0a23
            r7 = r49
            java.lang.annotation.Annotation r1 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r3, r7)
            r21 = r1
            com.alibaba.fastjson.annotation.JSONField r21 = (com.alibaba.fastjson.annotation.JSONField) r21
            if (r21 == 0) goto L_0x0a0e
            boolean r1 = r21.deserialize()
            if (r1 != 0) goto L_0x09a7
            r52 = r7
            r44 = r11
            r41 = r13
            r25 = r15
            r53 = r43
            goto L_0x0919
        L_0x09a7:
            int r6 = r21.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r21.serialzeFeatures()
            int r22 = com.alibaba.fastjson.serializer.SerializerFeature.of(r1)
            com.alibaba.fastjson.parser.Feature[] r1 = r21.parseFeatures()
            int r23 = com.alibaba.fastjson.parser.Feature.of(r1)
            java.lang.String r1 = r21.name()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x09f9
            java.lang.String r1 = r21.name()
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r25 = 0
            r0 = r5
            r4 = r57
            r51 = r5
            r5 = r58
            r52 = r7
            r7 = r22
            r26 = 0
            r8 = r23
            r36 = 3
            r10 = r21
            r41 = r13
            r13 = r11
            r11 = r25
            r25 = r15
            r15 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r51
            add(r14, r0)
            r44 = r13
            r53 = r43
        L_0x09f6:
            r0 = 1
            goto L_0x0a74
        L_0x09f9:
            r52 = r7
            r41 = r13
            r25 = r15
            r26 = 0
            r36 = 3
            r13 = r11
            r15 = r12
            r10 = r21
            r7 = r22
            r8 = r23
        L_0x0a0b:
            r12 = r43
            goto L_0x0a38
        L_0x0a0e:
            r52 = r7
            r41 = r13
            r25 = r15
            r26 = 0
            r36 = 3
            r13 = r11
            r15 = r12
            r10 = r21
            r6 = r22
            r7 = r23
            r8 = r28
            goto L_0x0a0b
        L_0x0a23:
            r41 = r13
            r25 = r15
            r52 = r49
            r26 = 0
            r36 = 3
            r13 = r11
            r15 = r12
            r6 = r22
            r7 = r23
            r8 = r28
            r10 = r30
            goto L_0x0a0b
        L_0x0a38:
            if (r12 == 0) goto L_0x0a3e
            java.lang.String r0 = r12.translate(r0)
        L_0x0a3e:
            r1 = r0
            com.alibaba.fastjson.util.FieldInfo r11 = new com.alibaba.fastjson.util.FieldInfo
            r21 = 0
            r0 = r11
            r4 = r57
            r5 = r58
            r44 = r13
            r13 = r11
            r11 = r21
            r53 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            add(r14, r13)
            goto L_0x09f6
        L_0x0a58:
            r33 = r6
            r34 = r9
            r35 = r10
            r30 = r11
            r31 = r12
            r25 = r15
            r53 = r43
            r32 = r45
            r52 = r46
            r41 = r48
            r26 = 0
            r29 = 2
            r36 = 3
            r15 = r13
            goto L_0x09f6
        L_0x0a74:
            int r9 = r34 + 1
            r13 = r15
            r15 = r25
            r11 = r30
            r12 = r31
            r45 = r32
            r38 = r33
            r10 = r35
            r48 = r41
            r46 = r52
            r43 = r53
            goto L_0x06ab
        L_0x0a8b:
            r30 = r11
            r31 = r12
            r15 = r13
            r53 = r43
            r52 = r46
            r26 = 0
            r36 = 3
            java.lang.reflect.Field[] r0 = r57.getFields()
            r13 = r58
            r12 = r53
            r11 = 3
            computeFields(r15, r13, r12, r14, r0)
            java.lang.reflect.Method[] r10 = r57.getMethods()
            int r9 = r10.length
            r6 = 0
        L_0x0aaa:
            if (r6 >= r9) goto L_0x0c26
            r2 = r10[r6]
            java.lang.String r0 = r2.getName()
            int r1 = r0.length()
            if (r1 >= r7) goto L_0x0acf
        L_0x0ab8:
            r33 = r6
            r26 = r8
            r28 = r9
            r17 = r10
            r56 = r12
            r32 = r37
        L_0x0ac4:
            r54 = r44
            r29 = r52
        L_0x0ac8:
            r0 = 1
            r21 = 3
            r23 = 4
            goto L_0x0c12
        L_0x0acf:
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x0ada
            goto L_0x0ab8
        L_0x0ada:
            if (r31 != 0) goto L_0x0bfd
            boolean r1 = r0.startsWith(r8)
            if (r1 == 0) goto L_0x0bfd
            char r1 = r0.charAt(r11)
            boolean r1 = java.lang.Character.isUpperCase(r1)
            if (r1 == 0) goto L_0x0bfd
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r1 = r1.length
            if (r1 == 0) goto L_0x0af4
            goto L_0x0ab8
        L_0x0af4:
            java.lang.Class r1 = r2.getReturnType()
            r5 = r37
            boolean r1 = r5.isAssignableFrom(r1)
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            if (r1 != 0) goto L_0x0b24
            java.lang.Class r1 = r2.getReturnType()
            boolean r1 = r3.isAssignableFrom(r1)
            if (r1 != 0) goto L_0x0b24
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r1 = java.util.concurrent.atomic.AtomicBoolean.class
            java.lang.Class r4 = r2.getReturnType()
            if (r1 == r4) goto L_0x0b24
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r1 = java.util.concurrent.atomic.AtomicInteger.class
            java.lang.Class r4 = r2.getReturnType()
            if (r1 == r4) goto L_0x0b24
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r1 = java.util.concurrent.atomic.AtomicLong.class
            java.lang.Class r4 = r2.getReturnType()
            if (r1 != r4) goto L_0x0b27
        L_0x0b24:
            r4 = r52
            goto L_0x0b34
        L_0x0b27:
            r32 = r5
            r33 = r6
            r26 = r8
            r28 = r9
            r17 = r10
            r56 = r12
            goto L_0x0ac4
        L_0x0b34:
            java.lang.annotation.Annotation r1 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Method) r2, r4)
            r17 = r1
            com.alibaba.fastjson.annotation.JSONField r17 = (com.alibaba.fastjson.annotation.JSONField) r17
            if (r17 == 0) goto L_0x0b56
            boolean r1 = r17.deserialize()
            if (r1 == 0) goto L_0x0b56
            r29 = r4
            r32 = r5
            r33 = r6
            r26 = r8
            r28 = r9
            r17 = r10
            r56 = r12
            r54 = r44
            goto L_0x0ac8
        L_0x0b56:
            if (r17 == 0) goto L_0x0b6b
            java.lang.String r1 = r17.name()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0b6b
            java.lang.String r0 = r17.name()
            r3 = r30
            r1 = r44
            goto L_0x0baf
        L_0x0b6b:
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.getPropertyNameByMethodName(r0)
            r1 = r44
            java.lang.reflect.Field r7 = com.alibaba.fastjson.util.TypeUtils.getField(r15, r0, r1)
            if (r7 == 0) goto L_0x0bad
            java.lang.annotation.Annotation r21 = com.alibaba.fastjson.util.TypeUtils.getAnnotation((java.lang.reflect.Field) r7, r4)
            com.alibaba.fastjson.annotation.JSONField r21 = (com.alibaba.fastjson.annotation.JSONField) r21
            if (r21 == 0) goto L_0x0b97
            boolean r21 = r21.deserialize()
            if (r21 != 0) goto L_0x0b97
        L_0x0b85:
            r54 = r1
            r29 = r4
            r32 = r5
            r33 = r6
            r26 = r8
            r28 = r9
            r17 = r10
            r56 = r12
            goto L_0x0ac8
        L_0x0b97:
            java.lang.Class r11 = r2.getReturnType()
            boolean r11 = r5.isAssignableFrom(r11)
            if (r11 != 0) goto L_0x0bab
            java.lang.Class r11 = r2.getReturnType()
            boolean r3 = r3.isAssignableFrom(r11)
            if (r3 == 0) goto L_0x0bad
        L_0x0bab:
            r3 = r7
            goto L_0x0baf
        L_0x0bad:
            r3 = r30
        L_0x0baf:
            if (r12 == 0) goto L_0x0bb5
            java.lang.String r0 = r12.translate(r0)
        L_0x0bb5:
            r7 = r0
            com.alibaba.fastjson.util.FieldInfo r0 = getField(r14, r7)
            if (r0 == 0) goto L_0x0bbd
            goto L_0x0b85
        L_0x0bbd:
            com.alibaba.fastjson.util.FieldInfo r11 = new com.alibaba.fastjson.util.FieldInfo
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r28 = 0
            r0 = r11
            r54 = r1
            r1 = r7
            r29 = r4
            r4 = r57
            r32 = r5
            r5 = r58
            r33 = r6
            r6 = r23
            r23 = 4
            r7 = r26
            r26 = r8
            r8 = r28
            r28 = r9
            r9 = r17
            r17 = r10
            r10 = r21
            r55 = r11
            r21 = 3
            r11 = r22
            r56 = r12
            r12 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r55
            add(r14, r0)
        L_0x0bfb:
            r0 = 1
            goto L_0x0c12
        L_0x0bfd:
            r33 = r6
            r26 = r8
            r28 = r9
            r17 = r10
            r56 = r12
            r32 = r37
            r54 = r44
            r29 = r52
            r21 = 3
            r23 = 4
            goto L_0x0bfb
        L_0x0c12:
            int r6 = r33 + 1
            r10 = r17
            r8 = r26
            r9 = r28
            r52 = r29
            r37 = r32
            r44 = r54
            r12 = r56
            r7 = 4
            r11 = 3
            goto L_0x0aaa
        L_0x0c26:
            r56 = r12
            r54 = r44
            r0 = 1
            int r1 = r14.size()
            if (r1 != 0) goto L_0x0c4b
            boolean r1 = com.alibaba.fastjson.util.TypeUtils.isXmlField(r57)
            if (r1 == 0) goto L_0x0c38
            goto L_0x0c3a
        L_0x0c38:
            r0 = r60
        L_0x0c3a:
            if (r0 == 0) goto L_0x0c4b
            r12 = r15
        L_0x0c3d:
            if (r12 == 0) goto L_0x0c4b
            r1 = r54
            r0 = r56
            computeFields(r15, r13, r0, r14, r1)
            java.lang.Class r12 = r12.getSuperclass()
            goto L_0x0c3d
        L_0x0c4b:
            com.alibaba.fastjson.util.JavaBeanInfo r9 = new com.alibaba.fastjson.util.JavaBeanInfo
            r0 = r9
            r1 = r57
            r2 = r31
            r3 = r18
            r4 = r24
            r5 = r20
            r6 = r19
            r7 = r27
            r8 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.JavaBeanInfo.build(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy, boolean, boolean, boolean):com.alibaba.fastjson.util.JavaBeanInfo");
    }
}
