package com.ss.android.socialbase.downloader.i;

/* loaded from: classes13.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private a f26313a;
    private a b;
    private int c;
    private int d = 10;

    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f26314a;
        long b;
        a c;
        a d;

        private a() {
        }
    }

    public boolean a(long j, long j2) {
        synchronized (this) {
            try {
                a aVar = this.f26313a;
                if (aVar != null) {
                    if (j >= aVar.f26314a && j2 >= aVar.b) {
                        a aVar2 = aVar.c;
                        if (aVar2 != null && j2 - aVar2.b < 1000) {
                            aVar.f26314a = j;
                            aVar.b = j2;
                            return true;
                        }
                    }
                    return false;
                }
                a a2 = a();
                a2.f26314a = j;
                a2.b = j2;
                if (aVar != null) {
                    a2.c = aVar;
                    aVar.d = a2;
                }
                this.f26313a = a2;
                return true;
            } finally {
            }
        }
    }

    public long b(long j, long j2) {
        synchronized (this) {
            try {
                a aVar = this.f26313a;
                if (aVar == null) {
                    return -1L;
                }
                a a2 = a(j);
                if (a2 == null) {
                    return -1L;
                }
                long j3 = aVar.f26314a - a2.f26314a;
                long j4 = j2 - a2.b;
                if (j3 < 0 || j4 <= 0) {
                    return -1L;
                }
                return j3 / j4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private a a() {
        a aVar;
        int i = this.c;
        if (i >= this.d && (aVar = this.b) != null) {
            a aVar2 = aVar.d;
            aVar.d = null;
            this.b = aVar2;
            if (aVar2 != null) {
                aVar2.c = null;
            }
            return aVar;
        }
        this.c = i + 1;
        return new a();
    }

    private a a(long j) {
        a aVar = this.f26313a;
        a aVar2 = null;
        while (aVar != null && aVar.b > j) {
            aVar2 = aVar;
            aVar = aVar.c;
        }
        return (aVar == null || aVar2 == null || aVar == aVar2 || j - aVar.b >= aVar2.b - j) ? aVar2 : aVar;
    }
}
