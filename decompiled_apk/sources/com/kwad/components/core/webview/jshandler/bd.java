package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class bd implements com.kwad.sdk.core.webview.c.a {
    private a YR;

    /* loaded from: classes11.dex */
    public interface a {
        void sL();
    }

    public bd(a aVar) {
        this.YR = aVar;
    }

    private void tb() {
        if (com.kwad.components.core.e.c.b.nQ()) {
            return;
        }
        bo.runOnUiThread(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.bd.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (bd.this.YR != null) {
                    bd.this.YR.sL();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        tb();
    }
}
