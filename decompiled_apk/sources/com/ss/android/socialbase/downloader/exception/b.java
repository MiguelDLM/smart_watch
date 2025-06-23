package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes13.dex */
public class b extends BaseException {

    /* renamed from: a, reason: collision with root package name */
    private final int f26283a;

    public b(int i, int i2, String str) {
        super(i, str);
        this.f26283a = i2;
    }

    public int a() {
        return this.f26283a;
    }
}
