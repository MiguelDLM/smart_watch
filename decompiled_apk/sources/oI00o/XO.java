package oI00o;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;
import androidx.core.view.ViewCompat;
import androidx.work.WorkInfo;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes6.dex */
public class XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f31358oIX0oI = 262143;

    public static void I0Io(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i3 * i7;
            int i9 = (i7 >> 1) * i4;
            int i10 = 0;
            while (i10 < i) {
                int i11 = ((i10 >> 1) * i5) + i9;
                iArr[i6] = oIX0oI(bArr[i8 + i10] & 255, bArr2[i11] & 255, bArr3[i11] & 255);
                i10++;
                i6++;
            }
        }
    }

    public static void II0xO0(byte[] bArr, int i, int i2, int[] iArr) {
        int i3 = i * i2;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 >> 1) * i) + i3;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < i) {
                int i10 = bArr[i4] & 255;
                if ((i7 & 1) == 0) {
                    int i11 = i6 + 1;
                    i9 = bArr[i6] & 255;
                    i6 += 2;
                    i8 = bArr[i11] & 255;
                }
                iArr[i4] = oIX0oI(i10, i8, i9);
                i7++;
                i4++;
            }
        }
    }

    public static void Oxx0IOOO(Bitmap bitmap, String str) {
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tensorflow";
        II0xO0.oxoX("Saving " + bitmap.getWidth() + "x" + bitmap.getHeight() + " bitmap to " + str2);
        File file = new File(str2);
        if (!file.mkdirs()) {
            II0xO0.oxoX("Make dir failed");
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            file2.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.PNG, 99, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            II0xO0.I0Io(e.toString() + "Exception!");
        }
    }

    public static int X0o0xo(int i, int i2) {
        return (i * i2) + (((i + 1) / 2) * ((i2 + 1) / 2) * 2);
    }

    public static void XO(Bitmap bitmap) {
        Oxx0IOOO(bitmap, "preview.png");
    }

    public static int oIX0oI(int i, int i2, int i3) {
        int i4 = i - 16;
        int i5 = 0;
        if (i4 < 0) {
            i4 = 0;
        }
        int i6 = i2 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        int i7 = i3 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        int i8 = i4 * 1192;
        int i9 = (i7 * 1634) + i8;
        int i10 = (i8 - (i7 * 833)) - (i6 * 400);
        int i11 = i8 + (i6 * 2066);
        if (i9 > 262143) {
            i9 = f31358oIX0oI;
        } else if (i9 < 0) {
            i9 = 0;
        }
        if (i10 > 262143) {
            i10 = f31358oIX0oI;
        } else if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > 262143) {
            i5 = f31358oIX0oI;
        } else if (i11 >= 0) {
            i5 = i11;
        }
        return ((i9 << 6) & 16711680) | ViewCompat.MEASURED_STATE_MASK | ((i10 >> 2) & 65280) | ((i5 >> 10) & 255);
    }

    public static Matrix oxoX(int i, int i2, int i3, int i4, int i5, boolean z) {
        boolean z2;
        int i6;
        Matrix matrix = new Matrix();
        if (i5 != 0) {
            if (i5 % 90 != 0) {
                II0xO0.xxIXOIIO("Rotation of " + i5 + " % 90 != 0");
            }
            matrix.postTranslate((-i) / 2.0f, (-i2) / 2.0f);
            matrix.postRotate(i5);
        }
        if ((Math.abs(i5) + 90) % 180 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i6 = i2;
        } else {
            i6 = i;
        }
        if (!z2) {
            i = i2;
        }
        if (i6 != i3 || i != i4) {
            float f = i3 / i6;
            float f2 = i4 / i;
            if (z) {
                float max = Math.max(f, f2);
                matrix.postScale(max, max);
            } else {
                matrix.postScale(f, f2);
            }
        }
        if (i5 != 0) {
            matrix.postTranslate(i3 / 2.0f, i4 / 2.0f);
        }
        return matrix;
    }
}
