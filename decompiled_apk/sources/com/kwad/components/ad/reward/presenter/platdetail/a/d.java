package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.h;

/* loaded from: classes11.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView hp;
    private ImageView vs;
    private h.a hq = new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            if (d.this.hp != null && !com.kwad.components.ad.reward.a.b.gt()) {
                d.this.hp.post(new az() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        d.this.hp.setSelected(false);
                        d.this.qp.oK.setAudioEnabled(false, false);
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.ad.reward.m.c vt = new com.kwad.components.ad.reward.m.c() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.2
        @Override // com.kwad.components.ad.reward.m.c
        public final void ir() {
            d.this.ip();
        }
    };

    private void ca() {
        int i;
        ImageView imageView;
        int i2 = 8;
        if (hr()) {
            this.hp.setVisibility(8);
            imageView = this.vs;
        } else {
            ImageView imageView2 = this.hp;
            if (g.G(this.mAdTemplate)) {
                i = 8;
            } else {
                i = 0;
            }
            imageView2.setVisibility(i);
            imageView = this.vs;
            if (g.G(this.mAdTemplate)) {
                i2 = 0;
            }
        }
        imageView.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ip() {
        g gVar = this.qp;
        KsVideoPlayConfig ksVideoPlayConfig = gVar.mVideoPlayConfig;
        boolean z = true;
        if (!gVar.f18441oI && com.kwad.components.core.s.a.as(getContext()).rA()) {
            this.vs.setSelected(true);
            this.qp.d(false, false);
            z = false;
        } else if (ksVideoPlayConfig != null) {
            z = ksVideoPlayConfig.isVideoSoundEnable();
            this.vs.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.qp.d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.vs.setSelected(true);
            this.qp.d(true, true);
        }
        this.hp.setSelected(z);
        this.qp.oK.setAudioEnabled(z, false);
    }

    private void iq() {
        this.hp.setOnClickListener(this);
        this.vs.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.qp.a(this.vt);
        this.qp.oK.a(this.hq);
        ca();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.hp) {
            this.qp.oK.setAudioEnabled(!r0.isSelected(), true);
            this.hp.setSelected(!r3.isSelected());
        } else {
            if (view == this.vs) {
                this.qp.oK.setAudioEnabled(!r0.isSelected(), true);
                this.vs.setSelected(!r3.isSelected());
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.hp = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.vs = (ImageView) findViewById(R.id.ksad_reward_deep_task_sound_switch);
        iq();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qp.oK.b(this.hq);
        this.qp.b(this.vt);
    }
}
