package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ai implements com.kwad.sdk.core.webview.c.a {
    private final Handler Xl = new Handler(Looper.getMainLooper());

    @Nullable
    private com.kwad.sdk.core.webview.c.c Xm;
    private b cT;

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int XY = -1;
        public int type;
    }

    /* loaded from: classes11.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public ai(b bVar) {
        this.cT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.cT;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.cT = null;
        this.Xm = null;
        this.Xl.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            this.Xm = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.Xl.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.ai.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (ai.this.Xm != null) {
                        ai.this.Xm.a(null);
                    }
                    ai.this.b(aVar);
                }
            });
        } catch (Exception e) {
            this.Xm.onError(-1, e.getMessage());
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }
}
