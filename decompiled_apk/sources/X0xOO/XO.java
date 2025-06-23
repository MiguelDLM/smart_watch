package X0xOO;

import android.R;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import java.io.IOException;

/* loaded from: classes6.dex */
public class XO implements xoXoI {

    /* renamed from: OxI, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3430OxI = XxIIOXIXx.X0o0xo.Oxx0IOOO(XO.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public xXxxox0I f3431I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3432II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public OxI f3433II0xO0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public OoIXo.x0xO0oo f3434IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oOXoIIIo f3435IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public double f3436OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public OxxIIOOXO f3437Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3438Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f3439Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public OI0 f3440OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f3441X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3442XO;

    /* renamed from: o00, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f3443o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public xXxxox0I f3444oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OxI f3445oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public oo0xXOI0I f3446oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public double f3447oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f3448ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public ooXIXxIX f3449oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public OxI f3450x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public IIXOooo f3451x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f3452xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public OoIXo.x0xO0oo f3453xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f3454xxIXOIIO;

    public XO(xXxxox0I xxxxox0i, ooXIXxIX ooxixxix, OxxIIOOXO oxxIIOOXO, IIXOooo iIXOooo, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f3451x0xO0oo = iIXOooo;
        this.f3431I0Io = xxxxox0i;
        this.f3437Oo = oxxIIOOXO;
        this.f3449oxoX = ooxixxix;
        boolean z = false;
        this.f3441X0o0xo = false;
        this.f3443o00 = o0xOxO;
        this.f3446oO = oo0xXOI0I.f3515oIX0oI;
        oxxIIOOXO.oIX0oI(xxxxox0i.xo0x());
        this.f3439Oxx0xo = this.f3437Oo.I0Io() - 1;
        this.f3451x0xO0oo.XO(this);
        if (xxxxox0i != null && ooxixxix != null) {
            z = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        IXxxXO();
    }

    private void IXxxXO() {
        boolean z;
        OxI oxoX2 = this.f3437Oo.oxoX(this.f3439Oxx0xo);
        this.f3445oIX0oI = oxoX2;
        if (oxoX2 != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        X0IIOO[] oO2 = this.f3445oIX0oI.oO();
        X00IoxXI x00IoxXI = (X00IoxXI) this.f3445oIX0oI.oO()[0];
        this.f3442XO = this.f3449oxoX.oX();
        this.f3432II0XooXoX = x00IoxXI.x0XOIxOo();
        oOXoIIIo oIX0oI2 = oOXoIIIo.oIX0oI(x00IoxXI.oO());
        this.f3435IXxxXO = oIX0oI2;
        if (oIX0oI2 == oOXoIIIo.f3487Oxx0IOOO) {
            f3430OxI.ooOOo0oXI("Unknown shape type");
        }
        xxIXOIIO xxixoiio = null;
        for (int i = 0; i < oO2.length && xxixoiio == null; i++) {
            if (oO2[i].xxIXOIIO() == XIxXXX0x0.f3421oO) {
                xxixoiio = (xxIXOIIO) oO2[i];
            }
        }
        if (xxixoiio == null) {
            f3430OxI.ooOOo0oXI("Client anchor not found");
        } else {
            this.f3454xxIXOIIO = (int) xxixoiio.oO();
            this.f3452xoIox = (int) xxixoiio.Oo();
        }
        this.f3441X0o0xo = true;
    }

    private OxI ooOOo0oXI() {
        if (!this.f3441X0o0xo) {
            IXxxXO();
        }
        return this.f3445oIX0oI;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public byte[] I0Io() {
        boolean z;
        oo0xXOI0I oo0xxoi0i = this.f3446oO;
        if (oo0xxoi0i != oo0xXOI0I.f3515oIX0oI && oo0xxoi0i != oo0xXOI0I.f3513I0Io) {
            z = false;
        } else {
            z = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        if (!this.f3441X0o0xo) {
            IXxxXO();
        }
        return this.f3451x0xO0oo.II0XooXoX(this.f3438Oxx0IOOO);
    }

    @Override // X0xOO.xoXoI
    public void II0XooXoX(int i) {
        this.f3448ooOOo0oXI = i;
    }

    public int II0xO0() {
        return 0;
    }

    @Override // X0xOO.xoXoI
    public void IIXOooo(IIXOooo iIXOooo) {
        this.f3451x0xO0oo = iIXOooo;
    }

    @Override // X0xOO.xoXoI
    public boolean OOXIXo() {
        return false;
    }

    @Override // X0xOO.xoXoI
    public void Oo(double d) {
        if (this.f3446oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3441X0o0xo) {
                IXxxXO();
            }
            this.f3446oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3436OOXIXo = d;
    }

    @Override // X0xOO.xoXoI
    public double OxI() {
        if (!this.f3441X0o0xo) {
            IXxxXO();
        }
        return this.f3452xoIox;
    }

    @Override // X0xOO.xoXoI
    public final int Oxx0IOOO() {
        if (!this.f3441X0o0xo) {
            IXxxXO();
        }
        return this.f3442XO;
    }

    @Override // X0xOO.xoXoI
    public oo0xXOI0I Oxx0xo() {
        return this.f3446oO;
    }

    public void OxxIIOOXO(OoIXo.x0xO0oo x0xo0oo) {
        this.f3453xoXoI = x0xo0oo;
    }

    @Override // X0xOO.xoXoI
    public final void X0IIOO(int i, int i2, int i3) {
        this.f3442XO = i;
        this.f3438Oxx0IOOO = i2;
        this.f3432II0XooXoX = i3;
        if (this.f3446oO == oo0xXOI0I.f3515oIX0oI) {
            this.f3446oO = oo0xXOI0I.f3513I0Io;
        }
    }

    @Override // X0xOO.xoXoI
    public xXxxox0I X0o0xo() {
        return this.f3431I0Io;
    }

    @Override // X0xOO.xoXoI
    public void XI0IXoo(double d) {
        if (this.f3446oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3441X0o0xo) {
                IXxxXO();
            }
            this.f3446oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3447oOoXoXO = d;
    }

    @Override // X0xOO.xoXoI
    public byte[] XIxXXX0x0() {
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        return null;
    }

    @Override // X0xOO.xoXoI
    public void XO(jxl.write.biff.IIX0o iIX0o) throws IOException {
        if (this.f3446oO == oo0xXOI0I.f3515oIX0oI) {
            iIX0o.XO(this.f3449oxoX);
            xXxxox0I xxxxox0i = this.f3444oI0IIXIo;
            if (xxxxox0i != null) {
                iIX0o.XO(xxxxox0i);
            }
            iIX0o.XO(this.f3440OxxIIOOXO);
            iIX0o.XO(this.f3434IIXOooo);
            OoIXo.x0xO0oo x0xo0oo = this.f3453xoXoI;
            if (x0xo0oo != null) {
                iIX0o.XO(x0xo0oo);
                return;
            }
            return;
        }
        iIX0o.XO(new ooXIXxIX(this.f3442XO, ooXIXxIX.f3552Oxx0xo));
        f3430OxI.ooOOo0oXI("Writing of additional records for checkboxes not implemented");
    }

    public void XxX0x0xxx(OI0 oi0) {
        this.f3440OxxIIOOXO = oi0;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public double getHeight() {
        if (!this.f3441X0o0xo) {
            IXxxXO();
        }
        return this.f3447oOoXoXO;
    }

    @Override // X0xOO.xoXoI
    public oOXoIIIo getType() {
        return this.f3435IXxxXO;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public double getWidth() {
        if (!this.f3441X0o0xo) {
            IXxxXO();
        }
        return this.f3436OOXIXo;
    }

    public int hashCode() {
        return getClass().getName().hashCode();
    }

    @Override // X0xOO.xoXoI
    public boolean isFirst() {
        return this.f3431I0Io.XX0();
    }

    @Override // X0xOO.xoXoI
    public double o00() {
        if (!this.f3441X0o0xo) {
            IXxxXO();
        }
        return this.f3454xxIXOIIO;
    }

    @Override // X0xOO.xoXoI
    public OxI oI0IIXIo() {
        if (!this.f3441X0o0xo) {
            IXxxXO();
        }
        if (this.f3446oO == oo0xXOI0I.f3515oIX0oI) {
            return ooOOo0oXI();
        }
        IO io2 = new IO();
        io2.x0XOIxOo(new X00IoxXI(this.f3435IXxxXO, this.f3432II0XooXoX, SubBinId.Bbpro.FACTORY_IAMGE));
        xI xIVar = new xI();
        xIVar.x0XOIxOo(127, false, false, R.string.aerr_wait);
        xIVar.x0XOIxOo(EMachine.EM_TILEGX, false, false, 524296);
        xIVar.x0XOIxOo(511, false, false, 524288);
        xIVar.x0XOIxOo(959, false, false, 131072);
        io2.x0XOIxOo(xIVar);
        io2.x0XOIxOo(new xxIXOIIO(this.f3454xxIXOIIO, this.f3452xoIox, r2 + 1, r3 + 1, 1));
        io2.x0XOIxOo(new xoIox());
        return io2;
    }

    public void oIX0oI(xXxxox0I xxxxox0i) {
        this.f3444oI0IIXIo = xxxxox0i;
        this.f3437Oo.II0xO0(xxxxox0i.xo0x());
    }

    @Override // X0xOO.xoXoI
    public final int oO() {
        if (!this.f3441X0o0xo) {
            IXxxXO();
        }
        return this.f3432II0XooXoX;
    }

    @Override // X0xOO.xoXoI
    public String oOoXoXO() {
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        return null;
    }

    @Override // X0xOO.xoXoI
    public final int oxoX() {
        if (!this.f3441X0o0xo) {
            IXxxXO();
        }
        return this.f3438Oxx0IOOO;
    }

    @Override // X0xOO.xoXoI
    public int x0XOIxOo() {
        return this.f3448ooOOo0oXI;
    }

    public int x0xO0oo() {
        return 0;
    }

    @Override // X0xOO.xoXoI
    public void xoIox(double d) {
        if (this.f3446oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3441X0o0xo) {
                IXxxXO();
            }
            this.f3446oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3454xxIXOIIO = (int) d;
    }

    @Override // X0xOO.xoXoI
    public IIXOooo xoXoI() {
        return this.f3451x0xO0oo;
    }

    @Override // X0xOO.xoXoI
    public void xxIXOIIO(double d) {
        if (this.f3446oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3441X0o0xo) {
                IXxxXO();
            }
            this.f3446oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3452xoIox = (int) d;
    }

    public void xxX(OoIXo.x0xO0oo x0xo0oo) {
        this.f3434IIXOooo = x0xo0oo;
    }

    public XO(xoXoI xoxoi, IIXOooo iIXOooo, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f3441X0o0xo = false;
        XO xo2 = (XO) xoxoi;
        oo0xXOI0I oo0xxoi0i = xo2.f3446oO;
        oo0xXOI0I oo0xxoi0i2 = oo0xXOI0I.f3515oIX0oI;
        XxIIOXIXx.oIX0oI.oIX0oI(oo0xxoi0i == oo0xxoi0i2);
        this.f3431I0Io = xo2.f3431I0Io;
        this.f3449oxoX = xo2.f3449oxoX;
        this.f3441X0o0xo = false;
        this.f3446oO = oo0xxoi0i2;
        this.f3437Oo = xo2.f3437Oo;
        this.f3451x0xO0oo = iIXOooo;
        this.f3439Oxx0xo = xo2.f3439Oxx0xo;
        iIXOooo.XO(this);
        this.f3444oI0IIXIo = xo2.f3444oI0IIXIo;
        this.f3440OxxIIOOXO = xo2.f3440OxxIIOOXO;
        this.f3434IIXOooo = xo2.f3434IIXOooo;
        this.f3453xoXoI = xo2.f3453xoXoI;
        this.f3443o00 = o0xOxO;
    }

    @Override // X0xOO.xoXoI
    public void O0xOxO(jxl.write.biff.IIX0o iIX0o) {
    }

    public XO() {
        this.f3441X0o0xo = true;
        this.f3446oO = oo0xXOI0I.f3514II0xO0;
        this.f3448ooOOo0oXI = 1;
        this.f3435IXxxXO = oOXoIIIo.f3488X0o0xo;
    }
}
