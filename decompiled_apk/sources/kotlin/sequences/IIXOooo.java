package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class IIXOooo<T> implements ooOOo0oXI<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<T, Boolean> f29422II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29423oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<T>, OI0IXox.oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        @OXOo.oOoXoXO
        public T f29424IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f29425Oo = -1;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ IIXOooo<T> f29426Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T> f29427XO;

        public oIX0oI(IIXOooo<T> iIXOooo) {
            this.f29426Oxx0xo = iIXOooo;
            this.f29427XO = iIXOooo.f29423oIX0oI.iterator();
        }

        private final void oIX0oI() {
            if (this.f29427XO.hasNext()) {
                T next = this.f29427XO.next();
                if (((Boolean) this.f29426Oxx0xo.f29422II0xO0.invoke(next)).booleanValue()) {
                    this.f29425Oo = 1;
                    this.f29424IXxxXO = next;
                    return;
                }
            }
            this.f29425Oo = 0;
        }

        @OXOo.OOXIXo
        public final Iterator<T> II0xO0() {
            return this.f29427XO;
        }

        public final void Oxx0IOOO(int i) {
            this.f29425Oo = i;
        }

        public final int X0o0xo() {
            return this.f29425Oo;
        }

        public final void XO(@OXOo.oOoXoXO T t) {
            this.f29424IXxxXO = t;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29425Oo == -1) {
                oIX0oI();
            }
            if (this.f29425Oo == 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f29425Oo == -1) {
                oIX0oI();
            }
            if (this.f29425Oo != 0) {
                T t = this.f29424IXxxXO;
                this.f29424IXxxXO = null;
                this.f29425Oo = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        @OXOo.oOoXoXO
        public final T oxoX() {
            return this.f29424IXxxXO;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IIXOooo(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence, @OXOo.OOXIXo Oox.oOoXoXO<? super T, Boolean> predicate) {
        IIX0o.x0xO0oo(sequence, "sequence");
        IIX0o.x0xO0oo(predicate, "predicate");
        this.f29423oIX0oI = sequence;
        this.f29422II0xO0 = predicate;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return new oIX0oI(this);
    }
}
