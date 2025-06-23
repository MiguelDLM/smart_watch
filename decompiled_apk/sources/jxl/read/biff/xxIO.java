package jxl.read.biff;

/* loaded from: classes6.dex */
public class xxIO extends OoIXo.Xx000oIo {

    /* renamed from: Oo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28540Oo = XxIIOXIXx.X0o0xo.Oxx0IOOO(xxIO.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public byte[] f28541I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f28542II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f28543OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public double f28544Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f28545X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public double f28546XO;

    /* renamed from: oO, reason: collision with root package name */
    public int f28547oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f28548oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f28549ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f28550oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public int f28551x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public boolean f28552x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f28553xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28554xxIXOIIO;

    public xxIO(xoxXI xoxxi) {
        super(OoIXo.xII.f2529xoxXI);
        boolean z;
        boolean z2;
        byte[] I0Io2 = xoxxi.I0Io();
        this.f28541I0Io = I0Io2;
        this.f28542II0XooXoX = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        byte[] bArr = this.f28541I0Io;
        this.f28554xxIXOIIO = OoIXo.oo0xXOI0I.I0Io(bArr[2], bArr[3]);
        byte[] bArr2 = this.f28541I0Io;
        this.f28553xoIox = OoIXo.oo0xXOI0I.I0Io(bArr2[4], bArr2[5]);
        byte[] bArr3 = this.f28541I0Io;
        this.f28543OOXIXo = OoIXo.oo0xXOI0I.I0Io(bArr3[6], bArr3[7]);
        byte[] bArr4 = this.f28541I0Io;
        this.f28548oOoXoXO = OoIXo.oo0xXOI0I.I0Io(bArr4[8], bArr4[9]);
        byte[] bArr5 = this.f28541I0Io;
        this.f28549ooOOo0oXI = OoIXo.oo0xXOI0I.I0Io(bArr5[12], bArr5[13]);
        byte[] bArr6 = this.f28541I0Io;
        this.f28551x0XOIxOo = OoIXo.oo0xXOI0I.I0Io(bArr6[14], bArr6[15]);
        byte[] bArr7 = this.f28541I0Io;
        this.f28547oO = OoIXo.oo0xXOI0I.I0Io(bArr7[32], bArr7[33]);
        this.f28546XO = OoIXo.OxI.II0xO0(this.f28541I0Io, 16);
        this.f28544Oxx0IOOO = OoIXo.OxI.II0xO0(this.f28541I0Io, 24);
        byte[] bArr8 = this.f28541I0Io;
        int I0Io3 = OoIXo.oo0xXOI0I.I0Io(bArr8[10], bArr8[11]);
        if ((I0Io3 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f28545X0o0xo = z;
        if ((I0Io3 & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f28550oxoX = z2;
        this.f28552x0xO0oo = (I0Io3 & 4) == 0;
    }

    public double I0X0x0oIo() {
        return this.f28544Oxx0IOOO;
    }

    public int I0oOIX() {
        return this.f28542II0XooXoX;
    }

    public boolean IoOoo() {
        return this.f28550oxoX;
    }

    public int O0Xx() {
        return this.f28553xoIox;
    }

    public int OO() {
        return this.f28551x0XOIxOo;
    }

    public int XX0() {
        return this.f28543OOXIXo;
    }

    public int Xo0() {
        return this.f28549ooOOo0oXI;
    }

    public boolean XoI0Ixx0() {
        return this.f28552x0xO0oo;
    }

    public double oX() {
        return this.f28546XO;
    }

    public int xXOx() {
        return this.f28548oOoXoXO;
    }

    public int xo0x() {
        return this.f28547oO;
    }

    public boolean xoIxX() {
        return this.f28545X0o0xo;
    }

    public int xoxXI() {
        return this.f28554xxIXOIIO;
    }
}
