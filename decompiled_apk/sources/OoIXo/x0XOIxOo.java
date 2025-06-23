package OoIXo;

import jxl.read.biff.xoxXI;

/* loaded from: classes6.dex */
public class x0XOIxOo extends OI0 {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2397OOXIXo = XxIIOXIXx.X0o0xo.Oxx0IOOO(x0XOIxOo.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f2398II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f2399Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public oIX0oI f2400X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public oIX0oI[] f2401XO;

    /* renamed from: xoIox, reason: collision with root package name */
    public byte[] f2402xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f2403xxIXOIIO;

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f2404I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f2405II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public boolean f2406X0o0xo = false;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f2407oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public int f2408oxoX;

        public void I0Io(int i) {
            int i2 = this.f2408oxoX;
            if (i > i2) {
                return;
            }
            int i3 = this.f2405II0xO0;
            if (i < i3) {
                this.f2405II0xO0 = i3 - 1;
                this.f2406X0o0xo = true;
            }
            if (i <= i2) {
                this.f2408oxoX = i2 - 1;
                this.f2406X0o0xo = true;
            }
        }

        public void II0xO0(int i) {
            int i2 = this.f2404I0Io;
            if (i > i2) {
                return;
            }
            int i3 = this.f2407oIX0oI;
            if (i <= i3) {
                this.f2407oIX0oI = i3 + 1;
                this.f2406X0o0xo = true;
            }
            if (i <= i2) {
                this.f2404I0Io = i2 + 1;
                this.f2406X0o0xo = true;
            }
        }

        public void oIX0oI(int i) {
            int i2 = this.f2408oxoX;
            if (i > i2) {
                return;
            }
            int i3 = this.f2405II0xO0;
            if (i <= i3) {
                this.f2405II0xO0 = i3 + 1;
                this.f2406X0o0xo = true;
            }
            if (i <= i2) {
                this.f2408oxoX = i2 + 1;
                this.f2406X0o0xo = true;
            }
        }

        public void oxoX(int i) {
            int i2 = this.f2404I0Io;
            if (i > i2) {
                return;
            }
            int i3 = this.f2407oIX0oI;
            if (i < i3) {
                this.f2407oIX0oI = i3 - 1;
                this.f2406X0o0xo = true;
            }
            if (i <= i2) {
                this.f2404I0Io = i2 - 1;
                this.f2406X0o0xo = true;
            }
        }
    }

    public x0XOIxOo(xoxXI xoxxi) {
        super(xoxxi);
        this.f2398II0XooXoX = false;
        this.f2403xxIXOIIO = false;
        this.f2402xoIox = oxXx0IX().I0Io();
    }

