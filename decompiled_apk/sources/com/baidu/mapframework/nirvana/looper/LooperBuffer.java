package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import android.os.Looper;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import java.util.LinkedList;

/* loaded from: classes7.dex */
public class LooperBuffer {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6093a;
    private volatile int d = 0;
    private Handler e = new Handler(Looper.getMainLooper());
    private long f = 0;
    private volatile boolean b = false;
    private final LinkedList<Runnable> c = new LinkedList<>();

    public LooperBuffer(boolean z) {
        this.f6093a = z;
    }

    public static /* synthetic */ int a(LooperBuffer looperBuffer) {
        int i = looperBuffer.d;
        looperBuffer.d = i - 1;
        return i;
    }

    private void d() {
        synchronized (this.c) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                while (!this.c.isEmpty() && System.currentTimeMillis() - currentTimeMillis < 16) {
                    this.c.removeFirst().run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!this.c.isEmpty()) {
            e();
        }
    }

    private void e() {
        if (this.d >= 3) {
            return;
        }
        this.d++;
        LooperManager.executeTask(Module.BASE_FRAMEWORK_MODULE, new LooperTask() { // from class: com.baidu.mapframework.nirvana.looper.LooperBuffer.1
            @Override // java.lang.Runnable
            public void run() {
                LooperBuffer.a(LooperBuffer.this);
            }
        }, ScheduleConfig.forData());
    }

    public void run(Runnable runnable) {
        if (!this.f6093a) {
            runnable.run();
            return;
        }
        a(runnable);
        if (!this.b) {
            d();
        }
    }

    public synchronized void startAnim() {
        this.b = true;
        b();
    }

    public synchronized void stopAnim() {
        this.b = false;
        c();
        e();
    }

    private void a(Runnable runnable) {
        synchronized (this.c) {
            this.c.addLast(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        try {
            if (this.f == 0) {
                this.f = System.currentTimeMillis();
            }
            this.e.postDelayed(new Runnable() { // from class: com.baidu.mapframework.nirvana.looper.LooperBuffer.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!LooperBuffer.this.a()) {
                        LooperBuffer.this.b();
                    }
                }
            }, 100L);
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void c() {
        this.f = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a() {
        if (this.b && this.f != 0) {
            if (System.currentTimeMillis() - this.f > 800) {
                stopAnim();
            }
            return false;
        }
        return true;
    }
}
