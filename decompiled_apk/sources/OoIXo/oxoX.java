package OoIXo;

import OoIXo.Oxx0xo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.Collection;

/* loaded from: classes6.dex */
public class oxoX {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final double f2381oOoXoXO = 3.0d;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final double f2382ooOOo0oXI = 4.0d;

    /* renamed from: I0Io, reason: collision with root package name */
    public double f2385I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public boolean f2386II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public double f2387II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Oxx0xo f2388Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public X0xOO.oOoXoXO f2389X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public xoXoI f2390XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f2391oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public X0xOO.ooOOo0oXI f2392oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public jxl.write.biff.oOoXoXO f2393xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f2394xxIXOIIO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2375OOXIXo = XxIIOXIXx.X0o0xo.Oxx0IOOO(oxoX.class);

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oIX0oI f2383x0XOIxOo = new oIX0oI(Oxx0xo.f2131xI);

    /* renamed from: oO, reason: collision with root package name */
    public static final oIX0oI f2380oO = new oIX0oI(Oxx0xo.f2127oo0xXOI0I);

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final oIX0oI f2384x0xO0oo = new oIX0oI(Oxx0xo.f2126oo);

    /* renamed from: Oo, reason: collision with root package name */
    public static final oIX0oI f2376Oo = new oIX0oI(Oxx0xo.f2111IoOoX);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final oIX0oI f2374IXxxXO = new oIX0oI(Oxx0xo.f2125oOXoIIIo);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final oIX0oI f2377Oxx0xo = new oIX0oI(Oxx0xo.f2121Xx000oIo);

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final oIX0oI f2379oI0IIXIo = new oIX0oI(Oxx0xo.f2115X00IoxXI);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final oIX0oI f2378OxxIIOOXO = new oIX0oI(Oxx0xo.f2109IO);

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static oIX0oI[] f2395II0xO0 = new oIX0oI[0];

        /* renamed from: oIX0oI, reason: collision with root package name */
        public Oxx0xo.oIX0oI f2396oIX0oI;

        public oIX0oI(Oxx0xo.oIX0oI oix0oi) {
            this.f2396oIX0oI = oix0oi;
            oIX0oI[] oix0oiArr = f2395II0xO0;
            oIX0oI[] oix0oiArr2 = new oIX0oI[oix0oiArr.length + 1];
            f2395II0xO0 = oix0oiArr2;
            System.arraycopy(oix0oiArr, 0, oix0oiArr2, 0, oix0oiArr.length);
            f2395II0xO0[oix0oiArr.length] = this;
        }

