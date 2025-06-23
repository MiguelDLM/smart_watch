package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes13.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.m f26380a;
    private static volatile com.ss.android.socialbase.downloader.downloader.m b;

    public static com.ss.android.socialbase.downloader.downloader.m a(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.c.T()) {
            if (b == null) {
                synchronized (l.class) {
                    try {
                        if (b == null) {
                            b = com.ss.android.socialbase.downloader.downloader.c.U().b();
                        }
                    } finally {
                    }
                }
            }
            return b;
        }
        if (f26380a == null) {
            synchronized (l.class) {
                try {
                    if (f26380a == null) {
                        f26380a = new p();
                    }
                } finally {
                }
            }
        }
        return f26380a;
    }
}
