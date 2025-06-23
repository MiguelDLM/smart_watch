package androidx.collection;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import XO0OX.XO;
import XO0OX.xoIox;
import androidx.annotation.IntRange;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nObjectList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectList.kt\nandroidx/collection/ObjectList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1618:1\n305#1,6:1619\n331#1,6:1625\n305#1,6:1633\n305#1,6:1639\n305#1,6:1645\n305#1,6:1651\n305#1,6:1657\n318#1,6:1663\n331#1,6:1669\n345#1,6:1675\n75#1:1681\n75#1:1682\n318#1,6:1683\n318#1,6:1689\n318#1,6:1695\n345#1,6:1701\n75#1:1707\n331#1,6:1708\n75#1:1714\n331#1,6:1715\n345#1,6:1721\n345#1,6:1727\n318#1,6:1733\n305#1,6:1739\n80#1:1745\n1855#2,2:1631\n*S KotlinDebug\n*F\n+ 1 ObjectList.kt\nandroidx/collection/ObjectList\n*L\n101#1:1619,6\n115#1:1625,6\n168#1:1633,6\n186#1:1639,6\n209#1:1645,6\n227#1:1651,6\n244#1:1657,6\n260#1:1663,6\n277#1:1669,6\n293#1:1675,6\n358#1:1681\n369#1:1682\n399#1:1683,6\n405#1:1689,6\n421#1:1695,6\n435#1:1701,6\n461#1:1707\n472#1:1708,6\n483#1:1714\n492#1:1715,6\n509#1:1721,6\n515#1:1727,6\n545#1:1733,6\n576#1:1739,6\n592#1:1745\n157#1:1631,2\n*E\n"})
public abstract class ObjectList<E> {
    @XO
    public int _size;
    @XO
    @OOXIXo
    public Object[] content;

    public /* synthetic */ ObjectList(int i, IIXOooo iIXOooo) {
        this(i);
    }

    @o0
    public static /* synthetic */ void getContent$annotations() {
    }

