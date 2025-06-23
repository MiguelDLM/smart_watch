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

final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
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

    public static class I0Io<K, V> {

        /* renamed from: oIX0oI  reason: collision with root package name */
        public Oxx0IOOO<K, V> f1045oIX0oI;

        public void II0xO0(Oxx0IOOO<K, V> oxx0IOOO) {
            Oxx0IOOO<K, V> oxx0IOOO2 = null;
            while (oxx0IOOO != null) {
                oxx0IOOO.f1055XO = oxx0IOOO2;
                oxx0IOOO2 = oxx0IOOO;
                oxx0IOOO = oxx0IOOO.f1052Oo;
            }
            this.f1045oIX0oI = oxx0IOOO2;
        }

        public Oxx0IOOO<K, V> oIX0oI() {
            Oxx0IOOO<K, V> oxx0IOOO = this.f1045oIX0oI;
            if (oxx0IOOO == null) {
                return null;
            }
            Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f1055XO;
            oxx0IOOO.f1055XO = null;
            Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f1051IXxxXO;
            while (true) {
                Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO2;
                oxx0IOOO2 = oxx0IOOO3;
                Oxx0IOOO<K, V> oxx0IOOO5 = oxx0IOOO4;
                if (oxx0IOOO2 != null) {
                    oxx0IOOO2.f1055XO = oxx0IOOO5;
                    oxx0IOOO3 = oxx0IOOO2.f1052Oo;
                } else {
                    this.f1045oIX0oI = oxx0IOOO5;
                    return oxx0IOOO;
                }
            }
        }
    }

    public static final class II0xO0<K, V> {

        /* renamed from: I0Io  reason: collision with root package name */
        public int f1046I0Io;

        /* renamed from: II0xO0  reason: collision with root package name */
        public int f1047II0xO0;

        /* renamed from: oIX0oI  reason: collision with root package name */
        public Oxx0IOOO<K, V> f1048oIX0oI;

        /* renamed from: oxoX  reason: collision with root package name */
        public int f1049oxoX;

        public Oxx0IOOO<K, V> I0Io() {
            Oxx0IOOO<K, V> oxx0IOOO = this.f1048oIX0oI;
            if (oxx0IOOO.f1055XO == null) {
                return oxx0IOOO;
            }
            throw new IllegalStateException();
        }

        public void II0xO0(int i) {
            this.f1047II0xO0 = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.f1049oxoX = 0;
            this.f1046I0Io = 0;
            this.f1048oIX0oI = null;
        }

        public void oIX0oI(Oxx0IOOO<K, V> oxx0IOOO) {
            oxx0IOOO.f1051IXxxXO = null;
            oxx0IOOO.f1055XO = null;
            oxx0IOOO.f1052Oo = null;
            oxx0IOOO.f1056o00 = 1;
            int i = this.f1047II0xO0;
            if (i > 0) {
                int i2 = this.f1049oxoX;
                if ((i2 & 1) == 0) {
                    this.f1049oxoX = i2 + 1;
                    this.f1047II0xO0 = i - 1;
                    this.f1046I0Io++;
                }
            }
            oxx0IOOO.f1055XO = this.f1048oIX0oI;
            this.f1048oIX0oI = oxx0IOOO;
            int i3 = this.f1049oxoX;
            int i4 = i3 + 1;
            this.f1049oxoX = i4;
            int i5 = this.f1047II0xO0;
            if (i5 > 0 && (i4 & 1) == 0) {
                this.f1049oxoX = i3 + 2;
                this.f1047II0xO0 = i5 - 1;
                this.f1046I0Io++;
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.f1049oxoX & i7) == i7) {
                    int i8 = this.f1046I0Io;
                    if (i8 == 0) {
                        Oxx0IOOO<K, V> oxx0IOOO2 = this.f1048oIX0oI;
                        Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO2.f1055XO;
                        Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO3.f1055XO;
                        oxx0IOOO3.f1055XO = oxx0IOOO4.f1055XO;
                        this.f1048oIX0oI = oxx0IOOO3;
                        oxx0IOOO3.f1052Oo = oxx0IOOO4;
                        oxx0IOOO3.f1051IXxxXO = oxx0IOOO2;
                        oxx0IOOO3.f1056o00 = oxx0IOOO2.f1056o00 + 1;
                        oxx0IOOO4.f1055XO = oxx0IOOO3;
                        oxx0IOOO2.f1055XO = oxx0IOOO3;
                    } else if (i8 == 1) {
                        Oxx0IOOO<K, V> oxx0IOOO5 = this.f1048oIX0oI;
                        Oxx0IOOO<K, V> oxx0IOOO6 = oxx0IOOO5.f1055XO;
                        this.f1048oIX0oI = oxx0IOOO6;
                        oxx0IOOO6.f1051IXxxXO = oxx0IOOO5;
                        oxx0IOOO6.f1056o00 = oxx0IOOO5.f1056o00 + 1;
                        oxx0IOOO5.f1055XO = oxx0IOOO6;
                        this.f1046I0Io = 0;
                    } else if (i8 == 2) {
                        this.f1046I0Io = 0;
                    }
                    i6 *= 2;
                } else {
                    return;
                }
            }
        }
    }

    public final class X0o0xo extends AbstractSet<K> {

        public class oIX0oI extends LinkedHashTreeMap<K, V>.XO<K> {
            public oIX0oI() {
                super();
            }

            public K next() {
                return oIX0oI().f1054OxxIIOOXO;
            }
        }

        public X0o0xo() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new oIX0oI();
        }

        public boolean remove(Object obj) {
            if (LinkedHashTreeMap.this.removeInternalByKey(obj) != null) {
                return true;
            }
            return false;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public abstract class XO<T> implements Iterator<T> {

        /* renamed from: IXxxXO  reason: collision with root package name */
        public int f1061IXxxXO;

        /* renamed from: Oo  reason: collision with root package name */
        public Oxx0IOOO<K, V> f1062Oo = null;

        /* renamed from: XO  reason: collision with root package name */
        public Oxx0IOOO<K, V> f1064XO;

        public XO() {
            this.f1064XO = LinkedHashTreeMap.this.header.f1053Oxx0xo;
            this.f1061IXxxXO = LinkedHashTreeMap.this.modCount;
        }

        public final boolean hasNext() {
            if (this.f1064XO != LinkedHashTreeMap.this.header) {
                return true;
            }
            return false;
        }

        public final Oxx0IOOO<K, V> oIX0oI() {
            Oxx0IOOO<K, V> oxx0IOOO = this.f1064XO;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (oxx0IOOO == linkedHashTreeMap.header) {
                throw new NoSuchElementException();
            } else if (linkedHashTreeMap.modCount == this.f1061IXxxXO) {
                this.f1064XO = oxx0IOOO.f1053Oxx0xo;
                this.f1062Oo = oxx0IOOO;
                return oxx0IOOO;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final void remove() {
            Oxx0IOOO<K, V> oxx0IOOO = this.f1062Oo;
            if (oxx0IOOO != null) {
                LinkedHashTreeMap.this.removeInternal(oxx0IOOO, true);
                this.f1062Oo = null;
                this.f1061IXxxXO = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public class oIX0oI implements Comparator<Comparable> {
        /* renamed from: oIX0oI */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public final class oxoX extends AbstractSet<Map.Entry<K, V>> {

        public class oIX0oI extends LinkedHashTreeMap<K, V>.XO<Map.Entry<K, V>> {
            public oIX0oI() {
                super();
            }

            /* renamed from: II0xO0 */
            public Map.Entry<K, V> next() {
                return oIX0oI();
            }
        }

        public oxoX() {
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry) || LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) == null) {
                return false;
            }
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new oIX0oI();
        }

        public boolean remove(Object obj) {
            Oxx0IOOO findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    public LinkedHashTreeMap() {
        this((Comparator) null);
    }

    private void doubleCapacity() {
        Oxx0IOOO<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            return true;
        }
        return false;
    }

    private void rebalance(Oxx0IOOO<K, V> oxx0IOOO, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        while (oxx0IOOO != null) {
            Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f1052Oo;
            Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f1051IXxxXO;
            int i5 = 0;
            if (oxx0IOOO2 != null) {
                i = oxx0IOOO2.f1056o00;
            } else {
                i = 0;
            }
            if (oxx0IOOO3 != null) {
                i2 = oxx0IOOO3.f1056o00;
            } else {
                i2 = 0;
            }
            int i6 = i - i2;
            if (i6 == -2) {
                Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO3.f1052Oo;
                Oxx0IOOO<K, V> oxx0IOOO5 = oxx0IOOO3.f1051IXxxXO;
                if (oxx0IOOO5 != null) {
                    i4 = oxx0IOOO5.f1056o00;
                } else {
                    i4 = 0;
                }
                if (oxx0IOOO4 != null) {
                    i5 = oxx0IOOO4.f1056o00;
                }
                int i7 = i5 - i4;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    rotateLeft(oxx0IOOO);
                } else {
                    rotateRight(oxx0IOOO3);
                    rotateLeft(oxx0IOOO);
                }
                if (z) {
                    return;
                }
            } else if (i6 == 2) {
                Oxx0IOOO<K, V> oxx0IOOO6 = oxx0IOOO2.f1052Oo;
                Oxx0IOOO<K, V> oxx0IOOO7 = oxx0IOOO2.f1051IXxxXO;
                if (oxx0IOOO7 != null) {
                    i3 = oxx0IOOO7.f1056o00;
                } else {
                    i3 = 0;
                }
                if (oxx0IOOO6 != null) {
                    i5 = oxx0IOOO6.f1056o00;
                }
                int i8 = i5 - i3;
                if (i8 == 1 || (i8 == 0 && !z)) {
                    rotateRight(oxx0IOOO);
                } else {
                    rotateLeft(oxx0IOOO2);
                    rotateRight(oxx0IOOO);
                }
                if (z) {
                    return;
                }
            } else if (i6 == 0) {
                oxx0IOOO.f1056o00 = i + 1;
                if (z) {
                    return;
                }
            } else {
                oxx0IOOO.f1056o00 = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            oxx0IOOO = oxx0IOOO.f1055XO;
        }
    }

    private void replaceInParent(Oxx0IOOO<K, V> oxx0IOOO, Oxx0IOOO<K, V> oxx0IOOO2) {
        Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f1055XO;
        oxx0IOOO.f1055XO = null;
        if (oxx0IOOO2 != null) {
            oxx0IOOO2.f1055XO = oxx0IOOO3;
        }
        if (oxx0IOOO3 == null) {
            int i = oxx0IOOO.f1050IIXOooo;
            Oxx0IOOO<K, V>[] oxx0IOOOArr = this.table;
            oxx0IOOOArr[i & (oxx0IOOOArr.length - 1)] = oxx0IOOO2;
        } else if (oxx0IOOO3.f1052Oo == oxx0IOOO) {
            oxx0IOOO3.f1052Oo = oxx0IOOO2;
        } else {
            oxx0IOOO3.f1051IXxxXO = oxx0IOOO2;
        }
    }

    private void rotateLeft(Oxx0IOOO<K, V> oxx0IOOO) {
        int i;
        int i2;
        Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f1052Oo;
        Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f1051IXxxXO;
        Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO3.f1052Oo;
        Oxx0IOOO<K, V> oxx0IOOO5 = oxx0IOOO3.f1051IXxxXO;
        oxx0IOOO.f1051IXxxXO = oxx0IOOO4;
        if (oxx0IOOO4 != null) {
            oxx0IOOO4.f1055XO = oxx0IOOO;
        }
        replaceInParent(oxx0IOOO, oxx0IOOO3);
        oxx0IOOO3.f1052Oo = oxx0IOOO;
        oxx0IOOO.f1055XO = oxx0IOOO3;
        int i3 = 0;
        if (oxx0IOOO2 != null) {
            i = oxx0IOOO2.f1056o00;
        } else {
            i = 0;
        }
        if (oxx0IOOO4 != null) {
            i2 = oxx0IOOO4.f1056o00;
        } else {
            i2 = 0;
        }
        int max = Math.max(i, i2) + 1;
        oxx0IOOO.f1056o00 = max;
        if (oxx0IOOO5 != null) {
            i3 = oxx0IOOO5.f1056o00;
        }
        oxx0IOOO3.f1056o00 = Math.max(max, i3) + 1;
    }

    private void rotateRight(Oxx0IOOO<K, V> oxx0IOOO) {
        int i;
        int i2;
        Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f1052Oo;
        Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f1051IXxxXO;
        Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO2.f1052Oo;
        Oxx0IOOO<K, V> oxx0IOOO5 = oxx0IOOO2.f1051IXxxXO;
        oxx0IOOO.f1052Oo = oxx0IOOO5;
        if (oxx0IOOO5 != null) {
            oxx0IOOO5.f1055XO = oxx0IOOO;
        }
        replaceInParent(oxx0IOOO, oxx0IOOO2);
        oxx0IOOO2.f1051IXxxXO = oxx0IOOO;
        oxx0IOOO.f1055XO = oxx0IOOO2;
        int i3 = 0;
        if (oxx0IOOO3 != null) {
            i = oxx0IOOO3.f1056o00;
        } else {
            i = 0;
        }
        if (oxx0IOOO5 != null) {
            i2 = oxx0IOOO5.f1056o00;
        } else {
            i2 = 0;
        }
        int max = Math.max(i, i2) + 1;
        oxx0IOOO.f1056o00 = max;
        if (oxx0IOOO4 != null) {
            i3 = oxx0IOOO4.f1056o00;
        }
        oxx0IOOO2.f1056o00 = Math.max(max, i3) + 1;
    }

    private static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        Oxx0IOOO<K, V> oxx0IOOO = this.header;
        Oxx0IOOO<K, V> oxx0IOOO2 = oxx0IOOO.f1053Oxx0xo;
        while (oxx0IOOO2 != oxx0IOOO) {
            Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO2.f1053Oxx0xo;
            oxx0IOOO2.f1057oI0IIXIo = null;
            oxx0IOOO2.f1053Oxx0xo = null;
            oxx0IOOO2 = oxx0IOOO3;
        }
        oxx0IOOO.f1057oI0IIXIo = oxx0IOOO;
        oxx0IOOO.f1053Oxx0xo = oxx0IOOO;
    }

    public boolean containsKey(Object obj) {
        if (findByObject(obj) != null) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.oxoX oxox = this.entrySet;
        if (oxox != null) {
            return oxox;
        }
        LinkedHashTreeMap<K, V>.oxoX oxox2 = new oxoX();
        this.entrySet = oxox2;
        return oxox2;
    }

    public Oxx0IOOO<K, V> find(K k, boolean z) {
        int i;
        Oxx0IOOO<K, V> oxx0IOOO;
        Oxx0IOOO<K, V> oxx0IOOO2;
        Comparable comparable;
        int i2;
        Oxx0IOOO<K, V> oxx0IOOO3;
        Comparator<? super K> comparator2 = this.comparator;
        Oxx0IOOO<K, V>[] oxx0IOOOArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = (oxx0IOOOArr.length - 1) & secondaryHash;
        Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOOArr[length];
        if (oxx0IOOO4 != null) {
            if (comparator2 == NATURAL_ORDER) {
                comparable = (Comparable) k;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(oxx0IOOO4.f1054OxxIIOOXO);
                } else {
                    i2 = comparator2.compare(k, oxx0IOOO4.f1054OxxIIOOXO);
                }
                if (i2 == 0) {
                    return oxx0IOOO4;
                }
                if (i2 < 0) {
                    oxx0IOOO3 = oxx0IOOO4.f1052Oo;
                } else {
                    oxx0IOOO3 = oxx0IOOO4.f1051IXxxXO;
                }
                if (oxx0IOOO3 == null) {
                    oxx0IOOO = oxx0IOOO4;
                    i = i2;
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
        if (oxx0IOOO != null) {
            oxx0IOOO2 = new Oxx0IOOO<>(oxx0IOOO, k, secondaryHash, oxx0IOOO5, oxx0IOOO5.f1057oI0IIXIo);
            if (i < 0) {
                oxx0IOOO.f1052Oo = oxx0IOOO2;
            } else {
                oxx0IOOO.f1051IXxxXO = oxx0IOOO2;
            }
            rebalance(oxx0IOOO, true);
        } else if (comparator2 != NATURAL_ORDER || (k instanceof Comparable)) {
            oxx0IOOO2 = new Oxx0IOOO<>(oxx0IOOO, k, secondaryHash, oxx0IOOO5, oxx0IOOO5.f1057oI0IIXIo);
            oxx0IOOOArr[length] = oxx0IOOO2;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return oxx0IOOO2;
    }

    public Oxx0IOOO<K, V> findByEntry(Map.Entry<?, ?> entry) {
        Oxx0IOOO<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject == null || !equal(findByObject.f1058xoXoI, entry.getValue())) {
            return null;
        }
        return findByObject;
    }

    public Oxx0IOOO<K, V> findByObject(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public V get(Object obj) {
        Oxx0IOOO findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f1058xoXoI;
        }
        return null;
    }

    public Set<K> keySet() {
        LinkedHashTreeMap<K, V>.X0o0xo x0o0xo = this.keySet;
        if (x0o0xo != null) {
            return x0o0xo;
        }
        LinkedHashTreeMap<K, V>.X0o0xo x0o0xo2 = new X0o0xo();
        this.keySet = x0o0xo2;
        return x0o0xo2;
    }

    public V put(K k, V v) {
        if (k != null) {
            Oxx0IOOO find = find(k, true);
            V v2 = find.f1058xoXoI;
            find.f1058xoXoI = v;
            return v2;
        }
        throw new NullPointerException("key == null");
    }

    public V remove(Object obj) {
        Oxx0IOOO removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f1058xoXoI;
        }
        return null;
    }

    public void removeInternal(Oxx0IOOO<K, V> oxx0IOOO, boolean z) {
        Oxx0IOOO<K, V> oxx0IOOO2;
        int i;
        if (z) {
            Oxx0IOOO<K, V> oxx0IOOO3 = oxx0IOOO.f1057oI0IIXIo;
            oxx0IOOO3.f1053Oxx0xo = oxx0IOOO.f1053Oxx0xo;
            oxx0IOOO.f1053Oxx0xo.f1057oI0IIXIo = oxx0IOOO3;
            oxx0IOOO.f1057oI0IIXIo = null;
            oxx0IOOO.f1053Oxx0xo = null;
        }
        Oxx0IOOO<K, V> oxx0IOOO4 = oxx0IOOO.f1052Oo;
        Oxx0IOOO<K, V> oxx0IOOO5 = oxx0IOOO.f1051IXxxXO;
        Oxx0IOOO<K, V> oxx0IOOO6 = oxx0IOOO.f1055XO;
        int i2 = 0;
        if (oxx0IOOO4 == null || oxx0IOOO5 == null) {
            if (oxx0IOOO4 != null) {
                replaceInParent(oxx0IOOO, oxx0IOOO4);
                oxx0IOOO.f1052Oo = null;
            } else if (oxx0IOOO5 != null) {
                replaceInParent(oxx0IOOO, oxx0IOOO5);
                oxx0IOOO.f1051IXxxXO = null;
            } else {
                replaceInParent(oxx0IOOO, (Oxx0IOOO<K, V>) null);
            }
            rebalance(oxx0IOOO6, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (oxx0IOOO4.f1056o00 > oxx0IOOO5.f1056o00) {
            oxx0IOOO2 = oxx0IOOO4.II0xO0();
        } else {
            oxx0IOOO2 = oxx0IOOO5.oIX0oI();
        }
        removeInternal(oxx0IOOO2, false);
        Oxx0IOOO<K, V> oxx0IOOO7 = oxx0IOOO.f1052Oo;
        if (oxx0IOOO7 != null) {
            i = oxx0IOOO7.f1056o00;
            oxx0IOOO2.f1052Oo = oxx0IOOO7;
            oxx0IOOO7.f1055XO = oxx0IOOO2;
            oxx0IOOO.f1052Oo = null;
        } else {
            i = 0;
        }
        Oxx0IOOO<K, V> oxx0IOOO8 = oxx0IOOO.f1051IXxxXO;
        if (oxx0IOOO8 != null) {
            i2 = oxx0IOOO8.f1056o00;
            oxx0IOOO2.f1051IXxxXO = oxx0IOOO8;
            oxx0IOOO8.f1055XO = oxx0IOOO2;
            oxx0IOOO.f1051IXxxXO = null;
        }
        oxx0IOOO2.f1056o00 = Math.max(i, i2) + 1;
        replaceInParent(oxx0IOOO, oxx0IOOO2);
    }

    public Oxx0IOOO<K, V> removeInternalByKey(Object obj) {
        Oxx0IOOO<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator2) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator2 == null ? NATURAL_ORDER : comparator2;
        this.header = new Oxx0IOOO<>();
        Oxx0IOOO<K, V>[] oxx0IOOOArr = new Oxx0IOOO[16];
        this.table = oxx0IOOOArr;
        this.threshold = (oxx0IOOOArr.length / 2) + (oxx0IOOOArr.length / 4);
    }

    public static <K, V> Oxx0IOOO<K, V>[] doubleCapacity(Oxx0IOOO<K, V>[] oxx0IOOOArr) {
        int length = oxx0IOOOArr.length;
        Oxx0IOOO<K, V>[] oxx0IOOOArr2 = new Oxx0IOOO[(length * 2)];
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
                    Oxx0IOOO oIX0oI2 = i0Io.oIX0oI();
                    if (oIX0oI2 == null) {
                        break;
                    } else if ((oIX0oI2.f1050IIXOooo & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                iI0xO0.II0xO0(i2);
                iI0xO02.II0xO0(i3);
                i0Io.II0xO0(oxx0IOOO);
                while (true) {
                    Oxx0IOOO oIX0oI3 = i0Io.oIX0oI();
                    if (oIX0oI3 == null) {
                        break;
                    } else if ((oIX0oI3.f1050IIXOooo & length) == 0) {
                        iI0xO0.oIX0oI(oIX0oI3);
                    } else {
                        iI0xO02.oIX0oI(oIX0oI3);
                    }
                }
                Oxx0IOOO<K, V> oxx0IOOO2 = null;
                oxx0IOOOArr2[i] = i2 > 0 ? iI0xO0.I0Io() : null;
                int i4 = i + length;
                if (i3 > 0) {
                    oxx0IOOO2 = iI0xO02.I0Io();
                }
                oxx0IOOOArr2[i4] = oxx0IOOO2;
            }
        }
        return oxx0IOOOArr2;
    }

    public static final class Oxx0IOOO<K, V> implements Map.Entry<K, V> {

        /* renamed from: IIXOooo  reason: collision with root package name */
        public final int f1050IIXOooo;

        /* renamed from: IXxxXO  reason: collision with root package name */
        public Oxx0IOOO<K, V> f1051IXxxXO;

        /* renamed from: Oo  reason: collision with root package name */
        public Oxx0IOOO<K, V> f1052Oo;

        /* renamed from: Oxx0xo  reason: collision with root package name */
        public Oxx0IOOO<K, V> f1053Oxx0xo;

        /* renamed from: OxxIIOOXO  reason: collision with root package name */
        public final K f1054OxxIIOOXO;

        /* renamed from: XO  reason: collision with root package name */
        public Oxx0IOOO<K, V> f1055XO;

        /* renamed from: o00  reason: collision with root package name */
        public int f1056o00;

        /* renamed from: oI0IIXIo  reason: collision with root package name */
        public Oxx0IOOO<K, V> f1057oI0IIXIo;

        /* renamed from: xoXoI  reason: collision with root package name */
        public V f1058xoXoI;

        public Oxx0IOOO() {
            this.f1054OxxIIOOXO = null;
            this.f1050IIXOooo = -1;
            this.f1057oI0IIXIo = this;
            this.f1053Oxx0xo = this;
        }

        public Oxx0IOOO<K, V> II0xO0() {
            Oxx0IOOO<K, V> oxx0IOOO = this;
            for (Oxx0IOOO<K, V> oxx0IOOO2 = this.f1051IXxxXO; oxx0IOOO2 != null; oxx0IOOO2 = oxx0IOOO2.f1051IXxxXO) {
                oxx0IOOO = oxx0IOOO2;
            }
            return oxx0IOOO;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.f1054OxxIIOOXO
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.f1058xoXoI
                if (r0 != 0) goto L_0x0027
                java.lang.Object r4 = r4.getValue()
                if (r4 != 0) goto L_0x0032
                goto L_0x0031
            L_0x0027:
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0032
            L_0x0031:
                r1 = 1
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.Oxx0IOOO.equals(java.lang.Object):boolean");
        }

        public K getKey() {
            return this.f1054OxxIIOOXO;
        }

        public V getValue() {
            return this.f1058xoXoI;
        }

        public int hashCode() {
            int i;
            K k = this.f1054OxxIIOOXO;
            int i2 = 0;
            if (k == null) {
                i = 0;
            } else {
                i = k.hashCode();
            }
            V v = this.f1058xoXoI;
            if (v != null) {
                i2 = v.hashCode();
            }
            return i ^ i2;
        }

        public Oxx0IOOO<K, V> oIX0oI() {
            Oxx0IOOO<K, V> oxx0IOOO = this;
            for (Oxx0IOOO<K, V> oxx0IOOO2 = this.f1052Oo; oxx0IOOO2 != null; oxx0IOOO2 = oxx0IOOO2.f1052Oo) {
                oxx0IOOO = oxx0IOOO2;
            }
            return oxx0IOOO;
        }

        public V setValue(V v) {
            V v2 = this.f1058xoXoI;
            this.f1058xoXoI = v;
            return v2;
        }

        public String toString() {
            return this.f1054OxxIIOOXO + "=" + this.f1058xoXoI;
        }

        public Oxx0IOOO(Oxx0IOOO<K, V> oxx0IOOO, K k, int i, Oxx0IOOO<K, V> oxx0IOOO2, Oxx0IOOO<K, V> oxx0IOOO3) {
            this.f1055XO = oxx0IOOO;
            this.f1054OxxIIOOXO = k;
            this.f1050IIXOooo = i;
            this.f1056o00 = 1;
            this.f1053Oxx0xo = oxx0IOOO2;
            this.f1057oI0IIXIo = oxx0IOOO3;
            oxx0IOOO3.f1053Oxx0xo = this;
            oxx0IOOO2.f1057oI0IIXIo = this;
        }
    }
}
