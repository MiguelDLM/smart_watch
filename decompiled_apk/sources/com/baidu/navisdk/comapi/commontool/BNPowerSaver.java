package com.baidu.navisdk.comapi.commontool;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.WindowManager;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.bean.h;
import com.baidu.navisdk.j;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.p;
import com.baidu.navisdk.util.common.x;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;

/* loaded from: classes7.dex */
public class BNPowerSaver extends com.baidu.navisdk.comapi.base.c {
    private static final String l = SDKDebugFileUtil.POWER_SAVE_LOG + p.b();

    /* renamed from: a, reason: collision with root package name */
    private Activity f6696a;
    private boolean b;
    private BatteryReceiver c;
    private int d;
    private int e;
    private long f;
    private boolean g;
    private boolean h;
    private int i;
    private com.baidu.navisdk.util.worker.loop.a j;
    private f k;

    /* loaded from: classes7.dex */
    public class BatteryReceiver extends BroadcastReceiver {
        private BatteryReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = true;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int i = intent.getExtras().getInt("level");
                int i2 = intent.getExtras().getInt("scale", 100);
                if (100 == i2 || i2 == 0) {
                    BNPowerSaver.this.d = i;
                } else {
                    BNPowerSaver.this.d = (i * 100) / i2;
                }
                if (BNPowerSaver.this.e < 0) {
                    BNPowerSaver bNPowerSaver = BNPowerSaver.this;
                    bNPowerSaver.e = bNPowerSaver.d;
                }
                if (2 == intent.getIntExtra("status", 1)) {
                    BNPowerSaver.this.g = true;
                    com.baidu.navisdk.module.offscreen.a.m().i();
                } else {
                    BNPowerSaver.this.g = false;
                    if (com.baidu.navisdk.module.offscreen.a.g) {
                        LogUtil.e("offScreen", "late battery check");
                        if (com.baidu.navisdk.module.offscreen.a.m().b()) {
                            if (com.baidu.navisdk.module.offscreen.a.m().b) {
                                com.baidu.navisdk.module.offscreen.a.m().b = false;
                                return;
                            } else if (!com.baidu.navisdk.module.offscreen.a.m().e) {
                                com.baidu.navisdk.module.offscreen.a.m().d();
                            }
                        }
                    }
                }
                LogUtil.e("PowerSaver", "recv BATTERY_CHANGED: level " + i + ", charging " + BNPowerSaver.this.g);
                com.baidu.navisdk.util.worker.c.a().a(BNPowerSaver.this.k, new e(2, 0));
            }
            com.baidu.navisdk.framework.message.a.a().a(new h(BNPowerSaver.this.g, BNPowerSaver.this.d));
            if (LogUtil.LOGGABLE) {
                StringBuilder sb = new StringBuilder();
                sb.append(p.a());
                sb.append(",");
                sb.append(BNPowerSaver.this.d);
                sb.append(",");
                sb.append(BNPowerSaver.this.g);
                sb.append(',');
                if (BNSettingManager.getPowerSaveMode() == 2) {
                    z = false;
                }
                sb.append(z);
                sb.append(",");
                sb.append(BNSettingManager.isLightSavePowerEnabled());
                sb.append(",");
                sb.append(x.t());
                SDKDebugFileUtil.get(BNPowerSaver.l, false, false).add(sb.toString());
            }
        }

        public /* synthetic */ BatteryReceiver(BNPowerSaver bNPowerSaver, a aVar) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public class a extends f<String, String> {

        /* renamed from: com.baidu.navisdk.comapi.commontool.BNPowerSaver$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0178a implements Runnable {
            public RunnableC0178a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BNPowerSaver.this.e();
            }
        }

        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            BNPowerSaver.this.h();
            BNPowerSaver.this.j.postDelayed(new RunnableC0178a(), 60000L);
            if (BNPowerSaver.this.i == 0) {
                if (BNPowerSaver.this.h) {
                    if (BNPowerSaver.this.d > 20 || BNPowerSaver.this.g) {
                        try {
                            BNPowerSaver.this.g();
                        } catch (Throwable th) {
                            LogUtil.e(g.TAG, "stopSaveMode - Exception : " + th.toString());
                        }
                    }
                } else if (BNPowerSaver.this.d <= 20 && !BNPowerSaver.this.g) {
                    try {
                        BNPowerSaver.this.f();
                    } catch (Throwable th2) {
                        LogUtil.e(g.TAG, "startSaveMode - Exception : " + th2.toString());
                    }
                    if (com.baidu.navisdk.module.offscreen.a.m().b()) {
                        if (com.baidu.navisdk.module.offscreen.a.m().b) {
                            com.baidu.navisdk.module.offscreen.a.m().b = false;
                            return null;
                        }
                        if (!com.baidu.navisdk.module.offscreen.a.m().e) {
                            com.baidu.navisdk.module.offscreen.a.m().d();
                        }
                    } else if (com.baidu.navisdk.module.offscreen.a.k) {
                        TipTool.onCreateToastDialog(BNPowerSaver.this.f6696a, com.baidu.navisdk.ui.util.b.h(R.string.off_screen_low_battery));
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static BNPowerSaver f6700a = new BNPowerSaver(null);
    }

    public /* synthetic */ BNPowerSaver(a aVar) {
        this();
    }

    public static BNPowerSaver getInstance() {
        return b.f6700a;
    }

    private BNPowerSaver() {
        this.b = false;
        this.d = 0;
        this.e = -1;
        this.f = -1L;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.j = new com.baidu.navisdk.util.worker.loop.a("PS");
        this.k = new a("mOnBatteryChangedTask", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        if (this.f6696a != null && this.c == null) {
            LogUtil.e("PowerSaver", "registerBatteryReceiver");
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            BatteryReceiver batteryReceiver = new BatteryReceiver(this, null);
            this.c = batteryReceiver;
            try {
                this.f6696a.registerReceiver(batteryReceiver, intentFilter);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaver", "startSaveMode: isPowerSaveMode " + this.h);
        }
        if (j.d() && !this.h) {
            this.h = true;
            notifyObservers(1, this.d, null);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaver", "startSaveMode toast - BNOffScreenManager.sIsModelueActive = " + com.baidu.navisdk.module.offscreen.a.g + ", BNSettingManager.getVoiceMode() = " + BNCommSettingManager.getInstance().getVoiceMode());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        LogUtil.e("PowerSaver", "stopSaveMode: isPowerSaveMode " + this.h);
        if (j.d() && this.h) {
            this.h = false;
            notifyObservers(2, this.d, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        if (this.f6696a != null && this.c != null) {
            LogUtil.e("PowerSaver", "unregisterBatteryReceiver");
            try {
                this.f6696a.unregisterReceiver(this.c);
            } catch (Exception unused) {
            }
            this.c = null;
        }
    }

    public void c() {
        if (this.b) {
            h();
            this.j.removeCallbacksAndMessages(null);
            this.b = false;
            try {
                g();
            } catch (Throwable unused) {
            }
            this.f6696a = null;
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.8", (SystemClock.elapsedRealtime() - this.f) + "", (this.d - this.e) + "", null);
            if (LogUtil.LOGGABLE) {
                SDKDebugFileUtil.get(l, false, false).add("==end==");
            }
        }
    }

    public boolean b() {
        return this.g;
    }

    public int a() {
        return this.d;
    }

    public void a(Activity activity) {
        if (this.b || activity == null) {
            return;
        }
        this.f6696a = activity;
        this.i = BNCommSettingManager.getInstance().getPowerSaveMode();
        this.b = true;
        this.e = -1;
        this.f = SystemClock.elapsedRealtime();
        if (com.baidu.navisdk.module.offscreen.a.g && !com.baidu.navisdk.module.cloudconfig.f.c().c.M) {
            com.baidu.navisdk.module.offscreen.a.g = false;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaver", "isHwPowerSaverOpen false");
            }
        }
        a(this.i);
        if (LogUtil.LOGGABLE) {
            SDKDebugFileUtil.get(l, false, false).add("==start==");
        }
    }

    public void a(int i) {
        this.i = i;
        if (this.b) {
            e();
            if (i == 0) {
                return;
            }
            if (i == 1) {
                this.j.removeCallbacksAndMessages(null);
                try {
                    f();
                    return;
                } catch (Throwable th) {
                    LogUtil.e("PowerSaver", "startSaveMode - Exception : " + th.toString());
                    return;
                }
            }
            this.j.removeCallbacksAndMessages(null);
            try {
                g();
            } catch (Throwable th2) {
                LogUtil.e("PowerSaver", "stopSaveMode - Exception : " + th2.toString());
            }
        }
    }

    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void a(Activity activity, int i) {
        if (activity != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.screenBrightness = i * 0.003921569f;
            activity.getWindow().setAttributes(attributes);
        }
    }
}
