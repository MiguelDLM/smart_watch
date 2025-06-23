package com.baidu.navisdk.framework.data;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.util.common.g;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Object f6804a = new Object();
    private final Map<String, Object> b = new HashMap();
    private final Map<String, MutableLiveData<b>> c = new HashMap();
    private Thread d;

    public static a b() {
        return new a();
    }

    public <T> T a(@NonNull String str) {
        T t;
        synchronized (this.f6804a) {
            t = (T) this.b.get(str);
        }
        if (t != null) {
            return t;
        }
        return null;
    }

    public boolean c(@NonNull String str) {
        boolean containsKey;
        synchronized (this.f6804a) {
            containsKey = this.b.containsKey(str);
        }
        return containsKey;
    }

    public a b(@NonNull String str, @Nullable Object obj) {
        MutableLiveData<b> mutableLiveData;
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e("DataCenter", str + "," + obj);
        }
        synchronized (this.f6804a) {
            this.b.put(str, obj);
            mutableLiveData = this.c.get(str);
        }
        if (mutableLiveData != null) {
            if (!c()) {
                mutableLiveData.postValue(new b(str, obj));
                return this;
            }
            mutableLiveData.setValue(new b(str, obj));
        }
        return this;
    }

    private boolean c() {
        if (this.d == null) {
            this.d = Looper.getMainLooper().getThread();
        }
        return Thread.currentThread() == this.d;
    }

    public <T> T a(@NonNull String str, T t) {
        return !c(str) ? t : (T) a(str);
    }

    public void a() {
        synchronized (this.f6804a) {
            this.b.clear();
            this.c.clear();
        }
    }

    @NonNull
    public MutableLiveData<b> b(@NonNull String str) {
        MutableLiveData<b> mutableLiveData;
        synchronized (this.f6804a) {
            try {
                mutableLiveData = this.c.get(str);
                if (mutableLiveData == null) {
                    mutableLiveData = new MutableLiveData<>();
                    if (this.b.containsKey(str)) {
                        mutableLiveData.setValue(new b(str, this.b.get(str)));
                    }
                    this.c.put(str, mutableLiveData);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mutableLiveData;
    }
}
