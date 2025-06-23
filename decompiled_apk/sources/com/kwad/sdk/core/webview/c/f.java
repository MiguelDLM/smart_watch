package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class f implements com.kwad.sdk.core.b {
    public final com.kwad.sdk.core.b aFS;
    public final int result = 1;

    public f(com.kwad.sdk.core.b bVar) {
        this.aFS = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "result", this.result);
        t.a(jSONObject, "data", this.aFS);
        return jSONObject;
    }
}
