package OoIXo;

/* loaded from: classes6.dex */
public abstract class X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f2187I0Io = 44;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f2188II0XooXoX = 64;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f2191IXxxXO = 72;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final String f2192O0xOxO = "\u0001CompObj";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f2193OOXIXo = 128;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f2194Oo = 68;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f2196Oxx0IOOO = 512;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f2197Oxx0xo = 76;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f2198OxxIIOOXO = 120;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f2200X0o0xo = 64;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f2201XI0IXoo = 0;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f2202XIxXXX0x0 = 1;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f2203XO = 48;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f2204XxX0x0xxx = 5;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f2206oI0IIXIo = 116;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f2208oO = 66;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f2209oOoXoXO = 76;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f2210ooOOo0oXI = 4096;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f2211oxoX = 60;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f2212x0XOIxOo = 64;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f2213x0xO0oo = 67;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f2214xoIox = 72;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f2216xxIXOIIO = 68;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f2217xxX = 2;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2207oIX0oI = XxIIOXIXx.X0o0xo.Oxx0IOOO(X0o0xo.class);

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final byte[] f2189II0xO0 = {-48, -49, 17, -32, -95, -79, 26, -31};

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String f2190IIXOooo = "Root Entry";

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final String f2215xoXoI = "Workbook";

    /* renamed from: o00, reason: collision with root package name */
    public static final String f2205o00 = "\u0005SummaryInformation";

    /* renamed from: OxI, reason: collision with root package name */
    public static final String f2195OxI = "\u0005DocumentSummaryInformation";

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final String[] f2199X0IIOO = {f2190IIXOooo, f2215xoXoI, f2205o00, f2195OxI};

    /* loaded from: classes6.dex */
    public class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f2218I0Io;

        /* renamed from: II0XooXoX, reason: collision with root package name */
        public int f2219II0XooXoX;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f2220II0xO0;

        /* renamed from: Oxx0IOOO, reason: collision with root package name */
        public int f2221Oxx0IOOO;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public int f2222X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public int f2223XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public String f2224oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public int f2225oxoX;

        /* renamed from: xxIXOIIO, reason: collision with root package name */
        public byte[] f2227xxIXOIIO;

        public oIX0oI(byte[] bArr) {
            this.f2227xxIXOIIO = bArr;
            int i = 64;
            int I0Io2 = oo0xXOI0I.I0Io(bArr[64], bArr[65]);
            if (I0Io2 > 64) {
                X0o0xo.f2207oIX0oI.ooOOo0oXI("property set name exceeds max length - truncating");
            } else {
                i = I0Io2;
            }
            byte[] bArr2 = this.f2227xxIXOIIO;
            this.f2220II0xO0 = bArr2[66];
            this.f2218I0Io = bArr2[67];
            this.f2225oxoX = oo0xXOI0I.oxoX(bArr2[116], bArr2[117], bArr2[118], bArr2[119]);
            byte[] bArr3 = this.f2227xxIXOIIO;
            this.f2222X0o0xo = oo0xXOI0I.oxoX(bArr3[120], bArr3[121], bArr3[122], bArr3[123]);
            byte[] bArr4 = this.f2227xxIXOIIO;
            this.f2223XO = oo0xXOI0I.oxoX(bArr4[68], bArr4[69], bArr4[70], bArr4[71]);
            byte[] bArr5 = this.f2227xxIXOIIO;
            this.f2221Oxx0IOOO = oo0xXOI0I.oxoX(bArr5[72], bArr5[73], bArr5[74], bArr5[75]);
            byte[] bArr6 = this.f2227xxIXOIIO;
            this.f2219II0XooXoX = oo0xXOI0I.oxoX(bArr6[76], bArr6[77], bArr6[78], bArr6[79]);
            int i2 = i > 2 ? (i - 1) / 2 : 0;
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i3 = 0; i3 < i2; i3++) {
                stringBuffer.append((char) this.f2227xxIXOIIO[i3 * 2]);
            }
            this.f2224oIX0oI = stringBuffer.toString();
        }

        public void I0Io(int i) {
            this.f2221Oxx0IOOO = i;
            oo0xXOI0I.oIX0oI(i, this.f2227xxIXOIIO, 72);
        }

        public void II0xO0(int i) {
            int i2;
            if (i == 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            this.f2218I0Io = i2;
            this.f2227xxIXOIIO[67] = (byte) i2;
        }

        public void Oxx0IOOO(int i) {
            this.f2220II0xO0 = i;
            this.f2227xxIXOIIO[66] = (byte) i;
        }

        public void X0o0xo(int i) {
            this.f2222X0o0xo = i;
            oo0xXOI0I.oIX0oI(i, this.f2227xxIXOIIO, 120);
        }

        public void XO(int i) {
            this.f2225oxoX = i;
            oo0xXOI0I.oIX0oI(i, this.f2227xxIXOIIO, 116);
        }

        public void oIX0oI(int i) {
            this.f2219II0XooXoX = i;
            oo0xXOI0I.oIX0oI(i, this.f2227xxIXOIIO, 76);
        }

        public void oxoX(int i) {
            this.f2223XO = i;
            oo0xXOI0I.oIX0oI(i, this.f2227xxIXOIIO, 68);
        }

        public oIX0oI(String str) {
            this.f2227xxIXOIIO = new byte[128];
            XxIIOXIXx.oIX0oI.oIX0oI(str.length() < 32);
            oo0xXOI0I.XO((str.length() + 1) * 2, this.f2227xxIXOIIO, 64);
            for (int i = 0; i < str.length(); i++) {
                this.f2227xxIXOIIO[i * 2] = (byte) str.charAt(i);
            }
        }
    }
}
