package com.alibaba.fastjson.parser.deserializer;

import OoOoXO0.xoXoI;
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

public abstract class FieldDeserializer {
    protected BeanContext beanContext;
    protected final Class<?> clazz;
    public final FieldInfo fieldInfo;

    public FieldDeserializer(Class<?> cls, FieldInfo fieldInfo2) {
        this.clazz = cls;
        this.fieldInfo = fieldInfo2;
    }

    private static boolean degradeValueAssignment(Field field, Method method, Object obj, Object obj2) throws InvocationTargetException, IllegalAccessException {
        if (setFieldValue(field, obj, obj2)) {
            return true;
        }
        try {
            Class<?> cls = obj.getClass();
            cls.getDeclaredMethod("set" + method.getName().substring(3), new Class[]{method.getReturnType()}).invoke(obj, new Object[]{obj2});
            return true;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    private static boolean setFieldValue(Field field, Object obj, Object obj2) throws IllegalAccessException {
        if (field == null || Modifier.isFinal(field.getModifiers())) {
            return false;
        }
        field.set(obj, obj2);
        return true;
    }

    public int getFastMatchToken() {
        return 0;
    }

    public Class<?> getOwnerClass() {
        return this.clazz;
    }

    public abstract void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map);

    public void setValue(Object obj, boolean z) {
        setValue(obj, (Object) Boolean.valueOf(z));
    }

    public void setWrappedValue(String str, Object obj) {
        throw new JSONException("TODO");
    }

    public void setValue(Object obj, int i) {
        setValue(obj, (Object) Integer.valueOf(i));
    }

    public void setValue(Object obj, long j) {
        setValue(obj, (Object) Long.valueOf(j));
    }

    public void setValue(Object obj, String str) {
        setValue(obj, (Object) str);
    }

    public void setValue(Object obj, Object obj2) {
        String str;
        if (obj2 != null || !this.fieldInfo.fieldClass.isPrimitive()) {
            FieldInfo fieldInfo2 = this.fieldInfo;
            if (fieldInfo2.fieldClass == String.class && (str = fieldInfo2.format) != null && str.equals("trim")) {
                obj2 = ((String) obj2).trim();
            }
            try {
                FieldInfo fieldInfo3 = this.fieldInfo;
                Method method = fieldInfo3.method;
                Class<Map> cls = Map.class;
                Class<AtomicBoolean> cls2 = AtomicBoolean.class;
                Class<AtomicLong> cls3 = AtomicLong.class;
                Class<AtomicInteger> cls4 = AtomicInteger.class;
                if (method == null) {
                    Field field = fieldInfo3.field;
                    if (fieldInfo3.getOnly) {
                        Class<?> cls5 = fieldInfo3.fieldClass;
                        if (cls5 == cls4) {
                            AtomicInteger atomicInteger = (AtomicInteger) field.get(obj);
                            if (atomicInteger != null) {
                                atomicInteger.set(((AtomicInteger) obj2).get());
                            }
                        } else if (cls5 == cls3) {
                            AtomicLong atomicLong = (AtomicLong) field.get(obj);
                            if (atomicLong != null) {
                                atomicLong.set(((AtomicLong) obj2).get());
                            }
                        } else if (cls5 == cls2) {
                            AtomicBoolean atomicBoolean = (AtomicBoolean) field.get(obj);
                            if (atomicBoolean != null) {
                                atomicBoolean.set(((AtomicBoolean) obj2).get());
                            }
                        } else if (cls.isAssignableFrom(cls5)) {
                            Map map = (Map) field.get(obj);
                            if (map != null && map != Collections.emptyMap()) {
                                if (!map.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                                    map.putAll((Map) obj2);
                                }
                            }
                        } else {
                            Collection collection = (Collection) field.get(obj);
                            if (collection != null && obj2 != null && collection != Collections.emptySet() && collection != Collections.emptyList()) {
                                if (!collection.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                                    collection.clear();
                                    collection.addAll((Collection) obj2);
                                }
                            }
                        }
                    } else if (field != null) {
                        field.set(obj, obj2);
                    }
                } else if (fieldInfo3.getOnly) {
                    Class<?> cls6 = fieldInfo3.fieldClass;
                    if (cls6 == cls4) {
                        AtomicInteger atomicInteger2 = (AtomicInteger) method.invoke(obj, (Object[]) null);
                        if (atomicInteger2 != null) {
                            atomicInteger2.set(((AtomicInteger) obj2).get());
                        } else {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                        }
                    } else if (cls6 == cls3) {
                        AtomicLong atomicLong2 = (AtomicLong) method.invoke(obj, (Object[]) null);
                        if (atomicLong2 != null) {
                            atomicLong2.set(((AtomicLong) obj2).get());
                        } else {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                        }
                    } else if (cls6 == cls2) {
                        AtomicBoolean atomicBoolean2 = (AtomicBoolean) method.invoke(obj, (Object[]) null);
                        if (atomicBoolean2 != null) {
                            atomicBoolean2.set(((AtomicBoolean) obj2).get());
                        } else {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                        }
                    } else if (cls.isAssignableFrom(method.getReturnType())) {
                        try {
                            Map map2 = (Map) method.invoke(obj, (Object[]) null);
                            if (map2 != null) {
                                if (map2 != Collections.emptyMap()) {
                                    if (!map2.isEmpty() || !((Map) obj2).isEmpty()) {
                                        String name = map2.getClass().getName();
                                        if (!name.equals("java.util.ImmutableCollections$Map1") && !name.equals("java.util.ImmutableCollections$MapN")) {
                                            if (!name.startsWith("java.util.Collections$Unmodifiable")) {
                                                if (map2.getClass().getName().equals("kotlin.collections.EmptyMap")) {
                                                    degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                                } else {
                                                    map2.putAll((Map) obj2);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (obj2 != null) {
                                degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            }
                        } catch (InvocationTargetException unused) {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                        }
                    } else {
                        try {
                            Collection collection2 = (Collection) method.invoke(obj, (Object[]) null);
                            if (collection2 != null && obj2 != null) {
                                String name2 = collection2.getClass().getName();
                                if (collection2 != Collections.emptySet() && collection2 != Collections.emptyList() && name2 != "java.util.ImmutableCollections$ListN" && name2 != "java.util.ImmutableCollections$List12") {
                                    if (!name2.startsWith("java.util.Collections$Unmodifiable")) {
                                        if (!collection2.isEmpty()) {
                                            collection2.clear();
                                        } else if (((Collection) obj2).isEmpty()) {
                                            return;
                                        }
                                        if (!name2.equals("kotlin.collections.EmptyList")) {
                                            if (!name2.equals("kotlin.collections.EmptySet")) {
                                                collection2.addAll((Collection) obj2);
                                                return;
                                            }
                                        }
                                        degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                                    }
                                }
                            } else if (collection2 == null && obj2 != null) {
                                degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                            }
                        } catch (InvocationTargetException unused2) {
                            degradeValueAssignment(this.fieldInfo.field, method, obj, obj2);
                        }
                    }
                } else {
                    method.invoke(obj, new Object[]{obj2});
                }
            } catch (Exception e) {
                throw new JSONException("set property error, " + this.clazz.getName() + xoXoI.f16453oxoX + this.fieldInfo.name, e);
            }
        }
    }
}
