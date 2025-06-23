package X0xOO;

import com.goodix.ble.libcomx.task.TaskPipe;
import com.realsil.sdk.dfu.image.constants.SubBinId;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes6.dex */
public class Oxx0xo implements xoXoI, xIoXXXIXo.x0xO0oo {

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final double f3351XI0IXoo = 10.0d;

    /* renamed from: I0Io, reason: collision with root package name */
    public ooXIXxIX f3353I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f3354II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public xXxxox0I f3355II0xO0;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public IoOoX f3356IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oOXoIIIo f3357IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public double f3358OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public OxxIIOOXO f3359Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f3360Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public int f3361Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public xIoXXXIXo.IIXOooo f3362OxxIIOOXO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public File f3363X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f3364XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f3365oI0IIXIo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OxI f3366oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    public oo0xXOI0I f3367oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public double f3368oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public int f3369ooOOo0oXI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f3370oxoX;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public OxI f3371x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public IIXOooo f3372x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public double f3373xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public oIX0oI f3374xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public double f3375xxIXOIIO;

    /* renamed from: o00, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f3352o00 = XxIIOXIXx.X0o0xo.Oxx0IOOO(Oxx0xo.class);

    /* renamed from: OxI, reason: collision with root package name */
    public static oIX0oI f3349OxI = new oIX0oI(1);

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static oIX0oI f3348O0xOxO = new oIX0oI(2);

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static oIX0oI f3350X0IIOO = new oIX0oI(3);

    /* loaded from: classes6.dex */
    public static class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static oIX0oI[] f3376II0xO0 = new oIX0oI[0];

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f3377oIX0oI;

        public oIX0oI(int i) {
            this.f3377oIX0oI = i;
            oIX0oI[] oix0oiArr = f3376II0xO0;
            oIX0oI[] oix0oiArr2 = new oIX0oI[oix0oiArr.length + 1];
            f3376II0xO0 = oix0oiArr2;
            System.arraycopy(oix0oiArr, 0, oix0oiArr2, 0, oix0oiArr.length);
            f3376II0xO0[oix0oiArr.length] = this;
        }

        public static oIX0oI oIX0oI(int i) {
            oIX0oI oix0oi = Oxx0xo.f3349OxI;
            int i2 = 0;
            while (true) {
                oIX0oI[] oix0oiArr = f3376II0xO0;
                if (i2 < oix0oiArr.length) {
                    if (oix0oiArr[i2].II0xO0() == i) {
                        return f3376II0xO0[i2];
                    }
                    i2++;
                } else {
                    return oix0oi;
                }
            }
        }

