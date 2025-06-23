package androidx.collection;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import Oox.oOoXoXO;
import Oox.x0xO0oo;
import XO0OX.XO;
import XO0OX.xoIox;
import androidx.annotation.IntRange;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nObjectList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectList.kt\nandroidx/collection/ObjectList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1618:1\n305#1,6:1619\n331#1,6:1625\n305#1,6:1633\n305#1,6:1639\n305#1,6:1645\n305#1,6:1651\n305#1,6:1657\n318#1,6:1663\n331#1,6:1669\n345#1,6:1675\n75#1:1681\n75#1:1682\n318#1,6:1683\n318#1,6:1689\n318#1,6:1695\n345#1,6:1701\n75#1:1707\n331#1,6:1708\n75#1:1714\n331#1,6:1715\n345#1,6:1721\n345#1,6:1727\n318#1,6:1733\n305#1,6:1739\n80#1:1745\n1855#2,2:1631\n*S KotlinDebug\n*F\n+ 1 ObjectList.kt\nandroidx/collection/ObjectList\n*L\n101#1:1619,6\n115#1:1625,6\n168#1:1633,6\n186#1:1639,6\n209#1:1645,6\n227#1:1651,6\n244#1:1657,6\n260#1:1663,6\n277#1:1669,6\n293#1:1675,6\n358#1:1681\n369#1:1682\n399#1:1683,6\n405#1:1689,6\n421#1:1695,6\n435#1:1701,6\n461#1:1707\n472#1:1708,6\n483#1:1714\n492#1:1715,6\n509#1:1721,6\n515#1:1727,6\n545#1:1733,6\n576#1:1739,6\n592#1:1745\n157#1:1631,2\n*E\n"})
/* loaded from: classes.dex */
public abstract class ObjectList<E> {

    @XO
    public int _size;

    @OOXIXo
    @XO
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
                charSequence5 = "";
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

