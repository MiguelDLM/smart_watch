package com.jd.ad.sdk.jad_do;

import android.app.Application;
import android.content.pm.PackageInfo;

/* loaded from: classes10.dex */
public class jad_an {
    public static boolean jad_an(String str) {
        PackageInfo packageInfo;
        Application jad_an;
        try {
            jad_an = jad_bo.jad_an();
        } catch (Throwable unused) {
            packageInfo = null;
        }
        if (jad_an == null) {
            return false;
        }
        packageInfo = jad_an.getPackageManager().getPackageInfo(str, 0);
        return packageInfo != null;
    }
}
