package com.baidu.mapframework.nirvana;

import java.util.LinkedList;

/* loaded from: classes7.dex */
public class QueueRunner {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f6079a;
    private final LinkedList<Runnable> b = new LinkedList<>();
    private Runnable c;

    /* loaded from: classes7.dex */
    public interface Executor {
        void execute(Runnable runnable);
    }

    public QueueRunner(Executor executor) {
        this.f6079a = executor;
    }

    public void execute(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.c == null) {
                    this.c = runnable;
                    this.f6079a.execute(a(runnable));
                } else {
                    this.b.addLast(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void shutdown() {
        synchronized (this) {
            this.c = null;
            this.b.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable a(final Runnable runnable) {
        return new Runnable() { // from class: com.baidu.mapframework.nirvana.QueueRunner.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
                synchronized (QueueRunner.this) {
                    try {
                        if (QueueRunner.this.b.isEmpty()) {
                            QueueRunner.this.c = null;
                        } else {
                            QueueRunner queueRunner = QueueRunner.this;
                            queueRunner.c = (Runnable) queueRunner.b.removeFirst();
                            Executor executor = QueueRunner.this.f6079a;
                            QueueRunner queueRunner2 = QueueRunner.this;
                            executor.execute(queueRunner2.a(queueRunner2.c));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
    }
}
