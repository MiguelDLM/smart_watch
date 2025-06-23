package com.baidu.navisdk.pronavi.ui.bucket.item.concrete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;

/* loaded from: classes7.dex */
public class x extends com.baidu.navisdk.pronavi.ui.bucket.item.c {
    private boolean k;
    private boolean l;

    public x(com.baidu.navisdk.pronavi.ui.base.b bVar, com.baidu.navisdk.pronavi.ui.bucket.config.d dVar) {
        super(bVar, dVar, R.drawable.nsdk_drawable_common_ic_weather, "天气");
        this.k = false;
        this.l = false;
    }

    private void y() {
        int i;
        int i2;
        boolean j = com.baidu.navisdk.ui.routeguide.model.t.s().j();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("WeatherBtn", "updateWeatherState need: " + j + ", last:" + this.l);
        }
        if (this.l == j) {
            return;
        }
        this.l = j;
        RGImageTextBtn v = v();
        if (v != null) {
            if (j) {
                i = R.drawable.nsdk_drawable_common_ic_weather_selected;
            } else {
                i = R.drawable.nsdk_drawable_common_ic_weather;
            }
            v.setIcon(i);
            if (j) {
                i2 = R.color.nsdk_cl_text_g;
            } else {
                i2 = R.color.nsdk_cl_text_h;
            }
            v.setTextColor(i2);
        }
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.c
    public void a(View view) {
        super.a(view);
        if (com.baidu.navisdk.ui.routeguide.model.t.s().j()) {
            com.baidu.navisdk.ui.routeguide.model.t.s().f();
        } else {
            com.baidu.navisdk.ui.routeguide.model.t.s().a(this.f7853a.a());
        }
        y();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.e.2", null, null, null);
    }

    public void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("WeatherBtn", "updateByDataChangehasWeatherData: " + z + ", " + this.k);
        }
        if (this.k == z) {
            return;
        }
        this.k = z;
        refreshVisible();
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public int c(int i) {
        if (!com.baidu.navisdk.function.b.FUNC_WEATHER.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("WeatherBtn", "visibility: not enable");
            }
            return 8;
        }
        if (!com.baidu.navisdk.ui.routeguide.model.t.s().l()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("WeatherBtn", "visibility: not open");
            }
            return 8;
        }
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e("WeatherBtn", "visibility: " + this.k);
        }
        if (!this.k) {
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().O2()) {
            if (gVar3.d()) {
                gVar3.e("WeatherBtn", "visibility: isVdrGuide");
            }
            return 8;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            if (gVar3.d()) {
                gVar3.e("WeatherBtn", "visibility: isYawing");
            }
            return 8;
        }
        if (!b(RGFSMTable.FsmState.SimpleGuide) || !a(RGFSMTable.FsmState.Fullview)) {
            return 8;
        }
        if (gVar3.d()) {
            gVar3.e("WeatherBtn", "visibility visible:" + this.f7853a.n());
            return 0;
        }
        return 0;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a
    public boolean g() {
        return true;
    }

    @Override // com.baidu.navisdk.pronavi.ui.bucket.item.a, com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void loadBucketItem(ViewGroup viewGroup, int i, Context context) {
        super.loadBucketItem(viewGroup, i, context);
        y();
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onVisibleChange(int i) {
        super.onVisibleChange(i);
        if (i == 0) {
            y();
        }
    }
}
