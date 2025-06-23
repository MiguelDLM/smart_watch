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
public final class d extends com.baidu.navisdk.pronavi.mapshow.strategy.a {
    private int c;
    private int d;

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

    public d(int i, int i2) {
        super(i, i2);
        this.c = Integer.MIN_VALUE;
        this.d = Integer.MIN_VALUE;
    }

    @Override // com.baidu.navisdk.pronavi.mapshow.i.a
    @OOXIXo
    public String a() {
        return "RGNormalHDMapShowStrategy";
    }

    @Override // com.baidu.navisdk.pronavi.mapshow.i.a
    @OOXIXo
    public Rect a(int i, @OOXIXo Activity activity) {
        int i2;
        int c;
        int b;
        IIX0o.x0xO0oo(activity, "activity");
        com.baidu.navisdk.pronavi.hd.normal.i.a c2 = com.baidu.navisdk.ui.routeguide.utils.b.c(false);
        if (i == 2) {
            if (this.c == Integer.MIN_VALUE && c2 != null) {
                this.c = c2.f(i).getFirst().intValue();
            }
            int V = x.b().V();
            int statusBarHeight = ScreenUtil.getInstance().getStatusBarHeight(activity);
            com.baidu.navisdk.ui.routeguide.mapmode.subview.a c3 = com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c();
            IIX0o.oO(c3, "DisplayCutoutManager.getInstance()");
            if (c3.b()) {
                V += statusBarHeight;
            }
            com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V2, "BNavigator.getInstance()");
            com.baidu.navisdk.ui.routeguide.navicenter.impl.d r = V2.r();
            IIX0o.oO(r, "BNavigator.getInstance().uiAction");
            r0 = r.g() ? statusBarHeight : 0;
            c = b() - this.c;
            b = c();
            int i3 = r0;
            r0 = V;
            i2 = i3;
        } else {
            if (this.d == Integer.MIN_VALUE && c2 != null) {
                this.d = c2.f(i).getSecond().intValue();
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a b2 = x.b();
            IIX0o.oO(b2, "RGViewController.getInstance()");
            if (b2.f2()) {
                com.baidu.navisdk.module.newguide.a e = com.baidu.navisdk.module.newguide.a.e();
                IIX0o.oO(e, "RGNewOldFuncController.getInstance()");
                i2 = e.c();
            } else {
                com.baidu.navisdk.ui.routeguide.mapmode.a b3 = x.b();
                IIX0o.oO(b3, "RGViewController.getInstance()");
                if (b3.N2()) {
                    com.baidu.navisdk.module.newguide.a e2 = com.baidu.navisdk.module.newguide.a.e();
                    IIX0o.oO(e2, "RGNewOldFuncController.getInstance()");
                    i2 = e2.c();
                } else if (com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                    m y = m.y();
                    IIX0o.oO(y, "RGHighwayModel.getInstance()");
                    if (y.u()) {
                        com.baidu.navisdk.ui.routeguide.mapmode.a b4 = x.b();
                        IIX0o.oO(b4, "RGViewController.getInstance()");
                        if (b4.h2()) {
                            i2 = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_top_guide_mini_height);
                        }
                    }
                    com.baidu.navisdk.module.newguide.a e3 = com.baidu.navisdk.module.newguide.a.e();
                    IIX0o.oO(e3, "RGNewOldFuncController.getInstance()");
                    i2 = e3.c();
                } else {
                    i2 = 0;
                }
            }
            com.baidu.navisdk.ui.routeguide.b V3 = com.baidu.navisdk.ui.routeguide.b.V();
            IIX0o.oO(V3, "BNavigator.getInstance()");
            com.baidu.navisdk.ui.routeguide.navicenter.impl.d r2 = V3.r();
            IIX0o.oO(r2, "BNavigator.getInstance().uiAction");
            if (r2.g()) {
                i2 += ScreenUtil.getInstance().getStatusBarHeight(activity);
            }
            c = c();
            b = b() - this.d;
        }
        return new Rect(r0, i2, c, b);
    }
}
