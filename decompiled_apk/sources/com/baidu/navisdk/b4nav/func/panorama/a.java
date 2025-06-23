package com.baidu.navisdk.b4nav.func.panorama;

import OXOo.OOXIXo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.baidu.baidunavis.maplayer.d;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class a extends com.baidu.navisdk.b4nav.framework.repository.a {
    private final String b;
    private ArrayList<com.baidu.navisdk.b4nav.data.panorama.a> c;
    private final MutableLiveData<Object> d;

    @OOXIXo
    private final MutableLiveData<Boolean> e;

    @OOXIXo
    private final LiveData<d> f;

    /* renamed from: com.baidu.navisdk.b4nav.func.panorama.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0171a {
    }

    @OOXIXo
    public final LiveData<d> b() {
        return this.f;
    }

    @OOXIXo
    public final MutableLiveData<Boolean> c() {
        return this.e;
    }

    public final void d() {
        g gVar = g.B4NAV;
        if (gVar.d()) {
            gVar.e(this.b, "resetData");
        }
        this.c = new ArrayList<>();
        this.d.postValue(new C0171a());
    }
}
