package com.baidu.navisdk.util.http;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import o0oIxXOx.oO;

/* loaded from: classes8.dex */
public class a {
    public static HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("cuid", a0.e());
        hashMap.put(oO.f31192XO, "0");
        hashMap.put("sv", a0.k());
        hashMap.put("osv", a0.b);
        return hashMap;
    }

    public static void a(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        if (!hashMap.containsKey("cuid")) {
            String e = a0.e();
            if (!TextUtils.isEmpty(e)) {
                hashMap.put("cuid", e);
            }
        }
        if (!hashMap.containsKey("osv") && !TextUtils.isEmpty(a0.b)) {
            hashMap.put("osv", a0.b);
        }
        if (!hashMap.containsKey("sv")) {
            String k = a0.k();
            if (!TextUtils.isEmpty(k)) {
                hashMap.put("sv", k);
            }
        }
        if (hashMap.containsKey("zid")) {
            return;
        }
        String F = com.baidu.navisdk.framework.b.F();
        if (TextUtils.isEmpty(F)) {
            return;
        }
        hashMap.put("zid", F);
    }

    public static void a(List<l> list) {
        if (list == null) {
            return;
        }
        if (!a(list, "cuid")) {
            String e = a0.e();
            if (!TextUtils.isEmpty(e)) {
                list.add(new i("cuid", e));
            }
        }
        if (!a(list, "osv") && !TextUtils.isEmpty(a0.b)) {
            list.add(new i("osv", a0.b));
        }
        if (!a(list, "sv")) {
            String k = a0.k();
            if (!TextUtils.isEmpty(k)) {
                list.add(new i("sv", k));
            }
        }
        if (a(list, "zid")) {
            return;
        }
        String F = com.baidu.navisdk.framework.b.F();
        if (TextUtils.isEmpty(F)) {
            return;
        }
        list.add(new i("zid", F));
    }

    private static boolean a(List<l> list, String str) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().a())) {
                return true;
            }
        }
        return false;
    }
}
