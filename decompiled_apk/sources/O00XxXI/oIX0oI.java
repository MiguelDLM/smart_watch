package O00XxXI;

import android.annotation.TargetApi;
import java.util.Arrays;

/* loaded from: classes9.dex */
public class oIX0oI {

    /* renamed from: O00XxXI.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C0030oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        public float f1141I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public float f1142II0xO0;

        /* renamed from: X0o0xo, reason: collision with root package name */
        public float f1144X0o0xo;

        /* renamed from: XO, reason: collision with root package name */
        public float f1145XO;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public float[] f1146oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public float f1147oxoX;

        public C0030oIX0oI(float f, float f2, float f3, float f4) {
            this.f1147oxoX = f - f3;
            this.f1144X0o0xo = f2 - f4;
            this.f1142II0xO0 = f * f4;
            this.f1141I0Io = f3 * f2;
            this.f1145XO = (float) Math.sqrt((r3 * r3) + (r0 * r0));
            this.f1146oIX0oI = new float[]{f, f2, f3, f4};
        }

        public float[] II0xO0() {
            return this.f1146oIX0oI;
        }

        public float oIX0oI(float f, float f2) {
            return Math.abs((((this.f1144X0o0xo * f) - (this.f1147oxoX * f2)) + this.f1142II0xO0) - this.f1141I0Io) / this.f1145XO;
        }
    }

    @TargetApi(9)
    public float[] II0xO0(float[] fArr, float f) {
        C0030oIX0oI c0030oIX0oI = new C0030oIX0oI(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1]);
        float f2 = 0.0f;
        int i = 0;
        for (int i2 = 2; i2 < fArr.length - 2; i2 += 2) {
            float oIX0oI2 = c0030oIX0oI.oIX0oI(fArr[i2], fArr[i2 + 1]);
            if (oIX0oI2 > f2) {
                i = i2;
                f2 = oIX0oI2;
            }
        }
        if (f2 > f) {
            float[] II0xO02 = II0xO0(Arrays.copyOfRange(fArr, 0, i + 2), f);
            float[] II0xO03 = II0xO0(Arrays.copyOfRange(fArr, i, fArr.length), f);
            return oIX0oI(II0xO02, Arrays.copyOfRange(II0xO03, 2, II0xO03.length));
        }
        return c0030oIX0oI.II0xO0();
    }

    public float[] oIX0oI(float[]... fArr) {
        int i = 0;
        for (float[] fArr2 : fArr) {
            i += fArr2.length;
        }
        float[] fArr3 = new float[i];
        int i2 = 0;
        for (float[] fArr4 : fArr) {
            for (float f : fArr4) {
                fArr3[i2] = f;
                i2++;
            }
        }
        return fArr3;
    }
}
