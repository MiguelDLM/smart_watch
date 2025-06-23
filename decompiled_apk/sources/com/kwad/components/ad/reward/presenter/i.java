package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class i {
    public static boolean x(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bI(dS) && (aVar = gVar.oM) != null && aVar.qF()) || com.kwad.components.ad.reward.a.b.k(dS) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.a.b.gC()) {
            return true;
        }
        if (!com.kwad.sdk.core.response.b.a.aE(dS) || !com.kwad.sdk.core.response.b.a.as(dS)) {
            return false;
        }
        return true;
    }
}
