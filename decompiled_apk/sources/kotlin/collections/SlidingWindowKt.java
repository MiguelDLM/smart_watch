package kotlin.collections;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class SlidingWindowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.jvm.internal.XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 SlidingWindow.kt\nkotlin/collections/SlidingWindowKt\n*L\n1#1,680:1\n19#2:681\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI<T> implements kotlin.sequences.ooOOo0oXI<List<? extends T>> {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ int f29126I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ int f29127II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public final /* synthetic */ boolean f29128X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ kotlin.sequences.ooOOo0oXI f29129oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public final /* synthetic */ boolean f29130oxoX;

        public oIX0oI(kotlin.sequences.ooOOo0oXI ooooo0oxi, int i, int i2, boolean z, boolean z2) {
            this.f29129oIX0oI = ooooo0oxi;
            this.f29127II0xO0 = i;
            this.f29126I0Io = i2;
            this.f29130oxoX = z;
            this.f29128X0o0xo = z2;
        }

        @Override // kotlin.sequences.ooOOo0oXI
        @OXOo.OOXIXo
        public Iterator<List<? extends T>> iterator() {
            return SlidingWindowKt.II0xO0(this.f29129oIX0oI.iterator(), this.f29127II0xO0, this.f29126I0Io, this.f29130oxoX, this.f29128X0o0xo);
        }
    }

    @OXOo.OOXIXo
    public static final <T> kotlin.sequences.ooOOo0oXI<List<T>> I0Io(@OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> ooooo0oxi, int i, int i2, boolean z, boolean z2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        oIX0oI(i, i2);
        return new oIX0oI(ooooo0oxi, i, i2, z, z2);
    }

    @OXOo.OOXIXo
    public static final <T> Iterator<List<T>> II0xO0(@OXOo.OOXIXo Iterator<? extends T> iterator, int i, int i2, boolean z, boolean z2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iterator, "iterator");
        if (!iterator.hasNext()) {
            return XIxXXX0x0.f29131XO;
        }
        return kotlin.sequences.IXxxXO.oIX0oI(new SlidingWindowKt$windowedIterator$1(i, i2, iterator, z2, z, null));
    }

    public static final void oIX0oI(int i, int i2) {
        String str;
        if (i > 0 && i2 > 0) {
            return;
        }
        if (i != i2) {
            str = "Both size " + i + " and step " + i2 + " must be greater than zero.";
        } else {
            str = "size " + i + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }
}
