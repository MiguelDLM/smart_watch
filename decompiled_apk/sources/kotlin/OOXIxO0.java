package kotlin;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;

@oI0IIXIo
@XO0OX.Oxx0IOOO
@oxxXoxO(version = "1.3")
@kotlin.jvm.internal.XX({"SMAP\nULongArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 ULongArray.kt\nkotlin/ULongArray\n*L\n62#1:87,3\n*E\n"})
/* loaded from: classes6.dex */
public final class OOXIxO0 implements Collection<XI0oooXX>, OI0IXox.oIX0oI {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final long[] f29061XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<XI0oooXX>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public int f29062Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final long[] f29063XO;

        public oIX0oI(@OXOo.OOXIXo long[] array) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
            this.f29063XO = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29062Oo < this.f29063XO.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ XI0oooXX next() {
            return XI0oooXX.oxoX(oIX0oI());
        }

        public long oIX0oI() {
            int i = this.f29062Oo;
            long[] jArr = this.f29063XO;
            if (i < jArr.length) {
                this.f29062Oo = i + 1;
                return XI0oooXX.oOoXoXO(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f29062Oo));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @o0
    public /* synthetic */ OOXIxO0(long[] jArr) {
        this.f29061XO = jArr;
    }

    public static boolean II0XooXoX(long[] jArr, @OXOo.OOXIXo Collection<XI0oooXX> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Collection<XI0oooXX> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof XI0oooXX) || !ArraysKt___ArraysKt.XXXoOII(jArr, ((XI0oooXX) obj).OO())) {
                return false;
            }
        }
        return true;
    }

    public static final /* synthetic */ OOXIxO0 II0xO0(long[] jArr) {
        return new OOXIxO0(jArr);
    }

    public static final void IXxxXO(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    public static final long OOXIXo(long[] jArr, int i) {
        return XI0oooXX.oOoXoXO(jArr[i]);
    }

    @OXOo.OOXIXo
    public static Iterator<XI0oooXX> Oo(long[] jArr) {
        return new oIX0oI(jArr);
    }

    public static boolean Oxx0IOOO(long[] jArr, long j) {
        return ArraysKt___ArraysKt.XXXoOII(jArr, j);
    }

    public static String Oxx0xo(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OXOo.OOXIXo
    @o0
    public static long[] X0o0xo(@OXOo.OOXIXo long[] storage) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(storage, "storage");
        return storage;
    }

    public static int oO(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static int ooOOo0oXI(long[] jArr) {
        return jArr.length;
    }

    @OXOo.OOXIXo
    public static long[] oxoX(int i) {
        return X0o0xo(new long[i]);
    }

    @o0
    public static /* synthetic */ void x0XOIxOo() {
    }

    public static boolean x0xO0oo(long[] jArr) {
        if (jArr.length == 0) {
            return true;
        }
        return false;
    }

    public static final boolean xoIox(long[] jArr, long[] jArr2) {
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(jArr, jArr2);
    }

    public static boolean xxIXOIIO(long[] jArr, Object obj) {
        return (obj instanceof OOXIxO0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(jArr, ((OOXIxO0) obj).oI0IIXIo());
    }

    public boolean XO(long j) {
        return Oxx0IOOO(this.f29061XO, j);
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(XI0oooXX xI0oooXX) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends XI0oooXX> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof XI0oooXX)) {
            return false;
        }
        return XO(((XI0oooXX) obj).OO());
    }

    @Override // java.util.Collection
    public boolean containsAll(@OXOo.OOXIXo Collection<? extends Object> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return II0XooXoX(this.f29061XO, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return xxIXOIIO(this.f29061XO, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return oO(this.f29061XO);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return x0xO0oo(this.f29061XO);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @OXOo.OOXIXo
    public Iterator<XI0oooXX> iterator() {
        return Oo(this.f29061XO);
    }

    public final /* synthetic */ long[] oI0IIXIo() {
        return this.f29061XO;
    }

    public boolean oIX0oI(long j) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public int size() {
        return ooOOo0oXI(this.f29061XO);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.OxxIIOOXO.oIX0oI(this);
    }

    public String toString() {
        return Oxx0xo(this.f29061XO);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        return (T[]) kotlin.jvm.internal.OxxIIOOXO.II0xO0(this, array);
    }
}
