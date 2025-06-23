package com.baidu.ar;

import org.json.JSONObject;

/* loaded from: classes7.dex */
public class dp {

    /* loaded from: classes7.dex */
    public static class a {
        private String appId;
        private String pB;

        public void ad(String str) {
            this.pB = str;
        }

        public String cY() {
            return this.pB;
        }

        public JSONObject cZ() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.huawei.openalliance.ad.uriaction.i.Code, getAppId());
                jSONObject.put("appKey", cY());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        public String getAppId() {
            return this.appId;
        }

        public void setAppId(String str) {
            this.appId = str;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        private String pC;
        private String pD;
        private String pE;
        private String pF;

        public void ae(String str) {
            this.pC = str;
        }

        public void af(String str) {
            this.pD = str;
        }

        public void ag(String str) {
            this.pE = str;
        }

        public void ah(String str) {
            this.pF = str;
        }

        public JSONObject cZ() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.huawei.openalliance.ad.constant.aw.S, da());
                jSONObject.put("action", getAction());
                jSONObject.put("render", db());
                jSONObject.put("body", getBody());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }

        public String da() {
            return this.pC;
        }

        public String db() {
            return this.pE;
        }

        public String getAction() {
            return this.pD;
        }

        public String getBody() {
            return this.pF;
        }
    }
}
