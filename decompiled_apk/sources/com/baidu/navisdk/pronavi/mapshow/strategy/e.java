package com.baidu.navisdk.pronavi.mapshow.strategy;

import OXOo.OOXIXo;
import android.app.Activity;
import android.graphics.Rect;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.model.m;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes7.dex */
public final class e extends com.baidu.navisdk.pronavi.mapshow.strategy.a {

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    public e(int i, int i2) {
        super(i, i2);
    }

    @Override // com.baidu.navisdk.pronavi.mapshow.i.a
    @OOXIXo
    public String a() {
        return "RGParkRecMapShowStrategy";
    }

    @Override // com.baidu.navisdk.pronavi.mapshow.i.a
    @OOXIXo
    public Rect a(int i, @OOXIXo Activity activity) {
        int b;
        int i2;
        int dip2px;
        int i3;
        IIX0o.x0xO0oo(activity, "activity");
        if (i == 2) {
            com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
            IIX0o.oO(b2, "RGViewController.getInstance()");
            int V = b2.V();
            i3 = b();
            ScreenUtil screenUtil = ScreenUtil.getInstance();
            com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V2, "BNavigator.getInstance()");
            int statusBarHeight = screenUtil.getStatusBarHeight(V2.b());
            com.baidu.navisdk.ui.routeguide.mapmode.subview.a c = com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c();
            IIX0o.oO(c, "DisplayCutoutManager.getInstance()");
            if (c.b()) {
                V += statusBarHeight;
            }
            com.baidu.navisdk.ui.routeguide.b V3 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V3, "BNavigator.getInstance()");
            com.baidu.navisdk.ui.routeguide.navicenter.impl.d r = V3.r();
            IIX0o.oO(r, "BNavigator.getInstance().uiAction");
            r2 = r.g() ? statusBarHeight : 0;
            b = c();
            dip2px = r2 + 30;
            r2 = V;
        } else {
            b = b() - JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_250dp);
            int c2 = c();
            com.baidu.navisdk.ui.routeguide.mapmode.a b3 = x.b();
            IIX0o.oO(b3, "RGViewController.getInstance()");
            int i4 = 60;
            if (b3.f2()) {
                com.baidu.navisdk.module.newguide.a e = com.baidu.navisdk.module.newguide.a.e();
                IIX0o.oO(e, "RGNewOldFuncController.getInstance()");
                i2 = e.c();
            } else {
                com.baidu.navisdk.ui.routeguide.mapmode.a b4 = x.b();
                IIX0o.oO(b4, "RGViewController.getInstance()");
                if (b4.N2()) {
                    com.baidu.navisdk.module.newguide.a e2 = com.baidu.navisdk.module.newguide.a.e();
                    IIX0o.oO(e2, "RGNewOldFuncController.getInstance()");
                    i2 = e2.c();
                } else if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                    m y = m.y();
                    IIX0o.oO(y, "RGHighwayModel.getInstance()");
                    if (y.u()) {
                        com.baidu.navisdk.ui.routeguide.mapmode.a b5 = x.b();
                        IIX0o.oO(b5, "RGViewController.getInstance()");
                        if (b5.h2()) {
                            i2 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_top_guide_mini_height);
                        }
                    }
                    com.baidu.navisdk.module.newguide.a e3 = com.baidu.navisdk.module.newguide.a.e();
                    IIX0o.oO(e3, "RGNewOldFuncController.getInstance()");
                    i2 = e3.c();
                } else {
                    i4 = 40;
                    i2 = 0;
                }
            }
            dip2px = i2 + ScreenUtil.getInstance().dip2px(i4);
            com.baidu.navisdk.ui.routeguide.b V4 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V4, "BNavigator.getInstance()");
            com.baidu.navisdk.ui.routeguide.navicenter.impl.d r2 = V4.r();
            IIX0o.oO(r2, "BNavigator.getInstance().uiAction");
            if (r2.g()) {
                dip2px = ScreenUtil.getInstance().getStatusBarHeight(activity) + dip2px;
            }
            i3 = c2;
        }
        return new Rect(r2, dip2px, i3, b);
    }
}
