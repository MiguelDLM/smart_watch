package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class er extends ag {

    /* loaded from: classes10.dex */
    public static class a implements IInterstitialAdStatusListener {
        private String Code;
        private RemoteCallResultCallback<String> V;

        public a(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClicked() {
            ag.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ah.b));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClosed() {
            ag.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ah.F));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdCompleted() {
            ag.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ah.f17252a));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdError(int i, int i2) {
            ag.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ah.L));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdShown() {
            ag.Code(this.V, this.Code, 1000, new JsbCallBackData(null, false, ah.D));
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onLeftApp() {
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onRewarded() {
        }
    }

    public er() {
        super(aj.k);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ac() { // from class: com.huawei.hms.ads.er.1
            @Override // com.huawei.hms.ads.ac
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    ag.Code(remoteCallResultCallback, er.this.Code, 3002, null, true);
                    fb.Code("JsbStartInterstitialAdActivity", "adContentData is null, start activity failed");
                    return;
                }
                com.huawei.hms.ads.inter.data.a aVar = new com.huawei.hms.ads.inter.data.a(adContentData);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.u);
                    String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.r);
                    boolean optBoolean = jSONObject.optBoolean("muted", true);
                    boolean optBoolean2 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.aw.aC, true);
                    if (!TextUtils.isEmpty(optString)) {
                        aVar.Code(optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        aVar.V(optString2);
                    }
                    aVar.Code(optBoolean);
                    aVar.setMobileDataAlertSwitch(optBoolean2);
                } catch (Throwable unused) {
                    fb.I("JsbStartInterstitialAdActivity", "content parse error");
                }
                aVar.show(er.this.Code(context), new a(remoteCallResultCallback, er.this.Code));
                er.this.V(remoteCallResultCallback, false);
            }
        });
    }
}
