package x0;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import o0oIxXOx.XIxXXX0x0;

/* loaded from: classes11.dex */
public class xII {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f33793I0Io = "octopus_frequency";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f33794II0xO0 = "octopus_group_config";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final String f33795oIX0oI = "octopus_sdk_config";

    public static boolean I0Io(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f33795oIX0oI, 0);
        if (sharedPreferences == null || !sharedPreferences.contains(str)) {
            return false;
        }
        return true;
    }

    public static String II0XooXoX(Context context, String str) {
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences(f33793I0Io, 0).getString(str, "");
    }

    public static void II0xO0(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f33793I0Io, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.apply();
        }
    }

    public static void IXxxXO(Context context, String str, String str2) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(f33793I0Io, 0).edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public static String OOXIXo(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences(f33795oIX0oI, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, null);
    }

    public static void Oo(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f33795oIX0oI, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(str);
            edit.apply();
        }
    }

    public static int Oxx0IOOO(Context context, String str) {
        if (context == null) {
            return -1;
        }
        return context.getSharedPreferences(f33793I0Io, 0).getInt(str, -1);
    }

    public static void Oxx0xo(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f33795oIX0oI, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static Map<String, ?> X0o0xo(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f33795oIX0oI, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return null;
    }

    public static String XO() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public static void oIX0oI(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f33795oIX0oI, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.apply();
        }
    }

    public static void oO(Context context, String str, int i) {
        context.getSharedPreferences(f33795oIX0oI, 0).edit().putInt(str, i).apply();
    }

    public static String oOoXoXO(Context context, String str) {
        return context.getSharedPreferences(f33795oIX0oI, 0).getString(str, String.valueOf(System.currentTimeMillis() / 1000));
    }

    public static void ooOOo0oXI(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f33795oIX0oI, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (obj instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                edit.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                edit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                edit.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                edit.remove(str);
                edit.putStringSet(str, (Set) obj);
            }
            edit.apply();
        }
    }

    public static Object oxoX(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(f33795oIX0oI, 0);
        if (sharedPreferences == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (!(obj instanceof Set)) {
            return null;
        }
        return sharedPreferences.getStringSet(str, (Set) obj);
    }

    public static void x0XOIxOo(Context context, String str, int i) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(f33793I0Io, 0).edit();
            edit.putInt(str, i);
            edit.apply();
        }
    }

    public static void x0xO0oo(Context context) {
        if (!XO().equals(II0XooXoX(context, XIxXXX0x0.f31178xoIox))) {
            II0xO0(context);
            IXxxXO(context, XIxXXX0x0.f31178xoIox, XO());
        }
    }

    public static int xoIox(Context context, String str, int i) {
        return context.getSharedPreferences(f33795oIX0oI, 0).getInt(str, i);
    }

    public static Object xxIXOIIO(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences(f33794II0xO0, 0)) == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Set) {
            return sharedPreferences.getStringSet(str, (Set) obj);
        }
        return null;
    }
}
