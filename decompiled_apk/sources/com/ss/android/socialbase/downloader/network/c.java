package com.ss.android.socialbase.downloader.network;

import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

/* loaded from: classes13.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.i.h<String, b> f26409a;
    private final Handler b;
    private final Handler c;

    /* loaded from: classes13.dex */
    public interface a {
        void a(String str, List<InetAddress> list);
    }

    /* loaded from: classes13.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        List<InetAddress> f26412a;
        long b;

        private b() {
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.c$c, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C1080c {

        /* renamed from: a, reason: collision with root package name */
        private static final c f26413a = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|a|(2:8|(1:(2:11|12)(1:14)))|15|(6:19|20|(3:36|37|38)|(3:28|29|(2:31|32)(1:33))|29|(0)(0))|45|(1:22)|36|37|38|(4:25|28|29|(0)(0))|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
    
        r10 = r2.f26412a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0078, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0093 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #3 {all -> 0x003b, blocks: (B:2:0x0000, B:3:0x000a, B:8:0x0016, B:11:0x0035, B:15:0x003e, B:17:0x0056, B:22:0x0068, B:25:0x007d, B:28:0x0084, B:29:0x008c, B:31:0x0093, B:35:0x008a, B:36:0x006e, B:41:0x0078, B:44:0x0062, B:49:0x0099, B:20:0x005c, B:38:0x0072, B:5:0x000b, B:6:0x0013), top: B:1:0x0000, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(final java.lang.String r8, final com.ss.android.socialbase.downloader.network.c.a r9, long r10) {
        /*
            r7 = this;
            android.net.Uri r0 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r0.getHost()     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.i.h<java.lang.String, com.ss.android.socialbase.downloader.network.c$b> r1 = r7.f26409a     // Catch: java.lang.Throwable -> L3b
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.i.h<java.lang.String, com.ss.android.socialbase.downloader.network.c$b> r2 = r7.f26409a     // Catch: java.lang.Throwable -> L97
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L97
            com.ss.android.socialbase.downloader.network.c$b r2 = (com.ss.android.socialbase.downloader.network.c.b) r2     // Catch: java.lang.Throwable -> L97
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L97
            if (r2 == 0) goto L3e
            com.ss.android.socialbase.downloader.g.a r1 = com.ss.android.socialbase.downloader.g.a.c()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "dns_expire_min"
            r4 = 10
            int r1 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> L3b
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L3b
            long r5 = r2.b     // Catch: java.lang.Throwable -> L3b
            long r3 = r3 - r5
            r5 = 60000(0xea60, float:8.4078E-41)
            int r1 = r1 * r5
            long r5 = (long) r1     // Catch: java.lang.Throwable -> L3b
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L3e
            if (r9 == 0) goto L3d
            java.util.List<java.net.InetAddress> r10 = r2.f26412a     // Catch: java.lang.Throwable -> L3b
            r9.a(r8, r10)     // Catch: java.lang.Throwable -> L3b
            goto L3d
        L3b:
            r8 = move-exception
            goto L9a
        L3d:
            return
        L3e:
            com.ss.android.socialbase.downloader.network.c$2 r1 = new com.ss.android.socialbase.downloader.network.c$2     // Catch: java.lang.Throwable -> L3b
            r1.<init>()     // Catch: java.lang.Throwable -> L3b
            android.os.Handler r3 = r7.c     // Catch: java.lang.Throwable -> L3b
            r3.postDelayed(r1, r10)     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.g.a r10 = com.ss.android.socialbase.downloader.g.a.c()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r11 = "use_host_dns"
            r3 = 1
            int r10 = r10.a(r11, r3)     // Catch: java.lang.Throwable -> L3b
            if (r10 != r3) goto L65
            com.ss.android.socialbase.downloader.network.f r10 = com.ss.android.socialbase.downloader.downloader.c.v()     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L65
            java.util.List r10 = r10.a(r0)     // Catch: java.lang.Throwable -> L61
            goto L66
        L61:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L3b
        L65:
            r10 = 0
        L66:
            if (r10 == 0) goto L6e
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r11 == 0) goto L7b
        L6e:
            com.ss.android.socialbase.downloader.network.f r11 = com.ss.android.socialbase.downloader.downloader.c.w()     // Catch: java.lang.Throwable -> L3b
            java.util.List r10 = r11.a(r0)     // Catch: java.lang.Throwable -> L77
            goto L7b
        L77:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L3b
        L7b:
            if (r10 == 0) goto L88
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r11 == 0) goto L84
            goto L88
        L84:
            r7.a(r0, r10)     // Catch: java.lang.Throwable -> L3b
            goto L8c
        L88:
            if (r2 == 0) goto L8c
            java.util.List<java.net.InetAddress> r10 = r2.f26412a     // Catch: java.lang.Throwable -> L3b
        L8c:
            android.os.Handler r11 = r7.c     // Catch: java.lang.Throwable -> L3b
            r11.removeCallbacks(r1)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L9d
            r9.a(r8, r10)     // Catch: java.lang.Throwable -> L3b
            goto L9d
        L97:
            r8 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L97
            throw r8     // Catch: java.lang.Throwable -> L3b
        L9a:
            r8.printStackTrace()
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.network.c.b(java.lang.String, com.ss.android.socialbase.downloader.network.c$a, long):void");
    }

    private c() {
        this.f26409a = new com.ss.android.socialbase.downloader.i.h<>(4, 16, false);
        this.b = new Handler(com.ss.android.socialbase.downloader.network.a.b.a());
        this.c = new Handler(com.ss.android.socialbase.downloader.h.e.a());
    }

    public static c a() {
        return C1080c.f26413a;
    }

    public void a(final String str, final a aVar, final long j) {
        this.b.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(str, aVar, j);
            }
        });
    }

    private void a(String str, List<InetAddress> list) {
        synchronized (this.f26409a) {
            try {
                b bVar = this.f26409a.get(str);
                if (bVar == null) {
                    bVar = new b();
                    this.f26409a.put(str, bVar);
                }
                bVar.f26412a = list;
                bVar.b = System.currentTimeMillis();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
