package kotlin.collections;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@kotlin.jvm.internal.XX({"SMAP\n_CollectionsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1963#2,14:169\n2333#2,14:183\n*S KotlinDebug\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n*L\n89#1:169,14\n126#1:183,14\n*E\n"})
/* loaded from: classes6.dex */
public class X0IIOO extends O0xOxO {
    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigInteger")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> BigInteger I0xX0(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends BigInteger> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(selector.invoke(it.next()));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Object IO0XoXxO(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return CollectionsKt___CollectionsKt.xx00oOoI(iterable, comparator);
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
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T IOoo(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
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

    @OXOo.OOXIXo
    public static final <T> SortedSet<T> OX(@OXOo.OOXIXo Iterable<? extends T> iterable, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return (SortedSet) CollectionsKt___CollectionsKt.X0oX(iterable, new TreeSet(comparator));
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> SortedSet<T> Oxx(@OXOo.OOXIXo Iterable<? extends T> iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return (SortedSet) CollectionsKt___CollectionsKt.X0oX(iterable, new TreeSet());
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float X0xII0I(Iterable iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return CollectionsKt___CollectionsKt.I0OO(iterable);
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
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T X0xxXX0(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends R> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        Iterator<? extends T> it = iterable.iterator();
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

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Float XI(Iterable iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return CollectionsKt___CollectionsKt.IoxOx(iterable);
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double XOxxooXI(Iterable iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return CollectionsKt___CollectionsKt.XXx0OXXXo(iterable);
    }

    @kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
    @XO0OX.xxIXOIIO(name = "sumOfBigDecimal")
    @kotlin.X00IoxXI
    @xx0o0O.XO
    public static final <T> BigDecimal XXXI(Iterable<? extends T> iterable, Oox.oOoXoXO<? super T, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            valueOf = valueOf.add(selector.invoke(it.next()));
            kotlin.jvm.internal.IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Object oIIxXoo(Iterable iterable, Comparator comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        return CollectionsKt___CollectionsKt.oxOIoIx(iterable, comparator);
    }

    public static <T> void oXX0IoI(@OXOo.OOXIXo List<T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        Collections.reverse(list);
    }

    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @kotlin.XX(expression = "this.minOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable oXxOI0oIx(Iterable iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return CollectionsKt___CollectionsKt.IOOXOOOOo(iterable);
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oxxXoxO(version = "1.1")
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Double x0(Iterable iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return CollectionsKt___CollectionsKt.X0(iterable);
    }

    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @kotlin.XX(expression = "this.maxOrNull()", imports = {}))
    @kotlin.oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ Comparable x0OxxIOxX(Iterable iterable) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        return CollectionsKt___CollectionsKt.o0xOIoxo(iterable);
    }

    @OXOo.OOXIXo
    public static final <C extends Collection<? super R>, R> C xXoOI00O(@OXOo.OOXIXo Iterable<?> iterable, @OXOo.OOXIXo C destination, @OXOo.OOXIXo Class<R> klass) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(klass, "klass");
        for (Object obj : iterable) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @OXOo.OOXIXo
    public static final <R> List<R> xxOXOOoIX(@OXOo.OOXIXo Iterable<?> iterable, @OXOo.OOXIXo Class<R> klass) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterable, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(klass, "klass");
        return (List) xXoOI00O(iterable, new ArrayList(), klass);
    }
}
