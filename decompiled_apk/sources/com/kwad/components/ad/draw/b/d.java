package com.kwad.components.ad.draw.b;

import android.widget.TextView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ah;

/* loaded from: classes11.dex */
public final class d extends com.kwad.components.ad.draw.a.a {
    private TextView cz;
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.d.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayError(int i, int i2) {
            d.this.cz.setVisibility(0);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            d.this.cz.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            d.this.cz.setVisibility(8);
        }
    };

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (!ah.isNetworkConnected(getContext())) {
            this.cz.setVisibility(0);
        } else {
            this.cz.setVisibility(8);
        }
        this.bO.bP.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cz = (TextView) findViewById(R.id.ksad_video_fail_tip);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bO.bP.a(this.mVideoPlayStateListener);
    }
}
