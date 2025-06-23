package X0xOO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes6.dex */
public class oI0IIXIo implements xoXoI {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3463oI0IIXIo = XxIIOXIXx.X0o0xo.Oxx0IOOO(Oxx0xo.class);

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f3464I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public double f3465II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public xXxxox0I f3466II0xO0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f3467IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public double f3468OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public oOXoIIIo f3469Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3470Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f3471Oxx0xo;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte[] f3472X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f3473XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OxI f3474oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public IIXOooo f3475oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f3476oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public OxI f3477ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public File f3478oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public oo0xXOI0I f3479x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public OxxIIOOXO f3480x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public double f3481xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public double f3482xxIXOIIO;

    public oI0IIXIo(xXxxox0I xxxxox0i, OxxIIOOXO oxxIIOOXO, IIXOooo iIXOooo) {
        this.f3475oO = iIXOooo;
        this.f3466II0xO0 = xxxxox0i;
        this.f3480x0xO0oo = oxxIIOOXO;
        this.f3464I0Io = false;
        this.f3479x0XOIxOo = oo0xXOI0I.f3515oIX0oI;
        oxxIIOOXO.II0xO0(xxxxox0i.xo0x());
        this.f3475oO.XO(this);
        XxIIOXIXx.oIX0oI.oIX0oI(xxxxox0i != null);
        x0xO0oo();
    }

    private OxI II0xO0() {
        if (!this.f3464I0Io) {
            x0xO0oo();
        }
        return this.f3474oIX0oI;
    }

    private void x0xO0oo() {
        this.f3464I0Io = true;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public byte[] I0Io() {
        boolean z = false;
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        oo0xXOI0I oo0xxoi0i = this.f3479x0XOIxOo;
        if (oo0xxoi0i == oo0xXOI0I.f3515oIX0oI || oo0xxoi0i == oo0xXOI0I.f3513I0Io) {
            z = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        if (!this.f3464I0Io) {
            x0xO0oo();
        }
        return this.f3475oO.II0XooXoX(this.f3470Oxx0IOOO);
    }

    @Override // X0xOO.xoXoI
    public void II0XooXoX(int i) {
        this.f3476oOoXoXO = i;
    }

    @Override // X0xOO.xoXoI
    public void IIXOooo(IIXOooo iIXOooo) {
        this.f3475oO = iIXOooo;
    }

    public void IXxxXO(int i) {
        double d = i;
        if (this.f3482xxIXOIIO > d) {
            xxIXOIIO(d);
        }
    }

    @Override // X0xOO.xoXoI
    public boolean OOXIXo() {
        return false;
    }

    @Override // X0xOO.xoXoI
    public void Oo(double d) {
        if (this.f3479x0XOIxOo == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3464I0Io) {
                x0xO0oo();
            }
            this.f3479x0XOIxOo = oo0xXOI0I.f3513I0Io;
        }
        this.f3481xoIox = d;
    }

    @Override // X0xOO.xoXoI
    public double OxI() {
        if (!this.f3464I0Io) {
            x0xO0oo();
        }
        return this.f3482xxIXOIIO;
    }

    @Override // X0xOO.xoXoI
    public final int Oxx0IOOO() {
        if (!this.f3464I0Io) {
            x0xO0oo();
        }
        return this.f3473XO;
    }

    @Override // X0xOO.xoXoI
    public oo0xXOI0I Oxx0xo() {
        return this.f3479x0XOIxOo;
    }

    @Override // X0xOO.xoXoI
    public final void X0IIOO(int i, int i2, int i3) {
        this.f3473XO = i;
        this.f3470Oxx0IOOO = i2;
        this.f3467IXxxXO = i3;
        if (this.f3479x0XOIxOo == oo0xXOI0I.f3515oIX0oI) {
            this.f3479x0XOIxOo = oo0xXOI0I.f3513I0Io;
        }
    }

    @Override // X0xOO.xoXoI
    public xXxxox0I X0o0xo() {
        return this.f3466II0xO0;
    }

    @Override // X0xOO.xoXoI
    public void XI0IXoo(double d) {
        if (this.f3479x0XOIxOo == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3464I0Io) {
                x0xO0oo();
            }
            this.f3479x0XOIxOo = oo0xXOI0I.f3513I0Io;
        }
        this.f3468OOXIXo = d;
    }

