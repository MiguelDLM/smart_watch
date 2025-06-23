package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.QueueRunner;
import java.util.concurrent.ExecutorService;

/* loaded from: classes7.dex */
class ConcurrentQueueRunner {

    /* renamed from: a, reason: collision with root package name */
    private final QueueRunner f6085a;

    public ConcurrentQueueRunner(final ExecutorService executorService) {
        this.f6085a = new QueueRunner(new QueueRunner.Executor(this) { // from class: com.baidu.mapframework.nirvana.concurrent.ConcurrentQueueRunner.1
            @Override // com.baidu.mapframework.nirvana.QueueRunner.Executor
            public void execute(Runnable runnable) {
                executorService.execute(runnable);
            }
        });
    }

    public void a(Runnable runnable) {
        this.f6085a.execute(runnable);
    }
}
