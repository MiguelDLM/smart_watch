package kotlin.time;

import Oox.oI0IIXIo;
import androidx.exifinterface.media.ExifInterface;
import com.garmin.fit.O0Xx;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.ble.ProductManager;
import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.o0;
import kotlin.oxxXoxO;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.xxIO;

@IIX0(markerClass = {xoIox.class})
@XO0OX.Oxx0IOOO
@oxxXoxO(version = "1.6")
@XX({"SMAP\nDuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1495:1\n38#1:1496\n38#1:1497\n38#1:1498\n38#1:1499\n38#1:1500\n683#1,2:1501\n700#1,2:1510\n163#2,6:1503\n1#3:1509\n*S KotlinDebug\n*F\n+ 1 Duration.kt\nkotlin/time/Duration\n*L\n39#1:1496\n40#1:1497\n458#1:1498\n478#1:1499\n662#1:1500\n979#1:1501,2\n1070#1:1510,2\n1021#1:1503,6\n*E\n"})
/* loaded from: classes6.dex */
public final class oxoX implements Comparable<oxoX> {

    /* renamed from: XO, reason: collision with root package name */
    public final long f29650XO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29647Oo = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final long f29646IXxxXO = ooOOo0oXI(0);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final long f29648Oxx0xo = XO.II0xO0(4611686018427387903L);

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final long f29649oI0IIXIo = XO.II0xO0(-4611686018427387903L);

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @xx0o0O.XO
        public static /* synthetic */ void II0XooXoX(double d) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void IIX0o(double d) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void IIXOooo(int i) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void IO(long j) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void Io(int i) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void OI0(double d) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void OxxIIOOXO(double d) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void X00IoxXI(int i) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void X0IIOO(double d) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void XI0IXoo(int i) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void XIxXXX0x0(long j) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void Xx000oIo(double d) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void o0(long j) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void oO(int i) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void ooXIXxIX(int i) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void x0XOIxOo(double d) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void x0xO0oo(long j) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void xI(long j) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void xoIox(long j) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void xoXoI(long j) {
        }

