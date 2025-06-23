package kotlin.time;

import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.time.oxoX;

@XX({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
/* loaded from: classes6.dex */
public final class OOXIXo {
    public static final boolean I0Io(long j) {
        return ((j - 1) | 1) == Long.MAX_VALUE;
    }

    public static final long II0XooXoX(long j, long j2, @OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            if (j == j2) {
                return oxoX.f29647Oo.XX();
            }
            return oxoX.OOXIxO0(II0xO0(j2));
        }
        if ((1 | (j - 1)) == Long.MAX_VALUE) {
            return II0xO0(j);
        }
        return Oxx0IOOO(j, j2, unit);
    }

    public static final long II0xO0(long j) {
        oxoX.oIX0oI oix0oi = oxoX.f29647Oo;
        if (j < 0) {
            return oix0oi.oo0xXOI0I();
        }
        return oix0oi.Oo();
    }

    public static final long Oxx0IOOO(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) < 0) {
            DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
            if (durationUnit.compareTo(durationUnit2) < 0) {
                long II0xO02 = II0XooXoX.II0xO0(1L, durationUnit2, durationUnit);
                long j4 = (j / II0xO02) - (j2 / II0xO02);
                long j5 = (j % II0xO02) - (j2 % II0xO02);
                oxoX.oIX0oI oix0oi = oxoX.f29647Oo;
                return oxoX.XoI0Ixx0(XO.xoIxX(j4, durationUnit2), XO.xoIxX(j5, durationUnit));
            }
            return oxoX.OOXIxO0(II0xO0(j3));
        }
        return XO.xoIxX(j3, durationUnit);
    }

    public static final long X0o0xo(long j, DurationUnit durationUnit, long j2) {
        long x0xO0oo2 = oxoX.x0xO0oo(j2, 2);
        long Ioxxx2 = oxoX.Ioxxx(x0xO0oo2, durationUnit);
        if ((1 | (Ioxxx2 - 1)) == Long.MAX_VALUE) {
            return Ioxxx2;
        }
        return oxoX(oxoX(j, durationUnit, x0xO0oo2), durationUnit, oxoX.Xo0(j2, x0xO0oo2));
    }

    public static final long XO(long j, long j2, @OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        if ((1 | (j2 - 1)) == Long.MAX_VALUE) {
            return oxoX.OOXIxO0(II0xO0(j2));
        }
        return Oxx0IOOO(j, j2, unit);
    }

    public static final long oIX0oI(long j, long j2, long j3) {
        if (oxoX.XX0(j2) && (j ^ j3) < 0) {
            throw new IllegalArgumentException("Summing infinities of different signs");
        }
        return j;
    }

    public static final long oxoX(long j, @OXOo.OOXIXo DurationUnit unit, long j2) {
        IIX0o.x0xO0oo(unit, "unit");
        long Ioxxx2 = oxoX.Ioxxx(j2, unit);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return oIX0oI(j, j2, Ioxxx2);
        }
        if ((1 | (Ioxxx2 - 1)) == Long.MAX_VALUE) {
            return X0o0xo(j, unit, j2);
        }
        long j3 = j + Ioxxx2;
        if (((j ^ j3) & (Ioxxx2 ^ j3)) < 0) {
            if (j >= 0) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
        return j3;
    }
}
