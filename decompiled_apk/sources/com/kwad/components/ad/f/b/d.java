package com.kwad.components.ad.f.b;

import android.view.View;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ah;

/* loaded from: classes11.dex */
public final class d extends com.kwad.components.ad.f.a.a {
    private View mX;

    /* JADX INFO: Access modifiers changed from: private */
    public void ex() {
        if (this.mX.getVisibility() != 0) {
            return;
        }
        this.mX.setVisibility(8);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (ah.isNetworkConnected(this.mX.getContext())) {
            this.mX.setVisibility(8);
            return;
        }
        this.mX.setVisibility(0);
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.d.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                d.this.ex();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                d.this.ex();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mX = findViewById(R.id.ksad_video_network_unavailable);
    }
}
