package com.baidu.navisdk.ui.routeguide.mapmode.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.navisdk.bluetooth.BNBluetoothAudio;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.h;
import com.baidu.navisdk.j;
import com.baidu.navisdk.ui.routeguide.control.q;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.y;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;

/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.ui.routeguide.mapmode.iview.d f8698a;

    /* loaded from: classes8.dex */
    public class a implements BNBluetoothAudio.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8699a;

        public a(c cVar, Context context) {
            this.f8699a = context;
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i) {
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i, int i2) {
            TipTool.onCreateToastDialog(this.f8699a, "设置失败");
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BNBaseDialog.OnNaviClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8700a;
        final /* synthetic */ int b;

        /* loaded from: classes8.dex */
        public class a implements BNBluetoothAudio.g {
            public a() {
            }

            @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
            public void a(int i) {
            }

            @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
            public void a(int i, int i2) {
                TipTool.onCreateToastDialog(b.this.f8700a, "蓝牙电话声道设置失败");
            }
        }

        public b(c cVar, Context context, int i) {
            this.f8700a = context;
            this.b = i;
        }

        @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
        public void onClick() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.3", "2", null, "1");
            com.baidu.navisdk.bluetooth.b.i().a(1, new a());
            BNSettingManager.setBluetoothChannelMode(this.b);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.presenter.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class DialogInterfaceOnDismissListenerC0452c implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC0452c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            c.this.f8698a.i(BNSettingManager.getBluetoothChannelMode());
        }
    }

    /* loaded from: classes8.dex */
    public class d implements BNBluetoothAudio.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8703a;

        public d(c cVar, Context context) {
            this.f8703a = context;
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i) {
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i, int i2) {
            TipTool.onCreateToastDialog(this.f8703a, "手机声道设置失败");
        }
    }

    public c(com.baidu.navisdk.ui.routeguide.mapmode.iview.d dVar) {
        this.f8698a = dVar;
    }

    public void b() {
        int voiceMode = BNSettingManager.getVoiceMode();
        int i = 0;
        if (voiceMode == 2) {
            this.f8698a.getVoiceMode(1);
        } else if (voiceMode == 3) {
            this.f8698a.getVoiceMode(2);
        } else {
            this.f8698a.getVoiceMode(0);
        }
        int mapMode = BNCommSettingManager.getInstance().getMapMode();
        if (mapMode != 1 && mapMode != 3) {
            this.f8698a.r(1);
        } else {
            this.f8698a.r(0);
        }
        int naviDayAndNightMode = BNSettingManager.getNaviDayAndNightMode();
        if (naviDayAndNightMode == 1) {
            this.f8698a.f(0);
        } else if (naviDayAndNightMode == 2) {
            this.f8698a.f(1);
        } else {
            this.f8698a.f(2);
        }
        this.f8698a.q(BNSettingManager.getIsShowMapSwitch());
        if (BNSettingManager.getPlayTTsVoiceMode() == 0) {
            this.f8698a.n(0);
        } else {
            this.f8698a.n(1);
        }
        if (BNCommSettingManager.getInstance().getFloatMode() == 0) {
            this.f8698a.o(0);
        } else {
            this.f8698a.o(1);
        }
        if (BNSettingManager.getSimpleGuideMode() == 0) {
            this.f8698a.h(0);
        } else {
            this.f8698a.h(1);
        }
        int bluetoothChannelMode = BNSettingManager.getBluetoothChannelMode();
        if (com.baidu.navisdk.bluetooth.a.a() || bluetoothChannelMode != 2) {
            i = bluetoothChannelMode;
        } else {
            BNSettingManager.setBluetoothChannelMode(0);
        }
        this.f8698a.i(i);
    }

    public void c() {
        if (!BNSettingManager.getFirsCarLogoGuide()) {
            this.f8698a.q(true);
        }
        if (BNSettingManager.getFirstVoiceGuide()) {
            return;
        }
        this.f8698a.u(true);
    }

    public boolean[] d() {
        boolean[] zArr = new boolean[11];
        try {
            zArr[2] = BNSettingManager.getPrefRealEnlargementNavi();
            zArr[3] = BNSettingManager.getColladaStatus();
            boolean z = true;
            zArr[1] = BNSettingManager.isAutoLevelMode();
            zArr[5] = BNSettingManager.getPrefParkSearch();
            zArr[6] = BNCommSettingManager.getInstance().getPrefFloatSwitch();
            zArr[4] = BNSettingManager.getShowCarLogoToEnd();
            zArr[0] = com.baidu.navisdk.module.routepreference.d.j().h();
            if (BNSettingManager.getPowerSaveMode() == 2 || !l.c(com.baidu.navisdk.ui.routeguide.b.V().b())) {
                z = false;
            }
            zArr[7] = z;
            zArr[8] = BNSettingManager.isPlayVoiceWhenCalling();
            zArr[9] = BNSettingManager.isScenicBroadcastOpen();
        } catch (Exception unused) {
        }
        return zArr;
    }

    public void e() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.1", "", null, "2");
        RouteGuideFSM.getInstance().setFullViewByUser(false);
        RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.Car3D);
        com.baidu.navisdk.ui.routeguide.b.V().r().l();
        BNCommSettingManager.getInstance().setMapMode(1);
    }

    public void f() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.1", null, "", "2");
        RouteGuideFSM.getInstance().setFullViewByUser(false);
        RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.North2D);
        com.baidu.navisdk.ui.routeguide.b.V().r().l();
        BNCommSettingManager.getInstance().setMapMode(2);
    }

    public void g() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "0", null, "1");
        this.f8698a.c(0, 0);
    }

    public void h() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "2", null, "1");
        this.f8698a.c(0, 3);
    }

    public void i() {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "1", null, "1");
        this.f8698a.c(0, 2);
    }

    public void j() {
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.b");
        BNSettingManager.setFirstCarLogoGuide(true);
        this.f8698a.q(false);
        this.f8698a.T();
    }

    public void a(int i, boolean z) {
        com.baidu.navisdk.module.routepreference.d.j().a(i, z);
    }

    public void a(boolean[] zArr, int i) {
        int i2 = 0;
        try {
            switch (i) {
                case 0:
                    String a2 = h.a();
                    if (TextUtils.isEmpty(a2) && zArr[i]) {
                        h.e(com.baidu.navisdk.framework.a.c().a());
                        a2 = h.a();
                    }
                    if (zArr[i]) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("b.1", "1", null, "1");
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("b.1", "0", null, "1");
                    }
                    this.f8698a.c(a2);
                    com.baidu.navisdk.module.routepreference.d.j().b(zArr[i]);
                    com.baidu.navisdk.behavrules.util.a.a().a(zArr[i] ? new com.baidu.navisdk.behavrules.event.b("asr_e_c_open_car_limit_inset") : new com.baidu.navisdk.behavrules.event.b("asr_e_c_close_car_limit_inset"));
                    break;
                case 1:
                    boolean z = zArr[i];
                    if (z) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.q", "1", null, "1");
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.q", "2", null, "1");
                    }
                    BNMapController.getInstance().getMapController().m(z);
                    BNSettingManager.setAutoLevelMode(z);
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b(z ? "asr_e_c_open_autolevel" : "asr_e_c_close_autolevel"));
                    break;
                case 2:
                    boolean z2 = zArr[i];
                    if (z2) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.r", "1", null, "1");
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.r", "2", null, "1");
                    }
                    BNSettingManager.setPrefRealEnlargementNavi(z2);
                    BNRouteGuider.getInstance().enableExpandmapDownload(z2);
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b(z2 ? "asr_e_c_open_enlarge_roadmap" : "asr_e_c_close_enlarge_roadmap"));
                    break;
                case 3:
                    BNSettingManager.setColladaStatus(zArr[i]);
                    break;
                case 4:
                    boolean z3 = zArr[i];
                    BNSettingManager.setShowCarLogoToEnd(z3);
                    BNMapController.getInstance().setRedLineRender(z3);
                    break;
                case 5:
                    boolean z4 = zArr[i];
                    BNSettingManager.setPrefParkSearch(z4);
                    BNSettingManager.setDestParkClicked();
                    if (z4) {
                        TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "已开启停车场推荐服务");
                        break;
                    }
                    break;
                case 6:
                    BNCommSettingManager.getInstance().setPrefFloatSwitch(zArr[i]);
                    break;
                case 7:
                    boolean z5 = zArr[i];
                    if (z5) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("b.b", "1", null, null);
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("b.b", "0", null, null);
                    }
                    if (!z5) {
                        i2 = 2;
                    }
                    BNSettingManager.setPowerSaveMode(i2);
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b(z5 ? "asr_e_c_open_powersaver" : "asr_e_c_close_powersaver"));
                    break;
                case 8:
                    if (zArr[i]) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.2", "1", null, "1");
                        BNSettingManager.setPlayVoiceWhenCalling(true);
                        break;
                    } else {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.2", "2", null, "1");
                        BNSettingManager.setPlayVoiceWhenCalling(false);
                        break;
                    }
                case 9:
                    if (zArr[i]) {
                        BNSettingManager.setScenicBroadcastOpen(true);
                        com.baidu.navisdk.ui.routeguide.b.V().r().l();
                        y.d();
                        break;
                    } else {
                        BNSettingManager.setScenicBroadcastOpen(false);
                        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J4();
                        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(false);
                        break;
                    }
            }
            this.f8698a.j(i);
        } catch (Throwable th) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "onSettingsChange exception ->" + th.getMessage());
            }
        }
    }

    public void c(int i) {
        BNSettingManager.setPlayTTsVoiceMode(i);
    }

    public void c(Context context) {
        if (x.b().n2()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "onChangeAngleHUDModeSetting isInterceptToHUDModeOnVdr ");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f2()) {
            TipTool.onCreateToastDialog(context, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_hud_not_allowed_fuzzy));
        } else {
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().N2()) {
                TipTool.onCreateToastDialog(context, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_hud_not_allowed_fuzzy));
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.4");
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_HUD_ENTER);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hud_inset"));
        }
    }

    public void e(int i) {
        if (BNSettingManager.setSimpleGuideMode(i)) {
            x.b().L4();
        }
        this.f8698a.c0();
        BNMapController.getInstance().setSimpleModeGuide(i == 1);
        q.c().b();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.k", i == 1 ? "0" : "1", null, null);
    }

    public void d(int i) {
        if (i == 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.p.1", null, null, "1");
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.p.2", null, null, "1");
        }
        com.baidu.navisdk.ui.routeguide.b.V().b(i);
        x.b().I().b(true);
        x.b().Y2();
    }

    public void b(int i) {
        if (i == 3) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.5", "2", null, "1");
        } else if (i == 1) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.5", "3", null, "1");
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.5", "1", null, "1");
        }
        BNSettingManager.setNaviDayAndNightMode(i);
    }

    public void b(Context context) {
        if (context != null) {
            String a2 = h.a();
            if (TextUtils.isEmpty(a2)) {
                a2 = BNSettingManager.getPlateFromLocal();
            }
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "initPlateFromLocal(), carNum=" + a2);
            }
            if (TextUtils.isEmpty(a2) || !com.baidu.navisdk.module.routepreference.d.j().h()) {
                return;
            }
            this.f8698a.d(a2);
        }
    }

    public void a() {
        VoiceInterfaceImplProxy o;
        String string;
        if (j.d() && (o = com.baidu.navisdk.framework.interfaces.c.p().o()) != null) {
            String currentVoice = o.getCurrentVoice();
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RouteGuide", "getVoiceName， ttsId=" + currentVoice);
            }
            if (currentVoice != null && !"putonghua99".equals(currentVoice) && !o.getCurGlobalId().equals(currentVoice)) {
                string = o.getDownloadedVoiceOuterBeanName(currentVoice);
                if (gVar.d()) {
                    gVar.e("RouteGuide", "getVoiceName， name=" + string);
                }
            } else {
                string = JarUtils.getResources().getString(R.string.nsdk_string_normal_new);
            }
            this.f8698a.a(string);
        }
    }

    public void a(Context context) {
        if (context != null) {
            String a2 = h.a();
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.4.3", a2, null, null);
            if (TextUtils.isEmpty(a2)) {
                a2 = BNSettingManager.getPlateFromLocal();
            }
            if (!TextUtils.isEmpty(a2)) {
                this.f8698a.d(a2);
            } else {
                com.baidu.navisdk.module.routepreference.d.j().b(false);
                this.f8698a.H();
            }
        }
    }

    public void a(Context context, int i) {
        if (com.baidu.navisdk.util.common.d.h) {
            TipTool.onCreateToastDialog(context, R.string.nsdk_bluetooth_panel_switch_when_calling);
            return;
        }
        if (i == 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.1", "1", null, "1");
            if (BNSettingManager.getBluetoothChannelMode() != i) {
                BNSettingManager.setBluetoothChannelMode(i);
                this.f8698a.i(0);
                com.baidu.navisdk.bluetooth.b.i().a(0, new a(this, context));
                return;
            }
            return;
        }
        if (i == 1) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.1", "2", null, "1");
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.3", "1", null, "1");
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a((BNBaseDialog.OnNaviClickListener) new b(this, context, i), (DialogInterface.OnDismissListener) new DialogInterfaceOnDismissListenerC0452c(), false);
        } else if (i == 2) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.1", "3", null, "1");
            if (BNSettingManager.getBluetoothChannelMode() != i) {
                BNSettingManager.setBluetoothChannelMode(i);
                this.f8698a.i(2);
                com.baidu.navisdk.bluetooth.b.i().a(2, new d(this, context));
            }
        }
    }

    public void a(int i) {
        BNCommSettingManager.getInstance().setFloatMode(i);
    }
}
