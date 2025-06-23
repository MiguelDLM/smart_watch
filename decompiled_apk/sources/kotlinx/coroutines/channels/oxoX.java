package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlinx.coroutines.IxIX0I;
import kotlinx.coroutines.channels.oI0IIXIo;

@kotlin.OOXIXo(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@IxIX0I
/* loaded from: classes6.dex */
public interface oxoX<E> extends oI0IIXIo<E> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @XX(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean I0Io(@OXOo.OOXIXo oxoX<E> oxox, E e) {
            return oI0IIXIo.oIX0oI.I0Io(oxox, e);
        }

        public static /* synthetic */ boolean II0xO0(oxoX oxox, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return oxox.oIX0oI(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ void oIX0oI(oxoX oxox, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                oxox.II0xO0(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }

    void II0xO0(@OXOo.oOoXoXO CancellationException cancellationException);

    @kotlin.OOXIXo(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    /* synthetic */ boolean oIX0oI(Throwable th);

    @OXOo.OOXIXo
    ReceiveChannel<E> ooOOo0oXI();
}
