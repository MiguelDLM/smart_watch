package com.baidu.lbsapi.auth;

import android.content.Context;
import com.huawei.openalliance.ad.constant.x;
import com.sma.smartv3.network.BaiDu;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Locale;

/* loaded from: classes7.dex */
class d {

    /* loaded from: classes7.dex */
    public static class a {
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

    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static String[] b(Context context) {
        String packageName = context.getPackageName();
        String[] b = b(context, packageName);
        if (b == null || b.length <= 0) {
            return null;
        }
        int length = b.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = b[i] + x.aL + packageName;
            if (b.f5584a) {
                b.a(BaiDu.MCODE_KEY + strArr[i]);
            }
        }
        return strArr;
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        return a(context, packageName) + x.aL + packageName;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String[] b(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.d.b(android.content.Context, java.lang.String):java.lang.String[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x009d A[LOOP:0: B:12:0x009d->B:22:0x00bd, LOOP_START, PHI: r1
      0x009d: PHI (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:11:0x009b, B:22:0x00bd] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "getFingerPrint："
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            r3 = 28
            r4 = 64
            if (r2 < r3) goto L52
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            r3 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r6, r3)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.pm.SigningInfo r2 = androidx.core.content.pm.oIX0oI.oIX0oI(r2)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            if (r2 != 0) goto L2a
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r4)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
        L23:
            android.content.pm.Signature[] r5 = r5.signatures     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            goto L5b
        L26:
            r5 = move-exception
            goto L77
        L28:
            r5 = move-exception
            goto L8e
        L2a:
            boolean r2 = com.baidu.lbsapi.auth.oIX0oI.oIX0oI(r2)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            if (r2 == 0) goto L41
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r3)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.pm.SigningInfo r5 = androidx.core.content.pm.oIX0oI.oIX0oI(r5)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.pm.Signature[] r5 = com.baidu.lbsapi.auth.II0xO0.oIX0oI(r5)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            goto L5b
        L41:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r3)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.pm.SigningInfo r5 = androidx.core.content.pm.oIX0oI.oIX0oI(r5)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.pm.Signature[] r5 = com.baidu.lbsapi.auth.I0Io.oIX0oI(r5)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            goto L5b
        L52:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r4)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            goto L23
        L5b:
            java.lang.String r6 = "X.509"
            java.security.cert.CertificateFactory r6 = java.security.cert.CertificateFactory.getInstance(r6)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            r5 = r5[r1]     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            byte[] r5 = r5.toByteArray()     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            r2.<init>(r5)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            java.security.cert.Certificate r5 = r6.generateCertificate(r2)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            java.security.cert.X509Certificate r5 = (java.security.cert.X509Certificate) r5     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            java.lang.String r5 = a(r5)     // Catch: java.security.cert.CertificateException -> L26 android.content.pm.PackageManager.NameNotFoundException -> L28
            goto L96
        L77:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
        L7c:
            r6.append(r0)
            java.lang.String r5 = r5.toString()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.baidu.lbsapi.auth.b.a(r5)
            goto L94
        L8e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            goto L7c
        L94:
            java.lang.String r5 = ""
        L96:
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            if (r5 == 0) goto Lc0
        L9d:
            int r0 = r5.length()
            if (r1 >= r0) goto Lc0
            char r0 = r5.charAt(r1)
            r6.append(r0)
            if (r1 <= 0) goto Lbd
            int r0 = r1 % 2
            r2 = 1
            if (r0 != r2) goto Lbd
            int r0 = r5.length()
            int r0 = r0 - r2
            if (r1 >= r0) goto Lbd
            java.lang.String r0 = ":"
            r6.append(r0)
        Lbd:
            int r1 = r1 + 1
            goto L9d
        Lc0:
            java.lang.String r5 = r6.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.d.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(X509Certificate x509Certificate) {
        try {
            return a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException e) {
            b.a("getFingerprintAs：" + e.toString());
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(IoxX.I0Io.f849Oxx0IOOO).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            b.a("generateSHA1：" + e.toString());
            return null;
        }
    }
}
