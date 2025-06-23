package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class aq implements com.kwad.sdk.core.webview.c.a {
    private Handler Xl = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c Xm;
    private b cU;
    private String mUrl;

    @KsJson
    /* loaded from: classes11.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            if (this.status == 1) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    @Deprecated
    public aq(b bVar) {
        this.cU = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.cU;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.cU = null;
        this.Xm = null;
        this.Xl.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Xm = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.Xl.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.aq.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    aq.this.b(aVar);
                    if (aq.this.Xm != null) {
                        aq.this.Xm.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.e("WebCardPageStatusHandler", "handleJsCall error: " + e);
            com.kwad.sdk.core.webview.b.c.b.ag(this.mUrl, e.getMessage());
            cVar.onError(-1, e.getMessage());
        }
    }

    public aq(b bVar, String str) {
        this.cU = bVar;
        this.mUrl = str;
    }
}
