package com.baidu.mapsdkplatform.comapi.util;

import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes7.dex */
public final class AlgorithmUtil {
    private AlgorithmUtil() {
    }

    private static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        if (str2 == null) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.f18320a);
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        int length = bArr.length;
        while (length % 16 != 0) {
            length++;
        }
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            if (i < bArr.length) {
                bArr2[i] = bArr[i];
            } else {
                bArr2[i] = 0;
            }
        }
        return cipher.doFinal(bArr2);
    }

    private static byte[] b(String str, String str2, byte[] bArr) throws Exception {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(HTTP.ASCII), "AES");
            Cipher cipher = Cipher.getInstance(com.kuaishou.weapon.p0.b.f18320a);
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return null;
    }

    private static byte[] c(String str, String str2, byte[] bArr) throws Exception {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return null;
    }

    public static byte[] getDecryptInfo(String str, String str2, byte[] bArr) throws Exception {
        return c(str, str2, bArr);
    }

    public static byte[] getUrlNeedInfo(String str, String str2, byte[] bArr) throws Exception {
        return b(str, str2, bArr);
    }

    public static byte[] setUrlNeedInfo(String str, String str2, byte[] bArr) throws Exception {
        return a(str, str2, bArr);
    }
}
