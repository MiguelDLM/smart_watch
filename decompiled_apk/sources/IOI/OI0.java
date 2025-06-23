package IOI;

import IOI.oOoXoXO;
import com.google.android.exoplayer2.C;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.datetime.DateTimeArithmeticException;

@XO0OX.xxIXOIIO(name = "InstantJvmKt")
@kotlin.jvm.internal.XX({"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlinx/datetime/InstantJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,190:1\n1#2:191\n*E\n"})
/* loaded from: classes6.dex */
public final class OI0 {
    @OXOo.OOXIXo
    public static final xxIXOIIO I0Io(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo IIX0o other, @OXOo.OOXIXo X0xxXX0 timeZone) {
        ChronoUnit chronoUnit;
        long until;
        ZonedDateTime plusMonths;
        ChronoUnit chronoUnit2;
        long until2;
        ZonedDateTime plusDays;
        ChronoUnit chronoUnit3;
        long until3;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        ZonedDateTime oIX0oI2 = oIX0oI(iIX0o, timeZone);
        ZonedDateTime oIX0oI3 = oIX0oI(other, timeZone);
        Temporal oIX0oI4 = IoOoX.oIX0oI(oIX0oI3);
        chronoUnit = ChronoUnit.MONTHS;
        until = oIX0oI2.until(oIX0oI4, Xx000oIo.oIX0oI(chronoUnit));
        plusMonths = oIX0oI2.plusMonths(until);
        kotlin.jvm.internal.IIX0o.oO(plusMonths, "plusMonths(...)");
        Temporal oIX0oI5 = IoOoX.oIX0oI(oIX0oI3);
        chronoUnit2 = ChronoUnit.DAYS;
        until2 = plusMonths.until(oIX0oI5, Xx000oIo.oIX0oI(chronoUnit2));
        plusDays = plusMonths.plusDays(until2);
        kotlin.jvm.internal.IIX0o.oO(plusDays, "plusDays(...)");
        Temporal oIX0oI6 = IoOoX.oIX0oI(oIX0oI3);
        chronoUnit3 = ChronoUnit.NANOS;
        until3 = plusDays.until(oIX0oI6, Xx000oIo.oIX0oI(chronoUnit3));
        if (until <= 2147483647L && until >= com.garmin.fit.O0Xx.f12378xXxxox0I) {
            return OOXIXo.oxoX((int) until, (int) until2, until3);
        }
        throw new DateTimeArithmeticException("The number of months between " + iIX0o + " and " + other + " does not fit in an Int");
    }

    @kotlin.OOXIXo(message = "Use the plus overload with an explicit number of units", replaceWith = @kotlin.XX(expression = "this.plus(1, unit, timeZone)", imports = {}))
    @OXOo.OOXIXo
    public static final IIX0o II0XooXoX(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo oOoXoXO unit, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return XO(iIX0o, 1L, unit, timeZone);
    }

    @OXOo.OOXIXo
    public static final IIX0o II0xO0(@OXOo.OOXIXo IIX0o iIX0o, int i, @OXOo.OOXIXo oOoXoXO unit, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return XO(iIX0o, -i, unit, timeZone);
    }

