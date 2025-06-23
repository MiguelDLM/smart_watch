package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: classes11.dex */
public class c extends com.ss.android.socialbase.downloader.i.h<Long, com.ss.android.downloadlib.addownload.b.b> {

    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static c f26003a = new c();
    }

    public static c a() {
        return a.f26003a;
    }

    private c() {
        super(16, 16);
    }

    public void a(com.ss.android.downloadlib.addownload.b.b bVar) {
        if (bVar == null) {
            return;
        }
        put(Long.valueOf(bVar.a()), bVar);
    }

    public com.ss.android.downloadlib.addownload.b.b a(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public com.ss.android.downloadlib.addownload.b.b a(long j) {
        return get(Long.valueOf(j));
    }
}
