package jxl.read.biff;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class XI0oooXX {

    /* renamed from: xoIox, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28268xoIox = XxIIOXIXx.X0o0xo.Oxx0IOOO(XI0oooXX.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public int f28269I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public jxl.biff.formula.OxxIIOOXO f28270II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f28271II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public byte[] f28272Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public II0xO0 f28273X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public ArrayList f28274XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f28275oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f28276oxoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public I0 f28277xxIXOIIO;

    public XI0oooXX(xoxXI xoxxi, II0xO0 iI0xO0, jxl.biff.formula.OxxIIOOXO oxxIIOOXO, OoIXo.x0o x0oVar, I0 i0) {
        this.f28277xxIXOIIO = i0;
        byte[] I0Io2 = xoxxi.I0Io();
        this.f28275oIX0oI = OoIXo.oo0xXOI0I.I0Io(I0Io2[0], I0Io2[1]);
        this.f28271II0xO0 = OoIXo.oo0xXOI0I.I0Io(I0Io2[2], I0Io2[3]);
        this.f28269I0Io = I0Io2[4] & 255;
        this.f28276oxoX = I0Io2[5] & 255;
        this.f28274XO = new ArrayList();
        this.f28273X0o0xo = iI0xO0;
        byte[] bArr = new byte[I0Io2.length - 10];
        this.f28272Oxx0IOOO = bArr;
        System.arraycopy(I0Io2, 10, bArr, 0, bArr.length);
    }

    public II0xO0 I0Io() {
        return this.f28273X0o0xo;
    }

    public xIoXXXIXo.I0Io[] II0xO0(OoIXo.xXxxox0I xxxxox0i, boolean z) {
        xIoXXXIXo.I0Io[] i0IoArr = new xIoXXXIXo.I0Io[this.f28274XO.size() + 1];
        II0xO0 iI0xO0 = this.f28273X0o0xo;
        int i = 0;
        if (iI0xO0 == null) {
            f28268xoIox.ooOOo0oXI("Shared formula template formula is null");
            return new xIoXXXIXo.I0Io[0];
        }
        iI0xO0.XoI0Ixx0(this.f28272Oxx0IOOO);
        if (this.f28273X0o0xo.getType() == xIoXXXIXo.Oxx0IOOO.f34236Oxx0IOOO) {
            OOXIxO0 oOXIxO0 = (OOXIxO0) this.f28273X0o0xo;
            oOXIxO0.X00IoxXI();
            if (xxxxox0i.OOXIXo(this.f28273X0o0xo.xXOx())) {
                o0xxxXXxX o0xxxxxxx = new o0xxxXXxX(oOXIxO0, xxxxox0i, z, this.f28277xxIXOIIO, oOXIxO0.I0X0x0oIo());
                this.f28273X0o0xo = o0xxxxxxx;
                o0xxxxxxx.XoI0Ixx0(oOXIxO0.Xo0());
            }
        }
        i0IoArr[0] = this.f28273X0o0xo;
        while (i < this.f28274XO.size()) {
            II0xO0 iI0xO02 = (II0xO0) this.f28274XO.get(i);
            if (iI0xO02.getType() == xIoXXXIXo.Oxx0IOOO.f34236Oxx0IOOO) {
                OOXIxO0 oOXIxO02 = (OOXIxO0) iI0xO02;
                if (xxxxox0i.OOXIXo(iI0xO02.xXOx())) {
                    iI0xO02 = new o0xxxXXxX(oOXIxO02, xxxxox0i, z, this.f28277xxIXOIIO, oOXIxO02.I0X0x0oIo());
                }
            }
            iI0xO02.XoI0Ixx0(this.f28272Oxx0IOOO);
            i++;
            i0IoArr[i] = iI0xO02;
        }
        return i0IoArr;
    }

    public boolean oIX0oI(II0xO0 iI0xO0) {
        int oIX0oI2;
        int II0xO02 = iI0xO0.II0xO0();
        if (II0xO02 >= this.f28275oIX0oI && II0xO02 <= this.f28271II0xO0 && (oIX0oI2 = iI0xO0.oIX0oI()) >= this.f28269I0Io && oIX0oI2 <= this.f28276oxoX) {
            this.f28274XO.add(iI0xO0);
            return true;
        }
        return false;
    }
}
