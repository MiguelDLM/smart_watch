package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.IIX0;
import kotlin.Pair;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nMaps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,804:1\n403#1:814\n414#1:819\n511#1,6:824\n536#1,6:830\n1#2:805\n1238#3,4:806\n1238#3,4:810\n1238#3,4:815\n1238#3,4:820\n*S KotlinDebug\n*F\n+ 1 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n453#1:814\n468#1:819\n526#1:824,6\n551#1:830,6\n403#1:806,4\n414#1:810,4\n453#1:815,4\n468#1:820,4\n*E\n"})
/* loaded from: classes6.dex */
public class o0 extends OI0 {
    @xx0o0O.XO
    public static final <K, V> void I0(Map<K, V> map, K k, V v) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        map.put(k, v);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> void I0X0x0oIo(Map<K, V> map, K k) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        map.remove(k);
    }

    @OXOo.OOXIXo
    public static <K, V> Map<K, V> I0oOIX(@OXOo.OOXIXo Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(OI0.xoIox(pairs.length));
        OOXIxO0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, R> Map<K, R> I0oOoX(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(OI0.xoIox(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(entry.getKey(), transform.invoke(entry));
        }
        return linkedHashMap;
    }

    @xx0o0O.XO
    public static final <K, V> Pair<K, V> IIX0(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(entry, "<this>");
        return new Pair<>(entry.getKey(), entry.getValue());
    }

    @xx0o0O.XO
    public static final <K, V> V IIX0o(Map<? extends K, ? extends V> map, K k) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.get(k);
    }

    @xx0o0O.XO
    public static final <K, V> V IIXOooo(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(entry, "<this>");
        return entry.getValue();
    }

    @xx0o0O.XO
    public static final <K, V> V IIxOXoOo0(Map<? extends K, V> map, K k) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return (V) kotlin.jvm.internal.XoX.OOXIXo(map).remove(k);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final <K, V> boolean IO(Map<? extends K, ? extends V> map) {
        if (map != null && !map.isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, R, M extends Map<? super R, ? super V>> M Io(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            destination.put(transform.invoke(entry), entry.getValue());
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> HashMap<K, V> IoOoX() {
        return new HashMap<>();
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> IoOoo(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        if (map.isEmpty()) {
            return ooOx(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        ox(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @xx0o0O.XO
    public static final <K, V> void Ioxxx(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        ox(map, pairs);
    }

    @xx0o0O.XO
    public static final <K, V> void O00XxXI(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        OOXIxO0(map, pairs);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static <K, V> Map<K, V> O0X(@OXOo.OOXIXo Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return new LinkedHashMap(map);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> Map<K, V> O0Xx() {
        return new LinkedHashMap();
    }

    @OXOo.OOXIXo
    public static <K, V> Map<K, V> O0xOxO() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        kotlin.jvm.internal.IIX0o.x0XOIxOo(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, R> Map<R, V> OI0(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(OI0.xoIox(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(transform.invoke(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    public static final <K, V> Map<K, V> OO(Map<K, ? extends V> map) {
        if (map == 0) {
            return O0xOxO();
        }
        return map;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> OO0x0xX(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        XI0oooXX(linkedHashMap, pairs);
        return xoxXI(linkedHashMap);
    }

    public static final <K, V> void OOXIxO0(@OXOo.OOXIXo Map<? super K, ? super V> map, @OXOo.OOXIXo Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static <K, V> Map<K, V> OX00O0xII(@OXOo.OOXIXo Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        int size = map.size();
        if (size != 0) {
            if (size != 1) {
                return O0X(map);
            }
            return OI0.oO(map);
        }
        return O0xOxO();
    }

    @xx0o0O.XO
    public static final <K, V> boolean OxI(Map<K, ? extends V> map, V v) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.containsValue(v);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.6")
    public static final <K, V> Map<K, V> Oxx0xo(int i, @kotlin.II0xO0 Oox.oOoXoXO<? super Map<K, V>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        Map II0XooXoX2 = OI0.II0XooXoX(i);
        builderAction.invoke(II0XooXoX2);
        return OI0.oxoX(II0XooXoX2);
    }

    @xx0o0O.XO
    public static final <K, V> K OxxIIOOXO(Map.Entry<? extends K, ? extends V> entry) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(entry, "<this>");
        return entry.getKey();
    }

    @xx0o0O.XO
    public static final <K, V> boolean X00IoxXI(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return !map.isEmpty();
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> X0IIOO(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> XI0IXoo(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super K, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> void XI0oooXX(@OXOo.OOXIXo Map<? super K, ? super V> map, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M XIXIX(@OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends Pair<? extends K, ? extends V>> ooooo0oxi, @OXOo.OOXIXo M destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        XI0oooXX(destination, ooooo0oxi);
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> XIo0oOXIx(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Pair<? extends K, ? extends V>[] pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        if (map.isEmpty()) {
            return oXIO0o0XI(pairs);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        OOXIxO0(linkedHashMap, pairs);
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> XIxXXX0x0(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <K, V> LinkedHashMap<K, V> XOxIOxOx(@OXOo.OOXIXo Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        return (LinkedHashMap) oOo(pairs, new LinkedHashMap(OI0.xoIox(pairs.length)));
    }

    @OXOo.OOXIXo
    public static <K, V> Map<K, V> XX(@OXOo.OOXIXo Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        if (pairs.length > 0) {
            return oOo(pairs, new LinkedHashMap(OI0.xoIox(pairs.length)));
        }
        return O0xOxO();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> void XX0(Map<K, V> map, Iterable<? extends K> keys) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keys, "keys");
        OxI.oXIO0o0XI(map.keySet(), keys);
    }

    @xx0o0O.XO
    public static final <K, V> void XX0xXo(Map<? super K, ? super V> map, Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pair, "pair");
        map.put(pair.getFirst(), pair.getSecond());
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> void Xo0(Map<K, V> map, K[] keys) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keys, "keys");
        OxI.IIX0(map.keySet(), keys);
    }

    @XO0OX.xxIXOIIO(name = "mutableIterator")
    @xx0o0O.XO
    public static final <K, V> Iterator<Map.Entry<K, V>> XoI0Ixx0(Map<K, V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.entrySet().iterator();
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> Map<K, V> XoX(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Iterable<? extends K> keys) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keys, "keys");
        Map O0X2 = O0X(map);
        OxI.oXIO0o0XI(O0X2.keySet(), keys);
        return xoxXI(O0X2);
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;LOox/oIX0oI<+TR;>;)TR; */
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final Object Xx000oIo(Map map, Oox.oIX0oI defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (map.isEmpty()) {
            return defaultValue.invoke();
        }
        return map;
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M XxX0x0xxx(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }

    @xx0o0O.XO
    public static final <K, V> Map<K, V> o0() {
        return O0xOxO();
    }

    @xx0o0O.XO
    public static final <K> boolean o00(Map<? extends K, ?> map, K k) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.containsKey(k);
    }

    @xx0o0O.XO
    public static final <K, V> void o0xxxXXxX(Map<? super K, ? super V> map, kotlin.sequences.ooOOo0oXI<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        XI0oooXX(map, pairs);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.6")
    public static final <K, V> Map<K, V> oI0IIXIo(@kotlin.II0xO0 Oox.oOoXoXO<? super Map<K, V>, oXIO0o0XI> builderAction) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(builderAction, "builderAction");
        Map Oxx0IOOO2 = OI0.Oxx0IOOO();
        builderAction.invoke(Oxx0IOOO2);
        return OI0.oxoX(Oxx0IOOO2);
    }

    @OXOo.OOXIXo
    public static <K, V> HashMap<K, V> oOXoIIIo(@OXOo.OOXIXo Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        HashMap<K, V> hashMap = new HashMap<>(OI0.xoIox(pairs.length));
        OOXIxO0(hashMap, pairs);
        return hashMap;
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M oOo(@OXOo.OOXIXo Pair<? extends K, ? extends V>[] pairArr, @OXOo.OOXIXo M destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairArr, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        OOXIxO0(destination, pairArr);
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> void oX(Map<K, V> map, kotlin.sequences.ooOOo0oXI<? extends K> keys) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keys, "keys");
        OxI.O0X(map.keySet(), keys);
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> oXIO0o0XI(@OXOo.OOXIXo Pair<? extends K, ? extends V>[] pairArr) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairArr, "<this>");
        int length = pairArr.length;
        if (length != 0) {
            if (length != 1) {
                return oOo(pairArr, new LinkedHashMap(OI0.xoIox(pairArr.length)));
            }
            return OI0.OOXIXo(pairArr[0]);
        }
        return O0xOxO();
    }

    @kotlin.oxxXoxO(version = "1.1")
    public static <K, V> V oo(@OXOo.OOXIXo Map<K, ? extends V> map, K k) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return (V) XOxIOxOx.oIX0oI(map, k);
    }

    public static final <K, V> V oo0xXOI0I(@OXOo.OOXIXo Map<K, V> map, K k, @OXOo.OOXIXo Oox.oIX0oI<? extends V> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        V v = map.get(k);
        if (v == null) {
            V invoke = defaultValue.invoke();
            map.put(k, invoke);
            return invoke;
        }
        return v;
    }

    @OXOo.OOXIXo
    public static <K, V> Map<K, V> ooOx(@OXOo.OOXIXo Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Pair<? extends K, ? extends V> next;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return xoO0xx0(iterable, new LinkedHashMap(OI0.xoIox(collection.size())));
                }
                if (iterable instanceof List) {
                    next = (Pair<? extends K, ? extends V>) ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                return OI0.OOXIXo(next);
            }
            return O0xOxO();
        }
        return xoxXI(xoO0xx0(iterable, new LinkedHashMap()));
    }

    @xx0o0O.XO
    public static final <K, V> V ooXIXxIX(Map<K, ? extends V> map, K k, Oox.oIX0oI<? extends V> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        V v = map.get(k);
        if (v == null) {
            return defaultValue.invoke();
        }
        return v;
    }

    public static final <K, V> void ox(@OXOo.OOXIXo Map<? super K, ? super V> map, @OXOo.OOXIXo Iterable<? extends Pair<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pairs, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairs) {
            map.put(pair.component1(), pair.component2());
        }
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> Map<K, V> oxXx0IX(@OXOo.OOXIXo Map<? extends K, ? extends V> map, K k) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        Map O0X2 = O0X(map);
        O0X2.remove(k);
        return xoxXI(O0X2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V, R, M extends Map<? super K, ? super R>> M oxxXoxO(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            destination.put(entry.getKey(), transform.invoke(entry));
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> LinkedHashMap<K, V> x0o() {
        return new LinkedHashMap<>();
    }

    @OXOo.OOXIXo
    public static <K, V> Map<K, V> x0xO(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(pair, "pair");
        if (map.isEmpty()) {
            return OI0.OOXIXo(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    public static final <K, V> V xI(@OXOo.OOXIXo Map<K, ? extends V> map, K k, @OXOo.OOXIXo Oox.oIX0oI<? extends V> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        V v = map.get(k);
        if (v == null && !map.containsKey(k)) {
            return defaultValue.invoke();
        }
        return v;
    }

    @xx0o0O.XO
    public static final <K, V> Iterator<Map.Entry<K, V>> xII(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.entrySet().iterator();
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> xOOOX(@OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends Pair<? extends K, ? extends V>> ooooo0oxi) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return xoxXI(XIXIX(ooooo0oxi, new LinkedHashMap()));
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V, M extends Map<? super K, ? super V>> M xX0IIXIx0(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo M destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        destination.putAll(map);
        return destination;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> Map<K, V> xXOx(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo K[] keys) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keys, "keys");
        Map O0X2 = O0X(map);
        OxI.IIX0(O0X2.keySet(), keys);
        return xoxXI(O0X2);
    }

    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> xXxxox0I(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super V, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (predicate.invoke(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V> Map<K, V> xo0x(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends K> keys) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keys, "keys");
        Map O0X2 = O0X(map);
        OxI.O0X(O0X2.keySet(), keys);
        return xoxXI(O0X2);
    }

    @OXOo.OOXIXo
    public static <K, V> Map<K, V> xoIxX(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Map<? extends K, ? extends V> map2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M xoO0xx0(@OXOo.OOXIXo Iterable<? extends Pair<? extends K, ? extends V>> iterable, @OXOo.OOXIXo M destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        ox(destination, iterable);
        return destination;
    }

    @xx0o0O.XO
    public static final <K, V> boolean xoXoI(Map<? extends K, ? extends V> map, K k) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.containsKey(k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <K, V> Map<K, V> xoxXI(@OXOo.OOXIXo Map<K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        int size = map.size();
        if (size != 0) {
            if (size == 1) {
                return OI0.oO(map);
            }
            return map;
        }
        return O0xOxO();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    public static final <K, V> void xxIO(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(map2, "map");
        map.putAll(map2);
    }

    @OXOo.OOXIXo
    public static final <K, V, M extends Map<? super K, ? super V>> M xxX(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        }
        return destination;
    }
}
