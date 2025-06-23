package com.kwad.components.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public final class a {
    private String Jd;
    private String Je;
    private long Jf;
    private long Jg;
    private Timer Jh;
    private boolean Ji = false;
    private final long period;

    /* renamed from: com.kwad.components.core.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C0776a {
        private static final a Jk = new a();
    }

    public a() {
        this.Jf = -1L;
        try {
            this.Jf = SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            this.Jf = System.currentTimeMillis();
            c.printStackTraceOnly(th);
        }
        this.period = TimeUnit.MINUTES.toMillis(d.Co());
        com.kwad.sdk.core.c.d dVar = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                a.this.mS();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                a.this.eG();
            }
        };
        b.En();
        b.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.Jf;
        this.Jf = elapsedRealtime;
        if (i == 1) {
            this.Jg = 0L;
            this.Je = UUID.randomUUID().toString();
            if (TextUtils.isEmpty(this.Jd)) {
                this.Jd = this.Je;
            }
        }
        this.Jg++;
        n nVar = new n(10220L);
        nVar.avo = this.Jg;
        if (j > 0) {
            nVar.aAb = j;
        }
        nVar.aAc = i;
        nVar.Jd = this.Jd;
        nVar.Je = this.Je;
        g.a2(nVar);
    }

    public static a mR() {
        return C0776a.Jk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mS() {
        this.Ji = false;
        if (this.period <= 0) {
            return;
        }
        Timer timer = this.Jh;
        if (timer != null) {
            timer.cancel();
        }
        ah(3);
    }

    public final void eG() {
        if (this.Ji) {
            return;
        }
        this.Ji = true;
        if (this.period <= 0) {
            return;
        }
        this.Jh = new Timer();
        ah(1);
        TimerTask timerTask = new TimerTask() { // from class: com.kwad.components.core.a.a.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                a.this.ah(2);
            }
        };
        try {
            Timer timer = this.Jh;
            long j = this.period;
            timer.schedule(timerTask, j, j);
        } catch (Throwable unused) {
        }
    }
}
