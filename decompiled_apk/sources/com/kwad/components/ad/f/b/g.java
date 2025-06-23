package com.kwad.components.ad.f.b;

import android.widget.ImageView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: classes11.dex */
public final class g extends com.kwad.components.ad.f.a.a {
    private ImageView ne;

    /* JADX INFO: Access modifiers changed from: private */
    public void ez() {
        KSImageLoader.loadImage(this.ne, com.kwad.sdk.core.response.b.a.W(com.kwad.sdk.core.response.b.e.dS(this.mN.mAdTemplate)), this.mN.mAdTemplate);
        this.ne.setVisibility(0);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.g.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                g.this.ez();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
        this.ne.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ne = (ImageView) findViewById(R.id.ksad_video_cover_image);
    }
}
