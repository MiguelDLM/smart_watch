package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class al implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b WQ;
    private final Handler Xl;

    @Nullable
    private final b Yf;

    @KsJson
    /* loaded from: classes11.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public boolean Yl;
        public String Ym;
        public int Yn;
        public com.kwad.sdk.core.webview.d.b.c Yo;
    }

    /* loaded from: classes11.dex */
    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Xl.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.components.core.e.d.c cVar2;
        final a aVar = new a();
        final AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.Ym));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (com.kwad.sdk.core.response.b.e.dK(adTemplate)) {
            if (this.WQ.aEX != null) {
                cVar2 = (com.kwad.components.core.e.d.c) this.WQ.aEX.gK(com.kwad.sdk.core.response.b.e.dS(adTemplate).downloadId);
            } else {
                cVar2 = null;
            }
            if (this.WQ.aEY) {
                this.Xl.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.al.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        com.kwad.components.core.e.d.a.a(new a.C0788a(al.this.WQ.Ph.getContext()).ar(adTemplate).b(cVar2).an(aVar.Yn).ao(true).ah(aVar.Yo.Lh).aq(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.al.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                            }
                        }));
                    }
                });
            } else if (this.Yf != null) {
                this.Xl.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.al.2
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                    }
                });
            }
            cVar.a(null);
        }
    }
}
