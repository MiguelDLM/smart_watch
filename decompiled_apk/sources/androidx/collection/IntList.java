package androidx.collection;

import OXOo.OOXIXo;
import Oox.IXxxXO;
import Oox.x0xO0oo;
import X0.oOoXoXO;
import XO0OX.XO;
import XO0OX.xoIox;
import androidx.annotation.IntRange;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nIntList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntList.kt\nandroidx/collection/IntList\n*L\n1#1,969:1\n253#1,6:970\n279#1,6:976\n253#1,6:982\n75#1:988\n253#1,6:989\n253#1,6:995\n253#1,6:1001\n266#1,6:1007\n279#1,6:1013\n293#1,6:1019\n70#1:1025\n70#1:1026\n266#1,6:1027\n266#1,6:1033\n293#1,6:1039\n70#1:1045\n279#1,6:1046\n293#1,6:1052\n266#1,6:1058\n266#1,6:1064\n253#1,6:1070\n75#1:1076\n467#1,10:1077\n266#1,4:1087\n477#1,9:1091\n271#1:1100\n486#1,2:1101\n467#1,10:1103\n266#1,4:1113\n477#1,9:1117\n271#1:1126\n486#1,2:1127\n467#1,10:1129\n266#1,4:1139\n477#1,9:1143\n271#1:1152\n486#1,2:1153\n467#1,10:1155\n266#1,4:1165\n477#1,9:1169\n271#1:1178\n486#1,2:1179\n467#1,10:1181\n266#1,4:1191\n477#1,9:1195\n271#1:1204\n486#1,2:1205\n*S KotlinDebug\n*F\n+ 1 IntList.kt\nandroidx/collection/IntList\n*L\n96#1:970,6\n110#1:976,6\n122#1:982,6\n135#1:988\n153#1:989,6\n175#1:995,6\n192#1:1001,6\n208#1:1007,6\n225#1:1013,6\n241#1:1019,6\n306#1:1025\n317#1:1026\n343#1:1027,6\n357#1:1033,6\n371#1:1039,6\n397#1:1045\n407#1:1046,6\n420#1:1052,6\n445#1:1058,6\n476#1:1064,6\n494#1:1070,6\n510#1:1076\n-1#1:1077,10\n-1#1:1087,4\n-1#1:1091,9\n-1#1:1100\n-1#1:1101,2\n-1#1:1103,10\n-1#1:1113,4\n-1#1:1117,9\n-1#1:1126\n-1#1:1127,2\n-1#1:1129,10\n-1#1:1139,4\n-1#1:1143,9\n-1#1:1152\n-1#1:1153,2\n-1#1:1155,10\n-1#1:1165,4\n-1#1:1169,9\n-1#1:1178\n-1#1:1179,2\n-1#1:1181,10\n-1#1:1191,4\n-1#1:1195,9\n-1#1:1204\n-1#1:1205,2\n*E\n"})
/* loaded from: classes.dex */
public abstract class IntList {

    @XO
    public int _size;

    @OOXIXo
    @XO
    public int[] content;

    public /* synthetic */ IntList(int i, IIXOooo iIXOooo) {
        this(i);
    }

    @o0
    public static /* synthetic */ void getContent$annotations() {
    }

