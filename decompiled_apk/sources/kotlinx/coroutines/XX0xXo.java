package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

@kotlin.jvm.internal.XX({"SMAP\nExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
/* loaded from: classes6.dex */
public final class XX0xXo {
    public static final void II0xO0(@OXOo.OOXIXo Throwable th, @OXOo.OOXIXo Throwable th2) {
        kotlin.oO.oIX0oI(th, th2);
    }

    @OXOo.OOXIXo
    public static final CancellationException oIX0oI(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
