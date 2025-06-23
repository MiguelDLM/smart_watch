package com.baidu.navisdk.ui.routeguide.control;

import android.os.Handler;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import o0oIxXOx.oO;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class z {

    /* loaded from: classes8.dex */
    public class a implements CmdGeneralHttpRequestFunc.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8608a;

        public a(String str) {
            this.f8608a = str;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public void a(byte[] bArr) {
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public List<com.baidu.navisdk.util.http.center.l> getRequestParams() {
            return z.this.b(this.f8608a);
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public int getRequestType() {
            return 1;
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public String getUrl() {
            return com.baidu.navisdk.util.http.b.d().b("NavUserConfig");
        }

        @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpRequestFunc.b
        public boolean parseResponseJSON(JSONObject jSONObject) {
            boolean a2 = z.this.a(jSONObject);
            if (!a2) {
                LogUtil.e("UserConfigRequestManager", "parseResponseJSON failed");
            }
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.navisdk.util.http.center.l> b(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            StringBuffer stringBuffer = new StringBuffer();
            String str2 = a0.e() + "";
            arrayList.add(new com.baidu.navisdk.util.http.center.i("cuid", str2));
            stringBuffer.append("cuid=" + URLEncoder.encode(str2, "utf-8"));
            arrayList.add(new com.baidu.navisdk.util.http.center.i(oO.f31192XO, "0"));
            stringBuffer.append("&os=" + URLEncoder.encode("0", "utf-8"));
            String str3 = a0.k() + "";
            arrayList.add(new com.baidu.navisdk.util.http.center.i("sv", str3));
            stringBuffer.append("&sv=" + URLEncoder.encode(str3, "utf-8"));
            String str4 = a0.b + "";
            arrayList.add(new com.baidu.navisdk.util.http.center.i("osv", str4));
            stringBuffer.append("&osv=" + URLEncoder.encode(str4, "utf-8"));
            arrayList.add(new com.baidu.navisdk.util.http.center.i("action", str));
            stringBuffer.append("&action=" + URLEncoder.encode(str, "utf-8"));
            com.baidu.navisdk.util.http.a.a(arrayList);
            String a2 = com.baidu.navisdk.module.cloudconfig.d.a(arrayList);
            LogUtil.e("UserConfigRequestManagerunsign str:", a2);
            String str5 = JNITrajectoryControl.sInstance.getUrlParamsSign(a2) + "";
            LogUtil.e("UserConfigRequestManagerhassign sign:", str5);
            arrayList.add(new com.baidu.navisdk.util.http.center.i(HttpConstants.SIGN, str5));
            stringBuffer.append("&sign=" + URLEncoder.encode(str5, "utf-8"));
            LogUtil.e("UserConfigRequestManagerparams:", stringBuffer.toString());
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(String str) {
        if (!com.baidu.navisdk.util.common.y.d(com.baidu.navisdk.framework.a.c().a())) {
            LogUtil.e("UserConfigRequestManager", "isNetworkAvailable = false!");
            return;
        }
        com.baidu.navisdk.cmdrequest.i iVar = new com.baidu.navisdk.cmdrequest.i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPREQUEST_FUNC, 7, (Handler) null, 0, 10000);
        CmdGeneralHttpRequestFunc.a(iVar, new a(str));
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("parseActJSON,jsonObj = ");
        sb.append(jSONObject == null ? "null" : jSONObject.toString());
        LogUtil.e("UserConfigRequestManager", sb.toString());
        if (jSONObject == null) {
            return false;
        }
        try {
            if (jSONObject.getInt("errno") == 0) {
                b(jSONObject.getJSONObject("data"));
                return true;
            }
            if (jSONObject.getInt("errno") == 0) {
                jSONObject.getString("errmsg").equals("success");
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            LogUtil.e("UserConfigRequestManager", "parseUgcvalidate, dataJSONObject == null");
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("ugcvalidate");
        if (jSONObject2 != null) {
            com.baidu.navisdk.ui.routeguide.control.a.d().d = jSONObject2.optInt("open", 0);
        }
    }
}
