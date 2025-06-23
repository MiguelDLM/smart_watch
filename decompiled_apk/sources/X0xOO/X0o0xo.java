package X0xOO;

/* loaded from: classes6.dex */
public class X0o0xo implements OoIXo.xoIox, xxX {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final XxIIOXIXx.X0o0xo f3391OOXIXo = XxIIOXIXx.X0o0xo.Oxx0IOOO(X0o0xo.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f3392I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public byte[] f3393II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public ooXIXxIX f3394II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3395Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public jxl.read.biff.XIxXXX0x0 f3396X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public OxxIIOOXO f3397XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public xXxxox0I f3398oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f3399oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f3400xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f3401xxIXOIIO;

    public X0o0xo(xXxxox0I xxxxox0i, ooXIXxIX ooxixxix, OxxIIOOXO oxxIIOOXO, int i, int i2, jxl.read.biff.XIxXXX0x0 xIxXXX0x0, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f3398oIX0oI = xxxxox0i;
        this.f3394II0xO0 = ooxixxix;
        this.f3392I0Io = i;
        this.f3399oxoX = i2;
        this.f3396X0o0xo = xIxXXX0x0;
        this.f3400xoIox = o0xOxO;
        boolean z = true;
        if (xxxxox0i != null) {
            this.f3397XO = oxxIIOOXO;
            oxxIIOOXO.oIX0oI(xxxxox0i.oxXx0IX().I0Io());
            this.f3395Oxx0IOOO = this.f3397XO.I0Io() - 1;
        }
        this.f3401xxIXOIIO = false;
        if ((xxxxox0i == null || ooxixxix == null) && (xxxxox0i != null || ooxixxix != null)) {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
    }

    private void X0o0xo() {
        jxl.read.biff.XIxXXX0x0 xIxXXX0x0 = this.f3396X0o0xo;
        int i = this.f3392I0Io;
        this.f3393II0XooXoX = xIxXXX0x0.xxIXOIIO(i, this.f3399oxoX - i);
        this.f3401xxIXOIIO = true;
    }

    @Override // OoIXo.xoIox
    public byte[] I0Io() {
        if (!this.f3401xxIXOIIO) {
            X0o0xo();
        }
        return this.f3393II0XooXoX;
    }

    public ooXIXxIX II0xO0() {
        return this.f3394II0xO0;
    }

    public void XO(OoIXo.xI xIVar, OoIXo.xI xIVar2, OoIXo.xI xIVar3) {
        if (!this.f3401xxIXOIIO) {
            X0o0xo();
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.f3393II0XooXoX;
            if (i < bArr.length) {
                int I0Io2 = OoIXo.oo0xXOI0I.I0Io(bArr[i], bArr[i + 1]);
                byte[] bArr2 = this.f3393II0XooXoX;
                int I0Io3 = OoIXo.oo0xXOI0I.I0Io(bArr2[i + 2], bArr2[i + 3]);
                OoIXo.xII II0xO02 = OoIXo.xII.II0xO0(I0Io2);
                if (II0xO02 == OoIXo.xII.f2461X0xxXX0) {
                    byte[] bArr3 = this.f3393II0XooXoX;
                    int i2 = i + 4;
                    OoIXo.oo0xXOI0I.XO(xIVar2.oIX0oI(OoIXo.oo0xXOI0I.I0Io(bArr3[i2], bArr3[i + 5])), this.f3393II0XooXoX, i2);
                } else if (II0xO02 == OoIXo.xII.f2497oXxOI0oIx) {
                    byte[] bArr4 = this.f3393II0XooXoX;
                    int i3 = i + 12;
                    OoIXo.oo0xXOI0I.XO(xIVar2.oIX0oI(OoIXo.oo0xXOI0I.I0Io(bArr4[i3], bArr4[i + 13])), this.f3393II0XooXoX, i3);
                } else if (II0xO02 == OoIXo.xII.f2425IO0XoXxO) {
                    byte[] bArr5 = this.f3393II0XooXoX;
                    int i4 = i + 4;
                    OoIXo.oo0xXOI0I.XO(xIVar3.oIX0oI(OoIXo.oo0xXOI0I.I0Io(bArr5[i4], bArr5[i + 5])), this.f3393II0XooXoX, i4);
                } else if (II0xO02 == OoIXo.xII.f2471XOxxooXI) {
                    byte[] bArr6 = this.f3393II0XooXoX;
                    int I0Io4 = OoIXo.oo0xXOI0I.I0Io(bArr6[i + 4], bArr6[i + 5]);
                    int i5 = i + 6;
                    for (int i6 = 0; i6 < I0Io4; i6++) {
                        byte[] bArr7 = this.f3393II0XooXoX;
                        int i7 = i5 + 2;
                        OoIXo.oo0xXOI0I.XO(xIVar2.oIX0oI(OoIXo.oo0xXOI0I.I0Io(bArr7[i7], bArr7[i5 + 3])), this.f3393II0XooXoX, i7);
                        i5 += 4;
                    }
                }
                i += I0Io3 + 4;
            } else {
                return;
            }
        }
    }

    @Override // X0xOO.xxX
    public byte[] getData() {
        return this.f3398oIX0oI.oxXx0IX().I0Io();
    }

    public xXxxox0I oIX0oI() {
        return this.f3398oIX0oI;
    }

    public OxI oxoX() {
        return this.f3397XO.oxoX(this.f3395Oxx0IOOO);
    }
}
