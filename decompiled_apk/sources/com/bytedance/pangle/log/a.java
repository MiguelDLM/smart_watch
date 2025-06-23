package com.bytedance.pangle.log;

/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f10578a;
    private String b;
    private String c;
    private long d;
    private long e;

    private a(String str, String str2, String str3) {
        this.f10578a = str;
        this.b = str2;
        this.c = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.e = currentTimeMillis;
        this.d = currentTimeMillis;
        ZeusLogger.i(this.f10578a, this.b + String.format(" watcher[%s]-start", str3));
    }

    public static a a(String str, String str2, String str3) {
        return new a(str, str2, str3);
    }

    public final long a(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.e;
        long currentTimeMillis2 = System.currentTimeMillis() - this.d;
        ZeusLogger.i(this.f10578a, this.b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.c, str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)));
        return currentTimeMillis2;
    }

    public final long a() {
        return System.currentTimeMillis() - this.d;
    }
}
