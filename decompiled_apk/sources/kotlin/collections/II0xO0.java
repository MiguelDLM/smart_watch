package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

@kotlin.oxxXoxO(version = "1.1")
@kotlin.jvm.internal.XX({"SMAP\nAbstractList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,170:1\n350#2,7:171\n378#2,7:178\n*S KotlinDebug\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n*L\n27#1:171,7\n29#1:178,7\n*E\n"})
/* loaded from: classes6.dex */
public abstract class II0xO0<E> extends AbstractCollection<E> implements List<E>, OI0IXox.oIX0oI {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    private static final int maxArraySize = 2147483639;

    /* loaded from: classes6.dex */
    public class I0Io extends II0xO0<E>.C1103II0xO0 implements ListIterator<E>, OI0IXox.oIX0oI {
        public I0Io(int i) {
            super();
            II0xO0.Companion.I0Io(i, II0xO0.this.size());
            II0xO0(i);
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (oIX0oI() > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return oIX0oI();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                II0xO0<E> iI0xO0 = II0xO0.this;
                II0xO0(oIX0oI() - 1);
                return iI0xO0.get(oIX0oI());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return oIX0oI() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: kotlin.collections.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1103II0xO0 implements Iterator<E>, OI0IXox.oIX0oI {

        /* renamed from: XO, reason: collision with root package name */
        public int f29116XO;

        public C1103II0xO0() {
        }

        public final void II0xO0(int i) {
            this.f29116XO = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29116XO < II0xO0.this.size()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                II0xO0<E> iI0xO0 = II0xO0.this;
                int i = this.f29116XO;
                this.f29116XO = i + 1;
                return iI0xO0.get(i);
            }
            throw new NoSuchElementException();
        }

        public final int oIX0oI() {
            return this.f29116XO;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final void I0Io(int i, int i2) {
            if (i >= 0 && i <= i2) {
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
        }

        public final void II0xO0(int i, int i2) {
            if (i >= 0 && i < i2) {
                return;
            }
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
        }

        public final int Oxx0IOOO(@OXOo.OOXIXo Collection<?> c) {
            int i;
            kotlin.jvm.internal.IIX0o.x0xO0oo(c, "c");
            int i2 = 1;
            for (Object obj : c) {
                int i3 = i2 * 31;
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                i2 = i3 + i;
            }
            return i2;
        }

        public final int X0o0xo(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            if (i3 - II0xO0.maxArraySize <= 0) {
                return i3;
            }
            if (i2 > II0xO0.maxArraySize) {
                return Integer.MAX_VALUE;
            }
            return II0xO0.maxArraySize;
        }

        public final boolean XO(@OXOo.OOXIXo Collection<?> c, @OXOo.OOXIXo Collection<?> other) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(c, "c");
            kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
            if (c.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final void oIX0oI(int i, int i2, int i3) {
            if (i >= 0 && i2 <= i3) {
                if (i <= i2) {
                    return;
                }
                throw new IllegalArgumentException("startIndex: " + i + " > endIndex: " + i2);
            }
            throw new IndexOutOfBoundsException("startIndex: " + i + ", endIndex: " + i2 + ", size: " + i3);
        }

        public final void oxoX(int i, int i2, int i3) {
            if (i >= 0 && i2 <= i3) {
                if (i <= i2) {
                    return;
                }
                throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
            }
            throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
        }

        public oIX0oI() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class oxoX<E> extends II0xO0<E> implements RandomAccess {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public int f29117IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final int f29118Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final II0xO0<E> f29119XO;

        /* JADX WARN: Multi-variable type inference failed */
        public oxoX(@OXOo.OOXIXo II0xO0<? extends E> list, int i, int i2) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(list, "list");
            this.f29119XO = list;
            this.f29118Oo = i;
            II0xO0.Companion.oxoX(i, i2, list.size());
            this.f29117IXxxXO = i2 - i;
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public E get(int i) {
            II0xO0.Companion.II0xO0(i, this.f29117IXxxXO);
            return this.f29119XO.get(this.f29118Oo + i);
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return this.f29117IXxxXO;
        }
    }

    @Override // java.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        return Companion.XO(this, (Collection) obj);
    }

    @Override // java.util.List
    public abstract E get(int i);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.Oxx0IOOO(this);
    }

    @Override // java.util.List
    public int indexOf(E e) {
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(it.next(), e)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @OXOo.OOXIXo
    public Iterator<E> iterator() {
        return new C1103II0xO0();
    }

    @Override // java.util.List
    public int lastIndexOf(E e) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(listIterator.previous(), e)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @OXOo.OOXIXo
    public ListIterator<E> listIterator() {
        return new I0Io(0);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @OXOo.OOXIXo
    public List<E> subList(int i, int i2) {
        return new oxoX(this, i, i2);
    }

    @Override // java.util.List
    @OXOo.OOXIXo
    public ListIterator<E> listIterator(int i) {
        return new I0Io(i);
    }
}
