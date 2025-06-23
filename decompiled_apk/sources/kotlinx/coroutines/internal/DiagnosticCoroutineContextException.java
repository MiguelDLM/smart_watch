package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

@kotlin.jvm.internal.XX({"SMAP\nCoroutineExceptionHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/DiagnosticCoroutineContextException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,50:1\n26#2:51\n*S KotlinDebug\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/DiagnosticCoroutineContextException\n*L\n46#1:51\n*E\n"})
/* loaded from: classes6.dex */
public final class DiagnosticCoroutineContextException extends RuntimeException {

    @OXOo.OOXIXo
    private final transient CoroutineContext context;

    public DiagnosticCoroutineContextException(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        this.context = coroutineContext;
    }

    @Override // java.lang.Throwable
    @OXOo.OOXIXo
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    @OXOo.OOXIXo
    public String getLocalizedMessage() {
        return this.context.toString();
    }
}
