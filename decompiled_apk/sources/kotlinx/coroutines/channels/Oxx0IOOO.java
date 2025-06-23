package kotlinx.coroutines.channels;

import com.bestmafen.androidbase.adapter.recyclerview.wrapper.EmptyWrapper;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.oI0IIXIo;
import kotlinx.coroutines.internal.o0;

/* loaded from: classes6.dex */
public interface Oxx0IOOO<E> extends oI0IIXIo<E>, ReceiveChannel<E> {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f29865OOXIXo = Integer.MAX_VALUE;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f29866oO = -3;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f29867oOoXoXO = 0;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f29868ooOOo0oXI = -1;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f29869x0XOIxOo = -2;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f29870x0xO0oo = "kotlinx.coroutines.channels.defaultBuffer";

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final II0xO0 f29871xoIox = II0xO0.f29878oIX0oI;

    /* loaded from: classes6.dex */
    public static final class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public static final int f29872I0Io = 0;

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final int f29874II0xO0 = Integer.MAX_VALUE;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final String f29875Oxx0IOOO = "kotlinx.coroutines.channels.defaultBuffer";

        /* renamed from: X0o0xo, reason: collision with root package name */
        public static final int f29876X0o0xo = -2;

        /* renamed from: XO, reason: collision with root package name */
        public static final int f29877XO = -3;

        /* renamed from: oxoX, reason: collision with root package name */
        public static final int f29879oxoX = -1;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ II0xO0 f29878oIX0oI = new II0xO0();

        /* renamed from: II0XooXoX, reason: collision with root package name */
        public static final int f29873II0XooXoX = o0.II0xO0("kotlinx.coroutines.channels.defaultBuffer", 64, 1, EmptyWrapper.ITEM_TYPE_EMPTY);

        public final int oIX0oI() {
            return f29873II0XooXoX;
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @XX(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean I0Io(@OXOo.OOXIXo Oxx0IOOO<E> oxx0IOOO, E e) {
            return oI0IIXIo.oIX0oI.I0Io(oxx0IOOO, e);
        }

        @OXOo.OOXIXo
        public static <E> kotlinx.coroutines.selects.X0o0xo<E> II0xO0(@OXOo.OOXIXo Oxx0IOOO<E> oxx0IOOO) {
            return ReceiveChannel.DefaultImpls.oxoX(oxx0IOOO);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @XX(expression = "receiveCatching().getOrNull()", imports = {}))
        @xx0o0O.II0XooXoX
        @OXOo.oOoXoXO
        public static <E> Object X0o0xo(@OXOo.OOXIXo Oxx0IOOO<E> oxx0IOOO, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super E> i0Io) {
            return ReceiveChannel.DefaultImpls.xxIXOIIO(oxx0IOOO, i0Io);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @XX(expression = "tryReceive().getOrNull()", imports = {}))
        @OXOo.oOoXoXO
        public static <E> E oxoX(@OXOo.OOXIXo Oxx0IOOO<E> oxx0IOOO) {
            return (E) ReceiveChannel.DefaultImpls.II0XooXoX(oxx0IOOO);
        }
    }
}
