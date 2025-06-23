package com.kwad.components.ad.draw.b;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.draw.a.a {
    private ImageView ck;
    private com.kwad.sdk.core.response.model.b cl;
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.b.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (b.this.ck.getVisibility() == 0) {
                b.this.ck.setVisibility(8);
            }
        }
    };
    private Runnable cm = new Runnable() { // from class: com.kwad.components.ad.draw.b.b.2
        @Override // java.lang.Runnable
        public final void run() {
            int width = b.this.getRootView().getWidth();
            ViewGroup.LayoutParams layoutParams = b.this.ck.getLayoutParams();
            int width2 = b.this.cl.getWidth();
            int height = b.this.cl.getHeight();
            if (width2 != 0 && height != 0 && height <= width2) {
                layoutParams.width = width;
                layoutParams.height = (int) ((height / (width2 * 1.0f)) * width);
                b.this.ck.setLayoutParams(layoutParams);
                b.this.ck.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -1;
                b.this.ck.setLayoutParams(layoutParams);
            }
            b.this.ck.setImageDrawable(null);
            KSImageLoader.loadImage(b.this.ck, b.this.cl.getUrl(), b.this.bO.mAdTemplate);
        }
    };

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.response.model.b bs = com.kwad.sdk.core.response.b.a.bs(e.dS(this.bO.mAdTemplate));
        this.cl = bs;
        if (TextUtils.isEmpty(bs.getUrl())) {
            return;
        }
        getRootView().post(this.cm);
        this.ck.setVisibility(0);
        this.bO.bP.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ck = (ImageView) findViewById(R.id.ksad_video_first_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        getRootView().removeCallbacks(this.cm);
        this.bO.bP.a(this.mVideoPlayStateListener);
    }
}
