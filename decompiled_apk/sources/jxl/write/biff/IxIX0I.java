package jxl.write.biff;

/* loaded from: classes6.dex */
public class IxIX0I extends OoIXo.OI0 {

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f28636OOXIXo = XxIIOXIXx.X0o0xo.Oxx0IOOO(IxIX0I.class);

    /* renamed from: oO, reason: collision with root package name */
    public static final II0xO0 f28637oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final II0xO0 f28638oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final II0xO0 f28639ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final II0xO0 f28640x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final II0xO0 f28641x0xO0oo;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f28642II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public int f28643Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public II0xO0 f28644X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public byte[] f28645XO;

    /* renamed from: xoIox, reason: collision with root package name */
    public xIoXXXIXo.O0xOxO f28646xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String[] f28647xxIXOIIO;

    /* loaded from: classes6.dex */
    public static class II0xO0 {
        public II0xO0() {
        }
    }

    static {
        f28638oOoXoXO = new II0xO0();
        f28639ooOOo0oXI = new II0xO0();
        f28640x0XOIxOo = new II0xO0();
        f28637oO = new II0xO0();
        f28641x0xO0oo = new II0xO0();
    }

    public IxIX0I() {
        super(OoIXo.xII.f2454Oxx0IOOO);
        this.f28644X0o0xo = f28640x0XOIxOo;
    }

    public String I0X0x0oIo() {
        return this.f28642II0XooXoX;
    }

    public final void I0oOIX() {
        this.f28645XO = new byte[]{1, 0, 1, 58};
    }

    public final void IoOoo(jxl.read.biff.xX0IIXIx0 xx0iixix0) {
        this.f28643Oxx0IOOO = xx0iixix0.I0X0x0oIo();
        OO();
    }

    public II0xO0 O0Xx() {
        return this.f28644X0o0xo;
    }

    public final void OO() {
        byte[] bArr = new byte[4];
        this.f28645XO = bArr;
        OoIXo.oo0xXOI0I.XO(this.f28643Oxx0IOOO, bArr, 0);
        byte[] bArr2 = this.f28645XO;
        bArr2[2] = 1;
        bArr2[3] = 4;
        this.f28644X0o0xo = f28638oOoXoXO;
    }

    public void XX0(int i) {
        boolean z;
        if (this.f28644X0o0xo == f28638oOoXoXO) {
            z = true;
        } else {
            z = false;
        }
        XxIIOXIXx.oIX0oI.oIX0oI(z);
        this.f28643Oxx0IOOO = i;
        OO();
    }

    public int Xo0(String str) {
        String[] strArr;
        int i = 0;
        boolean z = false;
        while (true) {
            strArr = this.f28647xxIXOIIO;
            if (i >= strArr.length || z) {
                break;
            }
            if (strArr[i].equals(str)) {
                z = true;
            }
            i++;
        }
        if (z) {
            return 0;
        }
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[this.f28647xxIXOIIO.length] = str;
        this.f28647xxIXOIIO = strArr2;
        return strArr2.length - 1;
    }

    public String XoI0Ixx0(int i) {
        return this.f28647xxIXOIIO[i];
    }

    public int oX() {
        return this.f28643Oxx0IOOO;
    }

    @Override // OoIXo.OI0
    public byte[] xo0x() {
        II0xO0 iI0xO0 = this.f28644X0o0xo;
        if (iI0xO0 == f28638oOoXoXO) {
            OO();
        } else if (iI0xO0 == f28639ooOOo0oXI) {
            xoxXI();
        } else if (iI0xO0 == f28640x0XOIxOo) {
            I0oOIX();
        } else {
            f28636OOXIXo.ooOOo0oXI("unsupported supbook type - defaulting to internal");
            OO();
        }
        return this.f28645XO;
    }

    public final void xoxXI() {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f28643Oxx0IOOO; i3++) {
            i2 += this.f28647xxIXOIIO[i3].length();
        }
        byte[] oIX0oI2 = OoIXo.X0IIOO.oIX0oI(this.f28642II0XooXoX, this.f28646xoIox);
        int length = oIX0oI2.length + 6;
        int i4 = this.f28643Oxx0IOOO;
        byte[] bArr = new byte[length + (i4 * 3) + (i2 * 2)];
        this.f28645XO = bArr;
        OoIXo.oo0xXOI0I.XO(i4, bArr, 0);
        OoIXo.oo0xXOI0I.XO(oIX0oI2.length + 1, this.f28645XO, 2);
        byte[] bArr2 = this.f28645XO;
        bArr2[4] = 0;
        bArr2[5] = 1;
        System.arraycopy(oIX0oI2, 0, bArr2, 6, oIX0oI2.length);
        int length2 = oIX0oI2.length + 6;
        while (true) {
            String[] strArr = this.f28647xxIXOIIO;
            if (i < strArr.length) {
                OoIXo.oo0xXOI0I.XO(strArr[i].length(), this.f28645XO, length2);
                byte[] bArr3 = this.f28645XO;
                bArr3[length2 + 2] = 1;
                OoIXo.IO.X0o0xo(this.f28647xxIXOIIO[i], bArr3, length2 + 3);
                length2 += (this.f28647xxIXOIIO[i].length() * 2) + 3;
                i++;
            } else {
                return;
            }
        }
    }

    public IxIX0I(int i, xIoXXXIXo.O0xOxO o0xOxO) {
        super(OoIXo.xII.f2454Oxx0IOOO);
        this.f28643Oxx0IOOO = i;
        this.f28644X0o0xo = f28638oOoXoXO;
        this.f28646xoIox = o0xOxO;
    }

    public IxIX0I(String str, xIoXXXIXo.O0xOxO o0xOxO) {
        super(OoIXo.xII.f2454Oxx0IOOO);
        this.f28642II0XooXoX = str;
        this.f28643Oxx0IOOO = 1;
        this.f28647xxIXOIIO = new String[0];
        this.f28646xoIox = o0xOxO;
        this.f28644X0o0xo = f28639ooOOo0oXI;
    }

    public IxIX0I(jxl.read.biff.xX0IIXIx0 xx0iixix0, xIoXXXIXo.O0xOxO o0xOxO) {
        super(OoIXo.xII.f2454Oxx0IOOO);
        this.f28646xoIox = o0xOxO;
        if (xx0iixix0.Xo0() == jxl.read.biff.xX0IIXIx0.f28497II0XooXoX) {
            this.f28644X0o0xo = f28638oOoXoXO;
            this.f28643Oxx0IOOO = xx0iixix0.I0X0x0oIo();
        } else if (xx0iixix0.Xo0() == jxl.read.biff.xX0IIXIx0.f28502xxIXOIIO) {
            this.f28644X0o0xo = f28639ooOOo0oXI;
            this.f28643Oxx0IOOO = xx0iixix0.I0X0x0oIo();
            this.f28642II0XooXoX = xx0iixix0.XX0();
            this.f28647xxIXOIIO = new String[this.f28643Oxx0IOOO];
            for (int i = 0; i < this.f28643Oxx0IOOO; i++) {
                this.f28647xxIXOIIO[i] = xx0iixix0.oX(i);
            }
        }
        if (xx0iixix0.Xo0() == jxl.read.biff.xX0IIXIx0.f28501xoIox) {
            f28636OOXIXo.ooOOo0oXI("Supbook type is addin");
        }
    }
}
