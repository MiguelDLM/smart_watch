package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Preconditions;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math.LongMath;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Beta
@GwtCompatible
/* loaded from: classes10.dex */
public final class Streams {

    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$1OptionalState, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class C1OptionalState {
        boolean set = false;
        T value = null;

        public T get() {
            Preconditions.checkState(this.set);
            return this.value;
        }

        public void set(@NullableDecl T t) {
            this.set = true;
            this.value = t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$1Splitr, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class C1Splitr<R, T> extends MapWithIndexSpliterator<Spliterator<T>, R, C1Splitr> implements Consumer<T> {

        @NullableDecl
        T holder;
        final /* synthetic */ FunctionWithIndex val$function;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT 
          (r4 I:com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$FunctionWithIndex)
          (r0 I:com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$1Splitr)
         (LINE:1) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.1Splitr.val$function com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$FunctionWithIndex, block:B:1:0x0000 */
        public C1Splitr(Spliterator spliterator, Spliterator<T> spliterator2, long j) {
            super(spliterator, spliterator2);
            FunctionWithIndex functionWithIndex;
            this.val$function = functionWithIndex;
        }

        @Override // java.util.function.Consumer
        public void accept(@NullableDecl T t) {
            this.holder = t;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            boolean tryAdvance;
            tryAdvance = this.fromSpliterator.tryAdvance(this);
            if (tryAdvance) {
                try {
                    FunctionWithIndex functionWithIndex = this.val$function;
                    T t = this.holder;
                    long j = this.index;
                    this.index = 1 + j;
                    consumer.accept(functionWithIndex.apply(t, j));
                    this.holder = null;
                    return true;
                } catch (Throwable th) {
                    this.holder = null;
                    throw th;
                }
            }
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.MapWithIndexSpliterator
        public C1Splitr createSplit(Spliterator<T> spliterator, long j) {
            return new C1Splitr(spliterator, j, this.val$function);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$2Splitr, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class C2Splitr<R> extends MapWithIndexSpliterator<Spliterator.OfInt, R, C2Splitr> implements IntConsumer, Spliterator<R> {
        int holder;
        final /* synthetic */ IntFunctionWithIndex val$function;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT 
          (r4 I:com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$IntFunctionWithIndex)
          (r0 I:com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$2Splitr)
         (LINE:1) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.2Splitr.val$function com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$IntFunctionWithIndex, block:B:1:0x0000 */
        public C2Splitr(Spliterator.OfInt ofInt, Spliterator.OfInt ofInt2, long j) {
            super(ofInt, ofInt2);
            IntFunctionWithIndex intFunctionWithIndex;
            this.val$function = intFunctionWithIndex;
        }

        @Override // java.util.function.IntConsumer
        public void accept(int i) {
            this.holder = i;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.MapWithIndexSpliterator
        public /* bridge */ /* synthetic */ C2Splitr createSplit(Spliterator.OfInt ofInt, long j) {
            return createSplit2(xOIx00.oIX0oI(ofInt), j);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            boolean tryAdvance;
            tryAdvance = xOIx00.oIX0oI(this.fromSpliterator).tryAdvance((IntConsumer) this);
            if (tryAdvance) {
                IntFunctionWithIndex intFunctionWithIndex = this.val$function;
                int i = this.holder;
                long j = this.index;
                this.index = 1 + j;
                consumer.accept(intFunctionWithIndex.apply(i, j));
                return true;
            }
            return false;
        }

        /* renamed from: createSplit, reason: avoid collision after fix types in other method */
        public C2Splitr createSplit2(Spliterator.OfInt ofInt, long j) {
            return new C2Splitr(ofInt, j, this.val$function);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$3Splitr, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class C3Splitr<R> extends MapWithIndexSpliterator<Spliterator.OfLong, R, C3Splitr> implements LongConsumer, Spliterator<R> {
        long holder;
        final /* synthetic */ LongFunctionWithIndex val$function;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT 
          (r4 I:com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$LongFunctionWithIndex)
          (r0 I:com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$3Splitr)
         (LINE:1) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.3Splitr.val$function com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$LongFunctionWithIndex, block:B:1:0x0000 */
        public C3Splitr(Spliterator.OfLong ofLong, Spliterator.OfLong ofLong2, long j) {
            super(ofLong, ofLong2);
            LongFunctionWithIndex longFunctionWithIndex;
            this.val$function = longFunctionWithIndex;
        }

        @Override // java.util.function.LongConsumer
        public void accept(long j) {
            this.holder = j;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.MapWithIndexSpliterator
        public /* bridge */ /* synthetic */ C3Splitr createSplit(Spliterator.OfLong ofLong, long j) {
            return createSplit2(x0Io0.oIX0oI(ofLong), j);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            boolean tryAdvance;
            tryAdvance = x0Io0.oIX0oI(this.fromSpliterator).tryAdvance((LongConsumer) this);
            if (tryAdvance) {
                LongFunctionWithIndex longFunctionWithIndex = this.val$function;
                long j = this.holder;
                long j2 = this.index;
                this.index = 1 + j2;
                consumer.accept(longFunctionWithIndex.apply(j, j2));
                return true;
            }
            return false;
        }

        /* renamed from: createSplit, reason: avoid collision after fix types in other method */
        public C3Splitr createSplit2(Spliterator.OfLong ofLong, long j) {
            return new C3Splitr(ofLong, j, this.val$function);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$4Splitr, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class C4Splitr<R> extends MapWithIndexSpliterator<Spliterator.OfDouble, R, C4Splitr> implements DoubleConsumer, Spliterator<R> {
        double holder;
        final /* synthetic */ DoubleFunctionWithIndex val$function;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0000: IPUT 
          (r4 I:com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$DoubleFunctionWithIndex)
          (r0 I:com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$4Splitr)
         (LINE:1) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.4Splitr.val$function com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams$DoubleFunctionWithIndex, block:B:1:0x0000 */
        public C4Splitr(Spliterator.OfDouble ofDouble, Spliterator.OfDouble ofDouble2, long j) {
            super(ofDouble, ofDouble2);
            DoubleFunctionWithIndex doubleFunctionWithIndex;
            this.val$function = doubleFunctionWithIndex;
        }

        @Override // java.util.function.DoubleConsumer
        public void accept(double d) {
            this.holder = d;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.MapWithIndexSpliterator
        public /* bridge */ /* synthetic */ C4Splitr createSplit(Spliterator.OfDouble ofDouble, long j) {
            return createSplit2(O0o000XOX.oIX0oI(ofDouble), j);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super R> consumer) {
            boolean tryAdvance;
            tryAdvance = O0o000XOX.oIX0oI(this.fromSpliterator).tryAdvance((DoubleConsumer) this);
            if (tryAdvance) {
                DoubleFunctionWithIndex doubleFunctionWithIndex = this.val$function;
                double d = this.holder;
                long j = this.index;
                this.index = 1 + j;
                consumer.accept(doubleFunctionWithIndex.apply(d, j));
                return true;
            }
            return false;
        }

        /* renamed from: createSplit, reason: avoid collision after fix types in other method */
        public C4Splitr createSplit2(Spliterator.OfDouble ofDouble, long j) {
            return new C4Splitr(ofDouble, j, this.val$function);
        }
    }

    @Beta
    /* loaded from: classes10.dex */
    public interface DoubleFunctionWithIndex<R> {
        R apply(double d, long j);
    }

    @Beta
    /* loaded from: classes10.dex */
    public interface FunctionWithIndex<T, R> {
        R apply(T t, long j);
    }

    @Beta
    /* loaded from: classes10.dex */
    public interface IntFunctionWithIndex<R> {
        R apply(int i, long j);
    }

    @Beta
    /* loaded from: classes10.dex */
    public interface LongFunctionWithIndex<R> {
        R apply(long j, long j2);
    }

    /* loaded from: classes10.dex */
    public static abstract class MapWithIndexSpliterator<F extends Spliterator<?>, R, S extends MapWithIndexSpliterator<F, R, S>> implements Spliterator<R> {
        final F fromSpliterator;
        long index;

        public MapWithIndexSpliterator(F f, long j) {
            this.fromSpliterator = f;
            this.index = j;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            int characteristics;
            characteristics = this.fromSpliterator.characteristics();
            return characteristics & 16464;
        }

        public abstract S createSplit(F f, long j);

        @Override // java.util.Spliterator
        public long estimateSize() {
            long estimateSize;
            estimateSize = this.fromSpliterator.estimateSize();
            return estimateSize;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Spliterator
        public S trySplit() {
            Spliterator trySplit;
            long exactSizeIfKnown;
            trySplit = this.fromSpliterator.trySplit();
            if (trySplit == null) {
                return null;
            }
            S s = (S) createSplit(trySplit, this.index);
            long j = this.index;
            exactSizeIfKnown = trySplit.getExactSizeIfKnown();
            this.index = j + exactSizeIfKnown;
            return s;
        }
    }

    /* loaded from: classes10.dex */
    public static class TemporaryPair<A, B> {

        /* renamed from: a, reason: collision with root package name */
        final A f16985a;
        final B b;

        public TemporaryPair(A a2, B b) {
            this.f16985a = a2;
            this.b = b;
        }
    }

    private Streams() {
    }

    @SafeVarargs
    public static <T> Stream<T> concat(final Stream<? extends T>... streamArr) {
        Stream stream;
        BaseStream onClose;
        boolean isParallel;
        Spliterator spliterator;
        int characteristics;
        long estimateSize;
        ImmutableList.Builder builder = new ImmutableList.Builder(streamArr.length);
        long j = 0;
        boolean z = false;
        int i = 336;
        for (Stream<? extends T> stream2 : streamArr) {
            isParallel = stream2.isParallel();
            z |= isParallel;
            spliterator = stream2.spliterator();
            builder.add((ImmutableList.Builder) spliterator);
            characteristics = spliterator.characteristics();
            i &= characteristics;
            estimateSize = spliterator.estimateSize();
            j = LongMath.saturatedAdd(j, estimateSize);
        }
        stream = StreamSupport.stream(CollectSpliterators.flatMap(builder.build().spliterator(), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.I0O00OI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Spliterator lambda$concat$0;
                lambda$concat$0 = Streams.lambda$concat$0((Spliterator) obj);
                return lambda$concat$0;
            }
        }, i, j), z);
        onClose = stream.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IxOXOxO
            @Override // java.lang.Runnable
            public final void run() {
                Streams.lambda$concat$1(streamArr);
            }
        });
        return Ix00oIoI.oIX0oI(onClose);
    }

    public static <T> Optional<T> findLast(Stream<T> stream) {
        Spliterator spliterator;
        Optional<T> empty;
        long exactSizeIfKnown;
        boolean hasCharacteristics;
        Spliterator trySplit;
        Optional<T> of;
        long exactSizeIfKnown2;
        long exactSizeIfKnown3;
        Spliterator trySplit2;
        Optional<T> of2;
        long exactSizeIfKnown4;
        final C1OptionalState c1OptionalState = new C1OptionalState();
        ArrayDeque arrayDeque = new ArrayDeque();
        spliterator = stream.spliterator();
        arrayDeque.addLast(spliterator);
        while (!arrayDeque.isEmpty()) {
            Spliterator oIX0oI2 = Ioxxx.oIX0oI(arrayDeque.removeLast());
            exactSizeIfKnown = oIX0oI2.getExactSizeIfKnown();
            if (exactSizeIfKnown != 0) {
                hasCharacteristics = oIX0oI2.hasCharacteristics(16384);
                if (hasCharacteristics) {
                    while (true) {
                        trySplit = oIX0oI2.trySplit();
                        if (trySplit == null) {
                            break;
                        }
                        exactSizeIfKnown2 = trySplit.getExactSizeIfKnown();
                        if (exactSizeIfKnown2 == 0) {
                            break;
                        }
                        exactSizeIfKnown3 = oIX0oI2.getExactSizeIfKnown();
                        if (exactSizeIfKnown3 == 0) {
                            oIX0oI2 = trySplit;
                            break;
                        }
                    }
                    oIX0oI2.forEachRemaining(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IIXOxIxOo
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            Streams.C1OptionalState.this.set(obj);
                        }
                    });
                    of = Optional.of(c1OptionalState.get());
                    return of;
                }
                trySplit2 = oIX0oI2.trySplit();
                if (trySplit2 != null) {
                    exactSizeIfKnown4 = trySplit2.getExactSizeIfKnown();
                    if (exactSizeIfKnown4 != 0) {
                        arrayDeque.addLast(trySplit2);
                        arrayDeque.addLast(oIX0oI2);
                    }
                }
                oIX0oI2.forEachRemaining(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IIXOxIxOo
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        Streams.C1OptionalState.this.set(obj);
                    }
                });
                if (c1OptionalState.set) {
                    of2 = Optional.of(c1OptionalState.get());
                    return of2;
                }
            }
        }
        empty = Optional.empty();
        return empty;
    }

    public static <A, B> void forEachPair(Stream<A> stream, Stream<B> stream2, final BiConsumer<? super A, ? super B> biConsumer) {
        boolean isParallel;
        boolean isParallel2;
        Iterator it;
        Iterator it2;
        Preconditions.checkNotNull(biConsumer);
        isParallel = stream.isParallel();
        if (!isParallel) {
            isParallel2 = stream2.isParallel();
            if (!isParallel2) {
                it = stream.iterator();
                it2 = stream2.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    biConsumer.accept(it.next(), it2.next());
                }
                return;
            }
        }
        zip(stream, stream2, new BiFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.O0OoXI
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return new Streams.TemporaryPair(obj, obj2);
            }
        }).forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oIoxI0xx
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Streams.lambda$forEachPair$5(biConsumer, (Streams.TemporaryPair) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator lambda$concat$0(Spliterator spliterator) {
        return spliterator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$concat$1(Stream[] streamArr) {
        for (Stream stream : streamArr) {
            stream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IntStream lambda$concat$2(IntStream intStream) {
        return intStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LongStream lambda$concat$3(LongStream longStream) {
        return longStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DoubleStream lambda$concat$4(DoubleStream doubleStream) {
        return doubleStream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$forEachPair$5(BiConsumer biConsumer, TemporaryPair temporaryPair) {
        biConsumer.accept(temporaryPair.f16985a, temporaryPair.b);
    }

    public static <T, R> Stream<R> mapWithIndex(final Stream<T> stream, final FunctionWithIndex<? super T, ? extends R> functionWithIndex) {
        boolean isParallel;
        Spliterator spliterator;
        boolean hasCharacteristics;
        Stream stream2;
        BaseStream onClose;
        final Iterator it;
        long estimateSize;
        int characteristics;
        Stream stream3;
        BaseStream onClose2;
        Preconditions.checkNotNull(stream);
        Preconditions.checkNotNull(functionWithIndex);
        isParallel = stream.isParallel();
        spliterator = stream.spliterator();
        hasCharacteristics = spliterator.hasCharacteristics(16384);
        if (!hasCharacteristics) {
            it = Spliterators.iterator(spliterator);
            estimateSize = spliterator.estimateSize();
            characteristics = spliterator.characteristics();
            stream3 = StreamSupport.stream(new Spliterators.AbstractSpliterator<R>(estimateSize, characteristics & 80) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.2
                long index = 0;

                @Override // java.util.Spliterator
                public boolean tryAdvance(Consumer<? super R> consumer) {
                    if (it.hasNext()) {
                        FunctionWithIndex functionWithIndex2 = functionWithIndex;
                        Object next = it.next();
                        long j = this.index;
                        this.index = 1 + j;
                        consumer.accept(functionWithIndex2.apply(next, j));
                        return true;
                    }
                    return false;
                }
            }, isParallel);
            stream.getClass();
            onClose2 = stream3.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.XoIoOXOIx
                @Override // java.lang.Runnable
                public final void run() {
                    stream.close();
                }
            });
            return Ix00oIoI.oIX0oI(onClose2);
        }
        stream2 = StreamSupport.stream(new C1Splitr(spliterator, 0L, functionWithIndex), isParallel);
        stream.getClass();
        onClose = stream2.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oOxxXI
            @Override // java.lang.Runnable
            public final void run() {
                stream.close();
            }
        });
        return Ix00oIoI.oIX0oI(onClose);
    }

    public static <T> Stream<T> stream(Iterable<T> iterable) {
        Spliterator spliterator;
        Stream<T> stream;
        Stream<T> stream2;
        if (iterable instanceof Collection) {
            stream2 = ((Collection) iterable).stream();
            return stream2;
        }
        spliterator = iterable.spliterator();
        stream = StreamSupport.stream(spliterator, false);
        return stream;
    }

    public static <A, B, R> Stream<R> zip(final Stream<A> stream, final Stream<B> stream2, final BiFunction<? super A, ? super B, R> biFunction) {
        boolean isParallel;
        boolean z;
        Spliterator spliterator;
        Spliterator spliterator2;
        int characteristics;
        int characteristics2;
        final Iterator it;
        final Iterator it2;
        long estimateSize;
        long estimateSize2;
        Stream stream3;
        BaseStream onClose;
        BaseStream onClose2;
        boolean isParallel2;
        Preconditions.checkNotNull(stream);
        Preconditions.checkNotNull(stream2);
        Preconditions.checkNotNull(biFunction);
        isParallel = stream.isParallel();
        if (!isParallel) {
            isParallel2 = stream2.isParallel();
            if (!isParallel2) {
                z = false;
                spliterator = stream.spliterator();
                spliterator2 = stream2.spliterator();
                characteristics = spliterator.characteristics();
                characteristics2 = spliterator2.characteristics();
                int i = characteristics & characteristics2 & 80;
                it = Spliterators.iterator(spliterator);
                it2 = Spliterators.iterator(spliterator2);
                estimateSize = spliterator.estimateSize();
                estimateSize2 = spliterator2.estimateSize();
                stream3 = StreamSupport.stream(new Spliterators.AbstractSpliterator<R>(Math.min(estimateSize, estimateSize2), i) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.1
                    @Override // java.util.Spliterator
                    public boolean tryAdvance(Consumer<? super R> consumer) {
                        Object apply;
                        if (it.hasNext() && it2.hasNext()) {
                            apply = biFunction.apply(it.next(), it2.next());
                            consumer.accept(apply);
                            return true;
                        }
                        return false;
                    }
                }, z);
                stream.getClass();
                onClose = stream3.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Oo0xX
                    @Override // java.lang.Runnable
                    public final void run() {
                        stream.close();
                    }
                });
                Stream oIX0oI2 = Ix00oIoI.oIX0oI(onClose);
                stream2.getClass();
                onClose2 = oIX0oI2.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xxoXO
                    @Override // java.lang.Runnable
                    public final void run() {
                        stream2.close();
                    }
                });
                return Ix00oIoI.oIX0oI(onClose2);
            }
        }
        z = true;
        spliterator = stream.spliterator();
        spliterator2 = stream2.spliterator();
        characteristics = spliterator.characteristics();
        characteristics2 = spliterator2.characteristics();
        int i2 = characteristics & characteristics2 & 80;
        it = Spliterators.iterator(spliterator);
        it2 = Spliterators.iterator(spliterator2);
        estimateSize = spliterator.estimateSize();
        estimateSize2 = spliterator2.estimateSize();
        stream3 = StreamSupport.stream(new Spliterators.AbstractSpliterator<R>(Math.min(estimateSize, estimateSize2), i2) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.1
            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super R> consumer) {
                Object apply;
                if (it.hasNext() && it2.hasNext()) {
                    apply = biFunction.apply(it.next(), it2.next());
                    consumer.accept(apply);
                    return true;
                }
                return false;
            }
        }, z);
        stream.getClass();
        onClose = stream3.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Oo0xX
            @Override // java.lang.Runnable
            public final void run() {
                stream.close();
            }
        });
        Stream oIX0oI22 = Ix00oIoI.oIX0oI(onClose);
        stream2.getClass();
        onClose2 = oIX0oI22.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xxoXO
            @Override // java.lang.Runnable
            public final void run() {
                stream2.close();
            }
        });
        return Ix00oIoI.oIX0oI(onClose2);
    }

    @Deprecated
    public static <T> Stream<T> stream(Collection<T> collection) {
        Stream<T> stream;
        stream = collection.stream();
        return stream;
    }

    public static <T> Stream<T> stream(Iterator<T> it) {
        Spliterator spliteratorUnknownSize;
        Stream<T> stream;
        spliteratorUnknownSize = Spliterators.spliteratorUnknownSize(it, 0);
        stream = StreamSupport.stream(spliteratorUnknownSize, false);
        return stream;
    }

    public static <T> Stream<T> stream(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional<T> optional) {
        Stream<T> of;
        Stream<T> of2;
        if (optional.isPresent()) {
            of2 = Stream.of(optional.get());
            return of2;
        }
        of = Stream.of(new Object[0]);
        return of;
    }

    public static <T> Stream<T> stream(Optional<T> optional) {
        boolean isPresent;
        Stream<T> of;
        Object obj;
        Stream<T> of2;
        isPresent = optional.isPresent();
        if (isPresent) {
            obj = optional.get();
            of2 = Stream.of(obj);
            return of2;
        }
        of = Stream.of(new Object[0]);
        return of;
    }

    public static IntStream stream(OptionalInt optionalInt) {
        boolean isPresent;
        IntStream empty;
        int asInt;
        IntStream of;
        isPresent = optionalInt.isPresent();
        if (isPresent) {
            asInt = optionalInt.getAsInt();
            of = IntStream.of(asInt);
            return of;
        }
        empty = IntStream.empty();
        return empty;
    }

    public static LongStream stream(OptionalLong optionalLong) {
        boolean isPresent;
        LongStream empty;
        long asLong;
        LongStream of;
        isPresent = optionalLong.isPresent();
        if (isPresent) {
            asLong = optionalLong.getAsLong();
            of = LongStream.of(asLong);
            return of;
        }
        empty = LongStream.empty();
        return empty;
    }

    public static DoubleStream stream(OptionalDouble optionalDouble) {
        boolean isPresent;
        DoubleStream empty;
        double asDouble;
        DoubleStream of;
        isPresent = optionalDouble.isPresent();
        if (isPresent) {
            asDouble = optionalDouble.getAsDouble();
            of = DoubleStream.of(asDouble);
            return of;
        }
        empty = DoubleStream.empty();
        return empty;
    }

    public static IntStream concat(IntStream... intStreamArr) {
        Stream of;
        IntStream flatMapToInt;
        of = Stream.of((Object[]) intStreamArr);
        flatMapToInt = of.flatMapToInt(new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xx0O
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                IntStream lambda$concat$2;
                lambda$concat$2 = Streams.lambda$concat$2((IntStream) obj);
                return lambda$concat$2;
            }
        });
        return flatMapToInt;
    }

    public static LongStream concat(LongStream... longStreamArr) {
        Stream of;
        LongStream flatMapToLong;
        of = Stream.of((Object[]) longStreamArr);
        flatMapToLong = of.flatMapToLong(new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xXXxoI
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                LongStream lambda$concat$3;
                lambda$concat$3 = Streams.lambda$concat$3((LongStream) obj);
                return lambda$concat$3;
            }
        });
        return flatMapToLong;
    }

    public static <R> Stream<R> mapWithIndex(final IntStream intStream, final IntFunctionWithIndex<R> intFunctionWithIndex) {
        boolean isParallel;
        Spliterator.OfInt spliterator;
        boolean hasCharacteristics;
        Stream stream;
        BaseStream onClose;
        final PrimitiveIterator.OfInt it;
        long estimateSize;
        int characteristics;
        Stream stream2;
        BaseStream onClose2;
        Preconditions.checkNotNull(intStream);
        Preconditions.checkNotNull(intFunctionWithIndex);
        isParallel = intStream.isParallel();
        spliterator = intStream.spliterator();
        hasCharacteristics = spliterator.hasCharacteristics(16384);
        if (!hasCharacteristics) {
            it = Spliterators.iterator(spliterator);
            estimateSize = spliterator.estimateSize();
            characteristics = spliterator.characteristics();
            stream2 = StreamSupport.stream(new Spliterators.AbstractSpliterator<R>(estimateSize, characteristics & 80) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.3
                long index = 0;

                @Override // java.util.Spliterator
                public boolean tryAdvance(Consumer<? super R> consumer) {
                    boolean hasNext;
                    int nextInt;
                    hasNext = it.hasNext();
                    if (hasNext) {
                        IntFunctionWithIndex intFunctionWithIndex2 = intFunctionWithIndex;
                        nextInt = it.nextInt();
                        long j = this.index;
                        this.index = 1 + j;
                        consumer.accept(intFunctionWithIndex2.apply(nextInt, j));
                        return true;
                    }
                    return false;
                }
            }, isParallel);
            intStream.getClass();
            onClose2 = stream2.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.OoxxX
                @Override // java.lang.Runnable
                public final void run() {
                    intStream.close();
                }
            });
            return Ix00oIoI.oIX0oI(onClose2);
        }
        stream = StreamSupport.stream(new C2Splitr(spliterator, 0L, intFunctionWithIndex), isParallel);
        intStream.getClass();
        onClose = stream.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oIxxIo
            @Override // java.lang.Runnable
            public final void run() {
                intStream.close();
            }
        });
        return Ix00oIoI.oIX0oI(onClose);
    }

    public static DoubleStream concat(DoubleStream... doubleStreamArr) {
        Stream of;
        DoubleStream flatMapToDouble;
        of = Stream.of((Object[]) doubleStreamArr);
        flatMapToDouble = of.flatMapToDouble(new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.OXOo
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DoubleStream lambda$concat$4;
                lambda$concat$4 = Streams.lambda$concat$4((DoubleStream) obj);
                return lambda$concat$4;
            }
        });
        return flatMapToDouble;
    }

    public static OptionalInt findLast(IntStream intStream) {
        Stream boxed;
        boolean isPresent;
        OptionalInt empty;
        Object obj;
        OptionalInt of;
        boxed = intStream.boxed();
        Optional findLast = findLast(boxed);
        isPresent = findLast.isPresent();
        if (isPresent) {
            obj = findLast.get();
            of = OptionalInt.of(((Integer) obj).intValue());
            return of;
        }
        empty = OptionalInt.empty();
        return empty;
    }

    public static OptionalLong findLast(LongStream longStream) {
        Stream boxed;
        boolean isPresent;
        OptionalLong empty;
        Object obj;
        OptionalLong of;
        boxed = longStream.boxed();
        Optional findLast = findLast(boxed);
        isPresent = findLast.isPresent();
        if (isPresent) {
            obj = findLast.get();
            of = OptionalLong.of(((Long) obj).longValue());
            return of;
        }
        empty = OptionalLong.empty();
        return empty;
    }

    public static OptionalDouble findLast(DoubleStream doubleStream) {
        Stream boxed;
        boolean isPresent;
        OptionalDouble empty;
        Object obj;
        OptionalDouble of;
        boxed = doubleStream.boxed();
        Optional findLast = findLast(boxed);
        isPresent = findLast.isPresent();
        if (isPresent) {
            obj = findLast.get();
            of = OptionalDouble.of(((Double) obj).doubleValue());
            return of;
        }
        empty = OptionalDouble.empty();
        return empty;
    }

    public static <R> Stream<R> mapWithIndex(final LongStream longStream, final LongFunctionWithIndex<R> longFunctionWithIndex) {
        boolean isParallel;
        Spliterator.OfLong spliterator;
        boolean hasCharacteristics;
        Stream stream;
        BaseStream onClose;
        final PrimitiveIterator.OfLong it;
        long estimateSize;
        int characteristics;
        Stream stream2;
        BaseStream onClose2;
        Preconditions.checkNotNull(longStream);
        Preconditions.checkNotNull(longFunctionWithIndex);
        isParallel = longStream.isParallel();
        spliterator = longStream.spliterator();
        hasCharacteristics = spliterator.hasCharacteristics(16384);
        if (!hasCharacteristics) {
            it = Spliterators.iterator(spliterator);
            estimateSize = spliterator.estimateSize();
            characteristics = spliterator.characteristics();
            stream2 = StreamSupport.stream(new Spliterators.AbstractSpliterator<R>(estimateSize, characteristics & 80) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.4
                long index = 0;

                @Override // java.util.Spliterator
                public boolean tryAdvance(Consumer<? super R> consumer) {
                    boolean hasNext;
                    long nextLong;
                    hasNext = it.hasNext();
                    if (hasNext) {
                        LongFunctionWithIndex longFunctionWithIndex2 = longFunctionWithIndex;
                        nextLong = it.nextLong();
                        long j = this.index;
                        this.index = 1 + j;
                        consumer.accept(longFunctionWithIndex2.apply(nextLong, j));
                        return true;
                    }
                    return false;
                }
            }, isParallel);
            longStream.getClass();
            onClose2 = stream2.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.xOIO
                @Override // java.lang.Runnable
                public final void run() {
                    longStream.close();
                }
            });
            return Ix00oIoI.oIX0oI(onClose2);
        }
        stream = StreamSupport.stream(new C3Splitr(spliterator, 0L, longFunctionWithIndex), isParallel);
        longStream.getClass();
        onClose = stream.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.oIxOXo
            @Override // java.lang.Runnable
            public final void run() {
                longStream.close();
            }
        });
        return Ix00oIoI.oIX0oI(onClose);
    }

    public static <R> Stream<R> mapWithIndex(final DoubleStream doubleStream, final DoubleFunctionWithIndex<R> doubleFunctionWithIndex) {
        boolean isParallel;
        Spliterator.OfDouble spliterator;
        boolean hasCharacteristics;
        Stream stream;
        BaseStream onClose;
        final PrimitiveIterator.OfDouble it;
        long estimateSize;
        int characteristics;
        Stream stream2;
        BaseStream onClose2;
        Preconditions.checkNotNull(doubleStream);
        Preconditions.checkNotNull(doubleFunctionWithIndex);
        isParallel = doubleStream.isParallel();
        spliterator = doubleStream.spliterator();
        hasCharacteristics = spliterator.hasCharacteristics(16384);
        if (!hasCharacteristics) {
            it = Spliterators.iterator(spliterator);
            estimateSize = spliterator.estimateSize();
            characteristics = spliterator.characteristics();
            stream2 = StreamSupport.stream(new Spliterators.AbstractSpliterator<R>(estimateSize, characteristics & 80) { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Streams.5
                long index = 0;

                @Override // java.util.Spliterator
                public boolean tryAdvance(Consumer<? super R> consumer) {
                    boolean hasNext;
                    double nextDouble;
                    hasNext = it.hasNext();
                    if (hasNext) {
                        DoubleFunctionWithIndex doubleFunctionWithIndex2 = doubleFunctionWithIndex;
                        nextDouble = it.nextDouble();
                        long j = this.index;
                        this.index = 1 + j;
                        consumer.accept(doubleFunctionWithIndex2.apply(nextDouble, j));
                        return true;
                    }
                    return false;
                }
            }, isParallel);
            doubleStream.getClass();
            onClose2 = stream2.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Oo0IXI0
                @Override // java.lang.Runnable
                public final void run() {
                    doubleStream.close();
                }
            });
            return Ix00oIoI.oIX0oI(onClose2);
        }
        stream = StreamSupport.stream(new C4Splitr(spliterator, 0L, doubleFunctionWithIndex), isParallel);
        doubleStream.getClass();
        onClose = stream.onClose(new Runnable() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IXIIo
            @Override // java.lang.Runnable
            public final void run() {
                doubleStream.close();
            }
        });
        return Ix00oIoI.oIX0oI(onClose);
    }
}
