package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import java.util.List;

/* loaded from: classes11.dex */
public final class f extends com.kwad.components.core.page.c.a.a {
    private boolean PI;
    private com.kwad.components.core.b.a mTitleBarHelper;

    /* loaded from: classes11.dex */
    public interface a {
        void aB(int i);
    }

    private String getTitle() {
        if (!TextUtils.isEmpty(this.Pk.mPageTitle)) {
            return this.Pk.mPageTitle;
        }
        List<AdInfo> list = this.Pk.mAdTemplate.adInfoList;
        if (list != null && list.size() > 0 && this.Pk.mAdTemplate.adInfoList.get(0) != null) {
            return com.kwad.sdk.core.response.b.a.cd(com.kwad.sdk.core.response.b.e.dS(this.Pk.mAdTemplate));
        }
        return "详情页面";
    }

    private void qc() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.Pk.gS);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.b(getTitle()));
        this.mTitleBarHelper.ah(true);
        this.mTitleBarHelper.a(new a.InterfaceC0777a() { // from class: com.kwad.components.core.page.c.a.f.1
            @Override // com.kwad.components.core.b.a.InterfaceC0777a
            public final void u(View view) {
                f.this.x(view);
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0777a
            public final void v(View view) {
                f.this.y(view);
            }
        });
        ViewGroup gG = this.mTitleBarHelper.gG();
        AdTemplate adTemplate = this.Pk.mAdTemplate;
        int i = 0;
        if (!adTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.b.a.cb(adTemplate) && !com.kwad.sdk.core.response.b.b.dp(com.kwad.sdk.core.response.b.e.dS(this.Pk.mAdTemplate))) {
            i = 8;
        }
        gG.setVisibility(i);
        this.Pk.a(new a() { // from class: com.kwad.components.core.page.c.a.f.2
            @Override // com.kwad.components.core.page.c.a.f.a
            public final void aB(int i2) {
                int i3;
                ViewGroup gG2 = f.this.mTitleBarHelper.gG();
                if (i2 == 1) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                gG2.setVisibility(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view) {
        KsAdWebView ksAdWebView = this.Pk.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.Pk.mAdWebView.goBack();
            if (this.PI) {
                com.kwad.sdk.core.adlog.c.bO(this.Pk.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.components.core.page.a.a aVar = this.Pk.Pl;
        if (aVar != null) {
            aVar.pC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(View view) {
        com.kwad.components.core.page.a.a aVar = this.Pk.Pl;
        if (aVar != null) {
            aVar.pD();
        }
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        b bVar = this.Pk;
        this.PI = TextUtils.equals(bVar.mPageUrl, com.kwad.sdk.core.response.b.a.aR(com.kwad.sdk.core.response.b.e.dS(bVar.mAdTemplate)));
        qc();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
