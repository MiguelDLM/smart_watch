package com.baidu.navisdk.ui.routeguide.ugc;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.util.Pair;
import android.view.ViewGroup;
import com.baidu.navisdk.framework.interfaces.pronavi.hd.f;
import com.baidu.navisdk.ugc.b;
import com.baidu.navisdk.ugc.report.ui.UgcReportPanelLayout;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class b extends com.baidu.navisdk.ugc.external.d implements com.baidu.navisdk.framework.interfaces.pronavi.hd.c {

    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f9147a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        public a(int i, int i2, int i3, int i4) {
            this.f9147a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (((com.baidu.navisdk.ugc.external.d) b.this).l != null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ((com.baidu.navisdk.ugc.external.d) b.this).l.a((int) (this.f9147a + (this.b * floatValue)), (int) (this.c + (this.d * floatValue)));
            }
        }
    }

    public b(Activity activity, ViewGroup viewGroup, b.AbstractC0368b abstractC0368b, int i, int i2, com.baidu.navisdk.ugc.report.data.datarepository.e eVar, com.baidu.navisdk.ugc.report.data.datarepository.e eVar2) {
        super(activity, viewGroup, abstractC0368b, i, i2, eVar, eVar2);
    }

    private void e(boolean z) {
        x.b().a(true, !z, this.e);
    }

    private void v() {
        if (this.l == null) {
            return;
        }
        f o = com.baidu.navisdk.ui.routeguide.utils.b.o();
        Pair<Integer, Integer> a2 = a(o.f6817a, com.baidu.navisdk.ui.routeguide.utils.b.a(false, o));
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGUgcReportView", "initLandPanelLocation: " + a2);
        }
        if (((Integer) a2.first).intValue() == this.l.getPaddingLeft() && ((Integer) a2.second).intValue() == this.l.getPaddingRight()) {
            return;
        }
        this.l.a(((Integer) a2.first).intValue(), ((Integer) a2.second).intValue());
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> c(int i, int i2, boolean z, f fVar) {
        return a(0, z, i2);
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> d(int i, int i2, boolean z, f fVar) {
        return a(3, z, i2);
    }

    @Override // com.baidu.navisdk.ugc.external.d
    public boolean r() {
        if (!l()) {
            v();
            u();
        }
        return super.r();
    }

    public void u() {
        e(com.baidu.navisdk.ui.routeguide.utils.b.o().b());
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.hd.c
    public List<Animator> a(int i, int i2, boolean z, f fVar) {
        return a(2, z, i2);
    }

    private List<Animator> a(int i, boolean z, int i2) {
        UgcReportPanelLayout ugcReportPanelLayout;
        if (z || (ugcReportPanelLayout = this.l) == null || ugcReportPanelLayout.getVisibility() != 0) {
            return null;
        }
        e(i == 2);
        Pair<Integer, Integer> a2 = a(i, i2);
        int intValue = ((Integer) a2.first).intValue();
        int intValue2 = ((Integer) a2.second).intValue();
        int paddingLeft = this.l.getPaddingLeft();
        int paddingRight = this.l.getPaddingRight();
        boolean z2 = paddingLeft != intValue;
        boolean z3 = paddingRight != intValue2;
        if (!z2 && !z3) {
            return null;
        }
        int i3 = intValue2 - paddingRight;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(paddingLeft, intValue - paddingLeft, paddingRight, i3));
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(ofFloat);
        return arrayList;
    }

    private Pair<Integer, Integer> a(int i, int i2) {
        int l;
        if (i == 2) {
            l = com.baidu.navisdk.ui.routeguide.utils.b.q();
        } else if (i == 3) {
            i2 = com.baidu.navisdk.ui.routeguide.utils.b.k();
            l = com.baidu.navisdk.ui.routeguide.utils.b.q() + i2;
        } else {
            l = com.baidu.navisdk.ui.routeguide.utils.b.l();
            i2 = 0;
        }
        return new Pair<>(Integer.valueOf(l), Integer.valueOf(i2));
    }
}
