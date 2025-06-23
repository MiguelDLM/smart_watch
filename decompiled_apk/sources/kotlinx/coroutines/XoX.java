package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@OX00O0xII
/* loaded from: classes6.dex */
public interface XoX {

    @kotlin.jvm.internal.XX({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/Delay$DefaultImpls\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/Delay$DefaultImpls\n*L\n30#1:163,11\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @OXOo.OOXIXo
        public static I0oOIX II0xO0(@OXOo.OOXIXo XoX xoX2, long j, @OXOo.OOXIXo Runnable runnable, @OXOo.OOXIXo CoroutineContext coroutineContext) {
            return XX.oIX0oI().Oxx0xo(j, runnable, coroutineContext);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        @OXOo.oOoXoXO
        public static Object oIX0oI(@OXOo.OOXIXo XoX xoX2, long j, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io) {
            if (j <= 0) {
                return kotlin.oXIO0o0XI.f29392oIX0oI;
            }
            x0xO0oo x0xo0oo = new x0xO0oo(IntrinsicsKt__IntrinsicsJvmKt.X0o0xo(i0Io), 1);
            x0xo0oo.IO();
            xoX2.OOXIXo(j, x0xo0oo);
            Object o002 = x0xo0oo.o00();
            if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                IXIxx0.XO.I0Io(i0Io);
            }
            if (o002 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                return o002;
            }
            return kotlin.oXIO0o0XI.f29392oIX0oI;
        }
    }

    void OOXIXo(long j, @OXOo.OOXIXo oO<? super kotlin.oXIO0o0XI> oOVar);

    @OXOo.OOXIXo
    I0oOIX Oxx0xo(long j, @OXOo.OOXIXo Runnable runnable, @OXOo.OOXIXo CoroutineContext coroutineContext);

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @OXOo.oOoXoXO
    Object OxxIIOOXO(long j, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super kotlin.oXIO0o0XI> i0Io);
}
