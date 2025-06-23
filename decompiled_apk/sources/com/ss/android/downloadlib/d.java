package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f26094a;
    private ExecutorService b;
    private ScheduledExecutorService c;
    private ExecutorService d;

    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static d f26096a = new d();
    }

    public static d a() {
        return a.f26096a;
    }

    public void b(Runnable runnable) {
        b(runnable, false);
    }

    public void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        e().execute(runnable);
    }

    public ScheduledExecutorService d() {
        if (this.c == null) {
            synchronized (d.class) {
                try {
                    if (this.c == null) {
                        this.c = new ScheduledThreadPoolExecutor(0, new com.ss.android.socialbase.downloader.h.a(i.class.getName() + "-ScheduledThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    public ExecutorService e() {
        if (this.d == null) {
            synchronized (d.class) {
                try {
                    if (this.d == null) {
                        this.d = new ThreadPoolExecutor(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.h.a(i.class.getName() + "-InstallFinishCheckCPUThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.d;
    }

    public void f() {
        a(new Runnable() { // from class: com.ss.android.downloadlib.d.1
            @Override // java.lang.Runnable
            public void run() {
                j y;
                synchronized (d.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i = 0; i < 13; i++) {
                            SharedPreferences sharedPreferences = k.a().getSharedPreferences(strArr[i], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        y = com.ss.android.socialbase.downloader.downloader.c.y();
                    } catch (Throwable unused) {
                    }
                    if (!(y instanceof com.ss.android.socialbase.downloader.impls.d)) {
                        return;
                    }
                    SparseArray<DownloadInfo> a2 = ((com.ss.android.socialbase.downloader.impls.d) y).a().a();
                    for (int size = a2.size() - 1; size >= 0; size--) {
                        DownloadInfo downloadInfo = a2.get(a2.keyAt(size));
                        if (downloadInfo != null) {
                            Downloader.getInstance(k.a()).clearDownloadData(downloadInfo.getId());
                        }
                    }
                }
            }
        });
    }

    private d() {
    }

    public void a(Runnable runnable) {
        a(runnable, false);
    }

    public void b(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !m.b()) {
            runnable.run();
        } else {
            c().execute(runnable);
        }
    }

    public ExecutorService c() {
        if (this.b == null) {
            synchronized (d.class) {
                try {
                    if (this.b == null) {
                        this.b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.h.a(i.class.getName() + "-IOThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.b;
    }

    public void a(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !m.b()) {
            runnable.run();
        } else {
            b().execute(runnable);
        }
    }

    public ExecutorService b() {
        if (this.f26094a == null) {
            synchronized (d.class) {
                try {
                    if (this.f26094a == null) {
                        this.f26094a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.h.a(i.class.getName() + "-CPUThreadPool"));
                    }
                } finally {
                }
            }
        }
        return this.f26094a;
    }

    public void a(Runnable runnable, long j) {
        try {
            d().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
