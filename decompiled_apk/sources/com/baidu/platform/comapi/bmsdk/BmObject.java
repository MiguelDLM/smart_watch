package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.util.j;

/* loaded from: classes8.dex */
public abstract class BmObject {

    /* renamed from: a, reason: collision with root package name */
    private String f9577a;
    private String b;
    protected final long g;
    protected final int h;

    private BmObject() {
        this.f9577a = "";
        this.b = "";
        this.h = 0;
        this.g = 0L;
    }

    private void a() {
        long j = this.g;
        if (j != 0) {
            j.a().submit(new c(this, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeFinalizer(long j);

    public String d() {
        return this.f9577a;
    }

    public long e() {
        return this.g;
    }

    public void finalize() throws Throwable {
        try {
            a();
        } catch (Throwable unused) {
        }
        super.finalize();
    }

    public void b(String str) {
        this.f9577a = str;
    }

    public BmObject(int i, long j) {
        this.f9577a = "";
        this.b = "";
        this.h = i;
        this.g = j;
    }
}
