package com.alibaba.fastjson.util;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

public class FieldInfo implements Comparable<FieldInfo> {
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final boolean jsonDirect;
    public final String label;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    public final char[] name_chars;
    private int ordinal;
    public final int parserFeatures;
    public final int serialzeFeatures;
    public final boolean unwrapped;

    public FieldInfo(String str, Class<?> cls, Class<?> cls2, Type type, Field field2, int i, int i2, int i3) {
        JSONField jSONField;
        this.ordinal = 0;
        i = i < 0 ? 0 : i;
        this.name = str;
        this.declaringClass = cls;
        this.fieldClass = cls2;
        this.fieldType = type;
        this.method = null;
        this.field = field2;
        this.ordinal = i;
        this.serialzeFeatures = i2;
        this.parserFeatures = i3;
        this.isEnum = cls2.isEnum();
        if (field2 != null) {
            int modifiers = field2.getModifiers();
            this.fieldAccess = true;
            this.fieldTransient = Modifier.isTransient(modifiers);
        } else {
            this.fieldTransient = false;
            this.fieldAccess = false;
        }
        this.name_chars = genFieldNameChars();
        if (field2 != null) {
            TypeUtils.setAccessible(field2);
        }
        this.label = "";
        if (field2 == null) {
            jSONField = null;
        } else {
            jSONField = (JSONField) TypeUtils.getAnnotation(field2, JSONField.class);
        }
        this.fieldAnnotation = jSONField;
        this.methodAnnotation = null;
        this.getOnly = false;
        this.jsonDirect = false;
        this.unwrapped = false;
        this.format = null;
        this.alternateNames = new String[0];
        this.nameHashCode = nameHashCode64(str, jSONField);
    }