    @o0
    public static /* synthetic */ void get_size$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, oOoXoXO oooxoxo, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = ", ";
            }
            CharSequence charSequence6 = "";
            if ((i2 & 2) != 0) {
                charSequence5 = charSequence6;
            } else {
                charSequence5 = charSequence2;
            }
            if ((i2 & 4) == 0) {
                charSequence6 = charSequence3;
            }
            if ((i2 & 8) != 0) {
                i3 = -1;
            } else {
                i3 = i;
            }
            if ((i2 & 16) != 0) {
                charSequence4 = "...";
            }
            CharSequence charSequence7 = charSequence4;
            if ((i2 & 32) != 0) {
                oooxoxo = null;
            }
            return objectList.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence7, oooxoxo);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean any() {
        return isNotEmpty();
    }

    @OOXIXo
    public abstract List<E> asList();

    public final boolean contains(E e) {
        if (indexOf(e) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsAll(@OOXIXo E[] eArr) {
        IIX0o.x0xO0oo(eArr, "elements");
        for (E contains : eArr) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final int count() {
        return this._size;
    }

    public final E elementAt(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final E elementAtOrElse(@IntRange(from = 0) int i, @OOXIXo oOoXoXO<? super Integer, ? extends E> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "defaultValue");
        if (i < 0 || i >= this._size) {
            return oooxoxo.invoke(Integer.valueOf(i));
        }
        return this.content[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r7 = (androidx.collection.ObjectList) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@OXOo.oOoXoXO java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.collection.ObjectList
            r1 = 0
            if (r0 == 0) goto L_0x0032
            androidx.collection.ObjectList r7 = (androidx.collection.ObjectList) r7
            int r0 = r7._size
            int r2 = r6._size
            if (r0 == r2) goto L_0x000e
            goto L_0x0032
        L_0x000e:
            java.lang.Object[] r0 = r6.content
            java.lang.Object[] r7 = r7.content
            X0.oOoXoXO r2 = X0.IIXOooo.X00xOoXI(r1, r2)
            int r3 = r2.oxoX()
            int r2 = r2.X0o0xo()
            if (r3 > r2) goto L_0x0030
        L_0x0020:
            r4 = r0[r3]
            r5 = r7[r3]
            boolean r4 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r4, r5)
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            if (r3 == r2) goto L_0x0030
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0030:
            r7 = 1
            return r7
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.equals(java.lang.Object):boolean");
    }

    public final E first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        throw new NoSuchElementException("ObjectList is empty.");
    }

    @OXOo.oOoXoXO
    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [Oox.x0xO0oo<? super R, ? super E, ? extends R>, Oox.x0xO0oo, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R fold(R r5, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super E, ? extends R> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r0)
            java.lang.Object[] r0 = r4.content
            int r1 = r4._size
            r2 = 0
        L_0x000a:
            if (r2 >= r1) goto L_0x0015
            r3 = r0[r2]
            java.lang.Object r5 = r6.invoke(r5, r3)
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0015:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.fold(java.lang.Object, Oox.x0xO0oo):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.Object, Oox.IXxxXO<? super java.lang.Integer, ? super R, ? super E, ? extends R>, Oox.IXxxXO] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldIndexed(R r6, @OXOo.OOXIXo Oox.IXxxXO<? super java.lang.Integer, ? super R, ? super E, ? extends R> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            java.lang.Object[] r0 = r5.content
            int r1 = r5._size
            r2 = 0
        L_0x000a:
            if (r2 >= r1) goto L_0x0019
            r3 = r0[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            java.lang.Object r6 = r7.invoke(r4, r6, r3)
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0019:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.foldIndexed(java.lang.Object, Oox.IXxxXO):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [Oox.x0xO0oo<? super E, ? super R, ? extends R>, Oox.x0xO0oo, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRight(R r4, @OXOo.OOXIXo Oox.x0xO0oo<? super E, ? super R, ? extends R> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
            java.lang.Object[] r0 = r3.content
            int r1 = r3._size
            int r1 = r1 + -1
        L_0x000b:
            r2 = -1
            if (r2 >= r1) goto L_0x0017
            r2 = r0[r1]
            java.lang.Object r4 = r5.invoke(r2, r4)
            int r1 = r1 + -1
            goto L_0x000b
        L_0x0017:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.foldRight(java.lang.Object, Oox.x0xO0oo):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object, Oox.IXxxXO<? super java.lang.Integer, ? super E, ? super R, ? extends R>, Oox.IXxxXO] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRightIndexed(R r5, @OXOo.OOXIXo Oox.IXxxXO<? super java.lang.Integer, ? super E, ? super R, ? extends R> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r0)
            java.lang.Object[] r0 = r4.content
            int r1 = r4._size
            int r1 = r1 + -1
        L_0x000b:
            r2 = -1
            if (r2 >= r1) goto L_0x001b
            r2 = r0[r1]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            java.lang.Object r5 = r6.invoke(r3, r2, r5)
            int r1 = r1 + -1
            goto L_0x000b
        L_0x001b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.foldRightIndexed(java.lang.Object, Oox.IXxxXO):java.lang.Object");
    }

    public final void forEach(@OOXIXo oOoXoXO<? super E, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "block");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            oooxoxo.invoke(objArr[i2]);
        }
    }

    public final void forEachIndexed(@OOXIXo x0xO0oo<? super Integer, ? super E, oXIO0o0XI> x0xo0oo) {
        IIX0o.x0xO0oo(x0xo0oo, "block");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            x0xo0oo.invoke(Integer.valueOf(i2), objArr[i2]);
        }
    }

    public final void forEachReversed(@OOXIXo oOoXoXO<? super E, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "block");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                oooxoxo.invoke(objArr[i]);
            } else {
                return;
            }
        }
    }

    public final void forEachReversedIndexed(@OOXIXo x0xO0oo<? super Integer, ? super E, oXIO0o0XI> x0xo0oo) {
        IIX0o.x0xO0oo(x0xo0oo, "block");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                x0xo0oo.invoke(Integer.valueOf(i), objArr[i]);
            } else {
                return;
            }
        }
    }

    public final E get(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    @OOXIXo
    public final X0.oOoXoXO getIndices() {
        return X0.IIXOooo.X00xOoXI(0, this._size);
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int i;
        Object[] objArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i3 += i * 31;
        }
        return i3;
    }

    public final int indexOf(E e) {
        int i = 0;
        if (e == null) {
            Object[] objArr = this.content;
            int i2 = this._size;
            while (i < i2) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        Object[] objArr2 = this.content;
        int i3 = this._size;
        while (i < i3) {
            if (e.equals(objArr2[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final int indexOfFirst(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (oooxoxo.invoke(objArr[i2]).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public final int indexOfLast(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return -1;
            }
            if (oooxoxo.invoke(objArr[i]).booleanValue()) {
                return i;
            }
        }
    }

    public final boolean isEmpty() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size != 0) {
            return true;
        }
        return false;
    }

    @xoIox
    @OOXIXo
    public final String joinToString() {
        return joinToString$default(this, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (oOoXoXO) null, 63, (Object) null);
    }

    public final E last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        throw new NoSuchElementException("ObjectList is empty.");
    }

    public final int lastIndexOf(E e) {
        if (e == null) {
            Object[] objArr = this.content;
            for (int i = this._size - 1; -1 < i; i--) {
                if (objArr[i] == null) {
                    return i;
                }
            }
        } else {
            Object[] objArr2 = this.content;
            for (int i2 = this._size - 1; -1 < i2; i2--) {
                if (e.equals(objArr2[i2])) {
                    return i2;
                }
            }
        }
        return -1;
    }

    @OXOo.oOoXoXO
    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.content[this._size - 1];
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        Object[] objArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (oooxoxo.invoke(objArr[i]).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @OOXIXo
    public String toString() {
        return joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, new ObjectList$toString$1(this), 25, (Object) null);
    }

    private ObjectList(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = ObjectListKt.EmptyArray;
        } else {
            objArr = new Object[i];
        }
        this.content = objArr;
    }

    public final boolean any(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (oooxoxo.invoke(objArr[i2]).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (oooxoxo.invoke(objArr[i3]).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @OXOo.oOoXoXO
    public final E firstOrNull(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        E[] eArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            E e = eArr[i2];
            if (oooxoxo.invoke(e).booleanValue()) {
                return e;
            }
        }
        return null;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "separator");
        return joinToString$default(this, charSequence, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (oOoXoXO) null, 62, (Object) null);
    }

    public final boolean containsAll(@OOXIXo List<? extends E> list) {
        IIX0o.x0xO0oo(list, "elements");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        return joinToString$default(this, charSequence, charSequence2, (CharSequence) null, 0, (CharSequence) null, (oOoXoXO) null, 60, (Object) null);
    }

    @OXOo.oOoXoXO
    public final E lastOrNull(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        E[] eArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return null;
            }
            E e = eArr[i];
            if (oooxoxo.invoke(e).booleanValue()) {
                return e;
            }
        }
    }

    public final E first(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        E[] eArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            E e = eArr[i2];
            if (oooxoxo.invoke(e).booleanValue()) {
                return e;
            }
        }
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, (oOoXoXO) null, 56, (Object) null);
    }

    public final boolean containsAll(@OOXIXo Iterable<? extends E> iterable) {
        IIX0o.x0xO0oo(iterable, "elements");
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, (CharSequence) null, (oOoXoXO) null, 48, (Object) null);
    }

    public final E last(@OOXIXo oOoXoXO<? super E, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        E[] eArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                E e = eArr[i];
                if (oooxoxo.invoke(e).booleanValue()) {
                    return e;
                }
            } else {
                throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
            }
        }
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo CharSequence charSequence4) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        IIX0o.x0xO0oo(charSequence4, "truncated");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, charSequence4, (oOoXoXO) null, 32, (Object) null);
    }

    public final boolean containsAll(@OOXIXo ObjectList<E> objectList) {
        IIX0o.x0xO0oo(objectList, "elements");
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (!contains(objArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo CharSequence charSequence4, @OXOo.oOoXoXO oOoXoXO<? super E, ? extends CharSequence> oooxoxo) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        IIX0o.x0xO0oo(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        Object[] objArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            Object obj = objArr[i3];
            if (i3 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            if (oooxoxo == null) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) oooxoxo.invoke(obj));
            }
            i3++;
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
