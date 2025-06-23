package com.kwad.components.ad.h.a.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public static int nu = 1;
    public static int nv = 2;
    private com.kwad.sdk.core.webview.c.c nt;
    private int nw;
    private int nx;
    private InterfaceC0737b nz;
    private c ny = new c(this, 0);

    @Nullable
    private Runnable nA = null;

    @KsJson
    /* loaded from: classes11.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int nC;
        public int nD;
    }

    /* renamed from: com.kwad.components.ad.h.a.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0737b {
        void E(int i);
    }

    private b(int i, int i2) {
        this.nw = i;
        this.nx = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i) {
        com.kwad.sdk.core.e.c.d("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.nt);
        if (i < 0 || this.nt == null) {
            return;
        }
        InterfaceC0737b interfaceC0737b = this.nz;
        if (interfaceC0737b != null && i == 0) {
            interfaceC0737b.E(this.nw);
        }
        a aVar = new a();
        aVar.nD = i;
        aVar.nC = this.nw;
        com.kwad.sdk.core.webview.c.c cVar = this.nt;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    private static int f(AdInfo adInfo) {
        int b = com.kwad.components.ad.interstitial.b.b.b(adInfo);
        if (b <= 0) {
            b = 60;
        }
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        if (i > 0) {
            return Math.min(b, i);
        }
        return b;
    }

    @Nullable
    public static b z(AdTemplate adTemplate) {
        AdInfo dS = e.dS(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bb(dS)) {
            return null;
        }
        if (com.kwad.sdk.core.response.b.a.bI(dS)) {
            return new b(nv, f(dS));
        }
        int i = dS.adInsertScreenInfo.autoCloseTime;
        if (i <= 0) {
            return null;
        }
        return new b(nu, i);
    }

    public final void eG() {
        com.kwad.sdk.core.e.c.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.nt);
        if (this.nt == null) {
            this.nA = new Runnable() { // from class: com.kwad.components.ad.h.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.eG();
                }
            };
        } else {
            this.ny.J(this.nx);
            bo.runOnUiThread(this.ny);
        }
    }

    public final void eH() {
        this.ny.y(true);
    }

    public final void eI() {
        this.ny.y(false);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.nt = null;
    }

    public final void a(InterfaceC0737b interfaceC0737b) {
        this.nz = interfaceC0737b;
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        private boolean nE;
        private int nF;

        private c() {
            this.nE = false;
            this.nF = -1;
        }

        public final void J(int i) {
            this.nF = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.c.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.nE + ", currentTime: " + this.nF);
            if (this.nE) {
                bo.a(this, null, 1000L);
                return;
            }
            int i = this.nF;
            if (i >= 0) {
                b.this.I(i);
                this.nF--;
                bo.a(this, null, 1000L);
            }
        }

        public final void y(boolean z) {
            this.nE = z;
        }

        public /* synthetic */ c(b bVar, byte b) {
            this();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.nt = cVar;
        Runnable runnable = this.nA;
        if (runnable != null) {
            runnable.run();
            this.nA = null;
        }
    }
}
