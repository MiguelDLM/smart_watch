package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class q extends b {
    private float sD;
    private r sF;
    private KsToastView sM;
    private Runnable sP;
    private boolean sN = false;
    private boolean sO = false;
    private boolean sQ = false;
    private boolean sG = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.q.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            q.this.sM.setVisibility(8);
        }
    };

    public q(r rVar) {
        this.sF = rVar;
    }

    private void hD() {
        this.sP = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.q.3
            @Override // java.lang.Runnable
            public final void run() {
                if (q.this.sQ) {
                    return;
                }
                if (q.this.sM != null) {
                    q.this.sM.setVisibility(8);
                }
                com.kwad.components.ad.reward.a.eY().a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    private void hE() {
        bo.c(this.sP);
        this.sP = null;
    }

    private synchronized void hy() {
        if (this.sG) {
            return;
        }
        com.kwad.sdk.core.adlog.c.d(this.qp.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().cM(192).ao(this.qp.oK.getPlayDuration()));
        this.sG = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.sM == null) {
            KsToastView ksToastView = (KsToastView) findViewById(R.id.ksad_toast_view);
            this.sM = ksToastView;
            ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.q.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.a(q.this, true);
                    q.this.sM.setVisibility(8);
                    com.kwad.components.ad.reward.a.eY().a(PlayableSource.PENDANT_CLICK_AUTO);
                }
            });
        }
        this.qp.b(this.mPlayEndPageListener);
    }

    public final void hB() {
        if (this.sO) {
            return;
        }
        hy();
        this.sO = true;
        this.sM.setVisibility(0);
        this.sM.U(3);
        hD();
        bo.a(this.sP, null, 3000L);
    }

    public final void hC() {
        this.sO = false;
        this.sM.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        boolean z;
        super.onCreate();
        this.sD = com.kwad.components.ad.reward.a.b.gw();
        if (com.kwad.components.ad.reward.a.b.gx() && com.kwad.components.ad.reward.a.b.gy()) {
            z = true;
        } else {
            z = false;
        }
        this.sN = z;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        hE();
        this.qp.c(this.mPlayEndPageListener);
    }

    public static /* synthetic */ boolean a(q qVar, boolean z) {
        qVar.sQ = true;
        return true;
    }
}
