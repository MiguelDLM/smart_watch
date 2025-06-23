package com.kwad.components.ad.f.b;

import android.view.View;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public final class i extends com.kwad.components.ad.f.a.a implements View.OnClickListener {
    private DetailVideoView mDetailVideoView;

    private void eA() {
        com.kwad.components.core.e.d.a.a(new a.C0788a(this.mDetailVideoView.getContext()).ar(this.mN.mAdTemplate).b(this.mN.mApkDownloadHelper).v(this.mN.mO.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.f.b.i.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(i.this.mN.mAdTemplate, 2, i.this.mN.mI.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.mN.mw.l(this.mDetailVideoView);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.i.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                i.this.mDetailVideoView.setOnClickListener(i.this);
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.mDetailVideoView) {
            eA();
            notifyAdClick();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mDetailVideoView.setOnClickListener(null);
    }
}
