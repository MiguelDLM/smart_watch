package com.kwad.components.ad.splashscreen.presenter;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class d extends e {
    private List<Integer> cB;
    private final com.kwad.components.core.video.k mVideoPlayStateListener = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.splashscreen.presenter.d.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            d.this.le();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            d.this.c(j2);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.ld();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.cB;
        if (list != null && !list.isEmpty()) {
            Iterator<Integer> it = this.cB.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.adlog.c.a(this.Di.mAdTemplate, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ld() {
        com.kwad.sdk.core.adlog.c.bM(this.Di.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le() {
        com.kwad.sdk.core.adlog.c.bN(this.Di.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.cB = com.kwad.sdk.core.response.b.a.bn(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate));
        com.kwad.components.ad.splashscreen.d.a aVar = this.Di.Cr;
        if (aVar != null) {
            aVar.b(this.mVideoPlayStateListener);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.d.a aVar = this.Di.Cr;
        if (aVar != null) {
            aVar.a(this.mVideoPlayStateListener);
        }
    }
}
