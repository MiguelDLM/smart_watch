package IIoX0OoI;

import android.graphics.Bitmap;
import android.util.Pair;
import androidx.core.view.ViewCompat;
import com.tenmeter.smlibrary.utils.FileUtils;
import me.devilsen.czxing.code.BarcodeFormat;
import me.devilsen.czxing.code.EncodeEngine;
import oI00o.I0Io;
import oI00o.oxoX;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final EncodeEngine f343oIX0oI = new EncodeEngine();

    public final Bitmap I0Io(String str, int i, int i2, int i3, BarcodeFormat barcodeFormat, int i4, int i5, Bitmap bitmap) {
        Object[] objArr = new Object[1];
        if (this.f343oIX0oI.oIX0oI(str, i, i2, i3, barcodeFormat, i4, i5, objArr) > -1) {
            Bitmap createBitmap = Bitmap.createBitmap((int[]) objArr[0], i, i2, Bitmap.Config.ARGB_8888);
            if (bitmap != null) {
                return oxoX.oIX0oI(createBitmap, bitmap);
            }
            return createBitmap;
        }
        return null;
    }

    public Bitmap II0XooXoX(String str, int i, int i2, BarcodeFormat barcodeFormat) {
        return oxoX(str, i, i2, ViewCompat.MEASURED_STATE_MASK, barcodeFormat, null);
    }

    public Bitmap II0xO0(String str, int i, int i2) {
        return X0o0xo(str, i, i2, null);
    }

    public Bitmap Oxx0IOOO(String str, int i, int i2, int i3) {
        return oxoX(str, i, i2, i3, BarcodeFormat.CODE_128, null);
    }

    public Bitmap X0o0xo(String str, int i, int i2, Bitmap bitmap) {
        return oxoX(str, i, i, i2, BarcodeFormat.QR_CODE, bitmap);
    }

    public Bitmap XO(String str, int i, int i2) {
        return Oxx0IOOO(str, i, i2, ViewCompat.MEASURED_STATE_MASK);
    }

    public Bitmap oIX0oI(String str, int i) {
        return II0xO0(str, i, ViewCompat.MEASURED_STATE_MASK);
    }

    public final Bitmap oxoX(String str, int i, int i2, int i3, BarcodeFormat barcodeFormat, Bitmap bitmap) {
        return I0Io(str, i, i2, i3, barcodeFormat, 5, 0, bitmap);
    }

    public Pair<Integer, byte[]> xxIXOIIO(String str, BarcodeFormat barcodeFormat) {
        Object[] objArr = new Object[2];
        if (this.f343oIX0oI.writeCodeByte(str, barcodeFormat.name(), objArr) > -1) {
            int[] iArr = (int[]) objArr[0];
            int[] iArr2 = (int[]) objArr[1];
            int i = iArr[0];
            int i2 = iArr[1];
            System.out.println("w:" + i + ", h:" + i2);
            int i3 = i * i2;
            I0Io i0Io = new I0Io(i3);
            for (int i4 = 0; i4 < i2; i4++) {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = (i4 * i2) + i5;
                    if (iArr2[i6] == 1) {
                        i0Io.Oo(i6);
                    }
                }
            }
            int i7 = (i3 + 7) / 8;
            byte[] bArr = new byte[i7];
            i0Io.oI0IIXIo(0, bArr, 0, i7);
            StringBuilder sb = new StringBuilder();
            for (int i8 = 0; i8 < i7; i8++) {
                sb.append(Integer.toBinaryString((bArr[i8] & 255) + 256).substring(1).replace("0", FileUtils.FILE_EXTENSION_SEPARATOR).replace("1", "X") + " ");
            }
            System.out.println("to bytes:" + ((Object) sb));
            return new Pair<>(Integer.valueOf(i), bArr);
        }
        return null;
    }
}