    public void I0X0x0oIo(int i) {
        if (!this.f2398II0XooXoX) {
            XX0();
        }
        this.f2400X0o0xo.oIX0oI(i);
        if (this.f2400X0o0xo.f2406X0o0xo) {
            this.f2403xxIXOIIO = true;
        }
        int i2 = 0;
        while (true) {
            oIX0oI[] oix0oiArr = this.f2401XO;
            if (i2 < oix0oiArr.length) {
                oix0oiArr[i2].oIX0oI(i);
                if (this.f2401XO[i2].f2406X0o0xo) {
                    this.f2403xxIXOIIO = true;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public final void XX0() {
        oIX0oI oix0oi = new oIX0oI();
        this.f2400X0o0xo = oix0oi;
        byte[] bArr = this.f2402xoIox;
        oix0oi.f2407oIX0oI = oo0xXOI0I.I0Io(bArr[4], bArr[5]);
        oIX0oI oix0oi2 = this.f2400X0o0xo;
        byte[] bArr2 = this.f2402xoIox;
        oix0oi2.f2404I0Io = oo0xXOI0I.I0Io(bArr2[6], bArr2[7]);
        oIX0oI oix0oi3 = this.f2400X0o0xo;
        byte[] bArr3 = this.f2402xoIox;
        oix0oi3.f2405II0xO0 = oo0xXOI0I.I0Io(bArr3[8], bArr3[9]);
        oIX0oI oix0oi4 = this.f2400X0o0xo;
        byte[] bArr4 = this.f2402xoIox;
        oix0oi4.f2408oxoX = oo0xXOI0I.I0Io(bArr4[10], bArr4[11]);
        byte[] bArr5 = this.f2402xoIox;
        int I0Io2 = oo0xXOI0I.I0Io(bArr5[12], bArr5[13]);
        this.f2399Oxx0IOOO = I0Io2;
        this.f2401XO = new oIX0oI[I0Io2];
        int i = 14;
        for (int i2 = 0; i2 < this.f2399Oxx0IOOO; i2++) {
            this.f2401XO[i2] = new oIX0oI();
            oIX0oI oix0oi5 = this.f2401XO[i2];
            byte[] bArr6 = this.f2402xoIox;
            oix0oi5.f2407oIX0oI = oo0xXOI0I.I0Io(bArr6[i], bArr6[i + 1]);
            oIX0oI oix0oi6 = this.f2401XO[i2];
            byte[] bArr7 = this.f2402xoIox;
            oix0oi6.f2404I0Io = oo0xXOI0I.I0Io(bArr7[i + 2], bArr7[i + 3]);
            oIX0oI oix0oi7 = this.f2401XO[i2];
            byte[] bArr8 = this.f2402xoIox;
            oix0oi7.f2405II0xO0 = oo0xXOI0I.I0Io(bArr8[i + 4], bArr8[i + 5]);
            oIX0oI oix0oi8 = this.f2401XO[i2];
            byte[] bArr9 = this.f2402xoIox;
            oix0oi8.f2408oxoX = oo0xXOI0I.I0Io(bArr9[i + 6], bArr9[i + 7]);
            i += 8;
        }
        this.f2398II0XooXoX = true;
    }

    public void Xo0(int i) {
        if (!this.f2398II0XooXoX) {
            XX0();
        }
        this.f2400X0o0xo.I0Io(i);
        if (this.f2400X0o0xo.f2406X0o0xo) {
            this.f2403xxIXOIIO = true;
        }
        int i2 = 0;
        while (true) {
            oIX0oI[] oix0oiArr = this.f2401XO;
            if (i2 < oix0oiArr.length) {
                oix0oiArr[i2].I0Io(i);
                if (this.f2401XO[i2].f2406X0o0xo) {
                    this.f2403xxIXOIIO = true;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public void XoI0Ixx0(int i) {
        if (!this.f2398II0XooXoX) {
            XX0();
        }
        this.f2400X0o0xo.oxoX(i);
        if (this.f2400X0o0xo.f2406X0o0xo) {
            this.f2403xxIXOIIO = true;
        }
        int i2 = 0;
        while (true) {
            oIX0oI[] oix0oiArr = this.f2401XO;
            if (i2 < oix0oiArr.length) {
                oix0oiArr[i2].oxoX(i);
                if (this.f2401XO[i2].f2406X0o0xo) {
                    this.f2403xxIXOIIO = true;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public void oX(int i) {
        if (!this.f2398II0XooXoX) {
            XX0();
        }
        this.f2400X0o0xo.II0xO0(i);
        if (this.f2400X0o0xo.f2406X0o0xo) {
            this.f2403xxIXOIIO = true;
        }
        int i2 = 0;
        while (true) {
            oIX0oI[] oix0oiArr = this.f2401XO;
            if (i2 < oix0oiArr.length) {
                oix0oiArr[i2].II0xO0(i);
                if (this.f2401XO[i2].f2406X0o0xo) {
                    this.f2403xxIXOIIO = true;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        if (!this.f2403xxIXOIIO) {
            return this.f2402xoIox;
        }
        int i = 14;
        byte[] bArr = new byte[(this.f2401XO.length * 8) + 14];
        int i2 = 0;
        System.arraycopy(this.f2402xoIox, 0, bArr, 0, 4);
        oo0xXOI0I.XO(this.f2400X0o0xo.f2407oIX0oI, bArr, 4);
        oo0xXOI0I.XO(this.f2400X0o0xo.f2404I0Io, bArr, 6);
        oo0xXOI0I.XO(this.f2400X0o0xo.f2405II0xO0, bArr, 8);
        oo0xXOI0I.XO(this.f2400X0o0xo.f2408oxoX, bArr, 10);
        oo0xXOI0I.XO(this.f2399Oxx0IOOO, bArr, 12);
        while (true) {
            oIX0oI[] oix0oiArr = this.f2401XO;
            if (i2 < oix0oiArr.length) {
                oo0xXOI0I.XO(oix0oiArr[i2].f2407oIX0oI, bArr, i);
                oo0xXOI0I.XO(this.f2401XO[i2].f2404I0Io, bArr, i + 2);
                oo0xXOI0I.XO(this.f2401XO[i2].f2405II0xO0, bArr, i + 4);
                oo0xXOI0I.XO(this.f2401XO[i2].f2408oxoX, bArr, i + 6);
                i += 8;
                i2++;
            } else {
                return bArr;
            }
        }
    }
}
