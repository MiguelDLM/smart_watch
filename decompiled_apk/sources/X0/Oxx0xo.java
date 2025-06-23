package X0;

import java.lang.Comparable;
import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

@IIX0(markerClass = {kotlin.IXxxXO.class})
@oxxXoxO(version = "1.9")
/* loaded from: classes6.dex */
public interface Oxx0xo<T extends Comparable<? super T>> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public static <T extends Comparable<? super T>> boolean II0xO0(@OXOo.OOXIXo Oxx0xo<T> oxx0xo) {
            if (oxx0xo.getStart().compareTo(oxx0xo.II0xO0()) >= 0) {
                return true;
            }
            return false;
        }

        public static <T extends Comparable<? super T>> boolean oIX0oI(@OXOo.OOXIXo Oxx0xo<T> oxx0xo, @OXOo.OOXIXo T value) {
            IIX0o.x0xO0oo(value, "value");
            if (value.compareTo(oxx0xo.getStart()) >= 0 && value.compareTo(oxx0xo.II0xO0()) < 0) {
                return true;
            }
            return false;
        }
    }

    @OXOo.OOXIXo
    T II0xO0();

    boolean contains(@OXOo.OOXIXo T t);

    @OXOo.OOXIXo
    T getStart();

    boolean isEmpty();
}
