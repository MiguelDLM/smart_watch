package jxl.read.biff;

import OoIXo.X0o0xo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public final class x0xO0oo extends OoIXo.X0o0xo {

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28477XOxIOxOx = XxIIOXIXx.X0o0xo.Oxx0IOOO(x0xO0oo.class);

    /* renamed from: IIX0o, reason: collision with root package name */
    public int f28478IIX0o;

    /* renamed from: IO, reason: collision with root package name */
    public ArrayList f28479IO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public byte[] f28480IoOoX;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int[] f28481X00IoxXI;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int[] f28482Xx000oIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int[] f28483oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f28484oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f28485oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f28486ooXIXxIX;

    /* renamed from: x0o, reason: collision with root package name */
    public X0o0xo.oIX0oI f28487x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f28488xI;

    /* renamed from: xII, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28489xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public byte[] f28490xXxxox0I;

    public x0xO0oo(byte[] bArr, xIoXXXIXo.O0xOxO o0xOxO) throws BiffException {
        int i;
        this.f28490xXxxox0I = bArr;
        this.f28489xII = o0xOxO;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr2 = OoIXo.X0o0xo.f2189II0xO0;
            if (i3 < bArr2.length) {
                if (this.f28490xXxxox0I[i3] == bArr2[i3]) {
                    i3++;
                } else {
                    throw new BiffException(BiffException.unrecognizedOLEFile);
                }
            } else {
                this.f28479IO = new ArrayList();
                byte[] bArr3 = this.f28490xXxxox0I;
                this.f28478IIX0o = OoIXo.oo0xXOI0I.oxoX(bArr3[44], bArr3[45], bArr3[46], bArr3[47]);
                byte[] bArr4 = this.f28490xXxxox0I;
                this.f28486ooXIXxIX = OoIXo.oo0xXOI0I.oxoX(bArr4[60], bArr4[61], bArr4[62], bArr4[63]);
                byte[] bArr5 = this.f28490xXxxox0I;
                this.f28488xI = OoIXo.oo0xXOI0I.oxoX(bArr5[48], bArr5[49], bArr5[50], bArr5[51]);
                byte[] bArr6 = this.f28490xXxxox0I;
                this.f28485oo0xXOI0I = OoIXo.oo0xXOI0I.oxoX(bArr6[68], bArr6[69], bArr6[70], bArr6[71]);
                byte[] bArr7 = this.f28490xXxxox0I;
                int oxoX2 = OoIXo.oo0xXOI0I.oxoX(bArr7[72], bArr7[73], bArr7[74], bArr7[75]);
                this.f28484oo = oxoX2;
                int i4 = this.f28478IIX0o;
                this.f28481X00IoxXI = new int[i4];
                i4 = oxoX2 != 0 ? 109 : i4;
                int i5 = 76;
                for (int i6 = 0; i6 < i4; i6++) {
                    this.f28481X00IoxXI[i6] = OoIXo.oo0xXOI0I.oxoX(bArr[i5], bArr[i5 + 1], bArr[i5 + 2], bArr[i5 + 3]);
                    i5 += 4;
                }
                while (i2 < this.f28484oo) {
                    int i7 = (this.f28485oo0xXOI0I + 1) * 512;
                    int min = Math.min(this.f28478IIX0o - i4, 127);
                    int i8 = i4;
                    while (true) {
                        i = i4 + min;
                        if (i8 >= i) {
                            break;
                        }
                        this.f28481X00IoxXI[i8] = OoIXo.oo0xXOI0I.oxoX(bArr[i7], bArr[i7 + 1], bArr[i7 + 2], bArr[i7 + 3]);
                        i7 += 4;
                        i8++;
                    }
                    if (i < this.f28478IIX0o) {
                        this.f28485oo0xXOI0I = OoIXo.oo0xXOI0I.oxoX(bArr[i7], bArr[i7 + 1], bArr[i7 + 2], bArr[i7 + 3]);
                    }
                    i2++;
                    i4 = i;
                }
                oOoXoXO();
                oO();
                this.f28480IoOoX = ooOOo0oXI(this.f28488xI);
                x0XOIxOo();
                return;
            }
        }
    }

    public final X0o0xo.oIX0oI I0Io(String str, X0o0xo.oIX0oI oix0oi) {
        int i = oix0oi.f2219II0XooXoX;
        if (i == -1) {
            return null;
        }
        X0o0xo.oIX0oI Oxx0IOOO2 = Oxx0IOOO(i);
        if (Oxx0IOOO2.f2224oIX0oI.equalsIgnoreCase(str)) {
            return Oxx0IOOO2;
        }
        X0o0xo.oIX0oI oix0oi2 = Oxx0IOOO2;
        do {
            int i2 = oix0oi2.f2223XO;
            if (i2 != -1) {
                oix0oi2 = Oxx0IOOO(i2);
            } else {
                X0o0xo.oIX0oI oix0oi3 = Oxx0IOOO2;
                do {
                    int i3 = oix0oi3.f2221Oxx0IOOO;
                    if (i3 != -1) {
                        oix0oi3 = Oxx0IOOO(i3);
                    } else {
                        return I0Io(str, Oxx0IOOO2);
                    }
                } while (!oix0oi3.f2224oIX0oI.equalsIgnoreCase(str));
                return oix0oi3;
            }
        } while (!oix0oi2.f2224oIX0oI.equalsIgnoreCase(str));
        return oix0oi2;
    }

    public final X0o0xo.oIX0oI II0XooXoX(String str) throws BiffException {
        Iterator it = this.f28479IO.iterator();
        X0o0xo.oIX0oI oix0oi = null;
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            X0o0xo.oIX0oI oix0oi2 = (X0o0xo.oIX0oI) it.next();
            if (oix0oi2.f2224oIX0oI.equalsIgnoreCase(str)) {
                if (z2) {
                    z = true;
                } else {
                    z = false;
                }
                oix0oi = oix0oi2;
                z2 = true;
            }
        }
        if (z) {
            f28477XOxIOxOx.ooOOo0oXI("found multiple copies of property set " + str);
        }
        if (z2) {
            return oix0oi;
        }
        throw new BiffException(BiffException.streamNotFound);
    }

    public X0o0xo.oIX0oI II0xO0(String str) {
        return I0Io(str, this.f28487x0o);
    }

    public byte[] OOXIXo(String str) throws BiffException {
        X0o0xo.oIX0oI I0Io2 = I0Io(str, this.f28487x0o);
        if (I0Io2 == null) {
            I0Io2 = II0XooXoX(str);
        }
        if (I0Io2.f2222X0o0xo < 4096 && !str.equalsIgnoreCase(OoIXo.X0o0xo.f2190IIXOooo)) {
            return xxIXOIIO(I0Io2);
        }
        return oxoX(I0Io2);
    }

    public final X0o0xo.oIX0oI Oxx0IOOO(int i) {
        return (X0o0xo.oIX0oI) this.f28479IO.get(i);
    }

    public int X0o0xo() {
        return this.f28479IO.size();
    }

    public X0o0xo.oIX0oI XO(int i) {
        return Oxx0IOOO(i);
    }

    public final void oO() throws BiffException {
        int[] iArr;
        int i = this.f28486ooXIXxIX;
        this.f28482Xx000oIo = new int[0];
        if (i == -1) {
            f28477XOxIOxOx.ooOOo0oXI("invalid small block depot number");
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            iArr = this.f28483oOXoIIIo;
            if (i2 > iArr.length || i == -2) {
                break;
            }
            int[] iArr2 = this.f28482Xx000oIo;
            int[] iArr3 = new int[iArr2.length + 128];
            this.f28482Xx000oIo = iArr3;
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            int i4 = (i + 1) * 512;
            for (int i5 = 0; i5 < 128; i5++) {
                int[] iArr4 = this.f28482Xx000oIo;
                byte[] bArr = this.f28490xXxxox0I;
                iArr4[i3] = OoIXo.oo0xXOI0I.oxoX(bArr[i4], bArr[i4 + 1], bArr[i4 + 2], bArr[i4 + 3]);
                i4 += 4;
                i3++;
            }
            i = this.f28483oOXoIIIo[i];
            i2++;
        }
        if (i2 > iArr.length) {
            throw new BiffException(BiffException.corruptFileFormat);
        }
    }

    public final void oOoXoXO() {
        this.f28483oOXoIIIo = new int[(this.f28478IIX0o * 512) / 4];
        int i = 0;
        for (int i2 = 0; i2 < this.f28478IIX0o; i2++) {
            int i3 = (this.f28481X00IoxXI[i2] + 1) * 512;
            for (int i4 = 0; i4 < 128; i4++) {
                int[] iArr = this.f28483oOXoIIIo;
                byte[] bArr = this.f28490xXxxox0I;
                iArr[i] = OoIXo.oo0xXOI0I.oxoX(bArr[i3], bArr[i3 + 1], bArr[i3 + 2], bArr[i3 + 3]);
                i3 += 4;
                i++;
            }
        }
    }

    public final byte[] ooOOo0oXI(int i) throws BiffException {
        int[] iArr;
        byte[] bArr = new byte[0];
        int i2 = 0;
        while (true) {
            iArr = this.f28483oOXoIIIo;
            if (i2 > iArr.length || i == -2) {
                break;
            }
            byte[] bArr2 = new byte[bArr.length + 512];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(this.f28490xXxxox0I, (i + 1) * 512, bArr2, bArr.length, 512);
            int i3 = this.f28483oOXoIIIo[i];
            if (i3 != i) {
                i2++;
                i = i3;
                bArr = bArr2;
            } else {
                throw new BiffException(BiffException.corruptFileFormat);
            }
        }
        if (i2 <= iArr.length) {
            return bArr;
        }
        throw new BiffException(BiffException.corruptFileFormat);
    }

    public final byte[] oxoX(X0o0xo.oIX0oI oix0oi) {
        int i = oix0oi.f2222X0o0xo;
        int i2 = i / 512;
        if (i % 512 != 0) {
            i2++;
        }
        byte[] bArr = new byte[i2 * 512];
        int i3 = oix0oi.f2225oxoX;
        int i4 = 0;
        while (i3 != -2 && i4 < i2) {
            System.arraycopy(this.f28490xXxxox0I, (i3 + 1) * 512, bArr, i4 * 512, 512);
            i4++;
            i3 = this.f28483oOXoIIIo[i3];
        }
        if (i3 != -2 && i4 == i2) {
            f28477XOxIOxOx.ooOOo0oXI("Property storage size inconsistent with block chain.");
        }
        return bArr;
    }

    public final void x0XOIxOo() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f28480IoOoX;
            if (i >= bArr.length) {
                break;
            }
            byte[] bArr2 = new byte[128];
            System.arraycopy(bArr, i, bArr2, 0, 128);
            X0o0xo.oIX0oI oix0oi = new X0o0xo.oIX0oI(bArr2);
            String str = oix0oi.f2224oIX0oI;
            if (str == null || str.length() == 0) {
                if (oix0oi.f2220II0xO0 == 5) {
                    oix0oi.f2224oIX0oI = OoIXo.X0o0xo.f2190IIXOooo;
                    f28477XOxIOxOx.ooOOo0oXI("Property storage name for " + oix0oi.f2220II0xO0 + " is empty - setting to " + OoIXo.X0o0xo.f2190IIXOooo);
                } else if (oix0oi.f2222X0o0xo != 0) {
                    f28477XOxIOxOx.ooOOo0oXI("Property storage type " + oix0oi.f2220II0xO0 + " is non-empty and has no associated name");
                }
            }
            this.f28479IO.add(oix0oi);
            if (oix0oi.f2224oIX0oI.equalsIgnoreCase(OoIXo.X0o0xo.f2190IIXOooo)) {
                this.f28487x0o = oix0oi;
            }
            i += 128;
        }
        if (this.f28487x0o == null) {
            this.f28487x0o = (X0o0xo.oIX0oI) this.f28479IO.get(0);
        }
    }

    public byte[] xoIox(int i) throws BiffException {
        X0o0xo.oIX0oI Oxx0IOOO2 = Oxx0IOOO(i);
        if (Oxx0IOOO2.f2222X0o0xo < 4096 && !Oxx0IOOO2.f2224oIX0oI.equalsIgnoreCase(OoIXo.X0o0xo.f2190IIXOooo)) {
            return xxIXOIIO(Oxx0IOOO2);
        }
        return oxoX(Oxx0IOOO2);
    }

    public final byte[] xxIXOIIO(X0o0xo.oIX0oI oix0oi) throws BiffException {
        int[] iArr;
        byte[] ooOOo0oXI2 = ooOOo0oXI(this.f28487x0o.f2225oxoX);
        byte[] bArr = new byte[0];
        int i = oix0oi.f2225oxoX;
        int i2 = 0;
        while (true) {
            iArr = this.f28482Xx000oIo;
            if (i2 > iArr.length || i == -2) {
                break;
            }
            byte[] bArr2 = new byte[bArr.length + 64];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(ooOOo0oXI2, i * 64, bArr2, bArr.length, 64);
            int i3 = this.f28482Xx000oIo[i];
            if (i3 == -1) {
                f28477XOxIOxOx.ooOOo0oXI("Incorrect terminator for small block stream " + oix0oi.f2224oIX0oI);
                i = -2;
            } else {
                i = i3;
            }
            i2++;
            bArr = bArr2;
        }
        if (i2 <= iArr.length) {
            return bArr;
        }
        throw new BiffException(BiffException.corruptFileFormat);
    }
}
