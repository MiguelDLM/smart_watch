package com.kwad.components.ad.fullscreen.c.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.h;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView hp;
    private h.a hq = new h.a() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (c.this.hp != null && !com.kwad.components.ad.reward.a.b.gt()) {
                c.this.hp.post(new az() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        c.this.hp.setSelected(false);
                        c.this.qp.oK.setAudioEnabled(false, false);
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };

    private void ca() {
        this.hp.setVisibility(0);
        g gVar = this.qp;
        KsVideoPlayConfig ksVideoPlayConfig = gVar.mVideoPlayConfig;
        if (!gVar.f18441oI && com.kwad.components.core.s.a.as(getContext()).rA()) {
            this.hp.setSelected(false);
            this.qp.d(false, false);
        } else if (ksVideoPlayConfig != null) {
            this.hp.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.qp.d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.hp.setSelected(true);
            this.qp.d(true, true);
        }
        this.qp.oK.a(this.hq);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.hp) {
            this.qp.oK.setAudioEnabled(!r0.isSelected(), true);
            this.hp.setSelected(!r3.isSelected());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.hp = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.oK.b(this.hq);
    }
}
