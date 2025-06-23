package com.kwad.components.ad.splashscreen.c;

import android.content.Context;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.ad.splashscreen.a.a {
    @Override // com.kwad.components.ad.splashscreen.a.a
    public final KsFragment a(AdResultData adResultData, com.kwad.sdk.core.h.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return b.b(adResultData, bVar, splashScreenAdInteractionListener);
    }

    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return com.kwad.components.ad.splashscreen.a.a.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }
}
