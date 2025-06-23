package oI0X0;

/* loaded from: classes6.dex */
public final class xxIXOIIO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31612II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f31613oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static xxIXOIIO[] f31604I0Io = new xxIXOIIO[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static xxIXOIIO f31609oxoX = new xxIXOIIO(0, "horizontal");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static xxIXOIIO f31607X0o0xo = new xxIXOIIO(255, "vertical");

    /* renamed from: XO, reason: collision with root package name */
    public static xxIXOIIO f31608XO = new xxIXOIIO(90, "up 90");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static xxIXOIIO f31606Oxx0IOOO = new xxIXOIIO(180, "down 90");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static xxIXOIIO f31605II0XooXoX = new xxIXOIIO(45, "up 45");

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static xxIXOIIO f31611xxIXOIIO = new xxIXOIIO(135, "down 45");

    /* renamed from: xoIox, reason: collision with root package name */
    public static xxIXOIIO f31610xoIox = new xxIXOIIO(255, "stacked");

    public xxIXOIIO(int i, String str) {
        this.f31613oIX0oI = i;
        this.f31612II0xO0 = str;
        xxIXOIIO[] xxixoiioArr = f31604I0Io;
        xxIXOIIO[] xxixoiioArr2 = new xxIXOIIO[xxixoiioArr.length + 1];
        f31604I0Io = xxixoiioArr2;
        System.arraycopy(xxixoiioArr, 0, xxixoiioArr2, 0, xxixoiioArr.length);
        f31604I0Io[xxixoiioArr.length] = this;
    }

    public static xxIXOIIO II0xO0(int i) {
        int i2 = 0;
        while (true) {
            xxIXOIIO[] xxixoiioArr = f31604I0Io;
            if (i2 < xxixoiioArr.length) {
                if (xxixoiioArr[i2].I0Io() == i) {
                    return f31604I0Io[i2];
                }
                i2++;
            } else {
                return f31609oxoX;
            }
        }
    }

    public int I0Io() {
        return this.f31613oIX0oI;
    }

    public String oIX0oI() {
        return this.f31612II0xO0;
    }
}
