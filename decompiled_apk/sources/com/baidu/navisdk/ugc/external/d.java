package com.baidu.navisdk.ugc.external;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.r;
import com.baidu.navisdk.ugc.b;
import com.baidu.navisdk.ugc.c;
import com.baidu.navisdk.ugc.report.ui.UgcReportPanelLayout;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.utils.a;

/* loaded from: classes8.dex */
public class d implements com.baidu.navisdk.ugc.replenishdetails.b, c.b {
    public static boolean n = false;

    /* renamed from: a, reason: collision with root package name */
    private Context f8181a;
    private ViewGroup b;
    private r f;
    private final b.AbstractC0368b g;
    private final int h;
    private com.baidu.navisdk.ugc.c j;
    protected UgcReportPanelLayout l;
    protected int m;
    private boolean c = false;
    private View d = null;
    protected ViewGroup e = null;
    private boolean i = true;
    private boolean k = true;

    /* loaded from: classes8.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ViewGroup viewGroup = d.this.e;
            if (viewGroup != null) {
                viewGroup.clearAnimation();
            }
            d.this.q();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.g != null) {
                d.this.g.a(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements com.baidu.navisdk.ugc.https.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.ugc.report.data.datastatus.a f8184a;

        public c(com.baidu.navisdk.ugc.report.data.datastatus.a aVar) {
            this.f8184a = aVar;
        }

        @Override // com.baidu.navisdk.ugc.https.b
        public void a(String str, boolean z) {
            if (com.baidu.navisdk.ugc.replenishdetails.d.o().c(str)) {
                com.baidu.navisdk.ugc.replenishdetails.d.o().d(null);
                if (z) {
                    com.baidu.navisdk.ugc.replenishdetails.d.o().b(str);
                }
                if (d.this.f != null && d.n) {
                    d.this.f.a(str, this.f8184a, z);
                }
            }
        }
    }

    public d(Activity activity, ViewGroup viewGroup, b.AbstractC0368b abstractC0368b, int i, int i2, com.baidu.navisdk.ugc.report.data.datarepository.e eVar, com.baidu.navisdk.ugc.report.data.datarepository.e eVar2) {
        this.m = 1;
        this.f8181a = activity;
        this.b = viewGroup;
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_UgcReport", "BNUgcNavReportMenuView: " + viewGroup + ", mComeFrom: " + i2);
        }
        this.g = abstractC0368b;
        this.h = i2;
        this.m = i;
        v();
        a(activity, i, i2, eVar, eVar2);
        d(com.baidu.navisdk.ui.util.b.b());
    }

    private void u() {
        com.baidu.navisdk.ugc.c cVar = new com.baidu.navisdk.ugc.c(this);
        this.j = cVar;
        cVar.a(this.h);
    }

    private void v() {
        int i;
        if (this.b == null) {
            return;
        }
        b.AbstractC0368b abstractC0368b = this.g;
        if (abstractC0368b != null) {
            i = abstractC0368b.a();
        } else {
            i = 0;
        }
        UgcReportPanelLayout ugcReportPanelLayout = (UgcReportPanelLayout) this.b.findViewById(i);
        this.l = ugcReportPanelLayout;
        this.d = ugcReportPanelLayout;
        ViewGroup viewGroup = (ViewGroup) this.b.findViewById(R.id.bnav_rg_ugc_menu_container);
        this.e = viewGroup;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "initMenuView: " + this.e);
        }
        View view = this.d;
        if (view != null) {
            view.setOnClickListener(new b());
        }
    }

    private boolean w() {
        if (this.h == 4) {
            return true;
        }
        return false;
    }

    public void c(boolean z) {
        g gVar = g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_UgcReport", "showUgcEventItemsPanel: " + this.e + ", isNeedDynamicEventCloudConfig:" + z);
        }
        if (this.e != null) {
            if (z) {
                u();
            }
            this.f.a(this);
            this.f.n();
            return;
        }
        b.AbstractC0368b abstractC0368b = this.g;
        if (abstractC0368b != null) {
            abstractC0368b.a(false);
        }
    }

    public void d(boolean z) {
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.b
    public int e() {
        return com.baidu.navisdk.ugc.replenishdetails.d.o().d();
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.b
    public boolean f() {
        if (m() && com.baidu.navisdk.ugc.replenishdetails.d.o().l()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.b
    public boolean g() {
        if (m() && com.baidu.navisdk.ugc.replenishdetails.d.o().m()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.b
    public int h() {
        return com.baidu.navisdk.ugc.replenishdetails.d.o().f();
    }

    public void i() {
        this.f8181a = null;
    }

    public void j() {
        if (this.k) {
            com.baidu.navisdk.asr.d.B().b(true);
        }
        this.k = true;
        this.c = false;
        if (this.d != null && !w()) {
            this.d.setBackgroundColor(0);
        }
        View view = this.d;
        if (view != null) {
            view.setOnClickListener(null);
        }
        if (this.i && this.e != null) {
            Animation a2 = com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_OUT, 0L, 300L);
            a2.setFillAfter(true);
            a2.setAnimationListener(new a());
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                viewGroup.startAnimation(a2);
                return;
            }
            return;
        }
        q();
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        if (this.m != 2) {
            return true;
        }
        return false;
    }

    public boolean m() {
        return true;
    }

    public boolean n() {
        return this.c;
    }

    public boolean o() {
        b.AbstractC0368b abstractC0368b;
        r rVar = this.f;
        if (rVar != null && !rVar.n0() && (abstractC0368b = this.g) != null) {
            abstractC0368b.a(true);
            return true;
        }
        return false;
    }

    public void p() {
        b(true);
    }

    public void q() {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "BNUgcNavReportMenuView onHide isViewShow:" + n);
        }
        n = false;
        View view = this.d;
        if (view != null) {
            view.setVisibility(8);
            this.d = null;
        }
        ViewGroup viewGroup = this.e;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.e.removeAllViews();
            this.e = null;
        }
        this.l = null;
        this.i = true;
    }

    public boolean r() {
        if (!n()) {
            boolean q = com.baidu.navisdk.asr.d.B().q();
            this.k = q;
            if (q) {
                com.baidu.navisdk.asr.d.B().b(false);
            }
        }
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "BNUgcNavReportMenuView show isViewShow:" + n);
        }
        this.c = true;
        n = true;
        if (this.d != null) {
            if (!w()) {
                this.d.setBackgroundColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_ugc_menu_background));
            }
            this.d.setVisibility(0);
        }
        if (this.e != null) {
            this.e.startAnimation(com.baidu.navisdk.utils.a.a(a.b.ANIM_DOWN_IN, 0L, 300L));
            this.e.setVisibility(0);
        }
        return true;
    }

    public void s() {
        if (this.e != null) {
            this.f.a(com.baidu.navisdk.ugc.replenishdetails.d.o().c(), com.baidu.navisdk.ugc.replenishdetails.d.o().d(), com.baidu.navisdk.ugc.replenishdetails.d.o().j(), com.baidu.navisdk.ugc.replenishdetails.d.o().i(), com.baidu.navisdk.ugc.replenishdetails.d.o().g());
            return;
        }
        b.AbstractC0368b abstractC0368b = this.g;
        if (abstractC0368b != null) {
            abstractC0368b.a(false);
        }
    }

    public void t() {
        if (this.e != null) {
            this.f.a(com.baidu.navisdk.ugc.replenishdetails.d.o().c(), com.baidu.navisdk.ugc.replenishdetails.d.o().h());
            return;
        }
        b.AbstractC0368b abstractC0368b = this.g;
        if (abstractC0368b != null) {
            abstractC0368b.a(false);
        }
    }

    private void a(Activity activity, int i, int i2, com.baidu.navisdk.ugc.report.data.datarepository.e eVar, com.baidu.navisdk.ugc.report.data.datarepository.e eVar2) {
        this.f = new com.baidu.navisdk.ugc.b(activity, this.g, i, i2, this.e, eVar, k(), eVar2);
    }

    public void b(boolean z) {
        com.baidu.navisdk.ugc.c cVar = this.j;
        if (cVar != null) {
            cVar.a();
            this.j = null;
        }
        if (this.f != null) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("BNUgcNavReportMenuView", "mUgcReport.onDestroy()");
            }
            this.f.onDestroy();
            this.f = null;
        }
        this.i = z;
        j();
        i();
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.b
    public String d() {
        return com.baidu.navisdk.ugc.replenishdetails.d.o().g();
    }

    @Override // com.baidu.navisdk.ugc.c.b
    public void a(boolean z) {
        r rVar = this.f;
        if (rVar != null) {
            rVar.M();
        }
    }

    public void a(int i, int i2, Intent intent) {
        r rVar = this.f;
        if (rVar != null) {
            rVar.onActivityResult(i, i2, intent);
        }
    }

    public boolean a(int i) {
        r rVar = this.f;
        return rVar != null && rVar.a(i);
    }

    public void a(ViewGroup viewGroup, int i) {
        this.b = viewGroup;
        this.m = i;
        if (viewGroup == null || this.f == null) {
            return;
        }
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "BNUgcNavReportMenuView orientationChanged isViewShow:" + n);
        }
        v();
        r rVar = this.f;
        if (rVar != null) {
            rVar.a((Activity) this.f8181a, i, this.e);
        }
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.b
    public String c() {
        return com.baidu.navisdk.ugc.replenishdetails.d.o().e();
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.b
    public String b() {
        return com.baidu.navisdk.ugc.replenishdetails.d.o().c();
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.b
    public com.baidu.navisdk.ugc.report.data.datastatus.a a() {
        return com.baidu.navisdk.ugc.replenishdetails.d.o().h();
    }

    @Override // com.baidu.navisdk.ugc.replenishdetails.b
    public void a(String str, com.baidu.navisdk.ugc.report.data.datastatus.a aVar, int i) {
        if (TextUtils.isEmpty(str)) {
            r rVar = this.f;
            if (rVar == null || !n) {
                return;
            }
            rVar.a(str, (Object) aVar, true);
            return;
        }
        if (str.equals(com.baidu.navisdk.ugc.replenishdetails.d.o().b())) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_UgcReport", "asyncQueryEventIsOffline: " + str + ", verifing event: " + com.baidu.navisdk.ugc.replenishdetails.d.o().b());
                return;
            }
            return;
        }
        com.baidu.navisdk.ugc.replenishdetails.d.o().d(str);
        com.baidu.navisdk.ugc.https.e.a(str, new c(aVar), i);
    }
}
