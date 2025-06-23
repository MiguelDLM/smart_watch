package com.kwad.components.core.e.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import com.kwad.components.core.e.c.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.n.l;
import com.kwad.sdk.widget.KSFrameLayout;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public final class a extends KSFrameLayout {
    private final b KF;
    private final b.C0787b KG;
    private d KH;
    private InterfaceC0786a KI;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private Presenter mPresenter;
    private final AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.e.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0786a {
        void nP();
    }

    public a(Context context, b bVar, b.C0787b c0787b) {
        super(context);
        this.mContext = context;
        this.KF = bVar;
        this.KG = c0787b;
        this.mAdTemplate = c0787b.adTemplate;
        l.inflate(context, R.layout.ksad_download_dialog_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        a(adBaseFrameLayout, "rootView is null");
        a((KsAdWebView) adBaseFrameLayout.findViewById(R.id.ksad_download_tips_web_card_webView), "webView is null");
    }

    private void a(View view, String str) {
        if (view != null) {
            return;
        }
        throw new RuntimeException("inflateView fail " + str + "\n--viewCount:" + getChildCount() + "\n--context:" + this.mContext.getClass().getName() + "\n--LayoutInflater context: " + LayoutInflater.from(this.mContext).getContext().getClass().getName() + "\n--classloader:" + a.class.getClassLoader().getClass().getName());
    }

    private static Presenter af() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        return presenter;
    }

    private d nO() {
        d dVar = new d();
        dVar.KF = this.KF;
        dVar.KG = this.KG;
        AdTemplate adTemplate = this.mAdTemplate;
        dVar.mAdTemplate = adTemplate;
        dVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dS(adTemplate))) {
            dVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        return dVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        this.KH = nO();
        Presenter af = af();
        this.mPresenter = af;
        af.G(this.mRootContainer);
        this.mPresenter.k(this.KH);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        d dVar = this.KH;
        if (dVar != null) {
            dVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InterfaceC0786a interfaceC0786a = this.KI;
        if (interfaceC0786a != null) {
            interfaceC0786a.nP();
        }
    }

    public final void setChangeListener(InterfaceC0786a interfaceC0786a) {
        this.KI = interfaceC0786a;
    }
}
