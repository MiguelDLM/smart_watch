package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class r extends com.baidu.navisdk.ui.routeguide.widget.d {
    private View i;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGMMDestArrivalTimeView", "showDestArrivalTimeView(), handleArrivalTimeViewCollision()");
            }
            r.this.n0();
        }
    }

    public r(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
    }

    private Rect o0() {
        Rect rect = new Rect();
        View view = this.i;
        if (view != null) {
            view.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d, com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        View view;
        if (!com.baidu.navisdk.ui.routeguide.control.x.b().s2() && (view = this.i) != null && view.isShown()) {
            return new View[]{this.i};
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        this.i = null;
    }

    public void n0() {
        boolean z;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDestArrivalTimeView", "handleArrivalTimeViewCollision(), RGViewController.getInstance().isOrientationPortrait()=" + com.baidu.navisdk.ui.routeguide.control.x.b().s2());
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().s2()) {
            return;
        }
        int dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_6dp);
        boolean j = com.baidu.navisdk.ui.routeguide.control.x.b().I().j();
        if (j) {
            dimensionPixelOffset = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_road_condition_bar_width) + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_1dp);
        }
        if (gVar.d()) {
            gVar.e("RGMMDestArrivalTimeView", "updateArrivalTimeViewMargin(), marginRight=" + dimensionPixelOffset + ", isRoadConditionBarShown=" + j);
        }
        a(dimensionPixelOffset, "right");
        Resources resources = JarUtils.getResources();
        int i = R.dimen.navi_dimens_4dp;
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(i);
        Rect o02 = o0();
        Rect W = com.baidu.navisdk.ui.routeguide.control.x.b().W();
        boolean p2 = com.baidu.navisdk.ui.routeguide.control.x.b().p2();
        if (W != null && p2 && W.right >= o02.left) {
            dimensionPixelOffset2 = com.baidu.navisdk.ui.routeguide.control.x.b().X() + JarUtils.getResources().getDimensionPixelOffset(i);
        }
        if (gVar.d()) {
            gVar.e("RGMMDestArrivalTimeView", "updateArrivalTimeViewMargin(), laneLineLocation=" + W + ", destArrivalTimeLocation=" + o02 + ",isLaneVisible=" + p2);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.iview.e l0 = com.baidu.navisdk.ui.routeguide.control.x.b().l0();
        boolean z2 = true;
        boolean z3 = false;
        if (l0 != null) {
            boolean a2 = l0.a();
            Rect X = l0.X();
            if (X != null && a2) {
                dimensionPixelOffset2 = X.bottom + JarUtils.getResources().getDimensionPixelOffset(i);
                z = true;
            } else {
                z = false;
            }
            if (gVar.d()) {
                gVar.e("RGMMDestArrivalTimeView", "updateArrivalTimeViewMargin(), routeWeatherLocation=" + X + ",isRouteWeatherVisible=" + a2);
            }
        } else {
            z = false;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.presenter.f m0 = com.baidu.navisdk.ui.routeguide.control.x.b().m0();
        if (m0 != null) {
            Rect c = m0.c();
            boolean f = m0.f();
            if (c != null && f) {
                dimensionPixelOffset2 = c.bottom + JarUtils.getResources().getDimensionPixelOffset(i);
            } else {
                z2 = z;
            }
            if (gVar.d()) {
                gVar.e("RGMMDestArrivalTimeView", "updateArrivalTimeViewMargin(), serviceAreaLocation=" + c + ",isServiceAreaVisible=" + f);
            }
            z = z2;
        }
        if (gVar.d()) {
            gVar.e("RGMMDestArrivalTimeView", "handleArrivalTimeViewCollision: " + z);
        }
        if (!z || com.baidu.navisdk.ui.routeguide.b.V().r().g()) {
            z3 = z;
        }
        if (z3) {
            dimensionPixelOffset2 -= ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.ui.routeguide.b.V().b());
        }
        if (gVar.d()) {
            gVar.e("RGMMDestArrivalTimeView", "updateArrivalTimeViewMargin(), marginTop=" + dimensionPixelOffset2);
        }
        a(dimensionPixelOffset2, "top");
    }

    public void y(boolean z) {
        View view;
        if (this.f != 2 || com.baidu.navisdk.module.pronavi.a.j == 2) {
            return;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDestArrivalTimeView", "showDestArrivalTimeView(), show=" + z + ", mDestArrivalTimeTV=" + this.i);
        }
        if (z && (com.baidu.navisdk.ui.routeguide.model.a.c().d || com.baidu.navisdk.ui.routeguide.model.a0.I().D() || !com.baidu.navisdk.ui.routeguide.b.V().x())) {
            return;
        }
        View view2 = this.i;
        int i = 8;
        if (view2 != null) {
            if (z) {
                i = 0;
            }
            view2.setVisibility(i);
        } else {
            View findViewById = this.b.findViewById(R.id.bnav_rg_toolbox_convoy_time_layout);
            if (findViewById != null) {
                if (z) {
                    i = 0;
                }
                findViewById.setVisibility(i);
            }
        }
        if (z && (view = this.i) != null) {
            view.post(new a());
        }
    }

    public void a(View view) {
        this.i = view;
    }

    private void a(int i, String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGMMDestArrivalTimeView", "updateArrivalTimeViewMargin, margin=" + i + ", direction=" + str + ",mDestArrivalTimeTV=" + this.i);
        }
        View view = this.i;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if ("left".equals(str)) {
                if (marginLayoutParams.leftMargin == i) {
                    if (gVar.d()) {
                        gVar.e("RGMMDestArrivalTimeView", "updateArrivalTimeViewMargin, lp.leftMargin == margin, return");
                        return;
                    }
                    return;
                }
                marginLayoutParams.leftMargin = i;
            } else if ("top".equals(str)) {
                if (marginLayoutParams.topMargin == i) {
                    if (gVar.d()) {
                        gVar.e("RGMMDestArrivalTimeView", "updateArrivalTimeViewMargin, lp.topMargin == margin, return");
                        return;
                    }
                    return;
                }
                marginLayoutParams.topMargin = i;
            } else if ("right".equals(str)) {
                if (marginLayoutParams.rightMargin == i) {
                    if (gVar.d()) {
                        gVar.e("RGMMDestArrivalTimeView", "updateArrivalTimeViewMargin, lp.rightMargin == margin, return");
                        return;
                    }
                    return;
                }
                marginLayoutParams.rightMargin = i;
            } else if ("bottom".equals(str)) {
                if (marginLayoutParams.bottomMargin == i) {
                    if (gVar.d()) {
                        gVar.e("RGMMDestArrivalTimeView", "updateArrivalTimeViewMargin, lp.bottomMargin == margin, return");
                        return;
                    }
                    return;
                }
                marginLayoutParams.bottomMargin = i;
            }
            this.i.setLayoutParams(marginLayoutParams);
        }
    }
}
