package OOOox;

import OXOo.OOXIXo;
import com.garmin.fit.O0Xx;
import com.szabh.smable3.entity.BleWatchFaceId;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nmath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 math.kt\nkotlinx/datetime/internal/MathKt\n*L\n1#1,182:1\n133#1:183\n135#1:184\n133#1:185\n135#1:186\n133#1:187\n133#1,3:188\n133#1:191\n135#1:192\n133#1,3:193\n133#1:196\n135#1:197\n133#1:198\n138#1:199\n138#1:200\n*S KotlinDebug\n*F\n+ 1 math.kt\nkotlinx/datetime/internal/MathKt\n*L\n66#1:183\n67#1:184\n68#1:185\n69#1:186\n80#1:187\n81#1:188,3\n82#1:191\n83#1:192\n83#1:193,3\n84#1:196\n87#1:197\n87#1:198\n93#1:199\n111#1:200\n*E\n"})
/* loaded from: classes6.dex */
public final class II0XooXoX {
    public static final long I0Io(long j, int i) {
        return (j >> i) & 1;
    }

    public static final long II0XooXoX(long j, long j2) {
        if (j2 == -1) {
            if (j == Long.MIN_VALUE) {
                return 0L;
            }
            return -j;
        }
        if (j2 == 1) {
            return j;
        }
        long j3 = j * j2;
        if (j3 / j2 != j) {
            return 0L;
        }
        return j3;
    }

    public static final long II0xO0(long j) {
        return (j >> 32) & BleWatchFaceId.WATCHFACE_ID_INVALID;
    }

    @OOXIXo
    public static final II0xO0 Oxx0IOOO(long j, long j2, long j3) {
        long j4;
        int i;
        long j5;
        if (j != 0 && j2 != 0) {
            long II0XooXoX2 = II0XooXoX(j, j2);
            if (II0XooXoX2 != 0) {
                return new II0xO0(II0XooXoX2 / j3, II0XooXoX2 % j3);
            }
            if (j2 == j3) {
                return new II0xO0(j, 0L);
            }
            if (j == j3) {
                return new II0xO0(j2, 0L);
            }
            long j6 = -1;
            if (j >= 0) {
                j4 = 0;
            } else {
                j4 = -1;
            }
            if (j2 >= 0) {
                j6 = 0;
            }
            long j7 = j & BleWatchFaceId.WATCHFACE_ID_INVALID;
            long j8 = (j >> 32) & BleWatchFaceId.WATCHFACE_ID_INVALID;
            long j9 = j2 & BleWatchFaceId.WATCHFACE_ID_INVALID;
            long j10 = (j2 >> 32) & BleWatchFaceId.WATCHFACE_ID_INVALID;
            long j11 = (j4 * j10) + (j8 * j6);
            long j12 = (j4 * j9) + (j8 * j10) + (j6 * j7);
            long j13 = j8 * j9;
            long j14 = j10 * j7;
            long j15 = j7 * j9;
            long j16 = j15 & BleWatchFaceId.WATCHFACE_ID_INVALID;
            long j17 = (j13 & BleWatchFaceId.WATCHFACE_ID_INVALID) + (j14 & BleWatchFaceId.WATCHFACE_ID_INVALID) + ((j15 >> 32) & BleWatchFaceId.WATCHFACE_ID_INVALID);
            long j18 = j17 & BleWatchFaceId.WATCHFACE_ID_INVALID;
            long j19 = ((j17 >> 32) & BleWatchFaceId.WATCHFACE_ID_INVALID) + (j12 & BleWatchFaceId.WATCHFACE_ID_INVALID) + ((j13 >> 32) & BleWatchFaceId.WATCHFACE_ID_INVALID) + ((j14 >> 32) & BleWatchFaceId.WATCHFACE_ID_INVALID);
            long j20 = (j18 << 32) | j16;
            long j21 = (j19 & BleWatchFaceId.WATCHFACE_ID_INVALID) | (((((j19 >> 32) & BleWatchFaceId.WATCHFACE_ID_INVALID) + ((j12 >> 32) & BleWatchFaceId.WATCHFACE_ID_INVALID)) + (j11 & BleWatchFaceId.WATCHFACE_ID_INVALID)) << 32);
            if (((j21 >> 63) & 1) == 1) {
                i = -1;
            } else {
                i = 1;
            }
            if (i == -1) {
                j20 = (~j20) + 1;
                j21 = ~j21;
                if (j20 == 0) {
                    j21++;
                }
            }
            int i2 = 127;
            long j22 = 0;
            long j23 = 0;
            for (int i3 = -1; i3 < i2; i3 = -1) {
                if (i2 < 64) {
                    j5 = j20 >> i2;
                } else {
                    j5 = j21 >> (i2 - 64);
                }
                j23 = (j23 << 1) | (j5 & 1);
                if (j23 >= j3 || j23 < 0) {
                    j23 -= j3;
                    if (i2 < 63) {
                        j22 |= 1 << i2;
                    } else {
                        throw new ArithmeticException("The result of a multiplication followed by division overflows a long");
                    }
                }
                i2--;
            }
            long j24 = i;
            return new II0xO0(j22 * j24, j24 * j23);
        }
        return new II0xO0(0L, 0L);
    }

    public static final long X0o0xo(long j, long j2, long j3, long j4) {
        if (j > 0 && j3 < 0) {
            j--;
            j3 += j2;
        } else if (j < 0 && j3 > 0) {
            j++;
            j3 -= j2;
        }
        long j5 = j;
        if (j5 == 0) {
            return j3 / j4;
        }
        II0xO0 Oxx0IOOO2 = Oxx0IOOO(j5, j2, j4);
        return Oxx0IOOO.II0xO0(Oxx0IOOO2.oIX0oI(), Oxx0IOOO.II0xO0(j3 / j4, Oxx0IOOO.II0xO0(j3 % j4, Oxx0IOOO2.II0xO0()) / j4));
    }

    public static final long XO(long j, long j2, long j3) {
        if (j > 0 && j3 < 0) {
            j--;
            j3 += j2;
        } else if (j < 0 && j3 > 0) {
            j++;
            j3 -= j2;
        }
        return Oxx0IOOO.II0xO0(Oxx0IOOO.oxoX(j, j2), j3);
    }

    public static final int oIX0oI(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < O0Xx.f12378xXxxox0I) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    public static final long oxoX(long j) {
        return j & BleWatchFaceId.WATCHFACE_ID_INVALID;
    }
}
