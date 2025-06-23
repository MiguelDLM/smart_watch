package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

@kotlin.jvm.internal.XX({"SMAP\nTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timeout.kt\nkotlinx/coroutines/TimeoutCancellationException\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,193:1\n1#2:194\n*E\n"})
/* loaded from: classes6.dex */
public final class TimeoutCancellationException extends CancellationException implements IoOoX<TimeoutCancellationException> {

    @XO0OX.XO
    @OXOo.oOoXoXO
    public final transient oXIO0o0XI coroutine;

    public TimeoutCancellationException(@OXOo.OOXIXo String str, @OXOo.oOoXoXO oXIO0o0XI oxio0o0xi) {
        super(str);
        this.coroutine = oxio0o0xi;
    }

    @Override // kotlinx.coroutines.IoOoX
    @OXOo.OOXIXo
    public TimeoutCancellationException createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }

    public TimeoutCancellationException(@OXOo.OOXIXo String str) {
        this(str, null);
    }
}
