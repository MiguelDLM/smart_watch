package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.subview.widget.RGTruckAvoidanceBGView;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

/* loaded from: classes8.dex */
public class n1 extends com.baidu.navisdk.ui.routeguide.widget.d {
    private View i;
    private RGTruckAvoidanceBGView j;
    private TextView k;

    public n1(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        n0();
    }

    private void n0() {
        if (this.b != null) {
            if (this.i == null) {
                View inflate = JarUtils.inflate(this.f9165a, R.layout.bnav_truck_avoidance_reminder_layout, null);
                this.i = inflate;
                this.j = (RGTruckAvoidanceBGView) inflate.findViewById(R.id.circle_background_panel);
                this.k = (TextView) this.i.findViewById(R.id.aboidance_reminder_info);
                this.j.setArcStrockeColor(JarUtils.getResources().getColor(R.color.nsdk_rg_truck_aboidance_info_bg_color));
                this.j.setArcStrokeWidth(JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_3dp));
                this.j.setCircleColor(-1);
                this.j.setTextSize(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_16dp));
                this.j.setTextColor(JarUtils.getResources().getColor(R.color.nsdk_interval_speed_default_text_color));
            }
            View view = this.i;
            if (view != null && view.getParent() != null) {
                ((ViewGroup) this.i.getParent()).removeView(this.i);
            }
            this.b.addView(this.i, new ViewGroup.LayoutParams(JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_cur_car_speed_anim_panel_size), JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_truck_avoidance_panel_height)));
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        n0();
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void d(int i, int i2) {
        String str;
        RGTruckAvoidanceBGView rGTruckAvoidanceBGView;
        StringBuilder sb = new StringBuilder();
        com.baidu.navisdk.util.common.l0.a(i2, l0.a.EN, sb);
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        str = "";
                    } else {
                        str = "限重";
                    }
                } else {
                    str = "限宽";
                }
            } else {
                str = "限高";
            }
        } else {
            sb.append("处");
            str = "禁行";
        }
        if (!com.baidu.navisdk.util.common.l0.c(str) && this.k != null && (rGTruckAvoidanceBGView = this.j) != null) {
            rGTruckAvoidanceBGView.setText(str);
            if (i2 <= 0) {
                sb.setLength(0);
                sb.append(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
            }
            this.k.setText(sb.toString());
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        super.y();
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            return true;
        }
        return true;
    }
}
