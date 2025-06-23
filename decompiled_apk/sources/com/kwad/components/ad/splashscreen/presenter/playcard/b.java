package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.p;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class b extends e {
    private com.kwad.components.core.n.a.d.b Fd;
    private long Fe;
    private volatile boolean Ff = false;
    private com.kwad.components.core.webview.tachikoma.e.e jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.1
        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void a(String str, long j, long j2, long j3) {
            if (!TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.b.b.dt(b.this.Di.mAdTemplate))) {
                com.kwad.components.ad.splashscreen.monitor.b.kW();
                com.kwad.components.ad.splashscreen.monitor.b.a(b.this.Di.mAdTemplate, b.this.Di.Cs, b.this.Di.CC, b.this.Di.CE, b.this.Di.CD, b.this.Di.CF, j, j2, j3, SystemClock.elapsedRealtime() - b.this.Fe);
                b.this.Di.CG = j;
                b.this.Di.CH = j2;
                b.this.Di.CI = j3;
                bo.c(b.this.Fg);
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void q(String str) {
            b.this.Di.CA = true;
            if ("tk_splash".equals(str)) {
                b.this.lX();
            }
        }
    };
    private final Runnable Fg = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (!b.this.Ff) {
                b.this.lW();
                return;
            }
            b.this.Di.CA = true;
            b.this.lX();
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.c(b.this.Di.mAdTemplate, b.this.Di.Cs);
        }
    };
    private com.kwad.components.core.n.a.d.a Fh = new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.3
        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i, int i2, long j, long j2) {
            b.this.Di.CC = i;
            b.this.Di.CD = i2;
            b.this.Di.CE = j;
            b.this.Di.CF = j2;
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.e(b.this.Di.mAdTemplate, SystemClock.elapsedRealtime() - b.this.Fe);
            b.this.lW();
        }
    };

    private void lV() {
        com.kwad.components.core.n.a.d.b bVar = (com.kwad.components.core.n.a.d.b) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.d.b.class);
        this.Fd = bVar;
        if (bVar != null) {
            bVar.a(this.Fh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW() {
        if (this.Ff) {
            return;
        }
        this.Ff = true;
        if (lY()) {
            bo.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new d(), true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX() {
        if (com.kwad.sdk.core.response.b.b.dI(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate))) {
            h hVar = this.Di;
            if (hVar.Cy) {
                return;
            }
            hVar.Cy = true;
            bo.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new p(), true);
                }
            });
        }
    }

    private boolean lY() {
        if (!com.kwad.sdk.core.config.d.CE()) {
            return false;
        }
        return com.kwad.sdk.core.response.b.b.m276do(com.kwad.sdk.core.response.b.e.dS(this.Di.mAdTemplate));
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Fe = SystemClock.elapsedRealtime();
        if (lY()) {
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            h hVar = this.Di;
            com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.Cs);
            h hVar2 = this.Di;
            hVar2.CB = this.Fe;
            bo.runOnUiThreadDelay(this.Fg, com.kwad.sdk.core.response.b.b.ds(com.kwad.sdk.core.response.b.e.dS(hVar2.mAdTemplate)));
            com.kwad.components.core.webview.tachikoma.d.b.tG().a(this.jR);
        }
        if (com.kwad.sdk.core.config.d.CE()) {
            lV();
        } else {
            lX();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.n.a.d.b bVar = this.Fd;
        if (bVar != null) {
            bVar.b(this.Fh);
        }
        if (lY()) {
            bo.c(this.Fg);
            com.kwad.components.core.webview.tachikoma.d.b.tG().b(this.jR);
        }
    }
}