        @xx0o0O.XO
        public static /* synthetic */ void xxIXOIIO(int i) {
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long I0Io(int i) {
            return XO.IoOoo(i, DurationUnit.DAYS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long I0X0x0oIo(int i) {
            return XO.IoOoo(i, DurationUnit.MILLISECONDS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long I0oOIX(double d) {
            return XO.OO(d, DurationUnit.NANOSECONDS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long I0oOoX(double d) {
            return XO.OO(d, DurationUnit.HOURS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long II0xO0(double d) {
            return XO.OO(d, DurationUnit.DAYS);
        }

        public final long IXxxXO(double d) {
            return XO.OO(d, DurationUnit.MICROSECONDS);
        }

        public final long IoOoX(int i) {
            return XO.IoOoo(i, DurationUnit.NANOSECONDS);
        }

        public final long IoOoo(@OXOo.OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            try {
                return XO.II0XooXoX(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long Ioxxx(int i) {
            return XO.IoOoo(i, DurationUnit.SECONDS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long O0Xx(long j) {
            return XO.xoIxX(j, DurationUnit.MINUTES);
        }

        public final long O0xOxO(long j) {
            return XO.xoIxX(j, DurationUnit.MILLISECONDS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long OO(long j) {
            return XO.xoIxX(j, DurationUnit.NANOSECONDS);
        }

        @OXOo.oOoXoXO
        public final oxoX OO0x0xX(@OXOo.OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            try {
                return oxoX.xoIox(XO.II0XooXoX(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final long OOXIXo(double d) {
            return XO.OO(d, DurationUnit.HOURS);
        }

        public final long Oo() {
            return oxoX.f29648Oxx0xo;
        }

        public final long OxI(int i) {
            return XO.IoOoo(i, DurationUnit.MILLISECONDS);
        }

        public final long Oxx0IOOO(long j) {
            return XO.xoIxX(j, DurationUnit.DAYS);
        }

        public final long Oxx0xo(int i) {
            return XO.IoOoo(i, DurationUnit.MICROSECONDS);
        }

        public final long X0o0xo(double d) {
            return XO.OO(d, DurationUnit.DAYS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long XIo0oOXIx(double d) {
            return XO.OO(d, DurationUnit.SECONDS);
        }

        public final long XO(int i) {
            return XO.IoOoo(i, DurationUnit.DAYS);
        }

        public final long XOxIOxOx(long j) {
            return XO.xoIxX(j, DurationUnit.SECONDS);
        }

        public final long XX() {
            return oxoX.f29646IXxxXO;
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long XX0(double d) {
            return XO.OO(d, DurationUnit.MILLISECONDS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long Xo0(double d) {
            return XO.OO(d, DurationUnit.MINUTES);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long XoI0Ixx0(int i) {
            return XO.IoOoo(i, DurationUnit.MINUTES);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long XoX(long j) {
            return XO.xoIxX(j, DurationUnit.HOURS);
        }

        public final long XxX0x0xxx(int i) {
            return XO.IoOoo(i, DurationUnit.MINUTES);
        }

        public final long o00(double d) {
            return XO.OO(d, DurationUnit.MILLISECONDS);
        }

        public final long oI0IIXIo(long j) {
            return XO.xoIxX(j, DurationUnit.MICROSECONDS);
        }

        @xoIox
        public final double oIX0oI(double d, @OXOo.OOXIXo DurationUnit sourceUnit, @OXOo.OOXIXo DurationUnit targetUnit) {
            IIX0o.x0xO0oo(sourceUnit, "sourceUnit");
            IIX0o.x0xO0oo(targetUnit, "targetUnit");
            return II0XooXoX.oIX0oI(d, sourceUnit, targetUnit);
        }

        public final long oOXoIIIo(long j) {
            return XO.xoIxX(j, DurationUnit.NANOSECONDS);
        }

        public final long oOoXoXO(int i) {
            return XO.IoOoo(i, DurationUnit.HOURS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long oX(long j) {
            return XO.xoIxX(j, DurationUnit.MILLISECONDS);
        }

        public final long oo(double d) {
            return XO.OO(d, DurationUnit.NANOSECONDS);
        }

        public final long oo0xXOI0I() {
            return oxoX.f29649oI0IIXIo;
        }

        public final long ooOOo0oXI(long j) {
            return XO.xoIxX(j, DurationUnit.HOURS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long oxXx0IX(double d) {
            return XO.OO(d, DurationUnit.MICROSECONDS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long oxoX(long j) {
            return XO.xoIxX(j, DurationUnit.DAYS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long oxxXoxO(int i) {
            return XO.IoOoo(i, DurationUnit.HOURS);
        }

        public final long x0o(int i) {
            return XO.IoOoo(i, DurationUnit.SECONDS);
        }

        @OXOo.oOoXoXO
        public final oxoX x0xO(@OXOo.OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            try {
                return oxoX.xoIox(XO.II0XooXoX(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final long xII(double d) {
            return XO.OO(d, DurationUnit.SECONDS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long xXOx(long j) {
            return XO.xoIxX(j, DurationUnit.MICROSECONDS);
        }

        public final long xXxxox0I(long j) {
            return XO.xoIxX(j, DurationUnit.MINUTES);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long xo0x(int i) {
            return XO.IoOoo(i, DurationUnit.MICROSECONDS);
        }

        public final long xoIxX(@OXOo.OOXIXo String value) {
            IIX0o.x0xO0oo(value, "value");
            try {
                return XO.II0XooXoX(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long xoxXI(int i) {
            return XO.IoOoo(i, DurationUnit.NANOSECONDS);
        }

        @oxxXoxO(version = "1.5")
        @kotlin.OOXIXo(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.XX(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @xoIox
        @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.6")
        public final /* synthetic */ long xxIO(long j) {
            return XO.xoIxX(j, DurationUnit.SECONDS);
        }

        public final long xxX(double d) {
            return XO.OO(d, DurationUnit.MINUTES);
        }

        public oIX0oI() {
        }
    }

    public /* synthetic */ oxoX(long j) {
        this.f29650XO = j;
    }

    public static final boolean I0X0x0oIo(long j) {
        return j < 0;
    }

    public static final long I0oOIX(long j, int i) {
        if (XX0(j)) {
            if (i != 0) {
                if (i > 0) {
                    return j;
                }
                return OOXIxO0(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i == 0) {
            return f29646IXxxXO;
        }
        long oxxXoxO2 = oxxXoxO(j);
        long j2 = i;
        long j3 = oxxXoxO2 * j2;
        if (xXOx(j)) {
            if (new X0.oO(-2147483647L, 2147483647L).xxIXOIIO(oxxXoxO2)) {
                return XO.oxoX(j3);
            }
            if (j3 / j2 == oxxXoxO2) {
                return XO.X0o0xo(j3);
            }
            long Oxx0IOOO2 = XO.Oxx0IOOO(oxxXoxO2);
            long j4 = Oxx0IOOO2 * j2;
            long Oxx0IOOO3 = XO.Oxx0IOOO((oxxXoxO2 - XO.XO(Oxx0IOOO2)) * j2) + j4;
            if (j4 / j2 == Oxx0IOOO2 && (Oxx0IOOO3 ^ j4) >= 0) {
                return XO.II0xO0(X0.IIXOooo.IoOoX(Oxx0IOOO3, new X0.oO(-4611686018427387903L, 4611686018427387903L)));
            }
            if (oOIx.oxoX.o0(oxxXoxO2) * oOIx.oxoX.Io(i) > 0) {
                return f29648Oxx0xo;
            }
            return f29649oI0IIXIo;
        }
        if (j3 / j2 == oxxXoxO2) {
            return XO.II0xO0(X0.IIXOooo.IoOoX(j3, new X0.oO(-4611686018427387903L, 4611686018427387903L)));
        }
        if (oOIx.oxoX.o0(oxxXoxO2) * oOIx.oxoX.Io(i) > 0) {
            return f29648Oxx0xo;
        }
        return f29649oI0IIXIo;
    }

    public static final int I0oOoX(long j) {
        return ((int) j) & 1;
    }

    public static final void II0XooXoX(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String I0OO2 = StringsKt__StringsKt.I0OO(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = I0OO2.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (I0OO2.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((CharSequence) I0OO2, 0, i6);
                IIX0o.oO(sb, "append(...)");
            } else {
                sb.append((CharSequence) I0OO2, 0, ((i4 + 3) / 3) * 3);
                IIX0o.oO(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    @kotlin.OOXIXo(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @kotlin.XX(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void IIXOooo() {
    }

    public static final long IO(long j) {
        return Ioxxx(j, DurationUnit.SECONDS);
    }

    public static final boolean IXxxXO(long j, long j2) {
        return j == j2;
    }

    @o0
    public static /* synthetic */ void Io() {
    }

    public static final long IoOoX(long j) {
        return Ioxxx(j, DurationUnit.MICROSECONDS);
    }

    public static final <T> T IoOoo(long j, @OXOo.OOXIXo Oox.Oxx0xo<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        IIX0o.x0xO0oo(action, "action");
        return action.invoke(Long.valueOf(oo(j)), Integer.valueOf(x0o(j)), Integer.valueOf(o0(j)), Integer.valueOf(OI0(j)));
    }

    public static final long Ioxxx(long j, @OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        if (j == f29648Oxx0xo) {
            return Long.MAX_VALUE;
        }
        if (j == f29649oI0IIXIo) {
            return Long.MIN_VALUE;
        }
        return II0XooXoX.II0xO0(oxxXoxO(j), XX(j), unit);
    }

    @OXOo.OOXIXo
    public static final String O00XxXI(long j, @OXOo.OOXIXo DurationUnit unit, int i) {
        IIX0o.x0xO0oo(unit, "unit");
        if (i >= 0) {
            double x0xO2 = x0xO(j, unit);
            if (Double.isInfinite(x0xO2)) {
                return String.valueOf(x0xO2);
            }
            return X0o0xo.II0xO0(x0xO2, X0.IIXOooo.XI0IXoo(i, 12)) + xxIXOIIO.II0XooXoX(unit);
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
    }

    public static final long O0Xx(long j, double d) {
        int IIX02 = oOIx.oxoX.IIX0(d);
        if (IIX02 == d) {
            return I0oOIX(j, IIX02);
        }
        DurationUnit XX2 = XX(j);
        return XO.OO(x0xO(j, XX2) * d, XX2);
    }

    @kotlin.OOXIXo(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @kotlin.XX(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void O0xOxO() {
    }

    public static final int OI0(long j) {
        long oxxXoxO2;
        if (XX0(j)) {
            return 0;
        }
        if (xo0x(j)) {
            oxxXoxO2 = XO.XO(oxxXoxO(j) % 1000);
        } else {
            oxxXoxO2 = oxxXoxO(j) % 1000000000;
        }
        return (int) oxxXoxO2;
    }

    public static final <T> T OO(long j, @OXOo.OOXIXo Oox.IXxxXO<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        IIX0o.x0xO0oo(action, "action");
        return action.invoke(Long.valueOf(Xx000oIo(j)), Integer.valueOf(o0(j)), Integer.valueOf(OI0(j)));
    }

    public static final int OO0x0xX(long j, @OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        return (int) X0.IIXOooo.oo(Ioxxx(j, unit), O0Xx.f12378xXxxox0I, 2147483647L);
    }

    public static final long OOXIxO0(long j) {
        return XO.oIX0oI(-oxxXoxO(j), ((int) j) & 1);
    }

    public static boolean Oo(long j, Object obj) {
        return (obj instanceof oxoX) && j == ((oxoX) obj).IIxOXoOo0();
    }

    public static final long Oxx0IOOO(long j, long j2, long j3) {
        long Oxx0IOOO2 = XO.Oxx0IOOO(j3);
        long j4 = j2 + Oxx0IOOO2;
        if (new X0.oO(-4611686018426L, XO.f29640oxoX).xxIXOIIO(j4)) {
            return XO.oxoX(XO.XO(j4) + (j3 - XO.XO(Oxx0IOOO2)));
        }
        return XO.II0xO0(X0.IIXOooo.oo(j4, -4611686018427387903L, 4611686018427387903L));
    }

    public static final long Oxx0xo(long j) {
        if (I0X0x0oIo(j)) {
            return OOXIxO0(j);
        }
        return j;
    }

    public static final int OxxIIOOXO(long j) {
        if (XX0(j)) {
            return 0;
        }
        return (int) (oo(j) % 24);
    }

    public static final long X00IoxXI(long j) {
        long oxxXoxO2 = oxxXoxO(j);
        if (!xXOx(j)) {
            if (oxxXoxO2 > xxIO.f30498XO) {
                return Long.MAX_VALUE;
            }
            if (oxxXoxO2 < -9223372036854L) {
                return Long.MIN_VALUE;
            }
            return XO.XO(oxxXoxO2);
        }
        return oxxXoxO2;
    }

    @kotlin.OOXIXo(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @kotlin.XX(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void XI0IXoo() {
    }

    public static final long XI0oooXX(long j, @OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        DurationUnit XX2 = XX(j);
        if (unit.compareTo(XX2) > 0 && !XX0(j)) {
            return XO.xoIxX(oxxXoxO(j) - (oxxXoxO(j) % II0XooXoX.II0xO0(1L, unit, XX2)), XX2);
        }
        return j;
    }

    @OXOo.OOXIXo
    public static final String XIo0oOXIx(long j) {
        boolean z;
        boolean z2;
        StringBuilder sb = new StringBuilder();
        if (I0X0x0oIo(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long Oxx0xo2 = Oxx0xo(j);
        long oo2 = oo(Oxx0xo2);
        int x0o2 = x0o(Oxx0xo2);
        int o02 = o0(Oxx0xo2);
        int OI02 = OI0(Oxx0xo2);
        if (XX0(j)) {
            oo2 = 9999999999999L;
        }
        boolean z3 = false;
        if (oo2 != 0) {
            z = true;
        } else {
            z = false;
        }
        if (o02 == 0 && OI02 == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (x0o2 != 0 || (z2 && z)) {
            z3 = true;
        }
        if (z) {
            sb.append(oo2);
            sb.append('H');
        }
        if (z3) {
            sb.append(x0o2);
            sb.append('M');
        }
        if (z2 || (!z && !z3)) {
            II0XooXoX(j, sb, o02, OI02, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    @o0
    public static /* synthetic */ void XOxIOxOx() {
    }

    public static final DurationUnit XX(long j) {
        if (xXOx(j)) {
            return DurationUnit.NANOSECONDS;
        }
        return DurationUnit.MILLISECONDS;
    }

    public static final boolean XX0(long j) {
        if (j != f29648Oxx0xo && j != f29649oI0IIXIo) {
            return false;
        }
        return true;
    }

    public static final long Xo0(long j, long j2) {
        return XoI0Ixx0(j, OOXIxO0(j2));
    }

    public static final long XoI0Ixx0(long j, long j2) {
        if (XX0(j)) {
            if (!oxXx0IX(j2) && (j2 ^ j) < 0) {
                throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            }
            return j;
        }
        if (XX0(j2)) {
            return j2;
        }
        if ((((int) j) & 1) == (((int) j2) & 1)) {
            long oxxXoxO2 = oxxXoxO(j) + oxxXoxO(j2);
            if (xXOx(j)) {
                return XO.X0o0xo(oxxXoxO2);
            }
            return XO.I0Io(oxxXoxO2);
        }
        if (xo0x(j)) {
            return Oxx0IOOO(j, oxxXoxO(j), oxxXoxO(j2));
        }
        return Oxx0IOOO(j, oxxXoxO(j2), oxxXoxO(j));
    }

    public static int XoX(long j) {
        return androidx.collection.oIX0oI.oIX0oI(j);
    }

    public static final long Xx000oIo(long j) {
        return Ioxxx(j, DurationUnit.MINUTES);
    }

    public static final int o0(long j) {
        if (XX0(j)) {
            return 0;
        }
        return (int) (IO(j) % 60);
    }

    @kotlin.OOXIXo(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @kotlin.XX(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void o00() {
    }

    @OXOo.OOXIXo
    public static String o0xxxXXxX(long j) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (j == 0) {
            return "0s";
        }
        if (j == f29648Oxx0xo) {
            return ProductManager.OIOXo;
        }
        if (j == f29649oI0IIXIo) {
            return "-Infinity";
        }
        boolean I0X0x0oIo2 = I0X0x0oIo(j);
        StringBuilder sb = new StringBuilder();
        if (I0X0x0oIo2) {
            sb.append('-');
        }
        long Oxx0xo2 = Oxx0xo(j);
        long oo0xXOI0I2 = oo0xXOI0I(Oxx0xo2);
        int OxxIIOOXO2 = OxxIIOOXO(Oxx0xo2);
        int x0o2 = x0o(Oxx0xo2);
        int o02 = o0(Oxx0xo2);
        int OI02 = OI0(Oxx0xo2);
        int i = 0;
        if (oo0xXOI0I2 != 0) {
            z = true;
        } else {
            z = false;
        }
        if (OxxIIOOXO2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (x0o2 != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (o02 == 0 && OI02 == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z) {
            sb.append(oo0xXOI0I2);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(TokenParser.SP);
            }
            sb.append(OxxIIOOXO2);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(TokenParser.SP);
            }
            sb.append(x0o2);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(TokenParser.SP);
            }
            if (o02 == 0 && !z && !z2 && !z3) {
                if (OI02 >= 1000000) {
                    II0XooXoX(j, sb, OI02 / 1000000, OI02 % 1000000, 6, "ms", false);
                } else if (OI02 >= 1000) {
                    II0XooXoX(j, sb, OI02 / 1000, OI02 % 1000, 3, "us", false);
                } else {
                    sb.append(OI02);
                    sb.append("ns");
                }
            } else {
                II0XooXoX(j, sb, o02, OI02, 9, "s", false);
            }
            i = i4;
        }
        if (I0X0x0oIo2 && i > 1) {
            sb.insert(1, HexStringBuilder.COMMENT_BEGIN_CHAR).append(HexStringBuilder.COMMENT_END_CHAR);
        }
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    @o0
    public static /* synthetic */ void oI0IIXIo() {
    }

    public static final long oO(long j, double d) {
        int IIX02 = oOIx.oxoX.IIX0(d);
        if (IIX02 == d && IIX02 != 0) {
            return x0xO0oo(j, IIX02);
        }
        DurationUnit XX2 = XX(j);
        return XO.OO(x0xO(j, XX2) / d, XX2);
    }

    public static final long oOXoIIIo(long j) {
        if (xo0x(j) && oxXx0IX(j)) {
            return oxxXoxO(j);
        }
        return Ioxxx(j, DurationUnit.MILLISECONDS);
    }

    public static int oOoXoXO(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 >= 0 && (((int) j3) & 1) != 0) {
            int i = (((int) j) & 1) - (((int) j2) & 1);
            if (I0X0x0oIo(j)) {
                return -i;
            }
            return i;
        }
        return IIX0o.OxxIIOOXO(j, j2);
    }

    public static final boolean oX(long j) {
        return j > 0;
    }

    public static final long oo(long j) {
        return Ioxxx(j, DurationUnit.HOURS);
    }

    public static final long oo0xXOI0I(long j) {
        return Ioxxx(j, DurationUnit.DAYS);
    }

    public static long ooOOo0oXI(long j) {
        if (X0o0xo.oxoX()) {
            if (xXOx(j)) {
                if (!new X0.oO(-4611686018426999999L, XO.f29638II0xO0).xxIXOIIO(oxxXoxO(j))) {
                    throw new AssertionError(oxxXoxO(j) + " ns is out of nanoseconds range");
                }
            } else if (new X0.oO(-4611686018427387903L, 4611686018427387903L).xxIXOIIO(oxxXoxO(j))) {
                if (new X0.oO(-4611686018426L, XO.f29640oxoX).xxIXOIIO(oxxXoxO(j))) {
                    throw new AssertionError(oxxXoxO(j) + " ms is denormalized");
                }
            } else {
                throw new AssertionError(oxxXoxO(j) + " ms is out of milliseconds range");
            }
        }
        return j;
    }

    @kotlin.OOXIXo(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @kotlin.XX(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void ooXIXxIX() {
    }

    public static /* synthetic */ String ox(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return O00XxXI(j, durationUnit, i);
    }

    public static final boolean oxXx0IX(long j) {
        return !XX0(j);
    }

    public static final long oxxXoxO(long j) {
        return j >> 1;
    }

    public static final double x0XOIxOo(long j, long j2) {
        DurationUnit durationUnit = (DurationUnit) xX0ox.II0XooXoX.I0oOoX(XX(j), XX(j2));
        return x0xO(j, durationUnit) / x0xO(j2, durationUnit);
    }

    public static final int x0o(long j) {
        if (XX0(j)) {
            return 0;
        }
        return (int) (Xx000oIo(j) % 60);
    }

    public static final double x0xO(long j, @OXOo.OOXIXo DurationUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        if (j == f29648Oxx0xo) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == f29649oI0IIXIo) {
            return Double.NEGATIVE_INFINITY;
        }
        return II0XooXoX.oIX0oI(oxxXoxO(j), XX(j), unit);
    }

    public static final long x0xO0oo(long j, int i) {
        if (i == 0) {
            if (oX(j)) {
                return f29648Oxx0xo;
            }
            if (I0X0x0oIo(j)) {
                return f29649oI0IIXIo;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (xXOx(j)) {
            return XO.oxoX(oxxXoxO(j) / i);
        }
        if (XX0(j)) {
            return I0oOIX(j, oOIx.oxoX.Io(i));
        }
        long j2 = i;
        long oxxXoxO2 = oxxXoxO(j) / j2;
        if (new X0.oO(-4611686018426L, XO.f29640oxoX).xxIXOIIO(oxxXoxO2)) {
            return XO.oxoX(XO.XO(oxxXoxO2) + (XO.XO(oxxXoxO(j) - (oxxXoxO2 * j2)) / j2));
        }
        return XO.II0xO0(oxxXoxO2);
    }

    @o0
    public static /* synthetic */ void xII() {
    }

    public static final boolean xXOx(long j) {
        return (((int) j) & 1) == 0;
    }

    @kotlin.OOXIXo(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @kotlin.XX(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void xXxxox0I() {
    }

    public static final boolean xo0x(long j) {
        return (((int) j) & 1) == 1;
    }

    public static final /* synthetic */ oxoX xoIox(long j) {
        return new oxoX(j);
    }

    public static final <T> T xoIxX(long j, @OXOo.OOXIXo oI0IIXIo<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        IIX0o.x0xO0oo(action, "action");
        return action.invoke(Long.valueOf(oo0xXOI0I(j)), Integer.valueOf(OxxIIOOXO(j)), Integer.valueOf(x0o(j)), Integer.valueOf(o0(j)), Integer.valueOf(OI0(j)));
    }

    public static final <T> T xoxXI(long j, @OXOo.OOXIXo Oox.x0xO0oo<? super Long, ? super Integer, ? extends T> action) {
        IIX0o.x0xO0oo(action, "action");
        return action.invoke(Long.valueOf(IO(j)), Integer.valueOf(OI0(j)));
    }

    @kotlin.OOXIXo(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @kotlin.XX(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @xoIox
    @kotlin.oOoXoXO(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static /* synthetic */ void xxX() {
    }

    public final /* synthetic */ long IIxOXoOo0() {
        return this.f29650XO;
    }

    public int OOXIXo(long j) {
        return oOoXoXO(this.f29650XO, j);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(oxoX oxox) {
        return OOXIXo(oxox.IIxOXoOo0());
    }

    public boolean equals(Object obj) {
        return Oo(this.f29650XO, obj);
    }

    public int hashCode() {
        return XoX(this.f29650XO);
    }

    @OXOo.OOXIXo
    public String toString() {
        return o0xxxXXxX(this.f29650XO);
    }
}
