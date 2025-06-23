package androidx.work;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.IIX0o;

public abstract class WorkerFactory {
    private static final ListenableWorker createWorkerWithDefaultFallback$fallbackToReflection(Context context, String str, WorkerParameters workerParameters) {
        try {
            Object newInstance = createWorkerWithDefaultFallback$getWorkerClass(str).getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
            IIX0o.oO(newInstance, "{\n                val co…Parameters)\n            }");
            return (ListenableWorker) newInstance;
        } catch (Throwable th) {
            Logger logger = Logger.get();
            String access$getTAG$p = WorkerFactoryKt.TAG;
            logger.error(access$getTAG$p, "Could not instantiate " + str, th);
            throw th;
        }
    }

    private static final Class<? extends ListenableWorker> createWorkerWithDefaultFallback$getWorkerClass(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
            IIX0o.oO(asSubclass, "{\n                Class.…class.java)\n            }");
            return asSubclass;
        } catch (Throwable th) {
            Logger logger = Logger.get();
            String access$getTAG$p = WorkerFactoryKt.TAG;
            logger.error(access$getTAG$p, "Invalid class: " + str, th);
            throw th;
        }
    }

    @oOoXoXO
    public abstract ListenableWorker createWorker(@OOXIXo Context context, @OOXIXo String str, @OOXIXo WorkerParameters workerParameters);

    @OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ListenableWorker createWorkerWithDefaultFallback(@OOXIXo Context context, @OOXIXo String str, @OOXIXo WorkerParameters workerParameters) {
        IIX0o.x0xO0oo(context, "appContext");
        IIX0o.x0xO0oo(str, "workerClassName");
        IIX0o.x0xO0oo(workerParameters, "workerParameters");
        ListenableWorker createWorker = createWorker(context, str, workerParameters);
        if (createWorker == null) {
            createWorker = createWorkerWithDefaultFallback$fallbackToReflection(context, str, workerParameters);
        }
        if (!createWorker.isUsed()) {
            return createWorker;
        }
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + str + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
