package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/TakeSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
/* loaded from: classes6.dex */
public final class OxxIIOOXO<T> implements ooOOo0oXI<T>, X0o0xo<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f29439II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29440oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<T>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T> f29441Oo;

        /* renamed from: XO, reason: collision with root package name */
        public int f29442XO;

        public oIX0oI(OxxIIOOXO<T> oxxIIOOXO) {
            this.f29442XO = oxxIIOOXO.f29439II0xO0;
            this.f29441Oo = oxxIIOOXO.f29440oIX0oI.iterator();
        }

        public final int II0xO0() {
            return this.f29442XO;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29442XO > 0 && this.f29441Oo.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.f29442XO;
            if (i != 0) {
                this.f29442XO = i - 1;
                return this.f29441Oo.next();
            }
            throw new NoSuchElementException();
        }

        @OXOo.OOXIXo
        public final Iterator<T> oIX0oI() {
            return this.f29441Oo;
        }

        public final void oxoX(int i) {
            this.f29442XO = i;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OxxIIOOXO(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence, int i) {
        IIX0o.x0xO0oo(sequence, "sequence");
        this.f29440oIX0oI = sequence;
        this.f29439II0xO0 = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // kotlin.sequences.X0o0xo
    @OXOo.OOXIXo
    public ooOOo0oXI<T> drop(int i) {
        int i2 = this.f29439II0xO0;
        if (i >= i2) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        return new oI0IIXIo(this.f29440oIX0oI, i, i2);
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return new oIX0oI(this);
    }

    @Override // kotlin.sequences.X0o0xo
    @OXOo.OOXIXo
    public ooOOo0oXI<T> oIX0oI(int i) {
        if (i >= this.f29439II0xO0) {
            return this;
        }
        return new OxxIIOOXO(this.f29440oIX0oI, i);
    }
}
