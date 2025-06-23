package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;

/* loaded from: classes11.dex */
public final class bd {
    private static String TAG = "plugin.signature";
    public static Signature[] aRg = new Signature[0];

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    private static Signature[] dg(Context context) {
        Signature[] signatureArr = aRg;
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                aRg = packageInfo.signatures;
            }
        } catch (PackageManager.NameNotFoundException e) {
            com.kwad.sdk.core.e.c.w(TAG, "Can not get signature, error = " + e.getLocalizedMessage());
            com.kwad.sdk.core.e.c.w(TAG, e);
        }
        return aRg;
    }

    public static String dh(Context context) {
        try {
            Signature[] dg = dg(context);
            if (dg != null && dg.length > 0) {
                return ae.l(dg[0].toByteArray());
            }
            return "";
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w(TAG, e);
            return "";
        }
    }
}
