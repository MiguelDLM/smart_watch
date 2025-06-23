package com.baidu.navisdk.module.routeresult.logic.plate;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.module.routepreference.g;
import com.baidu.navisdk.module.routepreference.h;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final g f7499a;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7500a = new a();
    }

    public static a b() {
        return b.f7500a;
    }

    private void c(int i) {
        this.f7499a.f7483a = BNSettingManager.getEngPassportIds();
        this.f7499a.d = BNSettingManager.getEngEtcClass();
        this.f7499a.e = BNSettingManager.getEngEtcColor();
        this.f7499a.f = BNSettingManager.getEngIsEtc();
        this.f7499a.i = BNSettingManager.getEngBrandId();
        this.f7499a.j = BNSettingManager.getIsNewEnergyCar();
        this.f7499a.p = BNSettingManager.getNewEnergyCarExt();
        this.f7499a.l = BNSettingManager.getNewEnergyBrand();
        this.f7499a.m = BNSettingManager.getNewEnergyBrandModel();
        this.f7499a.n = BNSettingManager.getNewEnergyBrandName();
        this.f7499a.o = BNSettingManager.getEngCarIcon();
        g gVar = this.f7499a;
        gVar.c = i;
        gVar.a(h.a(gVar.l, gVar.p));
        this.f7499a.setPlateInfo(BNSettingManager.getEnergyDefaultPlate(), i);
    }

    private void d(int i) {
        this.f7499a.f7483a = BNSettingManager.getCarPassportIds();
        this.f7499a.d = BNSettingManager.getEtcClass();
        this.f7499a.e = BNSettingManager.getEtcColor();
        this.f7499a.f = BNSettingManager.getIsEtc();
        this.f7499a.g = BNSettingManager.getIsPickUp();
        this.f7499a.i = BNSettingManager.getBrandId();
        this.f7499a.o = BNSettingManager.getCarIcon();
        String a2 = com.baidu.navisdk.h.a();
        g gVar = this.f7499a;
        gVar.c = i;
        gVar.setPlateInfo(a2, i);
    }

    private void e(int i) {
        if (i == 1) {
            c(i);
        } else {
            d(i);
        }
    }

    private void f(int i) {
        BNSettingManager.setEngEtcClass(this.f7499a.d);
        BNSettingManager.setEngEtcColor(this.f7499a.e);
        BNSettingManager.setEngIsEtc(this.f7499a.f);
        BNSettingManager.setEngBrandId(this.f7499a.i);
        BNSettingManager.setIsNewEnergyCar(this.f7499a.j);
        BNSettingManager.setNewEnergyBrand(this.f7499a.l);
        BNSettingManager.setNewEnergyBrandModel(this.f7499a.m);
        BNSettingManager.setNewEnergyBrandName(this.f7499a.n);
        BNSettingManager.setEngCarIcon(this.f7499a.k);
        BNSettingManager.setNewEnergyCarExt(this.f7499a.p);
        BNSettingManager.setEngPassportIds(this.f7499a.f7483a);
        BNSettingManager.setEnergyDefaultPlate(this.f7499a.getPlate(i));
    }

    private void g(int i) {
        BNSettingManager.setEtcClass(this.f7499a.d);
        BNSettingManager.setEtcColor(this.f7499a.e);
        BNSettingManager.setIsEtc(this.f7499a.f);
        BNSettingManager.setIsPickUp(this.f7499a.g);
        BNSettingManager.setBrandId(this.f7499a.i);
        BNSettingManager.setCarIcon(this.f7499a.k);
        BNSettingManager.setCarPassportIds(this.f7499a.f7483a);
        BNSettingManager.setCarPlateToLocal(this.f7499a.getPlate(i));
    }

    private void h(int i) {
        if (i == 1) {
            f(i);
        } else {
            g(i);
        }
    }

    private boolean i(int i) {
        Bundle h;
        if (i == 1) {
            h = com.baidu.navisdk.framework.b.y();
        } else {
            h = com.baidu.navisdk.framework.b.h();
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.CAR_PLATE;
        if (gVar.d()) {
            gVar.e("CarPlateManager", "syncPlateFromCarOwner: " + h);
        }
        if (h != null) {
            g gVar2 = new g();
            gVar2.a(h, i);
            if (!gVar2.equals(this.f7499a)) {
                this.f7499a.a(h, i);
                h(i);
            }
            return true;
        }
        e(i);
        if (gVar.e()) {
            gVar.g("CarPlateManager", "get carnum form local");
        }
        return true;
    }

    @NonNull
    public g a() {
        i(0);
        return this.f7499a;
    }

    private a() {
        this.f7499a = new g();
    }

    @NonNull
    public g b(int i) {
        i(i);
        return this.f7499a;
    }

    @NonNull
    public g a(int i) {
        i(i);
        return this.f7499a.m94clone();
    }
}
