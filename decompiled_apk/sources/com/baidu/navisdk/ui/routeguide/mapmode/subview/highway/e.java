package com.baidu.navisdk.ui.routeguide.mapmode.subview.highway;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class e extends b {
    private TextView e;
    private TextView f;
    private TextView g;
    private View h;
    private TextView i;

    public e(Context context, int i) {
        super(context, i);
    }

    private void e(com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.model.datastruct.chargestation.b bVar;
        int b;
        int b2;
        int c;
        TextView textView;
        String str;
        com.baidu.navisdk.module.pronavi.model.d dVar2 = this.b;
        com.baidu.navisdk.model.datastruct.chargestation.b bVar2 = null;
        if (dVar2 != null) {
            bVar = (com.baidu.navisdk.model.datastruct.chargestation.b) dVar2.a("charge_station_info", null);
        } else {
            bVar = null;
        }
        if (dVar != null) {
            bVar2 = (com.baidu.navisdk.model.datastruct.chargestation.b) dVar.a("charge_station_info", null);
        }
        if (bVar == null) {
            b = 0;
        } else {
            b = bVar.d().b() + bVar.d().f();
        }
        if (bVar2 == null) {
            b2 = 0;
        } else {
            b2 = bVar2.d().b() + bVar2.d().f();
        }
        if (bVar2 == null) {
            c = 0;
        } else {
            c = bVar2.d().c() + bVar2.d().g();
        }
        if ((b != b2 || bVar == null) && (textView = this.i) != null) {
            textView.setVisibility(0);
            if (b2 <= 0) {
                str = "充电桩 共" + c + "个";
            } else {
                str = "充电桩 空" + b2 + "个";
            }
            this.i.setText(str);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void a(View view) {
        this.e = (TextView) this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_name);
        this.f = (TextView) this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_top_remain_dist);
        this.g = (TextView) this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_top_unit);
        this.h = this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_subscript_icon);
        this.i = (TextView) this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_change_station_count);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int c() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_116dp);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public String d() {
        return "BNServiceAreaChargeView";
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int f() {
        if (h()) {
            return R.layout.nsdk_layout_hw_service_charge_view;
        }
        return R.layout.nsdk_layout_hw_service_charge_land_view;
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
        if (this.f != null && this.g != null) {
            f(dVar);
            a(dVar.m(), dVar.l());
            e(dVar);
            a(dVar.s());
            this.b = dVar;
            return;
        }
        LogUtil.e("BNServiceAreaChargeView", "pullAllServiceAreaDatas-> view为null！return");
    }

    private void f(com.baidu.navisdk.module.pronavi.model.d dVar) {
        com.baidu.navisdk.module.pronavi.model.d dVar2 = this.b;
        com.baidu.navisdk.model.datastruct.chargestation.b bVar = dVar2 != null ? (com.baidu.navisdk.model.datastruct.chargestation.b) dVar2.a("charge_station_info", null) : null;
        com.baidu.navisdk.model.datastruct.chargestation.b bVar2 = dVar != null ? (com.baidu.navisdk.model.datastruct.chargestation.b) dVar.a("charge_station_info", null) : null;
        String e = bVar == null ? "" : bVar.d().e();
        String e2 = bVar2 == null ? "" : bVar2.d().e();
        String j = bVar == null ? "" : bVar.j();
        String j2 = bVar2 != null ? bVar2.j() : "";
        if (!TextUtils.isEmpty(e)) {
            j = e + " · " + j;
        }
        if (!TextUtils.isEmpty(e2)) {
            j2 = e2 + " · " + j2;
        }
        if (bVar == null || !TextUtils.equals(j, j2)) {
            this.e.setText(j2);
        }
    }

    private void a(String str, String str2) {
        this.f.setText(str);
        this.g.setText(str2);
    }

    private void a(boolean z) {
        View view = this.h;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
