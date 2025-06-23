package kotlinx.coroutines.flow.internal;

import kotlin.o0;

/* loaded from: classes6.dex */
public final class II0XooXoX {
    public static final void II0xO0(@OXOo.OOXIXo AbortFlowException abortFlowException, @OXOo.OOXIXo kotlinx.coroutines.flow.XO<?> xo2) {
        if (abortFlowException.owner == xo2) {
        } else {
            throw abortFlowException;
        }
    }

    @o0
    public static final int oIX0oI(int i) {
        if (i >= 0) {
            return i;
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
