package com.kwad.components.ad.splashscreen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;
import java.util.List;

/* loaded from: classes11.dex */
public final class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.b.h {
    @Override // com.kwad.components.ad.b.h
    public final List<String> R() {
        return SplashPreloadManager.kz().R();
    }

    @Override // com.kwad.sdk.components.a
    public final Class<com.kwad.components.ad.b.h> getComponentsType() {
        return com.kwad.components.ad.b.h.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.h
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        if (!l.zJ().Ag()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awT;
            splashScreenAdListener.onError(eVar.errorCode, eVar.msg);
        } else {
            b.loadSplashScreenAd(ksScene, splashScreenAdListener);
        }
    }
}
