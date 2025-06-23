package X0xOO;

/* loaded from: classes6.dex */
public final class XI0IXoo {

    /* renamed from: xoIox, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3402xoIox = XxIIOXIXx.X0o0xo.Oxx0IOOO(XI0IXoo.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f3403I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public XIxXXX0x0 f3404II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f3405II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public boolean f3406Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f3407X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3408XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f3409oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f3410oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public xxX f3411xxIXOIIO;

    public XI0IXoo(xxX xxx2, int i) {
        this.f3411xxIXOIIO = xxx2;
        this.f3409oIX0oI = i;
        byte[] data = xxx2.getData();
        this.f3408XO = data.length;
        int i2 = this.f3409oIX0oI;
        int I0Io2 = OoIXo.oo0xXOI0I.I0Io(data[i2], data[i2 + 1]);
        this.f3405II0xO0 = (65520 & I0Io2) >> 4;
        this.f3403I0Io = I0Io2 & 15;
        int i3 = this.f3409oIX0oI;
        this.f3410oxoX = OoIXo.oo0xXOI0I.I0Io(data[i3 + 2], data[i3 + 3]);
        int i4 = this.f3409oIX0oI;
        this.f3407X0o0xo = OoIXo.oo0xXOI0I.oxoX(data[i4 + 4], data[i4 + 5], data[i4 + 6], data[i4 + 7]);
        if (this.f3403I0Io == 15) {
            this.f3406Oxx0IOOO = true;
        } else {
            this.f3406Oxx0IOOO = false;
        }
    }

    public xxX I0Io() {
        return this.f3411xxIXOIIO;
    }

    public int II0XooXoX() {
        return this.f3408XO;
    }

    public xxX II0xO0() {
        return this.f3411xxIXOIIO;
    }

    public void OOXIXo(boolean z) {
        this.f3406Oxx0IOOO = z;
    }

    public int Oxx0IOOO() {
        return this.f3410oxoX;
    }

    public int X0o0xo() {
        return this.f3407X0o0xo;
    }

    public int XO() {
        return this.f3409oIX0oI;
    }

    public byte[] oIX0oI() {
        byte[] bArr = new byte[this.f3407X0o0xo];
        System.arraycopy(this.f3411xxIXOIIO.getData(), this.f3409oIX0oI + 8, bArr, 0, this.f3407X0o0xo);
        return bArr;
    }

    public void oO(int i) {
        this.f3403I0Io = i;
    }

    public byte[] oOoXoXO(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 8];
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        if (this.f3406Oxx0IOOO) {
            this.f3403I0Io = 15;
        }
        OoIXo.oo0xXOI0I.XO((this.f3405II0xO0 << 4) | this.f3403I0Io, bArr2, 0);
        OoIXo.oo0xXOI0I.XO(this.f3410oxoX, bArr2, 2);
        OoIXo.oo0xXOI0I.oIX0oI(bArr.length, bArr2, 4);
        return bArr2;
    }

    public void ooOOo0oXI(int i) {
        this.f3405II0xO0 = i;
    }

    public int oxoX() {
        return this.f3405II0xO0;
    }

    public void x0XOIxOo(int i) {
        this.f3407X0o0xo = i;
    }

    public boolean xoIox() {
        return this.f3406Oxx0IOOO;
    }

    public XIxXXX0x0 xxIXOIIO() {
        if (this.f3404II0XooXoX == null) {
            this.f3404II0XooXoX = XIxXXX0x0.oIX0oI(this.f3410oxoX);
        }
        return this.f3404II0XooXoX;
    }

    public XI0IXoo(XIxXXX0x0 xIxXXX0x0) {
        this.f3404II0XooXoX = xIxXXX0x0;
        this.f3410oxoX = xIxXXX0x0.II0xO0();
    }
}
