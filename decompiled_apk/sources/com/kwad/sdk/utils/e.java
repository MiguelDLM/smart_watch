package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes11.dex */
public final class e {
    private static HashMap<String, ArrayList<String>> aPj = new HashMap<>();
    private static String aPk;

    @Nullable
    private static ArrayList<String> L(Context context, String str) {
        String packageName;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (aPj.get(str) != null) {
            return aPj.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : M(context, packageName)) {
                String str2 = "error!";
                if ("MD5".equals(str)) {
                    str2 = a(signature, "MD5");
                } else if (IoxX.I0Io.f849Oxx0IOOO.equals(str)) {
                    str2 = a(signature, IoxX.I0Io.f849Oxx0IOOO);
                } else if ("SHA256".equals(str)) {
                    str2 = a(signature, "SHA256");
                }
                arrayList.add(str2);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", "签名信息列表获取失败 " + e.getMessage());
        }
        aPj.put(str, arrayList);
        return arrayList;
    }

    private static Signature[] M(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", e.getMessage());
            return null;
        }
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", e.getMessage());
            return "error!";
        }
    }

    @Nullable
    public static String bT(Context context) {
        if (!TextUtils.isEmpty(aPk)) {
            return aPk;
        }
        ArrayList<String> L = L(context, IoxX.I0Io.f849Oxx0IOOO);
        if (L != null && L.size() != 0) {
            aPk = L.get(0);
        }
        return aPk;
    }
}
