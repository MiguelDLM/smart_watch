package oI00o;

/* loaded from: classes6.dex */
public class Oxx0IOOO {

    /* renamed from: I0Io, reason: collision with root package name */
    public int f31352I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f31353II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public float f31354X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public float f31355XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f31356oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f31357oxoX;

    public void I0Io(boolean z, int i, int i2) {
        this.f31352I0Io = i;
        this.f31357oxoX = i2;
        if (z) {
            int i3 = this.f31353II0xO0;
            this.f31353II0xO0 = this.f31356oIX0oI;
            this.f31356oIX0oI = i3;
        }
        oxoX();
    }

    public int II0xO0(int i) {
        float f = this.f31354X0o0xo;
        if (f != 0.0f) {
            return (int) (f * i);
        }
        return i;
    }

    public void X0o0xo(int i, int i2) {
        this.f31356oIX0oI = i;
        this.f31353II0xO0 = i2;
        oxoX();
    }

    public int oIX0oI(int i) {
        float f = this.f31355XO;
        if (f != 0.0f) {
            return (int) (f * i);
        }
        return i;
    }

    public final void oxoX() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.f31354X0o0xo == 0.0f && (i3 = this.f31356oIX0oI) != 0 && (i4 = this.f31352I0Io) != 0) {
            this.f31354X0o0xo = (i4 * 1.0f) / i3;
        }
        if (this.f31355XO == 0.0f && (i = this.f31353II0xO0) != 0 && (i2 = this.f31357oxoX) != 0) {
            this.f31355XO = (i2 * 1.0f) / i;
        }
    }
}
