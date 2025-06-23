package androidx.work;

import Oox.oOoXoXO;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class Data$toString$1$content$1 extends Lambda implements oOoXoXO<Map.Entry<? extends String, ? extends Object>, CharSequence> {
    public static final Data$toString$1$content$1 INSTANCE = new Data$toString$1$content$1();

    public Data$toString$1$content$1() {
        super(1);
    }

    public final CharSequence invoke(Map.Entry<String, ? extends Object> entry) {
        IIX0o.x0xO0oo(entry, "<name for destructuring parameter 0>");
        Object value = entry.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(entry.getKey());
        sb.append(" : ");
        if (value instanceof Object[]) {
            value = Arrays.toString((Object[]) value);
            IIX0o.oO(value, "toString(this)");
        }
        sb.append(value);
        return sb.toString();
    }
}
