package com.kwad.components.ad.f.b;

import com.kwad.components.core.video.l;
import com.kwad.sdk.api.KsNativeAd;

/* loaded from: classes11.dex */
public final class e extends com.kwad.components.ad.f.a.a {
    private boolean bR = false;
    private KsNativeAd.VideoPlayListener mr;

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.mr = this.mN.mr;
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.e.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                if (e.this.mr != null) {
                    e.this.mr.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                if (e.this.mr != null) {
                    e.this.mr.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayPaused() {
                super.onMediaPlayPaused();
                if (e.this.mr != null) {
                    try {
                        e.this.mr.onVideoPlayPause();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    }
                }
                e.this.bR = true;
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                if (e.this.mr != null) {
                    e.this.mr.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (e.this.bR) {
                    e.this.bR = false;
                    if (e.this.mr != null) {
                        try {
                            e.this.mr.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPrepared() {
                super.onMediaPrepared();
                if (e.this.mr != null) {
                    try {
                        e.this.mr.onVideoPlayReady();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
                    }
                }
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
