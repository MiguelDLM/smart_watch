package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mshield.utility.g;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public class c implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f6387a;
    public Context b;
    public int c;
    public SharedPreferences.Editor d;
    public boolean e;
    public String f;
    public String g;

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i) {
        this(context, sharedPreferences, str, z, i, null);
    }

    public final Bundle a(String str, String str2, String str3) {
        try {
            com.baidu.mshield.b.c.a.b("SPT callProviderGet:" + str + "_" + str2 + "_" + str3);
            Bundle bundle = new Bundle();
            bundle.putString("operation", str);
            bundle.putString("pref_name", this.f);
            bundle.putString("key", str2);
            bundle.putString("defult_value", str3);
            if (this.e) {
                if (TextUtils.isEmpty(this.g)) {
                    return g.a(this.b, "CallPreferences", bundle);
                }
                return g.a(this.b, "CallPreferences", bundle, this.g);
            }
            return g.a(this.b, "CallPreferences", bundle);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        throw new RuntimeException("This preference not allow to call contains.");
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        SharedPreferences.Editor editor = this.d;
        if (editor != null) {
            return editor;
        }
        SharedPreferences sharedPreferences = this.f6387a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit();
        }
        return null;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new RuntimeException("This preference not allow to call getAll.");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.g))) {
            Bundle a2 = a("getBoolean", str, String.valueOf(z));
            if (a2 != null) {
                com.baidu.mshield.b.c.a.b("SPT getBoolean:return by resultBundle");
                return a2.getBoolean("result", z);
            }
            return z;
        }
        if (this.f6387a == null) {
            return z;
        }
        com.baidu.mshield.b.c.a.b("SPT getBoolean:return by mBase");
        return this.f6387a.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.g))) {
            Bundle a2 = a("getFloat", str, String.valueOf(f));
            if (a2 != null) {
                com.baidu.mshield.b.c.a.b("SPT getFloat:return by resultBundle");
                return a2.getFloat("result", f);
            }
            return f;
        }
        if (this.f6387a == null) {
            return f;
        }
        com.baidu.mshield.b.c.a.b("SPT getFloat:return by mBase");
        return this.f6387a.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.g))) {
            Bundle a2 = a("getInt", str, String.valueOf(i));
            if (a2 != null) {
                com.baidu.mshield.b.c.a.b("SPT getInt:return by resultBundle");
                return a2.getInt("result", i);
            }
            return i;
        }
        if (this.f6387a == null) {
            return i;
        }
        com.baidu.mshield.b.c.a.b("SPT getInt:return by mBase");
        return this.f6387a.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.g))) {
            Bundle a2 = a("getLong", str, String.valueOf(j));
            if (a2 != null) {
                com.baidu.mshield.b.c.a.b("SPT getLong:return by resultBundle");
                return a2.getLong("result", j);
            }
            return j;
        }
        if (this.f6387a == null) {
            return j;
        }
        com.baidu.mshield.b.c.a.b("SPT getLong:return by mBase");
        return this.f6387a.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.g))) {
            Bundle a2 = a("getString", str, str2);
            if (a2 != null) {
                com.baidu.mshield.b.c.a.b("SPT getString:return by resultBundle");
                return a2.getString("result", str2);
            }
            return str2;
        }
        if (this.f6387a == null) {
            return str2;
        }
        com.baidu.mshield.b.c.a.b("SPT getString:return by mBase");
        return this.f6387a.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("This preference not allow to call getStringSet.");
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences sharedPreferences = this.f6387a;
            if (sharedPreferences != null) {
                sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences sharedPreferences = this.f6387a;
            if (sharedPreferences != null) {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i, String str2) {
        this.b = context;
        this.c = i;
        this.f6387a = sharedPreferences;
        this.d = new b(context, sharedPreferences != null ? sharedPreferences.edit() : null, str, z, this.c, str2);
        this.e = z;
        this.f = str;
        this.g = str2;
    }
}
