package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;

/* loaded from: classes11.dex */
public final class a extends e {
    private com.kwad.components.core.n.a.d.b Fd;
    private long Fe;
    private volatile boolean Ff = false;
    private com.kwad.components.core.webview.tachikoma.e.e jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.1
        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void a(String str, long j, long j2, long j3) {
            if (!TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.b.b.dt(a.this.Di.mAdTemplate))) {
                com.kwad.components.ad.splashscreen.monitor.b.kW();
                com.kwad.components.ad.splashscreen.monitor.b.a(a.this.Di.mAdTemplate, a.this.Di.Cs, a.this.Di.CC, a.this.Di.CE, a.this.Di.CD, a.this.Di.CF, j, j2, j3, SystemClock.elapsedRealtime() - a.this.Fe);
                a.this.Di.CG = j;
                a.this.Di.CH = j2;
                a.this.Di.CI = j3;
                bo.c(a.this.Fg);
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void q(String str) {
            a.this.Di.CA = true;
            if ("tk_splash".equals(str)) {
                a.this.aq();
            }
        }
    };
    private final Runnable Fg = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (!a.this.Ff) {
                a.this.lW();
                return;
            }
            a.this.Di.CA = true;
            a.this.aq();
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.c(a.this.Di.mAdTemplate, a.this.Di.Cs);
        }
    };
    private com.kwad.components.core.n.a.d.a Fh = new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.3
        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i, int i2, long j, long j2) {
            a.this.Di.CC = i;
            a.this.Di.CD = i2;
            a.this.Di.CE = j;
            a.this.Di.CF = j2;
            com.kwad.components.ad.splashscreen.monitor.b.kW();
            com.kwad.components.ad.splashscreen.monitor.b.e(a.this.Di.mAdTemplate, SystemClock.elapsedRealtime() - a.this.Fe);
            a.this.lW();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aq() {
        h hVar = this.Di;
        if (hVar.Cz) {
            return;
        }
        hVar.Cz = true;
        hVar.Cy = true;
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.5
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                a.this.a(new j(), true);
            }
        });
    }

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
        bo.postOnUiThread(new az() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.4
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                a.this.a(new com.kwad.components.ad.splashscreen.presenter.a.a(), true);
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Fe = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.kW();
        h hVar = this.Di;
        com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.Cs);
        h hVar2 = this.Di;
        hVar2.CB = this.Fe;
        bo.runOnUiThreadDelay(this.Fg, com.kwad.sdk.core.response.b.b.dg(hVar2.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.d.b.tG().a(this.jR);
        lV();
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
        bo.c(this.Fg);
        com.kwad.components.core.webview.tachikoma.d.b.tG().b(this.jR);
    }
}
