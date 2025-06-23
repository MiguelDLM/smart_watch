package com.baidu.mshield.x6.d;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    public static boolean a(Context context, String str) {
        return a(context, str, true);
    }

    public static boolean b(Context context, String str, boolean z) {
        try {
            String a2 = new com.baidu.mshield.x6.a.b(context).a(str);
            return TextUtils.isEmpty(a2) ? z : new JSONObject(a2).getInt("1") != 0;
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
            return z;
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            return b(context, str, z);
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
            return z;
        }
    }

    public static int a(Context context) {
        try {
            int i = new com.baidu.mshield.x6.a.b(context).i();
            if (i <= 0) {
                i = 60;
            }
            return i / 60;
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
            return 1;
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z) {
        try {
            JSONObject b = b(context, str);
            if (b.has(str2)) {
                return b.optInt(str2, z ? 1 : 0) == 1;
            }
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
        }
        return z;
    }

    public static JSONObject b(Context context, String str) {
        try {
            return new JSONObject(new com.baidu.mshield.x6.a.b(context).a(str)).optJSONObject("2");
        } catch (Throwable th) {
            com.baidu.mshield.x6.e.f.a(th);
            return new JSONObject();
        }
    }
}
