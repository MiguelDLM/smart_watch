package com.baidu.navisdk.ui.routeguide.model;

import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;

/* loaded from: classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private int f8947a;
    private String b;
    private String c;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final j f8948a = new j();
    }

    public static j e() {
        return b.f8948a;
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("ServiceArea", "updateExitFastwayData=null");
            }
            this.b = null;
            this.f8947a = -1;
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("ServiceArea", "updateExitFastwayData=" + bundle.toString());
        }
        this.b = bundle.getString(RouteGuideParams.RGKey.ExitFastway.ROAD_NAME);
        bundle.getInt(RouteGuideParams.RGKey.ExitFastway.REMAIN_DIST);
        this.c = bundle.getString(RouteGuideParams.RGKey.ExitFastway.ROAD_ID);
        this.f8947a = bundle.getInt(RouteGuideParams.RGKey.ExitFastway.ADD_DIST);
    }

    public int b() {
        return this.f8947a;
    }

    public String c() {
        String str = this.b;
        if (str != null) {
            return str.replace(",", " ");
        }
        return str;
    }

    public void d() {
        this.b = null;
        this.c = null;
        this.f8947a = -1;
    }

    private j() {
        this.f8947a = -1;
        this.b = null;
        this.c = null;
    }

    public String a() {
        String str = this.c;
        return str == null ? "" : str;
    }
}
