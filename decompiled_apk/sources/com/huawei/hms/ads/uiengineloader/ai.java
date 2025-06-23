package com.huawei.hms.ads.uiengineloader;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes10.dex */
public abstract class ai {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17338a = "Sha256Util";

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            af.d(f17338a, "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
