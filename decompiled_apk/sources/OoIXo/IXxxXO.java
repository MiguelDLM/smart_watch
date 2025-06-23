package OoIXo;

import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes6.dex */
public class IXxxXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public String f2077I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f2078II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f2079oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static XxIIOXIXx.X0o0xo f2071oxoX = XxIIOXIXx.X0o0xo.Oxx0IOOO(IXxxXO.class);

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static IXxxXO[] f2065X0o0xo = new IXxxXO[0];

    /* renamed from: XO, reason: collision with root package name */
    public static final IXxxXO f2066XO = new IXxxXO(1, "US", "USA");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final IXxxXO f2062Oxx0IOOO = new IXxxXO(2, "CA", "Canada");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final IXxxXO f2057II0XooXoX = new IXxxXO(30, "GR", "Greece");

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final IXxxXO f2076xxIXOIIO = new IXxxXO(31, "NE", "Netherlands");

    /* renamed from: xoIox, reason: collision with root package name */
    public static final IXxxXO f2074xoIox = new IXxxXO(32, "BE", "Belgium");

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final IXxxXO f2060OOXIXo = new IXxxXO(33, "FR", "France");

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final IXxxXO f2069oOoXoXO = new IXxxXO(34, "ES", "Spain");

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final IXxxXO f2070ooOOo0oXI = new IXxxXO(39, "IT", "Italy");

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final IXxxXO f2072x0XOIxOo = new IXxxXO(41, "CH", "Switzerland");

    /* renamed from: oO, reason: collision with root package name */
    public static final IXxxXO f2068oO = new IXxxXO(44, "UK", "United Kingdowm");

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final IXxxXO f2073x0xO0oo = new IXxxXO(45, "DK", "Denmark");

    /* renamed from: Oo, reason: collision with root package name */
    public static final IXxxXO f2061Oo = new IXxxXO(46, "SE", "Sweden");

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final IXxxXO f2059IXxxXO = new IXxxXO(47, "NO", "Norway");

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final IXxxXO f2063Oxx0xo = new IXxxXO(49, "DE", "Germany");

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final IXxxXO f2067oI0IIXIo = new IXxxXO(63, "PH", "Philippines");

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final IXxxXO f2064OxxIIOOXO = new IXxxXO(86, "CN", "China");

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final IXxxXO f2058IIXOooo = new IXxxXO(91, "IN", "India");

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final IXxxXO f2075xoXoI = new IXxxXO(65535, "??", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);

    public IXxxXO(int i, String str, String str2) {
        this.f2079oIX0oI = i;
        this.f2078II0xO0 = str;
        this.f2077I0Io = str2;
        IXxxXO[] iXxxXOArr = f2065X0o0xo;
        IXxxXO[] iXxxXOArr2 = new IXxxXO[iXxxXOArr.length + 1];
        System.arraycopy(iXxxXOArr, 0, iXxxXOArr2, 0, iXxxXOArr.length);
        iXxxXOArr2[f2065X0o0xo.length] = this;
        f2065X0o0xo = iXxxXOArr2;
    }

    public static IXxxXO I0Io(String str) {
        if (str != null && str.length() == 2) {
            IXxxXO iXxxXO = f2075xoXoI;
            int i = 0;
            while (true) {
                IXxxXO[] iXxxXOArr = f2065X0o0xo;
                if (i >= iXxxXOArr.length || iXxxXO != f2075xoXoI) {
                    break;
                }
                if (iXxxXOArr[i].f2078II0xO0.equals(str)) {
                    iXxxXO = f2065X0o0xo[i];
                }
                i++;
            }
            return iXxxXO;
        }
        f2071oxoX.ooOOo0oXI("Please specify two character ISO 3166 country code");
        return f2066XO;
    }

    public static IXxxXO oIX0oI(int i) {
        return new IXxxXO(i);
    }

    public String II0xO0() {
        return this.f2078II0xO0;
    }

    public int oxoX() {
        return this.f2079oIX0oI;
    }

    public IXxxXO(int i) {
        this.f2079oIX0oI = i;
        this.f2077I0Io = "Arbitrary";
        this.f2078II0xO0 = "??";
    }
}
