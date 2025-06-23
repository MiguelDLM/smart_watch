package com.huawei.openalliance.ad.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;

/* loaded from: classes10.dex */
public class t {
    private static final String Code = "HandlerExecAgent";
    private static final long I = 60000;
    private static final String V = "handler_exec_release_task";
    private static final String Z = "handler_exec_thread";
    private final byte[] B = new byte[0];
    private final byte[] C = new byte[0];
    private HandlerThread D;
    private s F;
    private int L;
    private final String S;

    /* loaded from: classes10.dex */
    public static class a {
        static final int Code = 1;
        static final int V = 2;
        String B;
        long C;
        int I;
        Runnable Z;

        public a(int i, Runnable runnable, String str, long j) {
            this.I = i;
            this.Z = runnable;
            this.B = str;
            this.C = j;
        }

        public String toString() {
            return "CacheTask{taskType=" + this.I + ", id='" + this.B + "'}";
        }
    }

    public t(String str) {
        this.S = TextUtils.isEmpty(str) ? Z : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (Z()) {
            synchronized (this.C) {
                try {
                    if (this.D == null) {
                        fb.V(Code, "init handler thread");
                        HandlerThread handlerThread = new HandlerThread(this.S);
                        handlerThread.start();
                        Looper looper = handlerThread.getLooper();
                        if (looper != null) {
                            this.D = handlerThread;
                            Code(new s(new Handler(looper)));
                        } else {
                            handlerThread.quit();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public s C() {
        s sVar;
        synchronized (this.B) {
            sVar = this.F;
        }
        return sVar;
    }

    private void I() {
        s C = C();
        if (C != null) {
            fb.V(Code, "delay quit thread");
            C.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.t.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (t.this.C) {
                        try {
                            if (t.this.D != null) {
                                t.this.D.quitSafely();
                                t.this.D = null;
                            }
                            t.this.Code((s) null);
                            fb.V(t.Code, "quit thread and release");
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }, V, 60000L);
        }
    }

    private boolean Z() {
        boolean z;
        synchronized (this.B) {
            z = this.L > 0;
        }
        return z;
    }

    public void Code() {
        synchronized (this.B) {
            try {
                this.L++;
                s C = C();
                if (C != null) {
                    C.Code(V);
                }
                if (fb.Code()) {
                    fb.Code(Code, "acquire exec agent. ref count: %d", Integer.valueOf(this.L));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void V() {
        synchronized (this.B) {
            try {
                if (!Z()) {
                    fb.V(Code, "release exec agent - not working");
                    return;
                }
                int i = this.L - 1;
                this.L = i;
                if (i <= 0) {
                    this.L = 0;
                    I();
                }
                if (fb.Code()) {
                    fb.Code(Code, "release exec agent - ref count: %d", Integer.valueOf(this.L));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(s sVar) {
        synchronized (this.B) {
            this.F = sVar;
        }
    }

    private void Code(final a aVar) {
        h.Z(new Runnable() { // from class: com.huawei.openalliance.ad.utils.t.2
            @Override // java.lang.Runnable
            public void run() {
                t.this.B();
                s C = t.this.C();
                if (C != null) {
                    a aVar2 = aVar;
                    int i = aVar2.I;
                    if (i == 1) {
                        C.Code(aVar2.Z, aVar2.B, aVar2.C);
                    } else if (i == 2) {
                        C.Code(aVar2.B);
                    }
                }
            }
        });
    }

    public void Code(Runnable runnable) {
        if (Z()) {
            s C = C();
            if (C != null) {
                C.Code(runnable);
            } else {
                Code(new a(1, runnable, null, 0L));
            }
        }
    }

    public void Code(Runnable runnable, String str, long j) {
        if (Z()) {
            s C = C();
            if (C != null) {
                C.Code(runnable, str, j);
            } else {
                Code(new a(1, runnable, str, j));
            }
        }
    }

    public void Code(String str) {
        if (Z()) {
            s C = C();
            if (C != null) {
                C.Code(str);
            } else {
                Code(new a(2, null, str, 0L));
            }
        }
    }
}
