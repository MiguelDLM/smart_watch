package IIXOooo;

public class II0XooXoX {

    /* renamed from: II0xO0  reason: collision with root package name */
    public int f16II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public float f17oIX0oI;

    public float II0xO0() {
        int i = this.f16II0xO0;
        if (i == 0) {
            return 0.0f;
        }
        return this.f17oIX0oI / ((float) i);
    }

    public void oIX0oI(float f) {
        float f2 = this.f17oIX0oI + f;
        this.f17oIX0oI = f2;
        int i = this.f16II0xO0 + 1;
        this.f16II0xO0 = i;
        if (i == Integer.MAX_VALUE) {
            this.f17oIX0oI = f2 / 2.0f;
            this.f16II0xO0 = i / 2;
        }
    }
}
