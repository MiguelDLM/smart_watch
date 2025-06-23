package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class be implements com.kwad.sdk.core.webview.c.a {
    private static Handler YX;
    private com.kwad.components.core.e.d.c La;
    private com.kwad.sdk.core.webview.b YW;
    private b YY;

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int kl;
    }

    /* loaded from: classes11.dex */
    public interface b {
        @MainThread
        void Q(int i);
    }

    public be(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, b bVar2) {
        this.YW = bVar;
        this.La = cVar;
        this.YY = bVar2;
        if (YX == null) {
            YX = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i = aVar.kl;
            YX.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.be.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (be.this.YY != null) {
                        be.this.YY.Q(i);
                    }
                }
            });
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }
}
