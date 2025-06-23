package IOI;

import IOI.oOoXoXO;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.datetime.DateTimeArithmeticException;

@XO0OX.xxIXOIIO(name = "LocalDateJvmKt")
@kotlin.jvm.internal.XX({"SMAP\nLocalDate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalDate.kt\nkotlinx/datetime/LocalDateJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
/* loaded from: classes6.dex */
public final class xxIO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final long f522II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final long f523oIX0oI;

    static {
        LocalDate localDate;
        long epochDay;
        LocalDate localDate2;
        long epochDay2;
        localDate = LocalDate.MIN;
        epochDay = localDate.toEpochDay();
        f523oIX0oI = epochDay;
        localDate2 = LocalDate.MAX;
        epochDay2 = localDate2.toEpochDay();
        f522II0xO0 = epochDay2;
    }

    public static final int I0Io(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo xoxXI other) {
        ChronoUnit chronoUnit;
        long until;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        LocalDate ooOOo0oXI2 = xoxxi.ooOOo0oXI();
        Temporal oIX0oI2 = IoOoX.oIX0oI(other.ooOOo0oXI());
        chronoUnit = ChronoUnit.MONTHS;
        until = ooOOo0oXI2.until(oIX0oI2, Xx000oIo.oIX0oI(chronoUnit));
        return OOOox.II0XooXoX.oIX0oI(until);
    }

    @OXOo.OOXIXo
    public static final xoxXI II0XooXoX(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo II0XooXoX period) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(period, "period");
        try {
            LocalDate ooOOo0oXI2 = xoxxi.ooOOo0oXI();
            if (period.II0XooXoX() != 0) {
                ooOOo0oXI2 = ooOOo0oXI2.plusMonths(period.II0XooXoX());
            }
            if (period.II0xO0() != 0) {
                ooOOo0oXI2 = ooOOo0oXI2.plusDays(period.II0xO0());
            }
            return new xoxXI(ooOOo0oXI2);
        } catch (DateTimeException unused) {
            throw new DateTimeArithmeticException("The result of adding " + xoxxi.ooOOo0oXI() + " to " + xoxxi + " is out of LocalDate range.");
        }
    }

    @OXOo.OOXIXo
    public static final xoxXI II0xO0(@OXOo.OOXIXo xoxXI xoxxi, int i, @OXOo.OOXIXo oOoXoXO.II0xO0 unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        return Oxx0IOOO(xoxxi, -i, unit);
    }

    public static final int OOXIXo(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo xoxXI other) {
        ChronoUnit chronoUnit;
        long until;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        LocalDate ooOOo0oXI2 = xoxxi.ooOOo0oXI();
        Temporal oIX0oI2 = IoOoX.oIX0oI(other.ooOOo0oXI());
        chronoUnit = ChronoUnit.YEARS;
        until = ooOOo0oXI2.until(oIX0oI2, Xx000oIo.oIX0oI(chronoUnit));
        return OOOox.II0XooXoX.oIX0oI(until);
    }

    @OXOo.OOXIXo
    public static final xoxXI Oxx0IOOO(@OXOo.OOXIXo xoxXI xoxxi, long j, @OXOo.OOXIXo oOoXoXO.II0xO0 unit) {
        LocalDate plusMonths;
        long epochDay;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        try {
            if (unit instanceof oOoXoXO.I0Io) {
                long oxoX2 = OOOox.Oxx0IOOO.oxoX(j, ((oOoXoXO.I0Io) unit).IXxxXO());
                epochDay = xoxxi.ooOOo0oXI().toEpochDay();
                plusMonths = oxoX(OOOox.Oxx0IOOO.II0xO0(epochDay, oxoX2));
            } else if (unit instanceof oOoXoXO.oxoX) {
                plusMonths = xoxxi.ooOOo0oXI().plusMonths(OOOox.Oxx0IOOO.oxoX(j, ((oOoXoXO.oxoX) unit).IXxxXO()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new xoxXI(plusMonths);
        } catch (Exception e) {
            if (!X0IIOO.oIX0oI(e) && !(e instanceof ArithmeticException)) {
                throw e;
            }
            throw new DateTimeArithmeticException("The result of adding " + j + " of " + unit + " to " + xoxxi + " is out of LocalDate range.", e);
        }
    }

    @OXOo.OOXIXo
    public static final II0XooXoX X0o0xo(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo xoxXI other) {
        ChronoUnit chronoUnit;
        long until;
        LocalDate plusMonths;
        ChronoUnit chronoUnit2;
        long until2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        LocalDate ooOOo0oXI2 = xoxxi.ooOOo0oXI();
        LocalDate ooOOo0oXI3 = other.ooOOo0oXI();
        Temporal oIX0oI2 = IoOoX.oIX0oI(ooOOo0oXI3);
        chronoUnit = ChronoUnit.MONTHS;
        until = ooOOo0oXI2.until(oIX0oI2, Xx000oIo.oIX0oI(chronoUnit));
        plusMonths = ooOOo0oXI2.plusMonths(until);
        kotlin.jvm.internal.IIX0o.oO(plusMonths, "plusMonths(...)");
        Temporal oIX0oI3 = IoOoX.oIX0oI(ooOOo0oXI3);
        chronoUnit2 = ChronoUnit.DAYS;
        until2 = plusMonths.until(oIX0oI3, Xx000oIo.oIX0oI(chronoUnit2));
        if (until <= 2147483647L && until >= com.garmin.fit.O0Xx.f12378xXxxox0I) {
            return new II0XooXoX((int) until, (int) until2);
        }
        throw new DateTimeArithmeticException("The number of months between " + xoxxi + " and " + other + " does not fit in an Int");
    }

    @OXOo.OOXIXo
    public static final xoxXI XO(@OXOo.OOXIXo xoxXI xoxxi, int i, @OXOo.OOXIXo oOoXoXO.II0xO0 unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        return Oxx0IOOO(xoxxi, i, unit);
    }

    public static final int oIX0oI(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo xoxXI other) {
        ChronoUnit chronoUnit;
        long until;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        LocalDate ooOOo0oXI2 = xoxxi.ooOOo0oXI();
        Temporal oIX0oI2 = IoOoX.oIX0oI(other.ooOOo0oXI());
        chronoUnit = ChronoUnit.DAYS;
        until = ooOOo0oXI2.until(oIX0oI2, Xx000oIo.oIX0oI(chronoUnit));
        return OOOox.II0XooXoX.oIX0oI(until);
    }

    public static final LocalDate oxoX(long j) {
        LocalDate ofEpochDay;
        long j2 = f523oIX0oI;
        if (j <= f522II0xO0 && j2 <= j) {
            ofEpochDay = LocalDate.ofEpochDay(j);
            kotlin.jvm.internal.IIX0o.oO(ofEpochDay, "ofEpochDay(...)");
            return ofEpochDay;
        }
        Ioxxx.oIX0oI();
        throw XIo0oOXIx.oIX0oI("The resulting day " + j + " is out of supported LocalDate range.");
    }

    public static final int xoIox(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo xoxXI other, @OXOo.OOXIXo oOoXoXO.II0xO0 unit) {
        ChronoUnit chronoUnit;
        long until;
        ChronoUnit chronoUnit2;
        long until2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        if (unit instanceof oOoXoXO.oxoX) {
            LocalDate ooOOo0oXI2 = xoxxi.ooOOo0oXI();
            Temporal oIX0oI2 = IoOoX.oIX0oI(other.ooOOo0oXI());
            chronoUnit2 = ChronoUnit.MONTHS;
            until2 = ooOOo0oXI2.until(oIX0oI2, Xx000oIo.oIX0oI(chronoUnit2));
            return OOOox.II0XooXoX.oIX0oI(until2 / ((oOoXoXO.oxoX) unit).IXxxXO());
        }
        if (unit instanceof oOoXoXO.I0Io) {
            LocalDate ooOOo0oXI3 = xoxxi.ooOOo0oXI();
            Temporal oIX0oI3 = IoOoX.oIX0oI(other.ooOOo0oXI());
            chronoUnit = ChronoUnit.DAYS;
            until = ooOOo0oXI3.until(oIX0oI3, Xx000oIo.oIX0oI(chronoUnit));
            return OOOox.II0XooXoX.oIX0oI(until / ((oOoXoXO.I0Io) unit).IXxxXO());
        }
        throw new NoWhenBranchMatchedException();
    }

    @kotlin.OOXIXo(message = "Use the plus overload with an explicit number of units", replaceWith = @kotlin.XX(expression = "this.plus(1, unit)", imports = {}))
    @OXOo.OOXIXo
    public static final xoxXI xxIXOIIO(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo oOoXoXO.II0xO0 unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        return Oxx0IOOO(xoxxi, 1L, unit);
    }
}
