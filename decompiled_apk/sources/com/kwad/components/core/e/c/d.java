package com.kwad.components.core.e.c;

import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: classes11.dex */
public final class d extends com.kwad.sdk.mvp.a {

    @Nullable
    public b KF;
    public b.C0787b KG;
    public AdTemplate mAdTemplate;

    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
    }
}
