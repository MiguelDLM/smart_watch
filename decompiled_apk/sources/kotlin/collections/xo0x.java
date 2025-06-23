package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes6.dex */
public final class xo0x<T> extends oxoX<T> {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final List<T> f29180XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements ListIterator<T>, OI0IXox.XO {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ xo0x<T> f29181Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final ListIterator<T> f29182XO;

        public oIX0oI(xo0x<T> xo0xVar, int i) {
            int IoXIXo2;
            this.f29181Oo = xo0xVar;
            List list = xo0xVar.f29180XO;
            IoXIXo2 = O0xOxO.IoXIXo(xo0xVar, i);
            this.f29182XO = list.listIterator(IoXIXo2);
        }

        @Override // java.util.ListIterator
        public void add(T t) {
            this.f29182XO.add(t);
            this.f29182XO.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f29182XO.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f29182XO.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.f29182XO.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            int O0IxXx2;
            O0IxXx2 = O0xOxO.O0IxXx(this.f29181Oo, this.f29182XO.previousIndex());
            return O0IxXx2;
        }

        @OXOo.OOXIXo
        public final ListIterator<T> oIX0oI() {
            return this.f29182XO;
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.f29182XO.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            int O0IxXx2;
            O0IxXx2 = O0xOxO.O0IxXx(this.f29181Oo, this.f29182XO.nextIndex());
            return O0IxXx2;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f29182XO.remove();
        }

        @Override // java.util.ListIterator
        public void set(T t) {
            this.f29182XO.set(t);
        }
    }

    public xo0x(@OXOo.OOXIXo List<T> delegate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(delegate, "delegate");
        this.f29180XO = delegate;
    }

    @Override // kotlin.collections.oxoX, java.util.AbstractList, java.util.List
    public void add(int i, T t) {
        int IoXIXo2;
        List<T> list = this.f29180XO;
        IoXIXo2 = O0xOxO.IoXIXo(this, i);
        list.add(IoXIXo2, t);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f29180XO.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        int Ix00oIoI2;
        List<T> list = this.f29180XO;
        Ix00oIoI2 = O0xOxO.Ix00oIoI(this, i);
        return list.get(Ix00oIoI2);
    }

    @Override // kotlin.collections.oxoX
    public int getSize() {
        return this.f29180XO.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    @OXOo.OOXIXo
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.oxoX
    public T removeAt(int i) {
        int Ix00oIoI2;
        List<T> list = this.f29180XO;
        Ix00oIoI2 = O0xOxO.Ix00oIoI(this, i);
        return list.remove(Ix00oIoI2);
    }

    @Override // kotlin.collections.oxoX, java.util.AbstractList, java.util.List
    public T set(int i, T t) {
        int Ix00oIoI2;
        List<T> list = this.f29180XO;
        Ix00oIoI2 = O0xOxO.Ix00oIoI(this, i);
        return list.set(Ix00oIoI2, t);
    }

    @Override // java.util.AbstractList, java.util.List
    @OXOo.OOXIXo
    public ListIterator<T> listIterator(int i) {
        return new oIX0oI(this, i);
    }
}
