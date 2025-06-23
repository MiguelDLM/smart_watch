package kotlin.collections;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.IIX0;
import kotlin.Pair;
import kotlin.XI0oooXX;
import kotlin.oXIO0o0XI;
import kotlin.random.Random;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.xxIO;
import xX0ox.Oxx0IOOO;

@kotlin.jvm.internal.XX({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,3683:1\n288#1,2:3684\n518#1,7:3686\n533#1,6:3693\n857#1,2:3700\n788#1:3702\n1864#1,2:3703\n789#1,2:3705\n1866#1:3707\n791#1:3708\n1864#1,3:3709\n809#1,2:3712\n847#1,2:3714\n1253#1,4:3720\n1222#1,4:3724\n1238#1,4:3728\n1285#1,4:3732\n1446#1,5:3736\n1461#1,5:3741\n1502#1,3:3746\n1505#1,3:3756\n1520#1,3:3759\n1523#1,3:3769\n1620#1,3:3786\n1590#1,4:3789\n1579#1:3793\n1864#1,2:3794\n1866#1:3797\n1580#1:3798\n1864#1,3:3799\n1611#1:3802\n1855#1:3803\n1856#1:3805\n1612#1:3806\n1855#1,2:3807\n1864#1,3:3809\n2847#1,3:3812\n2850#1,6:3816\n2872#1,3:3822\n2875#1,7:3826\n857#1,2:3833\n819#1:3835\n847#1,2:3836\n819#1:3838\n847#1,2:3839\n819#1:3841\n847#1,2:3842\n3405#1,8:3848\n3433#1,7:3856\n3464#1,10:3863\n1#2:3699\n1#2:3796\n1#2:3804\n1#2:3815\n1#2:3825\n37#3,2:3716\n37#3,2:3718\n372#4,7:3749\n372#4,7:3762\n372#4,7:3772\n372#4,7:3779\n32#5,2:3844\n32#5,2:3846\n*S KotlinDebug\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n167#1:3684,2\n177#1:3686,7\n187#1:3693,6\n766#1:3700,2\n777#1:3702\n777#1:3703,2\n777#1:3705,2\n777#1:3707\n777#1:3708\n788#1:3709,3\n800#1:3712,2\n819#1:3714,2\n1180#1:3720,4\n1195#1:3724,4\n1209#1:3728,4\n1272#1:3732,4\n1360#1:3736,5\n1373#1:3741,5\n1477#1:3746,3\n1477#1:3756,3\n1490#1:3759,3\n1490#1:3769,3\n1549#1:3786,3\n1559#1:3789,4\n1569#1:3793\n1569#1:3794,2\n1569#1:3797\n1569#1:3798\n1579#1:3799,3\n1603#1:3802\n1603#1:3803\n1603#1:3805\n1603#1:3806\n1611#1:3807,2\n2645#1:3809,3\n2949#1:3812,3\n2949#1:3816,6\n2967#1:3822,3\n2967#1:3826,7\n3143#1:3833,2\n3151#1:3835\n3151#1:3836,2\n3161#1:3838\n3161#1:3839,2\n3171#1:3841\n3171#1:3842,2\n3394#1:3848,8\n3422#1:3856,7\n3451#1:3863,10\n1569#1:3796\n1603#1:3804\n2949#1:3815\n2967#1:3825\n1032#1:3716,2\n1075#1:3718,2\n1477#1:3749,7\n1490#1:3762,7\n1504#1:3772,7\n1522#1:3779,7\n3339#1:3844,2\n3381#1:3846,2\n*E\n"})
/* loaded from: classes6.dex */
public class CollectionsKt___CollectionsKt extends X0IIOO {

    @kotlin.jvm.internal.XX({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1\n*L\n1#1,3683:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0<K, T> implements XxX0x0xxx<T, K> {

        /* renamed from: II0xO0 */
        public final /* synthetic */ Oox.oOoXoXO<T, K> f29109II0xO0;

        /* renamed from: oIX0oI */
        public final /* synthetic */ Iterable<T> f29110oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public II0xO0(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends K> oooxoxo) {
            this.f29110oIX0oI = iterable;
            this.f29109II0xO0 = oooxoxo;
        }

        @Override // kotlin.collections.XxX0x0xxx
        @OXOo.OOXIXo
        public Iterator<T> II0xO0() {
            return this.f29110oIX0oI.iterator();
        }

        @Override // kotlin.collections.XxX0x0xxx
        public K oIX0oI(T t) {
            return this.f29109II0xO0.invoke(t);
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,680:1\n3524#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements kotlin.sequences.ooOOo0oXI<T> {

        /* renamed from: oIX0oI */
        public final /* synthetic */ Iterable f29111oIX0oI;

        public oIX0oI(Iterable iterable) {
            this.f29111oIX0oI = iterable;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<T> iterator() {
            return this.f29111oIX0oI.iterator();
        }
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C I00O(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            OxI.XIo0oOXIx(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T I0O00OI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : iterable) {
            if (predicate.invoke(t2).booleanValue()) {
                if (!z) {
                    z = true;
                    t = t2;
                } else {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float I0OO(@OXOo.OOXIXo Iterable<Float> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final <T> List<T> I0XIOxO(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!predicate.invoke(listIterator.previous()).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return oOo0o(list);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> int II0(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += selector.invoke(it.next()).intValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, C extends Iterable<? extends T>> C II0OOXOx(@OXOo.OOXIXo C c, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(c, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int i = 0;
        for (T t : c) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            action.invoke(Integer.valueOf(i), t);
            i = i2;
        }
        return c;
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C IIIxO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <T> T IIOIX(@OXOo.OOXIXo Iterable<? extends T> iterable, int i, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (i >= 0 && i <= CollectionsKt__CollectionsKt.oo0xXOI0I(list)) {
                return (T) list.get(i);
            }
            return defaultValue.invoke(Integer.valueOf(i));
        }
        if (i < 0) {
            return defaultValue.invoke(Integer.valueOf(i));
        }
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return defaultValue.invoke(Integer.valueOf(i));
    }

    @OXOo.oOoXoXO
    public static final <T> T IIXOxIxOo(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() != 1) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final double IIoX0OoI(@OXOo.OOXIXo Iterable<Double> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (it.hasNext()) {
            double doubleValue = it.next().doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, it.next().doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, C extends Iterable<? extends T>> C IO0xX(@OXOo.OOXIXo C c, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(c, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        Iterator<T> it = c.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        return c;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R IOI(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            R invoke = selector.invoke(it.next());
            while (it.hasNext()) {
                R invoke2 = selector.invoke(it.next());
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static <T extends Comparable<? super T>> T IOOXOOOOo(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    @OXOo.OOXIXo
    public static <T> List<T> IOOoXo0Ix(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return (List) X0IOOI(iterable, new ArrayList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T> T IOXOxOII(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            Object obj = (T) it.next();
            while (it.hasNext()) {
                Object obj2 = (T) it.next();
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (T) obj2;
                }
            }
            return (T) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <T> Pair<List<T>, List<T>> IOo0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @xx0o0O.XO
    public static final <T> List<T> IOooo0o(Collection<? extends T> collection, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        return OIxOIX0II(collection, t);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <S, T extends S> List<S> IXI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        arrayList.add(next);
        int i = 1;
        while (it.hasNext()) {
            next = operation.invoke(Integer.valueOf(i), next, it.next());
            arrayList.add(next);
            i++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> List<R> IXIIo(@OXOo.OOXIXo Iterable<? extends T> iterable, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xo0x2 = OxxIIOOXO.xo0x(iterable, 9);
        if (xo0x2 == 0) {
            return oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(xo0x2 + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            r = operation.invoke(Integer.valueOf(i), r, it.next());
            arrayList.add(r);
            i++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T, R> List<R> IXIxx0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            R invoke = transform.invoke(Integer.valueOf(i), t);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i = i2;
        }
        return arrayList;
    }

    public static final <T> int IXX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = -1;
        int i2 = 0;
        for (T t : iterable) {
            if (i2 < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (predicate.invoke(t).booleanValue()) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C IXXIXx00I(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            R invoke = transform.invoke(Integer.valueOf(i), t);
            if (invoke != null) {
                destination.add(invoke);
            }
            i = i2;
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    @OXOo.oOoXoXO
    public static final <T> T IXo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        boolean z = false;
        T t = null;
        for (T t2 : iterable) {
            if (predicate.invoke(t2).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = t2;
            }
        }
        if (!z) {
            return null;
        }
        return t;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedSequenceTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T, R, C extends Collection<? super R>> C IXoIo(Iterable<? extends T> iterable, C destination, Oox.x0xO0oo<? super Integer, ? super T, ? extends kotlin.sequences.ooOOo0oXI<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            OxI.Ioxxx(destination, transform.invoke(Integer.valueOf(i), t));
            i = i2;
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @OXOo.oOoXoXO
    public static final <T> T IXxOIOO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        T t = null;
        for (T t2 : iterable) {
            if (predicate.invoke(t2).booleanValue()) {
                t = t2;
            }
        }
        return t;
    }

    @OXOo.OOXIXo
    public static final <T, A extends Appendable> A IoX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super T, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.text.IXxxXO.II0xO0(buffer, t, oooxoxo);
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Double IoXO0XoX(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float IoxOx(@OXOo.OOXIXo Iterable<Float> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> List<R> IoxX(@OXOo.OOXIXo Iterable<? extends T> iterable, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xo0x2 = OxxIIOOXO.xo0x(iterable, 9);
        if (xo0x2 == 0) {
            return oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(xo0x2 + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r = operation.invoke(r, it.next());
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T, C extends Collection<? super T>> C Ix0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T, K, M extends Map<? super K, List<T>>> M Ix0x(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (T t : iterable) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(t);
        }
        return destination;
    }

    public static final <T> void IxI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            action.invoke(Integer.valueOf(i), t);
            i = i2;
        }
    }

    @OXOo.OOXIXo
    public static final <T> List<T> IxIo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (predicate.invoke(Integer.valueOf(i), t).booleanValue()) {
                arrayList.add(t);
            }
            i = i2;
        }
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final float IxO0Oxo(@OXOo.OOXIXo Iterable<Float> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (it.hasNext()) {
            float floatValue = it.next().floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, it.next().floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> List<T> IxOIO(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return xxx(iterable, xX0ox.Oxx0IOOO.o00());
    }

    public static final <T> T IxOXOxO(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static final <K, V, M extends Map<? super K, ? super V>> M IxX00(@OXOo.OOXIXo Iterable<? extends K> iterable, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (K k : iterable) {
            destination.put(k, valueSelector.invoke(k));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static <T> List<T> IxoOxx(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            return o0Xo0XII((Collection) iterable);
        }
        return (List) X0oX(iterable, new ArrayList());
    }

    @OXOo.OOXIXo
    public static final <T, K, M extends Map<? super K, ? super T>> M O00(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        for (T t : iterable) {
            destination.put(keySelector.invoke(t), t);
        }
        return destination;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <S, T extends S> S O0IoXXOx(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S previous = listIterator.previous();
        while (listIterator.hasPrevious()) {
            previous = operation.invoke(listIterator.previous(), previous);
        }
        return previous;
    }

    public static <T> T O0O0Io00X(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(CollectionsKt__CollectionsKt.oo0xXOI0I(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T O0OOX0IIx(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T, R extends Comparable<? super R>> void O0OoXI(@OXOo.OOXIXo List<T> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (list.size() > 1) {
            o00.OO0x0xX(list, new Oxx0IOOO.I0Io(selector));
        }
    }

    public static final <T> int O0o0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (T t : iterable) {
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (predicate.invoke(t).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static <T> List<T> O0o000XOX(@OXOo.OOXIXo Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return oOo0o(iterable);
                }
                if (i == 1) {
                    return oI0IIXIo.OOXIXo(oxIO0IIo(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            Iterator<? extends T> it = iterable.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                arrayList.add(it.next());
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return CollectionsKt__CollectionsKt.OI0(arrayList);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <T, R> List<R> O0x(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            OxI.XIo0oOXIx(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.2")
    public static final <T> List<Pair<T, T>> O0x0XXxI(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList();
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(kotlin.Xo0.oIX0oI(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T, R> List<R> O0xO0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            arrayList.add(transform.invoke(Integer.valueOf(i), t));
            i = i2;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T, K, V, M extends Map<? super K, ? super V>> M O0xxXxI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R OI0IXox(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            R invoke = selector.invoke(it.next());
            while (it.hasNext()) {
                R invoke2 = selector.invoke(it.next());
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <S, T extends S> S OIII0O(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        int i = 1;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            next = operation.invoke(Integer.valueOf(i), next, it.next());
            i = i2;
        }
        return next;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public static final <T> T OIIXOxo(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T previous = listIterator.previous();
            if (predicate.invoke(previous).booleanValue()) {
                return previous;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    @OXOo.oOoXoXO
    public static <T> T OIoxIx(@OXOo.OOXIXo List<? extends T> list, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (i >= 0 && i <= CollectionsKt__CollectionsKt.oo0xXOI0I(list)) {
            return list.get(i);
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <T, K, V> Map<K, V> OIx00oxx(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(OxxIIOOXO.xo0x(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T> T OIx0xoOo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            Object obj = (T) it.next();
            while (it.hasNext()) {
                Object obj2 = (T) it.next();
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (T) obj2;
                }
            }
            return (T) obj;
        }
        throw new NoSuchElementException();
    }

    public static final <T> int OIxI0O(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        Iterator<? extends T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static <T> List<T> OIxOIX0II(@OXOo.OOXIXo Collection<? extends T> collection, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T, R, C extends Collection<? super R>> C OIxOX(Iterable<? extends T> iterable, C destination, Oox.x0xO0oo<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i), t));
            i = i2;
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final <T, R> R OIxx0I0(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    public static final <T> Iterable<T> OO0(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return iterable;
    }

    @OXOo.OOXIXo
    public static final <T, K> List<T> OOIXx0x(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (hashSet.add(selector.invoke(t))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.2")
    public static final <T, R> List<R> OOOI(@OXOo.OOXIXo Iterable<? extends T> iterable, int i, @OXOo.OOXIXo Oox.oOoXoXO<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        return XOoxOOO(iterable, i, i, true, transform);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R OOOox(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R invoke = selector.invoke(it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke(it.next());
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    @OXOo.OOXIXo
    public static <T> List<T> OOoOoO0o(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return oOo0o(iterable);
        }
        List<T> IxoOxx = IxoOxx(iterable);
        X0IIOO.oXX0IoI(IxoOxx);
        return IxoOxx;
    }

    public static <T> int OOxOI(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.oxxXoxO();
            }
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T, K, V, M extends Map<? super K, List<V>>> M OOxOOxIO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (T t : iterable) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(t));
        }
        return destination;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.3")
    public static final <T> T OX00o0X(Collection<? extends T> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        return (T) ox0(collection, Random.Default);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapSequence")
    @kotlin.X00IoxXI
    public static final <T, R> List<R> OXIOoo0X0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends kotlin.sequences.ooOOo0oXI<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            OxI.Ioxxx(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static final <T> void OXOo(@OXOo.OOXIXo List<T> list, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        for (int oo0xXOI0I2 = CollectionsKt__CollectionsKt.oo0xXOI0I(list); oo0xXOI0I2 > 0; oo0xXOI0I2--) {
            int nextInt = random.nextInt(oo0xXOI0I2 + 1);
            list.set(nextInt, list.set(oo0xXOI0I2, list.get(nextInt)));
        }
    }

    @xx0o0O.XO
    public static final <T> int OXXoIoXI(Collection<? extends T> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        return collection.size();
    }

    @OXOo.OOXIXo
    public static final <T, K, V> Map<K, List<V>> OXooXo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : iterable) {
            K invoke = keySelector.invoke(t);
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> OXxx0OO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo T[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (elements.length == 0) {
            return oOo0o(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!ArraysKt___ArraysKt.OXO0oX(elements, t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> List<R> Oo0IXI0(@OXOo.OOXIXo Iterable<? extends T> iterable, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xo0x2 = OxxIIOOXO.xo0x(iterable, 9);
        if (xo0x2 == 0) {
            return oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(xo0x2 + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            r = operation.invoke(Integer.valueOf(i), r, it.next());
            arrayList.add(r);
            i++;
        }
        return arrayList;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final <T> double Oo0xX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        while (it.hasNext()) {
            d += selector.invoke(it.next()).doubleValue();
        }
        return d;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> float OoI0OO(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            float floatValue = selector.invoke(it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    public static /* synthetic */ String OoIXo(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i2 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i2 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            oooxoxo = null;
        }
        return xIoXXXIXo(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T> Iterable<T> OoOoXO0(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + '.');
            }
        }
        return iterable;
    }

    @OXOo.OOXIXo
    public static <T> Set<T> OoOoxX0xo(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) X0oX(iterable, new LinkedHashSet());
    }

    @OXOo.OOXIXo
    public static <T> kotlin.sequences.ooOOo0oXI<T> OooI(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return new oIX0oI(iterable);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @OXOo.oOoXoXO
    public static final <T> T OooO0XOx(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> float Oox(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            float floatValue = selector.invoke(it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> T OoxOxII(Collection<? extends T> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        return (T) xXIX0Xo(collection, Random.Default);
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> OoxxX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Iterable<? extends T> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<T> OoOoxX0xo = OoOoxX0xo(iterable);
        OxI.oXIO0o0XI(OoOoxX0xo, other);
        return OoOoxX0xo;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> Ox(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Iterable<Integer> indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        int xo0x2 = OxxIIOOXO.xo0x(indices, 10);
        if (xo0x2 == 0) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(xo0x2);
        Iterator<Integer> it = indices.iterator();
        while (it.hasNext()) {
            arrayList.add(list.get(it.next().intValue()));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> Ox00XOXoo(@OXOo.OOXIXo Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            return OIxOIX0II((Collection) iterable, t);
        }
        ArrayList arrayList = new ArrayList();
        OxI.XIo0oOXIx(arrayList, iterable);
        arrayList.add(t);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T> List<T> Ox0XO(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + '.');
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R OxIxx0(Iterable<? extends T> iterable, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((T) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @xx0o0O.XO
    public static final <T> T OxO(List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return list.get(2);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.2")
    public static <T> List<List<T>> OxXXx0X(@OXOo.OOXIXo Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return Xox0o(iterable, i, i, true);
    }

    @OXOo.OOXIXo
    public static final <T, C extends Collection<? super T>> C Oxo00O(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : iterable) {
            if (!predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T, R> List<Pair<T, R>> OxxIXIX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo R[] other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(iterable, 10), length));
        int i = 0;
        for (T t : iterable) {
            if (i >= length) {
                break;
            }
            arrayList.add(kotlin.Xo0.oIX0oI(t, other[i]));
            i++;
        }
        return arrayList;
    }

    public static final <S, T extends S> S Oxxo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.x0xO0oo<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            S next = it.next();
            while (it.hasNext()) {
                next = operation.invoke(next, it.next());
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double X0(@OXOo.OOXIXo Iterable<Double> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R X00IxOx(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        R invoke = selector.invoke(it.next());
        while (it.hasNext()) {
            R invoke2 = selector.invoke(it.next());
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
            }
        }
        return invoke;
    }

    public static <T> boolean X00xOoXI(@OXOo.OOXIXo Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        if (oox000IX(iterable, t) >= 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super T>, T> C X0IOOI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (T t : iterable) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    @xx0o0O.XO
    public static final <T> T X0O0I0(List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return list.get(1);
    }

    public static final <T> boolean X0OXX(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    @OXOo.OOXIXo
    public static <T, C extends Collection<? super T>> C X0oX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @OXOo.oOoXoXO
    public static final <T> T X0ooXIooI(@OXOo.OOXIXo Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) OIoxIx((List) iterable, i);
        }
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T X0x(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            R invoke = selector.invoke(next);
            do {
                T next2 = it.next();
                R invoke2 = selector.invoke(next2);
                next = next;
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                    next = next2;
                }
            } while (it.hasNext());
            return (T) next;
        }
        throw new NoSuchElementException();
    }

    public static final <T> T X0xOO(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) O0O0Io00X((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, K> XxX0x0xxx<T, K> XIOOI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        return new II0xO0(iterable, keySelector);
    }

    @OXOo.OOXIXo
    public static <T> HashSet<T> XIo(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return (HashSet) X0oX(iterable, new HashSet(OI0.xoIox(OxxIIOOXO.xo0x(iterable, 12))));
    }

    @OXOo.OOXIXo
    public static final <T, R> List<R> XIxO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List XIxoOo0oI(Iterable iterable, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return Xox0o(iterable, i, i2, z);
    }

    public static <T> T XO0(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) IxOXOxO((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> int XO00XOO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue() && (i = i + 1) < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.oxxXoxO();
                } else {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        return i;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> double XO0OX(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            double doubleValue = selector.invoke(it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @XO0OX.xxIXOIIO(name = "averageOfByte")
    public static final double XO0o(@OXOo.OOXIXo Iterable<Byte> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().byteValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.oxxXoxO();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> XOOO0O(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        ArrayList arrayList = new ArrayList();
        OxI.XIo0oOXIx(arrayList, iterable);
        OxI.Ioxxx(arrayList, elements);
        return arrayList;
    }

    @OXOo.OOXIXo
    public static <T> Set<T> XOo0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Iterable<? extends T> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<T> OoOoxX0xo = OoOoxX0xo(iterable);
        OxI.oxIIX0o(OoOoxX0xo, other);
        return OoOoxX0xo;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.2")
    public static final <T, R> List<R> XOoxOOO(@OXOo.OOXIXo Iterable<? extends T> iterable, int i, int i2, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super List<? extends T>, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        SlidingWindowKt.oIX0oI(i, i2);
        int i3 = 1;
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            int i4 = size / i2;
            int i5 = 0;
            if (size % i2 == 0) {
                i3 = 0;
            }
            ArrayList arrayList = new ArrayList(i4 + i3);
            oxxXoxO oxxxoxo = new oxxXoxO(list);
            while (i5 >= 0 && i5 < size) {
                int XI0IXoo2 = X0.IIXOooo.XI0IXoo(i, size - i5);
                if (!z && XI0IXoo2 < i) {
                    break;
                }
                oxxxoxo.oIX0oI(i5, XI0IXoo2 + i5);
                arrayList.add(transform.invoke(oxxxoxo));
                i5 += i2;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator II0xO02 = SlidingWindowKt.II0xO0(iterable.iterator(), i, i2, z, true);
        while (II0xO02.hasNext()) {
            arrayList2.add(transform.invoke((List) II0xO02.next()));
        }
        return arrayList2;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> List<R> XOx(@OXOo.OOXIXo Iterable<? extends T> iterable, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int xo0x2 = OxxIIOOXO.xo0x(iterable, 9);
        if (xo0x2 == 0) {
            return oI0IIXIo.OOXIXo(r);
        }
        ArrayList arrayList = new ArrayList(xo0x2 + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r = operation.invoke(r, it.next());
            arrayList.add(r);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static <T, R> List<Pair<T, R>> XOx0xX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Iterable<? extends R> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(iterable, 10), OxxIIOOXO.xo0x(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(kotlin.Xo0.oIX0oI(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final /* synthetic */ <R> List<R> XOxoX(Iterable<?> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            kotlin.jvm.internal.IIX0o.OxI(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> double XXIoX0(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            double doubleValue = selector.invoke(it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <T> List<T> XXO0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Iterable<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Collection XX0xXo2 = OxI.XX0xXo(elements);
        if (XX0xXo2.isEmpty()) {
            return oOo0o(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!XX0xXo2.contains(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <S, T extends S> S XXoO0oX(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (listIterator.hasPrevious()) {
            S previous = listIterator.previous();
            while (listIterator.hasPrevious()) {
                previous = operation.invoke(listIterator.previous(), previous);
            }
            return previous;
        }
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    public static final <S, T extends S> S XXooOOI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            S next = it.next();
            int i = 1;
            while (it.hasNext()) {
                int i2 = i + 1;
                if (i < 0) {
                    if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                        CollectionsKt__CollectionsKt.XoX();
                    } else {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                }
                next = operation.invoke(Integer.valueOf(i), next, it.next());
                i = i2;
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double XXx0OXXXo(@OXOo.OOXIXo Iterable<Double> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    public static final <T> T Xo(@OXOo.OOXIXo Iterable<? extends T> iterable, final int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i);
        }
        return (T) IIOIX(iterable, i, new Oox.oOoXoXO<Integer, T>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$elementAt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final T invoke(int i2) {
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + i + '.');
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        });
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> double XoIoOXOIx(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        while (it.hasNext()) {
            d += selector.invoke(it.next()).doubleValue();
        }
        return d;
    }

    public static final <T> boolean XoIxOXIXo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> long XoOOOXox(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Long> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += selector.invoke(it.next()).longValue();
        }
        return j;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T extends Comparable<? super T>> T XoOOx0IX(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) < 0) {
                    next = next2;
                }
            }
            return next;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    public static final <T> T XoOxI0ox(List<? extends T> list, int i, Oox.oOoXoXO<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= CollectionsKt__CollectionsKt.oo0xXOI0I(list)) {
            return list.get(i);
        }
        return defaultValue.invoke(Integer.valueOf(i));
    }

    @OXOo.OOXIXo
    public static <T> List<T> XooIO0oo0(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return oOo0o(OoOoxX0xo(iterable));
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.2")
    public static final <T> List<List<T>> Xox0o(@OXOo.OOXIXo Iterable<? extends T> iterable, int i, int i2, boolean z) {
        int i3;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        SlidingWindowKt.oIX0oI(i, i2);
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            int i4 = size / i2;
            if (size % i2 == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            ArrayList arrayList = new ArrayList(i4 + i3);
            int i5 = 0;
            while (i5 >= 0 && i5 < size) {
                int XI0IXoo2 = X0.IIXOooo.XI0IXoo(i, size - i5);
                if (XI0IXoo2 < i && !z) {
                    break;
                }
                ArrayList arrayList2 = new ArrayList(XI0IXoo2);
                for (int i6 = 0; i6 < XI0IXoo2; i6++) {
                    arrayList2.add(list.get(i6 + i5));
                }
                arrayList.add(arrayList2);
                i5 += i2;
            }
            return arrayList;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator II0xO02 = SlidingWindowKt.II0xO0(iterable.iterator(), i, i2, z, false);
        while (II0xO02.hasNext()) {
            arrayList3.add((List) II0xO02.next());
        }
        return arrayList3;
    }

    @xx0o0O.XO
    public static final <T> List<T> Xx(Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return x0xOIoO(iterable, t);
    }

    public static final <T> boolean Xx0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> long Xx0oX(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, XI0oooXX> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(it.next()).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.oOoXoXO
    public static final <T> T XxI(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    @OXOo.OOXIXo
    public static <T> Set<T> XxI0(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        Object next;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return (Set) X0oX(iterable, new LinkedHashSet(OI0.xoIox(collection.size())));
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                return oX.XO(next);
            }
            return Xo0.OOXIXo();
        }
        return Xo0.IXxxXO((Set) X0oX(iterable, new LinkedHashSet()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T XxIIOXIXx(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : iterable) {
            if (predicate.invoke(t2).booleanValue()) {
                z = true;
                t = t2;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static <T> List<T> XxIOX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Iterable<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (iterable instanceof Collection) {
            return o0xIIX0((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        OxI.XIo0oOXIx(arrayList, iterable);
        OxI.XIo0oOXIx(arrayList, elements);
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
    @xx0o0O.XO
    public static final <T> T XxIo(List<? extends T> list, Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T previous = listIterator.previous();
            if (predicate.invoke(previous).booleanValue()) {
                return previous;
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static double[] XxOOoxOO(@OXOo.OOXIXo Collection<Double> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        double[] dArr = new double[collection.size()];
        Iterator<Double> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            dArr[i] = it.next().doubleValue();
            i++;
        }
        return dArr;
    }

    @OXOo.oOoXoXO
    public static <T> T XxXX(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static /* synthetic */ List XxoOI00IX(Iterable iterable, int i, int i2, boolean z, Oox.oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return XOoxOOO(iterable, i, i2, z, oooxoxo);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <S, T extends S> S Xxx0oXX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.x0xO0oo<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
        }
        return next;
    }

    @xx0o0O.X0o0xo
    public static final <T> void o00xOoIO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> action) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(action, "action");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    public static final <T> boolean o0IXXIx(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            return !((Collection) iterable).isEmpty();
        }
        return iterable.iterator().hasNext();
    }

    public static final <T, R> R o0OO0(@OXOo.OOXIXo List<? extends T> list, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r = operation.invoke(listIterator.previous(), r);
            }
        }
        return r;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T, R> List<R> o0Oo(Iterable<? extends T> iterable, Oox.x0xO0oo<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            OxI.XIo0oOXIx(arrayList, transform.invoke(Integer.valueOf(i), t));
            i = i2;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static int[] o0Oox0xox(@OXOo.OOXIXo Collection<Integer> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    @xx0o0O.XO
    public static final <T> T o0Xo(List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return list.get(4);
    }

    @OXOo.OOXIXo
    public static <T> List<T> o0Xo0XII(@OXOo.OOXIXo Collection<? extends T> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        return new ArrayList(collection);
    }

    @OXOo.OOXIXo
    public static final <T> List<T> o0oIxXOx(@OXOo.OOXIXo Collection<? extends T> collection, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        OxI.Ioxxx(arrayList, elements);
        return arrayList;
    }

    @xx0o0O.XO
    public static final <T> T o0oxo0oI(List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return list.get(0);
    }

    @OXOo.OOXIXo
    public static <T> List<T> o0xIIX0(@OXOo.OOXIXo Collection<? extends T> collection, @OXOo.OOXIXo Iterable<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        OxI.XIo0oOXIx(arrayList2, elements);
        return arrayList2;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T o0xIoII(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            R invoke = selector.invoke(next);
            do {
                T next2 = it.next();
                R invoke2 = selector.invoke(next2);
                next = next;
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                    next = next2;
                }
            } while (it.hasNext());
            return (T) next;
        }
        throw new NoSuchElementException();
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static <T extends Comparable<? super T>> T o0xOIoxo(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static /* synthetic */ Appendable oI0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i3;
        CharSequence charSequence7;
        Oox.oOoXoXO oooxoxo2;
        if ((i2 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i2 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i2 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            oooxoxo2 = null;
        } else {
            oooxoxo2 = oooxoxo;
        }
        return IoX(iterable, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final <T extends Comparable<? super T>> T oI00o(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        throw new NoSuchElementException();
    }

    public static final <T> int oI0X0(@OXOo.OOXIXo Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t);
        }
        int i = -1;
        int i2 = 0;
        for (T t2 : iterable) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(t, t2)) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final char[] oII(@OXOo.OOXIXo Collection<Character> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        char[] cArr = new char[collection.size()];
        Iterator<Character> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            cArr[i] = it.next().charValue();
            i++;
        }
        return cArr;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <S, T extends S> S oIX0o(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S previous = listIterator.previous();
        while (listIterator.hasPrevious()) {
            previous = operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), previous);
        }
        return previous;
    }

    public static final <T> int oIXoXx0(@OXOo.OOXIXo List<? extends T> list, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return list.lastIndexOf(t);
    }

    @XO0OX.xxIXOIIO(name = "sumOfInt")
    public static final int oIoIXxIO(@OXOo.OOXIXo Iterable<Integer> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().intValue();
        }
        return i;
    }

    public static final <T extends Comparable<? super T>> void oIoxI0xx(@OXOo.OOXIXo List<T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        o00.OO0x0xX(list, xX0ox.Oxx0IOOO.o00());
    }

    @OXOo.OOXIXo
    public static <T extends Comparable<? super T>> List<T> oIxOXo(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return oOo0o(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            ooOOo0oXI.XoOOx0IX((Comparable[]) array);
            return ooOOo0oXI.oI0IIXIo(array);
        }
        List<T> IxoOxx = IxoOxx(iterable);
        o00.IoOoo(IxoOxx);
        return IxoOxx;
    }

    @OXOo.OOXIXo
    public static final <T, R, V> List<V> oIxXX0Xo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Iterable<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(iterable, 10), OxxIIOOXO.xo0x(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(transform.invoke(it.next(), it2.next()));
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static byte[] oIxXXOI(@OXOo.OOXIXo Collection<Byte> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr[i] = it.next().byteValue();
            i++;
        }
        return bArr;
    }

    @OXOo.OOXIXo
    public static final <T, R extends Comparable<? super R>> List<T> oIxxIo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return xxx(iterable, new Oxx0IOOO.I0Io(selector));
    }

    public static final <T, R extends Comparable<? super R>> void oO0(@OXOo.OOXIXo List<T> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        if (list.size() > 1) {
            o00.OO0x0xX(list, new Oxx0IOOO.oIX0oI(selector));
        }
    }

    public static final <T, R> R oO0IXx(@OXOo.OOXIXo Iterable<? extends T> iterable, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r = operation.invoke(r, it.next());
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> oO0OX0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo T[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (iterable instanceof Collection) {
            return xOx((Collection) iterable, elements);
        }
        ArrayList arrayList = new ArrayList();
        OxI.XIo0oOXIx(arrayList, iterable);
        OxI.xxIO(arrayList, elements);
        return arrayList;
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final float oOIXoIXXI(@OXOo.OOXIXo Iterable<Float> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (it.hasNext()) {
            float floatValue = it.next().floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, it.next().floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R oOIx(Iterable<? extends T> iterable, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            Object obj = (R) selector.invoke((T) it.next());
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke((T) it.next());
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static <T> List<T> oOo0o(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        Object next;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return o0Xo0XII(collection);
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                return oI0IIXIo.OOXIXo(next);
            }
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return CollectionsKt__CollectionsKt.OI0(IxoOxx(iterable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T, R, V> List<V> oOx0xoXI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo R[] other, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super R, ? extends V> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int length = other.length;
        ArrayList arrayList = new ArrayList(Math.min(OxxIIOOXO.xo0x(iterable, 10), length));
        int i = 0;
        for (T t : iterable) {
            if (i >= length) {
                break;
            }
            arrayList.add(transform.invoke(t, other[i]));
            i++;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T> Iterable<xI<T>> oOxoXxoX(@OXOo.OOXIXo final Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return new oo0xXOI0I(new Oox.oIX0oI<Iterator<? extends T>>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Iterator<T> invoke() {
                return iterable.iterator();
            }
        });
    }

    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    public static final double oOxxXI(@OXOo.OOXIXo Iterable<Double> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        while (it.hasNext()) {
            d += it.next().doubleValue();
        }
        return d;
    }

    @xx0o0O.XO
    public static final <T> T oX000x(List<? extends T> list, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return (T) OIoxIx(list, i);
    }

    @XO0OX.xxIXOIIO(name = "averageOfDouble")
    public static final double oX0I0O(@OXOo.OOXIXo Iterable<Double> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().doubleValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.oxxXoxO();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final <T> int oX0O(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Integer> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += selector.invoke(it.next()).intValue();
        }
        return i;
    }

    @XO0OX.xxIXOIIO(name = "averageOfLong")
    public static final double oX0ooo0I0(@OXOo.OOXIXo Iterable<Long> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().longValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.oxxXoxO();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Double oXIoIo(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Double> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    public static final <T> boolean oXIoO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @xx0o0O.XO
    public static final <T> T oXO0oOx0(List<? extends T> list, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return list.get(i);
    }

    @OXOo.OOXIXo
    public static final <T, K> Map<K, List<T>> oXoXxOo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : iterable) {
            K invoke = keySelector.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(t);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T, R extends Comparable<? super R>> T oXxOXOX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) > 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @OXOo.OOXIXo
    public static <T> List<T> oXxx000(@OXOo.OOXIXo List<? extends T> list, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (i >= 0) {
            return O0o000XOX(list, X0.IIXOooo.OxxIIOOXO(list.size() - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @XO0OX.xxIXOIIO(name = "averageOfShort")
    public static double oo00(@OXOo.OOXIXo Iterable<Short> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().shortValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.oxxXoxO();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @OXOo.OOXIXo
    public static long[] oo00Io(@OXOo.OOXIXo Collection<Long> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator<Long> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T oo0oIXo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final <T, R> R ooO0oXxI(@OXOo.OOXIXo Iterable<? extends T> iterable, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            r = operation.invoke(Integer.valueOf(i), r, t);
            i = i2;
        }
        return r;
    }

    public static final <T> int oox000IX(@OXOo.OOXIXo Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (T t2 : iterable) {
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(t, t2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @kotlin.oxxXoxO(version = "1.3")
    public static <T> T ox0(@OXOo.OOXIXo Collection<? extends T> collection, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (!collection.isEmpty()) {
            return (T) Xo(collection, random.nextInt(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> int ox0I(@OXOo.OOXIXo List<? extends T> list, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return list.indexOf(t);
    }

    public static final <T> T oxIO0IIo(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) O0OOX0IIx((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <S, T extends S> List<S> oxO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.x0xO0oo<? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        S next = it.next();
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        arrayList.add(next);
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
            arrayList.add(next);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final short[] oxOII(@OXOo.OOXIXo Collection<Short> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        short[] sArr = new short[collection.size()];
        Iterator<Short> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            sArr[i] = it.next().shortValue();
            i++;
        }
        return sArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T> T oxOIoIx(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) > 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.3")
    public static final <K, V> Map<K, V> oxOXxoXII(@OXOo.OOXIXo Iterable<? extends K> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super K, ? extends V> valueSelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(OxxIIOOXO.xo0x(iterable, 10)), 16));
        for (K k : iterable) {
            linkedHashMap.put(k, valueSelector.invoke(k));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static <T> List<T> oxXIOXO(@OXOo.OOXIXo List<? extends T> list, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            int size = list.size();
            if (i >= size) {
                return oOo0o(list);
            }
            if (i == 1) {
                return oI0IIXIo.OOXIXo(O0O0Io00X(list));
            }
            ArrayList arrayList = new ArrayList(i);
            if (list instanceof RandomAccess) {
                for (int i2 = size - i; i2 < size; i2++) {
                    arrayList.add(list.get(i2));
                }
            } else {
                ListIterator<? extends T> listIterator = list.listIterator(size - i);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @XO0OX.xxIXOIIO(name = "averageOfFloat")
    public static final double x00IOx(@OXOo.OOXIXo Iterable<Float> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().floatValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.oxxXoxO();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    public static final <T> int x00X0xoXO(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (predicate.invoke(listIterator.previous()).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @XO0OX.xxIXOIIO(name = "sumOfLong")
    public static final long x0Io0(@OXOo.OOXIXo Iterable<Long> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Long> it = iterable.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().longValue();
        }
        return j;
    }

    @OXOo.OOXIXo
    public static boolean[] x0OI(@OXOo.OOXIXo Collection<Boolean> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        boolean[] zArr = new boolean[collection.size()];
        Iterator<Boolean> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr[i] = it.next().booleanValue();
            i++;
        }
        return zArr;
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedSequence")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T, R> List<R> x0OOI(Iterable<? extends T> iterable, Oox.x0xO0oo<? super Integer, ? super T, ? extends kotlin.sequences.ooOOo0oXI<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            OxI.Ioxxx(arrayList, transform.invoke(Integer.valueOf(i), t));
            i = i2;
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapSequenceTo")
    @kotlin.X00IoxXI
    public static final <T, R, C extends Collection<? super R>> C x0oox0(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends kotlin.sequences.ooOOo0oXI<? extends R>> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            OxI.Ioxxx(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T, C extends Collection<? super T>> C x0oxIIIX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (predicate.invoke(Integer.valueOf(i), t).booleanValue()) {
                destination.add(t);
            }
            i = i2;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> x0xOIoO(@OXOo.OOXIXo Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        boolean z = false;
        for (T t2 : iterable) {
            boolean z2 = true;
            if (!z && kotlin.jvm.internal.IIX0o.Oxx0IOOO(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    @xx0o0O.XO
    public static final <T> List<T> xI0OXooO(Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return Ox00XOXoo(iterable, t);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @kotlin.oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> int xI0Ooxx0x(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, xxIO> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(it.next()).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xIIoO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!predicate.invoke(t).booleanValue()) {
                break;
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xIOXX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C xIXIOX(Iterable<?> iterable, C destination) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        for (Object obj : iterable) {
            kotlin.jvm.internal.IIX0o.OxI(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @xx0o0O.XO
    public static final <T> T xIXOoI(List<? extends T> list, int i, Oox.oOoXoXO<? super Integer, ? extends T> defaultValue) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i <= CollectionsKt__CollectionsKt.oo0xXOI0I(list)) {
            return list.get(i);
        }
        return defaultValue.invoke(Integer.valueOf(i));
    }

    @OXOo.OOXIXo
    public static final <T, K> Map<K, T> xIXX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(OxxIIOOXO.xo0x(iterable, 10)), 16));
        for (T t : iterable) {
            linkedHashMap.put(keySelector.invoke(t), t);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R xIXoO0Xx(Iterable<? extends T> iterable, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            Object obj = (R) selector.invoke((T) it.next());
            while (it.hasNext()) {
                Object obj2 = (R) selector.invoke((T) it.next());
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <T> String xIoXXXIXo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super T, ? extends CharSequence> oooxoxo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(separator, "separator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(prefix, "prefix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(postfix, "postfix");
        kotlin.jvm.internal.IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) IoX(iterable, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        kotlin.jvm.internal.IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xIx(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (T t : iterable) {
            if (z) {
                arrayList.add(t);
            } else if (!predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
                z = true;
            }
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static <T> List<T> xIx0XO(@OXOo.OOXIXo Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return oOo0o(iterable);
            }
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i;
                if (size <= 0) {
                    return CollectionsKt__CollectionsKt.ooXIXxIX();
                }
                if (size == 1) {
                    return oI0IIXIo.OOXIXo(X0xOO(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = collection.size();
                        while (i < size2) {
                            arrayList.add(((List) iterable).get(i));
                            i++;
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            int i2 = 0;
            for (T t : iterable) {
                if (i2 >= i) {
                    arrayList.add(t);
                } else {
                    i2++;
                }
            }
            return CollectionsKt__CollectionsKt.OI0(arrayList);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @xx0o0O.XO
    public static final <T> T xIxooxXX(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        T t = null;
        for (T t2 : iterable) {
            if (predicate.invoke(t2).booleanValue()) {
                t = t2;
            }
        }
        return t;
    }

    public static final <S, T extends S> S xOI0(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super T, ? super S, ? extends S> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (listIterator.hasPrevious()) {
            S previous = listIterator.previous();
            while (listIterator.hasPrevious()) {
                previous = operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), previous);
            }
            return previous;
        }
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    @OXOo.OOXIXo
    public static final <T, R extends Comparable<? super R>> List<T> xOIO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        return xxx(iterable, new Oxx0IOOO.oIX0oI(selector));
    }

    @XO0OX.xxIXOIIO(name = "sumOfFloat")
    public static final float xOIx00(@OXOo.OOXIXo Iterable<Float> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            f += it.next().floatValue();
        }
        return f;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xOOxI(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!predicate.invoke(listIterator.previous()).booleanValue()) {
                    return O0o000XOX(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    @OXOo.OOXIXo
    public static final <T, K, V, M extends Map<? super K, ? super V>> M xOOxIO(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (T t : iterable) {
            destination.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return destination;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.2")
    public static final <T, R> List<R> xOXoxI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList();
        I00O.II0xO0 next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            arrayList.add(transform.invoke(next, next2));
            next = next2;
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Float xOoIIIoXI(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, selector.invoke(it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xOx(@OXOo.OOXIXo Collection<? extends T> collection, @OXOo.OOXIXo T[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        ArrayList arrayList = new ArrayList(collection.size() + elements.length);
        arrayList.addAll(collection);
        OxI.xxIO(arrayList, elements);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R xOxOoo(Iterable<? extends T> iterable, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (R) selector.invoke((T) it.next());
        while (it.hasNext()) {
            Object obj2 = (R) selector.invoke((T) it.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (R) obj2;
            }
        }
        return (R) obj;
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @kotlin.oxxXoxO(version = "1.7")
    public static final double xOxxXO(@OXOo.OOXIXo Iterable<Double> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Double> it = iterable.iterator();
        if (it.hasNext()) {
            double doubleValue = it.next().doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, it.next().doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @XO0OX.xxIXOIIO(name = "averageOfInt")
    public static final double xX(@OXOo.OOXIXo Iterable<Integer> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        int i = 0;
        while (it.hasNext()) {
            d += it.next().intValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.oxxXoxO();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / i;
    }

    @OXOo.oOoXoXO
    public static <T> T xX0ox(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T> T xXIX0Xo(@OXOo.OOXIXo Collection<? extends T> collection, @OXOo.OOXIXo Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) Xo(collection, random.nextInt(collection.size()));
    }

    @OXOo.OOXIXo
    public static float[] xXO0oXX(@OXOo.OOXIXo Collection<Float> collection) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator<Float> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = it.next().floatValue();
            i++;
        }
        return fArr;
    }

    @OXOo.OOXIXo
    public static <T> List<T> xXXxoI(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo X0.oOoXoXO indices) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        return oOo0o(list.subList(indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final <T, R> R xXo(@OXOo.OOXIXo List<? extends T> list, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super T, ? super R, ? extends R> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                r = operation.invoke(Integer.valueOf(listIterator.previousIndex()), listIterator.previous(), r);
            }
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @OXOo.oOoXoXO
    public static final <T> T xoIXOxX(@OXOo.OOXIXo List<? extends T> list, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            T previous = listIterator.previous();
            if (predicate.invoke(previous).booleanValue()) {
                return previous;
            }
        }
        return null;
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.5")
    public static final <T, R> R xoX(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends R> transform) {
        R r;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
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
        throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
    }

    @OXOo.OOXIXo
    public static final <T, R> List<R> xooxxX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @xx0o0O.XO
    public static final <T> T xox(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Boolean> predicate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : iterable) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> xoxo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        List oox000IX2 = SequencesKt___SequencesKt.oox000IX(elements);
        if (oox000IX2.isEmpty()) {
            return oOo0o(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!oox000IX2.contains(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @kotlin.X00IoxXI
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Float xx(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, Float> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.oOoXoXO
    public static <T> T xx0(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T> T xx00oOoI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (T) it.next();
        while (it.hasNext()) {
            Object obj2 = (T) it.next();
            if (comparator.compare(obj, obj2) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    @OXOo.oOoXoXO
    public static <T> T xx0O(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C xx0o0O(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        for (T t : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            destination.add(transform.invoke(Integer.valueOf(i), t));
            i = i2;
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "sumOfShort")
    public static final int xxOoXO(@OXOo.OOXIXo Iterable<Short> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Short> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().shortValue();
        }
        return i;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T, R extends Comparable<? super R>> T xxXXXxIxo(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        R invoke = selector.invoke(next);
        do {
            T next2 = it.next();
            R invoke2 = selector.invoke(next2);
            next = next;
            if (invoke.compareTo(invoke2) < 0) {
                invoke = invoke2;
                next = next2;
            }
        } while (it.hasNext());
        return (T) next;
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> xxXooOI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Iterable<? extends T> other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        Set<T> OoOoxX0xo = OoOoxX0xo(iterable);
        OxI.XIo0oOXIx(OoOoxX0xo, other);
        return OoOoxX0xo;
    }

    @XO0OX.xxIXOIIO(name = "sumOfByte")
    public static final int xxoXO(@OXOo.OOXIXo Iterable<Byte> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        Iterator<Byte> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().byteValue();
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static <T> List<T> xxx(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return oOo0o(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            ooOOo0oXI.IOOXOOOOo(array, comparator);
            return ooOOo0oXI.oI0IIXIo(array);
        }
        List<T> IxoOxx = IxoOxx(iterable);
        o00.OO0x0xX(IxoOxx, comparator);
        return IxoOxx;
    }

    @xx0o0O.XO
    public static final <T> T xxx00(List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return list.get(3);
    }

    @OXOo.OOXIXo
    public static final <T, K, V> Map<K, V> xxxI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(keySelector, "keySelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(X0.IIXOooo.OxxIIOOXO(OI0.xoIox(OxxIIOOXO.xo0x(iterable, 10)), 16));
        for (T t : iterable) {
            linkedHashMap.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C xxxoo0XI(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }
}
