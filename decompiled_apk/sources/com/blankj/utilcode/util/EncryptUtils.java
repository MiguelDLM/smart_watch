package com.blankj.utilcode.util;

import android.os.Build;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes8.dex */
public final class EncryptUtils {
    private EncryptUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] decrypt3DES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return symmetricTemplate(bArr, bArr2, "DESede", str, bArr3, false);
    }

    public static byte[] decryptAES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return symmetricTemplate(bArr, bArr2, "AES", str, bArr3, false);
    }

    public static byte[] decryptBase64AES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return decryptAES(UtilsBridge.base64Decode(bArr), bArr2, str, bArr3);
    }

    public static byte[] decryptBase64DES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return decryptDES(UtilsBridge.base64Decode(bArr), bArr2, str, bArr3);
    }

    public static byte[] decryptBase64RSA(byte[] bArr, byte[] bArr2, int i, String str) {
        return decryptRSA(UtilsBridge.base64Decode(bArr), bArr2, i, str);
    }

    public static byte[] decryptBase64_3DES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return decrypt3DES(UtilsBridge.base64Decode(bArr), bArr2, str, bArr3);
    }

    public static byte[] decryptDES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return symmetricTemplate(bArr, bArr2, "DES", str, bArr3, false);
    }

    public static byte[] decryptHexString3DES(String str, byte[] bArr, String str2, byte[] bArr2) {
        return decrypt3DES(UtilsBridge.hexString2Bytes(str), bArr, str2, bArr2);
    }

    public static byte[] decryptHexStringAES(String str, byte[] bArr, String str2, byte[] bArr2) {
        return decryptAES(UtilsBridge.hexString2Bytes(str), bArr, str2, bArr2);
    }

    public static byte[] decryptHexStringDES(String str, byte[] bArr, String str2, byte[] bArr2) {
        return decryptDES(UtilsBridge.hexString2Bytes(str), bArr, str2, bArr2);
    }

    public static byte[] decryptHexStringRSA(String str, byte[] bArr, int i, String str2) {
        return decryptRSA(UtilsBridge.hexString2Bytes(str), bArr, i, str2);
    }

    public static byte[] decryptRSA(byte[] bArr, byte[] bArr2, int i, String str) {
        return rsaTemplate(bArr, bArr2, i, str, false);
    }

    public static byte[] encrypt3DES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return symmetricTemplate(bArr, bArr2, "DESede", str, bArr3, true);
    }

    public static byte[] encrypt3DES2Base64(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return UtilsBridge.base64Encode(encrypt3DES(bArr, bArr2, str, bArr3));
    }

    public static String encrypt3DES2HexString(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return UtilsBridge.bytes2HexString(encrypt3DES(bArr, bArr2, str, bArr3));
    }

    public static byte[] encryptAES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return symmetricTemplate(bArr, bArr2, "AES", str, bArr3, true);
    }

    public static byte[] encryptAES2Base64(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return UtilsBridge.base64Encode(encryptAES(bArr, bArr2, str, bArr3));
    }

    public static String encryptAES2HexString(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return UtilsBridge.bytes2HexString(encryptAES(bArr, bArr2, str, bArr3));
    }

    public static byte[] encryptDES(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return symmetricTemplate(bArr, bArr2, "DES", str, bArr3, true);
    }

    public static byte[] encryptDES2Base64(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return UtilsBridge.base64Encode(encryptDES(bArr, bArr2, str, bArr3));
    }

    public static String encryptDES2HexString(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return UtilsBridge.bytes2HexString(encryptDES(bArr, bArr2, str, bArr3));
    }

    public static byte[] encryptHmacMD5(byte[] bArr, byte[] bArr2) {
        return hmacTemplate(bArr, bArr2, "HmacMD5");
    }

    public static String encryptHmacMD5ToString(String str, String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            return encryptHmacMD5ToString(str.getBytes(), str2.getBytes());
        }
        return "";
    }

    public static byte[] encryptHmacSHA1(byte[] bArr, byte[] bArr2) {
        return hmacTemplate(bArr, bArr2, "HmacSHA1");
    }

    public static String encryptHmacSHA1ToString(String str, String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            return encryptHmacSHA1ToString(str.getBytes(), str2.getBytes());
        }
        return "";
    }

    public static byte[] encryptHmacSHA224(byte[] bArr, byte[] bArr2) {
        return hmacTemplate(bArr, bArr2, "HmacSHA224");
    }

    public static String encryptHmacSHA224ToString(String str, String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            return encryptHmacSHA224ToString(str.getBytes(), str2.getBytes());
        }
        return "";
    }

    public static byte[] encryptHmacSHA256(byte[] bArr, byte[] bArr2) {
        return hmacTemplate(bArr, bArr2, "HmacSHA256");
    }

    public static String encryptHmacSHA256ToString(String str, String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            return encryptHmacSHA256ToString(str.getBytes(), str2.getBytes());
        }
        return "";
    }

    public static byte[] encryptHmacSHA384(byte[] bArr, byte[] bArr2) {
        return hmacTemplate(bArr, bArr2, "HmacSHA384");
    }

    public static String encryptHmacSHA384ToString(String str, String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            return encryptHmacSHA384ToString(str.getBytes(), str2.getBytes());
        }
        return "";
    }

    public static byte[] encryptHmacSHA512(byte[] bArr, byte[] bArr2) {
        return hmacTemplate(bArr, bArr2, "HmacSHA512");
    }

    public static String encryptHmacSHA512ToString(String str, String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            return encryptHmacSHA512ToString(str.getBytes(), str2.getBytes());
        }
        return "";
    }

    public static byte[] encryptMD2(byte[] bArr) {
        return hashTemplate(bArr, MessageDigestAlgorithms.MD2);
    }

    public static String encryptMD2ToString(String str) {
        if (str != null && str.length() != 0) {
            return encryptMD2ToString(str.getBytes());
        }
        return "";
    }

    public static byte[] encryptMD5(byte[] bArr) {
        return hashTemplate(bArr, "MD5");
    }

    public static byte[] encryptMD5File(String str) {
        return encryptMD5File(UtilsBridge.isSpace(str) ? null : new File(str));
    }

    public static String encryptMD5File2String(String str) {
        return encryptMD5File2String(UtilsBridge.isSpace(str) ? null : new File(str));
    }

    public static String encryptMD5ToString(String str) {
        if (str != null && str.length() != 0) {
            return encryptMD5ToString(str.getBytes());
        }
        return "";
    }

    public static byte[] encryptRSA(byte[] bArr, byte[] bArr2, int i, String str) {
        return rsaTemplate(bArr, bArr2, i, str, true);
    }

    public static byte[] encryptRSA2Base64(byte[] bArr, byte[] bArr2, int i, String str) {
        return UtilsBridge.base64Encode(encryptRSA(bArr, bArr2, i, str));
    }

    public static String encryptRSA2HexString(byte[] bArr, byte[] bArr2, int i, String str) {
        return UtilsBridge.bytes2HexString(encryptRSA(bArr, bArr2, i, str));
    }

    public static byte[] encryptSHA1(byte[] bArr) {
        return hashTemplate(bArr, MessageDigestAlgorithms.SHA_1);
    }

    public static String encryptSHA1ToString(String str) {
        if (str != null && str.length() != 0) {
            return encryptSHA1ToString(str.getBytes());
        }
        return "";
    }

    public static byte[] encryptSHA224(byte[] bArr) {
        return hashTemplate(bArr, "SHA224");
    }

    public static String encryptSHA224ToString(String str) {
        if (str != null && str.length() != 0) {
            return encryptSHA224ToString(str.getBytes());
        }
        return "";
    }

    public static byte[] encryptSHA256(byte[] bArr) {
        return hashTemplate(bArr, MessageDigestAlgorithms.SHA_256);
    }

    public static String encryptSHA256ToString(String str) {
        if (str != null && str.length() != 0) {
            return encryptSHA256ToString(str.getBytes());
        }
        return "";
    }

    public static byte[] encryptSHA384(byte[] bArr) {
        return hashTemplate(bArr, MessageDigestAlgorithms.SHA_384);
    }

    public static String encryptSHA384ToString(String str) {
        if (str != null && str.length() != 0) {
            return encryptSHA384ToString(str.getBytes());
        }
        return "";
    }

    public static byte[] encryptSHA512(byte[] bArr) {
        return hashTemplate(bArr, MessageDigestAlgorithms.SHA_512);
    }

    public static String encryptSHA512ToString(String str) {
        if (str != null && str.length() != 0) {
            return encryptSHA512ToString(str.getBytes());
        }
        return "";
    }

    public static byte[] hashTemplate(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static byte[] hmacTemplate(byte[] bArr, byte[] bArr2, String str) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, str);
                Mac mac = Mac.getInstance(str);
                mac.init(secretKeySpec);
                return mac.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static byte[] joins(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] rc4(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null) {
            if (bArr2.length >= 1 && bArr2.length <= 256) {
                byte[] bArr3 = new byte[256];
                byte[] bArr4 = new byte[256];
                int length = bArr2.length;
                for (int i = 0; i < 256; i++) {
                    bArr3[i] = (byte) i;
                    bArr4[i] = bArr2[i % length];
                }
                int i2 = 0;
                for (int i3 = 0; i3 < 256; i3++) {
                    byte b = bArr3[i3];
                    i2 = (i2 + b + bArr4[i3]) & 255;
                    byte b2 = bArr3[i2];
                    bArr3[i2] = b;
                    bArr3[i3] = b2;
                }
                byte[] bArr5 = new byte[bArr.length];
                int i4 = 0;
                for (int i5 = 0; i5 < bArr.length; i5++) {
                    i4 = (i4 + 1) & 255;
                    byte b3 = bArr3[i4];
                    i2 = (i2 + b3) & 255;
                    byte b4 = bArr3[i2];
                    bArr3[i2] = b3;
                    bArr3[i4] = b4;
                    bArr5[i5] = (byte) (bArr3[(b4 + bArr3[i2]) & 255] ^ bArr[i5]);
                }
                return bArr5;
            }
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        return null;
    }

    private static byte[] rsaTemplate(byte[] bArr, byte[] bArr2, int i, String str, boolean z) {
        KeyFactory keyFactory;
        Key generatePrivate;
        int i2;
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            try {
                if (Build.VERSION.SDK_INT < 28) {
                    keyFactory = KeyFactory.getInstance("RSA", "BC");
                } else {
                    keyFactory = KeyFactory.getInstance("RSA");
                }
                if (z) {
                    generatePrivate = keyFactory.generatePublic(new X509EncodedKeySpec(bArr2));
                } else {
                    generatePrivate = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
                }
                if (generatePrivate == null) {
                    return null;
                }
                Cipher cipher = Cipher.getInstance(str);
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                cipher.init(i2, generatePrivate);
                int length = bArr.length;
                int i3 = i / 8;
                if (z && str.toLowerCase().endsWith("pkcs1padding")) {
                    i3 -= 11;
                }
                int i4 = length / i3;
                if (i4 > 0) {
                    byte[] bArr3 = new byte[0];
                    byte[] bArr4 = new byte[i3];
                    int i5 = 0;
                    for (int i6 = 0; i6 < i4; i6++) {
                        System.arraycopy(bArr, i5, bArr4, 0, i3);
                        bArr3 = joins(bArr3, cipher.doFinal(bArr4));
                        i5 += i3;
                    }
                    if (i5 != length) {
                        int i7 = length - i5;
                        byte[] bArr5 = new byte[i7];
                        System.arraycopy(bArr, i5, bArr5, 0, i7);
                        return joins(bArr3, cipher.doFinal(bArr5));
                    }
                    return bArr3;
                }
                return cipher.doFinal(bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        r6 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] symmetricTemplate(byte[] r3, byte[] r4, java.lang.String r5, java.lang.String r6, byte[] r7, boolean r8) {
        /*
            r0 = 0
            if (r3 == 0) goto L50
            int r1 = r3.length
            if (r1 == 0) goto L50
            if (r4 == 0) goto L50
            int r1 = r4.length
            if (r1 != 0) goto Lc
            goto L50
        Lc:
            java.lang.String r1 = "DES"
            boolean r1 = r1.equals(r5)     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L24
            javax.crypto.spec.DESKeySpec r1 = new javax.crypto.spec.DESKeySpec     // Catch: java.lang.Throwable -> L22
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L22
            javax.crypto.SecretKeyFactory r4 = javax.crypto.SecretKeyFactory.getInstance(r5)     // Catch: java.lang.Throwable -> L22
            javax.crypto.SecretKey r4 = r4.generateSecret(r1)     // Catch: java.lang.Throwable -> L22
            goto L2a
        L22:
            r3 = move-exception
            goto L4d
        L24:
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec     // Catch: java.lang.Throwable -> L22
            r1.<init>(r4, r5)     // Catch: java.lang.Throwable -> L22
            r4 = r1
        L2a:
            javax.crypto.Cipher r5 = javax.crypto.Cipher.getInstance(r6)     // Catch: java.lang.Throwable -> L22
            r6 = 2
            r1 = 1
            if (r7 == 0) goto L42
            int r2 = r7.length     // Catch: java.lang.Throwable -> L22
            if (r2 != 0) goto L36
            goto L42
        L36:
            javax.crypto.spec.IvParameterSpec r2 = new javax.crypto.spec.IvParameterSpec     // Catch: java.lang.Throwable -> L22
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L22
            if (r8 == 0) goto L3e
            r6 = 1
        L3e:
            r5.init(r6, r4, r2)     // Catch: java.lang.Throwable -> L22
            goto L48
        L42:
            if (r8 == 0) goto L45
            r6 = 1
        L45:
            r5.init(r6, r4)     // Catch: java.lang.Throwable -> L22
        L48:
            byte[] r3 = r5.doFinal(r3)     // Catch: java.lang.Throwable -> L22
            return r3
        L4d:
            r3.printStackTrace()
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.EncryptUtils.symmetricTemplate(byte[], byte[], java.lang.String, java.lang.String, byte[], boolean):byte[]");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0030: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:45:0x0030 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] encryptMD5File(java.io.File r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38 java.security.NoSuchAlgorithmException -> L3b
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38 java.security.NoSuchAlgorithmException -> L3b
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
            r2.<init>(r1, r4)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
            r4 = 262144(0x40000, float:3.67342E-40)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
        L18:
            int r3 = r2.read(r4)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
            if (r3 > 0) goto L18
            java.security.MessageDigest r4 = r2.getMessageDigest()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
            byte[] r4 = r4.digest()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32 java.security.NoSuchAlgorithmException -> L34
            r1.close()     // Catch: java.io.IOException -> L2a
            goto L2e
        L2a:
            r0 = move-exception
            r0.printStackTrace()
        L2e:
            return r4
        L2f:
            r4 = move-exception
            r0 = r1
            goto L4b
        L32:
            r4 = move-exception
            goto L3d
        L34:
            r4 = move-exception
            goto L3d
        L36:
            r4 = move-exception
            goto L4b
        L38:
            r4 = move-exception
        L39:
            r1 = r0
            goto L3d
        L3b:
            r4 = move-exception
            goto L39
        L3d:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L4a
            r1.close()     // Catch: java.io.IOException -> L46
            goto L4a
        L46:
            r4 = move-exception
            r4.printStackTrace()
        L4a:
            return r0
        L4b:
            if (r0 == 0) goto L55
            r0.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r0 = move-exception
            r0.printStackTrace()
        L55:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.EncryptUtils.encryptMD5File(java.io.File):byte[]");
    }

    public static String encryptMD5File2String(File file) {
        return UtilsBridge.bytes2HexString(encryptMD5File(file));
    }

    public static String encryptHmacMD5ToString(byte[] bArr, byte[] bArr2) {
        return UtilsBridge.bytes2HexString(encryptHmacMD5(bArr, bArr2));
    }

    public static String encryptHmacSHA1ToString(byte[] bArr, byte[] bArr2) {
        return UtilsBridge.bytes2HexString(encryptHmacSHA1(bArr, bArr2));
    }

    public static String encryptHmacSHA224ToString(byte[] bArr, byte[] bArr2) {
        return UtilsBridge.bytes2HexString(encryptHmacSHA224(bArr, bArr2));
    }

    public static String encryptHmacSHA256ToString(byte[] bArr, byte[] bArr2) {
        return UtilsBridge.bytes2HexString(encryptHmacSHA256(bArr, bArr2));
    }

    public static String encryptHmacSHA384ToString(byte[] bArr, byte[] bArr2) {
        return UtilsBridge.bytes2HexString(encryptHmacSHA384(bArr, bArr2));
    }

    public static String encryptHmacSHA512ToString(byte[] bArr, byte[] bArr2) {
        return UtilsBridge.bytes2HexString(encryptHmacSHA512(bArr, bArr2));
    }

    public static String encryptMD2ToString(byte[] bArr) {
        return UtilsBridge.bytes2HexString(encryptMD2(bArr));
    }

    public static String encryptMD5ToString(String str, String str2) {
        if (str == null && str2 == null) {
            return "";
        }
        if (str2 == null) {
            return UtilsBridge.bytes2HexString(encryptMD5(str.getBytes()));
        }
        if (str == null) {
            return UtilsBridge.bytes2HexString(encryptMD5(str2.getBytes()));
        }
        return UtilsBridge.bytes2HexString(encryptMD5((str + str2).getBytes()));
    }

    public static String encryptSHA1ToString(byte[] bArr) {
        return UtilsBridge.bytes2HexString(encryptSHA1(bArr));
    }

    public static String encryptSHA224ToString(byte[] bArr) {
        return UtilsBridge.bytes2HexString(encryptSHA224(bArr));
    }

    public static String encryptSHA256ToString(byte[] bArr) {
        return UtilsBridge.bytes2HexString(encryptSHA256(bArr));
    }

    public static String encryptSHA384ToString(byte[] bArr) {
        return UtilsBridge.bytes2HexString(encryptSHA384(bArr));
    }

    public static String encryptSHA512ToString(byte[] bArr) {
        return UtilsBridge.bytes2HexString(encryptSHA512(bArr));
    }

    public static String encryptMD5ToString(byte[] bArr) {
        return UtilsBridge.bytes2HexString(encryptMD5(bArr));
    }

    public static String encryptMD5ToString(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return "";
        }
        if (bArr2 == null) {
            return UtilsBridge.bytes2HexString(encryptMD5(bArr));
        }
        if (bArr == null) {
            return UtilsBridge.bytes2HexString(encryptMD5(bArr2));
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return UtilsBridge.bytes2HexString(encryptMD5(bArr3));
    }
}
