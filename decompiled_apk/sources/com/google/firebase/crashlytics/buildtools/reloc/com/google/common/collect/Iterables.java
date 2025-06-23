package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtIncompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicate;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Predicates;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class Iterables {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static class AnonymousClass1<T> extends FluentIterable<T> {
        final /* synthetic */ Iterable val$iterable;

        public AnonymousClass1(Iterable iterable) {
            this.val$iterable = iterable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Iterable lambda$spliterator$0(Iterable iterable) {
            return iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.cycle(this.val$iterable);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            Stream generate;
            Stream flatMap;
            Spliterator<T> spliterator;
            final Iterable iterable = this.val$iterable;
            generate = Stream.generate(new Supplier() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.X0IOOI
                @Override // java.util.function.Supplier
                public final Object get() {
                    Iterable lambda$spliterator$0;
                    lambda$spliterator$0 = Iterables.AnonymousClass1.lambda$spliterator$0(iterable);
                    return lambda$spliterator$0;
                }
            });
            flatMap = generate.flatMap(new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Oxo00O
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Streams.stream((Iterable) obj);
                }
            });
            spliterator = flatMap.spliterator();
            return spliterator;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.FluentIterable
        public String toString() {
            return this.val$iterable.toString() + " (cycled)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables$4, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static class AnonymousClass4<T> extends FluentIterable<T> {
        final /* synthetic */ Predicate val$retainIfTrue;
        final /* synthetic */ Iterable val$unfiltered;

        public AnonymousClass4(Iterable iterable, Predicate predicate) {
            this.val$unfiltered = iterable;
            this.val$retainIfTrue = predicate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$forEach$0(Predicate predicate, Consumer consumer, Object obj) {
            if (predicate.test(obj)) {
                consumer.accept(obj);
            }
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> consumer) {
            Preconditions.checkNotNull(consumer);
            Iterable iterable = this.val$unfiltered;
            final Predicate predicate = this.val$retainIfTrue;
            iterable.forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oxIO0IIo
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Iterables.AnonymousClass4.lambda$forEach$0(Predicate.this, consumer, obj);
                }
            });
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.filter(this.val$unfiltered.iterator(), this.val$retainIfTrue);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            Spliterator spliterator;
            spliterator = this.val$unfiltered.spliterator();
            return CollectSpliterators.filter(spliterator, this.val$retainIfTrue);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables$5, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static class AnonymousClass5<T> extends FluentIterable<T> {
        final /* synthetic */ Iterable val$fromIterable;
        final /* synthetic */ com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function val$function;

        public AnonymousClass5(Iterable iterable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function function) {
            this.val$fromIterable = iterable;
            this.val$function = function;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$forEach$0(Consumer consumer, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function function, Object obj) {
            consumer.accept(function.apply(obj));
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> consumer) {
            Preconditions.checkNotNull(consumer);
            Iterable iterable = this.val$fromIterable;
            final com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function function = this.val$function;
            iterable.forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oo0oIXo
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Iterables.AnonymousClass5.lambda$forEach$0(consumer, function, obj);
                }
            });
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.val$fromIterable.iterator(), this.val$function);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            Spliterator spliterator;
            spliterator = this.val$fromIterable.spliterator();
            return CollectSpliterators.map(spliterator, this.val$function);
        }
    }

    /* loaded from: classes10.dex */
    public static final class UnmodifiableIterable<T> extends FluentIterable<T> {
        private final Iterable<? extends T> iterable;

        public /* synthetic */ UnmodifiableIterable(Iterable iterable, AnonymousClass1 anonymousClass1) {
            this(iterable);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super T> consumer) {
            this.iterable.forEach(consumer);
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.iterable.iterator());
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            Spliterator<T> spliterator;
            spliterator = this.iterable.spliterator();
            return spliterator;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.FluentIterable
        public String toString() {
            return this.iterable.toString();
        }

        private UnmodifiableIterable(Iterable<? extends T> iterable) {
            this.iterable = iterable;
        }
    }

    private Iterables() {
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(Collections2.cast(iterable));
        }
        return Iterators.addAll(collection, ((Iterable) Preconditions.checkNotNull(iterable)).iterator());
    }

    public static <T> boolean all(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.all(iterable.iterator(), predicate);
    }

    public static <T> boolean any(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.any(iterable.iterator(), predicate);
    }

    private static <E> Collection<E> castOrCopyToCollection(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.newArrayList(iterable.iterator());
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return FluentIterable.concat(iterable, iterable2);
    }

    public static <T> Iterable<T> consumingIterable(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables.8
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                Iterable iterable2 = iterable;
                if (iterable2 instanceof Queue) {
                    return new ConsumingQueueIterator((Queue) iterable2);
                }
                return Iterators.consumingIterator(iterable2.iterator());
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.FluentIterable
            public String toString() {
                return "Iterables.consumingIterable(...)";
            }
        };
    }

    public static boolean contains(Iterable<?> iterable, @NullableDecl Object obj) {
        if (iterable instanceof Collection) {
            return Collections2.safeContains((Collection) iterable, obj);
        }
        return Iterators.contains(iterable.iterator(), obj);
    }

    public static <T> Iterable<T> cycle(Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new AnonymousClass1(iterable);
    }

    public static boolean elementsEqual(Iterable<?> iterable, Iterable<?> iterable2) {
        if ((iterable instanceof Collection) && (iterable2 instanceof Collection) && ((Collection) iterable).size() != ((Collection) iterable2).size()) {
            return false;
        }
        return Iterators.elementsEqual(iterable.iterator(), iterable2.iterator());
    }

    public static <T> Iterable<T> filter(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(predicate);
        return new AnonymousClass4(iterable, predicate);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        return (T) Iterators.find(iterable.iterator(), predicate);
    }

    public static int frequency(Iterable<?> iterable, @NullableDecl Object obj) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).count(obj);
        }
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(obj) ? 1 : 0;
        }
        return Iterators.frequency(iterable.iterator(), obj);
    }

    public static <T> T get(Iterable<T> iterable, int i) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i);
        }
        return (T) Iterators.get(iterable.iterator(), i);
    }

    @NullableDecl
    public static <T> T getFirst(Iterable<? extends T> iterable, @NullableDecl T t) {
        return (T) Iterators.getNext(iterable.iterator(), t);
    }

    public static <T> T getLast(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (!list.isEmpty()) {
                return (T) getLastInNonemptyList(list);
            }
            throw new NoSuchElementException();
        }
        return (T) Iterators.getLast(iterable.iterator());
    }

    private static <T> T getLastInNonemptyList(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T getOnlyElement(Iterable<T> iterable) {
        return (T) Iterators.getOnlyElement(iterable.iterator());
    }

    public static <T> int indexOf(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.indexOf(iterable.iterator(), predicate);
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> limit(final Iterable<T> iterable, final int i) {
        boolean z;
        Preconditions.checkNotNull(iterable);
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "limit is negative");
        return new FluentIterable<T>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables.7
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return Iterators.limit(iterable.iterator(), i);
            }

            @Override // java.lang.Iterable
            public Spliterator<T> spliterator() {
                Stream limit;
                Spliterator<T> spliterator;
                limit = Streams.stream(iterable).limit(i);
                spliterator = limit.spliterator();
                return spliterator;
            }
        };
    }

    @Beta
    public static <T> Iterable<T> mergeSorted(final Iterable<? extends Iterable<? extends T>> iterable, final Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterables");
        Preconditions.checkNotNull(comparator, "comparator");
        return new UnmodifiableIterable(new FluentIterable<T>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables.9
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return Iterators.mergeSorted(Iterables.transform(iterable, Iterables.toIterator()), comparator);
            }
        }, null);
    }

    public static <T> Iterable<List<T>> paddedPartition(final Iterable<T> iterable, final int i) {
        boolean z;
        Preconditions.checkNotNull(iterable);
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new FluentIterable<List<T>>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables.3
            @Override // java.lang.Iterable
            public Iterator<List<T>> iterator() {
                return Iterators.paddedPartition(iterable.iterator(), i);
            }
        };
    }

    public static <T> Iterable<List<T>> partition(final Iterable<T> iterable, final int i) {
        boolean z;
        Preconditions.checkNotNull(iterable);
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new FluentIterable<List<T>>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables.2
            @Override // java.lang.Iterable
            public Iterator<List<T>> iterator() {
                return Iterators.partition(iterable.iterator(), i);
            }
        };
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterable<?> iterable, Collection<?> collection) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).removeAll((Collection) Preconditions.checkNotNull(collection));
        }
        return Iterators.removeAll(iterable.iterator(), collection);
    }

    @NullableDecl
    public static <T> T removeFirstMatching(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterable<T> iterable, Predicate<? super T> predicate) {
        boolean removeIf;
        if (iterable instanceof Collection) {
            removeIf = ((Collection) iterable).removeIf(predicate);
            return removeIf;
        }
        return Iterators.removeIf(iterable.iterator(), predicate);
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterable<?> iterable, Collection<?> collection) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).retainAll((Collection) Preconditions.checkNotNull(collection));
        }
        return Iterators.retainAll(iterable.iterator(), collection);
    }

    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return Iterators.size(iterable.iterator());
    }

    public static <T> Iterable<T> skip(final Iterable<T> iterable, final int i) {
        boolean z;
        Preconditions.checkNotNull(iterable);
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "number to skip cannot be negative");
        return new FluentIterable<T>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables.6
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                Iterable iterable2 = iterable;
                if (iterable2 instanceof List) {
                    List list = (List) iterable2;
                    return list.subList(Math.min(list.size(), i), list.size()).iterator();
                }
                final Iterator<T> it = iterable2.iterator();
                Iterators.advance(it, i);
                return new Iterator<T>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables.6.1
                    boolean atStart = true;

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public T next() {
                        T t = (T) it.next();
                        this.atStart = false;
                        return t;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        CollectPreconditions.checkRemove(!this.atStart);
                        it.remove();
                    }
                };
            }

            @Override // java.lang.Iterable
            public Spliterator<T> spliterator() {
                Stream skip;
                Spliterator<T> spliterator;
                Spliterator<T> spliterator2;
                Iterable iterable2 = iterable;
                if (!(iterable2 instanceof List)) {
                    skip = Streams.stream(iterable2).skip(i);
                    spliterator = skip.spliterator();
                    return spliterator;
                }
                List list = (List) iterable2;
                spliterator2 = list.subList(Math.min(list.size(), i), list.size()).spliterator();
                return spliterator2;
            }
        };
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterable<? extends T> iterable, Class<T> cls) {
        return (T[]) toArray(iterable, ObjectArrays.newArray(cls, 0));
    }

    public static <T> com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function<Iterable<? extends T>, Iterator<? extends T>> toIterator() {
        return new com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function<Iterable<? extends T>, Iterator<? extends T>>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Iterables.10
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function, java.util.function.Function
            public Iterator<? extends T> apply(Iterable<? extends T> iterable) {
                return iterable.iterator();
            }
        };
    }

    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    public static <F, T> Iterable<T> transform(Iterable<F> iterable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new AnonymousClass5(iterable, function);
    }

    public static <T> Optional<T> tryFind(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.tryFind(iterable.iterator(), predicate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Iterable<T> unmodifiableIterable(Iterable<? extends T> iterable) {
        Preconditions.checkNotNull(iterable);
        return ((iterable instanceof UnmodifiableIterable) || (iterable instanceof ImmutableCollection)) ? iterable : new UnmodifiableIterable(iterable, null);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return FluentIterable.concat(iterable, iterable2, iterable3);
    }

    @NullableDecl
    public static <T> T find(Iterable<? extends T> iterable, Predicate<? super T> predicate, @NullableDecl T t) {
        return (T) Iterators.find(iterable.iterator(), predicate, t);
    }

    @NullableDecl
    public static <T> T getOnlyElement(Iterable<? extends T> iterable, @NullableDecl T t) {
        return (T) Iterators.getOnlyElement(iterable.iterator(), t);
    }

    public static <T> T[] toArray(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) castOrCopyToCollection(iterable).toArray(tArr);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return FluentIterable.concat(iterable, iterable2, iterable3, iterable4);
    }

    @SafeVarargs
    public static <T> Iterable<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList(tArr));
    }

    @SafeVarargs
    public static <T> Iterable<T> concat(Iterable<? extends T>... iterableArr) {
        return FluentIterable.concat(iterableArr);
    }

    @GwtIncompatible
    public static <T> Iterable<T> filter(Iterable<?> iterable, Class<T> cls) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(cls);
        return filter(iterable, Predicates.instanceOf(cls));
    }

    public static Object[] toArray(Iterable<?> iterable) {
        return castOrCopyToCollection(iterable).toArray();
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> immutableCollection) {
        return (Iterable) Preconditions.checkNotNull(immutableCollection);
    }

    public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> iterable) {
        return FluentIterable.concat(iterable);
    }

    @NullableDecl
    public static <T> T get(Iterable<? extends T> iterable, int i, @NullableDecl T t) {
        Preconditions.checkNotNull(iterable);
        Iterators.checkNonnegative(i);
        if (iterable instanceof List) {
            List cast = Lists.cast(iterable);
            return i < cast.size() ? (T) cast.get(i) : t;
        }
        Iterator<? extends T> it = iterable.iterator();
        Iterators.advance(it, i);
        return (T) Iterators.getNext(it, t);
    }

    @NullableDecl
    public static <T> T getLast(Iterable<? extends T> iterable, @NullableDecl T t) {
        if (iterable instanceof Collection) {
            if (Collections2.cast(iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return (T) getLastInNonemptyList(Lists.cast(iterable));
            }
        }
        return (T) Iterators.getLast(iterable.iterator(), t);
    }
}
