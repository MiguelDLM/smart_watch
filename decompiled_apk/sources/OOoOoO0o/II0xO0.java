package OOoOoO0o;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f1772oIX0oI = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final char[] f1771II0xO0 = f1772oIX0oI.toCharArray();

    public static final long I0Io(byte[] bArr, int i, int i2) {
        long j;
        int i3 = 0;
        long j2 = 0;
        while (i2 > 0) {
            i2--;
            int i4 = i + 1;
            byte b = bArr[i];
            if (b == 47) {
                j = 1;
            } else {
                j = 0;
            }
            if (b >= 48 && b <= 57) {
                j = b - 46;
            }
            if (b >= 65 && b <= 90) {
                j = b - 53;
            }
            if (b >= 97 && b <= 122) {
                j = b - 59;
            }
            j2 += j << i3;
            i3 += 6;
            i = i4;
        }
        return j2;
    }

    public static String II0xO0(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer(((length + 2) / 3) * 4);
        int i = 0;
        while (length >= 3) {
            stringBuffer.append(oxoX(((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i + 2] & 255), 4));
            i += 3;
            length -= 3;
        }
        if (length == 2) {
            stringBuffer.append(oxoX(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255), 3));
        }
        if (length == 1) {
            stringBuffer.append(oxoX(bArr[i] & 255, 2));
        }
        return stringBuffer.toString();
    }

    public static byte[] oIX0oI(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[(length * 3) / 4];
        int i = 0;
        int i2 = 0;
        while (true) {
            if (length < 4) {
                break;
            }
            long I0Io2 = I0Io(bytes, i, 4);
            length -= 4;
            i += 4;
            for (int i3 = 2; i3 >= 0; i3--) {
                bArr[i2 + i3] = (byte) (I0Io2 & 255);
                I0Io2 >>= 8;
            }
            i2 += 3;
        }
        if (length == 3) {
            long I0Io3 = I0Io(bytes, i, 3);
            for (int i4 = 1; i4 >= 0; i4--) {
                bArr[i2 + i4] = (byte) (I0Io3 & 255);
                I0Io3 >>= 8;
            }
        }
        if (length == 2) {
            bArr[i2] = (byte) (I0Io(bytes, i, 2) & 255);
        }
        return bArr;
    }

    public static final String oxoX(long j, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        while (i > 0) {
            i--;
            stringBuffer.append(f1771II0xO0[(int) (63 & j)]);
            j >>= 6;
        }
        return stringBuffer.toString();
    }
}
