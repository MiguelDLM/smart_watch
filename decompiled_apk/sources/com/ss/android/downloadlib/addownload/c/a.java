package com.ss.android.downloadlib.addownload.c;

import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes11.dex */
public class a implements r {

    /* renamed from: a, reason: collision with root package name */
    private int f25980a;

    private long b(com.ss.android.socialbase.downloader.g.a aVar) {
        long a2 = aVar.a("clear_space_sleep_time", 0L);
        if (a2 <= 0) {
            return 0L;
        }
        if (a2 > 5000) {
            a2 = 5000;
        }
        k.b("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + a2, null);
        try {
            Thread.sleep(a2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        k.b("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return a2;
    }

    public void a(int i) {
        this.f25980a = i;
    }

    @Override // com.ss.android.socialbase.downloader.depend.r
    public boolean a(long j, long j2, q qVar) {
        long j3;
        com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(this.f25980a);
        if (!a(a2)) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        d.a().c();
        long b = m.b(0L);
        a();
        long b2 = m.b(0L);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (b2 < j2) {
            long b3 = b(a2);
            if (b3 > 0) {
                b2 = m.b(0L);
            }
            j3 = b3;
        } else {
            j3 = 0;
        }
        k.b("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + b2 + ", cleaned = " + (b2 - b), null);
        long j4 = b2;
        a(b, b2, j2, currentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (qVar == null) {
            return true;
        }
        qVar.a();
        return true;
    }

    private boolean a(com.ss.android.socialbase.downloader.g.a aVar) {
        if (aVar.a("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - d.a().b() >= aVar.a("clear_space_min_time_interval", 600000L);
    }

    private void a() {
        com.ss.android.download.api.config.e q = com.ss.android.downloadlib.addownload.k.q();
        if (q != null) {
            q.a();
        }
        c.a();
        c.b();
    }

    private void a(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(this.f25980a);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.a.a().a(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
