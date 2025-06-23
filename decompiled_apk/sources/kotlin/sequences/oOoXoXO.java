package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class oOoXoXO<T1, T2, V> implements ooOOo0oXI<V> {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.x0xO0oo<T1, T2, V> f29476I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T2> f29477II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T1> f29478oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<V>, OI0IXox.oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ oOoXoXO<T1, T2, V> f29479IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T2> f29480Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T1> f29481XO;

        public oIX0oI(oOoXoXO<T1, T2, V> oooxoxo) {
            this.f29479IXxxXO = oooxoxo;
            this.f29481XO = oooxoxo.f29478oIX0oI.iterator();
            this.f29480Oo = oooxoxo.f29477II0xO0.iterator();
        }

        @OXOo.OOXIXo
        public final Iterator<T2> II0xO0() {
            return this.f29480Oo;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29481XO.hasNext() && this.f29480Oo.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) this.f29479IXxxXO.f29476I0Io.invoke(this.f29481XO.next(), this.f29480Oo.next());
        }

        @OXOo.OOXIXo
        public final Iterator<T1> oIX0oI() {
            return this.f29481XO;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public oOoXoXO(@OXOo.OOXIXo ooOOo0oXI<? extends T1> sequence1, @OXOo.OOXIXo ooOOo0oXI<? extends T2> sequence2, @OXOo.OOXIXo Oox.x0xO0oo<? super T1, ? super T2, ? extends V> transform) {
        IIX0o.x0xO0oo(sequence1, "sequence1");
        IIX0o.x0xO0oo(sequence2, "sequence2");
        IIX0o.x0xO0oo(transform, "transform");
        this.f29478oIX0oI = sequence1;
        this.f29477II0xO0 = sequence2;
        this.f29476I0Io = transform;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<V> iterator() {
        return new oIX0oI(this);
    }
}
