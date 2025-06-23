package OOOox;

/* loaded from: classes6.dex */
public final /* synthetic */ class X0o0xo {
    public static /* synthetic */ long oIX0oI(long j, long j2) {
        boolean z;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j2);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        if (numberOfLeadingZeros >= 64) {
            boolean z2 = false;
            if (j >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (j2 != Long.MIN_VALUE) {
                z2 = true;
            }
            if (z | z2) {
                long j3 = j * j2;
                if (j == 0 || j3 / j == j2) {
                    return j3;
                }
            }
        }
        throw new ArithmeticException();
    }
}
