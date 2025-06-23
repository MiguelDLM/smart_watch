package com.baidu.navisdk.module.pronavi.model;

import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;

/* loaded from: classes7.dex */
public class j {
    private static j d = null;
    public static int e = -1;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7471a = false;
    public boolean b = false;
    public int c = 5;

    public static j b() {
        if (d == null) {
            d = new j();
        }
        return d;
    }

    public boolean a() {
        boolean z;
        boolean z2;
        if (!com.baidu.navisdk.module.offscreen.a.g) {
            return false;
        }
        boolean c = com.baidu.navisdk.module.offscreen.a.m().c();
        if (BNPowerSaver.getInstance().a() <= 20) {
            z = true;
        } else {
            z = false;
        }
        if (BNCommSettingManager.getInstance().getPowerSaveMode() == 2) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean b = BNPowerSaver.getInstance().b();
        boolean z3 = com.baidu.navisdk.module.offscreen.a.i;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("offScreen", "ret 0 ,ret2, ret3, ret4 , ret5 is " + c + z + ", " + z2 + "," + b + "," + z3);
        }
        com.baidu.navisdk.module.offscreen.a.a("offScreen", "ret 0,ret2, ret3, ret4 , ret5 is " + c + z + ", " + z2 + "," + b + "," + z3);
        if (!c || !z || !z2 || b || !z3) {
            return false;
        }
        return true;
    }
}
