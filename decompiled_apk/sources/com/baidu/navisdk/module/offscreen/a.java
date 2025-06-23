package com.baidu.navisdk.module.offscreen;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.provider.Settings;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.framework.interfaces.pronavi.n;
import com.baidu.navisdk.module.pronavi.model.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.facebook.login.widget.ToolTipPopup;

/* loaded from: classes7.dex */
public class a {
    private static a f = null;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    private static long l = -100000;

    /* renamed from: a, reason: collision with root package name */
    private f f7365a;
    public boolean b = false;
    public boolean c = false;
    private final com.baidu.navisdk.util.worker.loop.a d;
    public boolean e;

    /* renamed from: com.baidu.navisdk.module.offscreen.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class HandlerC0270a extends com.baidu.navisdk.util.worker.loop.a {
        public HandlerC0270a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.arg1;
            if (message.what == 5556) {
                if (i != 1) {
                    if (i == 4) {
                        a.this.a(false);
                        return;
                    }
                    return;
                }
                a.this.a(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(a aVar, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            TTSPlayerControl.playTTS("电量低是否进入黑屏导航", 0);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.worker.f<String, String> {
        public c(a aVar, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            TTSPlayerControl.playTTS("电量低是否进入黑屏导航", 0);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.util.worker.f<String, String> {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a aVar = a.this;
            aVar.b = false;
            if (!aVar.b()) {
                return null;
            }
            a.this.d();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.util.worker.f<String, String> {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (!a.h || j.e != 2) {
                return null;
            }
            a.a("offScreen", "handeMsgBrightAction in it,haha");
            a.this.b(2);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        boolean a(boolean z);
    }

    private a() {
        HandlerC0270a handlerC0270a = new HandlerC0270a("offScreen");
        this.d = handlerC0270a;
        this.e = false;
        com.baidu.navisdk.util.listener.a.a(handlerC0270a);
    }

    public static void a(String str, String str2) {
    }

    private void k() {
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (a2 != null) {
            try {
                if (Settings.System.getInt(a2.getContentResolver(), "screen_brightness_mode") == 1) {
                    int i2 = (int) (com.baidu.navisdk.module.offscreen.b.c * 255.0f);
                    LogUtil.e("MODULE_NAME", "backResetBrightness mode is automode bright ness is " + i2);
                    BNPowerSaver.a(com.baidu.navisdk.framework.a.c().b(), i2);
                } else {
                    BNPowerSaver.a(com.baidu.navisdk.framework.a.c().b(), BNSettingManager.getNormalBrightness());
                    LogUtil.e("MODULE_NAME", "backResetBrightness mode is mannully mode bright ness is " + BNSettingManager.getNormalBrightness());
                }
            } catch (Exception unused) {
            }
        }
    }

    private void l() {
        b(true);
    }

    public static a m() {
        if (f == null) {
            f = new a();
        }
        return f;
    }

    public static void n() {
        LogUtil.e("offScreen", "start test");
    }

    public void b(boolean z) {
        f fVar = this.f7365a;
        if (fVar != null) {
            fVar.a(z);
        }
    }

    public boolean c() {
        boolean z;
        boolean z2;
        com.baidu.navisdk.framework.interfaces.pronavi.b h2 = com.baidu.navisdk.framework.interfaces.c.p().h();
        if (h2 != null && h2.x0()) {
            z = true;
        } else {
            z = false;
        }
        if (h2 != null && h2.v0()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || z2) {
            return false;
        }
        return true;
    }

    public void d() {
        n b0;
        if (!this.e && !j.b().b && !h) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - l;
            l = currentTimeMillis;
            if (j2 < 10000) {
                a("offScreen", "time stop it");
                return;
            }
            n();
            this.e = true;
            LogUtil.e("offScreen", "enter in enterOffScreenState");
            a("offScreen", "enter in enterOffScreenState");
            com.baidu.navisdk.util.worker.c.a().c(new b(this, "enterOffScreenState-" + a.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(2, 0));
            j.b().f7471a = true;
            com.baidu.navisdk.framework.interfaces.pronavi.b h2 = com.baidu.navisdk.framework.interfaces.c.p().h();
            if (h2 != null && (b0 = h2.b0()) != null) {
                b0.a(1, true);
            }
            this.e = false;
            return;
        }
        a("offScreen", "failed enterOffScreenState , isInCheckingTime is , isInCounting is , sIsInOffScreenMode " + this.e + j.b().b);
        LogUtil.e("offScreen", "failed enterOffScreenState , isInCheckingTime is , isInCounting is , sIsInOffScreenMode " + this.e + j.b().b);
    }

    public void e() {
        BNPowerSaver.a(com.baidu.navisdk.framework.a.c().b(), 102);
        BNMapController.getInstance().onResume();
        b(false);
        h = false;
        this.b = false;
    }

    public void f() {
        if (g && h) {
            LogUtil.e("offScreen", "handleExitOffScreen");
            a("offScreen", "handleExitOffScreen");
            e();
            if (!j) {
                LogUtil.e("offScreen", "not sIsReallyLeave");
                a("offScreen", "not sIsReallyLeave");
                this.b = true;
                com.baidu.navisdk.util.worker.c.a().a(new d("HandleExitOffScreen-" + a.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(2, 0), 30000L);
            }
        }
    }

    public void g() {
        BNSettingManager.setNormalBrightness(BNPowerSaver.a((Context) com.baidu.navisdk.framework.a.c().b()));
        a("offScreen", "initOffScreen");
        k = true;
        this.c = false;
    }

    public void h() {
        LogUtil.e("offScreen", "original brightness is " + BNPowerSaver.a((Context) com.baidu.navisdk.framework.a.c().b()));
        h = true;
        com.baidu.navisdk.util.worker.c.a().c(new c(this, "offScreenAction-" + a.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(2, 0));
        BNPowerSaver.a(com.baidu.navisdk.framework.a.c().b(), (int) (com.baidu.navisdk.module.offscreen.b.f7369a * 255.0f));
        BNMapController.getInstance().onPause();
        l();
    }

    public void i() {
        if (g && h) {
            j = true;
            LogUtil.e("offScreen", "onChargedAction");
            a("offScreen", "onChargedAction");
            b(false);
            a();
            BNMapController.getInstance().onResume();
            h = false;
            j.b().f7471a = false;
        }
    }

    public void j() {
        j.b().f7471a = false;
        j = true;
        h = false;
        i = false;
        b(false);
        if (this.c) {
            k();
        }
        a("offScreen", "uninit off screen");
        n();
        a("offScreen", "uninitOffScreen");
        k = false;
    }

    public void a() {
        BNPowerSaver.a(com.baidu.navisdk.framework.a.c().b(), BNSettingManager.getNormalBrightness());
    }

    public void a(int i2) {
        if (g) {
            if (j.b().b) {
                a("offScreen", "handeMsgBrightAction isincounting");
                com.baidu.navisdk.util.worker.c.a().a(new e("HandeMsgBrightAction-" + a.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(2, 0), ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                return;
            }
            b(2);
        }
    }

    public boolean b() {
        if (!g) {
            return false;
        }
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.M) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("offScreen", "isHwPowerSaverOpen false");
            }
            return false;
        }
        boolean c2 = c();
        boolean z = BNPowerSaver.getInstance().a() <= 20;
        boolean z2 = BNCommSettingManager.getInstance().getPowerSaveMode() != 2;
        boolean b2 = BNPowerSaver.getInstance().b();
        boolean z3 = i;
        LogUtil.e("offScreen", "manger ret 0 ,ret2, ret3, ret4 , ret5 is " + c2 + z + ", " + z2 + "," + b2 + "," + z3);
        a("offScreen", "manager ret 0,ret2, ret3, ret4 , ret5 is " + c2 + z + ", " + z2 + "," + b2 + "," + z3);
        return c2 && z && z2 && !b2 && z3;
    }

    public void a(boolean z) {
        if (g && h) {
            Activity b2 = com.baidu.navisdk.framework.a.c().b();
            if (z) {
                BNPowerSaver.a(b2, (int) (com.baidu.navisdk.module.offscreen.b.b * 255.0f));
            } else if (h) {
                BNPowerSaver.a(b2, (int) (com.baidu.navisdk.module.offscreen.b.f7369a * 255.0f));
            }
        }
    }

    public void b(int i2) {
        if (i2 == 1) {
            if (b()) {
                d();
            }
        } else if (i2 == 2) {
            f();
        }
    }
}
