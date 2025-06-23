package com.kwad.components.core.page;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.e;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.page.c.a.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: classes11.dex */
public final class c extends com.kwad.components.core.l.c<com.kwad.components.core.page.c.a.b> {
    private AdWebViewActivityProxy.a OV;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean mAutoShow;
    private Context mContext;
    private com.kwad.components.core.page.a.a mLandPageViewListener;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    private c(Context context) {
        super(context);
    }

    public static c a(Context context, AdWebViewActivityProxy.a aVar) {
        c cVar = new c(context);
        cVar.b(context, aVar);
        return cVar;
    }

    private void b(Context context, AdWebViewActivityProxy.a aVar) {
        this.OV = aVar;
        this.mContext = context;
        this.mAdTemplate = aVar.getAdTemplate();
        this.mPageUrl = aVar.pF();
        this.mPageTitle = aVar.pE();
        this.mShowPermission = aVar.pH();
        this.mAutoShow = aVar.pJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.l.c
    /* renamed from: pL, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.page.c.a.b ku() {
        com.kwad.components.core.page.c.a.b bVar = new com.kwad.components.core.page.c.a.b();
        bVar.mContext = this.mContext;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.OV = this.OV;
        bVar.mPageTitle = this.mPageTitle;
        bVar.mPageUrl = this.mPageUrl;
        bVar.mAutoShow = this.mAutoShow;
        bVar.mShowPermission = this.mShowPermission;
        bVar.Pl = this.mLandPageViewListener;
        bVar.setWebCardCloseListener(this.mWebCardCloseListener);
        bVar.gS = this.lD;
        return bVar;
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.release();
            this.mAdWebView = null;
        }
    }

    public final boolean getCanInterceptBackClick() {
        return ((com.kwad.components.core.page.c.a.b) this.mPresenter.Kf()).pS();
    }

    @Override // com.kwad.components.core.l.c
    public final int getLayoutId() {
        return R.layout.ksad_activity_ad_webview;
    }

    @Override // com.kwad.components.core.l.c
    public final void initData() {
    }

    @Override // com.kwad.components.core.l.c
    public final void ks() {
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.components.core.l.c
    @NonNull
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        presenter.a(new e());
        if (com.kwad.sdk.core.response.b.e.F(((com.kwad.components.core.page.c.a.b) this.MW).mAdTemplate)) {
            presenter.a(new com.kwad.components.core.page.c.a.c());
        }
        if (com.kwad.sdk.core.response.b.a.aN(com.kwad.sdk.core.response.b.e.dS(((com.kwad.components.core.page.c.a.b) this.MW).mAdTemplate)) && com.kwad.components.core.q.a.rj().rp() && com.kwad.components.core.q.a.rj().rk() == 1) {
            presenter.a(new com.kwad.components.core.page.c.a.d());
        }
        presenter.a(new g());
        return presenter;
    }

    public final void pM() {
        ((com.kwad.components.core.page.c.a.b) this.mPresenter.Kf()).pM();
    }

    public final void setLandPageViewListener(com.kwad.components.core.page.a.a aVar) {
        this.mLandPageViewListener = aVar;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
        if (this.mAdWebView == null && bVar != null) {
            bVar.b(null);
        }
    }
}
