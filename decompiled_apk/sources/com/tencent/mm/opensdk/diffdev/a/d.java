package com.tencent.mm.opensdk.diffdev.a;

/* loaded from: classes13.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);


    /* renamed from: a, reason: collision with root package name */
    private int f26939a;

    d(int i) {
        this.f26939a = i;
    }

    public int a() {
        return this.f26939a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f26939a;
    }
}
