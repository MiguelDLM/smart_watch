package OoOoXO0;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final boolean f2598II0XooXoX = false;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final boolean f2599Oxx0IOOO = false;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f2600X0o0xo = 5000;

    /* renamed from: XO, reason: collision with root package name */
    public static final boolean f2601XO = false;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f2604oIX0oI = 5000;

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f2603II0xO0 = false;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f2602I0Io = false;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f2605oxoX = false;

    public boolean I0Io() {
        return this.f2605oxoX;
    }

    public void II0XooXoX(boolean z) {
        this.f2602I0Io = z;
    }

    public boolean II0xO0() {
        return this.f2603II0xO0;
    }

    public void Oxx0IOOO(boolean z) {
        this.f2605oxoX = z;
    }

    public void X0o0xo(boolean z) {
        this.f2603II0xO0 = z;
    }

    public void XO(int i) {
        if (i >= 1) {
            this.f2604oIX0oI = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int oIX0oI() {
        return this.f2604oIX0oI;
    }

    public boolean oxoX() {
        return this.f2602I0Io;
    }
}
