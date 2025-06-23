package com.baidu.navisdk.module.powersavemode;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import com.baidu.navisdk.framework.interfaces.pronavi.i;
import com.baidu.navisdk.framework.interfaces.pronavi.n;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.h;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.l;
import com.baidu.navisdk.util.listener.ChargeStatusReceiver;
import com.huawei.openalliance.ad.constant.x;
import com.tencent.connect.common.II0xO0;

/* loaded from: classes7.dex */
public class f implements com.baidu.navisdk.module.powersavemode.b {
    private static volatile f h;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.powersavemode.a f7448a = null;
    private long b = 0;
    private long c = 0;
    private int d = 0;
    private a.InterfaceC0201a e = new a();
    private com.baidu.navisdk.comapi.base.d f = new b("Naving5");
    private ContentObserver g = new c(new com.baidu.navisdk.util.worker.loop.a());

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0201a {
        public a() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if (obj instanceof h) {
                h hVar = (h) obj;
                int i = hVar.b;
                boolean z = hVar.f6830a;
                f.this.b(i, z);
                if (f.this.a(i, z)) {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", II0xO0.f26834o0IXXIx, f.this.f7448a.d() + "," + f.this.f7448a.b(), f.this.f7448a.c() + "");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.util.worker.loop.b {
        public b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4421);
            observe(0);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            String str;
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaveMode", "mMsgHandler what:" + message.what);
            }
            int i = message.what;
            boolean z = false;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 4421 && f.this.f7448a != null) {
                            com.baidu.navisdk.module.powersavemode.a aVar = f.this.f7448a;
                            if (message.arg1 == 0) {
                                z = true;
                            }
                            if (aVar.b(z)) {
                                str = f.this.f7448a.d() + "," + f.this.f7448a.b();
                            } else {
                                str = x.dt;
                            }
                            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.3", message.arg1 + "", str, f.this.f7448a.c() + "");
                            return;
                        }
                        return;
                    }
                    e.f7447a[6] = true;
                    f.this.q();
                    return;
                }
                if (f.this.f7448a != null) {
                    f.this.f7448a.c(com.baidu.navisdk.comapi.commontool.a.getInstance().a());
                }
                f.this.f.sendEmptyMessageDelayed(1, 10000L);
                return;
            }
            if (f.this.f7448a != null && f.this.f7448a.d(false)) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", "2", f.this.f7448a.d() + "," + f.this.f7448a.b(), f.this.f7448a.c() + "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaveMode", "selfChange:" + z);
            }
            if (!z && f.this.f7448a != null && f.this.f7448a.e()) {
                f.this.n();
            }
        }
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "changeBrightnessByUser");
        }
        int b2 = l.b(com.baidu.navisdk.framework.a.c().a());
        int a2 = l.a(com.baidu.navisdk.framework.a.c().a());
        com.baidu.navisdk.util.statistic.userop.b.r().a("b.c", a2 + "", b2 + "", null);
        b(false);
    }

    public static com.baidu.navisdk.module.powersavemode.b o() {
        if (h == null) {
            synchronized (f.class) {
                try {
                    if (h == null) {
                        h = new f();
                    }
                } finally {
                }
            }
        }
        return h;
    }

    private boolean p() {
        int length = e.f7447a.length;
        for (int i = 0; i < length; i++) {
            if (!e.f7447a[i]) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("PowerSaveMode", "isSwitchAllOpen index:" + i);
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.f7448a == null || !p()) {
            return false;
        }
        return this.f7448a.g();
    }

    private void r() {
        Activity b2 = com.baidu.navisdk.framework.a.c().b();
        if (b2 == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaveMode", "requestSettingsWriteAuth err:");
                return;
            }
            return;
        }
        l.a(b2, 4101);
    }

    private void s() {
        int length = e.f7447a.length;
        for (int i = 0; i < length; i++) {
            e.f7447a[i] = true;
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void e() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "onGuideStart");
        }
        e.f7447a[4] = false;
        if (a(true)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", "9", this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void f() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "onTouchMapDown");
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.c > 600000) {
            this.d = 0;
        }
        long j = this.b;
        if (elapsedRealtime - j < 100) {
            int i = this.d + 1;
            this.d = i;
            if (i == 1) {
                this.c = j;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaveMode", "mTouchInterruptCnt：" + this.d);
            }
        }
        if (this.d >= 2 && elapsedRealtime - this.c < 600000) {
            b();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaveMode", "touch over times");
            }
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void g() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "onFastRouteStart");
        }
        e.f7447a[5] = false;
        if (q()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", "10", this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void h() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("PowerSaveMode", "onStopRouteGuide:");
        }
        com.baidu.navisdk.module.powersavemode.a aVar = this.f7448a;
        if (aVar != null && aVar.b(false)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", "11", this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void i() {
        e.f7447a[2] = false;
        if (a(true)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", "5", this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void j() {
        e.f7447a[3] = true;
        if (q()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", "8", this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public boolean k() {
        com.baidu.navisdk.module.powersavemode.a aVar = this.f7448a;
        if (aVar != null && aVar.f()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void l() {
        e.f7447a[3] = false;
        if (a(true)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", "7", this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    public boolean m() {
        return l.c(com.baidu.navisdk.framework.a.c().a());
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void onBackground() {
        e.f7447a[0] = false;
        if (a(true)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", "3", this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void onForeground() {
        e.f7447a[0] = true;
        if (q()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", "4", this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void onResume() {
        e.f7447a[1] = true;
        if (q()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", II0xO0.f26773OO0, this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void onStop() {
        e.f7447a[1] = false;
        if (a(true)) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", II0xO0.f26825XoIxOXIXo, this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void c() {
        if (com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a() && this.f7448a == null) {
            ChargeStatusReceiver.a(com.baidu.navisdk.framework.a.c().a());
            if (!m()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("PowerSaveMode", "onStart FAIL:");
                    return;
                }
                return;
            }
            this.b = 0L;
            this.c = 0L;
            this.d = 0;
            com.baidu.navisdk.module.powersavemode.a aVar = new com.baidu.navisdk.module.powersavemode.a();
            this.f7448a = aVar;
            aVar.a();
            this.f7448a.c(com.baidu.navisdk.comapi.commontool.a.getInstance().a());
            e.f7447a[6] = false;
            a(false);
            this.f7448a.b(JNIGuidanceControl.getInstance().isCurScreenDark());
            com.baidu.navisdk.vi.b.a(this.f);
            com.baidu.navisdk.framework.message.a.a().a(this.e, h.class, new Class[0]);
            Uri uriFor = Settings.System.getUriFor("screen_brightness");
            Uri uriFor2 = Settings.System.getUriFor("screen_brightness_mode");
            Context a2 = com.baidu.navisdk.framework.a.c().a();
            a2.getContentResolver().registerContentObserver(uriFor, true, this.g);
            a2.getContentResolver().registerContentObserver(uriFor2, true, this.g);
            this.f.sendEmptyMessageDelayed(1, 600000L);
            this.f.sendEmptyMessageDelayed(2, 10000L);
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void d() {
        e.f7447a[2] = true;
        if (q()) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.1", "6", this.f7448a.d() + "," + this.f7448a.b(), this.f7448a.c() + "");
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void a() {
        f.e eVar = com.baidu.navisdk.module.cloudconfig.f.c().d;
        if (eVar == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("PowerSaveMode", "cloudconfig is null");
            }
        } else {
            if (!eVar.f7110a) {
                com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a(false);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("PowerSaveMode", "cloudconfig closed");
                    return;
                }
                return;
            }
            int[] iArr = eVar.b;
            com.baidu.navisdk.module.powersavemode.c.f7445a = iArr[0];
            com.baidu.navisdk.module.powersavemode.c.b = iArr[1];
            com.baidu.navisdk.module.powersavemode.c.c = iArr[2];
            int[] iArr2 = eVar.c;
            d.f7446a = iArr2[0];
            d.b = iArr2[1];
            d.c = iArr2[2];
        }
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void b() {
        b(true);
    }

    private void b(boolean z) {
        if (com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a()) {
            ChargeStatusReceiver.b(com.baidu.navisdk.framework.a.c().a());
            com.baidu.navisdk.framework.message.a.a().a(this.e);
            com.baidu.navisdk.vi.b.b(this.f);
            com.baidu.navisdk.module.powersavemode.a aVar = this.f7448a;
            if (aVar != null) {
                aVar.a(z);
                this.f7448a = null;
            }
            com.baidu.navisdk.framework.interfaces.pronavi.b h2 = com.baidu.navisdk.framework.interfaces.c.p().h();
            if (h2 != null && h2.x0()) {
                i C = h2.C();
                if (C != null) {
                    C.f(true);
                }
            } else {
                com.baidu.navisdk.framework.interfaces.lightnavi.a i = com.baidu.navisdk.framework.interfaces.c.p().i();
                if (i != null) {
                    i.g(true);
                }
            }
            com.baidu.navisdk.framework.a.c().a().getContentResolver().unregisterContentObserver(this.g);
            this.f.removeMessages(1);
            this.f.removeMessages(2);
            this.f.removeMessages(0);
            this.f.removeCallbacks(null);
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, boolean z) {
        com.baidu.navisdk.module.powersavemode.a aVar = this.f7448a;
        if (aVar != null) {
            return aVar.a(i, z);
        }
        return false;
    }

    @Override // com.baidu.navisdk.module.powersavemode.b
    public void a(int i) {
        if (i == 2) {
            b();
        } else if (!m()) {
            r();
        } else {
            c();
        }
    }

    private boolean a(boolean z) {
        com.baidu.navisdk.module.powersavemode.a aVar = this.f7448a;
        if (aVar != null) {
            return aVar.a(z);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z) {
        if (i < 0) {
            return;
        }
        com.baidu.navisdk.framework.interfaces.lightnavi.a i2 = com.baidu.navisdk.framework.interfaces.c.p().i();
        com.baidu.navisdk.framework.interfaces.pronavi.b h2 = com.baidu.navisdk.framework.interfaces.c.p().h();
        i C = h2 != null ? h2.C() : null;
        if (i < 20) {
            if (i2 != null && i2.t0()) {
                i2.g(false);
                return;
            }
            if (h2 == null || C == null || !C.o()) {
                return;
            }
            C.f(false);
            n b0 = h2.b0();
            if (b0 != null) {
                b0.f();
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.4", "0", null, null);
            return;
        }
        if (i2 != null && i2.t0()) {
            i2.g(true);
            return;
        }
        if (h2 == null || C == null || C.o()) {
            return;
        }
        C.f(true);
        n b02 = h2.b0();
        if (b02 != null) {
            b02.f();
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("b.c.4", "1", null, null);
    }
}
