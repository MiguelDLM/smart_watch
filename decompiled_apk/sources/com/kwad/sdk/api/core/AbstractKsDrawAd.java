package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.loader.Wrapper;

@KsAdSdkDynamicApi
@Keep
/* loaded from: classes11.dex */
public abstract class AbstractKsDrawAd implements KsDrawAd {
    @Override // com.kwad.sdk.api.KsDrawAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getDrawView(Context context) {
        return getDrawView2(Wrapper.wrapContextIfNeed(context));
    }

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public abstract View getDrawView2(Context context);
}
