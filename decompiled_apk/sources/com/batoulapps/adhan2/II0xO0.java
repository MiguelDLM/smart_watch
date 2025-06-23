package com.batoulapps.adhan2;

import IOI.IIX0o;
import IOI.IO0XoXxO;
import IOI.X0xxXX0;
import IOI.oOoXoXO;
import IOI.xOOOX;
import OXOo.OOXIXo;
import XXO0.oIX0oI;
import com.batoulapps.adhan2.model.Shafaq;
import com.batoulapps.adhan2.oIX0oI;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.IIXOooo;
import oOIx.oxoX;
import oo0xXOI0I.Oxx0IOOO;
import xI.I0Io;
import xI.oxoX;

/* loaded from: classes8.dex */
public final class II0xO0 {

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f10290xoIox = new oIX0oI(null);

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final com.batoulapps.adhan2.oIX0oI f10291I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final IIX0o f10292II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final I0Io f10293II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public final IIX0o f10294Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final IIX0o f10295X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OOXIXo
    public final IIX0o f10296XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final ooXIXxIX.II0xO0 f10297oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public final IIX0o f10298oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public final IIX0o f10299xxIXOIIO;

    /* renamed from: com.batoulapps.adhan2.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public /* synthetic */ class C0546II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f10300oIX0oI;

