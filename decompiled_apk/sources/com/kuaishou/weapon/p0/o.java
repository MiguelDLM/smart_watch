package com.kuaishou.weapon.p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.p;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class o {
    public static s a(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        int a2;
        int b;
        p b2 = b(jSONObject);
        if (b2 == null) {
            return null;
        }
        int a3 = b2.a();
        String l = b2.l();
        String j = b2.j();
        boolean z3 = true;
        if (b2.d() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (b2.h() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int e = b2.e();
        String c = b2.c();
        String f = b2.f();
        String b3 = b2.b();
        PackageInfo packageInfo = new PackageInfo();
        try {
            packageInfo.packageName = f;
            packageInfo.versionName = l;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            if (!TextUtils.isEmpty(f) && !TextUtils.isEmpty(b3) && b3.startsWith(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                applicationInfo.name = f + b3;
                applicationInfo.className = f + b3;
            }
            applicationInfo.theme = b2.i();
            packageInfo.applicationInfo = applicationInfo;
            List<p.a> m = b2.m();
            if (m != null && m.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < m.size(); i++) {
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.name = m.get(i).c();
                    activityInfo.theme = m.get(i).b();
                    activityInfo.labelRes = m.get(i).a();
                    if (!TextUtils.isEmpty(activityInfo.name)) {
                        arrayList.add(activityInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
        } catch (Throwable unused) {
        }
        s sVar = new s(packageInfo, a3, f, l, j, c);
        sVar.v = z;
        sVar.x = e;
        if (b2.k() == null) {
            a2 = 0;
        } else {
            a2 = b2.k().a();
        }
        if (b2.k() == null) {
            b = -1;
        } else {
            b = b2.k().b();
        }
        sVar.t = a2;
        sVar.u = b;
        sVar.s = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT > 29 && z2) {
            if (b2.g() != 1) {
                z3 = false;
            }
            z2 = z3;
        }
        sVar.y = z2;
        return sVar;
    }

    private static p b(JSONObject jSONObject) {
        try {
            p pVar = new p();
            pVar.a(jSONObject.optInt("wk"));
            pVar.a(jSONObject.optString("wan"));
            pVar.b(jSONObject.optString("wm"));
            pVar.b(jSONObject.optInt("wo"));
            pVar.c(jSONObject.optInt("wpr"));
            pVar.c(jSONObject.optString("wp"));
            pVar.e(jSONObject.optInt("ws", 1));
            pVar.d(jSONObject.optInt("wh", 0));
            pVar.f(jSONObject.optInt("wt"));
            pVar.d(jSONObject.optString("wu"));
            pVar.e(jSONObject.optString("wv"));
            JSONArray jSONArray = jSONObject.getJSONArray("wa");
            ArrayList arrayList = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                p.a aVar = new p.a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                aVar.a(jSONObject2.optInt("r"));
                aVar.b(jSONObject2.optInt("t"));
                aVar.a(jSONObject2.getString("n"));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar);
            }
            pVar.a(arrayList);
            p.b bVar = new p.b();
            JSONObject jSONObject3 = jSONObject.getJSONObject("we");
            bVar.a(jSONObject3.optInt("duration"));
            bVar.b(jSONObject3.optInt("network"));
            pVar.a(bVar);
            return pVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
