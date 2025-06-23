package com.baidu.navisdk.ui.routeguide.repository;

import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.navisdk.ui.routeguide.model.c0;
import com.baidu.navisdk.ui.routeguide.model.h;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class b extends ViewModel {
    private h c = new h();
    private c0 d = new c0();

    /* renamed from: a, reason: collision with root package name */
    private final MutableLiveData<h> f9087a = new MutableLiveData<>();
    private final MutableLiveData<c0> b = new MutableLiveData<>();

    public void a(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDestViaOriginalEtaRepository", "updateClosetViaRemainDistTime remainDistance: " + i + ", remainTime: " + i2);
        }
        c0 c0Var = this.d;
        c0Var.f8933a = i;
        c0Var.b = i2;
        a((MutableLiveData<MutableLiveData<c0>>) this.b, (MutableLiveData<c0>) c0Var);
    }

    public void b(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDestViaOriginalEtaRepository", "updateDestinationRemainDistTime remainDistance: " + i + ", remainTime: " + i2);
        }
        this.c.a(i, i2);
        a((MutableLiveData<MutableLiveData<h>>) this.f9087a, (MutableLiveData<h>) this.c);
    }

    public h c() {
        return this.c;
    }

    public boolean d() {
        c0 c0Var = this.d;
        if (c0Var != null && c0Var.a()) {
            return true;
        }
        return false;
    }

    public void e() {
        g();
        f();
    }

    public void f() {
        if (this.d.a()) {
            this.d.b();
            a((MutableLiveData<MutableLiveData<c0>>) this.b, (MutableLiveData<c0>) this.d);
        } else {
            this.d.b();
        }
    }

    public void g() {
        h hVar = this.c;
        if (hVar != null) {
            hVar.b();
        }
        a((MutableLiveData<MutableLiveData<h>>) this.f9087a, (MutableLiveData<h>) this.c);
    }

    public void h() {
        b(0);
        a(0);
    }

    public void b(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDestViaOriginalEtaRepository", "updateDestinationRemainLights desCount: " + i + ",old: " + this.c.c);
        }
        h hVar = this.c;
        if (i != hVar.c) {
            hVar.c = i;
            a((MutableLiveData<MutableLiveData<h>>) this.f9087a, (MutableLiveData<h>) hVar);
        }
    }

    public void a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDestViaOriginalEtaRepository", "updateClosetViaRemainTrafficLights viaCount: " + i + ",old: " + this.d.c);
        }
        c0 c0Var = this.d;
        if (i != c0Var.c) {
            c0Var.c = i;
            a((MutableLiveData<MutableLiveData<c0>>) this.b, (MutableLiveData<c0>) c0Var);
        }
    }

    public LiveData<h> b() {
        return this.f9087a;
    }

    public LiveData<c0> a() {
        return this.b;
    }

    private <T> void a(MutableLiveData<T> mutableLiveData, T t) {
        if (mutableLiveData == null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDestViaOriginalEtaRepository", "notifyDataChange liveData == null: " + t);
                return;
            }
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }
}
