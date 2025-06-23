package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class e {

    /* loaded from: classes11.dex */
    public static class a {
        private static e oG = new e(0);
    }

    /* loaded from: classes11.dex */
    public static class b extends com.kwad.sdk.core.network.l<f, BaseResultData> {

        @NonNull
        private AdTemplate adTemplate;
        private com.kwad.sdk.core.network.o<f, BaseResultData> oH = new com.kwad.sdk.core.network.o<f, BaseResultData>() { // from class: com.kwad.components.ad.reward.e.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                super.onSuccess(fVar, baseResultData);
                com.kwad.components.core.o.a.qI().g(b.this.adTemplate, 0, "success");
                com.kwad.sdk.core.e.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull f fVar, int i, String str) {
                super.onError(fVar, i, str);
                com.kwad.components.core.o.a.qI().g(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.e.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }
        };

        public b(@NonNull AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: ft, reason: merged with bridge method [inline-methods] */
        public f createRequest() {
            return new f(this.adTemplate);
        }

        public final void fs() {
            request(this.oH);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final BaseResultData parseData(String str) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    baseResultData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
            return baseResultData;
        }
    }

    public /* synthetic */ e(byte b2) {
        this();
    }

    private static void D(AdTemplate adTemplate) {
        new b(adTemplate).fs();
    }

    public static e fq() {
        return a.oG;
    }

    public final void C(AdTemplate adTemplate) {
        com.kwad.sdk.core.e.c.d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.bQ(dS))) {
            D(adTemplate);
        } else {
            o.b(adTemplate, dS);
        }
    }

    private e() {
    }
}
