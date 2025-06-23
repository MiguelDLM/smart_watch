package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes8.dex */
public abstract class h3 implements i3 {

    /* renamed from: a, reason: collision with root package name */
    public final Lock f10102a;
    public final Condition b;

    public h3() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f10102a = reentrantLock;
        this.b = reentrantLock.newCondition();
    }

    public boolean b() {
        while (c()) {
            try {
                try {
                    this.f10102a.lock();
                    LoggerProxy.d("ASafeLife", "before await");
                    this.b.await();
                    LoggerProxy.d("ASafeLife", "after await");
                    this.f10102a.unlock();
                } finally {
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (d()) {
            return false;
        }
        return true;
    }

    public abstract boolean c();

    @Override // com.baidu.tts.i3
    public synchronized TtsError create() {
        return e();
    }

    public abstract boolean d();

    @Override // com.baidu.tts.i3
    public synchronized void destroy() {
        f();
    }

    public abstract TtsError e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    @Override // com.baidu.tts.i3
    public synchronized void pause() {
        g();
    }

    @Override // com.baidu.tts.i3
    public synchronized void resume() {
        h();
        try {
            try {
                this.f10102a.lock();
                this.b.signalAll();
            } finally {
                this.f10102a.unlock();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tts.i3
    public synchronized void start() {
        i();
    }

    @Override // com.baidu.tts.i3
    public synchronized void stop() {
        j();
    }
}
