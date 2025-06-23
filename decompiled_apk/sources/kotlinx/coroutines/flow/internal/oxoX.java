package kotlinx.coroutines.flow.internal;

import Oox.x0xO0oo;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.XoX;
import kotlinx.coroutines.internal.ThreadContextKt;

@XX({"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,245:1\n95#2,5:246\n*S KotlinDebug\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n*L\n226#1:246,5\n*E\n"})
/* loaded from: classes6.dex */
public final class oxoX {
    @OXOo.oOoXoXO
    public static final <T, V> Object I0Io(@OXOo.OOXIXo CoroutineContext coroutineContext, V v, @OXOo.OOXIXo Object obj, @OXOo.OOXIXo x0xO0oo<? super V, ? super kotlin.coroutines.I0Io<? super T>, ? extends Object> x0xo0oo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super T> i0Io) {
        Object I0Io2 = ThreadContextKt.I0Io(coroutineContext, obj);
        try {
            Object invoke = ((x0xO0oo) XoX.Oo(x0xo0oo, 2)).invoke(v, new x0XOIxOo(i0Io, coroutineContext));
            ThreadContextKt.oIX0oI(coroutineContext, I0Io2);
            if (invoke == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
                IXIxx0.XO.I0Io(i0Io);
            }
            return invoke;
        } catch (Throwable th) {
            ThreadContextKt.oIX0oI(coroutineContext, I0Io2);
            throw th;
        }
    }

    @OXOo.OOXIXo
    public static final <T> ChannelFlow<T> II0xO0(@OXOo.OOXIXo kotlinx.coroutines.flow.X0o0xo<? extends T> x0o0xo) {
        ChannelFlow<T> channelFlow;
        if (x0o0xo instanceof ChannelFlow) {
            channelFlow = (ChannelFlow) x0o0xo;
        } else {
            channelFlow = null;
        }
        if (channelFlow == null) {
            return new X0o0xo(x0o0xo, null, 0, null, 14, null);
        }
        return channelFlow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.flow.XO<T> X0o0xo(kotlinx.coroutines.flow.XO<? super T> xo2, CoroutineContext coroutineContext) {
        boolean z;
        if (xo2 instanceof ooOOo0oXI) {
            z = true;
        } else {
            z = xo2 instanceof OOXIXo;
        }
        if (!z) {
            return new UndispatchedContextCollector(xo2, coroutineContext);
        }
        return xo2;
    }

    public static /* synthetic */ Object oxoX(CoroutineContext coroutineContext, Object obj, Object obj2, x0xO0oo x0xo0oo, kotlin.coroutines.I0Io i0Io, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = ThreadContextKt.II0xO0(coroutineContext);
        }
        return I0Io(coroutineContext, obj, obj2, x0xo0oo, i0Io);
    }
}
