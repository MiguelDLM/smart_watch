package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nFlowExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowExceptions.kt\nkotlinx/coroutines/flow/internal/AbortFlowException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,30:1\n26#2:31\n*S KotlinDebug\n*F\n+ 1 FlowExceptions.kt\nkotlinx/coroutines/flow/internal/AbortFlowException\n*L\n17#1:31\n*E\n"})
/* loaded from: classes6.dex */
public final class AbortFlowException extends CancellationException {

    @OXOo.OOXIXo
    @XO0OX.XO
    public final transient kotlinx.coroutines.flow.XO<?> owner;

    public AbortFlowException(@OXOo.OOXIXo kotlinx.coroutines.flow.XO<?> xo2) {
        super("Flow was aborted, no more elements needed");
        this.owner = xo2;
    }

    @Override // java.lang.Throwable
    @OXOo.OOXIXo
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
