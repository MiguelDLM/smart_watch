package com.adp.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.UUID;

/* loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        d dVar = new d(context);
        String b = dVar.b("appuuid", "");
        if ("".equals(b)) {
            String uuid = UUID.randomUUID().toString();
            dVar.a("appuuid", uuid);
            return uuid;
        }
        return b;
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
