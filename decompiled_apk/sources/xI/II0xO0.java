package xI;

import IOI.IIX0o;
import IOI.IO0XoXxO;
import IOI.OI0;
import IOI.Oxx0xo;
import IOI.X0xxXX0;
import IOI.oOoXoXO;
import IOI.xOOOX;
import OXOo.OOXIXo;
import com.batoulapps.adhan2.model.Rounding;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final II0xO0 f34114oIX0oI = new II0xO0();

    /* loaded from: classes8.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f34115oIX0oI;

        static {
            int[] iArr = new int[Rounding.values().length];
            try {
                iArr[Rounding.NEAREST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Rounding.UP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Rounding.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f34115oIX0oI = iArr;
        }
    }

    public static /* synthetic */ xOOOX Oxx0IOOO(II0xO0 iI0xO0, xOOOX xooox, Rounding rounding, int i, Object obj) {
        if ((i & 2) != 0) {
            rounding = Rounding.NEAREST;
        }
        return iI0xO0.XO(xooox, rounding);
    }

    public final boolean I0Io(int i) {
        if (i % 4 == 0 && (i % 100 != 0 || i % 400 == 0)) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final IIX0o II0XooXoX(@OOXIXo xOOOX xooox) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(xooox, "<this>");
        return IO0XoXxO.oxoX(xooox, X0xxXX0.Companion.I0Io());
    }

    @OOXIXo
    public final xOOOX II0xO0(@OOXIXo xOOOX localDateTime, int i, @OOXIXo oOoXoXO dateTimeUnit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(localDateTime, "localDateTime");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dateTimeUnit, "dateTimeUnit");
        return oIX0oI(IO0XoXxO.oxoX(localDateTime, X0xxXX0.Companion.I0Io()), i, dateTimeUnit);
    }

    @OOXIXo
    public final xOOOX X0o0xo(@OOXIXo I0Io components) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(components, "components");
        return oxoX(components.I0Io(), components.II0xO0(), components.oIX0oI());
    }

    @OOXIXo
    public final xOOOX XO(@OOXIXo xOOOX localDateTime, @OOXIXo Rounding rounding) {
        Pair oIX0oI2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(localDateTime, "localDateTime");
        kotlin.jvm.internal.IIX0o.x0xO0oo(rounding, "rounding");
        int ooOOo0oXI2 = localDateTime.ooOOo0oXI();
        int i = oIX0oI.f34115oIX0oI[rounding.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    oIX0oI2 = Xo0.oIX0oI(Integer.valueOf(ooOOo0oXI2), Integer.valueOf(localDateTime.Oo()));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                oIX0oI2 = Xo0.oIX0oI(Integer.valueOf(oOIx.oxoX.xOoOIoI((float) Math.ceil(localDateTime.Oo() / 60.0f)) + ooOOo0oXI2), 0);
            }
        } else {
            oIX0oI2 = Xo0.oIX0oI(Integer.valueOf(oOIx.oxoX.xOoOIoI(localDateTime.Oo() / 60.0f) + ooOOo0oXI2), 0);
        }
        int intValue = ((Number) oIX0oI2.component1()).intValue();
        xOOOX xooox = new xOOOX(localDateTime.oI0IIXIo(), localDateTime.oO(), localDateTime.II0XooXoX(), localDateTime.oOoXoXO(), ooOOo0oXI2, ((Number) oIX0oI2.component2()).intValue(), 0, 64, (IIXOooo) null);
        if (ooOOo0oXI2 != intValue) {
            return II0xO0(xooox, intValue - ooOOo0oXI2, oOoXoXO.Companion.XO());
        }
        return xooox;
    }

    @OOXIXo
    public final xOOOX oIX0oI(@OOXIXo IIX0o instant, int i, @OOXIXo oOoXoXO dateTimeUnit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(instant, "instant");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dateTimeUnit, "dateTimeUnit");
        Oxx0xo I0Io2 = X0xxXX0.Companion.I0Io();
        return IO0XoXxO.XO(OI0.oxoX(instant, i, dateTimeUnit, I0Io2), I0Io2);
    }

    public final xOOOX oxoX(int i, int i2, int i3) {
        return new xOOOX(i, i2, i3, 0, 0, 0, 0, 64, (IIXOooo) null);
    }
}
