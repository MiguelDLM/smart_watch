package kotlinx.coroutines.sync;

import OXOo.oOoXoXO;
import kotlin.DeprecationLevel;
import kotlin.OOXIXo;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.selects.Oxx0IOOO;

/* loaded from: classes6.dex */
public interface oIX0oI {

    /* renamed from: kotlinx.coroutines.sync.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1115oIX0oI {
        public static /* synthetic */ boolean I0Io(oIX0oI oix0oi, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                return oix0oi.X0o0xo(obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        public static /* synthetic */ Object II0xO0(oIX0oI oix0oi, Object obj, kotlin.coroutines.I0Io i0Io, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                return oix0oi.II0XooXoX(obj, i0Io);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }

        @OOXIXo(level = DeprecationLevel.WARNING, message = "Mutex.onLock deprecated without replacement. For additional details please refer to #2794")
        public static /* synthetic */ void oIX0oI() {
        }

        public static /* synthetic */ void oxoX(oIX0oI oix0oi, Object obj, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 1) != 0) {
                    obj = null;
                }
                oix0oi.xxIXOIIO(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    @oOoXoXO
    Object II0XooXoX(@oOoXoXO Object obj, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io);

    @OXOo.OOXIXo
    Oxx0IOOO<Object, oIX0oI> Oxx0IOOO();

    boolean X0o0xo(@oOoXoXO Object obj);

    boolean XO(@OXOo.OOXIXo Object obj);

    boolean oxoX();

    void xxIXOIIO(@oOoXoXO Object obj);
}
