package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class k {
    public static void h(g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        Context context = gVar.mContext;
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(adTemplate);
        if ((!com.kwad.sdk.core.response.b.a.bI(dS) || (aVar = gVar.oM) == null || !aVar.qF()) && !com.kwad.components.ad.reward.a.b.k(dS) && !adTemplate.mXiaomiAppStoreDetailViewOpen && com.kwad.sdk.core.response.b.a.aE(dS) && com.kwad.sdk.core.response.b.a.as(dS) && !adTemplate.hasEnterAdWebViewLandPageActivity) {
            gVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
            DownloadLandPageActivity.launch(context, adTemplate, true);
        }
    }
}
