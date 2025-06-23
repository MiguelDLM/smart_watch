package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import java.util.List;

/* loaded from: classes8.dex */
public class u {
    private static final String K = f.class.getSimpleName();
    public CountDownTimer A;
    public int B;
    public boolean C;
    public int D = 0;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public List<i0.e> I;
    public com.baidu.navisdk.module.pronavi.model.d J;

    /* renamed from: a, reason: collision with root package name */
    public i0 f8977a;
    public String b;
    public int c;
    public int d;
    public CharSequence e;
    public String f;
    public CharSequence g;
    public CharSequence h;
    public int i;
    public int j;
    public int k;
    public int l;
    public String m;
    public String n;
    public int o;
    public int p;
    public Drawable q;
    public int r;
    public Drawable s;
    public Drawable t;
    public i0.f u;
    public g0.e v;
    public g0.d w;
    public String x;
    public com.baidu.navisdk.util.navimageloader.b y;
    public com.baidu.navisdk.util.navimageloader.e z;

    /* loaded from: classes8.dex */
    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(u.K, "onFinish!!!");
            }
            com.baidu.navisdk.ui.routeguide.control.s.T().b(u.this.f8977a);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(u.K, "onTick --> millisUntilFinished = " + j);
            }
            u.this.D = (int) (j / 1000);
            com.baidu.navisdk.ui.routeguide.control.s.T().d(u.this.f8977a);
        }
    }

    public u(i0 i0Var, String str, int i, int i2, CharSequence charSequence, String str2, CharSequence charSequence2, CharSequence charSequence3, int i3, int i4, int i5, int i6, String str3, String str4, int i7, int i8, Drawable drawable, int i9, Drawable drawable2, Drawable drawable3, i0.f fVar, g0.e eVar, g0.d dVar, String str5, com.baidu.navisdk.util.navimageloader.b bVar, com.baidu.navisdk.util.navimageloader.e eVar2, int i10, boolean z, boolean z2, int i11, boolean z3, boolean z4, int i12, List<i0.e> list, com.baidu.navisdk.module.pronavi.model.d dVar2) {
        this.A = null;
        this.f8977a = i0Var;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = charSequence;
        this.f = str2;
        this.g = charSequence2;
        this.h = charSequence3;
        this.i = i3;
        this.j = i4;
        this.k = i5;
        this.l = i6;
        this.m = str3;
        this.n = str4;
        this.o = i7;
        this.p = i8;
        this.q = drawable;
        this.r = i9;
        this.s = drawable2;
        this.t = drawable3;
        this.u = fVar;
        this.v = eVar;
        this.w = dVar;
        this.x = str5;
        this.y = bVar;
        this.z = eVar2;
        this.B = i10;
        this.C = z;
        this.G = i11;
        this.E = z3;
        this.F = z4;
        this.H = i12;
        this.I = list;
        this.J = dVar2;
        this.A = new a(this.d, 1000L);
    }

    public void a() {
        this.f8977a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.B = 0;
        this.C = false;
        CountDownTimer countDownTimer = this.A;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.A = null;
        this.D = 0;
        this.G = 0;
        this.E = false;
        this.F = false;
        this.H = 0;
        this.I = null;
        this.J = null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(fVar.b)) {
                return this.b.equals(fVar.b);
            }
        }
        return super.equals(obj);
    }
}
