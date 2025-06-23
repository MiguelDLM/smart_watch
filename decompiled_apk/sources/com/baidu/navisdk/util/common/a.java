package com.baidu.navisdk.util.common;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f9217a = "7777889654578967";

    public static String a(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(2, secretKeySpec, new IvParameterSpec(f9217a.getBytes()));
        return new String(cipher.doFinal(a(str2)), "utf-8");
    }

    public static String b(String str, String str2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(1, secretKeySpec, new IvParameterSpec(f9217a.getBytes()));
        return a(cipher.doFinal(str2.getBytes("utf-8")));
    }

    public static String a(byte[] bArr) {
        return new String(Base64.encode(bArr, 0));
    }

    public static byte[] a(String str) {
        return Base64.decode(str.getBytes(), 0);
    }
}
