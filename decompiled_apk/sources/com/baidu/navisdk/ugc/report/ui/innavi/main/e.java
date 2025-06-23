package com.baidu.navisdk.ugc.report.ui.innavi.main;

import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.mapframework.location.LocationChangeListener;
import com.baidu.mapframework.location.LocationManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.bean.m;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.ugc.f;
import com.baidu.navisdk.ugc.report.ui.innavi.sub.c;
import com.baidu.navisdk.ugc.utils.b;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.google.android.exoplayer2.ExoPlayer;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class e implements com.baidu.navisdk.ugc.report.ui.innavi.main.c {
    public static com.baidu.navisdk.ugc.report.data.datastatus.a B;
    private int A;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.ugc.report.ui.innavi.main.d f8284a;
    private i b;
    private Handler c;
    private final com.baidu.navisdk.ugc.report.data.datarepository.e e;
    private com.baidu.navisdk.ugc.report.data.datarepository.e f;
    private com.baidu.navisdk.ugc.report.data.datastatus.a g;
    private boolean h;
    private final j i;
    private Handler j;
    private s m;
    private c.e n;
    private int o;
    private int s;
    private com.baidu.navisdk.ugc.utils.b t;
    com.baidu.navisdk.ugc.report.ui.innavi.main.g u;
    private int v;
    private com.baidu.navisdk.ugc.replenishdetails.b w;
    private com.baidu.navisdk.ugc.report.ui.innavi.verifyevent.b x;
    private boolean z;
    private int d = 0;
    private boolean k = false;
    private boolean l = false;
    private com.baidu.navisdk.ugc.report.ui.innavi.sub.c p = null;
    private com.baidu.navisdk.ugc.report.ui.innavi.mayi.d q = null;
    private String r = null;
    private boolean y = false;

    /* loaded from: classes8.dex */
    public class a implements j {
        public a() {
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.e.j
        public void a(int i) {
            e.this.A = i;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            int i = message.what;
            if (i != 1003) {
                if (i == 2000) {
                    e.this.k = true;
                    e.this.n = (c.e) message.obj;
                }
            } else {
                if (message.arg1 == 0) {
                    com.baidu.navisdk.model.modelfactory.e eVar = (com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel");
                    e.this.m = eVar.b();
                    if (e.this.m != null && !TextUtils.isEmpty(e.this.m.g) && e.this.f8284a != null && e.this.g != null) {
                        e.this.g.s = e.this.m.g;
                    }
                }
                e.this.l = true;
            }
            if (e.this.k && e.this.l && e.this.m != null && e.this.n != null && e.this.g != null) {
                e.this.k = false;
                e.this.l = false;
                c.e eVar2 = e.this.n;
                String str2 = e.this.g.c;
                if (TextUtils.isEmpty(e.this.m.g)) {
                    str = "";
                } else {
                    str = e.this.m.g;
                }
                eVar2.a(str2, str);
                e.this.m = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements b.c {
        public c() {
        }

        @Override // com.baidu.navisdk.ugc.utils.b.c
        public void a(String str) {
            e.this.g.D = str;
            com.baidu.navisdk.ugc.report.data.datastatus.a aVar = e.B;
            if (aVar != null) {
                aVar.D = str;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements f.a {
        public d() {
        }

        @Override // com.baidu.navisdk.ugc.f.a
        public void a(@oOoXoXO String str, @oOoXoXO Bitmap bitmap) {
            e.this.g.D = str;
            com.baidu.navisdk.ugc.report.data.datastatus.a aVar = e.B;
            if (aVar != null) {
                aVar.D = str;
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.report.ui.innavi.main.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0396e extends Handler {
        public HandlerC0396e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1 || e.this.c == null) {
                return;
            }
            e.this.c.removeMessages(1);
            int i = message.arg1 - 1;
            if (i <= 0) {
                e.this.d(i);
                e.this.f8284a.c(i);
                if (e.this.v == 1) {
                    e.this.s();
                    return;
                } else {
                    e.this.a(true);
                    return;
                }
            }
            e.this.d(i);
            e.this.f8284a.c(i);
            e.this.c.sendMessageDelayed(e.this.c.obtainMessage(1, i, 0), 1000L);
        }
    }

    /* loaded from: classes8.dex */
    public class h implements b.c {
        public h() {
        }

        @Override // com.baidu.navisdk.ugc.utils.b.c
        public void a(String str) {
            e.this.g.D = str;
            e.this.J();
        }
    }

    /* loaded from: classes8.dex */
    public interface i {
        int a();

        void a(boolean z);

        ArrayList<View> b();

        void c();
    }

    /* loaded from: classes8.dex */
    public interface j {
        void a(int i);
    }

    public e(com.baidu.navisdk.ugc.report.ui.innavi.main.d dVar, com.baidu.navisdk.ugc.report.data.datarepository.e eVar, i iVar, int i2, boolean z) {
        this.g = null;
        this.u = null;
        this.f8284a = dVar;
        this.b = iVar;
        this.e = eVar;
        this.o = i2;
        this.z = z;
        a aVar = new a();
        this.i = aVar;
        this.g = new com.baidu.navisdk.ugc.report.data.datastatus.a();
        this.f8284a.a((com.baidu.navisdk.ugc.report.ui.innavi.main.d) this);
        this.u = new com.baidu.navisdk.ugc.report.ui.innavi.main.g(this.f8284a, this.g, this, aVar, this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        try {
            String str = this.g.D;
            if (str != null) {
                com.baidu.navisdk.util.common.s.a(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int F() {
        return com.baidu.navisdk.ugc.utils.c.e(this.o);
    }

    private String G() {
        LocationManager.LocData curLocation = LocationManager.getInstance().getCurLocation((LocationChangeListener.CoordType) null);
        if (curLocation != null) {
            if (this.g == null) {
                this.g = new com.baidu.navisdk.ugc.report.data.datastatus.a();
            }
            if (B == null) {
                B = new com.baidu.navisdk.ugc.report.data.datastatus.a();
            }
            this.g.s = curLocation.addr;
            s sVar = new s();
            this.m = sVar;
            sVar.g = curLocation.addr;
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLongitudeE6((int) curLocation.longitude);
            geoPoint.setLatitudeE6((int) curLocation.latitude);
            this.g.R = geoPoint;
            B.R = geoPoint;
            this.l = true;
            return ((int) curLocation.longitude) + "," + ((int) curLocation.latitude);
        }
        return "";
    }

    private String H() {
        int i2 = this.o;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return "0";
                    }
                    return "4";
                }
                return "3";
            }
            return "2";
        }
        return "1";
    }

    private void I() {
        if (this.j == null) {
            this.j = new b(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        i iVar;
        String H = H();
        if ("4".equals(H)) {
            H = "6";
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.1", H, this.g.e + "", null);
        if (this.o == 2 && (iVar = this.b) != null) {
            iVar.c();
        }
        if (!com.baidu.navisdk.j.d() && !d(false)) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail));
        }
        com.baidu.navisdk.ugc.https.e.a(this.g, new f(this.o, o()), this.h, this.o);
    }

    private void K() {
        TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "感谢您的反馈");
    }

    private void L() {
        if (this.c == null) {
            this.c = new HandlerC0396e(Looper.getMainLooper());
        }
        this.f8284a.c(10);
        this.c.removeMessages(1);
        Handler handler = this.c;
        handler.sendMessageDelayed(handler.obtainMessage(1, 10, 0), 1000L);
    }

    public void A() {
        i iVar = this.b;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void B() {
        if (this.f8284a == null) {
            return;
        }
        this.v = 0;
        f(false);
    }

    public void C() {
        Handler handler = this.c;
        if (handler != null) {
            handler.removeMessages(1);
            this.c = null;
        }
    }

    public void D() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.d dVar = this.f8284a;
        if (dVar != null && this.v == 0) {
            dVar.f();
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> k() {
        return this.e.e();
    }

    public boolean m() {
        return this.h;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public String o() {
        com.baidu.navisdk.ugc.report.data.datarepository.e eVar;
        String str = null;
        if (this.h) {
            com.baidu.navisdk.ugc.report.data.datarepository.e eVar2 = this.e;
            if (eVar2 == null) {
                return null;
            }
            return eVar2.d(this.A);
        }
        com.baidu.navisdk.ugc.report.data.datarepository.e eVar3 = this.e;
        if (eVar3 != null) {
            str = eVar3.c(this.A);
        }
        if (TextUtils.isEmpty(str) && (eVar = this.f) != null) {
            return eVar.c(this.A);
        }
        return str;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public com.baidu.navisdk.ugc.report.data.datarepository.e q() {
        return this.e;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public int r() {
        return this.o;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public void s() {
        i iVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "simpleUpload --> reportInfo: name = " + o() + ", type = " + this.g.e + ", point = " + this.g.c);
        }
        com.baidu.navisdk.ugc.https.d.a(this.g);
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.g;
        if (aVar.d <= 0) {
            aVar.d = F();
        }
        String H = H();
        if ("4".equals(H)) {
            H = "6";
        }
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = this.g;
        if (aVar2.e <= -1) {
            aVar2.e = this.s;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.1", H, this.g.e + "", null);
        if (this.o == 2 && (iVar = this.b) != null) {
            iVar.c();
        }
        com.baidu.navisdk.ugc.https.e.a(this.g, (com.baidu.navisdk.ugc.https.c) new g(this, this.o, o()), false, this.o);
        a(true);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> u() {
        if (this.o == 2) {
            return this.e.f();
        }
        return null;
    }

    public com.baidu.navisdk.ugc.report.ui.innavi.main.g w() {
        return this.u;
    }

    public void x() {
        C();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "simpleUpload --> reportInfo: name = " + o() + ", type = " + this.g.e + ", point = " + this.g.c);
        }
        com.baidu.navisdk.ugc.https.d.a(this.g);
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.g;
        if (aVar.d <= 0) {
            aVar.d = F();
        }
        if (this.g.D == null) {
            com.baidu.navisdk.ugc.utils.b bVar = this.t;
            if (bVar != null) {
                bVar.a();
            }
            new com.baidu.navisdk.ugc.utils.b().a(this.f8284a.c(), new h());
        } else {
            J();
        }
        a(true);
    }

    public boolean y() {
        com.baidu.navisdk.ugc.report.ui.innavi.mayi.d dVar = this.q;
        if (dVar != null) {
            dVar.w();
        }
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar = this.p;
        if (cVar != null) {
            cVar.B();
        }
        C();
        return false;
    }

    public void z() {
        this.y = true;
        g(false);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        Object obj = "null";
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDestroy: mSubPrensenter = ");
            Object obj2 = this.p;
            if (obj2 == null) {
                obj2 = "null";
            }
            sb.append(obj2);
            gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", sb.toString());
        }
        if (this.p != null) {
            if (gVar.d()) {
                gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "mSubPrensenter.onDestroy");
            }
            this.p.y();
            this.p = null;
        }
        if (gVar.d()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("UgcReportNaviMainPresenter.onDestroy: mMayiPresenter = ");
            Object obj3 = this.q;
            if (obj3 != null) {
                obj = obj3;
            }
            sb2.append(obj);
            gVar.e("UgcReportNaviMainPresenter", sb2.toString());
        }
        if (this.q != null) {
            if (gVar.d()) {
                gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "mMayiPresenter.onDestroy");
            }
            this.q.x();
        }
        C();
        B = null;
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.c = null;
        }
        this.d = 0;
        Handler handler2 = this.j;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.j = null;
        }
        com.baidu.navisdk.ugc.utils.b bVar = this.t;
        if (bVar != null) {
            bVar.a();
            this.t = null;
        }
        this.v = 0;
        this.x = null;
        this.b = null;
    }

    private void e(int i2) {
        this.A = i2;
        this.h = false;
        com.baidu.navisdk.ugc.report.ui.innavi.main.d dVar = this.f8284a;
        if (dVar != null) {
            dVar.a(i2);
        }
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.g;
        if (aVar != null) {
            aVar.e = i2;
            com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = B;
            aVar2.e = i2;
            aVar2.N = aVar.N;
        }
    }

    private void f(boolean z) {
        if (this.f8284a == null) {
            return;
        }
        C();
        this.f8284a.a(this.w);
        this.f8284a.a(this.o, false);
        this.v = 0;
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = B;
        if (aVar == null) {
            B = new com.baidu.navisdk.ugc.report.data.datastatus.a();
        } else if (!z) {
            aVar.a();
        }
        this.f8284a.g();
        L();
        this.f8284a.updateView(this.o);
    }

    private void g(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "setIsUserOperating: " + z + ", comeFrom: " + this.o);
        }
        int i2 = this.o;
        if (i2 == 2 || i2 == 4) {
            com.baidu.navisdk.ugc.d.a(z);
        }
    }

    public void c(boolean z) {
        if (z) {
            com.baidu.navisdk.ugc.utils.b bVar = this.t;
            if (bVar != null) {
                bVar.a();
            }
            com.baidu.navisdk.ugc.report.data.datastatus.a aVar = B;
            if (aVar != null) {
                aVar.D = null;
            }
            E();
        }
        i iVar = this.b;
        ArrayList<View> b2 = iVar != null ? iVar.b() : null;
        if (b2 != null && !b2.isEmpty()) {
            com.baidu.navisdk.ugc.utils.f.c.a(b2, 1, new d());
            return;
        }
        com.baidu.navisdk.ugc.utils.b bVar2 = new com.baidu.navisdk.ugc.utils.b();
        this.t = bVar2;
        bVar2.a(this.f8284a.c(), new c(), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public void d(int i2) {
        this.d = i2;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public int h() {
        return this.d;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public int j() {
        return this.v;
    }

    /* loaded from: classes8.dex */
    public class g extends com.baidu.navisdk.ugc.report.ui.innavi.a {
        public g(e eVar, int i, String str) {
            super(i, str);
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(JSONObject jSONObject) {
            super.a(jSONObject);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (!gVar.d() || jSONObject == null) {
                return;
            }
            gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "simpleUpload onUgcInfoReportUpLoadSuccess: " + jSONObject);
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(String str) {
            super.a(str);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "simpleUpload onUgcInfoReportUpLoadFail: " + str);
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public void b(boolean z) {
        if (B == null) {
            B = new com.baidu.navisdk.ugc.report.data.datastatus.a();
        }
        a(this.f8284a.d(), z, true, 1, this.r);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public ArrayList<com.baidu.navisdk.ugc.report.data.datarepository.b> d() {
        com.baidu.navisdk.ugc.report.data.datarepository.e eVar = this.f;
        if (eVar != null) {
            return eVar.e();
        }
        return null;
    }

    private boolean d(boolean z) {
        if (!z.a(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail_badwet));
            return false;
        }
        if (this.g == null) {
            this.g = new com.baidu.navisdk.ugc.report.data.datastatus.a();
        }
        I();
        int i2 = this.o;
        if (i2 != 4 && i2 != 7) {
            this.g.b = e(z);
        } else {
            this.g.b = G();
        }
        if (TextUtils.isEmpty(this.g.b)) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_open_gpc));
            return false;
        }
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar = B;
        com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = this.g;
        aVar.b = aVar2.b;
        aVar2.c = com.baidu.navisdk.ugc.https.d.b();
        B.c = this.g.c;
        return true;
    }

    public void a(com.baidu.navisdk.ugc.report.data.datarepository.e eVar) {
        this.f = eVar;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public void b(int i2) {
        if (!z.a(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), JarUtils.getResources().getString(R.string.ugc_network_not_available));
            return;
        }
        if (this.z) {
            com.baidu.navisdk.framework.message.a.a().a(new m("ugc_select_page", 28));
            Bundle bundle = new Bundle();
            bundle.putInt("bundle_event_type", i2);
            bundle.putInt("ugc_select_point_source", this.o);
            com.baidu.navisdk.module.page.a.b().a(28, bundle, this.f8284a.a());
            a(false);
            return;
        }
        if (d(true)) {
            com.baidu.navisdk.ugc.report.data.datarepository.e eVar = this.e;
            if (eVar != null && !eVar.f(i2)) {
                this.h = false;
                this.v = 1;
                C();
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.4", H(), i2 + "", null);
                B.e = i2;
                e(i2);
                L();
                return;
            }
            if (this.u != null) {
                C();
                this.u.a(i2);
                this.v = 3;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends com.baidu.navisdk.ugc.report.ui.innavi.a {
        public f(int i, String str) {
            super(i, str);
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(JSONObject jSONObject) {
            super.a(jSONObject);
            int i = -1;
            if (jSONObject != null) {
                try {
                    i = jSONObject.optInt("id", -1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            e.this.g.f8263a = i;
            com.baidu.navisdk.ugc.report.data.datarepository.g.c().a(e.this.g);
            e.this.E();
        }

        @Override // com.baidu.navisdk.ugc.report.ui.innavi.a, com.baidu.navisdk.ugc.https.c
        public void a(String str) {
            super.a(str);
            e.this.E();
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public void a(int i2, ImageView imageView) {
        if (imageView != null) {
            com.baidu.navisdk.ugc.utils.d.b(i2, imageView);
        }
    }

    public void a(String str, com.baidu.navisdk.ugc.report.data.datastatus.a aVar, boolean z, int i2) {
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("gotoReplenishDetailsView: ");
            sb.append(str);
            sb.append(", ");
            sb.append(aVar == null ? "null" : aVar.toString());
            gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", sb.toString());
        }
        if (!z) {
            if (TextUtils.isEmpty(str) || aVar == null) {
                return;
            }
            this.r = str;
            int i3 = aVar.e;
            this.s = i3;
            this.A = i3;
            if (B == null) {
                B = new com.baidu.navisdk.ugc.report.data.datastatus.a();
            }
            B.a(aVar);
            if (this.g == null) {
                this.g = new com.baidu.navisdk.ugc.report.data.datastatus.a();
            }
            this.g.a(aVar);
        }
        this.h = false;
        a(this.f8284a.d(), z, false, 2, str);
        if (z || (cVar = this.p) == null) {
            return;
        }
        cVar.e(i2);
    }

    private String e(boolean z) {
        com.baidu.navisdk.model.datastruct.g b2 = com.baidu.navisdk.ugc.utils.f.c.b();
        String str = "";
        if (b2 != null) {
            GeoPoint c2 = b2.c();
            if (this.g == null) {
                this.g = new com.baidu.navisdk.ugc.report.data.datastatus.a();
            }
            if (B == null) {
                B = new com.baidu.navisdk.ugc.report.data.datastatus.a();
            }
            this.g.R = c2;
            B.R = c2;
            Bundle b3 = o.b(b2.b, b2.f6926a);
            if (b3 != null) {
                str = b3.getInt("MCx") + "," + b3.getInt("MCy");
            }
            if (z && c2 != null) {
                com.baidu.navisdk.poisearch.c.a(c2, (com.baidu.navisdk.framework.a.c().a() == null || z.a(com.baidu.navisdk.framework.a.c().a())) ? 1 : 0, 3000, this.j);
            }
        }
        return str;
    }

    public boolean c(int i2) {
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar = this.p;
        return cVar != null && cVar.c(i2);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public void a(String str, int i2, String str2, boolean z, int i3) {
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar;
        if (!z) {
            if (B == null) {
                B = new com.baidu.navisdk.ugc.report.data.datastatus.a();
            }
            if (!d(false)) {
                a(true);
                return;
            }
            this.v = 2;
            this.h = false;
            this.A = i2;
            this.s = i2;
            this.r = str;
            com.baidu.navisdk.ugc.report.data.datastatus.a aVar = B;
            aVar.e = i2;
            aVar.s = str2;
            com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = this.g;
            if (aVar2 != null) {
                aVar2.e = i2;
                aVar2.s = str2;
            }
        }
        a(this.f8284a.d(), z, false, 3, str);
        if (z || (cVar = this.p) == null) {
            return;
        }
        cVar.e(i3);
    }

    public Activity b() {
        com.baidu.navisdk.ugc.report.ui.innavi.main.d dVar = this.f8284a;
        if (dVar == null) {
            return null;
        }
        return dVar.b();
    }

    private void a(ViewGroup viewGroup, boolean z, boolean z2, int i2, String str) {
        com.baidu.navisdk.ugc.report.data.datarepository.e h2;
        com.baidu.navisdk.ugc.report.data.datarepository.e eVar;
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar;
        if (viewGroup != null && !this.y) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "gotoUgcDetailsPanel isOrientateChange: " + z + ", isNeedGetPoint:" + z2 + ", detailsPanelType: " + i2 + ", eventId: " + str);
            }
            g(true);
            this.h = false;
            this.v = 2;
            this.r = str;
            C();
            com.baidu.navisdk.ugc.report.ui.innavi.sub.d dVar = new com.baidu.navisdk.ugc.report.ui.innavi.sub.d(this.f8284a.a(), this.f8284a.c(), i2);
            if (i2 == 4) {
                h2 = com.baidu.navisdk.ugc.report.data.datarepository.c.f(this.A);
            } else if (com.baidu.navisdk.module.ugc.a.b(this.A)) {
                h2 = com.baidu.navisdk.ugc.report.data.datarepository.c.g(this.A);
            } else {
                h2 = com.baidu.navisdk.ugc.report.data.datarepository.c.h(this.A);
            }
            com.baidu.navisdk.ugc.report.data.datarepository.e eVar2 = h2;
            if (z && (cVar = this.p) != null) {
                cVar.a(dVar);
                eVar = eVar2;
            } else {
                eVar = eVar2;
                this.p = new com.baidu.navisdk.ugc.report.ui.innavi.sub.c(this.f8284a.a(), eVar2, dVar, this, this.g, this.j, this.o, z2, i2, str);
            }
            this.p.d(this.o);
            dVar.a((com.baidu.navisdk.ugc.report.ui.a) this.p);
            View h3 = dVar.h();
            if (h3 != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(h3, new FrameLayout.LayoutParams(-1, -1));
                if (z) {
                    this.p.a((Configuration) null);
                    return;
                }
                this.p.z();
                if (eVar != null) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.5", H(), eVar.j() + "", null);
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
        if (gVar2.d()) {
            gVar2.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "gotoUgcDetailsPanel mMenuViewContainer: " + viewGroup + ", isOnDestroy:" + this.y);
        }
    }

    public void a(com.baidu.navisdk.ugc.report.ui.innavi.verifyevent.b bVar, boolean z) {
        if (bVar == null) {
            a(true);
            return;
        }
        if (!z) {
            this.v = 4;
            this.h = false;
            this.r = bVar.f8308a;
            this.s = bVar.b;
            C();
            this.x = bVar;
        }
        com.baidu.navisdk.ugc.report.ui.innavi.main.d dVar = this.f8284a;
        if (dVar != null ? dVar.a(bVar) : false) {
            return;
        }
        a(true);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public void a(boolean z, ViewGroup viewGroup) {
        com.baidu.navisdk.ugc.report.ui.innavi.mayi.d dVar;
        if (viewGroup == null) {
            return;
        }
        this.h = true;
        if (d(true)) {
            this.v = 3;
            C();
            c(z);
            if (B == null) {
                B = new com.baidu.navisdk.ugc.report.data.datastatus.a();
            }
            com.baidu.navisdk.ugc.report.ui.innavi.mayi.e eVar = new com.baidu.navisdk.ugc.report.ui.innavi.mayi.e(this.f8284a.a(), this.f8284a.c());
            if (z && (dVar = this.q) != null) {
                dVar.a(eVar);
            } else {
                this.q = new com.baidu.navisdk.ugc.report.ui.innavi.mayi.d(eVar, this.b, this.e, this.g, this, this.i, this.j);
            }
            eVar.a((com.baidu.navisdk.ugc.report.ui.innavi.mayi.b) this.q);
            View h2 = eVar.h();
            if (h2 != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(h2, new FrameLayout.LayoutParams(-1, -1));
                if (z) {
                    this.q.a((Configuration) null);
                } else {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.4", "2", "95", null);
                    this.q.y();
                }
            }
        }
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "finish: ");
        }
        if (this.b != null) {
            C();
            this.b.a(z);
        }
    }

    public void a(int i2, int i3, Intent intent) {
        com.baidu.navisdk.ugc.report.ui.innavi.mayi.d dVar;
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReportUgcReportNaviMainPresenter", "onActivityResult: " + i2 + "," + i3 + "," + this.h);
        }
        if (!this.h && (cVar = this.p) != null) {
            cVar.a(i2, i3, intent);
        }
        if (!this.h || (dVar = this.q) == null) {
            return;
        }
        dVar.a(i2, i3, intent);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public void a(String str, int i2, int i3) {
        if (i3 == 0) {
            com.baidu.navisdk.ugc.eventdetails.control.d.a(str, 4);
            a(true);
            K();
        } else if (i3 == 1) {
            com.baidu.navisdk.ugc.eventdetails.control.d.a(str, 3);
            a(true);
            K();
        } else {
            if (i3 != 2) {
                return;
            }
            com.baidu.navisdk.ugc.report.ui.innavi.verifyevent.b bVar = this.x;
            a(str, i2, bVar != null ? bVar.e : null, false, 5);
        }
    }

    public void a(int i2, ViewGroup viewGroup) {
        int i3 = this.v;
        if (i3 == 0) {
            f(true);
            return;
        }
        if (i3 == 1) {
            e(B.e);
            com.baidu.navisdk.ugc.report.data.datastatus.a aVar = this.g;
            com.baidu.navisdk.ugc.report.data.datastatus.a aVar2 = B;
            aVar.R = aVar2.R;
            aVar.b = aVar2.b;
            aVar.c = aVar2.c;
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                this.u.a(true);
                return;
            } else if (i3 != 4) {
                f(true);
                return;
            } else {
                a(this.x, true);
                return;
            }
        }
        com.baidu.navisdk.ugc.report.ui.innavi.sub.c cVar = this.p;
        if (cVar != null) {
            int j2 = cVar.j();
            if (j2 == 1) {
                b(true);
            } else if (j2 == 2) {
                a(this.r, null, true, 0);
            } else {
                if (j2 != 3) {
                    return;
                }
                a(this.r, this.s, B.s, true, 0);
            }
        }
    }

    public void a(com.baidu.navisdk.ugc.report.ui.innavi.main.f fVar) {
        this.f8284a = fVar;
    }

    public void a(com.baidu.navisdk.ugc.replenishdetails.b bVar) {
        this.w = bVar;
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public void a(String str, com.baidu.navisdk.ugc.report.data.datastatus.a aVar) {
        com.baidu.navisdk.ugc.replenishdetails.b bVar = this.w;
        if (bVar != null) {
            bVar.a(str, aVar, this.o);
        }
    }

    public void a(String str, Object obj, boolean z) {
        if (this.v != 0) {
            return;
        }
        if (z) {
            com.baidu.navisdk.ugc.report.ui.innavi.main.d dVar = this.f8284a;
            if (dVar != null) {
                dVar.e();
                return;
            }
            return;
        }
        a(str, (com.baidu.navisdk.ugc.report.data.datastatus.a) obj, false, 2);
    }

    @Override // com.baidu.navisdk.ugc.report.ui.innavi.main.c
    public int a() {
        i iVar = this.b;
        if (iVar != null) {
            return iVar.a();
        }
        return 0;
    }
}
