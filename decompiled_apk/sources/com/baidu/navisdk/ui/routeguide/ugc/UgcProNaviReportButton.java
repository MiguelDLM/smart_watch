package com.baidu.navisdk.ui.routeguide.ugc;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.ugc.report.ui.UgcReportButton;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class UgcProNaviReportButton extends UgcReportButton {
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private a.InterfaceC0201a l;

    /* loaded from: classes8.dex */
    public class a implements com.baidu.navisdk.widget.naviimageloader.e {
        public a() {
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.e
        public void a(String str, View view) {
            UgcProNaviReportButton.this.i = true;
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.e
        public void a(String str, View view, Bitmap bitmap, int i) {
            UgcProNaviReportButton.this.h = true;
            UgcProNaviReportButton.this.i = false;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0201a {
        public b() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            g gVar = g.UGC;
            if (gVar.d() && obj != null) {
                gVar.e("UgcModule_UgcReport", "onEvent: " + obj.toString());
            }
            if (obj instanceof com.baidu.navisdk.ugc.replenishdetails.e) {
                com.baidu.navisdk.ugc.replenishdetails.e eVar = (com.baidu.navisdk.ugc.replenishdetails.e) obj;
                if (eVar.b == 2) {
                    if (eVar.f8239a || UgcProNaviReportButton.this.k == eVar.e) {
                        int i = ((UgcReportButton) UgcProNaviReportButton.this).d;
                        String str = "上报";
                        if (!eVar.f8239a) {
                            UgcProNaviReportButton.this.k = 0;
                        } else {
                            UgcProNaviReportButton.this.k = eVar.e;
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
                        }
                        UgcProNaviReportButton.this.a(!eVar.f8239a, str, i);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements com.baidu.navisdk.widget.naviimageloader.e {
        public c() {
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.e
        public void a(String str, View view) {
            UgcProNaviReportButton.this.i = true;
        }

        @Override // com.baidu.navisdk.widget.naviimageloader.e
        public void a(String str, View view, Bitmap bitmap, int i) {
            UgcProNaviReportButton.this.h = true;
            UgcProNaviReportButton.this.i = false;
        }
    }

    public UgcProNaviReportButton(Context context) {
        super(context);
        this.h = false;
        this.i = false;
        this.j = true;
        this.k = 0;
        this.l = new b();
    }

    private int c(boolean z) {
        if (com.baidu.navisdk.module.newguide.a.e().d() && x.b().s2()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_text_size_new);
        }
        if (z) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_text_size);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.navisdk.framework.message.a.a().a(this.l, com.baidu.navisdk.ugc.replenishdetails.e.class, new Class[0]);
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "UgcProNaviReportButton onAttachedToWindow: " + getPageName());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.navisdk.framework.message.a.a().a(this.l);
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "UgcProNaviReportButton onDetachedFromWindow: " + getPageName());
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.UgcReportButton
    public void b() {
        ImageView imageView;
        super.b();
        int i = this.e;
        if (i <= 0 || (imageView = this.f8266a) == null) {
            return;
        }
        imageView.setImageDrawable(com.baidu.navisdk.ui.util.b.f(i));
    }

    @Override // com.baidu.navisdk.ugc.report.ui.UgcReportButton
    public void a() {
        if (this.f8266a == null || this.h || !this.j) {
            return;
        }
        if (TextUtils.isEmpty(com.baidu.navisdk.ugc.report.data.datarepository.c.e(4102))) {
            this.h = true;
        } else {
            if (this.i) {
                return;
            }
            com.baidu.navisdk.ugc.utils.d.a(4102, this.f8266a, new a());
        }
    }

    public UgcProNaviReportButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = false;
        this.i = false;
        this.j = true;
        this.k = 0;
        this.l = new b();
    }

    private int b(boolean z) {
        if (com.baidu.navisdk.module.newguide.a.e().d() && x.b().s2()) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_btn_img_width);
        }
        if (z) {
            return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_26dp);
        }
        return JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_24dp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, int i) {
        LinearLayout.LayoutParams layoutParams;
        this.e = i;
        this.j = z;
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextSize(0, c(z));
        }
        ImageView imageView = this.f8266a;
        if (imageView != null && (layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams()) != null) {
            int b2 = b(z);
            layoutParams.width = b2;
            layoutParams.height = b2;
            layoutParams.topMargin = a(z);
            this.f8266a.setLayoutParams(layoutParams);
        }
        if (z) {
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setText(str);
            }
            if (this.f8266a != null) {
                if (TextUtils.isEmpty(com.baidu.navisdk.ugc.report.data.datarepository.c.e(4102))) {
                    this.f8266a.setImageDrawable(com.baidu.navisdk.ui.util.b.f(i));
                    return;
                } else {
                    com.baidu.navisdk.ugc.utils.d.a(4102, this.f8266a, new c());
                    return;
                }
            }
            return;
        }
        TextView textView3 = this.b;
        if (textView3 != null) {
            textView3.setText(str);
        }
        ImageView imageView2 = this.f8266a;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.baidu.navisdk.ui.util.b.f(i));
        }
    }

    public UgcProNaviReportButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = false;
        this.i = false;
        this.j = true;
        this.k = 0;
        this.l = new b();
    }

    private int a(boolean z) {
        if (com.baidu.navisdk.module.newguide.a.e().d() && x.b().s2()) {
            return 0;
        }
        if (z) {
            return ScreenUtil.getInstance().dip2px(-4);
        }
        return ScreenUtil.getInstance().dip2px(-2);
    }
}
