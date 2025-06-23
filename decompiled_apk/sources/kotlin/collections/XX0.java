package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

@kotlin.jvm.internal.XX({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n204#1:208\n204#1:209\n204#1:210\n1#2:207\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n106#1:208\n175#1:209\n188#1:210\n*E\n"})
/* loaded from: classes6.dex */
public final class XX0<T> extends II0xO0<T> implements RandomAccess {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f29132IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f29133Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f29134Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Object[] f29135XO;

    @kotlin.jvm.internal.XX({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n+ 2 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n1#1,206:1\n204#2:207\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n*L\n121#1:207\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI extends kotlin.collections.oIX0oI<T> {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public int f29136IXxxXO;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public int f29137Oxx0xo;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ XX0<T> f29138oI0IIXIo;

        public oIX0oI(XX0<T> xx02) {
            this.f29138oI0IIXIo = xx02;
            this.f29136IXxxXO = xx02.size();
            this.f29137Oxx0xo = xx02.f29132IXxxXO;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.oIX0oI
        public void oIX0oI() {
            if (this.f29136IXxxXO == 0) {
                II0xO0();
                return;
            }
            oxoX(this.f29138oI0IIXIo.f29135XO[this.f29137Oxx0xo]);
            this.f29137Oxx0xo = (this.f29137Oxx0xo + 1) % this.f29138oI0IIXIo.f29133Oo;
            this.f29136IXxxXO--;
        }
    }

    public XX0(@OXOo.OOXIXo Object[] buffer, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(buffer, "buffer");
        this.f29135XO = buffer;
        if (i >= 0) {
            if (i <= buffer.length) {
                this.f29133Oo = buffer.length;
                this.f29134Oxx0xo = i;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
    }

    public final boolean II0XooXoX() {
        if (size() == this.f29133Oo) {
            return true;
        }
        return false;
    }

    public final int Oxx0IOOO(int i, int i2) {
        return (i + i2) % this.f29133Oo;
    }

    public final void X0o0xo(T t) {
        if (!II0XooXoX()) {
            this.f29135XO[(this.f29132IXxxXO + size()) % this.f29133Oo] = t;
            this.f29134Oxx0xo = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    public final XX0<T> XO(int i) {
        Object[] array;
        int i2 = this.f29133Oo;
        int XI0IXoo2 = X0.IIXOooo.XI0IXoo(i2 + (i2 >> 1) + 1, i);
        if (this.f29132IXxxXO == 0) {
            array = Arrays.copyOf(this.f29135XO, XI0IXoo2);
            kotlin.jvm.internal.IIX0o.oO(array, "copyOf(...)");
        } else {
            array = toArray(new Object[XI0IXoo2]);
        }
        return new XX0<>(array, size());
    }

    @Override // kotlin.collections.II0xO0, java.util.List
    public T get(int i) {
        II0xO0.Companion.II0xO0(i, size());
        return (T) this.f29135XO[(this.f29132IXxxXO + i) % this.f29133Oo];
    }

    @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f29134Oxx0xo;
    }

    @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @OXOo.OOXIXo
    public Iterator<T> iterator() {
        return new oIX0oI(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @OXOo.OOXIXo
    public <T> T[] toArray(@OXOo.OOXIXo T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        int length = array.length;
        Object[] objArr = array;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.IIX0o.oO(objArr2, "copyOf(...)");
            objArr = objArr2;
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.f29132IXxxXO; i2 < size && i3 < this.f29133Oo; i3++) {
            objArr[i2] = this.f29135XO[i3];
            i2++;
        }
        while (i2 < size) {
            objArr[i2] = this.f29135XO[i];
            i2++;
            i++;
        }
        return (T[]) oI0IIXIo.x0XOIxOo(size, objArr);
    }

    public final void xxIXOIIO(int i) {
        if (i >= 0) {
            if (i <= size()) {
                if (i > 0) {
                    int i2 = this.f29132IXxxXO;
                    int i3 = (i2 + i) % this.f29133Oo;
                    if (i2 > i3) {
                        ooOOo0oXI.xX(this.f29135XO, null, i2, this.f29133Oo);
                        ooOOo0oXI.xX(this.f29135XO, null, 0, i3);
                    } else {
                        ooOOo0oXI.xX(this.f29135XO, null, i2, i3);
                    }
                    this.f29132IXxxXO = i3;
                    this.f29134Oxx0xo = size() - i;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
    }

    public XX0(int i) {
        this(new Object[i], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @OXOo.OOXIXo
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
