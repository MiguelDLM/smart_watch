package jxl.read.biff;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* loaded from: classes6.dex */
public class XoX implements xIoXXXIXo.Oxx0xo, OOXIXo {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static DecimalFormat f28306OOXIXo = new DecimalFormat("#.###");

    /* renamed from: I0Io, reason: collision with root package name */
    public double f28307I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public OoIXo.xXxxox0I f28308II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f28309II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28310Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public oI0X0.X0o0xo f28311X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public xIoXXXIXo.oxoX f28312XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f28313oIX0oI;

    /* renamed from: xoIox, reason: collision with root package name */
    public I0 f28315xoIox;

    /* renamed from: oxoX, reason: collision with root package name */
    public NumberFormat f28314oxoX = f28306OOXIXo;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f28316xxIXOIIO = false;

    public XoX(int i, int i2, double d, int i3, OoIXo.xXxxox0I xxxxox0i, I0 i0) {
        this.f28313oIX0oI = i;
        this.f28309II0xO0 = i2;
        this.f28307I0Io = d;
        this.f28310Oxx0IOOO = i3;
        this.f28308II0XooXoX = xxxxox0i;
        this.f28315xoIox = i0;
    }

    public final void I0Io(NumberFormat numberFormat) {
        if (numberFormat != null) {
            this.f28314oxoX = numberFormat;
        }
    }

    @Override // xIoXXXIXo.I0Io
    public final int II0xO0() {
        return this.f28313oIX0oI;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28314oxoX.format(this.f28307I0Io);
    }

    @Override // xIoXXXIXo.Oxx0xo
    public NumberFormat X00IoxXI() {
        return this.f28314oxoX;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.oxoX XO() {
        return this.f28312XO;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34240oxoX;
    }

    @Override // xIoXXXIXo.Oxx0xo
    public double getValue() {
        return this.f28307I0Io;
    }

    @Override // xIoXXXIXo.I0Io
    public boolean isHidden() {
        oO x0xO2 = this.f28315xoIox.x0xO(this.f28309II0xO0);
        if (x0xO2 != null && x0xO2.Xo0() == 0) {
            return true;
        }
        x0xO XI0oooXX2 = this.f28315xoIox.XI0oooXX(this.f28313oIX0oI);
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
        return this.f28309II0xO0;
    }

    @Override // jxl.read.biff.OOXIXo
    public void oO(xIoXXXIXo.oxoX oxox) {
        this.f28312XO = oxox;
    }

    @Override // xIoXXXIXo.I0Io
    public oI0X0.X0o0xo xoIox() {
        if (!this.f28316xxIXOIIO) {
            this.f28311X0o0xo = this.f28308II0XooXoX.xoIox(this.f28310Oxx0IOOO);
            this.f28316xxIXOIIO = true;
        }
        return this.f28311X0o0xo;
    }
}
