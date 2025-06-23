package com.baidu.navisdk.ugc.https;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final a f8185a = new a();

    private a() {
    }

    public final void a(@OOXIXo String eventId, @OOXIXo c callBack) {
        IIX0o.x0xO0oo(eventId, "eventId");
        IIX0o.x0xO0oo(callBack, "callBack");
        f f = f.f();
        f.j(1);
        f.e(eventId);
        com.baidu.navisdk.util.http.center.b.a().b(com.baidu.navisdk.util.http.b.d().b("getVideoInfo"), f.a("ugc", "68abf9193052dd98481f3b7ab84317c4"), new C0383a(callBack), null);
    }

    /* renamed from: com.baidu.navisdk.ugc.https.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0383a extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f8186a;

        public C0383a(c cVar) {
            this.f8186a = cVar;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str, @oOoXoXO Throwable th) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetailsHttp", "live request onFailure,statusCode = " + i + ", responseString = " + str);
            }
            this.f8186a.a(str);
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, @oOoXoXO String str) {
            JSONObject optJSONObject;
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_EventDetailsHttp", "live request onSuccess,statusCode = " + i + ", responseString = " + str);
            }
            if (str == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errno")) {
                if (jSONObject.optInt("errno") == 0) {
                    if (!jSONObject.has("data") || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                        return;
                    }
                    this.f8186a.a(optJSONObject);
                    return;
                }
                this.f8186a.a(str);
                com.baidu.navisdk.framework.a c = com.baidu.navisdk.framework.a.c();
                IIX0o.oO(c, "BNContextManager.getInstance()");
                TipTool.onCreateToastDialog(c.a(), "网络请求成功，返回失败");
            }
        }
    }
}
