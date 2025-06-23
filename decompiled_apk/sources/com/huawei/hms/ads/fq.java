package com.huawei.hms.ads;

import android.view.View;
import com.huawei.openalliance.ad.inter.data.VideoInfo;

/* loaded from: classes10.dex */
public class fq extends fs {
    private a C;
    private boolean D;
    private int F;
    boolean I;
    private long L;
    private long S;
    boolean V;
    protected com.huawei.openalliance.ad.inter.data.k Z;

    /* renamed from: a, reason: collision with root package name */
    private int f17288a;
    private int b;
    private int c;

    /* loaded from: classes10.dex */
    public interface a {
        void B();

        void Code();

        void Code(long j, int i);

        void I();

        void V();

        void V(long j, int i);

        void Z();
    }

    public fq(View view, a aVar) {
        super(view);
        this.S = 500L;
        this.F = 50;
        this.D = false;
        this.b = 100;
        this.c = 10;
        this.V = false;
        this.I = false;
        this.C = aVar;
        this.L = com.huawei.openalliance.ad.utils.w.Code();
    }

    private void f() {
        if (this.D) {
            return;
        }
        fb.V("PPSLinkedViewMonitor", "viewShowStartRecord");
        this.D = true;
        this.L = System.currentTimeMillis();
        a aVar = this.C;
        if (aVar != null) {
            aVar.Code();
        }
    }

    private void g() {
        if (this.D) {
            fb.V("PPSLinkedViewMonitor", "viewShowEndRecord");
            this.D = false;
            long currentTimeMillis = System.currentTimeMillis() - this.L;
            if (fb.Code()) {
                fb.Code("PPSLinkedViewMonitor", "max visible area percentage: %d duration: %d", Integer.valueOf(this.f17288a), Long.valueOf(currentTimeMillis));
            }
            a aVar = this.C;
            if (aVar != null) {
                aVar.Code(currentTimeMillis, this.f17288a);
            }
            this.f17288a = 0;
        }
    }

    public int B() {
        return this.f17288a;
    }

    @Override // com.huawei.hms.ads.fs
    public void Code() {
        a aVar = this.C;
        if (aVar != null) {
            aVar.V();
        }
    }

    public boolean F() {
        return e() >= V();
    }

    public int I() {
        return this.c;
    }

    public int V() {
        return this.b;
    }

    @Override // com.huawei.hms.ads.fs
    public void Code(int i) {
        fb.V("PPSLinkedViewMonitor", "onUpdateViewShowArea, percentage: %s", Integer.valueOf(i));
        if (i > this.f17288a) {
            this.f17288a = i;
        }
        if (i >= this.F) {
            f();
        } else {
            g();
        }
        V(i);
    }

    public void V(int i) {
        a aVar;
        if (i >= V()) {
            this.I = false;
            if (this.V) {
                return;
            }
            this.V = true;
            a aVar2 = this.C;
            if (aVar2 != null) {
                aVar2.I();
                return;
            }
            return;
        }
        this.V = false;
        if (i > 100 - I()) {
            if (this.I && (aVar = this.C) != null) {
                aVar.B();
            }
            this.I = false;
            return;
        }
        if (this.I) {
            return;
        }
        this.I = true;
        a aVar3 = this.C;
        if (aVar3 != null) {
            aVar3.Z();
        }
    }

    @Override // com.huawei.hms.ads.fs
    public void Code(long j, int i) {
        g();
        a aVar = this.C;
        if (aVar != null) {
            aVar.V(j, i);
        }
        V(0);
    }

    public void V(long j, int i) {
        this.F = i;
        this.S = j;
    }

    public void Code(com.huawei.openalliance.ad.inter.data.k kVar) {
        this.Z = kVar;
        if (kVar == null || kVar.C() == null) {
            return;
        }
        VideoInfo C = kVar.C();
        this.b = C.c();
        this.c = Math.max(100 - C.d(), 0);
    }

    public boolean Code(long j) {
        return j >= this.S && this.f17288a >= this.F;
    }
}
