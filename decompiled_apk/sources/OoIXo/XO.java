package OoIXo;

import com.tenmeter.smlibrary.utils.DateFormatUtils;

/* loaded from: classes6.dex */
public final class XO implements oI0X0.II0XooXoX, o00 {

    /* renamed from: I0Io, reason: collision with root package name */
    public static XO[] f2245I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f2246II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f2247oIX0oI;

    static {
        XO[] xoArr = new XO[50];
        f2245I0Io = xoArr;
        xoArr[0] = new XO("", 0);
        f2245I0Io[1] = new XO("0", 1);
        f2245I0Io[2] = new XO("0.00", 2);
        f2245I0Io[3] = new XO("#,##0", 3);
        f2245I0Io[4] = new XO("#,##0.00", 4);
        f2245I0Io[5] = new XO("($#,##0_);($#,##0)", 5);
        f2245I0Io[6] = new XO("($#,##0_);[Red]($#,##0)", 6);
        f2245I0Io[7] = new XO("($#,##0_);[Red]($#,##0)", 7);
        f2245I0Io[8] = new XO("($#,##0.00_);[Red]($#,##0.00)", 8);
        f2245I0Io[9] = new XO("0%", 9);
        f2245I0Io[10] = new XO("0.00%", 10);
        f2245I0Io[11] = new XO("0.00E+00", 11);
        f2245I0Io[12] = new XO("# ?/?", 12);
        f2245I0Io[13] = new XO("# ??/??", 13);
        f2245I0Io[14] = new XO("dd/mm/yyyy", 14);
        f2245I0Io[15] = new XO("d-mmm-yy", 15);
        f2245I0Io[16] = new XO("d-mmm", 16);
        f2245I0Io[17] = new XO("mmm-yy", 17);
        f2245I0Io[18] = new XO("h:mm AM/PM", 18);
        f2245I0Io[19] = new XO("h:mm:ss AM/PM", 19);
        f2245I0Io[20] = new XO("h:mm", 20);
        f2245I0Io[21] = new XO("h:mm:ss", 21);
        f2245I0Io[22] = new XO("m/d/yy h:mm", 22);
        f2245I0Io[37] = new XO("(#,##0_);(#,##0)", 37);
        f2245I0Io[38] = new XO("(#,##0_);[Red](#,##0)", 38);
        f2245I0Io[39] = new XO("(#,##0.00_);(#,##0.00)", 39);
        f2245I0Io[40] = new XO("(#,##0.00_);[Red](#,##0.00)", 40);
        f2245I0Io[41] = new XO("_(*#,##0_);_(*(#,##0);_(*\"-\"_);(@_)", 41);
        f2245I0Io[42] = new XO("_($*#,##0_);_($*(#,##0);_($*\"-\"_);(@_)", 42);
        f2245I0Io[43] = new XO("_(* #,##0.00_);_(* (#,##0.00);_(* \"-\"??_);(@_)", 43);
        f2245I0Io[44] = new XO("_($* #,##0.00_);_($* (#,##0.00);_($* \"-\"??_);(@_)", 44);
        f2245I0Io[45] = new XO(DateFormatUtils.MM_SS, 45);
        f2245I0Io[46] = new XO("[h]mm:ss", 46);
        f2245I0Io[47] = new XO("mm:ss.0", 47);
        f2245I0Io[48] = new XO("##0.0E+0", 48);
        f2245I0Io[49] = new XO("@", 49);
    }

    public XO(String str, int i) {
        this.f2246II0xO0 = i;
        this.f2247oIX0oI = str;
    }

    @Override // OoIXo.o00
    public int OxI() {
        return this.f2246II0xO0;
    }

    @Override // oI0X0.II0XooXoX
    public String XxX0x0xxx() {
        return this.f2247oIX0oI;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof XO) && this.f2246II0xO0 == ((XO) obj).f2246II0xO0) {
            return true;
        }
        return false;
    }

    @Override // OoIXo.o00
    public boolean isInitialized() {
        return true;
    }

    @Override // OoIXo.o00
    public boolean xII() {
        return true;
    }

    @Override // OoIXo.o00
    public void initialize(int i) {
    }
}
