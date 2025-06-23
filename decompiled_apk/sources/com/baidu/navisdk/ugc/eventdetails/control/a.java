package com.baidu.navisdk.ugc.eventdetails.control;

import XXO0.oIX0oI;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.navisdk.cmdrequest.j;
import com.baidu.navisdk.comapi.mapcontrol.MapParams;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ugc.eventdetails.model.c;
import com.baidu.navisdk.ugc.eventdetails.model.e;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.TwoStateScrollView;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.MapItem;
import com.facebook.appevents.UserDataStore;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private TwoStateScrollView.DragState f8056a;
    private WeakReference<Context> b;
    private final com.baidu.navisdk.ugc.eventdetails.model.a c;
    private com.baidu.navisdk.ugc.eventdetails.interfaces.c d;
    private final com.baidu.navisdk.ugc.eventdetails.model.c e;
    private Handler f;
    private int g;
    private g h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private com.baidu.navisdk.ugc.eventdetails.control.f n;
    private com.baidu.navisdk.comapi.ugc.b o;
    private com.baidu.navisdk.comapi.ugc.a p;
    private long q;
    private boolean r;
    private com.baidu.navisdk.ugc.eventdetails.model.f s;
    private com.baidu.navisdk.ugc.eventdetails.model.b t;
    private boolean u;
    private boolean v;

    /* renamed from: com.baidu.navisdk.ugc.eventdetails.control.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class HandlerC0374a extends com.baidu.navisdk.util.worker.loop.a {
        public HandlerC0374a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "handleMessage: msg.what --> " + message.what + ", msg.arg1: " + message.arg1);
            }
            if (!a.this.u) {
                switch (message.what) {
                    case 1:
                        a.this.b(message);
                        return;
                    case 2:
                        a.this.a(message, true);
                        return;
                    case 3:
                        a.this.a(message);
                        return;
                    case 4:
                        a.this.d(message);
                        return;
                    case 5:
                        a.this.y();
                        return;
                    case 6:
                        a.this.c(message);
                        return;
                    case 7:
                        a.this.a(message, false);
                        return;
                    case 8:
                        a.this.g(message.arg1);
                        return;
                    case 9:
                        if (a.this.p != null && a.this.c.f != 7) {
                            a.this.p.a(a.this.c.a(a.this.d.g()), a.this.o);
                            return;
                        }
                        return;
                    case 10:
                        if (a.this.p != null && a.this.c.f != 7) {
                            if (a.this.c.f == 11) {
                                a.this.p.b(a.this.K());
                                return;
                            } else {
                                a.this.p.b(a.this.c.i());
                                return;
                            }
                        }
                        return;
                    case 11:
                        if (a.this.d != null) {
                            a.this.d.a(1, null, true);
                            a.this.d.f();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "onMessage is destroy");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.ugc.eventdetails.control.c {
        public b() {
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.c
        public void a() throws UnsupportedEncodingException {
            this.b.add(new i("event_id", a.this.c.f8066a));
            this.f8061a.append("event_id=");
            this.f8061a.append(URLEncoder.encode(a.this.c.f8066a, "utf-8"));
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "eventId decode  = " + JNIGuidanceControl.getInstance().uidCodecDecode(a.this.c.f8066a));
            }
            String a2 = com.baidu.navisdk.ugc.https.d.a(a.this.Q());
            this.b.add(new i("point", a2));
            this.f8061a.append("&point=");
            this.f8061a.append(URLEncoder.encode(a2, "utf-8"));
            this.b.add(new i("type", "" + a.this.c.c()));
            this.f8061a.append("&type=");
            this.f8061a.append(URLEncoder.encode(String.valueOf(a.this.c.c()), "utf-8"));
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            this.b.add(new i(UserDataStore.STATE, valueOf));
            this.f8061a.append("&st=");
            this.f8061a.append(URLEncoder.encode(valueOf, "utf-8"));
            int b = com.baidu.navisdk.ugc.utils.c.b(a.this.c.g);
            this.b.add(new i("business_trigger", "" + b));
            this.f8061a.append("&business_trigger=");
            this.f8061a.append(URLEncoder.encode(String.valueOf(b), "utf-8"));
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("UgcGetEventDetail");
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.ugc.eventdetails.control.c {
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;

        public c(String str, String str2, String str3, String str4, String str5) {
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.c
        public void a() throws UnsupportedEncodingException {
            this.b.add(new i("comment_id", this.c));
            this.f8061a.append("comment_id=");
            this.f8061a.append(URLEncoder.encode(this.c, "utf-8"));
            if (!TextUtils.isEmpty(this.d)) {
                this.b.add(new i("top_ids", this.d));
                this.f8061a.append("top_ids=");
                this.f8061a.append(URLEncoder.encode(this.d, "utf-8"));
            }
            if (!TextUtils.isEmpty(this.e)) {
                this.b.add(new i("good_ids", this.e));
                this.f8061a.append("good_ids=");
                this.f8061a.append(URLEncoder.encode(this.e, "utf-8"));
            }
            this.b.add(new i("event_id", this.f));
            this.f8061a.append("event_id=");
            this.f8061a.append(URLEncoder.encode(this.f, "utf-8"));
            this.b.add(new i("detail_id", this.g));
            this.f8061a.append("&detail_id=");
            this.f8061a.append(URLEncoder.encode(this.g, "utf-8"));
            int b = com.baidu.navisdk.ugc.utils.c.b(a.this.c.g);
            this.b.add(new i("business_trigger", "" + b));
            this.f8061a.append("&business_trigger=");
            this.f8061a.append(URLEncoder.encode(String.valueOf(b), "utf-8"));
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("getUgcNewCommentList");
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a();

        void a(Bundle bundle);
    }

    /* loaded from: classes8.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private static final a f8059a = new a(null);
    }

    /* loaded from: classes8.dex */
    public static abstract class g {
        public abstract Activity a();

        public abstract String a(String str);

        public abstract void a(int i, Bundle bundle);

        public boolean a(int i) {
            return false;
        }

        public int b() {
            return 0;
        }

        public boolean c() {
            return false;
        }

        public boolean d() {
            return true;
        }

        public boolean e() {
            return true;
        }

        public abstract void f();
    }

    public /* synthetic */ a(HandlerC0374a handlerC0374a) {
        this();
    }

    private void E() {
        com.baidu.navisdk.ugc.eventdetails.model.b bVar = this.t;
        if (bVar == null) {
            this.t = new com.baidu.navisdk.ugc.eventdetails.model.b();
        } else {
            bVar.a();
        }
        this.t.b = this.e.N();
        if (TextUtils.isEmpty(this.t.b)) {
            this.t.f8067a = com.baidu.navisdk.ugc.eventdetails.control.b.a(this.c.c());
        }
        this.t.c = this.e.P();
        this.t.d = this.e.O();
        com.baidu.navisdk.ugc.eventdetails.model.b bVar2 = this.t;
        bVar2.e = null;
        bVar2.g = q();
        this.t.h = this.e.w();
        this.t.i = this.e.j();
        this.t.f = this.e.x();
        com.baidu.navisdk.ugc.eventdetails.model.b bVar3 = this.t;
        com.baidu.navisdk.ugc.eventdetails.model.c cVar = this.e;
        bVar3.j = cVar.J;
        bVar3.k = cVar.p();
        c.d[] B = this.e.B();
        if (B != null && B.length > 0) {
            com.baidu.navisdk.ugc.eventdetails.model.b bVar4 = this.t;
            if (bVar4.l == null) {
                bVar4.l = new c.d();
            }
            this.t.l.a(B[0]);
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "data model after convert : " + this.t.toString());
        }
    }

    private boolean F() {
        return a((e) null);
    }

    private boolean G() {
        return b((e) null);
    }

    private void H() {
        boolean J;
        if (this.c.d() == 2) {
            int j = this.c.j();
            if (j == 2) {
                J = G();
            } else if (j == 3) {
                J = F();
            } else {
                J = J();
            }
            if (J) {
                com.baidu.navisdk.ugc.eventdetails.model.a aVar = this.c;
                if (aVar.k == 3 || aVar.e() == 1) {
                    E();
                }
            }
        }
    }

    public static a I() {
        return f.f8059a;
    }

    private boolean J() {
        return c((e) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle K() {
        String str;
        int i;
        Bundle bundle = new Bundle();
        bundle.putInt("page", this.c.g);
        com.baidu.navisdk.ugc.eventdetails.model.f fVar = this.s;
        if (fVar != null) {
            str = fVar.f8077a;
        } else {
            str = "";
        }
        bundle.putString("id", str);
        com.baidu.navisdk.ugc.eventdetails.model.f fVar2 = this.s;
        if (fVar2 != null) {
            i = fVar2.g;
        } else {
            i = 0;
        }
        bundle.putInt("iid", i);
        return bundle;
    }

    private int L() {
        com.baidu.navisdk.ugc.eventdetails.model.a aVar = this.c;
        int i = aVar.f;
        if (i != 7) {
            if (i != 8) {
                if (i != 9) {
                    if (aVar.o()) {
                        return 2;
                    }
                    return 3;
                }
                return 6;
            }
            return 5;
        }
        return 4;
    }

    private void M() {
        com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar = this.d;
        if (cVar instanceof com.baidu.navisdk.ugc.eventdetails.interfaces.b) {
            int i = this.g;
            if (i == 1) {
                ((com.baidu.navisdk.ugc.eventdetails.interfaces.b) cVar).b(true);
            } else if (i == 2) {
                ((com.baidu.navisdk.ugc.eventdetails.interfaces.b) cVar).b(false);
            }
        }
    }

    private void N() {
        if (this.f == null) {
            this.f = new HandlerC0374a("RCEDVC");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        com.baidu.navisdk.ugc.eventdetails.model.c cVar = this.e;
        cVar.b(cVar.d() + 1);
        e.a aVar = new e.a();
        aVar.g = this.e.o();
        aVar.f8075a = "现在";
        aVar.e = this.e.u();
        aVar.f = true;
        g gVar = this.h;
        String str = "百度地图热心用户";
        if (gVar != null) {
            str = gVar.a("百度地图热心用户");
        }
        aVar.c = str;
        if (aVar.p == null && this.e.U()) {
            aVar.p = new e.b();
        }
        if (this.e.U()) {
            aVar.p.a(this.e.P);
        }
        aVar.q = true;
        ArrayList arrayList = new ArrayList(2);
        com.baidu.navisdk.ugc.quickinput.tags.b bVar = this.e.M;
        if (bVar != null && bVar.a()) {
            arrayList.add(this.e.M.f8231a);
        }
        com.baidu.navisdk.ugc.quickinput.tags.b bVar2 = this.e.N;
        if (bVar2 != null && bVar2.a()) {
            arrayList.add(this.e.N.f8231a);
        }
        if (!arrayList.isEmpty()) {
            aVar.h = (String[]) arrayList.toArray(new String[0]);
        }
        this.e.a(aVar);
    }

    private boolean P() {
        if (TextUtils.isEmpty(this.e.O()) && TextUtils.isEmpty(this.e.j()) && TextUtils.isEmpty(this.e.w()) && TextUtils.isEmpty(this.e.J) && (this.e.p() == null || this.e.p().length <= 0)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q() {
        return this.c.m();
    }

    private void R() {
        com.baidu.navisdk.util.common.g.UGC.e("UgcModule_EventDetails", "resetUiFlags:  --> ");
        S();
    }

    private void S() {
        this.g = 0;
    }

    private void T() {
        int i;
        int c2 = this.c.c();
        int i2 = this.c.g;
        if (!com.baidu.navisdk.module.ugc.a.b(c2) && !this.c.q()) {
            int i3 = 4;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        i = 1;
                    } else {
                        i = 4;
                    }
                } else {
                    i = 3;
                }
            } else {
                i = 2;
            }
            int i4 = this.c.f;
            if (i4 != 13 && i4 != 7) {
                i3 = i4 != 8 ? i4 != 9 ? 1 : 3 : 2;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.6", i + "", i3 + "", c2 + "");
        }
    }

    private void U() {
        int i;
        com.baidu.navisdk.ugc.eventdetails.model.a aVar = this.c;
        int i2 = aVar.g;
        int i3 = 2;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    i = 1;
                } else {
                    i = 4;
                }
            } else {
                i = 3;
            }
        } else {
            i = 2;
        }
        int i4 = aVar.k;
        if (i4 != 3) {
            if (i4 != 4) {
                int L = L();
                if (!this.c.r()) {
                    i3 = 1;
                }
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2", "" + i, "" + L, "" + i3);
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.5", "2", "3", null);
            return;
        }
        if (aVar.f == 8) {
            i3 = 1;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.a", "" + i, "" + i3, null);
    }

    private void V() {
        String str;
        int i = 1;
        if (this.c.g == 1 && this.q > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = this.c.f;
            if (i2 != 8) {
                if (i2 == 9) {
                    i = 3;
                } else {
                    i = 2;
                }
            }
            com.baidu.navisdk.util.statistic.userop.b r = com.baidu.navisdk.util.statistic.userop.b.r();
            String str2 = "" + i;
            if (this.r) {
                str = "1";
            } else {
                str = "2";
            }
            r.a("3.u.c", str2, str, "" + ((currentTimeMillis - this.q) / 1000));
        }
    }

    public void A() {
        com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar = this.d;
        if (cVar != null) {
            cVar.onResume();
        }
    }

    public boolean B() {
        g gVar;
        if (this.c.n() && com.baidu.navisdk.ugc.utils.a.a(this.e.Q()) && (gVar = this.h) != null) {
            return gVar.a(6);
        }
        return false;
    }

    public void C() {
        com.baidu.navisdk.ugc.eventdetails.control.f fVar = this.n;
        if (fVar != null) {
            fVar.c();
        }
    }

    public boolean D() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "upload: isUploading --> " + this.l);
        }
        if (this.l) {
            return false;
        }
        this.l = true;
        com.baidu.navisdk.ugc.https.e.b(this.e, com.baidu.navisdk.ugc.utils.c.c(this.c.g), this.c.f8066a, new d(), com.baidu.navisdk.module.vehiclemanager.b.i().b());
        return true;
    }

    public com.baidu.navisdk.ugc.eventdetails.model.c k() {
        return this.e;
    }

    public boolean l() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "getTrafficLightData: isGettingOutline --> " + this.i);
        }
        if (this.i) {
            return true;
        }
        this.i = true;
        Handler handler = this.f;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(11, 500L);
            this.i = false;
            return true;
        }
        this.i = false;
        return false;
    }

    public int m() {
        int i = this.c.g;
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i != 3) {
            if (i != 8) {
                return 1;
            }
            return 7;
        }
        return 4;
    }

    public void n() {
        c.b bVar = new c.b();
        com.baidu.navisdk.ugc.eventdetails.model.c cVar = this.e;
        if (cVar != null) {
            cVar.a(bVar);
        }
    }

    public void o() {
        c.C0375c c0375c = new c.C0375c();
        com.baidu.navisdk.ugc.eventdetails.model.c cVar = this.e;
        if (cVar != null) {
            cVar.a(c0375c);
        }
    }

    public boolean p() {
        return this.k;
    }

    public boolean q() {
        g gVar = this.h;
        if (gVar != null && gVar.c()) {
            return false;
        }
        return this.c.p();
    }

    public boolean r() {
        g gVar = this.h;
        if (gVar != null) {
            return gVar.d();
        }
        return true;
    }

    public boolean s() {
        return this.v;
    }

    public boolean t() {
        g gVar = this.h;
        if (gVar != null && gVar.e()) {
            return true;
        }
        return false;
    }

    public boolean u() {
        return this.l;
    }

    public boolean v() {
        if (this.g != 0) {
            return true;
        }
        return false;
    }

    public boolean w() {
        com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar = this.d;
        if (cVar == null) {
            return false;
        }
        return cVar.onBackPressed();
    }

    public void x() {
        int i;
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "onClickAvoidCongestion: --> " + this.h);
        }
        g gVar2 = this.h;
        com.baidu.navisdk.ugc.eventdetails.model.a aVar = this.c;
        String str = aVar.f8066a;
        int i3 = aVar.g;
        int i4 = aVar.k;
        int i5 = aVar.c;
        int i6 = aVar.d;
        String str2 = aVar.e;
        if (i3 == 3) {
            if (gVar2 != null) {
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "onClickAvoidCongestion mEventId: --> " + str + ", mPage:" + com.baidu.navisdk.module.ugc.eventdetails.control.a.a(i3) + ", mPanleType:" + com.baidu.navisdk.module.ugc.eventdetails.control.a.b(i4));
                }
                if (i4 == 3) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                gVar2.a(i2, a(str, i5, i6, str2));
            }
            y();
            return;
        }
        y();
        if (gVar2 != null) {
            if (gVar.e()) {
                gVar.g("UgcModule_EventDetails", "onClickAvoidCongestion mEventId: --> " + str + ", mPage:" + com.baidu.navisdk.module.ugc.eventdetails.control.a.a(i3) + ", mPanleType:" + com.baidu.navisdk.module.ugc.eventdetails.control.a.b(i4));
            }
            if (i4 == 3) {
                i = 2;
            } else {
                i = 1;
            }
            gVar2.a(i, a(str, i5, i6, str2));
        }
    }

    public void y() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "BNRCEventDetailsViewController onDestroy:  --> ");
        }
        this.u = true;
        V();
        Handler handler = this.f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f = null;
        }
        com.baidu.navisdk.ugc.eventdetails.control.f fVar = this.n;
        if (fVar != null) {
            fVar.a();
            this.n = null;
        }
        com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar = this.d;
        if (cVar != null) {
            cVar.onDestroy();
            this.d = null;
        }
        com.baidu.navisdk.comapi.ugc.a aVar = this.p;
        if (aVar != null) {
            com.baidu.navisdk.ugc.eventdetails.model.a aVar2 = this.c;
            int i = aVar2.f;
            if (i == 11) {
                aVar.a(K());
            } else if (aVar2.g == 3 || i != 7) {
                aVar.a(aVar2.h());
            }
            this.p = null;
        }
        this.r = false;
        this.k = true;
        this.i = false;
        this.j = false;
        this.m = false;
        this.f8056a = TwoStateScrollView.DragState.BOTTOM;
        this.q = -1L;
        this.o = null;
        this.c.b();
        this.v = false;
        try {
            ArrayList<String> H = this.e.H();
            if (H != null && H.size() > 0) {
                Iterator<String> it = H.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    s.a(next);
                    this.e.b(next);
                }
            }
            if (this.e.u() != null && !this.l) {
                s.a(this.e.u());
            }
        } catch (Throwable unused) {
        }
        if (!this.l && this.e.U()) {
            this.e.P.b();
        }
        com.baidu.navisdk.ugc.eventdetails.model.c cVar2 = this.e;
        if (cVar2 != null) {
            cVar2.a();
        }
        g gVar2 = this.h;
        if (gVar2 != null) {
            gVar2.f();
            this.h = null;
        }
        this.s = null;
        this.t = null;
        this.b = null;
    }

    public void z() {
        com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar = this.d;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    private a() {
        this.f8056a = TwoStateScrollView.DragState.BOTTOM;
        this.f = null;
        this.g = 0;
        this.h = null;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = false;
        this.m = false;
        this.q = -1L;
        this.r = false;
        this.u = false;
        this.v = false;
        this.e = new com.baidu.navisdk.ugc.eventdetails.model.c();
        this.c = new com.baidu.navisdk.ugc.eventdetails.model.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        boolean J;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "getPanelDetailsOnlyFromEngine: " + i);
        }
        if (P()) {
            if (gVar.e()) {
                gVar.g("UgcModule_EventDetails", "getPanelDetailsOnlyFromEngine 数据已存在");
            }
            E();
            com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar = this.d;
            if (cVar != null) {
                cVar.a(1, null, true);
                this.d.f();
            }
            this.i = false;
            Handler handler = this.f;
            if (handler != null) {
                handler.sendEmptyMessage(9);
                return;
            }
            return;
        }
        if (i == 3) {
            J = F();
        } else if (i == 2) {
            J = G();
        } else {
            J = J();
        }
        if (J) {
            J = P();
        }
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "getPanelDetailsOnlyFromEngine result: " + J + "; " + this.c);
        }
        this.r = J;
        if (!J) {
            com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar2 = this.d;
            if (cVar2 != null) {
                cVar2.a(1, JarUtils.getResources().getString(R.string.nsdk_string_ugc_load_failed_try_again), false);
            }
            com.baidu.navisdk.ugc.eventdetails.model.a aVar = this.c;
            if (aVar != null) {
                a(aVar, false, aVar.c());
            }
        } else {
            this.q = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.e.O())) {
                this.e.t(JarUtils.getResources().getString(R.string.nsdk_string_ugc_jam_road_default_road_name));
            }
            this.e.s(null);
            c.d[] dVarArr = {new c.d()};
            c.d dVar = dVarArr[0];
            dVar.b = 2;
            dVar.f8071a = "百度地图大数据";
            this.e.a(dVarArr);
            E();
            com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar3 = this.d;
            if (cVar3 != null) {
                cVar3.a(1, null, true);
                this.d.f();
            }
        }
        this.i = false;
        Handler handler2 = this.f;
        if (handler2 != null) {
            handler2.sendEmptyMessage(9);
        }
    }

    public boolean e(int i) {
        com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar = this.d;
        return cVar != null && cVar.a(i);
    }

    public Context f() {
        WeakReference<Context> weakReference = this.b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int h() {
        g gVar = this.h;
        if (gVar != null) {
            return gVar.b();
        }
        return 0;
    }

    public com.baidu.navisdk.ugc.eventdetails.interfaces.c i() {
        return this.d;
    }

    public com.baidu.navisdk.ugc.eventdetails.model.b j() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.os.Message r9) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.eventdetails.control.a.b(android.os.Message):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        if (this.u || message == null || message.arg1 != 0) {
            return;
        }
        JSONObject jSONObject = (JSONObject) ((j) message.obj).b;
        try {
            if (jSONObject.getInt("errno") == 0) {
                int optInt = jSONObject.getJSONObject("data").optInt("new_comment_num");
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "handlerNewCommentNum new comment num: " + optInt);
                }
                if (this.e.R == 0 && optInt > 0) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.7", m() + "", null, null);
                }
                if (gVar.d()) {
                    gVar.e("UgcModule_EventDetails", "handlerNewCommentNum: " + this.u);
                }
                if (this.u) {
                    return;
                }
                com.baidu.navisdk.ugc.eventdetails.model.c cVar = this.e;
                if (optInt != cVar.R) {
                    cVar.R = optInt;
                    com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar2 = this.d;
                    if (cVar2 instanceof com.baidu.navisdk.ugc.eventdetails.interfaces.b) {
                        ((com.baidu.navisdk.ugc.eventdetails.interfaces.b) cVar2).a();
                        return;
                    }
                    return;
                }
                return;
            }
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.d()) {
                gVar2.e("UgcModule_EventDetails", "handlerNewCommentNum errmsg: " + jSONObject.optString("errmsg"));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar3.d()) {
                gVar3.e("UgcModule_EventDetails", "BNRCEventDetailsViewController handlerNewCommentNum jsonException: " + e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.os.Message r8) {
        /*
            r7 = this;
            com.baidu.navisdk.ugc.eventdetails.interfaces.c r0 = r7.d
            boolean r1 = r0 instanceof com.baidu.navisdk.ugc.eventdetails.interfaces.b
            if (r1 == 0) goto Lb
            com.baidu.navisdk.ugc.eventdetails.interfaces.b r0 = (com.baidu.navisdk.ugc.eventdetails.interfaces.b) r0
            r0.h()
        Lb:
            int r0 = r8.arg1
            r1 = 4
            r2 = 0
            r3 = 1
            java.lang.String r4 = "UgcModule_EventDetails"
            if (r0 != 0) goto L96
            java.lang.Object r8 = r8.obj     // Catch: java.lang.Exception -> L42
            com.baidu.navisdk.cmdrequest.j r8 = (com.baidu.navisdk.cmdrequest.j) r8     // Catch: java.lang.Exception -> L42
            java.lang.Object r8 = r8.b     // Catch: java.lang.Exception -> L42
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch: java.lang.Exception -> L42
            java.lang.String r0 = "errno"
            int r0 = r8.getInt(r0)     // Catch: java.lang.Exception -> L42
            if (r0 != 0) goto L65
            java.lang.String r0 = "data"
            org.json.JSONObject r0 = r8.getJSONObject(r0)     // Catch: java.lang.Exception -> L42
            boolean r0 = r7.a(r0, r3)     // Catch: java.lang.Exception -> L42
            if (r0 == 0) goto L57
            com.baidu.navisdk.ugc.eventdetails.model.c r0 = r7.e     // Catch: java.lang.Exception -> L42
            com.baidu.navisdk.ugc.eventdetails.model.c$b r0 = r0.e()     // Catch: java.lang.Exception -> L42
            if (r0 == 0) goto L44
            com.baidu.navisdk.ugc.eventdetails.model.c r0 = r7.e     // Catch: java.lang.Exception -> L42
            com.baidu.navisdk.ugc.eventdetails.model.c$b r0 = r0.e()     // Catch: java.lang.Exception -> L42
            r0.a(r8)     // Catch: java.lang.Exception -> L42
            goto L44
        L42:
            goto L88
        L44:
            com.baidu.navisdk.ugc.eventdetails.interfaces.c r8 = r7.d     // Catch: java.lang.Exception -> L42
            boolean r0 = r8 instanceof com.baidu.navisdk.ugc.eventdetails.interfaces.b     // Catch: java.lang.Exception -> L42
            if (r0 == 0) goto L55
            r0 = 0
            r8.a(r1, r0, r3)     // Catch: java.lang.Exception -> L42
            com.baidu.navisdk.ugc.eventdetails.interfaces.c r8 = r7.d     // Catch: java.lang.Exception -> L42
            com.baidu.navisdk.ugc.eventdetails.interfaces.b r8 = (com.baidu.navisdk.ugc.eventdetails.interfaces.b) r8     // Catch: java.lang.Exception -> L42
            r8.a()     // Catch: java.lang.Exception -> L42
        L55:
            r8 = 1
            goto Lba
        L57:
            com.baidu.navisdk.util.common.g r8 = com.baidu.navisdk.util.common.g.UGC     // Catch: java.lang.Exception -> L42
            boolean r0 = r8.d()     // Catch: java.lang.Exception -> L42
            if (r0 == 0) goto Lb9
            java.lang.String r0 = "MSG_BN_RC_COMMENTS: -->> error 330"
            r8.e(r4, r0)     // Catch: java.lang.Exception -> L42
            goto Lb9
        L65:
            java.lang.String r0 = "errmsg"
            java.lang.String r8 = r8.getString(r0)     // Catch: java.lang.Exception -> L42
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.UGC     // Catch: java.lang.Exception -> L42
            boolean r5 = r0.d()     // Catch: java.lang.Exception -> L42
            if (r5 == 0) goto Lb9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L42
            r5.<init>()     // Catch: java.lang.Exception -> L42
            java.lang.String r6 = "MSG_BN_RC_COMMENTS: -->> error 337, errMsg:"
            r5.append(r6)     // Catch: java.lang.Exception -> L42
            r5.append(r8)     // Catch: java.lang.Exception -> L42
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Exception -> L42
            r0.e(r4, r8)     // Catch: java.lang.Exception -> L42
            goto Lb9
        L88:
            com.baidu.navisdk.util.common.g r8 = com.baidu.navisdk.util.common.g.UGC
            boolean r0 = r8.c()
            if (r0 == 0) goto Lb9
            java.lang.String r0 = "MSG_BN_RC_COMMENTS: -->> error 344"
            r8.c(r4, r0)
            goto Lb9
        L96:
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.UGC
            boolean r5 = r0.c()
            if (r5 == 0) goto Lb9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "MSG_BN_RC_COMMENTS: -->> network ("
            r5.append(r6)
            int r8 = r8.arg1
            r5.append(r8)
            java.lang.String r8 = ")"
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            r0.c(r4, r8)
        Lb9:
            r8 = 0
        Lba:
            if (r8 != 0) goto Lc9
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.UGC
            boolean r5 = r0.d()
            if (r5 == 0) goto Lc9
            java.lang.String r5 = "BNRCEventDetailsViewController handlerRefreshComments failed"
            r0.e(r4, r5)
        Lc9:
            if (r8 != 0) goto Ldc
            com.baidu.navisdk.ugc.eventdetails.interfaces.c r8 = r7.d
            if (r8 == 0) goto Ldc
            android.content.res.Resources r0 = com.baidu.navisdk.util.jar.JarUtils.getResources()
            int r4 = com.baidu.navisdk.embed.R.string.nsdk_string_ugc_load_failed
            java.lang.String r0 = r0.getString(r4)
            r8.a(r1, r0, r2)
        Ldc:
            r7.j = r2
            r7.c(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.eventdetails.control.a.d(android.os.Message):void");
    }

    private void e(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (this.s == null) {
            this.s = new com.baidu.navisdk.ugc.eventdetails.model.f();
        }
        this.s.b(bundle.getInt("wdis", -1));
        this.s.c(bundle.getInt("wt", -1));
        this.s.d(bundle.getInt("pdis", -1));
        this.s.e(bundle.getInt("c", 0));
        this.s.g(bundle.getInt("wc", -1));
        this.s.f8077a = bundle.getString("id", "");
        this.s.f(bundle.getInt("iid", -1));
        this.t = this.s.a();
    }

    public void f(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "onClickTruckUgcBtn: " + i);
        }
        if (this.h != null) {
            Bundle bundle = new Bundle();
            bundle.putString("uid", this.c.u);
            bundle.putString("eventName", this.c.t);
            bundle.putDouble("x", this.c.r);
            bundle.putDouble("y", this.c.s);
            if (gVar.d()) {
                bundle.putString("event_id", this.c.f8066a);
                bundle.putInt(MapParams.PanoramaKeys.EVENT_TYPE, this.c.c());
            }
            this.h.a(i, bundle);
        }
    }

    public View a(Context context, g gVar, int i, boolean z) {
        Handler handler;
        com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar;
        com.baidu.navisdk.ugc.eventdetails.model.f fVar;
        this.u = false;
        this.h = gVar;
        if (context == null) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.c()) {
                gVar2.c("UgcModule_EventDetails", "getView: return null --> context == null");
            }
            return null;
        }
        if (!this.c.a()) {
            return null;
        }
        this.c.a(z);
        if (this.c.q() && ((fVar = this.s) == null || !fVar.b())) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar3.c()) {
                gVar3.c("UgcModule_EventDetails", "红绿灯详情面板 getView: return null：");
            }
            return null;
        }
        if (!z) {
            U();
            T();
        }
        R();
        this.b = new WeakReference<>(context);
        N();
        Handler handler2 = this.f;
        if (handler2 != null) {
            handler2.sendEmptyMessage(10);
        }
        if (z && (cVar = this.d) != null) {
            cVar.b(context, i);
        } else {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar4.d() && this.e != null) {
                gVar4.e("UgcModule_EventDetails", "getView: " + this.e);
            }
            com.baidu.navisdk.ugc.eventdetails.model.c cVar2 = this.e;
            if (cVar2 != null) {
                cVar2.a();
            }
            int e2 = this.c.e();
            if (gVar4.d()) {
                gVar4.e("UgcModule_EventDetails", "panelUIType = " + e2);
            }
            if (e2 == -1) {
                return null;
            }
            if (e2 == 1) {
                this.d = new com.baidu.navisdk.ugc.eventdetails.view.e(context, this.c, this);
            } else if (e2 == 2) {
                this.d = new com.baidu.navisdk.ugc.eventdetails.view.d(context, i, this.c, this);
            } else {
                this.d = new com.baidu.navisdk.ugc.eventdetails.view.f(context, i, this.c, this);
            }
        }
        if (this.d.e() == null && (handler = this.f) != null) {
            handler.sendEmptyMessage(5);
        }
        return this.d.e();
    }

    /* loaded from: classes8.dex */
    public class d implements com.baidu.navisdk.ugc.https.c {
        public d() {
        }

        @Override // com.baidu.navisdk.ugc.https.c
        public void a(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.e()) {
                gVar.g("UgcModule_EventDetails", "handleMessage: Error --> " + str);
            }
            if (a.this.b != null) {
                TipTool.onCreateToastDialog((Context) a.this.b.get(), str);
            }
            if (a.this.e.U()) {
                if (!TextUtils.isEmpty(a.this.e.P.d)) {
                    a.this.e.P.f8076a = a.this.e.P.d;
                }
                if (!TextUtils.isEmpty(a.this.e.P.e)) {
                    a.this.e.P.b = a.this.e.P.e;
                }
            }
            a.this.l = false;
        }

        @Override // com.baidu.navisdk.ugc.https.c
        public void a(JSONObject jSONObject) {
            if (a.this.b != null) {
                try {
                    TipTool.onCreateToastDialog((Context) a.this.b.get(), jSONObject.getString("tips"));
                    a.this.O();
                    if (a.this.d instanceof com.baidu.navisdk.ugc.eventdetails.interfaces.b) {
                        ((com.baidu.navisdk.ugc.eventdetails.interfaces.b) a.this.d).a();
                        ((com.baidu.navisdk.ugc.eventdetails.interfaces.b) a.this.d).b();
                    }
                    if (a.this.e.P != null) {
                        a.this.e.P.a();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (a.this.b != null) {
                        TipTool.onCreateToastDialog((Context) a.this.b.get(), JarUtils.getResources().getString(R.string.nsdk_string_ugc_detail_post_comment_fail));
                    }
                }
            }
            a.this.l = false;
        }
    }

    public com.baidu.navisdk.ugc.eventdetails.model.a e() {
        return this.c;
    }

    public boolean c(int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "getPanelDataFromEngine: isGettingOutline --> " + this.i);
        }
        if (this.i) {
            return true;
        }
        this.i = true;
        if (this.f != null) {
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "getPanelDataFromEngine: " + i);
            }
            Message obtainMessage = this.f.obtainMessage();
            obtainMessage.what = 8;
            obtainMessage.arg1 = i;
            this.f.sendMessageDelayed(obtainMessage, 500L);
            return true;
        }
        if (gVar.c()) {
            gVar.c("UgcModule_EventDetails", "getPanelDataFromEngine: " + i);
        }
        this.i = false;
        return false;
    }

    private void d(boolean z) {
        com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar = this.d;
        if (cVar instanceof com.baidu.navisdk.ugc.eventdetails.interfaces.b) {
            ((com.baidu.navisdk.ugc.eventdetails.interfaces.b) cVar).c(z);
        }
    }

    private void d(Bundle bundle) {
        String[] strArr;
        int i;
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "parseInterpretJamStructData: " + bundle);
        }
        this.e.l(bundle.getString("usPanoramaUrl", null));
        this.e.k(bundle.getString("usRCInfo", null));
        this.e.e(bundle.getString("usETAInfo", null));
        String string = bundle.getString("usCongestType", null);
        int i3 = !TextUtils.isEmpty(string) ? 1 : 0;
        String string2 = bundle.getString("usTurnExplan", null);
        if (!TextUtils.isEmpty(string2)) {
            i3++;
        }
        this.e.K = bundle.getString("usHasJamedTime", null);
        String string3 = bundle.getString("usJamPassTime", null);
        String[] p = this.e.p();
        if (p != null && p.length != 0) {
            i = p.length;
            strArr = new String[i3 + i];
            System.arraycopy(p, 0, strArr, 0, i);
        } else {
            strArr = new String[i3];
            i = 0;
        }
        if (TextUtils.isEmpty(string)) {
            i2 = 0;
        } else {
            strArr[i] = string;
            i2 = 1;
        }
        if (!TextUtils.isEmpty(string2)) {
            strArr[i + i2] = string2;
        }
        this.e.a(strArr);
        boolean isEmpty = TextUtils.isEmpty(this.e.K);
        boolean isEmpty2 = TextUtils.isEmpty(string3);
        if (!isEmpty && !isEmpty2) {
            com.baidu.navisdk.ugc.eventdetails.model.c cVar = this.e;
            cVar.J = String.format("%s，%s", cVar.K, string3);
        } else if (!isEmpty) {
            com.baidu.navisdk.ugc.eventdetails.model.c cVar2 = this.e;
            cVar2.J = cVar2.K;
        } else if (!isEmpty2) {
            this.e.J = string3;
        } else {
            this.e.J = null;
        }
        String O = this.e.O();
        if (TextUtils.isEmpty(O) || O.contains("当前道路")) {
            String string4 = bundle.getString("usRoadName", null);
            if (!TextUtils.isEmpty(string4)) {
                this.e.t(string4);
            }
        }
        long j = bundle.getLong("chatId");
        if (j != 0) {
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "chatId from engine is " + j);
            }
            this.c.x = String.valueOf(j);
        }
        b(bundle);
        if (gVar.e()) {
            gVar.g("UgcModule", "getInterpretJamDataFromEngine rc:" + this.e.w() + ",eta:" + this.e.j() + ",congestionTime:" + this.e.J + ",labels:" + Arrays.toString(this.e.p()) + ", jamPassTime" + string3);
        }
    }

    public void a(com.baidu.navisdk.comapi.ugc.a aVar) {
        this.p = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        JSONObject jSONObject;
        if (message.arg1 == 0) {
            try {
                jSONObject = (JSONObject) ((j) message.obj).b;
            } catch (Exception unused) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.c()) {
                    gVar.c("UgcModule_EventDetails", "MSG_BN_RC_COMMENTS: -->> error 344");
                }
            }
            if (jSONObject.getInt("errno") == 0) {
                if (a(jSONObject.getJSONObject("data"), false)) {
                    if (this.e.e() != null) {
                        this.e.e().a(jSONObject);
                    }
                    com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar = this.d;
                    if (cVar instanceof com.baidu.navisdk.ugc.eventdetails.interfaces.b) {
                        cVar.a(3, null, true);
                        ((com.baidu.navisdk.ugc.eventdetails.interfaces.b) this.d).a();
                    }
                    this.j = false;
                    c(true);
                }
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
                if (gVar2.c()) {
                    gVar2.c("UgcModule_EventDetails", "MSG_BN_RC_COMMENTS: -->> error 330");
                }
            } else {
                String string = jSONObject.getString("errmsg");
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.UGC;
                if (gVar3.e()) {
                    gVar3.g("UgcModule_EventDetails", "MSG_BN_RC_COMMENTS: -->> error 337, errMsg:" + string);
                }
            }
        } else {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar4.d()) {
                gVar4.e("UgcModule_EventDetails", "MSG_BN_RC_COMMENTS: -->> network (" + message.arg1 + oIX0oI.I0Io.f4095I0Io);
            }
        }
        com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar2 = this.d;
        if (cVar2 != null) {
            cVar2.a(3, JarUtils.getResources().getString(R.string.nsdk_string_ugc_load_failed_try_again), false);
        }
        this.j = false;
        c(true);
    }

    private boolean c(e eVar) {
        int i = 2;
        com.baidu.navisdk.ugc.eventdetails.model.a aVar = this.c;
        if (aVar.g != 4 && (!TextUtils.isEmpty(aVar.f8066a) || this.c.c >= 0)) {
            try {
                Bundle bundle = new Bundle();
                a(bundle);
                com.baidu.navisdk.ugc.eventdetails.model.a aVar2 = this.c;
                int i2 = aVar2.k;
                if (i2 == 2) {
                    i = 3;
                } else if (i2 == 3) {
                    i = 1;
                }
                bundle.putBoolean("onRoute", aVar2.o());
                bundle.putInt("jamVer", this.c.d);
                bundle.putInt("jamIdx", this.c.c);
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
                if (gVar.e()) {
                    gVar.g("UgcModule_EventDetails", "getInterpretJamDataFromEngine getRouteInfoInUniform: " + bundle);
                }
                BNRouteGuider.getInstance().getRouteInfoInUniform(16, i, bundle);
                if (gVar.e()) {
                    gVar.g("UgcModule_EventDetails", "getInterpretJamDataFromEngine bundle: " + bundle);
                }
                d(bundle);
                if (eVar != null) {
                    eVar.a(bundle);
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
                if (gVar2.c()) {
                    gVar2.c("UgcModule", "getInterpretJamDataFromEngine eventId" + this.c.f8066a + " " + th.getMessage());
                }
                if (eVar != null) {
                    eVar.a();
                }
                return false;
            }
        }
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.UGC;
        if (gVar3.e()) {
            Locale locale = Locale.getDefault();
            com.baidu.navisdk.ugc.eventdetails.model.a aVar3 = this.c;
            gVar3.g("UgcModule_EventDetails", String.format(locale, "getInterpretJamDataFromEngine  eventId is %s, source is %d, linkIndex is %d", aVar3.f8066a, Integer.valueOf(aVar3.f), Integer.valueOf(this.c.c)));
        }
        return false;
    }

    public TwoStateScrollView.DragState g() {
        return this.f8056a;
    }

    private void b(Bundle bundle) {
        if (this.o == null) {
            this.o = new com.baidu.navisdk.comapi.ugc.b();
        }
        this.o.f6758a = bundle.getDouble("usBoundTop", -1.0d);
        this.o.b = bundle.getDouble("usBoundBottom", -1.0d);
        this.o.c = bundle.getDouble("usBoundLeft", -1.0d);
        this.o.d = bundle.getDouble("usBoundRight", -1.0d);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule", "parseBound:" + this.o.toString());
        }
        if (this.o.a()) {
            return;
        }
        this.o = null;
    }

    public boolean b() {
        String str;
        String str2 = "" + this.e.k();
        String str3 = "" + this.e.h();
        if (this.e.V()) {
            str = "0";
        } else {
            str = "" + this.e.q();
        }
        return a(str, this.e.G(), this.e.n(), str2, str3, 3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00a7 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.os.Message r7, boolean r8) {
        /*
            r6 = this;
            int r0 = r7.arg1
            java.lang.String r1 = "UgcModule_EventDetails"
            r2 = 2
            r3 = 0
            if (r0 != 0) goto L70
            java.lang.Object r7 = r7.obj     // Catch: java.lang.Exception -> L2f
            com.baidu.navisdk.cmdrequest.j r7 = (com.baidu.navisdk.cmdrequest.j) r7     // Catch: java.lang.Exception -> L2f
            java.lang.Object r7 = r7.b     // Catch: java.lang.Exception -> L2f
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch: java.lang.Exception -> L2f
            java.lang.String r0 = "errno"
            int r7 = r7.getInt(r0)     // Catch: java.lang.Exception -> L2f
            if (r7 != 0) goto L31
            com.baidu.navisdk.ugc.eventdetails.interfaces.c r7 = r6.d     // Catch: java.lang.Exception -> L2f
            if (r7 == 0) goto La4
            r0 = 0
            r4 = 1
            r7.a(r2, r0, r4)     // Catch: java.lang.Exception -> L28
            if (r8 == 0) goto L2a
            r6.M()     // Catch: java.lang.Exception -> L28
            goto La5
        L28:
            goto L51
        L2a:
            r6.d(r4)     // Catch: java.lang.Exception -> L28
            goto La5
        L2f:
            goto L50
        L31:
            com.baidu.navisdk.util.common.g r7 = com.baidu.navisdk.util.common.g.UGC     // Catch: java.lang.Exception -> L2f
            boolean r0 = r7.c()     // Catch: java.lang.Exception -> L2f
            if (r0 == 0) goto L3e
            java.lang.String r0 = "MSG_BN_RC_EVENT_FEEDBACK: -->> error 283"
            r7.c(r1, r0)     // Catch: java.lang.Exception -> L2f
        L3e:
            com.baidu.navisdk.ugc.eventdetails.interfaces.c r7 = r6.d     // Catch: java.lang.Exception -> L2f
            if (r7 == 0) goto La4
            android.content.res.Resources r0 = com.baidu.navisdk.util.jar.JarUtils.getResources()     // Catch: java.lang.Exception -> L2f
            int r4 = com.baidu.navisdk.embed.R.string.nsdk_string_ugc_load_failed     // Catch: java.lang.Exception -> L2f
            java.lang.String r0 = r0.getString(r4)     // Catch: java.lang.Exception -> L2f
            r7.a(r2, r0, r3)     // Catch: java.lang.Exception -> L2f
            goto La4
        L50:
            r4 = 0
        L51:
            com.baidu.navisdk.util.common.g r7 = com.baidu.navisdk.util.common.g.UGC
            boolean r0 = r7.c()
            if (r0 == 0) goto L5e
            java.lang.String r0 = "MSG_BN_RC_EVENT_FEEDBACK: -->> error 289"
            r7.c(r1, r0)
        L5e:
            com.baidu.navisdk.ugc.eventdetails.interfaces.c r7 = r6.d
            if (r7 == 0) goto La5
            android.content.res.Resources r0 = com.baidu.navisdk.util.jar.JarUtils.getResources()
            int r1 = com.baidu.navisdk.embed.R.string.nsdk_string_ugc_load_failed
            java.lang.String r0 = r0.getString(r1)
            r7.a(r2, r0, r3)
            goto La5
        L70:
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.UGC
            boolean r4 = r0.c()
            if (r4 == 0) goto L93
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "MSG_BN_RC_EVENT_FEEDBACK: -->> network ("
            r4.append(r5)
            int r7 = r7.arg1
            r4.append(r7)
            java.lang.String r7 = ")"
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            r0.c(r1, r7)
        L93:
            com.baidu.navisdk.ugc.eventdetails.interfaces.c r7 = r6.d
            if (r7 == 0) goto La4
            android.content.res.Resources r0 = com.baidu.navisdk.util.jar.JarUtils.getResources()
            int r1 = com.baidu.navisdk.embed.R.string.nsdk_string_ugc_network_error
            java.lang.String r0 = r0.getString(r1)
            r7.a(r2, r0, r3)
        La4:
            r4 = 0
        La5:
            if (r4 != 0) goto Lac
            if (r8 != 0) goto Lac
            r6.d(r3)
        Lac:
            r6.S()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.eventdetails.control.a.a(android.os.Message, boolean):void");
    }

    private void c(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "parseCommonPanelData: " + bundle);
        }
        if (!this.c.k()) {
            String string = bundle.getString("panelTitle", null);
            String string2 = bundle.getString("panelRoad", null);
            String string3 = bundle.getString("panelContent", null);
            String string4 = bundle.getString("usPanoramaUrl", null);
            if (!TextUtils.isEmpty(string)) {
                this.e.t(string);
            }
            if (!TextUtils.isEmpty(string4)) {
                this.e.l(string4);
            }
            if (!TextUtils.isEmpty(string2)) {
                this.e.k(string2);
            }
            if (!TextUtils.isEmpty(string3)) {
                this.e.J = string3;
            }
        } else {
            com.baidu.navisdk.ugc.eventdetails.model.a aVar = this.c;
            if (aVar.f == 13) {
                aVar.r = bundle.getDouble("x");
                this.c.s = bundle.getDouble("y");
            }
        }
        if (this.e.P() <= 0) {
            this.e.f(this.c.c());
        }
        long j = bundle.getLong("chatId");
        if (j != 0) {
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "chatId from engine is " + j);
            }
            this.c.x = String.valueOf(j);
        }
        b(bundle);
    }

    public void b(boolean z) {
        if (z) {
            this.g = 1;
        } else {
            this.g = 2;
        }
    }

    public View b(int i) {
        if (!(this.d instanceof com.baidu.navisdk.ugc.eventdetails.interfaces.b) || f() == null) {
            return null;
        }
        return ((com.baidu.navisdk.ugc.eventdetails.interfaces.b) this.d).a(f(), i);
    }

    private boolean b(e eVar) {
        try {
            Bundle bundle = new Bundle();
            a(bundle);
            bundle.putBoolean("onRoute", this.c.o());
            int i = this.c.k;
            int i2 = i != 2 ? i != 3 ? 2 : 1 : 3;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.e()) {
                gVar.g("UgcModule_EventDetails", "getCommonPanelDataFromEngine getRouteInfoInUniform: " + bundle);
            }
            BNRouteGuider.getInstance().getRouteInfoInUniform(30, i2, bundle);
            if (gVar.e()) {
                gVar.g("UgcModule_EventDetails", "getCommonPanelDataFromEngine bundle: " + bundle);
            }
            c(bundle);
            if (eVar != null) {
                eVar.a(bundle);
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.c()) {
                gVar2.c("UgcModule", "getCommonPanelDataFromEngine yellowId" + this.c.o + " " + th.getMessage());
            }
            if (eVar == null) {
                return false;
            }
            eVar.a();
            return false;
        }
    }

    public Activity d() {
        if (f() instanceof Activity) {
            return (Activity) this.b.get();
        }
        g gVar = this.h;
        if (gVar != null) {
            return gVar.a();
        }
        return null;
    }

    public void d(int i) {
        com.baidu.navisdk.ugc.eventdetails.model.f fVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            StringBuilder sb = new StringBuilder();
            sb.append("hideTrafficLightPanel lightId: ");
            sb.append(i);
            sb.append(", mPanelType: ");
            sb.append(this.c.k);
            sb.append(", ");
            com.baidu.navisdk.ugc.eventdetails.model.f fVar2 = this.s;
            sb.append(fVar2 != null ? fVar2.toString() : "null");
            gVar.g("UgcModule_EventDetails", sb.toString());
        }
        if (this.c.k == 4 && (fVar = this.s) != null && fVar.a(i)) {
            y();
        }
    }

    public boolean a() {
        com.baidu.navisdk.ugc.eventdetails.model.c cVar = this.e;
        if (cVar != null && cVar.t() != null && this.e.t().b() != null) {
            Handler handler = this.f;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = new j(null, this.e.t().b());
                obtainMessage.what = 1;
                this.f.sendMessage(obtainMessage);
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "asyncGetRCEventDetailsData: --> json data existed");
            }
            return true;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
        if (gVar2.e()) {
            gVar2.g("UgcModule_EventDetails", "asyncGetRCEventDetailsData: isGettingOutline --> " + this.i);
        }
        if (this.i) {
            return true;
        }
        this.i = true;
        new b().a(this.f, 1);
        return false;
    }

    public boolean c() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.2.8", m() + "", null, null);
        return a("0", null, null, "" + this.e.k(), "" + this.e.h(), 4, true);
    }

    public void c(boolean z) {
        Handler handler = this.f;
        if (handler == null) {
            return;
        }
        if (z && this.n == null) {
            this.n = new com.baidu.navisdk.ugc.eventdetails.control.f(handler, this.e.h(), this.e.k(), this.e.b());
        }
        com.baidu.navisdk.ugc.eventdetails.control.f fVar = this.n;
        if (fVar != null) {
            fVar.a(this.e.b());
        }
        com.baidu.navisdk.ugc.eventdetails.control.f fVar2 = this.n;
        if (fVar2 != null) {
            fVar2.b();
        }
    }

    public void a(com.baidu.navisdk.ugc.https.c cVar) {
        if (this.m) {
            return;
        }
        this.m = true;
        com.baidu.navisdk.ugc.https.a.f8185a.a(this.c.f8066a, cVar);
    }

    private boolean a(String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        com.baidu.navisdk.ugc.eventdetails.model.c cVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "asyncGetCommentsData: firstPage --> " + this.e.V());
        }
        if (!this.j) {
            C();
        }
        com.baidu.navisdk.ugc.eventdetails.model.c cVar2 = this.e;
        cVar2.R = 0;
        if (cVar2.V() && !z && (cVar = this.e) != null && cVar.e() != null && this.e.e().a() != null) {
            Handler handler = this.f;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = new j(null, this.e.e().a());
                obtainMessage.what = i;
                this.f.sendMessage(obtainMessage);
            }
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetails", "asyncGetCommentsData: --> json data existed");
            }
            return true;
        }
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "asyncGetCommentsData: isGettingComments --> " + this.j);
        }
        if (this.j) {
            return true;
        }
        this.j = true;
        new c(str, str2, str3, str4, str5).a(this.f, i);
        return false;
    }

    private boolean a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (!gVar.c()) {
                return false;
            }
            gVar.c("UgcModule_EventDetails", "parseGetCommentsJSON: data == null");
            return false;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
        if (gVar2.e()) {
            gVar2.g("UgcModule_EventDetails", "parseGetCommentsJSON: data --> " + jSONObject);
        }
        boolean a2 = this.e.a(jSONObject, z);
        com.baidu.navisdk.ugc.eventdetails.model.e eVar = this.e.Q;
        if (eVar != null) {
            this.k = eVar.d;
        }
        return a2;
    }

    public void a(int i) {
        com.baidu.navisdk.ugc.eventdetails.model.a aVar = this.c;
        com.baidu.navisdk.ugc.eventdetails.control.d.a(aVar.f8066a, i, aVar.b, "" + com.baidu.navisdk.ugc.utils.c.b(this.c.g), this.f, 2, Q());
    }

    public void a(e.a aVar) {
        com.baidu.navisdk.ugc.eventdetails.control.d.a(aVar.i + "", aVar.k + "", "" + com.baidu.navisdk.ugc.utils.c.b(this.c.g), this.f, 7, Q());
    }

    public void a(int i, int i2, Intent intent) {
        com.baidu.navisdk.ugc.eventdetails.interfaces.c cVar = this.d;
        if (cVar != null) {
            cVar.onActivityResult(i, i2, intent);
        }
    }

    private Bundle a(String str, int i, int i2, String str2) {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("event_id", str);
        }
        bundle.putInt(MapItem.KEY_JAM_INDEX, i);
        bundle.putInt("jamVersion", i2);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("routeMD5", str2);
        }
        return bundle;
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void a(TwoStateScrollView.DragState dragState) {
        this.f8056a = dragState;
    }

    public void a(String str, Bundle bundle, String str2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "BNRCEventDetailsViewController setBaseDataBundle bundle: " + bundle);
        }
        this.c.a(str, bundle, str2);
        if (this.c.q()) {
            e(bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.os.Bundle r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L12
            com.baidu.navisdk.util.common.g r7 = com.baidu.navisdk.util.common.g.UGC
            boolean r0 = r7.c()
            if (r0 == 0) goto L11
            java.lang.String r0 = "UgcModule_EventDetails"
            java.lang.String r1 = "addCommonParamsGetDataEngine bundle == null"
            r7.c(r0, r1)
        L11:
            return
        L12:
            com.baidu.navisdk.ugc.eventdetails.model.a r0 = r6.c
            java.lang.String r0 = r0.f8066a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L25
            com.baidu.navisdk.ugc.eventdetails.model.a r0 = r6.c
            java.lang.String r0 = r0.f8066a
            java.lang.String r1 = "eventId"
            r7.putString(r1, r0)
        L25:
            com.baidu.navisdk.ugc.eventdetails.model.a r0 = r6.c
            int r0 = r0.g
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L3d
            if (r0 == r2) goto L3b
            r4 = 3
            if (r0 == r4) goto L3e
            r5 = 6
            if (r0 == r5) goto L3e
            r4 = 7
            if (r0 == r4) goto L3d
            r4 = 0
            goto L3e
        L3b:
            r4 = 2
            goto L3e
        L3d:
            r4 = 1
        L3e:
            java.lang.String r0 = "sceneType"
            r7.putInt(r0, r4)
            com.baidu.navisdk.ugc.eventdetails.model.a r0 = r6.c
            java.lang.String r0 = r0.e
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L56
            com.baidu.navisdk.ugc.eventdetails.model.a r0 = r6.c
            java.lang.String r0 = r0.e
            java.lang.String r4 = "routeMd5"
            r7.putString(r4, r0)
        L56:
            com.baidu.navisdk.ugc.eventdetails.model.a r0 = r6.c
            int r0 = r0.f
            r4 = 4
            if (r0 == r4) goto L64
            r3 = 13
            if (r0 == r3) goto L62
            goto L65
        L62:
            r1 = 2
            goto L65
        L64:
            r1 = 1
        L65:
            java.lang.String r0 = "triggerSource"
            r7.putInt(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ugc.eventdetails.control.a.a(android.os.Bundle):void");
    }

    private boolean a(e eVar) {
        try {
            Bundle bundle = new Bundle();
            a(bundle);
            bundle.putInt("roadNo", this.c.p);
            bundle.putInt("yellowId", this.c.o);
            int i = this.c.k;
            int i2 = i != 2 ? i != 3 ? 2 : 1 : 3;
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
            if (gVar.e()) {
                gVar.g("UgcModule_EventDetails", "getClickYellowDataFromEngine getRouteInfoInUniform: " + bundle);
            }
            BNRouteGuider.getInstance().getRouteInfoInUniform(31, i2, bundle);
            if (gVar.e()) {
                gVar.g("UgcModule_EventDetails", "getClickYellowDataFromEngine bundle: " + bundle);
            }
            if (bundle.getInt("parseDataType") == 1) {
                c(bundle);
            } else {
                d(bundle);
            }
            if (eVar != null) {
                eVar.a(bundle);
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.UGC;
            if (gVar2.c()) {
                gVar2.c("UgcModule", "getClickYellowDataFromEngine yellowId" + this.c.o + " " + th.getMessage());
            }
            if (eVar == null) {
                return false;
            }
            eVar.a();
            return false;
        }
    }

    public boolean a(double d2, double d3, int i) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.UGC;
        if (gVar.e()) {
            gVar.g("UgcModule_EventDetails", "onClickInterdictReportOpen(), poiX = " + d2 + " poiY = " + d3 + " iconId = " + i);
        }
        Bundle bundle = new Bundle();
        String b2 = com.baidu.navisdk.util.http.b.d().b("BlockUploadOpen");
        if (!b2.endsWith("/")) {
            b2 = b2 + "/?";
        } else if (!b2.contains(LocationInfo.NA)) {
            b2 = b2 + LocationInfo.NA;
        }
        String str = b2 + String.format("business_trigger=18&parent_type=16&point=%s,%s&sub_type=%s", Integer.valueOf((int) d2), Integer.valueOf((int) d3), Integer.valueOf(i));
        if (gVar.d()) {
            gVar.e("UgcModule_EventDetails", "onClickInterdictReportOpen url:" + str);
        }
        bundle.putString("url", str);
        bundle.putBoolean("isProNavi", this.c.m());
        return com.baidu.navisdk.framework.b.f(bundle);
    }

    public static void a(com.baidu.navisdk.ugc.eventdetails.model.a aVar, boolean z, int i) {
        if (aVar == null) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("e.1.b.2", aVar.f8066a, z ? "1" : "2", i + "");
    }
}
