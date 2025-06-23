package IOI;

import IOI.oOoXoXO;

@kotlin.jvm.internal.XX({"SMAP\nLocalDate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalDate.kt\nkotlinx/datetime/LocalDateKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,305:1\n1#2:306\n*E\n"})
/* loaded from: classes6.dex */
public final class XX0xXo {
    public static /* synthetic */ xOOOX I0Io(xoxXI xoxxi, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return oIX0oI(xoxxi, i, i2, i3, i4);
    }

    @OXOo.OOXIXo
    public static final xoxXI II0XooXoX(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<this>");
        return xoxXI.Companion.oxoX(str);
    }

    @OXOo.OOXIXo
    public static final xOOOX II0xO0(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo x0OIX00oO time) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(time, "time");
        return new xOOOX(xoxxi, time);
    }

    @kotlin.OOXIXo(message = "Use the minus overload with an explicit number of units", replaceWith = @kotlin.XX(expression = "this.minus(1, unit)", imports = {}))
    @OXOo.OOXIXo
    public static final xoxXI Oxx0IOOO(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo oOoXoXO.II0xO0 unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        return xxIO.XO(xoxxi, -1, unit);
    }

    @OXOo.OOXIXo
    public static final xoxXI X0o0xo(@OXOo.OOXIXo xoxXI xoxxi, long j, @OXOo.OOXIXo oOoXoXO.II0xO0 unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        return xxIO.Oxx0IOOO(xoxxi, -j, unit);
    }

    @OXOo.OOXIXo
    public static final xoxXI XO(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo II0XooXoX period) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(period, "period");
        if (period.II0xO0() != Integer.MIN_VALUE && period.X0o0xo() != Integer.MIN_VALUE) {
            return xxIO.II0XooXoX(xoxxi, new II0XooXoX(-period.xoIox(), -period.X0o0xo(), -period.II0xO0()));
        }
        int xoIox2 = period.xoIox();
        oOoXoXO.oIX0oI oix0oi = oOoXoXO.Companion;
        return xxIO.II0xO0(xxIO.II0xO0(xxIO.II0xO0(xoxxi, xoIox2, oix0oi.oOoXoXO()), period.X0o0xo(), oix0oi.Oxx0IOOO()), period.II0xO0(), oix0oi.II0xO0());
    }

    @OXOo.OOXIXo
    public static final xOOOX oIX0oI(@OXOo.OOXIXo xoxXI xoxxi, int i, int i2, int i3, int i4) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        return new xOOOX(xoxxi.x0XOIxOo(), xoxxi.oOoXoXO(), xoxxi.Oxx0IOOO(), i, i2, i3, i4);
    }

    @OXOo.OOXIXo
    public static final II0XooXoX oxoX(@OXOo.OOXIXo xoxXI xoxxi, @OXOo.OOXIXo xoxXI other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xoxxi, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        return xxIO.X0o0xo(other, xoxxi);
    }
}
