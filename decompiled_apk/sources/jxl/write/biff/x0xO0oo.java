package jxl.write.biff;

import OoIXo.X0o0xo;
import com.google.android.exoplayer2.RendererCapabilities;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import jxl.read.biff.BiffException;

/* loaded from: classes6.dex */
public final class x0xO0oo extends OoIXo.X0o0xo {

    /* renamed from: xXOx, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28972xXOx = XxIIOXIXx.X0o0xo.Oxx0IOOO(x0xO0oo.class);

    /* renamed from: I0oOoX, reason: collision with root package name */
    public int f28973I0oOoX;

    /* renamed from: IIX0o, reason: collision with root package name */
    public XIxXXX0x0 f28974IIX0o;

    /* renamed from: IO, reason: collision with root package name */
    public int f28975IO;

    /* renamed from: Io, reason: collision with root package name */
    public int f28976Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f28977IoOoX;

    /* renamed from: OI0, reason: collision with root package name */
    public int f28978OI0;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int f28979X00IoxXI;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public int f28980XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public int f28981XX;

    /* renamed from: XoX, reason: collision with root package name */
    public HashMap f28982XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public int f28983Xx000oIo;

    /* renamed from: o0, reason: collision with root package name */
    public int f28984o0;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f28985oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public int f28986oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f28987oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public int f28988ooXIXxIX;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public int f28989oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public ArrayList f28990oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public int f28991x0o;

    /* renamed from: xI, reason: collision with root package name */
    public int f28992xI;

    /* renamed from: xII, reason: collision with root package name */
    public int f28993xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public OutputStream f28994xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    public byte[] f28995xo0x;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f28996I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public byte[] f28997II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public X0o0xo.oIX0oI f28998oIX0oI;

