package com.iflytek.sparkchain.utils;

import com.iflytek.sparkchain.utils.log.LogUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes10.dex */
public class Encrypter {
    public static final int BUFFER_SIZE = 1024;
    public static final byte GZIP_KEY = 5;
    private static final String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCt8H0BF3SquJmk6xIo2bTldgvtazLIeSbR4cle\np7zeUAtI/mC7UgFl8xXFCTemVambyQFnM5GsZOI1BpAMJO7N/YHRX7hvCZG6D0rEXQEdKXhKFIBQ\nmOYRYZP042vWRcKZ6iQLdLYmyg6tIzjYVfH0f6YX8OLIU7fy0TA/c88rzwIDAQAB";
    private static final int SDK_VERSION_KITKAT = 19;

    public static synchronized String MD5(String str) {
        String stringBuffer;
        synchronized (Encrypter.class) {
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    char[] charArray = str.toCharArray();
                    byte[] bArr = new byte[charArray.length];
                    for (int i = 0; i < charArray.length; i++) {
                        bArr[i] = (byte) charArray[i];
                    }
                    byte[] digest = messageDigest.digest(bArr);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (byte b : digest) {
                        int i2 = b & 255;
                        if (i2 < 16) {
                            stringBuffer2.append("0");
                        }
                        stringBuffer2.append(Integer.toHexString(i2));
                    }
                    stringBuffer = stringBuffer2.toString();
                } catch (Exception e) {
                    LogUtil.e(e);
                    return "";
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringBuffer;
    }

    public static int byteArrayToInt(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += (bArr[i2] & 255) << ((3 - i2) * 8);
        }
        return i;
    }

    public static synchronized String cut16MD5(String str) {
        synchronized (Encrypter.class) {
            try {
                LogUtil.d("cut16MD5 start:" + str);
                String MD5 = MD5(str);
                LogUtil.d("cut16MD5 start:" + MD5);
                StringBuffer stringBuffer = new StringBuffer();
                if (MD5 != null && MD5.length() != 0) {
                    LogUtil.d("cut16MD5 md5 size is:" + MD5.length());
                    for (int i = 0; i < MD5.length(); i++) {
                        if (i % 2 == 0) {
                            LogUtil.d("cut16MD5 result i:" + MD5.charAt(i));
                            stringBuffer.append(MD5.charAt(i));
                        }
                        LogUtil.d("cut16MD5 result i = :" + i);
                    }
                    LogUtil.d("cut16MD5 result:" + ((Object) stringBuffer));
                    return stringBuffer.toString();
                }
                return null;
            } finally {
            }
        }
    }

