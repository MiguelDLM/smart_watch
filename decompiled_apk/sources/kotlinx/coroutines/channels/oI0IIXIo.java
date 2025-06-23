package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.internal.xII;
import kotlinx.coroutines.xo0x;

/* loaded from: classes6.dex */
public interface oI0IIXIo<E> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        /* JADX WARN: Multi-variable type inference failed */
        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @XX(expression = "trySend(element).isSuccess", imports = {}))
        public static <E> boolean I0Io(@OXOo.OOXIXo oI0IIXIo<? super E> oi0iixio, E e) {
            Object x0xO0oo2 = oi0iixio.x0xO0oo(e);
            if (xoIox.ooOOo0oXI(x0xO0oo2)) {
                return true;
            }
            Throwable XO2 = xoIox.XO(x0xO0oo2);
            if (XO2 == null) {
                return false;
            }
            throw xII.oO(XO2);
        }

        @xo0x
        public static /* synthetic */ void II0xO0() {
        }

        public static /* synthetic */ boolean oIX0oI(oI0IIXIo oi0iixio, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return oi0iixio.x0o(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    void OOXIXo(@OXOo.OOXIXo Oox.oOoXoXO<? super Throwable, oXIO0o0XI> oooxoxo);

    boolean X0IIOO();

    @OXOo.oOoXoXO
    Object XOxIOxOx(E e, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io);

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @XX(expression = "trySend(element).isSuccess", imports = {}))
    boolean offer(E e);

    boolean x0o(@OXOo.oOoXoXO Throwable th);

    @OXOo.OOXIXo
    Object x0xO0oo(E e);

    @OXOo.OOXIXo
    kotlinx.coroutines.selects.Oxx0IOOO<E, oI0IIXIo<E>> xxIXOIIO();
}
