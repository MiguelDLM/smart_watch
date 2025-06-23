package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

@kotlin.jvm.internal.XX({"SMAP\nExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,76:1\n26#2:77\n*S KotlinDebug\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n*L\n44#1:77\n*E\n"})
/* loaded from: classes6.dex */
public final class JobCancellationException extends CancellationException implements IoOoX<JobCancellationException> {

    @OXOo.OOXIXo
    @XO0OX.XO
    public final transient oXIO0o0XI job;

    public JobCancellationException(@OXOo.OOXIXo String str, @OXOo.oOoXoXO Throwable th, @OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
        super(str);
        this.job = oxio0o0xi;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // kotlinx.coroutines.IoOoX
    @OXOo.oOoXoXO
    public JobCancellationException createCopy() {
        return null;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(jobCancellationException.getMessage(), getMessage()) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(jobCancellationException.job, this.job) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    @OXOo.OOXIXo
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        int i;
        String message = getMessage();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(message);
        int hashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i = cause.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    @Override // java.lang.Throwable
    @OXOo.OOXIXo
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }
}
