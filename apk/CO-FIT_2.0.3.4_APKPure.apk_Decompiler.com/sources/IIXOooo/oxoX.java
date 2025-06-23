package IIXOooo;

public class oxoX {
    public static int I0Io(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((float) ((i >> 24) & 255)) / 255.0f;
        float oIX0oI2 = oIX0oI(((float) ((i >> 16) & 255)) / 255.0f);
        float oIX0oI3 = oIX0oI(((float) ((i >> 8) & 255)) / 255.0f);
        float oIX0oI4 = oIX0oI(((float) (i & 255)) / 255.0f);
        float oIX0oI5 = oIX0oI(((float) ((i2 >> 16) & 255)) / 255.0f);
        float oIX0oI6 = oIX0oI(((float) ((i2 >> 8) & 255)) / 255.0f);
        float oIX0oI7 = oIX0oI4 + (f * (oIX0oI(((float) (i2 & 255)) / 255.0f) - oIX0oI4));
        return (Math.round(II0xO0(oIX0oI2 + ((oIX0oI5 - oIX0oI2) * f)) * 255.0f) << 16) | (Math.round((f2 + (((((float) ((i2 >> 24) & 255)) / 255.0f) - f2) * f)) * 255.0f) << 24) | (Math.round(II0xO0(oIX0oI3 + ((oIX0oI6 - oIX0oI3) * f)) * 255.0f) << 8) | Math.round(II0xO0(oIX0oI7) * 255.0f);
    }

    public static float II0xO0(float f) {
        if (f <= 0.0031308f) {
            return f * 12.92f;
        }
        return (float) ((Math.pow((double) f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static float oIX0oI(float f) {
        if (f <= 0.04045f) {
            return f / 12.92f;
        }
        return (float) Math.pow((double) ((f + 0.055f) / 1.055f), 2.4000000953674316d);
    }
}
