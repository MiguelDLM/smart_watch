package androidx.collection;

import OI0IXox.X0o0xo;
import OI0IXox.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import X0.IIXOooo;
import androidx.annotation.IntRange;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.OxxIIOOXO;
import kotlin.jvm.internal.XX;
import kotlin.sequences.SequencesKt___SequencesKt;

@XX({"SMAP\nObjectList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectList.kt\nandroidx/collection/MutableObjectList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 5 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 6 ObjectList.kt\nandroidx/collection/ObjectList\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1618:1\n948#1,2:1641\n948#1,2:1652\n948#1,2:1656\n652#1:1659\n955#1,2:1662\n955#1,2:1669\n955#1,2:1691\n955#1,2:1701\n955#1,2:1704\n955#1,2:1708\n1864#2,3:1619\n1855#2:1651\n1856#2:1654\n1855#2:1703\n1856#2:1706\n267#3,4:1622\n237#3,7:1626\n248#3,3:1634\n251#3,2:1638\n272#3:1640\n273#3:1643\n254#3,6:1644\n274#3:1650\n267#3,4:1672\n237#3,7:1676\n248#3,3:1684\n251#3,2:1688\n272#3:1690\n273#3:1693\n254#3,6:1694\n274#3:1700\n1826#4:1633\n1688#4:1637\n1826#4:1683\n1688#4:1687\n1295#5:1655\n1296#5:1658\n1295#5:1707\n1296#5:1710\n80#6:1660\n305#6,4:1665\n310#6:1671\n75#6:1711\n75#6:1712\n75#6:1713\n75#6:1714\n75#6:1715\n75#6:1716\n75#6:1717\n75#6:1718\n13579#7:1661\n13580#7:1664\n*S KotlinDebug\n*F\n+ 1 ObjectList.kt\nandroidx/collection/MutableObjectList\n*L\n864#1:1641,2\n898#1:1652,2\n907#1:1656,2\n927#1:1659\n1050#1:1662,2\n1059#1:1669,2\n1068#1:1691,2\n1077#1:1701,2\n1086#1:1704,2\n1095#1:1708,2\n740#1:1619,3\n897#1:1651\n897#1:1654\n1085#1:1703\n1085#1:1706\n863#1:1622,4\n863#1:1626,7\n863#1:1634,3\n863#1:1638,2\n863#1:1640\n863#1:1643\n863#1:1644,6\n863#1:1650\n1067#1:1672,4\n1067#1:1676,7\n1067#1:1684,3\n1067#1:1688,2\n1067#1:1690\n1067#1:1693\n1067#1:1694,6\n1067#1:1700\n863#1:1633\n863#1:1637\n1067#1:1683\n1067#1:1687\n906#1:1655\n906#1:1658\n1094#1:1707\n1094#1:1710\n979#1:1660\n1058#1:1665,4\n1058#1:1671\n1105#1:1711\n1109#1:1712\n1159#1:1713\n1175#1:1714\n1191#1:1715\n1207#1:1716\n1223#1:1717\n1242#1:1718\n1049#1:1661\n1049#1:1664\n*E\n"})
/* loaded from: classes.dex */
public final class MutableObjectList<E> extends ObjectList<E> {

    @oOoXoXO
    private ObjectListMutableList<E> list;

    /* loaded from: classes.dex */
    public static final class MutableObjectListIterator<T> implements ListIterator<T>, XO {

        @OOXIXo
        private final List<T> list;
        private int prevIndex;

        public MutableObjectListIterator(@OOXIXo List<T> list, int i) {
            IIX0o.x0xO0oo(list, "list");
            this.list = list;
            this.prevIndex = i - 1;
        }

        @Override // java.util.ListIterator
        public void add(T t) {
            List<T> list = this.list;
            int i = this.prevIndex + 1;
            this.prevIndex = i;
            list.add(i, t);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            if (this.prevIndex < this.list.size() - 1) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.prevIndex >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i = this.prevIndex + 1;
            this.prevIndex = i;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.prevIndex + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            List<T> list = this.list;
            int i = this.prevIndex;
            this.prevIndex = i - 1;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex--;
        }

        @Override // java.util.ListIterator
        public void set(T t) {
            this.list.set(this.prevIndex, t);
        }
    }

