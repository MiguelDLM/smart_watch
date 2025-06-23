package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class aa implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b WQ;
    private boolean Xd;
    private Handler Xl;
    private boolean Xp;
    private boolean Xq;

    @Nullable
    private com.kwad.sdk.core.webview.d.a.a cR;

    @Nullable
    private final com.kwad.components.core.e.d.c mApkDownloadHelper;

    public aa(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z, boolean z2, boolean z3) {
        this.Xp = false;
        this.Xq = false;
        this.Xd = z;
        this.Xl = new Handler(Looper.getMainLooper());
        this.WQ = bVar;
        this.mApkDownloadHelper = cVar;
        this.Xp = false;
        if (cVar != null) {
            cVar.as(1);
        }
        this.cR = aVar;
        this.Xq = z3;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Xl.removeCallbacksAndMessages(null);
        this.cR = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.WQ.Hx()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.KS = true;
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (this.WQ.aEY) {
            this.Xl.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.aa.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (!aa.this.WQ.aEZ && !aVar.Yl) {
                        return;
                    }
                    aa.this.WQ.getAdTemplate();
                    com.kwad.components.core.e.d.a.a(aa.this.WQ.Ph.getContext(), aa.this.WQ.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.aa.1.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            if (aa.this.cR != null) {
                                aa.this.cR.a(aVar);
                            }
                        }
                    }, aa.this.mApkDownloadHelper, aVar.Yl, aa.this.Xd, aa.this.Xp, aa.this.Xq);
                }
            });
        } else if (this.cR != null) {
            this.Xl.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.aa.2
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (aa.this.cR != null) {
                        aa.this.cR.a(aVar);
                    }
                }
            });
        }
        cVar.a(null);
    }

    public aa(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, false, false);
    }

    public aa(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, byte b) {
        this(bVar, cVar, aVar, false, false, false);
    }
}
