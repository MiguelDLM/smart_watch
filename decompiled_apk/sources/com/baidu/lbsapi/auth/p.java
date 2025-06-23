package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class p extends Thread {

    /* renamed from: a, reason: collision with root package name */
    Handler f5597a;
    private Object b;
    private boolean c;

    public p() {
        this.f5597a = null;
        this.b = new Object();
        this.c = false;
    }

    public void a() {
        if (b.f5584a) {
            b.a("Looper thread quit()");
        }
        Handler handler = this.f5597a;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.f5597a.getLooper().quit();
    }

    public void b() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    this.b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.b) {
            this.c = true;
            this.b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f5597a = new Handler();
        if (b.f5584a) {
            b.a("new Handler() finish!!");
        }
        Looper.loop();
        if (b.f5584a) {
            b.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }

    public p(String str) {
        super(str);
        this.f5597a = null;
        this.b = new Object();
        this.c = false;
    }
}
