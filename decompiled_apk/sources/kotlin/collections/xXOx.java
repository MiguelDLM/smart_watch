package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes6.dex */
public class xXOx<T> extends II0xO0<T> {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<T> f29177XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements ListIterator<T>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ xXOx<T> f29178Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final ListIterator<T> f29179XO;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI(xXOx<? extends T> xxox, int i) {
            int IoXIXo2;
            this.f29178Oo = xxox;
            List list = xxox.f29177XO;
            IoXIXo2 = O0xOxO.IoXIXo(xxox, i);
            this.f29179XO = list.listIterator(IoXIXo2);
        }

        @Override // java.util.ListIterator
        public void add(T t) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f29179XO.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f29179XO.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.f29179XO.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            int O0IxXx2;
            O0IxXx2 = O0xOxO.O0IxXx(this.f29178Oo, this.f29179XO.previousIndex());
            return O0IxXx2;
        }

        @OXOo.OOXIXo
        public final ListIterator<T> oIX0oI() {
            return this.f29179XO;
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.f29179XO.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            int O0IxXx2;
            O0IxXx2 = O0xOxO.O0IxXx(this.f29178Oo, this.f29179XO.nextIndex());
            return O0IxXx2;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(T t) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public xXOx(@OXOo.OOXIXo List<? extends T> delegate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(delegate, "delegate");
        this.f29177XO = delegate;
    }

    @Override // kotlin.collections.II0xO0, java.util.List
    public T get(int i) {
        int Ix00oIoI2;
        List<T> list = this.f29177XO;
        Ix00oIoI2 = O0xOxO.Ix00oIoI(this, i);
        return list.get(Ix00oIoI2);
    }

    @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f29177XO.size();
    }

    @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.II0xO0, java.util.List
    @OXOo.OOXIXo
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.II0xO0, java.util.List
    @OXOo.OOXIXo
    public ListIterator<T> listIterator(int i) {
        return new oIX0oI(this, i);
    }
}
