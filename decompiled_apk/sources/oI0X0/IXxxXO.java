package oI0X0;

/* loaded from: classes6.dex */
public class IXxxXO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31382II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f31383oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static IXxxXO[] f31377I0Io = new IXxxXO[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static IXxxXO f31381oxoX = new IXxxXO(0, "top");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static IXxxXO f31379X0o0xo = new IXxxXO(1, "centre");

    /* renamed from: XO, reason: collision with root package name */
    public static IXxxXO f31380XO = new IXxxXO(2, "bottom");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static IXxxXO f31378Oxx0IOOO = new IXxxXO(3, "Justify");

    public IXxxXO(int i, String str) {
        this.f31383oIX0oI = i;
        this.f31382II0xO0 = str;
        IXxxXO[] iXxxXOArr = f31377I0Io;
        IXxxXO[] iXxxXOArr2 = new IXxxXO[iXxxXOArr.length + 1];
        f31377I0Io = iXxxXOArr2;
        System.arraycopy(iXxxXOArr, 0, iXxxXOArr2, 0, iXxxXOArr.length);
        f31377I0Io[iXxxXOArr.length] = this;
    }

    public static IXxxXO oIX0oI(int i) {
        int i2 = 0;
        while (true) {
            IXxxXO[] iXxxXOArr = f31377I0Io;
            if (i2 < iXxxXOArr.length) {
                if (iXxxXOArr[i2].I0Io() == i) {
                    return f31377I0Io[i2];
                }
                i2++;
            } else {
                return f31380XO;
            }
        }
    }

    public int I0Io() {
        return this.f31383oIX0oI;
    }

    public String II0xO0() {
        return this.f31382II0xO0;
    }
}