        public Oxx0xo.oIX0oI oIX0oI() {
            return this.f2396oIX0oI;
        }
    }

    public oxoX() {
    }

    public final X0xOO.ooOOo0oXI I0Io() {
        return this.f2392oxoX;
    }

    public xIoXXXIXo.OxxIIOOXO II0XooXoX() {
        if (!this.f2394xxIXOIIO) {
            return null;
        }
        Oxx0xo XO2 = XO();
        return new X00IoxXI(this.f2393xoIox.I0oOIX(), XO2.X0o0xo(), XO2.XO(), XO2.Oxx0IOOO(), XO2.II0XooXoX());
    }

    public String II0xO0() {
        return this.f2391oIX0oI;
    }

    public void IIXOooo(double d, oIX0oI oix0oi) {
        if (this.f2394xxIXOIIO && XO().I0Io()) {
            f2375OOXIXo.ooOOo0oXI("Cannot set data validation on " + xIoXXXIXo.XO.oxoX(this.f2393xoIox) + " as it is part of a shared data validation");
            return;
        }
        oIX0oI();
        this.f2388Oxx0IOOO = new Oxx0xo(d, Double.NaN, oix0oi.oIX0oI());
        this.f2386II0XooXoX = false;
        this.f2394xxIXOIIO = true;
    }

    public void IXxxXO(Collection collection) {
        if (this.f2394xxIXOIIO && XO().I0Io()) {
            f2375OOXIXo.ooOOo0oXI("Cannot set data validation on " + xIoXXXIXo.XO.oxoX(this.f2393xoIox) + " as it is part of a shared data validation");
            return;
        }
        oIX0oI();
        this.f2388Oxx0IOOO = new Oxx0xo(collection);
        this.f2386II0XooXoX = true;
        this.f2394xxIXOIIO = true;
    }

    public void O0xOxO(oxoX oxox) {
        if (this.f2394xxIXOIIO) {
            f2375OOXIXo.ooOOo0oXI("Attempting to share a data validation on cell " + xIoXXXIXo.XO.oxoX(this.f2393xoIox) + " which already has a data validation");
            return;
        }
        oIX0oI();
        this.f2388Oxx0IOOO = oxox.XO();
        this.f2390XO = null;
        this.f2394xxIXOIIO = true;
        this.f2386II0XooXoX = oxox.f2386II0XooXoX;
        this.f2389X0o0xo = oxox.f2389X0o0xo;
    }

    public void OOXIXo() {
        this.f2391oIX0oI = null;
        X0xOO.ooOOo0oXI ooooo0oxi = this.f2392oxoX;
        if (ooooo0oxi != null) {
            this.f2393xoIox.OO0x0xX(ooooo0oxi);
            this.f2392oxoX = null;
        }
    }

    public final void Oo(X0xOO.ooOOo0oXI ooooo0oxi) {
        this.f2392oxoX = ooooo0oxi;
    }

    public final void OxI(jxl.write.biff.oOoXoXO oooxoxo) {
        this.f2393xoIox = oooxoxo;
    }

    public String Oxx0IOOO() {
        xoXoI xoxoi = this.f2390XO;
        if (xoxoi == null) {
            return null;
        }
        return xoxoi.Xo0();
    }

    public void Oxx0xo(int i, int i2, int i3, int i4) {
        if (this.f2394xxIXOIIO && XO().I0Io()) {
            f2375OOXIXo.ooOOo0oXI("Cannot set data validation on " + xIoXXXIXo.XO.oxoX(this.f2393xoIox) + " as it is part of a shared data validation");
            return;
        }
        oIX0oI();
        this.f2388Oxx0IOOO = new Oxx0xo(i, i2, i3, i4);
        this.f2386II0XooXoX = true;
        this.f2394xxIXOIIO = true;
    }

    public void OxxIIOOXO(double d, double d2, oIX0oI oix0oi) {
        if (this.f2394xxIXOIIO && XO().I0Io()) {
            f2375OOXIXo.ooOOo0oXI("Cannot set data validation on " + xIoXXXIXo.XO.oxoX(this.f2393xoIox) + " as it is part of a shared data validation");
            return;
        }
        oIX0oI();
        this.f2388Oxx0IOOO = new Oxx0xo(d, d2, oix0oi.oIX0oI());
        this.f2386II0XooXoX = false;
        this.f2394xxIXOIIO = true;
    }

    public double X0o0xo() {
        return this.f2387II0xO0;
    }

    public Oxx0xo XO() {
        Oxx0xo oxx0xo = this.f2388Oxx0IOOO;
        if (oxx0xo != null) {
            return oxx0xo;
        }
        if (this.f2390XO != null) {
            Oxx0xo oxx0xo2 = new Oxx0xo(this.f2390XO.XX0());
            this.f2388Oxx0IOOO = oxx0xo2;
            return oxx0xo2;
        }
        return null;
    }

    public void o00(xoXoI xoxoi) {
        boolean z;
        if (xoxoi != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        this.f2390XO = xoxoi;
        this.f2394xxIXOIIO = true;
    }

    public void oI0IIXIo(String str) {
        if (this.f2394xxIXOIIO && XO().I0Io()) {
            f2375OOXIXo.ooOOo0oXI("Cannot set data validation on " + xIoXXXIXo.XO.oxoX(this.f2393xoIox) + " as it is part of a shared data validation");
            return;
        }
        oIX0oI();
        this.f2388Oxx0IOOO = new Oxx0xo(str);
        this.f2386II0XooXoX = true;
        this.f2394xxIXOIIO = true;
    }

    public final void oIX0oI() {
        this.f2390XO = null;
        this.f2388Oxx0IOOO = null;
        this.f2386II0XooXoX = false;
        this.f2389X0o0xo = null;
        this.f2394xxIXOIIO = false;
    }

    public void oO(String str) {
        x0xO0oo(str, 3.0d, 4.0d);
    }

    public void oOoXoXO() {
        if (!this.f2394xxIXOIIO) {
            return;
        }
        Oxx0xo XO2 = XO();
        if (XO2.I0Io()) {
            f2375OOXIXo.ooOOo0oXI("Cannot remove data validation from " + xIoXXXIXo.XO.oxoX(this.f2393xoIox) + " as it is part of the shared reference " + xIoXXXIXo.XO.oIX0oI(XO2.X0o0xo(), XO2.XO()) + HelpFormatter.DEFAULT_OPT_PREFIX + xIoXXXIXo.XO.oIX0oI(XO2.Oxx0IOOO(), XO2.II0XooXoX()));
            return;
        }
        this.f2393xoIox.XIo0oOXIx();
        oIX0oI();
    }

    public void ooOOo0oXI() {
        if (!this.f2394xxIXOIIO) {
            return;
        }
        this.f2393xoIox.XIo0oOXIx();
        oIX0oI();
    }

    public double oxoX() {
        return this.f2385I0Io;
    }

    public void x0XOIxOo(X0xOO.oOoXoXO oooxoxo) {
        this.f2389X0o0xo = oooxoxo;
    }

    public void x0xO0oo(String str, double d, double d2) {
        this.f2391oIX0oI = str;
        this.f2387II0xO0 = d;
        this.f2385I0Io = d2;
        X0xOO.ooOOo0oXI ooooo0oxi = this.f2392oxoX;
        if (ooooo0oxi != null) {
            ooooo0oxi.xxX(str);
            this.f2392oxoX.Oo(d);
            this.f2392oxoX.Oo(d2);
        }
    }

    public boolean xoIox() {
        return this.f2386II0XooXoX;
    }

    public void xoXoI(String str, double d, double d2) {
        this.f2391oIX0oI = str;
        this.f2387II0xO0 = d;
        this.f2385I0Io = d2;
    }

    public boolean xxIXOIIO() {
        return this.f2394xxIXOIIO;
    }

    public oxoX(oxoX oxox) {
        this.f2391oIX0oI = oxox.f2391oIX0oI;
        this.f2387II0xO0 = oxox.f2387II0xO0;
        this.f2385I0Io = oxox.f2385I0Io;
        this.f2386II0XooXoX = oxox.f2386II0XooXoX;
        this.f2394xxIXOIIO = oxox.f2394xxIXOIIO;
        this.f2390XO = oxox.f2390XO;
        if (oxox.f2388Oxx0IOOO != null) {
            this.f2388Oxx0IOOO = new Oxx0xo(oxox.f2388Oxx0IOOO);
        }
    }
}
