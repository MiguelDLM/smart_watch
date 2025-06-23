package oI0X0;

/* loaded from: classes6.dex */
public final class x0xO0oo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f31600II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f31601oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static x0xO0oo[] f31594I0Io = new x0xO0oo[0];

    /* renamed from: oxoX, reason: collision with root package name */
    public static final x0xO0oo f31599oxoX = new x0xO0oo(0, "none");

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final x0xO0oo f31597X0o0xo = new x0xO0oo(1, "single");

    /* renamed from: XO, reason: collision with root package name */
    public static final x0xO0oo f31598XO = new x0xO0oo(2, "double");

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final x0xO0oo f31596Oxx0IOOO = new x0xO0oo(33, "single accounting");

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final x0xO0oo f31595II0XooXoX = new x0xO0oo(34, "double accounting");

    public x0xO0oo(int i, String str) {
        this.f31601oIX0oI = i;
        this.f31600II0xO0 = str;
        x0xO0oo[] x0xo0ooArr = f31594I0Io;
        x0xO0oo[] x0xo0ooArr2 = new x0xO0oo[x0xo0ooArr.length + 1];
        f31594I0Io = x0xo0ooArr2;
        System.arraycopy(x0xo0ooArr, 0, x0xo0ooArr2, 0, x0xo0ooArr.length);
        f31594I0Io[x0xo0ooArr.length] = this;
    }

    public static x0xO0oo II0xO0(int i) {
        int i2 = 0;
        while (true) {
            x0xO0oo[] x0xo0ooArr = f31594I0Io;
            if (i2 < x0xo0ooArr.length) {
                if (x0xo0ooArr[i2].I0Io() == i) {
                    return f31594I0Io[i2];
                }
                i2++;
            } else {
                return f31599oxoX;
            }
        }
    }

    public int I0Io() {
        return this.f31601oIX0oI;
    }

    public String oIX0oI() {
        return this.f31600II0xO0;
    }
}
