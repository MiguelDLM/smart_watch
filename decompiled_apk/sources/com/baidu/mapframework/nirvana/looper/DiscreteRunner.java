package com.baidu.mapframework.nirvana.looper;

import android.os.Handler;
import com.baidu.mapframework.nirvana.QueueRunner;

/* loaded from: classes7.dex */
public class DiscreteRunner {

    /* renamed from: a, reason: collision with root package name */
    private final QueueRunner f6089a;

    public DiscreteRunner(final Handler handler) {
        this.f6089a = new QueueRunner(new QueueRunner.Executor(this) { // from class: com.baidu.mapframework.nirvana.looper.DiscreteRunner.1
            @Override // com.baidu.mapframework.nirvana.QueueRunner.Executor
            public void execute(Runnable runnable) {
                handler.postDelayed(runnable, 16L);
            }
        });
    }

    public void a(Runnable runnable) {
        this.f6089a.execute(runnable);
    }

    public void a() {
        this.f6089a.shutdown();
    }
}