        static {
            int[] iArr = new int[Prayer.values().length];
            try {
                iArr[Prayer.FAJR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Prayer.SUNRISE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Prayer.DHUHR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Prayer.ASR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Prayer.MAGHRIB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Prayer.ISHA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Prayer.NONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f10300oIX0oI = iArr;
        }
    }

    /* loaded from: classes8.dex */
    public static final class oIX0oI {

        /* renamed from: com.batoulapps.adhan2.II0xO0$oIX0oI$oIX0oI, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public /* synthetic */ class C0547oIX0oI {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public static final /* synthetic */ int[] f10301oIX0oI;

            static {
                int[] iArr = new int[Shafaq.values().length];
                try {
                    iArr[Shafaq.GENERAL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Shafaq.AHMER.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Shafaq.ABYAD.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f10301oIX0oI = iArr;
            }
        }

        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public final int I0Io(int i, int i2, double d) {
            int i3;
            int i4;
            boolean I0Io2 = xI.II0xO0.f34114oIX0oI.I0Io(i2);
            if (I0Io2) {
                i3 = 173;
            } else {
                i3 = 172;
            }
            if (I0Io2) {
                i4 = 366;
            } else {
                i4 = 365;
            }
            if (d >= XIXIX.OOXIXo.f3760XO) {
                int i5 = i + 10;
                if (i5 >= i4) {
                    return i5 - i4;
                }
                return i5;
            }
            int i6 = i - i3;
            if (i6 < 0) {
                return i6 + i4;
            }
            return i6;
        }

        public final xOOOX X0o0xo(double d, int i, int i2, xOOOX xooox) {
            double d2;
            double d3 = 75;
            double abs = (Math.abs(d) * 0.5209090909090909d) + d3;
            double abs2 = (Math.abs(d) * 0.35345454545454547d) + d3;
            double abs3 = (Math.abs(d) * 0.5952727272727273d) + d3;
            double abs4 = d3 + (Math.abs(d) * 0.8745454545454546d);
            int I0Io2 = I0Io(i, i2, d);
            if (I0Io2 < 91) {
                d2 = abs + (((abs2 - abs) / 91.0d) * I0Io2);
            } else if (I0Io2 < 137) {
                d2 = abs2 + (((abs3 - abs2) / 46.0d) * (I0Io2 - 91));
            } else if (I0Io2 < 183) {
                d2 = abs3 + (((abs4 - abs3) / 46.0d) * (I0Io2 - 137));
            } else if (I0Io2 < 229) {
                d2 = abs4 + (((abs3 - abs4) / 46.0d) * (I0Io2 - 183));
            } else if (I0Io2 < 275) {
                d2 = abs3 + (((abs2 - abs3) / 46.0d) * (I0Io2 - 229));
            } else {
                d2 = (((abs - abs2) / 91.0d) * (I0Io2 - 275)) + abs2;
            }
            return xI.II0xO0.f34114oIX0oI.II0xO0(xooox, -oxoX.IIX0(d2 * 60.0d), oOoXoXO.Companion.xoIox());
        }

        public final xOOOX oxoX(double d, int i, int i2, xOOOX xooox, Shafaq shafaq) {
            double d2;
            double abs;
            double abs2;
            double abs3;
            double d3;
            double abs4;
            double d4;
            int i3 = C0547oIX0oI.f10301oIX0oI[shafaq.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        d2 = 75;
                        abs = (Math.abs(d) * 0.46545454545454545d) + d2;
                        abs2 = (Math.abs(d) * 0.13018181818181818d) + d2;
                        abs3 = (Math.abs(d) * 0.6698181818181819d) + d2;
                        d3 = 1.488d;
                        abs4 = Math.abs(d);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    d2 = 62;
                    abs = (Math.abs(d) * 0.31636363636363635d) + d2;
                    abs2 = d2 - (Math.abs(d) * 0.13018181818181818d);
                    abs3 = (Math.abs(d) * 0.0930909090909091d) + d2;
                    d3 = 0.35345454545454547d;
                    abs4 = Math.abs(d);
                }
            } else {
                d2 = 75;
                abs = d2 + (Math.abs(d) * 0.46545454545454545d);
                abs2 = d2 + (Math.abs(d) * 0.03727272727272727d);
                abs3 = d2 - (Math.abs(d) * 0.16745454545454547d);
                d3 = 0.11163636363636363d;
                abs4 = Math.abs(d);
            }
            double d5 = d2 + (abs4 * d3);
            int I0Io2 = I0Io(i, i2, d);
            if (I0Io2 < 91) {
                d4 = abs + (((abs2 - abs) / 91.0d) * I0Io2);
            } else if (I0Io2 < 137) {
                d4 = abs2 + (((abs3 - abs2) / 46.0d) * (I0Io2 - 91));
            } else if (I0Io2 < 183) {
                d4 = abs3 + (((d5 - abs3) / 46.0d) * (I0Io2 - 137));
            } else if (I0Io2 < 229) {
                d4 = d5 + (((abs3 - d5) / 46.0d) * (I0Io2 - 183));
            } else if (I0Io2 < 275) {
                d4 = abs3 + (((abs2 - abs3) / 46.0d) * (I0Io2 - 229));
            } else {
                d4 = (((abs - abs2) / 91.0d) * (I0Io2 - 275)) + abs2;
            }
            return xI.II0xO0.f34114oIX0oI.II0xO0(xooox, oxoX.IIX0(d4 * 60.0d), oOoXoXO.Companion.xoIox());
        }

        public oIX0oI() {
        }
    }

    public II0xO0(@OOXIXo ooXIXxIX.II0xO0 coordinates, @OOXIXo I0Io dateComponents, @OOXIXo com.batoulapps.adhan2.oIX0oI calculationParameters) {
        xOOOX xooox;
        xOOOX xooox2;
        xOOOX xooox3;
        xOOOX xooox4;
        xOOOX xooox5;
        xOOOX xooox6;
        xOOOX xooox7;
        xOOOX xooox8;
        xOOOX xooox9;
        xOOOX xooox10;
        xOOOX xooox11;
        oxoX.oIX0oI oix0oi;
        int i;
        xOOOX xooox12;
        oxoX.oIX0oI oix0oi2;
        int i2;
        long j;
        xOOOX II0xO02;
        xOOOX xooox13;
        xOOOX xooox14;
        xOOOX xooox15;
        xOOOX II0xO03;
        kotlin.jvm.internal.IIX0o.x0xO0oo(coordinates, "coordinates");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dateComponents, "dateComponents");
        kotlin.jvm.internal.IIX0o.x0xO0oo(calculationParameters, "calculationParameters");
        this.f10297oIX0oI = coordinates;
        this.f10293II0xO0 = dateComponents;
        this.f10291I0Io = calculationParameters;
        xI.II0xO0 iI0xO0 = xI.II0xO0.f34114oIX0oI;
        xOOOX X0o0xo2 = iI0xO0.X0o0xo(dateComponents);
        int OOXIXo2 = X0o0xo2.OOXIXo();
        oOoXoXO.oIX0oI oix0oi3 = oOoXoXO.Companion;
        I0Io II0xO04 = I0Io.f34110oxoX.II0xO0(iI0xO0.II0xO0(X0o0xo2, 1, oix0oi3.II0xO0()));
        Oxx0IOOO oxx0IOOO = new Oxx0IOOO(dateComponents, coordinates);
        oxoX.oIX0oI oix0oi4 = xI.oxoX.f34116oxoX;
        xI.oxoX oIX0oI2 = oix0oi4.oIX0oI(oxx0IOOO.oxoX());
        if (oIX0oI2 != null) {
            xooox = oIX0oI2.oIX0oI(dateComponents);
        } else {
            xooox = null;
        }
        xI.oxoX oIX0oI3 = oix0oi4.oIX0oI(oxx0IOOO.II0xO0());
        if (oIX0oI3 != null) {
            xooox2 = oIX0oI3.oIX0oI(dateComponents);
        } else {
            xooox2 = null;
        }
        xI.oxoX oIX0oI4 = oix0oi4.oIX0oI(oxx0IOOO.I0Io());
        if (oIX0oI4 != null) {
            xooox3 = oIX0oI4.oIX0oI(dateComponents);
        } else {
            xooox3 = null;
        }
        xI.oxoX oIX0oI5 = oix0oi4.oIX0oI(new Oxx0IOOO(II0xO04, coordinates).II0xO0());
        if (xooox != null && xooox2 != null && xooox3 != null && oIX0oI5 != null) {
            xI.oxoX oIX0oI6 = oix0oi4.oIX0oI(oxx0IOOO.oIX0oI(calculationParameters.Oo().getShadowLength()));
            if (oIX0oI6 != null) {
                xooox10 = oIX0oI6.oIX0oI(dateComponents);
            } else {
                xooox10 = null;
            }
            xOOOX oIX0oI7 = oIX0oI5.oIX0oI(II0xO04);
            X0xxXX0.oIX0oI oix0oi5 = X0xxXX0.Companion;
            long x0xO0oo2 = IO0XoXxO.oxoX(oIX0oI7, oix0oi5.I0Io()).x0xO0oo() - IO0XoXxO.oxoX(xooox3, oix0oi5.I0Io()).x0xO0oo();
            xI.oxoX oIX0oI8 = oix0oi4.oIX0oI(oxx0IOOO.X0o0xo(-calculationParameters.ooOOo0oXI(), false));
            if (oIX0oI8 != null) {
                xooox11 = oIX0oI8.oIX0oI(dateComponents);
            } else {
                xooox11 = null;
            }
            CalculationMethod IXxxXO2 = calculationParameters.IXxxXO();
            CalculationMethod calculationMethod = CalculationMethod.MOON_SIGHTING_COMMITTEE;
            xOOOX xooox16 = xooox11;
            if (IXxxXO2 == calculationMethod && coordinates.oIX0oI() >= 55.0d) {
                oix0oi = oix0oi4;
                i = OOXIXo2;
                xooox12 = iI0xO0.II0xO0(xooox2, ((int) (x0xO0oo2 / 7000)) * (-1), oix0oi3.xoIox());
            } else {
                oix0oi = oix0oi4;
                i = OOXIXo2;
                xooox12 = xooox16;
            }
            oIX0oI.C0548oIX0oI xoXoI2 = calculationParameters.xoXoI(coordinates);
            if (calculationParameters.IXxxXO() == calculationMethod) {
                xooox7 = xooox3;
                oix0oi2 = oix0oi;
                i2 = 1000;
                xooox9 = xooox2;
                II0xO02 = f10290xoIox.X0o0xo(coordinates.oIX0oI(), i, dateComponents.I0Io(), xooox9);
                j = x0xO0oo2;
            } else {
                xooox7 = xooox3;
                oix0oi2 = oix0oi;
                i2 = 1000;
                j = x0xO0oo2;
                xooox9 = xooox2;
                II0xO02 = iI0xO0.II0xO0(xooox9, ((int) ((xoXoI2.X0o0xo() * j) / 1000)) * (-1), oix0oi3.xoIox());
            }
            if (xooox12 != null && !II0xO0(xooox12, II0xO02)) {
                xooox13 = xooox12;
            } else {
                xooox13 = II0xO02;
            }
            if (calculationParameters.x0xO0oo() > 0) {
                xooox8 = iI0xO0.II0xO0(xooox7, calculationParameters.x0xO0oo() * 60, oix0oi3.xoIox());
            } else {
                xI.oxoX oIX0oI9 = oix0oi2.oIX0oI(oxx0IOOO.X0o0xo(-calculationParameters.oO(), true));
                xOOOX oIX0oI10 = oIX0oI9 != null ? oIX0oI9.oIX0oI(dateComponents) : null;
                if (calculationParameters.IXxxXO() == calculationMethod && coordinates.oIX0oI() >= 55.0d) {
                    xooox14 = iI0xO0.II0xO0(xooox7, (int) (j / 7000), oix0oi3.xoIox());
                } else {
                    xooox14 = oIX0oI10;
                }
                if (calculationParameters.IXxxXO() == calculationMethod) {
                    xooox15 = xooox9;
                    II0xO03 = f10290xoIox.oxoX(coordinates.oIX0oI(), i, dateComponents.I0Io(), xooox7, calculationParameters.IIXOooo());
                } else {
                    xooox15 = xooox9;
                    II0xO03 = iI0xO0.II0xO0(xooox7, (int) ((xoXoI2.XO() * j) / i2), oix0oi3.xoIox());
                }
                if (xooox14 != null && !oIX0oI(xooox14, II0xO03)) {
                    xooox8 = xooox14;
                } else {
                    xooox8 = II0xO03;
                }
                xooox9 = xooox15;
            }
            xooox5 = xooox;
            xooox6 = xooox10;
            xooox4 = xooox13;
        } else {
            xooox4 = null;
            xooox5 = null;
            xooox6 = null;
            xooox7 = null;
            xooox8 = null;
            xooox9 = null;
        }
        if (xooox4 != null && xooox9 != null && xooox5 != null && xooox6 != null && xooox7 != null && xooox8 != null) {
            this.f10298oxoX = iI0xO0.II0XooXoX(iI0xO0.XO(iI0xO0.II0xO0(iI0xO0.II0xO0(xooox4, calculationParameters.oI0IIXIo().OOXIXo(), oix0oi3.XO()), calculationParameters.Oxx0xo().OOXIXo(), oix0oi3.XO()), calculationParameters.OxxIIOOXO()));
            this.f10295X0o0xo = iI0xO0.II0XooXoX(iI0xO0.XO(iI0xO0.II0xO0(iI0xO0.II0xO0(xooox9, calculationParameters.oI0IIXIo().x0XOIxOo(), oix0oi3.XO()), calculationParameters.Oxx0xo().x0XOIxOo(), oix0oi3.XO()), calculationParameters.OxxIIOOXO()));
            this.f10296XO = iI0xO0.II0XooXoX(iI0xO0.XO(iI0xO0.II0xO0(iI0xO0.II0xO0(xooox5, calculationParameters.oI0IIXIo().xoIox(), oix0oi3.XO()), calculationParameters.Oxx0xo().xoIox(), oix0oi3.XO()), calculationParameters.OxxIIOOXO()));
            this.f10294Oxx0IOOO = iI0xO0.II0XooXoX(iI0xO0.XO(iI0xO0.II0xO0(iI0xO0.II0xO0(xooox6, calculationParameters.oI0IIXIo().xxIXOIIO(), oix0oi3.XO()), calculationParameters.Oxx0xo().xxIXOIIO(), oix0oi3.XO()), calculationParameters.OxxIIOOXO()));
            this.f10292II0XooXoX = iI0xO0.II0XooXoX(iI0xO0.XO(iI0xO0.II0xO0(iI0xO0.II0xO0(xooox7, calculationParameters.oI0IIXIo().ooOOo0oXI(), oix0oi3.XO()), calculationParameters.Oxx0xo().ooOOo0oXI(), oix0oi3.XO()), calculationParameters.OxxIIOOXO()));
            this.f10299xxIXOIIO = iI0xO0.II0XooXoX(iI0xO0.XO(iI0xO0.II0xO0(iI0xO0.II0xO0(xooox8, calculationParameters.oI0IIXIo().oOoXoXO(), oix0oi3.XO()), calculationParameters.Oxx0xo().oOoXoXO(), oix0oi3.XO()), calculationParameters.OxxIIOOXO()));
            return;
        }
        throw new IllegalStateException();
    }

    public static /* synthetic */ II0xO0 Oxx0IOOO(II0xO0 iI0xO0, ooXIXxIX.II0xO0 iI0xO02, I0Io i0Io, com.batoulapps.adhan2.oIX0oI oix0oi, int i, Object obj) {
        if ((i & 1) != 0) {
            iI0xO02 = iI0xO0.f10297oIX0oI;
        }
        if ((i & 2) != 0) {
            i0Io = iI0xO0.f10293II0xO0;
        }
        if ((i & 4) != 0) {
            oix0oi = iI0xO0.f10291I0Io;
        }
        return iI0xO0.XO(iI0xO02, i0Io, oix0oi);
    }

    @OOXIXo
    public final ooXIXxIX.II0xO0 I0Io() {
        return this.f10297oIX0oI;
    }

    @OOXIXo
    public final Prayer II0XooXoX(@OOXIXo IIX0o instant) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(instant, "instant");
        if (instant.compareTo(this.f10299xxIXOIIO) >= 0) {
            return Prayer.ISHA;
        }
        if (instant.compareTo(this.f10292II0XooXoX) >= 0) {
            return Prayer.MAGHRIB;
        }
        if (instant.compareTo(this.f10294Oxx0IOOO) >= 0) {
            return Prayer.ASR;
        }
        if (instant.compareTo(this.f10296XO) >= 0) {
            return Prayer.DHUHR;
        }
        if (instant.compareTo(this.f10295X0o0xo) >= 0) {
            return Prayer.SUNRISE;
        }
        if (instant.compareTo(this.f10298oxoX) >= 0) {
            return Prayer.FAJR;
        }
        return Prayer.NONE;
    }

