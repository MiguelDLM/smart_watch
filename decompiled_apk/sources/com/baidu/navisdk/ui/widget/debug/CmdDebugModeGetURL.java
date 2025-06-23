package com.baidu.navisdk.ui.widget.debug;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc;
import com.baidu.navisdk.cmdrequest.i;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.s;
import com.baidu.navisdk.util.common.v;
import com.baidu.navisdk.util.http.a;
import com.baidu.navisdk.util.http.b;
import com.baidu.navisdk.util.http.center.l;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.facebook.appevents.UserDataStore;
import com.garmin.fit.OxXXx0X;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o0oIxXOx.oO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class CmdDebugModeGetURL {
    private static final String CACHE_FILE = m0.j().b() + "/debug/http_debug_url.txt";
    private static final String TAG = "CmdDebugModeGetURL";
    private static JSONObject cacheUrlJson;
    private String errorMsg;
    private final List<DebugModeMessageBean> mGuideMsg = new ArrayList();

    public static void initDebugUrl() {
        try {
            String e = s.e(CACHE_FILE);
            if (!TextUtils.isEmpty(e)) {
                JSONObject jSONObject = new JSONObject(e);
                cacheUrlJson = jSONObject;
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = cacheUrlJson.getString(next);
                    String substring = string.substring(1);
                    if (string.startsWith("0")) {
                        JNIGuidanceControl.getInstance().loadUrlAddrConfigParams(substring, next);
                    } else {
                        b.d().a(substring, next);
                    }
                }
            }
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                e2.printStackTrace();
                g.COMMON.e(TAG, "initDebugUrl,e=" + e2);
            }
        }
    }

    private void initSwitchStatus(DebugModeMessageSerBean debugModeMessageSerBean) {
        boolean z;
        JSONObject jSONObject = cacheUrlJson;
        if (jSONObject != null && jSONObject.has(debugModeMessageSerBean.value)) {
            z = debugModeMessageSerBean.key.equals(cacheUrlJson.optString(debugModeMessageSerBean.value, "xxxxx").substring(1));
        } else {
            z = false;
        }
        debugModeMessageSerBean.flag = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean parseJSON(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        LogUtil.e("wangyang", "parselightJSON json=" + jSONObject);
        try {
            int i = jSONObject.getInt("errno");
            this.errorMsg = jSONObject.getString("errmsg");
            if (i != 0) {
                return false;
            }
            JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("scene_list");
            List<DebugModeMessageBean> list = this.mGuideMsg;
            if (list != null) {
                list.clear();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    DebugModeMessageBean debugModeMessageBean = new DebugModeMessageBean();
                    debugModeMessageBean.mId = jSONObject2.getInt("id");
                    debugModeMessageBean.mSceneName = jSONObject2.getString("scene_name");
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("serlist");
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        DebugModeMessageSerBean debugModeMessageSerBean = new DebugModeMessageSerBean();
                        String string = jSONObject3.getString("key");
                        if (string != null) {
                            if (string.startsWith("0")) {
                                debugModeMessageSerBean.type = 0;
                            } else {
                                debugModeMessageSerBean.type = 1;
                            }
                            debugModeMessageSerBean.key = jSONObject3.getString("key").substring(2, string.length());
                            debugModeMessageSerBean.value = jSONObject3.getString("host");
                            if (debugModeMessageSerBean.key.equals("ugcControl")) {
                                debugModeMessageSerBean.key = "NavUserConfig";
                            }
                            initSwitchStatus(debugModeMessageSerBean);
                            debugModeMessageBean.serList.add(debugModeMessageSerBean);
                        }
                    }
                    this.mGuideMsg.add(debugModeMessageBean);
                }
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToSDCard(String str) {
        s.b(CACHE_FILE, str);
    }

    public void changedSwitchStatusToSDCard(DebugModeMessageSerBean debugModeMessageSerBean) {
        if (cacheUrlJson == null) {
            cacheUrlJson = new JSONObject();
        }
        try {
            if (!cacheUrlJson.has(debugModeMessageSerBean.value) && debugModeMessageSerBean.flag) {
                cacheUrlJson.put(debugModeMessageSerBean.value, debugModeMessageSerBean.type + debugModeMessageSerBean.key);
                return;
            }
            if (cacheUrlJson.has(debugModeMessageSerBean.value) && !debugModeMessageSerBean.flag) {
                cacheUrlJson.remove(debugModeMessageSerBean.value);
            }
        } catch (JSONException e) {
            if (g.b0) {
                g.COMMON.e("changedSwitchStatusToSDCard->e=" + e);
                e.printStackTrace();
            }
        }
    }

    public void flush() {
        if (cacheUrlJson == null) {
            return;
        }
        c.a().c(new f<String, String>("writeToSDCard", null) { // from class: com.baidu.navisdk.ui.widget.debug.CmdDebugModeGetURL.2
            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                if (CmdDebugModeGetURL.cacheUrlJson == null) {
                    return null;
                }
                CmdDebugModeGetURL.this.writeToSDCard(CmdDebugModeGetURL.cacheUrlJson.toString());
                return null;
            }
        }, new e(199, 0));
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public List<DebugModeMessageBean> getGuideMsg() {
        return this.mGuideMsg;
    }

    public boolean requestDebugModeUrl(Handler handler) {
        i iVar = new i(com.baidu.navisdk.cmdrequest.c.K_COMMAND_KEY_GENERAL_HTTPPOST_FUNC, 7, handler, OxXXx0X.f12987Io, 10000);
        CmdGeneralHttpPostFunc.a(iVar, new CmdGeneralHttpPostFunc.a() { // from class: com.baidu.navisdk.ui.widget.debug.CmdDebugModeGetURL.1
            @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc.a
            public List<l> getRequestParams() {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    ArrayList arrayList = new ArrayList();
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    arrayList.add(new com.baidu.navisdk.util.http.center.i(UserDataStore.CITY, valueOf));
                    stringBuffer.append("ct=");
                    stringBuffer.append(URLEncoder.encode(valueOf, "utf-8"));
                    arrayList.add(new com.baidu.navisdk.util.http.center.i("cuid", a0.e()));
                    stringBuffer.append("&cuid=");
                    stringBuffer.append(URLEncoder.encode(a0.e(), "utf-8"));
                    arrayList.add(new com.baidu.navisdk.util.http.center.i("mb", a0.f9218a));
                    stringBuffer.append("&mb=");
                    stringBuffer.append(URLEncoder.encode(a0.f9218a, "utf-8"));
                    arrayList.add(new com.baidu.navisdk.util.http.center.i(oO.f31192XO, "0"));
                    stringBuffer.append("&os=");
                    stringBuffer.append(URLEncoder.encode("0", "utf-8"));
                    arrayList.add(new com.baidu.navisdk.util.http.center.i("p", "1"));
                    stringBuffer.append("&p=");
                    stringBuffer.append(URLEncoder.encode("1", "utf-8"));
                    arrayList.add(new com.baidu.navisdk.util.http.center.i("sv", a0.k()));
                    stringBuffer.append("&sv=");
                    stringBuffer.append(URLEncoder.encode(a0.k(), "utf-8"));
                    a.a(arrayList);
                    String b = com.baidu.navisdk.util.http.center.c.b(arrayList);
                    LogUtil.e("wangyang", "getRequestParams()=" + b);
                    arrayList.add(new com.baidu.navisdk.util.http.center.i(HttpConstants.SIGN, v.b("emode" + b + "093ca827bf3645b106fb26246bcdb43f").toLowerCase()));
                    return arrayList;
                } catch (UnsupportedEncodingException unused) {
                    return null;
                }
            }

            @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc.a
            public int getRequestType() {
                return 1;
            }

            @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc.a
            public String getUrl() {
                return b.d().b("DebugModeGetURL");
            }

            @Override // com.baidu.navisdk.cmdrequest.commandparser.CmdGeneralHttpPostFunc.a
            public boolean parseResponseJSON(JSONObject jSONObject) {
                return CmdDebugModeGetURL.this.parseJSON(jSONObject);
            }

            public void responseImage(byte[] bArr) {
            }
        });
        com.baidu.navisdk.cmdrequest.b.a().a(iVar);
        return true;
    }

    public void reset() {
        cacheUrlJson = new JSONObject();
        flush();
    }
}
