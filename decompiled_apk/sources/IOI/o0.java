package IOI;

import IOI.oOoXoXO;
import com.google.android.exoplayer2.C;

@kotlin.jvm.internal.XX({"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlinx/datetime/InstantKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,524:1\n1#2:525\n*E\n"})
/* loaded from: classes6.dex */
public final class o0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f484II0xO0 = 3093527980800L;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f485oIX0oI = -3217862419201L;

    public static final boolean I0Io(@OXOo.OOXIXo IIX0o iIX0o) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        if (iIX0o.compareTo(IIX0o.Companion.Oxx0IOOO()) <= 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public static final IIX0o II0XooXoX(@OXOo.OOXIXo IIX0o iIX0o, long j, @OXOo.OOXIXo oOoXoXO.X0o0xo unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        if (j != Long.MIN_VALUE) {
            return OI0.X0o0xo(iIX0o, -j, unit);
        }
        return x0XOIxOo(OI0.X0o0xo(iIX0o, -(j + 1), unit), 1, unit);
    }

    public static final boolean II0xO0(@OXOo.OOXIXo IIX0o iIX0o) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        if (iIX0o.compareTo(IIX0o.Companion.XO()) >= 0) {
            return true;
        }
        return false;
    }

    public static final int IXxxXO(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo IIX0o other, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return OOOox.II0XooXoX.oIX0oI(OI0.xoIox(iIX0o, other, oOoXoXO.Companion.oOoXoXO(), timeZone));
    }

    @kotlin.OOXIXo(message = "Use the minus overload with an explicit number of units", replaceWith = @kotlin.XX(expression = "this.minus(1, unit)", imports = {}))
    @OXOo.OOXIXo
    public static final IIX0o OOXIXo(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo oOoXoXO.X0o0xo unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        return OI0.X0o0xo(iIX0o, -1L, unit);
    }

    public static final long Oo(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo IIX0o other, @OXOo.OOXIXo oOoXoXO.X0o0xo unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        try {
            return OOOox.II0XooXoX.X0o0xo(other.xoIox() - iIX0o.xoIox(), C.NANOS_PER_SECOND, other.OOXIXo() - iIX0o.OOXIXo(), unit.Oo());
        } catch (ArithmeticException unused) {
            if (iIX0o.compareTo(other) < 0) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
    }

    @OXOo.OOXIXo
    public static final IIX0o Oxx0IOOO(@OXOo.OOXIXo IIX0o iIX0o, int i, @OXOo.OOXIXo oOoXoXO.X0o0xo unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        return II0XooXoX(iIX0o, i, unit);
    }

    public static final long X0o0xo(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo IIX0o other, @OXOo.OOXIXo oOoXoXO unit, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return OI0.xoIox(other, iIX0o, unit, timeZone);
    }

    @OXOo.OOXIXo
    public static final xxIXOIIO XO(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo IIX0o other, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return OI0.I0Io(other, iIX0o, timeZone);
    }

    public static final int oIX0oI(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo IIX0o other, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return OOOox.II0XooXoX.oIX0oI(OI0.xoIox(iIX0o, other, oOoXoXO.Companion.II0xO0(), timeZone));
    }

    @kotlin.OOXIXo(message = "Use the plus overload with an explicit number of units", replaceWith = @kotlin.XX(expression = "this.plus(1, unit)", imports = {}))
    @OXOo.OOXIXo
    public static final IIX0o oO(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo oOoXoXO.X0o0xo unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        return OI0.X0o0xo(iIX0o, 1L, unit);
    }

    @kotlin.OOXIXo(message = "Use the minus overload with an explicit number of units", replaceWith = @kotlin.XX(expression = "this.minus(1, unit, timeZone)", imports = {}))
    @OXOo.OOXIXo
    public static final IIX0o oOoXoXO(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo oOoXoXO unit, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return OI0.oxoX(iIX0o, -1, unit, timeZone);
    }

    public static final int ooOOo0oXI(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo IIX0o other, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return OOOox.II0XooXoX.oIX0oI(OI0.xoIox(iIX0o, other, oOoXoXO.Companion.Oxx0IOOO(), timeZone));
    }

    public static final long oxoX(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo IIX0o other, @OXOo.OOXIXo oOoXoXO.X0o0xo unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        return Oo(other, iIX0o, unit);
    }

    @OXOo.OOXIXo
    public static final IIX0o x0XOIxOo(@OXOo.OOXIXo IIX0o iIX0o, int i, @OXOo.OOXIXo oOoXoXO.X0o0xo unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        return OI0.X0o0xo(iIX0o, i, unit);
    }

    @OXOo.OOXIXo
    public static final IIX0o x0xO0oo(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<this>");
        return IIX0o.Companion.OOXIXo(str);
    }

    @OXOo.OOXIXo
    public static final IIX0o xoIox(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo xxIXOIIO period, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(period, "period");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        if (period.xxIXOIIO() != Long.MIN_VALUE) {
            return OI0.Oxx0IOOO(iIX0o, OOXIXo.oxoX(-period.II0XooXoX(), -period.II0xO0(), -period.xxIXOIIO()), timeZone);
        }
        return x0XOIxOo(OI0.Oxx0IOOO(iIX0o, OOXIXo.oxoX(-period.II0XooXoX(), -period.II0xO0(), -(period.xxIXOIIO() + 1)), timeZone), 1, oOoXoXO.Companion.II0XooXoX());
    }

    @OXOo.OOXIXo
    public static final IIX0o xxIXOIIO(@OXOo.OOXIXo IIX0o iIX0o, long j, @OXOo.OOXIXo oOoXoXO unit, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        if (j != Long.MIN_VALUE) {
            return OI0.XO(iIX0o, -j, unit, timeZone);
        }
        return OI0.oxoX(OI0.XO(iIX0o, -(j + 1), unit, timeZone), 1, unit, timeZone);
    }
}
