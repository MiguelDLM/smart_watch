package com.kwad.components.ad.reward.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private d qh;

    public f(d dVar) {
        this.qh = dVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateExtraReward";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.qh = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.reward.c.f.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (f.this.qh != null) {
                        f.this.qh.a(bVar);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }
}
