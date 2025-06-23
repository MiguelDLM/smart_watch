package com.kwad.components.ad.reward.i;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public final class b extends bf implements bf.a {
    private PlayableSource sb;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.sb = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.bf.a
    public final boolean dL() {
        com.kwad.components.ad.reward.a.eY().c(this.sb, new a(this.mContext));
        return false;
    }
}
