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
@kotlin.jvm.internal.XX({"SMAP\nUIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n*L\n62#1:87,3\n*E\n"})
/* loaded from: classes6.dex */
public final class XX0xXo implements Collection<xxIO>, OI0IXox.oIX0oI {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final int[] f29079XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<xxIO>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public int f29080Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final int[] f29081XO;

        public oIX0oI(@OXOo.OOXIXo int[] array) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
            this.f29081XO = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29080Oo < this.f29081XO.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ xxIO next() {
            return xxIO.oxoX(oIX0oI());
        }

        public int oIX0oI() {
            int i = this.f29080Oo;
            int[] iArr = this.f29081XO;
            if (i < iArr.length) {
                this.f29080Oo = i + 1;
                return xxIO.oOoXoXO(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f29080Oo));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @o0
    public /* synthetic */ XX0xXo(int[] iArr) {
        this.f29079XO = iArr;
    }

    public static boolean II0XooXoX(int[] iArr, @OXOo.OOXIXo Collection<xxIO> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Collection<xxIO> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof xxIO) || !ArraysKt___ArraysKt.OOI00oxoO(iArr, ((xxIO) obj).OO())) {
                return false;
            }
        }
        return true;
    }

    public static final /* synthetic */ XX0xXo II0xO0(int[] iArr) {
        return new XX0xXo(iArr);
    }

    public static final void IXxxXO(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    public static final int OOXIXo(int[] iArr, int i) {
        return xxIO.oOoXoXO(iArr[i]);
    }

    @OXOo.OOXIXo
    public static Iterator<xxIO> Oo(int[] iArr) {
        return new oIX0oI(iArr);
    }

    public static boolean Oxx0IOOO(int[] iArr, int i) {
        return ArraysKt___ArraysKt.OOI00oxoO(iArr, i);
    }

    public static String Oxx0xo(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OXOo.OOXIXo
    @o0
    public static int[] X0o0xo(@OXOo.OOXIXo int[] storage) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(storage, "storage");
        return storage;
    }

    public static int oO(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static int ooOOo0oXI(int[] iArr) {
        return iArr.length;
    }

    @OXOo.OOXIXo
    public static int[] oxoX(int i) {
        return X0o0xo(new int[i]);
    }

    @o0
    public static /* synthetic */ void x0XOIxOo() {
    }

    public static boolean x0xO0oo(int[] iArr) {
        if (iArr.length == 0) {
            return true;
        }
        return false;
    }

    public static final boolean xoIox(int[] iArr, int[] iArr2) {
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(iArr, iArr2);
    }

    public static boolean xxIXOIIO(int[] iArr, Object obj) {
        return (obj instanceof XX0xXo) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(iArr, ((XX0xXo) obj).oI0IIXIo());
    }

    public boolean XO(int i) {
        return Oxx0IOOO(this.f29079XO, i);
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(xxIO xxio) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends xxIO> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof xxIO)) {
            return false;
        }
        return XO(((xxIO) obj).OO());
    }

    @Override // java.util.Collection
    public boolean containsAll(@OXOo.OOXIXo Collection<? extends Object> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return II0XooXoX(this.f29079XO, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return xxIXOIIO(this.f29079XO, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return oO(this.f29079XO);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return x0xO0oo(this.f29079XO);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @OXOo.OOXIXo
    public Iterator<xxIO> iterator() {
        return Oo(this.f29079XO);
    }

    public final /* synthetic */ int[] oI0IIXIo() {
        return this.f29079XO;
    }

    public boolean oIX0oI(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public int size() {
        return ooOOo0oXI(this.f29079XO);
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
        return Oxx0xo(this.f29079XO);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        return (T[]) kotlin.jvm.internal.OxxIIOOXO.II0xO0(this, array);
    }
}
