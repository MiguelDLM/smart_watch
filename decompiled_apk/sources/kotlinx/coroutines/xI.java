package kotlinx.coroutines;

import kotlin.Result;

@kotlin.jvm.internal.XX({"SMAP\nCompletionState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n+ 2 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,67:1\n61#2,2:68\n61#2,2:70\n*S KotlinDebug\n*F\n+ 1 CompletionState.kt\nkotlinx/coroutines/CompletionStateKt\n*L\n21#1:68,2\n27#1:70,2\n*E\n"})
/* loaded from: classes6.dex */
public final class xI {
    @OXOo.oOoXoXO
    public static final <T> Object I0Io(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo oO<?> oOVar) {
        Throwable m290exceptionOrNullimpl = Result.m290exceptionOrNullimpl(obj);
        if (m290exceptionOrNullimpl != null) {
            return new xxX(m290exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }

    @OXOo.oOoXoXO
    public static final <T> Object II0xO0(@OXOo.OOXIXo Object obj, @OXOo.oOoXoXO Oox.oOoXoXO<? super Throwable, kotlin.oXIO0o0XI> oooxoxo) {
        Throwable m290exceptionOrNullimpl = Result.m290exceptionOrNullimpl(obj);
        if (m290exceptionOrNullimpl == null) {
            if (oooxoxo != null) {
                return new XxX0x0xxx(obj, oooxoxo);
            }
            return obj;
        }
        return new xxX(m290exceptionOrNullimpl, false, 2, null);
    }

    @OXOo.OOXIXo
    public static final <T> Object oIX0oI(@OXOo.oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        if (obj instanceof xxX) {
            Result.oIX0oI oix0oi = Result.Companion;
            return Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(((xxX) obj).f30502oIX0oI));
        }
        Result.oIX0oI oix0oi2 = Result.Companion;
        return Result.m287constructorimpl(obj);
    }

    public static /* synthetic */ Object oxoX(Object obj, Oox.oOoXoXO oooxoxo, int i, Object obj2) {
        if ((i & 1) != 0) {
            oooxoxo = null;
        }
        return II0xO0(obj, oooxoxo);
    }
}
