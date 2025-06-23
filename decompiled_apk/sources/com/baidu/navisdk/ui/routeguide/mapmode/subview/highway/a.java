package com.baidu.navisdk.ui.routeguide.mapmode.subview.highway;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a extends b {
    private TextView e;
    private TextView f;
    private int g;
    private int h;
    private int i;
    private int j;

    public a(Context context, int i, int i2) {
        super(context, i2);
        this.g = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_service_area_panel_content_height);
        this.h = JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_direction_panel_single_content_height);
        this.i = this.g;
        this.j = i;
    }

    private int k() {
        if (!i() && com.baidu.navisdk.module.newguide.a.e().d()) {
            return (JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_land_left_panel_width_new) - (JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_left) * 2)) - JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_16dp);
        }
        return JarUtils.getResources().getDimensionPixelOffset(R.dimen.nsdk_rg_service_area_panel_content_width);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void a(View view) {
        int color;
        this.e = (TextView) view.findViewById(R.id.bnavi_rg_direction_name);
        this.f = (TextView) view.findViewById(R.id.bnavi_rg_direction_code);
        if (this.j == 0) {
            color = JarUtils.getResources().getColor(R.color.nsdk_rg_hw_service_exit_code_top);
        } else {
            color = JarUtils.getResources().getColor(R.color.nsdk_rg_hw_service_exit_code_bottom);
        }
        this.f.setTextColor(color);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int c() {
        return this.i + JarUtils.getResources().getDimensionPixelOffset(R.dimen.navi_dimens_10dp);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public String d() {
        return "BNDirectionBoardView";
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public int f() {
        return R.layout.nsdk_layout_direction_area_view;
    }

    public ViewGroup.LayoutParams j() {
        return null;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.highway.b
    public void d(com.baidu.navisdk.module.pronavi.model.d dVar) {
        if (dVar == null) {
            this.b = null;
            return;
        }
        if (this.e == null || this.f == null) {
            return;
        }
        if (a(dVar)) {
            int k = k();
            int i = 2;
            if (this.f != null) {
                if (!l0.c(dVar.d())) {
                    this.f.setVisibility(0);
                    this.f.setText("出口 " + dVar.d());
                    i = 1;
                } else {
                    this.f.setVisibility(8);
                }
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setMaxLines(i);
                this.e.setText(a(a(i, k, dVar.h())));
                ViewGroup.LayoutParams layoutParams = e().getLayoutParams();
                layoutParams.height = this.i;
                e().setLayoutParams(layoutParams);
            }
        }
        this.b = dVar;
    }

    private SpannableString a(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(JarUtils.getResources().getColor(R.color.nsdk_rg_service_area_panel_direction_label_color)), str.lastIndexOf("方向"), str.length(), 33);
        return spannableString;
    }

    private String a(int i, int i2, String str) {
        String str2;
        if (this.e == null) {
            return str;
        }
        if (str.contains("..")) {
            str2 = str + "方向";
        } else {
            str2 = str + " 方向";
        }
        if (i == 1) {
            if (com.baidu.navisdk.ui.util.j.a(this.e, str2) > i2) {
                int length = str.length();
                if (str.contains("..")) {
                    length = str.lastIndexOf("..");
                }
                return a(i, i2, str.substring(0, length - 1) + "..");
            }
            this.i = this.g;
        } else if (com.baidu.navisdk.ui.util.j.a(this.e, i2, str2, 2)) {
            if (!com.baidu.navisdk.ui.util.j.a(this.e, i2, str2, 1)) {
                if (com.baidu.navisdk.ui.util.j.a(this.e, i2, str, 1)) {
                    str = str + "\n";
                }
                this.i = this.g;
            } else {
                this.i = this.h;
            }
        } else {
            int length2 = str.length();
            if (str.contains("..")) {
                length2 = str.lastIndexOf("..");
            }
            return a(i, i2, str.substring(0, length2 - 1) + "..");
        }
        if (!str.contains("\n") && !str.contains("..")) {
            return str + " 方向";
        }
        return str + "方向";
    }
}
