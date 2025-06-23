package IOI;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;

/* loaded from: classes6.dex */
public final class Oxx0IOOO {
    @OXOo.OOXIXo
    public static final LocalDateTime I0Io(@OXOo.OOXIXo xOOOX xooox) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xooox, "<this>");
        return xooox.Oxx0xo();
    }

    @OXOo.OOXIXo
    public static final ZoneOffset II0XooXoX(@OXOo.OOXIXo o0IXXIx o0ixxix) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(o0ixxix, "<this>");
        return o0ixxix.I0Io();
    }

    @OXOo.OOXIXo
    public static final LocalDate II0xO0(@OXOo.OOXIXo xoxXI xoxxi) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        return xoxxi.ooOOo0oXI();
    }

    @OXOo.OOXIXo
    public static final IIX0o OOXIXo(@OXOo.OOXIXo Instant instant) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(instant, "<this>");
        return new IIX0o(instant);
    }

    @kotlin.OOXIXo(message = "Use toKotlinFixedOffsetTimeZone() instead.", replaceWith = @kotlin.XX(expression = "this.toKotlinFixedOffsetTimeZone()", imports = {}))
    @OXOo.OOXIXo
    public static final Oxx0xo Oo(@OXOo.OOXIXo ZoneOffset zoneOffset) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zoneOffset, "<this>");
        return xoIox(zoneOffset);
    }

    @OXOo.OOXIXo
    public static final ZoneOffset Oxx0IOOO(@OXOo.OOXIXo Oxx0xo oxx0xo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(oxx0xo, "<this>");
        return oxx0xo.XO().I0Io();
    }

    @OXOo.OOXIXo
    public static final Period X0o0xo(@OXOo.OOXIXo II0XooXoX iI0XooXoX) {
        Period of;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iI0XooXoX, "<this>");
        of = Period.of(iI0XooXoX.xoIox(), iI0XooXoX.X0o0xo(), iI0XooXoX.II0xO0());
        kotlin.jvm.internal.IIX0o.oO(of, "of(...)");
        return of;
    }

    @OXOo.OOXIXo
    public static final ZoneId XO(@OXOo.OOXIXo X0xxXX0 x0xxXX0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xxXX0, "<this>");
        return x0xxXX0.I0Io();
    }

    @OXOo.OOXIXo
    public static final Instant oIX0oI(@OXOo.OOXIXo IIX0o iIX0o) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        return iIX0o.oOoXoXO();
    }

    @OXOo.OOXIXo
    public static final X0xxXX0 oO(@OXOo.OOXIXo ZoneId zoneId) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zoneId, "<this>");
        return X0xxXX0.Companion.X0o0xo(zoneId);
    }

    @OXOo.OOXIXo
    public static final xoxXI oOoXoXO(@OXOo.OOXIXo LocalDate localDate) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(localDate, "<this>");
        return new xoxXI(localDate);
    }

    @OXOo.OOXIXo
    public static final xOOOX ooOOo0oXI(@OXOo.OOXIXo LocalDateTime localDateTime) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(localDateTime, "<this>");
        return new xOOOX(localDateTime);
    }

    @OXOo.OOXIXo
    public static final LocalTime oxoX(@OXOo.OOXIXo x0OIX00oO x0oix00oo) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0oix00oo, "<this>");
        return x0oix00oo.oOoXoXO();
    }

    @OXOo.OOXIXo
    public static final x0OIX00oO x0XOIxOo(@OXOo.OOXIXo LocalTime localTime) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(localTime, "<this>");
        return new x0OIX00oO(localTime);
    }

    @OXOo.OOXIXo
    public static final o0IXXIx x0xO0oo(@OXOo.OOXIXo ZoneOffset zoneOffset) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zoneOffset, "<this>");
        return new o0IXXIx(zoneOffset);
    }

    @OXOo.OOXIXo
    public static final Oxx0xo xoIox(@OXOo.OOXIXo ZoneOffset zoneOffset) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(zoneOffset, "<this>");
        return new Oxx0xo(new o0IXXIx(zoneOffset));
    }

    @OXOo.OOXIXo
    public static final II0XooXoX xxIXOIIO(@OXOo.OOXIXo Period period) {
        int years;
        int months;
        int days;
        kotlin.jvm.internal.IIX0o.x0xO0oo(period, "<this>");
        years = period.getYears();
        months = period.getMonths();
        days = period.getDays();
        return new II0XooXoX(years, months, days);
    }
}
