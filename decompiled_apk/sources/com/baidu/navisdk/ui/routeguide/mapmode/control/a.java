package com.baidu.navisdk.ui.routeguide.mapmode.control;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.c;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.abtest.model.k;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i1;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.t;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class a implements com.baidu.navisdk.ui.routeguide.mapmode.iview.g {
    private com.baidu.navisdk.util.worker.f<String, String> b;
    private boolean h;
    private c.e i;
    private com.baidu.navisdk.pronavi.data.model.h j;

    /* renamed from: a, reason: collision with root package name */
    private boolean f8685a = false;
    private boolean c = false;
    private boolean d = false;
    private String e = null;
    private Drawable f = null;
    private boolean g = false;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.control.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0449a extends com.baidu.navisdk.util.worker.f<String, String> {
        public C0449a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.j();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements g0.d {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.d
        public void a() {
            a.this.d = false;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements i0.f {
        public c(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
        }
    }

    /* loaded from: classes8.dex */
    public class d extends com.baidu.navisdk.util.worker.f<String, String> {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            a.this.x();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements c.e {

        /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.control.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0450a extends c.a {
            public C0450a() {
            }

            @Override // com.baidu.navisdk.framework.c.a
            public boolean a(c.e eVar, int i, Object obj) {
                a.this.j();
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.a.1", "2");
                return true;
            }
        }

        public e() {
        }

        @Override // com.baidu.navisdk.framework.c.e
        public c.C0198c a() {
            c.C0198c c0198c = new c.C0198c(a.this.i);
            C0450a c0450a = new C0450a();
            c0198c.b((Integer) 13, (c.a) c0450a).b((Integer) 15, (c.a) c0450a).b((Integer) 16, (c.a) c0450a).a(12, (c.a) c0450a).a((Integer) 11, (c.a) c0450a).a((Integer) 14, (c.a) c0450a).b(15, c0450a).a(RGFSMTable.FsmState.Voice, c0450a);
            return c0198c;
        }
    }

    /* loaded from: classes8.dex */
    public class f extends g0.f {
        public f() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void a(boolean z) {
            super.a(z);
            a.this.h = true;
            com.baidu.navisdk.framework.c.b().a(a.this.i);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.f, com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.e
        public void b(boolean z) {
            super.b(z);
            com.baidu.navisdk.framework.c.b().b(a.this.i);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements g0.d {
        public g() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.d
        public void a() {
            com.baidu.navisdk.framework.c.b().b(a.this.i);
        }
    }

    /* loaded from: classes8.dex */
    public class h implements i0.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f8693a;

        public h(Activity activity) {
            this.f8693a = activity;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.a.1", "3");
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.b.1", "3");
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.b.1", "2");
            a.this.j();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.b.1", "1");
            try {
                if (this.f8693a != null) {
                    this.f8693a.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                }
            } catch (Exception e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("", e.toString());
                }
            }
        }
    }

    public a(com.baidu.navisdk.pronavi.ui.base.b bVar) {
        new C0449a("ExitRouteSearchMode", null);
        this.j = null;
        LogUtil.e("VdrModeGuide", "RGMMVdrController,construct:" + bVar);
        if (bVar != null) {
            this.j = (com.baidu.navisdk.pronavi.data.model.h) bVar.b(com.baidu.navisdk.pronavi.data.model.h.class);
        }
        u();
    }

    private String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "(vdr未知)" : "(vdr起点中低)" : "(vdr极低)" : "(vdr低)" : "(vdr中)" : "(vdr高)" : "(vdr退出)";
    }

    private void l() {
        if (this.b != null) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.b, false);
            this.b = null;
        }
    }

    private void m() {
        x.b().C();
    }

    private void n() {
        String topState = RouteGuideFSM.getInstance().getTopState();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "exitHudModeIfNeed currentState:" + topState);
        }
        if (RGFSMTable.FsmState.HUD.equals(topState) || RGFSMTable.FsmState.HUDMirror.equals(topState)) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
        }
    }

    private void o() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "exitVdrMode isOpenVdrMode: " + this.f8685a);
        }
        this.f8685a = false;
        c(-1);
        l();
        t();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().E();
        this.g = false;
    }

    private String p() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    private int q() {
        com.baidu.navisdk.pronavi.data.model.h hVar = this.j;
        if (hVar != null) {
            return hVar.a().getValue().intValue();
        }
        return -1;
    }

    private int r() {
        com.baidu.navisdk.pronavi.data.model.h hVar = this.j;
        if (hVar != null) {
            return hVar.b().getValue().intValue();
        }
        return 0;
    }

    private void s() {
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(23, 0, bundle);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "handlerVdrMiddleLowInStart: " + bundle);
        }
        this.e = bundle.getString("vdrRoadName", " ");
        int i = bundle.getInt("routeType", 0);
        String string = bundle.getString("nextRoadName");
        if (i != 0) {
            int[] iArr = com.baidu.navisdk.module.pronavi.constant.b.b;
            if (i < iArr.length) {
                this.f = JarUtils.getResources().getDrawable(iArr[i]);
                a0.I().e().a(this.f, string);
            }
        }
        this.f = null;
        a0.I().e().a(this.f, string);
    }

    private void t() {
        if (this.d) {
            this.d = false;
            s.T().e(122);
        }
    }

    private void u() {
        this.i = new e();
    }

    private void v() {
        if (this.b == null) {
            this.b = new d("RGMMVdrController-showNotifTask", null);
        }
    }

    public static void w() {
        try {
            int vDRSwitchStatus = JNIGuidanceControl.getInstance().getVDRSwitchStatus(2);
            int vDRSwitchStatus2 = JNIGuidanceControl.getInstance().getVDRSwitchStatus(3);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("net_vdr_abtest_switch", vDRSwitchStatus);
            jSONObject.put("net_vdr_parkingarea_switch", vDRSwitchStatus2);
            jSONObject.put("vdr_navi_debug_switch", BNSettingManager.getGpsCloseVdrFunctionNormal());
            com.baidu.navisdk.comapi.a.a(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("VdrModeGuide", "sendVDRABTestSwitchToLocSDK Exception: " + e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        String p = p();
        boolean a2 = a(p);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "showContinueVdrLocationLowNotification isShow: " + a2);
        }
        if (!a2) {
            return;
        }
        i0 v = x.b().k(122).d(JarUtils.getResources().getDrawable(R.drawable.nsdk_notification_vdr_location_low_icon)).D(100).v(20000);
        Resources resources = JarUtils.getResources();
        int i = R.string.nsdk_vdr_long_time_low;
        i0 z = v.a(resources.getString(i)).z(2);
        Resources resources2 = JarUtils.getResources();
        int i2 = R.string.nsdk_vdr_try_open_navi_or_restart;
        boolean y = z.b(resources2.getString(i2)).g(JarUtils.getResources().getString(R.string.nsdk_string_common_alert_i_know)).a(new c(this)).a(new b()).y();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "showContinueVdrLocationLowNotification result: " + y);
        }
        this.d = y;
        if (y) {
            TTSPlayerControl.playTTS(JarUtils.getResources().getString(i) + JarUtils.getResources().getString(i2), 1);
            BNCommSettingManager.getInstance().setVdrLowNotificationShowDate(p);
        }
    }

    private void y() {
        if (this.b != null) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.b, false);
        }
        boolean a2 = a(p());
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "startShowNotification isShow: " + a2);
        }
        if (!a2) {
            return;
        }
        v();
        com.baidu.navisdk.util.worker.c.a().a(this.b, new com.baidu.navisdk.util.worker.e(2, 0), 30000L);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public void E(Message message) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "onVDRAbtestStatic: " + message);
        }
        k.x().b(true);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public boolean c() {
        return this.g;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public boolean d() {
        return this.f8685a;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public boolean e() {
        return this.f8685a;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public boolean f() {
        int q = q();
        if (q != 3 && q != 4 && q != 5) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public String g() {
        return this.e;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public void h() {
        int k = k();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("VdrModeGuide", "showWifiStateNotification ret:" + k);
        }
        if (k == 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.a.1", "1");
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public Drawable i() {
        return this.f;
    }

    public void j() {
        s.T().s();
    }

    public int k() {
        if (this.h) {
            return -1;
        }
        Activity b2 = com.baidu.navisdk.ui.routeguide.b.V().b();
        if (b2 == null) {
            b2 = com.baidu.navisdk.framework.a.c().b();
        }
        if (b2 != null && !b2.isFinishing()) {
            if (!s.T().b(131)) {
                return -3;
            }
            int a2 = com.baidu.navisdk.ui.routeguide.navicenter.d.b().a();
            if (a2 != 0) {
                return a2;
            }
            f fVar = new f();
            g gVar = new g();
            s.T().a(new h(b2), fVar, gVar);
            return 0;
        }
        return -2;
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public void onDestroy() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "onDestroy: ");
        }
        this.f8685a = false;
        c(-1);
        l();
        this.d = false;
        this.e = null;
        this.g = false;
        j();
    }

    private void c(int i) {
        com.baidu.navisdk.pronavi.data.model.h hVar = this.j;
        if (hVar == null || hVar.a().getValue().intValue() == i) {
            return;
        }
        this.j.a().setValue(Integer.valueOf(i));
    }

    private void d(int i) {
        com.baidu.navisdk.pronavi.data.model.h hVar = this.j;
        if (hVar == null || hVar.b().getValue().intValue() == i) {
            return;
        }
        this.j.b().setValue(Integer.valueOf(i));
    }

    private void b(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "openVdrMode isOpenVdrMode: " + this.f8685a);
        }
        this.f8685a = true;
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().F2()) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().D();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().b(a(i));
        k.x().e(true);
        int r = r();
        if (r == 2) {
            k.x().c(true);
        } else if (r == 1) {
            k.x().d(true);
        }
    }

    private boolean a(String str) {
        String vdrLowNotificationShowDate = BNCommSettingManager.getInstance().getVdrLowNotificationShowDate();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "isShowOperableNotification lastDate: " + vdrLowNotificationShowDate + ", currentDate: " + str + ",isTestNotification:" + this.c);
        }
        return (LogUtil.LOGGABLE && this.c) || TextUtils.isEmpty(vdrLowNotificationShowDate) || !vdrLowNotificationShowDate.equals(str);
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public void a(Message message) {
        int q = q();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "onVdrGuideForLostGps 当前vdr状态: " + a(message.arg1) + ", vdr类型:" + message.arg2 + ",上次vdrState:" + a(q));
        }
        this.e = null;
        int i = message.arg1;
        c(i);
        d(message.arg2);
        if (q == 5 && i != 5) {
            x.b().O(false);
        }
        a(q, i);
        if (i == 0) {
            o();
            return;
        }
        if (i == 1 || i == 2) {
            l();
            t();
            b(i);
            m();
            return;
        }
        if (i == 3) {
            n();
            m();
            l();
            t();
            b(i);
            return;
        }
        if (i != 4) {
            if (i != 5) {
                return;
            }
            s();
            n();
            b(i);
            x.b().O(true);
            return;
        }
        b(i);
        if (LogUtil.LOGGABLE) {
            this.c = message.arg2 == -113;
        }
        y();
        n();
        m();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public boolean b() {
        return this.f8685a;
    }

    private void a(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("VdrModeGuide", "hideWeatherAllViewIfNeed lastVdrState: " + i + ", nowVdrState:" + i2);
        }
        if (i1.r0() && i != i2 && i == -1 && i2 != 0) {
            com.baidu.navisdk.framework.c.b().a(16, 14);
            if (t.s().j()) {
                t.s().f();
            }
            x.b().I().c(false);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public int a() {
        return q();
    }

    @Override // com.baidu.navisdk.ui.routeguide.mapmode.iview.g
    public void a(boolean z) {
        this.g = z;
    }
}
