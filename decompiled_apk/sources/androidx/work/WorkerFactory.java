package androidx.work;

import android.content.Context;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public abstract class WorkerFactory {
    private static final ListenableWorker createWorkerWithDefaultFallback$fallbackToReflection(Context context, String str, WorkerParameters workerParameters) {
        String str2;
        try {
            ListenableWorker newInstance = createWorkerWithDefaultFallback$getWorkerClass(str).getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            IIX0o.oO(newInstance, "{\n                val co…Parameters)\n            }");
            return newInstance;
        } catch (Throwable th) {
            Logger logger = Logger.get();
            str2 = WorkerFactoryKt.TAG;
            logger.error(str2, "Could not instantiate " + str, th);
            throw th;
        }
    }

    private static final Class<? extends ListenableWorker> createWorkerWithDefaultFallback$getWorkerClass(String str) {
        String str2;
        try {
            Class asSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
            IIX0o.oO(asSubclass, "{\n                Class.…class.java)\n            }");
            return asSubclass;
        } catch (Throwable th) {
            Logger logger = Logger.get();
            str2 = WorkerFactoryKt.TAG;
            logger.error(str2, "Invalid class: " + str, th);
            throw th;
        }
    }

    @OXOo.oOoXoXO
    public abstract ListenableWorker createWorker(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String str, @OXOo.OOXIXo WorkerParameters workerParameters);

    @OXOo.OOXIXo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ListenableWorker createWorkerWithDefaultFallback(@OXOo.OOXIXo Context appContext, @OXOo.OOXIXo String workerClassName, @OXOo.OOXIXo WorkerParameters workerParameters) {
        IIX0o.x0xO0oo(appContext, "appContext");
        IIX0o.x0xO0oo(workerClassName, "workerClassName");
        IIX0o.x0xO0oo(workerParameters, "workerParameters");
        ListenableWorker createWorker = createWorker(appContext, workerClassName, workerParameters);
        if (createWorker == null) {
            createWorker = createWorkerWithDefaultFallback$fallbackToReflection(appContext, workerClassName, workerParameters);
        }
        if (!createWorker.isUsed()) {
            return createWorker;
        }
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + workerClassName + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
