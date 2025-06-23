package com.kwad.components.ad.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a {
    @NonNull
    public static Map<String, AppPackageInfo> K(Context context) {
        ActivityInfo activityInfo;
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        PackageManager packageManager = context.getPackageManager();
        if (av.Ne()) {
            try {
                List<String> Nf = av.Nf();
                if (Nf != null && !Nf.isEmpty()) {
                    Iterator it = new ArrayList(Nf).iterator();
                    while (it.hasNext()) {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo((String) it.next(), 0);
                            if (packageInfo != null) {
                                AppPackageInfo a2 = a(packageInfo, packageManager);
                                a2.reportMethod = 3;
                                hashMap.put(a2.packageName, a2);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            return hashMap;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null && o.LU()) {
            try {
                List<String> dv = bj.dv(context);
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                    if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && !TextUtils.isEmpty(activityInfo.packageName)) {
                        String str = resolveInfo.activityInfo.packageName;
                        if (dv != null && !dv.isEmpty()) {
                            dv.remove(str);
                        }
                        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo a3 = a(packageInfo2, packageManager);
                            a3.reportMethod = 1;
                            hashMap.put(a3.packageName, a3);
                        }
                    }
                }
                if (dv != null && !dv.isEmpty()) {
                    Iterator<String> it2 = dv.iterator();
                    while (it2.hasNext()) {
                        try {
                            PackageInfo packageInfo3 = packageManager.getPackageInfo(it2.next(), 0);
                            if (packageInfo3 != null) {
                                AppPackageInfo a4 = a(packageInfo3, packageManager);
                                a4.reportMethod = 2;
                                hashMap.put(a4.packageName, a4);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Exception unused4) {
            }
            hashMap.putAll(c(context, hVar.zm()));
        }
        return hashMap;
    }

    public static AppPackageInfo a(@NonNull PackageInfo packageInfo, @Nullable PackageManager packageManager) {
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = packageInfo.packageName;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo != null) {
            appPackageInfo.isSystemApp = a(applicationInfo) || b(packageInfo.applicationInfo);
        }
        appPackageInfo.versionName = packageInfo.versionName;
        appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
        appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
        if (packageManager != null && packageInfo.applicationInfo != null && al.an(ServiceProvider.getContext(), packageInfo.packageName)) {
            try {
                appPackageInfo.appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable th) {
                c.printStackTraceOnly(th);
            }
        }
        return appPackageInfo;
    }

    @NonNull
    public static JSONArray[] b(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        h hVar = (h) ServiceProvider.get(h.class);
        if (context == null || list == null || list.isEmpty() || hVar == null || !o.LU()) {
            return jSONArrayArr;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (String str : list) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    AppPackageInfo a2 = a(packageInfo, packageManager);
                    hashMap.put(a2.packageName, a2);
                } else {
                    AppPackageInfo appPackageInfo = new AppPackageInfo();
                    appPackageInfo.packageName = str;
                    hashMap2.put(str, appPackageInfo);
                }
            } catch (Exception unused) {
                AppPackageInfo appPackageInfo2 = new AppPackageInfo();
                appPackageInfo2.packageName = str;
                hashMap2.put(str, appPackageInfo2);
            }
        }
        jSONArrayArr[0] = c(hashMap);
        jSONArrayArr[1] = c(hashMap2);
        return jSONArrayArr;
    }

    @NonNull
    private static Map<String, AppPackageInfo> c(Context context, List<String> list) {
        HashMap hashMap = new HashMap();
        if (context != null && list != null) {
            for (String str : list) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo a2 = a(packageInfo, packageManager);
                        hashMap.put(a2.packageName, a2);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return hashMap;
    }

    @NonNull
    public static JSONArray c(@NonNull Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                AppPackageInfo appPackageInfo = map.get(it.next());
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    t.a(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return jSONArray;
    }

    public static void a(final Context context, final com.kwad.sdk.f.a<JSONArray> aVar) {
        g.execute(new az() { // from class: com.kwad.components.ad.g.a.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                aVar.accept(a.c(a.K(context)));
            }
        });
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "pkgName", appPackageInfo.packageName);
        t.putValue(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        t.putValue(jSONObject, "appVersion", appPackageInfo.versionName);
        t.putValue(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        t.putValue(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        t.putValue(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        t.putValue(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    private static boolean b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }

    private static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }
}
