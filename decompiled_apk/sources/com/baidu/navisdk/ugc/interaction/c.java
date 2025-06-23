package com.baidu.navisdk.ugc.interaction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.comapi.mapcontrol.MapParams;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.module.longlink.JNILonglinkControl;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o0oIxXOx.oO;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class c implements com.baidu.navisdk.module.longlink.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.ugc.interaction.a f8201a;
    private Handler b;
    private int c;
    private String d;
    private d e;
    private com.baidu.navisdk.ugc.interaction.b f;

    /* loaded from: classes8.dex */
    public class a implements CmdGeneralHttpRequestFunc.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8202a;

        public a(int i) {
            this.f8202a = i;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public void a(byte[] bArr) {
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public List<l> getRequestParams() {
            return c.this.d(this.f8202a);
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public int getRequestType() {
            return 1;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("ugcInteractionClick");
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public boolean parseResponseJSON(JSONObject jSONObject) {
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.loop.a {
        public b(c cVar, String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Interaction", "onMessage msg:" + message.toString());
            }
            if (message.what == 1 && message.arg1 == 0) {
                if (gVar.d()) {
                    gVar.e("UgcModule_Interaction", "click report callback success");
                } else {
                    gVar.e("UgcModule_Interaction", "click report callback failed");
                }
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.interaction.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0386c implements com.baidu.navisdk.ugc.interaction.b {
        public C0386c() {
        }

        @Override // com.baidu.navisdk.ugc.interaction.b
        public void a(int i) {
            if (i == 1) {
                c.this.e();
            } else if (i == 3) {
                c.this.g();
            }
            c.this.e(2);
        }

        @Override // com.baidu.navisdk.ugc.interaction.b
        public void b(int i) {
            c.this.b(2);
            c.this.e(1);
        }

        @Override // com.baidu.navisdk.ugc.interaction.b
        public void c(int i) {
            c.this.b(0);
            c.this.e(3);
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class d {
        public abstract void a(String str, Bundle bundle);

        public abstract boolean a();

        public abstract boolean a(String str, String str2, int i, com.baidu.navisdk.ugc.interaction.b bVar);
    }

    /* loaded from: classes8.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static final c f8204a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    private String c(int i) {
        if (i == 1) {
            return "Naving";
        }
        if (i == 2) {
            return "LightNav";
        }
        if (i != 3) {
            return null;
        }
        return "RouteResult";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<l> d(int i) {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(new i("cuid", a0.e()));
        arrayList.add(new i("sv", a0.k()));
        arrayList.add(new i(oO.f31192XO, String.valueOf(0)));
        arrayList.add(new i("event_id", this.f8201a.b));
        arrayList.add(new i("flag", String.valueOf(i)));
        com.baidu.navisdk.util.http.a.a(arrayList);
        arrayList.add(new i(HttpConstants.SIGN, JNITrajectoryControl.sInstance.getUrlParamsSign(com.baidu.navisdk.module.cloudconfig.d.a(arrayList))));
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "reportUserClickTipsStatus request params: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "showNavingDetailView mPage: " + com.baidu.navisdk.module.ugc.eventdetails.control.a.a(this.c));
        }
        Bundle a2 = a(this.f8201a);
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(this.f8201a.f8200a, a2);
        }
        b(1);
    }

    private int f(int i) {
        if (i == 1) {
            return 3;
        }
        if (i != 2) {
            return i != 3 ? -1 : 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "showRouteResultDetailView mPage: " + com.baidu.navisdk.module.ugc.eventdetails.control.a.a(this.c));
        }
        Bundle a2 = a(this.f8201a);
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(this.f8201a.f8200a, a2);
        }
        b(1);
    }

    private c() {
        this.c = 0;
        this.f8201a = new com.baidu.navisdk.ugc.interaction.a();
    }

    private void f() {
        boolean z;
        g.UGC.d();
        if (this.e != null) {
            c();
            d dVar = this.e;
            com.baidu.navisdk.ugc.interaction.a aVar = this.f8201a;
            z = dVar.a(null, aVar.e, com.baidu.navisdk.ugc.report.data.datarepository.c.a(aVar.c, true), this.f);
        } else {
            z = false;
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.b.1", "1", null, null);
        }
    }

    public static c a() {
        return e.f8204a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "asyncReportUserClickTipsStatus clickStatus:" + i + ",isReportServer: " + this.f8201a.f);
        }
        com.baidu.navisdk.ugc.interaction.a aVar = this.f8201a;
        if (aVar.f) {
            return;
        }
        aVar.f = true;
        b();
        com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.b, 1, 2000);
        CmdGeneralHttpRequestFunc.a(iVar, new a(i));
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
    }

    private void c(String str) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "unregisterPushListener --1 moduleName: " + str + ",mPage:" + this.c + ",mCurrentModuleName: " + this.d);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JNILonglinkControl.getInstance().unRegisterLongLink(new JNILonglinkControl.c(1, str));
        this.e = null;
    }

    private Bundle a(com.baidu.navisdk.ugc.interaction.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(MapParams.PanoramaKeys.EVENT_TYPE, aVar.c);
        bundle.putInt("page", this.c);
        bundle.putInt("source", 7);
        bundle.putInt("inter_role", aVar.d);
        bundle.putInt("onroute", aVar.d != 2 ? 0 : 2);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        int i2 = this.c;
        if (i2 != 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.b.2", "" + i2, "" + i, null);
        }
    }

    private void c() {
        if (this.f == null) {
            this.f = new C0386c();
        }
    }

    private void b() {
        if (this.b == null) {
            this.b = new b(this, "UgcInteraction");
        }
    }

    public void a(int i, d dVar) {
        int f = f(i);
        this.c = f;
        String c = c(f);
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "registerPushListener moduleName: " + c + ",mPage:" + this.c + ",mCurrentModuleName: " + this.d);
        }
        JNILonglinkControl.getInstance().registerLongLink(new JNILonglinkControl.c(1, c), this);
        this.d = c;
        this.e = dVar;
    }

    @Override // com.baidu.navisdk.module.longlink.a
    public void b(String str, int i, boolean z, String str2) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "onSuccess moduleName: " + str + ",content:" + str2 + ", msgID:" + i + ", isPush:" + z + ",mPage:" + this.c + ",mCurrentModuleName: " + this.d);
        }
    }

    private void b(String str) {
        d dVar = this.e;
        boolean z = false;
        if (dVar != null && dVar.a()) {
            c();
            d dVar2 = this.e;
            com.baidu.navisdk.ugc.interaction.a aVar = this.f8201a;
            z = dVar2.a(str, aVar.e, com.baidu.navisdk.ugc.report.data.datarepository.c.a(aVar.c, false), this.f);
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.b.1", "3", null, null);
        }
    }

    private void d() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.b.1", "2", null, null);
    }

    public void a(int i) {
        String c = c(f(i));
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "unregisterPushListener --0 moduleName: " + c + ",mPage:" + this.c + ",mCurrentModuleName: " + this.d);
        }
        c(c);
    }

    @Override // com.baidu.navisdk.module.longlink.a
    public void a(String str, int i, boolean z, String str2) {
        d dVar;
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "onSuccess moduleName: " + str + ",content:" + str2 + ", msgID:" + i + ", isPush:" + z + ",mPage:" + this.c + ",mCurrentModuleName: " + this.d);
        }
        if (!TextUtils.isEmpty(str) && str.equals(this.d) && (dVar = this.e) != null && dVar.a()) {
            this.f8201a.a(str2);
            com.baidu.navisdk.ugc.interaction.a aVar = this.f8201a;
            aVar.g = f(aVar.g);
            if (gVar.d()) {
                gVar.e("UgcModule_Interaction", "Push data: " + this.f8201a + ", mPage: " + this.c);
            }
            if (this.f8201a.b() && this.f8201a.g == this.c) {
                a(str2);
            }
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.u.b.3", "" + this.c, null, null);
    }

    private void a(String str) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "showNoticeTipsView mPage: " + com.baidu.navisdk.module.ugc.eventdetails.control.a.a(this.c));
        }
        int i = this.c;
        if (i == 1) {
            f();
        } else if (i == 2) {
            d();
        } else {
            if (i != 3) {
                return;
            }
            b(str);
        }
    }
}
