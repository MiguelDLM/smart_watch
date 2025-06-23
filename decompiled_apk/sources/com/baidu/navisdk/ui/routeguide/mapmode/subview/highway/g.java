package com.baidu.navisdk.ui.routeguide.mapmode.subview.highway;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class g extends b {
    private TextView e;
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private TextView j;
    private boolean k;

    public g(Context context, int i) {
        super(context, i);
    }

    private void b(boolean z) {
        int i;
        View view = this.h;
        if (view != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    private void e(com.baidu.navisdk.module.pronavi.model.d dVar) {
        int i;
        if (dVar.r()) {
            com.baidu.navisdk.module.pronavi.model.a aVar = (com.baidu.navisdk.module.pronavi.model.a) dVar.a("parking_lot_info");
            if (aVar != null && aVar.a() > 0) {
                int a2 = aVar.a();
                TextView textView = this.j;
                if (textView != null) {
                    textView.setText(String.valueOf(a2));
                }
                if (this.i != null) {
                    a(true);
                    if (this.i.getVisibility() == 8) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.3.4", "1", null, null);
                    }
                    this.i.setVisibility(0);
                }
            } else if (this.i != null) {
                a(false);
                this.i.setVisibility(8);
            }
        } else if (this.i != null) {
            a(false);
            this.i.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams = e().getLayoutParams();
        if (j() != null && layoutParams != null) {
            Resources resources = JarUtils.getResources();
            if (this.k) {
                i = R.dimen.navi_dimens_77dp;
            } else {
                i = R.dimen.nsdk_rg_land_hw_service_height;
            }
            layoutParams.height = resources.getDimensionPixelSize(i);
            e().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void a(View view) {
        g();
        this.e = (TextView) this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_top_name);
        this.f = (TextView) this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_top_remain_dist);
        this.g = (TextView) this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_top_unit);
        this.h = this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_subscript_icon);
        this.i = this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_empty_parking_place_container);
        this.j = (TextView) this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_empty_parking_place_count);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int c() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_normal_service_area_panel_height);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public String d() {
        return "BNServiceAreaNormalView";
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int f() {
        if (h()) {
            return R.layout.nsdk_layout_hw_service_normal_view;
        }
        return R.layout.nsdk_layout_hw_service_normal_land_new_view;
    }

    public ViewGroup.LayoutParams j() {
        int i;
        if (!h()) {
            Resources resources = JarUtils.getResources();
            if (this.k) {
                i = R.dimen.navi_dimens_77dp;
            } else {
                i = R.dimen.nsdk_rg_land_hw_service_height;
            }
            return new ViewGroup.LayoutParams(-1, resources.getDimensionPixelSize(i));
        }
        return null;
    }

    public boolean k() {
        boolean z;
        if (com.baidu.navisdk.module.vehiclemanager.b.i().f() && com.baidu.navisdk.module.vehiclemanager.b.i().a() == 0) {
            z = true;
        } else {
            z = false;
        }
        boolean a2 = com.baidu.navisdk.function.b.FUNC_SERVICE_AREA_EMPTY_PARKING_SPACE_INFO.a();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNServiceAreaNormalView", "isShowEmptyParkingSpaceInfoScene--> isCar-->" + z + ", FUNC_SERVICE_AREA_EMPTY_PARKING_SPACE_INFO is -->" + a2);
        }
        if (!z || !a2) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void d(com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.e != null && this.f != null && this.g != null) {
            if (a(dVar)) {
                a(dVar.h());
                b(dVar);
            }
            a(dVar.m(), dVar.l());
            b(dVar.s());
            if (k()) {
                e(dVar);
            }
            this.b = dVar;
            return;
        }
        LogUtil.e("BNServiceAreaNormalView", "pullAllServiceAreaDatas-> view为null！return");
    }

    private void a(String str) {
        this.e.setText(str);
    }

    private void a(String str, String str2) {
        this.f.setText(str);
        this.g.setText(str2);
    }

    public void a(boolean z) {
        this.k = z;
    }
}
