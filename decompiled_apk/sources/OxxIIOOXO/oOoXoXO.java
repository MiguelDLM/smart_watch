package OxxIIOOXO;

import android.graphics.Color;
import androidx.annotation.IntRange;
import androidx.collection.ScatterMapKt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class oOoXoXO implements oOXoIIIo<IXxxXO.I0Io> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public int f3106oIX0oI;

    public oOoXoXO(int i) {
        this.f3106oIX0oI = i;
    }

    @IntRange(from = 0, to = ScatterMapKt.Sentinel)
    public final int I0Io(double d, double[] dArr, double[] dArr2) {
        double d2;
        int i = 1;
        while (true) {
            if (i < dArr.length) {
                int i2 = i - 1;
                double d3 = dArr[i2];
                double d4 = dArr[i];
                if (d4 >= d) {
                    d2 = IIXOooo.xxIXOIIO.xoIox(dArr2[i2], dArr2[i], IIXOooo.xxIXOIIO.II0xO0((d - d3) / (d4 - d3), XIXIX.OOXIXo.f3760XO, 1.0d));
                    break;
                }
                i++;
            } else {
                d2 = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (d2 * 255.0d);
    }

    public final void II0xO0(IXxxXO.I0Io i0Io, List<Float> list) {
        int i = this.f3106oIX0oI * 4;
        if (list.size() <= i) {
            return;
        }
        int size = (list.size() - i) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i2 = 0;
        while (i < list.size()) {
            if (i % 2 == 0) {
                dArr[i2] = list.get(i).floatValue();
            } else {
                dArr2[i2] = list.get(i).floatValue();
                i2++;
            }
            i++;
        }
        for (int i3 = 0; i3 < i0Io.I0Io(); i3++) {
            int i4 = i0Io.oIX0oI()[i3];
            i0Io.oIX0oI()[i3] = Color.argb(I0Io(i0Io.II0xO0()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    @Override // OxxIIOOXO.oOXoIIIo
    /* renamed from: oxoX, reason: merged with bridge method [inline-methods] */
    public IXxxXO.I0Io oIX0oI(JsonReader jsonReader, float f) throws IOException {
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
        if (this.f3106oIX0oI == -1) {
            this.f3106oIX0oI = arrayList.size() / 4;
        }
        int i = this.f3106oIX0oI;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f3106oIX0oI * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
                        }
                    } else {
                        i3 = (int) (floatValue * 255.0d);
                    }
                } else {
                    i2 = (int) (floatValue * 255.0d);
                }
            } else {
                fArr[i5] = (float) floatValue;
            }
        }
        IXxxXO.I0Io i0Io = new IXxxXO.I0Io(fArr, iArr);
        II0xO0(i0Io, arrayList);
        return i0Io;
    }
}
