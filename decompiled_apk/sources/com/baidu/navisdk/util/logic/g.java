package com.baidu.navisdk.util.logic;

import android.content.Context;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes8.dex */
public class g {
    private static g b;

    /* renamed from: a, reason: collision with root package name */
    private f f9326a;

    private g() {
    }

    public static g j() {
        if (b == null) {
            synchronized (g.class) {
                try {
                    if (b == null) {
                        b = new g();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a(Context context) {
    }

    public int b() {
        int i;
        if (a.j().g()) {
            if (a.j().f()) {
                i = 1;
            } else {
                i = 2;
            }
        } else {
            i = 0;
        }
        if (i == 1) {
            return i;
        }
        if (!j.r().g()) {
            return 0;
        }
        if (j.r().f()) {
            return 1;
        }
        return 2;
    }

    public GeoPoint c() {
        GeoPoint d = a.j().d();
        if (d != null && d.isValid()) {
            return d;
        }
        GeoPoint d2 = j.r().d();
        if (d2 != null) {
            d2.isValid();
        }
        return d2;
    }

    public com.baidu.navisdk.model.datastruct.g d() {
        f fVar = this.f9326a;
        if (fVar != null) {
            return fVar.a();
        }
        LogUtil.e("BNLocationManagerProxy", "getNavingCurLocation mNavingLocationManager is null");
        return null;
    }

    public GeoPoint e() {
        f fVar = this.f9326a;
        if (fVar != null) {
            return fVar.d();
        }
        LogUtil.e("BNLocationManagerProxy", "getNavingLastValidLocation mNavingLocationManager is null");
        return null;
    }

    public boolean f() {
        boolean f = a.j().f();
        if (f) {
            return f;
        }
        return j.r().m();
    }

    public boolean g() {
        if (this.f9326a != null) {
            if (LogUtil.LOGGABLE) {
                TipTool.onCreateDebugToast(com.baidu.navisdk.framework.a.c().a(), "触发反作弊：" + this.f9326a.h());
            }
            return this.f9326a.h();
        }
        LogUtil.e("BNLocationManagerProxy", "isMock mNavingLocationManager is null");
        return false;
    }

    public boolean h() {
        f fVar = this.f9326a;
        if (fVar != null) {
            if (!fVar.f() || this.f9326a.a() == null) {
                return false;
            }
            return true;
        }
        LogUtil.e("BNLocationManagerProxy", "isNavingLocationValid mNavingLocationManager is null");
        return false;
    }

    public void i() {
    }

    public com.baidu.navisdk.model.datastruct.g a() {
        com.baidu.navisdk.model.datastruct.g a2 = a.j().a();
        if (a2 != null && a2.b()) {
            return a2;
        }
        com.baidu.navisdk.model.datastruct.g a3 = j.r().a();
        if (a3 != null) {
            a3.b();
        }
        return a3;
    }

    public void a(f fVar) {
        this.f9326a = fVar;
    }
}
