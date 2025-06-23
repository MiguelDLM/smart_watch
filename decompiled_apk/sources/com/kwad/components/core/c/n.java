package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes11.dex */
public final class n implements c {
    public static void a(final com.kwad.components.core.request.model.a aVar, @NonNull j jVar) {
        new com.kwad.components.core.m.a(aVar.MX) { // from class: com.kwad.components.core.c.n.1
            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: aa, reason: merged with bridge method [inline-methods] */
            public final AdResultData parseData(String str) {
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(str, aVar.MX.adScene);
                createFromResponseJson.setAdSource("network");
                return createFromResponseJson;
            }

            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: no */
            public final com.kwad.components.core.request.a createRequest() {
                if (aVar.getAdStyle() == 4) {
                    com.kwad.components.ad.b.h hVar = (com.kwad.components.ad.b.h) com.kwad.sdk.components.c.f(com.kwad.components.ad.b.h.class);
                    aVar.Sd = hVar.R();
                }
                return new com.kwad.components.core.request.a(aVar);
            }
        }.request(jVar);
    }

    @Override // com.kwad.components.core.c.c
    public final void c(com.kwad.components.core.request.model.a aVar) {
        a(aVar, new j(aVar));
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkOnlyFetcher";
    }
}
