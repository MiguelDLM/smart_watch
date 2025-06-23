package com.baidu.mapsdkplatform.comapi.util;

import IoxX.I0Io;
import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.constant.x;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.baidu.mapsdkplatform.comapi.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0142a {
        public static String a(byte[] bArr) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                sb.append(cArr[(bArr[i] & 240) >> 4]);
                sb.append(cArr[bArr[i] & 15]);
            }
            return sb.toString();
        }
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        return a(context, packageName) + x.aL + packageName;
    }

    private static String a(Context context, String str) {
        String str2;
        Signature[] signatureArr;
        SigningInfo signingInfo;
        boolean hasMultipleSigners;
        SigningInfo signingInfo2;
        SigningInfo signingInfo3;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                signingInfo = context.getPackageManager().getPackageInfo(str, C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                hasMultipleSigners = signingInfo.hasMultipleSigners();
                if (hasMultipleSigners) {
                    signingInfo3 = context.getPackageManager().getPackageInfo(str, C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                    signatureArr = signingInfo3.getApkContentsSigners();
                } else {
                    signingInfo2 = context.getPackageManager().getPackageInfo(str, C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                    signatureArr = signingInfo2.getSigningCertificateHistory();
                }
            } else {
                signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            }
            str2 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray())));
        } catch (Exception e) {
            e.printStackTrace();
            str2 = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str2.length(); i++) {
            stringBuffer.append(str2.charAt(i));
            if (i > 0 && i % 2 == 1 && i < str2.length() - 1) {
                stringBuffer.append(":");
            }
        }
        return stringBuffer.toString();
    }

    public static String a(X509Certificate x509Certificate) {
        try {
            return C0142a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(I0Io.f849Oxx0IOOO).digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
