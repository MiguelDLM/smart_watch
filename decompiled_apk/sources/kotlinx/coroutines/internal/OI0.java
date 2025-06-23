package kotlinx.coroutines.internal;

import kotlinx.coroutines.OX00O0xII;

@kotlin.jvm.internal.XX({"SMAP\nSynchronized.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 2 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,33:1\n20#2:34\n*S KotlinDebug\n*F\n+ 1 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n*L\n31#1:34\n*E\n"})
/* loaded from: classes6.dex */
public final class OI0 {
    @OX00O0xII
    public static final <T> T oIX0oI(@OXOo.OOXIXo Object obj, @OXOo.OOXIXo Oox.oIX0oI<? extends T> oix0oi) {
        T invoke;
        synchronized (obj) {
            try {
                invoke = oix0oi.invoke();
                kotlin.jvm.internal.xxX.oxoX(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.xxX.oxoX(1);
                kotlin.jvm.internal.xxX.I0Io(1);
                throw th;
            }
        }
        kotlin.jvm.internal.xxX.I0Io(1);
        return invoke;
    }
}
