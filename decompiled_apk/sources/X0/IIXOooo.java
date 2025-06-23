package X0;

import X0.oIX0oI;
import X0.ooOOo0oXI;
import X0.xoIox;
import androidx.work.WorkInfo;
import com.garmin.fit.O0Xx;
import com.goodix.ble.gr.libdfu.BuildConfig;
import java.util.NoSuchElementException;
import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;
import kotlin.random.Random;

@XX({"SMAP\n_Ranges.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Ranges.kt\nkotlin/ranges/RangesKt___RangesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1537:1\n1#2:1538\n*E\n"})
/* loaded from: classes6.dex */
public class IIXOooo extends OxxIIOOXO {
    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public static final Integer I0(@OXOo.OOXIXo xoIox xoiox) {
        IIX0o.x0xO0oo(xoiox, "<this>");
        if (xoiox.isEmpty()) {
            return null;
        }
        return Integer.valueOf(xoiox.oxoX());
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "doubleRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean I0X0x0oIo(@OXOo.OOXIXo Oxx0xo<Double> oxx0xo, float f) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        return oxx0xo.contains(Double.valueOf(f));
    }

    @OXOo.OOXIXo
    public static final xoIox I0oOIX(int i, byte b) {
        return xoIox.f3221Oxx0xo.oIX0oI(i, b, -1);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final boolean I0oOoX(oO oOVar, Long l) {
        IIX0o.x0xO0oo(oOVar, "<this>");
        if (l != null && oOVar.xxIXOIIO(l.longValue())) {
            return true;
        }
        return false;
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "shortRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean I0xX0(Oxx0IOOO oxx0IOOO, double d) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Short oX0ooo0I02 = oX0ooo0I0(d);
        if (oX0ooo0I02 != null) {
            return oxx0IOOO.contains(oX0ooo0I02);
        }
        return false;
    }

    @XO0OX.xxIXOIIO(name = "intRangeContains")
    public static boolean IIX0(@OXOo.OOXIXo Oxx0IOOO<Integer> oxx0IOOO, long j) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Integer oX0I0O2 = oX0I0O(j);
        if (oX0I0O2 != null) {
            return oxx0IOOO.contains(oX0I0O2);
        }
        return false;
    }

    public static final double IIX0o(double d, double d2, double d3) {
        if (d2 <= d3) {
            if (d < d2) {
                return d2;
            }
            if (d > d3) {
                return d3;
            }
            return d;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }

    public static long IIXOooo(long j, long j2) {
        if (j < j2) {
            return j2;
        }
        return j;
    }

    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public static final Character IIxOXoOo0(@OXOo.OOXIXo oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        if (oix0oi.isEmpty()) {
            return null;
        }
        return Character.valueOf(oix0oi.oxoX());
    }

    public static final short IO(short s, short s2, short s3) {
        if (s2 <= s3) {
            if (s < s2) {
                return s2;
            }
            if (s > s3) {
                return s3;
            }
            return s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s3) + " is less than minimum " + ((int) s2) + '.');
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Integer IO0XoXxO(oOoXoXO oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        return oXxOI0oIx(oooxoxo, Random.Default);
    }

    @OXOo.OOXIXo
    public static final oIX0oI IOoo(@OXOo.OOXIXo oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        return oIX0oI.f3201Oxx0xo.oIX0oI(oix0oi.X0o0xo(), oix0oi.oxoX(), -oix0oi.XO());
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "longRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean IXO(@OXOo.OOXIXo Oxx0xo<Long> oxx0xo, byte b) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        return oxx0xo.contains(Long.valueOf(b));
    }

    public static final byte IXxxXO(byte b, byte b2) {
        if (b < b2) {
            return b2;
        }
        return b;
    }

    @xx0o0O.XO
    public static final boolean Io(oOoXoXO oooxoxo, short s) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        return xOoOIoI(oooxoxo, s);
    }

    @oxxXoxO(version = "1.7")
    public static final int IoIOOxIIo(@OXOo.OOXIXo xoIox xoiox) {
        IIX0o.x0xO0oo(xoiox, "<this>");
        if (!xoiox.isEmpty()) {
            return xoiox.X0o0xo();
        }
        throw new NoSuchElementException("Progression " + xoiox + " is empty.");
    }

