package oo00;

/* loaded from: classes12.dex */
public class II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public float f32194I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f32196II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public float f32198X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public float f32199XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f32200oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public float f32201oxoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public float f32197Oxx0IOOO = 20.0f;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public float f32195II0XooXoX = 22000.0f;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public float f32202xxIXOIIO = 0.0f;

    public II0xO0(int w, int h) {
        this.f32200oIX0oI = w;
        this.f32196II0xO0 = h;
        oIX0oI();
    }

    public float I0Io(float x) {
        return ((float) (Math.log10(x) * this.f32194I0Io)) + this.f32199XO;
    }

    public float[] II0xO0(float[] data) {
        int length = data.length;
        float[] fArr = new float[length];
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < length; i += 2) {
            fArr[i] = I0Io(data[i]);
            int i2 = i + 1;
            fArr[i2] = oxoX(data[i2]);
            f = Math.max(f, data[i2]);
            f2 = Math.min(f2, data[i2]);
        }
        return fArr;
    }

    public void X0o0xo(float padding) {
        this.f32202xxIXOIIO = padding;
    }

    public void XO(float startFreq, float endFreq) {
        this.f32197Oxx0IOOO = Math.max(startFreq, 20.0f);
        this.f32195II0XooXoX = Math.min(endFreq, 22000.0f);
        oIX0oI();
    }

    public final void oIX0oI() {
        this.f32194I0Io = (this.f32200oIX0oI - (this.f32202xxIXOIIO * 2.0f)) / ((float) (Math.log10(this.f32195II0XooXoX) - Math.log10(this.f32197Oxx0IOOO)));
        this.f32199XO = ((float) ((-Math.log10(this.f32197Oxx0IOOO)) * this.f32194I0Io)) + this.f32202xxIXOIIO;
        float f = this.f32196II0xO0 / (-24.0f);
        this.f32201oxoX = f;
        this.f32198X0o0xo = f * (-12.0f);
    }

    public float oxoX(float y) {
        return (y * this.f32201oxoX) + this.f32198X0o0xo;
    }
}
