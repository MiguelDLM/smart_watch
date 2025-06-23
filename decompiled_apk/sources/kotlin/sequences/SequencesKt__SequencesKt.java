package kotlin.sequences;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;
import kotlin.random.Random;

/* loaded from: classes6.dex */
public class SequencesKt__SequencesKt extends Oxx0xo {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt\n*L\n1#1,680:1\n30#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0<T> implements ooOOo0oXI<T> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Iterator f29443oIX0oI;

        public II0xO0(Iterator it) {
            this.f29443oIX0oI = it;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<T> iterator() {
            return this.f29443oIX0oI;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n*L\n1#1,680:1\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements ooOOo0oXI<T> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ Oox.oIX0oI<Iterator<T>> f29444oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(Oox.oIX0oI<? extends Iterator<? extends T>> oix0oi) {
            this.f29444oIX0oI = oix0oi;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<T> iterator() {
            return this.f29444oIX0oI.invoke();
        }
    }

    @OXOo.OOXIXo
    public static final <T, C, R> ooOOo0oXI<R> II0XooXoX(@OXOo.OOXIXo ooOOo0oXI<? extends T> source, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends C> transform, @OXOo.OOXIXo Oox.oOoXoXO<? super C, ? extends Iterator<? extends R>> iterator) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(transform, "transform");
        IIX0o.x0xO0oo(iterator, "iterator");
        return IXxxXO.II0xO0(new SequencesKt__SequencesKt$flatMapIndexed$1(source, transform, iterator, null));
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> ooOOo0oXI<T> IXxxXO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return Oxx0xo(ooooo0oxi, Random.Default);
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "flattenSequenceOfIterable")
    public static final <T> ooOOo0oXI<T> OOXIXo(@OXOo.OOXIXo ooOOo0oXI<? extends Iterable<? extends T>> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return xoIox(ooooo0oxi, new Oox.oOoXoXO<Iterable<? extends T>, Iterator<? extends T>>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$2
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Iterator<T> invoke(@OXOo.OOXIXo Iterable<? extends T> it) {
                IIX0o.x0xO0oo(it, "it");
                return it.iterator();
            }
        });
    }

    @OXOo.OOXIXo
    public static <T> ooOOo0oXI<T> Oo(@OXOo.OOXIXo T... elements) {
        IIX0o.x0xO0oo(elements, "elements");
        if (elements.length == 0) {
            return Oxx0IOOO();
        }
        return ArraysKt___ArraysKt.oxXIOXO(elements);
    }

    @OXOo.OOXIXo
    public static <T> ooOOo0oXI<T> Oxx0IOOO() {
        return Oxx0IOOO.f29438oIX0oI;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final <T> ooOOo0oXI<T> Oxx0xo(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(random, "random");
        return IXxxXO.II0xO0(new SequencesKt__SequencesKt$shuffled$1(ooooo0oxi, random, null));
    }

    @OXOo.OOXIXo
    public static <T> ooOOo0oXI<T> X0o0xo(@OXOo.OOXIXo Iterator<? extends T> it) {
        IIX0o.x0xO0oo(it, "<this>");
        return XO(new II0xO0(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public static <T> ooOOo0oXI<T> XO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        if (!(ooooo0oxi instanceof kotlin.sequences.oIX0oI)) {
            return new kotlin.sequences.oIX0oI(ooooo0oxi);
        }
        return ooooo0oxi;
    }

    @OXOo.OOXIXo
    public static final <T, R> Pair<List<T>, List<R>> oI0IIXIo(@OXOo.OOXIXo ooOOo0oXI<? extends Pair<? extends T, ? extends R>> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair<? extends T, ? extends R> pair : ooooo0oxi) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return Xo0.oIX0oI(arrayList, arrayList2);
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.3")
    public static final <T> ooOOo0oXI<T> oO(@OXOo.OOXIXo ooOOo0oXI<? extends T> ooooo0oxi, @OXOo.OOXIXo Oox.oIX0oI<? extends ooOOo0oXI<? extends T>> defaultValue) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        return IXxxXO.II0xO0(new SequencesKt__SequencesKt$ifEmpty$1(ooooo0oxi, defaultValue, null));
    }

    @OXOo.OOXIXo
    public static <T> ooOOo0oXI<T> oOoXoXO(@OXOo.OOXIXo final Oox.oIX0oI<? extends T> nextFunction) {
        IIX0o.x0xO0oo(nextFunction, "nextFunction");
        return XO(new xoIox(nextFunction, new Oox.oOoXoXO<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            @OXOo.oOoXoXO
            public final T invoke(@OXOo.OOXIXo T it) {
                IIX0o.x0xO0oo(it, "it");
                return nextFunction.invoke();
            }
        }));
    }

    @OXOo.OOXIXo
    public static <T> ooOOo0oXI<T> ooOOo0oXI(@OXOo.OOXIXo Oox.oIX0oI<? extends T> seedFunction, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends T> nextFunction) {
        IIX0o.x0xO0oo(seedFunction, "seedFunction");
        IIX0o.x0xO0oo(nextFunction, "nextFunction");
        return new xoIox(seedFunction, nextFunction);
    }

    @xx0o0O.XO
    public static final <T> ooOOo0oXI<T> oxoX(Oox.oIX0oI<? extends Iterator<? extends T>> iterator) {
        IIX0o.x0xO0oo(iterator, "iterator");
        return new oIX0oI(iterator);
    }

    @xx0o0O.II0XooXoX
    @OXOo.OOXIXo
    public static <T> ooOOo0oXI<T> x0XOIxOo(@OXOo.oOoXoXO final T t, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends T> nextFunction) {
        IIX0o.x0xO0oo(nextFunction, "nextFunction");
        if (t == null) {
            return Oxx0IOOO.f29438oIX0oI;
        }
        return new xoIox(new Oox.oIX0oI<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @OXOo.oOoXoXO
            public final T invoke() {
                return t;
            }
        }, nextFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final <T> ooOOo0oXI<T> x0xO0oo(ooOOo0oXI<? extends T> ooooo0oxi) {
        if (ooooo0oxi == 0) {
            return Oxx0IOOO();
        }
        return ooooo0oxi;
    }

    public static final <T, R> ooOOo0oXI<R> xoIox(ooOOo0oXI<? extends T> ooooo0oxi, Oox.oOoXoXO<? super T, ? extends Iterator<? extends R>> oooxoxo) {
        if (ooooo0oxi instanceof o00) {
            return ((o00) ooooo0oxi).oxoX(oooxoxo);
        }
        return new xxIXOIIO(ooooo0oxi, new Oox.oOoXoXO<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$3
            @Override // Oox.oOoXoXO
            public final T invoke(T t) {
                return t;
            }
        }, oooxoxo);
    }

    @OXOo.OOXIXo
    public static final <T> ooOOo0oXI<T> xxIXOIIO(@OXOo.OOXIXo ooOOo0oXI<? extends ooOOo0oXI<? extends T>> ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return xoIox(ooooo0oxi, new Oox.oOoXoXO<ooOOo0oXI<? extends T>, Iterator<? extends T>>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$1
            @Override // Oox.oOoXoXO
            @OXOo.OOXIXo
            public final Iterator<T> invoke(@OXOo.OOXIXo ooOOo0oXI<? extends T> it) {
                IIX0o.x0xO0oo(it, "it");
                return it.iterator();
            }
        });
    }
}