    @Override // X0xOO.xoXoI
    public byte[] XIxXXX0x0() throws IOException {
        boolean z;
        boolean z2 = false;
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        oo0xXOI0I oo0xxoi0i = this.f3479x0XOIxOo;
        if (oo0xxoi0i != oo0xXOI0I.f3515oIX0oI && oo0xxoi0i != oo0xXOI0I.f3513I0Io) {
            if (oo0xxoi0i == oo0xXOI0I.f3514II0xO0) {
                z = true;
            } else {
                z = false;
            }
            XxIIOXIXx.oIX0oI.oIX0oI(z);
            File file = this.f3478oxoX;
            if (file == null) {
                if (this.f3472X0o0xo != null) {
                    z2 = true;
                }
                XxIIOXIXx.oIX0oI.oIX0oI(z2);
                return this.f3472X0o0xo;
            }
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            FileInputStream fileInputStream = new FileInputStream(this.f3478oxoX);
            fileInputStream.read(bArr, 0, length);
            fileInputStream.close();
            return bArr;
        }
        return I0Io();
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public double getHeight() {
        if (!this.f3464I0Io) {
            x0xO0oo();
        }
        return this.f3468OOXIXo;
    }

    @Override // X0xOO.xoXoI
    public oOXoIIIo getType() {
        return this.f3469Oo;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public double getWidth() {
        if (!this.f3464I0Io) {
            x0xO0oo();
        }
        return this.f3481xoIox;
    }

    @Override // X0xOO.xoXoI
    public boolean isFirst() {
        return this.f3466II0xO0.XX0();
    }

    @Override // X0xOO.xoXoI
    public double o00() {
        if (!this.f3464I0Io) {
            x0xO0oo();
        }
        return this.f3465II0XooXoX;
    }

    @Override // X0xOO.xoXoI
    public OxI oI0IIXIo() {
        boolean z;
        if (!this.f3464I0Io) {
            x0xO0oo();
        }
        if (this.f3479x0XOIxOo == oo0xXOI0I.f3515oIX0oI) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        return II0xO0();
    }

    public double oIX0oI() {
        return o00();
    }

    @Override // X0xOO.xoXoI
    public int oO() {
        if (!this.f3464I0Io) {
            x0xO0oo();
        }
        return this.f3467IXxxXO;
    }

    @Override // X0xOO.xoXoI
    public String oOoXoXO() {
        XxIIOXIXx.oIX0oI.oIX0oI(false);
        return null;
    }

    public double ooOOo0oXI() {
        return OxI();
    }

    @Override // X0xOO.xoXoI
    public final int oxoX() {
        if (!this.f3464I0Io) {
            x0xO0oo();
        }
        return this.f3470Oxx0IOOO;
    }

    @Override // X0xOO.xoXoI
    public int x0XOIxOo() {
        return this.f3476oOoXoXO;
    }

    @Override // X0xOO.xoXoI
    public void xoIox(double d) {
        if (this.f3479x0XOIxOo == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3464I0Io) {
                x0xO0oo();
            }
            this.f3479x0XOIxOo = oo0xXOI0I.f3513I0Io;
        }
        this.f3465II0XooXoX = d;
    }

    @Override // X0xOO.xoXoI
    public IIXOooo xoXoI() {
        return this.f3475oO;
    }

    @Override // X0xOO.xoXoI
    public void xxIXOIIO(double d) {
        if (this.f3479x0XOIxOo == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3464I0Io) {
                x0xO0oo();
            }
            this.f3479x0XOIxOo = oo0xXOI0I.f3513I0Io;
        }
        this.f3482xxIXOIIO = d;
    }

    public oI0IIXIo(xoXoI xoxoi, IIXOooo iIXOooo) {
        this.f3464I0Io = false;
        oI0IIXIo oi0iixio = (oI0IIXIo) xoxoi;
        oo0xXOI0I oo0xxoi0i = oi0iixio.f3479x0XOIxOo;
        oo0xXOI0I oo0xxoi0i2 = oo0xXOI0I.f3515oIX0oI;
        XxIIOXIXx.oIX0oI.oIX0oI(oo0xxoi0i == oo0xxoi0i2);
        this.f3466II0xO0 = oi0iixio.f3466II0xO0;
        this.f3464I0Io = false;
        this.f3479x0XOIxOo = oo0xxoi0i2;
        this.f3480x0xO0oo = oi0iixio.f3480x0xO0oo;
        this.f3475oO = iIXOooo;
        this.f3471Oxx0xo = oi0iixio.f3471Oxx0xo;
        iIXOooo.XO(this);
    }

    public oI0IIXIo(double d, double d2, double d3, double d4, File file) {
        this.f3478oxoX = file;
        this.f3464I0Io = true;
        this.f3479x0XOIxOo = oo0xXOI0I.f3514II0xO0;
        this.f3465II0XooXoX = d;
        this.f3482xxIXOIIO = d2;
        this.f3481xoIox = d3;
        this.f3468OOXIXo = d4;
        this.f3476oOoXoXO = 1;
        this.f3469Oo = oOXoIIIo.f3490oxoX;
    }

    @Override // X0xOO.xoXoI
    public void O0xOxO(jxl.write.biff.IIX0o iIX0o) throws IOException {
    }

    @Override // X0xOO.xoXoI
    public void XO(jxl.write.biff.IIX0o iIX0o) throws IOException {
    }

    public oI0IIXIo(double d, double d2, double d3, double d4, byte[] bArr) {
        this.f3472X0o0xo = bArr;
        this.f3464I0Io = true;
        this.f3479x0XOIxOo = oo0xXOI0I.f3514II0xO0;
        this.f3465II0XooXoX = d;
        this.f3482xxIXOIIO = d2;
        this.f3481xoIox = d3;
        this.f3468OOXIXo = d4;
        this.f3476oOoXoXO = 1;
        this.f3469Oo = oOXoIIIo.f3490oxoX;
    }
}
