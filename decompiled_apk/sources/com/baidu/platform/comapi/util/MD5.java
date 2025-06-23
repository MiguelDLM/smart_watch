package com.baidu.platform.comapi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes8.dex */
public class MD5 {

    /* renamed from: a, reason: collision with root package name */
    protected static final char[] f9684a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static boolean checkPassword(String str, String str2) {
        return getMD5String(str).equals(str2);
    }

    public static String getFileMD5String(File file) throws IOException {
        return getFileMD5String(file, 131072);
    }

    public static String getFileMD5StringNIO(File file) throws IOException {
        return getFileMD5StringNIO(file, 131072);
    }

    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
    }

    public static String getMD5String16(String str) {
        String mD5String = getMD5String(str.getBytes());
        if (mD5String.length() == 32) {
            return mD5String.substring(8, 24);
        }
        return null;
    }

    public static String getSignMD5String(String str) {
        return URLEncodeUtils.a(1, str);
    }

    public static String getWebSignMD5String(String str) {
        return URLEncodeUtils.a(2, str);
    }

    public static String signOpra(String str) {
        return URLEncodeUtils.a(3, str);
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

    public static String getFileMD5String(File file, int i) throws IOException {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[i];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                messageDigest.update(bArr, 0, read);
            } else {
                fileInputStream.close();
                try {
                    return a(messageDigest.digest());
                } catch (Exception e) {
                    throw new IOException(e.toString());
                }
            }
        }
    }

    public static String getFileMD5StringNIO(File file, int i) throws IOException {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(i);
        while (channel.read(allocate) != -1) {
            allocate.flip();
            messageDigest.update(allocate);
            if (!allocate.hasRemaining()) {
                allocate.clear();
            }
        }
        fileInputStream.close();
        try {
            return a(messageDigest.digest());
        } catch (Exception e) {
            throw new IOException(e.toString());
        }
    }

    public static String getMD5String(byte[] bArr) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        messageDigest.update(bArr);
        try {
            return a(messageDigest.digest());
        } catch (Exception unused2) {
            return "";
        }
    }

    private static void a(byte b, StringBuffer stringBuffer) {
        char[] cArr = f9684a;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }
}
