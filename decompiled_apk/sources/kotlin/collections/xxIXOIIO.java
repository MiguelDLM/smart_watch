package kotlin.collections;

import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.IIX0;
import kotlin.oXIO0o0XI;

@IIX0(markerClass = {kotlin.IXxxXO.class})
@kotlin.oxxXoxO(version = BuildConfig.VERSION_NAME)
@kotlin.jvm.internal.XX({"SMAP\nArrayDeque.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,569:1\n467#1,51:572\n467#1,51:623\n37#2,2:570\n26#3:674\n*S KotlinDebug\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n*L\n462#1:572,51\n464#1:623,51\n47#1:570,2\n559#1:674\n*E\n"})
/* loaded from: classes6.dex */
public final class xxIXOIIO<E> extends oxoX<E> {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f29184OxxIIOOXO = 10;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f29186IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public Object[] f29187Oo;

    /* renamed from: XO, reason: collision with root package name */
    public int f29188XO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29183Oxx0xo = new oIX0oI(null);

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Object[] f29185oI0IIXIo = new Object[0];

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public xxIXOIIO(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = f29185oI0IIXIo;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        }
        this.f29187Oo = objArr;
    }

    private final void X0o0xo(int i) {
        if (i >= 0) {
            Object[] objArr = this.f29187Oo;
            if (i <= objArr.length) {
                return;
            }
            if (objArr == f29185oI0IIXIo) {
                this.f29187Oo = new Object[X0.IIXOooo.OxxIIOOXO(i, 10)];
                return;
            } else {
                II0xO0(II0xO0.Companion.X0o0xo(objArr.length, i));
                return;
            }
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final int II0XooXoX(int i) {
        if (i == ArraysKt___ArraysKt.o0IXO(this.f29187Oo)) {
            return 0;
        }
        return i + 1;
    }

    public final void II0xO0(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.f29187Oo;
        ooOOo0oXI.ooOx(objArr2, objArr, 0, this.f29188XO, objArr2.length);
        Object[] objArr3 = this.f29187Oo;
        int length = objArr3.length;
        int i2 = this.f29188XO;
        ooOOo0oXI.ooOx(objArr3, objArr, length - i2, 0, i2);
        this.f29188XO = 0;
        this.f29187Oo = objArr;
    }

    @OXOo.OOXIXo
    public final <T> T[] IXxxXO(@OXOo.OOXIXo T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        return (T[]) toArray(array);
    }

    public final void OOXIXo(@OXOo.OOXIXo Oox.x0xO0oo<? super Integer, ? super Object[], oXIO0o0XI> structure) {
        int i;
        int i2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(structure, "structure");
        int x0XOIxOo2 = x0XOIxOo(this.f29188XO + size());
        if (!isEmpty() && (i2 = this.f29188XO) >= x0XOIxOo2) {
            i = i2 - this.f29187Oo.length;
        } else {
            i = this.f29188XO;
        }
        structure.invoke(Integer.valueOf(i), toArray());
    }

    @OXOo.OOXIXo
    public final Object[] Oo() {
        return toArray();
    }

    @OXOo.oOoXoXO
    public final E Oxx0IOOO() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f29187Oo[this.f29188XO];
    }

    public final boolean XO(Oox.oOoXoXO<? super E, Boolean> oooxoxo) {
        int x0XOIxOo2;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f29187Oo.length != 0) {
            int x0XOIxOo3 = x0XOIxOo(this.f29188XO + size());
            int i = this.f29188XO;
            if (i < x0XOIxOo3) {
                x0XOIxOo2 = i;
                while (i < x0XOIxOo3) {
                    Object obj = this.f29187Oo[i];
                    if (oooxoxo.invoke(obj).booleanValue()) {
                        this.f29187Oo[x0XOIxOo2] = obj;
                        x0XOIxOo2++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                ooOOo0oXI.xX(this.f29187Oo, null, x0XOIxOo2, x0XOIxOo3);
            } else {
                int length = this.f29187Oo.length;
                int i2 = i;
                boolean z2 = false;
                while (i < length) {
                    Object[] objArr = this.f29187Oo;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (oooxoxo.invoke(obj2).booleanValue()) {
                        this.f29187Oo[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                x0XOIxOo2 = x0XOIxOo(i2);
                for (int i3 = 0; i3 < x0XOIxOo3; i3++) {
                    Object[] objArr2 = this.f29187Oo;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (oooxoxo.invoke(obj3).booleanValue()) {
                        this.f29187Oo[x0XOIxOo2] = obj3;
                        x0XOIxOo2 = II0XooXoX(x0XOIxOo2);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                this.f29186IXxxXO = ooOOo0oXI(x0XOIxOo2 - this.f29188XO);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@OXOo.OOXIXo Collection<? extends E> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        X0o0xo(size() + elements.size());
        oIX0oI(x0XOIxOo(this.f29188XO + size()), elements);
        return true;
    }

    public final void addFirst(E e) {
        X0o0xo(size() + 1);
        int oxoX2 = oxoX(this.f29188XO);
        this.f29188XO = oxoX2;
        this.f29187Oo[oxoX2] = e;
        this.f29186IXxxXO = size() + 1;
    }

    public final void addLast(E e) {
        X0o0xo(size() + 1);
        this.f29187Oo[x0XOIxOo(this.f29188XO + size())] = e;
        this.f29186IXxxXO = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int x0XOIxOo2 = x0XOIxOo(this.f29188XO + size());
        int i = this.f29188XO;
        if (i < x0XOIxOo2) {
            ooOOo0oXI.xX(this.f29187Oo, null, i, x0XOIxOo2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f29187Oo;
            ooOOo0oXI.xX(objArr, null, this.f29188XO, objArr.length);
            ooOOo0oXI.xX(this.f29187Oo, null, 0, x0XOIxOo2);
        }
        this.f29188XO = 0;
        this.f29186IXxxXO = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final E first() {
        if (!isEmpty()) {
            return (E) this.f29187Oo[this.f29188XO];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        II0xO0.Companion.II0xO0(i, size());
        return (E) this.f29187Oo[x0XOIxOo(this.f29188XO + i)];
    }

    @Override // kotlin.collections.oxoX
    public int getSize() {
        return this.f29186IXxxXO;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i;
        int x0XOIxOo2 = x0XOIxOo(this.f29188XO + size());
        int i2 = this.f29188XO;
        if (i2 < x0XOIxOo2) {
            while (i2 < x0XOIxOo2) {
                if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, this.f29187Oo[i2])) {
                    i = this.f29188XO;
                } else {
                    i2++;
                }
            }
            return -1;
        }
        if (i2 >= x0XOIxOo2) {
            int length = this.f29187Oo.length;
            while (true) {
                if (i2 < length) {
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, this.f29187Oo[i2])) {
                        i = this.f29188XO;
                        break;
                    }
                    i2++;
                } else {
                    for (int i3 = 0; i3 < x0XOIxOo2; i3++) {
                        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, this.f29187Oo[i3])) {
                            i2 = i3 + this.f29187Oo.length;
                            i = this.f29188XO;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return i2 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final E last() {
        if (!isEmpty()) {
            return (E) this.f29187Oo[x0XOIxOo(this.f29188XO + CollectionsKt__CollectionsKt.oo0xXOI0I(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int o0IXO;
        int i;
        int x0XOIxOo2 = x0XOIxOo(this.f29188XO + size());
        int i2 = this.f29188XO;
        if (i2 < x0XOIxOo2) {
            o0IXO = x0XOIxOo2 - 1;
            if (i2 <= o0IXO) {
                while (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, this.f29187Oo[o0IXO])) {
                    if (o0IXO != i2) {
                        o0IXO--;
                    }
                }
                i = this.f29188XO;
                return o0IXO - i;
            }
            return -1;
        }
        if (i2 > x0XOIxOo2) {
            int i3 = x0XOIxOo2 - 1;
            while (true) {
                if (-1 < i3) {
                    if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, this.f29187Oo[i3])) {
                        o0IXO = i3 + this.f29187Oo.length;
                        i = this.f29188XO;
                        break;
                    }
                    i3--;
                } else {
                    o0IXO = ArraysKt___ArraysKt.o0IXO(this.f29187Oo);
                    int i4 = this.f29188XO;
                    if (i4 <= o0IXO) {
                        while (!kotlin.jvm.internal.IIX0o.Oxx0IOOO(obj, this.f29187Oo[o0IXO])) {
                            if (o0IXO != i4) {
                                o0IXO--;
                            }
                        }
                        i = this.f29188XO;
                    }
                }
            }
        }
        return -1;
    }

    public final void oIX0oI(int i, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f29187Oo.length;
        while (i < length && it.hasNext()) {
            this.f29187Oo[i] = it.next();
            i++;
        }
        int i2 = this.f29188XO;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.f29187Oo[i3] = it.next();
        }
        this.f29186IXxxXO = size() + collection.size();
    }

    @OXOo.oOoXoXO
    public final E oO() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @OXOo.oOoXoXO
    public final E oOoXoXO() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f29187Oo[x0XOIxOo(this.f29188XO + CollectionsKt__CollectionsKt.oo0xXOI0I(this))];
    }

    public final int ooOOo0oXI(int i) {
        if (i < 0) {
            return i + this.f29187Oo.length;
        }
        return i;
    }

    public final int oxoX(int i) {
        if (i == 0) {
            return ArraysKt___ArraysKt.o0IXO(this.f29187Oo);
        }
        return i - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@OXOo.OOXIXo Collection<? extends Object> elements) {
        int x0XOIxOo2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f29187Oo.length != 0) {
            int x0XOIxOo3 = x0XOIxOo(this.f29188XO + size());
            int i = this.f29188XO;
            if (i < x0XOIxOo3) {
                x0XOIxOo2 = i;
                while (i < x0XOIxOo3) {
                    Object obj = this.f29187Oo[i];
                    if (!elements.contains(obj)) {
                        this.f29187Oo[x0XOIxOo2] = obj;
                        x0XOIxOo2++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                ooOOo0oXI.xX(this.f29187Oo, null, x0XOIxOo2, x0XOIxOo3);
            } else {
                int length = this.f29187Oo.length;
                int i2 = i;
                boolean z2 = false;
                while (i < length) {
                    Object[] objArr = this.f29187Oo;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (!elements.contains(obj2)) {
                        this.f29187Oo[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                x0XOIxOo2 = x0XOIxOo(i2);
                for (int i3 = 0; i3 < x0XOIxOo3; i3++) {
                    Object[] objArr2 = this.f29187Oo;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (!elements.contains(obj3)) {
                        this.f29187Oo[x0XOIxOo2] = obj3;
                        x0XOIxOo2 = II0XooXoX(x0XOIxOo2);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                this.f29186IXxxXO = ooOOo0oXI(x0XOIxOo2 - this.f29188XO);
            }
        }
        return z;
    }

    @Override // kotlin.collections.oxoX
    public E removeAt(int i) {
        II0xO0.Companion.II0xO0(i, size());
        if (i == CollectionsKt__CollectionsKt.oo0xXOI0I(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        int x0XOIxOo2 = x0XOIxOo(this.f29188XO + i);
        E e = (E) this.f29187Oo[x0XOIxOo2];
        if (i < (size() >> 1)) {
            int i2 = this.f29188XO;
            if (x0XOIxOo2 >= i2) {
                Object[] objArr = this.f29187Oo;
                ooOOo0oXI.ooOx(objArr, objArr, i2 + 1, i2, x0XOIxOo2);
            } else {
                Object[] objArr2 = this.f29187Oo;
                ooOOo0oXI.ooOx(objArr2, objArr2, 1, 0, x0XOIxOo2);
                Object[] objArr3 = this.f29187Oo;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i3 = this.f29188XO;
                ooOOo0oXI.ooOx(objArr3, objArr3, i3 + 1, i3, objArr3.length - 1);
            }
            Object[] objArr4 = this.f29187Oo;
            int i4 = this.f29188XO;
            objArr4[i4] = null;
            this.f29188XO = II0XooXoX(i4);
        } else {
            int x0XOIxOo3 = x0XOIxOo(this.f29188XO + CollectionsKt__CollectionsKt.oo0xXOI0I(this));
            if (x0XOIxOo2 <= x0XOIxOo3) {
                Object[] objArr5 = this.f29187Oo;
                ooOOo0oXI.ooOx(objArr5, objArr5, x0XOIxOo2, x0XOIxOo2 + 1, x0XOIxOo3 + 1);
            } else {
                Object[] objArr6 = this.f29187Oo;
                ooOOo0oXI.ooOx(objArr6, objArr6, x0XOIxOo2, x0XOIxOo2 + 1, objArr6.length);
                Object[] objArr7 = this.f29187Oo;
                objArr7[objArr7.length - 1] = objArr7[0];
                ooOOo0oXI.ooOx(objArr7, objArr7, 0, 1, x0XOIxOo3 + 1);
            }
            this.f29187Oo[x0XOIxOo3] = null;
        }
        this.f29186IXxxXO = size() - 1;
        return e;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            Object[] objArr = this.f29187Oo;
            int i = this.f29188XO;
            E e = (E) objArr[i];
            objArr[i] = null;
            this.f29188XO = II0XooXoX(i);
            this.f29186IXxxXO = size() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int x0XOIxOo2 = x0XOIxOo(this.f29188XO + CollectionsKt__CollectionsKt.oo0xXOI0I(this));
            Object[] objArr = this.f29187Oo;
            E e = (E) objArr[x0XOIxOo2];
            objArr[x0XOIxOo2] = null;
            this.f29186IXxxXO = size() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@OXOo.OOXIXo Collection<? extends Object> elements) {
        int x0XOIxOo2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f29187Oo.length != 0) {
            int x0XOIxOo3 = x0XOIxOo(this.f29188XO + size());
            int i = this.f29188XO;
            if (i < x0XOIxOo3) {
                x0XOIxOo2 = i;
                while (i < x0XOIxOo3) {
                    Object obj = this.f29187Oo[i];
                    if (elements.contains(obj)) {
                        this.f29187Oo[x0XOIxOo2] = obj;
                        x0XOIxOo2++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                ooOOo0oXI.xX(this.f29187Oo, null, x0XOIxOo2, x0XOIxOo3);
            } else {
                int length = this.f29187Oo.length;
                int i2 = i;
                boolean z2 = false;
                while (i < length) {
                    Object[] objArr = this.f29187Oo;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        this.f29187Oo[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                x0XOIxOo2 = x0XOIxOo(i2);
                for (int i3 = 0; i3 < x0XOIxOo3; i3++) {
                    Object[] objArr2 = this.f29187Oo;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (elements.contains(obj3)) {
                        this.f29187Oo[x0XOIxOo2] = obj3;
                        x0XOIxOo2 = II0XooXoX(x0XOIxOo2);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                this.f29186IXxxXO = ooOOo0oXI(x0XOIxOo2 - this.f29188XO);
            }
        }
        return z;
    }

    @Override // kotlin.collections.oxoX, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        II0xO0.Companion.II0xO0(i, size());
        int x0XOIxOo2 = x0XOIxOo(this.f29188XO + i);
        Object[] objArr = this.f29187Oo;
        E e2 = (E) objArr[x0XOIxOo2];
        objArr[x0XOIxOo2] = e;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @OXOo.OOXIXo
    public <T> T[] toArray(@OXOo.OOXIXo T[] array) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(array, "array");
        if (array.length < size()) {
            array = (T[]) OOXIXo.oIX0oI(array, size());
        }
        int x0XOIxOo2 = x0XOIxOo(this.f29188XO + size());
        int i = this.f29188XO;
        if (i < x0XOIxOo2) {
            ooOOo0oXI.IIX0(this.f29187Oo, array, 0, i, x0XOIxOo2, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f29187Oo;
            ooOOo0oXI.ooOx(objArr, array, 0, this.f29188XO, objArr.length);
            Object[] objArr2 = this.f29187Oo;
            ooOOo0oXI.ooOx(objArr2, array, objArr2.length - this.f29188XO, 0, x0XOIxOo2);
        }
        return (T[]) oI0IIXIo.x0XOIxOo(size(), array);
    }

    public final int x0XOIxOo(int i) {
        Object[] objArr = this.f29187Oo;
        if (i >= objArr.length) {
            return i - objArr.length;
        }
        return i;
    }

    @OXOo.oOoXoXO
    public final E x0xO0oo() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @xx0o0O.XO
    public final int xoIox(int i) {
        return x0XOIxOo(this.f29188XO + i);
    }

    @xx0o0O.XO
    public final E xxIXOIIO(int i) {
        return (E) this.f29187Oo[i];
    }

    @Override // kotlin.collections.oxoX, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        II0xO0.Companion.I0Io(i, size());
        if (i == size()) {
            addLast(e);
            return;
        }
        if (i == 0) {
            addFirst(e);
            return;
        }
        X0o0xo(size() + 1);
        int x0XOIxOo2 = x0XOIxOo(this.f29188XO + i);
        if (i < ((size() + 1) >> 1)) {
            int oxoX2 = oxoX(x0XOIxOo2);
            int oxoX3 = oxoX(this.f29188XO);
            int i2 = this.f29188XO;
            if (oxoX2 >= i2) {
                Object[] objArr = this.f29187Oo;
                objArr[oxoX3] = objArr[i2];
                ooOOo0oXI.ooOx(objArr, objArr, i2, i2 + 1, oxoX2 + 1);
            } else {
                Object[] objArr2 = this.f29187Oo;
                ooOOo0oXI.ooOx(objArr2, objArr2, i2 - 1, i2, objArr2.length);
                Object[] objArr3 = this.f29187Oo;
                objArr3[objArr3.length - 1] = objArr3[0];
                ooOOo0oXI.ooOx(objArr3, objArr3, 0, 1, oxoX2 + 1);
            }
            this.f29187Oo[oxoX2] = e;
            this.f29188XO = oxoX3;
        } else {
            int x0XOIxOo3 = x0XOIxOo(this.f29188XO + size());
            if (x0XOIxOo2 < x0XOIxOo3) {
                Object[] objArr4 = this.f29187Oo;
                ooOOo0oXI.ooOx(objArr4, objArr4, x0XOIxOo2 + 1, x0XOIxOo2, x0XOIxOo3);
            } else {
                Object[] objArr5 = this.f29187Oo;
                ooOOo0oXI.ooOx(objArr5, objArr5, 1, 0, x0XOIxOo3);
                Object[] objArr6 = this.f29187Oo;
                objArr6[0] = objArr6[objArr6.length - 1];
                ooOOo0oXI.ooOx(objArr6, objArr6, x0XOIxOo2 + 1, x0XOIxOo2, objArr6.length - 1);
            }
            this.f29187Oo[x0XOIxOo2] = e;
        }
        this.f29186IXxxXO = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, @OXOo.OOXIXo Collection<? extends E> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        II0xO0.Companion.I0Io(i, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(elements);
        }
        X0o0xo(size() + elements.size());
        int x0XOIxOo2 = x0XOIxOo(this.f29188XO + size());
        int x0XOIxOo3 = x0XOIxOo(this.f29188XO + i);
        int size = elements.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.f29188XO;
            int i3 = i2 - size;
            if (x0XOIxOo3 < i2) {
                Object[] objArr = this.f29187Oo;
                ooOOo0oXI.ooOx(objArr, objArr, i3, i2, objArr.length);
                if (size >= x0XOIxOo3) {
                    Object[] objArr2 = this.f29187Oo;
                    ooOOo0oXI.ooOx(objArr2, objArr2, objArr2.length - size, 0, x0XOIxOo3);
                } else {
                    Object[] objArr3 = this.f29187Oo;
                    ooOOo0oXI.ooOx(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f29187Oo;
                    ooOOo0oXI.ooOx(objArr4, objArr4, 0, size, x0XOIxOo3);
                }
            } else if (i3 >= 0) {
                Object[] objArr5 = this.f29187Oo;
                ooOOo0oXI.ooOx(objArr5, objArr5, i3, i2, x0XOIxOo3);
            } else {
                Object[] objArr6 = this.f29187Oo;
                i3 += objArr6.length;
                int i4 = x0XOIxOo3 - i2;
                int length = objArr6.length - i3;
                if (length >= i4) {
                    ooOOo0oXI.ooOx(objArr6, objArr6, i3, i2, x0XOIxOo3);
                } else {
                    ooOOo0oXI.ooOx(objArr6, objArr6, i3, i2, i2 + length);
                    Object[] objArr7 = this.f29187Oo;
                    ooOOo0oXI.ooOx(objArr7, objArr7, 0, this.f29188XO + length, x0XOIxOo3);
                }
            }
            this.f29188XO = i3;
            oIX0oI(ooOOo0oXI(x0XOIxOo3 - size), elements);
        } else {
            int i5 = x0XOIxOo3 + size;
            if (x0XOIxOo3 < x0XOIxOo2) {
                int i6 = size + x0XOIxOo2;
                Object[] objArr8 = this.f29187Oo;
                if (i6 <= objArr8.length) {
                    ooOOo0oXI.ooOx(objArr8, objArr8, i5, x0XOIxOo3, x0XOIxOo2);
                } else if (i5 >= objArr8.length) {
                    ooOOo0oXI.ooOx(objArr8, objArr8, i5 - objArr8.length, x0XOIxOo3, x0XOIxOo2);
                } else {
                    int length2 = x0XOIxOo2 - (i6 - objArr8.length);
                    ooOOo0oXI.ooOx(objArr8, objArr8, 0, length2, x0XOIxOo2);
                    Object[] objArr9 = this.f29187Oo;
                    ooOOo0oXI.ooOx(objArr9, objArr9, i5, x0XOIxOo3, length2);
                }
            } else {
                Object[] objArr10 = this.f29187Oo;
                ooOOo0oXI.ooOx(objArr10, objArr10, size, 0, x0XOIxOo2);
                Object[] objArr11 = this.f29187Oo;
                if (i5 >= objArr11.length) {
                    ooOOo0oXI.ooOx(objArr11, objArr11, i5 - objArr11.length, x0XOIxOo3, objArr11.length);
                } else {
                    ooOOo0oXI.ooOx(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f29187Oo;
                    ooOOo0oXI.ooOx(objArr12, objArr12, i5, x0XOIxOo3, objArr12.length - size);
                }
            }
            oIX0oI(x0XOIxOo3, elements);
        }
        return true;
    }

    public xxIXOIIO() {
        this.f29187Oo = f29185oI0IIXIo;
    }

    public xxIXOIIO(@OXOo.OOXIXo Collection<? extends E> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        this.f29187Oo = array;
        this.f29186IXxxXO = array.length;
        if (array.length == 0) {
            this.f29187Oo = f29185oI0IIXIo;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @OXOo.OOXIXo
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
