package androidx.work;

import androidx.tracing.Trace;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.O00XxXI;

/* loaded from: classes.dex */
public final class ConfigurationKt {
    public static final int DEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT = 8;

    public static final /* synthetic */ Executor access$asExecutor(CoroutineContext coroutineContext) {
        return asExecutor(coroutineContext);
    }

    public static final /* synthetic */ Executor access$createDefaultExecutor(boolean z) {
        return createDefaultExecutor(z);
    }

    public static final /* synthetic */ Tracer access$createDefaultTracer() {
        return createDefaultTracer();
    }

    public static final Executor asExecutor(CoroutineContext coroutineContext) {
        kotlin.coroutines.oxoX oxox;
        CoroutineDispatcher coroutineDispatcher;
        if (coroutineContext != null) {
            oxox = (kotlin.coroutines.oxoX) coroutineContext.get(kotlin.coroutines.oxoX.f29196Oxx0IOOO);
        } else {
            oxox = null;
        }
        if (oxox instanceof CoroutineDispatcher) {
            coroutineDispatcher = (CoroutineDispatcher) oxox;
        } else {
            coroutineDispatcher = null;
        }
        if (coroutineDispatcher == null) {
            return null;
        }
        return O00XxXI.II0xO0(coroutineDispatcher);
    }

    public static final Executor createDefaultExecutor(final boolean z) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.ConfigurationKt$createDefaultExecutor$factory$1
            private final AtomicInteger threadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                String str;
                IIX0o.x0xO0oo(runnable, "runnable");
                if (z) {
                    str = "WM.task-";
                } else {
                    str = "androidx.work-";
                }
                return new Thread(runnable, str + this.threadCount.incrementAndGet());
            }
        });
        IIX0o.oO(newFixedThreadPool, "newFixedThreadPool(\n    …)),\n        factory\n    )");
        return newFixedThreadPool;
    }

    public static final Tracer createDefaultTracer() {
        return new Tracer() { // from class: androidx.work.ConfigurationKt$createDefaultTracer$tracer$1
            @Override // androidx.work.Tracer
            public void beginAsyncSection(String methodName, int i) {
                IIX0o.x0xO0oo(methodName, "methodName");
                Trace.beginAsyncSection(methodName, i);
            }

            @Override // androidx.work.Tracer
            public void beginSection(String label) {
                IIX0o.x0xO0oo(label, "label");
                Trace.beginSection(label);
            }

            @Override // androidx.work.Tracer
            public void endAsyncSection(String methodName, int i) {
                IIX0o.x0xO0oo(methodName, "methodName");
                Trace.endAsyncSection(methodName, i);
            }

            @Override // androidx.work.Tracer
            public void endSection() {
                Trace.endSection();
            }

            @Override // androidx.work.Tracer
            public boolean isEnabled() {
                return Trace.isEnabled();
            }
        };
    }
}
