package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes13.dex */
public class b {
    private static volatile b c;
    private static final Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final long f26424a = 1000;
    private final Map<Integer, Long> b = new HashMap();
    private final Set<String> d = new HashSet();
    private final SparseArray<a> f = new SparseArray<>();

    private b() {
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                try {
                    if (c == null) {
                        c = new b();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static boolean b(int i) {
        return i == 1 || i == 3;
    }

    public static boolean c(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && b(downloadInfo.getNotificationVisibility());
    }

    public a d(int i) {
        a aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f) {
            try {
                aVar = this.f.get(i);
                if (aVar != null) {
                    this.f.remove(i);
                    com.ss.android.socialbase.downloader.c.a.a("removeNotificationId " + i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public a e(int i) {
        a aVar;
        if (i == 0) {
            return null;
        }
        synchronized (this.f) {
            aVar = this.f.get(i);
        }
        return aVar;
    }

    public void f(int i) {
        d(i);
        if (i != 0) {
            a().c(i);
        }
    }

    public void b(DownloadInfo downloadInfo) {
        if (c(downloadInfo)) {
            f(downloadInfo.getId());
        }
    }

    public void c(int i) {
        Context O = c.O();
        if (O == null || i == 0) {
            return;
        }
        try {
            Intent intent = new Intent(O, (Class<?>) DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            O.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public SparseArray<a> b() {
        SparseArray<a> sparseArray;
        synchronized (this.f) {
            sparseArray = this.f;
        }
        return sparseArray;
    }

    public void a(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(c.O()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        a(downloadInfo);
        b(downloadInfo);
    }

    public void a(DownloadInfo downloadInfo) {
        j y = c.y();
        if (y != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                y.a(downloadInfo);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(int i, int i2, Notification notification) {
        Context O = c.O();
        if (O == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.b) {
                try {
                    Long l = this.b.get(Integer.valueOf(i));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l != null && Math.abs(currentTimeMillis - l.longValue()) < 1000) {
                        return;
                    } else {
                        this.b.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
                    }
                } finally {
                }
            }
        }
        try {
            Intent intent = new Intent(O, (Class<?>) DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            O.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f) {
            this.f.put(aVar.a(), aVar);
        }
    }
}
