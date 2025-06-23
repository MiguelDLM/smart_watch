package com.kwad.components.ad.splashscreen.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class m extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.c {
    private boolean CY;
    private com.kwad.components.ad.splashscreen.d DG;
    private ViewGroup DJ;
    private KsShakeView DK;
    private TextView DL;
    private com.kwad.sdk.core.g.d eg;
    private Vibrator eh;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i) {
    }

    @Override // com.kwad.sdk.core.g.b
    public final void aV() {
        com.kwad.sdk.core.adlog.c.bP(this.Di.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        getRootView().post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.m.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                m.this.Di.CJ = SystemClock.elapsedRealtime() - m.this.mStartTime;
            }
        });
        Context context = getContext();
        if (context != null) {
            this.eh = (Vibrator) context.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_layout);
        if (viewStub != null) {
            this.DJ = (ViewGroup) viewStub.inflate();
        } else {
            this.DJ = (ViewGroup) findViewById(R.id.ksad_shake_root);
        }
        this.DL = (TextView) this.DJ.findViewById(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) this.DJ.findViewById(R.id.ksad_shake_view);
        this.DK = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void j(int i, String str) {
        TextView textView = this.DL;
        if (textView != null) {
            if (i == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kB() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bw(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lk() {
        AdInfo dS = com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate);
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        this.DG = com.kwad.components.ad.splashscreen.d.a(hVar.mAdTemplate, dS, hVar.mApkDownloadHelper, 2);
        this.CY = com.kwad.sdk.core.response.b.d.dH(this.Di.mAdTemplate);
        new com.kwad.sdk.widget.f(this.DK.getContext(), this.DK, this);
        this.Di.a(this);
        TextView textView = this.DL;
        if (textView != null) {
            textView.setText(this.DG.kv());
        }
        KsShakeView ksShakeView = this.DK;
        if (ksShakeView != null) {
            ksShakeView.ac(this.DG.kw());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void ll() {
        ViewGroup viewGroup = this.DJ;
        if (viewGroup != null && this.Di != null) {
            viewGroup.setVisibility(0);
            com.kwad.sdk.core.adlog.c.b(this.Di.mAdTemplate, 185, (JSONObject) null);
            com.kwad.components.core.webview.tachikoma.d.a.tC().aW(185);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lm() {
        float cV = com.kwad.sdk.core.response.b.b.cV(this.Di.mAdTemplate);
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(cV);
            this.eg = dVar2;
            dVar2.a(this);
            return;
        }
        dVar.g(cV);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void ln() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bv(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lo() {
        com.kwad.sdk.core.g.d dVar = this.eg;
        if (dVar != null) {
            dVar.bw(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    public final void lp() {
        this.DK.post(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.m.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                m.this.DK.mv();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        AdTemplate adTemplate;
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onClick: " + view);
        if (view.equals(this.DK) && (hVar = this.Di) != null && (adTemplate = hVar.mAdTemplate) != null && com.kwad.sdk.core.response.b.b.dM(com.kwad.sdk.core.response.b.e.dS(adTemplate))) {
            this.Di.c(1, getContext(), 158, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.Di;
        if (hVar != null) {
            hVar.b(this);
        }
        KsShakeView ksShakeView = this.DK;
        if (ksShakeView != null) {
            ksShakeView.mw();
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(final double d) {
        boolean nQ = com.kwad.components.core.e.c.b.nQ();
        if (!this.Di.Ct.ud() || nQ) {
            return;
        }
        this.DK.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.presenter.m.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                m mVar = m.this;
                com.kwad.components.ad.splashscreen.h hVar = mVar.Di;
                if (hVar != null) {
                    hVar.a(1, mVar.getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.m.3.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.l(d);
                        }
                    });
                }
                m.this.DK.mv();
            }
        });
        bo.a(getContext(), this.eh);
        lo();
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onSlide: enableSlickClick: " + this.CY);
        if (this.CY && (hVar = this.Di) != null) {
            hVar.c(1, view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        com.kwad.components.ad.splashscreen.h hVar;
        com.kwad.sdk.core.e.c.d("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.b.b.dM(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate)) && (hVar = this.Di) != null) {
            hVar.c(1, getContext(), 158, 1);
        }
    }
}
