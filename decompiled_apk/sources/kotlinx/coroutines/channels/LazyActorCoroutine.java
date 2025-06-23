package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XoX;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class LazyActorCoroutine<E> extends oIX0oI<E> {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public kotlin.coroutines.I0Io<? super oXIO0o0XI> f29862oI0IIXIo;

    public LazyActorCoroutine(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oxx0IOOO<E> oxx0IOOO, @OXOo.OOXIXo Oox.x0xO0oo<? super I0Io<E>, ? super kotlin.coroutines.I0Io<? super oXIO0o0XI>, ? extends Object> x0xo0oo) {
        super(coroutineContext, oxx0IOOO, false);
        this.f29862oI0IIXIo = IntrinsicsKt__IntrinsicsJvmKt.I0Io(x0xo0oo, this, this);
    }

    public static /* synthetic */ void xIXX() {
    }

    @Override // kotlinx.coroutines.channels.II0XooXoX, kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.oOoXoXO
    public Object XOxIOxOx(E e, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        start();
        Object XOxIOxOx2 = super.XOxIOxOx(e, i0Io);
        if (XOxIOxOx2 == kotlin.coroutines.intrinsics.II0xO0.oOoXoXO()) {
            return XOxIOxOx2;
        }
        return oXIO0o0XI.f29392oIX0oI;
    }

    @Override // kotlinx.coroutines.channels.II0XooXoX, kotlinx.coroutines.channels.oI0IIXIo
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @XX(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        start();
        return super.offer(e);
    }

    @Override // kotlinx.coroutines.channels.II0XooXoX, kotlinx.coroutines.channels.oI0IIXIo
    public boolean x0o(@OXOo.oOoXoXO Throwable th) {
        boolean x0o2 = super.x0o(th);
        start();
        return x0o2;
    }

    @Override // kotlinx.coroutines.channels.II0XooXoX, kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.OOXIXo
    public Object x0xO0oo(E e) {
        start();
        return super.x0xO0oo(e);
    }

    @Override // kotlinx.coroutines.channels.II0XooXoX, kotlinx.coroutines.channels.oI0IIXIo
    @OXOo.OOXIXo
    public kotlinx.coroutines.selects.Oxx0IOOO<E, oI0IIXIo<E>> xxIXOIIO() {
        LazyActorCoroutine$onSend$1 lazyActorCoroutine$onSend$1 = LazyActorCoroutine$onSend$1.INSTANCE;
        IIX0o.x0XOIxOo(lazyActorCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.II0XooXoX(this, (Oox.IXxxXO) XoX.Oo(lazyActorCoroutine$onSend$1, 3), super.xxIXOIIO().II0xO0(), null, 8, null);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void xxOXOOoIX() {
        o0xIoII.oIX0oI.X0o0xo(this.f29862oI0IIXIo, this);
    }

    public final void xxxI(kotlinx.coroutines.selects.xoIox<?> xoiox, Object obj) {
        xxOXOOoIX();
        super.xxIXOIIO().I0Io().invoke(this, xoiox, obj);
    }
}
