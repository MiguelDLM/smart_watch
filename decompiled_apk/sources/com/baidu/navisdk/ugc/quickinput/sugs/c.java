package com.baidu.navisdk.ugc.quickinput.sugs;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.sdk.internal.bn;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.ugc.report.data.datarepository.j;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import o0oIxXOx.oO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0390c f8225a;
    private Handler b;

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            j jVar;
            Log.e("UgcModule_Sug", "onMessage:" + message.toString());
            if (message.what == 1) {
                if (message.arg1 == 0) {
                    jVar = c.this.a((JSONObject) ((com.baidu.navisdk.cmdrequest.j) message.obj).b);
                } else {
                    jVar = null;
                }
                if (c.this.f8225a != null) {
                    c.this.f8225a.a(jVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CmdGeneralHttpRequestFunc.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8227a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        public b(String str, int i, int i2) {
            this.f8227a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public void a(byte[] bArr) {
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public List<l> getRequestParams() {
            return c.this.b(this.f8227a, this.b, this.c);
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public int getRequestType() {
            return 1;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("UgcSugs");
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public boolean parseResponseJSON(JSONObject jSONObject) {
            return false;
        }
    }

    /* renamed from: com.baidu.navisdk.ugc.quickinput.sugs.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0390c {
        void a(j jVar);
    }

    public c(InterfaceC0390c interfaceC0390c) {
        this.f8225a = interfaceC0390c;
        b();
    }

    private void b() {
        this.b = new a("UGCSUG");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<l> b(String str, int i, int i2) {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(new i("word", str));
        arrayList.add(new i("reqidx", String.valueOf(i)));
        arrayList.add(new i("type", String.valueOf(i2)));
        arrayList.add(new i(HttpConstants.SIGN, JNITrajectoryControl.sInstance.getUrlParamsSign(com.baidu.navisdk.module.cloudconfig.d.a(arrayList))));
        arrayList.add(new i("sv", a0.k()));
        arrayList.add(new i(oO.f31192XO, String.valueOf(0)));
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule", "sug request params: " + Arrays.toString(arrayList.toArray()));
        }
        return arrayList;
    }

    public void a(String str, int i, int i2) {
        com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, this.b, 1, 2000);
        CmdGeneralHttpRequestFunc.a(iVar, new b(str, i, i2));
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("errno", 0);
        if (optInt != 0) {
            g gVar = g.UGC;
            if (gVar.d()) {
                gVar.e("UgcModule_Sug", String.format(Locale.getDefault(), "parseSugResponseJson errno:%d, %s", Integer.valueOf(optInt), jSONObject.optString("errmsg", null)));
            }
            return null;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            if (jSONObject2 == null) {
                return null;
            }
            j jVar = new j();
            jVar.b(jSONObject2.optInt("reqidx", -1));
            jVar.a(jSONObject2.optString("word", ""));
            JSONArray jSONArray = jSONObject2.getJSONArray(bn.l);
            if (jSONArray == null) {
                jVar.b(-1);
                return jVar;
            }
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArray.getString(i);
            }
            jVar.a(strArr);
            return jVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a() {
        Handler handler = this.b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.b = null;
        }
        this.f8225a = null;
    }
}
