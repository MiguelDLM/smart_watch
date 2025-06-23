package com.baidu.ar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes7.dex */
public class kp {
    private static char[] Dr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static MessageDigest Ds;

    static {
        try {
            Ds = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(kp.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            e.printStackTrace();
        }
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    public static String b(InputStream inputStream) {
        try {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        String n = n(Ds.digest());
                        ko.closeQuietly(inputStream);
                        return n;
                    }
                    Ds.update(bArr, 0, read);
                }
            } catch (IOException e) {
                e.printStackTrace();
                ko.closeQuietly(inputStream);
                return null;
            }
        } catch (Throwable th) {
            ko.closeQuietly(inputStream);
            throw th;
        }
    }

    public static synchronized String co(String str) {
        String m;
        synchronized (kp.class) {
            m = m(str.getBytes(Charset.forName("utf-8")));
        }
        return m;
    }

    public static String cp(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String m(byte[] bArr) {
        Ds.update(bArr);
        return n(Ds.digest());
    }

    private static String n(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static String o(File file) {
        try {
            return b(new FileInputStream(file));
        } catch (IOException unused) {
            return null;
        }
    }

    private static void a(byte b, StringBuffer stringBuffer) {
        char[] cArr = Dr;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
