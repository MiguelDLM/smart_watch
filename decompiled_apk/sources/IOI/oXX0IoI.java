package IOI;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRules;
import kotlinx.datetime.DateTimeArithmeticException;

@kotlin.jvm.internal.XX({"SMAP\nTimeZoneJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeZoneJvm.kt\nkotlinx/datetime/TimeZoneKt__TimeZoneJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
/* loaded from: classes6.dex */
public final /* synthetic */ class oXX0IoI {
    public static final boolean I0Io(ZoneId zoneId) {
        ZoneRules rules;
        boolean isFixedOffset;
        try {
            rules = zoneId.getRules();
            isFixedOffset = rules.isFixedOffset();
            return isFixedOffset;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return false;
        }
    }

    @OXOo.OOXIXo
    public static final xOOOX II0XooXoX(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo o0IXXIx offset) {
        LocalDateTime ofInstant;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(offset, "offset");
        try {
            ofInstant = LocalDateTime.ofInstant(iIX0o.oOoXoXO(), IXxxXO.oIX0oI(offset.I0Io()));
            return new xOOOX(ofInstant);
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    @OXOo.OOXIXo
    public static final IIX0o II0xO0(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo X0xxXX0 timeZone) {
        ZonedDateTime atStartOfDay;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        atStartOfDay = xoxxi.ooOOo0oXI().atStartOfDay(timeZone.I0Io());
        return new IIX0o(atStartOfDay.toInstant());
    }

    @OXOo.OOXIXo
    public static final xOOOX Oxx0IOOO(@OXOo.OOXIXo IIX0o iIX0o, @OXOo.OOXIXo X0xxXX0 timeZone) {
        LocalDateTime ofInstant;
        kotlin.jvm.internal.IIX0o.x0xO0oo(iIX0o, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        try {
            ofInstant = LocalDateTime.ofInstant(iIX0o.oOoXoXO(), timeZone.I0Io());
            return new xOOOX(ofInstant);
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    @OXOo.OOXIXo
    public static final IIX0o X0o0xo(@OXOo.OOXIXo xOOOX xooox, @OXOo.OOXIXo X0xxXX0 timeZone) {
        ZonedDateTime atZone;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xooox, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(timeZone, "timeZone");
        atZone = xooox.Oxx0xo().atZone(timeZone.I0Io());
        return new IIX0o(atZone.toInstant());
    }

    @OXOo.OOXIXo
    public static final IIX0o XO(@OXOo.OOXIXo xOOOX xooox, @OXOo.OOXIXo o0IXXIx offset) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xooox, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(offset, "offset");
        return new IIX0o(xooox.Oxx0xo().toInstant(offset.I0Io()));
    }

    @OXOo.OOXIXo
    public static final o0IXXIx oxoX(@OXOo.OOXIXo X0xxXX0 x0xxXX0, @OXOo.OOXIXo IIX0o instant) {
        ZoneRules rules;
        ZoneOffset offset;
        kotlin.jvm.internal.IIX0o.x0xO0oo(x0xxXX0, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(instant, "instant");
        rules = x0xxXX0.I0Io().getRules();
        offset = rules.getOffset(instant.oOoXoXO());
        return new o0IXXIx(offset);
    }
}
