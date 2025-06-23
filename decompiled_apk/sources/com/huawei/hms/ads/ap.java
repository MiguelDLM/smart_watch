package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.bean.AdProvider;
import com.huawei.hms.ads.consent.constant.ConsentStatus;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.hms.ads.consent.inter.ConsentUpdateListener;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ap extends ag {
    public ap() {
        super(aj.v);
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).requestConsentUpdate(new ConsentUpdateListener() { // from class: com.huawei.hms.ads.ap.1
            public void onFail(String str2) {
                ag.Code(remoteCallResultCallback, ap.this.Code, 3006, str2, true);
            }

            public void onSuccess(ConsentStatus consentStatus, boolean z, List<AdProvider> list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.huawei.openalliance.ad.constant.aw.Q, consentStatus.getValue());
                    jSONObject.put(com.huawei.openalliance.ad.constant.aw.T, z);
                    JSONArray jSONArray = new JSONArray();
                    if (!com.huawei.openalliance.ad.utils.ad.Code(list)) {
                        for (AdProvider adProvider : list) {
                            JSONObject jSONObject2 = new JSONObject();
                            if (adProvider != null) {
                                jSONObject2.put("id", adProvider.getId());
                                jSONObject2.put("name", adProvider.getName());
                                jSONObject2.put(com.huawei.openalliance.ad.constant.aw.ac, adProvider.getServiceArea());
                                jSONObject2.put(com.huawei.openalliance.ad.constant.aw.ad, adProvider.getPrivacyPolicyUrl());
                            }
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put(com.huawei.openalliance.ad.constant.aw.U, jSONArray);
                    ag.Code(remoteCallResultCallback, ap.this.Code, 1000, jSONObject.toString(), true);
                } catch (Throwable unused) {
                    ag.Code(remoteCallResultCallback, ap.this.Code, 3006, "consent info is null", true);
                }
            }
        });
    }
}