    /* loaded from: classes.dex */
    public static final class ObjectListMutableList<T> implements List<T>, X0o0xo {

        @OOXIXo
        private final MutableObjectList<T> objectList;

        public ObjectListMutableList(@OOXIXo MutableObjectList<T> objectList) {
            IIX0o.x0xO0oo(objectList, "objectList");
            this.objectList = objectList;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t) {
            return this.objectList.add(t);
        }

        @Override // java.util.List
        public boolean addAll(int i, @OOXIXo Collection<? extends T> elements) {
            IIX0o.x0xO0oo(elements, "elements");
            return this.objectList.addAll(i, elements);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.objectList.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.objectList.contains(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(@OOXIXo Collection<? extends Object> elements) {
            IIX0o.x0xO0oo(elements, "elements");
            return this.objectList.containsAll(elements);
        }

        @Override // java.util.List
        public T get(int i) {
            ObjectListKt.checkIndex(this, i);
            return this.objectList.get(i);
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.objectList.indexOf(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        @OOXIXo
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.objectList.lastIndexOf(obj);
        }

        @Override // java.util.List
        @OOXIXo
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(@OOXIXo Collection<? extends Object> elements) {
            IIX0o.x0xO0oo(elements, "elements");
            return this.objectList.removeAll(elements);
        }

        public T removeAt(int i) {
            ObjectListKt.checkIndex(this, i);
            return this.objectList.removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(@OOXIXo Collection<? extends Object> elements) {
            IIX0o.x0xO0oo(elements, "elements");
            return this.objectList.retainAll((Collection<? extends T>) elements);
        }

        @Override // java.util.List
        public T set(int i, T t) {
            ObjectListKt.checkIndex(this, i);
            return this.objectList.set(i, t);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        @OOXIXo
        public List<T> subList(int i, int i2) {
            ObjectListKt.checkSubIndex(this, i, i2);
            return new SubList(this, i, i2);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return OxxIIOOXO.oIX0oI(this);
        }

        @Override // java.util.List
        public void add(int i, T t) {
            this.objectList.add(i, t);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(@OOXIXo Collection<? extends T> elements) {
            IIX0o.x0xO0oo(elements, "elements");
            return this.objectList.addAll(elements);
        }

        @Override // java.util.List
        @OOXIXo
        public ListIterator<T> listIterator(int i) {
            return new MutableObjectListIterator(this, i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.objectList.remove(obj);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            IIX0o.x0xO0oo(array, "array");
            return (T[]) OxxIIOOXO.II0xO0(this, array);
        }
    }

    @XX({"SMAP\nObjectList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectList.kt\nandroidx/collection/MutableObjectList$SubList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1618:1\n1855#2,2:1619\n1855#2,2:1621\n*S KotlinDebug\n*F\n+ 1 ObjectList.kt\nandroidx/collection/MutableObjectList$SubList\n*L\n1395#1:1619,2\n1477#1:1621,2\n*E\n"})
    /* loaded from: classes.dex */
    public static final class SubList<T> implements List<T>, X0o0xo {
        private int end;

        @OOXIXo
        private final List<T> list;
        private final int start;

        public SubList(@OOXIXo List<T> list, int i, int i2) {
            IIX0o.x0xO0oo(list, "list");
            this.list = list;
            this.start = i;
            this.end = i2;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t) {
            List<T> list = this.list;
            int i = this.end;
            this.end = i + 1;
            list.add(i, t);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i, @OOXIXo Collection<? extends T> elements) {
            IIX0o.x0xO0oo(elements, "elements");
            this.list.addAll(i + this.start, elements);
            this.end += elements.size();
            return elements.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i = this.end - 1;
            int i2 = this.start;
            if (i2 <= i) {
                while (true) {
                    this.list.remove(i);
                    if (i == i2) {
                        break;
                    } else {
                        i--;
                    }
                }
            }
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i = this.end;
            for (int i2 = this.start; i2 < i; i2++) {
                if (IIX0o.Oxx0IOOO(this.list.get(i2), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(@OOXIXo Collection<? extends Object> elements) {
            IIX0o.x0xO0oo(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public T get(int i) {
            ObjectListKt.checkIndex(this, i);
            return this.list.get(i + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i = this.end;
            for (int i2 = this.start; i2 < i; i2++) {
                if (IIX0o.Oxx0IOOO(this.list.get(i2), obj)) {
                    return i2 - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            if (this.end == this.start) {
                return true;
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        @OOXIXo
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i = this.end - 1;
            int i2 = this.start;
            if (i2 <= i) {
                while (!IIX0o.Oxx0IOOO(this.list.get(i), obj)) {
                    if (i != i2) {
                        i--;
                    } else {
                        return -1;
                    }
                }
                return i - this.start;
            }
            return -1;
        }

        @Override // java.util.List
        @OOXIXo
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(@OOXIXo Collection<? extends Object> elements) {
            IIX0o.x0xO0oo(elements, "elements");
            int i = this.end;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            if (i != this.end) {
                return true;
            }
            return false;
        }

        public T removeAt(int i) {
            ObjectListKt.checkIndex(this, i);
            this.end--;
            return this.list.remove(i + this.start);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(@OOXIXo Collection<? extends Object> elements) {
            IIX0o.x0xO0oo(elements, "elements");
            int i = this.end;
            int i2 = i - 1;
            int i3 = this.start;
            if (i3 <= i2) {
                while (true) {
                    if (!elements.contains(this.list.get(i2))) {
                        this.list.remove(i2);
                        this.end--;
                    }
                    if (i2 == i3) {
                        break;
                    }
                    i2--;
                }
            }
            if (i != this.end) {
                return true;
            }
            return false;
        }

        @Override // java.util.List
        public T set(int i, T t) {
            ObjectListKt.checkIndex(this, i);
            return this.list.set(i + this.start, t);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        @OOXIXo
        public List<T> subList(int i, int i2) {
            ObjectListKt.checkSubIndex(this, i, i2);
            return new SubList(this, i, i2);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return OxxIIOOXO.oIX0oI(this);
        }

        @Override // java.util.List
        public void add(int i, T t) {
            this.list.add(i + this.start, t);
            this.end++;
        }

        @Override // java.util.List
        @OOXIXo
        public ListIterator<T> listIterator(int i) {
            return new MutableObjectListIterator(this, i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i = this.end;
            for (int i2 = this.start; i2 < i; i2++) {
                if (IIX0o.Oxx0IOOO(this.list.get(i2), obj)) {
                    this.list.remove(i2);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            IIX0o.x0xO0oo(array, "array");
            return (T[]) OxxIIOOXO.II0xO0(this, array);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(@OOXIXo Collection<? extends T> elements) {
            IIX0o.x0xO0oo(elements, "elements");
            this.list.addAll(this.end, elements);
            this.end += elements.size();
            return elements.size() > 0;
        }
    }

    public MutableObjectList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableObjectList mutableObjectList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mutableObjectList._size;
        }
        mutableObjectList.trim(i);
    }

    public final boolean add(E e) {
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        int i = this._size;
        objArr[i] = e;
        this._size = i + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i, @OOXIXo E[] elements) {
        int i2;
        IIX0o.x0xO0oo(elements, "elements");
        if (i >= 0 && i <= (i2 = this._size)) {
            if (elements.length == 0) {
                return false;
            }
            ensureCapacity(i2 + elements.length);
            Object[] objArr = this.content;
            int i3 = this._size;
            if (i != i3) {
                ooOOo0oXI.ooOx(objArr, objArr, elements.length + i, i, i3);
            }
            ooOOo0oXI.IIX0(elements, objArr, i, 0, 0, 12, null);
            this._size += elements.length;
            return true;
        }
        throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
    }

    @Override // androidx.collection.ObjectList
    @OOXIXo
    public List<E> asList() {
        return asMutableList();
    }

    @OOXIXo
    public final List<E> asMutableList() {
        ObjectListMutableList<E> objectListMutableList = this.list;
        if (objectListMutableList == null) {
            ObjectListMutableList<E> objectListMutableList2 = new ObjectListMutableList<>(this);
            this.list = objectListMutableList2;
            return objectListMutableList2;
        }
        return objectListMutableList;
    }

    public final void clear() {
        ooOOo0oXI.xX(this.content, null, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int i) {
        Object[] objArr = this.content;
        if (objArr.length < i) {
            Object[] copyOf = Arrays.copyOf(objArr, Math.max(i, (objArr.length * 3) / 2));
            IIX0o.oO(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(E e) {
        remove(e);
    }

    public final void plusAssign(@OOXIXo ObjectList<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(this._size + elements._size);
        ooOOo0oXI.ooOx(elements.content, this.content, this._size, 0, elements._size);
        this._size += elements._size;
    }

    public final boolean remove(E e) {
        int indexOf = indexOf(e);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public final boolean removeAll(@OOXIXo E[] elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        for (E e : elements) {
            remove(e);
        }
        return i != this._size;
    }

    public final E removeAt(@IntRange(from = 0) int i) {
        int i2;
        if (i >= 0 && i < (i2 = this._size)) {
            Object[] objArr = this.content;
            E e = (E) objArr[i];
            if (i != i2 - 1) {
                ooOOo0oXI.ooOx(objArr, objArr, i, i + 1, i2);
            }
            int i3 = this._size - 1;
            this._size = i3;
            objArr[i3] = null;
            return e;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void removeIf(@OOXIXo Oox.oOoXoXO<? super E, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        int i = this._size;
        Object[] objArr = this.content;
        int i2 = 0;
        X0.oOoXoXO X00xOoXI2 = IIXOooo.X00xOoXI(0, i);
        int oxoX2 = X00xOoXI2.oxoX();
        int X0o0xo2 = X00xOoXI2.X0o0xo();
        if (oxoX2 <= X0o0xo2) {
            while (true) {
                objArr[oxoX2 - i2] = objArr[oxoX2];
                if (predicate.invoke(objArr[oxoX2]).booleanValue()) {
                    i2++;
                }
                if (oxoX2 == X0o0xo2) {
                    break;
                } else {
                    oxoX2++;
                }
            }
        }
        ooOOo0oXI.xX(objArr, null, i - i2, i);
        this._size -= i2;
    }

    public final void removeRange(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        int i3;
        if (i >= 0 && i <= (i3 = this._size) && i2 >= 0 && i2 <= i3) {
            if (i2 >= i) {
                if (i2 != i) {
                    if (i2 < i3) {
                        Object[] objArr = this.content;
                        ooOOo0oXI.ooOx(objArr, objArr, i, i2, i3);
                    }
                    int i4 = this._size;
                    int i5 = i4 - (i2 - i);
                    ooOOo0oXI.xX(this.content, null, i5, i4);
                    this._size = i5;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Start (" + i + ") is more than end (" + i2 + HexStringBuilder.COMMENT_END_CHAR);
        }
        throw new IndexOutOfBoundsException("Start (" + i + ") and end (" + i2 + ") must be in 0.." + this._size);
    }

    public final boolean retainAll(@OOXIXo E[] elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (ArraysKt___ArraysKt.XxOX(elements, objArr[i2]) < 0) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final E set(@IntRange(from = 0) int i, E e) {
        if (i >= 0 && i < this._size) {
            Object[] objArr = this.content;
            E e2 = (E) objArr[i];
            objArr[i] = e;
            return e2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("set index ");
        sb.append(i);
        sb.append(" must be between 0 .. ");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        Object[] objArr = this.content;
        if (objArr.length > max) {
            Object[] copyOf = Arrays.copyOf(objArr, max);
            IIX0o.oO(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public /* synthetic */ MutableObjectList(int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final void minusAssign(@OOXIXo List<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            remove(elements.get(i));
        }
    }

    public MutableObjectList(int i) {
        super(i, null);
    }

    public final void add(@IntRange(from = 0) int i, E e) {
        int i2;
        if (i >= 0 && i <= (i2 = this._size)) {
            ensureCapacity(i2 + 1);
            Object[] objArr = this.content;
            int i3 = this._size;
            if (i != i3) {
                ooOOo0oXI.ooOx(objArr, objArr, i + 1, i, i3);
            }
            objArr[i] = e;
            this._size++;
            return;
        }
        throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
    }

    public final void minusAssign(@OOXIXo E[] elements) {
        IIX0o.x0xO0oo(elements, "elements");
        for (E e : elements) {
            remove(e);
        }
    }

    public final boolean removeAll(@OOXIXo ObjectList<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        minusAssign((ObjectList) elements);
        return i != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@OOXIXo ObjectList<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(objArr[i2]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(@OOXIXo ObjectList<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!elements.contains(objArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final boolean removeAll(@OOXIXo ScatterSet<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        minusAssign((ScatterSet) elements);
        return i != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(@OOXIXo ScatterSet<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(this._size + elements.getSize());
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        add(objArr[(i << 3) + i3]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final boolean addAll(@IntRange(from = 0) int i, @OOXIXo Collection<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        if (i >= 0 && i <= this._size) {
            int i2 = 0;
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements.size());
            Object[] objArr = this.content;
            if (i != this._size) {
                ooOOo0oXI.ooOx(objArr, objArr, elements.size() + i, i, this._size);
            }
            for (Object obj : elements) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.XoX();
                }
                objArr[i2 + i] = obj;
                i2 = i3;
            }
            this._size += elements.size();
            return true;
        }
        throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@OOXIXo ScatterSet<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        remove(objArr[(i << 3) + i3]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final boolean removeAll(@OOXIXo List<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        minusAssign((List) elements);
        return i != this._size;
    }

    public final boolean retainAll(@OOXIXo Collection<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!elements.contains(objArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final boolean removeAll(@OOXIXo Iterable<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        minusAssign((Iterable) elements);
        return i != this._size;
    }

    public final void minusAssign(@OOXIXo Iterable<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void plusAssign(@OOXIXo E[] elements) {
        IIX0o.x0xO0oo(elements, "elements");
        if (elements.length == 0) {
            return;
        }
        ensureCapacity(this._size + elements.length);
        ooOOo0oXI.IIX0(elements, this.content, this._size, 0, 0, 12, null);
        this._size += elements.length;
    }

    public final boolean removeAll(@OOXIXo kotlin.sequences.ooOOo0oXI<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        minusAssign((kotlin.sequences.ooOOo0oXI) elements);
        return i != this._size;
    }

    public final void minusAssign(@OOXIXo kotlin.sequences.ooOOo0oXI<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final boolean retainAll(@OOXIXo Iterable<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!CollectionsKt___CollectionsKt.X00xOoXI(elements, objArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final void plusAssign(@OOXIXo List<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        int i = this._size;
        ensureCapacity(elements.size() + i);
        Object[] objArr = this.content;
        int size = elements.size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2 + i] = elements.get(i2);
        }
        this._size += elements.size();
    }

    public final boolean addAll(@IntRange(from = 0) int i, @OOXIXo ObjectList<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        if (i >= 0 && i <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            Object[] objArr = this.content;
            int i2 = this._size;
            if (i != i2) {
                ooOOo0oXI.ooOx(objArr, objArr, elements._size + i, i, i2);
            }
            ooOOo0oXI.ooOx(elements.content, objArr, i, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
    }

    public final boolean retainAll(@OOXIXo kotlin.sequences.ooOOo0oXI<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!SequencesKt___SequencesKt.oX(elements, objArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final void plusAssign(E e) {
        add(e);
    }

    public final void plusAssign(@OOXIXo Iterable<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final void plusAssign(@OOXIXo kotlin.sequences.ooOOo0oXI<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final boolean addAll(@OOXIXo ObjectList<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        plusAssign((ObjectList) elements);
        return i != this._size;
    }

    public final boolean addAll(@OOXIXo ScatterSet<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        plusAssign((ScatterSet) elements);
        return i != this._size;
    }

    public final boolean addAll(@OOXIXo E[] elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        plusAssign((Object[]) elements);
        return i != this._size;
    }

    public final boolean addAll(@OOXIXo List<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        plusAssign((List) elements);
        return i != this._size;
    }

    public final boolean addAll(@OOXIXo Iterable<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        plusAssign((Iterable) elements);
        return i != this._size;
    }

    public final boolean addAll(@OOXIXo kotlin.sequences.ooOOo0oXI<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int i = this._size;
        plusAssign((kotlin.sequences.ooOOo0oXI) elements);
        return i != this._size;
    }
}
