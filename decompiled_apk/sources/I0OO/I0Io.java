package I0OO;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;
import kotlin.sequences.ooOOo0oXI;

@xxIXOIIO(name = "StreamsKt")
/* loaded from: classes6.dex */
public final class I0Io {

    @XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n47#2:681\n*E\n"})
    /* renamed from: I0OO.I0Io$I0Io, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0001I0Io implements ooOOo0oXI<Long> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ LongStream f72oIX0oI;

        public C0001I0Io(LongStream longStream) {
            this.f72oIX0oI = longStream;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OOXIXo
        public Iterator<Long> iterator() {
            PrimitiveIterator.OfLong it;
            it = this.f72oIX0oI.iterator();
            IIX0o.oO(it, "iterator(...)");
            return it;
        }
    }

    @XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n39#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0 implements ooOOo0oXI<Integer> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ IntStream f73oIX0oI;

        public II0xO0(IntStream intStream) {
            this.f73oIX0oI = intStream;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OOXIXo
        public Iterator<Integer> iterator() {
            PrimitiveIterator.OfInt it;
            it = this.f73oIX0oI.iterator();
            IIX0o.oO(it, "iterator(...)");
            return it;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n31#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements ooOOo0oXI<T> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Stream f74oIX0oI;

        public oIX0oI(Stream stream) {
            this.f74oIX0oI = stream;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OOXIXo
        public Iterator<T> iterator() {
            Iterator<T> it;
            it = this.f74oIX0oI.iterator();
            IIX0o.oO(it, "iterator(...)");
            return it;
        }
    }

    @XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n55#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oxoX implements ooOOo0oXI<Double> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ DoubleStream f75oIX0oI;

        public oxoX(DoubleStream doubleStream) {
            this.f75oIX0oI = doubleStream;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OOXIXo
        public Iterator<Double> iterator() {
            PrimitiveIterator.OfDouble it;
            it = this.f75oIX0oI.iterator();
            IIX0o.oO(it, "iterator(...)");
            return it;
        }
    }

    @OOXIXo
    @oxxXoxO(version = "1.2")
    public static final ooOOo0oXI<Integer> I0Io(@OOXIXo IntStream intStream) {
        IIX0o.x0xO0oo(intStream, "<this>");
        return new II0xO0(intStream);
    }

    @OOXIXo
    @oxxXoxO(version = "1.2")
    public static final List<Double> II0XooXoX(@OOXIXo DoubleStream doubleStream) {
        double[] array;
        IIX0o.x0xO0oo(doubleStream, "<this>");
        array = doubleStream.toArray();
        IIX0o.oO(array, "toArray(...)");
        return kotlin.collections.ooOOo0oXI.x0xO0oo(array);
    }

    @OOXIXo
    @oxxXoxO(version = "1.2")
    public static final ooOOo0oXI<Double> II0xO0(@OOXIXo DoubleStream doubleStream) {
        IIX0o.x0xO0oo(doubleStream, "<this>");
        return new oxoX(doubleStream);
    }

    @OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <T> List<T> OOXIXo(@OOXIXo Stream<T> stream) {
        Collector list;
        Object collect;
        IIX0o.x0xO0oo(stream, "<this>");
        list = Collectors.toList();
        collect = stream.collect(list);
        IIX0o.oO(collect, "collect(...)");
        return (List) collect;
    }

    public static final Spliterator Oxx0IOOO(ooOOo0oXI this_asStream) {
        Spliterator spliteratorUnknownSize;
        IIX0o.x0xO0oo(this_asStream, "$this_asStream");
        spliteratorUnknownSize = Spliterators.spliteratorUnknownSize(this_asStream.iterator(), 16);
        return spliteratorUnknownSize;
    }

    @OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <T> ooOOo0oXI<T> X0o0xo(@OOXIXo Stream<T> stream) {
        IIX0o.x0xO0oo(stream, "<this>");
        return new oIX0oI(stream);
    }

    @OOXIXo
    @oxxXoxO(version = "1.2")
    public static final <T> Stream<T> XO(@OOXIXo final ooOOo0oXI<? extends T> ooooo0oxi) {
        Stream<T> stream;
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        stream = StreamSupport.stream(new Supplier() { // from class: I0OO.II0xO0
            @Override // java.util.function.Supplier
            public final Object get() {
                Spliterator Oxx0IOOO2;
                Oxx0IOOO2 = I0Io.Oxx0IOOO(ooOOo0oXI.this);
                return Oxx0IOOO2;
            }
        }, 16, false);
        IIX0o.oO(stream, "stream(...)");
        return stream;
    }

    @OOXIXo
    @oxxXoxO(version = "1.2")
    public static final ooOOo0oXI<Long> oxoX(@OOXIXo LongStream longStream) {
        IIX0o.x0xO0oo(longStream, "<this>");
        return new C0001I0Io(longStream);
    }

    @OOXIXo
    @oxxXoxO(version = "1.2")
    public static final List<Long> xoIox(@OOXIXo LongStream longStream) {
        long[] array;
        IIX0o.x0xO0oo(longStream, "<this>");
        array = longStream.toArray();
        IIX0o.oO(array, "toArray(...)");
        return kotlin.collections.ooOOo0oXI.Oxx0xo(array);
    }

    @OOXIXo
    @oxxXoxO(version = "1.2")
    public static final List<Integer> xxIXOIIO(@OOXIXo IntStream intStream) {
        int[] array;
        IIX0o.x0xO0oo(intStream, "<this>");
        array = intStream.toArray();
        IIX0o.oO(array, "toArray(...)");
        return kotlin.collections.ooOOo0oXI.IXxxXO(array);
    }
}
