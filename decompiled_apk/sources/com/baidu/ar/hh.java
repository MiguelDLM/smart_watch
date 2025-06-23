package com.baidu.ar;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes7.dex */
public class hh {
    private final Context mContext;

    public hh(Context context) {
        this.mContext = context;
    }

    private SharedPreferences eY() {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("fea_res_info", 0);
    }

    public void aZ(String str) {
        SharedPreferences eY = eY();
        if (eY == null || eY.edit() == null) {
            return;
        }
        eY.edit().putString("fea_res_md5", str).apply();
    }

    public String eX() {
        SharedPreferences eY = eY();
        return eY == null ? "" : eY.getString("fea_res_md5", "");
    }
}
