package com.baidu.navisdk.ugc.https;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.j;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.baidu.navisdk.ugc.https.f;
import com.baidu.navisdk.ugc.video.d;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.o;
import com.baidu.navisdk.util.jar.JarUtils;
import com.garmin.fit.OxXXx0X;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.huawei.openalliance.ad.constant.x;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class e {

    /* loaded from: classes8.dex */
    public class b implements d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.ugc.https.c f8193a;

        public b(com.baidu.navisdk.ugc.https.c cVar, com.baidu.navisdk.ugc.report.data.datastatus.a aVar, boolean z, int i, String str, int i2, int i3, int i4) {
            this.f8193a = cVar;
        }

        @Override // com.baidu.navisdk.ugc.video.d.b
        public void a(int i) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule", "onVideoUploadFailed");
            com.baidu.navisdk.ugc.https.c cVar = this.f8193a;
            if (cVar != null) {
                cVar.a(JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.ugc.https.c f8195a;

        public d(com.baidu.navisdk.ugc.https.c cVar, com.baidu.navisdk.ugc.eventdetails.model.c cVar2, int i, String str, int i2) {
            this.f8195a = cVar;
        }

        @Override // com.baidu.navisdk.ugc.video.d.b
        public void a(int i) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule", "onVideoUploadFailed");
            com.baidu.navisdk.ugc.https.c cVar = this.f8195a;
            if (cVar != null) {
                cVar.a(JarUtils.getResources().getString(R.string.nsdk_string_ugc_detail_post_comment_fail));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class g implements com.baidu.navisdk.ugc.https.c {
        private g() {
        }

        public abstract void a(int i, String str);

        @Override // com.baidu.navisdk.ugc.https.c
        public void a(String str) {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    public static void a(String str, com.baidu.navisdk.ugc.https.b bVar, int i) {
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                bVar.a(str, true);
            }
        } else {
            com.baidu.navisdk.ugc.https.f f2 = com.baidu.navisdk.ugc.https.f.f();
            f2.e(com.baidu.navisdk.ugc.https.d.a(str));
            f2.a(com.baidu.navisdk.ugc.utils.c.d(i));
            com.baidu.navisdk.util.http.center.b.a().b(com.baidu.navisdk.util.http.b.d().b("getEventOnlineState"), f2.b(), new a(bVar, str), null);
        }
    }

    private static boolean b(com.baidu.navisdk.ugc.report.data.datastatus.a aVar, com.baidu.navisdk.ugc.https.c cVar, boolean z, int i, String str, int i2, int i3, int i4) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "ugcReport(), infoPackage = " + aVar + " isMayi = " + z + " reportFrom = " + i + " eventId = " + str + " ugcSupply = " + i2 + " eventPass = " + i3 + " vehicle = " + i4);
        }
        if (gVar.d()) {
            aVar.b("upload2");
        }
        com.baidu.navisdk.ugc.report.data.datastatus.a c2 = com.baidu.navisdk.ugc.report.data.datastatus.a.c(aVar);
        if (c2 == null) {
            gVar.e("UgcModule", "post ugc report new format ugcPackage == null");
            if (cVar == null) {
                return false;
            }
            cVar.a(JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail));
            return false;
        }
        if (gVar.d()) {
            c2.b("upload3");
        }
        com.baidu.navisdk.ugc.https.f f2 = com.baidu.navisdk.ugc.https.f.f();
        a(c2);
        f2.e(c2.f8263a);
        f2.C(c2.b);
        f2.r(c2.c);
        f2.a(c2.d);
        f2.b(i4);
        int a2 = com.baidu.navisdk.module.ugc.a.a(c2.e);
        f2.o(com.baidu.navisdk.ugc.https.d.a(a2));
        f2.x(com.baidu.navisdk.ugc.https.d.a(c2.f));
        f2.i(c2.g);
        f2.a(c2.h);
        f2.p(c2.j);
        f2.s(c2.k);
        f2.f(c2.l);
        f2.b(c2.m);
        f2.n(c2.s);
        f2.t(c2.t);
        f2.m(c2.u);
        f2.g(c2.w);
        f2.f(c2.v);
        f2.h(c2.y);
        f2.A(c2.x);
        f2.z(c2.C);
        f2.B(c2.B);
        f2.g(c2.E);
        f2.c(c2.G);
        f2.k(c2.I);
        f2.w(c2.J);
        f2.v(c2.L);
        f2.d(c2.K);
        f2.c(c2.M);
        f2.h(c2.N);
        f2.l(c2.O);
        f2.j(c2.P);
        f2.l(c2.Q);
        f2.y(c2.S);
        f2.u(c2.T);
        f2.m(i2);
        f2.d(i3);
        f2.e(com.baidu.navisdk.ugc.https.d.a(str));
        f2.D(c2.d());
        f2.k(c2.V);
        f2.i(c2.b0);
        f.a b2 = f.a.b();
        b2.b(c2.D);
        b2.a(c2.i);
        b2.c(c2.n);
        b2.a(c2.c(), f2);
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "ugc report: " + f2.c());
        }
        if (i4 == 3 && ((i == 2 || i == 7) && com.baidu.navisdk.module.ugc.a.b(aVar.e))) {
            String str2 = i == 2 ? "2" : "1";
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.9", str2, a2 + "", "");
        }
        b(c2);
        a(f2.a(), b2.a(), new c(cVar, i3, str, z, aVar, i));
        return true;
    }

    /* renamed from: com.baidu.navisdk.ugc.https.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0385e extends g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.ugc.https.c f8196a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0385e(com.baidu.navisdk.ugc.https.c cVar) {
            super(null);
            this.f8196a = cVar;
        }

        @Override // com.baidu.navisdk.ugc.https.e.g
        public void a(int i, String str) {
            com.baidu.navisdk.ugc.https.c cVar = this.f8196a;
            if (cVar != null) {
                if (i == 422) {
                    cVar.a(JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail_badwet));
                } else {
                    cVar.a(JarUtils.getResources().getString(R.string.nsdk_string_ugc_detail_post_comment_fail));
                }
            }
        }

        @Override // com.baidu.navisdk.ugc.https.c
        public void a(JSONObject jSONObject) {
            com.baidu.navisdk.ugc.https.c cVar = this.f8196a;
            if (cVar != null) {
                cVar.a(jSONObject);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.ugc.https.b f8192a;
        final /* synthetic */ String b;

        public a(com.baidu.navisdk.ugc.https.b bVar, String str) {
            this.f8192a = bVar;
            this.b = str;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_UgcReport", "asyncQueryEventIsOffline report on Failure status code: " + i + "; response:" + str);
            }
            com.baidu.navisdk.ugc.https.b bVar = this.f8192a;
            if (bVar != null) {
                bVar.a(this.b, true);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_UgcReport", "asyncQueryEventIsOffline ugc report on success: " + jSONObject);
                }
                if (jSONObject.getInt("errno") == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    boolean optBoolean = jSONObject2.optBoolean("online");
                    String optString = jSONObject2.optString("event_id");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.b;
                    }
                    com.baidu.navisdk.ugc.https.b bVar = this.f8192a;
                    if (bVar != null) {
                        bVar.a(optString, !optBoolean);
                        return;
                    }
                    return;
                }
                com.baidu.navisdk.ugc.https.b bVar2 = this.f8192a;
                if (bVar2 != null) {
                    bVar2.a(this.b, true);
                }
                if (gVar.d()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), jSONObject.toString());
                }
            } catch (Throwable unused) {
                com.baidu.navisdk.ugc.https.b bVar3 = this.f8192a;
                if (bVar3 != null) {
                    bVar3.a(this.b, false);
                }
                if (com.baidu.navisdk.util.common.g.UGC.d()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), i + "," + str);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f8197a;

        public f(g gVar) {
            this.f8197a = gVar;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.e()) {
                gVar.g("UgcModule_UgcReport", "ugc report on Failure status code: " + i + "; response:" + str);
            }
            g gVar2 = this.f8197a;
            if (gVar2 != null) {
                gVar2.a(422, null);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.e()) {
                gVar.g("UgcModule_UgcReport", "ugc report on success: " + str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("errno");
                if (i2 == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    g gVar2 = this.f8197a;
                    if (gVar2 != null) {
                        if (jSONObject2 == null) {
                            gVar2.a(10001, null);
                        } else {
                            gVar2.a(jSONObject2);
                        }
                    }
                } else {
                    g gVar3 = this.f8197a;
                    if (gVar3 != null) {
                        gVar3.a(i2, null);
                    }
                }
            } catch (Throwable th) {
                com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.UGC;
                if (gVar4.c()) {
                    gVar4.c("UgcModule_UgcReport", "onSuccess throwable:" + str + ", " + th.getMessage());
                }
                g gVar5 = this.f8197a;
                if (gVar5 != null) {
                    gVar5.a(10001, null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.ugc.https.c f8194a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ boolean d;
        final /* synthetic */ com.baidu.navisdk.ugc.report.data.datastatus.a e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.baidu.navisdk.ugc.https.c cVar, int i, String str, boolean z, com.baidu.navisdk.ugc.report.data.datastatus.a aVar, int i2) {
            super(null);
            this.f8194a = cVar;
            this.b = i;
            this.c = str;
            this.d = z;
            this.e = aVar;
            this.f = i2;
        }

        @Override // com.baidu.navisdk.ugc.https.e.g
        public void a(int i, String str) {
            String string;
            com.baidu.navisdk.ugc.https.c cVar = this.f8194a;
            if (cVar != null) {
                if (i == 422) {
                    cVar.a(JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail_badwet));
                    return;
                }
                if (i == 20001 && this.b == 0) {
                    com.baidu.navisdk.ugc.replenishdetails.d.o().b(this.c);
                    string = JarUtils.getResources().getString(R.string.nsdk_string_ugc_event_offline_hint);
                } else {
                    string = JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail);
                }
                this.f8194a.a(string);
            }
        }

        @Override // com.baidu.navisdk.ugc.https.c
        public void a(JSONObject jSONObject) {
            if (!this.d) {
                com.baidu.navisdk.ugc.replenishdetails.d.o().a(jSONObject, this.e, this.f);
            }
            if (this.f == 2) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_UgcReport", "data :" + jSONObject.toString());
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("help_info");
                TTSPlayerControl.playTTS((optJSONObject == null || !j.d()) ? "上报成功，感谢您的反馈" : optJSONObject.optString("broadcast_copy"), 1);
            }
            com.baidu.navisdk.ugc.https.c cVar = this.f8194a;
            if (cVar != null) {
                cVar.a(jSONObject);
            }
        }
    }

    public static boolean a(com.baidu.navisdk.ugc.report.data.datastatus.a aVar, com.baidu.navisdk.ugc.https.c cVar, int i, String str) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            if (cVar == null) {
                return false;
            }
            cVar.a((String) null);
            return false;
        }
        int a2 = com.baidu.navisdk.ugc.utils.c.a(i);
        com.baidu.navisdk.ugc.eventdetails.model.c cVar2 = new com.baidu.navisdk.ugc.eventdetails.model.c();
        cVar2.r(aVar.b);
        cVar2.j(aVar.c);
        cVar2.f(aVar.e);
        cVar2.g(aVar.h);
        cVar2.i(aVar.i);
        cVar2.h(aVar.s);
        e.b bVar = aVar.U;
        if (bVar != null) {
            cVar2.a(bVar.f8076a, bVar.b, bVar.c);
        }
        cVar2.b(aVar.E, aVar.F);
        cVar2.a(aVar.G, aVar.H);
        b(cVar2, a2, str, cVar, com.baidu.navisdk.module.vehiclemanager.b.i().b());
        return true;
    }

    public static boolean a(com.baidu.navisdk.ugc.report.data.datastatus.a aVar, com.baidu.navisdk.ugc.https.c cVar, boolean z, int i) {
        return a(aVar, cVar, z, i, null, -1, -1, com.baidu.navisdk.module.vehiclemanager.b.i().b());
    }

    public static boolean a(com.baidu.navisdk.ugc.report.data.datastatus.a aVar, com.baidu.navisdk.ugc.https.c cVar, boolean z, int i, String str) {
        int b2 = com.baidu.navisdk.module.vehiclemanager.b.i().b();
        if (!TextUtils.isEmpty(str) && !z) {
            if (aVar != null) {
                aVar.d = com.baidu.navisdk.ugc.utils.c.f(i);
            }
            return a(aVar, cVar, z, i, str, 1, 0, b2);
        }
        return a(aVar, cVar, z, i, null, -1, -1, b2);
    }

    private static boolean a(com.baidu.navisdk.ugc.report.data.datastatus.a aVar, com.baidu.navisdk.ugc.https.c cVar, boolean z, int i, String str, int i2, int i3, int i4) {
        if (aVar == null) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule", "post ugc report infoPackage == null");
            if (cVar == null) {
                return false;
            }
            cVar.a(JarUtils.getResources().getString(R.string.nsdk_string_ugc_report_fail));
            return false;
        }
        if (aVar.e()) {
            com.baidu.navisdk.ugc.video.d dVar = new com.baidu.navisdk.ugc.video.d();
            dVar.a(new b(cVar, aVar, z, i, str, i2, i3, i4));
            dVar.a(aVar.U);
            return true;
        }
        return b(aVar, cVar, z, i, str, i2, i3, i4);
    }

    private static void a(com.baidu.navisdk.ugc.eventdetails.model.c cVar, int i, String str, com.baidu.navisdk.ugc.https.c cVar2, int i2) {
        com.baidu.navisdk.ugc.https.f f2 = com.baidu.navisdk.ugc.https.f.f();
        f2.C(cVar.K());
        f2.r(cVar.v() == null ? "" : cVar.v());
        f2.a(i);
        f2.o(com.baidu.navisdk.ugc.https.d.a(cVar.P()));
        if (!TextUtils.isEmpty(cVar.o())) {
            f2.a(com.baidu.navisdk.ugc.https.d.a(cVar.o()));
        }
        f.a b2 = f.a.b();
        if (!TextUtils.isEmpty(cVar.u())) {
            cVar.a(cVar.u());
            b2.a(cVar.u());
        }
        f2.n(com.baidu.navisdk.ugc.https.d.a(cVar.s()));
        if (i == 21) {
            b(f2);
            a(f2);
        }
        f2.e(com.baidu.navisdk.ugc.https.d.a(str));
        f2.y(com.baidu.navisdk.ugc.https.d.a(cVar.D()));
        f2.D(cVar.L());
        f2.b(i2);
        com.baidu.navisdk.ugc.quickinput.tags.b bVar = cVar.M;
        if (bVar != null) {
            f2.g(bVar.b);
        }
        com.baidu.navisdk.ugc.quickinput.tags.b bVar2 = cVar.N;
        if (bVar2 != null) {
            f2.c(bVar2.b);
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_UgcReport", "post event detail comment: " + f2.c());
        }
        a(f2.a(), b2.a(), new C0385e(cVar2));
    }

    private static void a(com.baidu.navisdk.ugc.https.f fVar) {
        com.baidu.navisdk.model.modelfactory.f fVar2 = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        RoutePlanNode o = fVar2.o();
        if (o != null) {
            String c2 = o.c(o.getLongitudeE6() / 100000.0f, o.getLatitudeE6() / 100000.0f);
            String name = o.getName();
            String uid = o.getUID();
            fVar.g(c2);
            fVar.f(com.baidu.navisdk.ugc.https.d.a(name));
            fVar.h(uid);
        }
        RoutePlanNode g2 = fVar2.g();
        if (g2 != null) {
            String c3 = o.c(g2.getLongitudeE6() / 100000.0f, g2.getLatitudeE6() / 100000.0f);
            String name2 = g2.getName();
            String uid2 = g2.getUID();
            fVar.A(c3);
            fVar.z(com.baidu.navisdk.ugc.https.d.a(name2));
            fVar.B(uid2);
        }
    }

    public static void b(com.baidu.navisdk.ugc.eventdetails.model.c cVar, int i, String str, com.baidu.navisdk.ugc.https.c cVar2, int i2) {
        if (cVar == null) {
            com.baidu.navisdk.util.common.g.UGC.e("UgcModule", "post details comments model == null");
            if (cVar2 != null) {
                cVar2.a(JarUtils.getResources().getString(R.string.nsdk_string_ugc_detail_post_comment_fail));
                return;
            }
            return;
        }
        if (cVar.U()) {
            com.baidu.navisdk.ugc.video.d dVar = new com.baidu.navisdk.ugc.video.d();
            dVar.a(new d(cVar2, cVar, i, str, i2));
            dVar.a(cVar.P);
            return;
        }
        a(cVar, i, str, cVar2, i2);
    }

    private static void b(com.baidu.navisdk.ugc.https.f fVar) {
        Bundle bundle = new Bundle();
        BNRoutePlaner.getInstance().c(bundle);
        String string = bundle.getString("session");
        String string2 = bundle.getString("mrsl");
        fVar.t(string);
        fVar.m(string2);
    }

    private static void b(com.baidu.navisdk.ugc.report.data.datastatus.a aVar) {
        if (aVar == null) {
            return;
        }
        boolean a2 = a(aVar.c);
        boolean a3 = a(aVar.b);
        if (a2 || a3) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.c() && gVar.e()) {
                gVar.a("ugcReport point Exception", new Throwable());
            }
            String str = (a2 && a3) ? "3" : a2 ? "1" : "2";
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.b.1", aVar.d + "", "8", str);
        }
    }

    private static void a(HashMap<String, String> hashMap, com.baidu.navisdk.util.http.center.e eVar, g gVar) {
        com.baidu.navisdk.util.http.center.b.a().b(com.baidu.navisdk.util.http.b.d().b("UGCEventUpload"), hashMap, new f(gVar), eVar);
    }

    private static void a(com.baidu.navisdk.ugc.report.data.datastatus.a aVar) {
        if (com.baidu.navisdk.module.ugc.a.b(aVar.e)) {
            int i = aVar.G;
            switch (i) {
                case 3107:
                case 3108:
                case 3109:
                case OxXXx0X.f13062Oox /* 3110 */:
                case OxXXx0X.f13023OI0IXox /* 3111 */:
                case OxXXx0X.f13081X00IxOx /* 3112 */:
                    aVar.e = i;
                    aVar.G = -1;
                    return;
                default:
                    return;
            }
        }
    }

    public static void a(int i, String str) {
        a(i, str, "1");
    }

    public static void a(int i, String str, String str2) {
        com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.b.1", com.baidu.navisdk.ugc.utils.c.e(i) + "", str + "", str2);
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str) || str.contains(HelpFormatter.DEFAULT_OPT_PREFIX) || str.equals(x.dt);
    }
}
