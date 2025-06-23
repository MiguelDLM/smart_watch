package androidx.collection.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import kotlin.jvm.internal.IIX0o;

public final class ContainerHelpersKt {
    @XO
    @OOXIXo
    public static final int[] EMPTY_INTS = new int[0];
    @XO
    @OOXIXo
    public static final long[] EMPTY_LONGS = new long[0];
    @XO
    @OOXIXo
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static final int binarySearch(@OOXIXo int[] iArr, int i, int i2) {
        IIX0o.x0xO0oo(iArr, "array");
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static final boolean equal(@oOoXoXO Object obj, @oOoXoXO Object obj2) {
        return IIX0o.Oxx0IOOO(obj, obj2);
    }

    public static final int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    public static final int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    public static final int idealLongArraySize(int i) {
        return idealByteArraySize(i * 8) / 8;
    }

    public static final int binarySearch(@OOXIXo long[] jArr, int i, long j) {
        IIX0o.x0xO0oo(jArr, "array");
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = (jArr[i4] > j ? 1 : (jArr[i4] == j ? 0 : -1));
            if (i5 < 0) {
                i3 = i4 + 1;
            } else if (i5 <= 0) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }
}
