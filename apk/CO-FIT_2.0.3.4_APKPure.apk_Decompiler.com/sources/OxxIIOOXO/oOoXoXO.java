package OxxIIOOXO;

import IIXOooo.xxIXOIIO;
import IXxxXO.I0Io;
import XIXIX.OOXIXo;
import android.graphics.Color;
import androidx.annotation.IntRange;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class oOoXoXO implements oOXoIIIo<I0Io> {

    /* renamed from: oIX0oI  reason: collision with root package name */
    public int f209oIX0oI;

    public oOoXoXO(int i) {
        this.f209oIX0oI = i;
    }

    @IntRange(from = 0, to = 255)
    public final int I0Io(double d, double[] dArr, double[] dArr2) {
        double d2;
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int i = 1;
        while (true) {
            if (i >= dArr3.length) {
                d2 = dArr4[dArr4.length - 1];
                break;
            }
            int i2 = i - 1;
            double d3 = dArr3[i2];
            double d4 = dArr3[i];
            if (d4 >= d) {
                d2 = xxIXOIIO.xoIox(dArr4[i2], dArr4[i], xxIXOIIO.II0xO0((d - d3) / (d4 - d3), OOXIXo.f29376XO, 1.0d));
                break;
            }
            i++;
        }
        return (int) (d2 * 255.0d);
    }

    public final void II0xO0(I0Io i0Io, List<Float> list) {
        int i = this.f209oIX0oI * 4;
        if (list.size() > i) {
            int size = (list.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i2 = 0;
            while (i < list.size()) {
                if (i % 2 == 0) {
                    dArr[i2] = (double) list.get(i).floatValue();
                } else {
                    dArr2[i2] = (double) list.get(i).floatValue();
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < i0Io.I0Io(); i3++) {
                int i4 = i0Io.oIX0oI()[i3];
                i0Io.oIX0oI()[i3] = Color.argb(I0Io((double) i0Io.II0xO0()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
    }

    /* renamed from: oxoX */
    public I0Io oIX0oI(JsonReader jsonReader, float f) throws IOException {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (jsonReader.x0XOIxOo() == JsonReader.Token.BEGIN_ARRAY) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            jsonReader.II0xO0();
        }
        while (jsonReader.XO()) {
            arrayList.add(Float.valueOf((float) jsonReader.II0XooXoX()));
        }
        if (z) {
            jsonReader.oxoX();
        }
        if (this.f209oIX0oI == -1) {
            this.f209oIX0oI = arrayList.size() / 4;
        }
        int i = this.f209oIX0oI;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f209oIX0oI * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = (double) ((Float) arrayList.get(i4)).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        I0Io i0Io = new I0Io(fArr, iArr);
        II0xO0(i0Io, arrayList);
        return i0Io;
    }
}
