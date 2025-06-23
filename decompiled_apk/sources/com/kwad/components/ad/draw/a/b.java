package com.kwad.components.ad.draw.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.c;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: classes11.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @Nullable
    public KsDrawAd.AdInteractionListener bN;

    @NonNull
    public com.kwad.components.ad.draw.c.a bP;

    @NonNull
    public com.kwad.components.ad.draw.b.b.a ch;

    @Nullable
    public com.kwad.components.ad.l.b ci;

    @Nullable
    public c mApkDownloadHelper;

    @NonNull
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.bP.release();
    }
}
