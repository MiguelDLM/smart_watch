package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.FieldInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class BeanContext {
    private final Class<?> beanClass;
    private final FieldInfo fieldInfo;
    private final String format;

    public BeanContext(Class<?> cls, FieldInfo fieldInfo2) {
        this.beanClass = cls;
        this.fieldInfo = fieldInfo2;
        this.format = fieldInfo2.getFormat();
    }

    public <T extends Annotation> T getAnnation(Class<T> cls) {
        return this.fieldInfo.getAnnation(cls);
    }

    public Class<?> getBeanClass() {
        return this.beanClass;
    }

    public int getFeatures() {
        return this.fieldInfo.serialzeFeatures;
    }

    public Field getField() {
        return this.fieldInfo.field;
    }

    public Class<?> getFieldClass() {
        return this.fieldInfo.fieldClass;
    }

    public Type getFieldType() {
        return this.fieldInfo.fieldType;
    }

    public String getFormat() {
        return this.format;
    }

    public String getLabel() {
        return this.fieldInfo.label;
    }

    public Method getMethod() {
        return this.fieldInfo.method;
    }

    public String getName() {
        return this.fieldInfo.name;
    }

    public boolean isJsonDirect() {
        return this.fieldInfo.jsonDirect;
    }
}
