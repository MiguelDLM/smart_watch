package com.kwad.components.core.n.b.d;

import android.content.Context;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.components.offline.api.core.webview.IWebView;

/* loaded from: classes11.dex */
public final class b implements IWebView {
    @Override // com.kwad.components.offline.api.core.webview.IWebView
    public final BaseKsWebView createWebView(Context context) {
        return new a(context);
    }
}
