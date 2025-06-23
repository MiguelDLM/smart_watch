package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class x implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c Xm;
    private OfflineOnAudioConflictListener xR = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.webview.tachikoma.a.x.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            x.this.aU(2);
        }

        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeReleased() {
            x.this.aU(3);
        }
    };

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean aaL;
        public int aaM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i) {
        a aVar = new a();
        aVar.aaL = com.kwad.components.core.s.a.as(ServiceProvider.getContext()).rA();
        aVar.aaM = i;
        com.kwad.sdk.core.webview.c.c cVar = this.Xm;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAudioFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.s.a.as(ServiceProvider.getContext()).b(this.xR);
        this.Xm = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Xm = cVar;
        com.kwad.components.core.s.a.as(ServiceProvider.getContext()).a(this.xR);
        aU(1);
    }
}
