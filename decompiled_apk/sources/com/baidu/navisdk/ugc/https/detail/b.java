package com.baidu.navisdk.ugc.https.detail;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.cmdrequest.j;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.http.center.i;
import com.facebook.appevents.UserDataStore;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private c f8188a;
    private Handler b = new a("UgcDetailRequest");

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        private void a(Message message) {
            if (message != null && message.arg1 == 0) {
                com.baidu.navisdk.ugc.https.detail.a a2 = com.baidu.navisdk.ugc.https.detail.a.a(((JSONObject) ((j) message.obj).b).toString());
                if (b.this.f8188a != null) {
                    b.this.f8188a.a(a2);
                    return;
                }
                return;
            }
            if (b.this.f8188a != null) {
                b.this.f8188a.a(com.baidu.navisdk.ugc.https.detail.a.c());
            }
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            super.onMessage(message);
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcDetailRequest", "handleMessage: msg.what --> " + message.what + ", msg.arg1: " + message.arg1);
            }
            if (message.what == 1) {
                a(message);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.https.detail.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0384b extends com.baidu.navisdk.ugc.eventdetails.control.c {
        final /* synthetic */ com.baidu.navisdk.ugc.https.detail.c c;

        public C0384b(b bVar, com.baidu.navisdk.ugc.https.detail.c cVar) {
            this.c = cVar;
        }

        @Override // com.baidu.navisdk.ugc.eventdetails.control.c
        public void a() throws UnsupportedEncodingException {
            if (this.c.b() != 0) {
                this.b.add(new i("call_way", "" + this.c.b()));
                this.f8061a.append("&call_way=");
                this.f8061a.append(URLEncoder.encode(this.c.b() + "", "utf-8"));
            }
            this.b.add(new i("event_id", this.c.d()));
            this.f8061a.append("event_id=");
            this.f8061a.append(URLEncoder.encode(this.c.d(), "utf-8"));
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcDetailRequest", "eventId decode  = " + JNIGuidanceControl.getInstance().uidCodecDecode(this.c.d()));
            }
            this.b.add(new i("point", this.c.f()));
            this.f8061a.append("&point=");
            this.f8061a.append(URLEncoder.encode(this.c.f(), "utf-8"));
            this.b.add(new i("type", "" + this.c.e()));
            this.f8061a.append("&type=");
            this.f8061a.append(URLEncoder.encode(String.valueOf(this.c.e()), "utf-8"));
            this.b.add(new i(UserDataStore.STATE, this.c.c()));
            this.f8061a.append("&st=");
            this.f8061a.append(URLEncoder.encode(this.c.c(), "utf-8"));
            this.b.add(new i("business_trigger", "" + this.c.a()));
            this.f8061a.append("&business_trigger=");
            this.f8061a.append(URLEncoder.encode(String.valueOf(this.c.a()), "utf-8"));
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("UgcGetEventDetail");
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(com.baidu.navisdk.ugc.https.detail.a aVar);
    }

    public void a(com.baidu.navisdk.ugc.https.detail.c cVar, c cVar2) {
        this.f8188a = cVar2;
        new C0384b(this, cVar).a(this.b, 1);
    }
}
