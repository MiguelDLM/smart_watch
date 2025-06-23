package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private View vP;
    private boolean vQ;
    private final Runnable vR = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() != null && !b.this.getActivity().isFinishing()) {
                b.this.iG();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iG() {
        com.kwad.sdk.core.e.c.d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.qp.pB + ", needHideCloseButton: " + this.vQ);
        if (this.qp.pB && this.vQ) {
            return;
        }
        this.vP.setVisibility(0);
        this.vP.setAlpha(0.0f);
        this.vP.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.vQ = com.kwad.sdk.core.response.b.b.dX(e.dS(this.qp.mAdTemplate));
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void iF() {
        g gVar = this.qp;
        if (gVar.pk) {
            return;
        }
        long j = gVar.pv;
        if (j == 0) {
            this.vR.run();
        } else {
            bo.runOnUiThreadDelay(this.vR, j);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.vP) {
            PlayableSource fH = this.qp.fH();
            if (fH != null && (fH.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || fH.equals(PlayableSource.PENDANT_CLICK_AUTO) || fH.equals(PlayableSource.PENDANT_AUTO) || fH.equals(PlayableSource.ACTIONBAR_CLICK))) {
                com.kwad.components.ad.reward.a.eY().eZ();
            } else {
                f.t(this.qp);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View findViewById = findViewById(R.id.ksad_end_close_btn);
        this.vP = findViewById;
        findViewById.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vP.setVisibility(8);
        bo.c(this.vR);
    }
}
