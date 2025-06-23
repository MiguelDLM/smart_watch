package oI0X0;

/* loaded from: classes6.dex */
public class oxoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31589II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f31590oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static oxoX[] f31574I0Io = new oxoX[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static final oxoX f31584oxoX = new oxoX(0, "none");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final oxoX f31579X0o0xo = new oxoX(1, "thin");

    /* renamed from: XO, reason: collision with root package name */
    public static final oxoX f31580XO = new oxoX(2, "medium");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final oxoX f31578Oxx0IOOO = new oxoX(3, "dashed");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final oxoX f31575II0XooXoX = new oxoX(4, "dotted");

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final oxoX f31588xxIXOIIO = new oxoX(5, "thick");

    /* renamed from: xoIox, reason: collision with root package name */
    public static final oxoX f31587xoIox = new oxoX(6, "double");

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oxoX f31576OOXIXo = new oxoX(7, "hair");

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final oxoX f31582oOoXoXO = new oxoX(8, "medium dashed");

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oxoX f31583ooOOo0oXI = new oxoX(9, "dash dot");

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oxoX f31585x0XOIxOo = new oxoX(10, "medium dash dot");

    /* renamed from: oO, reason: collision with root package name */
    public static final oxoX f31581oO = new oxoX(11, "Dash dot dot");

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final oxoX f31586x0xO0oo = new oxoX(12, "Medium dash dot dot");

    /* renamed from: Oo, reason: collision with root package name */
    public static final oxoX f31577Oo = new oxoX(13, "Slanted dash dot");

    public oxoX(int i, String str) {
        this.f31590oIX0oI = i;
        this.f31589II0xO0 = str;
        oxoX[] oxoxArr = f31574I0Io;
        oxoX[] oxoxArr2 = new oxoX[oxoxArr.length + 1];
        f31574I0Io = oxoxArr2;
        System.arraycopy(oxoxArr, 0, oxoxArr2, 0, oxoxArr.length);
        f31574I0Io[oxoxArr.length] = this;
    }

    public static oxoX II0xO0(int i) {
        int i2 = 0;
        while (true) {
            oxoX[] oxoxArr = f31574I0Io;
            if (i2 < oxoxArr.length) {
                if (oxoxArr[i2].I0Io() == i) {
                    return f31574I0Io[i2];
                }
                i2++;
            } else {
                return f31584oxoX;
            }
        }
    }

    public int I0Io() {
        return this.f31590oIX0oI;
    }

    public String oIX0oI() {
        return this.f31589II0xO0;
    }
}
