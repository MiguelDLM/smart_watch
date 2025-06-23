package com.baidu.navisdk.context.support.service;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class b implements a {
    private static final Object c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Object> f6764a = new HashMap<>();
    private final HashMap<Class<?>, String> b = new HashMap<>();

    @Nullable
    public <T> T a(String str, Class<T> cls) {
        Object obj;
        synchronized (c) {
            obj = this.f6764a.get(str);
        }
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    @Override // com.baidu.navisdk.context.support.service.a
    public void clear() {
        synchronized (c) {
            this.f6764a.clear();
            this.b.clear();
        }
    }

    @Override // com.baidu.navisdk.context.support.service.a
    @Nullable
    public <T> T getService(Class<T> cls) {
        return (T) a(a(cls), cls);
    }

    private String a(Class<?> cls) {
        String str;
        synchronized (c) {
            try {
                str = this.b.containsKey(cls) ? this.b.get(cls) : "";
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            LogUtil.printException("get model IllegalArgumentException!", new IllegalArgumentException("Local and anonymous classes can not be BaseModel"));
        }
        return "com.baidu.navisdk.context.support.service.ServiceManager.DefaultKey:" + canonicalName;
    }
}
