package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: classes6.dex */
public final class InterruptibleKt {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f29706I0Io = 2;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f29707II0xO0 = 1;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f29708oIX0oI = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f29709oxoX = 3;

    public static /* synthetic */ Object I0Io(CoroutineContext coroutineContext, Oox.oIX0oI oix0oi, kotlin.coroutines.I0Io i0Io, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return II0xO0(coroutineContext, oix0oi, i0Io);
    }

    @OXOo.oOoXoXO
    public static final <T> Object II0xO0(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oox.oIX0oI<? extends T> oix0oi, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        return II0XooXoX.II0XooXoX(coroutineContext, new InterruptibleKt$runInterruptible$2(oix0oi, null), i0Io);
    }

    public static final <T> T oxoX(CoroutineContext coroutineContext, Oox.oIX0oI<? extends T> oix0oi) {
        try {
            oXX0IoI oxx0ioi = new oXX0IoI(IIX0.XI0IXoo(coroutineContext));
            oxx0ioi.X0o0xo();
            try {
                return oix0oi.invoke();
            } finally {
                oxx0ioi.oIX0oI();
            }
        } catch (InterruptedException e) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
        }
    }
}
