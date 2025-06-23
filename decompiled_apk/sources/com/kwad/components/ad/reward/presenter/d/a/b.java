package com.kwad.components.ad.reward.presenter.d.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.k;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements aq.b {

    @Nullable
    private com.kwad.components.ad.l.b ci;
    private AdInfo mAdInfo;
    private DetailVideoView mDetailVideoView;
    private TailFrameView vD;
    private volatile boolean vE;
    private boolean vF;
    private k vG;
    private Drawable vJ;
    private boolean sS = false;
    private int vH = Integer.MIN_VALUE;
    private int vI = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            b.this.ix();
            if (b.this.vD != null && g.G(b.this.mAdTemplate)) {
                b.this.vD.jR();
            }
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.2
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if ((e.ef(b.this.mAdTemplate) || !b.this.sS || b.this.qp.fI()) && !b.this.qp.pk && !b.this.qp.pq) {
                b.this.vF = true;
                if (b.this.ci != null && b.this.ci.ar()) {
                    b.this.vF = false;
                }
                b.this.qp.pB = true ^ b.this.vF;
                if (b.this.vF) {
                    if (b.this.qp.f18442oO != null) {
                        com.kwad.components.ad.reward.monitor.c.a(b.this.qp.mAdTemplate, b.this.qp.oZ, "end_card", com.kwad.sdk.core.response.b.b.cA(b.this.mAdTemplate), System.currentTimeMillis() - b.this.qp.f18442oO.getLoadTime(), 1);
                    }
                    b.this.aI();
                }
            }
        }

        @Override // com.kwad.components.ad.reward.e.a, com.kwad.components.ad.reward.e.g
        public final int getPriority() {
            return -1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z) {
        int i;
        if (z) {
            i = 2;
        } else {
            i = 153;
        }
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", (String) null, new com.kwad.sdk.core.adlog.c.b().f(this.qp.mRootContainer.getTouchCoords()).cK(i), this.qp.mReportExtData);
        this.qp.oJ.bJ();
    }

    private void P(int i) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI() {
        ix();
        this.vD.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.3
            @Override // com.kwad.components.ad.reward.widget.tailframe.b
            public final void N(boolean z) {
                b.this.K(z);
            }
        });
        this.vD.setVisibility(0);
    }

    private boolean iA() {
        AdInfo.AdMaterialInfo.MaterialFeature aW = com.kwad.sdk.core.response.b.a.aW(this.mAdInfo);
        if (aW.height > aW.width) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ix() {
        if (this.vE) {
            return;
        }
        iy();
    }

    private void iy() {
        boolean z;
        com.kwad.sdk.core.e.c.d("RewardPlayEndNativeCardPresenter", "initTailView");
        TailFrameView tailFrameView = this.vD;
        Context context = getContext();
        if (this.qp.mScreenOrientation == 0) {
            z = true;
        } else {
            z = false;
        }
        tailFrameView.a(context, z, iA());
        this.vE = true;
    }

    private void iz() {
        if (this.vF) {
            ix();
            this.vD.destroy();
            this.vD.setVisibility(8);
            this.vG.hide();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.core.playable.a aVar = this.qp.oM;
        if (aVar != null) {
            aVar.a(this);
        }
        this.mAdInfo = e.dS(this.mAdTemplate);
        g gVar = this.qp;
        this.ci = gVar.f18442oO;
        gVar.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.fc().a(this.mRewardVerifyListener);
        this.vD.setCallerContext(this.qp);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playend_native_jinniu);
        if (viewStub != null) {
            this.vG = new k(this.qp, viewStub);
        } else {
            this.vG = new k(this.qp, (ViewGroup) findViewById(R.id.ksad_reward_jinniu_end_card_root));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vD = (TailFrameView) findViewById(R.id.ksad_video_tail_frame);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.qp.oM;
        if (aVar != null) {
            aVar.b(this);
        }
        com.kwad.components.ad.reward.b.fc().b(this.mRewardVerifyListener);
        iz();
        this.qp.c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i = this.vI;
            if (i != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i);
            }
            com.kwad.sdk.core.e.c.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.vH);
            int i2 = this.vH;
            if (i2 != Integer.MIN_VALUE) {
                P(i2);
            }
            Drawable drawable = this.vJ;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        this.sS = aVar.isSuccess();
    }
}
