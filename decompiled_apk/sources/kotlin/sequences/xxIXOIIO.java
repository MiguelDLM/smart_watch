package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class xxIXOIIO<T, R, E> implements ooOOo0oXI<E> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<R, Iterator<E>> f29500I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<T, R> f29501II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29502oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<E>, OI0IXox.oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ xxIXOIIO<T, R, E> f29503IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        @OXOo.oOoXoXO
        public Iterator<? extends E> f29504Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T> f29505XO;

        public oIX0oI(xxIXOIIO<T, R, E> xxixoiio) {
            this.f29503IXxxXO = xxixoiio;
            this.f29505XO = xxixoiio.f29502oIX0oI.iterator();
        }

        @OXOo.oOoXoXO
        public final Iterator<E> II0xO0() {
            return this.f29504Oo;
        }

        public final void X0o0xo(@OXOo.oOoXoXO Iterator<? extends E> it) {
            this.f29504Oo = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return oIX0oI();
        }

        @Override // java.util.Iterator
        public E next() {
            if (oIX0oI()) {
                Iterator<? extends E> it = this.f29504Oo;
                IIX0o.ooOOo0oXI(it);
                return it.next();
            }
            throw new NoSuchElementException();
        }

        public final boolean oIX0oI() {
            Iterator<? extends E> it = this.f29504Oo;
            if (it != null && !it.hasNext()) {
                this.f29504Oo = null;
            }
            while (true) {
                if (this.f29504Oo != null) {
                    break;
                }
                if (!this.f29505XO.hasNext()) {
                    return false;
                }
                Iterator<? extends E> it2 = (Iterator) this.f29503IXxxXO.f29500I0Io.invoke(this.f29503IXxxXO.f29501II0xO0.invoke(this.f29505XO.next()));
                if (it2.hasNext()) {
                    this.f29504Oo = it2;
                    break;
                }
            }
            return true;
        }

        @OXOo.OOXIXo
        public final Iterator<T> oxoX() {
            return this.f29505XO;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public xxIXOIIO(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transformer, @OXOo.OOXIXo Oox.oOoXoXO<? super R, ? extends Iterator<? extends E>> iterator) {
        IIX0o.x0xO0oo(sequence, "sequence");
        IIX0o.x0xO0oo(transformer, "transformer");
        IIX0o.x0xO0oo(iterator, "iterator");
        this.f29502oIX0oI = sequence;
        this.f29501II0xO0 = transformer;
        this.f29500I0Io = iterator;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<E> iterator() {
        return new oIX0oI(this);
    }
}
