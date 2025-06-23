package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes13.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected Notification f26423a;
    private int b;
    private long c;
    private long d;
    private String e;
    private int f = 0;
    private long g;
    private int h;
    private boolean i;

    public a(int i, String str) {
        this.b = i;
        this.e = str;
    }

    public abstract void a(BaseException baseException, boolean z);

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.b = downloadInfo.getId();
        this.e = downloadInfo.getTitle();
    }

    public long b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public long f() {
        if (this.g == 0) {
            this.g = System.currentTimeMillis();
        }
        return this.g;
    }

    public synchronized void g() {
        this.h++;
    }

    public boolean h() {
        return this.i;
    }

    public void b(long j) {
        this.d = j;
    }

    public int a() {
        return this.b;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(int i, BaseException baseException, boolean z) {
        a(i, baseException, z, false);
    }

    public void a(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f != i) {
            this.f = i;
            a(baseException, z);
        }
    }

    public void a(long j, long j2) {
        this.c = j;
        this.d = j2;
        this.f = 4;
        a((BaseException) null, false);
    }

    public void a(Notification notification) {
        if (this.b == 0 || notification == null) {
            return;
        }
        b.a().a(this.b, this.f, notification);
    }
}
