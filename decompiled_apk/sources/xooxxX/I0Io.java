package xooxxX;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.IIXOooo;
import kotlin.contracts.InvocationKind;
import kotlin.oxxXoxO;

@xx0o0O.II0xO0
@XO
@oxxXoxO(version = "1.3")
/* loaded from: classes6.dex */
public interface I0Io {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public static /* synthetic */ xooxxX.oIX0oI oIX0oI(I0Io i0Io, IIXOooo iIXOooo, InvocationKind invocationKind, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    invocationKind = InvocationKind.UNKNOWN;
                }
                return i0Io.oxoX(iIXOooo, invocationKind);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
        }
    }

    @xx0o0O.II0xO0
    @OOXIXo
    II0XooXoX I0Io();

    @xx0o0O.II0xO0
    @OOXIXo
    Oxx0IOOO II0xO0(@oOoXoXO Object obj);

    @xx0o0O.II0xO0
    @OOXIXo
    Oxx0IOOO oIX0oI();

    @xx0o0O.II0xO0
    @OOXIXo
    <R> xooxxX.oIX0oI oxoX(@OOXIXo IIXOooo<? extends R> iIXOooo, @OOXIXo InvocationKind invocationKind);
}
