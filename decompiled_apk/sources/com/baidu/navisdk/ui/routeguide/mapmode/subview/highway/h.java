package com.baidu.navisdk.ui.routeguide.mapmode.subview.highway;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class h extends b {
    private ImageView e;
    private TextView f;
    private TextView g;
    private View h;
    private TextView i;

    public h(Context context, int i) {
        super(context, i);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void a(View view) {
        this.e = (ImageView) this.f8768a.findViewById(R.id.bnavi_hw_service_panel_top_icon);
        this.f = (TextView) this.f8768a.findViewById(R.id.bnavi_hw_service_panel_top_remain_dist);
        this.g = (TextView) this.f8768a.findViewById(R.id.bnavi_hw_service_panel_exit_name);
        this.h = this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_subscript_icon);
        this.i = (TextView) this.f8768a.findViewById(R.id.bnavi_hw_service_panel_top_unit);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int c() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_single_type_service_area_panel_height);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public String d() {
        return "BNServiceAreaSingleTypeView";
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int f() {
        if (h()) {
            return R.layout.nsdk_layout_hw_service_single_type_view;
        }
        return R.layout.nsdk_layout_hw_service_single_type_land_new_view;
    }

    public ViewGroup.LayoutParams j() {
        if (!h()) {
            return new ViewGroup.LayoutParams(-1, JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_land_hw_service_height));
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void d(com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.e != null && this.f != null && this.g != null && this.i != null) {
            if (a(dVar)) {
                this.g.setText(dVar.h());
                this.e.setImageResource(c(dVar));
            }
            View view = this.h;
            if (view != null) {
                view.setVisibility(dVar.s() ? 0 : 8);
            }
            this.f.setText(dVar.m());
            this.i.setText(dVar.l());
            this.b = dVar;
            return;
        }
        LogUtil.e("BNServiceAreaSingleTypeView", "pullAllServiceAreaDatas-> mServiceIconView == null || mDistView == null || mServiceNameView == null");
    }
}
