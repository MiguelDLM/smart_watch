package com.kwad.components.ad.f;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* loaded from: classes11.dex */
public final class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.b.f {
    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.f.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.f
    public final void loadNativeAd(KsScene ksScene, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        if (!l.zJ().Ag()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awT;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        } else {
            c.loadNativeAd(ksScene, nativeAdListener);
        }
    }

    @Override // com.kwad.components.ad.b.f
    public final void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        c.loadNativeAd(str, nativeAdListener);
    }
}
