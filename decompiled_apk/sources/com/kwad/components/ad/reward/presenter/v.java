package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.LayoutRes;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.aj;

/* loaded from: classes11.dex */
public final class v extends b {
    private DetailVideoView tB;
    private ViewGroup tC;
    private FrameLayout tD;
    private ImageView tE;
    private ViewGroup.LayoutParams tF = null;
    private com.kwad.components.core.video.l gO = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.v.1
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            v.this.tB.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.v.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    v.this.tB.setVisibility(0);
                }
            }, 200L);
        }
    };

    private void O(@LayoutRes int i) {
        this.tD.addView(com.kwad.sdk.n.l.a(getContext(), i, this.tD, false), -1, -1);
    }

    private void hL() {
    }

    private void hM() {
        boolean z;
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.qp.mAdTemplate);
        getContext();
        boolean ML = aj.ML();
        boolean bI = com.kwad.sdk.core.response.b.a.bI(dS);
        boolean z2 = true;
        int i = 0;
        if (com.kwad.sdk.core.response.b.a.cE(dS) && com.kwad.components.ad.reward.a.b.gD()) {
            z = true;
        } else {
            z = false;
        }
        if (!com.kwad.components.ad.reward.g.E(this.qp.mAdTemplate) && !com.kwad.components.ad.reward.g.F(this.qp.mAdTemplate) && !bI && !z) {
            z2 = false;
        }
        if (!ML && z2) {
            ViewGroup viewGroup = this.tC;
            if (z) {
                i = 4;
            }
            viewGroup.setVisibility(i);
            if (bI) {
                this.tE.setVisibility(8);
                O(R.layout.ksad_playable_end_info);
            } else {
                O(R.layout.ksad_activity_apk_info_landscape);
            }
            if (!com.kwad.sdk.core.response.b.a.aX(dS)) {
                this.tB.updateTextureViewGravity(17);
                return;
            } else {
                this.tB.updateTextureViewGravity(21);
                return;
            }
        }
        this.tC.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        hL();
        ViewGroup.LayoutParams layoutParams = this.tB.getLayoutParams();
        if (layoutParams != null) {
            this.tF = new ViewGroup.LayoutParams(layoutParams);
        }
        this.qp.oK.a(this.gO);
        hM();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tB = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.tC = (ViewGroup) findViewById(R.id.ksad_play_right_area);
        this.tE = (ImageView) findViewById(R.id.ksad_play_right_area_bg_img);
        this.tD = (FrameLayout) findViewById(R.id.ksad_play_right_area_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        DetailVideoView detailVideoView;
        super.onUnbind();
        this.qp.oK.b(this.gO);
        if (this.tF != null && (detailVideoView = this.tB) != null) {
            ViewGroup.LayoutParams layoutParams = detailVideoView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.LayoutParams layoutParams2 = this.tF;
                layoutParams.width = layoutParams2.width;
                layoutParams.height = layoutParams2.height;
                this.tB.setLayoutParams(layoutParams);
            }
            DetailVideoView detailVideoView2 = this.tB;
            if (detailVideoView2 != null) {
                detailVideoView2.setVisibility(4);
            }
            this.tF = null;
        }
    }
}
