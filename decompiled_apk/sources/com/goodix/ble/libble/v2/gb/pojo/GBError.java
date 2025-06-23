package com.goodix.ble.libble.v2.gb.pojo;

/* loaded from: classes9.dex */
public class GBError extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private int f16148a;

    public GBError(int i, String str) {
        super(str);
        this.f16148a = i;
    }

    public int getErrorCode() {
        return this.f16148a;
    }

    public GBError(int i, String str, Throwable th) {
        super(str, th);
        this.f16148a = i;
    }
}
