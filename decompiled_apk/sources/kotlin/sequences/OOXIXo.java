package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.xI;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class OOXIXo<T> implements ooOOo0oXI<xI<? extends T>> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29435oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<xI<? extends T>>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public int f29436Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T> f29437XO;

        public oIX0oI(OOXIXo<T> oOXIXo) {
            this.f29437XO = oOXIXo.f29435oIX0oI.iterator();
        }

        @OXOo.OOXIXo
        public final Iterator<T> II0xO0() {
            return this.f29437XO;
        }

        public final void X0o0xo(int i) {
            this.f29436Oo = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f29437XO.hasNext();
        }

        public final int oIX0oI() {
            return this.f29436Oo;
        }

        @Override // java.util.Iterator
        @OXOo.OOXIXo
        /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
        public xI<T> next() {
            int i = this.f29436Oo;
            this.f29436Oo = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            return new xI<>(i, this.f29437XO.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OOXIXo(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence) {
        IIX0o.x0xO0oo(sequence, "sequence");
        this.f29435oIX0oI = sequence;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<xI<T>> iterator() {
        return new oIX0oI(this);
    }
}
