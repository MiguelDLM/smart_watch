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
@kotlin.jvm.internal.XX({"SMAP\nUShortArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n*L\n62#1:87,3\n*E\n"})
/* loaded from: classes6.dex */
public final class xX0IIXIx0 implements Collection<OX00O0xII>, OI0IXox.oIX0oI {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final short[] f29662XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<OX00O0xII>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public int f29663Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final short[] f29664XO;

        public oIX0oI(@OXOo.OOXIXo short[] array) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
            this.f29664XO = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29663Oo < this.f29664XO.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ OX00O0xII next() {
            return OX00O0xII.oxoX(oIX0oI());
        }

        public short oIX0oI() {
            int i = this.f29663Oo;
            short[] sArr = this.f29664XO;
            if (i < sArr.length) {
                this.f29663Oo = i + 1;
                return OX00O0xII.oOoXoXO(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f29663Oo));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @o0
    public /* synthetic */ xX0IIXIx0(short[] sArr) {
        this.f29662XO = sArr;
    }

    public static boolean II0XooXoX(short[] sArr, @OXOo.OOXIXo Collection<OX00O0xII> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Collection<OX00O0xII> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof OX00O0xII) || !ArraysKt___ArraysKt.X0xX(sArr, ((OX00O0xII) obj).I0oOIX())) {
                return false;
            }
        }
        return true;
    }

    public static final /* synthetic */ xX0IIXIx0 II0xO0(short[] sArr) {
        return new xX0IIXIx0(sArr);
    }

    public static final void IXxxXO(short[] sArr, int i, short s) {
        sArr[i] = s;
    }

    public static final short OOXIXo(short[] sArr, int i) {
        return OX00O0xII.oOoXoXO(sArr[i]);
    }

    @OXOo.OOXIXo
    public static Iterator<OX00O0xII> Oo(short[] sArr) {
        return new oIX0oI(sArr);
    }

    public static boolean Oxx0IOOO(short[] sArr, short s) {
        return ArraysKt___ArraysKt.X0xX(sArr, s);
    }

    public static String Oxx0xo(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OXOo.OOXIXo
    @o0
    public static short[] X0o0xo(@OXOo.OOXIXo short[] storage) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(storage, "storage");
        return storage;
    }

    public static int oO(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static int ooOOo0oXI(short[] sArr) {
        return sArr.length;
    }

    @OXOo.OOXIXo
    public static short[] oxoX(int i) {
        return X0o0xo(new short[i]);
    }

    @o0
    public static /* synthetic */ void x0XOIxOo() {
    }

    public static boolean x0xO0oo(short[] sArr) {
        if (sArr.length == 0) {
            return true;
        }
        return false;
    }

    public static final boolean xoIox(short[] sArr, short[] sArr2) {
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(sArr, sArr2);
    }

    public static boolean xxIXOIIO(short[] sArr, Object obj) {
        return (obj instanceof xX0IIXIx0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(sArr, ((xX0IIXIx0) obj).oI0IIXIo());
    }

    public boolean XO(short s) {
        return Oxx0IOOO(this.f29662XO, s);
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(OX00O0xII oX00O0xII) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends OX00O0xII> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof OX00O0xII)) {
            return false;
        }
        return XO(((OX00O0xII) obj).I0oOIX());
    }

    @Override // java.util.Collection
    public boolean containsAll(@OXOo.OOXIXo Collection<? extends Object> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return II0XooXoX(this.f29662XO, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return xxIXOIIO(this.f29662XO, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return oO(this.f29662XO);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return x0xO0oo(this.f29662XO);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @OXOo.OOXIXo
    public Iterator<OX00O0xII> iterator() {
        return Oo(this.f29662XO);
    }

    public final /* synthetic */ short[] oI0IIXIo() {
        return this.f29662XO;
    }

    public boolean oIX0oI(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public int size() {
        return ooOOo0oXI(this.f29662XO);
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
        return Oxx0xo(this.f29662XO);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        return (T[]) kotlin.jvm.internal.OxxIIOOXO.II0xO0(this, array);
    }
}
