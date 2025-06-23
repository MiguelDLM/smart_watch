package com.baidu.navisdk.module.powersavemode;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f7444a = 0;
    private int b = 0;
    private int c = 100;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private boolean g = true;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private long k = 0;
    private boolean l = true;

    private boolean h() {
        int i;
        int a2;
        int b = b(this.c, this.g);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "brightnessLevel:" + b);
            LogUtil.e("PowerSaveMode", "mCurBatteryLevel:" + this.c);
        }
        if (b != -1 && b == this.d && (a2 = l.a(com.baidu.navisdk.framework.a.c().a())) != this.d) {
            this.d = a2;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaveMode", "error setlevel != curlevel：" + a2);
            }
        }
        int i2 = this.d;
        if (b == i2) {
            return false;
        }
        if (b == -1) {
            if (this.b == 1) {
                Context a3 = com.baidu.navisdk.framework.a.c().a();
                if (this.l) {
                    i = 178;
                } else {
                    i = 128;
                }
                l.a(a3, i);
            } else {
                l.a(com.baidu.navisdk.framework.a.c().a(), this.f7444a);
            }
            l.b(com.baidu.navisdk.framework.a.c().a(), this.b);
            this.e = this.b;
        } else {
            if (b > this.f7444a && i2 == -1) {
                return false;
            }
            l.b(com.baidu.navisdk.framework.a.c().a(), 0);
            l.a(com.baidu.navisdk.framework.a.c().a(), b);
            this.e = 0;
        }
        this.f = this.d;
        this.d = b;
        this.k = SystemClock.elapsedRealtime();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "adjustBrightness =" + b);
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "亮度：" + this.d);
        }
        return true;
    }

    public boolean a(int i, boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "onBatteryChange :" + i + "isCharging:" + z);
        }
        if (i >= 0) {
            this.c = i;
        }
        this.g = z;
        return h();
    }

    public int b() {
        int i = this.d;
        return i == -1 ? this.f7444a : i;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        int i = this.f;
        return i == -1 ? this.f7444a : i;
    }

    public boolean e() {
        int b = l.b(com.baidu.navisdk.framework.a.c().a());
        int i = this.e;
        if (i >= 0 && b != i) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaveMode", "changeByUser mode");
            }
            return true;
        }
        if (SystemClock.elapsedRealtime() - this.k < 1000) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaveMode", "changeNotByUser time");
            }
            return false;
        }
        if (this.d == -1 && this.e == this.b) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaveMode", "changeNotByUser system");
            }
            return false;
        }
        if (b != 1) {
            int a2 = l.a(com.baidu.navisdk.framework.a.c().a());
            int i2 = this.d;
            if (i2 != -1 && a2 != i2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("PowerSaveMode", "changeByUser level" + a2);
                }
                return true;
            }
            if (i2 != -1 && a2 == i2) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        if (this.d != -1) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "recoveryControl:");
        }
        this.i = false;
        return h();
    }

    public void c(boolean z) {
        this.l = z;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "isDayMode:" + z);
        }
    }

    private int b(int i, boolean z) {
        if (this.i || this.j || !this.h) {
            return -1;
        }
        boolean z2 = this.l;
        if (i <= 20) {
            if (z2) {
                return c.f7445a;
            }
            return d.f7446a;
        }
        if (i <= 50 && !z) {
            if (z2) {
                return c.b;
            }
            return d.b;
        }
        if (i > 100 || z) {
            return -1;
        }
        if (z2) {
            return c.c;
        }
        return d.c;
    }

    public boolean d(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "setTouchState =" + z);
        }
        this.j = z;
        return h();
    }

    public void a() {
        this.f7444a = l.a(com.baidu.navisdk.framework.a.c().a());
        this.b = l.b(com.baidu.navisdk.framework.a.c().a());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "mBackupSysValue:" + this.f7444a + " mBackupSysMode:" + this.b);
        }
        if (this.b == 1) {
            this.f7444a = 255;
        }
    }

    public boolean b(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "setEngineStateEnable:" + z);
        }
        this.h = z;
        return h();
    }

    public boolean a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "interruptControl:" + z);
        }
        this.i = true;
        if (z) {
            return h();
        }
        return false;
    }
}