    @o0
    public static /* synthetic */ void get_size$annotations() {
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        return intList.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence4);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean contains(int i) {
        int[] iArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3] == i) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(@OOXIXo IntList elements) {
        IIX0o.x0xO0oo(elements, "elements");
        oOoXoXO X00xOoXI2 = X0.IIXOooo.X00xOoXI(0, elements._size);
        int oxoX2 = X00xOoXI2.oxoX();
        int X0o0xo2 = X00xOoXI2.X0o0xo();
        if (oxoX2 <= X0o0xo2) {
            while (contains(elements.get(oxoX2))) {
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

    public final int count() {
        return this._size;
    }

    public final int elementAt(@IntRange(from = 0) int i) {
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

    public final int elementAtOrElse(@IntRange(from = 0) int i, @OOXIXo Oox.oOoXoXO<? super Integer, Integer> defaultValue) {
        IIX0o.x0xO0oo(defaultValue, "defaultValue");
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        return defaultValue.invoke(Integer.valueOf(i)).intValue();
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof IntList) {
            IntList intList = (IntList) obj;
            int i = intList._size;
            int i2 = this._size;
            if (i == i2) {
                int[] iArr = this.content;
                int[] iArr2 = intList.content;
                oOoXoXO X00xOoXI2 = X0.IIXOooo.X00xOoXI(0, i2);
                int oxoX2 = X00xOoXI2.oxoX();
                int X0o0xo2 = X00xOoXI2.X0o0xo();
                if (oxoX2 <= X0o0xo2) {
                    while (iArr[oxoX2] == iArr2[oxoX2]) {
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

    public final int first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        throw new NoSuchElementException("IntList is empty.");
    }

    public final <R> R fold(R r, @OOXIXo x0xO0oo<? super R, ? super Integer, ? extends R> operation) {
        IIX0o.x0xO0oo(operation, "operation");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            r = operation.invoke(r, Integer.valueOf(iArr[i2]));
        }
        return r;
    }

    public final <R> R foldIndexed(R r, @OOXIXo IXxxXO<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        IIX0o.x0xO0oo(operation, "operation");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            R r2 = r;
            r = operation.invoke(Integer.valueOf(i2), r2, Integer.valueOf(iArr[i2]));
        }
        return r;
    }

    public final <R> R foldRight(R r, @OOXIXo x0xO0oo<? super Integer, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(operation, "operation");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return r;
            }
            r = operation.invoke(Integer.valueOf(iArr[i]), r);
        }
    }

    public final <R> R foldRightIndexed(R r, @OOXIXo IXxxXO<? super Integer, ? super Integer, ? super R, ? extends R> operation) {
        IIX0o.x0xO0oo(operation, "operation");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return r;
            }
            r = operation.invoke(Integer.valueOf(i), Integer.valueOf(iArr[i]), r);
        }
    }

    public final void forEach(@OOXIXo Oox.oOoXoXO<? super Integer, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            block.invoke(Integer.valueOf(iArr[i2]));
        }
    }

    public final void forEachIndexed(@OOXIXo x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            block.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]));
        }
    }

    public final void forEachReversed(@OOXIXo Oox.oOoXoXO<? super Integer, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                block.invoke(Integer.valueOf(iArr[i]));
            } else {
                return;
            }
        }
    }

    public final void forEachReversedIndexed(@OOXIXo x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> block) {
        IIX0o.x0xO0oo(block, "block");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                block.invoke(Integer.valueOf(i), Integer.valueOf(iArr[i]));
            } else {
                return;
            }
        }
    }

    public final int get(@IntRange(from = 0) int i) {
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
    public final oOoXoXO getIndices() {
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
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3] * 31;
        }
        return i2;
    }

    public final int indexOf(int i) {
        int[] iArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i == iArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public final int indexOfFirst(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (predicate.invoke(Integer.valueOf(iArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public final int indexOfLast(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        do {
            i--;
            if (-1 >= i) {
                return -1;
            }
        } while (!predicate.invoke(Integer.valueOf(iArr[i])).booleanValue());
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
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final int last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        throw new NoSuchElementException("IntList is empty.");
    }

    public final int lastIndexOf(int i) {
        int[] iArr = this.content;
        int i2 = this._size;
        do {
            i2--;
            if (-1 >= i2) {
                return -1;
            }
        } while (iArr[i2] != i);
        return i2;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        int[] iArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (predicate.invoke(Integer.valueOf(iArr[i])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @OOXIXo
    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    private IntList(int i) {
        int[] iArr;
        if (i == 0) {
            iArr = IntSetKt.getEmptyIntArray();
        } else {
            iArr = new int[i];
        }
        this.content = iArr;
    }

    public final boolean any(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (predicate.invoke(Integer.valueOf(iArr[i2])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (predicate.invoke(Integer.valueOf(iArr[i3])).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator) {
        IIX0o.x0xO0oo(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final int first(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        IIX0o.x0xO0oo(predicate, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (predicate.invoke(Integer.valueOf(i3)).booleanValue()) {
                return i3;
            }
        }
        throw new NoSuchElementException("IntList contains no element matching the predicate.");
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Oox.oOoXoXO transform, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                separator = ", ";
            }
            if ((i2 & 2) != 0) {
                prefix = "";
            }
            if ((i2 & 4) != 0) {
                postfix = "";
            }
            if ((i2 & 8) != 0) {
                i = -1;
            }
            if ((i2 & 16) != 0) {
                truncated = "...";
            }
            IIX0o.x0xO0oo(separator, "separator");
            IIX0o.x0xO0oo(prefix, "prefix");
            IIX0o.x0xO0oo(postfix, "postfix");
            IIX0o.x0xO0oo(truncated, "truncated");
            IIX0o.x0xO0oo(transform, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            int[] iArr = intList.content;
            int i3 = intList._size;
            int i4 = 0;
            while (true) {
                if (i4 < i3) {
                    int i5 = iArr[i4];
                    if (i4 == i) {
                        sb.append(truncated);
                        break;
                    }
                    if (i4 != 0) {
                        sb.append(separator);
                    }
                    sb.append((CharSequence) transform.invoke(Integer.valueOf(i5)));
                    i4++;
                } else {
                    sb.append(postfix);
                    break;
                }
            }
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, int i) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, 16, null);
    }

    public final int last(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> predicate) {
        int i;
        IIX0o.x0xO0oo(predicate, "predicate");
        int[] iArr = this.content;
        int i2 = this._size;
        do {
            i2--;
            if (-1 < i2) {
                i = iArr[i2];
            } else {
                throw new NoSuchElementException("IntList contains no element matching the predicate.");
            }
        } while (!predicate.invoke(Integer.valueOf(i)).booleanValue());
        return i;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, int i, @OOXIXo CharSequence truncated) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        IIX0o.x0xO0oo(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 < i2) {
                int i4 = iArr[i3];
                if (i3 == i) {
                    sb.append(truncated);
                    break;
                }
                if (i3 != 0) {
                    sb.append(separator);
                }
                sb.append(i4);
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

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, int i, @OOXIXo CharSequence truncated, @OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> transform) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        IIX0o.x0xO0oo(truncated, "truncated");
        IIX0o.x0xO0oo(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 < i2) {
                int i4 = iArr[i3];
                if (i3 == i) {
                    sb.append(truncated);
                    break;
                }
                if (i3 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Integer.valueOf(i4)));
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

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, int i, @OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> transform) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        IIX0o.x0xO0oo(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 < i2) {
                int i4 = iArr[i3];
                if (i3 == i) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i3 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Integer.valueOf(i4)));
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

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo CharSequence postfix, @OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> transform) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(postfix, "postfix");
        IIX0o.x0xO0oo(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                int i3 = iArr[i2];
                if (i2 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i2 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Integer.valueOf(i3)));
                i2++;
            } else {
                sb.append(postfix);
                break;
            }
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo CharSequence prefix, @OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> transform) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(prefix, "prefix");
        IIX0o.x0xO0oo(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                int i3 = iArr[i2];
                if (i2 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i2 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Integer.valueOf(i3)));
                i2++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo CharSequence separator, @OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> transform) {
        IIX0o.x0xO0oo(separator, "separator");
        IIX0o.x0xO0oo(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                int i3 = iArr[i2];
                if (i2 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i2 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Integer.valueOf(i3)));
                i2++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @OOXIXo
    @xoIox
    public final String joinToString(@OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> transform) {
        IIX0o.x0xO0oo(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 < i) {
                int i3 = iArr[i2];
                if (i2 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i2 != 0) {
                    sb.append((CharSequence) ", ");
                }
                sb.append(transform.invoke(Integer.valueOf(i3)));
                i2++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
