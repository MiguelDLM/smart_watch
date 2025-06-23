package kotlinx.coroutines;

import kotlin.Result;

@kotlin.jvm.internal.XX({"SMAP\nCompletableDeferred.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletableDeferred.kt\nkotlinx/coroutines/CompletableDeferredKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
/* loaded from: classes6.dex */
public final class X0IIOO {
    public static /* synthetic */ OxI I0Io(oXIO0o0XI oxio0o0xi, int i, Object obj) {
        if ((i & 1) != 0) {
            oxio0o0xi = null;
        }
        return II0xO0(oxio0o0xi);
    }

    @OXOo.OOXIXo
    public static final <T> OxI<T> II0xO0(@OXOo.oOoXoXO oXIO0o0XI oxio0o0xi) {
        return new O0xOxO(oxio0o0xi);
    }

    @OXOo.OOXIXo
    public static final <T> OxI<T> oIX0oI(T t) {
        O0xOxO o0xOxO = new O0xOxO(null);
        o0xOxO.oO(t);
        return o0xOxO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean oxoX(@OXOo.OOXIXo OxI<T> oxI, @OXOo.OOXIXo Object obj) {
        Throwable m290exceptionOrNullimpl = Result.m290exceptionOrNullimpl(obj);
        if (m290exceptionOrNullimpl == null) {
            return oxI.oO(obj);
        }
        return oxI.I0Io(m290exceptionOrNullimpl);
    }
}