    public final boolean II0xO0(xOOOX xooox, xOOOX xooox2) {
        X0xxXX0.oIX0oI oix0oi = X0xxXX0.Companion;
        if (IO0XoXxO.oxoX(xooox, oix0oi.I0Io()).x0xO0oo() < IO0XoXxO.oxoX(xooox2, oix0oi.I0Io()).x0xO0oo()) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final Prayer IXxxXO(@OOXIXo IIX0o instant) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(instant, "instant");
        if (instant.compareTo(this.f10299xxIXOIIO) >= 0) {
            return Prayer.NONE;
        }
        if (instant.compareTo(this.f10292II0XooXoX) >= 0) {
            return Prayer.ISHA;
        }
        if (instant.compareTo(this.f10294Oxx0IOOO) >= 0) {
            return Prayer.MAGHRIB;
        }
        if (instant.compareTo(this.f10296XO) >= 0) {
            return Prayer.ASR;
        }
        if (instant.compareTo(this.f10295X0o0xo) >= 0) {
            return Prayer.DHUHR;
        }
        if (instant.compareTo(this.f10298oxoX) >= 0) {
            return Prayer.SUNRISE;
        }
        return Prayer.FAJR;
    }

    @OOXIXo
    public final ooXIXxIX.II0xO0 OOXIXo() {
        return this.f10297oIX0oI;
    }

