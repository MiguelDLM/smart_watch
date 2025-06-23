package jxl.read.biff;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/* loaded from: classes6.dex */
public class oxxXoxO extends oOoXoXO implements xIoXXXIXo.Oxx0xo {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public double f28454oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public NumberFormat f28455ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28453x0XOIxOo = XxIIOXIXx.X0o0xo.Oxx0IOOO(oxxXoxO.class);

    /* renamed from: oO, reason: collision with root package name */
    public static DecimalFormat f28452oO = new DecimalFormat("#.###");

    public oxxXoxO(xoxXI xoxxi, OoIXo.xXxxox0I xxxxox0i, I0 i0) {
        super(xoxxi, xxxxox0i, i0);
        this.f28454oOoXoXO = OoIXo.OxI.II0xO0(oxXx0IX().I0Io(), 6);
        NumberFormat Oxx0IOOO2 = xxxxox0i.Oxx0IOOO(xXOx());
        this.f28455ooOOo0oXI = Oxx0IOOO2;
        if (Oxx0IOOO2 == null) {
            this.f28455ooOOo0oXI = f28452oO;
        }
    }

    @Override // xIoXXXIXo.I0Io
    public String IIX0o() {
        return this.f28455ooOOo0oXI.format(this.f28454oOoXoXO);
    }

    @Override // xIoXXXIXo.Oxx0xo
    public NumberFormat X00IoxXI() {
        return this.f28455ooOOo0oXI;
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.Oxx0IOOO getType() {
        return xIoXXXIXo.Oxx0IOOO.f34240oxoX;
    }

    @Override // xIoXXXIXo.Oxx0xo
    public double getValue() {
        return this.f28454oOoXoXO;
    }
}
