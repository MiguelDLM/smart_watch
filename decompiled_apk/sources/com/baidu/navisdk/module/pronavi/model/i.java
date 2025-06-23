package com.baidu.navisdk.module.pronavi.model;

import android.content.Context;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class i {
    public static final int[] h = {40, 150, 400};
    private static i i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7470a = false;
    public boolean b = false;
    public boolean c = true;
    public boolean d = false;
    public int e = -1;
    public int f = 0;
    public int[] g = new int[3];

    private i() {
    }

    public static i f() {
        if (i == null) {
            i = new i();
        }
        return i;
    }

    public void a(boolean z) {
        BNRouteGuider.getInstance().updateInstantConfigParams(!z, b(), a());
    }

    public int[] b() {
        if (com.baidu.navisdk.module.cloudconfig.f.c().o) {
            if (this.f7470a) {
                return this.g;
            }
            f.a0 a0Var = com.baidu.navisdk.module.cloudconfig.f.c().f7101a;
            if (a0Var != null) {
                return a0Var.c();
            }
        }
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 == null) {
            LogUtil.e("RGMultiRouteModel", "context is null");
            return h;
        }
        String a3 = e0.a(a2).a("sp_rg_instant_last_cloud_pstlabeldis_value", (String) null);
        if (a3 != null && a3.length() != 0) {
            try {
                String[] split = a3.substring(1, a3.length() - 1).split(",");
                int length = split.length;
                if (length != 3) {
                    return h;
                }
                int[] iArr = new int[3];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = Integer.valueOf(split[i2].trim()).intValue();
                }
                return iArr;
            } catch (Exception unused) {
                LogUtil.e("RGMultiRouteModel", "Exception labelDis");
                return h;
            }
        }
        LogUtil.e("RGMultiRouteModel", "labelDis is null");
        return h;
    }

    public boolean c() {
        if (com.baidu.navisdk.module.cloudconfig.f.c().o) {
            if (this.f7470a) {
                return this.c;
            }
            f.a0 a0Var = com.baidu.navisdk.module.cloudconfig.f.c().f7101a;
            if (a0Var != null) {
                return a0Var.d();
            }
        }
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 != null) {
            LogUtil.e("RGMultiRouteModel", "context not null");
            return e0.a(a2).a("sp_rg_instant_last_cloud_open_state", true);
        }
        LogUtil.e("RGMultiRouteModel", "context is null");
        return true;
    }

    public void d() {
        boolean c;
        if (!com.baidu.navisdk.j.d()) {
            c = BNSettingManager.isMultiRouteEnable();
        } else {
            c = c();
        }
        a(c);
    }

    public void e() {
        f.a0 a0Var = com.baidu.navisdk.module.cloudconfig.f.c().f7101a;
        if (a0Var == null) {
            LogUtil.e("RGMultiRouteModel", "MultiRoadConfig is null");
            return;
        }
        this.c = a0Var.d();
        int[] c = a0Var.c();
        this.g = c;
        if (c != null && c.length == 3) {
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            if (a2 != null) {
                e0.a(a2).b("sp_rg_instant_last_cloud_open_state", this.c);
                e0.a(a2).b("sp_rg_instant_last_cloud_pstlabeldis_value", Arrays.toString(this.g));
            }
            this.f7470a = true;
            d();
        }
    }

    public int a() {
        int b;
        f.a0 a0Var = com.baidu.navisdk.module.cloudconfig.f.c().f7101a;
        if (a0Var != null && (b = a0Var.b()) > 0) {
            return b;
        }
        return 1000;
    }
}
