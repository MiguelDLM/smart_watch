package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes7.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name */
    private static Object f5613a = new Object();
    private static ad b;
    private SharedPreferences c;
    private SharedPreferences d = null;

    public ad() {
        this.c = null;
        if (com.baidu.location.f.getServiceContext() != null) {
            this.c = a(com.baidu.location.f.getServiceContext());
        }
    }

    public synchronized long a(String str, long j) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            try {
                j = sharedPreferences.getLong(str, j);
            } catch (Exception unused) {
            }
        }
        return j;
    }

    public SharedPreferences b(Context context) {
        if (this.d == null && context != null) {
            try {
                this.d = context.getSharedPreferences("MapCoreServicePregck", 0);
            } catch (Exception e) {
                e.printStackTrace();
                this.d = null;
            }
        }
        return this.d;
    }

    public static SharedPreferences a(Context context) {
        if (context != null) {
            try {
                return context.getSharedPreferences("MapCoreServicePreIA", 0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public synchronized void b(String str, long j) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            try {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(str, j);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public static ad a() {
        ad adVar;
        synchronized (f5613a) {
            try {
                if (b == null) {
                    b = new ad();
                }
                adVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return adVar;
    }

    public synchronized void b(String str, String str2) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            try {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str, str2);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public synchronized String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            try {
                str2 = sharedPreferences.getString(str, str2);
            } catch (Exception unused) {
            }
        }
        return str2;
    }
}
