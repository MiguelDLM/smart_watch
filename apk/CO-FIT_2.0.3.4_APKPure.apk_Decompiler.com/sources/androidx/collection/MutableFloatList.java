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

@XX({"SMAP\nFloatList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatList.kt\nandroidx/collection/MutableFloatList\n+ 2 FloatList.kt\nandroidx/collection/FloatList\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,969:1\n549#1:970\n70#2:971\n253#2,6:974\n70#2:980\n70#2:981\n70#2:982\n70#2:989\n70#2:990\n13614#3,2:972\n1687#3,6:983\n*S KotlinDebug\n*F\n+ 1 FloatList.kt\nandroidx/collection/MutableFloatList\n*L\n692#1:970\n753#1:971\n772#1:974,6\n783#1:980\n787#1:981\n834#1:982\n850#1:989\n869#1:990\n763#1:972,2\n836#1:983,6\n*E\n"})
public final class MutableFloatList extends FloatList {
    public MutableFloatList() {
        this(0, 1, (IIXOooo) null);
    }

    public static /* synthetic */ void trim$default(MutableFloatList mutableFloatList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mutableFloatList._size;
        }
        mutableFloatList.trim(i);
    }

    public final boolean add(float f) {
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        int i = this._size;
        fArr[i] = f;
        this._size = i + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i, @OOXIXo float[] fArr) {
        int i2;
        IIX0o.x0xO0oo(fArr, "elements");
        if (i < 0 || i > (i2 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (fArr.length == 0) {
            return false;
        } else {
            ensureCapacity(i2 + fArr.length);
            float[] fArr2 = this.content;
            int i3 = this._size;
            if (i != i3) {
                ooOOo0oXI.OOXIxO0(fArr2, fArr2, fArr.length + i, i, i3);
            }
            ooOOo0oXI.oXIO0o0XI(fArr, fArr2, i, 0, 0, 12, (Object) null);
            this._size += fArr.length;
            return true;
        }
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i) {
        float[] fArr = this.content;
        if (fArr.length < i) {
            float[] copyOf = Arrays.copyOf(fArr, Math.max(i, (fArr.length * 3) / 2));
            IIX0o.oO(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(float f) {
        remove(f);
    }

    public final void plusAssign(@OOXIXo FloatList floatList) {
        IIX0o.x0xO0oo(floatList, "elements");
        addAll(this._size, floatList);
    }

    public final boolean remove(float f) {
        int indexOf = indexOf(f);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(@OOXIXo float[] fArr) {
        IIX0o.x0xO0oo(fArr, "elements");
        int i = this._size;
        for (float remove : fArr) {
            remove(remove);
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final float removeAt(@IntRange(from = 0) int i) {
        int i2;
        if (i < 0 || i >= (i2 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        float[] fArr = this.content;
        float f = fArr[i];
        if (i != i2 - 1) {
            ooOOo0oXI.OOXIxO0(fArr, fArr, i, i + 1, i2);
        }
        this._size--;
        return f;
    }

    public final void removeRange(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        int i3;
        if (i < 0 || i > (i3 = this._size) || i2 < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException("Start (" + i + ") and end (" + i2 + ") must be in 0.." + this._size);
        } else if (i2 < i) {
            throw new IllegalArgumentException("Start (" + i + ") is more than end (" + i2 + HexStringBuilder.COMMENT_END_CHAR);
        } else if (i2 != i) {
            if (i2 < i3) {
                float[] fArr = this.content;
                ooOOo0oXI.OOXIxO0(fArr, fArr, i, i2, i3);
            }
            this._size -= i2 - i;
        }
    }

    public final boolean retainAll(@OOXIXo float[] fArr) {
        IIX0o.x0xO0oo(fArr, "elements");
        int i = this._size;
        float[] fArr2 = this.content;
        int i2 = i - 1;
        while (true) {
            int i3 = 0;
            int i4 = -1;
            if (-1 >= i2) {
                break;
            }
            float f = fArr2[i2];
            int length = fArr.length;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (fArr[i3] == f) {
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

    public final float set(@IntRange(from = 0) int i, float f) {
        if (i < 0 || i >= this._size) {
            StringBuilder sb = new StringBuilder();
            sb.append("set index ");
            sb.append(i);
            sb.append(" must be between 0 .. ");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        float[] fArr = this.content;
        float f2 = fArr[i];
        fArr[i] = f;
        return f2;
    }

    public final void sort() {
        ooOOo0oXI.oOIx(this.content, 0, this._size);
    }

    public final void sortDescending() {
        ArraysKt___ArraysKt.x000IxIoI(this.content, 0, this._size);
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        float[] fArr = this.content;
        if (fArr.length > max) {
            float[] copyOf = Arrays.copyOf(fArr, max);
            IIX0o.oO(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableFloatList(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final void minusAssign(@OOXIXo float[] fArr) {
        IIX0o.x0xO0oo(fArr, "elements");
        for (float remove : fArr) {
            remove(remove);
        }
    }

    public final void plusAssign(@OOXIXo float[] fArr) {
        IIX0o.x0xO0oo(fArr, "elements");
        addAll(this._size, fArr);
    }

    public MutableFloatList(int i) {
        super(i, (IIXOooo) null);
    }

    public final void plusAssign(float f) {
        add(f);
    }

    public final void add(@IntRange(from = 0) int i, float f) {
        int i2;
        if (i < 0 || i > (i2 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        }
        ensureCapacity(i2 + 1);
        float[] fArr = this.content;
        int i3 = this._size;
        if (i != i3) {
            ooOOo0oXI.OOXIxO0(fArr, fArr, i + 1, i, i3);
        }
        fArr[i] = f;
        this._size++;
    }

    public final void minusAssign(@OOXIXo FloatList floatList) {
        IIX0o.x0xO0oo(floatList, "elements");
        float[] fArr = floatList.content;
        int i = floatList._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(fArr[i2]);
        }
    }

    public final boolean removeAll(@OOXIXo FloatList floatList) {
        IIX0o.x0xO0oo(floatList, "elements");
        int i = this._size;
        int i2 = floatList._size - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                remove(floatList.get(i3));
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

    public final boolean retainAll(@OOXIXo FloatList floatList) {
        IIX0o.x0xO0oo(floatList, "elements");
        int i = this._size;
        float[] fArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!floatList.contains(fArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i, @OOXIXo FloatList floatList) {
        IIX0o.x0xO0oo(floatList, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (floatList.isEmpty()) {
            return false;
        } else {
            ensureCapacity(this._size + floatList._size);
            float[] fArr = this.content;
            int i2 = this._size;
            if (i != i2) {
                ooOOo0oXI.OOXIxO0(fArr, fArr, floatList._size + i, i, i2);
            }
            ooOOo0oXI.OOXIxO0(floatList.content, fArr, i, 0, floatList._size);
            this._size += floatList._size;
            return true;
        }
    }

    public final boolean addAll(@OOXIXo FloatList floatList) {
        IIX0o.x0xO0oo(floatList, "elements");
        return addAll(this._size, floatList);
    }

    public final boolean addAll(@OOXIXo float[] fArr) {
        IIX0o.x0xO0oo(fArr, "elements");
        return addAll(this._size, fArr);
    }
}
