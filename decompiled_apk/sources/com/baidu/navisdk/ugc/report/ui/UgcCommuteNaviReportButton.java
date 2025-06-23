package com.baidu.navisdk.ugc.report.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.ugc.replenishdetails.e;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class UgcCommuteNaviReportButton extends UgcReportButton {
    private int h;
    private a.InterfaceC0201a i;

    /* loaded from: classes8.dex */
    public class a implements a.InterfaceC0201a {
        public a() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            g gVar = g.UGC;
            if (gVar.d() && obj != null) {
                gVar.e("UgcModule_UgcReport", "UgcCommuteNaviReportButton, onEvent: " + obj.toString());
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (eVar.b == 2) {
                    if (!eVar.f8239a && UgcCommuteNaviReportButton.this.h != eVar.e) {
                        return;
                    }
                    UgcCommuteNaviReportButton ugcCommuteNaviReportButton = UgcCommuteNaviReportButton.this;
                    int i = ugcCommuteNaviReportButton.d;
                    String str = "上报";
                    if (eVar.f8239a) {
                        ugcCommuteNaviReportButton.h = eVar.e;
                        int i2 = eVar.c;
                        if (i2 > 0) {
                            i = i2;
                        }
                        if (!TextUtils.isEmpty(eVar.d)) {
                            str = eVar.d;
                        }
                        if (eVar.e == 1) {
                            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.4", eVar.b + "", "6", null);
                        } else {
                            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.2", eVar.b + "", "3", null);
                        }
                    } else {
                        ugcCommuteNaviReportButton.h = 0;
                    }
                    UgcCommuteNaviReportButton.this.a(!eVar.f8239a, str, i);
                }
            }
        }
    }

    public UgcCommuteNaviReportButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 0;
        this.i = new a();
    }

    @Override // com.baidu.navisdk.ugc.report.ui.UgcReportButton
    public void b() {
        int i;
        ImageView imageView = this.f8266a;
        if (imageView != null && (i = this.e) > 0) {
            imageView.setImageDrawable(b(i));
        }
        setBackgroundDrawable(b(R.drawable.nsdk_rg_selector_common_control_btn_bg));
        TextView textView = this.b;
        if (textView == null || this.f <= 0) {
            return;
        }
        textView.setTextColor(a(this.g));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.navisdk.framework.message.a.a().a(this.i, e.class, new Class[0]);
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "UgcCommuteNaviReportButton onAttachedToWindow: " + getPageName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.navisdk.framework.message.a.a().a(this.i);
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "UgcCommuteNaviReportButton onDetachedFromWindow: " + getPageName());
        }
    }

    public UgcCommuteNaviReportButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 0;
        this.i = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelSize;
        this.e = i;
        TextView textView = this.b;
        if (textView != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            if (z) {
                this.b.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.ugc_rg_control_panel_btn_text_size));
            } else {
                this.b.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp));
            }
            if (layoutParams2 != null) {
                this.b.setLayoutParams(layoutParams2);
            }
        }
        ImageView imageView = this.f8266a;
        if (imageView != null && (layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams()) != null) {
            if (z) {
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_26dp);
                layoutParams.topMargin = ScreenUtil.getInstance().dip2px(-4);
            } else {
                dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_24dp);
                layoutParams.topMargin = ScreenUtil.getInstance().dip2px(-2);
            }
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            this.f8266a.setLayoutParams(layoutParams);
        }
        if (z) {
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setText(str);
            }
            ImageView imageView2 = this.f8266a;
            if (imageView2 != null) {
                imageView2.setImageDrawable(b(i));
                return;
            }
            return;
        }
        TextView textView3 = this.b;
        if (textView3 != null) {
            textView3.setText(str);
        }
        ImageView imageView3 = this.f8266a;
        if (imageView3 != null) {
            imageView3.setImageDrawable(b(i));
        }
    }

    private Drawable b(int i) {
        return JarUtils.getResources().getDrawable(i);
    }

    private int a(int i) {
        return JarUtils.getResources().getColor(i);
    }
}
