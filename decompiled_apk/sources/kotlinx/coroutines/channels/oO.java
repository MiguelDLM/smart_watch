package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class oO<E> extends XO<E> {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final kotlin.coroutines.I0Io<oXIO0o0XI> f29885oI0IIXIo;

    public oO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo oxoX<E> oxox, @OXOo.OOXIXo Oox.x0xO0oo<? super IXxxXO<? super E>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        super(coroutineContext, oxox, false);
        this.f29885oI0IIXIo = IntrinsicsKt__IntrinsicsJvmKt.I0Io(x0xo0oo, this, this);
    }

    @Override // kotlinx.coroutines.channels.XO, kotlinx.coroutines.channels.oxoX
    @OXOo.OOXIXo
    public ReceiveChannel<E> ooOOo0oXI() {
        ReceiveChannel<E> ooOOo0oXI2 = OooI().ooOOo0oXI();
        start();
        return ooOOo0oXI2;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void xxOXOOoIX() {
        o0xIoII.oIX0oI.X0o0xo(this.f29885oI0IIXIo, this);
    }
}
