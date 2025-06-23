package com.baidu.ar;

import XIXIX.OOXIXo;
import com.baidu.ar.arplay.representation.Vector4f;

/* loaded from: classes7.dex */
public class no {
    public static void a(double[] dArr, Vector4f vector4f) {
        if (dArr.length == 16) {
            double[] dArr2 = {vector4f.toArray()[0], vector4f.toArray()[1], vector4f.toArray()[2], vector4f.toArray()[3]};
            double d = OOXIXo.f3760XO;
            double d2 = 0.0d;
            double d3 = 0.0d;
            double d4 = 0.0d;
            for (int i = 0; i < 4; i++) {
                int i2 = i * 4;
                double d5 = dArr[i2];
                double d6 = dArr2[i];
                d += d5 * d6;
                d2 += dArr[i2 + 1] * d6;
                d3 += dArr[i2 + 2] * d6;
                d4 += dArr[i2 + 3] * d6;
            }
            vector4f.setX((float) d);
            vector4f.setY((float) d2);
            vector4f.setZ((float) d3);
            vector4f.setW((float) d4);
        }
    }

    public static boolean a(float[] fArr, int i, double[] dArr, int i2) {
        double d = dArr[i2];
        double d2 = dArr[i2 + 1];
        double d3 = dArr[i2 + 2];
        double d4 = dArr[i2 + 3];
        double d5 = dArr[i2 + 4];
        double d6 = dArr[i2 + 5];
        double d7 = dArr[i2 + 6];
        double d8 = dArr[i2 + 7];
        double d9 = dArr[i2 + 8];
        double d10 = dArr[i2 + 9];
        double d11 = dArr[i2 + 10];
        double d12 = dArr[i2 + 11];
        double d13 = dArr[i2 + 12];
        double d14 = dArr[i2 + 13];
        double d15 = dArr[i2 + 14];
        double d16 = dArr[i2 + 15];
        double d17 = d11 * d16;
        double d18 = d15 * d12;
        double d19 = d7 * d16;
        double d20 = d15 * d8;
        double d21 = d7 * d12;
        double d22 = d11 * d8;
        double d23 = d3 * d16;
        double d24 = d15 * d4;
        double d25 = d3 * d12;
        double d26 = d11 * d4;
        double d27 = d3 * d8;
        double d28 = d7 * d4;
        double d29 = (((d17 * d6) + (d20 * d10)) + (d21 * d14)) - (((d18 * d6) + (d19 * d10)) + (d22 * d14));
        double d30 = (((d18 * d2) + (d23 * d10)) + (d26 * d14)) - (((d17 * d2) + (d24 * d10)) + (d25 * d14));
        double d31 = (((d19 * d2) + (d24 * d6)) + (d27 * d14)) - (((d20 * d2) + (d23 * d6)) + (d28 * d14));
        double d32 = (((d22 * d2) + (d25 * d6)) + (d28 * d10)) - (((d21 * d2) + (d26 * d6)) + (d27 * d10));
        double d33 = (((d18 * d5) + (d19 * d9)) + (d22 * d13)) - (((d17 * d5) + (d20 * d9)) + (d21 * d13));
        double d34 = (((d17 * d) + (d24 * d9)) + (d25 * d13)) - (((d18 * d) + (d23 * d9)) + (d26 * d13));
        double d35 = (((d20 * d) + (d23 * d5)) + (d28 * d13)) - (((d19 * d) + (d24 * d5)) + (d27 * d13));
        double d36 = (((d21 * d) + (d26 * d5)) + (d27 * d9)) - (((d22 * d) + (d25 * d5)) + (d28 * d9));
        double d37 = d9 * d14;
        double d38 = d13 * d10;
        double d39 = d5 * d14;
        double d40 = d13 * d6;
        double d41 = d5 * d10;
        double d42 = d9 * d6;
        double d43 = d14 * d;
        double d44 = d13 * d2;
        double d45 = d10 * d;
        double d46 = d9 * d2;
        double d47 = d6 * d;
        double d48 = d2 * d5;
        double d49 = (((d37 * d8) + (d40 * d12)) + (d41 * d16)) - (((d38 * d8) + (d39 * d12)) + (d42 * d16));
        double d50 = (((d38 * d4) + (d43 * d12)) + (d46 * d16)) - (((d37 * d4) + (d44 * d12)) + (d45 * d16));
        double d51 = (((d39 * d4) + (d44 * d8)) + (d47 * d16)) - (((d40 * d4) + (d43 * d8)) + (d16 * d48));
        double d52 = (((d42 * d4) + (d45 * d8)) + (d48 * d12)) - (((d4 * d41) + (d8 * d46)) + (d12 * d47));
        double d53 = (((d39 * d11) + (d42 * d15)) + (d38 * d7)) - (((d41 * d15) + (d37 * d7)) + (d40 * d11));
        double d54 = (((d45 * d15) + (d37 * d3)) + (d44 * d11)) - (((d43 * d11) + (d46 * d15)) + (d38 * d3));
        double d55 = (((d43 * d7) + (d48 * d15)) + (d40 * d3)) - (((d15 * d47) + (d39 * d3)) + (d44 * d7));
        double d56 = (((d47 * d11) + (d41 * d3)) + (d46 * d7)) - (((d45 * d7) + (d48 * d11)) + (d42 * d3));
        double d57 = (d * d29) + (d5 * d30) + (d9 * d31) + (d13 * d32);
        if (d57 == OOXIXo.f3760XO) {
            return false;
        }
        double d58 = 1.0d / d57;
        fArr[i] = (float) (d29 * d58);
        fArr[i + 1] = (float) (d30 * d58);
        fArr[i + 2] = (float) (d31 * d58);
        fArr[i + 3] = (float) (d32 * d58);
        fArr[i + 4] = (float) (d33 * d58);
        fArr[i + 5] = (float) (d34 * d58);
        fArr[i + 6] = (float) (d35 * d58);
        fArr[i + 7] = (float) (d36 * d58);
        fArr[i + 8] = (float) (d49 * d58);
        fArr[i + 9] = (float) (d50 * d58);
        fArr[i + 10] = (float) (d51 * d58);
        fArr[i + 11] = (float) (d52 * d58);
        fArr[i + 12] = (float) (d53 * d58);
        fArr[i + 13] = (float) (d54 * d58);
        fArr[i + 14] = (float) (d55 * d58);
        fArr[i + 15] = (float) (d56 * d58);
        return true;
    }
}
