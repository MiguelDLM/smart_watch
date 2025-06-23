package com.kwad.components.ad.f.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.f.d;
import com.kwad.components.core.e.d.c;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* loaded from: classes11.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public c mApkDownloadHelper;

    @NonNull
    public AdBasePvFrameLayout mI;

    @NonNull
    public com.kwad.components.ad.f.c.a mO;

    @NonNull
    public KsNativeAd.VideoPlayListener mr;

    @NonNull
    public d.a mw;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.mO.release();
    }
}
