package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* loaded from: classes13.dex */
public class DownloadService extends Service {
    private static final String b = "DownloadService";

    /* renamed from: a, reason: collision with root package name */
    protected o f26265a;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        boolean z;
        String str = b;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        if (this.f26265a != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        com.ss.android.socialbase.downloader.c.a.b(str, sb.toString());
        o oVar = this.f26265a;
        if (oVar != null) {
            return oVar.a(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c.a(this);
        o z = c.z();
        this.f26265a = z;
        z.a(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(b, "Service onDestroy");
        }
        o oVar = this.f26265a;
        if (oVar != null) {
            oVar.d();
            this.f26265a = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.b(b, "DownloadService onStartCommand");
        }
        this.f26265a.c();
        ExecutorService l = c.l();
        if (l != null) {
            l.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    o oVar = DownloadService.this.f26265a;
                    if (oVar != null) {
                        oVar.a(intent, i, i2);
                    }
                }
            });
        }
        if (c.j()) {
            return 2;
        }
        return 3;
    }
}
