package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.Xx000oIo;
import kotlinx.coroutines.channels.oI0IIXIo;

@XX({"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,202:1\n706#2,2:203\n706#2,2:205\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n*L\n152#1:203,2\n157#1:205,2\n*E\n"})
/* loaded from: classes6.dex */
public class XO<E> extends kotlinx.coroutines.oIX0oI<oXIO0o0XI> implements IXxxXO<E>, oxoX<E> {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oxoX<E> f29884Oxx0xo;

    public XO(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo oxoX<E> oxox, boolean z) {
        super(coroutineContext, false, z);
        this.f29884Oxx0xo = oxox;
        IIX0((kotlinx.coroutines.oXIO0o0XI) coroutineContext.get(kotlinx.coroutines.oXIO0o0XI.f30343xxIXOIIO));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void I0oOIX(@OXOo.OOXIXo Throwable th) {
        CancellationException XI2 = JobSupport.XI(this, th, null, 1, null);
        this.f29884Oxx0xo.II0xO0(XI2);
        XoI0Ixx0(XI2);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.oXIO0o0XI
    public final void II0xO0(@OXOo.oOoXoXO CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(IoOoo(), null, this);
        }
        I0oOIX(cancellationException);
    }

    @Override // kotlinx.coroutines.oIX0oI
    /* renamed from: OIx00oxx, reason: merged with bridge method [inline-methods] */
    public void XoIxOXIXo(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
        oI0IIXIo.oIX0oI.oIX0oI(this.f29884Oxx0xo, null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    public void OOXIXo(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo) {
        this.f29884Oxx0xo.OOXIXo(oooxoxo);
    }

    @OXOo.OOXIXo
    public final oxoX<E> OooI() {
        return this.f29884Oxx0xo;
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    public boolean X0IIOO() {
        return this.f29884Oxx0xo.X0IIOO();
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.oOoXoXO
    public Object XOxIOxOx(E e, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return this.f29884Oxx0xo.XOxIOxOx(e, i0Io);
    }

    @Override // kotlinx.coroutines.channels.IXxxXO
    @OXOo.OOXIXo
    public oI0IIXIo<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.oIX0oI, kotlinx.coroutines.JobSupport, kotlinx.coroutines.oXIO0o0XI
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.oIX0oI
    public void o0IXXIx(@OXOo.OOXIXo Throwable th, boolean z) {
        if (!this.f29884Oxx0xo.x0o(th) && !z) {
            Xx000oIo.II0xO0(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.oXIO0o0XI
    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean oIX0oI(Throwable th) {
        if (th == null) {
            th = new JobCancellationException(IoOoo(), null, this);
        }
        I0oOIX(th);
        return true;
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @kotlin.XX(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return this.f29884Oxx0xo.offer(e);
    }

    @Override // kotlinx.coroutines.channels.oxoX
    @OXOo.OOXIXo
    public ReceiveChannel<E> ooOOo0oXI() {
        return this.f29884Oxx0xo.ooOOo0oXI();
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    public boolean x0o(@OXOo.oOoXoXO Throwable th) {
        boolean x0o2 = this.f29884Oxx0xo.x0o(th);
        start();
        return x0o2;
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.OOXIXo
    public Object x0xO0oo(E e) {
        return this.f29884Oxx0xo.x0xO0oo(e);
    }

    @Override // kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.OOXIXo
    public kotlinx.coroutines.selects.Oxx0IOOO<E, oI0IIXIo<E>> xxIXOIIO() {
        return this.f29884Oxx0xo.xxIXOIIO();
    }
}