    public final boolean containsAll(@OOXIXo E[] elements) {
        IIX0o.x0xO0oo(elements, "elements");
        for (E e : elements) {
            if (!contains(e)) {
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
            return (E) this.content[i];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final E elementAtOrElse(@IntRange(from = 0) int i, @OOXIXo oOoXoXO<? super Integer, ? extends E> defaultValue) {
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i < this._size) {
            return (E) this.content[i];
        }
        return defaultValue.invoke(Integer.valueOf(i));
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof ObjectList) {
            ObjectList objectList = (ObjectList) obj;
            int i = objectList._size;
            int i2 = this._size;
            if (i == i2) {
                Object[] objArr = this.content;
                Object[] objArr2 = objectList.content;
                X0.oOoXoXO X00xOoXI2 = X0.IIXOooo.X00xOoXI(0, i2);
                int oxoX2 = X00xOoXI2.oxoX();
                int X0o0xo2 = X00xOoXI2.X0o0xo();
                if (oxoX2 <= X0o0xo2) {
                    while (IIX0o.Oxx0IOOO(objArr[oxoX2], objArr2[oxoX2])) {
                        if (oxoX2 != X0o0xo2) {
                            oxoX2++;
                        } else {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final E first() {
        if (!isEmpty()) {
            return (E) this.content[0];
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

    public final <R> R fold(R r, @OOXIXo x0xO0oo<? super R, ? super E, ? extends R> operation) {
        IIX0o.x0xO0oo(operation, "operation");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            r = operation.invoke(r, objArr[i2]);
        }
        return r;
    }

    public final <R> R foldIndexed(R r, @OOXIXo IXxxXO<? super Integer, ? super R, ? super E, ? extends R> operation) {
        IIX0o.x0xO0oo(operation, "operation");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            r = operation.invoke(Integer.valueOf(i2), r, objArr[i2]);
        }
        return r;
    }

    public final <R> R foldRight(R r, @OOXIXo x0xO0oo<? super E, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(operation, "operation");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return r;
            }
            r = operation.invoke(objArr[i], r);
        }
    }

    public final <R> R foldRightIndexed(R r, @OOXIXo IXxxXO<? super Integer, ? super E, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(operation, "operation");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return r;
            }
            r = operation.invoke(Integer.valueOf(i), objArr[i], r);
        }
    }

    public final void forEach(@OOXIXo oOoXoXO<? super E, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            block.invoke(objArr[i2]);
        }
    }

    public final void forEachIndexed(@OOXIXo x0xO0oo<? super Integer, ? super E, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            block.invoke(Integer.valueOf(i2), objArr[i2]);
        }
    }

    public final void forEachReversed(@OOXIXo oOoXoXO<? super E, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                block.invoke(objArr[i]);
            } else {
                return;
            }
        }
    }

    public final void forEachReversedIndexed(@OOXIXo x0xO0oo<? super Integer, ? super E, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                block.invoke(Integer.valueOf(i), objArr[i]);
            } else {
                return;
            }
        }
    }

    public final E get(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this._size) {
            return (E) this.content[i];
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

    public final int indexOfFirst(@OOXIXo oOoXoXO<? super E, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (predicate.invoke(objArr[i2]).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public final int indexOfLast(@OOXIXo oOoXoXO<? super E, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (!predicate.invoke(objArr[i]).booleanValue());
        return i;
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

    @OOXIXo
    @xoIox
    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final E last() {
        if (!isEmpty()) {
            return (E) this.content[this._size - 1];
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
        return (E) this.content[this._size - 1];
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(@OOXIXo oOoXoXO<? super E, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (predicate.invoke(objArr[i]).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @OOXIXo
    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new oOoXoXO<E, CharSequence>(this) { // from class: androidx.collection.ObjectList$toString$1
            final /* synthetic */ ObjectList<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
                return invoke((ObjectList$toString$1<E>) obj);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oOoXoXO
            @OOXIXo
            public final CharSequence invoke(E e) {
                if (e == this.this$0) {
                    return "(this)";
                }
                return String.valueOf(e);
            }
        }, 25, null);
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

    public final boolean any(@OOXIXo oOoXoXO<? super E, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (predicate.invoke(objArr[i2]).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(@OOXIXo oOoXoXO<? super E, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (predicate.invoke(objArr[i3]).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [E, java.lang.Object] */
    @OXOo.oOoXoXO
    public final E firstOrNull(@OOXIXo oOoXoXO<? super E, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            ?? r3 = (Object) objArr[i2];
            if (predicate.invoke(r3).booleanValue()) {
                return r3;
            }
        }
        return null;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator) {
        IIX0o.x0xO0oo(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, null, 62, null);
    }

    public final boolean containsAll(@OOXIXo List<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            if (!contains(elements.get(i))) {
                return false;
            }
        }
        return true;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, null, 60, null);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [E, java.lang.Object] */
    @OXOo.oOoXoXO
    public final E lastOrNull(@OOXIXo oOoXoXO<? super E, Boolean> predicate) {
        ?? r2;
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return null;
            }
            r2 = (Object) objArr[i];
        } while (!predicate.invoke(r2).booleanValue());
        return r2;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [E, java.lang.Object] */
    public final E first(@OOXIXo oOoXoXO<? super E, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            ?? r3 = (Object) objArr[i2];
            if (predicate.invoke(r3).booleanValue()) {
                return r3;
            }
        }
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, null, 56, null);
    }

    public final boolean containsAll(@OOXIXo Iterable<? extends E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, int i) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, null, 48, null);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [E, java.lang.Object] */
    public final E last(@OOXIXo oOoXoXO<? super E, Boolean> predicate) {
        ?? r2;
        IIX0o.x0xO0oo(predicate, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 < i) {
                r2 = (Object) objArr[i];
            } else {
                throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
            }
        } while (!predicate.invoke(r2).booleanValue());
        return r2;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, int i, @OOXIXo CharSequence truncated) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        IIX0o.x0xO0oo(truncated, "truncated");
        return joinToString$default(this, separator, prefix, postfix, i, truncated, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(@OOXIXo ObjectList<E> elements) {
        IIX0o.x0xO0oo(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (!contains(objArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, int i, @OOXIXo CharSequence truncated, @OXOo.oOoXoXO oOoXoXO<? super E, ? extends CharSequence> oooxoxo) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        IIX0o.x0xO0oo(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 < i2) {
                Object obj = objArr[i3];
                if (i3 == i) {
                    sb.append(truncated);
                    break;
                }
                if (i3 != 0) {
                    sb.append(separator);
                }
                if (oooxoxo == null) {
                    sb.append(obj);
                } else {
                    sb.append(oooxoxo.invoke(obj));
                }
                i3++;
            } else {
                sb.append(postfix);
                break;
            }
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
