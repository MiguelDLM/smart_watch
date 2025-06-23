package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.model.RGLaneInfoModel;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.List;

/* loaded from: classes8.dex */
public class n extends com.baidu.navisdk.ui.routeguide.widget.d implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {
    private static final String n = "n";
    private int[] i;
    private View j;
    private boolean k;
    private View l;
    private boolean[] m;

    public n(Context context, ViewGroup viewGroup, com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        super(context, viewGroup, aVar);
        this.i = new int[12];
        this.j = null;
        this.k = false;
        this.l = null;
        this.m = new boolean[12];
        p0();
    }

    private boolean A(boolean z) {
        int i = 8;
        if (z) {
            boolean z2 = false;
            boolean z3 = false;
            for (int i2 = 0; i2 <= 3; i2++) {
                if (z2) {
                    e(i2, false);
                } else if (this.m[i2]) {
                    z2 = true;
                    e(i2, true);
                    if (i2 == 1) {
                        z3 = true;
                    }
                } else {
                    e(i2, false);
                }
            }
            View view = this.j;
            if (view != null) {
                if (z2) {
                    i = 0;
                }
                view.setVisibility(i);
            }
            return z3;
        }
        View view2 = this.j;
        if (view2 == null) {
            return false;
        }
        view2.setVisibility(8);
        return false;
    }

