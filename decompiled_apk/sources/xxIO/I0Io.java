package xxIO;

/* loaded from: classes9.dex */
public abstract class I0Io<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final float[] f35293II0xO0;

    /* renamed from: I0Io, reason: collision with root package name */
    public float f35292I0Io = 1.0f;

    /* renamed from: oxoX, reason: collision with root package name */
    public float f35297oxoX = 1.0f;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f35294X0o0xo = 0;

    /* renamed from: XO, reason: collision with root package name */
    public int f35295XO = 0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f35296oIX0oI = 0;

    public I0Io(int i) {
        this.f35293II0xO0 = new float[i];
    }

    public void I0Io(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f35295XO = i;
    }

    public void II0xO0(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f35294X0o0xo = i;
    }

    public void X0o0xo(float f, float f2) {
        this.f35292I0Io = f;
        this.f35297oxoX = f2;
    }

    public int XO() {
        return this.f35293II0xO0.length;
    }

    public abstract void oIX0oI(T t);

    public void oxoX() {
        this.f35296oIX0oI = 0;
    }
}
