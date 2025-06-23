package com.huawei.hms.ads.dynamic;

import android.os.IBinder;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

/* loaded from: classes10.dex */
public class ObjectWrapper<T> extends IObjectWrapper.Stub {

    /* renamed from: a, reason: collision with root package name */
    private final T f17271a;

    private ObjectWrapper(T t) {
        this.f17271a = t;
    }

    public static <T> T unwrap(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ObjectWrapper) {
            return ((ObjectWrapper) iObjectWrapper).f17271a;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        int i = 0;
        for (Field field : declaredFields) {
            if (!field.isSynthetic()) {
                i++;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException("Got " + declaredFields.length + " fields, The number of field number should be 1.");
        }
        if (declaredFields[0].isAccessible()) {
            throw new IllegalArgumentException("The field is accessible.");
        }
        declaredFields[0].setAccessible(true);
        try {
            return (T) declaredFields[0].get(asBinder);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Get binder failed: null or not permitted.");
        }
    }

    public static <T> IObjectWrapper wrap(T t) {
        return new ObjectWrapper(t);
    }
}
