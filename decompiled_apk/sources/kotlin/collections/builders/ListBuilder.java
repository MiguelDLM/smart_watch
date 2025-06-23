package kotlin.collections.builders;

import OI0IXox.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.collections.oI0IIXIo;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
/* loaded from: classes6.dex */
public final class ListBuilder<E> extends kotlin.collections.oxoX<E> implements List<E>, RandomAccess, Serializable, OI0IXox.X0o0xo {

    @OOXIXo
    private static final oIX0oI Companion = new oIX0oI(null);

    @OOXIXo
    private static final ListBuilder Empty;

    @OOXIXo
    private E[] array;

    @oOoXoXO
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;

    @oOoXoXO
    private final ListBuilder<E> root;

    @XX({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class II0xO0<E> implements ListIterator<E>, XO {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public int f29140IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f29141Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public int f29142Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        @OOXIXo
        public final ListBuilder<E> f29143XO;

        public II0xO0(@OOXIXo ListBuilder<E> list, int i) {
            IIX0o.x0xO0oo(list, "list");
            this.f29143XO = list;
            this.f29141Oo = i;
            this.f29140IXxxXO = -1;
            this.f29142Oxx0xo = ((AbstractList) list).modCount;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            oIX0oI();
            ListBuilder<E> listBuilder = this.f29143XO;
            int i = this.f29141Oo;
            this.f29141Oo = i + 1;
            listBuilder.add(i, e);
            this.f29140IXxxXO = -1;
            this.f29142Oxx0xo = ((AbstractList) this.f29143XO).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.f29141Oo < ((ListBuilder) this.f29143XO).length) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.f29141Oo > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            oIX0oI();
            if (this.f29141Oo < ((ListBuilder) this.f29143XO).length) {
                int i = this.f29141Oo;
                this.f29141Oo = i + 1;
                this.f29140IXxxXO = i;
                return (E) ((ListBuilder) this.f29143XO).array[((ListBuilder) this.f29143XO).offset + this.f29140IXxxXO];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f29141Oo;
        }

        public final void oIX0oI() {
            if (((AbstractList) this.f29143XO).modCount == this.f29142Oxx0xo) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public E previous() {
            oIX0oI();
            int i = this.f29141Oo;
            if (i > 0) {
                int i2 = i - 1;
                this.f29141Oo = i2;
                this.f29140IXxxXO = i2;
                return (E) ((ListBuilder) this.f29143XO).array[((ListBuilder) this.f29143XO).offset + this.f29140IXxxXO];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f29141Oo - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            oIX0oI();
            int i = this.f29140IXxxXO;
            if (i != -1) {
                this.f29143XO.remove(i);
                this.f29141Oo = this.f29140IXxxXO;
                this.f29140IXxxXO = -1;
                this.f29142Oxx0xo = ((AbstractList) this.f29143XO).modCount;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            oIX0oI();
            int i = this.f29140IXxxXO;
            if (i != -1) {
                this.f29143XO.set(i, e);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    private ListBuilder(E[] eArr, int i, int i2, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i;
        this.length = i2;
        this.isReadOnly = z;
        this.backing = listBuilder;
        this.root = listBuilder2;
        if (listBuilder != null) {
            ((AbstractList) this).modCount = ((AbstractList) listBuilder).modCount;
        }
    }

    private final void addAllInternal(int i, Collection<? extends E> collection, int i2) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i, collection, i2);
            this.array = this.backing.array;
            this.length += i2;
        } else {
            insertAtInternal(i, i2);
            Iterator<? extends E> it = collection.iterator();
            for (int i3 = 0; i3 < i2; i3++) {
                this.array[i + i3] = it.next();
            }
        }
    }

    private final void addAtInternal(int i, E e) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i, e);
            this.array = this.backing.array;
            this.length++;
        } else {
            insertAtInternal(i, 1);
            this.array[i] = e;
        }
    }

    private final void checkForComodification() {
        ListBuilder<E> listBuilder = this.root;
        if (listBuilder != null && ((AbstractList) listBuilder).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void checkIsMutable() {
        if (!isEffectivelyReadOnly()) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        boolean II0XooXoX2;
        II0XooXoX2 = kotlin.collections.builders.II0xO0.II0XooXoX(this.array, this.offset, this.length, list);
        return II0XooXoX2;
    }

    private final void ensureCapacityInternal(int i) {
        if (i >= 0) {
            E[] eArr = this.array;
            if (i > eArr.length) {
                this.array = (E[]) kotlin.collections.builders.II0xO0.X0o0xo(this.array, kotlin.collections.II0xO0.Companion.X0o0xo(eArr.length, i));
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i) {
        ensureCapacityInternal(this.length + i);
    }

    private final void insertAtInternal(int i, int i2) {
        ensureExtraCapacity(i2);
        E[] eArr = this.array;
        ooOOo0oXI.ooOx(eArr, eArr, i + i2, i, this.offset + this.length);
        this.length += i2;
    }

    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        if (!this.isReadOnly && ((listBuilder = this.root) == null || !listBuilder.isReadOnly)) {
            return false;
        }
        return true;
    }

    private final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    private final E removeAtInternal(int i) {
        registerModification();
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i);
        }
        E[] eArr = this.array;
        E e = eArr[i];
        ooOOo0oXI.ooOx(eArr, eArr, i, i + 1, this.offset + this.length);
        kotlin.collections.builders.II0xO0.XO(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e;
    }

    private final void removeRangeInternal(int i, int i2) {
        if (i2 > 0) {
            registerModification();
        }
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i, i2);
        } else {
            E[] eArr = this.array;
            ooOOo0oXI.ooOx(eArr, eArr, i, i + i2, this.length);
            E[] eArr2 = this.array;
            int i3 = this.length;
            kotlin.collections.builders.II0xO0.Oxx0IOOO(eArr2, i3 - i2, i3);
        }
        this.length -= i2;
    }

    private final int retainOrRemoveAllInternal(int i, int i2, Collection<? extends E> collection, boolean z) {
        int i3;
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            i3 = listBuilder.retainOrRemoveAllInternal(i, i2, collection, z);
        } else {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                int i6 = i + i4;
                if (collection.contains(this.array[i6]) == z) {
                    E[] eArr = this.array;
                    i4++;
                    eArr[i5 + i] = eArr[i6];
                    i5++;
                } else {
                    i4++;
                }
            }
            int i7 = i2 - i5;
            E[] eArr2 = this.array;
            ooOOo0oXI.ooOx(eArr2, eArr2, i + i5, i2 + i, this.length);
            E[] eArr3 = this.array;
            int i8 = this.length;
            kotlin.collections.builders.II0xO0.Oxx0IOOO(eArr3, i8 - i7, i8);
            i3 = i7;
        }
        if (i3 > 0) {
            registerModification();
        }
        this.length -= i3;
        return i3;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        checkIsMutable();
        checkForComodification();
        addAtInternal(this.offset + this.length, e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@OOXIXo Collection<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        checkIsMutable();
        checkForComodification();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    @OOXIXo
    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            if (this.length > 0) {
                return this;
            }
            return Empty;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        checkForComodification();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@oOoXoXO Object obj) {
        checkForComodification();
        if (obj != this && (!(obj instanceof List) || !contentEquals((List) obj))) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        checkForComodification();
        kotlin.collections.II0xO0.Companion.II0xO0(i, this.length);
        return this.array[this.offset + i];
    }

    @Override // kotlin.collections.oxoX
    public int getSize() {
        checkForComodification();
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int xxIXOIIO2;
        checkForComodification();
        xxIXOIIO2 = kotlin.collections.builders.II0xO0.xxIXOIIO(this.array, this.offset, this.length);
        return xxIXOIIO2;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        checkForComodification();
        for (int i = 0; i < this.length; i++) {
            if (IIX0o.Oxx0IOOO(this.array[this.offset + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        checkForComodification();
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @OOXIXo
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        checkForComodification();
        for (int i = this.length - 1; i >= 0; i--) {
            if (IIX0o.Oxx0IOOO(this.array[this.offset + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @OOXIXo
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        checkForComodification();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // kotlin.collections.oxoX
    public E removeAt(int i) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.II0xO0.Companion.II0xO0(i, this.length);
        return removeAtInternal(this.offset + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@OOXIXo Collection<? extends Object> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        checkIsMutable();
        checkForComodification();
        if (retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.oxoX, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.II0xO0.Companion.II0xO0(i, this.length);
        E[] eArr = this.array;
        int i2 = this.offset;
        E e2 = eArr[i2 + i];
        eArr[i2 + i] = e;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    @OOXIXo
    public List<E> subList(int i, int i2) {
        ListBuilder<E> listBuilder;
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, this.length);
        E[] eArr = this.array;
        int i3 = this.offset + i;
        int i4 = i2 - i;
        boolean z = this.isReadOnly;
        ListBuilder<E> listBuilder2 = this.root;
        if (listBuilder2 == null) {
            listBuilder = this;
        } else {
            listBuilder = listBuilder2;
        }
        return new ListBuilder(eArr, i3, i4, z, this, listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @OOXIXo
    public <T> T[] toArray(@OOXIXo T[] destination) {
        IIX0o.x0xO0oo(destination, "destination");
        checkForComodification();
        int length = destination.length;
        int i = this.length;
        if (length < i) {
            E[] eArr = this.array;
            int i2 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i2, i + i2, destination.getClass());
            IIX0o.oO(tArr, "copyOfRange(...)");
            return tArr;
        }
        E[] eArr2 = this.array;
        int i3 = this.offset;
        ooOOo0oXI.ooOx(eArr2, destination, 0, i3, i + i3);
        return (T[]) oI0IIXIo.x0XOIxOo(this.length, destination);
    }

    @Override // java.util.AbstractCollection
    @OOXIXo
    public String toString() {
        String xoIox2;
        checkForComodification();
        xoIox2 = kotlin.collections.builders.II0xO0.xoIox(this.array, this.offset, this.length, this);
        return xoIox2;
    }

    @Override // java.util.AbstractList, java.util.List
    @OOXIXo
    public ListIterator<E> listIterator(int i) {
        checkForComodification();
        kotlin.collections.II0xO0.Companion.I0Io(i, this.length);
        return new II0xO0(this, i);
    }

    @Override // kotlin.collections.oxoX, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        checkIsMutable();
        checkForComodification();
        kotlin.collections.II0xO0.Companion.I0Io(i, this.length);
        addAtInternal(this.offset + i, e);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, @OOXIXo Collection<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        checkIsMutable();
        checkForComodification();
        kotlin.collections.II0xO0.Companion.I0Io(i, this.length);
        int size = elements.size();
        addAllInternal(this.offset + i, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @OOXIXo
    public Object[] toArray() {
        checkForComodification();
        E[] eArr = this.array;
        int i = this.offset;
        return ooOOo0oXI.IO0XoXxO(eArr, i, this.length + i);
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i) {
        this(kotlin.collections.builders.II0xO0.oxoX(i), 0, 0, false, null, null);
    }
}
