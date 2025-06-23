package com.facebook.internal.security;

import IoxX.I0Io;
import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class CertificateUtil {

    @OOXIXo
    public static final String DELIMITER = ":";

    @OOXIXo
    public static final CertificateUtil INSTANCE = new CertificateUtil();

    private CertificateUtil() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final String getCertificateHash(@OOXIXo Context ctx) {
        IIX0o.x0xO0oo(ctx, "ctx");
        try {
            Signature[] signatures = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 64).signatures;
            StringBuilder sb = new StringBuilder();
            MessageDigest messageDigest = MessageDigest.getInstance(I0Io.f849Oxx0IOOO);
            IIX0o.oO(signatures, "signatures");
            int length = signatures.length;
            int i = 0;
            while (i < length) {
                Signature signature = signatures[i];
                i++;
                messageDigest.update(signature.toByteArray());
                sb.append(Base64.encodeToString(messageDigest.digest(), 0));
                sb.append(":");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            String sb2 = sb.toString();
            IIX0o.oO(sb2, "sb.toString()");
            return sb2;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getDELIMITER$facebook_core_release$annotations() {
    }
}
