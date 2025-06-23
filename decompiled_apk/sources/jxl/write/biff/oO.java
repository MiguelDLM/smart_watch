package jxl.write.biff;

import com.realsil.sdk.dfu.image.constants.SubBinId;

/* loaded from: classes6.dex */
public class oO extends OoIXo.OI0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f28839II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f28840OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public OoIXo.XX f28841Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f28842X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28843XO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f28844oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public boolean f28845xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f28846xxIXOIIO;

    public oO(int i, int i2, OoIXo.XX xx2) {
        super(OoIXo.xII.f2456OxxIIOOXO);
        this.f28843XO = i;
        this.f28846xxIXOIIO = i2;
        this.f28841Oxx0IOOO = xx2;
        this.f28839II0XooXoX = xx2.XoI0Ixx0();
        this.f28845xoIox = false;
    }

    public void I0X0x0oIo() {
        int i = this.f28840OOXIXo;
        if (i > 0) {
            this.f28840OOXIXo = i - 1;
        }
        if (this.f28840OOXIXo == 0) {
            this.f28844oOoXoXO = false;
        }
    }

    public int I0oOIX() {
        return this.f28846xxIXOIIO;
    }

    public void IoOoo() {
        this.f28840OOXIXo++;
    }

    public void Ioxxx(int i) {
        this.f28840OOXIXo = i;
    }

    public int O0Xx() {
        return this.f28840OOXIXo;
    }

    public void OO() {
        this.f28843XO++;
    }

    public void OO0x0xX(boolean z) {
        this.f28844oOoXoXO = z;
    }

    public void XIo0oOXIx(boolean z) {
        this.f28845xoIox = z;
    }

    public void XX0() {
        this.f28843XO--;
    }

    public boolean Xo0() {
        return this.f28844oOoXoXO;
    }

    public boolean XoI0Ixx0() {
        return this.f28845xoIox;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oO)) {
            return false;
        }
        oO oOVar = (oO) obj;
        if (this.f28843XO != oOVar.f28843XO || this.f28839II0XooXoX != oOVar.f28839II0XooXoX || this.f28846xxIXOIIO != oOVar.f28846xxIXOIIO || this.f28845xoIox != oOVar.f28845xoIox || this.f28840OOXIXo != oOVar.f28840OOXIXo || this.f28844oOoXoXO != oOVar.f28844oOoXoXO) {
            return false;
        }
        OoIXo.XX xx2 = this.f28841Oxx0IOOO;
        if ((xx2 == null && oOVar.f28841Oxx0IOOO != null) || (xx2 != null && oOVar.f28841Oxx0IOOO == null)) {
            return false;
        }
        return xx2.equals(oOVar.f28841Oxx0IOOO);
    }

    public int hashCode() {
        int i = ((((((10823 + this.f28843XO) * 79) + this.f28839II0XooXoX) * 79) + this.f28846xxIXOIIO) * 79) + (this.f28845xoIox ? 1 : 0);
        OoIXo.XX xx2 = this.f28841Oxx0IOOO;
        if (xx2 != null) {
            return i ^ xx2.hashCode();
        }
        return i;
    }

    public int oIX0oI() {
        return this.f28843XO;
    }

    public OoIXo.XX oX() {
        return this.f28841Oxx0IOOO;
    }

    public void x0xO(OoIXo.XX xx2) {
        this.f28841Oxx0IOOO = xx2;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[12];
        this.f28842X0o0xo = bArr;
        OoIXo.oo0xXOI0I.XO(this.f28843XO, bArr, 0);
        OoIXo.oo0xXOI0I.XO(this.f28843XO, this.f28842X0o0xo, 2);
        OoIXo.oo0xXOI0I.XO(this.f28846xxIXOIIO, this.f28842X0o0xo, 4);
        OoIXo.oo0xXOI0I.XO(this.f28839II0XooXoX, this.f28842X0o0xo, 6);
        int i = this.f28840OOXIXo << 8;
        int i2 = i | 6;
        if (this.f28845xoIox) {
            i2 = i | 7;
        }
        this.f28840OOXIXo = (i2 & SubBinId.Bbpro.SECURE_BOOT_LOADER_IMAGE) / 256;
        if (this.f28844oOoXoXO) {
            i2 |= 4096;
        }
        OoIXo.oo0xXOI0I.XO(i2, this.f28842X0o0xo, 8);
        return this.f28842X0o0xo;
    }

    public void xoIxX(OoIXo.xI xIVar) {
        this.f28839II0XooXoX = xIVar.oIX0oI(this.f28839II0XooXoX);
    }

    public int xoxXI() {
        return this.f28839II0XooXoX;
    }

    public void xxIO(int i) {
        this.f28846xxIXOIIO = i;
    }

    public oO(oO oOVar) {
        super(OoIXo.xII.f2456OxxIIOOXO);
        this.f28843XO = oOVar.f28843XO;
        this.f28846xxIXOIIO = oOVar.f28846xxIXOIIO;
        this.f28841Oxx0IOOO = oOVar.f28841Oxx0IOOO;
        this.f28839II0XooXoX = oOVar.f28839II0XooXoX;
        this.f28845xoIox = oOVar.f28845xoIox;
        this.f28840OOXIXo = oOVar.f28840OOXIXo;
        this.f28844oOoXoXO = oOVar.f28844oOoXoXO;
    }

    public oO(jxl.read.biff.oO oOVar, int i, OoIXo.xXxxox0I xxxxox0i) {
        super(OoIXo.xII.f2456OxxIIOOXO);
        this.f28843XO = i;
        this.f28846xxIXOIIO = oOVar.Xo0();
        int XoI0Ixx02 = oOVar.XoI0Ixx0();
        this.f28839II0XooXoX = XoI0Ixx02;
        this.f28841Oxx0IOOO = xxxxox0i.xoIox(XoI0Ixx02);
        this.f28840OOXIXo = oOVar.I0X0x0oIo();
        this.f28844oOoXoXO = oOVar.xo0x();
    }

    public oO(jxl.read.biff.oO oOVar, int i) {
        super(OoIXo.xII.f2456OxxIIOOXO);
        this.f28843XO = i;
        this.f28846xxIXOIIO = oOVar.Xo0();
        this.f28839II0XooXoX = oOVar.XoI0Ixx0();
        this.f28840OOXIXo = oOVar.I0X0x0oIo();
        this.f28844oOoXoXO = oOVar.xo0x();
    }
}
