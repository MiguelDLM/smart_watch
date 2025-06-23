package com.baidu.navisdk.ui.routeguide.mapmode.subview.highway;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class f extends b {
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private int k;

    public f(View view, int i, Context context, int i2) {
        super(context, i);
        this.e = view;
        this.k = i2;
        l();
    }

    private int k() {
        boolean c;
        if (!i() && com.baidu.navisdk.module.newguide.a.e().d()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_land_left_panel_width_new) - (JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_left) * 2);
        }
        if (i()) {
            c = false;
        } else {
            c = com.baidu.navisdk.ui.routeguide.utils.b.c(com.baidu.navisdk.ui.routeguide.utils.b.o().f6817a);
        }
        return j.C(c);
    }

    private void l() {
        int color;
        this.f = (TextView) this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_exit_or_enter);
        this.g = (TextView) this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_exit_code);
        this.h = (TextView) this.f8768a.findViewById(R.id.bnavi_hw_exit_panel_name);
        this.i = (TextView) this.f8768a.findViewById(R.id.bnavi_hw_exit_panel_direction_label);
        this.j = this.f8768a.findViewById(R.id.bnavi_rg_hw_service_panel_subscript_icon);
        if (this.k == 0) {
            color = JarUtils.getResources().getColor(R.color.nsdk_rg_hw_service_exit_code_top);
        } else {
            color = JarUtils.getResources().getColor(R.color.nsdk_rg_hw_service_exit_code_bottom);
        }
        this.f.setTextColor(color);
        this.g.setTextColor(color);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void a(View view) {
    }

    public void b(String str) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int c() {
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_single_type_service_area_panel_height);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public String d() {
        return "BNServiceAreaExitView";
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int f() {
        return R.layout.nsdk_layout_hw_service_exit_view;
    }

    public ViewGroup.LayoutParams j() {
        return null;
    }

    private void c(boolean z) {
        TextView textView = this.i;
        if (textView != null) {
            String str = z ? " 方向" : "方向";
            if (str.equals(textView.getText().toString())) {
                return;
            }
            this.i.setText(str);
        }
    }

    public void a(String str) {
        if (this.g != null) {
            if (!l0.c(str)) {
                this.g.setText(str);
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void d(com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (dVar == null) {
            this.b = null;
            return;
        }
        if (a(dVar)) {
            if (dVar.p() == 2) {
                b("入口");
            } else if (dVar.p() == 3 || dVar.p() == 5) {
                b("出口");
            }
            boolean z = LogUtil.LOGGABLE;
            a(dVar.h(), b(dVar.s()));
            a(dVar.d());
        }
        if (this.k == 0) {
            if (a(dVar.s())) {
                a(dVar.h(), b(dVar.s()));
            }
        } else {
            a(false);
        }
        this.b = dVar;
    }

    private int b(boolean z) {
        View view;
        if (this.h == null || (view = this.e) == null || this.i == null) {
            return 0;
        }
        int k = (k() - (view.getPaddingLeft() + this.e.getPaddingRight())) - com.baidu.navisdk.ui.util.j.a(this.i, " 方向");
        if (z) {
            k -= JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_hw_service_area_subscript_icon_size) + JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_hw_service_area_subscript_icon_margin_right);
        }
        if (this.h.getMaxWidth() == k) {
            return k;
        }
        this.h.setMaxWidth(k);
        return k;
    }

    public void a(String str, int i) {
        TextView textView = this.h;
        if (textView != null) {
            c(com.baidu.navisdk.ui.util.j.a(textView, str) <= i);
            this.h.setText(str);
        }
    }

    public boolean a(boolean z) {
        int i = z ? 0 : 8;
        View view = this.j;
        if (view == null || view.getVisibility() == i) {
            return false;
        }
        this.j.setVisibility(i);
        return true;
    }
}
