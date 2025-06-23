package com.baidu.mshield.b.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.sec.privacy.c.j;

/* loaded from: classes7.dex */
public class c {
    public static PackageInfo a(Context context, String str, int i) {
        try {
            com.baidu.mshield.b.c.a.a("---privacy getPackageInfo---" + System.currentTimeMillis());
            return j.a(context).a(str, i);
        } catch (PackageManager.NameNotFoundException e) {
            com.baidu.mshield.b.c.a.a(e);
            return null;
        }
    }
}
