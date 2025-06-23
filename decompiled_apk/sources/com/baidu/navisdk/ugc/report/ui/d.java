package com.baidu.navisdk.ugc.report.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.baidu.navisdk.ugc.report.ui.widget.UgcCustomLinearScrollView;
import com.baidu.navisdk.ugc.report.ui.widget.UgcReportLayout;
import com.baidu.navisdk.ugc.utils.h;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public abstract class d implements com.baidu.navisdk.ugc.report.ui.b {
    protected boolean c;
    private c e;
    private UgcReportLayout h;
    private UgcCustomLinearScrollView i;

    /* renamed from: a, reason: collision with root package name */
    protected View f8270a = null;
    protected Context b = null;
    private com.baidu.navisdk.ugc.report.ui.a d = null;
    private ImageView f = null;
    private TextView g = null;
    private int j = 1;
    private Button k = null;
    private Button l = null;
    private ViewTreeObserver.OnGlobalLayoutListener m = null;
    private int n = 0;

    /* loaded from: classes8.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            if (d.this.h == null) {
                return;
            }
            if (d.this.j == 1 && h.c.c()) {
                i = ScreenUtil.getInstance().getWidthPixels();
            } else {
                i = 0;
            }
            if (i <= 0) {
                i = d.this.h.getWidth();
            }
            if (i != 0 && i != d.this.n) {
                d.this.n = i;
                d.this.h.setLayoutWidth(d.this.n);
                d.this.h.b();
            }
            if (d.this.h.getHeight() > 0) {
                d.this.i();
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(int i, int i2);

        void a(e.b bVar);

        void a(String str);

        void a(String str, int i);

        void a(String str, String str2);

        void b(String str);

        void b(String str, String str2);

        void c(String str, String str2);
    }

    public d(Context context, int i, boolean z) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("SubContentView", "SubContentView: " + z + ", orientation:" + i);
        }
        a(context, i, z);
        m();
    }

    private void j() {
        com.baidu.navisdk.ugc.report.ui.widget.a eVar;
        this.h.a();
        if (this.d.l() != null && this.d.l().size() != 0 && !n()) {
            this.h.a(new com.baidu.navisdk.ugc.report.ui.widget.d(this.b, this.d, 2000, this.e, this.n, this.j), 0);
        }
        if (this.d.f() != null && this.d.f().size() != 0) {
            this.h.a(new com.baidu.navisdk.ugc.report.ui.widget.d(this.b, this.d, 2001, this.e, this.n, this.j), 1);
        }
        if (this.d.g() != null && this.d.g().size() != 0) {
            this.h.a(new com.baidu.navisdk.ugc.report.ui.widget.d(this.b, this.d, 2002, this.e, this.n, this.j), 2);
        }
        int p = this.d.p();
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("SubContentView", "addNewCard parentType:" + p);
        }
        if (com.baidu.navisdk.module.ugc.a.b(p)) {
            Activity b2 = this.d.b();
            com.baidu.navisdk.ugc.report.ui.a aVar = this.d;
            eVar = new com.baidu.navisdk.ugc.report.ui.widget.b(b2, aVar, this.c, aVar.p(), this.e, this.j);
        } else {
            Activity b3 = this.d.b();
            com.baidu.navisdk.ugc.report.ui.a aVar2 = this.d;
            eVar = new com.baidu.navisdk.ugc.report.ui.widget.e(b3, aVar2, this.c, aVar2.p(), this.e, this.j);
        }
        this.h.a(eVar, 3);
    }

    private void k() {
        if (this.e == null) {
            this.e = new a();
        }
    }

    private void l() {
        if (this.h == null) {
            return;
        }
        k();
        j();
    }

    private void m() {
        if (this.j == 1) {
            this.f8270a = JarUtils.inflate(this.b, R.layout.nsdk_layout_ugc_report_sub_detail_view, null);
        } else {
            this.f8270a = JarUtils.inflate(this.b, R.layout.nsdk_layout_ugc_report_sub_detail_view_land, null);
        }
        View view = this.f8270a;
        if (view == null) {
            return;
        }
        UgcReportLayout ugcReportLayout = (UgcReportLayout) view.findViewById(R.id.ugc_report_detail_layout);
        this.h = ugcReportLayout;
        ugcReportLayout.setTipsMayi(this.c);
        this.i = (UgcCustomLinearScrollView) this.f8270a.findViewById(R.id.ugc_sub_main_content_layout);
        this.f = (ImageView) this.f8270a.findViewById(R.id.ugc_sub_title_iv);
        this.g = (TextView) this.f8270a.findViewById(R.id.ugc_sub_title_type_tv);
        this.k = (Button) this.f8270a.findViewById(R.id.ugc_sub_upload_btn);
        this.l = (Button) this.f8270a.findViewById(R.id.ugc_navi_sub_upload_btn);
    }

    private boolean n() {
        if (this.d.p() == 7 && this.d.t()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.b
    public abstract void a(String str, String str2);

    @Override // com.baidu.navisdk.ugc.report.b
    public void g() {
        com.baidu.navisdk.ugc.report.ui.a aVar = this.d;
        if (aVar == null) {
            return;
        }
        if (this.f != null) {
            com.baidu.navisdk.ugc.utils.d.b(aVar.p(), this.f);
        }
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(this.d.i());
        }
        l();
        this.h.d();
        this.m = new b();
        UgcReportLayout ugcReportLayout = this.h;
        if (ugcReportLayout != null) {
            ugcReportLayout.getViewTreeObserver().addOnGlobalLayoutListener(this.m);
        }
    }

    public View h() {
        return this.f8270a;
    }

    public void i() {
    }

    @Override // com.baidu.navisdk.ugc.report.ui.b
    public void onActivityResult(int i, int i2, Intent intent) {
        UgcReportLayout ugcReportLayout = this.h;
        if (ugcReportLayout != null) {
            ugcReportLayout.a(i, i2, intent);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.b
    public void onConfigurationChanged(Configuration configuration) {
        UgcReportLayout ugcReportLayout = this.h;
        if (ugcReportLayout != null) {
            ugcReportLayout.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.b
    public void onDestroy() {
        UgcReportLayout ugcReportLayout = this.h;
        if (ugcReportLayout != null) {
            ugcReportLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this.m);
            this.h.c();
        }
    }

    /* loaded from: classes8.dex */
    public class a implements c {
        public a() {
        }

        @Override // com.baidu.navisdk.ugc.report.ui.d.c
        public void a(int i, int i2) {
            if (d.this.d != null) {
                d.this.d.a(i, i2);
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.d.c
        public void b(String str) {
            if (d.this.d != null) {
                d.this.d.b(str);
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.d.c
        public void c(String str, String str2) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("SubContentView", "addPhoto: " + str);
            }
            if (d.this.d != null) {
                d.this.d.c(str, str2);
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.d.c
        public void a(String str, int i) {
            if (d.this.d != null) {
                d.this.d.a(str, i);
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.d.c
        public void b(String str, String str2) {
            if (d.this.d != null) {
                d.this.d.b(str, str2);
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.d.c
        public void a(String str, String str2) {
            if (d.this.d != null) {
                d.this.d.a(str, str2);
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.d.c
        public void a(e.b bVar) {
            if (d.this.d != null) {
                d.this.d.a(bVar);
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.d.c
        public void a(String str) {
            g gVar = g.UGC;
            if (gVar.e()) {
                gVar.g("SubContentView", "deletePhoto: " + str);
            }
            if (d.this.d != null) {
                d.this.d.a(str);
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.b
    public boolean d(int i) {
        UgcReportLayout ugcReportLayout = this.h;
        return ugcReportLayout != null && ugcReportLayout.a(i);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.b
    public void a(boolean z) {
        if (z) {
            Button button = this.k;
            if (button == null || this.l == null) {
                return;
            }
            button.setClickable(true);
            this.l.setClickable(true);
            Button button2 = this.k;
            int i = R.drawable.bnav_common_ugc_blue_button_selector;
            button2.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i));
            this.l.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i));
            return;
        }
        Button button3 = this.k;
        if (button3 == null || this.l == null) {
            return;
        }
        button3.setClickable(false);
        this.l.setClickable(false);
        Button button4 = this.k;
        int i2 = R.drawable.bnav_common_ugc_gray_button_selector;
        button4.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i2));
        this.l.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i2));
    }

    private void a(Context context, int i, boolean z) {
        this.b = context;
        this.j = i;
        this.c = z;
    }

    public void a(com.baidu.navisdk.ugc.report.ui.a aVar) {
        this.d = aVar;
    }
}
