package com.baidu.ar;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class dq {
    private int code;
    private String nC;
    private String pC;
    private String pD;
    private String pF;

    public static dq ai(String str) {
        dq dqVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            dq dqVar2 = new dq();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("action")) {
                    dqVar2.af(jSONObject.getString("action"));
                }
                if (jSONObject.has("code")) {
                    dqVar2.setCode(jSONObject.getInt("code"));
                }
                if (jSONObject.has("message")) {
                    dqVar2.setMessage(jSONObject.getString("message"));
                }
                if (jSONObject.has(com.huawei.openalliance.ad.constant.aw.S)) {
                    dqVar2.ae(jSONObject.getString(com.huawei.openalliance.ad.constant.aw.S));
                }
                if (jSONObject.has("body")) {
                    dqVar2.ah(jSONObject.getString("body"));
                }
                return dqVar2;
            } catch (Exception e) {
                e = e;
                dqVar = dqVar2;
                e.printStackTrace();
                return dqVar;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void ae(String str) {
        this.pC = str;
    }

    public void af(String str) {
        this.pD = str;
    }

    public void ah(String str) {
        this.pF = str;
    }

    public String getAction() {
        return this.pD;
    }

    public String getBody() {
        return this.pF;
    }

    public int getCode() {
        return this.code;
    }

    public boolean isSuccess() {
        return getCode() == 0;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMessage(String str) {
        this.nC = str;
    }
}
