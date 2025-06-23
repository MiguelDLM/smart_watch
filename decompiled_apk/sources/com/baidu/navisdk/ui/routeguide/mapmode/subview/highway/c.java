package com.baidu.navisdk.ui.routeguide.mapmode.subview.highway;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class c extends b {
    private View e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private TextView k;
    private TextView l;
    private TextView m;

    public c(Context context, int i) {
        super(context, i);
    }

    private void e(com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (dVar.p() == 1) {
            int i = R.drawable.nsdk_drawable_rg_hw_service_toll_station;
            this.j.setVisibility(8);
            this.e.setVisibility(0);
            this.f.setImageDrawable(JarUtils.getResources().getDrawable(i));
            return;
        }
        if (dVar.o().size() <= 1) {
            this.j.setVisibility(8);
            this.e.setVisibility(0);
            this.f.setImageDrawable(JarUtils.getResources().getDrawable(c(dVar)));
            return;
        }
        this.e.setVisibility(8);
        this.j.setVisibility(0);
        b(dVar);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void a(View view) {
        this.e = view.findViewById(R.id.bnavi_hw_service_panel_bottom_single_type_panel);
        this.j = view.findViewById(R.id.bnavi_hw_service_bottom_normal_panel);
        this.f = (ImageView) view.findViewById(R.id.bnavi_hw_service_single_type_panel_icon);
        this.g = (TextView) view.findViewById(R.id.bnavi_hw_service_bottom_single_type_panel_remain_dist);
        this.h = (TextView) view.findViewById(R.id.bnavi_rg_hw_service_bottom_gate_panel_unit);
        this.i = (TextView) view.findViewById(R.id.bnavi_hw_service_panel_exit_name);
        this.k = (TextView) view.findViewById(R.id.bnavi_rg_hw_service_bottom_normal_panel_remain_dist);
        this.l = (TextView) view.findViewById(R.id.bnavi_rg_hw_service_bottom_normal_panel_top_unit);
        this.m = (TextView) view.findViewById(R.id.bnavi_rg_hw_service_panel_top_name);
        g();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int c() {
        View view = this.e;
        if (view != null && view.getVisibility() == 0) {
            return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_bottom_single_type_service_area_panel_height);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_single_type_service_area_panel_height);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public String d() {
        return "BNServiceAreaBottomView";
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int f() {
        if (h()) {
            return R.layout.nsdk_layout_hw_service_bottom_view;
        }
        return R.layout.nsdk_layout_hw_service_bottom_land_new_view;
    }

    public ViewGroup.LayoutParams j() {
        if (!h()) {
            return new ViewGroup.LayoutParams(-1, JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_land_hw_service_height));
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void d(com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (a(dVar)) {
            e(dVar);
            a(dVar.h());
        }
        a(dVar.m(), dVar.l());
        this.b = dVar;
    }

    private void a(String str, String str2) {
        if (this.j.getVisibility() == 0) {
            this.k.setText(str);
            this.l.setText(str2);
        } else {
            this.g.setText(str);
            this.h.setText(str2);
        }
    }

    private void a(String str) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNServiceAreaBottomView", "updateName: " + str);
        }
        if (this.j.getVisibility() == 0) {
            TextView textView = this.m;
            if (textView != null) {
                textView.setText(str);
                return;
            }
            return;
        }
        TextView textView2 = this.i;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }
}
