package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlinx.coroutines.IxIX0I;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.xII;

@IxIX0I
/* loaded from: classes6.dex */
public interface I0Io<E> extends xII, ReceiveChannel<E> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @XX(expression = "tryReceive().getOrNull()", imports = {}))
        @OXOo.oOoXoXO
        public static <E> E I0Io(@OXOo.OOXIXo I0Io<E> i0Io) {
            return (E) ReceiveChannel.DefaultImpls.II0XooXoX(i0Io);
        }

        @OXOo.OOXIXo
        public static <E> kotlinx.coroutines.selects.X0o0xo<E> II0xO0(@OXOo.OOXIXo I0Io<E> i0Io) {
            return ReceiveChannel.DefaultImpls.oxoX(i0Io);
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @XX(expression = "receiveCatching().getOrNull()", imports = {}))
        @xx0o0O.II0XooXoX
        @OXOo.oOoXoXO
        public static <E> Object oxoX(@OXOo.OOXIXo I0Io<E> i0Io, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super E> i0Io2) {
            return ReceiveChannel.DefaultImpls.xxIXOIIO(i0Io, i0Io2);
        }
    }

    @OXOo.OOXIXo
    Oxx0IOOO<E> getChannel();
}
