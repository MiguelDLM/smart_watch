package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableBiMap;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableRangeMap;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableRangeSet;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMap;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedSet;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

@GwtCompatible
/* loaded from: classes10.dex */
final class CollectCollectors {
    private static final Collector<Object, ?, ImmutableList<Object>> TO_IMMUTABLE_LIST;

    @GwtIncompatible
    private static final Collector<Range<Comparable>, ?, ImmutableRangeSet<Comparable>> TO_IMMUTABLE_RANGE_SET;
    private static final Collector<Object, ?, ImmutableSet<Object>> TO_IMMUTABLE_SET;

    static {
        Collector<Object, ?, ImmutableList<Object>> of;
        Collector<Object, ?, ImmutableSet<Object>> of2;
        Collector<Range<Comparable>, ?, ImmutableRangeSet<Comparable>> of3;
        of = Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.OxI
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableList.builder();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xxX
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableList.Builder) obj).add((ImmutableList.Builder) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XxX0x0xxx
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableList.Builder) obj).combine((ImmutableList.Builder) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xXxxox0I
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableList.Builder) obj).build();
            }
        }, new Collector.Characteristics[0]);
        TO_IMMUTABLE_LIST = of;
        of2 = Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IIX0o
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableSet.builder();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ooXIXxIX
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableSet.Builder) obj).add((ImmutableSet.Builder) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xI
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSet.Builder) obj).combine((ImmutableSet.Builder) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oo0xXOI0I
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSet.Builder) obj).build();
            }
        }, new Collector.Characteristics[0]);
        TO_IMMUTABLE_SET = of2;
        of3 = Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.O0xOxO
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableRangeSet.builder();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.X0IIOO
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableRangeSet.Builder) obj).add((Range) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XI0IXoo
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableRangeSet.Builder) obj).combine((ImmutableRangeSet.Builder) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XIxXXX0x0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableRangeSet.Builder) obj).build();
            }
        }, new Collector.Characteristics[0]);
        TO_IMMUTABLE_RANGE_SET = of3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toImmutableBiMap$0(Function function, Function function2, ImmutableBiMap.Builder builder, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        builder.put((ImmutableBiMap.Builder) apply, apply2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toImmutableMap$1(Function function, Function function2, ImmutableMap.Builder builder, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        builder.put(apply, apply2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toImmutableRangeMap$5(Function function, Function function2, ImmutableRangeMap.Builder builder, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        builder.put((Range) apply, apply2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableSortedMap.Builder lambda$toImmutableSortedMap$2(Comparator comparator) {
        return new ImmutableSortedMap.Builder(comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toImmutableSortedMap$3(Function function, Function function2, ImmutableSortedMap.Builder builder, Object obj) {
        Object apply;
        Object apply2;
        apply = function.apply(obj);
        apply2 = function2.apply(obj);
        builder.put((ImmutableSortedMap.Builder) apply, apply2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableSortedSet.Builder lambda$toImmutableSortedSet$4(Comparator comparator) {
        return new ImmutableSortedSet.Builder(comparator);
    }

    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        Collector<T, ?, ImmutableBiMap<K, V>> of;
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        of = Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.OI0
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ImmutableBiMap.Builder();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XoX
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                CollectCollectors.lambda$toImmutableBiMap$0(function, function2, (ImmutableBiMap.Builder) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oxXx0IX
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableBiMap.Builder) obj).combine((ImmutableMap.Builder) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xo0x
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableBiMap.Builder) obj).build();
            }
        }, new Collector.Characteristics[0]);
        return of;
    }

    public static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return (Collector<E, ?, ImmutableList<E>>) TO_IMMUTABLE_LIST;
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        Collector<T, ?, ImmutableMap<K, V>> of;
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        of = Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IO
            @Override // java.util.function.Supplier
            public final Object get() {
                return new ImmutableMap.Builder();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xII
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                CollectCollectors.lambda$toImmutableMap$1(function, function2, (ImmutableMap.Builder) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x0o
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableMap.Builder) obj).combine((ImmutableMap.Builder) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XOxIOxOx
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableMap.Builder) obj).build();
            }
        }, new Collector.Characteristics[0]);
        return of;
    }

    @GwtIncompatible
    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(final Function<? super T, Range<K>> function, final Function<? super T, ? extends V> function2) {
        Collector<T, ?, ImmutableRangeMap<K, V>> of;
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        of = Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IoOoX
            @Override // java.util.function.Supplier
            public final Object get() {
                return ImmutableRangeMap.builder();
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oOXoIIIo
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                CollectCollectors.lambda$toImmutableRangeMap$5(function, function2, (ImmutableRangeMap.Builder) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Xx000oIo
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableRangeMap.Builder) obj).combine((ImmutableRangeMap.Builder) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.X00IoxXI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableRangeMap.Builder) obj).build();
            }
        }, new Collector.Characteristics[0]);
        return of;
    }

    @GwtIncompatible
    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return (Collector<Range<E>, ?, ImmutableRangeSet<E>>) TO_IMMUTABLE_RANGE_SET;
    }

    public static <E> Collector<E, ?, ImmutableSet<E>> toImmutableSet() {
        return (Collector<E, ?, ImmutableSet<E>>) TO_IMMUTABLE_SET;
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(final Comparator<? super K> comparator, final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        Collector.Characteristics characteristics;
        Collector<T, ?, ImmutableSortedMap<K, V>> of;
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        Supplier supplier = new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xXOx
            @Override // java.util.function.Supplier
            public final Object get() {
                ImmutableSortedMap.Builder lambda$toImmutableSortedMap$2;
                lambda$toImmutableSortedMap$2 = CollectCollectors.lambda$toImmutableSortedMap$2(comparator);
                return lambda$toImmutableSortedMap$2;
            }
        };
        BiConsumer biConsumer = new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XX0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                CollectCollectors.lambda$toImmutableSortedMap$3(function, function2, (ImmutableSortedMap.Builder) obj, obj2);
            }
        };
        BinaryOperator binaryOperator = new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.I0X0x0oIo
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSortedMap.Builder) obj).combine((ImmutableMap.Builder) obj2);
            }
        };
        Function function3 = new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oX
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSortedMap.Builder) obj).build();
            }
        };
        characteristics = Collector.Characteristics.UNORDERED;
        of = Collector.of(supplier, biConsumer, binaryOperator, function3, characteristics);
        return of;
    }

    public static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(final Comparator<? super E> comparator) {
        Collector<E, ?, ImmutableSortedSet<E>> of;
        Preconditions.checkNotNull(comparator);
        of = Collector.of(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.o0
            @Override // java.util.function.Supplier
            public final Object get() {
                ImmutableSortedSet.Builder lambda$toImmutableSortedSet$4;
                lambda$toImmutableSortedSet$4 = CollectCollectors.lambda$toImmutableSortedSet$4(comparator);
                return lambda$toImmutableSortedSet$4;
            }
        }, new BiConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XX
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((ImmutableSortedSet.Builder) obj).add((ImmutableSortedSet.Builder) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.I0oOoX
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableSortedSet.Builder) obj).combine((ImmutableSet.Builder) obj2);
            }
        }, new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oxxXoxO
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ImmutableSortedSet.Builder) obj).build();
            }
        }, new Collector.Characteristics[0]);
        return of;
    }
}
