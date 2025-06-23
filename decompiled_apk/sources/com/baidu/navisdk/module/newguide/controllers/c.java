package com.baidu.navisdk.module.newguide.controllers;

import android.app.Activity;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class c {
    public static void a() {
        boolean s2 = x.b().s2();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScreenOrientationCont", "changeScreenOrientationByVoice: " + s2);
        }
        a(s2 ? 2 : 1);
    }

    private static int b(int i) {
        if (i == 0) {
            return 2;
        }
        return i == 2 ? 6 : 1;
    }

    public static void c() {
        int screenOrientationMode = BNCommSettingManager.getInstance().getScreenOrientationMode();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScreenOrientationCont", "quiteIndoorPark: " + screenOrientationMode);
        }
        a(screenOrientationMode);
    }

    public static void b() {
        int screenOrientationMode = BNCommSettingManager.getInstance().getScreenOrientationMode();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScreenOrientationCont", "onPageToTop: " + screenOrientationMode);
        }
        a(screenOrientationMode);
    }

    public static void a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScreenOrientationCont", "changeScreenOrientation: " + i);
        }
        Activity b = com.baidu.navisdk.ui.routeguide.b.V().b();
        if (b == null || b.isFinishing()) {
            return;
        }
        b.setRequestedOrientation(b(i));
    }

    public static int c(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGScreenOrientationCont", "switchSysConfigToCustomOrientation: " + i);
        }
        return i == 2 ? 2 : 1;
    }
}
