package com.kwad.components.ad.interstitial.g;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.components.ad.interstitial.e.f;
import com.kwad.components.ad.interstitial.e.g;
import com.kwad.components.ad.interstitial.g.d;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes11.dex */
public final class c extends a {
    private KsAdVideoPlayConfig dU;
    protected KsInterstitialAd.AdInteractionListener ie;

    /* renamed from: io, reason: collision with root package name */
    private com.kwad.components.ad.interstitial.d f18437io;
    protected com.kwad.components.ad.interstitial.e.c jK;
    private boolean jO;
    private c.a jP;
    private com.kwad.components.core.webview.tachikoma.e.e jR;
    private int jZ;

    @Nullable
    protected com.kwad.components.ad.interstitial.e.b lB;
    private boolean lC;
    protected ViewGroup lD;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdResultData mAdResultData;

    @NonNull
    protected AdTemplate mAdTemplate;

    public c(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.lC = false;
        return false;
    }

    private com.kwad.components.ad.interstitial.e.c dY() {
        com.kwad.components.ad.interstitial.e.c cVar = new com.kwad.components.ad.interstitial.e.c();
        cVar.d(this.mAdResultData);
        cVar.ie = this.ie;
        cVar.f18436io = this.f18437io;
        cVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        cVar.dU = this.dU;
        cVar.eN = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) this.lD.findViewById(R.id.ksad_container);
        cVar.jS = kSFrameLayout;
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b(kSFrameLayout, com.kwad.sdk.core.config.d.Cp());
        cVar.ib = bVar;
        bVar.ua();
        cVar.jZ = this.jZ;
        cVar.jO = this.jO;
        cVar.jP = this.jP;
        cVar.jR = this.jR;
        cVar.jL = a(this.mContext, com.kwad.sdk.core.response.b.e.dS(this.mAdTemplate), cVar);
        return cVar;
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void cr() {
        com.kwad.components.ad.interstitial.e.b bVar = this.lB;
        if (bVar != null) {
            bVar.cP();
        }
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void cs() {
        com.kwad.components.ad.interstitial.e.b bVar = this.lB;
        if (bVar != null) {
            bVar.cQ();
        }
    }

    @NonNull
    public final com.kwad.components.ad.interstitial.e.b dZ() {
        com.kwad.components.ad.interstitial.e.b bVar = new com.kwad.components.ad.interstitial.e.b();
        if (this.lC) {
            bVar.a(new com.kwad.components.ad.interstitial.e.a.b());
        } else {
            if (com.kwad.sdk.core.response.b.a.bb(this.mAdInfo)) {
                bVar.a(new f());
            }
            bVar.a(new g());
            bVar.a(new com.kwad.components.ad.interstitial.e.d());
            if (com.kwad.sdk.core.response.b.a.aO(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.e.a());
            }
            if (this.jK.J(getContext())) {
                bVar.a(new com.kwad.components.ad.interstitial.e.e());
            }
        }
        return bVar;
    }

    public final void ea() {
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null && cVar.jX) {
            cVar.cS();
        }
    }

    public final void eb() {
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            if (this.lC || cVar.jX) {
                cVar.cT();
            }
        }
    }

    public final void ec() {
        if (this.jK != null) {
            this.jK.a(new c.b(this.mContext).k(true).A(1).m(true).z(2));
        }
    }

    public final boolean ed() {
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            return cVar.jY;
        }
        return false;
    }

    public final int getLayoutId() {
        return R.layout.ksad_interstitial;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.e.b bVar = this.lB;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    public final void setAdConvertListener(c.a aVar) {
        this.jP = aVar;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.jP = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ie = adInteractionListener;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.ie = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z) {
        this.jO = z;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.jO = z;
        }
    }

    public final void setAggregateShowTriggerType(int i) {
        this.jZ = i;
        com.kwad.components.ad.interstitial.e.c cVar = this.jK;
        if (cVar != null) {
            cVar.jZ = i;
        }
    }

    private c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.jZ = -1;
        this.jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.interstitial.g.c.1
            @Override // com.kwad.components.core.webview.tachikoma.e.e
            public final void a(String str, long j, long j2, long j3) {
                c.this.jK.jY = true;
            }

            @Override // com.kwad.components.core.webview.tachikoma.e.b
            public final void q(String str) {
                if ("tk_interstitial".equals(str)) {
                    c.a(c.this, false);
                    com.kwad.components.ad.interstitial.e.b bVar = c.this.lB;
                    if (bVar != null) {
                        bVar.mw();
                    }
                    c cVar = c.this;
                    cVar.lB = cVar.dZ();
                    c cVar2 = c.this;
                    cVar2.lB.G(cVar2.lD);
                    c cVar3 = c.this;
                    cVar3.lB.k(cVar3.jK);
                }
            }
        };
        this.lD = (ViewGroup) l.inflate(context, getLayoutId(), this);
    }

    private d a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.e.c cVar) {
        boolean a2 = com.kwad.components.ad.interstitial.e.c.a(this.mContext, adInfo);
        d.a aVar = new d.a();
        aVar.v(a2);
        aVar.w(!cVar.J(context) && com.kwad.components.ad.interstitial.b.b.cF());
        aVar.F(com.kwad.components.ad.interstitial.b.b.cG());
        aVar.x((com.kwad.sdk.core.response.b.a.aV(adInfo) && aj.ML()) ? false : true);
        return new d(context, aVar);
    }

    @Override // com.kwad.components.ad.interstitial.g.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdResultData = adResultData;
        AdTemplate n = com.kwad.sdk.core.response.b.c.n(adResultData);
        this.mAdTemplate = n;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dS(n);
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.realShowType = 2;
        this.dU = ksAdVideoPlayConfig;
        this.f18437io = dVar;
        this.lC = com.kwad.sdk.core.response.b.b.cU(adTemplate);
        this.ie = adInteractionListener;
        this.jK = dY();
        if (this.lB == null) {
            this.lB = dZ();
        }
        this.lB.G(this.lD);
        this.lB.k(this.jK);
    }
}
