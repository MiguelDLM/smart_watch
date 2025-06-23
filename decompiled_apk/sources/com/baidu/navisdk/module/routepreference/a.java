package com.baidu.navisdk.module.routepreference;

import android.text.TextUtils;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f7475a;
    protected int b = -1;
    protected int c = 0;

    public a(String str) {
        this.f7475a = str;
    }

    private void j() {
        boolean z;
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7475a, "fixPreferValue(), mSinglePreferValue = " + this.c);
        }
        if (this.c == 0) {
            int a2 = a();
            this.c = a2;
            if (a2 == 0 && com.baidu.navisdk.framework.a.c().a() != null) {
                this.c = b();
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(this.f7475a, "getSinglePreferValueNotFix(), mSinglePreferValue = " + this.c);
                }
            }
        }
        if (this.c != 0) {
            if (!TextUtils.isEmpty(e())) {
                z = true;
                a(true);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(this.f7475a, "fixPreferValue. " + e());
                }
            } else {
                a(false);
                z = false;
            }
            if (!h() && (com.baidu.navisdk.j.d() || TextUtils.isEmpty(e()))) {
                if ((this.c & 32) != 0) {
                    a(32, false);
                    return;
                }
                return;
            }
            a(32, z);
        }
    }

    public abstract int a();

    public abstract int a(String str);

    public void a(boolean z) {
    }

    public abstract int b();

    public abstract b b(int i);

    public int c() {
        return this.b;
    }

    public abstract int d();

    public abstract void d(int i);

    public abstract String e();

    public void e(int i) {
        this.b = i;
    }

    public void f(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7475a, "setSinglePreferValue prefer: " + i + ", mSinglePreferValue: " + this.c);
        }
        if (i > 0) {
            this.c = i;
        }
    }

    public int g() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7475a, "getSinglePreferValueNotFix(), mSinglePreferValue = " + this.c);
        }
        if (this.c == 0) {
            int a2 = a();
            this.c = a2;
            if (a2 == 0 && com.baidu.navisdk.framework.a.c().a() != null) {
                this.c = b();
            }
        }
        return this.c;
    }

    public abstract boolean h();

    public void i() {
        this.b = -1;
    }

    public int a(int i) {
        String e = e();
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7475a, "getFixedPreferValue(), viasPrefer prefer = " + i + ", outSettingPlateNum = , isCarLimitOpen = " + h());
        }
        return i != 0 ? (h() || !(com.baidu.navisdk.j.d() || TextUtils.isEmpty(e))) ? i | 32 : i : i;
    }

    public boolean c(int i) {
        int i2 = this.b;
        return (i2 == -1 || i2 == i) ? false : true;
    }

    public int f() {
        j();
        return this.c;
    }

    public void a(int i, boolean z) {
        int a2 = a();
        int a3 = e.a(a2, i, z);
        d(a3);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7475a, "updatePreferValue(), changePrefer = " + i + " isPreferOpen = " + z + " lastPreferValue = " + a2 + " updatedPreferValue = " + a3);
        }
        int i2 = this.c;
        int a4 = e.a(i2, i, z);
        f(a4);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(this.f7475a, "updatePreferValue lastPreferValue = " + i2 + ", updatedPreferValue = " + a4 + ", changePrefer = " + i + ", isPreferOpen = " + z);
        }
    }
}
