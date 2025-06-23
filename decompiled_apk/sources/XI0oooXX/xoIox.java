package XI0oooXX;

/* loaded from: classes9.dex */
public final class xoIox {

    /* renamed from: II0xO0, reason: collision with root package name */
    public float f3730II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public float f3731oIX0oI;

    public xoIox(float f, float f2) {
        this.f3731oIX0oI = f;
        this.f3730II0xO0 = f2;
    }

    public boolean I0Io(float f) {
        if (f < this.f3731oIX0oI) {
            return true;
        }
        return false;
    }

    public boolean II0xO0(float f) {
        if (f > this.f3730II0xO0) {
            return true;
        }
        return false;
    }

    public boolean oIX0oI(float f) {
        if (f > this.f3731oIX0oI && f <= this.f3730II0xO0) {
            return true;
        }
        return false;
    }
}
