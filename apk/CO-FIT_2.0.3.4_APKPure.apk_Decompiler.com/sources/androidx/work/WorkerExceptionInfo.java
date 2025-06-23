package androidx.work;

import OXOo.OOXIXo;
import kotlin.jvm.internal.IIX0o;

public final class WorkerExceptionInfo {
    @OOXIXo
    private final Throwable throwable;
    @OOXIXo
    private final String workerClassName;
    @OOXIXo
    private final WorkerParameters workerParameters;

    public WorkerExceptionInfo(@OOXIXo String str, @OOXIXo WorkerParameters workerParameters2, @OOXIXo Throwable th) {
        IIX0o.x0xO0oo(str, "workerClassName");
        IIX0o.x0xO0oo(workerParameters2, "workerParameters");
        IIX0o.x0xO0oo(th, "throwable");
        this.workerClassName = str;
        this.workerParameters = workerParameters2;
        this.throwable = th;
    }

    @OOXIXo
    public final Throwable getThrowable() {
        return this.throwable;
    }

    @OOXIXo
    public final String getWorkerClassName() {
        return this.workerClassName;
    }

    @OOXIXo
    public final WorkerParameters getWorkerParameters() {
        return this.workerParameters;
    }
}
