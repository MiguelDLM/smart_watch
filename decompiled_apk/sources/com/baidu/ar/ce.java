package com.baidu.ar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes7.dex */
public class ce extends Handler {
    private final cg md;

    /* renamed from: me, reason: collision with root package name */
    private final int f5563me;
    private final cd mf;
    private boolean mg;
    private boolean mh;

    public ce(cd cdVar, Looper looper, int i) {
        super(looper);
        this.mh = false;
        this.mf = cdVar;
        this.f5563me = i;
        this.md = new cg();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            while (!this.mh) {
                cf cq = this.md.cq();
                if (cq == null) {
                    synchronized (this) {
                        cq = this.md.cq();
                        if (cq == null) {
                            this.mg = false;
                            return;
                        }
                    }
                }
                this.mf.a(cq);
                if (SystemClock.uptimeMillis() - uptimeMillis >= this.f5563me) {
                    if (!sendMessage(obtainMessage())) {
                        kf.cl("Could not send handler message");
                    }
                    this.mg = true;
                    return;
                }
            }
            this.mg = false;
        } catch (Throwable th) {
            this.mg = false;
            throw th;
        }
    }

    public void release() {
        this.mh = true;
    }
}