    @OXOo.OOXIXo
    public static final IIX0o Oxx0IOOO(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo xxIXOIIO period, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(period, "period");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        try {
            ZonedDateTime oIX0oI2 = oIX0oI(iIX0o, timeZone);
            if (period.II0XooXoX() != 0) {
                oIX0oI2 = oIX0oI2.plusMonths(period.II0XooXoX());
            }
            if (period.II0xO0() != 0) {
                oIX0oI2 = oIX0oI2.plusDays(period.II0xO0());
            }
            if (period.xxIXOIIO() != 0) {
                oIX0oI2 = oIX0oI2.plusNanos(period.xxIXOIIO());
            }
            return new IIX0o(oIX0oI2.toInstant());
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    @OXOo.OOXIXo
    public static final IIX0o X0o0xo(@OXOo.OOXIXo IIX0o iIX0o, long j, @OXOo.OOXIXo oOoXoXO.X0o0xo unit) {
        IIX0o xxIXOIIO2;
        Instant plusSeconds;
        Instant plusNanos;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        try {
            OOOox.II0xO0 Oxx0IOOO2 = OOOox.II0XooXoX.Oxx0IOOO(j, unit.Oo(), C.NANOS_PER_SECOND);
            long oIX0oI2 = Oxx0IOOO2.oIX0oI();
            long II0xO02 = Oxx0IOOO2.II0xO0();
            plusSeconds = iIX0o.oOoXoXO().plusSeconds(oIX0oI2);
            plusNanos = plusSeconds.plusNanos(II0xO02);
            kotlin.jvm.internal.IIX0o.oO(plusNanos, "plusNanos(...)");
            return new IIX0o(plusNanos);
        } catch (Exception e) {
            if (!X0IIOO.oIX0oI(e) && !(e instanceof ArithmeticException)) {
                throw e;
            }
            if (j > 0) {
                xxIXOIIO2 = IIX0o.Companion.II0XooXoX();
            } else {
                xxIXOIIO2 = IIX0o.Companion.xxIXOIIO();
            }
            return xxIXOIIO2;
        }
    }

    @OXOo.OOXIXo
    public static final IIX0o XO(@OXOo.OOXIXo IIX0o iIX0o, long j, @OXOo.OOXIXo oOoXoXO unit, @OXOo.OOXIXo X0xxXX0 timeZone) {
        ZonedDateTime plusMonths;
        Instant instant;
        ZonedDateTime plusDays;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        try {
            ZonedDateTime oIX0oI2 = oIX0oI(iIX0o, timeZone);
            if (unit instanceof oOoXoXO.X0o0xo) {
                instant = X0o0xo(iIX0o, j, (oOoXoXO.X0o0xo) unit).oOoXoXO();
                instant.atZone(timeZone.I0Io());
            } else if (unit instanceof oOoXoXO.I0Io) {
                plusDays = oIX0oI2.plusDays(OOOox.Oxx0IOOO.oxoX(j, ((oOoXoXO.I0Io) unit).IXxxXO()));
                instant = plusDays.toInstant();
            } else if (unit instanceof oOoXoXO.oxoX) {
                plusMonths = oIX0oI2.plusMonths(OOOox.Oxx0IOOO.oxoX(j, ((oOoXoXO.oxoX) unit).IXxxXO()));
                instant = plusMonths.toInstant();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new IIX0o(instant);
        } catch (Exception e) {
            if (!X0IIOO.oIX0oI(e) && !(e instanceof ArithmeticException)) {
                throw e;
            }
            throw new DateTimeArithmeticException("Instant " + iIX0o + " cannot be represented as local date when adding " + j + TokenParser.SP + unit + " to it", e);
        }
    }

    public static final ZonedDateTime oIX0oI(IIX0o iIX0o, X0xxXX0 x0xxXX0) {
        ZonedDateTime atZone;
        try {
            atZone = iIX0o.oOoXoXO().atZone(x0xxXX0.I0Io());
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(atZone);
            return atZone;
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    @OXOo.OOXIXo
    public static final IIX0o oxoX(@OXOo.OOXIXo IIX0o iIX0o, int i, @OXOo.OOXIXo oOoXoXO unit, @OXOo.OOXIXo X0xxXX0 timeZone) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        return XO(iIX0o, i, unit, timeZone);
    }

    public static final long xoIox(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo IIX0o other, @OXOo.OOXIXo oOoXoXO unit, @OXOo.OOXIXo X0xxXX0 timeZone) {
        int compareTo;
        ChronoUnit chronoUnit;
        long until;
        ChronoUnit chronoUnit2;
        long until2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        try {
            ZonedDateTime oIX0oI2 = oIX0oI(iIX0o, timeZone);
            ZonedDateTime oIX0oI3 = oIX0oI(other, timeZone);
            if (unit instanceof oOoXoXO.X0o0xo) {
                return o0.Oo(iIX0o, other, (oOoXoXO.X0o0xo) unit);
            }
            if (unit instanceof oOoXoXO.I0Io) {
                Temporal oIX0oI4 = IoOoX.oIX0oI(oIX0oI3);
                chronoUnit2 = ChronoUnit.DAYS;
                until2 = oIX0oI2.until(oIX0oI4, Xx000oIo.oIX0oI(chronoUnit2));
                return until2 / ((oOoXoXO.I0Io) unit).IXxxXO();
            }
            if (unit instanceof oOoXoXO.oxoX) {
                Temporal oIX0oI5 = IoOoX.oIX0oI(oIX0oI3);
                chronoUnit = ChronoUnit.MONTHS;
                until = oIX0oI2.until(oIX0oI5, Xx000oIo.oIX0oI(chronoUnit));
                return until / ((oOoXoXO.oxoX) unit).IXxxXO();
            }
            throw new NoWhenBranchMatchedException();
        } catch (ArithmeticException unused) {
            compareTo = iIX0o.oOoXoXO().compareTo(other.oOoXoXO());
            if (compareTo < 0) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    @OXOo.OOXIXo
    public static final String xxIXOIIO(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo o0IXXIx offset) {
        OffsetDateTime ofInstant;
        String offsetDateTime;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(offset, "offset");
        ofInstant = OffsetDateTime.ofInstant(iIX0o.oOoXoXO(), IXxxXO.oIX0oI(offset.I0Io()));
        offsetDateTime = ofInstant.toString();
        kotlin.jvm.internal.IIX0o.oO(offsetDateTime, "toString(...)");
        return offsetDateTime;
    }
}
