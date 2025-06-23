package com.baidu.navisdk.pronavi.ui.driving;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.lifecycle.Observer;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.widgets.b;
import com.baidu.navisdk.pronavi.logic.driving.c;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class a extends b {
    private TextView l;
    private com.baidu.navisdk.pronavi.logic.driving.b m;
    private c n;
    private boolean o;

    @ColorRes
    private int p;

    @ColorRes
    private int q;

    /* renamed from: com.baidu.navisdk.pronavi.ui.driving.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0351a implements Observer<com.baidu.navisdk.pronavi.logic.driving.a> {
        public C0351a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.baidu.navisdk.pronavi.logic.driving.a aVar) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDrivingDistanceTimeVi", "distance Time onChanged: ");
            }
            a.this.a(aVar);
        }
    }

    public a(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, false);
    }

    private void o0() {
        c cVar = (c) n0().get(c.class);
        this.n = cVar;
        cVar.a().observe(this, new C0351a());
    }

    private void p0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDrivingDistanceTimeVi", "endLoopUpdate: ");
        }
        com.baidu.navisdk.pronavi.logic.driving.b bVar = this.m;
        if (bVar != null) {
            bVar.b();
        }
    }

    private void q0() {
        if (this.l != null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGDrivingDistanceTimeVi", "initView:mDistanceTimeTxt != null");
                return;
            }
            return;
        }
        ViewGroup viewGroup = this.b;
        if (viewGroup == null) {
            g gVar2 = g.PRO_NAV;
            if (gVar2.c()) {
                gVar2.c("RGDrivingDistanceTimeVi", "initView: mRootViewGroup == null");
                return;
            }
            return;
        }
        try {
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.bnav_rg_bmbar_driving_info_ly_stub);
            if (viewStub != null) {
                com.baidu.navisdk.ui.util.b.a(viewStub);
            }
        } catch (Exception e) {
            g gVar3 = g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGDrivingDistanceTimeVi", "initView ViewStub exception: " + e);
            }
            if (gVar3.b()) {
                gVar3.a("load initView exception", e);
            }
        }
        this.l = (TextView) this.b.findViewById(R.id.bnav_rg_bmbar_driving_info_ly);
        s0();
    }

    private void r0() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDrivingDistanceTimeVi", "startLoopUpdate: ");
        }
        if (this.m == null) {
            this.m = new com.baidu.navisdk.pronavi.logic.driving.b();
        }
        this.m.a(this.n);
        this.m.a(3000L);
    }

    private void s0() {
        TextView textView = this.l;
        if (textView == null) {
            return;
        }
        if (this.f == 1) {
            textView.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_17dp));
        } else {
            textView.setTextSize(0, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_15dp));
        }
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.b, com.baidu.navisdk.ui.routeguide.widget.d
    public void c() {
        super.c();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDrivingDistanceTimeVi", "hide: ");
        }
        p0();
        TextView textView = this.l;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void d(@ColorRes int i, @ColorRes int i2) {
        if (i == 0) {
            i = R.color.nsdk_cl_text_b_mm_title;
        }
        this.p = i;
        if (i2 == 0) {
            this.q = R.color.nsdk_cl_text_b_mm_title;
        } else {
            this.q = i2;
        }
        TextView textView = this.l;
        if (textView != null) {
            com.baidu.navisdk.ui.util.b.a(textView, this.q);
        }
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.b, com.baidu.navisdk.ui.routeguide.widget.d
    public void i() {
        super.i();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDrivingDistanceTimeVi", "dispose: ");
        }
        if (a()) {
            c();
        } else {
            p0();
        }
        com.baidu.navisdk.pronavi.logic.driving.b bVar = this.m;
        if (bVar != null) {
            bVar.a();
            this.m = null;
        }
    }

    public String toString() {
        return "RGDrivingDistanceTimeView{, mDistanceTimeTxt=" + this.l + ", mService=" + this.m + ", mViewModel=" + this.n + ", isSimpleEta=" + this.o + ", mTitleColorId=" + this.p + ", mDistTimeColorId=" + this.q + '}';
    }

    @Override // com.baidu.navisdk.module.newguide.widgets.b, com.baidu.navisdk.ui.routeguide.widget.d
    public boolean y() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDrivingDistanceTimeVi", "show: " + a());
        }
        if (a()) {
            return true;
        }
        super.y();
        q0();
        o0();
        r0();
        TextView textView = this.l;
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (gVar.d()) {
            gVar.e("RGDrivingDistanceTimeVi", "show: " + this.l);
        }
        return true;
    }

    public a(Context context, ViewGroup viewGroup, boolean z) {
        super(context, viewGroup);
        int i = R.color.nsdk_cl_text_b_mm_title;
        this.p = i;
        this.q = i;
        this.o = z;
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(boolean z) {
        super.a(z);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDrivingDistanceTimeVi", "updateStyle: " + z);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.widget.d
    public void a(ViewGroup viewGroup, int i) {
        super.a(viewGroup, i);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDrivingDistanceTimeVi", "orientationChanged: ");
        }
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.navisdk.pronavi.logic.driving.a aVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGDrivingDistanceTimeVi", "updateView: " + aVar);
        }
        TextView textView = this.l;
        if (textView != null) {
            if (this.o) {
                textView.setText(aVar.b);
            } else {
                textView.setText(String.format("%s %s %s", aVar.f7777a, aVar.b, aVar.c));
            }
        }
    }
}
