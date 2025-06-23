package kotlin.collections;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nMapsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n1#2:158\n*E\n"})
/* loaded from: classes6.dex */
public class OI0 extends XOxIOxOx {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f29123oIX0oI = 1073741824;

    @OXOo.OOXIXo
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <K, V> Map<K, V> II0XooXoX(int i) {
        return new MapBuilder(i);
    }

    @OXOo.OOXIXo
    public static final <K, V> SortedMap<K, V> IXxxXO(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Comparator<? super K> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }

    @OXOo.OOXIXo
    public static <K, V> Map<K, V> OOXIXo(@OXOo.OOXIXo Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        kotlin.jvm.internal.IIX0o.oO(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    @OXOo.OOXIXo
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> Oo(@OXOo.OOXIXo Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return new TreeMap(map);
    }

    @OXOo.OOXIXo
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <K, V> Map<K, V> Oxx0IOOO() {
        return new MapBuilder();
    }

    @xx0o0O.XO
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static final <K, V> Map<K, V> X0o0xo(int i, Oox.oOoXoXO<? super Map<K, V>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        Map II0XooXoX2 = II0XooXoX(i);
        builderAction.invoke(II0XooXoX2);
        return oxoX(II0XooXoX2);
    }

    @xx0o0O.XO
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static final <K, V> Map<K, V> XO(Oox.oOoXoXO<? super Map<K, V>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        Map Oxx0IOOO2 = Oxx0IOOO();
        builderAction.invoke(Oxx0IOOO2);
        return oxoX(Oxx0IOOO2);
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> oO(@OXOo.OOXIXo Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.IIX0o.oO(singletonMap, "with(...)");
        return singletonMap;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> SortedMap<K, V> oOoXoXO(@OXOo.OOXIXo Comparator<? super K> comparator, @OXOo.OOXIXo Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        o0.OOXIxO0(treeMap, pairs);
        return treeMap;
    }

    @OXOo.OOXIXo
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> ooOOo0oXI(@OXOo.OOXIXo Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        TreeMap treeMap = new TreeMap();
        o0.OOXIxO0(treeMap, pairs);
        return treeMap;
    }

    @OXOo.OOXIXo
    @kotlin.o0
    @kotlin.oxxXoxO(version = "1.3")
    public static <K, V> Map<K, V> oxoX(@OXOo.OOXIXo Map<K, V> builder) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builder, "builder");
        return ((MapBuilder) builder).build();
    }

    @xx0o0O.XO
    public static final Properties x0XOIxOo(Map<String, String> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    @xx0o0O.XO
    public static final <K, V> Map<K, V> x0xO0oo(Map<K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return oO(map);
    }

    @kotlin.o0
    public static int xoIox(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final <K, V> V xxIXOIIO(@OXOo.OOXIXo ConcurrentMap<K, V> concurrentMap, K k, @OXOo.OOXIXo Oox.oIX0oI<? extends V> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(concurrentMap, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        V v = concurrentMap.get(k);
        if (v == null) {
            V invoke = defaultValue.invoke();
            V putIfAbsent = concurrentMap.putIfAbsent(k, invoke);
            if (putIfAbsent == null) {
                return invoke;
            }
            return putIfAbsent;
        }
        return v;
    }
}
