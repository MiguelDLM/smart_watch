package com.kwad.components.ad.f;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.f.b.g;
import com.kwad.components.ad.f.b.h;
import com.kwad.components.ad.f.b.i;
import com.kwad.components.ad.f.b.k;
import com.kwad.components.ad.f.d;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.j;

/* loaded from: classes11.dex */
public final class f extends KSFrameLayout {
    private com.kwad.components.core.widget.a.b bQ;
    private j cD;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private AdBasePvFrameLayout mI;
    private com.kwad.components.ad.f.a.b mN;
    public com.kwad.components.ad.f.c.a mO;
    private KsAdVideoPlayConfig mP;
    private Presenter mPresenter;
    private KsNativeAd.VideoPlayListener mr;
    private d.a mw;

    public f(@NonNull Context context) {
        this(context, null);
    }

    private void A(Context context) {
        l.inflate(context, R.layout.ksad_native_video_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.mI = adBasePvFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBasePvFrameLayout.findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
    }

    private Presenter af() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.ad.f.b.e());
        presenter.a(new com.kwad.components.ad.f.b.c());
        presenter.a(new i());
        presenter.a(new com.kwad.components.ad.f.b.j());
        presenter.a(new com.kwad.components.ad.f.b.d());
        presenter.a(new com.kwad.components.ad.f.b.b());
        presenter.a(new k());
        presenter.a(new com.kwad.components.ad.f.b.a(this.mP));
        presenter.a(new g());
        if (com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate))) {
            presenter.a(new com.kwad.components.ad.f.b.f());
        } else {
            presenter.a(new h());
        }
        return presenter;
    }

    private com.kwad.components.ad.f.a.b ev() {
        com.kwad.components.ad.f.a.b bVar = new com.kwad.components.ad.f.a.b();
        bVar.mI = this.mI;
        AdTemplate adTemplate = this.mAdTemplate;
        bVar.mAdTemplate = adTemplate;
        bVar.mw = this.mw;
        bVar.mr = this.mr;
        if (com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dS(adTemplate))) {
            com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
            if (cVar == null) {
                bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            } else {
                cVar.ot();
                bVar.mApkDownloadHelper = this.mApkDownloadHelper;
            }
        }
        bVar.mO = this.mO;
        return bVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        if (this.mO == null) {
            this.mO = new com.kwad.components.ad.f.c.a(this.mAdTemplate, this.bQ, this.mDetailVideoView, this.mP);
        }
        this.mN = ev();
        Presenter af = af();
        this.mPresenter = af;
        af.G(this.mI);
        this.mPresenter.k(this.mN);
        this.bQ.ua();
        this.mO.aJ();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.f.f.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (f.this.bQ != null) {
                    f.this.bQ.release();
                }
                com.kwad.components.ad.f.c.a aVar = f.this.mO;
                if (aVar != null) {
                    aVar.aK();
                }
                if (f.this.mN != null) {
                    f.this.mN.release();
                }
                if (f.this.mPresenter != null) {
                    f.this.mPresenter.destroy();
                }
            }
        });
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.mw = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mr = videoPlayListener;
    }

    private f(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.mP = ksAdVideoPlayConfig;
        this.mI.setVisibleListener(this.cD);
        this.bQ = new com.kwad.components.core.widget.a.b(getParent() == null ? this : (View) getParent(), 30);
    }

    private f(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.cD = new j() { // from class: com.kwad.components.ad.f.f.1
            @Override // com.kwad.sdk.widget.j
            public final void ao() {
                com.kwad.sdk.utils.l.en(f.this.mAdTemplate);
            }
        };
        A(context);
    }
}
