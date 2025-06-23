package jxl.write.biff;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* loaded from: classes6.dex */
public abstract class I0oOIX extends oOoXoXO {

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static DecimalFormat f28562x0xO0oo = new DecimalFormat("#.###");

    /* renamed from: oO, reason: collision with root package name */
    public NumberFormat f28563oO;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public double f28564x0XOIxOo;

    public I0oOIX(int i, int i2, double d) {
        super(OoIXo.xII.f2458X0IIOO, i, i2);
        this.f28564x0XOIxOo = d;
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        if (this.f28563oO == null) {
            NumberFormat X00IoxXI2 = ((OoIXo.XX) xoIox()).X00IoxXI();
            this.f28563oO = X00IoxXI2;
            if (X00IoxXI2 == null) {
                this.f28563oO = f28562x0xO0oo;
            }
        }
        return this.f28563oO.format(this.f28564x0XOIxOo);
    }

    public void O00XxXI(double d) {
        this.f28564x0XOIxOo = d;
    }

    public NumberFormat X00IoxXI() {
        return null;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34240oxoX;
    }

    public double getValue() {
        return this.f28564x0XOIxOo;
    }

    @Override // jxl.write.biff.oOoXoXO, OoIXo.OI0
    public byte[] xo0x() {
        byte[] xo0x2 = super.xo0x();
        byte[] bArr = new byte[xo0x2.length + 8];
        System.arraycopy(xo0x2, 0, bArr, 0, xo0x2.length);
        OoIXo.OxI.oIX0oI(this.f28564x0XOIxOo, bArr, xo0x2.length);
        return bArr;
    }

    public I0oOIX(int i, int i2, double d, oI0X0.X0o0xo x0o0xo) {
        super(OoIXo.xII.f2458X0IIOO, i, i2, x0o0xo);
        this.f28564x0XOIxOo = d;
    }

    public I0oOIX(xIoXXXIXo.Oxx0xo oxx0xo) {
        super(OoIXo.xII.f2458X0IIOO, oxx0xo);
        this.f28564x0XOIxOo = oxx0xo.getValue();
    }

    public I0oOIX(int i, int i2, I0oOIX i0oOIX) {
        super(OoIXo.xII.f2458X0IIOO, i, i2, i0oOIX);
        this.f28564x0XOIxOo = i0oOIX.f28564x0XOIxOo;
    }
}
