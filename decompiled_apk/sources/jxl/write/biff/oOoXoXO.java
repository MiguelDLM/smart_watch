package jxl.write.biff;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import jxl.biff.NumFormatRecordsException;
import jxl.biff.formula.FormulaException;

/* loaded from: classes6.dex */
public abstract class oOoXoXO extends OoIXo.OI0 implements oIXoXx0.oI0IIXIo {

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28851ooOOo0oXI = XxIIOXIXx.X0o0xo.Oxx0IOOO(oOoXoXO.class);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public OoIXo.xXxxox0I f28852II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public oIXoXx0.OxxIIOOXO f28853OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public OoIXo.XX f28854Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f28855X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f28856XO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public boolean f28857oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public XOxxooXI f28858xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f28859xxIXOIIO;

    public oOoXoXO(OoIXo.xII xii, int i, int i2) {
        this(xii, i, i2, oIXoXx0.X0IIOO.f31668I0Io);
        this.f28857oOoXoXO = false;
    }

    public final void I0X0x0oIo() {
        XXoOx0 o02 = this.f28858xoIox.IIxOXoOo0().o0();
        OoIXo.XX I0Io2 = o02.I0Io(this.f28854Oxx0IOOO);
        this.f28854Oxx0IOOO = I0Io2;
        try {
            if (!I0Io2.isInitialized()) {
                this.f28852II0XooXoX.II0xO0(this.f28854Oxx0IOOO);
            }
        } catch (NumFormatRecordsException unused) {
            f28851ooOOo0oXI.ooOOo0oXI("Maximum number of format records exceeded.  Using default format.");
            this.f28854Oxx0IOOO = o02.Oxx0IOOO();
        }
    }

    public XOxxooXI I0oOIX() {
        return this.f28858xoIox;
    }

    @Override // xIoXXXIXo.I0Io
    public int II0xO0() {
        return this.f28855X0o0xo;
    }

    @Override // oIXoXx0.oI0IIXIo
    public oIXoXx0.OxxIIOOXO Io() {
        return this.f28853OOXIXo;
    }

    public void IoOoo() {
        X0xOO.ooOOo0oXI I0Io2;
        this.f28855X0o0xo++;
        oIXoXx0.OxxIIOOXO oxxIIOOXO = this.f28853OOXIXo;
        if (oxxIIOOXO != null && (I0Io2 = oxxIIOOXO.I0Io()) != null) {
            I0Io2.xoIox(this.f28856XO);
            I0Io2.xxIXOIIO(this.f28855X0o0xo);
        }
    }

    public void O0Xx() {
        this.f28855X0o0xo--;
        oIXoXx0.OxxIIOOXO oxxIIOOXO = this.f28853OOXIXo;
        if (oxxIIOOXO != null) {
            X0xOO.ooOOo0oXI I0Io2 = oxxIIOOXO.I0Io();
            if (I0Io2 != null) {
                I0Io2.xoIox(this.f28856XO);
                I0Io2.xxIXOIIO(this.f28855X0o0xo);
            }
            if (this.f28853OOXIXo.xoIox()) {
                f28851ooOOo0oXI.ooOOo0oXI("need to change value for drop down drawing");
            }
        }
    }

    public void OO() {
        X0xOO.ooOOo0oXI I0Io2;
        this.f28856XO++;
        oIXoXx0.OxxIIOOXO oxxIIOOXO = this.f28853OOXIXo;
        if (oxxIIOOXO != null && (I0Io2 = oxxIIOOXO.I0Io()) != null) {
            I0Io2.xoIox(this.f28856XO);
            I0Io2.xxIXOIIO(this.f28855X0o0xo);
        }
    }

    public final void OO0x0xX(X0xOO.ooOOo0oXI ooooo0oxi) {
        this.f28858xoIox.XIXIX(ooooo0oxi);
    }

    public final void XIo0oOXIx() {
        this.f28858xoIox.xOOOX(this);
    }

    @Override // xIoXXXIXo.I0Io
    public xIoXXXIXo.oxoX XO() {
        return this.f28853OOXIXo;
    }

