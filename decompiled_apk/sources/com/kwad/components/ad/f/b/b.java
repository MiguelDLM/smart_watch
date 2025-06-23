package com.kwad.components.ad.f.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.f.a.a {
    private ImageView ck;
    private com.kwad.sdk.core.response.model.b cl;
    private Runnable cm = new Runnable() { // from class: com.kwad.components.ad.f.b.b.2
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.c.a.a.d(b.this.ck, b.this.cl.getWidth(), b.this.cl.getHeight());
            b.this.ck.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.ck, b.this.cl.getUrl(), b.this.mN.mAdTemplate);
        }
    };

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.response.model.b bs = com.kwad.sdk.core.response.b.a.bs(com.kwad.sdk.core.response.b.e.dS(this.mN.mAdTemplate));
        this.cl = bs;
        if (TextUtils.isEmpty(bs.getUrl())) {
            return;
        }
        getRootView().post(this.cm);
        this.ck.setVisibility(0);
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.b.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                if (b.this.ck.getVisibility() == 0) {
                    b.this.ck.setVisibility(8);
                }
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ck = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.cm);
    }
}
