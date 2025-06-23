package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CollectSpliterators;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes10.dex */
public final class CollectSpliterators {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CollectSpliterators$1, reason: invalid class name */
    /* loaded from: classes10.dex */
    public static class AnonymousClass1<T> implements Spliterator<T> {
        final /* synthetic */ Spliterator val$fromSpliterator;
        final /* synthetic */ Function val$function;

        public AnonymousClass1(Spliterator spliterator, Function function) {
            this.val$fromSpliterator = spliterator;
            this.val$function = function;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$forEachRemaining$1(Consumer consumer, Function function, Object obj) {
            Object apply;
            apply = function.apply(obj);
            consumer.accept(apply);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$tryAdvance$0(Consumer consumer, Function function, Object obj) {
            Object apply;
            apply = function.apply(obj);
            consumer.accept(apply);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            int characteristics;
            characteristics = this.val$fromSpliterator.characteristics();
            return characteristics & (-262);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            long estimateSize;
            estimateSize = this.val$fromSpliterator.estimateSize();
            return estimateSize;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator spliterator = this.val$fromSpliterator;
            final Function function = this.val$function;
            spliterator.forEachRemaining(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.OO0x0xX
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CollectSpliterators.AnonymousClass1.lambda$forEachRemaining$1(consumer, function, obj);
                }
            });
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            boolean tryAdvance;
            Spliterator spliterator = this.val$fromSpliterator;
            final Function function = this.val$function;
            tryAdvance = spliterator.tryAdvance(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XIo0oOXIx
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CollectSpliterators.AnonymousClass1.lambda$tryAdvance$0(consumer, function, obj);
                }
            });
            return tryAdvance;
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator trySplit;
            trySplit = this.val$fromSpliterator.trySplit();
            if (trySplit != null) {
                return CollectSpliterators.map(trySplit, this.val$function);
            }
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CollectSpliterators$1FlatMapSpliterator, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class C1FlatMapSpliterator<T> implements Spliterator<T> {
        int characteristics;
        long estimatedSize;
        final Spliterator<F> from;

        @NullableDecl
        Spliterator<T> prefix;
        final /* synthetic */ Function val$function;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0000: IPUT 
          (r6 I:java.util.function.Function)
          (r0 I:com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CollectSpliterators$1FlatMapSpliterator)
         (LINE:1) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CollectSpliterators.1FlatMapSpliterator.val$function java.util.function.Function, block:B:1:0x0000 */
        public C1FlatMapSpliterator(Spliterator spliterator, Spliterator<T> spliterator2, Spliterator<F> spliterator3, int i, long j) {
            Function function;
            this.val$function = function;
            this.prefix = spliterator;
            this.from = spliterator2;
            this.characteristics = spliterator3;
            this.estimatedSize = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$forEachRemaining$1(Function function, Consumer consumer, Object obj) {
            Object apply;
            apply = function.apply(obj);
            Ioxxx.oIX0oI(apply).forEachRemaining(consumer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$tryAdvance$0(Function function, Object obj) {
            Object apply;
            apply = function.apply(obj);
            this.prefix = Ioxxx.oIX0oI(apply);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            long estimateSize;
            Spliterator<T> spliterator = this.prefix;
            if (spliterator != null) {
                long j = this.estimatedSize;
                estimateSize = spliterator.estimateSize();
                this.estimatedSize = Math.max(j, estimateSize);
            }
            return Math.max(this.estimatedSize, 0L);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator<T> spliterator = this.prefix;
            if (spliterator != null) {
                spliterator.forEachRemaining(consumer);
                this.prefix = null;
            }
            Spliterator<F> spliterator2 = this.from;
            final Function function = this.val$function;
            spliterator2.forEachRemaining(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xxIO
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    CollectSpliterators.C1FlatMapSpliterator.lambda$forEachRemaining$1(function, consumer, obj);
                }
            });
            this.estimatedSize = 0L;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            boolean tryAdvance;
            boolean tryAdvance2;
            do {
                Spliterator<T> spliterator = this.prefix;
                if (spliterator != null) {
                    tryAdvance2 = spliterator.tryAdvance(consumer);
                    if (tryAdvance2) {
                        long j = this.estimatedSize;
                        if (j != Long.MAX_VALUE) {
                            this.estimatedSize = j - 1;
                            return true;
                        }
                        return true;
                    }
                }
                this.prefix = null;
                Spliterator<F> spliterator2 = this.from;
                final Function function = this.val$function;
                tryAdvance = spliterator2.tryAdvance(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XX0xXo
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        CollectSpliterators.C1FlatMapSpliterator.this.lambda$tryAdvance$0(function, obj);
                    }
                });
            } while (tryAdvance);
            return false;
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator trySplit;
            trySplit = this.from.trySplit();
            if (trySplit != null) {
                int i = this.characteristics & (-65);
                long estimateSize = estimateSize();
                if (estimateSize < Long.MAX_VALUE) {
                    estimateSize /= 2;
                    this.estimatedSize -= estimateSize;
                    this.characteristics = i;
                }
                C1FlatMapSpliterator c1FlatMapSpliterator = new C1FlatMapSpliterator(this.prefix, trySplit, i, estimateSize, this.val$function);
                this.prefix = null;
                return c1FlatMapSpliterator;
            }
            Spliterator<T> spliterator = this.prefix;
            if (spliterator == null) {
                return null;
            }
            this.prefix = null;
            return spliterator;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CollectSpliterators$1Splitr, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class C1Splitr<T> implements Spliterator<T>, Consumer<T> {
        T holder = null;
        final /* synthetic */ Spliterator val$fromSpliterator;
        final /* synthetic */ Predicate val$predicate;

        public C1Splitr(Spliterator spliterator, Predicate predicate) {
            this.val$fromSpliterator = spliterator;
            this.val$predicate = predicate;
        }

        @Override // java.util.function.Consumer
        public void accept(T t) {
            this.holder = t;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            int characteristics;
            characteristics = this.val$fromSpliterator.characteristics();
            return characteristics & 277;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            long estimateSize;
            estimateSize = this.val$fromSpliterator.estimateSize();
            return estimateSize / 2;
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            Comparator<? super T> comparator;
            comparator = this.val$fromSpliterator.getComparator();
            return comparator;
        }

        /* JADX WARN: Incorrect condition in loop: B:2:0x0006 */
        @Override // java.util.Spliterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean tryAdvance(java.util.function.Consumer<? super T> r4) {
            /*
                r3 = this;
            L0:
                java.util.Spliterator r0 = r3.val$fromSpliterator
                boolean r0 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.x0xO.oIX0oI(r0, r3)
                if (r0 == 0) goto L24
                r0 = 0
                java.util.function.Predicate r1 = r3.val$predicate     // Catch: java.lang.Throwable -> L1c
                T r2 = r3.holder     // Catch: java.lang.Throwable -> L1c
                boolean r1 = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.cache.XO.oIX0oI(r1, r2)     // Catch: java.lang.Throwable -> L1c
                if (r1 == 0) goto L1e
                T r1 = r3.holder     // Catch: java.lang.Throwable -> L1c
                com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.I0oOIX.oIX0oI(r4, r1)     // Catch: java.lang.Throwable -> L1c
                r3.holder = r0
                r4 = 1
                return r4
            L1c:
                r4 = move-exception
                goto L21
            L1e:
                r3.holder = r0
                goto L0
            L21:
                r3.holder = r0
                throw r4
            L24:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CollectSpliterators.C1Splitr.tryAdvance(java.util.function.Consumer):boolean");
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator trySplit;
            trySplit = this.val$fromSpliterator.trySplit();
            if (trySplit == null) {
                return null;
            }
            return CollectSpliterators.filter(trySplit, this.val$predicate);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.CollectSpliterators$1WithCharacteristics, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class C1WithCharacteristics<T> implements Spliterator<T> {
        private final Spliterator.OfInt delegate;
        final /* synthetic */ Comparator val$comparator;
        final /* synthetic */ int val$extraCharacteristics;
        final /* synthetic */ IntFunction val$function;

        public C1WithCharacteristics(Spliterator.OfInt ofInt, IntFunction intFunction, int i, Comparator comparator) {
            this.val$function = intFunction;
            this.val$extraCharacteristics = i;
            this.val$comparator = comparator;
            this.delegate = ofInt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$forEachRemaining$1(Consumer consumer, IntFunction intFunction, int i) {
            Object apply;
            apply = intFunction.apply(i);
            consumer.accept(apply);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$tryAdvance$0(Consumer consumer, IntFunction intFunction, int i) {
            Object apply;
            apply = intFunction.apply(i);
            consumer.accept(apply);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.val$extraCharacteristics | 16464;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            long estimateSize;
            estimateSize = this.delegate.estimateSize();
            return estimateSize;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> consumer) {
            Spliterator.OfInt ofInt = this.delegate;
            final IntFunction intFunction = this.val$function;
            ofInt.forEachRemaining(new IntConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xoO0xx0
                @Override // java.util.function.IntConsumer
                public final void accept(int i) {
                    CollectSpliterators.C1WithCharacteristics.lambda$forEachRemaining$1(consumer, intFunction, i);
                }
            });
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return this.val$comparator;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(final Consumer<? super T> consumer) {
            boolean tryAdvance;
            Spliterator.OfInt ofInt = this.delegate;
            final IntFunction intFunction = this.val$function;
            tryAdvance = ofInt.tryAdvance(new IntConsumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ooOx
                @Override // java.util.function.IntConsumer
                public final void accept(int i) {
                    CollectSpliterators.C1WithCharacteristics.lambda$tryAdvance$0(consumer, intFunction, i);
                }
            });
            return tryAdvance;
        }

        @Override // java.util.Spliterator
        @NullableDecl
        public Spliterator<T> trySplit() {
            Spliterator.OfInt trySplit;
            trySplit = this.delegate.trySplit();
            if (trySplit == null) {
                return null;
            }
            return new C1WithCharacteristics(trySplit, this.val$function, this.val$extraCharacteristics, this.val$comparator);
        }
    }

    private CollectSpliterators() {
    }

    public static <T> Spliterator<T> filter(Spliterator<T> spliterator, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(spliterator);
        Preconditions.checkNotNull(predicate);
        return new C1Splitr(spliterator, predicate);
    }

    public static <F, T> Spliterator<T> flatMap(Spliterator<F> spliterator, Function<? super F, Spliterator<T>> function, int i, long j) {
        boolean z;
        boolean z2 = false;
        if ((i & 16384) == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "flatMap does not support SUBSIZED characteristic");
        if ((i & 4) == 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "flatMap does not support SORTED characteristic");
        Preconditions.checkNotNull(spliterator);
        Preconditions.checkNotNull(function);
        return new C1FlatMapSpliterator(null, spliterator, i, j, function);
    }

    public static <T> Spliterator<T> indexed(int i, int i2, IntFunction<T> intFunction) {
        return indexed(i, i2, intFunction, null);
    }

    public static <F, T> Spliterator<T> map(Spliterator<F> spliterator, Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(spliterator);
        Preconditions.checkNotNull(function);
        return new AnonymousClass1(spliterator, function);
    }

    public static <T> Spliterator<T> indexed(int i, int i2, IntFunction<T> intFunction, Comparator<? super T> comparator) {
        IntStream range;
        Spliterator.OfInt spliterator;
        if (comparator != null) {
            Preconditions.checkArgument((i2 & 4) != 0);
        }
        range = IntStream.range(0, i);
        spliterator = range.spliterator();
        return new C1WithCharacteristics(spliterator, intFunction, i2, comparator);
    }
}
