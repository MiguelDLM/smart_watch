package com.kwad.sdk.core.adlog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.t;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class b {
    public static void BN() {
        GlobalThreadPools.Gr().execute(new az() { // from class: com.kwad.sdk.core.adlog.b.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                com.kwad.sdk.core.adlog.a.a BT = com.kwad.sdk.core.adlog.a.b.BQ().BT();
                if (BT != null) {
                    JSONObject jSONObject = BT.aqw;
                    t.putValue(jSONObject, "retryCount", BT.retryCount);
                    t.putValue(jSONObject, "cacheType", 1);
                    b.a(BT.url, jSONObject, BT.aqx, BT);
                }
            }
        });
    }

    public static void a(@NonNull final com.kwad.sdk.core.adlog.c.a aVar) {
        GlobalThreadPools.Gr().execute(new az() { // from class: com.kwad.sdk.core.adlog.b.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                a aVar2 = new a(com.kwad.sdk.core.adlog.c.a.this);
                b.a(aVar2.getUrl(), aVar2.getBody(), com.kwad.sdk.core.adlog.c.a.this, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, JSONObject jSONObject, @NonNull com.kwad.sdk.core.adlog.c.a aVar, @Nullable com.kwad.sdk.core.adlog.a.a aVar2) {
        AdTemplate adTemplate = aVar.adTemplate;
        int i = aVar.apT;
        try {
            com.kwad.sdk.core.adlog.b.c.a(adTemplate, i, aVar2);
            if (!ah.isNetworkConnected(ServiceProvider.getContext())) {
                com.kwad.sdk.core.e.c.w("AdLogRequestManager", "no network while report log");
                com.kwad.sdk.core.adlog.b.c.a(adTemplate, i, str, 100004, "no network", aVar2);
                com.kwad.sdk.core.adlog.a.b.BQ().a(aVar2, str, jSONObject, aVar, 100004, "no network");
                return;
            }
            if (bo.hk(str)) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, str, 100001, "", aVar2);
                return;
            }
            com.kwad.sdk.core.network.c doPost = g.yy().doPost(str, (Map<String, String>) null, jSONObject);
            AdLogRequestResult adLogRequestResult = new AdLogRequestResult();
            adLogRequestResult.parseResult(doPost.awE);
            int i2 = doPost.code;
            if (i2 != 200) {
                int cb = d.cb(i2);
                String str2 = doPost.awE;
                com.kwad.sdk.core.adlog.b.c.d(adTemplate, i, str, cb, str2, aVar2);
                com.kwad.sdk.core.adlog.a.b.BQ().a(aVar2, str, jSONObject, aVar, cb, str2);
                return;
            }
            if (adLogRequestResult.isResultOk()) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, aVar2);
                b(aVar);
                com.kwad.sdk.core.adlog.a.b.BQ().BR();
                return;
            }
            if (adLogRequestResult.isCheatingFlow()) {
                adTemplate.setCheatingFlow(adLogRequestResult.isCheatingFlow());
                com.kwad.sdk.core.adlog.b.c.c(adTemplate, i, str, adLogRequestResult.result, adLogRequestResult.errorMsg, aVar2);
                return;
            }
            int i3 = adLogRequestResult.result;
            String str3 = adLogRequestResult.errorMsg;
            com.kwad.sdk.core.e.c.w("AdLogRequestManager", "request fail code:" + i3 + ", errorMsg:" + str3 + ", url=" + str);
            com.kwad.sdk.core.adlog.b.c.c(adTemplate, i, str, i3, str3, aVar2);
            com.kwad.sdk.core.adlog.a.b.BQ().a(aVar2, str, jSONObject, aVar, i3, str3);
        } catch (Throwable th) {
            com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, "", 100000, bo.t(th), aVar2);
            com.kwad.sdk.core.e.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void b(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        try {
            com.kwad.sdk.core.track.a.d(aVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
