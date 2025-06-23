package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.RewardItem;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class es extends ag {

    /* loaded from: classes10.dex */
    public static class a implements com.huawei.openalliance.ad.inter.listeners.g {
        RewardItem Code;
        private RemoteCallResultCallback<String> I;
        private String V;

        public a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, RewardItem rewardItem) {
            this.Code = rewardItem;
            this.I = remoteCallResultCallback;
            this.V = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void B() {
            ag.Code(this.I, this.V, 1000, new JsbCallBackData(this.Code, false, ah.Z));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Code() {
            ag.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ah.I));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void I() {
            ag.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ah.S));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void V() {
            ag.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ah.C));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Z() {
            ag.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ah.V));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Code(int i, int i2) {
            ag.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ah.B));
        }
    }

    public es() {
        super(aj.j);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ac() { // from class: com.huawei.hms.ads.es.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    fb.V("JsbStartRewardAdActivity", "adContentData is null, start activity failed");
                    ag.Code(remoteCallResultCallback, es.this.Code, 3002, null, true);
                    return;
                }
                com.huawei.openalliance.ad.inter.data.q qVar = new com.huawei.openalliance.ad.inter.data.q(adContentData);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.u);
                    String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.r);
                    boolean optBoolean = jSONObject.optBoolean("muted", true);
                    boolean optBoolean2 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.aw.aA, true);
                    int optInt = jSONObject.optInt("audioFocusType", 1);
                    if (!TextUtils.isEmpty(optString)) {
                        qVar.Code(optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        qVar.V(optString2);
                    }
                    if (optInt == 1 || optInt == 2 || optInt == 0) {
                        qVar.Code(optInt);
                    }
                    qVar.Code(optBoolean);
                    qVar.a_(optBoolean2);
                } catch (Throwable unused) {
                    fb.I("JsbStartRewardAdActivity", "content parse error");
                }
                qVar.Code(es.this.Code(context), new a(remoteCallResultCallback, es.this.Code, qVar.C()));
                es.this.V(remoteCallResultCallback, false);
            }
        });
    }
}
