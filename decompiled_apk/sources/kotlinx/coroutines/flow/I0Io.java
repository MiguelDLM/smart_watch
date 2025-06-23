package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* loaded from: classes6.dex */
public class I0Io<T> extends ChannelFlow<T> {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.x0xO0oo<kotlinx.coroutines.channels.IXxxXO<? super T>, kotlin.coroutines.I0Io<? super oXIO0o0XI>, Object> f30116Oxx0xo;

    public /* synthetic */ I0Io(Oox.x0xO0oo x0xo0oo, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(x0xo0oo, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    public static /* synthetic */ <T> Object x0XOIxOo(I0Io<T> i0Io, kotlinx.coroutines.channels.IXxxXO<? super T> iXxxXO, kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io2) {
        Object invoke = i0Io.f30116Oxx0xo.invoke(iXxxXO, i0Io2);
        if (invoke == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return invoke;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.oOoXoXO
    public Object II0XooXoX(@OXOo.OOXIXo kotlinx.coroutines.channels.IXxxXO<? super T> iXxxXO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return x0XOIxOo(this, iXxxXO, i0Io);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public String toString() {
        return "block[" + this.f30116Oxx0xo + "] -> " + super.toString();
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @OXOo.OOXIXo
    public ChannelFlow<T> xxIXOIIO(@OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        return new I0Io(this.f30116Oxx0xo, coroutineContext, i, bufferOverflow);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public I0Io(@OXOo.OOXIXo Oox.x0xO0oo<? super kotlinx.coroutines.channels.IXxxXO<? super T>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo, @OXOo.OOXIXo CoroutineContext coroutineContext, int i, @OXOo.OOXIXo BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.f30116Oxx0xo = x0xo0oo;
    }
}
