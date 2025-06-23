package kotlin.text;

import com.szabh.smable3.entity.BleWatchFaceId;
import kotlin.IIX0;
import kotlin.IoOoo;
import kotlin.KotlinNothingValueException;
import kotlin.O0X;
import kotlin.O0Xx;
import kotlin.OX00O0xII;
import kotlin.XI0oooXX;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;
import kotlin.x0xO;
import kotlin.xxIO;

@XO0OX.xxIXOIIO(name = "UStringsKt")
/* loaded from: classes6.dex */
public final class XxX0x0xxx {
    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final String I0Io(int i, int i2) {
        String l = Long.toString(i & BleWatchFaceId.WATCHFACE_ID_INVALID, II0xO0.oIX0oI(i2));
        IIX0o.oO(l, "toString(...)");
        return l;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final x0xO II0XooXoX(@OXOo.OOXIXo String str, int i) {
        int compare;
        IIX0o.x0xO0oo(str, "<this>");
        xxIO oOoXoXO2 = oOoXoXO(str, i);
        if (oOoXoXO2 == null) {
            return null;
        }
        int OO2 = oOoXoXO2.OO();
        compare = Integer.compare(OO2 ^ Integer.MIN_VALUE, xxIO.oOoXoXO(255) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return null;
        }
        return x0xO.oxoX(x0xO.oOoXoXO((byte) OO2));
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final String II0xO0(byte b, int i) {
        String num = Integer.toString(b & 255, II0xO0.oIX0oI(i));
        IIX0o.oO(num, "toString(...)");
        return num;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final short IXxxXO(@OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        OX00O0xII oI0IIXIo2 = oI0IIXIo(str, i);
        if (oI0IIXIo2 != null) {
            return oI0IIXIo2.I0oOIX();
        }
        o00.OoO(str);
        throw new KotlinNothingValueException();
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final xxIO OOXIXo(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return oOoXoXO(str, 10);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final short Oo(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        OX00O0xII Oxx0xo2 = Oxx0xo(str);
        if (Oxx0xo2 != null) {
            return Oxx0xo2.I0oOIX();
        }
        o00.OoO(str);
        throw new KotlinNothingValueException();
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final x0xO Oxx0IOOO(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return II0XooXoX(str, 10);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final OX00O0xII Oxx0xo(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return oI0IIXIo(str, 10);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final byte X0o0xo(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        x0xO Oxx0IOOO2 = Oxx0IOOO(str);
        if (Oxx0IOOO2 != null) {
            return Oxx0IOOO2.I0oOIX();
        }
        o00.OoO(str);
        throw new KotlinNothingValueException();
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final byte XO(@OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        x0xO II0XooXoX2 = II0XooXoX(str, i);
        if (II0XooXoX2 != null) {
            return II0XooXoX2.I0oOIX();
        }
        o00.OoO(str);
        throw new KotlinNothingValueException();
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final OX00O0xII oI0IIXIo(@OXOo.OOXIXo String str, int i) {
        int compare;
        IIX0o.x0xO0oo(str, "<this>");
        xxIO oOoXoXO2 = oOoXoXO(str, i);
        if (oOoXoXO2 == null) {
            return null;
        }
        int OO2 = oOoXoXO2.OO();
        compare = Integer.compare(OO2 ^ Integer.MIN_VALUE, xxIO.oOoXoXO(65535) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return null;
        }
        return OX00O0xII.oxoX(OX00O0xII.oOoXoXO((short) OO2));
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final String oIX0oI(long j, int i) {
        return O0X.oOoXoXO(j, II0xO0.oIX0oI(i));
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final XI0oooXX oO(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        return x0xO0oo(str, 10);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final xxIO oOoXoXO(@OXOo.OOXIXo String str, int i) {
        int i2;
        int compare;
        int compare2;
        int compare3;
        IIX0o.x0xO0oo(str, "<this>");
        II0xO0.oIX0oI(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = str.charAt(0);
        if (IIX0o.oI0IIXIo(charAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int oOoXoXO2 = xxIO.oOoXoXO(i);
        int i4 = 119304647;
        while (i2 < length) {
            int II0xO02 = II0xO0.II0xO0(str.charAt(i2), i);
            if (II0xO02 >= 0) {
                compare = Integer.compare(i3 ^ Integer.MIN_VALUE, i4 ^ Integer.MIN_VALUE);
                if (compare > 0) {
                    if (i4 == 119304647) {
                        i4 = O0Xx.oIX0oI(-1, oOoXoXO2);
                        compare3 = Integer.compare(i3 ^ Integer.MIN_VALUE, i4 ^ Integer.MIN_VALUE);
                        if (compare3 > 0) {
                        }
                    }
                    return null;
                }
                int oOoXoXO3 = xxIO.oOoXoXO(i3 * oOoXoXO2);
                int oOoXoXO4 = xxIO.oOoXoXO(xxIO.oOoXoXO(II0xO02) + oOoXoXO3);
                compare2 = Integer.compare(oOoXoXO4 ^ Integer.MIN_VALUE, oOoXoXO3 ^ Integer.MIN_VALUE);
                if (compare2 < 0) {
                    return null;
                }
                i2++;
                i3 = oOoXoXO4;
            } else {
                return null;
            }
        }
        return xxIO.oxoX(i3);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long ooOOo0oXI(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        XI0oooXX oO2 = oO(str);
        if (oO2 != null) {
            return oO2.OO();
        }
        o00.OoO(str);
        throw new KotlinNothingValueException();
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final String oxoX(short s, int i) {
        String num = Integer.toString(s & OX00O0xII.f29066Oxx0xo, II0xO0.oIX0oI(i));
        IIX0o.oO(num, "toString(...)");
        return num;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long x0XOIxOo(@OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        XI0oooXX x0xO0oo2 = x0xO0oo(str, i);
        if (x0xO0oo2 != null) {
            return x0xO0oo2.OO();
        }
        o00.OoO(str);
        throw new KotlinNothingValueException();
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final XI0oooXX x0xO0oo(@OXOo.OOXIXo String str, int i) {
        int compare;
        int compare2;
        int compare3;
        IIX0o.x0xO0oo(str, "<this>");
        II0xO0.oIX0oI(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        if (IIX0o.oI0IIXIo(charAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        }
        long oOoXoXO2 = XI0oooXX.oOoXoXO(i);
        long j = 0;
        long j2 = 512409557603043100L;
        while (i2 < length) {
            if (II0xO0.II0xO0(str.charAt(i2), i) >= 0) {
                compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
                if (compare > 0) {
                    if (j2 == 512409557603043100L) {
                        j2 = IoOoo.oIX0oI(-1L, oOoXoXO2);
                        compare3 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
                        if (compare3 > 0) {
                        }
                    }
                    return null;
                }
                long oOoXoXO3 = XI0oooXX.oOoXoXO(j * oOoXoXO2);
                long oOoXoXO4 = XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO(xxIO.oOoXoXO(r13) & BleWatchFaceId.WATCHFACE_ID_INVALID) + oOoXoXO3);
                compare2 = Long.compare(oOoXoXO4 ^ Long.MIN_VALUE, oOoXoXO3 ^ Long.MIN_VALUE);
                if (compare2 < 0) {
                    return null;
                }
                i2++;
                j = oOoXoXO4;
            } else {
                return null;
            }
        }
        return XI0oooXX.oxoX(j);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int xoIox(@OXOo.OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "<this>");
        xxIO oOoXoXO2 = oOoXoXO(str, i);
        if (oOoXoXO2 != null) {
            return oOoXoXO2.OO();
        }
        o00.OoO(str);
        throw new KotlinNothingValueException();
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int xxIXOIIO(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<this>");
        xxIO OOXIXo2 = OOXIXo(str);
        if (OOXIXo2 != null) {
            return OOXIXo2.OO();
        }
        o00.OoO(str);
        throw new KotlinNothingValueException();
    }
}
