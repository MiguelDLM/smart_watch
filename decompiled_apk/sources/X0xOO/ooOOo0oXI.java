package X0xOO;

import com.garmin.fit.IXXIXx00I;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import java.io.IOException;

/* loaded from: classes6.dex */
public class ooOOo0oXI implements xoXoI {

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3516X0IIOO = XxIIOXIXx.X0o0xo.Oxx0IOOO(ooOOo0oXI.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public xXxxox0I f3517I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3518II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public OxI f3519II0xO0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public IIX0o f3520IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oOXoIIIo f3521IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f3522O0xOxO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public double f3523OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public OxxIIOOXO f3524Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public String f3525OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3526Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f3527Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public OI0 f3528OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f3529X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3530XO;

    /* renamed from: o00, reason: collision with root package name */
    public OoIXo.x0xO0oo f3531o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public xXxxox0I f3532oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OxI f3533oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public oo0xXOI0I f3534oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public double f3535oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f3536ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public ooXIXxIX f3537oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public OxI f3538x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public IIXOooo f3539x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f3540xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public OoIXo.x0xO0oo f3541xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f3542xxIXOIIO;

    public ooOOo0oXI(xXxxox0I xxxxox0i, ooXIXxIX ooxixxix, OxxIIOOXO oxxIIOOXO, IIXOooo iIXOooo, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f3539x0xO0oo = iIXOooo;
        this.f3517I0Io = xxxxox0i;
        this.f3524Oo = oxxIIOOXO;
        this.f3537oxoX = ooxixxix;
        boolean z = false;
        this.f3529X0o0xo = false;
        this.f3522O0xOxO = o0xOxO;
        this.f3534oO = oo0xXOI0I.f3515oIX0oI;
        oxxIIOOXO.oIX0oI(xxxxox0i.xo0x());
        this.f3527Oxx0xo = this.f3524Oo.I0Io() - 1;
        this.f3539x0xO0oo.XO(this);
        if (this.f3517I0Io != null && this.f3537oxoX != null) {
            z = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        if (this.f3529X0o0xo) {
            return;
        }
        OxxIIOOXO();
    }

    private void OxxIIOOXO() {
        boolean z;
        OxI oxoX2 = this.f3524Oo.oxoX(this.f3527Oxx0xo);
        this.f3533oIX0oI = oxoX2;
        if (oxoX2 != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        X0IIOO[] oO2 = this.f3533oIX0oI.oO();
        X00IoxXI x00IoxXI = (X00IoxXI) this.f3533oIX0oI.oO()[0];
        this.f3530XO = this.f3537oxoX.oX();
        this.f3518II0XooXoX = x00IoxXI.x0XOIxOo();
        oOXoIIIo oIX0oI2 = oOXoIIIo.oIX0oI(x00IoxXI.oO());
        this.f3521IXxxXO = oIX0oI2;
        if (oIX0oI2 == oOXoIIIo.f3487Oxx0IOOO) {
            f3516X0IIOO.ooOOo0oXI("Unknown shape type");
        }
        xxIXOIIO xxixoiio = null;
        for (int i = 0; i < oO2.length && xxixoiio == null; i++) {
            if (oO2[i].xxIXOIIO() == XIxXXX0x0.f3421oO) {
                xxixoiio = (xxIXOIIO) oO2[i];
            }
        }
        if (xxixoiio == null) {
            f3516X0IIOO.ooOOo0oXI("client anchor not found");
        } else {
            this.f3542xxIXOIIO = ((int) xxixoiio.oO()) - 1;
            this.f3540xoIox = ((int) xxixoiio.Oo()) + 1;
            this.f3523OOXIXo = xxixoiio.x0xO0oo() - xxixoiio.oO();
            this.f3535oOoXoXO = xxixoiio.IXxxXO() - xxixoiio.Oo();
        }
        this.f3529X0o0xo = true;
    }

    private OxI ooOOo0oXI() {
        if (!this.f3529X0o0xo) {
            OxxIIOOXO();
        }
        return this.f3533oIX0oI;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public byte[] I0Io() {
        boolean z;
        oo0xXOI0I oo0xxoi0i = this.f3534oO;
        if (oo0xxoi0i != oo0xXOI0I.f3515oIX0oI && oo0xxoi0i != oo0xXOI0I.f3513I0Io) {
            z = false;
        } else {
            z = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        if (!this.f3529X0o0xo) {
            OxxIIOOXO();
        }
        return this.f3539x0xO0oo.II0XooXoX(this.f3526Oxx0IOOO);
    }

    @Override // X0xOO.xoXoI
    public void II0XooXoX(int i) {
        this.f3536ooOOo0oXI = i;
    }

    public int II0xO0() {
        return this.f3520IIXOooo.oIX0oI();
    }

    public void IIX0o(OoIXo.x0xO0oo x0xo0oo) {
        this.f3541xoXoI = x0xo0oo;
    }

    @Override // X0xOO.xoXoI
    public void IIXOooo(IIXOooo iIXOooo) {
        this.f3539x0xO0oo = iIXOooo;
    }

    public String IXxxXO() {
        boolean z;
        if (this.f3525OxI == null) {
            if (this.f3541xoXoI != null) {
                z = true;
            } else {
                z = false;
            }
            XxIIOXIXx.oIX0oI.oIX0oI(z);
            byte[] xo0x2 = this.f3541xoXoI.xo0x();
            if (xo0x2[0] == 0) {
                this.f3525OxI = OoIXo.IO.oxoX(xo0x2, xo0x2.length - 1, 1, this.f3522O0xOxO);
            } else {
                this.f3525OxI = OoIXo.IO.Oxx0IOOO(xo0x2, (xo0x2.length - 1) / 2, 1);
            }
        }
        return this.f3525OxI;
    }

    @Override // X0xOO.xoXoI
    public void O0xOxO(jxl.write.biff.IIX0o iIX0o) throws IOException {
        if (this.f3534oO == oo0xXOI0I.f3515oIX0oI) {
            iIX0o.XO(this.f3520IIXOooo);
        } else {
            iIX0o.XO(new IIX0o(this.f3542xxIXOIIO, this.f3540xoIox, this.f3530XO));
        }
    }

    @Override // X0xOO.xoXoI
    public boolean OOXIXo() {
        return true;
    }

    @Override // X0xOO.xoXoI
    public void Oo(double d) {
        if (this.f3534oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3529X0o0xo) {
                OxxIIOOXO();
            }
            this.f3534oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3523OOXIXo = d;
    }

    @Override // X0xOO.xoXoI
    public double OxI() {
        if (!this.f3529X0o0xo) {
            OxxIIOOXO();
        }
        return this.f3540xoIox;
    }

    @Override // X0xOO.xoXoI
    public final int Oxx0IOOO() {
        if (!this.f3529X0o0xo) {
            OxxIIOOXO();
        }
        return this.f3530XO;
    }

    @Override // X0xOO.xoXoI
    public oo0xXOI0I Oxx0xo() {
        return this.f3534oO;
    }

    @Override // X0xOO.xoXoI
    public final void X0IIOO(int i, int i2, int i3) {
        this.f3530XO = i;
        this.f3526Oxx0IOOO = i2;
        this.f3518II0XooXoX = i3;
        if (this.f3534oO == oo0xXOI0I.f3515oIX0oI) {
            this.f3534oO = oo0xXOI0I.f3513I0Io;
        }
    }

    @Override // X0xOO.xoXoI
    public xXxxox0I X0o0xo() {
        return this.f3517I0Io;
    }

    @Override // X0xOO.xoXoI
    public void XI0IXoo(double d) {
        if (this.f3534oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3529X0o0xo) {
                OxxIIOOXO();
            }
            this.f3534oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3535oOoXoXO = d;
    }

    @Override // X0xOO.xoXoI
    public byte[] XIxXXX0x0() {
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        return null;
    }

    @Override // X0xOO.xoXoI
    public void XO(jxl.write.biff.IIX0o iIX0o) throws IOException {
        if (this.f3534oO == oo0xXOI0I.f3515oIX0oI) {
            iIX0o.XO(this.f3537oxoX);
            xXxxox0I xxxxox0i = this.f3532oI0IIXIo;
            if (xxxxox0i != null) {
                iIX0o.XO(xxxxox0i);
            }
            iIX0o.XO(this.f3528OxxIIOOXO);
            iIX0o.XO(this.f3541xoXoI);
            OoIXo.x0xO0oo x0xo0oo = this.f3531o00;
            if (x0xo0oo != null) {
                iIX0o.XO(x0xo0oo);
                return;
            }
            return;
        }
        iIX0o.XO(new ooXIXxIX(this.f3530XO, ooXIXxIX.f3557XxX0x0xxx));
        iIX0o.XO(new xXxxox0I(new OOXIXo().II0xO0()));
        iIX0o.XO(new OI0(IXxxXO()));
        byte[] bArr = new byte[(this.f3525OxI.length() * 2) + 1];
        bArr[0] = 1;
        OoIXo.IO.X0o0xo(this.f3525OxI, bArr, 1);
        iIX0o.XO(new OoIXo.x0xO0oo(bArr));
        byte[] bArr2 = new byte[16];
        OoIXo.oo0xXOI0I.XO(0, bArr2, 0);
        OoIXo.oo0xXOI0I.XO(0, bArr2, 2);
        OoIXo.oo0xXOI0I.XO(this.f3525OxI.length(), bArr2, 8);
        OoIXo.oo0xXOI0I.XO(0, bArr2, 10);
        iIX0o.XO(new OoIXo.x0xO0oo(bArr2));
    }

    public void XxX0x0xxx(OoIXo.x0xO0oo x0xo0oo) {
        this.f3531o00 = x0xo0oo;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public double getHeight() {
        if (!this.f3529X0o0xo) {
            OxxIIOOXO();
        }
        return this.f3535oOoXoXO;
    }

    @Override // X0xOO.xoXoI
    public oOXoIIIo getType() {
        return this.f3521IXxxXO;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public double getWidth() {
        if (!this.f3529X0o0xo) {
            OxxIIOOXO();
        }
        return this.f3523OOXIXo;
    }

    public int hashCode() {
        return this.f3525OxI.hashCode();
    }

    @Override // X0xOO.xoXoI
    public boolean isFirst() {
        return this.f3517I0Io.XX0();
    }

    @Override // X0xOO.xoXoI
    public double o00() {
        if (!this.f3529X0o0xo) {
            OxxIIOOXO();
        }
        return this.f3542xxIXOIIO;
    }

    @Override // X0xOO.xoXoI
    public OxI oI0IIXIo() {
        if (!this.f3529X0o0xo) {
            OxxIIOOXO();
        }
        if (this.f3534oO == oo0xXOI0I.f3515oIX0oI) {
            return ooOOo0oXI();
        }
        if (this.f3519II0xO0 == null) {
            this.f3519II0xO0 = new IO();
            this.f3519II0xO0.x0XOIxOo(new X00IoxXI(this.f3521IXxxXO, this.f3518II0XooXoX, SubBinId.Bbpro.FACTORY_IAMGE));
            xI xIVar = new xI();
            xIVar.x0XOIxOo(344, false, false, 0);
            xIVar.x0XOIxOo(385, false, false, 134217808);
            xIVar.x0XOIxOo(IXXIXx00I.f11718X0xxXX0, false, false, 134217808);
            xIVar.x0XOIxOo(959, false, false, 131074);
            this.f3519II0xO0.x0XOIxOo(xIVar);
            this.f3519II0xO0.x0XOIxOo(new xxIXOIIO(this.f3542xxIXOIIO + 1.3d, Math.max(XIXIX.OOXIXo.f3760XO, this.f3540xoIox - 0.6d), this.f3542xxIXOIIO + 1.3d + this.f3523OOXIXo, this.f3540xoIox + this.f3535oOoXoXO, 1));
            this.f3519II0xO0.x0XOIxOo(new xoIox());
            this.f3519II0xO0.x0XOIxOo(new OOXIXo());
        }
        return this.f3519II0xO0;
    }

    public void oIX0oI(xXxxox0I xxxxox0i) {
        this.f3532oI0IIXIo = xxxxox0i;
        this.f3524Oo.II0xO0(xxxxox0i.xo0x());
    }

    @Override // X0xOO.xoXoI
    public final int oO() {
        if (!this.f3529X0o0xo) {
            OxxIIOOXO();
        }
        return this.f3518II0XooXoX;
    }

    @Override // X0xOO.xoXoI
    public String oOoXoXO() {
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        return null;
    }

    public void ooXIXxIX(OI0 oi0) {
        this.f3528OxxIIOOXO = oi0;
    }

    @Override // X0xOO.xoXoI
    public final int oxoX() {
        if (!this.f3529X0o0xo) {
            OxxIIOOXO();
        }
        return this.f3526Oxx0IOOO;
    }

    @Override // X0xOO.xoXoI
    public int x0XOIxOo() {
        return this.f3536ooOOo0oXI;
    }

    public int x0xO0oo() {
        return this.f3520IIXOooo.II0xO0();
    }

    public void xXxxox0I(IIX0o iIX0o) {
        this.f3520IIXOooo = iIX0o;
    }

    @Override // X0xOO.xoXoI
    public void xoIox(double d) {
        if (this.f3534oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3529X0o0xo) {
                OxxIIOOXO();
            }
            this.f3534oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3542xxIXOIIO = (int) d;
    }

    @Override // X0xOO.xoXoI
    public IIXOooo xoXoI() {
        return this.f3539x0xO0oo;
    }

    @Override // X0xOO.xoXoI
    public void xxIXOIIO(double d) {
        if (this.f3534oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3529X0o0xo) {
                OxxIIOOXO();
            }
            this.f3534oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3540xoIox = (int) d;
    }

    public void xxX(String str) {
        this.f3525OxI = str;
        if (this.f3534oO == oo0xXOI0I.f3515oIX0oI) {
            this.f3534oO = oo0xXOI0I.f3513I0Io;
        }
    }

    public ooOOo0oXI(xoXoI xoxoi, IIXOooo iIXOooo, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f3529X0o0xo = false;
        ooOOo0oXI ooooo0oxi = (ooOOo0oXI) xoxoi;
        oo0xXOI0I oo0xxoi0i = ooooo0oxi.f3534oO;
        oo0xXOI0I oo0xxoi0i2 = oo0xXOI0I.f3515oIX0oI;
        XxIIOXIXx.oIX0oI.oIX0oI(oo0xxoi0i == oo0xxoi0i2);
        this.f3517I0Io = ooooo0oxi.f3517I0Io;
        this.f3537oxoX = ooooo0oxi.f3537oxoX;
        this.f3529X0o0xo = false;
        this.f3534oO = oo0xxoi0i2;
        this.f3524Oo = ooooo0oxi.f3524Oo;
        this.f3539x0xO0oo = iIXOooo;
        this.f3527Oxx0xo = ooooo0oxi.f3527Oxx0xo;
        iIXOooo.XO(this);
        this.f3532oI0IIXIo = ooooo0oxi.f3532oI0IIXIo;
        this.f3528OxxIIOOXO = ooooo0oxi.f3528OxxIIOOXO;
        this.f3541xoXoI = ooooo0oxi.f3541xoXoI;
        this.f3531o00 = ooooo0oxi.f3531o00;
        this.f3520IIXOooo = ooooo0oxi.f3520IIXOooo;
        this.f3523OOXIXo = ooooo0oxi.f3523OOXIXo;
        this.f3535oOoXoXO = ooooo0oxi.f3535oOoXoXO;
        this.f3522O0xOxO = o0xOxO;
    }

    public ooOOo0oXI(String str, int i, int i2) {
        this.f3529X0o0xo = true;
        this.f3534oO = oo0xXOI0I.f3514II0xO0;
        this.f3542xxIXOIIO = i;
        this.f3540xoIox = i2;
        this.f3536ooOOo0oXI = 1;
        this.f3521IXxxXO = oOXoIIIo.f3489XO;
        this.f3525OxI = str;
        this.f3523OOXIXo = 3.0d;
        this.f3535oOoXoXO = 4.0d;
    }
}
