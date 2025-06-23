package oO0;

/* loaded from: classes6.dex */
public class xxIXOIIO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int[] f31871oIX0oI = new int[0];

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long[] f31870II0xO0 = new long[0];

    /* renamed from: I0Io, reason: collision with root package name */
    public static final Object[] f31869I0Io = new Object[0];

    public static boolean I0Io(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static int II0xO0(long[] jArr, int i, long j) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else if (j2 > j) {
                i2 = i4 - 1;
            } else {
                return i4;
            }
        }
        return ~i3;
    }

    public static int X0o0xo(int i) {
        return oxoX(i * 4) / 4;
    }

    public static int XO(int i) {
        return oxoX(i * 8) / 8;
    }

    public static int oIX0oI(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 > i2) {
                i3 = i5 - 1;
            } else {
                return i5;
            }
        }
        return ~i4;
    }

    public static int oxoX(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }
}