    public static long IoOoX(long j, @OXOo.OOXIXo Oxx0IOOO<Long> range) {
        IIX0o.x0xO0oo(range, "range");
        if (range instanceof XO) {
            return ((Number) oOXoIIIo(Long.valueOf(j), (XO) range)).longValue();
        }
        if (!range.isEmpty()) {
            if (j < range.getStart().longValue()) {
                return range.getStart().longValue();
            }
            if (j > range.getEndInclusive().longValue()) {
                return range.getEndInclusive().longValue();
            }
            return j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @OXOo.OOXIXo
    public static final xoIox IoOoo(short s, byte b) {
        return xoIox.f3221Oxx0xo.oIX0oI(s, b, -1);
    }

    @oxxXoxO(version = "1.3")
    public static final char IoXIXo(@OXOo.OOXIXo I0Io i0Io, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        IIX0o.x0xO0oo(random, "random");
        try {
            return (char) random.nextInt(i0Io.oxoX(), i0Io.X0o0xo() + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @OXOo.OOXIXo
    public static final ooOOo0oXI Ioxxx(long j, byte b) {
        return ooOOo0oXI.f3209Oxx0xo.oIX0oI(j, b, -1L);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "longRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean Ix00oIoI(@OXOo.OOXIXo Oxx0xo<Long> oxx0xo, short s) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        return oxx0xo.contains(Long.valueOf(s));
    }

    @XO0OX.xxIXOIIO(name = "longRangeContains")
    public static final boolean IxIX0I(@OXOo.OOXIXo Oxx0IOOO<Long> oxx0IOOO, int i) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Long.valueOf(i));
    }

    @OXOo.oOoXoXO
    public static final Integer IxX00(double d) {
        if (-2.147483648E9d <= d && d <= 2.147483647E9d) {
            return Integer.valueOf((int) d);
        }
        return null;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "intRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean O0(@OXOo.OOXIXo Oxx0xo<Integer> oxx0xo, long j) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        Integer oX0I0O2 = oX0I0O(j);
        if (oX0I0O2 != null) {
            return oxx0xo.contains(oX0I0O2);
        }
        return false;
    }

    @OXOo.oOoXoXO
    public static final Byte O00(float f) {
        if (-128.0f <= f && f <= 127.0f) {
            return Byte.valueOf((byte) f);
        }
        return null;
    }

    @OXOo.OOXIXo
    public static final ooOOo0oXI O00XxXI(short s, long j) {
        return ooOOo0oXI.f3209Oxx0xo.oIX0oI(s, j, -1L);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final char O0IxXx(I0Io i0Io) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        return IoXIXo(i0Io, Random.Default);
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "intRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean O0X(Oxx0IOOO oxx0IOOO, float f) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Integer XO0o2 = XO0o(f);
        if (XO0o2 != null) {
            return oxx0IOOO.contains(XO0o2);
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final xoIox O0Xx(byte b, short s) {
        return xoIox.f3221Oxx0xo.oIX0oI(b, s, -1);
    }

    public static final double O0xOxO(double d, double d2) {
        if (d > d2) {
            return d2;
        }
        return d;
    }

    @OXOo.oOoXoXO
    public static final Byte O0xxXxI(long j) {
        if (new oO(-128L, 127L).xxIXOIIO(j)) {
            return Byte.valueOf((byte) j);
        }
        return null;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final boolean OI0(oOoXoXO oooxoxo, Integer num) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        if (num != null && oooxoxo.xxIXOIIO(num.intValue())) {
            return true;
        }
        return false;
    }

    @XO0OX.xxIXOIIO(name = "longRangeContains")
    public static final boolean OIOoIIOIx(@OXOo.OOXIXo Oxx0IOOO<Long> oxx0IOOO, byte b) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Long.valueOf(b));
    }

    @OXOo.OOXIXo
    public static xoIox OIx00oxx(@OXOo.OOXIXo xoIox xoiox, int i) {
        boolean z;
        IIX0o.x0xO0oo(xoiox, "<this>");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        OxxIIOOXO.oIX0oI(z, Integer.valueOf(i));
        xoIox.oIX0oI oix0oi = xoIox.f3221Oxx0xo;
        int oxoX2 = xoiox.oxoX();
        int X0o0xo2 = xoiox.X0o0xo();
        if (xoiox.XO() <= 0) {
            i = -i;
        }
        return oix0oi.oIX0oI(oxoX2, X0o0xo2, i);
    }

    @OXOo.OOXIXo
    public static final xoIox OO(int i, short s) {
        return xoIox.f3221Oxx0xo.oIX0oI(i, s, -1);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "shortRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean OO0(@OXOo.OOXIXo Oxx0xo<Short> oxx0xo, long j) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        Short OOOI2 = OOOI(j);
        if (OOOI2 != null) {
            return oxx0xo.contains(OOOI2);
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final ooOOo0oXI OO0x0xX(byte b, long j) {
        return ooOOo0oXI.f3209Oxx0xo.oIX0oI(b, j, -1L);
    }

    @OXOo.OOXIXo
    public static final oO OOIXx0x(byte b, long j) {
        if (j <= Long.MIN_VALUE) {
            return oO.f3206oI0IIXIo.oIX0oI();
        }
        return new oO(b, j - 1);
    }

    @OXOo.oOoXoXO
    public static final Short OOOI(long j) {
        if (new oO(-32768L, 32767L).xxIXOIIO(j)) {
            return Short.valueOf((short) j);
        }
        return null;
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "byteRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean OOXIXo(Oxx0IOOO oxx0IOOO, float f) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Byte O002 = O00(f);
        if (O002 != null) {
            return oxx0IOOO.contains(O002);
        }
        return false;
    }

    @oxxXoxO(version = "1.7")
    public static final long OOXIxO0(@OXOo.OOXIXo ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        if (!ooooo0oxi.isEmpty()) {
            return ooooo0oxi.oxoX();
        }
        throw new NoSuchElementException("Progression " + ooooo0oxi + " is empty.");
    }

    @OXOo.OOXIXo
    public static final oOoXoXO OOxOI(int i, short s) {
        return new oOoXoXO(i, s - 1);
    }

    @XO0OX.xxIXOIIO(name = "shortRangeContains")
    public static final boolean OX(@OXOo.OOXIXo Oxx0IOOO<Short> oxx0IOOO, int i) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Short OxXXx0X2 = OxXXx0X(i);
        if (OxXXx0X2 != null) {
            return oxx0IOOO.contains(OxXXx0X2);
        }
        return false;
    }

    @XO0OX.xxIXOIIO(name = "floatRangeContains")
    public static final boolean OX00O0xII(@OXOo.OOXIXo Oxx0IOOO<Float> oxx0IOOO, double d) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Float.valueOf((float) d));
    }

    @OXOo.OOXIXo
    public static final oOoXoXO OXXoIoXI(short s, int i) {
        if (i <= Integer.MIN_VALUE) {
            return oOoXoXO.f3208oI0IIXIo.oIX0oI();
        }
        return new oOoXoXO(s, i - 1);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "byteRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean Oo(@OXOo.OOXIXo Oxx0xo<Byte> oxx0xo, short s) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        Byte oxOXxoXII2 = oxOXxoXII(s);
        if (oxOXxoXII2 != null) {
            return oxx0xo.contains(oxOXxoXII2);
        }
        return false;
    }

    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public static final Long OoO(@OXOo.OOXIXo ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        if (ooooo0oxi.isEmpty()) {
            return null;
        }
        return Long.valueOf(ooooo0oxi.X0o0xo());
    }

    @OXOo.OOXIXo
    public static final oIX0oI OooI(@OXOo.OOXIXo oIX0oI oix0oi, int i) {
        boolean z;
        IIX0o.x0xO0oo(oix0oi, "<this>");
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        OxxIIOOXO.oIX0oI(z, Integer.valueOf(i));
        oIX0oI.C0048oIX0oI c0048oIX0oI = oIX0oI.f3201Oxx0xo;
        char oxoX2 = oix0oi.oxoX();
        char X0o0xo2 = oix0oi.X0o0xo();
        if (oix0oi.XO() <= 0) {
            i = -i;
        }
        return c0048oIX0oI.oIX0oI(oxoX2, X0o0xo2, i);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "intRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean Ox0O(@OXOo.OOXIXo Oxx0xo<Integer> oxx0xo, byte b) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        return oxx0xo.contains(Integer.valueOf(b));
    }

    public static final byte OxI(byte b, byte b2) {
        if (b > b2) {
            return b2;
        }
        return b;
    }

    @OXOo.OOXIXo
    public static final oOoXoXO OxO(byte b, int i) {
        if (i <= Integer.MIN_VALUE) {
            return oOoXoXO.f3208oI0IIXIo.oIX0oI();
        }
        return new oOoXoXO(b, i - 1);
    }

    @OXOo.oOoXoXO
    public static final Short OxXXx0X(int i) {
        if (new oOoXoXO(-32768, 32767).xxIXOIIO(i)) {
            return Short.valueOf((short) i);
        }
        return null;
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "shortRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean Oxx(Oxx0IOOO oxx0IOOO, float f) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Short oo002 = oo00(f);
        if (oo002 != null) {
            return oxx0IOOO.contains(oo002);
        }
        return false;
    }

    public static final double Oxx0xo(double d, double d2) {
        if (d < d2) {
            return d2;
        }
        return d;
    }

    public static int OxxIIOOXO(int i, int i2) {
        if (i < i2) {
            return i2;
        }
        return i;
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> T X00IoxXI(@OXOo.OOXIXo T t, @OXOo.oOoXoXO T t2, @OXOo.oOoXoXO T t3) {
        IIX0o.x0xO0oo(t, "<this>");
        if (t2 != null && t3 != null) {
            if (t2.compareTo(t3) <= 0) {
                if (t.compareTo(t2) < 0) {
                    return t2;
                }
                if (t.compareTo(t3) > 0) {
                    return t3;
                }
            } else {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + '.');
            }
        } else {
            if (t2 != null && t.compareTo(t2) < 0) {
                return t2;
            }
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    @OXOo.OOXIXo
    public static oOoXoXO X00xOoXI(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return oOoXoXO.f3208oI0IIXIo.oIX0oI();
        }
        return new oOoXoXO(i, i2 - 1);
    }

    public static final float X0IIOO(float f, float f2) {
        if (f > f2) {
            return f2;
        }
        return f;
    }

    @OXOo.OOXIXo
    public static final oOoXoXO X0O0I0(byte b, byte b2) {
        return new oOoXoXO(b, b2 - 1);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Character X0xII0I(I0Io i0Io) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        return X0xxXX0(i0Io, Random.Default);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Character X0xxXX0(@OXOo.OOXIXo I0Io i0Io, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        IIX0o.x0xO0oo(random, "random");
        if (i0Io.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(i0Io.oxoX(), i0Io.X0o0xo() + 1));
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Long XI(@OXOo.OOXIXo oO oOVar, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(oOVar, "<this>");
        IIX0o.x0xO0oo(random, "random");
        if (oOVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(kotlin.random.oxoX.xxIXOIIO(random, oOVar));
    }

    public static int XI0IXoo(int i, int i2) {
        if (i > i2) {
            return i2;
        }
        return i;
    }

    @oxxXoxO(version = "1.7")
    public static final int XI0oooXX(@OXOo.OOXIXo xoIox xoiox) {
        IIX0o.x0xO0oo(xoiox, "<this>");
        if (!xoiox.isEmpty()) {
            return xoiox.oxoX();
        }
        throw new NoSuchElementException("Progression " + xoiox + " is empty.");
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "floatRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean XIXIX(Oxx0IOOO oxx0IOOO, short s) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Float.valueOf(s));
    }

    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public static final Integer XIXIxO(@OXOo.OOXIXo xoIox xoiox) {
        IIX0o.x0xO0oo(xoiox, "<this>");
        if (xoiox.isEmpty()) {
            return null;
        }
        return Integer.valueOf(xoiox.X0o0xo());
    }

    @OXOo.OOXIXo
    public static final ooOOo0oXI XIo0oOXIx(int i, long j) {
        return ooOOo0oXI.f3209Oxx0xo.oIX0oI(i, j, -1L);
    }

    public static long XIxXXX0x0(long j, long j2) {
        if (j > j2) {
            return j2;
        }
        return j;
    }

    @OXOo.OOXIXo
    public static final oOoXoXO XO00XOO(short s, byte b) {
        return new oOoXoXO(s, b - 1);
    }

    @OXOo.oOoXoXO
    public static final Integer XO0o(float f) {
        if (-2.1474836E9f <= f && f <= 2.1474836E9f) {
            return Integer.valueOf((int) f);
        }
        return null;
    }

    @xx0o0O.XO
    public static final boolean XOxIOxOx(oOoXoXO oooxoxo, long j) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        return IIX0(oooxoxo, j);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    public static final Long XOxxooXI(oO oOVar) {
        IIX0o.x0xO0oo(oOVar, "<this>");
        return XI(oOVar, Random.Default);
    }

    @xx0o0O.XO
    public static final boolean XX(oO oOVar, int i) {
        IIX0o.x0xO0oo(oOVar, "<this>");
        return IxIX0I(oOVar, i);
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "doubleRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean XX0(Oxx0IOOO oxx0IOOO, short s) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Double.valueOf(s));
    }

    @OXOo.OOXIXo
    public static final ooOOo0oXI XX0xXo(long j, long j2) {
        return ooOOo0oXI.f3209Oxx0xo.oIX0oI(j, j2, -1L);
    }

    @XO0OX.xxIXOIIO(name = "shortRangeContains")
    public static final boolean XXXI(@OXOo.OOXIXo Oxx0IOOO<Short> oxx0IOOO, byte b) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Short.valueOf(b));
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "longRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean XXoOx0(Oxx0IOOO oxx0IOOO, float f) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Long xX2 = xX(f);
        if (xX2 != null) {
            return oxx0IOOO.contains(xX2);
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final oO Xo(long j, short s) {
        return new oO(j, s - 1);
    }

    @OXOo.OOXIXo
    public static final xoIox Xo0(byte b, byte b2) {
        return xoIox.f3221Oxx0xo.oIX0oI(b, b2, -1);
    }

    @OXOo.OOXIXo
    public static final xoIox XoI0Ixx0(byte b, int i) {
        return xoIox.f3221Oxx0xo.oIX0oI(b, i, -1);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "shortRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean XoIxOXIXo(@OXOo.OOXIXo Oxx0xo<Short> oxx0xo, int i) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        Short OxXXx0X2 = OxXXx0X(i);
        if (OxXXx0X2 != null) {
            return oxx0xo.contains(OxXXx0X2);
        }
        return false;
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "doubleRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean XoX(Oxx0IOOO oxx0IOOO, byte b) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Double.valueOf(b));
    }

    @OXOo.OOXIXo
    public static final oOoXoXO XooIO0oo0(short s, short s2) {
        return new oOoXoXO(s, s2 - 1);
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> T Xx000oIo(@OXOo.OOXIXo T t, @OXOo.OOXIXo Oxx0IOOO<T> range) {
        IIX0o.x0xO0oo(t, "<this>");
        IIX0o.x0xO0oo(range, "range");
        if (range instanceof XO) {
            return (T) oOXoIIIo(t, (XO) range);
        }
        if (!range.isEmpty()) {
            if (t.compareTo(range.getStart()) < 0) {
                return range.getStart();
            }
            if (t.compareTo(range.getEndInclusive()) > 0) {
                return range.getEndInclusive();
            }
            return t;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static final short XxX0x0xxx(short s, short s2) {
        if (s > s2) {
            return s2;
        }
        return s;
    }

    @xx0o0O.XO
    public static final boolean o0(oO oOVar, byte b) {
        IIX0o.x0xO0oo(oOVar, "<this>");
        return OIOoIIOIx(oOVar, b);
    }

    public static final short o00(short s, short s2) {
        if (s < s2) {
            return s2;
        }
        return s;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "shortRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean o0IXXIx(@OXOo.OOXIXo Oxx0xo<Short> oxx0xo, byte b) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        return oxx0xo.contains(Short.valueOf(b));
    }

    @OXOo.OOXIXo
    public static final oOoXoXO o0Xo(int i, byte b) {
        return new oOoXoXO(i, b - 1);
    }

    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public static final Character o0oIxOo(@OXOo.OOXIXo oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        if (oix0oi.isEmpty()) {
            return null;
        }
        return Character.valueOf(oix0oi.X0o0xo());
    }

    @OXOo.OOXIXo
    public static final I0Io o0oxo0oI(char c, char c2) {
        if (IIX0o.oI0IIXIo(c2, 0) <= 0) {
            return I0Io.f3170oI0IIXIo.oIX0oI();
        }
        return new I0Io(c, (char) (c2 - 1));
    }

    @OXOo.OOXIXo
    public static final ooOOo0oXI o0xxxXXxX(long j, short s) {
        return ooOOo0oXI.f3209Oxx0xo.oIX0oI(j, s, -1L);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "longRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean oI(@OXOo.OOXIXo Oxx0xo<Long> oxx0xo, int i) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        return oxx0xo.contains(Long.valueOf(i));
    }

    public static final float oI0IIXIo(float f, float f2) {
        if (f < f2) {
            return f2;
        }
        return f;
    }

    @OXOo.OOXIXo
    public static final xoIox oIIxXoo(@OXOo.OOXIXo xoIox xoiox) {
        IIX0o.x0xO0oo(xoiox, "<this>");
        return xoIox.f3221Oxx0xo.oIX0oI(xoiox.X0o0xo(), xoiox.oxoX(), -xoiox.XO());
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "byteRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean oO(@OXOo.OOXIXo Oxx0xo<Byte> oxx0xo, int i) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        Byte xOOxIO2 = xOOxIO(i);
        if (xOOxIO2 != null) {
            return oxx0xo.contains(xOOxIO2);
        }
        return false;
    }

    @OXOo.OOXIXo
    @oxxXoxO(version = "1.1")
    public static final <T extends Comparable<? super T>> T oOXoIIIo(@OXOo.OOXIXo T t, @OXOo.OOXIXo XO<T> range) {
        IIX0o.x0xO0oo(t, "<this>");
        IIX0o.x0xO0oo(range, "range");
        if (!range.isEmpty()) {
            if (range.oIX0oI(t, range.getStart()) && !range.oIX0oI(range.getStart(), t)) {
                return range.getStart();
            }
            if (range.oIX0oI(range.getEndInclusive(), t) && !range.oIX0oI(t, range.getEndInclusive())) {
                return range.getEndInclusive();
            }
            return t;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "intRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean oOo(Oxx0IOOO oxx0IOOO, double d) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Integer IxX002 = IxX00(d);
        if (IxX002 != null) {
            return oxx0IOOO.contains(IxX002);
        }
        return false;
    }

    @XO0OX.xxIXOIIO(name = "longRangeContains")
    public static final boolean oOoIIO0(@OXOo.OOXIXo Oxx0IOOO<Long> oxx0IOOO, short s) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Long.valueOf(s));
    }

    @XO0OX.xxIXOIIO(name = "byteRangeContains")
    public static final boolean oOoXoXO(@OXOo.OOXIXo Oxx0IOOO<Byte> oxx0IOOO, int i) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Byte xOOxIO2 = xOOxIO(i);
        if (xOOxIO2 != null) {
            return oxx0IOOO.contains(xOOxIO2);
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final oIX0oI oX(char c, char c2) {
        return oIX0oI.f3201Oxx0xo.oIX0oI(c, c2, -1);
    }

    @OXOo.oOoXoXO
    public static final Integer oX0I0O(long j) {
        if (new oO(O0Xx.f12378xXxxox0I, 2147483647L).xxIXOIIO(j)) {
            return Integer.valueOf((int) j);
        }
        return null;
    }

    @OXOo.oOoXoXO
    public static final Short oX0ooo0I0(double d) {
        if (-32768.0d <= d && d <= 32767.0d) {
            return Short.valueOf((short) d);
        }
        return null;
    }

    @XO0OX.xxIXOIIO(name = "intRangeContains")
    public static final boolean oXIO0o0XI(@OXOo.OOXIXo Oxx0IOOO<Integer> oxx0IOOO, byte b) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Integer.valueOf(b));
    }

    @XO0OX.xxIXOIIO(name = "shortRangeContains")
    public static final boolean oXIoO(@OXOo.OOXIXo Oxx0IOOO<Short> oxx0IOOO, long j) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Short OOOI2 = OOOI(j);
        if (OOOI2 != null) {
            return oxx0IOOO.contains(OOOI2);
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final oO oXO0oOx0(short s, long j) {
        if (j <= Long.MIN_VALUE) {
            return oO.f3206oI0IIXIo.oIX0oI();
        }
        return new oO(s, j - 1);
    }

    @OXOo.OOXIXo
    public static final ooOOo0oXI oXX0IoI(@OXOo.OOXIXo ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        return ooOOo0oXI.f3209Oxx0xo.oIX0oI(ooooo0oxi.X0o0xo(), ooooo0oxi.oxoX(), -ooooo0oxi.XO());
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @OXOo.oOoXoXO
    public static final Integer oXxOI0oIx(@OXOo.OOXIXo oOoXoXO oooxoxo, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        IIX0o.x0xO0oo(random, "random");
        if (oooxoxo.isEmpty()) {
            return null;
        }
        return Integer.valueOf(kotlin.random.oxoX.II0XooXoX(random, oooxoxo));
    }

    @OXOo.OOXIXo
    public static final oO oXxx000(long j, byte b) {
        return new oO(j, b - 1);
    }

    public static long oo(long j, long j2, long j3) {
        if (j2 <= j3) {
            if (j < j2) {
                return j2;
            }
            if (j > j3) {
                return j3;
            }
            return j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    @OXOo.oOoXoXO
    public static final Short oo00(float f) {
        if (-32768.0f <= f && f <= 32767.0f) {
            return Short.valueOf((short) f);
        }
        return null;
    }

    public static final int oo0xXOI0I(int i, @OXOo.OOXIXo Oxx0IOOO<Integer> range) {
        IIX0o.x0xO0oo(range, "range");
        if (range instanceof XO) {
            return ((Number) oOXoIIIo(Integer.valueOf(i), (XO) range)).intValue();
        }
        if (!range.isEmpty()) {
            if (i < range.getStart().intValue()) {
                return range.getStart().intValue();
            }
            if (i > range.getEndInclusive().intValue()) {
                return range.getEndInclusive().intValue();
            }
            return i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @XO0OX.xxIXOIIO(name = "byteRangeContains")
    public static final boolean ooOOo0oXI(@OXOo.OOXIXo Oxx0IOOO<Byte> oxx0IOOO, long j) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Byte O0xxXxI2 = O0xxXxI(j);
        if (O0xxXxI2 != null) {
            return oxx0IOOO.contains(O0xxXxI2);
        }
        return false;
    }

    @oxxXoxO(version = "1.7")
    @OXOo.oOoXoXO
    public static final Long ooOx(@OXOo.OOXIXo ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        if (ooooo0oxi.isEmpty()) {
            return null;
        }
        return Long.valueOf(ooooo0oxi.oxoX());
    }

    public static final float ooXIXxIX(float f, float f2, float f3) {
        if (f2 <= f3) {
            if (f < f2) {
                return f2;
            }
            if (f > f3) {
                return f3;
            }
            return f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    @oxxXoxO(version = "1.7")
    public static final char ox(@OXOo.OOXIXo oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        if (!oix0oi.isEmpty()) {
            return oix0oi.oxoX();
        }
        throw new NoSuchElementException("Progression " + oix0oi + " is empty.");
    }

    @oxxXoxO(version = "1.7")
    public static final long oxIIX0o(@OXOo.OOXIXo ooOOo0oXI ooooo0oxi) {
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        if (!ooooo0oxi.isEmpty()) {
            return ooooo0oxi.X0o0xo();
        }
        throw new NoSuchElementException("Progression " + ooooo0oxi + " is empty.");
    }

    @OXOo.oOoXoXO
    public static final Byte oxOXxoXII(short s) {
        if (xOoOIoI(new oOoXoXO(WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, 127), s)) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    @XO0OX.xxIXOIIO(name = "doubleRangeContains")
    public static final boolean oxXx0IX(@OXOo.OOXIXo Oxx0IOOO<Double> oxx0IOOO, float f) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Double.valueOf(f));
    }

    @xx0o0O.XO
    public static final boolean oxxXoxO(oO oOVar, short s) {
        IIX0o.x0xO0oo(oOVar, "<this>");
        return oOoIIO0(oOVar, s);
    }

    @oxxXoxO(version = "1.3")
    public static long x0(@OXOo.OOXIXo oO oOVar, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(oOVar, "<this>");
        IIX0o.x0xO0oo(random, "random");
        try {
            return kotlin.random.oxoX.xxIXOIIO(random, oOVar);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @OXOo.oOoXoXO
    public static final Long x00IOx(double d) {
        if (-9.223372036854776E18d <= d && d <= 9.223372036854776E18d) {
            return Long.valueOf((long) d);
        }
        return null;
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "longRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean x0OIX00oO(Oxx0IOOO oxx0IOOO, double d) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Long x00IOx2 = x00IOx(d);
        if (x00IOx2 != null) {
            return oxx0IOOO.contains(x00IOx2);
        }
        return false;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final long x0OxxIOxX(oO oOVar) {
        IIX0o.x0xO0oo(oOVar, "<this>");
        return x0(oOVar, Random.Default);
    }

    @XO0OX.xxIXOIIO(name = "byteRangeContains")
    public static final boolean x0XOIxOo(@OXOo.OOXIXo Oxx0IOOO<Byte> oxx0IOOO, short s) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Byte oxOXxoXII2 = oxOXxoXII(s);
        if (oxOXxoXII2 != null) {
            return oxx0IOOO.contains(oxOXxoXII2);
        }
        return false;
    }

    @xx0o0O.XO
    public static final boolean x0o(oOoXoXO oooxoxo, byte b) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        return oXIO0o0XI(oooxoxo, b);
    }

    @OXOo.OOXIXo
    public static final xoIox x0xO(short s, short s2) {
        return xoIox.f3221Oxx0xo.oIX0oI(s, s2, -1);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "byteRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean x0xO0oo(@OXOo.OOXIXo Oxx0xo<Byte> oxx0xo, long j) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        Byte O0xxXxI2 = O0xxXxI(j);
        if (O0xxXxI2 != null) {
            return oxx0xo.contains(O0xxXxI2);
        }
        return false;
    }

    public static int xI(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i < i2) {
                return i2;
            }
            if (i > i3) {
                return i3;
            }
            return i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    @oxxXoxO(version = "1.7")
    public static final char xI0oxI00(@OXOo.OOXIXo oIX0oI oix0oi) {
        IIX0o.x0xO0oo(oix0oi, "<this>");
        if (!oix0oi.isEmpty()) {
            return oix0oi.X0o0xo();
        }
        throw new NoSuchElementException("Progression " + oix0oi + " is empty.");
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final boolean xII(I0Io i0Io, Character ch) {
        IIX0o.x0xO0oo(i0Io, "<this>");
        if (ch != null && i0Io.xxIXOIIO(ch.charValue())) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static ooOOo0oXI xIXX(@OXOo.OOXIXo ooOOo0oXI ooooo0oxi, long j) {
        boolean z;
        IIX0o.x0xO0oo(ooooo0oxi, "<this>");
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        OxxIIOOXO.oIX0oI(z, Long.valueOf(j));
        ooOOo0oXI.oIX0oI oix0oi = ooOOo0oXI.f3209Oxx0xo;
        long oxoX2 = ooooo0oxi.oxoX();
        long X0o0xo2 = ooooo0oxi.X0o0xo();
        if (ooooo0oxi.XO() <= 0) {
            j = -j;
        }
        return oix0oi.oIX0oI(oxoX2, X0o0xo2, j);
    }

    @OXOo.OOXIXo
    public static final oO xIx(long j, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return oO.f3206oI0IIXIo.oIX0oI();
        }
        return new oO(j, j2 - 1);
    }

    @OXOo.OOXIXo
    public static final oO xIx0XO(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return oO.f3206oI0IIXIo.oIX0oI();
        }
        return new oO(i, j - 1);
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "floatRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean xOOOX(Oxx0IOOO oxx0IOOO, long j) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Float.valueOf((float) j));
    }

    @OXOo.OOXIXo
    public static final oO xOOxI(long j, int i) {
        return new oO(j, i - 1);
    }

    @OXOo.oOoXoXO
    public static final Byte xOOxIO(int i) {
        if (new oOoXoXO(WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, 127).xxIXOIIO(i)) {
            return Byte.valueOf((byte) i);
        }
        return null;
    }

    @XO0OX.xxIXOIIO(name = "intRangeContains")
    public static final boolean xOoOIoI(@OXOo.OOXIXo Oxx0IOOO<Integer> oxx0IOOO, short s) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Integer.valueOf(s));
    }

    @OXOo.oOoXoXO
    public static final Long xX(float f) {
        if (-9.223372E18f <= f && f <= 9.223372E18f) {
            return Long.valueOf(f);
        }
        return null;
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "floatRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean xX0IIXIx0(Oxx0IOOO oxx0IOOO, int i) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Float.valueOf(i));
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "doubleRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean xXOx(Oxx0IOOO oxx0IOOO, long j) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Double.valueOf(j));
    }

    @oxxXoxO(version = "1.3")
    public static int xXoOI00O(@OXOo.OOXIXo oOoXoXO oooxoxo, @OXOo.OOXIXo Random random) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        IIX0o.x0xO0oo(random, "random");
        try {
            return kotlin.random.oxoX.II0XooXoX(random, oooxoxo);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final byte xXxxox0I(byte b, byte b2, byte b3) {
        if (b2 <= b3) {
            if (b < b2) {
                return b2;
            }
            if (b > b3) {
                return b3;
            }
            return b;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b3) + " is less than minimum " + ((int) b2) + '.');
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "doubleRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean xo0x(Oxx0IOOO oxx0IOOO, int i) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Double.valueOf(i));
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "byteRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean xoIox(Oxx0IOOO oxx0IOOO, double d) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        Byte xxxI2 = xxxI(d);
        if (xxxI2 != null) {
            return oxx0IOOO.contains(xxxI2);
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final xoIox xoIxX(short s, int i) {
        return xoIox.f3221Oxx0xo.oIX0oI(s, i, -1);
    }

    @kotlin.OOXIXo(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @XO0OX.xxIXOIIO(name = "floatRangeContains")
    @kotlin.oOoXoXO(errorSince = BuildConfig.VERSION_NAME, hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean xoO0xx0(Oxx0IOOO oxx0IOOO, byte b) {
        IIX0o.x0xO0oo(oxx0IOOO, "<this>");
        return oxx0IOOO.contains(Float.valueOf(b));
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> T xoXoI(@OXOo.OOXIXo T t, @OXOo.OOXIXo T minimumValue) {
        IIX0o.x0xO0oo(t, "<this>");
        IIX0o.x0xO0oo(minimumValue, "minimumValue");
        if (t.compareTo(minimumValue) < 0) {
            return minimumValue;
        }
        return t;
    }

    @OXOo.OOXIXo
    public static xoIox xoxXI(int i, int i2) {
        return xoIox.f3221Oxx0xo.oIX0oI(i, i2, -1);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @XO0OX.xxIXOIIO(name = "intRangeContains")
    @oxxXoxO(version = "1.9")
    public static final boolean xx0X0(@OXOo.OOXIXo Oxx0xo<Integer> oxx0xo, short s) {
        IIX0o.x0xO0oo(oxx0xo, "<this>");
        return oxx0xo.contains(Integer.valueOf(s));
    }

    @OXOo.OOXIXo
    public static final ooOOo0oXI xxIO(long j, int i) {
        return ooOOo0oXI.f3209Oxx0xo.oIX0oI(j, i, -1L);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.3")
    public static final int xxOXOOoIX(oOoXoXO oooxoxo) {
        IIX0o.x0xO0oo(oooxoxo, "<this>");
        return xXoOI00O(oooxoxo, Random.Default);
    }

    @OXOo.OOXIXo
    public static final <T extends Comparable<? super T>> T xxX(@OXOo.OOXIXo T t, @OXOo.OOXIXo T maximumValue) {
        IIX0o.x0xO0oo(t, "<this>");
        IIX0o.x0xO0oo(maximumValue, "maximumValue");
        if (t.compareTo(maximumValue) > 0) {
            return maximumValue;
        }
        return t;
    }

    @OXOo.OOXIXo
    public static final oOoXoXO xxx00(byte b, short s) {
        return new oOoXoXO(b, s - 1);
    }

    @OXOo.oOoXoXO
    public static final Byte xxxI(double d) {
        if (-128.0d <= d && d <= 127.0d) {
            return Byte.valueOf((byte) d);
        }
        return null;
    }
}