        public oIX0oI(X0o0xo.oIX0oI oix0oi, byte[] bArr, int i) {
            this.f28998oIX0oI = oix0oi;
            this.f28997II0xO0 = bArr;
            this.f28996I0Io = i;
        }
    }

    public x0xO0oo(XIxXXX0x0 xIxXXX0x0, int i, OutputStream outputStream, jxl.read.biff.x0xO0oo x0xo0oo) throws CopyAdditionalPropertySetsException, IOException {
        int i2;
        this.f28988ooXIXxIX = i;
        this.f28974IIX0o = xIxXXX0x0;
        X0o0xo(x0xo0oo);
        this.f28973I0oOoX = 1;
        ArrayList arrayList = this.f28990oxxXoxO;
        if (arrayList != null) {
            i2 = arrayList.size();
        } else {
            i2 = 0;
        }
        this.f28981XX = i2 + 4;
        if (this.f28990oxxXoxO != null) {
            this.f28986oo = I0Io(this.f28984o0 * 4);
            this.f28977IoOoX = I0Io(this.f28984o0 * 64);
            this.f28973I0oOoX += I0Io(this.f28990oxxXoxO.size() * 128);
        }
        int I0Io2 = I0Io(i);
        if (i < 4096) {
            this.f28992xI = 4096;
        } else {
            this.f28992xI = I0Io2 * 512;
        }
        this.f28994xXxxox0I = outputStream;
        int i3 = this.f28992xI / 512;
        this.f28979X00IoxXI = i3;
        this.f28987oo0xXOI0I = 1;
        int i4 = i3 + 16 + this.f28976Io + this.f28977IoOoX + this.f28986oo + this.f28973I0oOoX;
        this.f28987oo0xXOI0I = (int) Math.ceil((i4 + 1) / 128.0d);
        int ceil = (int) Math.ceil((r7 + i4) / 128.0d);
        this.f28987oo0xXOI0I = ceil;
        int i5 = i4 + ceil;
        if (ceil > 108) {
            this.f28983Xx000oIo = 0;
            this.f28985oOXoIIIo = (int) Math.ceil((ceil - 108) / 127.0d);
            int ceil2 = (int) Math.ceil(((r7 + i4) + this.f28987oo0xXOI0I) / 128.0d);
            this.f28987oo0xXOI0I = ceil2;
            i5 = i4 + this.f28985oOXoIIIo + ceil2;
        } else {
            this.f28983Xx000oIo = -2;
            this.f28985oOXoIIIo = 0;
        }
        int i6 = this.f28985oOXoIIIo;
        this.f28993xII = i6;
        this.f28978OI0 = -2;
        if (this.f28990oxxXoxO != null && this.f28977IoOoX != 0) {
            this.f28978OI0 = this.f28979X00IoxXI + i6 + this.f28976Io + 16;
        }
        this.f28980XOxIOxOx = -2;
        int i7 = this.f28978OI0;
        if (i7 != -2) {
            this.f28980XOxIOxOx = i7 + this.f28977IoOoX;
        }
        int i8 = this.f28980XOxIOxOx;
        if (i8 != -2) {
            this.f28991x0o = i8 + this.f28986oo;
        } else {
            this.f28991x0o = i6 + this.f28979X00IoxXI + this.f28976Io + 16;
        }
        int i9 = this.f28991x0o + this.f28987oo0xXOI0I;
        this.f28975IO = i9;
        if (i5 != i9 + this.f28973I0oOoX) {
            f28972xXOx.ooOOo0oXI("Root start block and total blocks are inconsistent  generated file may be corrupt");
            f28972xXOx.ooOOo0oXI("RootStartBlock " + this.f28975IO + " totalBlocks " + i5);
        }
    }

    public final int I0Io(int i) {
        int i2 = i / 512;
        if (i % 512 > 0) {
            return i2 + 1;
        }
        return i2;
    }

    public final void II0XooXoX() throws IOException {
        ArrayList arrayList = this.f28990oxxXoxO;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            byte[] bArr = ((oIX0oI) it.next()).f28997II0xO0;
            if (bArr.length > 4096) {
                int I0Io2 = I0Io(bArr.length) * 512;
                this.f28994xXxxox0I.write(bArr, 0, bArr.length);
                int length = I0Io2 - bArr.length;
                this.f28994xXxxox0I.write(new byte[length], 0, length);
            }
        }
    }

    public final void II0xO0() throws IOException {
        if (this.f28989oxXx0IX >= 512) {
            this.f28994xXxxox0I.write(this.f28995xo0x);
            this.f28995xo0x = new byte[512];
            this.f28989oxXx0IX = 0;
        }
    }

    public final void OOXIXo() throws IOException {
        this.f28994xXxxox0I.write(new byte[4096]);
    }

    public final void Oo() throws IOException {
        this.f28994xXxxox0I.write(new byte[4096]);
    }

    public final void Oxx0IOOO() throws IOException {
        ArrayList arrayList = this.f28990oxxXoxO;
        if (arrayList == null) {
            return;
        }
        int i = this.f28993xII + this.f28979X00IoxXI + 16;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            byte[] bArr = ((oIX0oI) it.next()).f28997II0xO0;
            if (bArr.length > 4096) {
                int I0Io2 = I0Io(bArr.length);
                xoIox(i, I0Io2);
                i += I0Io2;
            }
        }
    }

    public final void X0o0xo(jxl.read.biff.x0xO0oo x0xo0oo) throws CopyAdditionalPropertySetsException, IOException {
        boolean z;
        byte[] bArr;
        boolean z2;
        if (x0xo0oo == null) {
            return;
        }
        this.f28990oxxXoxO = new ArrayList();
        this.f28982XoX = new HashMap();
        int X0o0xo2 = x0xo0oo.X0o0xo();
        int i = 0;
        for (int i2 = 0; i2 < X0o0xo2; i2++) {
            X0o0xo.oIX0oI XO2 = x0xo0oo.XO(i2);
            if (XO2.f2224oIX0oI.equalsIgnoreCase(OoIXo.X0o0xo.f2190IIXOooo)) {
                this.f28982XoX.put(OoIXo.X0o0xo.f2190IIXOooo, new oIX0oI(XO2, null, i2));
                z = true;
            } else {
                z = false;
            }
            int i3 = 0;
            while (true) {
                String[] strArr = OoIXo.X0o0xo.f2199X0IIOO;
                if (i3 >= strArr.length || z) {
                    break;
                }
                if (XO2.f2224oIX0oI.equalsIgnoreCase(strArr[i3])) {
                    X0o0xo.oIX0oI II0xO02 = x0xo0oo.II0xO0(XO2.f2224oIX0oI);
                    if (II0xO02 != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    XxIIOXIXx.oIX0oI.oIX0oI(z2);
                    if (II0xO02 == XO2) {
                        this.f28982XoX.put(strArr[i3], new oIX0oI(XO2, null, i2));
                        z = true;
                    }
                }
                i3++;
            }
            if (!z) {
                try {
                    if (XO2.f2222X0o0xo > 0) {
                        bArr = x0xo0oo.xoIox(i2);
                    } else {
                        bArr = new byte[0];
                    }
                    this.f28990oxxXoxO.add(new oIX0oI(XO2, bArr, i2));
                    if (bArr.length > 4096) {
                        i += I0Io(bArr.length);
                    } else {
                        this.f28984o0 += oxoX(bArr.length);
                    }
                } catch (BiffException e) {
                    f28972xXOx.I0Io(e);
                    throw new CopyAdditionalPropertySetsException();
                }
            }
        }
        this.f28976Io = i;
    }

    public void XO() throws IOException {
        ooOOo0oXI();
        oOoXoXO();
        OOXIXo();
        Oo();
        II0XooXoX();
        oO();
        x0xO0oo();
        xxIXOIIO();
        x0XOIxOo();
    }

    public final void oO() throws IOException {
        ArrayList arrayList = this.f28990oxxXoxO;
        if (arrayList == null) {
            return;
        }
        byte[] bArr = new byte[this.f28977IoOoX * 512];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            oIX0oI oix0oi = (oIX0oI) it.next();
            byte[] bArr2 = oix0oi.f28997II0xO0;
            if (bArr2.length <= 4096) {
                int oxoX2 = oxoX(bArr2.length) * 64;
                byte[] bArr3 = oix0oi.f28997II0xO0;
                System.arraycopy(bArr3, 0, bArr, i, bArr3.length);
                i += oxoX2;
            }
        }
        this.f28994xXxxox0I.write(bArr);
    }

    public final void oOoXoXO() throws IOException {
        this.f28974IIX0o.II0xO0(this.f28994xXxxox0I);
        this.f28994xXxxox0I.write(new byte[this.f28992xI - this.f28988ooXIXxIX]);
    }

    public final void ooOOo0oXI() throws IOException {
        int i;
        int i2;
        byte[] bArr = new byte[512];
        int i3 = this.f28985oOXoIIIo * 512;
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = OoIXo.X0o0xo.f2189II0xO0;
        System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
        bArr[24] = 62;
        bArr[26] = 3;
        bArr[28] = -2;
        bArr[29] = -1;
        bArr[30] = 9;
        bArr[32] = 6;
        bArr[57] = 16;
        OoIXo.oo0xXOI0I.oIX0oI(this.f28987oo0xXOI0I, bArr, 44);
        OoIXo.oo0xXOI0I.oIX0oI(this.f28980XOxIOxOx, bArr, 60);
        OoIXo.oo0xXOI0I.oIX0oI(this.f28986oo, bArr, 64);
        OoIXo.oo0xXOI0I.oIX0oI(this.f28983Xx000oIo, bArr, 68);
        OoIXo.oo0xXOI0I.oIX0oI(this.f28985oOXoIIIo, bArr, 72);
        OoIXo.oo0xXOI0I.oIX0oI(this.f28975IO, bArr, 48);
        int min = Math.min(this.f28987oo0xXOI0I, 109);
        int i4 = 76;
        int i5 = 0;
        for (int i6 = 0; i6 < min; i6++) {
            OoIXo.oo0xXOI0I.oIX0oI(this.f28991x0o + i6, bArr, i4);
            i4 += 4;
            i5++;
        }
        while (i4 < 512) {
            bArr[i4] = -1;
            i4++;
        }
        this.f28994xXxxox0I.write(bArr);
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i = this.f28985oOXoIIIo;
            if (i7 >= i) {
                break;
            }
            int min2 = Math.min(this.f28987oo0xXOI0I - i5, 127);
            for (int i9 = 0; i9 < min2; i9++) {
                OoIXo.oo0xXOI0I.oIX0oI(this.f28991x0o + i5 + i9, bArr2, i8);
                i8 += 4;
            }
            i5 += min2;
            if (i5 == this.f28987oo0xXOI0I) {
                i2 = -2;
            } else {
                i2 = i7 + 1;
            }
            OoIXo.oo0xXOI0I.oIX0oI(i2, bArr2, i8);
            i8 += 4;
            i7++;
        }
        if (i > 0) {
            while (i8 < i3) {
                bArr2[i8] = -1;
                i8++;
            }
            this.f28994xXxxox0I.write(bArr2);
        }
    }

    public final int oxoX(int i) {
        int i2 = i / 64;
        if (i % 64 > 0) {
            return i2 + 1;
        }
        return i2;
    }

    public final void x0XOIxOo() throws IOException {
        int[] iArr;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        oIX0oI oix0oi;
        int i9;
        int oxoX2;
        String[] strArr;
        int i10 = 512;
        byte[] bArr = new byte[this.f28973I0oOoX * 512];
        int i11 = 1;
        if (this.f28990oxxXoxO != null) {
            iArr = new int[this.f28981XX];
            int i12 = 0;
            while (true) {
                strArr = OoIXo.X0o0xo.f2199X0IIOO;
                if (i12 >= strArr.length) {
                    break;
                }
                oIX0oI oix0oi2 = (oIX0oI) this.f28982XoX.get(strArr[i12]);
                if (oix0oi2 != null) {
                    iArr[oix0oi2.f28996I0Io] = i12;
                } else {
                    f28972xXOx.ooOOo0oXI("Standard property set " + strArr[i12] + " not present in source file");
                }
                i12++;
            }
            int length = strArr.length;
            Iterator it = this.f28990oxxXoxO.iterator();
            while (it.hasNext()) {
                iArr[((oIX0oI) it.next()).f28996I0Io] = length;
                length++;
            }
        } else {
            iArr = null;
        }
        if (this.f28990oxxXoxO != null) {
            i = (I0Io(this.f28992xI) * 512) + (I0Io(4096) * 512) + (I0Io(4096) * 512);
            Iterator it2 = this.f28990oxxXoxO.iterator();
            while (it2.hasNext()) {
                X0o0xo.oIX0oI oix0oi3 = ((oIX0oI) it2.next()).f28998oIX0oI;
                if (oix0oi3.f2220II0xO0 != 1) {
                    int i13 = oix0oi3.f2222X0o0xo;
                    if (i13 >= 4096) {
                        oxoX2 = I0Io(i13) * 512;
                    } else {
                        oxoX2 = oxoX(i13) * 64;
                    }
                    i += oxoX2;
                }
            }
        } else {
            i = 0;
        }
        X0o0xo.oIX0oI oix0oi4 = new X0o0xo.oIX0oI(OoIXo.X0o0xo.f2190IIXOooo);
        oix0oi4.Oxx0IOOO(5);
        oix0oi4.XO(this.f28978OI0);
        oix0oi4.X0o0xo(i);
        oix0oi4.oxoX(-1);
        oix0oi4.I0Io(-1);
        oix0oi4.II0xO0(0);
        if (this.f28990oxxXoxO != null) {
            i2 = iArr[((oIX0oI) this.f28982XoX.get(OoIXo.X0o0xo.f2190IIXOooo)).f28998oIX0oI.f2219II0XooXoX];
        } else {
            i2 = 1;
        }
        oix0oi4.oIX0oI(i2);
        System.arraycopy(oix0oi4.f2227xxIXOIIO, 0, bArr, 0, 128);
        X0o0xo.oIX0oI oix0oi5 = new X0o0xo.oIX0oI(OoIXo.X0o0xo.f2215xoXoI);
        oix0oi5.Oxx0IOOO(2);
        oix0oi5.XO(this.f28993xII);
        oix0oi5.X0o0xo(this.f28992xI);
        int i14 = 3;
        if (this.f28990oxxXoxO != null) {
            X0o0xo.oIX0oI oix0oi6 = ((oIX0oI) this.f28982XoX.get(OoIXo.X0o0xo.f2215xoXoI)).f28998oIX0oI;
            int i15 = oix0oi6.f2223XO;
            if (i15 != -1) {
                i4 = iArr[i15];
            } else {
                i4 = -1;
            }
            int i16 = oix0oi6.f2221Oxx0IOOO;
            if (i16 != -1) {
                i3 = iArr[i16];
            } else {
                i3 = -1;
            }
        } else {
            i3 = -1;
            i4 = 3;
        }
        oix0oi5.oxoX(i4);
        oix0oi5.I0Io(i3);
        oix0oi5.oIX0oI(-1);
        System.arraycopy(oix0oi5.f2227xxIXOIIO, 0, bArr, 128, 128);
        X0o0xo.oIX0oI oix0oi7 = new X0o0xo.oIX0oI(OoIXo.X0o0xo.f2205o00);
        oix0oi7.Oxx0IOOO(2);
        oix0oi7.XO(this.f28993xII + this.f28979X00IoxXI);
        oix0oi7.X0o0xo(4096);
        if (this.f28990oxxXoxO != null && (oix0oi = (oIX0oI) this.f28982XoX.get(OoIXo.X0o0xo.f2205o00)) != null) {
            X0o0xo.oIX0oI oix0oi8 = oix0oi.f28998oIX0oI;
            int i17 = oix0oi8.f2223XO;
            if (i17 != -1) {
                i9 = iArr[i17];
            } else {
                i9 = -1;
            }
            int i18 = oix0oi8.f2221Oxx0IOOO;
            if (i18 != -1) {
                i14 = iArr[i18];
            } else {
                i14 = -1;
            }
            i11 = i9;
        }
        oix0oi7.oxoX(i11);
        oix0oi7.I0Io(i14);
        oix0oi7.oIX0oI(-1);
        System.arraycopy(oix0oi7.f2227xxIXOIIO, 0, bArr, 256, 128);
        X0o0xo.oIX0oI oix0oi9 = new X0o0xo.oIX0oI(OoIXo.X0o0xo.f2195OxI);
        oix0oi9.Oxx0IOOO(2);
        oix0oi9.XO(this.f28993xII + this.f28979X00IoxXI + 8);
        oix0oi9.X0o0xo(4096);
        oix0oi9.oxoX(-1);
        oix0oi9.I0Io(-1);
        oix0oi9.oIX0oI(-1);
        System.arraycopy(oix0oi9.f2227xxIXOIIO, 0, bArr, RendererCapabilities.MODE_SUPPORT_MASK, 128);
        ArrayList arrayList = this.f28990oxxXoxO;
        if (arrayList == null) {
            this.f28994xXxxox0I.write(bArr);
            return;
        }
        int i19 = this.f28993xII + this.f28979X00IoxXI + 16;
        Iterator it3 = arrayList.iterator();
        int i20 = 0;
        while (it3.hasNext()) {
            oIX0oI oix0oi10 = (oIX0oI) it3.next();
            if (oix0oi10.f28997II0xO0.length > 4096) {
                i5 = i19;
            } else {
                i5 = i20;
            }
            X0o0xo.oIX0oI oix0oi11 = new X0o0xo.oIX0oI(oix0oi10.f28998oIX0oI.f2224oIX0oI);
            oix0oi11.Oxx0IOOO(oix0oi10.f28998oIX0oI.f2220II0xO0);
            oix0oi11.XO(i5);
            oix0oi11.X0o0xo(oix0oi10.f28998oIX0oI.f2222X0o0xo);
            X0o0xo.oIX0oI oix0oi12 = oix0oi10.f28998oIX0oI;
            int i21 = oix0oi12.f2223XO;
            if (i21 != -1) {
                i6 = iArr[i21];
            } else {
                i6 = -1;
            }
            int i22 = oix0oi12.f2221Oxx0IOOO;
            if (i22 != -1) {
                i7 = iArr[i22];
            } else {
                i7 = -1;
            }
            int i23 = oix0oi12.f2219II0XooXoX;
            if (i23 != -1) {
                i8 = iArr[i23];
            } else {
                i8 = -1;
            }
            oix0oi11.oxoX(i6);
            oix0oi11.I0Io(i7);
            oix0oi11.oIX0oI(i8);
            System.arraycopy(oix0oi11.f2227xxIXOIIO, 0, bArr, i10, 128);
            i10 += 128;
            byte[] bArr2 = oix0oi10.f28997II0xO0;
            if (bArr2.length > 4096) {
                i19 += I0Io(bArr2.length);
            } else {
                i20 += oxoX(bArr2.length);
            }
        }
        this.f28994xXxxox0I.write(bArr);
    }

    public final void x0xO0oo() throws IOException {
        if (this.f28980XOxIOxOx == -2) {
            return;
        }
        byte[] bArr = new byte[this.f28986oo * 512];
        Iterator it = this.f28990oxxXoxO.iterator();
        int i = 0;
        int i2 = 1;
        while (it.hasNext()) {
            byte[] bArr2 = ((oIX0oI) it.next()).f28997II0xO0;
            if (bArr2.length <= 4096 && bArr2.length != 0) {
                int oxoX2 = oxoX(bArr2.length);
                for (int i3 = 0; i3 < oxoX2 - 1; i3++) {
                    OoIXo.oo0xXOI0I.oIX0oI(i2, bArr, i);
                    i += 4;
                    i2++;
                }
                OoIXo.oo0xXOI0I.oIX0oI(-2, bArr, i);
                i += 4;
                i2++;
            }
        }
        this.f28994xXxxox0I.write(bArr);
    }

    public final void xoIox(int i, int i2) throws IOException {
        int i3 = i2 - 1;
        int i4 = i + 1;
        while (i3 > 0) {
            int min = Math.min(i3, (512 - this.f28989oxXx0IX) / 4);
            for (int i5 = 0; i5 < min; i5++) {
                OoIXo.oo0xXOI0I.oIX0oI(i4, this.f28995xo0x, this.f28989oxXx0IX);
                this.f28989oxXx0IX += 4;
                i4++;
            }
            i3 -= min;
            II0xO0();
        }
        OoIXo.oo0xXOI0I.oIX0oI(-2, this.f28995xo0x, this.f28989oxXx0IX);
        this.f28989oxXx0IX += 4;
        II0xO0();
    }

    public final void xxIXOIIO() throws IOException {
        this.f28995xo0x = new byte[512];
        this.f28989oxXx0IX = 0;
        for (int i = 0; i < this.f28985oOXoIIIo; i++) {
            OoIXo.oo0xXOI0I.oIX0oI(-3, this.f28995xo0x, this.f28989oxXx0IX);
            this.f28989oxXx0IX += 4;
            II0xO0();
        }
        xoIox(this.f28993xII, this.f28979X00IoxXI);
        int i2 = this.f28993xII + this.f28979X00IoxXI + this.f28976Io;
        int i3 = i2;
        while (i3 < i2 + 7) {
            i3++;
            OoIXo.oo0xXOI0I.oIX0oI(i3, this.f28995xo0x, this.f28989oxXx0IX);
            this.f28989oxXx0IX += 4;
            II0xO0();
        }
        OoIXo.oo0xXOI0I.oIX0oI(-2, this.f28995xo0x, this.f28989oxXx0IX);
        this.f28989oxXx0IX += 4;
        II0xO0();
        int i4 = i2 + 8;
        while (i4 < i2 + 15) {
            i4++;
            OoIXo.oo0xXOI0I.oIX0oI(i4, this.f28995xo0x, this.f28989oxXx0IX);
            this.f28989oxXx0IX += 4;
            II0xO0();
        }
        OoIXo.oo0xXOI0I.oIX0oI(-2, this.f28995xo0x, this.f28989oxXx0IX);
        this.f28989oxXx0IX += 4;
        II0xO0();
        Oxx0IOOO();
        int i5 = this.f28978OI0;
        if (i5 != -2) {
            xoIox(i5, this.f28977IoOoX);
            xoIox(this.f28980XOxIOxOx, this.f28986oo);
        }
        for (int i6 = 0; i6 < this.f28987oo0xXOI0I; i6++) {
            OoIXo.oo0xXOI0I.oIX0oI(-3, this.f28995xo0x, this.f28989oxXx0IX);
            this.f28989oxXx0IX += 4;
            II0xO0();
        }
        xoIox(this.f28975IO, this.f28973I0oOoX);
        int i7 = this.f28989oxXx0IX;
        if (i7 != 0) {
            while (i7 < 512) {
                this.f28995xo0x[i7] = -1;
                i7++;
            }
            this.f28994xXxxox0I.write(this.f28995xo0x);
        }
    }
}
