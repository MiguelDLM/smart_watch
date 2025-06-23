package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class xoXoI<T, R> implements ooOOo0oXI<R> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.x0xO0oo<Integer, T, R> f29495II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ooOOo0oXI<T> f29496oIX0oI;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<R>, OI0IXox.oIX0oI {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ xoXoI<T, R> f29497IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f29498Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final Iterator<T> f29499XO;

        public oIX0oI(xoXoI<T, R> xoxoi) {
            this.f29497IXxxXO = xoxoi;
            this.f29499XO = xoxoi.f29496oIX0oI.iterator();
        }

        @OXOo.OOXIXo
        public final Iterator<T> II0xO0() {
            return this.f29499XO;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f29499XO.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            Oox.x0xO0oo x0xo0oo = this.f29497IXxxXO.f29495II0xO0;
            int i = this.f29498Oo;
            this.f29498Oo = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            return (R) x0xo0oo.invoke(Integer.valueOf(i), this.f29499XO.next());
        }

        public final int oIX0oI() {
            return this.f29498Oo;
        }

        public final void oxoX(int i) {
            this.f29498Oo = i;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public xoXoI(@OXOo.OOXIXo ooOOo0oXI<? extends T> sequence, @OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super T, ? extends R> transformer) {
        IIX0o.x0xO0oo(sequence, "sequence");
        IIX0o.x0xO0oo(transformer, "transformer");
        this.f29496oIX0oI = sequence;
        this.f29495II0xO0 = transformer;
    }

    @Override // kotlin.sequences.ooOOo0oXI
    @OXOo.OOXIXo
    public Iterator<R> iterator() {
        return new oIX0oI(this);
    }
}
