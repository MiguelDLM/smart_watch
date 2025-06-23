package xX0ox;

import Oox.x0xO0oo;
import java.util.Comparator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

/* loaded from: classes6.dex */
public class Oxx0IOOO {

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class I0Io<T> implements Comparator {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<T, Comparable<?>> f34624XO;

        /* JADX WARN: Multi-variable type inference failed */
        public I0Io(Oox.oOoXoXO<? super T, ? extends Comparable<?>> oooxoxo) {
            this.f34624XO = oooxoxo;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Oox.oOoXoXO<T, Comparable<?>> oooxoxo = this.f34624XO;
            return Oxx0IOOO.oOoXoXO(oooxoxo.invoke(t2), oooxoxo.invoke(t));
        }
    }

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$2\n*L\n1#1,328:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0XooXoX<T> implements Comparator {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<T, K> f34625IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f34626Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f34627XO;

        /* JADX WARN: Multi-variable type inference failed */
        public II0XooXoX(Comparator<T> comparator, Comparator<? super K> comparator2, Oox.oOoXoXO<? super T, ? extends K> oooxoxo) {
            this.f34627XO = comparator;
            this.f34626Oo = comparator2;
            this.f34625IXxxXO = oooxoxo;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f34627XO.compare(t, t2);
            if (compare == 0) {
                Comparator<? super K> comparator = this.f34626Oo;
                Oox.oOoXoXO<T, K> oooxoxo = this.f34625IXxxXO;
                return comparator.compare(oooxoxo.invoke(t2), oooxoxo.invoke(t));
            }
            return compare;
        }
    }

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$3\n*L\n1#1,328:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0<T> implements Comparator {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<T, K> f34628Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f34629XO;

        /* JADX WARN: Multi-variable type inference failed */
        public II0xO0(Comparator<? super K> comparator, Oox.oOoXoXO<? super T, ? extends K> oooxoxo) {
            this.f34629XO = comparator;
            this.f34628Oo = oooxoxo;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Comparator<? super K> comparator = this.f34629XO;
            Oox.oOoXoXO<T, K> oooxoxo = this.f34628Oo;
            return comparator.compare(oooxoxo.invoke(t), oooxoxo.invoke(t2));
        }
    }

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1\n*L\n1#1,328:1\n*E\n"})
    /* renamed from: xX0ox.Oxx0IOOO$Oxx0IOOO, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1163Oxx0IOOO<T> implements Comparator {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<T, Comparable<?>> f34630Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f34631XO;

        /* JADX WARN: Multi-variable type inference failed */
        public C1163Oxx0IOOO(Comparator<T> comparator, Oox.oOoXoXO<? super T, ? extends Comparable<?>> oooxoxo) {
            this.f34631XO = comparator;
            this.f34630Oo = oooxoxo;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f34631XO.compare(t, t2);
            if (compare == 0) {
                Oox.oOoXoXO<T, Comparable<?>> oooxoxo = this.f34630Oo;
                return Oxx0IOOO.oOoXoXO(oooxoxo.invoke(t2), oooxoxo.invoke(t));
            }
            return compare;
        }
    }

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1\n*L\n1#1,328:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class X0o0xo<T> implements Comparator {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<T, Comparable<?>> f34632Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f34633XO;

        /* JADX WARN: Multi-variable type inference failed */
        public X0o0xo(Comparator<T> comparator, Oox.oOoXoXO<? super T, ? extends Comparable<?>> oooxoxo) {
            this.f34633XO = comparator;
            this.f34632Oo = oooxoxo;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f34633XO.compare(t, t2);
            if (compare == 0) {
                Oox.oOoXoXO<T, Comparable<?>> oooxoxo = this.f34632Oo;
                return Oxx0IOOO.oOoXoXO(oooxoxo.invoke(t), oooxoxo.invoke(t2));
            }
            return compare;
        }
    }

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$2\n*L\n1#1,328:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class XO<T> implements Comparator {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<T, K> f34634IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f34635Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f34636XO;

        /* JADX WARN: Multi-variable type inference failed */
        public XO(Comparator<T> comparator, Comparator<? super K> comparator2, Oox.oOoXoXO<? super T, ? extends K> oooxoxo) {
            this.f34636XO = comparator;
            this.f34635Oo = comparator2;
            this.f34634IXxxXO = oooxoxo;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f34636XO.compare(t, t2);
            if (compare == 0) {
                Comparator<? super K> comparator = this.f34635Oo;
                Oox.oOoXoXO<T, K> oooxoxo = this.f34634IXxxXO;
                return comparator.compare(oooxoxo.invoke(t), oooxoxo.invoke(t2));
            }
            return compare;
        }
    }

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements Comparator {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<T, Comparable<?>> f34637XO;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(Oox.oOoXoXO<? super T, ? extends Comparable<?>> oooxoxo) {
            this.f34637XO = oooxoxo;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Oox.oOoXoXO<T, Comparable<?>> oooxoxo = this.f34637XO;
            return Oxx0IOOO.oOoXoXO(oooxoxo.invoke(t), oooxoxo.invoke(t2));
        }
    }

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$2\n*L\n1#1,328:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oxoX<T> implements Comparator {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Oox.oOoXoXO<T, K> f34638Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f34639XO;

        /* JADX WARN: Multi-variable type inference failed */
        public oxoX(Comparator<? super K> comparator, Oox.oOoXoXO<? super T, ? extends K> oooxoxo) {
            this.f34639XO = comparator;
            this.f34638Oo = oooxoxo;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Comparator<? super K> comparator = this.f34639XO;
            Oox.oOoXoXO<T, K> oooxoxo = this.f34638Oo;
            return comparator.compare(oooxoxo.invoke(t2), oooxoxo.invoke(t));
        }
    }

    @XX({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenComparator$1\n*L\n1#1,328:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class xxIXOIIO<T> implements Comparator {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ x0xO0oo<T, T, Integer> f34640Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f34641XO;

        /* JADX WARN: Multi-variable type inference failed */
        public xxIXOIIO(Comparator<T> comparator, x0xO0oo<? super T, ? super T, Integer> x0xo0oo) {
            this.f34641XO = comparator;
            this.f34640Oo = x0xo0oo;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare = this.f34641XO.compare(t, t2);
            if (compare == 0) {
                return this.f34640Oo.invoke(t, t2).intValue();
            }
            return compare;
        }
    }

    @OXOo.OOXIXo
    public static final <T> Comparator<T> II0XooXoX(@OXOo.OOXIXo final Oox.oOoXoXO<? super T, ? extends Comparable<?>>... selectors) {
        IIX0o.x0xO0oo(selectors, "selectors");
        if (selectors.length > 0) {
            return new Comparator() { // from class: xX0ox.X0o0xo
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int xxIXOIIO2;
                    xxIXOIIO2 = Oxx0IOOO.xxIXOIIO(selectors, obj, obj2);
                    return xxIXOIIO2;
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    @OXOo.OOXIXo
    public static final <T> Comparator<T> IIX0o(@OXOo.OOXIXo final Comparator<T> comparator, @OXOo.OOXIXo final Comparator<? super T> comparator2) {
        IIX0o.x0xO0oo(comparator, "<this>");
        IIX0o.x0xO0oo(comparator2, "comparator");
        return new Comparator() { // from class: xX0ox.I0Io
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int ooXIXxIX2;
                ooXIXxIX2 = Oxx0IOOO.ooXIXxIX(comparator, comparator2, obj, obj2);
                return ooXIXxIX2;
            }
        };
    }

    @OXOo.OOXIXo
    public static final <T> Comparator<T> IIXOooo(@OXOo.OOXIXo final Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(comparator, "comparator");
        return new Comparator() { // from class: xX0ox.II0xO0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int xoXoI2;
                xoXoI2 = Oxx0IOOO.xoXoI(comparator, obj, obj2);
                return xoXoI2;
            }
        };
    }

    @xx0o0O.XO
    public static final <T extends Comparable<? super T>> Comparator<T> IXxxXO() {
        return Oxx0xo(Oo());
    }

    @OXOo.OOXIXo
    public static final <T> Comparator<T> O0xOxO(@OXOo.OOXIXo final Comparator<T> comparator, @OXOo.OOXIXo final Comparator<? super T> comparator2) {
        IIX0o.x0xO0oo(comparator, "<this>");
        IIX0o.x0xO0oo(comparator2, "comparator");
        return new Comparator() { // from class: xX0ox.oxoX
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int X0IIOO2;
                X0IIOO2 = Oxx0IOOO.X0IIOO(comparator, comparator2, obj, obj2);
                return X0IIOO2;
            }
        };
    }

    @xx0o0O.XO
    public static final <T, K> Comparator<T> OOXIXo(Comparator<? super K> comparator, Oox.oOoXoXO<? super T, ? extends K> selector) {
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        return new oxoX(comparator, selector);
    }

    @OXOo.OOXIXo
    public static <T extends Comparable<? super T>> Comparator<T> Oo() {
        xoIox xoiox = xoIox.f34647XO;
        IIX0o.x0XOIxOo(xoiox, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return xoiox;
    }

    @OXOo.OOXIXo
    public static final <T> Comparator<T> OxI(@OXOo.OOXIXo Comparator<T> comparator) {
        IIX0o.x0xO0oo(comparator, "<this>");
        if (comparator instanceof oOoXoXO) {
            return ((oOoXoXO) comparator).oIX0oI();
        }
        Comparator<T> comparator2 = xoIox.f34647XO;
        if (IIX0o.Oxx0IOOO(comparator, comparator2)) {
            OOXIXo oOXIXo = OOXIXo.f34623XO;
            IIX0o.x0XOIxOo(oOXIXo, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
            return oOXIXo;
        }
        if (IIX0o.Oxx0IOOO(comparator, OOXIXo.f34623XO)) {
            IIX0o.x0XOIxOo(comparator2, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        } else {
            comparator2 = new oOoXoXO<>(comparator);
        }
        return comparator2;
    }

    @xx0o0O.XO
    public static final <T, K> Comparator<T> Oxx0IOOO(Comparator<? super K> comparator, Oox.oOoXoXO<? super T, ? extends K> selector) {
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        return new II0xO0(comparator, selector);
    }

    @OXOo.OOXIXo
    public static final <T> Comparator<T> Oxx0xo(@OXOo.OOXIXo final Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(comparator, "comparator");
        return new Comparator() { // from class: xX0ox.XO
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int oI0IIXIo2;
                oI0IIXIo2 = Oxx0IOOO.oI0IIXIo(comparator, obj, obj2);
                return oI0IIXIo2;
            }
        };
    }

    @xx0o0O.XO
    public static final <T extends Comparable<? super T>> Comparator<T> OxxIIOOXO() {
        return IIXOooo(Oo());
    }

    public static final int X0IIOO(Comparator this_then, Comparator comparator, Object obj, Object obj2) {
        IIX0o.x0xO0oo(this_then, "$this_then");
        IIX0o.x0xO0oo(comparator, "$comparator");
        int compare = this_then.compare(obj, obj2);
        if (compare == 0) {
            return comparator.compare(obj, obj2);
        }
        return compare;
    }

    @xx0o0O.XO
    public static final <T> Comparator<T> XI0IXoo(Comparator<T> comparator, Oox.oOoXoXO<? super T, ? extends Comparable<?>> selector) {
        IIX0o.x0xO0oo(comparator, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        return new X0o0xo(comparator, selector);
    }

    @xx0o0O.XO
    public static final <T, K> Comparator<T> XIxXXX0x0(Comparator<T> comparator, Comparator<? super K> comparator2, Oox.oOoXoXO<? super T, ? extends K> selector) {
        IIX0o.x0xO0oo(comparator, "<this>");
        IIX0o.x0xO0oo(comparator2, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        return new XO(comparator, comparator2, selector);
    }

    @xx0o0O.XO
    public static final <T> Comparator<T> XO(Oox.oOoXoXO<? super T, ? extends Comparable<?>> selector) {
        IIX0o.x0xO0oo(selector, "selector");
        return new oIX0oI(selector);
    }

    @xx0o0O.XO
    public static final <T, K> Comparator<T> XxX0x0xxx(Comparator<T> comparator, Comparator<? super K> comparator2, Oox.oOoXoXO<? super T, ? extends K> selector) {
        IIX0o.x0xO0oo(comparator, "<this>");
        IIX0o.x0xO0oo(comparator2, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        return new II0XooXoX(comparator, comparator2, selector);
    }

    @OXOo.OOXIXo
    public static <T extends Comparable<? super T>> Comparator<T> o00() {
        OOXIXo oOXIXo = OOXIXo.f34623XO;
        IIX0o.x0XOIxOo(oOXIXo, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return oOXIXo;
    }

    public static final int oI0IIXIo(Comparator comparator, Object obj, Object obj2) {
        IIX0o.x0xO0oo(comparator, "$comparator");
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return comparator.compare(obj, obj2);
    }

    public static final <T> int oO(T t, T t2, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends Comparable<?>>... selectors) {
        IIX0o.x0xO0oo(selectors, "selectors");
        if (selectors.length > 0) {
            return x0xO0oo(t, t2, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static <T extends Comparable<?>> int oOoXoXO(@OXOo.oOoXoXO T t, @OXOo.oOoXoXO T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    @xx0o0O.XO
    public static final <T> int ooOOo0oXI(T t, T t2, Oox.oOoXoXO<? super T, ? extends Comparable<?>> selector) {
        IIX0o.x0xO0oo(selector, "selector");
        return oOoXoXO(selector.invoke(t), selector.invoke(t2));
    }

    public static final int ooXIXxIX(Comparator this_thenDescending, Comparator comparator, Object obj, Object obj2) {
        IIX0o.x0xO0oo(this_thenDescending, "$this_thenDescending");
        IIX0o.x0xO0oo(comparator, "$comparator");
        int compare = this_thenDescending.compare(obj, obj2);
        if (compare == 0) {
            return comparator.compare(obj2, obj);
        }
        return compare;
    }

    @xx0o0O.XO
    public static final <T, K> int x0XOIxOo(T t, T t2, Comparator<? super K> comparator, Oox.oOoXoXO<? super T, ? extends K> selector) {
        IIX0o.x0xO0oo(comparator, "comparator");
        IIX0o.x0xO0oo(selector, "selector");
        return comparator.compare(selector.invoke(t), selector.invoke(t2));
    }

    public static final <T> int x0xO0oo(T t, T t2, Oox.oOoXoXO<? super T, ? extends Comparable<?>>[] oooxoxoArr) {
        for (Oox.oOoXoXO<? super T, ? extends Comparable<?>> oooxoxo : oooxoxoArr) {
            int oOoXoXO2 = oOoXoXO(oooxoxo.invoke(t), oooxoxo.invoke(t2));
            if (oOoXoXO2 != 0) {
                return oOoXoXO2;
            }
        }
        return 0;
    }

    @xx0o0O.XO
    public static final <T> Comparator<T> xXxxox0I(Comparator<T> comparator, x0xO0oo<? super T, ? super T, Integer> comparison) {
        IIX0o.x0xO0oo(comparator, "<this>");
        IIX0o.x0xO0oo(comparison, "comparison");
        return new xxIXOIIO(comparator, comparison);
    }

    @xx0o0O.XO
    public static final <T> Comparator<T> xoIox(Oox.oOoXoXO<? super T, ? extends Comparable<?>> selector) {
        IIX0o.x0xO0oo(selector, "selector");
        return new I0Io(selector);
    }

    public static final int xoXoI(Comparator comparator, Object obj, Object obj2) {
        IIX0o.x0xO0oo(comparator, "$comparator");
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return comparator.compare(obj, obj2);
    }

    public static final int xxIXOIIO(Oox.oOoXoXO[] selectors, Object obj, Object obj2) {
        IIX0o.x0xO0oo(selectors, "$selectors");
        return x0xO0oo(obj, obj2, selectors);
    }

    @xx0o0O.XO
    public static final <T> Comparator<T> xxX(Comparator<T> comparator, Oox.oOoXoXO<? super T, ? extends Comparable<?>> selector) {
        IIX0o.x0xO0oo(comparator, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        return new C1163Oxx0IOOO(comparator, selector);
    }
}
