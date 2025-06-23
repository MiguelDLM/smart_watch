package xx0o0O;

import kotlin.I0oOIX;
import kotlin.XI0oooXX;
import kotlin.o0;
import kotlin.oxxXoxO;
import kotlin.xoxXI;
import kotlin.xxIO;

/* loaded from: classes6.dex */
public final class IXxxXO {
    @o0
    @oxxXoxO(version = "1.3")
    public static final long I0Io(long j, long j2, long j3) {
        int compare;
        int compare2;
        if (j3 > 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return XI0oooXX.oOoXoXO(j2 - II0xO0(j2, j, XI0oooXX.oOoXoXO(j3)));
            }
            return j2;
        }
        if (j3 < 0) {
            compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            if (compare > 0) {
                return XI0oooXX.oOoXoXO(j2 + II0xO0(j, j2, XI0oooXX.oOoXoXO(-j3)));
            }
            return j2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long II0xO0(long j, long j2, long j3) {
        int compare;
        long oIX0oI2 = xoxXI.oIX0oI(j, j3);
        long oIX0oI3 = xoxXI.oIX0oI(j2, j3);
        compare = Long.compare(oIX0oI2 ^ Long.MIN_VALUE, oIX0oI3 ^ Long.MIN_VALUE);
        long oOoXoXO2 = XI0oooXX.oOoXoXO(oIX0oI2 - oIX0oI3);
        if (compare < 0) {
            return XI0oooXX.oOoXoXO(oOoXoXO2 + j3);
        }
        return oOoXoXO2;
    }

    public static final int oIX0oI(int i, int i2, int i3) {
        int compare;
        int oIX0oI2 = I0oOIX.oIX0oI(i, i3);
        int oIX0oI3 = I0oOIX.oIX0oI(i2, i3);
        compare = Integer.compare(oIX0oI2 ^ Integer.MIN_VALUE, oIX0oI3 ^ Integer.MIN_VALUE);
        int oOoXoXO2 = xxIO.oOoXoXO(oIX0oI2 - oIX0oI3);
        if (compare < 0) {
            return xxIO.oOoXoXO(oOoXoXO2 + i3);
        }
        return oOoXoXO2;
    }

    @o0
    @oxxXoxO(version = "1.3")
    public static final int oxoX(int i, int i2, int i3) {
        int compare;
        int compare2;
        if (i3 > 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return xxIO.oOoXoXO(i2 - oIX0oI(i2, i, xxIO.oOoXoXO(i3)));
            }
            return i2;
        }
        if (i3 < 0) {
            compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                return xxIO.oOoXoXO(i2 + oIX0oI(i, i2, xxIO.oOoXoXO(-i3)));
            }
            return i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
