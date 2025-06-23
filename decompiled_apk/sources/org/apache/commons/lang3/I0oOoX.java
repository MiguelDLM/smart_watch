package org.apache.commons.lang3;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;
import org.apache.commons.lang3.I0oOoX;
import org.apache.commons.lang3.IoOoX;

@Deprecated
/* loaded from: classes6.dex */
public class I0oOoX {

    @Deprecated
    /* loaded from: classes6.dex */
    public static class II0xO0<O> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public boolean f32484II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public Stream<O> f32485oIX0oI;

        public II0xO0(Stream<O> stream) {
            this.f32485oIX0oI = stream;
        }

        public void I0Io() {
            if (!this.f32484II0xO0) {
            } else {
                throw new IllegalStateException("This stream is already terminated.");
            }
        }

        public void II0XooXoX() {
            I0Io();
            this.f32484II0xO0 = true;
        }

        public boolean II0xO0(IoOoX.Oxx0IOOO<O, ?> oxx0IOOO) {
            boolean anyMatch;
            I0Io();
            anyMatch = OOXIXo().anyMatch(IoOoX.O0xOxO(oxx0IOOO));
            return anyMatch;
        }

        public Stream<O> OOXIXo() {
            return this.f32485oIX0oI;
        }

        public void Oxx0IOOO(IoOoX.X0o0xo<O, ?> x0o0xo) {
            II0XooXoX();
            OOXIXo().forEach(IoOoX.o00(x0o0xo));
        }

        public <A, R> R X0o0xo(Collector<? super O, A, R> collector) {
            Object collect;
            II0XooXoX();
            collect = OOXIXo().collect(collector);
            return (R) collect;
        }

        public II0xO0<O> XO(IoOoX.Oxx0IOOO<O, ?> oxx0IOOO) {
            Stream<O> filter;
            I0Io();
            filter = this.f32485oIX0oI.filter(IoOoX.O0xOxO(oxx0IOOO));
            this.f32485oIX0oI = filter;
            return this;
        }

        public boolean oIX0oI(IoOoX.Oxx0IOOO<O, ?> oxx0IOOO) {
            boolean allMatch;
            I0Io();
            allMatch = OOXIXo().allMatch(IoOoX.O0xOxO(oxx0IOOO));
            return allMatch;
        }

        public <A, R> R oxoX(Supplier<R> supplier, BiConsumer<R, ? super O> biConsumer, BiConsumer<R, R> biConsumer2) {
            Object collect;
            II0XooXoX();
            collect = OOXIXo().collect(supplier, biConsumer, biConsumer2);
            return (R) collect;
        }

        public O xoIox(O o, BinaryOperator<O> binaryOperator) {
            Object reduce;
            II0XooXoX();
            reduce = OOXIXo().reduce(o, binaryOperator);
            return (O) reduce;
        }

        public <R> II0xO0<R> xxIXOIIO(IoOoX.XO<O, R, ?> xo2) {
            Stream map;
            I0Io();
            map = this.f32485oIX0oI.map(IoOoX.OxI(xo2));
            return new II0xO0<>(map);
        }
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public static class oIX0oI<O> implements Collector<O, List<O>, O[]> {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final Set<Collector.Characteristics> f32486II0xO0 = Collections.emptySet();

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final Class<O> f32487oIX0oI;

        public oIX0oI(Class<O> cls) {
            this.f32487oIX0oI = cls;
        }

        public static /* synthetic */ List I0Io(List list, List list2) {
            list.addAll(list2);
            return list;
        }

        @Override // java.util.stream.Collector
        public BiConsumer<List<O>, O> accumulator() {
            return new o0();
        }

        @Override // java.util.stream.Collector
        public Set<Collector.Characteristics> characteristics() {
            return f32486II0xO0;
        }

        @Override // java.util.stream.Collector
        public BinaryOperator<List<O>> combiner() {
            return new BinaryOperator() { // from class: org.apache.commons.lang3.OI0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    List I0Io2;
                    I0Io2 = I0oOoX.oIX0oI.I0Io((List) obj, (List) obj2);
                    return I0Io2;
                }
            };
        }

        @Override // java.util.stream.Collector
        public Function<List<O>, O[]> finisher() {
            return new Function() { // from class: org.apache.commons.lang3.XOxIOxOx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Object[] oxoX2;
                    oxoX2 = I0oOoX.oIX0oI.this.oxoX((List) obj);
                    return oxoX2;
                }
            };
        }

        public final /* synthetic */ Object[] oxoX(List list) {
            return list.toArray((Object[]) Array.newInstance((Class<?>) this.f32487oIX0oI, list.size()));
        }

        @Override // java.util.stream.Collector
        public Supplier<List<O>> supplier() {
            return new XX();
        }
    }

    public static <O> Collector<O, ?, O[]> I0Io(Class<O> cls) {
        return new oIX0oI(cls);
    }

    public static <O> II0xO0<O> II0xO0(Stream<O> stream) {
        return new II0xO0<>(stream);
    }

    public static <O> II0xO0<O> oIX0oI(Collection<O> collection) {
        Stream stream;
        stream = collection.stream();
        return II0xO0(stream);
    }
}
