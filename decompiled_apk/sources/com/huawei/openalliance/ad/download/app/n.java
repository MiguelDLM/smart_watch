package com.huawei.openalliance.ad.download.app;

import com.huawei.hms.ads.fb;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes10.dex */
public class n {
    private static final String Code = "TaskDelTimer";
    private static final long V = 2000;
    private AppDownloadTask I;
    private Timer Z;

    /* loaded from: classes10.dex */
    public static class a extends TimerTask {
        private AppDownloadTask Code;

        public a(AppDownloadTask appDownloadTask) {
            this.Code = appDownloadTask;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            fb.Code(n.Code, "del task");
            g.I().V((g) this.Code);
        }
    }

    public n(AppDownloadTask appDownloadTask) {
        this.I = appDownloadTask;
    }

    public void Code() {
        if (this.Z == null) {
            this.Z = new Timer();
        }
        fb.Code(Code, "start timer");
        this.Z.schedule(new a(this.I), 2000L);
    }

    public AppDownloadTask V() {
        return this.I;
    }

    public void Code(AppDownloadTask appDownloadTask) {
        this.I = appDownloadTask;
    }
}
