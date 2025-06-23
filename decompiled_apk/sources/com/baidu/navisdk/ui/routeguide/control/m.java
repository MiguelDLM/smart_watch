package com.baidu.navisdk.ui.routeguide.control;

import android.view.View;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class m extends com.baidu.navisdk.module.newguide.abs.c {
    public static com.baidu.navisdk.ui.routeguide.model.w f;

    /* renamed from: a, reason: collision with root package name */
    private View f8566a;
    private View b;
    private View c;
    private View d;
    private View e;

    public m(View view) {
        this.f8566a = view;
        p();
    }

    private void p() {
        Object valueOf;
        this.d = null;
        this.e = null;
        if (this.f8566a != null) {
            if (x.b().s2()) {
                this.b = this.f8566a.findViewById(R.id.bnav_rg_top_panel);
                this.c = null;
            } else {
                this.b = null;
                View findViewById = this.f8566a.findViewById(R.id.bnav_rg_left_panel);
                this.c = findViewById;
                if (findViewById != null) {
                    findViewById.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_guide_top_panel));
                }
            }
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("initPanel -> mRootViewGroup = ");
            sb.append(this.f8566a);
            sb.append("isOrientationPortrait = ");
            sb.append(x.b().s2());
            sb.append(", mTopPanel = ");
            View view = this.b;
            Object obj = "null";
            if (view == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(view.getVisibility());
            }
            sb.append(valueOf);
            sb.append(", mLandspaceLeftPanel = ");
            View view2 = this.c;
            if (view2 != null) {
                obj = Integer.valueOf(view2.getVisibility());
            }
            sb.append(obj);
            gVar.e("RGGuidePanelManager", sb.toString());
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.y
    public View[] B() {
        View view;
        if (x.b().s2()) {
            View view2 = this.b;
            if (view2 != null && view2.isShown()) {
                view = this.b;
            } else {
                if (!com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                    if (e() != null && this.d.isShown()) {
                        view = this.d;
                    } else if (f() != null && this.e.isShown()) {
                        view = this.e;
                    }
                }
                view = null;
            }
        } else {
            View view3 = this.c;
            if (view3 != null && view3.isShown()) {
                view = this.c;
            }
            view = null;
        }
        if (view == null) {
            return null;
        }
        return new View[]{view};
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void a(View view, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "orientationChanged -> rootViewGroup = " + view + ", orien = " + i);
        }
        this.f8566a = view;
        p();
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public int b() {
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_land_left_panel_width_new);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_land_left_panel_width);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public View c() {
        return this.c;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public View e() {
        View view;
        if (this.d == null && x.b().s2() && (view = this.f8566a) != null) {
            this.d = view.findViewById(R.id.bnav_rg_simple_model_guide_panel);
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "getSimpleModeGuidePanel -> isOrientationPortrait = " + x.b().s2() + ", mRootViewGroup = " + this.f8566a + ", panel = " + this.d);
        }
        return this.d;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public View f() {
        View view;
        if (this.e == null && x.b().s2() && (view = this.f8566a) != null) {
            this.e = view.findViewById(R.id.bnav_rg_simple_model_highway_view);
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "getSimpleModeHighwayPanel -> isOrientationPortrait = " + x.b().s2() + ", mRootViewGroup = " + this.f8566a + ", panel = " + this.e);
        }
        return this.e;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public int g() {
        return x.b().X() + (JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_lane_line_margin_top) * 2);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public View h() {
        return this.b;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void i() {
        c(true);
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void j() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "hideTopPanel -> mTopPanel = " + this.b);
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public boolean k() {
        return !com.baidu.navisdk.ui.routeguide.utils.b.x();
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void l() {
        f = null;
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void n() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "showSimpleGuideLeftPanelView -> mLandspaceLeftPanel = " + this.c);
        }
        View view = this.c;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void o() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "showTopPanel -> mTopPanel = " + this.b);
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void c(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGGuidePanelManager", "hideSimpleGuideLeftPanelView -> mLandspaceLeftPanel = " + this.c + ", isInvisible = " + z);
        }
        View view = this.c;
        if (view != null) {
            if (z) {
                view.setVisibility(4);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.navisdk.module.newguide.abs.c
    public void b(boolean z) {
        View view;
        if (x.b().s2() || (view = this.c) == null) {
            return;
        }
        view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_rg_guide_top_panel));
    }
}
