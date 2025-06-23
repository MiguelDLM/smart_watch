package com.baidu.navisdk.pronavi.data.model;

import OXOo.OOXIXo;
import androidx.lifecycle.MutableLiveData;

/* loaded from: classes7.dex */
public final class f extends com.baidu.navisdk.pageframe.store.data.b {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final MutableLiveData<com.baidu.navisdk.pronavi.logic.service.parkrec.a> f7663a = new MutableLiveData<>();

    @OOXIXo
    private final MutableLiveData<com.baidu.navisdk.module.park.a> b = new MutableLiveData<>();

    @OOXIXo
    public final MutableLiveData<com.baidu.navisdk.module.park.a> a() {
        return this.b;
    }

    @OOXIXo
    public final MutableLiveData<com.baidu.navisdk.pronavi.logic.service.parkrec.a> b() {
        return this.f7663a;
    }
}
