package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class e extends w {
    private final b aas;

    /* loaded from: classes11.dex */
    public static class a implements com.kwad.sdk.core.b {
        public int height;

        private a() {
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        @MainThread
        int jd();
    }

    public e(b bVar) {
        this.aas = bVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a((byte) 0);
        b bVar = this.aas;
        if (bVar != null) {
            aVar.height = bVar.jd();
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getBottomLimitHeight";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