    public final void XX0() {
        oIXoXx0.OxxIIOOXO oxxIIOOXO = this.f28853OOXIXo;
        if (oxxIIOOXO == null) {
            return;
        }
        if (this.f28857oOoXoXO) {
            this.f28857oOoXoXO = false;
            return;
        }
        if (oxxIIOOXO.II0xO0() != null) {
            X0xOO.ooOOo0oXI ooooo0oxi = new X0xOO.ooOOo0oXI(this.f28853OOXIXo.II0xO0(), this.f28856XO, this.f28855X0o0xo);
            ooooo0oxi.Oo(this.f28853OOXIXo.X0o0xo());
            ooooo0oxi.XI0IXoo(this.f28853OOXIXo.oxoX());
            this.f28858xoIox.I0oOIX(ooooo0oxi);
            this.f28858xoIox.IIxOXoOo0().IIX0o(ooooo0oxi);
            this.f28853OOXIXo.Oo(ooooo0oxi);
        }
        if (this.f28853OOXIXo.xxIXOIIO()) {
            try {
                this.f28853OOXIXo.XO().x0XOIxOo(this.f28856XO, this.f28855X0o0xo, this.f28858xoIox.IIxOXoOo0(), this.f28858xoIox.IIxOXoOo0(), this.f28858xoIox.I0());
            } catch (FormulaException unused) {
                XxIIOXIXx.oIX0oI.oIX0oI(false);
            }
            this.f28858xoIox.xoxXI(this);
            if (!this.f28853OOXIXo.xoIox()) {
                return;
            }
            if (this.f28858xoIox.xxIO() == null) {
                X0xOO.oOoXoXO oooxoxo = new X0xOO.oOoXoXO();
                this.f28858xoIox.I0oOIX(oooxoxo);
                this.f28858xoIox.IIxOXoOo0().IIX0o(oooxoxo);
                this.f28858xoIox.oXIO0o0XI(oooxoxo);
            }
            this.f28853OOXIXo.x0XOIxOo(this.f28858xoIox.xxIO());
        }
    }

    public void XX0xXo(OoIXo.xXxxox0I xxxxox0i, IoIOOxIIo ioIOOxIIo, XOxxooXI xOxxooXI) {
        this.f28859xxIXOIIO = true;
        this.f28858xoIox = xOxxooXI;
        this.f28852II0XooXoX = xxxxox0i;
        I0X0x0oIo();
        XX0();
    }

    public void XoI0Ixx0() {
        X0xOO.ooOOo0oXI I0Io2;
        this.f28856XO--;
        oIXoXx0.OxxIIOOXO oxxIIOOXO = this.f28853OOXIXo;
        if (oxxIIOOXO != null && (I0Io2 = oxxIIOOXO.I0Io()) != null) {
            I0Io2.xoIox(this.f28856XO);
            I0Io2.xxIXOIIO(this.f28855X0o0xo);
        }
    }

