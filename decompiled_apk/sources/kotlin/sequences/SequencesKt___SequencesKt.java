package kotlin.sequences;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.IIX0;
import kotlin.Pair;
import kotlin.X00IoxXI;
import kotlin.XI0oooXX;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.collections.Xo0;
import kotlin.collections.XxX0x0xxx;
import kotlin.collections.oX;
import kotlin.collections.xI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.oxxXoxO;
import kotlin.xxIO;
import xX0ox.Oxx0IOOO;

@XX({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,3112:1\n179#1,2:3113\n316#1,7:3115\n1324#1,3:3123\n739#1,4:3126\n704#1,4:3130\n722#1,4:3134\n775#1,4:3138\n1017#1,3:3142\n1020#1,3:3152\n1037#1,3:3155\n1040#1,3:3165\n1324#1,3:3182\n1313#1,2:3185\n1#2:3122\n372#3,7:3145\n372#3,7:3158\n372#3,7:3168\n372#3,7:3175\n*S KotlinDebug\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n87#1:3113,2\n99#1:3115,7\n458#1:3123,3\n658#1:3126,4\n674#1:3130,4\n689#1:3134,4\n760#1:3138,4\n988#1:3142,3\n988#1:3152,3\n1003#1:3155,3\n1003#1:3165,3\n1106#1:3182,3\n1144#1:3185,2\n988#1:3145,7\n1003#1:3158,7\n1019#1:3168,7\n1039#1:3175,7\n*E\n"})
/* loaded from: classes6.dex */
public class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public static final class I0Io<T> implements ooOOo0oXI<T> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ ooOOo0oXI<T> f29445oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public I0Io(ooOOo0oXI<? extends T> ooooo0oxi) {
            this.f29445oIX0oI = ooooo0oxi;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<T> iterator() {
            List ox0I2 = SequencesKt___SequencesKt.ox0I(this.f29445oIX0oI);
            kotlin.collections.o00.IoOoo(ox0I2);
            return ox0I2.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    @XX({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt$groupingBy$1\n*L\n1#1,3112:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0<K, T> implements XxX0x0xxx<T, K> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<T, K> f29446II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ ooOOo0oXI<T> f29447oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public II0xO0(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends K> oooxoxo) {
            this.f29447oIX0oI = ooooo0oxi;
            this.f29446II0xO0 = oooxoxo;
        }

        @Override // kotlin.collections.XxX0x0xxx
        @OXOo.OOXIXo
        public Iterator<T> II0xO0() {
            return this.f29447oIX0oI.iterator();
        }

        @Override // kotlin.collections.XxX0x0xxx
        public K oIX0oI(T t) {
            return this.f29446II0xO0.invoke(t);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,70:1\n2921#2:71\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements Iterable<T>, OI0IXox.oIX0oI {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ ooOOo0oXI f29456XO;

        public oIX0oI(ooOOo0oXI ooooo0oxi) {
            this.f29456XO = ooooo0oxi;
        }

        @Override // java.lang.Iterable
        @OXOo.OOXIXo
        public Iterator<T> iterator() {
            return this.f29456XO.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public static final class oxoX<T> implements ooOOo0oXI<T> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super T> f29457II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ ooOOo0oXI<T> f29458oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public oxoX(ooOOo0oXI<? extends T> ooooo0oxi, Comparator<? super T> comparator) {
            this.f29458oIX0oI = ooooo0oxi;
            this.f29457II0xO0 = comparator;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<T> iterator() {
            List ox0I2 = SequencesKt___SequencesKt.ox0I(this.f29458oIX0oI);
            kotlin.collections.o00.OO0x0xX(ox0I2, this.f29457II0xO0);
            return ox0I2.iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @xx0o0O.XO
    public static final <T> T I0(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        T t = null;
        for (T t2 : ooooo0oxi) {
            if (predicate.invoke(t2).booleanValue()) {
                t = t2;
            }
        }
        return t;
    }

    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    public static final double I00O(@OXOo.OOXIXo ooOOo0oXI<Double> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Double> it = ooooo0oxi.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        while (it.hasNext()) {
            d += it.next().doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <T, R> ooOOo0oXI<R> I0X0x0oIo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, int i, @OXOo.OOXIXo Oox.oOoXoXO<? super List<? extends T>, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return x00X0xoXO(ooooo0oxi, i, i, true, transform);
    }

    @OXOo.OOXIXo
    public static final <T, K> ooOOo0oXI<T> I0oOIX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        return new kotlin.sequences.I0Io(ooooo0oxi, selector);
    }

    @XO0OX.xxIXOIIO(name = "averageOfByte")
    public static final double I0oOoX(@OXOo.OOXIXo ooOOo0oXI<Byte> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Byte> it = ooooo0oxi.iterator();
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

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @XO0OX.xxIXOIIO(name = "maxByOrThrow")
    @oxxXoxO(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T I0xX0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    public static final <T> boolean IIOIX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedSequence")
    @X00IoxXI
    public static final <T, R> ooOOo0oXI<R> IIX0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends ooOOo0oXI<? extends R>> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return SequencesKt__SequencesKt.II0XooXoX(ooooo0oxi, transform, SequencesKt___SequencesKt$flatMapIndexed$2.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @xx0o0O.XO
    public static final <T> T IIxOXoOo0(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : ooooo0oxi) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <T, K, V> Map<K, V> IO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <T, R> ooOOo0oXI<R> IO0XoXxO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return new xoXoI(ooooo0oxi, transform);
    }

    public static final <S, T extends S> S IOOoXo0Ix(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super S, ? super T, ? extends S> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    @OXOo.OOXIXo
    public static <T, R> ooOOo0oXI<R> IOoo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return O00XxXI(new o00(ooooo0oxi, transform));
    }

    public static final <T> int IXO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int i = -1;
        int i2 = 0;
        for (T t : ooooo0oxi) {
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
    @oxxXoxO(version = "1.2")
    public static final <T> ooOOo0oXI<List<T>> IXX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, int i, int i2, boolean z) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return SlidingWindowKt.I0Io(ooooo0oxi, i, i2, z, false);
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final <T> int IXoIo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Integer> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += selector.invoke(it.next()).intValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final <T, K, V, M extends Map<? super K, ? super V>> M Io(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(it.next());
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static final <T, R> R IoIOOxIIo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super T, ? extends R> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        int i = 0;
        for (T t : ooooo0oxi) {
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

    public static final <T> boolean IoOoX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return ooooo0oxi.iterator().hasNext();
    }

    public static final <T> T IoOoo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, final int i) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return (T) xoIxX(ooooo0oxi, i, new Oox.oOoXoXO<Integer, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$elementAt$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final T invoke(int i2) {
                throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + i + '.');
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }
        });
    }

    public static /* synthetic */ ooOOo0oXI IoX(ooOOo0oXI ooooo0oxi, int i, int i2, boolean z, Oox.oOoXoXO oooxoxo, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return x00X0xoXO(ooooo0oxi, i, i2, z, oooxoxo);
    }

    public static /* synthetic */ String IoXIXo(ooOOo0oXI ooooo0oxi, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
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
        return O0IxXx(ooooo0oxi, charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final <T, C extends Collection<? super T>> C Ioxxx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (T t : ooooo0oxi) {
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
    public static final <T> ooOOo0oXI<T> Ix0(@OXOo.OOXIXo final ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return X0xxXX0(ooooo0oxi, new Oox.oOoXoXO<T, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$requireNoNulls$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final T invoke(@OXOo.oOoXoXO T t) {
                if (t != null) {
                    return t;
                }
                throw new IllegalArgumentException("null element found in " + ooooo0oxi + '.');
            }
        });
    }

    public static /* synthetic */ Appendable Ix00oIoI(ooOOo0oXI ooooo0oxi, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
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
        return oI(ooooo0oxi, appendable, charSequence5, charSequence6, charSequence8, i3, charSequence7, oooxoxo2);
    }

    @OXOo.OOXIXo
    public static <T> ooOOo0oXI<T> Ix0x(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        return new IIXOooo(ooooo0oxi, predicate);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfLong")
    @X00IoxXI
    @xx0o0O.XO
    public static final <T> long IxI(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Long> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += selector.invoke(it.next()).longValue();
        }
        return j;
    }

    public static final <T> int IxIX0I(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, T t) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        int i = 0;
        for (T t2 : ooooo0oxi) {
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            if (IIX0o.Oxx0IOOO(t, t2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> IxIo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, T t) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return SequencesKt__SequencesKt.xxIXOIIO(SequencesKt__SequencesKt.Oo(ooooo0oxi, SequencesKt__SequencesKt.Oo(t)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T> T IxX00(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIterableTo")
    @X00IoxXI
    public static final <T, R, C extends Collection<? super R>> C O0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            kotlin.collections.OxI.XIo0oOXIx(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float O00(@OXOo.OOXIXo ooOOo0oXI<Float> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Float> it = ooooo0oxi.iterator();
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
    public static <T> ooOOo0oXI<T> O00XxXI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        ooOOo0oXI<T> o0xxxXXxX2 = o0xxxXXxX(ooooo0oxi, new Oox.oOoXoXO<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterNotNull$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.oOoXoXO T t) {
                return Boolean.valueOf(t == null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((SequencesKt___SequencesKt$filterNotNull$1<T>) obj);
            }
        });
        IIX0o.x0XOIxOo(o0xxxXXxX2, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return o0xxxXXxX2;
    }

    @OXOo.OOXIXo
    public static final <T> String O0IxXx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super T, ? extends CharSequence> oooxoxo) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        IIX0o.x0xO0oo(truncated, "truncated");
        String sb = ((StringBuilder) oI(ooooo0oxi, new StringBuilder(), separator, prefix, postfix, i, truncated, oooxoxo)).toString();
        IIX0o.oO(sb, "toString(...)");
        return sb;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> ooOOo0oXI<R> O0OOX0IIx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super T, ? extends R> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        return xIxooxXX(ooooo0oxi, r, operation);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterableTo")
    @X00IoxXI
    @xx0o0O.XO
    public static final <T, R, C extends Collection<? super R>> C O0X(ooOOo0oXI<? extends T> ooooo0oxi, C destination, Oox.x0xO0oo<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        for (T t : ooooo0oxi) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            kotlin.collections.OxI.XIo0oOXIx(destination, transform.invoke(Integer.valueOf(i), t));
            i = i2;
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> O0Xx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return I0oOIX(ooooo0oxi, new Oox.oOoXoXO<T, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$distinct$1
            @Override // Oox.oOoXoXO
            public final T invoke(T t) {
                return t;
            }
        });
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> O0o0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    @OXOo.OOXIXo
    public static final <T, R extends Comparable<? super R>> ooOOo0oXI<T> O0x(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        return x0OOI(ooooo0oxi, new Oxx0IOOO.oIX0oI(selector));
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @oxxXoxO(version = "1.7")
    public static final float O0xxXxI(@OXOo.OOXIXo ooOOo0oXI<Float> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Float> it = ooooo0oxi.iterator();
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
    public static final <T, K, V, M extends Map<? super K, ? super V>> M OI0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (T t : ooooo0oxi) {
            destination.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T, K, M extends Map<? super K, List<T>>> M OIOoIIOIx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        for (T t : ooooo0oxi) {
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

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfUInt")
    @X00IoxXI
    @xx0o0O.XO
    public static final <T> int OIoxIx(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, xxIO> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        int oOoXoXO2 = xxIO.oOoXoXO(0);
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            oOoXoXO2 = xxIO.oOoXoXO(oOoXoXO2 + selector.invoke(it.next()).OO());
        }
        return oOoXoXO2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R OIx00oxx(ooOOo0oXI<? extends T> ooooo0oxi, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @OXOo.OOXIXo
    public static final <T> Set<T> OIxI0O(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return Xo0.OOXIXo();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return oX.XO(next);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> ooOOo0oXI<T> OIxOX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return x0OOI(ooooo0oxi, xX0ox.Oxx0IOOO.o00());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T OIxx0I0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : ooooo0oxi) {
            if (predicate.invoke(t2).booleanValue()) {
                if (!z) {
                    z = true;
                    t = t2;
                } else {
                    throw new IllegalArgumentException("Sequence contains more than one matching element.");
                }
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> OO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        return new XO(ooooo0oxi, predicate);
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Float OO0(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Float> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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
    public static <T> ooOOo0oXI<T> OO0x0xX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        return new II0XooXoX(ooooo0oxi, true, predicate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @XO0OX.xxIXOIIO(name = "minWithOrThrow")
    @oxxXoxO(version = "1.7")
    public static final <T> T OOIXx0x(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Double OOOI(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Double> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    public static final <T, C extends Collection<? super T>> C OOXIxO0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : ooooo0oxi) {
            if (predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @oxxXoxO(version = "1.7")
    public static final double OOxOI(@OXOo.OOXIXo ooOOo0oXI<Double> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Double> it = ooooo0oxi.iterator();
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
    public static final <T, C extends Collection<? super T>> C OOxOOxIO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> float OX(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Float> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (it.hasNext()) {
            float floatValue = selector.invoke(it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, selector.invoke(it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final <T, R> R OX00O0xII(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends R> transform) {
        R r;
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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
        throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
    }

    @kotlin.OOXIXo(message = "Use sumOf instead.", replaceWith = @kotlin.XX(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.oOoXoXO(warningSince = "1.5")
    public static final <T> double OXIOoo0X0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Double> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        while (it.hasNext()) {
            d += selector.invoke(it.next()).doubleValue();
        }
        return d;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @oxxXoxO(version = "1.7")
    public static final <T extends Comparable<? super T>> T OXXoIoXI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> OXooXo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, int i) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return SequencesKt__SequencesKt.Oxx0IOOO();
            }
            if (ooooo0oxi instanceof X0o0xo) {
                return ((X0o0xo) ooooo0oxi).oIX0oI(i);
            }
            return new OxxIIOOXO(ooooo0oxi, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.OOXIXo
    public static final <T, R, V> ooOOo0oXI<V> OoIXo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo ooOOo0oXI<? extends R> other, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super R, ? extends V> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(other, "other");
        IIX0o.x0xO0oo(transform, "transform");
        return new oOoXoXO(ooooo0oxi, other, transform);
    }

    @OXOo.OOXIXo
    public static final <T, K, V> Map<K, List<V>> OoO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : ooooo0oxi) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R OooI(ooOOo0oXI<? extends T> ooooo0oxi, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    @OXOo.oOoXoXO
    public static final <T> T OooO0XOx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        boolean z = false;
        T t = null;
        for (T t2 : ooooo0oxi) {
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

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIterable")
    @X00IoxXI
    public static final <T, R> ooOOo0oXI<R> Ox0O(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return new xxIXOIIO(ooooo0oxi, transform, SequencesKt___SequencesKt$flatMap$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R OxO(ooOOo0oXI<? extends T> ooooo0oxi, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R OxXXx0X(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <S, T extends S> S Oxo00O(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.x0xO0oo<? super S, ? super T, ? extends S> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S next = it.next();
        while (it.hasNext()) {
            next = operation.invoke(next, it.next());
        }
        return next;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> double Oxx(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Double> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (it.hasNext()) {
            double doubleValue = selector.invoke(it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, selector.invoke(it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    public static final <T> ooOOo0oXI<T> X00IoxXI(ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return ooooo0oxi;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Float X00xOoXI(@OXOo.OOXIXo ooOOo0oXI<Float> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Float> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <S, T extends S> S X0IOOI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super S, ? super T, ? extends S> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    /* JADX WARN: Multi-variable type inference failed */
    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> R X0O0I0(ooOOo0oXI<? extends T> ooooo0oxi, Comparator<? super R> comparator, Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> ooOOo0oXI<T> X0ooXIooI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo final Oox.x0xO0oo<? super Integer, ? super T, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(action, "action");
        return IO0XoXxO(ooooo0oxi, new Oox.x0xO0oo<Integer, T, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$onEachIndexed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Object invoke(Integer num, Object obj) {
                return invoke(num.intValue(), (int) obj);
            }

            public final T invoke(int i, T t) {
                action.invoke(Integer.valueOf(i), t);
                return t;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @OXOo.oOoXoXO
    public static final <T> T X0xII0I(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        T t = null;
        for (T t2 : ooooo0oxi) {
            if (predicate.invoke(t2).booleanValue()) {
                t = t2;
            }
        }
        return t;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <T> ooOOo0oXI<Pair<T, T>> X0xOO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return XxIIOXIXx(ooooo0oxi, new Oox.x0xO0oo<T, T, Pair<? extends T, ? extends T>>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$1
            @Override // Oox.x0xO0oo
            @OXOo.OOXIXo
            public final Pair<T, T> invoke(T t, T t2) {
                return kotlin.Xo0.oIX0oI(t, t2);
            }
        });
    }

    @OXOo.OOXIXo
    public static <T, R> ooOOo0oXI<R> X0xxXX0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return new o00(ooooo0oxi, transform);
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C XI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        for (T t : ooooo0oxi) {
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

    @OXOo.OOXIXo
    public static final <T, C extends Collection<? super T>> C XI0oooXX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : ooooo0oxi) {
            if (!predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T> HashSet<T> XIOOI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return (HashSet) OOxOOxIO(ooooo0oxi, new HashSet());
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @OXOo.oOoXoXO
    public static final <T> T XIXIX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : ooooo0oxi) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final <T, K> Map<K, List<T>> XIXIxO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : ooooo0oxi) {
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

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> XIo0oOXIx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo final Oox.x0xO0oo<? super Integer, ? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        return new o00(new II0XooXoX(new OOXIXo(ooooo0oxi), true, new Oox.oOoXoXO<xI<? extends T>, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterIndexed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.OOXIXo xI<? extends T> it) {
                IIX0o.x0xO0oo(it, "it");
                return predicate.invoke(Integer.valueOf(it.X0o0xo()), it.XO());
            }
        }), new Oox.oOoXoXO<xI<? extends T>, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterIndexed$2
            @Override // Oox.oOoXoXO
            public final T invoke(@OXOo.OOXIXo xI<? extends T> it) {
                IIX0o.x0xO0oo(it, "it");
                return it.XO();
            }
        });
    }

    @XO0OX.xxIXOIIO(name = "minOrThrow")
    @oxxXoxO(version = "1.7")
    public static final float XO00XOO(@OXOo.OOXIXo ooOOo0oXI<Float> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Float> it = ooooo0oxi.iterator();
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
    @XO0OX.xxIXOIIO(name = "maxWithOrThrow")
    @oxxXoxO(version = "1.7")
    public static final <T> T XO0o(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    public static /* synthetic */ ooOOo0oXI XOo0(ooOOo0oXI ooooo0oxi, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return IXX(ooooo0oxi, i, i2, z);
    }

    @OXOo.OOXIXo
    public static final <T, K, M extends Map<? super K, ? super T>> M XOxIOxOx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        for (T t : ooooo0oxi) {
            destination.put(keySelector.invoke(t), t);
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> XOxoX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo T[] elements) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(elements, "elements");
        return xIOXX(ooooo0oxi, kotlin.collections.ooOOo0oXI.oI0IIXIo(elements));
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C XOxxooXI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        for (T t : ooooo0oxi) {
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

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.3")
    public static final <K, V, M extends Map<? super K, ? super V>> M XX(@OXOo.OOXIXo ooOOo0oXI<? extends K> ooooo0oxi, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super K, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        for (K k : ooooo0oxi) {
            destination.put(k, valueSelector.invoke(k));
        }
        return destination;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <T> ooOOo0oXI<List<T>> XX0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, int i) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return IXX(ooooo0oxi, i, i, true);
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C XX0xXo(ooOOo0oXI<?> ooooo0oxi, C destination) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        for (Object obj : ooooo0oxi) {
            IIX0o.OxI(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T, R extends Comparable<? super R>> T XXXI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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
    @oxxXoxO(version = "1.1")
    public static final <T, K> XxX0x0xxx<T, K> XXoOx0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        return new II0xO0(ooooo0oxi, keySelector);
    }

    @xx0o0O.XO
    public static final <T> ooOOo0oXI<T> Xo(ooOOo0oXI<? extends T> ooooo0oxi, T t) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return oXxx000(ooooo0oxi, t);
    }

    public static <T> int Xo0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    public static final <T> int XoI0Ixx0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Double XoIxOXIXo(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Double> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = selector.invoke(it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, selector.invoke(it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.1")
    public static final <T> ooOOo0oXI<T> XoOxI0ox(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo final Oox.oOoXoXO<? super T, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(action, "action");
        return X0xxXX0(ooooo0oxi, new Oox.oOoXoXO<T, T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$onEach$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public final T invoke(T t) {
                action.invoke(t);
                return t;
            }
        });
    }

    @XO0OX.xxIXOIIO(name = "averageOfFloat")
    public static final double XoX(@OXOo.OOXIXo ooOOo0oXI<Float> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Float> it = ooooo0oxi.iterator();
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

    /* JADX WARN: Multi-variable type inference failed */
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T> T XooIO0oo0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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
    public static <T> Iterable<T> Xx000oIo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return new oIX0oI(ooooo0oxi);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <T, R> ooOOo0oXI<R> XxIIOXIXx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.x0xO0oo<? super T, ? super T, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return IXxxXO.II0xO0(new SequencesKt___SequencesKt$zipWithNext$2(ooooo0oxi, transform, null));
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <S, T extends S> ooOOo0oXI<S> XxIo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.x0xO0oo<? super S, ? super T, ? extends S> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        return IXxxXO.II0xO0(new SequencesKt___SequencesKt$runningReduce$1(ooooo0oxi, operation, null));
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> ooOOo0oXI<T> XxXX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return new I0Io(ooooo0oxi);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.3")
    public static final <K, V> Map<K, V> o0(@OXOo.OOXIXo ooOOo0oXI<? extends K> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super K, ? extends V> valueSelector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (K k : ooooo0oxi) {
            linkedHashMap.put(k, valueSelector.invoke(k));
        }
        return linkedHashMap;
    }

    @XO0OX.xxIXOIIO(name = "sumOfLong")
    public static final long o00xOoIO(@OXOo.OOXIXo ooOOo0oXI<Long> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Long> it = ooooo0oxi.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().longValue();
        }
        return j;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R o0IXXIx(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @XO0OX.xxIXOIIO(name = "sumOfInt")
    public static final int o0OO0(@OXOo.OOXIXo ooOOo0oXI<Integer> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Integer> it = ooooo0oxi.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().intValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final <T, R extends Comparable<? super R>> ooOOo0oXI<T> o0Oo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        return x0OOI(ooooo0oxi, new Oxx0IOOO.I0Io(selector));
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double o0Xo(@OXOo.OOXIXo ooOOo0oXI<Double> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Double> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    public static final <T> void o0oIxOo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(action, "action");
        int i = 0;
        for (T t : ooooo0oxi) {
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

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> Float o0oxo0oI(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Float> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = selector.invoke(it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, selector.invoke(it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> o0xxxXXxX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        return new II0XooXoX(ooooo0oxi, false, predicate);
    }

    @OXOo.OOXIXo
    public static final <T, A extends Appendable> A oI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo A buffer, @OXOo.OOXIXo CharSequence separator, @OXOo.OOXIXo CharSequence prefix, @OXOo.OOXIXo CharSequence postfix, int i, @OXOo.OOXIXo CharSequence truncated, @OXOo.oOoXoXO Oox.oOoXoXO<? super T, ? extends CharSequence> oooxoxo) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(buffer, "buffer");
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        IIX0o.x0xO0oo(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (T t : ooooo0oxi) {
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

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<xI<T>> oI0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return new OOXIXo(ooooo0oxi);
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C oIIxXoo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfDouble")
    @X00IoxXI
    @xx0o0O.XO
    public static final <T> double oO0IXx(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Double> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        double d = XIXIX.OOXIXo.f3760XO;
        while (it.hasNext()) {
            d += selector.invoke(it.next()).doubleValue();
        }
        return d;
    }

    public static final <T> boolean oOXoIIIo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedIterable")
    @X00IoxXI
    public static final <T, R> ooOOo0oXI<R> oOo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return SequencesKt__SequencesKt.II0XooXoX(ooooo0oxi, transform, SequencesKt___SequencesKt$flatMapIndexed$1.INSTANCE);
    }

    public static final <T> int oOoIIO0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        int i = 0;
        for (T t : ooooo0oxi) {
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

    public static <T> boolean oX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, T t) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        if (IxIX0I(ooooo0oxi, t) >= 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final <T> Pair<List<T>, List<T>> oX000x(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : ooooo0oxi) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T, R extends Comparable<? super R>> T oX0I0O(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> float oX0ooo0I0(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Float> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (it.hasNext()) {
            float floatValue = selector.invoke(it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, selector.invoke(it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    @OXOo.OOXIXo
    public static final <T, R> ooOOo0oXI<R> oXIO0o0XI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends ooOOo0oXI<? extends R>> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return new xxIXOIIO(ooooo0oxi, transform, SequencesKt___SequencesKt$flatMap$2.INSTANCE);
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R oXIoO(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    public static final <T> boolean oXO0oOx0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return !ooooo0oxi.iterator().hasNext();
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C oXX0IoI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @XO0OX.xxIXOIIO(name = "sumOfULong")
    @X00IoxXI
    @xx0o0O.XO
    public static final <T> long oXoXxOo(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, XI0oooXX> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        long oOoXoXO2 = XI0oooXX.oOoXoXO(0L);
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            oOoXoXO2 = XI0oooXX.oOoXoXO(oOoXoXO2 + selector.invoke(it.next()).OO());
        }
        return oOoXoXO2;
    }

    @OXOo.OOXIXo
    public static <T, R> ooOOo0oXI<R> oXxOI0oIx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return O00XxXI(new xoXoI(ooooo0oxi, transform));
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> oXxx000(@OXOo.OOXIXo final ooOOo0oXI<? extends T> ooooo0oxi, final T t) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return new ooOOo0oXI<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$1
            @Override // kotlin.sequences.ooOOo0oXI
            @OXOo.OOXIXo
            public Iterator<T> iterator() {
                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                ooOOo0oXI<T> ooooo0oxi2 = ooooo0oxi;
                final T t2 = t;
                return SequencesKt___SequencesKt.OO0x0xX(ooooo0oxi2, new Oox.oOoXoXO<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$1$iterator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oOoXoXO
                    @OXOo.OOXIXo
                    public final Boolean invoke(T t3) {
                        boolean z = true;
                        if (!Ref.BooleanRef.this.element && IIX0o.Oxx0IOOO(t3, t2)) {
                            Ref.BooleanRef.this.element = true;
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                        return invoke((SequencesKt___SequencesKt$minus$1$iterator$1<T>) obj);
                    }
                }).iterator();
            }
        };
    }

    public static final <T> boolean oo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R extends Comparable<? super R>> R oo00(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> ooOOo0oXI<R> oo0oIXo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        return xox(ooooo0oxi, r, operation);
    }

    @XO0OX.xxIXOIIO(name = "sumOfFloat")
    public static final float ooO0oXxI(@OXOo.OOXIXo ooOOo0oXI<Float> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Float> it = ooooo0oxi.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            f += it.next().floatValue();
        }
        return f;
    }

    public static final <T> T ooOx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @OXOo.OOXIXo
    public static <T> List<T> oox000IX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        T next = it.next();
        if (!it.hasNext()) {
            return kotlin.collections.oI0IIXIo.OOXIXo(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super T>, T> C ox(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        for (T t : ooooo0oxi) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <T> List<T> ox0I(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return (List) OOxOOxIO(ooooo0oxi, new ArrayList());
    }

    public static final <T> void oxIIX0o(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> action) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(action, "action");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <S, T extends S> ooOOo0oXI<S> oxIO0IIo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super S, ? super T, ? extends S> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        return IXxxXO.II0xO0(new SequencesKt___SequencesKt$runningReduceIndexed$1(ooooo0oxi, operation, null));
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @oxxXoxO(version = "1.7")
    public static final <T extends Comparable<? super T>> T oxOXxoXII(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @XO0OX.xxIXOIIO(name = "averageOfInt")
    public static final double oxXx0IX(@OXOo.OOXIXo ooOOo0oXI<Integer> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Integer> it = ooooo0oxi.iterator();
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

    @XO0OX.xxIXOIIO(name = "averageOfDouble")
    public static final double oxxXoxO(@OXOo.OOXIXo ooOOo0oXI<Double> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Double> it = ooooo0oxi.iterator();
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

    @OXOo.oOoXoXO
    public static final <T> T x0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @XO0OX.xxIXOIIO(name = "minByOrThrow")
    @oxxXoxO(version = "1.7")
    public static final <T, R extends Comparable<? super R>> T x00IOx(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <T, R> ooOOo0oXI<R> x00X0xoXO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, int i, int i2, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super List<? extends T>, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        return X0xxXX0(SlidingWindowKt.I0Io(ooooo0oxi, i, i2, z, true), transform);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T, K, V, M extends Map<? super K, List<V>>> M x0OIX00oO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        for (T t : ooooo0oxi) {
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

    @OXOo.OOXIXo
    public static <T> ooOOo0oXI<T> x0OOI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        return new oxoX(ooooo0oxi, comparator);
    }

    public static final <T> int x0OxxIOxX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, T t) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        int i = -1;
        int i2 = 0;
        for (T t2 : ooooo0oxi) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            if (IIX0o.Oxx0IOOO(t, t2)) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final <T, K, V> Map<K, V> x0o(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends V> valueTransform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        IIX0o.x0xO0oo(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : ooooo0oxi) {
            linkedHashMap.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    @XO0OX.xxIXOIIO(name = "sumOfByte")
    public static final int x0oox0(@OXOo.OOXIXo ooOOo0oXI<Byte> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Byte> it = ooooo0oxi.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().byteValue();
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> x0oxIIIX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo ooOOo0oXI<? extends T> elements) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(elements, "elements");
        return SequencesKt__SequencesKt.xxIXOIIO(SequencesKt__SequencesKt.Oo(ooooo0oxi, elements));
    }

    @OXOo.oOoXoXO
    public static final <T> T x0xO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, int i) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        for (T t : ooooo0oxi) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return null;
    }

    public static final <T, R> R xI0oxI00(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            r = operation.invoke(r, it.next());
        }
        return r;
    }

    @OXOo.OOXIXo
    public static final <T, K> Map<K, T> xII(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends K> keySelector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : ooooo0oxi) {
            linkedHashMap.put(keySelector.invoke(t), t);
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> xIOXX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Iterable<? extends T> elements) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(elements, "elements");
        return SequencesKt__SequencesKt.xxIXOIIO(SequencesKt__SequencesKt.Oo(ooooo0oxi, CollectionsKt___CollectionsKt.OooI(elements)));
    }

    @xx0o0O.XO
    public static final <T> ooOOo0oXI<T> xIXIOX(ooOOo0oXI<? extends T> ooooo0oxi, T t) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return IxIo(ooooo0oxi, t);
    }

    @XO0OX.xxIXOIIO(name = "sumOfShort")
    public static final int xIXOoI(@OXOo.OOXIXo ooOOo0oXI<Short> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Short> it = ooooo0oxi.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().shortValue();
        }
        return i;
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T extends Comparable<? super T>> T xIXX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @OXOo.OOXIXo
    public static final <T, R> ooOOo0oXI<Pair<T, R>> xIoXXXIXo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo ooOOo0oXI<? extends R> other) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(other, "other");
        return new oOoXoXO(ooooo0oxi, other, new Oox.x0xO0oo<T, R, Pair<? extends T, ? extends R>>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$zip$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((SequencesKt___SequencesKt$zip$1<R, T>) obj, obj2);
            }

            @Override // Oox.x0xO0oo
            @OXOo.OOXIXo
            public final Pair<T, R> invoke(T t, R r) {
                return kotlin.Xo0.oIX0oI(t, r);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> xIx(@OXOo.OOXIXo final ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo final T[] elements) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(elements, "elements");
        if (elements.length == 0) {
            return ooooo0oxi;
        }
        return new ooOOo0oXI<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$2
            @Override // kotlin.sequences.ooOOo0oXI
            @OXOo.OOXIXo
            public Iterator<T> iterator() {
                ooOOo0oXI<T> ooooo0oxi2 = ooooo0oxi;
                final T[] tArr = elements;
                return SequencesKt___SequencesKt.o0xxxXXxX(ooooo0oxi2, new Oox.oOoXoXO<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$2$iterator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oOoXoXO
                    @OXOo.OOXIXo
                    public final Boolean invoke(T t) {
                        return Boolean.valueOf(ArraysKt___ArraysKt.OXO0oX(tArr, t));
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                        return invoke((SequencesKt___SequencesKt$minus$2$iterator$1<T>) obj);
                    }
                }).iterator();
            }
        };
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> xIx0XO(@OXOo.OOXIXo final ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo final Iterable<? extends T> elements) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(elements, "elements");
        return new ooOOo0oXI<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$3
            @Override // kotlin.sequences.ooOOo0oXI
            @OXOo.OOXIXo
            public Iterator<T> iterator() {
                final Collection XX0xXo2 = kotlin.collections.OxI.XX0xXo(elements);
                if (XX0xXo2.isEmpty()) {
                    return ooooo0oxi.iterator();
                }
                return SequencesKt___SequencesKt.o0xxxXXxX(ooooo0oxi, new Oox.oOoXoXO<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$3$iterator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oOoXoXO
                    @OXOo.OOXIXo
                    public final Boolean invoke(T t) {
                        return Boolean.valueOf(XX0xXo2.contains(t));
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                        return invoke((SequencesKt___SequencesKt$minus$3$iterator$1<T>) obj);
                    }
                }).iterator();
            }
        };
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> ooOOo0oXI<R> xIxooxXX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, R r, @OXOo.OOXIXo Oox.IXxxXO<? super Integer, ? super R, ? super T, ? extends R> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        return IXxxXO.II0xO0(new SequencesKt___SequencesKt$runningFoldIndexed$1(r, ooooo0oxi, operation, null));
    }

    @OXOo.oOoXoXO
    public static <T> T xOOOX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> xOOxI(@OXOo.OOXIXo final ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo final ooOOo0oXI<? extends T> elements) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(elements, "elements");
        return new ooOOo0oXI<T>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$4
            @Override // kotlin.sequences.ooOOo0oXI
            @OXOo.OOXIXo
            public Iterator<T> iterator() {
                final List oox000IX2 = SequencesKt___SequencesKt.oox000IX(elements);
                if (oox000IX2.isEmpty()) {
                    return ooooo0oxi.iterator();
                }
                return SequencesKt___SequencesKt.o0xxxXXxX(ooooo0oxi, new Oox.oOoXoXO<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$minus$4$iterator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // Oox.oOoXoXO
                    @OXOo.OOXIXo
                    public final Boolean invoke(T t) {
                        return Boolean.valueOf(oox000IX2.contains(t));
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                        return invoke((SequencesKt___SequencesKt$minus$4$iterator$1<T>) obj);
                    }
                }).iterator();
            }
        };
    }

    @XO0OX.xxIXOIIO(name = "maxOrThrow")
    @oxxXoxO(version = "1.7")
    public static final double xOOxIO(@OXOo.OOXIXo ooOOo0oXI<Double> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Double> it = ooooo0oxi.iterator();
        if (it.hasNext()) {
            double doubleValue = it.next().doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, it.next().doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "flatMapIndexedSequenceTo")
    @X00IoxXI
    @xx0o0O.XO
    public static final <T, R, C extends Collection<? super R>> C xOoOIoI(ooOOo0oXI<? extends T> ooooo0oxi, C destination, Oox.x0xO0oo<? super Integer, ? super T, ? extends ooOOo0oXI<? extends R>> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        int i = 0;
        for (T t : ooooo0oxi) {
            int i2 = i + 1;
            if (i < 0) {
                if (xx0o0O.ooOOo0oXI.oIX0oI(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.XoX();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            kotlin.collections.OxI.Ioxxx(destination, transform.invoke(Integer.valueOf(i), t));
            i = i2;
        }
        return destination;
    }

    @X00IoxXI
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> double xX(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Double> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (it.hasNext()) {
            double doubleValue = selector.invoke(it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, selector.invoke(it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final <T, R> R xX0IIXIx0(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends R> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    @XO0OX.xxIXOIIO(name = "averageOfShort")
    public static final double xXOx(@OXOo.OOXIXo ooOOo0oXI<Short> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Short> it = ooooo0oxi.iterator();
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

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfInt")
    @X00IoxXI
    @xx0o0O.XO
    public static final <T> int xXo(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, Integer> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += selector.invoke(it.next()).intValue();
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    public static final <T> T xXoOI00O(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : ooooo0oxi) {
            if (predicate.invoke(t2).booleanValue()) {
                z = true;
                t = t2;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <S, T extends S> S xo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.x0xO0oo<? super S, ? super T, ? extends S> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (it.hasNext()) {
            S next = it.next();
            while (it.hasNext()) {
                next = operation.invoke(next, it.next());
            }
            return next;
        }
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    @XO0OX.xxIXOIIO(name = "averageOfLong")
    public static final double xo0x(@OXOo.OOXIXo ooOOo0oXI<Long> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Long> it = ooooo0oxi.iterator();
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

    public static final <T> T xoIxX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, int i, @OXOo.OOXIXo Oox.oOoXoXO<? super Integer, ? extends T> defaultValue) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i < 0) {
            return defaultValue.invoke(Integer.valueOf(i));
        }
        int i2 = 0;
        for (T t : ooooo0oxi) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return defaultValue.invoke(Integer.valueOf(i));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T xoO0xx0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(predicate, "predicate");
        for (T t : ooooo0oxi) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> T xoX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Sequence has more than one element.");
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T, R> ooOOo0oXI<R> xox(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(operation, "operation");
        return IXxxXO.II0xO0(new SequencesKt___SequencesKt$runningFold$1(r, ooooo0oxi, operation, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static <T> ooOOo0oXI<T> xoxXI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, int i) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        if (i >= 0) {
            if (i != 0) {
                if (ooooo0oxi instanceof X0o0xo) {
                    return ((X0o0xo) ooooo0oxi).drop(i);
                }
                return new kotlin.sequences.oxoX(ooooo0oxi, i);
            }
            return ooooo0oxi;
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    @OXOo.oOoXoXO
    public static final <T> T xx0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            return null;
        }
        return next;
    }

    @OXOo.OOXIXo
    public static final <T, R, C extends Collection<? super R>> C xx0X0(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends ooOOo0oXI<? extends R>> transform) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(transform, "transform");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            kotlin.collections.OxI.Ioxxx(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    public static final /* synthetic */ <R> ooOOo0oXI<R> xxIO(ooOOo0oXI<?> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.xoXoI();
        ooOOo0oXI<R> OO0x0xX2 = OO0x0xX(ooooo0oxi, new Oox.oOoXoXO<Object, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.oOoXoXO Object obj) {
                IIX0o.OxI(3, "R");
                return Boolean.valueOf(obj instanceof Object);
            }
        });
        IIX0o.x0XOIxOo(OO0x0xX2, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return OO0x0xX2;
    }

    public static <T> T xxOXOOoIX(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final <T extends Comparable<? super T>> T xxx00(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<? extends T> it = ooooo0oxi.iterator();
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

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Double xxxI(@OXOo.OOXIXo ooOOo0oXI<Double> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        Iterator<Double> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }
}
