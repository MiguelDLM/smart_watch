package jxl.biff.formula;

/* loaded from: classes6.dex */
public class xXOx extends IO implements o0 {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f27989oOoXoXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(xXOx.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f27990II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public xIoXXXIXo.I0Io f27991OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f27992Oxx0IOOO;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f27993xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f27994xxIXOIIO;

    public xXOx(xIoXXXIXo.I0Io i0Io) {
        this.f27991OOXIXo = i0Io;
    }

    public int IXxxXO() {
        return this.f27994xxIXOIIO;
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
    }

    public int Oxx0xo() {
        return this.f27993xoIox;
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        OoIXo.oOoXoXO.oxoX(this.f27994xxIXOIIO, this.f27993xoIox, stringBuffer);
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte[] bArr = new byte[5];
        bArr[0] = xoxXI.f28012I0Io.oIX0oI();
        OoIXo.oo0xXOI0I.XO(this.f27993xoIox, bArr, 1);
        int i = this.f27994xxIXOIIO;
        if (this.f27992Oxx0IOOO) {
            i |= 16384;
        }
        if (this.f27990II0XooXoX) {
            i |= 32768;
        }
        OoIXo.oo0xXOI0I.XO(i, bArr, 3);
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        boolean z;
        xIoXXXIXo.I0Io i0Io;
        xIoXXXIXo.I0Io i0Io2;
        this.f27993xoIox = OoIXo.oo0xXOI0I.X0o0xo(bArr[i], bArr[i + 1]);
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i + 2], bArr[i + 3]);
        this.f27994xxIXOIIO = (byte) (I0Io2 & 255);
        boolean z2 = false;
        if ((I0Io2 & 16384) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f27992Oxx0IOOO = z;
        if ((I0Io2 & 32768) != 0) {
            z2 = true;
        }
        this.f27990II0XooXoX = z2;
        if (z && (i0Io2 = this.f27991OOXIXo) != null) {
            this.f27994xxIXOIIO = i0Io2.oIX0oI() + this.f27994xxIXOIIO;
        }
        if (this.f27990II0XooXoX && (i0Io = this.f27991OOXIXo) != null) {
            this.f27993xoIox = i0Io.II0xO0() + this.f27993xoIox;
            return 4;
        }
        return 4;
    }
}
