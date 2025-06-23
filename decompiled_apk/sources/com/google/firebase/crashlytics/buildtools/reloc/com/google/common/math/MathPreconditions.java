package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.math;

import XIXIX.OOXIXo;
import XXO0.oIX0oI;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.crashlytics.buildtools.reloc.org.checkerframework.checker.nullness.compatqual.NullableDecl;
import java.math.BigInteger;

@GwtCompatible
@CanIgnoreReturnValue
/* loaded from: classes10.dex */
final class MathPreconditions {
    private MathPreconditions() {
    }

    public static void checkInRange(boolean z) {
        if (z) {
        } else {
            throw new ArithmeticException("not in range");
        }
    }

    public static void checkNoOverflow(boolean z, String str, int i, int i2) {
        if (z) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + oIX0oI.I0Io.f4096II0xO0 + i + ", " + i2 + oIX0oI.I0Io.f4095I0Io);
    }

    public static int checkNonNegative(@NullableDecl String str, int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " (" + i + ") must be >= 0");
    }

    public static int checkPositive(@NullableDecl String str, int i) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " (" + i + ") must be > 0");
    }

    public static void checkRoundingUnnecessary(boolean z) {
        if (z) {
        } else {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    public static void checkNoOverflow(boolean z, String str, long j, long j2) {
        if (z) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + oIX0oI.I0Io.f4096II0xO0 + j + ", " + j2 + oIX0oI.I0Io.f4095I0Io);
    }

    public static long checkNonNegative(@NullableDecl String str, long j) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " (" + j + ") must be >= 0");
    }

    public static long checkPositive(@NullableDecl String str, long j) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " (" + j + ") must be > 0");
    }

    public static BigInteger checkNonNegative(@NullableDecl String str, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be >= 0");
    }

    public static BigInteger checkPositive(@NullableDecl String str, BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be > 0");
    }

    public static double checkNonNegative(@NullableDecl String str, double d) {
        if (d >= OOXIXo.f3760XO) {
            return d;
        }
        throw new IllegalArgumentException(str + " (" + d + ") must be >= 0");
    }
}
