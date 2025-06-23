package com.baidu.mapframework.nirvana.looper;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.mapframework.nirvana.Utils;
import java.util.LinkedList;

/* loaded from: classes7.dex */
class IdleRunner {
    private static final boolean e;
    private final Handler b;
    private final MessageQueue.IdleHandler d = new MessageQueue.IdleHandler() { // from class: com.baidu.mapframework.nirvana.looper.IdleRunner.1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            try {
                if (!IdleRunner.this.f6091a.isEmpty()) {
                    ((Runnable) IdleRunner.this.f6091a.removeFirst()).run();
                }
            } catch (Exception e2) {
                Utils.loge("IdleRunner idleHandler exception", e2);
            }
            synchronized (IdleRunner.this) {
                try {
                    if (IdleRunner.this.f6091a.isEmpty()) {
                        IdleRunner.this.c = false;
                        return false;
                    }
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<Runnable> f6091a = new LinkedList<>();
    private boolean c = false;

    static {
        boolean z;
        if (Build.VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        e = z;
    }

    public IdleRunner(Handler handler) {
        this.b = handler;
    }

    public void a(Runnable runnable) {
        MessageQueue queue;
        if (e) {
            synchronized (this) {
                try {
                    this.f6091a.addLast(runnable);
                    if (!this.c) {
                        this.c = true;
                        queue = Looper.getMainLooper().getQueue();
                        queue.addIdleHandler(this.d);
                    }
                } finally {
                }
            }
            return;
        }
        this.b.post(runnable);
    }
}
