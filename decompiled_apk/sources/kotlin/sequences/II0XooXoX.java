package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class II0XooXoX<T> implements ooOOo0oXI<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<T, Boolean> f29412I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final boolean f29413II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29414oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<T>, OI0IXox.oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        @OXOo.oOoXoXO
        public T f29415IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f29416Oo = -1;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ II0XooXoX<T> f29417Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T> f29418XO;

        public oIX0oI(II0XooXoX<T> iI0XooXoX) {
            this.f29417Oxx0xo = iI0XooXoX;
            this.f29418XO = iI0XooXoX.f29414oIX0oI.iterator();
        }

        @OXOo.OOXIXo
        public final Iterator<T> II0xO0() {
            return this.f29418XO;
        }

        public final void Oxx0IOOO(int i) {
            this.f29416Oo = i;
        }

        public final int X0o0xo() {
            return this.f29416Oo;
        }

        public final void XO(@OXOo.oOoXoXO T t) {
            this.f29415IXxxXO = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29416Oo == -1) {
                oIX0oI();
            }
            if (this.f29416Oo == 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f29416Oo == -1) {
                oIX0oI();
            }
            if (this.f29416Oo != 0) {
                T t = this.f29415IXxxXO;
                this.f29415IXxxXO = null;
                this.f29416Oo = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        public final void oIX0oI() {
            while (this.f29418XO.hasNext()) {
                T next = this.f29418XO.next();
                if (((Boolean) this.f29417Oxx0xo.f29412I0Io.invoke(next)).booleanValue() == this.f29417Oxx0xo.f29413II0xO0) {
                    this.f29415IXxxXO = next;
                    this.f29416Oo = 1;
                    return;
                }
            }
            this.f29416Oo = 0;
        }

        @OXOo.oOoXoXO
        public final T oxoX() {
            return this.f29415IXxxXO;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public II0XooXoX(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence, boolean z, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(sequence, "sequence");
        IIX0o.x0xO0oo(predicate, "predicate");
        this.f29414oIX0oI = sequence;
        this.f29413II0xO0 = z;
        this.f29412I0Io = predicate;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return new oIX0oI(this);
    }

    public /* synthetic */ II0XooXoX(ooOOo0oXI ooooo0oxi, boolean z, Oox.oOoXoXO oooxoxo, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(ooooo0oxi, (i & 2) != 0 ? true : z, oooxoxo);
    }
}
