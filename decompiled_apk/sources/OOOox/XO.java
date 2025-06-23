package OOOox;

/* loaded from: classes6.dex */
public final /* synthetic */ class XO {
    public static /* synthetic */ long oIX0oI(long j, long j2) {
        boolean z;
        long j3 = j + j2;
        boolean z2 = false;
        if ((j2 ^ j) < 0) {
            z = true;
        } else {
            z = false;
        }
        if ((j ^ j3) >= 0) {
            z2 = true;
        }
        if (z | z2) {
            return j3;
        }
        throw new ArithmeticException();
    }
}
