package com.baidu.navisdk.ugc.report.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.ugc.replenishdetails.e;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class UgcLightReportButton extends UgcReportButton {
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
                gVar.e("UgcModule_UgcReport", "onEvent: " + obj.toString());
            }
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (eVar.b == 3) {
                    if (!eVar.f8239a && UgcLightReportButton.this.h != eVar.e) {
                        return;
                    }
                    UgcLightReportButton ugcLightReportButton = UgcLightReportButton.this;
                    int i = ugcLightReportButton.d;
                    String str = "上报";
                    if (eVar.f8239a) {
                        ugcLightReportButton.h = eVar.e;
                        if (!TextUtils.isEmpty(eVar.d)) {
                            str = eVar.d;
                        }
                        int i2 = eVar.c;
                        if (i2 > 0) {
                            i = i2;
                        }
                        if (eVar.e == 1) {
                            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.4", eVar.b + "", "6", null);
                        } else {
                            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.2", eVar.b + "", "3", null);
                        }
                    } else {
                        ugcLightReportButton.h = 0;
                    }
                    UgcLightReportButton.this.a(!eVar.f8239a, str, i);
                }
            }
        }
    }

    public UgcLightReportButton(Context context) {
        super(context);
        this.h = 0;
        this.i = new a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.navisdk.framework.message.a.a().a(this.i, e.class, new Class[0]);
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_UgcReport", "UgcLightReportButton onAttachedToWindow: " + getPageName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.navisdk.framework.message.a.a().a(this.i);
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "UgcLightReportButton onDetachedFromWindow: " + getPageName());
        }
    }

    public UgcLightReportButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 0;
        this.i = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, int i) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        this.e = i;
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
            TextView textView2 = this.b;
            if (z) {
                dimensionPixelSize2 = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_13dp);
            } else {
                dimensionPixelSize2 = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
            }
            textView2.setTextSize(0, dimensionPixelSize2);
        }
        ImageView imageView = this.f8266a;
        if (imageView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            if (layoutParams != null) {
                if (z) {
                    dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_20dp);
                } else {
                    dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_24dp);
                }
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.f8266a.setLayoutParams(layoutParams);
            }
            this.f8266a.setImageResource(i);
        }
    }

    public UgcLightReportButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 0;
        this.i = new a();
    }
}
