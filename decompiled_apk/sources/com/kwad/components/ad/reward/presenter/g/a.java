package com.kwad.components.ad.reward.presenter.g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.l.d;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.e;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.f;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.core.webview.d.a.a, com.kwad.sdk.widget.c {
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.a.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (a.this.wN != null) {
                a.this.wN.jR();
            }
            if (a.this.wO != null) {
                a.this.wO.jR();
            }
        }
    };
    private com.kwad.components.ad.reward.l.a.a ps;

    @Nullable
    private ViewGroup wJ;

    @Nullable
    private q wK;
    private ViewGroup wL;
    private e wM;
    private c wN;

    @Nullable
    private c wO;

    private void c(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_card_native_container || id == R.id.ksad_activity_apk_info_area_native) {
            e(z, 2);
        }
    }

    private void e(boolean z, int i) {
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 153;
        }
        this.qp.a(1, getContext(), i2, i);
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.sdk.core.e.c.d("LandPageOpenTaskPresenter", "onBind");
        if (!g.F(this.qp.mAdTemplate)) {
            return;
        }
        com.kwad.components.ad.reward.l.a.a jA = d.jA();
        this.ps = jA;
        this.qp.ps = jA;
        com.kwad.components.ad.reward.b.fc().a(this.mRewardVerifyListener);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
        this.wJ = viewGroup;
        if (viewGroup != null) {
            viewGroup.setClickable(true);
            this.wJ.setVisibility(8);
            new f(this.wJ, this);
            c cVar = new c(this.wJ);
            this.wO = cVar;
            cVar.a(this);
            this.wO.c(this.qp.mAdTemplate, false);
            ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
            q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.wJ, null, this);
            this.wK = qVar;
            qVar.a(this.qp.mAdTemplate, adBaseFrameLayout);
        }
        a(adBaseFrameLayout);
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z, int i) {
        e(z, 1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("LandPageOpenTaskPresenter", "onUnbind");
        e eVar = this.wM;
        if (eVar != null) {
            eVar.jT();
            this.wM = null;
        }
        c cVar = this.wO;
        if (cVar != null) {
            cVar.jQ();
        }
        com.kwad.components.ad.reward.b.fc().b(this.mRewardVerifyListener);
        this.qp.ps = null;
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dH(this.qp.mAdTemplate)) {
            c(view, false);
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!aj.ML()) {
            com.kwad.sdk.core.e.c.d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        if (com.kwad.sdk.core.response.b.d.dJ(this.qp.mAdTemplate).size() == 0) {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.c.a.a.m(kSFrameLayout, com.kwad.sdk.c.a.a.a(getContext(), 136.0f));
        } else {
            kSFrameLayout.setRatio(0.0f);
            com.kwad.sdk.c.a.a.m(kSFrameLayout, com.kwad.sdk.c.a.a.a(getContext(), 155.0f));
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.wL = viewGroup;
        viewGroup.setClickable(true);
        new f(this.wL, this);
        c cVar = new c(this.wL);
        this.wN = cVar;
        cVar.a(this);
        this.wN.c(this.qp.mAdTemplate, true);
        e eVar = new e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.wL, null, this);
        this.wM = eVar;
        eVar.a(this.qp.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        c(view, true);
    }
}
