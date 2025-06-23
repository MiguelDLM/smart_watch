package com.kwad.sdk.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: classes11.dex */
public class bg {
    static final String TAG = "bg";

    public static void a(String str, String str2, int i) {
        SharedPreferences gY = gY(str);
        if (gY == null) {
            return;
        }
        gY.edit().putInt(str2, i).apply();
    }

    public static void aw(String str, String str2) {
        SharedPreferences gY = gY(str);
        if (gY == null) {
            return;
        }
        gY.edit().remove(str2).apply();
    }

    public static int b(String str, String str2, int i) {
        SharedPreferences gY = gY(str);
        return gY == null ? i : gY.getInt(str2, i);
    }

    public static void g(String str, String str2, String str3) {
        a(str, str2, str3, false);
    }

    @Nullable
    public static SharedPreferences gY(String str) {
        try {
            return ServiceProvider.Lw().getSharedPreferences(str, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static String h(String str, String str2, String str3) {
        try {
            SharedPreferences gY = gY(str);
            if (gY == null) {
                return str3;
            }
            String string = gY.getString(str2, str3);
            if (string != null && !TextUtils.isEmpty(string)) {
                if (!TextUtils.equals(string, str3) && com.kwad.sdk.core.a.c.dT(string)) {
                    return com.kwad.sdk.core.a.c.dS(string);
                }
                return string;
            }
            return str3;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return "";
        }
    }

    public static void i(String str, String str2, String str3) {
        if (!com.kwad.sdk.core.a.c.dT(str)) {
            g(str2, str3, com.kwad.sdk.core.a.c.dR(str));
        }
    }

    public static void l(String str, String str2, boolean z) {
        SharedPreferences gY = gY(str);
        if (gY == null) {
            return;
        }
        gY.edit().putBoolean(str2, z).apply();
    }

    public static boolean m(String str, String str2, boolean z) {
        SharedPreferences gY = gY(str);
        if (gY == null) {
            return z;
        }
        return gY.getBoolean(str2, z);
    }

    public static void a(String str, String str2, long j) {
        SharedPreferences gY = gY(str);
        if (gY == null) {
            return;
        }
        gY.edit().putLong(str2, j).apply();
    }

    public static long b(String str, String str2, long j) {
        SharedPreferences gY = gY(str);
        return gY == null ? j : gY.getLong(str2, j);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        try {
            SharedPreferences gY = gY(str);
            if (gY == null) {
                return;
            }
            if (z && !com.kwad.sdk.core.a.c.dT(str3)) {
                gY.edit().putString(str2, com.kwad.sdk.core.a.c.dR(str3)).apply();
            } else {
                gY.edit().putString(str2, str3).apply();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static <T> void a(String str, Map<String, T> map) {
        SharedPreferences gY = gY(str);
        if (gY == null) {
            return;
        }
        SharedPreferences.Editor edit = gY.edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(edit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.e(TAG, Log.getStackTraceString(th));
            }
        }
        edit.apply();
    }

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }
}
