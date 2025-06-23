package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.j;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class c {
    private static c g;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8522a = false;
    private boolean b = false;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;

    private c() {
    }

    public static c g() {
        if (g == null) {
            synchronized (c.class) {
                g = new c();
            }
        }
        return g;
    }

    public void a(boolean z) {
        this.f8522a = z;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public int c() {
        if (this.d == 0) {
            this.d = BNSettingManager.getCarIconOffsetForLightNavi()[1];
        }
        return this.d;
    }

    public int d() {
        if (this.f == 0 || !j.d()) {
            if (BNSettingManager.getUserCarIconOffsetForNavi()[1] == 0) {
                this.f = BNSettingManager.getCarIconOffsetForNavi()[1];
            } else {
                this.f = BNSettingManager.getUserCarIconOffsetForNavi()[1];
            }
            if (this.f != 0) {
                if (f.c().c.Z != 0) {
                    this.f += ScreenUtil.getInstance().dip2px(f.c().c.Z);
                } else {
                    this.f += ScreenUtil.getInstance().dip2px(69);
                }
            }
        }
        return this.f;
    }

    public boolean e() {
        return this.f8522a;
    }

    public boolean f() {
        return this.b;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        BNSettingManager.setCarIconOffsetForLightNavi(i, i2);
    }

    public int b() {
        if (this.e == 0 || !j.d()) {
            if (BNSettingManager.getUserCarIconOffsetForNavi()[0] == 0) {
                this.e = BNSettingManager.getCarIconOffsetForNavi()[0];
            } else {
                this.e = BNSettingManager.getUserCarIconOffsetForNavi()[0];
            }
        }
        return this.e;
    }

    public int a() {
        if (this.c == 0) {
            this.c = BNSettingManager.getCarIconOffsetForLightNavi()[0];
        }
        return this.c;
    }
}
