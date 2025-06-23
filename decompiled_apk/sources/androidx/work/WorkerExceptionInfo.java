package androidx.work;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class WorkerExceptionInfo {

    @OXOo.OOXIXo
    private final Throwable throwable;

    @OXOo.OOXIXo
    private final String workerClassName;

    @OXOo.OOXIXo
    private final WorkerParameters workerParameters;

    public WorkerExceptionInfo(@OXOo.OOXIXo String workerClassName, @OXOo.OOXIXo WorkerParameters workerParameters, @OXOo.OOXIXo Throwable throwable) {
        IIX0o.x0xO0oo(workerClassName, "workerClassName");
        IIX0o.x0xO0oo(workerParameters, "workerParameters");
        IIX0o.x0xO0oo(throwable, "throwable");
        this.workerClassName = workerClassName;
        this.workerParameters = workerParameters;
        this.throwable = throwable;
    }

    @OXOo.OOXIXo
    public final Throwable getThrowable() {
        return this.throwable;
    }

    @OXOo.OOXIXo
    public final String getWorkerClassName() {
        return this.workerClassName;
    }

    @OXOo.OOXIXo
    public final WorkerParameters getWorkerParameters() {
        return this.workerParameters;
    }
}