    private static boolean getArgument(Type[] typeArr, Map<TypeVariable, Type> map) {
        if (map == null || map.size() == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            ParameterizedType parameterizedType = typeArr[i];
            if (parameterizedType instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = parameterizedType;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (getArgument(actualTypeArguments, map)) {
                    typeArr[i] = TypeReference.intern(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType()));
                }
            } else {
                if ((parameterizedType instanceof TypeVariable) && map.containsKey(parameterizedType)) {
                    typeArr[i] = map.get(parameterizedType);
                }
            }
            z = true;
        }
        return z;
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2) {
        return getFieldType(cls, type, type2, (Map<TypeVariable, Type>) null);
    }

    private static Type getInheritGenericType(Class<?> cls, Type type, TypeVariable<?> typeVariable) {
        Class<?> cls2;
        Type[] typeArr;
        if (typeVariable.getGenericDeclaration() instanceof Class) {
            cls2 = (Class) typeVariable.getGenericDeclaration();
        } else {
            cls2 = null;
        }
        if (cls2 != cls) {
            Type[] typeArr2 = null;
            Class<? super Object> cls3 = cls;
            while (cls3 != null && cls3 != Object.class && cls3 != cls2) {
                Type genericSuperclass = cls3.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    getArgument(actualTypeArguments, cls3.getTypeParameters(), typeArr2);
                    typeArr2 = actualTypeArguments;
                }
                cls3 = cls3.getSuperclass();
            }
            typeArr = typeArr2;
        } else if (type instanceof ParameterizedType) {
            typeArr = ((ParameterizedType) type).getActualTypeArguments();
        } else {
            typeArr = null;
        }
        if (typeArr == null || cls2 == null) {
            return null;
        }
        TypeVariable[] typeParameters = cls2.getTypeParameters();
        for (int i = 0; i < typeParameters.length; i++) {
            if (typeVariable.equals(typeParameters[i])) {
                return typeArr[i];
            }
        }
        return null;
    }

    private long nameHashCode64(String str, JSONField jSONField) {
        if (jSONField == null || jSONField.name().length() == 0) {
            return TypeUtils.fnv1a_64_extract(str);
        }
        return TypeUtils.fnv1a_64_lower(str);
    }

    public char[] genFieldNameChars() {
        int length = this.name.length();
        char[] cArr = new char[(length + 3)];
        String str = this.name;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    public Object get(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method2 = this.method;
        if (method2 != null) {
            return method2.invoke(obj, (Object[]) null);
        }
        return this.field.get(obj);
    }

    public <T extends Annotation> T getAnnation(Class<T> cls) {
        T t;
        Field field2;
        if (cls == JSONField.class) {
            return getAnnotation();
        }
        Method method2 = this.method;
        if (method2 != null) {
            t = TypeUtils.getAnnotation(method2, cls);
        } else {
            t = null;
        }
        if (t != null || (field2 = this.field) == null) {
            return t;
        }
        return TypeUtils.getAnnotation(field2, cls);
    }

    public JSONField getAnnotation() {
        JSONField jSONField = this.fieldAnnotation;
        if (jSONField != null) {
            return jSONField;
        }
        return this.methodAnnotation;
    }

    public Class<?> getDeclaredClass() {
        Method method2 = this.method;
        if (method2 != null) {
            return method2.getDeclaringClass();
        }
        Field field2 = this.field;
        if (field2 != null) {
            return field2.getDeclaringClass();
        }
        return null;
    }

    public String getFormat() {
        return this.format;
    }

    public Member getMember() {
        Method method2 = this.method;
        if (method2 != null) {
            return method2;
        }
        return this.field;
    }

    public void set(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method2 = this.method;
        if (method2 != null) {
            method2.invoke(obj, new Object[]{obj2});
            return;
        }
        this.field.set(obj, obj2);
    }

    public void setAccessible() throws SecurityException {
        Method method2 = this.method;
        if (method2 != null) {
            TypeUtils.setAccessible(method2);
        } else {
            TypeUtils.setAccessible(this.field);
        }
    }

    public String toString() {
        return this.name;
    }

    public static Type getFieldType(Class<?> cls, Type type, Type type2, Map<TypeVariable, Type> map) {
        ParameterizedType parameterizedType;
        TypeVariable[] typeVariableArr;
        if (!(cls == null || type == null)) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type fieldType2 = getFieldType(cls, type, genericComponentType, map);
                return genericComponentType != fieldType2 ? Array.newInstance(TypeUtils.getClass(fieldType2), 0).getClass() : type2;
            } else if (!TypeUtils.isGenericParamType(type)) {
                return type2;
            } else {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.getGenericParamType(type);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    TypeVariable[] typeParameters = TypeUtils.getClass(parameterizedType2).getTypeParameters();
                    for (int i = 0; i < typeParameters.length; i++) {
                        if (typeParameters[i].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    boolean argument = getArgument(actualTypeArguments, map);
                    if (!argument) {
                        if (type instanceof ParameterizedType) {
                            parameterizedType = (ParameterizedType) type;
                            typeVariableArr = cls.getTypeParameters();
                        } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                            parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                            typeVariableArr = cls.getSuperclass().getTypeParameters();
                        } else {
                            typeVariableArr = type.getClass().getTypeParameters();
                            parameterizedType = parameterizedType3;
                        }
                        argument = getArgument(actualTypeArguments, typeVariableArr, parameterizedType.getActualTypeArguments());
                    }
                    if (argument) {
                        return TypeReference.intern(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType()));
                    }
                }
            }
        }
        return type2;
    }

    public int compareTo(FieldInfo fieldInfo) {
        Method method2 = fieldInfo.method;
        if (method2 != null && this.method != null && method2.isBridge() && !this.method.isBridge() && fieldInfo.method.getName().equals(this.method.getName())) {
            return 1;
        }
        int i = this.ordinal;
        int i2 = fieldInfo.ordinal;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int compareTo = this.name.compareTo(fieldInfo.name);
        if (compareTo != 0) {
            return compareTo;
        }
        Class<?> declaredClass = getDeclaredClass();
        Class<?> declaredClass2 = fieldInfo.getDeclaredClass();
        if (!(declaredClass == null || declaredClass2 == null || declaredClass == declaredClass2)) {
            if (declaredClass.isAssignableFrom(declaredClass2)) {
                return -1;
            }
            if (declaredClass2.isAssignableFrom(declaredClass)) {
                return 1;
            }
        }
        Field field2 = this.field;
        boolean z = false;
        boolean z2 = field2 != null && field2.getType() == this.fieldClass;
        Field field3 = fieldInfo.field;
        if (field3 != null && field3.getType() == fieldInfo.fieldClass) {
            z = true;
        }
        if (z2 && !z) {
            return 1;
        }
        if (z && !z2) {
            return -1;
        }
        if (fieldInfo.fieldClass.isPrimitive() && !this.fieldClass.isPrimitive()) {
            return 1;
        }
        if (this.fieldClass.isPrimitive() && !fieldInfo.fieldClass.isPrimitive()) {
            return -1;
        }
        if (fieldInfo.fieldClass.getName().startsWith("java.") && !this.fieldClass.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.fieldClass.getName().startsWith("java.") || fieldInfo.fieldClass.getName().startsWith("java.")) {
            return this.fieldClass.getName().compareTo(fieldInfo.fieldClass.getName());
        }
        return -1;
    }

    private static boolean getArgument(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < typeArr.length; i++) {
            ParameterizedType parameterizedType = typeArr[i];
            if (parameterizedType instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = parameterizedType;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (getArgument(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i] = TypeReference.intern(new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType()));
                    z = true;
                }
            } else if (parameterizedType instanceof TypeVariable) {
                for (int i2 = 0; i2 < typeVariableArr.length; i2++) {
                    if (parameterizedType.equals(typeVariableArr[i2])) {
                        typeArr[i] = typeArr2[i2];
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public FieldInfo(String str, Method method2, Field field2, Class<?> cls, Type type, int i, int i2, int i3, JSONField jSONField, JSONField jSONField2, String str2) {
        this(str, method2, field2, cls, type, i, i2, i3, jSONField, jSONField2, str2, (Map<TypeVariable, Type>) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: java.lang.reflect.Type[]} */
    /* JADX WARNING: type inference failed for: r12v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FieldInfo(java.lang.String r4, java.lang.reflect.Method r5, java.lang.reflect.Field r6, java.lang.Class<?> r7, java.lang.reflect.Type r8, int r9, int r10, int r11, com.alibaba.fastjson.annotation.JSONField r12, com.alibaba.fastjson.annotation.JSONField r13, java.lang.String r14, java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> r15) {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.ordinal = r0
            if (r6 == 0) goto L_0x0013
            java.lang.String r1 = r6.getName()
            boolean r2 = r1.equals(r4)
            if (r2 == 0) goto L_0x0013
            r4 = r1
        L_0x0013:
            if (r9 >= 0) goto L_0x0016
            r9 = 0
        L_0x0016:
            r3.name = r4
            r3.method = r5
            r3.field = r6
            r3.ordinal = r9
            r3.serialzeFeatures = r10
            r3.parserFeatures = r11
            r3.fieldAnnotation = r12
            r3.methodAnnotation = r13
            r9 = 1
            if (r6 == 0) goto L_0x004c
            int r10 = r6.getModifiers()
            r11 = r10 & 1
            if (r11 != 0) goto L_0x0036
            if (r5 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r11 = 0
            goto L_0x0037
        L_0x0036:
            r11 = 1
        L_0x0037:
            r3.fieldAccess = r11
            boolean r10 = java.lang.reflect.Modifier.isTransient(r10)
            if (r10 != 0) goto L_0x0048
            boolean r10 = com.alibaba.fastjson.util.TypeUtils.isTransient(r5)
            if (r10 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r10 = 0
            goto L_0x0049
        L_0x0048:
            r10 = 1
        L_0x0049:
            r3.fieldTransient = r10
            goto L_0x0054
        L_0x004c:
            r3.fieldAccess = r0
            boolean r10 = com.alibaba.fastjson.util.TypeUtils.isTransient(r5)
            r3.fieldTransient = r10
        L_0x0054:
            if (r14 == 0) goto L_0x005f
            int r10 = r14.length()
            if (r10 <= 0) goto L_0x005f
            r3.label = r14
            goto L_0x0063
        L_0x005f:
            java.lang.String r10 = ""
            r3.label = r10
        L_0x0063:
            com.alibaba.fastjson.annotation.JSONField r10 = r3.getAnnotation()
            long r11 = r3.nameHashCode64(r4, r10)
            r3.nameHashCode = r11
            r4 = 0
            if (r10 == 0) goto L_0x0091
            java.lang.String r11 = r10.format()
            java.lang.String r12 = r11.trim()
            int r12 = r12.length()
            if (r12 != 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r4 = r11
        L_0x0080:
            boolean r11 = r10.jsonDirect()
            boolean r12 = r10.unwrapped()
            r3.unwrapped = r12
            java.lang.String[] r10 = r10.alternateNames()
            r3.alternateNames = r10
            goto L_0x0098
        L_0x0091:
            r3.unwrapped = r0
            java.lang.String[] r10 = new java.lang.String[r0]
            r3.alternateNames = r10
            r11 = 0
        L_0x0098:
            r3.format = r4
            char[] r4 = r3.genFieldNameChars()
            r3.name_chars = r4
            if (r5 == 0) goto L_0x00a5
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r5)
        L_0x00a5:
            if (r6 == 0) goto L_0x00aa
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r6)
        L_0x00aa:
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            if (r5 == 0) goto L_0x00df
            java.lang.Class[] r6 = r5.getParameterTypes()
            int r12 = r6.length
            if (r12 != r9) goto L_0x00c1
            r6 = r6[r0]
            java.lang.reflect.Type[] r12 = r5.getGenericParameterTypes()
            r12 = r12[r0]
        L_0x00bf:
            r13 = 0
            goto L_0x00d8
        L_0x00c1:
            int r12 = r6.length
            r13 = 2
            if (r12 != r13) goto L_0x00cf
            r12 = r6[r0]
            if (r12 != r10) goto L_0x00cf
            r6 = r6[r9]
            if (r6 != r4) goto L_0x00cf
            r6 = r12
            goto L_0x00bf
        L_0x00cf:
            java.lang.Class r6 = r5.getReturnType()
            java.lang.reflect.Type r12 = r5.getGenericReturnType()
            r13 = 1
        L_0x00d8:
            java.lang.Class r5 = r5.getDeclaringClass()
            r3.declaringClass = r5
            goto L_0x00f6
        L_0x00df:
            java.lang.Class r5 = r6.getType()
            java.lang.reflect.Type r12 = r6.getGenericType()
            java.lang.Class r13 = r6.getDeclaringClass()
            r3.declaringClass = r13
            int r6 = r6.getModifiers()
            boolean r13 = java.lang.reflect.Modifier.isFinal(r6)
            r6 = r5
        L_0x00f6:
            r3.getOnly = r13
            if (r11 == 0) goto L_0x00fd
            if (r6 != r10) goto L_0x00fd
            r0 = 1
        L_0x00fd:
            r3.jsonDirect = r0
            if (r7 == 0) goto L_0x011f
            if (r6 != r4) goto L_0x011f
            boolean r4 = r12 instanceof java.lang.reflect.TypeVariable
            if (r4 == 0) goto L_0x011f
            r4 = r12
            java.lang.reflect.TypeVariable r4 = (java.lang.reflect.TypeVariable) r4
            java.lang.reflect.Type r4 = getInheritGenericType(r7, r8, r4)
            if (r4 == 0) goto L_0x011f
            java.lang.Class r5 = com.alibaba.fastjson.util.TypeUtils.getClass(r4)
            r3.fieldClass = r5
            r3.fieldType = r4
            boolean r4 = r6.isEnum()
            r3.isEnum = r4
            return
        L_0x011f:
            boolean r4 = r12 instanceof java.lang.Class
            if (r4 != 0) goto L_0x0140
            if (r8 == 0) goto L_0x0126
            goto L_0x0127
        L_0x0126:
            r8 = r7
        L_0x0127:
            java.lang.reflect.Type r4 = getFieldType(r7, r8, r12, r15)
            if (r4 == r12) goto L_0x0135
            boolean r5 = r4 instanceof java.lang.reflect.ParameterizedType
            if (r5 == 0) goto L_0x0137
            java.lang.Class r6 = com.alibaba.fastjson.util.TypeUtils.getClass(r4)
        L_0x0135:
            r12 = r4
            goto L_0x0140
        L_0x0137:
            boolean r5 = r4 instanceof java.lang.Class
            if (r5 == 0) goto L_0x0135
            java.lang.Class r6 = com.alibaba.fastjson.util.TypeUtils.getClass(r4)
            goto L_0x0135
        L_0x0140:
            r3.fieldType = r12
            r3.fieldClass = r6
            boolean r4 = r6.isEnum()
            r3.isEnum = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.FieldInfo.<init>(java.lang.String, java.lang.reflect.Method, java.lang.reflect.Field, java.lang.Class, java.lang.reflect.Type, int, int, int, com.alibaba.fastjson.annotation.JSONField, com.alibaba.fastjson.annotation.JSONField, java.lang.String, java.util.Map):void");
    }
}
