package com.alibaba.sdk.android.oss.common.utils;

import android.util.Base64;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BinaryUtil {
    public static String calculateBase64Md5(byte[] bArr) {
        return toBase64String(calculateMd5(bArr));
    }

    public static byte[] calculateMd5(FileDescriptor fileDescriptor) throws IOException {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[10240];
            FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return instance.digest();
                }
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }

    public static String calculateMd5Str(byte[] bArr) {
        return getMd5StrFromBytes(calculateMd5(bArr));
    }

    private static String convertHashToString(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = str + Integer.toString((bArr[i] & 255) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0037 A[SYNTHETIC, Splitter:B:24:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003d A[SYNTHETIC, Splitter:B:29:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String fileToSHA1(java.lang.String r6) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            java.lang.String r2 = "SHA-1"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r3 = 0
            r4 = 0
        L_0x0012:
            r5 = -1
            if (r4 == r5) goto L_0x0024
            int r4 = r1.read(r6)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            if (r4 <= 0) goto L_0x0012
            r2.update(r6, r3, r4)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            goto L_0x0012
        L_0x001f:
            r6 = move-exception
            r0 = r1
            goto L_0x0035
        L_0x0022:
            goto L_0x003b
        L_0x0024:
            byte[] r6 = r2.digest()     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            java.lang.String r6 = convertHashToString(r6)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r1.close()     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            return r6
        L_0x0030:
            r6 = move-exception
            goto L_0x0035
        L_0x0032:
            r1 = r0
            goto L_0x003b
        L_0x0035:
            if (r0 == 0) goto L_0x003a
            r0.close()     // Catch:{ Exception -> 0x003a }
        L_0x003a:
            throw r6
        L_0x003b:
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.utils.BinaryUtil.fileToSHA1(java.lang.String):java.lang.String");
    }

    public static byte[] fromBase64String(String str) {
        return Base64.decode(str, 0);
    }

    public static String getMd5StrFromBytes(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return sb.toString();
    }

    public static String toBase64String(byte[] bArr) {
        return new String(Base64.encode(bArr, 0)).trim();
    }

    public static String calculateBase64Md5(String str) throws IOException {
        return toBase64String(calculateMd5(str));
    }

    public static String calculateMd5Str(String str) throws IOException {
        return getMd5StrFromBytes(calculateMd5(str));
    }

    public static String calculateBase64Md5(FileDescriptor fileDescriptor) throws IOException {
        return toBase64String(calculateMd5(fileDescriptor));
    }

    public static String calculateMd5Str(FileDescriptor fileDescriptor) throws IOException {
        return getMd5StrFromBytes(calculateMd5(fileDescriptor));
    }

    public static byte[] calculateMd5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0037 A[SYNTHETIC, Splitter:B:24:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x003d A[SYNTHETIC, Splitter:B:29:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String fileToSHA1(java.io.FileDescriptor r6) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            java.lang.String r2 = "SHA-1"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r3 = 0
            r4 = 0
        L_0x0012:
            r5 = -1
            if (r4 == r5) goto L_0x0024
            int r4 = r1.read(r6)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            if (r4 <= 0) goto L_0x0012
            r2.update(r6, r3, r4)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            goto L_0x0012
        L_0x001f:
            r6 = move-exception
            r0 = r1
            goto L_0x0035
        L_0x0022:
            goto L_0x003b
        L_0x0024:
            byte[] r6 = r2.digest()     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            java.lang.String r6 = convertHashToString(r6)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r1.close()     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            return r6
        L_0x0030:
            r6 = move-exception
            goto L_0x0035
        L_0x0032:
            r1 = r0
            goto L_0x003b
        L_0x0035:
            if (r0 == 0) goto L_0x003a
            r0.close()     // Catch:{ Exception -> 0x003a }
        L_0x003a:
            throw r6
        L_0x003b:
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.common.utils.BinaryUtil.fileToSHA1(java.io.FileDescriptor):java.lang.String");
    }

    public static byte[] calculateMd5(String str) throws IOException {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[10240];
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return instance.digest();
                }
            }
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("MD5 algorithm not found.");
        }
    }
}
