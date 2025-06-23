package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class o00<T, R> implements ooOOo0oXI<R> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<T, R> f29465II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29466oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<R>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ o00<T, R> f29467Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T> f29468XO;

        public oIX0oI(o00<T, R> o00Var) {
            this.f29467Oo = o00Var;
            this.f29468XO = o00Var.f29466oIX0oI.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f29468XO.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) this.f29467Oo.f29465II0xO0.invoke(this.f29468XO.next());
        }

        @OXOo.OOXIXo
        public final Iterator<T> oIX0oI() {
            return this.f29468XO;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o00(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> transformer) {
        IIX0o.x0xO0oo(sequence, "sequence");
        IIX0o.x0xO0oo(transformer, "transformer");
        this.f29466oIX0oI = sequence;
        this.f29465II0xO0 = transformer;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<R> iterator() {
        return new oIX0oI(this);
    }

    @OXOo.OOXIXo
    public final <E> ooOOo0oXI<E> oxoX(@OXOo.OOXIXo Oox.oOoXoXO<? super R, ? extends Iterator<? extends E>> iterator) {
        IIX0o.x0xO0oo(iterator, "iterator");
        return new xxIXOIIO(this.f29466oIX0oI, this.f29465II0xO0, iterator);
    }
}
