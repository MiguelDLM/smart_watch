package XOxIOxOx;

import android.bluetooth.le.ScanResult;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;

/* loaded from: classes8.dex */
public class x0XOIxOo {
    public static String I0Io(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        String str = null;
        while (i < bArr.length) {
            try {
                int i2 = i + 1;
                int i3 = bArr[i] & 255;
                if (i3 == 0) {
                    break;
                }
                int i4 = i3 - 1;
                int i5 = i + 2;
                int i6 = bArr[i2] & 255;
                if (i6 == 8 || i6 == 9) {
                    str = new String(oIX0oI(bArr, i5, i4));
                }
                i = i5 + i4;
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("TAG", "unable to parse scan record: " + Arrays.toString(bArr));
                return null;
            }
        }
        return str;
    }

    public static String II0xO0(ScanResult scanResult) {
        String name = scanResult.getDevice().getName();
        if (TextUtils.isEmpty(name)) {
            name = oxoX(scanResult.getScanRecord().getDeviceName());
        }
        if (TextUtils.isEmpty(name)) {
            return oxoX(I0Io(scanResult.getScanRecord().getBytes()));
        }
        return name;
    }

    public static byte[] oIX0oI(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static String oxoX(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] bytes = str.getBytes();
                int length = bytes.length;
                int i = length - 1;
                if (bytes[i] == 0) {
                    length = i;
                }
                byte[] bArr = new byte[length];
                System.arraycopy(bytes, 0, bArr, 0, length);
                return new String(bArr);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
