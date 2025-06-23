package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bo;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private b Wz;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0809a extends com.kwad.sdk.core.response.a.a {
        public String JK;
        public String WC;
        public String WD;
    }

    /* loaded from: classes11.dex */
    public interface b {
        void c(C0809a c0809a);
    }

    @KsJson
    /* loaded from: classes11.dex */
    public static class c extends com.kwad.sdk.core.response.a.a {
        public int WE;
        public long WF;
        public boolean WG;
        public int errorCode;
    }

    public a(b bVar) {
        this.Wz = bVar;
    }

    private void b(final C0809a c0809a) {
        bo.postOnUiThread(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (a.this.Wz != null) {
                    a.this.Wz.c(c0809a);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C0809a c0809a = new C0809a();
            c0809a.parseJson(new JSONObject(str));
            b(c0809a);
        } catch (Throwable unused) {
        }
    }
}
