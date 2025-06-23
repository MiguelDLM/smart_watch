package OoIXo;

import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public class IoOoX extends OI0 {

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f2080xxIXOIIO = 56;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f2081II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f2082Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public oI0X0.x0XOIxOo[] f2083X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f2084XO;

    public IoOoX(xoxXI xoxxi) {
        super(xoxxi);
        this.f2083X0o0xo = new oI0X0.x0XOIxOo[56];
        this.f2081II0XooXoX = false;
        this.f2084XO = false;
        this.f2082Oxx0IOOO = true;
    }

    private void I0X0x0oIo() {
        byte[] I0Io2 = oxXx0IX().I0Io();
        int I0Io3 = oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        for (int i = 0; i < I0Io3; i++) {
            int i2 = i * 4;
            this.f2083X0o0xo[i] = new oI0X0.x0XOIxOo(oo0xXOI0I.I0Io(I0Io2[i2 + 2], (byte) 0), oo0xXOI0I.I0Io(I0Io2[i2 + 3], (byte) 0), oo0xXOI0I.I0Io(I0Io2[i2 + 4], (byte) 0));
        }
        this.f2081II0XooXoX = true;
    }

    public oI0X0.x0XOIxOo XX0(oI0X0.XO xo2) {
        int II0XooXoX2 = xo2.II0XooXoX() - 8;
        if (II0XooXoX2 >= 0 && II0XooXoX2 < 56) {
            if (!this.f2081II0XooXoX) {
                I0X0x0oIo();
            }
            return this.f2083X0o0xo[II0XooXoX2];
        }
        return xo2.oxoX();
    }

    public void Xo0(oI0X0.XO xo2, int i, int i2, int i3) {
        int II0XooXoX2 = xo2.II0XooXoX() - 8;
        if (II0XooXoX2 >= 0 && II0XooXoX2 < 56) {
            if (!this.f2081II0XooXoX) {
                I0X0x0oIo();
            }
            this.f2083X0o0xo[II0XooXoX2] = new oI0X0.x0XOIxOo(XoI0Ixx0(i, 0, 255), XoI0Ixx0(i2, 0, 255), XoI0Ixx0(i3, 0, 255));
            this.f2084XO = true;
        }
    }

    public final int XoI0Ixx0(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public boolean oX() {
        return this.f2084XO;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        if (this.f2082Oxx0IOOO && !this.f2084XO) {
            return oxXx0IX().I0Io();
        }
        byte[] bArr = new byte[226];
        oo0xXOI0I.XO(56, bArr, 0);
        for (int i = 0; i < 56; i++) {
            int i2 = i * 4;
            bArr[i2 + 2] = (byte) this.f2083X0o0xo[i].I0Io();
            bArr[i2 + 3] = (byte) this.f2083X0o0xo[i].II0xO0();
            bArr[i2 + 4] = (byte) this.f2083X0o0xo[i].oIX0oI();
        }
        return bArr;
    }

    public IoOoX() {
        super(xII.f2436IxIX0I);
        this.f2083X0o0xo = new oI0X0.x0XOIxOo[56];
        this.f2081II0XooXoX = true;
        this.f2084XO = false;
        this.f2082Oxx0IOOO = false;
        for (oI0X0.XO xo2 : oI0X0.XO.oIX0oI()) {
            Xo0(xo2, xo2.oxoX().I0Io(), xo2.oxoX().II0xO0(), xo2.oxoX().oIX0oI());
        }
    }
}
