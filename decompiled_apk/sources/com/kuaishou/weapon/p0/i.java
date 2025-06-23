package com.kuaishou.weapon.p0;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes11.dex */
public class i {
    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    public static byte[] b(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = a(bytes[i2], bytes[i2 + 1]);
        }
        return bArr;
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return new String(c(c(str), str2));
    }

    private static byte[] b(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return c(str.getBytes(), str2);
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            stringBuffer.append((char) b);
        }
        return stringBuffer.toString();
    }

    private static String b(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            String hexString = Integer.toHexString(str.charAt(i) & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str2 = str2 + hexString;
        }
        return str2;
    }

    private static byte[] c(byte[] bArr, String str) {
        byte[] a2 = a(str);
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte b = a2[i];
            i2 = ((b & 255) + i2) & 255;
            a2[i] = a2[i2];
            a2[i2] = b;
            int i4 = ((a2[i] & 255) + (b & 255)) & 255;
            bArr2[i3] = (byte) (a2[i4] ^ bArr[i3]);
        }
        return bArr2;
    }

    private static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr[i] = (byte) i;
        }
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            int i5 = bytes[i2] & 255;
            byte b = bArr[i4];
            i3 = (i5 + (b & 255) + i3) & 255;
            bArr[i4] = bArr[i3];
            bArr[i3] = b;
            i2 = (i2 + 1) % bytes.length;
        }
        return bArr;
    }

    private static byte a(byte b, byte b2) {
        return (byte) (((char) (((char) Byte.decode(HexStringBuilder.DEFAULT_PREFIX + new String(new byte[]{b})).byteValue()) << 4)) ^ ((char) Byte.decode(HexStringBuilder.DEFAULT_PREFIX + new String(new byte[]{b2})).byteValue()));
    }
}
