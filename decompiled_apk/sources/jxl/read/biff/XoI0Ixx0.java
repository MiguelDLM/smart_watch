package jxl.read.biff;

/* loaded from: classes6.dex */
public final class XoI0Ixx0 {
    public static double oIX0oI(int i) {
        if ((i & 2) != 0) {
            double d = i >> 2;
            if ((i & 1) != 0) {
                return d / 100.0d;
            }
            return d;
        }
        double longBitsToDouble = Double.longBitsToDouble((i & (-4)) << 32);
        if ((i & 1) != 0) {
            return longBitsToDouble / 100.0d;
        }
        return longBitsToDouble;
    }
}
