package com.alimm.tanx.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class MD5Utils implements NotConfused {
    public static final String ALGORIGTHM_MD5 = "MD5";
    public static final String EMPTY_CONTENT_MD5 = "d41d8cd98f00b204e9800998ecf8427e";
    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static void appendHexPair(byte b, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    public static String bytesToHex(byte[] bArr) {
        return bytesToHex(bArr, 0, bArr.length);
    }

    public static String getFileMD5String(File file) throws IOException {
        MessageDigest mD5Digest = getMD5Digest();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                mD5Digest.update(bArr, 0, read);
            } else {
                fileInputStream.close();
                return bytesToHex(mD5Digest.digest());
            }
        }
    }

    public static String getFilePathMD5String(String str) {
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return new BigInteger(1, messageDigest.digest()).toString(16);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static MessageDigest getMD5Digest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getMD5String(String str) {
        if (str == null) {
            return "";
        }
        return getMD5String(str.getBytes());
    }

    public static String bytesToHex(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            appendHexPair(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    public static String getMD5String(byte[] bArr) {
        MessageDigest mD5Digest = getMD5Digest();
        mD5Digest.update(bArr);
        return bytesToHex(mD5Digest.digest());
    }

    public static String getMD5String(byte[] bArr, int i, int i2) {
        MessageDigest mD5Digest = getMD5Digest();
        mD5Digest.update(bArr, i, i2);
        return bytesToHex(mD5Digest.digest());
    }
}
