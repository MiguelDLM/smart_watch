package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.IxIX0I;

@kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "ConflatedBroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@IxIX0I
/* loaded from: classes6.dex */
public final class ooOOo0oXI<E> implements oxoX<E> {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final BroadcastChannelImpl<E> f29887XO;

    public ooOOo0oXI(BroadcastChannelImpl<E> broadcastChannelImpl) {
        this.f29887XO = broadcastChannelImpl;
    }

    public final E I0Io() {
        return this.f29887XO.x00IOx();
    }

    @Override // kotlinx.coroutines.channels.oxoX
    public void II0xO0(@OXOo.oOoXoXO CancellationException cancellationException) {
        this.f29887XO.II0xO0(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    public void OOXIXo(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
        this.f29887XO.OOXIXo(oooxoxo);
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    public boolean X0IIOO() {
        return this.f29887XO.X0IIOO();
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.oOoXoXO
    public Object XOxIOxOx(E e, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return this.f29887XO.XOxIOxOx(e, i0Io);
    }

    @Override // kotlinx.coroutines.channels.oxoX
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    public /* synthetic */ boolean oIX0oI(Throwable th) {
        return this.f29887XO.oIX0oI(th);
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @XX(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return this.f29887XO.offer(e);
    }

    @Override // kotlinx.coroutines.channels.oxoX
    @OXOo.OOXIXo
    public ReceiveChannel<E> ooOOo0oXI() {
        return this.f29887XO.ooOOo0oXI();
    }

    @OXOo.oOoXoXO
    public final E oxoX() {
        return this.f29887XO.oX0ooo0I0();
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    public boolean x0o(@OXOo.oOoXoXO Throwable th) {
        return this.f29887XO.x0o(th);
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.OOXIXo
    public Object x0xO0oo(E e) {
        return this.f29887XO.x0xO0oo(e);
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.OOXIXo
    public kotlinx.coroutines.selects.Oxx0IOOO<E, oI0IIXIo<E>> xxIXOIIO() {
        return this.f29887XO.xxIXOIIO();
    }

    public ooOOo0oXI() {
        this(new BroadcastChannelImpl(-1));
    }

    public ooOOo0oXI(E e) {
        this();
        x0xO0oo(e);
    }
}
