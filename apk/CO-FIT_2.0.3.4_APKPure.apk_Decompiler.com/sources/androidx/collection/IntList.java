package androidx.collection;

import OXOo.OOXIXo;
import Oox.x0xO0oo;
import X0.oOoXoXO;
import XO0OX.XO;
import XO0OX.xoIox;
import androidx.annotation.IntRange;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nIntList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntList.kt\nandroidx/collection/IntList\n*L\n1#1,969:1\n253#1,6:970\n279#1,6:976\n253#1,6:982\n75#1:988\n253#1,6:989\n253#1,6:995\n253#1,6:1001\n266#1,6:1007\n279#1,6:1013\n293#1,6:1019\n70#1:1025\n70#1:1026\n266#1,6:1027\n266#1,6:1033\n293#1,6:1039\n70#1:1045\n279#1,6:1046\n293#1,6:1052\n266#1,6:1058\n266#1,6:1064\n253#1,6:1070\n75#1:1076\n467#1,10:1077\n266#1,4:1087\n477#1,9:1091\n271#1:1100\n486#1,2:1101\n467#1,10:1103\n266#1,4:1113\n477#1,9:1117\n271#1:1126\n486#1,2:1127\n467#1,10:1129\n266#1,4:1139\n477#1,9:1143\n271#1:1152\n486#1,2:1153\n467#1,10:1155\n266#1,4:1165\n477#1,9:1169\n271#1:1178\n486#1,2:1179\n467#1,10:1181\n266#1,4:1191\n477#1,9:1195\n271#1:1204\n486#1,2:1205\n*S KotlinDebug\n*F\n+ 1 IntList.kt\nandroidx/collection/IntList\n*L\n96#1:970,6\n110#1:976,6\n122#1:982,6\n135#1:988\n153#1:989,6\n175#1:995,6\n192#1:1001,6\n208#1:1007,6\n225#1:1013,6\n241#1:1019,6\n306#1:1025\n317#1:1026\n343#1:1027,6\n357#1:1033,6\n371#1:1039,6\n397#1:1045\n407#1:1046,6\n420#1:1052,6\n445#1:1058,6\n476#1:1064,6\n494#1:1070,6\n510#1:1076\n-1#1:1077,10\n-1#1:1087,4\n-1#1:1091,9\n-1#1:1100\n-1#1:1101,2\n-1#1:1103,10\n-1#1:1113,4\n-1#1:1117,9\n-1#1:1126\n-1#1:1127,2\n-1#1:1129,10\n-1#1:1139,4\n-1#1:1143,9\n-1#1:1152\n-1#1:1153,2\n-1#1:1155,10\n-1#1:1165,4\n-1#1:1169,9\n-1#1:1178\n-1#1:1179,2\n-1#1:1181,10\n-1#1:1191,4\n-1#1:1195,9\n-1#1:1204\n-1#1:1205,2\n*E\n"})
public abstract class IntList {
    @XO
    public int _size;
    @XO
    @OOXIXo
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
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = ", ";
            }
            CharSequence charSequence5 = "";
            CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
            if ((i2 & 4) == 0) {
                charSequence5 = charSequence3;
            }
            int i3 = (i2 & 8) != 0 ? -1 : i;
            if ((i2 & 16) != 0) {
                charSequence4 = "...";
            }
            return intList.joinToString(charSequence, charSequence6, charSequence5, i3, charSequence4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
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

    public final boolean containsAll(@OOXIXo IntList intList) {
        IIX0o.x0xO0oo(intList, "elements");
        oOoXoXO X00xOoXI2 = X0.IIXOooo.X00xOoXI(0, intList._size);
        int oxoX2 = X00xOoXI2.oxoX();
        int X0o0xo2 = X00xOoXI2.X0o0xo();
        if (oxoX2 > X0o0xo2) {
            return true;
        }
        while (contains(intList.get(oxoX2))) {
            if (oxoX2 == X0o0xo2) {
                return true;
            }
            oxoX2++;
        }
        return false;
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

    public final int elementAtOrElse(@IntRange(from = 0) int i, @OOXIXo Oox.oOoXoXO<? super Integer, Integer> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "defaultValue");
        if (i < 0 || i >= this._size) {
            return oooxoxo.invoke(Integer.valueOf(i)).intValue();
        }
        return this.content[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r7 = (androidx.collection.IntList) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@OXOo.oOoXoXO java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.collection.IntList
            r1 = 0
            if (r0 == 0) goto L_0x002e
            androidx.collection.IntList r7 = (androidx.collection.IntList) r7
            int r0 = r7._size
            int r2 = r6._size
            if (r0 == r2) goto L_0x000e
            goto L_0x002e
        L_0x000e:
            int[] r0 = r6.content
            int[] r7 = r7.content
            X0.oOoXoXO r2 = X0.IIXOooo.X00xOoXI(r1, r2)
            int r3 = r2.oxoX()
            int r2 = r2.X0o0xo()
            if (r3 > r2) goto L_0x002c
        L_0x0020:
            r4 = r0[r3]
            r5 = r7[r3]
            if (r4 == r5) goto L_0x0027
            return r1
        L_0x0027:
            if (r3 == r2) goto L_0x002c
            int r3 = r3 + 1
            goto L_0x0020
        L_0x002c:
            r7 = 1
            return r7
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntList.equals(java.lang.Object):boolean");
    }

    public final int first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        throw new NoSuchElementException("IntList is empty.");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [Oox.x0xO0oo<? super R, ? super java.lang.Integer, ? extends R>, Oox.x0xO0oo, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R fold(R r5, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super java.lang.Integer, ? extends R> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r0)
            int[] r0 = r4.content
            int r1 = r4._size
            r2 = 0
        L_0x000a:
            if (r2 >= r1) goto L_0x0019
            r3 = r0[r2]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r5 = r6.invoke(r5, r3)
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0019:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntList.fold(java.lang.Object, Oox.x0xO0oo):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.Object, Oox.IXxxXO<? super java.lang.Integer, ? super R, ? super java.lang.Integer, ? extends R>, Oox.IXxxXO] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldIndexed(R r6, @OXOo.OOXIXo Oox.IXxxXO<? super java.lang.Integer, ? super R, ? super java.lang.Integer, ? extends R> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            int[] r0 = r5.content
            int r1 = r5._size
            r2 = 0
        L_0x000a:
            if (r2 >= r1) goto L_0x001d
            r3 = r0[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r6 = r7.invoke(r4, r6, r3)
            int r2 = r2 + 1
            goto L_0x000a
        L_0x001d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntList.foldIndexed(java.lang.Object, Oox.IXxxXO):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [Oox.x0xO0oo<? super java.lang.Integer, ? super R, ? extends R>, Oox.x0xO0oo, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRight(R r4, @OXOo.OOXIXo Oox.x0xO0oo<? super java.lang.Integer, ? super R, ? extends R> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
            int[] r0 = r3.content
            int r1 = r3._size
            int r1 = r1 + -1
        L_0x000b:
            r2 = -1
            if (r2 >= r1) goto L_0x001b
            r2 = r0[r1]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r4 = r5.invoke(r2, r4)
            int r1 = r1 + -1
            goto L_0x000b
        L_0x001b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntList.foldRight(java.lang.Object, Oox.x0xO0oo):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object, Oox.IXxxXO<? super java.lang.Integer, ? super java.lang.Integer, ? super R, ? extends R>, Oox.IXxxXO] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRightIndexed(R r5, @OXOo.OOXIXo Oox.IXxxXO<? super java.lang.Integer, ? super java.lang.Integer, ? super R, ? extends R> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r6, r0)
            int[] r0 = r4.content
            int r1 = r4._size
            int r1 = r1 + -1
        L_0x000b:
            r2 = -1
            if (r2 >= r1) goto L_0x001f
            r2 = r0[r1]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r5 = r6.invoke(r3, r2, r5)
            int r1 = r1 + -1
            goto L_0x000b
        L_0x001f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntList.foldRightIndexed(java.lang.Object, Oox.IXxxXO):java.lang.Object");
    }

    public final void forEach(@OOXIXo Oox.oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "block");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            oooxoxo.invoke(Integer.valueOf(iArr[i2]));
        }
    }

    public final void forEachIndexed(@OOXIXo x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> x0xo0oo) {
        IIX0o.x0xO0oo(x0xo0oo, "block");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            x0xo0oo.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]));
        }
    }

    public final void forEachReversed(@OOXIXo Oox.oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "block");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                oooxoxo.invoke(Integer.valueOf(iArr[i]));
            } else {
                return;
            }
        }
    }

    public final void forEachReversedIndexed(@OOXIXo x0xO0oo<? super Integer, ? super Integer, oXIO0o0XI> x0xo0oo) {
        IIX0o.x0xO0oo(x0xo0oo, "block");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                x0xo0oo.invoke(Integer.valueOf(i), Integer.valueOf(iArr[i]));
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

    public final int indexOfFirst(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (oooxoxo.invoke(Integer.valueOf(iArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public final int indexOfLast(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return -1;
            }
            if (oooxoxo.invoke(Integer.valueOf(iArr[i])).booleanValue()) {
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
        return joinToString$default(this, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 31, (Object) null);
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
        while (true) {
            i2--;
            if (-1 >= i2) {
                return -1;
            }
            if (iArr[i2] == i) {
                return i2;
            }
        }
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        int[] iArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (oooxoxo.invoke(Integer.valueOf(iArr[i])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @OOXIXo
    public String toString() {
        return joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, 25, (Object) null);
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

    public final boolean any(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (oooxoxo.invoke(Integer.valueOf(iArr[i2])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (oooxoxo.invoke(Integer.valueOf(iArr[i3])).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence) {
        IIX0o.x0xO0oo(charSequence, "separator");
        return joinToString$default(this, charSequence, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 30, (Object) null);
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        return joinToString$default(this, charSequence, charSequence2, (CharSequence) null, 0, (CharSequence) null, 28, (Object) null);
    }

    public final int first(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (oooxoxo.invoke(Integer.valueOf(i3)).booleanValue()) {
                return i3;
            }
        }
        throw new NoSuchElementException("IntList contains no element matching the predicate.");
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, 24, (Object) null);
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Oox.oOoXoXO oooxoxo, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                charSequence = ", ";
            }
            if ((i2 & 2) != 0) {
                charSequence2 = "";
            }
            if ((i2 & 4) != 0) {
                charSequence3 = "";
            }
            if ((i2 & 8) != 0) {
                i = -1;
            }
            if ((i2 & 16) != 0) {
                charSequence4 = "...";
            }
            IIX0o.x0xO0oo(charSequence, "separator");
            IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
            IIX0o.x0xO0oo(charSequence3, "postfix");
            IIX0o.x0xO0oo(charSequence4, "truncated");
            IIX0o.x0xO0oo(oooxoxo, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence2);
            int[] iArr = intList.content;
            int i3 = intList._size;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    sb.append(charSequence3);
                    break;
                }
                int i5 = iArr[i4];
                if (i4 == i) {
                    sb.append(charSequence4);
                    break;
                }
                if (i4 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) oooxoxo.invoke(Integer.valueOf(i5)));
                i4++;
            }
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, (CharSequence) null, 16, (Object) null);
    }

    public final int last(@OOXIXo Oox.oOoXoXO<? super Integer, Boolean> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "predicate");
        int[] iArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                int i2 = iArr[i];
                if (oooxoxo.invoke(Integer.valueOf(i2)).booleanValue()) {
                    return i2;
                }
            } else {
                throw new NoSuchElementException("IntList contains no element matching the predicate.");
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
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        int[] iArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            int i4 = iArr[i3];
            if (i3 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            sb.append(i4);
            i3++;
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo CharSequence charSequence4, @OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> oooxoxo) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        IIX0o.x0xO0oo(charSequence4, "truncated");
        IIX0o.x0xO0oo(oooxoxo, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        int[] iArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            int i4 = iArr[i3];
            if (i3 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) oooxoxo.invoke(Integer.valueOf(i4)));
            i3++;
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, int i, @OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> oooxoxo) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        IIX0o.x0xO0oo(oooxoxo, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        int[] iArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            int i4 = iArr[i3];
            if (i3 == i) {
                sb.append("...");
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) oooxoxo.invoke(Integer.valueOf(i4)));
            i3++;
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo CharSequence charSequence3, @OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> oooxoxo) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(charSequence3, "postfix");
        IIX0o.x0xO0oo(oooxoxo, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                sb.append(charSequence3);
                break;
            }
            int i3 = iArr[i2];
            if (i2 == -1) {
                sb.append("...");
                break;
            }
            if (i2 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) oooxoxo.invoke(Integer.valueOf(i3)));
            i2++;
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo CharSequence charSequence2, @OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> oooxoxo) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(charSequence2, RequestParameters.PREFIX);
        IIX0o.x0xO0oo(oooxoxo, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                sb.append("");
                break;
            }
            int i3 = iArr[i2];
            if (i2 == -1) {
                sb.append("...");
                break;
            }
            if (i2 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) oooxoxo.invoke(Integer.valueOf(i3)));
            i2++;
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo CharSequence charSequence, @OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> oooxoxo) {
        IIX0o.x0xO0oo(charSequence, "separator");
        IIX0o.x0xO0oo(oooxoxo, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                sb.append("");
                break;
            }
            int i3 = iArr[i2];
            if (i2 == -1) {
                sb.append("...");
                break;
            }
            if (i2 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) oooxoxo.invoke(Integer.valueOf(i3)));
            i2++;
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @xoIox
    @OOXIXo
    public final String joinToString(@OOXIXo Oox.oOoXoXO<? super Integer, ? extends CharSequence> oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int[] iArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                sb.append("");
                break;
            }
            int i3 = iArr[i2];
            if (i2 == -1) {
                sb.append("...");
                break;
            }
            if (i2 != 0) {
                sb.append(", ");
            }
            sb.append((CharSequence) oooxoxo.invoke(Integer.valueOf(i3)));
            i2++;
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
