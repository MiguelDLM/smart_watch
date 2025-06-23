package oI00o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.util.Log;
import androidx.core.view.ViewCompat;
import androidx.work.WorkInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static long f31348oIX0oI;

    public static Bitmap I0Io(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                int pixel = (-16777216) & copy.getPixel(i, i2);
                int i3 = 255;
                if (((int) ((((16711680 & r5) >> 16) * 0.3d) + (((65280 & r5) >> 8) * 0.59d) + ((r5 & 255) * 0.11d))) <= 150) {
                    i3 = 0;
                }
                copy.setPixel(i, i2, (i3 << 16) | pixel | (i3 << 8) | i3);
            }
        }
        return copy;
    }

    public static void II0XooXoX(Context context, byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        if (System.currentTimeMillis() - f31348oIX0oI < 5000) {
            return;
        }
        f31348oIX0oI = System.currentTimeMillis();
        Log.e("save >>> ", "left = " + i + " top= " + i2 + " width=" + i3 + " height= " + i4 + " row=" + i5);
        int[] II0xO02 = II0xO0(bArr, i, i2, i3, i4, i5);
        Bitmap createBitmap = Bitmap.createBitmap(i4, i3, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(II0xO02, 0, i4, 0, 0, i4, i3);
        xxIXOIIO(context, createBitmap);
        createBitmap.recycle();
    }

    public static int[] II0xO0(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        int[] iArr = new int[i3 * i4];
        int i6 = i2 + i4;
        int i7 = i3 + i;
        int i8 = 0;
        while (i < i7) {
            int i9 = ((i6 - 1) * i5) + i;
            int i10 = 0;
            while (i10 < i4) {
                int i11 = bArr[i9] & 255;
                iArr[i8] = i11 | (i11 << 16) | ViewCompat.MEASURED_STATE_MASK | (i11 << 8);
                i10++;
                i8++;
                i9 -= i5;
            }
            i++;
        }
        return iArr;
    }

    public static int[] Oxx0IOOO(int[] iArr, int i, int i2, int i3) {
        int[] iArr2 = new int[i * i2];
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = ((i2 - 1) * i3) + i5;
            int i7 = 0;
            while (i7 < i2) {
                iArr2[i4] = iArr[i6];
                i7++;
                i4++;
                i6 -= i3;
            }
        }
        return iArr2;
    }

    public static Bitmap X0o0xo(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = (i4 * i) + i5;
                int i7 = 255;
                int i8 = bArr[i6] & 255;
                int i9 = ((i4 >> 1) * i) + i3 + (i5 & (-2));
                int i10 = bArr[i9] & 255;
                int i11 = bArr[i9 + 1] & 255;
                if (i8 < 16) {
                    i8 = 16;
                }
                float f = (i8 - 16) * 1.164f;
                float f2 = i11 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                int round = Math.round((1.596f * f2) + f);
                float f3 = i10 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                int round2 = Math.round((f - (f2 * 0.813f)) - (0.391f * f3));
                int round3 = Math.round(f + (f3 * 2.018f));
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = 255;
                }
                if (round2 < 0) {
                    round2 = 0;
                } else if (round2 > 255) {
                    round2 = 255;
                }
                if (round3 < 0) {
                    i7 = 0;
                } else if (round3 <= 255) {
                    i7 = round3;
                }
                iArr[i6] = (i7 << 16) + ViewCompat.MEASURED_STATE_MASK + (round2 << 8) + round;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    public static Bitmap XO(byte[] bArr, int i, int i2) {
        Bitmap bitmap = null;
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 80, byteArrayOutputStream);
            bitmap = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            byteArrayOutputStream.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Sys", "Error:" + e.getMessage());
            return bitmap;
        }
    }

    public static int[] oIX0oI(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        int[] iArr = new int[i3 * i4];
        int i6 = i2 * i5;
        int i7 = (i5 - i) - i3;
        int i8 = 0;
        for (int i9 = i2; i9 < i4 + i2; i9++) {
            int i10 = i6 + i;
            int i11 = i;
            while (i11 < i + i3) {
                int i12 = bArr[i10] & 255;
                iArr[i8] = i12 | (i12 << 16) | ViewCompat.MEASURED_STATE_MASK | (i12 << 8);
                i11++;
                i8++;
                i10++;
            }
            i6 = i10 + i7;
        }
        return iArr;
    }

    public static Bitmap oxoX(Bitmap bitmap, RectF rectF) {
        int height = (int) rectF.height();
        return Bitmap.createBitmap(bitmap, (int) rectF.left, (int) rectF.top, (int) rectF.width(), height);
    }

    public static void xoIox(Context context, Bitmap bitmap, RectF rectF) {
        II0xO0.oIX0oI("location : " + rectF.toString());
        xxIXOIIO(context, Bitmap.createBitmap(bitmap, (int) rectF.left, (int) rectF.top, (int) rectF.width(), (int) rectF.height()));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x009b -> B:22:0x00a7). Please report as a decompilation issue!!! */
    public static void xxIXOIIO(Context context, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        File file = new File(context.getExternalCacheDir().getAbsolutePath() + "/scan/", System.currentTimeMillis() + ".jpg");
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    if (!file.getParentFile().exists()) {
                        if (file.getParentFile().mkdirs()) {
                            Log.d("save >>> ", "make dir success ");
                        } else {
                            Log.e("save >>> ", "make dir fail ");
                        }
                    }
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
                Log.d("save >>> ", "save image success, path = " + file.getAbsolutePath());
            }
            fileOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
