package com.huawei.openalliance.ad.utils;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import com.huawei.hms.ads.fb;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes10.dex */
public class au {
    private static final String Code = "Sha256Util";

    public static String Code(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.update(str.getBytes("utf-8"));
            return v.Code(messageDigest.digest());
        } catch (IOException | NoSuchAlgorithmException unused) {
            fb.I(Code, "fail to get file sha256");
            return null;
        }
    }

    public static byte[] Code(byte[] bArr) {
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            fb.Z(Code, "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
