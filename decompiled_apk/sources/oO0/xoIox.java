package oO0;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes6.dex */
public abstract class xoIox<K, V> {

    /* renamed from: I0Io, reason: collision with root package name */
    public xoIox<K, V>.X0o0xo f31854I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public xoIox<K, V>.I0Io f31855II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public xoIox<K, V>.II0xO0 f31856oIX0oI;

    /* loaded from: classes6.dex */
    public final class I0Io implements Set<K> {
        public I0Io() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            xoIox.this.oIX0oI();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (xoIox.this.X0o0xo(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return xoIox.xoIox(xoIox.this.I0Io(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return xoIox.OOXIXo(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int i = 0;
            for (int oxoX2 = xoIox.this.oxoX() - 1; oxoX2 >= 0; oxoX2--) {
                Object II0xO02 = xoIox.this.II0xO0(oxoX2, 0);
                if (II0xO02 == null) {
                    hashCode = 0;
                } else {
                    hashCode = II0xO02.hashCode();
                }
                i += hashCode;
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (xoIox.this.oxoX() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new oIX0oI(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int X0o0xo2 = xoIox.this.X0o0xo(obj);
            if (X0o0xo2 >= 0) {
                xoIox.this.II0XooXoX(X0o0xo2);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return xoIox.oO(xoIox.this.I0Io(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return xoIox.x0xO0oo(xoIox.this.I0Io(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return xoIox.this.oxoX();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return xoIox.this.Oo(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) xoIox.this.IXxxXO(tArr, 0);
        }
    }

    /* loaded from: classes6.dex */
    public final class II0xO0 implements Set<Map.Entry<K, V>> {
        public II0xO0() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int oxoX2 = xoIox.this.oxoX();
            for (Map.Entry<K, V> entry : collection) {
                xoIox.this.Oxx0IOOO(entry.getKey(), entry.getValue());
            }
            if (oxoX2 != xoIox.this.oxoX()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            xoIox.this.oIX0oI();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int X0o0xo2 = xoIox.this.X0o0xo(entry.getKey());
            if (X0o0xo2 < 0) {
                return false;
            }
            return xxIXOIIO.I0Io(xoIox.this.II0xO0(X0o0xo2, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return xoIox.OOXIXo(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i = 0;
            for (int oxoX2 = xoIox.this.oxoX() - 1; oxoX2 >= 0; oxoX2--) {
                Object II0xO02 = xoIox.this.II0xO0(oxoX2, 0);
                Object II0xO03 = xoIox.this.II0xO0(oxoX2, 1);
                if (II0xO02 == null) {
                    hashCode = 0;
                } else {
                    hashCode = II0xO02.hashCode();
                }
                if (II0xO03 == null) {
                    hashCode2 = 0;
                } else {
                    hashCode2 = II0xO03.hashCode();
                }
                i += hashCode ^ hashCode2;
            }
            return i;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            if (xoIox.this.oxoX() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new oxoX();
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return xoIox.this.oxoX();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes6.dex */
    public final class X0o0xo implements Collection<V> {
        public X0o0xo() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            xoIox.this.oIX0oI();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            if (xoIox.this.XO(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            if (xoIox.this.oxoX() == 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new oIX0oI(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int XO2 = xoIox.this.XO(obj);
            if (XO2 >= 0) {
                xoIox.this.II0XooXoX(XO2);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int oxoX2 = xoIox.this.oxoX();
            int i = 0;
            boolean z = false;
            while (i < oxoX2) {
                if (collection.contains(xoIox.this.II0xO0(i, 1))) {
                    xoIox.this.II0XooXoX(i);
                    i--;
                    oxoX2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int oxoX2 = xoIox.this.oxoX();
            int i = 0;
            boolean z = false;
            while (i < oxoX2) {
                if (!collection.contains(xoIox.this.II0xO0(i, 1))) {
                    xoIox.this.II0XooXoX(i);
                    i--;
                    oxoX2--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return xoIox.this.oxoX();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return xoIox.this.Oo(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) xoIox.this.IXxxXO(tArr, 1);
        }
    }

    /* loaded from: classes6.dex */
    public final class oIX0oI<T> implements Iterator<T> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public int f31860IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public int f31861Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public boolean f31862Oxx0xo = false;

        /* renamed from: XO, reason: collision with root package name */
        public final int f31863XO;

        public oIX0oI(int i) {
            this.f31863XO = i;
            this.f31861Oo = xoIox.this.oxoX();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f31860IXxxXO < this.f31861Oo) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t = (T) xoIox.this.II0xO0(this.f31860IXxxXO, this.f31863XO);
                this.f31860IXxxXO++;
                this.f31862Oxx0xo = true;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f31862Oxx0xo) {
                int i = this.f31860IXxxXO - 1;
                this.f31860IXxxXO = i;
                this.f31861Oo--;
                this.f31862Oxx0xo = false;
                xoIox.this.II0XooXoX(i);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes6.dex */
    public final class oxoX implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public boolean f31865IXxxXO = false;

        /* renamed from: Oo, reason: collision with root package name */
        public int f31866Oo = -1;

        /* renamed from: XO, reason: collision with root package name */
        public int f31868XO;

        public oxoX() {
            this.f31868XO = xoIox.this.oxoX() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f31865IXxxXO) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!xxIXOIIO.I0Io(entry.getKey(), xoIox.this.II0xO0(this.f31866Oo, 0)) || !xxIXOIIO.I0Io(entry.getValue(), xoIox.this.II0xO0(this.f31866Oo, 1))) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f31865IXxxXO) {
                return (K) xoIox.this.II0xO0(this.f31866Oo, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f31865IXxxXO) {
                return (V) xoIox.this.II0xO0(this.f31866Oo, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f31866Oo < this.f31868XO) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            if (this.f31865IXxxXO) {
                int i = 0;
                Object II0xO02 = xoIox.this.II0xO0(this.f31866Oo, 0);
                Object II0xO03 = xoIox.this.II0xO0(this.f31866Oo, 1);
                if (II0xO02 == null) {
                    hashCode = 0;
                } else {
                    hashCode = II0xO02.hashCode();
                }
                if (II0xO03 != null) {
                    i = II0xO03.hashCode();
                }
                return hashCode ^ i;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f31866Oo++;
                this.f31865IXxxXO = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f31865IXxxXO) {
                xoIox.this.II0XooXoX(this.f31866Oo);
                this.f31866Oo--;
                this.f31868XO--;
                this.f31865IXxxXO = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f31865IXxxXO) {
                return (V) xoIox.this.xxIXOIIO(this.f31866Oo, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    public static <T> boolean OOXIXo(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean oO(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public static <K, V> boolean x0xO0oo(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        if (size != map.size()) {
            return true;
        }
        return false;
    }

    public static <K, V> boolean xoIox(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract Map<K, V> I0Io();

    public abstract void II0XooXoX(int i);

    public abstract Object II0xO0(int i, int i2);

    public <T> T[] IXxxXO(T[] tArr, int i) {
        int oxoX2 = oxoX();
        if (tArr.length < oxoX2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), oxoX2));
        }
        for (int i2 = 0; i2 < oxoX2; i2++) {
            tArr[i2] = II0xO0(i2, i);
        }
        if (tArr.length > oxoX2) {
            tArr[oxoX2] = null;
        }
        return tArr;
    }

    public Object[] Oo(int i) {
        int oxoX2 = oxoX();
        Object[] objArr = new Object[oxoX2];
        for (int i2 = 0; i2 < oxoX2; i2++) {
            objArr[i2] = II0xO0(i2, i);
        }
        return objArr;
    }

    public abstract void Oxx0IOOO(K k, V v);

    public abstract int X0o0xo(Object obj);

    public abstract int XO(Object obj);

    public abstract void oIX0oI();

    public Set<Map.Entry<K, V>> oOoXoXO() {
        if (this.f31856oIX0oI == null) {
            this.f31856oIX0oI = new II0xO0();
        }
        return this.f31856oIX0oI;
    }

    public Set<K> ooOOo0oXI() {
        if (this.f31855II0xO0 == null) {
            this.f31855II0xO0 = new I0Io();
        }
        return this.f31855II0xO0;
    }

    public abstract int oxoX();

    public Collection<V> x0XOIxOo() {
        if (this.f31854I0Io == null) {
            this.f31854I0Io = new X0o0xo();
        }
        return this.f31854I0Io;
    }

    public abstract V xxIXOIIO(int i, V v);
}
