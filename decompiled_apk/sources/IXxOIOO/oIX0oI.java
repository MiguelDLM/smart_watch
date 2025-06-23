package IXxOIOO;

import XO0OX.xxIXOIIO;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XoX;
import kotlin.oxxXoxO;
import xx0o0O.XO;

@xxIXOIIO(name = "CollectionsJDK8Kt")
/* loaded from: classes6.dex */
public final class oIX0oI {
    @XO
    @oxxXoxO(version = "1.2")
    public static final <K, V> boolean II0xO0(Map<? extends K, ? extends V> map, K k, V v) {
        boolean remove;
        IIX0o.x0xO0oo(map, "<this>");
        remove = XoX.OOXIXo(map).remove(k, v);
        return remove;
    }

    @XO
    @oxxXoxO(version = "1.2")
    public static final <K, V> V oIX0oI(Map<? extends K, ? extends V> map, K k, V v) {
        Object orDefault;
        IIX0o.x0xO0oo(map, "<this>");
        orDefault = map.getOrDefault(k, v);
        return (V) orDefault;
    }
}
