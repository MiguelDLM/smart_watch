package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new oIX0oI();
    Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.oxoX entrySet;
    final Oxx0IOOO<K, V> header;
    private LinkedHashTreeMap<K, V>.X0o0xo keySet;
    int modCount;
    int size;
    Oxx0IOOO<K, V>[] table;
    int threshold;

    /* loaded from: classes.dex */
    public static class I0Io<K, V> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public Oxx0IOOO<K, V> f5039oIX0oI;

        public void II0xO0(Oxx0IOOO<K, V> oxx0IOOO) {
            Oxx0IOOO<K, V> oxx0IOOO2 = null;
            while (oxx0IOOO != null) {
                oxx0IOOO.f5049XO = oxx0IOOO2;
                oxx0IOOO2 = oxx0IOOO;
                oxx0IOOO = oxx0IOOO.f5046Oo;
            }
            this.f5039oIX0oI = oxx0IOOO2;
        }

        public Oxx0IOOO<K, V> oIX0oI() {
            Oxx0IOOO<K, V> oxx0IOOO = this.f5039oIX0oI;
            if (oxx0IOOO == null) {
                return null;
            }
            Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f5049XO;
            oxx0IOOO.f5049XO = null;
            Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f5045IXxxXO;
            while (true) {
                Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO2;
                oxx0IOOO2 = oxx0IOOO3;
                if (oxx0IOOO2 != null) {
                    oxx0IOOO2.f5049XO = oxx0IOOO4;
                    oxx0IOOO3 = oxx0IOOO2.f5046Oo;
                } else {
                    this.f5039oIX0oI = oxx0IOOO4;
                    return oxx0IOOO;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class II0xO0<K, V> {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f5040I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f5041II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public Oxx0IOOO<K, V> f5042oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public int f5043oxoX;

        public Oxx0IOOO<K, V> I0Io() {
            Oxx0IOOO<K, V> oxx0IOOO = this.f5042oIX0oI;
            if (oxx0IOOO.f5049XO == null) {
                return oxx0IOOO;
            }
            throw new IllegalStateException();
        }

        public void II0xO0(int i) {
            this.f5041II0xO0 = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.f5043oxoX = 0;
            this.f5040I0Io = 0;
            this.f5042oIX0oI = null;
        }

        public void oIX0oI(Oxx0IOOO<K, V> oxx0IOOO) {
            oxx0IOOO.f5045IXxxXO = null;
            oxx0IOOO.f5049XO = null;
            oxx0IOOO.f5046Oo = null;
            oxx0IOOO.f5050o00 = 1;
            int i = this.f5041II0xO0;
            if (i > 0) {
                int i2 = this.f5043oxoX;
                if ((i2 & 1) == 0) {
                    this.f5043oxoX = i2 + 1;
                    this.f5041II0xO0 = i - 1;
                    this.f5040I0Io++;
                }
            }
            oxx0IOOO.f5049XO = this.f5042oIX0oI;
            this.f5042oIX0oI = oxx0IOOO;
            int i3 = this.f5043oxoX;
            int i4 = i3 + 1;
            this.f5043oxoX = i4;
            int i5 = this.f5041II0xO0;
            if (i5 > 0 && (i4 & 1) == 0) {
                this.f5043oxoX = i3 + 2;
                this.f5041II0xO0 = i5 - 1;
                this.f5040I0Io++;
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.f5043oxoX & i7) == i7) {
                    int i8 = this.f5040I0Io;
                    if (i8 == 0) {
                        Oxx0IOOO<K, V> oxx0IOOO2 = this.f5042oIX0oI;
                        Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO2.f5049XO;
                        Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO3.f5049XO;
                        oxx0IOOO3.f5049XO = oxx0IOOO4.f5049XO;
                        this.f5042oIX0oI = oxx0IOOO3;
                        oxx0IOOO3.f5046Oo = oxx0IOOO4;
                        oxx0IOOO3.f5045IXxxXO = oxx0IOOO2;
                        oxx0IOOO3.f5050o00 = oxx0IOOO2.f5050o00 + 1;
                        oxx0IOOO4.f5049XO = oxx0IOOO3;
                        oxx0IOOO2.f5049XO = oxx0IOOO3;
                    } else if (i8 == 1) {
                        Oxx0IOOO<K, V> oxx0IOOO5 = this.f5042oIX0oI;
                        Oxx0IOOO<K, V> oxx0IOOO6 = oxx0IOOO5.f5049XO;
                        this.f5042oIX0oI = oxx0IOOO6;
                        oxx0IOOO6.f5045IXxxXO = oxx0IOOO5;
                        oxx0IOOO6.f5050o00 = oxx0IOOO5.f5050o00 + 1;
                        oxx0IOOO5.f5049XO = oxx0IOOO6;
                        this.f5040I0Io = 0;
                    } else if (i8 == 2) {
                        this.f5040I0Io = 0;
                    }
                    i6 *= 2;
                } else {
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public final class X0o0xo extends AbstractSet<K> {

        /* loaded from: classes.dex */
        public class oIX0oI extends LinkedHashTreeMap<K, V>.XO<K> {
            public oIX0oI() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return oIX0oI().f5048OxxIIOOXO;
            }
        }

        public X0o0xo() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new oIX0oI();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (LinkedHashTreeMap.this.removeInternalByKey(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* loaded from: classes.dex */
    public abstract class XO<T> implements Iterator<T> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public int f5055IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public Oxx0IOOO<K, V> f5056Oo = null;

        /* renamed from: XO, reason: collision with root package name */
        public Oxx0IOOO<K, V> f5058XO;

        public XO() {
            this.f5058XO = LinkedHashTreeMap.this.header.f5047Oxx0xo;
            this.f5055IXxxXO = LinkedHashTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f5058XO != LinkedHashTreeMap.this.header) {
                return true;
            }
            return false;
        }

        public final Oxx0IOOO<K, V> oIX0oI() {
            Oxx0IOOO<K, V> oxx0IOOO = this.f5058XO;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (oxx0IOOO != linkedHashTreeMap.header) {
                if (linkedHashTreeMap.modCount == this.f5055IXxxXO) {
                    this.f5058XO = oxx0IOOO.f5047Oxx0xo;
                    this.f5056Oo = oxx0IOOO;
                    return oxx0IOOO;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Oxx0IOOO<K, V> oxx0IOOO = this.f5056Oo;
            if (oxx0IOOO != null) {
                LinkedHashTreeMap.this.removeInternal(oxx0IOOO, true);
                this.f5056Oo = null;
                this.f5055IXxxXO = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: classes.dex */
    public final class oxoX extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: classes.dex */
        public class oIX0oI extends LinkedHashTreeMap<K, V>.XO<Map.Entry<K, V>> {
            public oIX0oI() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return oIX0oI();
            }
        }

        public oxoX() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if ((obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new oIX0oI();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Oxx0IOOO<K, V> findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public LinkedHashTreeMap() {
        this(null);
    }

    private void doubleCapacity() {
        Oxx0IOOO<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    private void rebalance(Oxx0IOOO<K, V> oxx0IOOO, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        while (oxx0IOOO != null) {
            Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f5046Oo;
            Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f5045IXxxXO;
            int i5 = 0;
            if (oxx0IOOO2 != null) {
                i = oxx0IOOO2.f5050o00;
            } else {
                i = 0;
            }
            if (oxx0IOOO3 != null) {
                i2 = oxx0IOOO3.f5050o00;
            } else {
                i2 = 0;
            }
            int i6 = i - i2;
            if (i6 == -2) {
                Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO3.f5046Oo;
                Oxx0IOOO<K, V> oxx0IOOO5 = oxx0IOOO3.f5045IXxxXO;
                if (oxx0IOOO5 != null) {
                    i4 = oxx0IOOO5.f5050o00;
                } else {
                    i4 = 0;
                }
                if (oxx0IOOO4 != null) {
                    i5 = oxx0IOOO4.f5050o00;
                }
                int i7 = i5 - i4;
                if (i7 != -1 && (i7 != 0 || z)) {
                    rotateRight(oxx0IOOO3);
                    rotateLeft(oxx0IOOO);
                } else {
                    rotateLeft(oxx0IOOO);
                }
                if (z) {
                    return;
                }
            } else if (i6 == 2) {
                Oxx0IOOO<K, V> oxx0IOOO6 = oxx0IOOO2.f5046Oo;
                Oxx0IOOO<K, V> oxx0IOOO7 = oxx0IOOO2.f5045IXxxXO;
                if (oxx0IOOO7 != null) {
                    i3 = oxx0IOOO7.f5050o00;
                } else {
                    i3 = 0;
                }
                if (oxx0IOOO6 != null) {
                    i5 = oxx0IOOO6.f5050o00;
                }
                int i8 = i5 - i3;
                if (i8 != 1 && (i8 != 0 || z)) {
                    rotateLeft(oxx0IOOO2);
                    rotateRight(oxx0IOOO);
                } else {
                    rotateRight(oxx0IOOO);
                }
                if (z) {
                    return;
                }
            } else if (i6 == 0) {
                oxx0IOOO.f5050o00 = i + 1;
                if (z) {
                    return;
                }
            } else {
                oxx0IOOO.f5050o00 = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            oxx0IOOO = oxx0IOOO.f5049XO;
        }
    }

    private void replaceInParent(Oxx0IOOO<K, V> oxx0IOOO, Oxx0IOOO<K, V> oxx0IOOO2) {
        Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f5049XO;
        oxx0IOOO.f5049XO = null;
        if (oxx0IOOO2 != null) {
            oxx0IOOO2.f5049XO = oxx0IOOO3;
        }
        if (oxx0IOOO3 != null) {
            if (oxx0IOOO3.f5046Oo == oxx0IOOO) {
                oxx0IOOO3.f5046Oo = oxx0IOOO2;
                return;
            } else {
                oxx0IOOO3.f5045IXxxXO = oxx0IOOO2;
                return;
            }
        }
        int i = oxx0IOOO.f5044IIXOooo;
        this.table[i & (r0.length - 1)] = oxx0IOOO2;
    }

    private void rotateLeft(Oxx0IOOO<K, V> oxx0IOOO) {
        int i;
        int i2;
        Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f5046Oo;
        Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f5045IXxxXO;
        Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO3.f5046Oo;
        Oxx0IOOO<K, V> oxx0IOOO5 = oxx0IOOO3.f5045IXxxXO;
        oxx0IOOO.f5045IXxxXO = oxx0IOOO4;
        if (oxx0IOOO4 != null) {
            oxx0IOOO4.f5049XO = oxx0IOOO;
        }
        replaceInParent(oxx0IOOO, oxx0IOOO3);
        oxx0IOOO3.f5046Oo = oxx0IOOO;
        oxx0IOOO.f5049XO = oxx0IOOO3;
        int i3 = 0;
        if (oxx0IOOO2 != null) {
            i = oxx0IOOO2.f5050o00;
        } else {
            i = 0;
        }
        if (oxx0IOOO4 != null) {
            i2 = oxx0IOOO4.f5050o00;
        } else {
            i2 = 0;
        }
        int max = Math.max(i, i2) + 1;
        oxx0IOOO.f5050o00 = max;
        if (oxx0IOOO5 != null) {
            i3 = oxx0IOOO5.f5050o00;
        }
        oxx0IOOO3.f5050o00 = Math.max(max, i3) + 1;
    }

    private void rotateRight(Oxx0IOOO<K, V> oxx0IOOO) {
        int i;
        int i2;
        Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f5046Oo;
        Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f5045IXxxXO;
        Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO2.f5046Oo;
        Oxx0IOOO<K, V> oxx0IOOO5 = oxx0IOOO2.f5045IXxxXO;
        oxx0IOOO.f5046Oo = oxx0IOOO5;
        if (oxx0IOOO5 != null) {
            oxx0IOOO5.f5049XO = oxx0IOOO;
        }
        replaceInParent(oxx0IOOO, oxx0IOOO2);
        oxx0IOOO2.f5045IXxxXO = oxx0IOOO;
        oxx0IOOO.f5049XO = oxx0IOOO2;
        int i3 = 0;
        if (oxx0IOOO3 != null) {
            i = oxx0IOOO3.f5050o00;
        } else {
            i = 0;
        }
        if (oxx0IOOO5 != null) {
            i2 = oxx0IOOO5.f5050o00;
        } else {
            i2 = 0;
        }
        int max = Math.max(i, i2) + 1;
        oxx0IOOO.f5050o00 = max;
        if (oxx0IOOO4 != null) {
            i3 = oxx0IOOO4.f5050o00;
        }
        oxx0IOOO2.f5050o00 = Math.max(max, i3) + 1;
    }

    private static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        Oxx0IOOO<K, V> oxx0IOOO = this.header;
        Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f5047Oxx0xo;
        while (oxx0IOOO2 != oxx0IOOO) {
            Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO2.f5047Oxx0xo;
            oxx0IOOO2.f5051oI0IIXIo = null;
            oxx0IOOO2.f5047Oxx0xo = null;
            oxx0IOOO2 = oxx0IOOO3;
        }
        oxx0IOOO.f5051oI0IIXIo = oxx0IOOO;
        oxx0IOOO.f5047Oxx0xo = oxx0IOOO;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (findByObject(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.oxoX oxox = this.entrySet;
        if (oxox == null) {
            LinkedHashTreeMap<K, V>.oxoX oxox2 = new oxoX();
            this.entrySet = oxox2;
            return oxox2;
        }
        return oxox;
    }

    public Oxx0IOOO<K, V> find(K k, boolean z) {
        Oxx0IOOO<K, V> oxx0IOOO;
        int i;
        Oxx0IOOO<K, V> oxx0IOOO2;
        Comparable comparable;
        int compare;
        Oxx0IOOO<K, V> oxx0IOOO3;
        Comparator<? super K> comparator = this.comparator;
        Oxx0IOOO<K, V>[] oxx0IOOOArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (oxx0IOOOArr.length - 1) & secondaryHash;
        Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOOArr[length];
        if (oxx0IOOO4 != null) {
            if (comparator == NATURAL_ORDER) {
                comparable = (Comparable) k;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    compare = comparable.compareTo(oxx0IOOO4.f5048OxxIIOOXO);
                } else {
                    compare = comparator.compare(k, oxx0IOOO4.f5048OxxIIOOXO);
                }
                if (compare == 0) {
                    return oxx0IOOO4;
                }
                if (compare < 0) {
                    oxx0IOOO3 = oxx0IOOO4.f5046Oo;
                } else {
                    oxx0IOOO3 = oxx0IOOO4.f5045IXxxXO;
                }
                if (oxx0IOOO3 == null) {
                    oxx0IOOO = oxx0IOOO4;
                    i = compare;
                    break;
                }
                oxx0IOOO4 = oxx0IOOO3;
            }
        } else {
            oxx0IOOO = oxx0IOOO4;
            i = 0;
        }
        if (!z) {
            return null;
        }
        Oxx0IOOO<K, V> oxx0IOOO5 = this.header;
        if (oxx0IOOO == null) {
            if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            oxx0IOOO2 = new Oxx0IOOO<>(oxx0IOOO, k, secondaryHash, oxx0IOOO5, oxx0IOOO5.f5051oI0IIXIo);
            oxx0IOOOArr[length] = oxx0IOOO2;
        } else {
            oxx0IOOO2 = new Oxx0IOOO<>(oxx0IOOO, k, secondaryHash, oxx0IOOO5, oxx0IOOO5.f5051oI0IIXIo);
            if (i < 0) {
                oxx0IOOO.f5046Oo = oxx0IOOO2;
            } else {
                oxx0IOOO.f5045IXxxXO = oxx0IOOO2;
            }
            rebalance(oxx0IOOO, true);
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return oxx0IOOO2;
    }

    public Oxx0IOOO<K, V> findByEntry(Map.Entry<?, ?> entry) {
        Oxx0IOOO<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject == null || !equal(findByObject.f5052xoXoI, entry.getValue())) {
            return null;
        }
        return findByObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Oxx0IOOO<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Oxx0IOOO<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f5052xoXoI;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.X0o0xo x0o0xo = this.keySet;
        if (x0o0xo == null) {
            LinkedHashTreeMap<K, V>.X0o0xo x0o0xo2 = new X0o0xo();
            this.keySet = x0o0xo2;
            return x0o0xo2;
        }
        return x0o0xo;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k != null) {
            Oxx0IOOO<K, V> find = find(k, true);
            V v2 = find.f5052xoXoI;
            find.f5052xoXoI = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Oxx0IOOO<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f5052xoXoI;
        }
        return null;
    }

    public void removeInternal(Oxx0IOOO<K, V> oxx0IOOO, boolean z) {
        Oxx0IOOO<K, V> oIX0oI2;
        int i;
        if (z) {
            Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f5051oI0IIXIo;
            oxx0IOOO2.f5047Oxx0xo = oxx0IOOO.f5047Oxx0xo;
            oxx0IOOO.f5047Oxx0xo.f5051oI0IIXIo = oxx0IOOO2;
            oxx0IOOO.f5051oI0IIXIo = null;
            oxx0IOOO.f5047Oxx0xo = null;
        }
        Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f5046Oo;
        Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO.f5045IXxxXO;
        Oxx0IOOO<K, V> oxx0IOOO5 = oxx0IOOO.f5049XO;
        int i2 = 0;
        if (oxx0IOOO3 != null && oxx0IOOO4 != null) {
            if (oxx0IOOO3.f5050o00 > oxx0IOOO4.f5050o00) {
                oIX0oI2 = oxx0IOOO3.II0xO0();
            } else {
                oIX0oI2 = oxx0IOOO4.oIX0oI();
            }
            removeInternal(oIX0oI2, false);
            Oxx0IOOO<K, V> oxx0IOOO6 = oxx0IOOO.f5046Oo;
            if (oxx0IOOO6 != null) {
                i = oxx0IOOO6.f5050o00;
                oIX0oI2.f5046Oo = oxx0IOOO6;
                oxx0IOOO6.f5049XO = oIX0oI2;
                oxx0IOOO.f5046Oo = null;
            } else {
                i = 0;
            }
            Oxx0IOOO<K, V> oxx0IOOO7 = oxx0IOOO.f5045IXxxXO;
            if (oxx0IOOO7 != null) {
                i2 = oxx0IOOO7.f5050o00;
                oIX0oI2.f5045IXxxXO = oxx0IOOO7;
                oxx0IOOO7.f5049XO = oIX0oI2;
                oxx0IOOO.f5045IXxxXO = null;
            }
            oIX0oI2.f5050o00 = Math.max(i, i2) + 1;
            replaceInParent(oxx0IOOO, oIX0oI2);
            return;
        }
        if (oxx0IOOO3 != null) {
            replaceInParent(oxx0IOOO, oxx0IOOO3);
            oxx0IOOO.f5046Oo = null;
        } else if (oxx0IOOO4 != null) {
            replaceInParent(oxx0IOOO, oxx0IOOO4);
            oxx0IOOO.f5045IXxxXO = null;
        } else {
            replaceInParent(oxx0IOOO, null);
        }
        rebalance(oxx0IOOO5, false);
        this.size--;
        this.modCount++;
    }

    public Oxx0IOOO<K, V> removeInternalByKey(Object obj) {
        Oxx0IOOO<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new Oxx0IOOO<>();
        Oxx0IOOO<K, V>[] oxx0IOOOArr = new Oxx0IOOO[16];
        this.table = oxx0IOOOArr;
        this.threshold = (oxx0IOOOArr.length / 2) + (oxx0IOOOArr.length / 4);
    }

    public static <K, V> Oxx0IOOO<K, V>[] doubleCapacity(Oxx0IOOO<K, V>[] oxx0IOOOArr) {
        int length = oxx0IOOOArr.length;
        Oxx0IOOO<K, V>[] oxx0IOOOArr2 = new Oxx0IOOO[length * 2];
        I0Io i0Io = new I0Io();
        II0xO0 iI0xO0 = new II0xO0();
        II0xO0 iI0xO02 = new II0xO0();
        for (int i = 0; i < length; i++) {
            Oxx0IOOO<K, V> oxx0IOOO = oxx0IOOOArr[i];
            if (oxx0IOOO != null) {
                i0Io.II0xO0(oxx0IOOO);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    Oxx0IOOO<K, V> oIX0oI2 = i0Io.oIX0oI();
                    if (oIX0oI2 == null) {
                        break;
                    }
                    if ((oIX0oI2.f5044IIXOooo & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                iI0xO0.II0xO0(i2);
                iI0xO02.II0xO0(i3);
                i0Io.II0xO0(oxx0IOOO);
                while (true) {
                    Oxx0IOOO<K, V> oIX0oI3 = i0Io.oIX0oI();
                    if (oIX0oI3 == null) {
                        break;
                    }
                    if ((oIX0oI3.f5044IIXOooo & length) == 0) {
                        iI0xO0.oIX0oI(oIX0oI3);
                    } else {
                        iI0xO02.oIX0oI(oIX0oI3);
                    }
                }
                oxx0IOOOArr2[i] = i2 > 0 ? iI0xO0.I0Io() : null;
                oxx0IOOOArr2[i + length] = i3 > 0 ? iI0xO02.I0Io() : null;
            }
        }
        return oxx0IOOOArr2;
    }

    /* loaded from: classes.dex */
    public static final class Oxx0IOOO<K, V> implements Map.Entry<K, V> {

        /* renamed from: IIXOooo, reason: collision with root package name */
        public final int f5044IIXOooo;

        /* renamed from: IXxxXO, reason: collision with root package name */
        public Oxx0IOOO<K, V> f5045IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public Oxx0IOOO<K, V> f5046Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public Oxx0IOOO<K, V> f5047Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public final K f5048OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public Oxx0IOOO<K, V> f5049XO;

        /* renamed from: o00, reason: collision with root package name */
        public int f5050o00;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public Oxx0IOOO<K, V> f5051oI0IIXIo;

        /* renamed from: xoXoI, reason: collision with root package name */
        public V f5052xoXoI;

        public Oxx0IOOO() {
            this.f5048OxxIIOOXO = null;
            this.f5044IIXOooo = -1;
            this.f5051oI0IIXIo = this;
            this.f5047Oxx0xo = this;
        }

        public Oxx0IOOO<K, V> II0xO0() {
            Oxx0IOOO<K, V> oxx0IOOO = this;
            for (Oxx0IOOO<K, V> oxx0IOOO2 = this.f5045IXxxXO; oxx0IOOO2 != null; oxx0IOOO2 = oxx0IOOO2.f5045IXxxXO) {
                oxx0IOOO = oxx0IOOO2;
            }
            return oxx0IOOO;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f5048OxxIIOOXO;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.f5052xoXoI;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f5048OxxIIOOXO;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f5052xoXoI;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k = this.f5048OxxIIOOXO;
            int i = 0;
            if (k == null) {
                hashCode = 0;
            } else {
                hashCode = k.hashCode();
            }
            V v = this.f5052xoXoI;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public Oxx0IOOO<K, V> oIX0oI() {
            Oxx0IOOO<K, V> oxx0IOOO = this;
            for (Oxx0IOOO<K, V> oxx0IOOO2 = this.f5046Oo; oxx0IOOO2 != null; oxx0IOOO2 = oxx0IOOO2.f5046Oo) {
                oxx0IOOO = oxx0IOOO2;
            }
            return oxx0IOOO;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f5052xoXoI;
            this.f5052xoXoI = v;
            return v2;
        }

        public String toString() {
            return this.f5048OxxIIOOXO + "=" + this.f5052xoXoI;
        }

        public Oxx0IOOO(Oxx0IOOO<K, V> oxx0IOOO, K k, int i, Oxx0IOOO<K, V> oxx0IOOO2, Oxx0IOOO<K, V> oxx0IOOO3) {
            this.f5049XO = oxx0IOOO;
            this.f5048OxxIIOOXO = k;
            this.f5044IIXOooo = i;
            this.f5050o00 = 1;
            this.f5047Oxx0xo = oxx0IOOO2;
            this.f5051oI0IIXIo = oxx0IOOO3;
            oxx0IOOO3.f5047Oxx0xo = this;
            oxx0IOOO2.f5051oI0IIXIo = this;
        }
    }
}
