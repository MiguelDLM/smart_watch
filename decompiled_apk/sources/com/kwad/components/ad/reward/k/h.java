package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private a xl;

    /* loaded from: classes11.dex */
    public interface a {
        void R(int i);
    }

    public h(a aVar) {
        this.xl = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        int i;
        if (this.xl != null) {
            try {
                i = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e) {
                e.printStackTrace();
                i = 0;
            }
            this.xl.R(i);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.xl = null;
    }
}
