package com.iflytek.sparkchain.utils;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes10.dex */
public class RSAUtil {
    private static final String ALGORITHM = "RSA";
    private static final String TRANSFORMATION = "RSA/ECB/PKCS1Padding";

    private static byte[] ASCII_To_BCD(byte[] bArr, int i) {
        byte asc_to_bcd;
        byte[] bArr2 = new byte[i / 2];
        int i2 = 0;
        for (int i3 = 0; i3 < (i + 1) / 2; i3++) {
            int i4 = i2 + 1;
            bArr2[i3] = asc_to_bcd(bArr[i2]);
            if (i4 >= i) {
                i2 = i4;
                asc_to_bcd = 0;
            } else {
                i2 += 2;
                asc_to_bcd = asc_to_bcd(bArr[i4]);
            }
            bArr2[i3] = (byte) (asc_to_bcd + (bArr2[i3] << 4));
        }
        return bArr2;
    }

    private static byte asc_to_bcd(byte b) {
        int i;
        if (b < 48 || b > 57) {
            if (b >= 65 && b <= 70) {
                i = b - 55;
            } else if (b >= 97 && b <= 102) {
                i = b - 87;
            }
            return (byte) i;
        }
        i = b - 48;
        return (byte) i;
    }

    private static String bcd2Str(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            char c = (char) (((b & 240) >> 4) & 15);
            int i2 = i * 2;
            cArr[i2] = (char) (c > '\t' ? c + '7' : c + '0');
            char c2 = (char) (b & 15);
            cArr[i2 + 1] = (char) (c2 > '\t' ? c2 + '7' : c2 + '0');
        }
        return new String(cArr);
    }

    public static String decryptByPrivateKey(String str, RSAPrivateKey rSAPrivateKey) throws Exception {
        int bitLength = rSAPrivateKey.getModulus().bitLength() / 8;
        byte[] bytes = str.getBytes();
        String str2 = "";
        for (byte[] bArr : splitArray(ASCII_To_BCD(bytes, bytes.length), bitLength)) {
            str2 = str2 + new String(decryptByPrivateKey(bArr, rSAPrivateKey));
        }
        return str2;
    }

    public static String decryptByPublicKey(String str, RSAPublicKey rSAPublicKey) throws Exception {
        int bitLength = rSAPublicKey.getModulus().bitLength() / 8;
        byte[] bytes = str.getBytes();
        String str2 = "";
        for (byte[] bArr : splitArray(ASCII_To_BCD(bytes, bytes.length), bitLength)) {
            str2 = str2 + new String(decryptByPublicKey(bArr, rSAPublicKey));
        }
        return str2;
    }

    public static String encryptByPrivateKey(String str, RSAPrivateKey rSAPrivateKey) throws Exception {
        String[] splitString = splitString(str, (rSAPrivateKey.getModulus().bitLength() / 8) - 11);
        StringBuilder sb = new StringBuilder();
        for (String str2 : splitString) {
            sb.append(bcd2Str(encryptByPrivateKey(str2.getBytes(), rSAPrivateKey)));
        }
        return sb.toString();
    }

    public static String encryptByPublicKey(String str, RSAPublicKey rSAPublicKey) {
        String[] splitString = splitString(str, (rSAPublicKey.getModulus().bitLength() / 8) - 11);
        StringBuilder sb = new StringBuilder();
        try {
            for (String str2 : splitString) {
                sb.append(bcd2Str(encryptByPublicKey(str2.getBytes(), rSAPublicKey)));
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static RSAPrivateKey loadPrivateKey(InputStream inputStream) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return loadPrivateKey(sb.toString());
                }
                if (readLine.charAt(0) != '-') {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static RSAPublicKey loadPublicKey(InputStream inputStream) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return loadPublicKey(sb.toString());
                }
                if (readLine.charAt(0) != '-') {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[][] splitArray(byte[] bArr, int i) {
        int length = bArr.length / i;
        int length2 = bArr.length % i;
        int i2 = length + (length2 != 0 ? 1 : 0);
        byte[][] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr3 = new byte[i];
            if (i3 != i2 - 1 || length2 == 0) {
                System.arraycopy(bArr, i3 * i, bArr3, 0, i);
            } else {
                System.arraycopy(bArr, i3 * i, bArr3, 0, length2);
            }
            bArr2[i3] = bArr3;
        }
        return bArr2;
    }

    private static String[] splitString(String str, int i) {
        int i2;
        int i3;
        int length = str.length() / i;
        int length2 = str.length() % i;
        int i4 = length + (length2 != 0 ? 1 : 0);
        String[] strArr = new String[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 != i4 - 1 || length2 == 0) {
                i2 = i5 * i;
                i3 = i2 + i;
            } else {
                i2 = i5 * i;
                i3 = i2 + length2;
            }
            strArr[i5] = str.substring(i2, i3);
        }
        return strArr;
    }

    public static byte[] decryptByPrivateKey(byte[] bArr, RSAPrivateKey rSAPrivateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, rSAPrivateKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] decryptByPublicKey(byte[] bArr, RSAPublicKey rSAPublicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, rSAPublicKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptByPrivateKey(byte[] bArr, RSAPrivateKey rSAPrivateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, rSAPrivateKey);
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptByPublicKey(byte[] bArr, RSAPublicKey rSAPublicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, rSAPublicKey);
        return cipher.doFinal(bArr);
    }

    public static RSAPrivateKey loadPrivateKey(String str) throws Exception {
        try {
            return (RSAPrivateKey) KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static RSAPublicKey loadPublicKey(String str) throws Exception {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Exception unused) {
            return null;
        }
    }
}