        public int II0xO0() {
            return this.f3377oIX0oI;
        }
    }

    public Oxx0xo(xXxxox0I xxxxox0i, ooXIXxIX ooxixxix, OxxIIOOXO oxxIIOOXO, IIXOooo iIXOooo, xIoXXXIXo.IIXOooo iIXOooo2) {
        this.f3372x0xO0oo = iIXOooo;
        this.f3355II0xO0 = xxxxox0i;
        this.f3359Oo = oxxIIOOXO;
        this.f3353I0Io = ooxixxix;
        this.f3362OxxIIOOXO = iIXOooo2;
        boolean z = false;
        this.f3370oxoX = false;
        this.f3367oO = oo0xXOI0I.f3515oIX0oI;
        oxxIIOOXO.oIX0oI(xxxxox0i.xo0x());
        this.f3365oI0IIXIo = this.f3359Oo.I0Io() - 1;
        this.f3372x0xO0oo.XO(this);
        if (xxxxox0i != null && ooxixxix != null) {
            z = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        oo0xXOI0I();
    }

    private void oo0xXOI0I() {
        boolean z;
        OxI oxoX2 = this.f3359Oo.oxoX(this.f3365oI0IIXIo);
        this.f3366oIX0oI = oxoX2;
        if (oxoX2 != null) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        X0IIOO[] oO2 = this.f3366oIX0oI.oO();
        X00IoxXI x00IoxXI = (X00IoxXI) this.f3366oIX0oI.oO()[0];
        this.f3361Oxx0xo = x00IoxXI.x0XOIxOo();
        this.f3360Oxx0IOOO = this.f3353I0Io.oX();
        oOXoIIIo oIX0oI2 = oOXoIIIo.oIX0oI(x00IoxXI.oO());
        this.f3357IXxxXO = oIX0oI2;
        if (oIX0oI2 == oOXoIIIo.f3487Oxx0IOOO) {
            f3352o00.ooOOo0oXI("Unknown shape type");
        }
        xI xIVar = (xI) this.f3366oIX0oI.oO()[1];
        if (xIVar.x0xO0oo(260) != null) {
            this.f3354II0XooXoX = xIVar.x0xO0oo(260).f3628oxoX;
        }
        if (xIVar.x0xO0oo(261) != null) {
            this.f3363X0o0xo = new File(xIVar.x0xO0oo(261).f3626X0o0xo);
        } else if (this.f3357IXxxXO == oOXoIIIo.f3490oxoX) {
            f3352o00.ooOOo0oXI("no filename property for drawing");
            this.f3363X0o0xo = new File(Integer.toString(this.f3354II0XooXoX));
        }
        xxIXOIIO xxixoiio = null;
        for (int i = 0; i < oO2.length && xxixoiio == null; i++) {
            if (oO2[i].xxIXOIIO() == XIxXXX0x0.f3421oO) {
                xxixoiio = (xxIXOIIO) oO2[i];
            }
        }
        if (xxixoiio == null) {
            f3352o00.ooOOo0oXI("client anchor not found");
        } else {
            this.f3375xxIXOIIO = xxixoiio.oO();
            this.f3373xoIox = xxixoiio.Oo();
            this.f3358OOXIXo = xxixoiio.x0xO0oo() - this.f3375xxIXOIIO;
            this.f3368oOoXoXO = xxixoiio.IXxxXO() - this.f3373xoIox;
            this.f3374xoXoI = oIX0oI.oIX0oI(xxixoiio.x0XOIxOo());
        }
        if (this.f3354II0XooXoX == 0) {
            f3352o00.ooOOo0oXI("linked drawings are not supported");
        }
        this.f3370oxoX = true;
    }

    private OxI ooXIXxIX() {
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        return this.f3366oIX0oI;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public byte[] I0Io() {
        boolean z;
        oo0xXOI0I oo0xxoi0i = this.f3367oO;
        if (oo0xxoi0i != oo0xXOI0I.f3515oIX0oI && oo0xxoi0i != oo0xXOI0I.f3513I0Io) {
            z = false;
        } else {
            z = true;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        return this.f3372x0xO0oo.II0XooXoX(this.f3354II0XooXoX);
    }

    @Override // X0xOO.xoXoI
    public void II0XooXoX(int i) {
        this.f3369ooOOo0oXI = i;
    }

    @Override // xIoXXXIXo.x0xO0oo
    public double II0xO0() {
        return OxI();
    }

    public final IoOoX IIX0o() {
        byte[] I0Io2;
        IoOoX ioOoX = this.f3356IIXOooo;
        if (ioOoX != null) {
            return ioOoX;
        }
        oo0xXOI0I oo0xxoi0i = this.f3367oO;
        if (oo0xxoi0i != oo0xXOI0I.f3515oIX0oI && oo0xxoi0i != oo0xXOI0I.f3513I0Io) {
            try {
                I0Io2 = XIxXXX0x0();
            } catch (IOException unused) {
                f3352o00.ooOOo0oXI("Could not read image file");
                I0Io2 = new byte[0];
            }
        } else {
            I0Io2 = I0Io();
        }
        IoOoX ioOoX2 = new IoOoX(I0Io2);
        this.f3356IIXOooo = ioOoX2;
        ioOoX2.Oxx0IOOO();
        return this.f3356IIXOooo;
    }

    @Override // X0xOO.xoXoI
    public void IIXOooo(IIXOooo iIXOooo) {
        this.f3372x0xO0oo = iIXOooo;
    }

    @Override // xIoXXXIXo.x0xO0oo
    public File IXxxXO() {
        return this.f3363X0o0xo;
    }

    public void IoOoX(oIX0oI oix0oi) {
        this.f3374xoXoI = oix0oi;
        if (this.f3367oO == oo0xXOI0I.f3515oIX0oI) {
            this.f3367oO = oo0xXOI0I.f3513I0Io;
        }
    }

    @Override // X0xOO.xoXoI
    public boolean OOXIXo() {
        return false;
    }

    @Override // X0xOO.xoXoI
    public void Oo(double d) {
        if (this.f3367oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3370oxoX) {
                oo0xXOI0I();
            }
            this.f3367oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3358OOXIXo = d;
    }

    @Override // X0xOO.xoXoI
    public double OxI() {
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        return this.f3373xoIox;
    }

    @Override // X0xOO.xoXoI
    public final int Oxx0IOOO() {
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        return this.f3360Oxx0IOOO;
    }

    @Override // X0xOO.xoXoI
    public oo0xXOI0I Oxx0xo() {
        return this.f3367oO;
    }

    @Override // xIoXXXIXo.x0xO0oo
    public double OxxIIOOXO(XxIIOXIXx.oxoX oxox) {
        return XxX0x0xxx() * XxIIOXIXx.I0Io.oIX0oI(XxIIOXIXx.oxoX.f4198I0Io, oxox);
    }

    @Override // X0xOO.xoXoI
    public final void X0IIOO(int i, int i2, int i3) {
        this.f3360Oxx0IOOO = i;
        this.f3354II0XooXoX = i2;
        this.f3361Oxx0xo = i3;
        if (this.f3367oO == oo0xXOI0I.f3515oIX0oI) {
            this.f3367oO = oo0xXOI0I.f3513I0Io;
        }
    }

    @Override // X0xOO.xoXoI
    public xXxxox0I X0o0xo() {
        return this.f3355II0xO0;
    }

    @Override // X0xOO.xoXoI
    public void XI0IXoo(double d) {
        if (this.f3367oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3370oxoX) {
                oo0xXOI0I();
            }
            this.f3367oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3368oOoXoXO = d;
    }

    @Override // X0xOO.xoXoI
    public byte[] XIxXXX0x0() throws IOException {
        boolean z;
        oo0xXOI0I oo0xxoi0i = this.f3367oO;
        if (oo0xxoi0i != oo0xXOI0I.f3515oIX0oI && oo0xxoi0i != oo0xXOI0I.f3513I0Io) {
            boolean z2 = true;
            if (oo0xxoi0i == oo0xXOI0I.f3514II0xO0) {
                z = true;
            } else {
                z = false;
            }
            XxIIOXIXx.oIX0oI.oIX0oI(z);
            File file = this.f3363X0o0xo;
            if (file == null) {
                if (this.f3364XO == null) {
                    z2 = false;
                }
                XxIIOXIXx.oIX0oI.oIX0oI(z2);
                return this.f3364XO;
            }
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            FileInputStream fileInputStream = new FileInputStream(this.f3363X0o0xo);
            fileInputStream.read(bArr, 0, length);
            fileInputStream.close();
            return bArr;
        }
        return I0Io();
    }

    @Override // X0xOO.xoXoI
    public void XO(jxl.write.biff.IIX0o iIX0o) throws IOException {
        if (this.f3367oO == oo0xXOI0I.f3515oIX0oI) {
            iIX0o.XO(this.f3353I0Io);
        } else {
            iIX0o.XO(new ooXIXxIX(this.f3360Oxx0IOOO, ooXIXxIX.f3550Oo));
        }
    }

    public final double XxX0x0xxx() {
        int i;
        xIoXXXIXo.IIXOooo iIXOooo = this.f3362OxxIIOOXO;
        double d = XIXIX.OOXIXo.f3760XO;
        if (iIXOooo == null) {
            f3352o00.ooOOo0oXI("calculating image height:  sheet is null");
            return XIXIX.OOXIXo.f3760XO;
        }
        double d2 = this.f3373xoIox;
        int i2 = (int) d2;
        int ceil = ((int) Math.ceil(d2 + this.f3368oOoXoXO)) - 1;
        double oxoX2 = this.f3362OxxIIOOXO.Oo(i2).oxoX();
        if (ceil != i2) {
            i = this.f3362OxxIIOOXO.Oo(ceil).oxoX();
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < (ceil - i2) - 1; i3++) {
            d += this.f3362OxxIIOOXO.Oo(i2 + 1 + i3).oxoX();
        }
        return ((d + oxoX2) + i) / 20.0d;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public double getHeight() {
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        return this.f3368oOoXoXO;
    }

    @Override // xIoXXXIXo.x0xO0oo
    public int getImageHeight() {
        return IIX0o().oIX0oI();
    }

    @Override // xIoXXXIXo.x0xO0oo
    public int getImageWidth() {
        return IIX0o().X0o0xo();
    }

    @Override // X0xOO.xoXoI
    public oOXoIIIo getType() {
        return this.f3357IXxxXO;
    }

    @Override // X0xOO.xoXoI, xIoXXXIXo.x0xO0oo
    public double getWidth() {
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        return this.f3358OOXIXo;
    }

    @Override // X0xOO.xoXoI
    public boolean isFirst() {
        return this.f3355II0xO0.XX0();
    }

    @Override // X0xOO.xoXoI
    public double o00() {
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        return this.f3375xxIXOIIO;
    }

    @Override // X0xOO.xoXoI
    public OxI oI0IIXIo() {
        String str;
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        if (this.f3367oO == oo0xXOI0I.f3515oIX0oI) {
            return ooXIXxIX();
        }
        IO io2 = new IO();
        io2.x0XOIxOo(new X00IoxXI(this.f3357IXxxXO, this.f3361Oxx0xo, SubBinId.Bbpro.FACTORY_IAMGE));
        xI xIVar = new xI();
        xIVar.x0XOIxOo(260, true, false, this.f3354II0XooXoX);
        if (this.f3357IXxxXO == oOXoIIIo.f3490oxoX) {
            File file = this.f3363X0o0xo;
            if (file != null) {
                str = file.getPath();
            } else {
                str = "";
            }
            String str2 = str;
            xIVar.oO(261, true, true, str2.length() * 2, str2);
            xIVar.x0XOIxOo(TaskPipe.EVT_TASK_ADDED, false, false, 65536);
            xIVar.x0XOIxOo(959, false, false, 524288);
            io2.x0XOIxOo(xIVar);
        }
        double d = this.f3375xxIXOIIO;
        double d2 = this.f3373xoIox;
        io2.x0XOIxOo(new xxIXOIIO(d, d2, d + this.f3358OOXIXo, d2 + this.f3368oOoXoXO, this.f3374xoXoI.II0xO0()));
        io2.x0XOIxOo(new xoIox());
        return io2;
    }

    @Override // xIoXXXIXo.x0xO0oo
    public double oIX0oI() {
        return o00();
    }

    @Override // X0xOO.xoXoI
    public int oO() {
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        return this.f3361Oxx0xo;
    }

    @Override // X0xOO.xoXoI
    public String oOoXoXO() {
        File file = this.f3363X0o0xo;
        if (file == null) {
            int i = this.f3354II0XooXoX;
            if (i != 0) {
                return Integer.toString(i);
            }
            return "__new__image__";
        }
        return file.getPath();
    }

    public void oo(int i) {
        double d = i;
        if (this.f3373xoIox > d) {
            xxIXOIIO(d);
        }
    }

    @Override // xIoXXXIXo.x0xO0oo
    public double ooOOo0oXI(XxIIOXIXx.oxoX oxox) {
        return IIX0o().oxoX() / XxIIOXIXx.I0Io.oIX0oI(XxIIOXIXx.oxoX.f4202oxoX, oxox);
    }

    @Override // X0xOO.xoXoI
    public final int oxoX() {
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        return this.f3354II0XooXoX;
    }

    @Override // X0xOO.xoXoI
    public int x0XOIxOo() {
        return this.f3369ooOOo0oXI;
    }

    @Override // xIoXXXIXo.x0xO0oo
    public double x0xO0oo(XxIIOXIXx.oxoX oxox) {
        return IIX0o().II0xO0() / XxIIOXIXx.I0Io.oIX0oI(XxIIOXIXx.oxoX.f4202oxoX, oxox);
    }

    public final double xI() {
        double d;
        double d2;
        double d3;
        double d4;
        if (this.f3362OxxIIOOXO == null) {
            f3352o00.ooOOo0oXI("calculating image width:  sheet is null");
            return XIXIX.OOXIXo.f3760XO;
        }
        double d5 = this.f3375xxIXOIIO;
        int i = (int) d5;
        int ceil = ((int) Math.ceil(d5 + this.f3358OOXIXo)) - 1;
        xIoXXXIXo.II0XooXoX X0IIOO2 = this.f3362OxxIIOOXO.X0IIOO(i);
        double oxoX2 = (1.0d - (this.f3375xxIXOIIO - i)) * X0IIOO2.oxoX();
        if (X0IIOO2.I0Io() != null) {
            d = X0IIOO2.I0Io().XIxXXX0x0().xoXoI();
        } else {
            d = 10.0d;
        }
        double d6 = ((oxoX2 * 0.59d) * d) / 256.0d;
        if (ceil != i) {
            xIoXXXIXo.II0XooXoX X0IIOO3 = this.f3362OxxIIOOXO.X0IIOO(ceil);
            double oxoX3 = ((this.f3375xxIXOIIO + this.f3358OOXIXo) - ceil) * X0IIOO3.oxoX();
            if (X0IIOO3.I0Io() != null) {
                d4 = X0IIOO3.I0Io().XIxXXX0x0().xoXoI();
            } else {
                d4 = 10.0d;
            }
            d2 = ((oxoX3 * 0.59d) * d4) / 256.0d;
        } else {
            d2 = XIXIX.OOXIXo.f3760XO;
        }
        double d7 = XIXIX.OOXIXo.f3760XO;
        for (int i2 = 0; i2 < (ceil - i) - 1; i2++) {
            xIoXXXIXo.II0XooXoX X0IIOO4 = this.f3362OxxIIOOXO.X0IIOO(i + 1 + i2);
            if (X0IIOO4.I0Io() != null) {
                d3 = X0IIOO4.I0Io().XIxXXX0x0().xoXoI();
            } else {
                d3 = 10.0d;
            }
            d7 += ((X0IIOO4.oxoX() * 0.59d) * d3) / 256.0d;
        }
        return d7 + d6 + d2;
    }

    public oIX0oI xXxxox0I() {
        if (!this.f3370oxoX) {
            oo0xXOI0I();
        }
        return this.f3374xoXoI;
    }

    @Override // X0xOO.xoXoI
    public void xoIox(double d) {
        if (this.f3367oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3370oxoX) {
                oo0xXOI0I();
            }
            this.f3367oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3375xxIXOIIO = d;
    }

    @Override // X0xOO.xoXoI
    public IIXOooo xoXoI() {
        return this.f3372x0xO0oo;
    }

    @Override // X0xOO.xoXoI
    public void xxIXOIIO(double d) {
        if (this.f3367oO == oo0xXOI0I.f3515oIX0oI) {
            if (!this.f3370oxoX) {
                oo0xXOI0I();
            }
            this.f3367oO = oo0xXOI0I.f3513I0Io;
        }
        this.f3373xoIox = d;
    }

    @Override // xIoXXXIXo.x0xO0oo
    public double xxX(XxIIOXIXx.oxoX oxox) {
        return xI() * XxIIOXIXx.I0Io.oIX0oI(XxIIOXIXx.oxoX.f4198I0Io, oxox);
    }

    public Oxx0xo(xoXoI xoxoi, IIXOooo iIXOooo) {
        this.f3370oxoX = false;
        Oxx0xo oxx0xo = (Oxx0xo) xoxoi;
        oo0xXOI0I oo0xxoi0i = oxx0xo.f3367oO;
        oo0xXOI0I oo0xxoi0i2 = oo0xXOI0I.f3515oIX0oI;
        XxIIOXIXx.oIX0oI.oIX0oI(oo0xxoi0i == oo0xxoi0i2);
        this.f3355II0xO0 = oxx0xo.f3355II0xO0;
        this.f3353I0Io = oxx0xo.f3353I0Io;
        this.f3370oxoX = false;
        this.f3367oO = oo0xxoi0i2;
        this.f3359Oo = oxx0xo.f3359Oo;
        this.f3372x0xO0oo = iIXOooo;
        this.f3365oI0IIXIo = oxx0xo.f3365oI0IIXIo;
        iIXOooo.XO(this);
    }

    @Override // X0xOO.xoXoI
    public void O0xOxO(jxl.write.biff.IIX0o iIX0o) throws IOException {
    }

    public Oxx0xo(double d, double d2, double d3, double d4, File file) {
        this.f3363X0o0xo = file;
        this.f3370oxoX = true;
        this.f3367oO = oo0xXOI0I.f3514II0xO0;
        this.f3375xxIXOIIO = d;
        this.f3373xoIox = d2;
        this.f3358OOXIXo = d3;
        this.f3368oOoXoXO = d4;
        this.f3369ooOOo0oXI = 1;
        this.f3374xoXoI = f3348O0xOxO;
        this.f3357IXxxXO = oOXoIIIo.f3490oxoX;
    }

    public Oxx0xo(double d, double d2, double d3, double d4, byte[] bArr) {
        this.f3364XO = bArr;
        this.f3370oxoX = true;
        this.f3367oO = oo0xXOI0I.f3514II0xO0;
        this.f3375xxIXOIIO = d;
        this.f3373xoIox = d2;
        this.f3358OOXIXo = d3;
        this.f3368oOoXoXO = d4;
        this.f3369ooOOo0oXI = 1;
        this.f3374xoXoI = f3348O0xOxO;
        this.f3357IXxxXO = oOXoIIIo.f3490oxoX;
    }
}
