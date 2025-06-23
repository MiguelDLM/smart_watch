package com.kwad.components.ad.f.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bm;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.ad.f.a.a implements View.OnClickListener {
    private KsAdVideoPlayConfig dU;
    private ViewGroup mR;
    private ImageView mS;
    private TextView mT;

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.dU = ksAdVideoPlayConfig;
    }

    private boolean e(AdInfo adInfo) {
        if (!ah.isNetworkConnected(getContext())) {
            return false;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return true;
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ah.isWifiConnected(getContext());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (!ah.isWifiConnected(getContext()) && (!kSAdVideoPlayConfigImpl.isDataFlowAutoStart() || !ah.isMobileConnected(getContext()))) {
                    return false;
                }
                return true;
            }
        }
        if (com.kwad.sdk.core.response.b.a.bV(adInfo)) {
            return true;
        }
        if (!com.kwad.sdk.core.response.b.a.bW(adInfo) || !ah.isWifiConnected(getContext())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ew() {
        if (this.mR.getVisibility() != 0) {
            return;
        }
        this.mR.setVisibility(8);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (!e(com.kwad.sdk.core.response.b.e.dS(this.mN.mAdTemplate))) {
            this.mT.setText(bm.ai(com.kwad.sdk.core.response.b.a.L(r0) * 1000));
            this.mS.setOnClickListener(this);
            this.mN.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.mR.setVisibility(0);
        } else {
            this.mR.setVisibility(8);
        }
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.a.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                a.this.ew();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                a.this.ew();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.mS) {
            this.mN.mO.eE();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mR = (ViewGroup) findViewById(R.id.ksad_data_flow_container);
        this.mS = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.mT = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
    }
}
