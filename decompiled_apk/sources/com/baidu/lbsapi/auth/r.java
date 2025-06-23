package com.baidu.lbsapi.auth;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* loaded from: classes7.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private static KeyPair f5598a;

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && f5598a != null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, f5598a.getPrivate());
                Charset charset = StandardCharsets.UTF_8;
                return c.a(cipher.doFinal(str.getBytes(charset)), charset.name());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String b() {
        PublicKey publicKey;
        KeyPair keyPair = f5598a;
        if (keyPair == null || (publicKey = keyPair.getPublic()) == null) {
            return null;
        }
        try {
            return c.a(publicKey.getEncoded(), StandardCharsets.UTF_8.name());
        } catch (Exception unused) {
            return null;
        }
    }

    public static KeyPair a() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048, new SecureRandom());
            if (f5598a == null) {
                f5598a = keyPairGenerator.generateKeyPair();
            }
            return f5598a;
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str) {
        if (!TextUtils.isEmpty(str) && f5598a != null) {
            try {
                byte[] a2 = c.a(str.getBytes(StandardCharsets.UTF_8));
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, f5598a.getPrivate());
                return cipher.doFinal(a2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
