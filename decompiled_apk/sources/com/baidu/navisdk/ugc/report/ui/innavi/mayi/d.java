package com.baidu.navisdk.ugc.report.ui.innavi.mayi;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.navisdk.ugc.report.ui.innavi.main.e;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f8298a;
    private c b;
    private e.i d;
    private com.baidu.navisdk.ugc.report.data.datarepository.e e;
    private com.baidu.navisdk.ugc.report.data.datastatus.a f;
    private Handler g;
    private com.baidu.navisdk.ugc.report.ui.innavi.main.e h;
    private e.j i;
    private Handler j;
    private int k;
    private com.baidu.navisdk.ugc.report.ui.innavi.sub.c c = null;
    private int l = 1;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (d.this.g == null) {
                return;
            }
            d.this.g.removeMessages(1);
            int i = message.arg1 - 1;
            if (i <= 0) {
                d.this.m();
            } else {
                d.this.b.b(i);
                d.this.g.sendMessageDelayed(d.this.g.obtainMessage(1, i, 0), 1000L);
            }
        }
    }

    public d(c cVar, e.i iVar, com.baidu.navisdk.ugc.report.data.datarepository.e eVar, com.baidu.navisdk.ugc.report.data.datastatus.a aVar, com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar2, e.j jVar, Handler handler) {
        this.b = cVar;
        this.d = iVar;
        this.e = eVar;
        this.f = aVar;
        this.h = eVar2;
        this.i = jVar;
        this.j = handler;
        cVar.a(this);
    }

    private void A() {
        if (this.g == null) {
            this.g = new a(Looper.getMainLooper());
        }
        this.b.b(10);
        Handler handler = this.g;
        handler.sendMessageDelayed(handler.obtainMessage(1, 10, 0), 1000L);
    }

    private void c(boolean z) {
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar;
        z();
        if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B == null) {
            com.baidu.navisdk.ugc.report.ui.innavi.main.e.B = new com.baidu.navisdk.ugc.report.data.datastatus.a();
        }
        com.baidu.navisdk.ugc.report.ui.innavi.sub.d dVar = new com.baidu.navisdk.ugc.report.ui.innavi.sub.d(this.b.a(), this.b.c(), 4);
        com.baidu.navisdk.ugc.report.data.datarepository.e f = com.baidu.navisdk.ugc.report.data.datarepository.c.f(this.k);
        if (z && (cVar = this.c) != null) {
            cVar.a(dVar);
        } else {
            this.c = new com.baidu.navisdk.ugc.report.ui.innavi.sub.c(this.b.a(), f, dVar, this.h, this.f, this.j, 2, true, 4, null);
        }
        dVar.a((com.baidu.navisdk.ugc.report.ui.a) this.c);
        View h = dVar.h();
        ViewGroup d = this.b.d();
        this.f8298a = d;
        if (d != null && h != null) {
            d.removeAllViews();
            this.f8298a.addView(h, new FrameLayout.LayoutParams(-1, -1));
            if (z) {
                this.c.a((Configuration) null);
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.4.2", "2", f.j() + "", null);
            this.c.z();
        }
    }

    public void m() {
        e.i iVar = this.d;
        if (iVar != null) {
            iVar.a(true);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.mayi.b
    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> v() {
        com.baidu.navisdk.ugc.report.data.datarepository.e eVar = this.e;
        if (eVar != null) {
            return eVar.f();
        }
        return new ArrayList<>(0);
    }

    public boolean w() {
        z();
        return true;
    }

    public void x() {
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar = this.c;
        if (cVar != null) {
            cVar.y();
        }
        z();
    }

    public void y() {
        this.l = 1;
        c cVar = this.b;
        if (cVar != null) {
            cVar.g();
        }
        A();
    }

    public void z() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeMessages(1);
            this.g = null;
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.mayi.b
    public void a(int i) {
        this.l = 2;
        this.k = i;
        this.i.a(i);
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.f;
        if (aVar != null) {
            aVar.e = i;
            aVar.N = 1;
        }
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = com.baidu.navisdk.ugc.report.ui.innavi.main.e.B;
        if (aVar2 != null) {
            aVar2.e = aVar.e;
            aVar2.N = aVar.N;
        }
        c(false);
    }

    public void a(e eVar) {
        this.b = eVar;
    }

    public void a(Configuration configuration) {
        if (this.l == 1) {
            y();
        } else {
            c(true);
        }
    }

    public void a(int i, int i2, Intent intent) {
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar = this.c;
        if (cVar != null) {
            cVar.a(i, i2, intent);
        }
    }
}
