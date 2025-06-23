package OOIXx0x;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.PrintStream;

/* loaded from: classes13.dex */
public class I0Io {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final char[] f1717oIX0oI = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final char[] f1716II0xO0 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] I0Io(byte[] bArr) {
        return oxoX(bArr, true);
    }

    public static String II0XooXoX(byte[] bArr, char[] cArr) {
        return new String(X0o0xo(bArr, cArr));
    }

    public static byte[] II0xO0(char[] cArr) {
        int length = cArr.length;
        if ((length & 1) == 0) {
            byte[] bArr = new byte[length >> 1];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i + 1;
                int oOoXoXO2 = (oOoXoXO(cArr[i], i) << 4) | oOoXoXO(cArr[i3], i3);
                i += 2;
                bArr[i2] = (byte) (oOoXoXO2 & 255);
                i2++;
            }
            return bArr;
        }
        throw new RuntimeException("Odd number of characters.");
    }

    public static byte[] OOXIXo(String str) {
        int i;
        int i2;
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[str.length() / 2];
        for (int i3 = 0; i3 < bytes.length / 2; i3++) {
            int i4 = i3 * 2;
            byte b = bytes[i4];
            if (b >= 97) {
                i = b - 87;
            } else if (b >= 65) {
                i = b - 55;
            } else {
                i = b - 48;
            }
            byte b2 = (byte) i;
            byte b3 = bytes[i4 + 1];
            if (b3 >= 97) {
                i2 = b3 - 87;
            } else if (b3 >= 65) {
                i2 = b3 - 55;
            } else {
                i2 = b3 - 48;
            }
            bArr[i3] = (byte) ((((byte) i2) & 255) | ((b2 & 255) << 4));
        }
        return bArr;
    }

    public static String Oxx0IOOO(byte[] bArr, boolean z) {
        char[] cArr;
        if (z) {
            cArr = f1717oIX0oI;
        } else {
            cArr = f1716II0xO0;
        }
        return II0XooXoX(bArr, cArr);
    }

    public static char[] X0o0xo(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b & 240) >>> 4];
            i += 2;
            cArr2[i2] = cArr[b & 15];
        }
        return cArr2;
    }

    public static String XO(byte[] bArr) {
        return Oxx0IOOO(bArr, true);
    }

    public static byte[] oIX0oI(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = ooOOo0oXI(bytes[i2], bytes[i2 + 1]);
        }
        return bArr;
    }

    public static int oOoXoXO(char c, int i) {
        int digit = Character.digit(c, 16);
        if (digit != -1) {
            return digit;
        }
        throw new RuntimeException("Illegal hexadecimal character " + c + " at index " + i);
    }

    public static byte ooOOo0oXI(byte b, byte b2) {
        return (byte) (((byte) (Byte.decode(HexStringBuilder.DEFAULT_PREFIX + new String(new byte[]{b})).byteValue() << 4)) ^ Byte.decode(HexStringBuilder.DEFAULT_PREFIX + new String(new byte[]{b2})).byteValue());
    }

    public static char[] oxoX(byte[] bArr, boolean z) {
        char[] cArr;
        if (z) {
            cArr = f1717oIX0oI;
        } else {
            cArr = f1716II0xO0;
        }
        return X0o0xo(bArr, cArr);
    }

    public static void xoIox(String[] strArr) {
        String XO2 = XO("待转换字符串".getBytes());
        String str = new String(II0xO0(XO2.toCharArray()));
        PrintStream printStream = System.out;
        printStream.println("转换前：待转换字符串");
        printStream.println("转换后：" + XO2);
        printStream.println("还原后：" + str);
    }

    public static byte[] xxIXOIIO(int i, int i2) {
        if (i2 > 4) {
            i2 = 4;
        }
        int i3 = (i2 - 1) * 8;
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) (i >> (i3 - (i4 * 8)));
        }
        return bArr;
    }
}
