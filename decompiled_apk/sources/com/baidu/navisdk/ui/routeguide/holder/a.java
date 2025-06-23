package com.baidu.navisdk.ui.routeguide.holder;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.routeguide.asr.c;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a {

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f8642a = new a();
    }

    public static a d() {
        return b.f8642a;
    }

    public Drawable a() {
        return x.b().r0();
    }

    public String b() {
        return x.b().q0();
    }

    public void c() {
        a0 I = a0.I();
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f2()) {
            BNRouteGuider.getInstance().messageCallback(1, 0, 0, new com.baidu.navisdk.module.pronavi.message.model.a(JarUtils.getResources().getString(R.string.nsdk_string_rg_fuzzy_panel_text, I.g())));
        } else {
            Bundle bundle = a0.A;
            BNRouteGuider.getInstance().messageCallback(1, 0, 0, new com.baidu.navisdk.module.pronavi.message.model.a(bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist), bundle.getString("road_name"), I.d(bundle.getString("icon_name")), I.e().d()));
        }
    }

    private a() {
    }

    private boolean b(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleGuideModelHolde", "isSamePosition addDist1: " + i + ",addDist2: " + i2);
        }
        return Math.abs(i - i2) <= 2;
    }

    public void a(boolean z) {
        if (a0.I().b(z)) {
            c.n().b(!z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x01a3, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012c, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00d9, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00af  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.os.Bundle a(int r9, int r10) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.holder.a.a(int, int):android.os.Bundle");
    }

    public void b(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSimpleGuideModelHolde", "setIsShowExitMainRoadGuide: " + z + ", cloud:" + f.c().c.k0);
        }
        if (com.baidu.navisdk.module.newguide.a.e().d() && f.c().c.k0) {
            a0.I().e(z);
        } else {
            a0.I().e(false);
        }
    }
}
