package kotlin.collections;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\n_Maps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,594:1\n96#1,5:595\n111#1,5:600\n152#1,3:605\n143#1:608\n215#1:609\n216#1:611\n144#1:612\n215#1:613\n216#1:615\n1#2:610\n1#2:614\n1940#3,14:616\n1963#3,14:630\n2310#3,14:644\n2333#3,14:658\n1864#3,3:672\n*S KotlinDebug\n*F\n+ 1 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n76#1:595,5\n89#1:600,5\n125#1:605,3\n135#1:608\n135#1:609\n135#1:611\n135#1:612\n143#1:613\n143#1:615\n135#1:610\n230#1:616,14\n241#1:630,14\n390#1:644,14\n401#1:658,14\n574#1:672,3\n*E\n"})
/* loaded from: classes6.dex */
public class I0oOoX extends XX {
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> I0xX0(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            entry = null;
        } else {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R invoke2 = selector.invoke(entry3);
                    if (invoke.compareTo(invoke2) > 0) {
                        entry2 = entry3;
                        invoke = invoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        }
        return entry;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, R extends Comparable<? super R>> R IO0XoXxO(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = selector.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = selector.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, R> R IOoo(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) selector.invoke((Object) it.next());
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke((Object) it.next());
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapSequenceTo")
    @kotlin.X00IoxXI
    public static final <K, V, R, C extends Collection<? super R>> C IXO(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends kotlin.sequences.ooOOo0oXI<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            OxI.Ioxxx(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <K, V> boolean IoIOOxIIo(@OXOo.OOXIXo Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return !map.isEmpty();
    }

    @OXOo.OOXIXo
    public static final <K, V, R> List<R> IoXIXo(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @xx0o0O.X0o0xo
    public static final <K, V> void Ix00oIoI(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    @OXOo.OOXIXo
    public static final <K, V, R> List<R> IxIX0I(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, M extends Map<? extends K, ? extends V>> M IxX00(@OXOo.OOXIXo M m, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Map.Entry<? extends K, ? extends V>, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(m, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        Iterator<T> it = m.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            I00O.II0xO0 iI0xO0 = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            action.invoke(Integer.valueOf(i), iI0xO0);
            i = i2;
        }
        return m;
    }

    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.7")
    public static final <K, V> Map.Entry<K, V> O00(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.OIx0xoOo(map.entrySet(), comparator);
    }

    @OXOo.OOXIXo
    public static final <K, V, R> List<R> O0IxXx(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    public static final <K, V> boolean O0xxXxI(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> int OIOoIIOIx(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        if (map.isEmpty()) {
            return 0;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, R> R OIx00oxx(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) selector.invoke((Object) it.next());
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke((Object) it.next());
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> Double OO0(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke((Object) it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> double OX(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = selector.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke((Object) it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final <K, V> int OoO(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.size();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> Float OooI(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke((Object) it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.7")
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> Oxx(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry = (Object) it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(entry);
                do {
                    Map.Entry<K, V> entry2 = (Object) it.next();
                    R invoke2 = selector.invoke(entry2);
                    if (invoke.compareTo(invoke2) > 0) {
                        entry = entry2;
                        invoke = invoke2;
                    }
                } while (it.hasNext());
            }
            return entry;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> double X0xII0I(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = selector.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke((Object) it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> float X0xxXX0(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = selector.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke((Object) it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> Float XI(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke((Object) it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static <K, V> kotlin.sequences.ooOOo0oXI<Map.Entry<K, V>> XIXIxO(@OXOo.OOXIXo Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return CollectionsKt___CollectionsKt.OooI(map.entrySet());
    }

    @OXOo.OOXIXo
    public static <K, V> List<Pair<K, V>> XO0o(@OXOo.OOXIXo Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        if (map.size() == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return oI0IIXIo.OOXIXo(new Pair(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(map.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> Double XOxxooXI(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke((Object) it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.7")
    public static final <K, V> Map.Entry<K, V> XXXI(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.IOXOxOII(map.entrySet(), comparator);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final <K, V, R> R XXoOx0(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, R extends Comparable<? super R>> R XoIxOXIXo(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R invoke = selector.invoke((Object) it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke((Object) it.next());
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, R extends Comparable<? super R>> R o0IXXIx(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = selector.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = selector.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final <K, V> Iterable<Map.Entry<K, V>> o0oIxOo(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.entrySet();
    }

    @OXOo.OOXIXo
    public static final <K, V, R, C extends Collection<? super R>> C oI(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            OxI.XIo0oOXIx(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, R> R oIIxXoo(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((Object) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((Object) it.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (Object) obj2;
            }
        }
        return obj;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapSequence")
    @kotlin.X00IoxXI
    public static final <K, V, R> List<R> oOoIIO0(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends kotlin.sequences.ooOOo0oXI<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            OxI.Ioxxx(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> float oXIoO(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = selector.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke((Object) it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> Map.Entry<K, V> oXX0IoI(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.xx00oOoI(map.entrySet(), comparator);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, R extends Comparable<? super R>> R oXxOI0oIx(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        R invoke = selector.invoke((Object) it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke((Object) it.next());
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    public static final <K, V> boolean oxIIX0o(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <K, V, M extends Map<? extends K, ? extends V>> M oxOXxoXII(@OXOo.OOXIXo M m, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(m, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        Iterator<Map.Entry<K, V>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        return m;
    }

    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.7")
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> x0(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<K, V> entry = (Object) it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(entry);
                do {
                    Map.Entry<K, V> entry2 = (Object) it.next();
                    R invoke2 = selector.invoke(entry2);
                    if (invoke.compareTo(invoke2) < 0) {
                        entry = entry2;
                        invoke = invoke2;
                    }
                } while (it.hasNext());
            }
            return entry;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final <K, V, R> R x0OIX00oO(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        R r;
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                r = transform.invoke(it.next());
                if (r != null) {
                    break;
                }
            } else {
                r = null;
                break;
            }
        }
        if (r != null) {
            return r;
        }
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> x0OxxIOxX(Map<? extends K, ? extends V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Map.Entry<K, V> entry;
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            entry = null;
        } else {
            Map.Entry<K, V> entry2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(entry2);
                do {
                    Map.Entry<K, V> entry3 = (Object) it.next();
                    R invoke2 = selector.invoke(entry3);
                    if (invoke.compareTo(invoke2) < 0) {
                        entry2 = entry3;
                        invoke = invoke2;
                    }
                } while (it.hasNext());
            }
            entry = entry2;
        }
        return entry;
    }

    public static final <K, V> boolean xI0oxI00(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V, R> R xIXX(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((Object) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((Object) it.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (Object) obj2;
            }
        }
        return obj;
    }

    public static final <K, V> boolean xOOxIO(@OXOo.OOXIXo Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        return map.isEmpty();
    }

    @OXOo.OOXIXo
    public static final <K, V, R, C extends Collection<? super R>> C xXoOI00O(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <K, V, R, C extends Collection<? super R>> C xxOXOOoIX(@OXOo.OOXIXo Map<? extends K, ? extends V> map, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <K, V> Map.Entry<K, V> xxxI(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.oxOIoIx(map.entrySet(), comparator);
    }
}
