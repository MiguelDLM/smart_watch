package jxl.biff.formula;

/* loaded from: classes6.dex */
public class xo0x extends IO implements o0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f27995II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f27996OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f27997Oxx0IOOO;

    /* renamed from: oO, reason: collision with root package name */
    public xIoXXXIXo.I0Io f27998oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f27999oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f28000ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public boolean f28001x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28002xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28003xxIXOIIO;

    public xo0x(xIoXXXIXo.I0Io i0Io) {
        this.f27998oO = i0Io;
    }

    public int IXxxXO() {
        return this.f27997Oxx0IOOO;
    }

    @Override // jxl.biff.formula.OI0
    public void Oxx0IOOO() {
    }

    public int Oxx0xo() {
        return this.f27995II0XooXoX;
    }

    public int OxxIIOOXO() {
        return this.f28002xoIox;
    }

    @Override // jxl.biff.formula.OI0
    public void XO(StringBuffer stringBuffer) {
        OoIXo.oOoXoXO.oxoX(this.f27997Oxx0IOOO, this.f27995II0XooXoX, stringBuffer);
        stringBuffer.append(':');
        OoIXo.oOoXoXO.oxoX(this.f28003xxIXOIIO, this.f28002xoIox, stringBuffer);
    }

    public int oI0IIXIo() {
        return this.f28003xxIXOIIO;
    }

    @Override // jxl.biff.formula.OI0
    public byte[] oxoX() {
        byte[] bArr = new byte[9];
        bArr[0] = xoxXI.f28036oO.oIX0oI();
        OoIXo.oo0xXOI0I.XO(this.f27995II0XooXoX, bArr, 1);
        OoIXo.oo0xXOI0I.XO(this.f28002xoIox, bArr, 3);
        OoIXo.oo0xXOI0I.XO(this.f27997Oxx0IOOO, bArr, 5);
        OoIXo.oo0xXOI0I.XO(this.f28003xxIXOIIO, bArr, 7);
        return bArr;
    }

    @Override // jxl.biff.formula.o0
    public int read(byte[] bArr, int i) {
        boolean z;
        boolean z2;
        boolean z3;
        this.f27995II0XooXoX = OoIXo.oo0xXOI0I.X0o0xo(bArr[i], bArr[i + 1]);
        this.f28002xoIox = OoIXo.oo0xXOI0I.X0o0xo(bArr[i + 2], bArr[i + 3]);
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i + 4], bArr[i + 5]);
        this.f27997Oxx0IOOO = I0Io2 & 255;
        boolean z4 = false;
        if ((I0Io2 & 16384) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f27996OOXIXo = z;
        if ((I0Io2 & 32768) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f27999oOoXoXO = z2;
        if (z) {
            this.f27997Oxx0IOOO = this.f27998oO.oIX0oI() + this.f27997Oxx0IOOO;
        }
        if (this.f27999oOoXoXO) {
            this.f27995II0XooXoX = this.f27998oO.II0xO0() + this.f27995II0XooXoX;
        }
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(bArr[i + 6], bArr[i + 7]);
        this.f28003xxIXOIIO = I0Io3 & 255;
        if ((I0Io3 & 16384) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f28000ooOOo0oXI = z3;
        if ((I0Io3 & 32768) != 0) {
            z4 = true;
        }
        this.f28001x0XOIxOo = z4;
        if (z3) {
            this.f28003xxIXOIIO = this.f27998oO.oIX0oI() + this.f28003xxIXOIIO;
        }
        if (this.f28001x0XOIxOo) {
            this.f28002xoIox = this.f27998oO.II0xO0() + this.f28002xoIox;
            return 8;
        }
        return 8;
    }
}
