package IOI;

import com.google.android.exoplayer2.C;

/* loaded from: classes6.dex */
public final class OOXIXo {
    @OXOo.OOXIXo
    public static final II0XooXoX II0XooXoX(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<this>");
        return II0XooXoX.Companion.oIX0oI(str);
    }

    public static /* synthetic */ xxIXOIIO II0xO0(int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = 0;
        }
        if ((i7 & 2) != 0) {
            i2 = 0;
        }
        if ((i7 & 4) != 0) {
            i3 = 0;
        }
        if ((i7 & 8) != 0) {
            i4 = 0;
        }
        if ((i7 & 16) != 0) {
            i5 = 0;
        }
        if ((i7 & 32) != 0) {
            i6 = 0;
        }
        if ((i7 & 64) != 0) {
            j = 0;
        }
        return oIX0oI(i, i2, i3, i4, i5, i6, j);
    }

    public static final int OOXIXo(int i, int i2) {
        long j = (i * 12) + i2;
        if (com.garmin.fit.O0Xx.f12378xXxxox0I <= j && j <= 2147483647L) {
            return (int) j;
        }
        throw new IllegalArgumentException("The total number of months in " + i + " years and " + i2 + " months overflows an Int");
    }

    @OXOo.OOXIXo
    public static final xxIXOIIO Oxx0IOOO(@OXOo.OOXIXo xxIXOIIO xxixoiio, @OXOo.OOXIXo xxIXOIIO other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxixoiio, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        return oxoX(OOOox.Oxx0IOOO.oIX0oI(xxixoiio.II0XooXoX(), other.II0XooXoX()), OOOox.Oxx0IOOO.oIX0oI(xxixoiio.II0xO0(), other.II0xO0()), OOOox.Oxx0IOOO.II0xO0(xxixoiio.xxIXOIIO(), other.xxIXOIIO()));
    }

    public static /* synthetic */ xxIXOIIO X0o0xo(int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return oxoX(i, i2, j);
    }

    @OXOo.OOXIXo
    public static final II0XooXoX XO(@OXOo.OOXIXo II0XooXoX iI0XooXoX, @OXOo.OOXIXo II0XooXoX other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iI0XooXoX, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        return new II0XooXoX(OOOox.Oxx0IOOO.oIX0oI(iI0XooXoX.II0XooXoX(), other.II0XooXoX()), OOOox.Oxx0IOOO.oIX0oI(iI0XooXoX.II0xO0(), other.II0xO0()));
    }

    @OXOo.OOXIXo
    public static final xxIXOIIO oIX0oI(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        return oxoX(OOXIXo(i, i2), i3, oOoXoXO(i4, i5, i6, j));
    }

    public static final long oOoXoXO(int i, int i2, int i3, long j) {
        long j2 = 60;
        long j3 = ((i * j2) + i2) * j2;
        long j4 = 1000000000;
        try {
            return OOOox.II0XooXoX.XO(j3 + (j / j4) + i3, C.NANOS_PER_SECOND, j % j4);
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("The total number of nanoseconds in " + i + " hours, " + i2 + " minutes, " + i3 + " seconds, and " + j + " nanoseconds overflows a Long");
        }
    }

    @OXOo.OOXIXo
    public static final xxIXOIIO oxoX(int i, int i2, long j) {
        if (j != 0) {
            return new xoIox(i, i2, j);
        }
        return new II0XooXoX(i, i2);
    }

    @OXOo.OOXIXo
    public static final xxIXOIIO xoIox(long j) {
        return X0o0xo(0, 0, kotlin.time.oxoX.X00IoxXI(j), 3, null);
    }

    @OXOo.OOXIXo
    public static final xxIXOIIO xxIXOIIO(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<this>");
        return xxIXOIIO.Companion.oIX0oI(str);
    }
}
