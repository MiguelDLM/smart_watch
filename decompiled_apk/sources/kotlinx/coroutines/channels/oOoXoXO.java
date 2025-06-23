package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlin.o0;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.IxIX0I;

/* loaded from: classes6.dex */
public final class oOoXoXO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29886oIX0oI = "Channel was closed";

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @IxIX0I
    public static final <E, R> R I0Io(@OXOo.OOXIXo oxoX<E> oxox, @OXOo.OOXIXo Oox.oOoXoXO<? super ReceiveChannel<? extends E>, ? extends R> oooxoxo) {
        return (R) ChannelsKt__Channels_commonKt.II0xO0(oxox, oooxoxo);
    }

    @o0
    @OXOo.oOoXoXO
    public static final <E, C extends oI0IIXIo<? super E>> Object I0X0x0oIo(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo C c, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super C> i0Io) {
        return ChannelsKt__DeprecatedKt.XX(receiveChannel, c, i0Io);
    }

    @OXOo.OOXIXo
    @o0
    public static final Oox.oOoXoXO<Throwable, oXIO0o0XI> II0XooXoX(@OXOo.OOXIXo ReceiveChannel<?>... receiveChannelArr) {
        return ChannelsKt__DeprecatedKt.I0Io(receiveChannelArr);
    }

    @o0
    public static final void II0xO0(@OXOo.OOXIXo ReceiveChannel<?> receiveChannel, @OXOo.oOoXoXO Throwable th) {
        ChannelsKt__Channels_commonKt.oIX0oI(receiveChannel, th);
    }

    @OXOo.OOXIXo
    @o0
    public static final <E, R> ReceiveChannel<R> IoOoX(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super E, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> iXxxXO) {
        return ChannelsKt__DeprecatedKt.IIX0o(receiveChannel, coroutineContext, iXxxXO);
    }

    @OXOo.OOXIXo
    public static final <E> Object IoOoo(@OXOo.OOXIXo oI0IIXIo<? super E> oi0iixio, E e) {
        return ChannelsKt__ChannelsKt.II0xO0(oi0iixio, e);
    }

    @OXOo.OOXIXo
    @o0
    public static final <E, K> ReceiveChannel<E> OOXIXo(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oox.x0xO0oo<? super E, ? super kotlin.coroutines.I0Io<? super K>, ? extends Object> x0xo0oo) {
        return ChannelsKt__DeprecatedKt.XO(receiveChannel, coroutineContext, x0xo0oo);
    }

    @OXOo.OOXIXo
    @o0
    public static final <E> ReceiveChannel<E> OxI(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__DeprecatedKt.oI0IIXIo(receiveChannel);
    }

    @OXOo.OOXIXo
    @o0
    public static final Oox.oOoXoXO<Throwable, oXIO0o0XI> Oxx0IOOO(@OXOo.OOXIXo ReceiveChannel<?> receiveChannel) {
        return ChannelsKt__DeprecatedKt.II0xO0(receiveChannel);
    }

    @OXOo.OOXIXo
    @o0
    public static final <E> ReceiveChannel<E> Oxx0xo(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oox.x0xO0oo<? super E, ? super kotlin.coroutines.I0Io<? super Boolean>, ? extends Object> x0xo0oo) {
        return ChannelsKt__DeprecatedKt.x0XOIxOo(receiveChannel, coroutineContext, x0xo0oo);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    @OXOo.oOoXoXO
    public static final <E> Object X0o0xo(@OXOo.OOXIXo oxoX<E> oxox, @OXOo.OOXIXo Oox.oOoXoXO<? super E, oXIO0o0XI> oooxoxo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ChannelsKt__Channels_commonKt.oxoX(oxox, oooxoxo, i0Io);
    }

    @OXOo.OOXIXo
    @o0
    public static final <E, R, V> ReceiveChannel<V> XIo0oOXIx(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo ReceiveChannel<? extends R> receiveChannel2, @OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oox.x0xO0oo<? super E, ? super R, ? extends V> x0xo0oo) {
        return ChannelsKt__DeprecatedKt.Xo0(receiveChannel, receiveChannel2, coroutineContext, x0xo0oo);
    }

    @OXOo.oOoXoXO
    public static final <E> Object XO(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo Oox.oOoXoXO<? super E, oXIO0o0XI> oooxoxo, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return ChannelsKt__Channels_commonKt.X0o0xo(receiveChannel, oooxoxo, i0Io);
    }

    @OXOo.oOoXoXO
    public static final <E> Object Xo0(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super List<? extends E>> i0Io) {
        return ChannelsKt__Channels_commonKt.xoIox(receiveChannel, i0Io);
    }

    @o0
    @OXOo.oOoXoXO
    public static final <K, V, M extends Map<? super K, ? super V>> Object XoI0Ixx0(@OXOo.OOXIXo ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, @OXOo.OOXIXo M m, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super M> i0Io) {
        return ChannelsKt__DeprecatedKt.oxxXoxO(receiveChannel, m, i0Io);
    }

    @o0
    @OXOo.oOoXoXO
    public static final <E, C extends Collection<? super E>> Object oX(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo C c, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super C> i0Io) {
        return ChannelsKt__DeprecatedKt.I0oOoX(receiveChannel, c, i0Io);
    }

    @OXOo.OOXIXo
    @o0
    public static final <E, R> ReceiveChannel<R> oo0xXOI0I(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Oox.x0xO0oo<? super E, ? super kotlin.coroutines.I0Io<? super R>, ? extends Object> x0xo0oo) {
        return ChannelsKt__DeprecatedKt.XxX0x0xxx(receiveChannel, coroutineContext, x0xo0oo);
    }

    public static final <E, R> R oxoX(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo Oox.oOoXoXO<? super ReceiveChannel<? extends E>, ? extends R> oooxoxo) {
        return (R) ChannelsKt__Channels_commonKt.I0Io(receiveChannel, oooxoxo);
    }

    @o0
    @OXOo.oOoXoXO
    public static final <E> Object xoxXI(@OXOo.OOXIXo ReceiveChannel<? extends E> receiveChannel, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super Set<E>> i0Io) {
        return ChannelsKt__DeprecatedKt.xo0x(receiveChannel, i0Io);
    }
}
