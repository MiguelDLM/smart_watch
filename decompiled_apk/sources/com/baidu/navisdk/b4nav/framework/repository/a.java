package com.baidu.navisdk.b4nav.framework.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected final com.baidu.navisdk.framework.data.a f6568a;

    public <T> T a(@NonNull String str, T t) {
        return (T) this.f6568a.a(str, t);
    }

    public void b(@NonNull String str, @Nullable Object obj) {
        this.f6568a.b(str, obj);
    }

    @NonNull
    public MutableLiveData<com.baidu.navisdk.framework.data.b> a(@NonNull String str) {
        return this.f6568a.b(str);
    }

    public void a() {
        this.f6568a.a();
    }
}
