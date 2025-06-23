package com.baidu.navisdk.ugc.report.ui.innavi.sub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.jar.JarUtils;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class c extends com.baidu.navisdk.ugc.report.ui.innavi.sub.a {
    private com.baidu.navisdk.ugc.report.ui.innavi.sub.b h;
    private com.baidu.navisdk.ugc.report.ui.innavi.main.e i;
    private Handler j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private String o;
    private int p;
    private Handler q;

    /* loaded from: classes8.dex */
    public class a implements e {
        public a() {
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.sub.c.e
        public void a(String str, String str2) {
            c.this.d(str, str2);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 256 || c.this.q == null) {
                return;
            }
            c.this.q.removeMessages(256);
            if (c.this.k) {
                return;
            }
            int i = message.arg1 - 1;
            if (i <= 0) {
                c.this.h.b(i);
                if (!c.this.h.j() && c.this.n != 1) {
                    c.this.A();
                    return;
                } else {
                    c.this.c(true);
                    return;
                }
            }
            c.this.h.b(i);
            c.this.q.sendMessageDelayed(c.this.q.obtainMessage(256, i, 0), 1000L);
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(String str, String str2);
    }

    public c(Context context, com.baidu.navisdk.ugc.report.data.datarepository.e eVar, com.baidu.navisdk.ugc.report.ui.innavi.sub.b bVar, com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar2, com.baidu.navisdk.ugc.report.data.datastatus.a aVar, Handler handler, int i, boolean z, int i2, String str) {
        super(context, bVar, eVar, handler, i, z);
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar2;
        this.k = false;
        this.q = null;
        this.h = bVar;
        this.i = eVar2;
        this.j = handler;
        this.m = i;
        this.l = z;
        this.n = i2;
        this.o = str;
        bVar.a((com.baidu.navisdk.ugc.report.ui.a) this);
        if (aVar != null && (aVar2 = this.d) != null) {
            aVar2.a(aVar);
        }
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar3 = this.d;
        if (aVar3 != null && i2 == 1) {
            aVar3.b0 = -1;
        }
    }

    private void C() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar;
        if (this.m == 2 && (eVar = this.i) != null) {
            eVar.A();
        }
        com.baidu.navisdk.ugc.https.e.a(this.d, new C0398c(this.m, true, this.i.o()), this.m, this.o);
    }

    private void D() {
        int i = this.p;
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i == 5) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.4", this.m + "", "5", null);
                        return;
                    }
                    return;
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.3", this.m + "", "3", null);
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.2", this.m + "", "2", null);
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.1", this.m + "", "4", null);
    }

    private boolean E() {
        int i = this.n;
        if (i != 2 && i != 3) {
            return false;
        }
        return true;
    }

    private void F() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar;
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcReportNaviSubDetailP", "realComUpload parPresenter:" + this.i + ", infoPackage:" + this.d.toString());
        }
        if (x()) {
            this.d.N = 1;
            if (this.i != null && this.h.j()) {
                this.i.x();
                return;
            }
        }
        com.baidu.navisdk.ugc.https.d.a(this.d);
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
        if (aVar.d <= 0) {
            aVar.d = com.baidu.navisdk.ugc.utils.c.e(this.m);
        }
        this.d.N = 0;
        com.baidu.navisdk.ugc.report.ui.innavi.sub.b bVar = this.h;
        if (bVar != null && !bVar.j()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.1", "5", this.d.e + "", null);
        }
        if (this.m == 2 && (eVar = this.i) != null) {
            eVar.A();
        }
        com.baidu.navisdk.ugc.https.e.a(this.d, new d(this.m, E(), this.i.o()), this.i.m(), this.m, this.o);
    }

    private void G() {
        if (this.q == null && !this.k) {
            this.q = new b(Looper.getMainLooper());
            this.h.b(10);
            this.q.removeMessages(256);
            Handler handler = this.q;
            handler.sendMessageDelayed(handler.obtainMessage(256, 10, 0), 1000L);
        }
    }

    private void H() {
        this.k = true;
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(256);
            this.q = null;
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.sub.a
    public void A() {
        H();
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.i;
        if (eVar != null) {
            eVar.a(true);
        }
    }

    public boolean B() {
        H();
        return false;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.c, com.baidu.navisdk.ugc.report.ui.a
    public int n() {
        return this.m;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.c
    public void y() {
        super.y();
        H();
    }

    @Override // com.baidu.navisdk.ugc.report.ui.c
    public void z() {
        super.z();
        G();
        if (this.l) {
            Handler handler = this.j;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 2000;
                obtainMessage.obj = new a();
                obtainMessage.sendToTarget();
                return;
            }
            return;
        }
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
        if (aVar != null) {
            d(aVar.c, aVar.s);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.c
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.c, com.baidu.navisdk.ugc.report.ui.a
    public Activity b() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.i;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.sub.a
    public void c(boolean z) {
        if (this.h == null || this.d == null) {
            return;
        }
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcReportNaviSubDetailP", "comUpload: " + z);
        }
        if (!z.a(com.baidu.navisdk.framework.a.c().a())) {
            if (!z) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail_badwet));
            }
            com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar = this.i;
            if (eVar != null) {
                eVar.a(true);
                return;
            }
            return;
        }
        H();
        if (this.n == 3) {
            C();
        } else {
            F();
        }
        D();
        com.baidu.navisdk.ugc.report.ui.innavi.main.e eVar2 = this.i;
        if (eVar2 != null) {
            eVar2.a(true);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.c
    public void d(String str, String str2) {
        this.h.a(str2, (String) null);
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = com.baidu.navisdk.ugc.report.ui.innavi.main.e.B;
        if (aVar != null) {
            aVar.s = str2;
        }
    }

    public void e(int i) {
        this.p = i;
    }

    public int j() {
        return this.n;
    }

    /* renamed from: com.baidu.navisdk.ugc.report.ui.innavi.sub.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0398c extends com.baidu.navisdk.ugc.report.ui.innavi.a {
        public C0398c(int i, boolean z, String str) {
            super(i, z, str);
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(JSONObject jSONObject) {
            super.a(jSONObject);
            if (((com.baidu.navisdk.ugc.report.ui.c) c.this).d != null) {
                ((com.baidu.navisdk.ugc.report.ui.c) c.this).d.b();
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(String str) {
            super.a(str);
            if (((com.baidu.navisdk.ugc.report.ui.c) c.this).d != null) {
                ((com.baidu.navisdk.ugc.report.ui.c) c.this).d.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends com.baidu.navisdk.ugc.report.ui.innavi.a {
        public d(int i, boolean z, String str) {
            super(i, z, str);
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(JSONObject jSONObject) {
            super.a(jSONObject);
            if (((com.baidu.navisdk.ugc.report.ui.c) c.this).d != null) {
                ((com.baidu.navisdk.ugc.report.ui.c) c.this).d.b();
            }
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(String str) {
            super.a(str);
            if (((com.baidu.navisdk.ugc.report.ui.c) c.this).d != null) {
                ((com.baidu.navisdk.ugc.report.ui.c) c.this).d.b();
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.sub.a
    public void a(MotionEvent motionEvent) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcReportNaviSubDetailP", "mainContentOnTouch: ");
        }
        H();
    }

    public void d(int i) {
        this.m = i;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.c
    public void a(Configuration configuration) {
        super.a(configuration);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.c
    public void a(com.baidu.navisdk.ugc.report.ui.innavi.sub.b bVar) {
        super.a(bVar);
        this.h = bVar;
    }
}
