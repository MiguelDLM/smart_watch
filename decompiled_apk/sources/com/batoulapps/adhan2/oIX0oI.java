package com.batoulapps.adhan2;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import com.batoulapps.adhan2.model.Rounding;
import com.batoulapps.adhan2.model.Shafaq;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import ooXIXxIX.I0Io;

/* loaded from: classes8.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f10303I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final I0Io f10304II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final double f10305II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OOXIXo
    public final I0Io f10306Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final Madhab f10307X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @oOoXoXO
    public final HighLatitudeRule f10308XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final double f10309oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public final CalculationMethod f10310oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OOXIXo
    public final Shafaq f10311xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public final Rounding f10312xxIXOIIO;

    /* loaded from: classes8.dex */
    public /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f10313oIX0oI;

        static {
            int[] iArr = new int[HighLatitudeRule.values().length];
            try {
                iArr[HighLatitudeRule.MIDDLE_OF_THE_NIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HighLatitudeRule.SEVENTH_OF_THE_NIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HighLatitudeRule.TWILIGHT_ANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f10313oIX0oI = iArr;
        }
    }

    /* renamed from: com.batoulapps.adhan2.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0548oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public final double f10314II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final double f10315oIX0oI;

        public C0548oIX0oI(double d, double d2) {
            this.f10315oIX0oI = d;
            this.f10314II0xO0 = d2;
        }

        public static /* synthetic */ C0548oIX0oI oxoX(C0548oIX0oI c0548oIX0oI, double d, double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                d = c0548oIX0oI.f10315oIX0oI;
            }
            if ((i & 2) != 0) {
                d2 = c0548oIX0oI.f10314II0xO0;
            }
            return c0548oIX0oI.I0Io(d, d2);
        }

        @OOXIXo
        public final C0548oIX0oI I0Io(double d, double d2) {
            return new C0548oIX0oI(d, d2);
        }

        public final double II0xO0() {
            return this.f10314II0xO0;
        }

        public final double X0o0xo() {
            return this.f10315oIX0oI;
        }

        public final double XO() {
            return this.f10314II0xO0;
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0548oIX0oI)) {
                return false;
            }
            C0548oIX0oI c0548oIX0oI = (C0548oIX0oI) obj;
            return Double.compare(this.f10315oIX0oI, c0548oIX0oI.f10315oIX0oI) == 0 && Double.compare(this.f10314II0xO0, c0548oIX0oI.f10314II0xO0) == 0;
        }

        public int hashCode() {
            return (ooXIXxIX.oIX0oI.oIX0oI(this.f10315oIX0oI) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.f10314II0xO0);
        }

        public final double oIX0oI() {
            return this.f10315oIX0oI;
        }

        @OOXIXo
        public String toString() {
            return "NightPortions(fajr=" + this.f10315oIX0oI + ", isha=" + this.f10314II0xO0 + oIX0oI.I0Io.f4095I0Io;
        }
    }

    public oIX0oI() {
        this(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0, null, null, null, null, null, null, null, 1023, null);
    }

    public final double I0Io() {
        return this.f10305II0xO0;
    }

    @OOXIXo
    public final I0Io II0XooXoX() {
        return this.f10306Oxx0IOOO;
    }

    @OOXIXo
    public final Shafaq II0xO0() {
        return this.f10311xoIox;
    }

    @OOXIXo
    public final Shafaq IIXOooo() {
        return this.f10311xoIox;
    }

    @OOXIXo
    public final CalculationMethod IXxxXO() {
        return this.f10310oxoX;
    }

    @OOXIXo
    public final oIX0oI OOXIXo(double d, double d2, int i, @OOXIXo CalculationMethod method, @OOXIXo Madhab madhab, @oOoXoXO HighLatitudeRule highLatitudeRule, @OOXIXo I0Io prayerAdjustments, @OOXIXo I0Io methodAdjustments, @OOXIXo Rounding rounding, @OOXIXo Shafaq shafaq) {
        IIX0o.x0xO0oo(method, "method");
        IIX0o.x0xO0oo(madhab, "madhab");
        IIX0o.x0xO0oo(prayerAdjustments, "prayerAdjustments");
        IIX0o.x0xO0oo(methodAdjustments, "methodAdjustments");
        IIX0o.x0xO0oo(rounding, "rounding");
        IIX0o.x0xO0oo(shafaq, "shafaq");
        return new oIX0oI(d, d2, i, method, madhab, highLatitudeRule, prayerAdjustments, methodAdjustments, rounding, shafaq);
    }

    @OOXIXo
    public final Madhab Oo() {
        return this.f10307X0o0xo;
    }

    @oOoXoXO
    public final HighLatitudeRule Oxx0IOOO() {
        return this.f10308XO;
    }

    @OOXIXo
    public final I0Io Oxx0xo() {
        return this.f10304II0XooXoX;
    }

    @OOXIXo
    public final Rounding OxxIIOOXO() {
        return this.f10312xxIXOIIO;
    }

    @OOXIXo
    public final CalculationMethod X0o0xo() {
        return this.f10310oxoX;
    }

    @OOXIXo
    public final Madhab XO() {
        return this.f10307X0o0xo;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oIX0oI)) {
            return false;
        }
        oIX0oI oix0oi = (oIX0oI) obj;
        return Double.compare(this.f10309oIX0oI, oix0oi.f10309oIX0oI) == 0 && Double.compare(this.f10305II0xO0, oix0oi.f10305II0xO0) == 0 && this.f10303I0Io == oix0oi.f10303I0Io && this.f10310oxoX == oix0oi.f10310oxoX && this.f10307X0o0xo == oix0oi.f10307X0o0xo && this.f10308XO == oix0oi.f10308XO && IIX0o.Oxx0IOOO(this.f10306Oxx0IOOO, oix0oi.f10306Oxx0IOOO) && IIX0o.Oxx0IOOO(this.f10304II0XooXoX, oix0oi.f10304II0XooXoX) && this.f10312xxIXOIIO == oix0oi.f10312xxIXOIIO && this.f10311xoIox == oix0oi.f10311xoIox;
    }

    public int hashCode() {
        int oIX0oI2 = ((((((((ooXIXxIX.oIX0oI.oIX0oI(this.f10309oIX0oI) * 31) + ooXIXxIX.oIX0oI.oIX0oI(this.f10305II0xO0)) * 31) + this.f10303I0Io) * 31) + this.f10310oxoX.hashCode()) * 31) + this.f10307X0o0xo.hashCode()) * 31;
        HighLatitudeRule highLatitudeRule = this.f10308XO;
        return ((((((((oIX0oI2 + (highLatitudeRule == null ? 0 : highLatitudeRule.hashCode())) * 31) + this.f10306Oxx0IOOO.hashCode()) * 31) + this.f10304II0XooXoX.hashCode()) * 31) + this.f10312xxIXOIIO.hashCode()) * 31) + this.f10311xoIox.hashCode();
    }

    @OOXIXo
    public final I0Io oI0IIXIo() {
        return this.f10306Oxx0IOOO;
    }

    public final double oIX0oI() {
        return this.f10309oIX0oI;
    }

    public final double oO() {
        return this.f10305II0xO0;
    }

    public final double ooOOo0oXI() {
        return this.f10309oIX0oI;
    }

    public final int oxoX() {
        return this.f10303I0Io;
    }

    @OOXIXo
    public String toString() {
        return "CalculationParameters(fajrAngle=" + this.f10309oIX0oI + ", ishaAngle=" + this.f10305II0xO0 + ", ishaInterval=" + this.f10303I0Io + ", method=" + this.f10310oxoX + ", madhab=" + this.f10307X0o0xo + ", highLatitudeRule=" + this.f10308XO + ", prayerAdjustments=" + this.f10306Oxx0IOOO + ", methodAdjustments=" + this.f10304II0XooXoX + ", rounding=" + this.f10312xxIXOIIO + ", shafaq=" + this.f10311xoIox + oIX0oI.I0Io.f4095I0Io;
    }

    @oOoXoXO
    public final HighLatitudeRule x0XOIxOo() {
        return this.f10308XO;
    }

    public final int x0xO0oo() {
        return this.f10303I0Io;
    }

    @OOXIXo
    public final Rounding xoIox() {
        return this.f10312xxIXOIIO;
    }

    @OOXIXo
    public final C0548oIX0oI xoXoI(@OOXIXo ooXIXxIX.II0xO0 coordinates) {
        IIX0o.x0xO0oo(coordinates, "coordinates");
        HighLatitudeRule highLatitudeRule = this.f10308XO;
        if (highLatitudeRule == null) {
            highLatitudeRule = HighLatitudeRule.Companion.oIX0oI(coordinates);
        }
        int i = II0xO0.f10313oIX0oI[highLatitudeRule.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new C0548oIX0oI(this.f10309oIX0oI / 60.0d, this.f10305II0xO0 / 60.0d);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new C0548oIX0oI(0.14285714285714285d, 0.14285714285714285d);
        }
        return new C0548oIX0oI(0.5d, 0.5d);
    }

    @OOXIXo
    public final I0Io xxIXOIIO() {
        return this.f10304II0XooXoX;
    }

    public oIX0oI(double d, double d2, int i, @OOXIXo CalculationMethod method, @OOXIXo Madhab madhab, @oOoXoXO HighLatitudeRule highLatitudeRule, @OOXIXo I0Io prayerAdjustments, @OOXIXo I0Io methodAdjustments, @OOXIXo Rounding rounding, @OOXIXo Shafaq shafaq) {
        IIX0o.x0xO0oo(method, "method");
        IIX0o.x0xO0oo(madhab, "madhab");
        IIX0o.x0xO0oo(prayerAdjustments, "prayerAdjustments");
        IIX0o.x0xO0oo(methodAdjustments, "methodAdjustments");
        IIX0o.x0xO0oo(rounding, "rounding");
        IIX0o.x0xO0oo(shafaq, "shafaq");
        this.f10309oIX0oI = d;
        this.f10305II0xO0 = d2;
        this.f10303I0Io = i;
        this.f10310oxoX = method;
        this.f10307X0o0xo = madhab;
        this.f10308XO = highLatitudeRule;
        this.f10306Oxx0IOOO = prayerAdjustments;
        this.f10304II0XooXoX = methodAdjustments;
        this.f10312xxIXOIIO = rounding;
        this.f10311xoIox = shafaq;
    }

    public /* synthetic */ oIX0oI(double d, double d2, int i, CalculationMethod calculationMethod, Madhab madhab, HighLatitudeRule highLatitudeRule, I0Io i0Io, I0Io i0Io2, Rounding rounding, Shafaq shafaq, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? 0.0d : d, (i2 & 2) == 0 ? d2 : XIXIX.OOXIXo.f3760XO, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? CalculationMethod.OTHER : calculationMethod, (i2 & 16) != 0 ? Madhab.SHAFI : madhab, (i2 & 32) != 0 ? null : highLatitudeRule, (i2 & 64) != 0 ? new I0Io(0, 0, 0, 0, 0, 0, 63, null) : i0Io, (i2 & 128) != 0 ? new I0Io(0, 0, 0, 0, 0, 0, 63, null) : i0Io2, (i2 & 256) != 0 ? Rounding.NEAREST : rounding, (i2 & 512) != 0 ? Shafaq.GENERAL : shafaq);
    }
}
