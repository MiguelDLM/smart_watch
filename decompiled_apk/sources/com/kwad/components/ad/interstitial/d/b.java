package com.kwad.components.ad.interstitial.d;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class b {
    public static boolean k(AdTemplate adTemplate) {
        if (!com.kwad.sdk.core.response.b.b.cj(adTemplate).closeAfterClick && !com.kwad.components.ad.interstitial.b.b.cK()) {
            return false;
        }
        return true;
    }
}
