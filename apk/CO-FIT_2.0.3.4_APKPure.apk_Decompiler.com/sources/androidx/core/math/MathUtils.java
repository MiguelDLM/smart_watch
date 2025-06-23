package androidx.core.math;

import com.garmin.fit.O0Xx;

public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i, int i2) {
        int i3 = i + i2;
        boolean z = false;
        if ((i >= 0) == (i2 >= 0)) {
            boolean z2 = i >= 0;
            if (i3 >= 0) {
                z = true;
            }
            if (z2 != z) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i3;
    }

    public static double clamp(double d, double d2, double d3) {
        if (d < d2) {
            return d2;
        }
        return d > d3 ? d3 : d;
    }

    public static int decrementExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return i - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i) {
        if (i != Integer.MAX_VALUE) {
            return i + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i, int i2) {
        int i3 = i * i2;
        if (i == 0 || i2 == 0 || (i3 / i == i2 && i3 / i2 == i)) {
            return i3;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return -i;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i, int i2) {
        int i3 = i - i2;
        boolean z = false;
        if ((i < 0) != (i2 < 0)) {
            boolean z2 = i < 0;
            if (i3 < 0) {
                z = true;
            }
            if (z2 != z) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i3;
    }

    public static int toIntExact(long j) {
        if (j <= 2147483647L && j >= O0Xx.f30774xXxxox0I) {
            return (int) j;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long addExact(long j, long j2) {
        long j3 = j + j2;
        boolean z = false;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if ((i >= 0) == (j2 >= 0)) {
            boolean z2 = i >= 0;
            if (j3 >= 0) {
                z = true;
            }
            if (z2 != z) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j3;
    }

    public static float clamp(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    public static long decrementExact(long j) {
        if (j != Long.MIN_VALUE) {
            return j - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j) {
        if (j != Long.MAX_VALUE) {
            return j + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j, long j2) {
        long j3 = j - j2;
        boolean z = false;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if ((i < 0) != (j2 < 0)) {
            boolean z2 = i < 0;
            if (j3 < 0) {
                z = true;
            }
            if (z2 != z) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j3;
    }

    public static int clamp(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    public static long multiplyExact(long j, long j2) {
        long j3 = j * j2;
        if (j == 0 || j2 == 0 || (j3 / j == j2 && j3 / j2 == j)) {
            return j3;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j, long j2, long j3) {
        if (j < j2) {
            return j2;
        }
        return j > j3 ? j3 : j;
    }
}