    private boolean B(boolean z) {
        boolean z2;
        int i;
        int i2 = 0;
        if (z) {
            z2 = false;
            for (int i3 = 6; i3 <= 9; i3++) {
                if (z2) {
                    e(i3, false);
                } else if (this.m[i3]) {
                    e(i3, true);
                    z2 = true;
                } else {
                    e(i3, false);
                }
            }
        } else {
            if (this.l != null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(RGLaneInfoModel.TAG, "mFollowLaneContainer dismiss it");
                }
                z(false);
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().i(false);
            com.baidu.navisdk.ui.routeguide.control.x.b().K(false);
            com.baidu.navisdk.ui.routeguide.control.x.b().L(false);
            com.baidu.navisdk.ui.routeguide.control.x.b().N(false);
            z2 = false;
        }
        if (z2) {
            i = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_not_intervene_height);
        } else {
            i = 0;
        }
        if (1 == com.baidu.navisdk.ui.routeguide.control.x.b().d0()) {
            i2 = com.baidu.navisdk.module.newguide.a.e().c();
        }
        int i4 = i + i2;
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e(n, "RGCommonView.showCommonView()  carDiff  " + i4);
        }
        BNMapController.getInstance().setTranslucentHeight(i4);
        return z2;
    }

    private void d(int i, boolean z) {
        if (i < 0 || i >= 12) {
            return;
        }
        if (i != 1) {
            switch (i) {
                case 6:
                    if (z && com.baidu.navisdk.ui.routeguide.model.a0.C) {
                        this.m[i] = true;
                        return;
                    } else {
                        this.m[i] = false;
                        return;
                    }
                case 7:
                    if ((z || this.m[i]) && RGLaneInfoModel.getModel(false).isShowLaneLineView()) {
                        this.m[i] = true;
                        return;
                    } else {
                        this.m[i] = false;
                        return;
                    }
                case 8:
                    if (z && com.baidu.navisdk.ui.routeguide.model.a0.E) {
                        this.m[i] = true;
                        return;
                    } else {
                        this.m[i] = false;
                        return;
                    }
                case 9:
                    if (z && com.baidu.navisdk.ui.routeguide.model.a0.D) {
                        this.m[i] = true;
                        return;
                    } else {
                        this.m[i] = false;
                        return;
                    }
                default:
                    return;
            }
        }
        if (z && com.baidu.navisdk.module.pronavi.model.j.b().f7471a && com.baidu.navisdk.module.pronavi.model.j.b().a()) {
            this.m[i] = true;
        } else {
            this.m[i] = false;
        }
    }

    private void e(int i, boolean z) {
        if (i >= 0 && i < 12) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(n, "RGMMCommonView.showExpendViewInner() type=" + i + ", show=" + z + ", sOrientation=" + com.baidu.navisdk.module.pronavi.model.h.f7469a);
            }
            if (i != 1) {
                switch (i) {
                    case 6:
                        com.baidu.navisdk.ui.routeguide.control.x.b().K(z);
                        return;
                    case 7:
                        if (this.l != null) {
                            if (gVar.d()) {
                                gVar.e(RGLaneInfoModel.TAG, "source is " + this.i[7] + "," + z);
                            }
                            if (z) {
                                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().i(RGLaneInfoModel.getModel(false).isShowLaneLineView());
                            } else {
                                if (gVar.d()) {
                                    gVar.e(RGLaneInfoModel.TAG, "false hide source is " + this.i[7]);
                                }
                                int i2 = this.i[7];
                                if (i2 == 2) {
                                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().i(false);
                                } else if (i2 != 0 && i2 != 4) {
                                    if (gVar.d()) {
                                        gVar.e(RGLaneInfoModel.TAG, "anther source is " + this.i[7]);
                                    }
                                } else {
                                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().i(false);
                                }
                                this.i[7] = -1;
                            }
                            o0();
                            return;
                        }
                        return;
                    case 8:
                        com.baidu.navisdk.ui.routeguide.control.x.b().N(z);
                        return;
                    case 9:
                        com.baidu.navisdk.ui.routeguide.control.x.b().L(z);
                        return;
                    default:
                        return;
                }
            }
            if (z) {
                com.baidu.navisdk.ui.routeguide.control.x.b().e4();
            } else {
                com.baidu.navisdk.ui.routeguide.control.x.b().b1();
            }
        }
    }

    private void o0() {
        z(com.baidu.navisdk.ui.routeguide.mapmode.a.o5().S());
    }

    private void p0() {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            this.j = viewGroup.findViewById(R.id.bnav_extends_info_panel);
            this.l = this.b.findViewById(R.id.bnav_rg_consecutive_lane_ll);
        }
        for (int i = 0; i < 12; i++) {
            this.m[i] = false;
            this.i[i] = -1;
        }
    }

    private boolean v(int i) {
        if (i != 100) {
            if (i == 101) {
                boolean[] zArr = this.m;
                if (zArr[7] || zArr[6] || zArr[9] || zArr[8]) {
                    return true;
                }
            }
        } else {
            boolean[] zArr2 = this.m;
            if (zArr2[0] || zArr2[1]) {
                return true;
            }
        }
        return false;
    }

    private void z(boolean z) {
        int i;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(RGLaneInfoModel.TAG, "lane  handleFollowLaneShow : " + z + ", mFollowLaneContainer = " + this.l);
        }
        View view = this.l;
        if (view != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            if (gVar.d()) {
                gVar.e(RGLaneInfoModel.TAG, "lane  getLaneLineVisibility : " + com.baidu.navisdk.ui.routeguide.control.x.b().Z());
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        p0();
    }

    public void b(int i, boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(RGLaneInfoModel.TAG, "handleFollowLaneOrientation " + i + "," + z);
        }
        boolean z2 = z && com.baidu.navisdk.ui.routeguide.mapmode.a.o5().b2();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
        if (i == 2) {
            if (z2) {
                marginLayoutParams.leftMargin = com.baidu.navisdk.ui.routeguide.control.x.b().R() - com.baidu.navisdk.ui.routeguide.control.x.b().V();
                a(marginLayoutParams);
            } else {
                marginLayoutParams.leftMargin = 0;
                marginLayoutParams.topMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_hw_simple_board_margin_top);
                a(marginLayoutParams);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().g(z2);
            return;
        }
        if (z2) {
            marginLayoutParams.topMargin = (com.baidu.navisdk.pronavi.util.a.h.d() / 2) - ScreenUtil.getInstance().dip2px(138);
            a(marginLayoutParams);
        } else {
            if (!com.baidu.navisdk.ui.routeguide.utils.b.x()) {
                marginLayoutParams.topMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_hw_simple_board_margin_top);
            } else {
                marginLayoutParams.topMargin = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_guide_panel_shadow_bottom);
            }
            a(marginLayoutParams);
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().j(z2);
    }

    public boolean c(int i, boolean z) {
        if (i >= 0 && i < 12) {
            this.i[7] = 0;
            d(i, z);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(n, "RGMMCommonView.requestShowExpendView() type=" + i + ", show=" + z + ", actShow=" + this.m[i]);
            }
            if (!com.baidu.navisdk.ui.routeguide.control.x.b().b2() && RouteGuideParams.NavState.NAV_STATE_NAVING.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b()) && !com.baidu.navisdk.ui.routeguide.control.x.b().b2() && !A(true)) {
                B(true);
            }
            if (i == -1) {
                return true;
            }
        }
        return false;
    }

    public boolean n0() {
        View view = this.j;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void y(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(RGLaneInfoModel.TAG, "showCommonView tag are " + z);
        }
        if (z && com.baidu.navisdk.ui.routeguide.control.x.b().b2()) {
            return;
        }
        if (z && v(100)) {
            a(true, 100);
            a(this.k, 101);
        } else if (z && v(101)) {
            a(false, 100);
            a(true, 101);
        } else {
            a(false, 100);
            a(false, 101);
        }
    }

    private void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (this.l != null) {
            boolean[] zArr = this.m;
            if (!zArr[6] && zArr[7]) {
                z(true);
            }
            this.l.setLayoutParams(marginLayoutParams);
        }
    }

    private boolean a(boolean z, int i) {
        if (i == 100) {
            return A(z);
        }
        if (i != 101) {
            return false;
        }
        this.i[7] = 4;
        return B(z);
    }

    public boolean a(int i, boolean z, int i2) {
        boolean z2;
        if (i < 0 || i >= 12) {
            return false;
        }
        this.i[i] = i2;
        d(i, z);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(n, "RGMMCommonView.requestShowExpendView() type=" + i + ", show=" + z + ", actShow=" + this.m[i]);
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().b2()) {
            b(i, z, i2);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && RouteGuideParams.NavState.NAV_STATE_NAVING.equals(com.baidu.navisdk.ui.routeguide.model.g.h().b()) && !com.baidu.navisdk.ui.routeguide.control.x.b().b2() && !A(true)) {
            B(true);
        }
        return i == -1;
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        if (!z || this.j == null) {
            return null;
        }
        return com.baidu.navisdk.pronavi.hd.d.f7723a.b(this.j, JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_new_control_panel_bottom_margin));
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        View view;
        if (!z || (view = this.j) == null) {
            return null;
        }
        return com.baidu.navisdk.pronavi.hd.d.f7723a.b(view, fVar.a());
    }

    private void b(int i, boolean z, int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(RGLaneInfoModel.TAG, "handleEnlargeCanShowView " + i + "," + z + "," + i2);
        }
        if (i == 7 && i2 == 2) {
            if (gVar.d()) {
                gVar.e(RGLaneInfoModel.TAG, "handleEnlargeCanShowView visible " + this.l.getVisibility());
            }
            if (this.l != null) {
                z(true);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().i(z);
            }
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, com.baidu.navisdk.framework.interfaces.pronavi.hd.f fVar) {
        View view;
        if (!z || (view = this.j) == null) {
            return null;
        }
        return com.baidu.navisdk.pronavi.hd.d.f7723a.b(view, i2);
    }
}
