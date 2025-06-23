package oI0X0;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31461II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f31462oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static oIX0oI[] f31454I0Io = new oIX0oI[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static oIX0oI f31459oxoX = new oIX0oI(0, "general");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static oIX0oI f31457X0o0xo = new oIX0oI(1, "left");

    /* renamed from: XO, reason: collision with root package name */
    public static oIX0oI f31458XO = new oIX0oI(2, "centre");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static oIX0oI f31456Oxx0IOOO = new oIX0oI(3, "right");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static oIX0oI f31455II0XooXoX = new oIX0oI(4, "fill");

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static oIX0oI f31460xxIXOIIO = new oIX0oI(5, "justify");

    public oIX0oI(int i, String str) {
        this.f31462oIX0oI = i;
        this.f31461II0xO0 = str;
        oIX0oI[] oix0oiArr = f31454I0Io;
        oIX0oI[] oix0oiArr2 = new oIX0oI[oix0oiArr.length + 1];
        f31454I0Io = oix0oiArr2;
        System.arraycopy(oix0oiArr, 0, oix0oiArr2, 0, oix0oiArr.length);
        f31454I0Io[oix0oiArr.length] = this;
    }

    public static oIX0oI oIX0oI(int i) {
        int i2 = 0;
        while (true) {
            oIX0oI[] oix0oiArr = f31454I0Io;
            if (i2 < oix0oiArr.length) {
                if (oix0oiArr[i2].I0Io() == i) {
                    return f31454I0Io[i2];
                }
                i2++;
            } else {
                return f31459oxoX;
            }
        }
    }

    public int I0Io() {
        return this.f31462oIX0oI;
    }

    public String II0xO0() {
        return this.f31461II0xO0;
    }
}
