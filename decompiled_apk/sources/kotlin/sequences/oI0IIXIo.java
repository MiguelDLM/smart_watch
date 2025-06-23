package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SubSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
/* loaded from: classes6.dex */
public final class oI0IIXIo<T> implements ooOOo0oXI<T>, X0o0xo<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f29469I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f29470II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29471oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<T>, OI0IXox.oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ oI0IIXIo<T> f29472IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f29473Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T> f29474XO;

        public oIX0oI(oI0IIXIo<T> oi0iixio) {
            this.f29472IXxxXO = oi0iixio;
            this.f29474XO = oi0iixio.f29471oIX0oI.iterator();
        }

        private final void oIX0oI() {
            while (this.f29473Oo < this.f29472IXxxXO.f29470II0xO0 && this.f29474XO.hasNext()) {
                this.f29474XO.next();
                this.f29473Oo++;
            }
        }

        @OXOo.OOXIXo
        public final Iterator<T> II0xO0() {
            return this.f29474XO;
        }

        public final void X0o0xo(int i) {
            this.f29473Oo = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            oIX0oI();
            if (this.f29473Oo < this.f29472IXxxXO.f29469I0Io && this.f29474XO.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            oIX0oI();
            if (this.f29473Oo < this.f29472IXxxXO.f29469I0Io) {
                this.f29473Oo++;
                return this.f29474XO.next();
            }
            throw new NoSuchElementException();
        }

        public final int oxoX() {
            return this.f29473Oo;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public oI0IIXIo(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence, int i, int i2) {
        IIX0o.x0xO0oo(sequence, "sequence");
        this.f29471oIX0oI = sequence;
        this.f29470II0xO0 = i;
        this.f29469I0Io = i2;
        if (i >= 0) {
            if (i2 >= 0) {
                if (i2 >= i) {
                    return;
                }
                throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i2 + " < " + i).toString());
            }
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i2).toString());
        }
        throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i).toString());
    }

    public final int X0o0xo() {
        return this.f29469I0Io - this.f29470II0xO0;
    }

    @Override // kotlin.sequences.X0o0xo
    @OXOo.OOXIXo
    public ooOOo0oXI<T> drop(int i) {
        if (i >= X0o0xo()) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new oI0IIXIo(this.f29471oIX0oI, this.f29470II0xO0 + i, this.f29469I0Io);
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return new oIX0oI(this);
    }

    @Override // kotlin.sequences.X0o0xo
    @OXOo.OOXIXo
    public ooOOo0oXI<T> oIX0oI(int i) {
        if (i >= X0o0xo()) {
            return this;
        }
        ooOOo0oXI<T> ooooo0oxi = this.f29471oIX0oI;
        int i2 = this.f29470II0xO0;
        return new oI0IIXIo(ooooo0oxi, i2, i + i2);
    }
}