    @OOXIXo
    public final IIX0o Oo() {
        return this.f10295X0o0xo;
    }

    @OXOo.oOoXoXO
    public final IIX0o Oxx0xo(@OOXIXo Prayer prayer) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(prayer, "prayer");
        switch (C0546II0xO0.f10300oIX0oI[prayer.ordinal()]) {
            case 1:
                return this.f10298oxoX;
            case 2:
                return this.f10295X0o0xo;
            case 3:
                return this.f10296XO;
            case 4:
                return this.f10294Oxx0IOOO;
            case 5:
                return this.f10292II0XooXoX;
            case 6:
                return this.f10299xxIXOIIO;
            case 7:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @OOXIXo
    public final com.batoulapps.adhan2.oIX0oI X0o0xo() {
        return this.f10291I0Io;
    }

    @OOXIXo
    public final II0xO0 XO(@OOXIXo ooXIXxIX.II0xO0 coordinates, @OOXIXo I0Io dateComponents, @OOXIXo com.batoulapps.adhan2.oIX0oI calculationParameters) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(coordinates, "coordinates");
        kotlin.jvm.internal.IIX0o.x0xO0oo(dateComponents, "dateComponents");
        kotlin.jvm.internal.IIX0o.x0xO0oo(calculationParameters, "calculationParameters");
        return new II0xO0(coordinates, dateComponents, calculationParameters);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof II0xO0)) {
            return false;
        }
        II0xO0 iI0xO0 = (II0xO0) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f10297oIX0oI, iI0xO0.f10297oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f10293II0xO0, iI0xO0.f10293II0xO0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f10291I0Io, iI0xO0.f10291I0Io);
    }

    public int hashCode() {
        return (((this.f10297oIX0oI.hashCode() * 31) + this.f10293II0xO0.hashCode()) * 31) + this.f10291I0Io.hashCode();
    }

    public final boolean oIX0oI(xOOOX xooox, xOOOX xooox2) {
        X0xxXX0.oIX0oI oix0oi = X0xxXX0.Companion;
        if (IO0XoXxO.oxoX(xooox, oix0oi.I0Io()).x0xO0oo() > IO0XoXxO.oxoX(xooox2, oix0oi.I0Io()).x0xO0oo()) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final IIX0o oO() {
        return this.f10299xxIXOIIO;
    }

    @OOXIXo
    public final I0Io oOoXoXO() {
        return this.f10293II0xO0;
    }

    @OOXIXo
    public final IIX0o ooOOo0oXI() {
        return this.f10296XO;
    }

    @OOXIXo
    public final I0Io oxoX() {
        return this.f10293II0xO0;
    }

    @OOXIXo
    public String toString() {
        return "PrayerTimes(coordinates=" + this.f10297oIX0oI + ", dateComponents=" + this.f10293II0xO0 + ", calculationParameters=" + this.f10291I0Io + oIX0oI.I0Io.f4095I0Io;
    }

    @OOXIXo
    public final IIX0o x0XOIxOo() {
        return this.f10298oxoX;
    }

    @OOXIXo
    public final IIX0o x0xO0oo() {
        return this.f10292II0XooXoX;
    }

    @OOXIXo
    public final com.batoulapps.adhan2.oIX0oI xoIox() {
        return this.f10291I0Io;
    }

    @OOXIXo
    public final IIX0o xxIXOIIO() {
        return this.f10294Oxx0IOOO;
    }
}
