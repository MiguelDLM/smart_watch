package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public abstract class a implements o {
    private static final String e = "a";
    protected volatile boolean c;
    private WeakReference<Service> f;

    /* renamed from: a, reason: collision with root package name */
    protected final SparseArray<List<DownloadTask>> f26268a = new SparseArray<>();
    protected volatile boolean b = false;
    protected volatile boolean d = false;
    private Handler g = new Handler(Looper.getMainLooper());
    private Runnable h = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(a.e, "tryDownload: 2 try");
            }
            if (!a.this.b) {
                if (com.ss.android.socialbase.downloader.c.a.a()) {
                    com.ss.android.socialbase.downloader.c.a.b(a.e, "tryDownload: 2 error");
                }
                a.this.a(c.O(), (ServiceConnection) null);
            }
        }
    };

    public void a(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public boolean b() {
        com.ss.android.socialbase.downloader.c.a.c(e, "isServiceForeground = " + this.c);
        return this.c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void c() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void d() {
        this.b = false;
    }

    public void e() {
        SparseArray<List<DownloadTask>> clone;
        synchronized (this.f26268a) {
            com.ss.android.socialbase.downloader.c.a.b(e, "resumePendingTask pendingTasks.size:" + this.f26268a.size());
            clone = this.f26268a.clone();
            this.f26268a.clear();
        }
        com.ss.android.socialbase.downloader.impls.a D = c.D();
        if (D != null) {
            for (int i = 0; i < clone.size(); i++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        com.ss.android.socialbase.downloader.c.a.b(e, "resumePendingTask key:" + downloadTask.getDownloadId());
                        D.a(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void f() {
        if (!this.b) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(e, "startService");
            }
            a(c.O(), (ServiceConnection) null);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(Intent intent, int i, int i2) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void c(DownloadTask downloadTask) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(n nVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void b(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.b) {
            if (com.ss.android.socialbase.downloader.c.a.a()) {
                com.ss.android.socialbase.downloader.c.a.b(e, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.i.a.a(262144)) {
                a(downloadTask);
                if (!this.d) {
                    if (com.ss.android.socialbase.downloader.c.a.a()) {
                        com.ss.android.socialbase.downloader.c.a.b(e, "tryDownload: 1");
                    }
                    a(c.O(), (ServiceConnection) null);
                    this.d = true;
                    return;
                }
                this.g.removeCallbacks(this.h);
                this.g.postDelayed(this.h, 10L);
                return;
            }
            a(downloadTask);
            a(c.O(), (ServiceConnection) null);
            return;
        }
        String str = e;
        com.ss.android.socialbase.downloader.c.a.b(str, "tryDownload when isServiceAlive");
        e();
        com.ss.android.socialbase.downloader.impls.a D = c.D();
        if (D != null) {
            com.ss.android.socialbase.downloader.c.a.b(str, "tryDownload current task: " + downloadTask.getDownloadId());
            D.a(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(WeakReference weakReference) {
        this.f = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public boolean a() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public IBinder a(Intent intent) {
        com.ss.android.socialbase.downloader.c.a.b(e, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(int i, Notification notification) {
        WeakReference<Service> weakReference = this.f;
        if (weakReference != null && weakReference.get() != null) {
            com.ss.android.socialbase.downloader.c.a.c(e, "startForeground  id = " + i + ", service = " + this.f.get() + ",  isServiceAlive = " + this.b);
            try {
                this.f.get().startForeground(i, notification);
                this.c = true;
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        com.ss.android.socialbase.downloader.c.a.d(e, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(boolean z) {
        WeakReference<Service> weakReference = this.f;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.c(e, "stopForeground  service = " + this.f.get() + ",  isServiceAlive = " + this.b);
        try {
            this.c = false;
            this.f.get().stopForeground(z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.f26268a) {
            try {
                String str = e;
                com.ss.android.socialbase.downloader.c.a.b(str, "pendDownloadTask pendingTasks.size:" + this.f26268a.size() + " downloadId:" + downloadId);
                List<DownloadTask> list = this.f26268a.get(downloadId);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f26268a.put(downloadId, list);
                }
                com.ss.android.socialbase.downloader.c.a.b(str, "before pendDownloadTask taskArray.size:" + list.size());
                list.add(downloadTask);
                com.ss.android.socialbase.downloader.c.a.b(str, "after pendDownloadTask pendingTasks.size:" + this.f26268a.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.o
    public void a(int i) {
        com.ss.android.socialbase.downloader.c.a.a(i);
    }
}
