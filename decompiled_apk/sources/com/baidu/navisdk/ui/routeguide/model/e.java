package com.baidu.navisdk.ui.routeguide.model;

import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.l;
import java.util.List;

/* loaded from: classes8.dex */
public class e {
    private static final String p = f.class.getSimpleName();
    private List<l.i> g;
    private int k;
    private CountDownTimer l;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.l f8939a = null;
    private String b = null;
    private int c = 0;
    private String d = null;
    private int e = 0;
    private int f = 0;
    private l.j h = null;
    private boolean i = false;
    public Handler j = null;
    private int m = 0;
    private boolean n = false;
    private int o = 0;

    /* loaded from: classes8.dex */
    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(e.p, "onFinish!!!");
            }
            if (e.this.f8939a != null) {
                com.baidu.navisdk.ui.routeguide.control.s.T().b(e.this.f8939a);
            }
            cancel();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(e.p, "onTick --> millisUntilFinished = " + j);
            }
            e.this.k = (int) j;
            if (e.this.f8939a != null) {
                e.this.f8939a.a(j);
            } else {
                cancel();
            }
        }
    }

    private void e(int i) {
        if (i > 0) {
            this.l = new a(i, 1000L);
        }
    }

    public e b(int i) {
        return this;
    }

    public int c() {
        return this.c;
    }

    public CountDownTimer d() {
        return this.l;
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

    public String f() {
        return this.d;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.m;
    }

    public l.j i() {
        return this.h;
    }

    public com.baidu.navisdk.ui.routeguide.mapmode.subview.l j() {
        return this.f8939a;
    }

    public boolean k() {
        return this.n;
    }

    public boolean l() {
        return this.i;
    }

    public void m() {
        this.f8939a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = 0;
        this.m = 0;
        this.f = 0;
        this.i = false;
        Handler handler = this.j;
        if (handler != null) {
            handler.removeMessages(1000);
        }
        this.j = null;
        this.g = null;
        this.h = null;
        this.n = false;
        this.o = 0;
    }

    public e b(String str) {
        this.d = str;
        return this;
    }

    public e c(int i) {
        this.m = i;
        return this;
    }

    public e d(int i) {
        this.c = i;
        e(i);
        return this;
    }

    public int e() {
        return this.e;
    }

    public e a(com.baidu.navisdk.ui.routeguide.mapmode.subview.l lVar) {
        this.f8939a = lVar;
        return this;
    }

    public int b() {
        return this.o;
    }

    public e a(String str) {
        this.b = str;
        return this;
    }

    public List<l.i> a() {
        return this.g;
    }

    public e a(List<l.i> list) {
        this.g = list;
        return this;
    }

    public e a(l.j jVar) {
        this.h = jVar;
        return this;
    }

    public e a(boolean z) {
        this.n = z;
        return this;
    }

    public e a(int i) {
        this.o = i;
        return this;
    }
}
