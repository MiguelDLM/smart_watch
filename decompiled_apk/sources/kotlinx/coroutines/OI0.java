package kotlinx.coroutines;

import kotlin.Result;
import org.apache.commons.lang3.ObjectUtils;

@kotlin.jvm.internal.XX({"SMAP\nDebugStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugStrings.kt\nkotlinx/coroutines/DebugStringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
/* loaded from: classes6.dex */
public final class OI0 {
    @OXOo.OOXIXo
    public static final String I0Io(@OXOo.OOXIXo kotlin.coroutines.I0Io<?> i0Io) {
        Object m287constructorimpl;
        if (i0Io instanceof kotlinx.coroutines.internal.oOoXoXO) {
            return i0Io.toString();
        }
        try {
            Result.oIX0oI oix0oi = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(i0Io + ObjectUtils.f32506oIX0oI + II0xO0(i0Io));
        } catch (Throwable th) {
            Result.oIX0oI oix0oi2 = Result.Companion;
            m287constructorimpl = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th));
        }
        if (Result.m290exceptionOrNullimpl(m287constructorimpl) != null) {
            m287constructorimpl = i0Io.getClass().getName() + ObjectUtils.f32506oIX0oI + II0xO0(i0Io);
        }
        return (String) m287constructorimpl;
    }

    @OXOo.OOXIXo
    public static final String II0xO0(@OXOo.OOXIXo Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @OXOo.OOXIXo
    public static final String oIX0oI(@OXOo.OOXIXo Object obj) {
        return obj.getClass().getSimpleName();
    }
}
