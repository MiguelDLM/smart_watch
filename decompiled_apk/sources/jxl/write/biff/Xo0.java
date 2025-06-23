package jxl.write.biff;

import jxl.read.biff.o0;

/* loaded from: classes6.dex */
public class Xo0 extends OoIXo.OI0 {

    /* renamed from: oO, reason: collision with root package name */
    public static final int f28777oO = 41;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f28779ooOOo0oXI = 58;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f28780x0XOIxOo = 59;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f28781x0xO0oo = 16;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f28782II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public oIX0oI[] f28783OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public OoIXo.Oxx0IOOO f28784Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28785X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public String f28786XO;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f28787xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28788xxIXOIIO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28778oOoXoXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(Xo0.class);

    /* renamed from: Oo, reason: collision with root package name */
    public static final oIX0oI f28776Oo = new oIX0oI(0, 0, 0, 0, 0);

    public Xo0(jxl.read.biff.o0 o0Var, int i) {
        super(OoIXo.xII.f2463XI0IXoo);
        int i2 = 0;
        this.f28788xxIXOIIO = 0;
        this.f28785X0o0xo = o0Var.xXOx();
        this.f28786XO = o0Var.getName();
        this.f28788xxIXOIIO = o0Var.oX();
        this.f28782II0XooXoX = i;
        this.f28787xoIox = false;
        o0.I0Io[] I0X0x0oIo2 = o0Var.I0X0x0oIo();
        this.f28783OOXIXo = new oIX0oI[I0X0x0oIo2.length];
        while (true) {
            oIX0oI[] oix0oiArr = this.f28783OOXIXo;
            if (i2 >= oix0oiArr.length) {
                return;
            }
            oix0oiArr[i2] = new oIX0oI(I0X0x0oIo2[i2]);
            i2++;
        }
    }

    public boolean I0X0x0oIo(int i, int i2) {
        oIX0oI[] oix0oiArr;
        int i3 = 0;
        while (true) {
            oIX0oI[] oix0oiArr2 = this.f28783OOXIXo;
            if (i3 >= oix0oiArr2.length) {
                break;
            }
            if (i == oix0oiArr2[i3].XO()) {
                if (i2 == this.f28783OOXIXo[i3].Oxx0IOOO() && i2 == this.f28783OOXIXo[i3].xxIXOIIO()) {
                    this.f28783OOXIXo[i3] = f28776Oo;
                }
                if (i2 < this.f28783OOXIXo[i3].Oxx0IOOO() && i2 > 0) {
                    this.f28783OOXIXo[i3].oIX0oI();
                    this.f28787xoIox = true;
                }
                if (i2 <= this.f28783OOXIXo[i3].xxIXOIIO()) {
                    this.f28783OOXIXo[i3].I0Io();
                    this.f28787xoIox = true;
                }
            }
            i3++;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            oix0oiArr = this.f28783OOXIXo;
            if (i4 >= oix0oiArr.length) {
                break;
            }
            if (oix0oiArr[i4] == f28776Oo) {
                i5++;
            }
            i4++;
        }
        if (i5 == oix0oiArr.length) {
            return true;
        }
        oIX0oI[] oix0oiArr3 = new oIX0oI[oix0oiArr.length - i5];
        int i6 = 0;
        while (true) {
            oIX0oI[] oix0oiArr4 = this.f28783OOXIXo;
            if (i6 < oix0oiArr4.length) {
                oIX0oI oix0oi = oix0oiArr4[i6];
                if (oix0oi != f28776Oo) {
                    oix0oiArr3[i6] = oix0oi;
                }
                i6++;
            } else {
                this.f28783OOXIXo = oix0oiArr3;
                return false;
            }
        }
    }

    public boolean I0oOIX(int i, int i2) {
        oIX0oI[] oix0oiArr;
        int i3 = 0;
        while (true) {
            oIX0oI[] oix0oiArr2 = this.f28783OOXIXo;
            if (i3 >= oix0oiArr2.length) {
                break;
            }
            if (i == oix0oiArr2[i3].XO()) {
                if (i2 == this.f28783OOXIXo[i3].II0XooXoX() && i2 == this.f28783OOXIXo[i3].xoIox()) {
                    this.f28783OOXIXo[i3] = f28776Oo;
                }
                if (i2 < this.f28783OOXIXo[i3].II0XooXoX() && i2 > 0) {
                    this.f28783OOXIXo[i3].II0xO0();
                    this.f28787xoIox = true;
                }
                if (i2 <= this.f28783OOXIXo[i3].xoIox()) {
                    this.f28783OOXIXo[i3].oxoX();
                    this.f28787xoIox = true;
                }
            }
            i3++;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            oix0oiArr = this.f28783OOXIXo;
            if (i4 >= oix0oiArr.length) {
                break;
            }
            if (oix0oiArr[i4] == f28776Oo) {
                i5++;
            }
            i4++;
        }
        if (i5 == oix0oiArr.length) {
            return true;
        }
        oIX0oI[] oix0oiArr3 = new oIX0oI[oix0oiArr.length - i5];
        int i6 = 0;
        while (true) {
            oIX0oI[] oix0oiArr4 = this.f28783OOXIXo;
            if (i6 < oix0oiArr4.length) {
                oIX0oI oix0oi = oix0oiArr4[i6];
                if (oix0oi != f28776Oo) {
                    oix0oiArr3[i6] = oix0oi;
                }
                i6++;
            } else {
                this.f28783OOXIXo = oix0oiArr3;
                return false;
            }
        }
    }

