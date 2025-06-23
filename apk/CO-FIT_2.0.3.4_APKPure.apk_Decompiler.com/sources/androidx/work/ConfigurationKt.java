package androidx.work;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.oxoX;
import kotlin.jvm.internal.IIX0o;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.O00XxXI;

public final class ConfigurationKt {
    public static final int DEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT = 8;

    /* access modifiers changed from: private */
    public static final Executor asExecutor(CoroutineContext coroutineContext) {
        oxoX oxox;
        CoroutineDispatcher coroutineDispatcher;
        if (coroutineContext != null) {
            oxox = (oxoX) coroutineContext.get(oxoX.f18959Oxx0IOOO);
        } else {
            oxox = null;
        }
        if (oxox instanceof CoroutineDispatcher) {
            coroutineDispatcher = (CoroutineDispatcher) oxox;
        } else {
            coroutineDispatcher = null;
        }
        if (coroutineDispatcher != null) {
            return O00XxXI.II0xO0(coroutineDispatcher);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Executor createDefaultExecutor(boolean z) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ConfigurationKt$createDefaultExecutor$factory$1(z));
        IIX0o.oO(newFixedThreadPool, "newFixedThreadPool(\n    …)),\n        factory\n    )");
        return newFixedThreadPool;
    }

    /* access modifiers changed from: private */
    public static final Tracer createDefaultTracer() {
        return new ConfigurationKt$createDefaultTracer$tracer$1();
    }
}
