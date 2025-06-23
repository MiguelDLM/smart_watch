package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class e implements com.kwad.sdk.core.b {
    private final String anT;
    private final int result;

    public e(int i, String str) {
        this.result = i;
        this.anT = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "result", this.result);
        t.putValue(jSONObject, "error_msg", this.anT);
        return jSONObject;
    }
}
