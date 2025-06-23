package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
@Keep
/* loaded from: classes11.dex */
public interface KsApkDownloadListener extends KsAppDownloadListener {
    @KsAdSdkApi
    @Keep
    void onPaused(int i);
}
