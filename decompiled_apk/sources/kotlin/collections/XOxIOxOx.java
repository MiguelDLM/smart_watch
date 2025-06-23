package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;

@kotlin.jvm.internal.XX({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n341#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n*L\n24#1:105,6\n*E\n"})
/* loaded from: classes6.dex */
public class XOxIOxOx {
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "withDefaultMutable")
    public static final <K, V> Map<K, V> I0Io(@OXOo.OOXIXo Map<K, V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (map instanceof XoX) {
            return I0Io(((XoX) map).getMap(), defaultValue);
        }
        return new oxXx0IX(map, defaultValue);
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> II0xO0(@OXOo.OOXIXo Map<K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (map instanceof IO) {
            return II0xO0(((IO) map).getMap(), defaultValue);
        }
        return new xII(map, defaultValue);
    }

    @XO0OX.xxIXOIIO(name = "getOrImplicitDefaultNullable")
    @kotlin.o0
    public static final <K, V> V oIX0oI(@OXOo.OOXIXo Map<K, ? extends V> map, K k) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        if (map instanceof IO) {
            return (V) ((IO) map).I0Io(k);
        }
        V v = map.get(k);
        if (v == null && !map.containsKey(k)) {
            throw new NoSuchElementException("Key " + k + " is missing in the map.");
        }
        return v;
    }
}
