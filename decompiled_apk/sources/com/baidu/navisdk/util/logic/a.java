package com.baidu.navisdk.util.logic;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.n0;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.common.x;

/* loaded from: classes8.dex */
public class a extends f {
    private static final String h = "a";
    private static a i;
    private LocationManager f;
    private int g = 1;

    private a() {
    }

    public static int a(int i2, String str) {
        if (i2 == 61) {
            return 1;
        }
        if (i2 == 161) {
            if ("wf".equalsIgnoreCase(str)) {
                return 2;
            }
            if ("cl".equalsIgnoreCase(str)) {
                return 3;
            }
        }
        return 0;
    }

    private void e(com.baidu.navisdk.model.datastruct.g gVar) {
        BNRouteGuider.getInstance().triggerGPSDataChange((int) (gVar.b * 100000.0d), (int) (gVar.f6926a * 100000.0d), gVar.c, gVar.e, gVar.f, (float) gVar.h, gVar.g, gVar.k, gVar.j, 2, gVar.o, gVar.a());
    }

    public static synchronized a j() {
        a aVar;
        synchronized (a.class) {
            try {
                if (i == null) {
                    i = new a();
                }
                aVar = i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public void b(com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
        if (gVar2 != null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(h, "updateLocation " + gVar2);
            }
            a(gVar, gVar2);
            a(gVar2);
        }
    }

    public void c(com.baidu.navisdk.model.datastruct.g gVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(h, "triggerGPSDataChangeForDriving   longitude:" + gVar.b + ", latitude:" + gVar.f6926a + ", locType:" + gVar.i + ", satellitesNum:" + gVar.g);
            SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("Driving sysloc=long:" + gVar.b + ", lati:" + gVar.f6926a + ", speed:" + gVar.c + ", direction:" + gVar.e + ", accuracy:" + gVar.f + ", bias:" + gVar.d + ", locType:" + gVar.k + ", satellitesNum:" + gVar.g + "isGcj true");
        }
        e(gVar);
    }

    public void d(com.baidu.navisdk.model.datastruct.g gVar) {
        b(null, gVar);
    }

    @Override // com.baidu.navisdk.util.logic.f
    public boolean f() {
        if (RouteGuideParams.getRouteGuideMode() == 2) {
            if (a() == null) {
                return false;
            }
            return !"wf".equals(a().m);
        }
        if (a() != null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.util.logic.f
    public boolean g() {
        if (RouteGuideParams.getRouteGuideMode() == 2) {
            try {
                if (this.f == null && b(com.baidu.navisdk.framework.a.c().a())) {
                    this.f = (LocationManager) com.baidu.navisdk.framework.a.c().a().getSystemService("location");
                }
                return this.f.isProviderEnabled("gps");
            } catch (Exception unused) {
                return false;
            }
        }
        if (!n0.a(com.baidu.navisdk.framework.a.c().a(), com.kuaishou.weapon.p0.g.g) || !n0.a(com.baidu.navisdk.framework.a.c().a(), com.kuaishou.weapon.p0.g.h)) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.util.logic.f
    public boolean h() {
        return false;
    }

    public void b(com.baidu.navisdk.model.datastruct.g gVar) {
        if (x.t() || gVar == null) {
            return;
        }
        Bundle d = o.d(gVar.b, gVar.f6926a);
        double d2 = d.getDouble("LLx");
        double d3 = d.getDouble("LLy");
        double d4 = gVar.h;
        float f = gVar.c;
        float f2 = gVar.e;
        float f3 = gVar.f;
        float f4 = gVar.d;
        int a2 = a(gVar.i, gVar.m);
        int i2 = gVar.l;
        int i3 = i2 == 1 ? 1 : i2 == 0 ? 2 : 0;
        if (this.g >= 10) {
            this.g = 1;
            LogUtil.e("triggerStartLocationData:", NotificationCompat.CATEGORY_CALL);
        }
        this.g++;
        BNRouteGuider.getInstance().triggerStartLocationData((int) (d2 * 100000.0d), (int) (d3 * 100000.0d), (float) d4, f, f2, f3, f4, a2, i3, gVar.j);
    }

    public boolean b(Context context) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && -1 == packageManager.checkPermission(com.kuaishou.weapon.p0.g.g, a0.g())) {
                    TipTool.onCreateToastDialog(context, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_error_gps_permission_fail));
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }
}
