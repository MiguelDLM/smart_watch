package X0;

import X0.O0xOxO;
import X0.xoXoI;
import com.szabh.smable3.entity.BleWatchFaceId;
import java.util.NoSuchElementException;
import kotlin.IIX0;
import kotlin.OX00O0xII;
import kotlin.XI0oooXX;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;
import kotlin.random.Random;
import kotlin.x0xO;
import kotlin.xxIO;

/* loaded from: classes6.dex */
public class xxX {
    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final byte I0Io(byte b, byte b2) {
        if (IIX0o.oI0IIXIo(b & 255, b2 & 255) < 0) {
            return b2;
        }
        return b;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static XI0IXoo I0oOoX(long j, long j2) {
        int compare;
        compare = Long.compare(j2 ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE);
        if (compare <= 0) {
            return XI0IXoo.f3196oI0IIXIo.oIX0oI();
        }
        return new XI0IXoo(j, XI0oooXX.oOoXoXO(j2 - XI0oooXX.oOoXoXO(1 & BleWatchFaceId.WATCHFACE_ID_INVALID)), null);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long II0XooXoX(long j, long j2) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        if (compare > 0) {
            return j2;
        }
        return j;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int II0xO0(int i, int i2) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        if (compare < 0) {
            return i2;
        }
        return i;
    }

    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public static final xxIO IIX0o(@OXOo.OOXIXo xoXoI xoxoi) {
        IIX0o.x0xO0oo(xoxoi, "<this>");
        if (xoxoi.isEmpty()) {
            return null;
        }
        return xxIO.oxoX(xoxoi.X0o0xo());
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final boolean IIXOooo(@OXOo.OOXIXo XI0IXoo contains, short s) {
        IIX0o.x0xO0oo(contains, "$this$contains");
        return contains.II0XooXoX(XI0oooXX.oOoXoXO(s & 65535));
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class, kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final XI0oooXX IO(@OXOo.OOXIXo XI0IXoo xI0IXoo, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(xI0IXoo, "<this>");
        IIX0o.x0xO0oo(random, "random");
        if (xI0IXoo.isEmpty()) {
            return null;
        }
        return XI0oooXX.oxoX(kotlin.random.X0o0xo.oOoXoXO(random, xI0IXoo));
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final boolean IXxxXO(@OXOo.OOXIXo XI0IXoo contains, byte b) {
        IIX0o.x0xO0oo(contains, "$this$contains");
        return contains.II0XooXoX(XI0oooXX.oOoXoXO(b & 255));
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final OxI Io(short s, short s2) {
        if (IIX0o.oI0IIXIo(s2 & OX00O0xII.f29066Oxx0xo, 0) <= 0) {
            return OxI.f3188oI0IIXIo.oIX0oI();
        }
        return new OxI(xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo), xxIO.oOoXoXO(xxIO.oOoXoXO(r3) - 1), null);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long IoOoX(@OXOo.OOXIXo XI0IXoo xI0IXoo, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(xI0IXoo, "<this>");
        IIX0o.x0xO0oo(random, "random");
        try {
            return kotlin.random.X0o0xo.oOoXoXO(random, xI0IXoo);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final O0xOxO O0xOxO(long j, long j2) {
        return O0xOxO.f3179Oxx0xo.oIX0oI(j, j2, -1L);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final O0xOxO OI0(@OXOo.OOXIXo O0xOxO o0xOxO, long j) {
        boolean z;
        IIX0o.x0xO0oo(o0xOxO, "<this>");
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        OxxIIOOXO.oIX0oI(z, Long.valueOf(j));
        O0xOxO.oIX0oI oix0oi = O0xOxO.f3179Oxx0xo;
        long oxoX2 = o0xOxO.oxoX();
        long X0o0xo2 = o0xOxO.X0o0xo();
        if (o0xOxO.XO() <= 0) {
            j = -j;
        }
        return oix0oi.oIX0oI(oxoX2, X0o0xo2, j);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int OOXIXo(int i, int i2, int i3) {
        int compare;
        int compare2;
        int compare3;
        compare = Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
            if (compare2 >= 0) {
                compare3 = Integer.compare(i ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
                if (compare3 > 0) {
                    return i3;
                }
                return i;
            }
            return i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) xxIO.Xo0(i3)) + " is less than minimum " + ((Object) xxIO.Xo0(i2)) + '.');
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final boolean Oo(@OXOo.OOXIXo XI0IXoo contains, int i) {
        IIX0o.x0xO0oo(contains, "$this$contains");
        return contains.II0XooXoX(XI0oooXX.oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID));
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final xoXoI OxI(byte b, byte b2) {
        return xoXoI.f3225Oxx0xo.oIX0oI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(b2 & 255), -1);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final byte Oxx0IOOO(byte b, byte b2) {
        if (IIX0o.oI0IIXIo(b & 255, b2 & 255) > 0) {
            return b2;
        }
        return b;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final boolean Oxx0xo(@OXOo.OOXIXo OxI contains, short s) {
        IIX0o.x0xO0oo(contains, "$this$contains");
        return contains.II0XooXoX(xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final boolean OxxIIOOXO(@OXOo.OOXIXo OxI contains, long j) {
        IIX0o.x0xO0oo(contains, "$this$contains");
        if (XI0oooXX.oOoXoXO(j >>> 32) == 0 && contains.II0XooXoX(xxIO.oOoXoXO((int) j))) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class, kotlin.oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final XI0oooXX X00IoxXI(XI0IXoo xI0IXoo) {
        IIX0o.x0xO0oo(xI0IXoo, "<this>");
        return IO(xI0IXoo, Random.Default);
    }

    @oxxXoxO(version = "1.7")
    public static final int X0IIOO(@OXOo.OOXIXo xoXoI xoxoi) {
        IIX0o.x0xO0oo(xoxoi, "<this>");
        if (!xoxoi.isEmpty()) {
            return xoxoi.oxoX();
        }
        throw new NoSuchElementException("Progression " + xoxoi + " is empty.");
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final short X0o0xo(short s, short s2) {
        if (IIX0o.oI0IIXIo(s & OX00O0xII.f29066Oxx0xo, 65535 & s2) > 0) {
            return s2;
        }
        return s;
    }

    @oxxXoxO(version = "1.7")
    public static final long XI0IXoo(@OXOo.OOXIXo O0xOxO o0xOxO) {
        IIX0o.x0xO0oo(o0xOxO, "<this>");
        if (!o0xOxO.isEmpty()) {
            return o0xOxO.oxoX();
        }
        throw new NoSuchElementException("Progression " + o0xOxO + " is empty.");
    }

    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public static final xxIO XIxXXX0x0(@OXOo.OOXIXo xoXoI xoxoi) {
        IIX0o.x0xO0oo(xoxoi, "<this>");
        if (xoxoi.isEmpty()) {
            return null;
        }
        return xxIO.oxoX(xoxoi.oxoX());
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int XO(int i, int i2) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return i2;
        }
        return i;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final xoXoI XOxIOxOx(@OXOo.OOXIXo xoXoI xoxoi, int i) {
        boolean z;
        IIX0o.x0xO0oo(xoxoi, "<this>");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        OxxIIOOXO.oIX0oI(z, Integer.valueOf(i));
        xoXoI.oIX0oI oix0oi = xoXoI.f3225Oxx0xo;
        int oxoX2 = xoxoi.oxoX();
        int X0o0xo2 = xoxoi.X0o0xo();
        if (xoxoi.XO() <= 0) {
            i = -i;
        }
        return oix0oi.oIX0oI(oxoX2, X0o0xo2, i);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final OxI XX(byte b, byte b2) {
        if (IIX0o.oI0IIXIo(b2 & 255, 0) <= 0) {
            return OxI.f3188oI0IIXIo.oIX0oI();
        }
        return new OxI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(xxIO.oOoXoXO(r3) - 1), null);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class, kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    @OXOo.oOoXoXO
    public static final xxIO Xx000oIo(@OXOo.OOXIXo OxI oxI, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(oxI, "<this>");
        IIX0o.x0xO0oo(random, "random");
        if (oxI.isEmpty()) {
            return null;
        }
        return xxIO.oxoX(kotlin.random.X0o0xo.II0XooXoX(random, oxI));
    }

    @oxxXoxO(version = "1.7")
    public static final int XxX0x0xxx(@OXOo.OOXIXo xoXoI xoxoi) {
        IIX0o.x0xO0oo(xoxoi, "<this>");
        if (!xoxoi.isEmpty()) {
            return xoxoi.X0o0xo();
        }
        throw new NoSuchElementException("Progression " + xoxoi + " is empty.");
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static OxI o0(int i, int i2) {
        int compare;
        compare = Integer.compare(i2 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            return OxI.f3188oI0IIXIo.oIX0oI();
        }
        return new OxI(i, xxIO.oOoXoXO(i2 - 1), null);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final xoXoI o00(int i, int i2) {
        return xoXoI.f3225Oxx0xo.oIX0oI(i, i2, -1);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final boolean oI0IIXIo(OxI contains, xxIO xxio) {
        IIX0o.x0xO0oo(contains, "$this$contains");
        if (xxio != null && contains.II0XooXoX(xxio.OO())) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final short oIX0oI(short s, short s2) {
        if (IIX0o.oI0IIXIo(s & OX00O0xII.f29066Oxx0xo, 65535 & s2) < 0) {
            return s2;
        }
        return s;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final boolean oO(@OXOo.OOXIXo OxI contains, byte b) {
        IIX0o.x0xO0oo(contains, "$this$contains");
        return contains.II0XooXoX(xxIO.oOoXoXO(b & 255));
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class, kotlin.oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final xxIO oOXoIIIo(OxI oxI) {
        IIX0o.x0xO0oo(oxI, "<this>");
        return Xx000oIo(oxI, Random.Default);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final byte oOoXoXO(byte b, byte b2, byte b3) {
        int i = b2 & 255;
        int i2 = b3 & 255;
        if (IIX0o.oI0IIXIo(i, i2) <= 0) {
            int i3 = b & 255;
            if (IIX0o.oI0IIXIo(i3, i) < 0) {
                return b2;
            }
            if (IIX0o.oI0IIXIo(i3, i2) > 0) {
                return b3;
            }
            return b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) x0xO.I0X0x0oIo(b3)) + " is less than minimum " + ((Object) x0xO.I0X0x0oIo(b2)) + '.');
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final long oo(XI0IXoo xI0IXoo) {
        IIX0o.x0xO0oo(xI0IXoo, "<this>");
        return IoOoX(xI0IXoo, Random.Default);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int oo0xXOI0I(@OXOo.OOXIXo OxI oxI, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(oxI, "<this>");
        IIX0o.x0xO0oo(random, "random");
        try {
            return kotlin.random.X0o0xo.II0XooXoX(random, oxI);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long ooOOo0oXI(long j, long j2, long j3) {
        int compare;
        int compare2;
        int compare3;
        compare = Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            if (compare2 >= 0) {
                compare3 = Long.compare(j ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE);
                if (compare3 > 0) {
                    return j3;
                }
                return j;
            }
            return j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) XI0oooXX.Xo0(j3)) + " is less than minimum " + ((Object) XI0oooXX.Xo0(j2)) + '.');
    }

    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public static final XI0oooXX ooXIXxIX(@OXOo.OOXIXo O0xOxO o0xOxO) {
        IIX0o.x0xO0oo(o0xOxO, "<this>");
        if (o0xOxO.isEmpty()) {
            return null;
        }
        return XI0oooXX.oxoX(o0xOxO.X0o0xo());
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long oxoX(long j, long j2) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
        if (compare < 0) {
            return j2;
        }
        return j;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final int x0XOIxOo(int i, @OXOo.OOXIXo Oxx0IOOO<xxIO> range) {
        int compare;
        int compare2;
        IIX0o.x0xO0oo(range, "range");
        if (range instanceof XO) {
            return ((xxIO) IIXOooo.oOXoIIIo(xxIO.oxoX(i), (XO) range)).OO();
        }
        if (!range.isEmpty()) {
            compare = Integer.compare(i ^ Integer.MIN_VALUE, range.getStart().OO() ^ Integer.MIN_VALUE);
            if (compare >= 0) {
                compare2 = Integer.compare(i ^ Integer.MIN_VALUE, range.getEndInclusive().OO() ^ Integer.MIN_VALUE);
                if (compare2 > 0) {
                    return range.getEndInclusive().OO();
                }
                return i;
            }
            return range.getStart().OO();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final O0xOxO x0o(@OXOo.OOXIXo O0xOxO o0xOxO) {
        IIX0o.x0xO0oo(o0xOxO, "<this>");
        return O0xOxO.f3179Oxx0xo.oIX0oI(o0xOxO.X0o0xo(), o0xOxO.oxoX(), -o0xOxO.XO());
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final boolean x0xO0oo(XI0IXoo contains, XI0oooXX xI0oooXX) {
        IIX0o.x0xO0oo(contains, "$this$contains");
        if (xI0oooXX != null && contains.II0XooXoX(xI0oooXX.OO())) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.5")
    public static final int xI(OxI oxI) {
        IIX0o.x0xO0oo(oxI, "<this>");
        return oo0xXOI0I(oxI, Random.Default);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final xoXoI xII(@OXOo.OOXIXo xoXoI xoxoi) {
        IIX0o.x0xO0oo(xoxoi, "<this>");
        return xoXoI.f3225Oxx0xo.oIX0oI(xoxoi.X0o0xo(), xoxoi.oxoX(), -xoxoi.XO());
    }

    @oxxXoxO(version = "1.7")
    public static final long xXxxox0I(@OXOo.OOXIXo O0xOxO o0xOxO) {
        IIX0o.x0xO0oo(o0xOxO, "<this>");
        if (!o0xOxO.isEmpty()) {
            return o0xOxO.X0o0xo();
        }
        throw new NoSuchElementException("Progression " + o0xOxO + " is empty.");
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final short xoIox(short s, short s2, short s3) {
        int i = s2 & OX00O0xII.f29066Oxx0xo;
        int i2 = s3 & OX00O0xII.f29066Oxx0xo;
        if (IIX0o.oI0IIXIo(i, i2) <= 0) {
            int i3 = 65535 & s;
            if (IIX0o.oI0IIXIo(i3, i) < 0) {
                return s2;
            }
            if (IIX0o.oI0IIXIo(i3, i2) > 0) {
                return s3;
            }
            return s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) OX00O0xII.I0X0x0oIo(s3)) + " is less than minimum " + ((Object) OX00O0xII.I0X0x0oIo(s2)) + '.');
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.5")
    public static final xoXoI xoXoI(short s, short s2) {
        return xoXoI.f3225Oxx0xo.oIX0oI(xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo), xxIO.oOoXoXO(s2 & OX00O0xII.f29066Oxx0xo), -1);
    }

    @IIX0(markerClass = {kotlin.oI0IIXIo.class})
    @oxxXoxO(version = "1.5")
    public static final long xxIXOIIO(long j, @OXOo.OOXIXo Oxx0IOOO<XI0oooXX> range) {
        int compare;
        int compare2;
        IIX0o.x0xO0oo(range, "range");
        if (range instanceof XO) {
            return ((XI0oooXX) IIXOooo.oOXoIIIo(XI0oooXX.oxoX(j), (XO) range)).OO();
        }
        if (!range.isEmpty()) {
            compare = Long.compare(j ^ Long.MIN_VALUE, range.getStart().OO() ^ Long.MIN_VALUE);
            if (compare >= 0) {
                compare2 = Long.compare(j ^ Long.MIN_VALUE, range.getEndInclusive().OO() ^ Long.MIN_VALUE);
                if (compare2 > 0) {
                    return range.getEndInclusive().OO();
                }
                return j;
            }
            return range.getStart().OO();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public static final XI0oooXX xxX(@OXOo.OOXIXo O0xOxO o0xOxO) {
        IIX0o.x0xO0oo(o0xOxO, "<this>");
        if (o0xOxO.isEmpty()) {
            return null;
        }
        return XI0oooXX.oxoX(o0xOxO.oxoX());
    }
}
