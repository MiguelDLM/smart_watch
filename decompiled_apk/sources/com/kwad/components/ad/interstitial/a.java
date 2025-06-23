package com.kwad.components.ad.interstitial;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* loaded from: classes11.dex */
public final class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.b.e {
    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.e.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.e
    public final void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!l.zJ().Ag()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awT;
            interstitialAdListener.onError(eVar.errorCode, eVar.msg);
        } else {
            e.loadInterstitialAd(ksScene, interstitialAdListener);
        }
    }
}
