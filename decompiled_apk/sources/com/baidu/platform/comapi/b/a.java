package com.baidu.platform.comapi.b;

import android.content.Context;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.google.android.exoplayer2.C;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f9536a = 621133959;

    public static boolean a(Context context) {
        return c(context);
    }

    private static int b(Context context) {
        Signature[] signatureArr;
        SigningInfo signingInfo;
        boolean hasMultipleSigners;
        SigningInfo signingInfo2;
        SigningInfo signingInfo3;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                signingInfo = context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                hasMultipleSigners = signingInfo.hasMultipleSigners();
                if (hasMultipleSigners) {
                    signingInfo3 = context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                    signatureArr = signingInfo3.getApkContentsSigners();
                } else {
                    signingInfo2 = context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo;
                    signatureArr = signingInfo2.getSigningCertificateHistory();
                }
            } else {
                signatureArr = context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 64).signatures;
            }
            return signatureArr[0].hashCode();
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean c(Context context) {
        if (b(context) == f9536a) {
            return true;
        }
        return false;
    }
}
