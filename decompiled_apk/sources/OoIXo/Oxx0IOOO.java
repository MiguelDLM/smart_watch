package OoIXo;

/* loaded from: classes6.dex */
public class Oxx0IOOO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f2105II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f2106oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static Oxx0IOOO[] f2090I0Io = new Oxx0IOOO[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Oxx0IOOO f2100oxoX = new Oxx0IOOO("Consolidate_Area", 0);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final Oxx0IOOO f2095X0o0xo = new Oxx0IOOO("Auto_Open", 1);

    /* renamed from: XO, reason: collision with root package name */
    public static final Oxx0IOOO f2096XO = new Oxx0IOOO("Auto_Open", 2);

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final Oxx0IOOO f2094Oxx0IOOO = new Oxx0IOOO("Extract", 3);

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final Oxx0IOOO f2091II0XooXoX = new Oxx0IOOO("Database", 4);

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final Oxx0IOOO f2104xxIXOIIO = new Oxx0IOOO("Criteria", 5);

    /* renamed from: xoIox, reason: collision with root package name */
    public static final Oxx0IOOO f2103xoIox = new Oxx0IOOO("Print_Area", 6);

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final Oxx0IOOO f2092OOXIXo = new Oxx0IOOO("Print_Titles", 7);

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final Oxx0IOOO f2098oOoXoXO = new Oxx0IOOO("Recorder", 8);

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final Oxx0IOOO f2099ooOOo0oXI = new Oxx0IOOO("Data_Form", 9);

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final Oxx0IOOO f2101x0XOIxOo = new Oxx0IOOO("Auto_Activate", 10);

    /* renamed from: oO, reason: collision with root package name */
    public static final Oxx0IOOO f2097oO = new Oxx0IOOO("Auto_Deactivate", 11);

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final Oxx0IOOO f2102x0xO0oo = new Oxx0IOOO("Sheet_Title", 11);

    /* renamed from: Oo, reason: collision with root package name */
    public static final Oxx0IOOO f2093Oo = new Oxx0IOOO("_FilterDatabase", 13);

    public Oxx0IOOO(String str, int i) {
        this.f2106oIX0oI = str;
        this.f2105II0xO0 = i;
        Oxx0IOOO[] oxx0IOOOArr = f2090I0Io;
        Oxx0IOOO[] oxx0IOOOArr2 = new Oxx0IOOO[oxx0IOOOArr.length + 1];
        f2090I0Io = oxx0IOOOArr2;
        System.arraycopy(oxx0IOOOArr, 0, oxx0IOOOArr2, 0, oxx0IOOOArr.length);
        f2090I0Io[oxx0IOOOArr.length] = this;
    }

    public static Oxx0IOOO oIX0oI(int i) {
        Oxx0IOOO oxx0IOOO = f2093Oo;
        int i2 = 0;
        while (true) {
            Oxx0IOOO[] oxx0IOOOArr = f2090I0Io;
            if (i2 < oxx0IOOOArr.length) {
                if (oxx0IOOOArr[i2].I0Io() == i) {
                    oxx0IOOO = f2090I0Io[i2];
                }
                i2++;
            } else {
                return oxx0IOOO;
            }
        }
    }

    public int I0Io() {
        return this.f2105II0xO0;
    }

    public String II0xO0() {
        return this.f2106oIX0oI;
    }
}
