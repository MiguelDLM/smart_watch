package com.kwad.components.core.page.c.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes11.dex */
public final class b extends com.kwad.sdk.mvp.a {

    @NonNull
    public AdWebViewActivityProxy.a OV;

    @Nullable
    public com.kwad.components.core.page.a.a Pl;

    @Nullable
    public KsAdWebView.c Pm;

    @Nullable
    public f.a Pn;

    @Nullable
    public at.b Po;
    public boolean Pp = false;
    public boolean Pq = false;

    @NonNull
    public ViewGroup gS;

    @NonNull
    public AdTemplate mAdTemplate;

    @NonNull
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;

    @NonNull
    public Context mContext;

    @Nullable
    public String mPageTitle;

    @NonNull
    public String mPageUrl;
    public boolean mShowPermission;

    @Nullable
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    private void aG(boolean z) {
        this.Pq = true;
    }

    public final void a(KsAdWebView.c cVar) {
        this.Pm = cVar;
    }

    public final boolean pH() {
        return this.mShowPermission;
    }

    public final void pM() {
        at.b bVar = this.Po;
        if (bVar != null) {
            bVar.qf();
        }
    }

    public final boolean pS() {
        return this.Pq;
    }

    public final boolean pT() {
        if (pH()) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.Pm = null;
        this.Pn = null;
        this.mWebCardCloseListener = null;
        this.Po = null;
    }

    public final void setWebCardCloseListener(@Nullable com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
    }

    public final void a(f.a aVar) {
        this.Pn = aVar;
    }

    public final void a(at.b bVar) {
        this.Po = bVar;
        aG(true);
    }
}
