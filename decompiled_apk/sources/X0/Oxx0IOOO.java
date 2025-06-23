package X0;

import java.lang.Comparable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public interface Oxx0IOOO<T extends Comparable<? super T>> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public static <T extends Comparable<? super T>> boolean II0xO0(@OXOo.OOXIXo Oxx0IOOO<T> oxx0IOOO) {
            if (oxx0IOOO.getStart().compareTo(oxx0IOOO.getEndInclusive()) > 0) {
                return true;
            }
            return false;
        }

        public static <T extends Comparable<? super T>> boolean oIX0oI(@OXOo.OOXIXo Oxx0IOOO<T> oxx0IOOO, @OXOo.OOXIXo T value) {
            IIX0o.x0xO0oo(value, "value");
            if (value.compareTo(oxx0IOOO.getStart()) >= 0 && value.compareTo(oxx0IOOO.getEndInclusive()) <= 0) {
                return true;
            }
            return false;
        }
    }

    boolean contains(@OXOo.OOXIXo T t);

    @OXOo.OOXIXo
    T getEndInclusive();

    @OXOo.OOXIXo
    T getStart();

    boolean isEmpty();
}
