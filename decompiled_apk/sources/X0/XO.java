package X0;

import java.lang.Comparable;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

@oxxXoxO(version = "1.1")
/* loaded from: classes6.dex */
public interface XO<T extends Comparable<? super T>> extends Oxx0IOOO<T> {

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public static <T extends Comparable<? super T>> boolean II0xO0(@OXOo.OOXIXo XO<T> xo2) {
            return !xo2.oIX0oI(xo2.getStart(), xo2.getEndInclusive());
        }

        public static <T extends Comparable<? super T>> boolean oIX0oI(@OXOo.OOXIXo XO<T> xo2, @OXOo.OOXIXo T value) {
            IIX0o.x0xO0oo(value, "value");
            if (xo2.oIX0oI(xo2.getStart(), value) && xo2.oIX0oI(value, xo2.getEndInclusive())) {
                return true;
            }
            return false;
        }
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    boolean contains(@OXOo.OOXIXo T t);

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    boolean isEmpty();

    boolean oIX0oI(@OXOo.OOXIXo T t, @OXOo.OOXIXo T t2);
}