    public void O0Xx(int i, int i2) {
        int i3 = 0;
        while (true) {
            oIX0oI[] oix0oiArr = this.f28783OOXIXo;
            if (i3 < oix0oiArr.length) {
                if (i == oix0oiArr[i3].XO()) {
                    if (i2 <= this.f28783OOXIXo[i3].II0XooXoX()) {
                        this.f28783OOXIXo[i3].oOoXoXO();
                        this.f28787xoIox = true;
                    }
                    if (i2 <= this.f28783OOXIXo[i3].xoIox()) {
                        this.f28783OOXIXo[i3].x0XOIxOo();
                        this.f28787xoIox = true;
                    }
                }
                i3++;
            } else {
                return;
            }
        }
    }

    public void XX0(int i, int i2) {
        int i3 = 0;
        while (true) {
            oIX0oI[] oix0oiArr = this.f28783OOXIXo;
            if (i3 < oix0oiArr.length) {
                if (i == oix0oiArr[i3].XO()) {
                    if (i2 <= this.f28783OOXIXo[i3].Oxx0IOOO()) {
                        this.f28783OOXIXo[i3].OOXIXo();
                        this.f28787xoIox = true;
                    }
                    if (i2 <= this.f28783OOXIXo[i3].xxIXOIIO()) {
                        this.f28783OOXIXo[i3].ooOOo0oXI();
                        this.f28787xoIox = true;
                    }
                }
                i3++;
            } else {
                return;
            }
        }
    }

    public oIX0oI[] Xo0() {
        return this.f28783OOXIXo;
    }

    public int XoI0Ixx0() {
        return this.f28788xxIXOIIO;
    }

    public String getName() {
        return this.f28786XO;
    }

    public int oX() {
        return this.f28782II0XooXoX;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        int length;
        int i;
        int length2;
        byte[] bArr = this.f28785X0o0xo;
        if (bArr != null && !this.f28787xoIox) {
            return bArr;
        }
        oIX0oI[] oix0oiArr = this.f28783OOXIXo;
        int i2 = 11;
        if (oix0oiArr.length > 1) {
            i2 = (oix0oiArr.length * 11) + 4;
        }
        int i3 = i2 + 15;
        if (this.f28784Oxx0IOOO != null) {
            length = 1;
        } else {
            length = this.f28786XO.length();
        }
        byte[] bArr2 = new byte[i3 + length];
        this.f28785X0o0xo = bArr2;
        if (this.f28784Oxx0IOOO != null) {
            i = 32;
        } else {
            i = 0;
        }
        OoIXo.oo0xXOI0I.XO(i, bArr2, 0);
        byte[] bArr3 = this.f28785X0o0xo;
        bArr3[2] = 0;
        if (this.f28784Oxx0IOOO != null) {
            bArr3[3] = 1;
        } else {
            bArr3[3] = (byte) this.f28786XO.length();
        }
        OoIXo.oo0xXOI0I.XO(i2, this.f28785X0o0xo, 4);
        OoIXo.oo0xXOI0I.XO(this.f28788xxIXOIIO, this.f28785X0o0xo, 6);
        OoIXo.oo0xXOI0I.XO(this.f28788xxIXOIIO, this.f28785X0o0xo, 8);
        OoIXo.Oxx0IOOO oxx0IOOO = this.f28784Oxx0IOOO;
        if (oxx0IOOO != null) {
            this.f28785X0o0xo[15] = (byte) oxx0IOOO.I0Io();
        } else {
            OoIXo.IO.oIX0oI(this.f28786XO, this.f28785X0o0xo, 15);
        }
        if (this.f28784Oxx0IOOO != null) {
            length2 = 16;
        } else {
            length2 = this.f28786XO.length() + 15;
        }
        oIX0oI[] oix0oiArr2 = this.f28783OOXIXo;
        if (oix0oiArr2.length > 1) {
            byte[] bArr4 = this.f28785X0o0xo;
            bArr4[length2] = 41;
            OoIXo.oo0xXOI0I.XO(i2 - 3, bArr4, length2 + 1);
            int i4 = length2 + 3;
            int i5 = 0;
            while (true) {
                oIX0oI[] oix0oiArr3 = this.f28783OOXIXo;
                if (i5 >= oix0oiArr3.length) {
                    break;
                }
                int i6 = i4 + 1;
                this.f28785X0o0xo[i4] = 59;
                byte[] X0o0xo2 = oix0oiArr3[i5].X0o0xo();
                System.arraycopy(X0o0xo2, 0, this.f28785X0o0xo, i6, X0o0xo2.length);
                i4 = X0o0xo2.length + i6;
                i5++;
            }
            this.f28785X0o0xo[i4] = 16;
        } else {
            this.f28785X0o0xo[length2] = 59;
            byte[] X0o0xo3 = oix0oiArr2[0].X0o0xo();
            System.arraycopy(X0o0xo3, 0, this.f28785X0o0xo, length2 + 1, X0o0xo3.length);
        }
        return this.f28785X0o0xo;
    }

