package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.nplatform.comapi.MapItem;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class e0 {
    private static volatile e0 d;

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f9225a;
    private final SharedPreferences.Editor b;
    private final Map<String, Object> c = new HashMap();

    private e0(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MapItem.KEY_IS_MAP_ITEM, 0);
        this.f9225a = sharedPreferences;
        this.b = sharedPreferences.edit();
    }

    public static synchronized e0 a(Context context) {
        e0 e0Var;
        synchronized (e0.class) {
            try {
                if (d == null) {
                    synchronized (e0.class) {
                        try {
                            if (d == null) {
                                d = new e0(context);
                            }
                        } finally {
                        }
                    }
                }
                e0Var = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return e0Var;
    }

    public void b(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f9225a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public boolean c(String str) {
        try {
            this.c.remove(str);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("PreferenceHelper remove exception!", e);
            }
        }
        this.b.remove(str);
        this.b.apply();
        return true;
    }

    public boolean b(String str, boolean z) {
        try {
            this.c.put(str, Boolean.valueOf(z));
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("PreferenceHelper putBoolean exception!", e);
            }
        }
        this.b.putBoolean(str, z);
        this.b.apply();
        return true;
    }

    public SharedPreferences a() {
        return this.f9225a;
    }

    public boolean a(String str) {
        if (this.c.containsKey(str)) {
            return true;
        }
        return this.f9225a.contains(str);
    }

    public void b(String str) {
        if (this.f9225a.contains(str)) {
            this.b.remove(str);
            this.b.apply();
        }
    }

    public boolean a(String str, boolean z) {
        try {
            if (this.c.containsKey(str)) {
                Object obj = this.c.get(str);
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("PreferenceHelper getBoolean exception!", e);
            }
        }
        return this.f9225a.getBoolean(str, z);
    }

    public boolean b(String str, int i) {
        try {
            this.c.put(str, Integer.valueOf(i));
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("PreferenceHelper putInt exception!", e);
            }
        }
        this.b.putInt(str, i);
        this.b.apply();
        return true;
    }

    public boolean b(String str, long j) {
        try {
            this.c.put(str, Long.valueOf(j));
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("PreferenceHelper putLong exception!", e);
            }
        }
        this.b.putLong(str, j);
        this.b.apply();
        return true;
    }

    public int a(String str, int i) {
        try {
            if (this.c.containsKey(str)) {
                Object obj = this.c.get(str);
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("PreferenceHelper getInt exception!", e);
            }
        }
        return this.f9225a.getInt(str, i);
    }

    public boolean b(String str, String str2) {
        try {
            this.c.put(str, str2);
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("PreferenceHelper putString exception!", e);
            }
        }
        this.b.putString(str, str2);
        this.b.apply();
        return true;
    }

    public long a(String str, long j) {
        try {
            if (this.c.containsKey(str)) {
                Object obj = this.c.get(str);
                if (obj instanceof Long) {
                    return ((Long) obj).longValue();
                }
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("PreferenceHelper getLong exception!", e);
            }
        }
        return this.f9225a.getLong(str, j);
    }

    public String a(String str, String str2) {
        try {
            if (this.c.containsKey(str)) {
                Object obj = this.c.get(str);
                if (obj instanceof String) {
                    return (String) obj;
                }
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("PreferenceHelper getLong exception!", e);
            }
        }
        return this.f9225a.getString(str, str2);
    }

    public void a(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f9225a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public boolean a(String str, float f) {
        try {
            this.c.put(str, Float.valueOf(f));
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("PreferenceHelper putFloat exception!", e);
            }
        }
        this.b.putFloat(str, f);
        this.b.apply();
        return true;
    }
}
