package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.kuaishou.weapon.p0.t;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

@Beta
@GwtCompatible
/* loaded from: classes10.dex */
public final class Comparators {
    private Comparators() {
    }

    @Beta
    public static <T> Comparator<Optional<T>> emptiesFirst(Comparator<? super T> comparator) {
        Comparator nullsFirst;
        Comparator<Optional<T>> comparing;
        Preconditions.checkNotNull(comparator);
        Function function = new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x0OIX00oO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object oIX0oI2;
                oIX0oI2 = I0oOIX.XO.oIX0oI((Optional) obj, null);
                return oIX0oI2;
            }
        };
        nullsFirst = Comparator.nullsFirst(comparator);
        comparing = Comparator.comparing(function, nullsFirst);
        return comparing;
    }

    @Beta
    public static <T> Comparator<Optional<T>> emptiesLast(Comparator<? super T> comparator) {
        Comparator nullsLast;
        Comparator<Optional<T>> comparing;
        Preconditions.checkNotNull(comparator);
        Function function = new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.OIOoIIOIx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object oIX0oI2;
                oIX0oI2 = I0oOIX.XO.oIX0oI((Optional) obj, null);
                return oIX0oI2;
            }
        };
        nullsLast = Comparator.nullsLast(comparator);
        comparing = Comparator.comparing(function, nullsLast);
        return comparing;
    }

    public static <T> Collector<T, ?, List<T>> greatest(int i, Comparator<? super T> comparator) {
        Comparator reversed;
        reversed = comparator.reversed();
        return least(i, reversed);
    }

    public static <T> boolean isInOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (comparator.compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public static <T> boolean isInStrictOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (comparator.compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public static <T> Collector<T, ?, List<T>> least(final int i, final Comparator<? super T> comparator) {
        Collector.Characteristics characteristics;
        Collector<T, ?, List<T>> of;
        CollectPreconditions.checkNonnegative(i, t.f18411a);
        Preconditions.checkNotNull(comparator);
        Supplier supplier = new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IoIOOxIIo
            @Override // java.util.function.Supplier
            public final Object get() {
                TopKSelector least;
                least = TopKSelector.least(i, comparator);
                return least;
            }
        };
        BiConsumer biConsumer = new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oxIIX0o
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((TopKSelector) obj).offer(obj2);
            }
        };
        BinaryOperator binaryOperator = new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.o0oIxOo
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((TopKSelector) obj).combine((TopKSelector) obj2);
            }
        };
        Function function = new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XIXIxO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((TopKSelector) obj).topK();
            }
        };
        characteristics = Collector.Characteristics.UNORDERED;
        of = Collector.of(supplier, biConsumer, binaryOperator, function, characteristics);
        return of;
    }

    public static <T, S extends T> Comparator<Iterable<S>> lexicographical(Comparator<T> comparator) {
        return new LexicographicalOrdering((Comparator) Preconditions.checkNotNull(comparator));
    }
}
