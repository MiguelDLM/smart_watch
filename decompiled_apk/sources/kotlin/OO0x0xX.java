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
@kotlin.jvm.internal.XX({"SMAP\nUByteArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n*L\n62#1:87,3\n*E\n"})
/* loaded from: classes6.dex */
public final class OO0x0xX implements Collection<x0xO>, OI0IXox.oIX0oI {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final byte[] f29058XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI implements Iterator<x0xO>, OI0IXox.oIX0oI {

        /* renamed from: Oo, reason: collision with root package name */
        public int f29059Oo;

        /* renamed from: XO, reason: collision with root package name */
        @OXOo.OOXIXo
        public final byte[] f29060XO;

        public oIX0oI(@OXOo.OOXIXo byte[] array) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
            this.f29060XO = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f29059Oo < this.f29060XO.length) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ x0xO next() {
            return x0xO.oxoX(oIX0oI());
        }

        public byte oIX0oI() {
            int i = this.f29059Oo;
            byte[] bArr = this.f29060XO;
            if (i < bArr.length) {
                this.f29059Oo = i + 1;
                return x0xO.oOoXoXO(bArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f29059Oo));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @o0
    public /* synthetic */ OO0x0xX(byte[] bArr) {
        this.f29058XO = bArr;
    }

    public static boolean II0XooXoX(byte[] bArr, @OXOo.OOXIXo Collection<x0xO> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Collection<x0xO> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof x0xO) || !ArraysKt___ArraysKt.IX0IO(bArr, ((x0xO) obj).I0oOIX())) {
                return false;
            }
        }
        return true;
    }

    public static final /* synthetic */ OO0x0xX II0xO0(byte[] bArr) {
        return new OO0x0xX(bArr);
    }

    public static final void IXxxXO(byte[] bArr, int i, byte b) {
        bArr[i] = b;
    }

    public static final byte OOXIXo(byte[] bArr, int i) {
        return x0xO.oOoXoXO(bArr[i]);
    }

    @OXOo.OOXIXo
    public static Iterator<x0xO> Oo(byte[] bArr) {
        return new oIX0oI(bArr);
    }

    public static boolean Oxx0IOOO(byte[] bArr, byte b) {
        return ArraysKt___ArraysKt.IX0IO(bArr, b);
    }

    public static String Oxx0xo(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + HexStringBuilder.COMMENT_END_CHAR;
    }

    @OXOo.OOXIXo
    @o0
    public static byte[] X0o0xo(@OXOo.OOXIXo byte[] storage) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(storage, "storage");
        return storage;
    }

    public static int oO(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static int ooOOo0oXI(byte[] bArr) {
        return bArr.length;
    }

    @OXOo.OOXIXo
    public static byte[] oxoX(int i) {
        return X0o0xo(new byte[i]);
    }

    @o0
    public static /* synthetic */ void x0XOIxOo() {
    }

    public static boolean x0xO0oo(byte[] bArr) {
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    public static final boolean xoIox(byte[] bArr, byte[] bArr2) {
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(bArr, bArr2);
    }

    public static boolean xxIXOIIO(byte[] bArr, Object obj) {
        return (obj instanceof OO0x0xX) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(bArr, ((OO0x0xX) obj).oI0IIXIo());
    }

    public boolean XO(byte b) {
        return Oxx0IOOO(this.f29058XO, b);
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(x0xO x0xo) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends x0xO> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof x0xO)) {
            return false;
        }
        return XO(((x0xO) obj).I0oOIX());
    }

    @Override // java.util.Collection
    public boolean containsAll(@OXOo.OOXIXo Collection<? extends Object> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        return II0XooXoX(this.f29058XO, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return xxIXOIIO(this.f29058XO, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return oO(this.f29058XO);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return x0xO0oo(this.f29058XO);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @OXOo.OOXIXo
    public Iterator<x0xO> iterator() {
        return Oo(this.f29058XO);
    }

    public final /* synthetic */ byte[] oI0IIXIo() {
        return this.f29058XO;
    }

    public boolean oIX0oI(byte b) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public int size() {
        return ooOOo0oXI(this.f29058XO);
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
        return Oxx0xo(this.f29058XO);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        return (T[]) kotlin.jvm.internal.OxxIIOOXO.II0xO0(this, array);
    }
}
