package com.baidu.navisdk.pronavi.logic.driving;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class c extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.framework.lifecycle.b<a> f7779a = new com.baidu.navisdk.framework.lifecycle.b<>();

    public c() {
        this.f7779a.setValue(new a());
    }

    public void a(a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDrivingDistanceTimeVi", "updateData: " + aVar);
        }
        this.f7779a.setValue(aVar);
    }

    public LiveData<a> a() {
        return this.f7779a;
    }
}
