package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@kotlin.jvm.internal.XX({"SMAP\nCoroutineExceptionHandlerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandlerImpl.kt\nkotlinx/coroutines/internal/CoroutineExceptionHandlerImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
/* loaded from: classes6.dex */
public final class xxIXOIIO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Collection<kotlinx.coroutines.oOXoIIIo> f30323oIX0oI = SequencesKt___SequencesKt.oox000IX(SequencesKt__SequencesKt.X0o0xo(ServiceLoader.load(kotlinx.coroutines.oOXoIIIo.class, kotlinx.coroutines.oOXoIIIo.class.getClassLoader()).iterator()));

    public static final void I0Io(@OXOo.OOXIXo Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @OXOo.OOXIXo
    public static final Collection<kotlinx.coroutines.oOXoIIIo> II0xO0() {
        return f30323oIX0oI;
    }

    public static final void oIX0oI(@OXOo.OOXIXo kotlinx.coroutines.oOXoIIIo ooxoiiio) {
        if (f30323oIX0oI.contains(ooxoiiio)) {
        } else {
            throw new IllegalStateException("Exception handler was not found via a ServiceLoader");
        }
    }
}
