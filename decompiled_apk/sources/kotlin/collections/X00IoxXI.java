package kotlin.collections;

import java.util.Map;

@XO0OX.xxIXOIIO(name = "MapAccessorsKt")
/* loaded from: classes6.dex */
public final class X00IoxXI {
    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    public static final <V> void I0Io(Map<? super String, ? super V> map, Object obj, kotlin.reflect.x0XOIxOo<?> property, V v) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(property, "property");
        map.put(property.getName(), v);
    }

    @XO0OX.xxIXOIIO(name = "getVar")
    @xx0o0O.XO
    public static final <V, V1 extends V> V1 II0xO0(Map<? super String, ? extends V> map, Object obj, kotlin.reflect.x0XOIxOo<?> property) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(property, "property");
        return (V1) XOxIOxOx.oIX0oI(map, property.getName());
    }

    @xx0o0O.XO
    public static final <V, V1 extends V> V1 oIX0oI(Map<? super String, ? extends V> map, Object obj, kotlin.reflect.x0XOIxOo<?> property) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(property, "property");
        return (V1) XOxIOxOx.oIX0oI(map, property.getName());
    }
}
