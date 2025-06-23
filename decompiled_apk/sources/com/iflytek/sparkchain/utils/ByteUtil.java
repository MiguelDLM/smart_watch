package com.iflytek.sparkchain.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public class ByteUtil {
    private static ByteBuffer buffer = ByteBuffer.allocate(8);

    public static String byteArrToHexString(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            str = str + Integer.toString((b & 255) + 256, 16).substring(1);
        }
        return str;
    }

    public static short byteArrToShort(byte[] bArr) {
        return byteArrToShort(bArr, 0);
    }

    public static int byteArrayToInt(byte[] bArr) {
        return byteArrayToInt(bArr, 0);
    }

    public static int byteArrayToShort(byte[] bArr) {
        return byteArrayToShort(bArr, 0);
    }

    public static int byteToInt(byte b) {
        return b & 255;
    }

    public static long bytesToLong(byte[] bArr) {
        buffer.put(bArr, 0, bArr.length);
        buffer.flip();
        return buffer.getLong();
    }

    public static byte[] getByteArr(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2 - i];
        int i3 = 0;
        while (true) {
            int i4 = i + i3;
            if (i4 >= i2) {
                return bArr2;
            }
            bArr2[i3] = bArr[i4];
            i3++;
        }
    }

    public static String getString(byte[] bArr, String str) {
        return getString(bArr, str, null);
    }

    public static int hexStringToInt(String str) {
        return Integer.parseInt(str, 16);
    }

    public static String intToBinary(int i) {
        return Integer.toBinaryString(i);
    }

    public static byte intToByte(int i) {
        return (byte) i;
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static boolean isEq(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] longToBytes(long j) {
        buffer.putLong(0, j);
        return buffer.array();
    }

    public static void main(String[] strArr) {
        System.err.println(isEq(new byte[]{1, 2}, new byte[]{1, 2}));
    }

    public static InputStream readByteArr(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    public static byte[] readInputStream(InputStream inputStream) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (IOException unused) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        inputStream.close();
                        return byteArray;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException unused3) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                    return null;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused5) {
                    return null;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public static byte[] shortToByteArr(short s) {
        byte[] bArr = new byte[2];
        for (int i = 0; i < 2; i++) {
            bArr[i] = (byte) ((s >>> ((1 - i) * 8)) & 255);
        }
        return bArr;
    }

    public static short byteArrToShort(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | (bArr[i] << 8));
    }

    public static int byteArrayToInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static short byteArrayToShort(byte[] bArr, int i) {
        return (short) ((bArr[i] & 255) | (bArr[i + 1] & 65280));
    }

    public static String getString(byte[] bArr, String str, String str2) {
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException unused) {
            if (str2 == null) {
                return null;
            }
            return str2;
        }
    }

    public static void byteArrToShort(byte[] bArr, short s, int i) {
        bArr[i + 1] = (byte) (s >> 8);
        bArr[i] = (byte) s;
    }
}
