package com.baidu.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.ar.if, reason: invalid class name */
/* loaded from: classes7.dex */
public final class Cif {
    private Map<String, String> yq;
    private int yr;

    public static void a(Context context, Cif cif) {
        SharedPreferences.Editor edit = context.getSharedPreferences("ar_res_info", 0).edit();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : cif.yq.entrySet()) {
            sb.append(entry.getKey() + " " + entry.getValue() + "\n");
        }
        edit.putString("res_version", sb.toString());
        edit.putInt("ar_sdk_version", cif.yr);
        edit.apply();
    }

    public static Cif fP() {
        Cif cif = new Cif();
        cif.yq = new HashMap();
        cif.yr = kg.getVersionCode();
        return cif;
    }

    public static Cif i(Context context) {
        Cif cif = new Cif();
        SharedPreferences sharedPreferences = context.getSharedPreferences("ar_res_info", 0);
        String string = sharedPreferences.getString("res_version", "");
        cif.yq = new HashMap();
        if (!TextUtils.isEmpty(string)) {
            for (String str : string.split("\n")) {
                String trim = str.trim();
                int indexOf = trim.indexOf(" ");
                if (indexOf > 0) {
                    cif.yq.put(trim.substring(0, indexOf).trim(), trim.substring(indexOf + 1).trim());
                }
            }
        }
        cif.yr = sharedPreferences.getInt("ar_sdk_version", 0);
        return cif;
    }

    public String by(String str) {
        return this.yq.get(str);
    }

    public int fQ() {
        return this.yr;
    }

    public void s(String str, String str2) {
        this.yq.put(str, str2);
    }
}
