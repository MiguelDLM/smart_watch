package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes13.dex */
public final class bg extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public bf f26595a;
    private a g;
    private boolean c = false;
    private boolean d = true;
    private boolean e = false;
    private int f = 1;
    public boolean b = true;

    /* loaded from: classes13.dex */
    public interface a {
    }

    public final boolean a() {
        this.c = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e) {
            al.b(e);
        }
        al.d("MainHandlerChecker is reset to null.", new Object[0]);
        this.f26595a = null;
        return true;
    }

    public final boolean b() {
        Handler handler = new Handler(Looper.getMainLooper());
        bf bfVar = this.f26595a;
        if (bfVar != null) {
            bfVar.b = 5000L;
        } else {
            this.f26595a = new bf(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e) {
            al.b(e);
            return false;
        }
    }

    public final synchronized void c() {
        this.d = false;
        al.c("Record stack trace is disabled.", new Object[0]);
    }

    public final synchronized void d() {
        this.e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
    
        r2.d();
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
        L4:
            boolean r2 = r10.c
            if (r2 != 0) goto L9e
            com.tencent.bugly.proguard.bf r2 = r10.f26595a     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r3 = 0
            if (r2 != 0) goto L1b
            java.lang.String r2 = "Main handler checker is null. Stop thread monitor."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            com.tencent.bugly.proguard.al.c(r2, r3)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            return
        L15:
            r2 = move-exception
            goto L94
        L18:
            r2 = move-exception
            goto L99
        L1b:
            boolean r4 = r2.c     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            if (r4 == 0) goto L2c
            r2.c = r3     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r2.d = r4     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            android.os.Handler r4 = r2.f26594a     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r4.post(r2)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
        L2c:
            r10.a(r2)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            boolean r4 = r10.b     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            if (r4 == 0) goto L73
            boolean r4 = r10.d     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            if (r4 != 0) goto L38
            goto L73
        L38:
            long r4 = r2.b()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r6 = 1510(0x5e6, double:7.46E-321)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L73
            r6 = 199990(0x30d36, double:9.8808E-319)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L4a
            goto L73
        L4a:
            r6 = 5010(0x1392, double:2.4753E-320)
            r8 = 1
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 > 0) goto L5d
            r10.f = r8     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            java.lang.String r4 = "timeSinceMsgSent in [2s, 5s], record stack"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            com.tencent.bugly.proguard.al.c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r3 = 1
            goto L73
        L5d:
            int r4 = r10.f     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            int r5 = r4 + 1
            r10.f = r5     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r4 = r4 & r5
            if (r4 != 0) goto L67
            goto L68
        L67:
            r8 = 0
        L68:
            if (r8 == 0) goto L72
            java.lang.String r4 = "timeSinceMsgSent in (5s, 200s), should record stack:true"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            com.tencent.bugly.proguard.al.c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
        L72:
            r3 = r8
        L73:
            if (r3 == 0) goto L78
            r2.d()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
        L78:
            com.tencent.bugly.proguard.bg$a r3 = r10.g     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            if (r3 == 0) goto L86
            boolean r3 = r10.d     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            if (r3 == 0) goto L86
            r2.a()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r2.b()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
        L86:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            long r2 = r2 - r0
            r4 = 500(0x1f4, double:2.47E-321)
            long r2 = r2 % r4
            long r4 = r4 - r2
            com.tencent.bugly.proguard.ap.b(r4)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            goto L4
        L94:
            com.tencent.bugly.proguard.al.b(r2)
            goto L4
        L99:
            com.tencent.bugly.proguard.al.b(r2)
            goto L4
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bg.run():void");
    }

    private synchronized void a(bf bfVar) {
        if (this.d) {
            return;
        }
        if (this.e && !bfVar.a()) {
            al.c("Restart getting main stack trace.", new Object[0]);
            this.d = true;
            this.e = false;
        }
    }
}
