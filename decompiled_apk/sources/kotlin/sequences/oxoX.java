package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/DropSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
/* loaded from: classes6.dex */
public final class oxoX<T> implements ooOOo0oXI<T>, X0o0xo<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f29482II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29483oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<T>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public int f29484Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T> f29485XO;

        public oIX0oI(oxoX<T> oxox) {
            this.f29485XO = oxox.f29483oIX0oI.iterator();
            this.f29484Oo = oxox.f29482II0xO0;
        }

        @OXOo.OOXIXo
        public final Iterator<T> II0xO0() {
            return this.f29485XO;
        }

        public final void X0o0xo(int i) {
            this.f29484Oo = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            oIX0oI();
            return this.f29485XO.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            oIX0oI();
            return this.f29485XO.next();
        }

        public final void oIX0oI() {
            while (this.f29484Oo > 0 && this.f29485XO.hasNext()) {
                this.f29485XO.next();
                this.f29484Oo--;
            }
        }

        public final int oxoX() {
            return this.f29484Oo;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public oxoX(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence, int i) {
        IIX0o.x0xO0oo(sequence, "sequence");
        this.f29483oIX0oI = sequence;
        this.f29482II0xO0 = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // kotlin.sequences.X0o0xo
    @OXOo.OOXIXo
    public ooOOo0oXI<T> drop(int i) {
        int i2 = this.f29482II0xO0 + i;
        if (i2 < 0) {
            return new oxoX(this, i);
        }
        return new oxoX(this.f29483oIX0oI, i2);
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return new oIX0oI(this);
    }

    @Override // kotlin.sequences.X0o0xo
    @OXOo.OOXIXo
    public ooOOo0oXI<T> oIX0oI(int i) {
        int i2 = this.f29482II0xO0;
        int i3 = i2 + i;
        if (i3 < 0) {
            return new OxxIIOOXO(this, i);
        }
        return new oI0IIXIo(this.f29483oIX0oI, i2, i3);
    }
}
