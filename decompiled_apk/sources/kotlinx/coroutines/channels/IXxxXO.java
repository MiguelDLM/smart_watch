package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlinx.coroutines.channels.oI0IIXIo;
import kotlinx.coroutines.xII;

/* loaded from: classes6.dex */
public interface IXxxXO<E> extends xII, oI0IIXIo<E> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @XX(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean oIX0oI(@OXOo.OOXIXo IXxxXO<? super E> iXxxXO, E e) {
            return oI0IIXIo.oIX0oI.I0Io(iXxxXO, e);
        }
    }

    @OXOo.OOXIXo
    oI0IIXIo<E> getChannel();
}
