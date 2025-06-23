package com.kwad.components.core.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public final class g extends KSFrameLayout {
    private final d Kk;
    private a Kt;
    private final d Kv;
    private final com.kwad.components.core.widget.a.b bQ;
    private final AdTemplate mAdTemplate;
    private Presenter mPresenter;
    private boolean oa;

    public g(@NonNull Context context, AdTemplate adTemplate, d dVar) {
        super(context);
        this.Kv = new d() { // from class: com.kwad.components.core.e.a.g.1
            @Override // com.kwad.components.core.e.a.d
            public final void nD() {
                g.this.dK();
            }
        };
        this.mAdTemplate = adTemplate;
        this.Kk = dVar;
        this.bQ = new com.kwad.components.core.widget.a.b(this, 70);
        initMVP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dK() {
        if (this.oa) {
            return;
        }
        this.oa = true;
        this.Kk.nD();
    }

    private void initMVP() {
        this.Kt = nK();
        Presenter onCreatePresenter = onCreatePresenter();
        this.mPresenter = onCreatePresenter;
        onCreatePresenter.G(this);
        this.mPresenter.k(this.Kt);
    }

    private a nK() {
        a aVar = new a();
        aVar.Ki = this;
        aVar.mAdTemplate = this.mAdTemplate;
        aVar.Kj = this.bQ;
        aVar.Kk = this.Kv;
        return aVar;
    }

    private static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        com.kwad.sdk.core.e.c.d("InstalledActivateView", "onViewAttached");
        this.bQ.ua();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.sdk.core.e.c.d("InstalledActivateView", "onViewDetached");
        this.bQ.release();
        this.mPresenter.destroy();
        this.Kt.release();
        dK();
    }
}
