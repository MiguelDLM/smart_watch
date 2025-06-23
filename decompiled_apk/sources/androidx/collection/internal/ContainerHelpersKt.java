package androidx.collection.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class ContainerHelpersKt {

    @OOXIXo
    @XO
    public static final int[] EMPTY_INTS = new int[0];

    @OOXIXo
    @XO
    public static final long[] EMPTY_LONGS = new long[0];

    @OOXIXo
    @XO
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static final int binarySearch(@OOXIXo int[] array, int i, int i2) {
        IIX0o.x0xO0oo(array, "array");
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = array[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
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

    public static final int binarySearch(@OOXIXo long[] array, int i, long j) {
        IIX0o.x0xO0oo(array, "array");
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = array[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }
}
