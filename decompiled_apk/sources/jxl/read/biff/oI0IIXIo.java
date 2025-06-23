package jxl.read.biff;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class oI0IIXIo implements xIoXXXIXo.xxIXOIIO, OOXIXo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f28347IXxxXO = 24107;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f28348Oo = 25569;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final long f28349Oxx0xo = 86400;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final long f28350OxxIIOOXO = 86400000;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final long f28351oI0IIXIo = 1000;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f28352oO = 61;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28353oOoXoXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(oI0IIXIo.class);

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final SimpleDateFormat f28354ooOOo0oXI = new SimpleDateFormat("dd MMM yyyy");

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final SimpleDateFormat f28355x0XOIxOo = new SimpleDateFormat(com.sma.smartv3.util.xoIox.f24709oo0xXOI0I);

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final TimeZone f28356x0xO0oo = TimeZone.getTimeZone(org.apache.commons.lang3.time.xoIox.f32917oIX0oI);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28357I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public OoIXo.xXxxox0I f28358II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f28359II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f28360OOXIXo = false;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28361Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public DateFormat f28362X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public oI0X0.X0o0xo f28363XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Date f28364oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f28365oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public xIoXXXIXo.oxoX f28366xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public I0 f28367xxIXOIIO;

    public oI0IIXIo(xIoXXXIXo.Oxx0xo oxx0xo, int i, OoIXo.xXxxox0I xxxxox0i, boolean z, I0 i0) {
        int i2;
        this.f28359II0xO0 = oxx0xo.II0xO0();
        this.f28357I0Io = oxx0xo.oIX0oI();
        this.f28361Oxx0IOOO = i;
        this.f28358II0XooXoX = xxxxox0i;
        this.f28367xxIXOIIO = i0;
        this.f28362X0o0xo = xxxxox0i.oxoX(i);
        double value = oxx0xo.getValue();
        if (Math.abs(value) < 1.0d) {
            if (this.f28362X0o0xo == null) {
                this.f28362X0o0xo = f28355x0XOIxOo;
            }
            this.f28365oxoX = true;
        } else {
            if (this.f28362X0o0xo == null) {
                this.f28362X0o0xo = f28354ooOOo0oXI;
            }
            this.f28365oxoX = false;
        }
        if (!z && !this.f28365oxoX && value < 61.0d) {
            value += 1.0d;
        }
        this.f28362X0o0xo.setTimeZone(f28356x0xO0oo);
        if (z) {
            i2 = 24107;
        } else {
            i2 = 25569;
        }
        this.f28364oIX0oI = new Date(Math.round((value - i2) * 86400.0d) * 1000);
    }

    public final I0 I0Io() {
        return this.f28367xxIXOIIO;
    }

    @Override // xIoXXXIXo.I0Io
    public final int II0xO0() {
        return this.f28359II0xO0;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28362X0o0xo.format(this.f28364oIX0oI);
    }

    @Override // xIoXXXIXo.xxIXOIIO
    public boolean IXxxXO() {
        return this.f28365oxoX;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.oxoX XO() {
        return this.f28366xoIox;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34239oOoXoXO;
    }

    @Override // xIoXXXIXo.I0Io
    public boolean isHidden() {
        oO x0xO2 = this.f28367xxIXOIIO.x0xO(this.f28357I0Io);
        if (x0xO2 != null && x0xO2.Xo0() == 0) {
            return true;
        }
        x0xO XI0oooXX2 = this.f28367xxIXOIIO.XI0oooXX(this.f28359II0xO0);
        if (XI0oooXX2 != null) {
            if (XI0oooXX2.XX0() == 0 || XI0oooXX2.XoI0Ixx0()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // xIoXXXIXo.I0Io
    public final int oIX0oI() {
        return this.f28357I0Io;
    }

    @Override // jxl.read.biff.OOXIXo
    public void oO(xIoXXXIXo.oxoX oxox) {
        this.f28366xoIox = oxox;
    }

    @Override // xIoXXXIXo.xxIXOIIO
    public Date oo0xXOI0I() {
        return this.f28364oIX0oI;
    }

    @Override // xIoXXXIXo.xxIXOIIO
    public DateFormat x0o() {
        boolean z;
        if (this.f28362X0o0xo != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        return this.f28362X0o0xo;
    }

    @Override // xIoXXXIXo.I0Io
    public oI0X0.X0o0xo xoIox() {
        if (!this.f28360OOXIXo) {
            this.f28363XO = this.f28358II0XooXoX.xoIox(this.f28361Oxx0IOOO);
            this.f28360OOXIXo = true;
        }
        return this.f28363XO;
    }
}
