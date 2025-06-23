package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.view.View;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes8.dex */
public class a {
    private static a c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8711a = false;
    private boolean b = false;

    public static a c() {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        c = new a();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public void a(boolean z) {
        this.f8711a = z;
    }

    public boolean b() {
        return this.f8711a && !com.baidu.navisdk.pronavi.util.a.h.i();
    }

    public void a(Activity activity) {
        if (!this.b || this.f8711a || activity == null) {
            return;
        }
        this.b = false;
        b(activity);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        r4 = r4.getWindow().getDecorView().getRootWindowInsets();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.app.Activity r4) {
        /*
            r3 = this;
            boolean r0 = r3.b
            if (r0 != 0) goto L6b
            r0 = 1
            r3.b = r0
            com.baidu.navisdk.ui.routeguide.b r1 = com.baidu.navisdk.ui.routeguide.b.V()
            int r1 = r1.q()
            r2 = 2
            if (r1 != r2) goto L16
            r4 = 0
            r3.f8711a = r4
            return
        L16:
            android.content.pm.PackageManager r1 = r4.getPackageManager()
            java.lang.String r2 = "com.oppo.feature.screen.heteromorphism"
            boolean r1 = r1.hasSystemFeature(r2)
            if (r1 == 0) goto L25
            r3.f8711a = r0
            goto L4a
        L25:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L4a
            android.view.Window r4 = r4.getWindow()
            android.view.View r4 = r4.getDecorView()
            android.view.WindowInsets r4 = com.baidu.navisdk.ui.routeguide.mapmode.subview.oIX0oI.oIX0oI(r4)
            if (r4 == 0) goto L4a
            android.view.DisplayCutout r4 = androidx.core.view.xoO0xx0.oIX0oI(r4)
            if (r4 == 0) goto L4a
            r3.f8711a = r0
            com.baidu.navisdk.util.statistic.userop.b r4 = com.baidu.navisdk.util.statistic.userop.b.r()
            java.lang.String r0 = "1.z"
            r4.b(r0)
        L4a:
            com.baidu.navisdk.util.common.g r4 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r0 = r4.d()
            if (r0 == 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "是否是异形屏："
            r0.append(r1)
            boolean r1 = r3.f8711a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RouteGuide"
            r4.e(r1, r0)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.mapmode.subview.a.b(android.app.Activity):void");
    }

    public void a(int i, boolean z, boolean z2, View... viewArr) {
        if (this.f8711a) {
            int statusBarHeight = ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
            int i2 = z ? statusBarHeight : 0;
            if (!z2) {
                statusBarHeight = 0;
            }
            for (View view : viewArr) {
                if (view != null) {
                    if (a(i)) {
                        view.setPadding(i2, 0, statusBarHeight, 0);
                    } else {
                        view.setPadding(0, 0, 0, 0);
                    }
                }
            }
        }
    }

    public int a() {
        if (!this.f8711a || com.baidu.navisdk.pronavi.util.a.h.i()) {
            return 0;
        }
        return ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
    }

    public void a(View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setPadding(0, 0, 0, 0);
            }
        }
    }

    private boolean a(int i) {
        return i == 2 && !com.baidu.navisdk.pronavi.util.a.h.i();
    }
}
