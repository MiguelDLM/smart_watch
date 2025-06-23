package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes13.dex */
public class d extends BaseException {

    /* renamed from: a, reason: collision with root package name */
    private final long f26284a;
    private final long b;

    public d(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.f26284a = j;
        this.b = j2;
    }

    public long a() {
        return this.f26284a;
    }

    public long b() {
        return this.b;
    }
}
