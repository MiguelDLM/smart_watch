package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import java.lang.ref.WeakReference;

/* loaded from: classes11.dex */
public final class ax implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c WI;
    private final Handler Xl = new Handler(Looper.getMainLooper());
    private final c YE;

    @KsJson
    /* loaded from: classes11.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    /* loaded from: classes11.dex */
    public static final class b {
        WeakReference<com.kwad.sdk.core.webview.c.c> YG;

        public b(com.kwad.sdk.core.webview.c.c cVar) {
            this.YG = new WeakReference<>(cVar);
        }

        public final void a(a aVar) {
            com.kwad.sdk.core.webview.c.c cVar = this.YG.get();
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        void a(b bVar);
    }

    public ax(c cVar) {
        this.YE = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLiveListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.WI = null;
        this.Xl.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.WI = cVar;
        this.Xl.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.ax.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                ax.this.YE.a(new b(ax.this.WI));
            }
        });
    }
}
