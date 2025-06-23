package com.kwad.sdk.api.loader;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.bn;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes11.dex */
final class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0838a {
        int amY;
        String amZ;
        transient File ana;
        long interval;
        String md5;
        String sdkVersion;

        public final boolean AI() {
            if (this.amY == 1) {
                return true;
            }
            return false;
        }

        public final boolean AJ() {
            if (this.amY == -1) {
                return true;
            }
            return false;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.amY = jSONObject.optInt("dynamicType");
            this.amZ = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString("md5");
            this.interval = jSONObject.optLong("interval");
            this.sdkVersion = jSONObject.optString(bn.f.Code);
        }

        public final String toString() {
            return "Data{dynamicType=" + this.amY + ", dynamicUrl='" + this.amZ + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.ana + '}';
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        long anb;
        C0838a anc;
        String errorMsg;

        public final boolean AK() {
            if (this.anb == 1 && this.anc != null) {
                return true;
            }
            return false;
        }

        public final void parseJson(JSONObject jSONObject) {
            this.anb = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            C0838a c0838a = new C0838a();
            this.anc = c0838a;
            c0838a.parseJson(jSONObject.optJSONObject("data"));
        }

        public final String toString() {
            return "UpdateData{result=" + this.anb + ", errorMsg='" + this.errorMsg + "', data=" + this.anc + '}';
        }
    }
}
