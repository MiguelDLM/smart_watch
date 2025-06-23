package kotlin.time;

import OoOoXO0.xoXoI;
import X0.IIXOooo;
import com.sma.smartv3.ble.ProductManager;
import java.util.Collection;
import java.util.Iterator;
import kotlin.IIX0;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.time.oxoX;

@XX({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1495:1\n1447#1,6:1497\n1450#1,3:1503\n1447#1,6:1506\n1447#1,6:1512\n1450#1,3:1521\n1#2:1496\n1726#3,3:1518\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/DurationKt\n*L\n1371#1:1497,6\n1405#1:1503,3\n1408#1:1506,6\n1411#1:1512,6\n1447#1:1521,3\n1436#1:1518,3\n*E\n"})
/* loaded from: classes6.dex */
public final class XO {

    /* renamed from: I0Io */
    public static final long f29637I0Io = 4611686018427387903L;

    /* renamed from: II0xO0 */
    public static final long f29638II0xO0 = 4611686018426999999L;

    /* renamed from: oIX0oI */
    public static final int f29639oIX0oI = 1000000;

    /* renamed from: oxoX */
    public static final long f29640oxoX = 4611686018426L;

    public static final long I0X0x0oIo(long j) {
        return j / 1000000;
    }

    @IIX0(markerClass = {xoIox.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final long I0oOIX(double d, long j) {
        return oxoX.O0Xx(j, d);
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void IO(int i) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void IXxxXO(int i) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void Io(double d) {
    }

    @IIX0(markerClass = {xoIox.class})
    @oxxXoxO(version = "1.6")
    public static final long IoOoo(int i, @OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return oOoXoXO(II0XooXoX.I0Io(i, unit, DurationUnit.NANOSECONDS));
        }
        return xoIxX(i, unit);
    }

    public static final String O0Xx(String str, int i, Oox.oOoXoXO<? super Character, Boolean> oooxoxo) {
        int i2 = i;
        while (i2 < str.length() && oooxoxo.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
            i2++;
        }
        IIX0o.x0XOIxOo(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        IIX0o.oO(substring, "substring(...)");
        return substring;
    }

    @IIX0(markerClass = {xoIox.class})
    @oxxXoxO(version = "1.6")
    public static final long OO(double d, @OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        double oIX0oI2 = II0XooXoX.oIX0oI(d, unit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(oIX0oI2)) {
            long Ox0O2 = oOIx.oxoX.Ox0O(oIX0oI2);
            if (new X0.oO(-4611686018426999999L, f29638II0xO0).xxIXOIIO(Ox0O2)) {
                return oOoXoXO(Ox0O2);
            }
            return OOXIXo(oOIx.oxoX.Ox0O(II0XooXoX.oIX0oI(d, unit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.");
    }

    public static final long OOXIXo(long j) {
        if (new X0.oO(-4611686018426L, f29640oxoX).xxIXOIIO(j)) {
            return oOoXoXO(XX0(j));
        }
        return xoIox(IIXOooo.oo(j, -4611686018427387903L, 4611686018427387903L));
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void Oo(double d) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void OxI(long j) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void Oxx0xo(long j) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void X00IoxXI(double d) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void XIxXXX0x0(double d) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void XX(long j) {
    }

    public static final long XX0(long j) {
        return j * 1000000;
    }

    public static final long Xo0(String str) {
        int i;
        int length = str.length();
        if (length > 0 && StringsKt__StringsKt.xXo("+-", str.charAt(0), false, 2, null)) {
            i = 1;
        } else {
            i = 0;
        }
        if (length - i > 16) {
            Iterable oooxoxo = new X0.oOoXoXO(i, StringsKt__StringsKt.IXX(str));
            if (!(oooxoxo instanceof Collection) || !((Collection) oooxoxo).isEmpty()) {
                Iterator it = oooxoxo.iterator();
                while (it.hasNext()) {
                    if (!new X0.I0Io('0', '9').xxIXOIIO(str.charAt(((oOXoIIIo) it).nextInt()))) {
                    }
                }
            }
            if (str.charAt(0) == '-') {
                return Long.MIN_VALUE;
            }
            return Long.MAX_VALUE;
        }
        if (OxI.IOOoXo0Ix(str, xoXoI.f2668X0o0xo, false, 2, null)) {
            str = StringsKt___StringsKt.x0Ix0O(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final int XoI0Ixx0(String str, int i, Oox.oOoXoXO<? super Character, Boolean> oooxoxo) {
        while (i < str.length() && oooxoxo.invoke(Character.valueOf(str.charAt(i))).booleanValue()) {
            i++;
        }
        return i;
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void XxX0x0xxx(long j) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void o0(int i) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void o00(int i) {
    }

    public static final long oOoXoXO(long j) {
        return oxoX.ooOOo0oXI(j << 1);
    }

    public static final long oX(String str, boolean z) {
        int i;
        boolean z2;
        boolean z3;
        long j;
        String str2 = str;
        int length = str.length();
        if (length != 0) {
            oxoX.oIX0oI oix0oi = oxoX.f29647Oo;
            long XX2 = oix0oi.XX();
            char charAt = str2.charAt(0);
            if (charAt == '+' || charAt == '-') {
                i = 1;
            } else {
                i = 0;
            }
            if (i > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && StringsKt__StringsKt.IXI(str2, '-', false, 2, null)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (length > i) {
                char c = '9';
                char c2 = '0';
                if (str2.charAt(i) == 'P') {
                    int i2 = i + 1;
                    if (i2 != length) {
                        DurationUnit durationUnit = null;
                        boolean z4 = false;
                        while (i2 < length) {
                            if (str2.charAt(i2) == 'T') {
                                if (!z4 && (i2 = i2 + 1) != length) {
                                    z4 = true;
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            } else {
                                int i3 = i2;
                                while (i3 < str.length()) {
                                    char charAt2 = str2.charAt(i3);
                                    if (!new X0.I0Io(c2, c).xxIXOIIO(charAt2) && !StringsKt__StringsKt.xXo("+-.", charAt2, false, 2, null)) {
                                        break;
                                    }
                                    i3++;
                                    c = '9';
                                    c2 = '0';
                                }
                                IIX0o.x0XOIxOo(str2, "null cannot be cast to non-null type java.lang.String");
                                String substring = str2.substring(i2, i3);
                                IIX0o.oO(substring, "substring(...)");
                                if (substring.length() != 0) {
                                    int length2 = i2 + substring.length();
                                    if (length2 >= 0 && length2 <= StringsKt__StringsKt.IXX(str)) {
                                        char charAt3 = str2.charAt(length2);
                                        i2 = length2 + 1;
                                        DurationUnit XO2 = xxIXOIIO.XO(charAt3, z4);
                                        if (durationUnit != null && durationUnit.compareTo(XO2) <= 0) {
                                            throw new IllegalArgumentException("Unexpected order of duration components");
                                        }
                                        int XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(substring, '.', 0, false, 6, null);
                                        if (XO2 == DurationUnit.SECONDS && XxIIOXIXx2 > 0) {
                                            IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
                                            String substring2 = substring.substring(0, XxIIOXIXx2);
                                            IIX0o.oO(substring2, "substring(...)");
                                            long XoI0Ixx02 = oxoX.XoI0Ixx0(XX2, xoIxX(Xo0(substring2), XO2));
                                            IIX0o.x0XOIxOo(substring, "null cannot be cast to non-null type java.lang.String");
                                            String substring3 = substring.substring(XxIIOXIXx2);
                                            IIX0o.oO(substring3, "substring(...)");
                                            XX2 = oxoX.XoI0Ixx0(XoI0Ixx02, OO(Double.parseDouble(substring3), XO2));
                                        } else {
                                            XX2 = oxoX.XoI0Ixx0(XX2, xoIxX(Xo0(substring), XO2));
                                        }
                                        durationUnit = XO2;
                                        c = '9';
                                        c2 = '0';
                                        str2 = str;
                                    } else {
                                        throw new IllegalArgumentException("Missing unit for value " + substring);
                                    }
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (!z) {
                    String str3 = "Unexpected order of duration components";
                    if (OxI.OOIXx0x(str, i, ProductManager.OIOXo, 0, Math.max(length - i, 8), true)) {
                        XX2 = oix0oi.Oo();
                    } else {
                        boolean z5 = !z2;
                        if (z2 && str.charAt(i) == '(' && StringsKt___StringsKt.x0ooOIxO(str) == ')') {
                            i++;
                            length--;
                            if (i != length) {
                                j = XX2;
                                z5 = true;
                            } else {
                                throw new IllegalArgumentException("No components");
                            }
                        } else {
                            j = XX2;
                        }
                        boolean z6 = false;
                        DurationUnit durationUnit2 = null;
                        while (i < length) {
                            if (z6 && z5) {
                                while (i < str.length() && str.charAt(i) == ' ') {
                                    i++;
                                }
                            }
                            int i4 = i;
                            while (i4 < str.length()) {
                                char charAt4 = str.charAt(i4);
                                if (!new X0.I0Io('0', '9').xxIXOIIO(charAt4) && charAt4 != '.') {
                                    break;
                                }
                                i4++;
                            }
                            IIX0o.x0XOIxOo(str, "null cannot be cast to non-null type java.lang.String");
                            String substring4 = str.substring(i, i4);
                            IIX0o.oO(substring4, "substring(...)");
                            if (substring4.length() != 0) {
                                int length3 = i + substring4.length();
                                int i5 = length3;
                                while (i5 < str.length()) {
                                    if (!new X0.I0Io('a', 'z').xxIXOIIO(str.charAt(i5))) {
                                        break;
                                    }
                                    i5++;
                                }
                                IIX0o.x0XOIxOo(str, "null cannot be cast to non-null type java.lang.String");
                                String substring5 = str.substring(length3, i5);
                                IIX0o.oO(substring5, "substring(...)");
                                i = length3 + substring5.length();
                                DurationUnit Oxx0IOOO2 = xxIXOIIO.Oxx0IOOO(substring5);
                                if (durationUnit2 == null || durationUnit2.compareTo(Oxx0IOOO2) > 0) {
                                    String str4 = str3;
                                    int XxIIOXIXx3 = StringsKt__StringsKt.XxIIOXIXx(substring4, '.', 0, false, 6, null);
                                    if (XxIIOXIXx3 > 0) {
                                        IIX0o.x0XOIxOo(substring4, "null cannot be cast to non-null type java.lang.String");
                                        String substring6 = substring4.substring(0, XxIIOXIXx3);
                                        IIX0o.oO(substring6, "substring(...)");
                                        long XoI0Ixx03 = oxoX.XoI0Ixx0(j, xoIxX(Long.parseLong(substring6), Oxx0IOOO2));
                                        IIX0o.x0XOIxOo(substring4, "null cannot be cast to non-null type java.lang.String");
                                        String substring7 = substring4.substring(XxIIOXIXx3);
                                        IIX0o.oO(substring7, "substring(...)");
                                        j = oxoX.XoI0Ixx0(XoI0Ixx03, OO(Double.parseDouble(substring7), Oxx0IOOO2));
                                        if (i < length) {
                                            throw new IllegalArgumentException("Fractional component must be last");
                                        }
                                    } else {
                                        j = oxoX.XoI0Ixx0(j, xoIxX(Long.parseLong(substring4), Oxx0IOOO2));
                                    }
                                    durationUnit2 = Oxx0IOOO2;
                                    str3 = str4;
                                    z6 = true;
                                } else {
                                    throw new IllegalArgumentException(str3);
                                }
                            } else {
                                throw new IllegalArgumentException();
                            }
                        }
                        XX2 = j;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
                if (z3) {
                    return oxoX.OOXIxO0(XX2);
                }
                return XX2;
            }
            throw new IllegalArgumentException("No components");
        }
        throw new IllegalArgumentException("The string is empty");
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void oo(long j) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void oo0xXOI0I(int i) {
    }

    public static final long ooOOo0oXI(long j) {
        if (new X0.oO(-4611686018426999999L, f29638II0xO0).xxIXOIIO(j)) {
            return oOoXoXO(j);
        }
        return xoIox(I0X0x0oIo(j));
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void oxXx0IX(double d) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void xI(double d) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void xII(long j) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void xXOx(long j) {
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void xo0x(int i) {
    }

    public static final long xoIox(long j) {
        return oxoX.ooOOo0oXI((j << 1) + 1);
    }

    @IIX0(markerClass = {xoIox.class})
    @oxxXoxO(version = "1.6")
    public static final long xoIxX(long j, @OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long I0Io2 = II0XooXoX.I0Io(f29638II0xO0, durationUnit, unit);
        if (new X0.oO(-I0Io2, I0Io2).xxIXOIIO(j)) {
            return oOoXoXO(II0XooXoX.I0Io(j, unit, durationUnit));
        }
        return xoIox(IIXOooo.oo(II0XooXoX.II0xO0(j, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void xoXoI(double d) {
    }

    @IIX0(markerClass = {xoIox.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.6")
    public static final long xoxXI(int i, long j) {
        return oxoX.I0oOIX(j, i);
    }

    public static final long xxIXOIIO(long j, int i) {
        return oxoX.ooOOo0oXI((j << 1) + i);
    }

    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void xxX(int i) {
    }
}
