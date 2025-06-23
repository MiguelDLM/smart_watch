package com.kwad.components.ad.feed;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.l;

/* loaded from: classes11.dex */
public final class a extends com.kwad.sdk.components.d implements com.kwad.components.ad.b.c {
    @Override // com.kwad.sdk.components.a
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.c.class;
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.c
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        e.a(ksScene, feedAdListener, true);
    }

    @Override // com.kwad.components.ad.b.c
    public final void loadFeedAd(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener) {
        if (!l.zJ().Ag()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awT;
            feedAdListener.onError(eVar.errorCode, eVar.msg);
        } else {
            e.a(ksScene, feedAdListener, !com.kwad.components.ad.feed.a.b.aX());
        }
    }
}
