package androidx.collection;

import OXOo.OOXIXo;
import XO0OX.xoIox;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nCircularArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircularArray.kt\nandroidx/collection/CircularArray\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CollectionPlatformUtils.jvm.kt\nandroidx/collection/CollectionPlatformUtils\n*L\n1#1,270:1\n1#2:271\n26#3:272\n26#3:273\n26#3:274\n26#3:275\n26#3:276\n26#3:277\n26#3:278\n*S KotlinDebug\n*F\n+ 1 CircularArray.kt\nandroidx/collection/CircularArray\n*L\n104#1:272\n122#1:273\n152#1:274\n187#1:275\n221#1:276\n235#1:277\n249#1:278\n*E\n"})
/* loaded from: classes.dex */
public final class CircularArray<E> {
    private int capacityBitmask;

    @OOXIXo
    private E[] elements;
    private int head;
    private int tail;

    @xoIox
    public CircularArray() {
        this(0, 1, null);
    }

    private final void doubleCapacity() {
        E[] eArr = this.elements;
        int length = eArr.length;
        int i = this.head;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 >= 0) {
            E[] eArr2 = (E[]) new Object[i3];
            ooOOo0oXI.ooOx(eArr, eArr2, 0, i, length);
            ooOOo0oXI.ooOx(this.elements, eArr2, i2, 0, this.head);
            this.elements = eArr2;
            this.head = 0;
            this.tail = length;
            this.capacityBitmask = i3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public final void addFirst(E e) {
        int i = (this.head - 1) & this.capacityBitmask;
        this.head = i;
        this.elements[i] = e;
        if (i == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e) {
        E[] eArr = this.elements;
        int i = this.tail;
        eArr[i] = e;
        int i2 = this.capacityBitmask & (i + 1);
        this.tail = i2;
        if (i2 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final E get(int i) {
        if (i >= 0 && i < size()) {
            E e = this.elements[this.capacityBitmask & (this.head + i)];
            IIX0o.ooOOo0oXI(e);
            return e;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E getFirst() {
        int i = this.head;
        if (i != this.tail) {
            E e = this.elements[i];
            IIX0o.ooOOo0oXI(e);
            return e;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E getLast() {
        int i = this.head;
        int i2 = this.tail;
        if (i != i2) {
            E e = this.elements[(i2 - 1) & this.capacityBitmask];
            IIX0o.ooOOo0oXI(e);
            return e;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        if (this.head == this.tail) {
            return true;
        }
        return false;
    }

    public final E popFirst() {
        int i = this.head;
        if (i != this.tail) {
            E[] eArr = this.elements;
            E e = eArr[i];
            eArr[i] = null;
            this.head = (i + 1) & this.capacityBitmask;
            return e;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E popLast() {
        int i = this.head;
        int i2 = this.tail;
        if (i != i2) {
            int i3 = this.capacityBitmask & (i2 - 1);
            E[] eArr = this.elements;
            E e = eArr[i3];
            eArr[i3] = null;
            this.tail = i3;
            return e;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromEnd(int i) {
        int i2;
        if (i <= 0) {
            return;
        }
        if (i <= size()) {
            int i3 = this.tail;
            if (i < i3) {
                i2 = i3 - i;
            } else {
                i2 = 0;
            }
            for (int i4 = i2; i4 < i3; i4++) {
                this.elements[i4] = null;
            }
            int i5 = this.tail;
            int i6 = i5 - i2;
            int i7 = i - i6;
            this.tail = i5 - i6;
            if (i7 > 0) {
                int length = this.elements.length;
                this.tail = length;
                int i8 = length - i7;
                for (int i9 = i8; i9 < length; i9++) {
                    this.elements[i9] = null;
                }
                this.tail = i8;
                return;
            }
            return;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromStart(int i) {
        if (i <= 0) {
            return;
        }
        if (i <= size()) {
            int length = this.elements.length;
            int i2 = this.head;
            if (i < length - i2) {
                length = i2 + i;
            }
            while (i2 < length) {
                this.elements[i2] = null;
                i2++;
            }
            int i3 = this.head;
            int i4 = length - i3;
            int i5 = i - i4;
            this.head = this.capacityBitmask & (i3 + i4);
            if (i5 > 0) {
                for (int i6 = 0; i6 < i5; i6++) {
                    this.elements[i6] = null;
                }
                this.head = i5;
                return;
            }
            return;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    @xoIox
    public CircularArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.capacityBitmask = i - 1;
            this.elements = (E[]) new Object[i];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }

    public /* synthetic */ CircularArray(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 8 : i);
    }
}
