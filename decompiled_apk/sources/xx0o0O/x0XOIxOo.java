package xx0o0O;

import kotlin.o0;

/* loaded from: classes6.dex */
public final class x0XOIxOo {
    @o0
    public static final int I0Io(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i < i2) {
                return i2 - oIX0oI(i2, i, i3);
            }
            return i2;
        }
        if (i3 < 0) {
            if (i > i2) {
                return i2 + oIX0oI(i, i2, -i3);
            }
            return i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long II0xO0(long j, long j2, long j3) {
        return XO(XO(j, j3) - XO(j2, j3), j3);
    }

    public static final int X0o0xo(int i, int i2) {
        int i3 = i % i2;
        if (i3 < 0) {
            return i3 + i2;
        }
        return i3;
    }

    public static final long XO(long j, long j2) {
        long j3 = j % j2;
        if (j3 < 0) {
            return j3 + j2;
        }
        return j3;
    }

    public static final int oIX0oI(int i, int i2, int i3) {
        return X0o0xo(X0o0xo(i, i3) - X0o0xo(i2, i3), i3);
    }

    @o0
    public static final long oxoX(long j, long j2, long j3) {
        if (j3 > 0) {
            if (j < j2) {
                return j2 - II0xO0(j2, j, j3);
            }
            return j2;
        }
        if (j3 < 0) {
            if (j > j2) {
                return j2 + II0xO0(j, j2, -j3);
            }
            return j2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
