package androidx.collection;

import OXOo.OOXIXo;
import androidx.annotation.IntRange;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nIntList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntList.kt\nandroidx/collection/MutableIntList\n+ 2 IntList.kt\nandroidx/collection/IntList\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,969:1\n549#1:970\n70#2:971\n253#2,6:974\n70#2:980\n70#2:981\n70#2:982\n70#2:989\n70#2:990\n13600#3,2:972\n1663#3,6:983\n*S KotlinDebug\n*F\n+ 1 IntList.kt\nandroidx/collection/MutableIntList\n*L\n692#1:970\n753#1:971\n772#1:974,6\n783#1:980\n787#1:981\n834#1:982\n850#1:989\n869#1:990\n763#1:972,2\n836#1:983,6\n*E\n"})
public final class MutableIntList extends IntList {
    public MutableIntList() {
        this(0, 1, (IIXOooo) null);
    }

    public static /* synthetic */ void trim$default(MutableIntList mutableIntList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mutableIntList._size;
        }
        mutableIntList.trim(i);
    }

    public final boolean add(int i) {
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i2 = this._size;
        iArr[i2] = i;
        this._size = i2 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i, @OOXIXo int[] iArr) {
        int i2;
        IIX0o.x0xO0oo(iArr, "elements");
        if (i < 0 || i > (i2 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (iArr.length == 0) {
            return false;
        } else {
            ensureCapacity(i2 + iArr.length);
            int[] iArr2 = this.content;
            int i3 = this._size;
            if (i != i3) {
                ooOOo0oXI.IIxOXoOo0(iArr2, iArr2, iArr.length + i, i, i3);
            }
            ooOOo0oXI.oOo(iArr, iArr2, i, 0, 0, 12, (Object) null);
            this._size += iArr.length;
            return true;
        }
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i) {
        int[] iArr = this.content;
        if (iArr.length < i) {
            int[] copyOf = Arrays.copyOf(iArr, Math.max(i, (iArr.length * 3) / 2));
            IIX0o.oO(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(int i) {
        remove(i);
    }

    public final void plusAssign(@OOXIXo IntList intList) {
        IIX0o.x0xO0oo(intList, "elements");
        addAll(this._size, intList);
    }

    public final boolean remove(int i) {
        int indexOf = indexOf(i);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(@OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(iArr, "elements");
        int i = this._size;
        for (int remove : iArr) {
            remove(remove);
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final int removeAt(@IntRange(from = 0) int i) {
        int i2;
        if (i < 0 || i >= (i2 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int[] iArr = this.content;
        int i3 = iArr[i];
        if (i != i2 - 1) {
            ooOOo0oXI.IIxOXoOo0(iArr, iArr, i, i + 1, i2);
        }
        this._size--;
        return i3;
    }

    public final void removeRange(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        int i3;
        if (i < 0 || i > (i3 = this._size) || i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException("Start (" + i + ") and end (" + i2 + ") must be in 0.." + this._size);
        } else if (i2 < i) {
            throw new IllegalArgumentException("Start (" + i + ") is more than end (" + i2 + HexStringBuilder.COMMENT_END_CHAR);
        } else if (i2 != i) {
            if (i2 < i3) {
                int[] iArr = this.content;
                ooOOo0oXI.IIxOXoOo0(iArr, iArr, i, i2, i3);
            }
            this._size -= i2 - i;
        }
    }

    public final boolean retainAll(@OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(iArr, "elements");
        int i = this._size;
        int[] iArr2 = this.content;
        int i2 = i - 1;
        while (true) {
            int i3 = 0;
            int i4 = -1;
            if (-1 >= i2) {
                break;
            }
            int i5 = iArr2[i2];
            int length = iArr.length;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (iArr[i3] == i5) {
                    i4 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i4 < 0) {
                removeAt(i2);
            }
            i2--;
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final int set(@IntRange(from = 0) int i, int i2) {
        if (i < 0 || i >= this._size) {
            StringBuilder sb = new StringBuilder();
            sb.append("set index ");
            sb.append(i);
            sb.append(" must be between 0 .. ");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int[] iArr = this.content;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    public final void sort() {
        ooOOo0oXI.o0xOIoxo(this.content, 0, this._size);
    }

    public final void sortDescending() {
        ArraysKt___ArraysKt.oXXOIo(this.content, 0, this._size);
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        int[] iArr = this.content;
        if (iArr.length > max) {
            int[] copyOf = Arrays.copyOf(iArr, max);
            IIX0o.oO(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableIntList(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final void minusAssign(@OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(iArr, "elements");
        for (int remove : iArr) {
            remove(remove);
        }
    }

    public final void plusAssign(@OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(iArr, "elements");
        addAll(this._size, iArr);
    }

    public MutableIntList(int i) {
        super(i, (IIXOooo) null);
    }

    public final void plusAssign(int i) {
        add(i);
    }

    public final void add(@IntRange(from = 0) int i, int i2) {
        int i3;
        if (i < 0 || i > (i3 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        }
        ensureCapacity(i3 + 1);
        int[] iArr = this.content;
        int i4 = this._size;
        if (i != i4) {
            ooOOo0oXI.IIxOXoOo0(iArr, iArr, i + 1, i, i4);
        }
        iArr[i] = i2;
        this._size++;
    }

    public final void minusAssign(@OOXIXo IntList intList) {
        IIX0o.x0xO0oo(intList, "elements");
        int[] iArr = intList.content;
        int i = intList._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(iArr[i2]);
        }
    }

    public final boolean removeAll(@OOXIXo IntList intList) {
        IIX0o.x0xO0oo(intList, "elements");
        int i = this._size;
        int i2 = intList._size - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                remove(intList.get(i3));
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final boolean retainAll(@OOXIXo IntList intList) {
        IIX0o.x0xO0oo(intList, "elements");
        int i = this._size;
        int[] iArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!intList.contains(iArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i, @OOXIXo IntList intList) {
        IIX0o.x0xO0oo(intList, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (intList.isEmpty()) {
            return false;
        } else {
            ensureCapacity(this._size + intList._size);
            int[] iArr = this.content;
            int i2 = this._size;
            if (i != i2) {
                ooOOo0oXI.IIxOXoOo0(iArr, iArr, intList._size + i, i, i2);
            }
            ooOOo0oXI.IIxOXoOo0(intList.content, iArr, i, 0, intList._size);
            this._size += intList._size;
            return true;
        }
    }

    public final boolean addAll(@OOXIXo IntList intList) {
        IIX0o.x0xO0oo(intList, "elements");
        return addAll(this._size, intList);
    }

    public final boolean addAll(@OOXIXo int[] iArr) {
        IIX0o.x0xO0oo(iArr, "elements");
        return addAll(this._size, iArr);
    }
}
