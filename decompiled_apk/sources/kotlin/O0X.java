package kotlin;

import com.szabh.smable3.entity.BleWatchFaceId;

@XO0OX.xxIXOIIO(name = "UnsignedKt")
/* loaded from: classes6.dex */
public final class O0X {
    @o0
    public static final int I0Io(int i, int i2) {
        return kotlin.jvm.internal.IIX0o.oI0IIXIo(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    @o0
    public static final long II0XooXoX(long j, long j2) {
        int compare;
        int compare2;
        if (j2 < 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return XI0oooXX.oOoXoXO(0L);
            }
            return XI0oooXX.oOoXoXO(1L);
        }
        if (j >= 0) {
            return XI0oooXX.oOoXoXO(j / j2);
        }
        int i = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        compare = Long.compare(XI0oooXX.oOoXoXO(j - (j3 * j2)) ^ Long.MIN_VALUE, XI0oooXX.oOoXoXO(j2) ^ Long.MIN_VALUE);
        if (compare < 0) {
            i = 0;
        }
        return XI0oooXX.oOoXoXO(j3 + i);
    }

    @o0
    public static final long II0xO0(double d) {
        if (Double.isNaN(d) || d <= xoIox(0L)) {
            return 0L;
        }
        if (d >= xoIox(-1L)) {
            return -1L;
        }
        if (d < 9.223372036854776E18d) {
            return XI0oooXX.oOoXoXO((long) d);
        }
        return XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @OXOo.OOXIXo
    public static final String OOXIXo(long j) {
        return oOoXoXO(j, 10);
    }

    @o0
    public static final int Oxx0IOOO(long j, long j2) {
        return kotlin.jvm.internal.IIX0o.OxxIIOOXO(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    @o0
    public static final int X0o0xo(int i, int i2) {
        return xxIO.oOoXoXO((int) ((i & BleWatchFaceId.WATCHFACE_ID_INVALID) % (i2 & BleWatchFaceId.WATCHFACE_ID_INVALID)));
    }

    @o0
    public static final double XO(int i) {
        return (Integer.MAX_VALUE & i) + (((i >>> 31) << 30) * 2);
    }

    @o0
    public static final int oIX0oI(double d) {
        if (Double.isNaN(d) || d <= XO(0)) {
            return 0;
        }
        if (d >= XO(-1)) {
            return -1;
        }
        if (d <= 2.147483647E9d) {
            return xxIO.oOoXoXO((int) d);
        }
        return xxIO.oOoXoXO(xxIO.oOoXoXO((int) (d - Integer.MAX_VALUE)) + xxIO.oOoXoXO(Integer.MAX_VALUE));
    }

    @OXOo.OOXIXo
    public static final String oOoXoXO(long j, int i) {
        if (j >= 0) {
            String l = Long.toString(j, kotlin.text.II0xO0.oIX0oI(i));
            kotlin.jvm.internal.IIX0o.oO(l, "toString(...)");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j3, kotlin.text.II0xO0.oIX0oI(i));
        kotlin.jvm.internal.IIX0o.oO(l2, "toString(...)");
        sb.append(l2);
        String l3 = Long.toString(j4, kotlin.text.II0xO0.oIX0oI(i));
        kotlin.jvm.internal.IIX0o.oO(l3, "toString(...)");
        sb.append(l3);
        return sb.toString();
    }

    @o0
    public static final int oxoX(int i, int i2) {
        return xxIO.oOoXoXO((int) ((i & BleWatchFaceId.WATCHFACE_ID_INVALID) / (i2 & BleWatchFaceId.WATCHFACE_ID_INVALID)));
    }

    @o0
    public static final double xoIox(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    @o0
    public static final long xxIXOIIO(long j, long j2) {
        int compare;
        int compare2;
        if (j2 < 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            if (compare2 >= 0) {
                return XI0oooXX.oOoXoXO(j - j2);
            }
            return j;
        }
        if (j >= 0) {
            return XI0oooXX.oOoXoXO(j % j2);
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        compare = Long.compare(XI0oooXX.oOoXoXO(j3) ^ Long.MIN_VALUE, XI0oooXX.oOoXoXO(j2) ^ Long.MIN_VALUE);
        if (compare < 0) {
            j2 = 0;
        }
        return XI0oooXX.oOoXoXO(j3 - j2);
    }
}
