package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public class bf implements com.kwad.sdk.core.webview.c.a {
    private a Za;
    private AdTemplate mAdTemplate;
    protected Context mContext;

    /* loaded from: classes11.dex */
    public interface a {
        boolean dL();
    }

    public bf(Context context, AdTemplate adTemplate) {
        this.mContext = com.kwad.sdk.n.l.wrapContextIfNeed(context);
        this.mAdTemplate = adTemplate;
    }

    public final void a(a aVar) {
        this.Za = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showPlayable";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.Za;
        boolean dL = aVar != null ? aVar.dL() : true;
        com.kwad.sdk.core.e.c.d("WebShowPlayableHandler", "handleJsCall launch AdPlayableActivityProxy : " + dL);
        if (dL) {
            com.kwad.components.core.page.a.launch(this.mContext, this.mAdTemplate);
        }
    }
}
