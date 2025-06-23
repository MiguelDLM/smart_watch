package com.baidu.navisdk.ui.routeguide.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.util.common.LogUtil;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public class g extends OrientationEventListener {
    private static boolean m = false;
    public static boolean n = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f9163a;
    private WeakReference<Activity> b;
    private Context c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private long h;
    private boolean i;
    private boolean j;
    private boolean k;
    private ContentObserver l;

    /* loaded from: classes8.dex */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Activity activity;
            super.onChange(z);
            boolean d = g.this.d();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGOrientationDetector", "AutoOrientationObserver - isLockScreen: " + d);
            }
            if (!d) {
                g.this.a(false);
                if (g.this.b != null) {
                    activity = (Activity) g.this.b.get();
                } else {
                    activity = null;
                }
                if (activity != null && com.baidu.navisdk.ui.routeguide.b.V().C()) {
                    g.this.a(activity, -1);
                }
                g.n = false;
                return;
            }
            if (g.this.l()) {
                g.this.a(true);
            }
        }
    }

    public g(Activity activity) {
        super(activity);
        this.f9163a = false;
        this.d = true;
        this.f = -1;
        this.g = 0;
        this.i = true;
        this.j = false;
        this.k = false;
        this.l = new a(new Handler());
        this.b = new WeakReference<>(activity);
        this.c = activity.getApplicationContext();
        f.a();
    }

    private void k() {
        Activity activity;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOrientationDetector", "handleOrientationFromResume->");
        }
        this.i = true;
        WeakReference<Activity> weakReference = this.b;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        if (this.g == 0) {
            this.g = activity.getResources().getConfiguration().orientation;
        }
        if (this.g == 1) {
            a(activity, 1);
        } else {
            a(activity, 6);
        }
        this.g = 0;
        if (!d()) {
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        if (x.b().a2() && !m && !this.f9163a && !x.b().M2() && !com.baidu.navisdk.module.dynamicui.a.f.a().d() && !x.b().Y1() && BNCommSettingManager.getInstance().getOrientationChangedDialogShowCount() < 3 && com.baidu.navisdk.ui.routeguide.b.V().C() && x.b().s2()) {
            return true;
        }
        return false;
    }

    public static void m() {
        m = true;
    }

    private void n() {
        if (!this.i) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGOrientationDetector", "pausePage-> isVisible = false! return");
                return;
            }
            return;
        }
        this.i = false;
        if (System.currentTimeMillis() - this.h < 1000 && x.b().d0() == 1) {
            this.g = 2;
        } else {
            this.g = x.b().d0();
        }
        this.h = 0L;
        a(false);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOrientationDetector", "pausePage->mOrientationOnPause=" + this.g);
        }
    }

    private void o() {
        Activity activity;
        WeakReference<Activity> weakReference = this.b;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.getContentResolver().unregisterContentObserver(this.l);
        }
    }

    public void c() {
        i();
        if (d() && l()) {
            a(true);
        }
    }

    public boolean d() {
        try {
            if (Settings.System.getInt(this.c.getContentResolver(), "accelerometer_rotation") != 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public void e() {
        this.j = true;
        n();
    }

    public void f() {
        this.j = false;
        k();
    }

    public void g() {
        n();
    }

    public void h() {
        if (this.d) {
            this.d = false;
            WeakReference<Activity> weakReference = this.b;
            if (weakReference == null) {
                return;
            }
            Activity activity = weakReference.get();
            this.e = BNSettingManager.isOrientationLandscapeByUser();
            if (d() && this.e) {
                a(activity, 6);
                return;
            }
            a(activity, 2);
            if (this.e) {
                b(false);
                return;
            }
            return;
        }
        if (!this.k && !this.j) {
            k();
        }
    }

    public void i() {
        Context context = this.c;
        if (context != null) {
            context.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this.l);
        }
    }

    public void j() {
        o();
        a(false);
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        Activity activity;
        int i2;
        int i3;
        WeakReference<Activity> weakReference = this.b;
        if (weakReference != null) {
            activity = weakReference.get();
        } else {
            activity = null;
        }
        if (activity != null && !activity.isFinishing()) {
            if (this.f != 0) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGOrientationDetector", "记录用户手机上一次放置的位置,mLastOrientation = 0,mOrientation= " + this.f);
                }
                i2 = this.f;
            } else {
                i2 = 0;
            }
            if (i == -1) {
                this.f = -1;
                return;
            }
            if (i <= 350 && i >= 10) {
                if (i > 80 && i < 100) {
                    i3 = 90;
                } else if (i > 170 && i < 190) {
                    i3 = 180;
                } else if (i > 260 && i < 280) {
                    i3 = 270;
                } else {
                    i3 = -1;
                }
            } else {
                i3 = 0;
            }
            if (i3 != -1 && i3 != this.f) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGOrientationDetector", "发生旋转 mOrientation= " + this.f + "， tmpOrientation = " + i3);
                }
                this.f = i3;
            }
            if (d()) {
                int i4 = this.f;
                if ((i4 == 90 || i4 == 270) && l()) {
                    this.f9163a = true;
                    x.b().i4();
                    BNCommSettingManager.getInstance().addOrientationChangedDialogShow();
                    a(false);
                    return;
                }
                return;
            }
            if (i2 >= 0 && i2 != this.f) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGOrientationDetector", "检测到手机位置距离上一次记录的手机位置不一致,mLastOrientation = " + i2 + ",mOrientation= " + this.f);
                }
                a(activity, -1);
                a(false);
                this.f = -1;
            }
        }
    }

    private void b(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOrientationDetector", "setSettingToSP-> isLandscape:" + z);
        }
        BNSettingManager.setOrientationLandscapeByUser(z);
        this.e = z;
    }

    public void a(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGOrientationDetector", "setSensorEnable - " + z);
        }
        if (z) {
            super.enable();
        } else {
            super.disable();
            this.f = -1;
        }
    }

    public void b() {
        j();
        WeakReference<Activity> weakReference = this.b;
        if (weakReference != null) {
            weakReference.clear();
            this.b = null;
        }
    }

    public void a(boolean z, Configuration configuration) {
        if (z) {
            this.h = System.currentTimeMillis();
            if (configuration.orientation != 2 && this.e) {
                b(false);
            }
            x.b().f1();
            return;
        }
        a(configuration);
    }

    private void a(Configuration configuration) {
        this.b.get();
    }

    public void a() {
        WeakReference<Activity> weakReference = this.b;
        Activity activity = weakReference != null ? weakReference.get() : null;
        if (activity == null) {
            return;
        }
        if (!d()) {
            a(true);
        }
        int i = activity.getResources().getConfiguration().orientation;
        if (i == 2) {
            LogUtil.e("RGOrientationDetector", "强制切换竖屏");
            a(activity, 1);
        } else if (i == 1) {
            LogUtil.e("RGOrientationDetector", "强制切换横屏");
            a(activity, 6);
            b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, int i) {
        if (activity != null) {
            activity.setRequestedOrientation(i);
        }
    }
}
