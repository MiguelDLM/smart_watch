package com.baidu.navisdk.ui.routeguide.asr.instruction;

import android.os.Bundle;
import android.util.Pair;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.pronavi.model.h;
import com.baidu.navisdk.util.common.x;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public enum d {
    INSTANCE;


    /* renamed from: a, reason: collision with root package name */
    private int f8476a;
    private boolean b;

    public static Pair<Integer, Integer> c() {
        int c;
        int d2;
        int i;
        if (2 == h.f7469a) {
            com.baidu.navisdk.ui.routeguide.utils.a aVar = com.baidu.navisdk.ui.routeguide.utils.a.f9151a;
            i = aVar.c() - ((aVar.c() / 4) - 10);
            d2 = aVar.a();
        } else {
            if (!x.q()) {
                c = 0;
            } else if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().h2()) {
                c = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_top_guide_mini_height) - 10;
            } else {
                c = com.baidu.navisdk.module.newguide.a.e().c() - 10;
            }
            com.baidu.navisdk.pronavi.util.a aVar2 = com.baidu.navisdk.pronavi.util.a.h;
            int e = aVar2.e();
            d2 = aVar2.d() - c;
            i = e;
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(d2));
    }

    public String a() {
        int i = this.f8476a;
        return i == 1 ? "2" : i == 2 ? "1" : "0";
    }

    public boolean b() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(String str, int i) {
        this.f8476a = 1;
        a(1, 1, str, i);
    }

    public void a(String str) {
        this.f8476a = 2;
        a(2, 1, str, 31);
    }

    private void a(int i, int i2, String str, int i3) {
        Bundle bundle;
        try {
            bundle = new Bundle();
            try {
                bundle.putDouble("bound_top", BNMapController.getInstance().getMapStatus().h.c);
                bundle.putDouble("bound_left", BNMapController.getInstance().getMapStatus().h.f9475a);
                bundle.putDouble("bound_right", BNMapController.getInstance().getMapStatus().h.b);
                bundle.putDouble("bound_bottom", BNMapController.getInstance().getMapStatus().h.d);
                Pair<Integer, Integer> c = c();
                bundle.putFloat("fWidth", ((Integer) c.first).intValue());
                bundle.putFloat("fHeight", ((Integer) c.second).intValue());
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            bundle = null;
        }
        BNRouteGuider.getInstance().calcOtherRoute("", 1, i3, i, i2, str, bundle);
    }
}
