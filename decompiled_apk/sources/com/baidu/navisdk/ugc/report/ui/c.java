package com.baidu.navisdk.ugc.report.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.baidu.navisdk.ugc.report.data.datarepository.e;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.worker.f;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public abstract class c implements com.baidu.navisdk.ugc.report.ui.a, com.baidu.navisdk.ugc.listener.a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ugc.report.ui.b f8267a;
    private final e b;
    private final Handler c;
    private boolean e;
    private final int f;
    private final Handler g = new b(Looper.getMainLooper());
    protected com.baidu.navisdk.ugc.report.data.datastatus.a d = new com.baidu.navisdk.ugc.report.data.datastatus.a();

    /* loaded from: classes8.dex */
    public class a extends f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            c.this.f8267a.a(c.this.d.s, null);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            com.baidu.navisdk.ugc.report.data.datastatus.a aVar;
            if (message.what == 1003) {
                g gVar = g.UGC;
                if (gVar.d()) {
                    gVar.e("SubContentPrensenter", "handleMessage: " + message.arg1);
                }
                if (message.arg1 == 0) {
                    s b = ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).b();
                    if (gVar.d()) {
                        gVar.e("SubContentPrensenter", "handleMessage: " + b);
                    }
                    if (b != null && b.g.length() > 0) {
                        if (c.this.f8267a != null && (aVar = c.this.d) != null) {
                            if (b.j != null && b.g != null) {
                                if (TextUtils.isEmpty(aVar.c) || TextUtils.isEmpty(c.this.d.s)) {
                                    Bundle c = o.c(b.j.getLongitudeE6(), b.j.getLatitudeE6());
                                    com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = c.this.d;
                                    if (aVar2.c == null) {
                                        aVar2.c = c.getInt("MCx") + "," + c.getInt("MCy");
                                    }
                                    c cVar = c.this;
                                    com.baidu.navisdk.ugc.report.data.datastatus.a aVar3 = cVar.d;
                                    if (aVar3.b == null) {
                                        aVar3.b = aVar3.c;
                                    }
                                    String str = b.g;
                                    aVar3.s = str;
                                    cVar.d(aVar3.c, str);
                                    return;
                                }
                                return;
                            }
                            if (gVar.d()) {
                                gVar.e("SubContentPrensenter", "handleMessage: poi guide point == null or address == null");
                            }
                            com.baidu.navisdk.ugc.https.e.a(c.this.f, "10");
                            return;
                        }
                        return;
                    }
                    if (gVar.d()) {
                        gVar.e("SubContentPrensenter", "handleMessage: poi == null");
                    }
                    com.baidu.navisdk.ugc.https.e.a(c.this.f, "9");
                    return;
                }
                com.baidu.navisdk.ugc.https.e.a(c.this.f, "3");
            }
        }
    }

    public c(Context context, com.baidu.navisdk.ugc.report.ui.b bVar, e eVar, Handler handler, int i, boolean z) {
        this.e = true;
        this.f8267a = bVar;
        this.b = eVar;
        this.c = handler;
        this.f = i;
        this.e = z;
        bVar.a((com.baidu.navisdk.ugc.report.ui.b) this);
    }

    private void A() {
        com.baidu.navisdk.model.datastruct.g a2 = com.baidu.navisdk.ugc.utils.f.c.a();
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("SubContentPrensenter", "getCurrentPositionInfo: " + a2);
        }
        if (a2 != null) {
            GeoPoint c = a2.c();
            if (gVar.d()) {
                gVar.e("SubContentPrensenter", "getCurrentPositionInfo: " + c);
            }
            int i = 0;
            if (c != null) {
                if (com.baidu.navisdk.framework.a.c().a() == null || y.d(com.baidu.navisdk.framework.a.c().a())) {
                    i = 1;
                }
                com.baidu.navisdk.poisearch.c.a(c, i, 3000, this.g);
                return;
            }
            com.baidu.navisdk.util.worker.c.a().a(new a("UGC-" + getClass().getSimpleName(), null), new com.baidu.navisdk.util.worker.e(99, 0), 3000L);
            com.baidu.navisdk.ugc.https.e.a(this.f, "2");
            return;
        }
        com.baidu.navisdk.ugc.https.e.a(this.f, "1");
    }

    private void B() {
        com.baidu.navisdk.ugc.report.ui.b bVar;
        boolean z;
        if (this.d != null && (bVar = this.f8267a) != null) {
            if (x() && !w()) {
                z = false;
            } else {
                z = true;
            }
            bVar.a(z);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public Activity b() {
        return null;
    }

    @Override // com.baidu.navisdk.ugc.listener.a
    public void c(String str) {
    }

    public abstract void d(String str, String str2);

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public int e() {
        return this.f;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> f() {
        e eVar = this.b;
        if (eVar != null && eVar.g() != null) {
            return this.b.g();
        }
        return null;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> g() {
        e eVar = this.b;
        if (eVar != null && eVar.a() != null) {
            return this.b.a();
        }
        return null;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public String i() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.i();
        }
        return null;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> l() {
        e eVar = this.b;
        if (eVar != null && eVar.c() != null) {
            return this.b.c();
        }
        return null;
    }

    @Override // com.baidu.navisdk.ugc.listener.a
    public void m() {
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public int n() {
        return 0;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public int p() {
        e eVar = this.b;
        if (eVar != null) {
            return eVar.j();
        }
        return -1;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public boolean t() {
        if (this.f == 1) {
            return true;
        }
        return false;
    }

    public boolean w() {
        int i = this.f;
        if (i != 4 && i != 2 && i != 3 && i != 7) {
            return false;
        }
        return true;
    }

    public boolean x() {
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
        int i = aVar.e;
        if ((i != 40 && i != 2 && i != 15 && i != 47 && i != 46 && i != 48 && i != 12 && i != 45) || aVar.G != -1 || aVar.E != -1 || aVar.f != -1 || aVar.I != -1 || !TextUtils.isEmpty(aVar.h) || !TextUtils.isEmpty(this.d.n) || !TextUtils.isEmpty(this.d.i)) {
            return false;
        }
        return true;
    }

    public void y() {
        this.f8267a.onDestroy();
    }

    public void z() {
        com.baidu.navisdk.ugc.report.ui.b bVar = this.f8267a;
        if (bVar == null) {
            return;
        }
        bVar.g();
        if (this.e && this.c == null) {
            A();
        }
        B();
    }

    public void a(com.baidu.navisdk.ugc.report.ui.innavi.sub.b bVar) {
        this.f8267a = bVar;
    }

    public boolean c(int i) {
        com.baidu.navisdk.ugc.report.ui.b bVar;
        return com.baidu.navisdk.ugc.utils.a.a(i) || ((bVar = this.f8267a) != null && bVar.d(i));
    }

    public void a(int i, int i2, Intent intent) {
        if (com.baidu.navisdk.ugc.utils.a.a(i)) {
            com.baidu.navisdk.ugc.utils.a.a(i, i2, intent, this);
        } else {
            this.f8267a.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public void b(String str) {
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
        if (aVar != null) {
            aVar.h = str;
        }
        if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B != null && w()) {
            com.baidu.navisdk.ugc.report.ui.innavi.main.e.B.h = this.d.h;
        }
        B();
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public com.baidu.navisdk.ugc.report.data.datastatus.a c() {
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
        return aVar != null ? aVar : new com.baidu.navisdk.ugc.report.data.datastatus.a();
    }

    public void a(Configuration configuration) {
        z();
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = com.baidu.navisdk.ugc.report.ui.innavi.main.e.B;
        if (aVar != null) {
            String str = aVar.s;
            if (str != null) {
                d(null, str);
            }
            com.baidu.navisdk.ugc.report.ui.b bVar = this.f8267a;
            if (bVar != null) {
                bVar.onConfigurationChanged(configuration);
            }
            B();
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public void c(String str, String str2) {
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
        if (aVar != null) {
            aVar.a(str, str2);
            if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B == null || !w()) {
                return;
            }
            com.baidu.navisdk.ugc.report.ui.innavi.main.e.B.a(str, str2);
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public void b(String str, String str2) {
        if (this.d != null) {
            if (TextUtils.isEmpty(str)) {
                com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
                aVar.i = null;
                aVar.j = null;
                if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B != null && w()) {
                    com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = com.baidu.navisdk.ugc.report.ui.innavi.main.e.B;
                    aVar2.i = null;
                    aVar2.j = null;
                }
            } else {
                com.baidu.navisdk.ugc.report.data.datastatus.a aVar3 = this.d;
                aVar3.i = str;
                aVar3.j = str2;
                if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B != null && w()) {
                    com.baidu.navisdk.ugc.report.data.datastatus.a aVar4 = com.baidu.navisdk.ugc.report.ui.innavi.main.e.B;
                    com.baidu.navisdk.ugc.report.data.datastatus.a aVar5 = this.d;
                    aVar4.i = aVar5.i;
                    aVar4.j = aVar5.j;
                }
            }
        }
        B();
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public void a(int i, int i2) {
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar;
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar2;
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar3;
        switch (i2) {
            case 2000:
                if (l() != null && (aVar = this.d) != null) {
                    aVar.X = i;
                    aVar.b(this.b.b(i));
                    this.d.b("laneType change" + this.d.E);
                    if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B != null && w()) {
                        com.baidu.navisdk.ugc.report.ui.innavi.main.e.B.X = i;
                        break;
                    }
                } else {
                    return;
                }
                break;
            case 2001:
                if (f() != null && (aVar2 = this.d) != null) {
                    aVar2.f = this.b.e(i);
                    com.baidu.navisdk.ugc.report.data.datastatus.a aVar4 = this.d;
                    aVar4.Z = i;
                    if (aVar4.e == 15) {
                        aVar4.I = aVar4.f;
                        aVar4.f = -1;
                    }
                    if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B != null && w()) {
                        com.baidu.navisdk.ugc.report.ui.innavi.main.e.B.Z = i;
                        break;
                    }
                } else {
                    return;
                }
                break;
            case 2002:
                if (g() != null && (aVar3 = this.d) != null) {
                    aVar3.a(this.b.a(i));
                    com.baidu.navisdk.ugc.report.data.datastatus.a aVar5 = this.d;
                    aVar5.Y = i;
                    aVar5.b("detailType change" + this.d.G);
                    if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B != null && w()) {
                        com.baidu.navisdk.ugc.report.ui.innavi.main.e.B.Y = i;
                        break;
                    }
                } else {
                    return;
                }
                break;
        }
        B();
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public void a(String str, int i) {
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
        if (aVar != null) {
            if (!TextUtils.isEmpty(aVar.n)) {
                try {
                    com.baidu.navisdk.util.common.s.a(this.d.n);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(str)) {
                com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = this.d;
                aVar2.n = null;
                aVar2.W = -1;
                if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B != null && w()) {
                    com.baidu.navisdk.ugc.report.data.datastatus.a aVar3 = com.baidu.navisdk.ugc.report.ui.innavi.main.e.B;
                    aVar3.n = null;
                    aVar3.W = -1;
                }
            } else {
                com.baidu.navisdk.ugc.report.data.datastatus.a aVar4 = this.d;
                aVar4.n = str;
                aVar4.W = i;
                if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B != null && w()) {
                    com.baidu.navisdk.ugc.report.data.datastatus.a aVar5 = com.baidu.navisdk.ugc.report.ui.innavi.main.e.B;
                    com.baidu.navisdk.ugc.report.data.datastatus.a aVar6 = this.d;
                    aVar5.n = aVar6.n;
                    aVar5.W = aVar6.W;
                }
            }
        }
        B();
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public void a(String str) {
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
        if (aVar != null) {
            aVar.a(str);
        }
        if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B == null || !w()) {
            return;
        }
        com.baidu.navisdk.ugc.report.ui.innavi.main.e.B.a(str);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public void a(String str, String str2) {
        if (this.d != null) {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    this.d.S = String.format("%s|%s", str2, str);
                    return;
                } else {
                    this.d.S = String.format("|%s", str);
                    return;
                }
            }
            this.d.S = null;
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.a
    public void a(e.b bVar) {
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.d;
        if (aVar != null) {
            aVar.a(bVar);
            if (com.baidu.navisdk.ugc.report.ui.innavi.main.e.B != null && w()) {
                com.baidu.navisdk.ugc.report.ui.innavi.main.e.B.a(bVar);
            }
        }
        B();
    }
}