    public static byte[] encrypt(byte[] bArr) {
        try {
            byte[] encoded = AESUtil.generateKey().getEncoded();
            byte[] encrypt = bArr != null ? AESUtil.encrypt(zip(bArr), encoded) : null;
            byte[] encryptByPublicKey = RSAUtil.encryptByPublicKey(encoded, RSAUtil.loadPublicKey(RSA_PUBLIC_KEY));
            if (encryptByPublicKey != null && encrypt != null) {
                int length = encryptByPublicKey.length;
                int length2 = encrypt.length;
                byte[] bArr2 = new byte[length + length2 + 10];
                bArr2[0] = 1;
                System.arraycopy(intToByteArray(length), 0, bArr2, 1, 4);
                System.arraycopy(encryptByPublicKey, 0, bArr2, 5, length);
                bArr2[length + 5] = 3;
                System.arraycopy(intToByteArray(length2), 0, bArr2, length + 6, 4);
                System.arraycopy(encrypt, 0, bArr2, length + 10, length2);
                return bArr2;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r0 == null) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getFileMd5(java.io.File r8) {
        /*
            boolean r0 = r8.exists()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.nio.channels.FileChannel r2 = r0.getChannel()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            long r6 = r8.length()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r4 = 0
            java.nio.MappedByteBuffer r8 = r2.map(r3, r4, r6)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r2.update(r8)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.math.BigInteger r8 = new java.math.BigInteger     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            byte[] r2 = r2.digest()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r3 = 1
            r8.<init>(r3, r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r2 = 16
            java.lang.String r1 = r8.toString(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
        L36:
            r0.close()     // Catch: java.io.IOException -> L3a
            goto L4e
        L3a:
            r8 = move-exception
            goto L4b
        L3c:
            r8 = move-exception
            r1 = r0
            goto L4f
        L3f:
            r8 = move-exception
            goto L45
        L41:
            r8 = move-exception
            goto L4f
        L43:
            r8 = move-exception
            r0 = r1
        L45:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto L4e
            goto L36
        L4b:
            r8.printStackTrace()
        L4e:
            return r1
        L4f:
            if (r1 == 0) goto L59
            r1.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r0 = move-exception
            r0.printStackTrace()
        L59:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.utils.Encrypter.getFileMd5(java.io.File):java.lang.String");
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] lightcode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 5);
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] zip(byte[] r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r2.write(r3)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            r2.finish()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27
            r2.close()     // Catch: java.io.IOException -> L1f
            r1.close()     // Catch: java.io.IOException -> L1f
            goto L38
        L1f:
            r3 = move-exception
            r3.printStackTrace()
            goto L38
        L24:
            r3 = move-exception
            r0 = r2
            goto L39
        L27:
            r3 = move-exception
            goto L2d
        L29:
            r3 = move-exception
            goto L39
        L2b:
            r3 = move-exception
            r2 = r0
        L2d:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L35
            r2.close()     // Catch: java.io.IOException -> L1f
        L35:
            r1.close()     // Catch: java.io.IOException -> L1f
        L38:
            return r0
        L39:
            if (r0 == 0) goto L41
            r0.close()     // Catch: java.io.IOException -> L3f
            goto L41
        L3f:
            r0 = move-exception
            goto L45
        L41:
            r1.close()     // Catch: java.io.IOException -> L3f
            goto L48
        L45:
            r0.printStackTrace()
        L48:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sparkchain.utils.Encrypter.zip(byte[]):byte[]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.zip.GZIPInputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.IOException, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.IOException, java.lang.Object] */
    public static byte[] zip5xDecode(byte[] bArr) {
        IOException iOException;
        byte[] bArr2;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPInputStream gZIPInputStream;
        ?? r0 = 0;
        byte[] bArr3 = null;
        GZIPInputStream gZIPInputStream2 = null;
        if (bArr == null) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 5);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            iOException = e;
            bArr2 = null;
        }
        try {
            byte[] bArr4 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr4, 0, 1024);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream2.write(bArr4, 0, read);
            }
            bArr3 = byteArrayOutputStream2.toByteArray();
            byteArrayOutputStream2.flush();
            try {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream2.close();
                r0 = bArr3;
                byteArrayOutputStream2 = byteArrayOutputStream2;
            } catch (IOException e2) {
                LogUtil.e(e2);
                r0 = bArr3;
                byteArrayOutputStream2 = e2;
            }
        } catch (IOException e3) {
            bArr2 = bArr3;
            gZIPInputStream2 = gZIPInputStream;
            iOException = e3;
            LogUtil.e(iOException);
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (IOException e4) {
                    LogUtil.e(e4);
                    byteArrayOutputStream = e4;
                    r0 = bArr2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    return r0;
                }
            }
            byteArrayInputStream.close();
            byteArrayOutputStream2.close();
            byteArrayOutputStream = byteArrayOutputStream2;
            r0 = bArr2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            return r0;
        } catch (Throwable th2) {
            th = th2;
            r0 = gZIPInputStream;
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (IOException e5) {
                    LogUtil.e(e5);
                    throw th;
                }
            }
            byteArrayInputStream.close();
            byteArrayOutputStream2.close();
            throw th;
        }
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static byte[] zip5xEncode(byte[] bArr) {
        byte[] bArr2;
        GZIPOutputStream gZIPOutputStream;
        ?? r0 = 0;
        byte[] bArr3 = null;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
            bArr2 = null;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            bArr3 = byteArrayOutputStream.toByteArray();
            for (int i = 0; i < bArr3.length; i++) {
                bArr3[i] = (byte) (bArr3[i] ^ 5);
            }
            try {
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                r0 = bArr3;
            } catch (IOException e2) {
                LogUtil.e(e2);
                r0 = bArr3;
            }
        } catch (IOException e3) {
            e = e3;
            bArr2 = bArr3;
            gZIPOutputStream2 = gZIPOutputStream;
            LogUtil.e(e);
            if (gZIPOutputStream2 != null) {
                try {
                    gZIPOutputStream2.close();
                } catch (IOException e4) {
                    LogUtil.e(e4);
                    r0 = bArr2;
                    return r0;
                }
            }
            byteArrayOutputStream.close();
            r0 = bArr2;
            return r0;
        } catch (Throwable th2) {
            th = th2;
            r0 = gZIPOutputStream;
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (IOException e5) {
                    LogUtil.e(e5);
                    throw th;
                }
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return r0;
    }
}
