package oI0X0;

/* loaded from: classes6.dex */
public class ooOOo0oXI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31572II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f31573oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static ooOOo0oXI[] f31552I0Io = new ooOOo0oXI[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static final ooOOo0oXI f31567oxoX = new ooOOo0oXI(0, "None");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final ooOOo0oXI f31561X0o0xo = new ooOOo0oXI(1, "Solid");

    /* renamed from: XO, reason: collision with root package name */
    public static final ooOOo0oXI f31562XO = new ooOOo0oXI(2, "Gray 50%");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final ooOOo0oXI f31558Oxx0IOOO = new ooOOo0oXI(3, "Gray 75%");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final ooOOo0oXI f31553II0XooXoX = new ooOOo0oXI(4, "Gray 25%");

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final ooOOo0oXI f31571xxIXOIIO = new ooOOo0oXI(5, "Pattern 1");

    /* renamed from: xoIox, reason: collision with root package name */
    public static final ooOOo0oXI f31570xoIox = new ooOOo0oXI(6, "Pattern 2");

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final ooOOo0oXI f31556OOXIXo = new ooOOo0oXI(7, "Pattern 3");

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final ooOOo0oXI f31565oOoXoXO = new ooOOo0oXI(8, "Pattern 4");

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final ooOOo0oXI f31566ooOOo0oXI = new ooOOo0oXI(9, "Pattern 5");

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final ooOOo0oXI f31568x0XOIxOo = new ooOOo0oXI(10, "Pattern 6");

    /* renamed from: oO, reason: collision with root package name */
    public static final ooOOo0oXI f31564oO = new ooOOo0oXI(11, "Pattern 7");

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final ooOOo0oXI f31569x0xO0oo = new ooOOo0oXI(12, "Pattern 8");

    /* renamed from: Oo, reason: collision with root package name */
    public static final ooOOo0oXI f31557Oo = new ooOOo0oXI(13, "Pattern 9");

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final ooOOo0oXI f31555IXxxXO = new ooOOo0oXI(14, "Pattern 10");

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final ooOOo0oXI f31559Oxx0xo = new ooOOo0oXI(15, "Pattern 11");

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final ooOOo0oXI f31563oI0IIXIo = new ooOOo0oXI(16, "Pattern 12");

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final ooOOo0oXI f31560OxxIIOOXO = new ooOOo0oXI(17, "Pattern 13");

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final ooOOo0oXI f31554IIXOooo = new ooOOo0oXI(18, "Pattern 14");

    public ooOOo0oXI(int i, String str) {
        this.f31573oIX0oI = i;
        this.f31572II0xO0 = str;
        ooOOo0oXI[] ooooo0oxiArr = f31552I0Io;
        ooOOo0oXI[] ooooo0oxiArr2 = new ooOOo0oXI[ooooo0oxiArr.length + 1];
        f31552I0Io = ooooo0oxiArr2;
        System.arraycopy(ooooo0oxiArr, 0, ooooo0oxiArr2, 0, ooooo0oxiArr.length);
        f31552I0Io[ooooo0oxiArr.length] = this;
    }

    public static ooOOo0oXI II0xO0(int i) {
        int i2 = 0;
        while (true) {
            ooOOo0oXI[] ooooo0oxiArr = f31552I0Io;
            if (i2 < ooooo0oxiArr.length) {
                if (ooooo0oxiArr[i2].I0Io() == i) {
                    return f31552I0Io[i2];
                }
                i2++;
            } else {
                return f31567oxoX;
            }
        }
    }

    public int I0Io() {
        return this.f31573oIX0oI;
    }

    public String oIX0oI() {
        return this.f31572II0xO0;
    }
}
