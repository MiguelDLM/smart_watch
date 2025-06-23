package xX0ox;

import com.goodix.ble.gr.libdfu.BuildConfig;
import kotlin.IIX0;
import kotlin.OO0x0xX;
import kotlin.OOXIxO0;
import kotlin.OX00O0xII;
import kotlin.XX0xXo;
import kotlin.jvm.internal.IIX0o;
import kotlin.oI0IIXIo;
import kotlin.oxxXoxO;
import kotlin.xX0IIXIx0;

/* loaded from: classes6.dex */
public class x0XOIxOo {
    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final byte I0Io(byte b, byte b2) {
        if (IIX0o.oI0IIXIo(b & 255, b2 & 255) < 0) {
            return b2;
        }
        return b;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte II0XooXoX(byte b, @OXOo.OOXIXo byte... other) {
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(other);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            b = I0Io(b, OO0x0xX.OOXIXo(other, i));
        }
        return b;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static int II0xO0(int i, int i2) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        if (compare < 0) {
            return i2;
        }
        return i;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static long IIXOooo(long j, long j2) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        if (compare > 0) {
            return j2;
        }
        return j;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final short IXxxXO(short s, short s2, short s3) {
        return ooOOo0oXI(s, ooOOo0oXI(s2, s3));
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final long OOXIXo(long j, long j2, long j3) {
        return xoIox(j, xoIox(j2, j3));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final long Oo(long j, @OXOo.OOXIXo long... other) {
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(other);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            j = IIXOooo(j, OOXIxO0.OOXIXo(other, i));
        }
        return j;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int Oxx0IOOO(int i, int i2, int i3) {
        return II0xO0(i, II0xO0(i2, i3));
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int Oxx0xo(int i, int i2, int i3) {
        return x0XOIxOo(i, x0XOIxOo(i2, i3));
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final byte OxxIIOOXO(byte b, byte b2, byte b3) {
        return oO(b, oO(b2, b3));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final long X0o0xo(long j, @OXOo.OOXIXo long... other) {
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(other);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            j = xoIox(j, OOXIxO0.OOXIXo(other, i));
        }
        return j;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final short XO(short s, short s2, short s3) {
        return oIX0oI(s, oIX0oI(s2, s3));
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final short o00(short s, @OXOo.OOXIXo short... other) {
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(other);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            s = ooOOo0oXI(s, xX0IIXIx0.OOXIXo(other, i));
        }
        return s;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final byte oI0IIXIo(byte b, @OXOo.OOXIXo byte... other) {
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(other);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            b = oO(b, OO0x0xX.OOXIXo(other, i));
        }
        return b;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final short oIX0oI(short s, short s2) {
        if (IIX0o.oI0IIXIo(s & OX00O0xII.f29066Oxx0xo, 65535 & s2) < 0) {
            return s2;
        }
        return s;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final byte oO(byte b, byte b2) {
        if (IIX0o.oI0IIXIo(b & 255, b2 & 255) > 0) {
            return b2;
        }
        return b;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final short oOoXoXO(short s, @OXOo.OOXIXo short... other) {
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(other);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            s = oIX0oI(s, xX0IIXIx0.OOXIXo(other, i));
        }
        return s;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final short ooOOo0oXI(short s, short s2) {
        if (IIX0o.oI0IIXIo(s & OX00O0xII.f29066Oxx0xo, 65535 & s2) > 0) {
            return s2;
        }
        return s;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int oxoX(int i, @OXOo.OOXIXo int... other) {
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(other);
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            i = II0xO0(i, XX0xXo.OOXIXo(other, i2));
        }
        return i;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static int x0XOIxOo(int i, int i2) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return i2;
        }
        return i;
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final int x0xO0oo(int i, @OXOo.OOXIXo int... other) {
        IIX0o.x0xO0oo(other, "other");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(other);
        for (int i2 = 0; i2 < ooOOo0oXI2; i2++) {
            i = x0XOIxOo(i, XX0xXo.OOXIXo(other, i2));
        }
        return i;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static long xoIox(long j, long j2) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        if (compare < 0) {
            return j2;
        }
        return j;
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final long xoXoI(long j, long j2, long j3) {
        return IIXOooo(j, IIXOooo(j2, j3));
    }

    @IIX0(markerClass = {oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final byte xxIXOIIO(byte b, byte b2, byte b3) {
        return I0Io(b, I0Io(b2, b3));
    }
}
