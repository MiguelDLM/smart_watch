package X0xOO;

import android.R;
import com.google.firebase.crashlytics.buildtools.ndk.internal.elf.EMachine;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import java.io.IOException;

/* loaded from: classes6.dex */
public class oOoXoXO implements xoXoI {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3492OxxIIOOXO = XxIIOXIXx.X0o0xo.Oxx0IOOO(oOoXoXO.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public xXxxox0I f3493I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3494II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public OxI f3495II0xO0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oOXoIIIo f3496IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public double f3497OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public OxxIIOOXO f3498Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3499Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f3500Oxx0xo;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f3501X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3502XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f3503oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OxI f3504oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public oo0xXOI0I f3505oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public double f3506oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f3507ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public ooXIXxIX f3508oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public OxI f3509x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public IIXOooo f3510x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f3511xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f3512xxIXOIIO;

    public oOoXoXO(xXxxox0I xxxxox0i, ooXIXxIX ooxixxix, OxxIIOOXO oxxIIOOXO, IIXOooo iIXOooo, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f3510x0xO0oo = iIXOooo;
        this.f3493I0Io = xxxxox0i;
        this.f3498Oo = oxxIIOOXO;
        this.f3508oxoX = ooxixxix;
        boolean z = false;
        this.f3501X0o0xo = false;
        this.f3503oI0IIXIo = o0xOxO;
        this.f3505oO = oo0xXOI0I.f3515oIX0oI;
        oxxIIOOXO.oIX0oI(xxxxox0i.xo0x());
        this.f3500Oxx0xo = this.f3498Oo.I0Io() - 1;
        this.f3510x0xO0oo.XO(this);
        if (xxxxox0i != null && ooxixxix != null) {
            z = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        x0xO0oo();
    }

    private OxI II0xO0() {
        if (!this.f3501X0o0xo) {
            x0xO0oo();
        }
        return this.f3504oIX0oI;
    }

    private void x0xO0oo() {
        boolean z;
        OxI oxoX2 = this.f3498Oo.oxoX(this.f3500Oxx0xo);
        this.f3504oIX0oI = oxoX2;
        if (oxoX2 != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        X0IIOO[] oO2 = this.f3504oIX0oI.oO();
        X00IoxXI x00IoxXI = (X00IoxXI) this.f3504oIX0oI.oO()[0];
        this.f3502XO = this.f3508oxoX.oX();
        this.f3494II0XooXoX = x00IoxXI.x0XOIxOo();
        oOXoIIIo oIX0oI2 = oOXoIIIo.oIX0oI(x00IoxXI.oO());
        this.f3496IXxxXO = oIX0oI2;
        if (oIX0oI2 == oOXoIIIo.f3487Oxx0IOOO) {
            f3492OxxIIOOXO.ooOOo0oXI("Unknown shape type");
        }
        xxIXOIIO xxixoiio = null;
        for (int i = 0; i < oO2.length && xxixoiio == null; i++) {
            if (oO2[i].xxIXOIIO() == XIxXXX0x0.f3421oO) {
                xxixoiio = (xxIXOIIO) oO2[i];
            }
        }
        if (xxixoiio == null) {
            f3492OxxIIOOXO.ooOOo0oXI("Client anchor not found");
        } else {
            this.f3512xxIXOIIO = (int) xxixoiio.oO();
            this.f3511xoIox = (int) xxixoiio.Oo();
        }
        this.f3501X0o0xo = true;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public byte[] I0Io() {
        boolean z;
        oo0xXOI0I oo0xxoi0i = this.f3505oO;
        if (oo0xxoi0i != oo0xXOI0I.f3515oIX0oI && oo0xxoi0i != oo0xXOI0I.f3513I0Io) {
            z = false;
        } else {
            z = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        if (!this.f3501X0o0xo) {
            x0xO0oo();
        }
        return this.f3510x0xO0oo.II0XooXoX(this.f3499Oxx0IOOO);
    }

    @Override // X0xOO.xoXoI
    public void II0XooXoX(int i) {
        this.f3507ooOOo0oXI = i;
    }

    @Override // X0xOO.xoXoI
    public void IIXOooo(IIXOooo iIXOooo) {
        this.f3510x0xO0oo = iIXOooo;
    }

    @Override // X0xOO.xoXoI
    public boolean OOXIXo() {
        return false;
    }

    @Override // X0xOO.xoXoI
    public void Oo(double d) {
        if (this.f3505oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3501X0o0xo) {
                x0xO0oo();
            }
            this.f3505oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3497OOXIXo = d;
    }

    @Override // X0xOO.xoXoI
    public double OxI() {
        if (!this.f3501X0o0xo) {
            x0xO0oo();
        }
        return this.f3511xoIox;
    }

    @Override // X0xOO.xoXoI
    public final int Oxx0IOOO() {
        if (!this.f3501X0o0xo) {
            x0xO0oo();
        }
        return this.f3502XO;
    }

    @Override // X0xOO.xoXoI
    public oo0xXOI0I Oxx0xo() {
        return this.f3505oO;
    }

    @Override // X0xOO.xoXoI
    public final void X0IIOO(int i, int i2, int i3) {
        this.f3502XO = i;
        this.f3499Oxx0IOOO = i2;
        this.f3494II0XooXoX = i3;
        if (this.f3505oO == oo0xXOI0I.f3515oIX0oI) {
            this.f3505oO = oo0xXOI0I.f3513I0Io;
        }
    }

    @Override // X0xOO.xoXoI
    public xXxxox0I X0o0xo() {
        return this.f3493I0Io;
    }

    @Override // X0xOO.xoXoI
    public void XI0IXoo(double d) {
        if (this.f3505oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3501X0o0xo) {
                x0xO0oo();
            }
            this.f3505oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3506oOoXoXO = d;
    }

    @Override // X0xOO.xoXoI
    public byte[] XIxXXX0x0() {
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        return null;
    }

    @Override // X0xOO.xoXoI
    public void XO(jxl.write.biff.IIX0o iIX0o) throws IOException {
        if (this.f3505oO == oo0xXOI0I.f3515oIX0oI) {
            iIX0o.XO(this.f3508oxoX);
        } else {
            iIX0o.XO(new ooXIXxIX(this.f3502XO, ooXIXxIX.f3555XI0IXoo));
        }
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public double getHeight() {
        if (!this.f3501X0o0xo) {
            x0xO0oo();
        }
        return this.f3506oOoXoXO;
    }

    @Override // X0xOO.xoXoI
    public oOXoIIIo getType() {
        return this.f3496IXxxXO;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public double getWidth() {
        if (!this.f3501X0o0xo) {
            x0xO0oo();
        }
        return this.f3497OOXIXo;
    }

    public int hashCode() {
        return getClass().getName().hashCode();
    }

    @Override // X0xOO.xoXoI
    public boolean isFirst() {
        return this.f3493I0Io.XX0();
    }

    @Override // X0xOO.xoXoI
    public double o00() {
        if (!this.f3501X0o0xo) {
            x0xO0oo();
        }
        return this.f3512xxIXOIIO;
    }

    @Override // X0xOO.xoXoI
    public OxI oI0IIXIo() {
        if (!this.f3501X0o0xo) {
            x0xO0oo();
        }
        if (this.f3505oO == oo0xXOI0I.f3515oIX0oI) {
            return II0xO0();
        }
        IO io2 = new IO();
        io2.x0XOIxOo(new X00IoxXI(this.f3496IXxxXO, this.f3494II0XooXoX, SubBinId.Bbpro.FACTORY_IAMGE));
        xI xIVar = new xI();
        xIVar.x0XOIxOo(127, false, false, R.string.aerr_wait);
        xIVar.x0XOIxOo(EMachine.EM_TILEGX, false, false, 524296);
        xIVar.x0XOIxOo(511, false, false, 524288);
        xIVar.x0XOIxOo(959, false, false, 131072);
        io2.x0XOIxOo(xIVar);
        io2.x0XOIxOo(new xxIXOIIO(this.f3512xxIXOIIO, this.f3511xoIox, r2 + 1, r3 + 1, 1));
        io2.x0XOIxOo(new xoIox());
        return io2;
    }

    public int oIX0oI() {
        return 0;
    }

    @Override // X0xOO.xoXoI
    public final int oO() {
        if (!this.f3501X0o0xo) {
            x0xO0oo();
        }
        return this.f3494II0XooXoX;
    }

    @Override // X0xOO.xoXoI
    public String oOoXoXO() {
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        return null;
    }

    public int ooOOo0oXI() {
        return 0;
    }

    @Override // X0xOO.xoXoI
    public final int oxoX() {
        if (!this.f3501X0o0xo) {
            x0xO0oo();
        }
        return this.f3499Oxx0IOOO;
    }

    @Override // X0xOO.xoXoI
    public int x0XOIxOo() {
        return this.f3507ooOOo0oXI;
    }

    @Override // X0xOO.xoXoI
    public void xoIox(double d) {
        if (this.f3505oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3501X0o0xo) {
                x0xO0oo();
            }
            this.f3505oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3512xxIXOIIO = (int) d;
    }

    @Override // X0xOO.xoXoI
    public IIXOooo xoXoI() {
        return this.f3510x0xO0oo;
    }

    @Override // X0xOO.xoXoI
    public void xxIXOIIO(double d) {
        if (this.f3505oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3501X0o0xo) {
                x0xO0oo();
            }
            this.f3505oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3511xoIox = (int) d;
    }

    public oOoXoXO(xoXoI xoxoi, IIXOooo iIXOooo, xIoXXXIXo.O0xOxO o0xOxO) {
        this.f3501X0o0xo = false;
        oOoXoXO oooxoxo = (oOoXoXO) xoxoi;
        oo0xXOI0I oo0xxoi0i = oooxoxo.f3505oO;
        oo0xXOI0I oo0xxoi0i2 = oo0xXOI0I.f3515oIX0oI;
        XxIIOXIXx.oIX0oI.oIX0oI(oo0xxoi0i == oo0xxoi0i2);
        this.f3493I0Io = oooxoxo.f3493I0Io;
        this.f3508oxoX = oooxoxo.f3508oxoX;
        this.f3501X0o0xo = false;
        this.f3505oO = oo0xxoi0i2;
        this.f3498Oo = oooxoxo.f3498Oo;
        this.f3510x0xO0oo = iIXOooo;
        this.f3500Oxx0xo = oooxoxo.f3500Oxx0xo;
        iIXOooo.XO(this);
        this.f3503oI0IIXIo = o0xOxO;
    }

    @Override // X0xOO.xoXoI
    public void O0xOxO(jxl.write.biff.IIX0o iIX0o) {
    }

    public oOoXoXO() {
        this.f3501X0o0xo = true;
        this.f3505oO = oo0xXOI0I.f3514II0xO0;
        this.f3507ooOOo0oXI = 1;
        this.f3496IXxxXO = oOXoIIIo.f3488X0o0xo;
    }
}
