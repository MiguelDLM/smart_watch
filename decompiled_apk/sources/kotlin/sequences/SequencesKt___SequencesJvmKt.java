package kotlin.sequences;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.X00IoxXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XX({"SMAP\n_SequencesJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,172:1\n1433#2,14:173\n1839#2,14:187\n*S KotlinDebug\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n*L\n89#1:173,14\n126#1:187,14\n*E\n"})
/* loaded from: classes6.dex */
public class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @X00IoxXI
    @xx0o0O.XO
    public static final <T> BigDecimal IIX0o(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends BigDecimal> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(selector.invoke(it.next()));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super R>, R> C IIXOooo(@OXOo.OOXIXo ooOOo0oXI<?> ooooo0oxi, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Class<R> klass) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(destination, "destination");
        IIX0o.x0xO0oo(klass, "klass");
        for (Object obj : ooooo0oxi) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T O0xOxO(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
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
        }
        return next;
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float OxI(ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return SequencesKt___SequencesKt.O00(ooooo0oxi);
    }

    @OXOo.OOXIXo
    public static final <R> ooOOo0oXI<R> OxxIIOOXO(@OXOo.OOXIXo ooOOo0oXI<?> ooooo0oxi, @OXOo.OOXIXo final Class<R> klass) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(klass, "klass");
        ooOOo0oXI<R> OO0x0xX2 = SequencesKt___SequencesKt.OO0x0xX(ooooo0oxi, new Oox.oOoXoXO<Object, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesJvmKt$filterIsInstance$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Boolean invoke(@OXOo.oOoXoXO Object obj) {
                return Boolean.valueOf(klass.isInstance(obj));
            }
        });
        IIX0o.x0XOIxOo(OO0x0xX2, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return OO0x0xX2;
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Object X0IIOO(ooOOo0oXI ooooo0oxi, Comparator comparator) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        return SequencesKt___SequencesKt.IxX00(ooooo0oxi, comparator);
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable XI0IXoo(ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return SequencesKt___SequencesKt.xxx00(ooooo0oxi);
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double XIxXXX0x0(ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return SequencesKt___SequencesKt.o0Xo(ooooo0oxi);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T XxX0x0xxx(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends R> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
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
        }
        return next;
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double o00(ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return SequencesKt___SequencesKt.xxxI(ooooo0oxi);
    }

    @OXOo.OOXIXo
    public static final <T> SortedSet<T> oo0xXOI0I(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Comparator<? super T> comparator) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        return (SortedSet) SequencesKt___SequencesKt.OOxOOxIO(ooooo0oxi, new TreeSet(comparator));
    }

    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @X00IoxXI
    @xx0o0O.XO
    public static final <T> BigInteger ooXIXxIX(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends BigInteger> selector) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        Iterator<? extends T> it = ooooo0oxi.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(selector.invoke(it.next()));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> SortedSet<T> xI(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return (SortedSet) SequencesKt___SequencesKt.OOxOOxIO(ooooo0oxi, new TreeSet());
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Object xXxxox0I(ooOOo0oXI ooooo0oxi, Comparator comparator) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(comparator, "comparator");
        return SequencesKt___SequencesKt.XooIO0oo0(ooooo0oxi, comparator);
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable xoXoI(ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return SequencesKt___SequencesKt.xIXX(ooooo0oxi);
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float xxX(ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return SequencesKt___SequencesKt.X00xOoXI(ooooo0oxi);
    }
}