    public void xoxXI(int i) {
        this.f28788xxIXOIIO = i;
        OoIXo.oo0xXOI0I.XO(i, this.f28785X0o0xo, 8);
    }

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f28789I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f28790II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public int f28791X0o0xo;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f28792oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public int f28793oxoX;

        public oIX0oI(o0.I0Io i0Io) {
            this.f28792oIX0oI = i0Io.II0xO0();
            this.f28790II0xO0 = i0Io.I0Io();
            this.f28789I0Io = i0Io.oxoX();
            this.f28793oxoX = i0Io.X0o0xo();
            this.f28791X0o0xo = i0Io.oIX0oI();
        }

        public void I0Io() {
            this.f28789I0Io--;
        }

        public int II0XooXoX() {
            return this.f28790II0xO0;
        }

        public void II0xO0() {
            this.f28790II0xO0--;
        }

        public void OOXIXo() {
            this.f28792oIX0oI++;
        }

        public int Oxx0IOOO() {
            return this.f28792oIX0oI;
        }

        public byte[] X0o0xo() {
            byte[] bArr = new byte[10];
            OoIXo.oo0xXOI0I.XO(this.f28791X0o0xo, bArr, 0);
            OoIXo.oo0xXOI0I.XO(this.f28790II0xO0, bArr, 2);
            OoIXo.oo0xXOI0I.XO(this.f28793oxoX, bArr, 4);
            OoIXo.oo0xXOI0I.XO(this.f28792oIX0oI & 255, bArr, 6);
            OoIXo.oo0xXOI0I.XO(this.f28789I0Io & 255, bArr, 8);
            return bArr;
        }

        public int XO() {
            return this.f28791X0o0xo;
        }

        public void oIX0oI() {
            this.f28792oIX0oI--;
        }

        public void oOoXoXO() {
            this.f28790II0xO0++;
        }

        public void ooOOo0oXI() {
            this.f28789I0Io++;
        }

        public void oxoX() {
            this.f28793oxoX--;
        }

        public void x0XOIxOo() {
            this.f28793oxoX++;
        }

        public int xoIox() {
            return this.f28793oxoX;
        }

        public int xxIXOIIO() {
            return this.f28789I0Io;
        }

        public oIX0oI(int i, int i2, int i3, int i4, int i5) {
            this.f28792oIX0oI = i4;
            this.f28790II0xO0 = i2;
            this.f28789I0Io = i5;
            this.f28793oxoX = i3;
            this.f28791X0o0xo = i;
        }
    }

    public Xo0(String str, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(OoIXo.xII.f2463XI0IXoo);
        this.f28788xxIXOIIO = 0;
        this.f28786XO = str;
        this.f28782II0XooXoX = i;
        this.f28788xxIXOIIO = z ? 0 : i + 1;
        this.f28783OOXIXo = r9;
        oIX0oI[] oix0oiArr = {new oIX0oI(i2, i3, i4, i5, i6)};
        this.f28787xoIox = true;
    }

    public Xo0(OoIXo.Oxx0IOOO oxx0IOOO, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(OoIXo.xII.f2463XI0IXoo);
        this.f28788xxIXOIIO = 0;
        this.f28784Oxx0IOOO = oxx0IOOO;
        this.f28782II0XooXoX = i;
        this.f28788xxIXOIIO = z ? 0 : i + 1;
        this.f28783OOXIXo = r8;
        oIX0oI[] oix0oiArr = {new oIX0oI(i2, i3, i4, i5, i6)};
    }

    public Xo0(OoIXo.Oxx0IOOO oxx0IOOO, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z) {
        super(OoIXo.xII.f2463XI0IXoo);
        this.f28788xxIXOIIO = 0;
        this.f28784Oxx0IOOO = oxx0IOOO;
        this.f28782II0XooXoX = i;
        this.f28788xxIXOIIO = z ? 0 : i + 1;
        oIX0oI[] oix0oiArr = new oIX0oI[2];
        this.f28783OOXIXo = oix0oiArr;
        oix0oiArr[0] = new oIX0oI(i2, i3, i4, i5, i6);
        this.f28783OOXIXo[1] = new oIX0oI(i2, i7, i8, i9, i10);
    }
}