    @Override // xIoXXXIXo.I0Io
    public boolean isHidden() {
        oO Ioxxx2 = this.f28858xoIox.Ioxxx(this.f28856XO);
        if (Ioxxx2 != null && Ioxxx2.I0oOIX() == 0) {
            return true;
        }
        oXIO0o0XI XI0oooXX2 = this.f28858xoIox.XI0oooXX(this.f28855X0o0xo);
        if (XI0oooXX2 != null) {
            if (XI0oooXX2.xoxXI() == 0 || XI0oooXX2.Ioxxx()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final void o0xxxXXxX(boolean z) {
        this.f28857oOoXoXO = z;
    }

    @Override // xIoXXXIXo.I0Io
    public int oIX0oI() {
        return this.f28856XO;
    }

    public final void x0xO() {
        this.f28853OOXIXo = null;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        byte[] bArr = new byte[6];
        OoIXo.oo0xXOI0I.XO(this.f28855X0o0xo, bArr, 0);
        OoIXo.oo0xXOI0I.XO(this.f28856XO, bArr, 2);
        OoIXo.oo0xXOI0I.XO(this.f28854Oxx0IOOO.XoI0Ixx0(), bArr, 4);
        return bArr;
    }

    @Override // xIoXXXIXo.I0Io
    public oI0X0.X0o0xo xoIox() {
        return this.f28854Oxx0IOOO;
    }

    public final boolean xoIxX() {
        return this.f28859xxIXOIIO;
    }

    public final int xoxXI() {
        return this.f28854Oxx0IOOO.XoI0Ixx0();
    }

    @Override // oIXoXx0.oI0IIXIo
    public void xxIXOIIO(oIXoXx0.OxxIIOOXO oxxIIOOXO) {
        if (this.f28853OOXIXo != null) {
            f28851ooOOo0oXI.ooOOo0oXI("current cell features for " + xIoXXXIXo.XO.oxoX(this) + " not null - overwriting");
            if (this.f28853OOXIXo.xxIXOIIO() && this.f28853OOXIXo.XO() != null && this.f28853OOXIXo.XO().I0Io()) {
                OoIXo.Oxx0xo XO2 = this.f28853OOXIXo.XO();
                f28851ooOOo0oXI.ooOOo0oXI("Cannot add cell features to " + xIoXXXIXo.XO.oxoX(this) + " because it is part of the shared cell validation group " + xIoXXXIXo.XO.oIX0oI(XO2.X0o0xo(), XO2.XO()) + HelpFormatter.DEFAULT_OPT_PREFIX + xIoXXXIXo.XO.oIX0oI(XO2.Oxx0IOOO(), XO2.II0XooXoX()));
                return;
            }
        }
        this.f28853OOXIXo = oxxIIOOXO;
        oxxIIOOXO.OxI(this);
        if (this.f28859xxIXOIIO) {
            XX0();
        }
    }

    @Override // oIXoXx0.oI0IIXIo
    public void xxX(oI0X0.X0o0xo x0o0xo) {
        boolean z;
        this.f28854Oxx0IOOO = (OoIXo.XX) x0o0xo;
        if (!this.f28859xxIXOIIO) {
            return;
        }
        if (this.f28852II0XooXoX != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        I0X0x0oIo();
    }

    public oOoXoXO(OoIXo.xII xii, xIoXXXIXo.I0Io i0Io) {
        this(xii, i0Io.oIX0oI(), i0Io.II0xO0());
        this.f28857oOoXoXO = true;
        this.f28854Oxx0IOOO = (OoIXo.XX) i0Io.xoIox();
        if (i0Io.XO() != null) {
            oIXoXx0.OxxIIOOXO oxxIIOOXO = new oIXoXx0.OxxIIOOXO(i0Io.XO());
            this.f28853OOXIXo = oxxIIOOXO;
            oxxIIOOXO.OxI(this);
        }
    }

    public oOoXoXO(OoIXo.xII xii, int i, int i2, oI0X0.X0o0xo x0o0xo) {
        super(xii);
        this.f28855X0o0xo = i2;
        this.f28856XO = i;
        this.f28854Oxx0IOOO = (OoIXo.XX) x0o0xo;
        this.f28859xxIXOIIO = false;
        this.f28857oOoXoXO = false;
    }

    public oOoXoXO(OoIXo.xII xii, int i, int i2, oOoXoXO oooxoxo) {
        super(xii);
        this.f28855X0o0xo = i2;
        this.f28856XO = i;
        this.f28854Oxx0IOOO = oooxoxo.f28854Oxx0IOOO;
        this.f28859xxIXOIIO = false;
        this.f28857oOoXoXO = false;
        if (oooxoxo.f28853OOXIXo != null) {
            oIXoXx0.OxxIIOOXO oxxIIOOXO = new oIXoXx0.OxxIIOOXO(oooxoxo.f28853OOXIXo);
            this.f28853OOXIXo = oxxIIOOXO;
            oxxIIOOXO.OxI(this);
        }
    }

    public void Ioxxx(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
    }

    public void Xo0(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
    }

    public void oX(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
    }

    public void xxIO(xIoXXXIXo.IIXOooo iIXOooo, int i, int i2) {
    }
}
