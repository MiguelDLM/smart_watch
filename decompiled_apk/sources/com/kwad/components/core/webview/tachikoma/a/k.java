package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class k extends w {
    b aax = new b() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1
        @Override // com.kwad.components.core.webview.tachikoma.a.k.b
        public final void L(final long j) {
            if (k.this.nt != null) {
                bo.runOnUiThread(new az() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        a aVar = new a((byte) 0);
                        aVar.creativeId = j;
                        k.this.nt.a(aVar);
                    }
                });
            }
        }
    };
    private com.kwad.sdk.core.webview.c.c nt;

    /* loaded from: classes11.dex */
    public static class a implements com.kwad.sdk.core.b {
        public long creativeId;

        private a() {
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void L(long j);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAdConvertListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.e.d.a.b(this.aax);
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.nt = cVar;
        com.kwad.components.core.e.d.a.a(this.aax);
    }
}
