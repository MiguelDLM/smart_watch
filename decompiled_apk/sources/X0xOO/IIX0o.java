package X0xOO;

import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public class IIX0o extends OoIXo.OI0 {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3306xxIXOIIO = XxIIOXIXx.X0o0xo.Oxx0IOOO(IIX0o.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3307II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3308Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f3309X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3310XO;

    public IIX0o(xoxXI xoxxi) {
        super(xoxxi);
        byte[] I0Io2 = oxXx0IX().I0Io();
        this.f3309X0o0xo = I0Io2;
        this.f3310XO = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        byte[] bArr = this.f3309X0o0xo;
        this.f3308Oxx0IOOO = OoIXo.oo0xXOI0I.I0Io(bArr[2], bArr[3]);
        byte[] bArr2 = this.f3309X0o0xo;
        this.f3307II0XooXoX = OoIXo.oo0xXOI0I.I0Io(bArr2[6], bArr2[7]);
    }

    public int II0xO0() {
        return this.f3310XO;
    }

    public int XX0() {
        return this.f3307II0XooXoX;
    }

    public int oIX0oI() {
        return this.f3308Oxx0IOOO;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = this.f3309X0o0xo;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[12];
        this.f3309X0o0xo = bArr2;
        OoIXo.oo0xXOI0I.XO(this.f3310XO, bArr2, 0);
        OoIXo.oo0xXOI0I.XO(this.f3308Oxx0IOOO, this.f3309X0o0xo, 2);
        OoIXo.oo0xXOI0I.XO(this.f3307II0XooXoX, this.f3309X0o0xo, 6);
        OoIXo.oo0xXOI0I.XO(0, this.f3309X0o0xo, 8);
        return this.f3309X0o0xo;
    }

    public IIX0o(byte[] bArr) {
        super(OoIXo.xII.f2500ooOOo0oXI);
        this.f3309X0o0xo = bArr;
    }

    public IIX0o(int i, int i2, int i3) {
        super(OoIXo.xII.f2500ooOOo0oXI);
        this.f3310XO = i2;
        this.f3308Oxx0IOOO = i;
        this.f3307II0XooXoX = i3;
    }
}
