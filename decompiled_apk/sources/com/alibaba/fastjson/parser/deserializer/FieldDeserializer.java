package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public abstract class FieldDeserializer {
    protected BeanContext beanContext;
    protected final Class<?> clazz;
    public final FieldInfo fieldInfo;

    public FieldDeserializer(Class<?> cls, FieldInfo fieldInfo) {
        this.clazz = cls;
        this.fieldInfo = fieldInfo;
    }

    private static boolean degradeValueAssignment(Field field, Method method, Object obj, Object obj2) throws InvocationTargetException, IllegalAccessException {
        if (setFieldValue(field, obj, obj2)) {
            return true;
        }
        try {
            obj.getClass().getDeclaredMethod("set" + method.getName().substring(3), method.getReturnType()).invoke(obj, obj2);
            return true;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    private static boolean setFieldValue(Field field, Object obj, Object obj2) throws IllegalAccessException {
        if (field != null && !Modifier.isFinal(field.getModifiers())) {
            field.set(obj, obj2);
            return true;
        }
        return false;
    }

    public int getFastMatchToken() {
        return 0;
    }

    public Class<?> getOwnerClass() {
        return this.clazz;
    }

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public void setValue(Object obj, boolean z) {
        setValue(obj, Boolean.valueOf(z));
    }

    public void setWrappedValue(String str, Object obj) {
        throw new JSONException("TODO");
    }

    public void setValue(Object obj, int i) {
        setValue(obj, Integer.valueOf(i));
    }

    public void setValue(Object obj, long j) {
        setValue(obj, Long.valueOf(j));
    }

    public void setValue(Object obj, String str) {
        setValue(obj, (Object) str);
    }

    public void setValue(Object obj, Object obj2) {
        FieldInfo fieldInfo;
        Method method;
        String str;
        if (obj2 == null && this.fieldInfo.fieldClass.isPrimitive()) {
            return;
        }
        FieldInfo fieldInfo2 = this.fieldInfo;
        if (fieldInfo2.fieldClass == String.class && (str = fieldInfo2.format) != null && str.equals("trim")) {
            obj2 = ((String) obj2).trim();
        }
        try {
            fieldInfo = this.fieldInfo;
            method = fieldInfo.method;
        } catch (Exception e) {
            throw new JSONException("set property error, " + this.clazz.getName() + OoOoXO0.xoXoI.f2670oxoX + this.fieldInfo.name, e);
        }
        if (method != null) {
            if (fieldInfo.getOnly) {
                Class<?> cls = fieldInfo.fieldClass;
                if (cls == AtomicInteger.class) {
                    AtomicInteger atomicInteger = (AtomicInteger) method.invoke(obj, null);
                    if (atomicInteger != null) {
                        atomicInteger.set(((AtomicInteger) obj2).get());
                        return;
                    } else {
                        degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                        return;
                    }
                }
                if (cls == AtomicLong.class) {
                    AtomicLong atomicLong = (AtomicLong) method.invoke(obj, null);
                    if (atomicLong != null) {
                        atomicLong.set(((AtomicLong) obj2).get());
                        return;
                    } else {
                        degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                        return;
                    }
                }
                if (cls != AtomicBoolean.class) {
                    if (Map.class.isAssignableFrom(method.getReturnType())) {
                        try {
                            Map map = (Map) method.invoke(obj, null);
                            if (map == null) {
                                if (obj2 != null) {
                                    degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                    return;
                                }
                                return;
                            } else {
                                if (map == Collections.emptyMap()) {
                                    return;
                                }
                                if (map.isEmpty() && ((Map) obj2).isEmpty()) {
                                    return;
                                }
                                String name = map.getClass().getName();
                                if (!name.equals("java.util.ImmutableCollections$Map1") && !name.equals("java.util.ImmutableCollections$MapN") && !name.startsWith("java.util.Collections$Unmodifiable")) {
                                    if (map.getClass().getName().equals("kotlin.collections.EmptyMap")) {
                                        degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                        return;
                                    } else {
                                        map.putAll((Map) obj2);
                                        return;
                                    }
                                }
                                return;
                            }
                        } catch (InvocationTargetException unused) {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                    }
                    try {
                        Collection collection = (Collection) method.invoke(obj, null);
                        if (collection == null || obj2 == null) {
                            if (collection != null || obj2 == null) {
                                return;
                            }
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                        String name2 = collection.getClass().getName();
                        if (collection != Collections.emptySet() && collection != Collections.emptyList() && name2 != "java.util.ImmutableCollections$ListN" && name2 != "java.util.ImmutableCollections$List12" && !name2.startsWith("java.util.Collections$Unmodifiable")) {
                            if (!collection.isEmpty()) {
                                collection.clear();
                            } else if (((Collection) obj2).isEmpty()) {
                                return;
                            }
                            if (!name2.equals("kotlin.collections.EmptyList") && !name2.equals("kotlin.collections.EmptySet")) {
                                collection.addAll((Collection) obj2);
                                return;
                            }
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            return;
                        }
                        return;
                    } catch (InvocationTargetException unused2) {
                        degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                        return;
                    }
                    throw new JSONException("set property error, " + this.clazz.getName() + OoOoXO0.xoXoI.f2670oxoX + this.fieldInfo.name, e);
                }
                AtomicBoolean atomicBoolean = (AtomicBoolean) method.invoke(obj, null);
                if (atomicBoolean != null) {
                    atomicBoolean.set(((AtomicBoolean) obj2).get());
                    return;
                } else {
                    degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                    return;
                }
            }
            method.invoke(obj, obj2);
            return;
        }
        Field field = fieldInfo.field;
        if (!fieldInfo.getOnly) {
            if (field != null) {
                field.set(obj, obj2);
                return;
            }
            return;
        }
        Class<?> cls2 = fieldInfo.fieldClass;
        if (cls2 == AtomicInteger.class) {
            AtomicInteger atomicInteger2 = (AtomicInteger) field.get(obj);
            if (atomicInteger2 != null) {
                atomicInteger2.set(((AtomicInteger) obj2).get());
                return;
            }
            return;
        }
        if (cls2 == AtomicLong.class) {
            AtomicLong atomicLong2 = (AtomicLong) field.get(obj);
            if (atomicLong2 != null) {
                atomicLong2.set(((AtomicLong) obj2).get());
                return;
            }
            return;
        }
        if (cls2 == AtomicBoolean.class) {
            AtomicBoolean atomicBoolean2 = (AtomicBoolean) field.get(obj);
            if (atomicBoolean2 != null) {
                atomicBoolean2.set(((AtomicBoolean) obj2).get());
                return;
            }
            return;
        }
        if (Map.class.isAssignableFrom(cls2)) {
            Map map2 = (Map) field.get(obj);
            if (map2 != null && map2 != Collections.emptyMap() && !map2.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                map2.putAll((Map) obj2);
                return;
            }
            return;
        }
        Collection collection2 = (Collection) field.get(obj);
        if (collection2 != null && obj2 != null && collection2 != Collections.emptySet() && collection2 != Collections.emptyList() && !collection2.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
            collection2.clear();
            collection2.addAll((Collection) obj2);
        }
    }
}
