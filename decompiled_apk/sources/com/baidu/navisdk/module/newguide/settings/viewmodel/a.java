package com.baidu.navisdk.module.newguide.settings.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.baidu.navisdk.bluetooth.BNBluetoothAudio;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.pronavi.j;
import com.baidu.navisdk.module.newguide.settings.h;
import com.baidu.navisdk.module.pronavi.model.f;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.y;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class a extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    private final h f7328a;
    private final LiveData<ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a>> b;
    private SparseArray<MutableLiveData<Boolean>> c;
    private SparseArray<MutableLiveData<Integer>> d;
    private SparseArray<MutableLiveData<String>> e;
    private SparseArray<MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.c>> f;
    private MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.a> g;
    private MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.b> h;
    private final Context i = com.baidu.navisdk.framework.a.c().a();
    private com.baidu.navisdk.ui.routeguide.subview.a j;
    private String k;
    private boolean l;
    private MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.d> m;

    /* renamed from: com.baidu.navisdk.module.newguide.settings.viewmodel.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0263a implements Function<ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a>, ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a>> {
        public C0263a() {
        }

        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> apply(ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList) {
            return a.this.b(arrayList);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BNBluetoothAudio.g {
        public b() {
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i) {
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i, int i2) {
            TipTool.onCreateToastDialog(a.this.i, "设置失败");
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BNBaseDialog.OnNaviClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7331a;

        /* renamed from: com.baidu.navisdk.module.newguide.settings.viewmodel.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0264a implements BNBluetoothAudio.g {
            public C0264a() {
            }

            @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
            public void a(int i) {
            }

            @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
            public void a(int i, int i2) {
                TipTool.onCreateToastDialog(a.this.i, "蓝牙电话声道设置失败");
            }
        }

        public c(int i) {
            this.f7331a = i;
        }

        @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
        public void onClick() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.3", "2", null, "1");
            com.baidu.navisdk.bluetooth.b.i().a(1, new C0264a());
            BNSettingManager.setBluetoothChannelMode(this.f7331a);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.v();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements BNBluetoothAudio.g {
        public e() {
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i) {
        }

        @Override // com.baidu.navisdk.bluetooth.BNBluetoothAudio.g
        public void a(int i, int i2) {
            TipTool.onCreateToastDialog(a.this.i, "手机声道设置失败");
        }
    }

    public a() {
        f n;
        this.l = false;
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        if (V != null && (n = V.n()) != null) {
            this.l = n.m();
        }
        h hVar = new h();
        this.f7328a = hVar;
        this.b = Transformations.map(hVar.d(), new C0263a());
    }

    private void A() {
        int screenOrientationMode = BNCommSettingManager.getInstance().getScreenOrientationMode();
        int i = 1;
        if (screenOrientationMode != 1) {
            i = 2;
            if (screenOrientationMode != 2) {
                i = 0;
            }
        }
        j(8).setValue(Integer.valueOf(i));
    }

    private void B() {
        C();
    }

    private void C() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "onClickChangePlate: ");
        }
        if (BNRoutePlaner.getInstance().B()) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "离线导航车牌限行不可用");
            return;
        }
        if (this.l) {
            if (z.b(com.baidu.navisdk.framework.a.c().a())) {
                com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
                if (V != null && V.j() != null) {
                    H();
                    V.j().i().a();
                    return;
                }
                return;
            }
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "当前无网络，请稍后再试");
            return;
        }
        if (!TextUtils.isEmpty(com.baidu.navisdk.h.a(false))) {
            if (com.baidu.navisdk.framework.b.e0()) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.o", "3", null, "1");
                com.baidu.navisdk.h.a(this.i, true);
                return;
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.o", "2", null, "1");
                com.baidu.navisdk.h.f(this.i);
                return;
            }
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.o", "1", null, "1");
        com.baidu.navisdk.h.e(this.i);
    }

    private void D() {
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.m");
        BNSettingManager.setIsEnteredBroadcastContentSettingPage(true);
        i();
        com.baidu.navisdk.framework.b.a(14, (Object) 0);
    }

    private void E() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("RGSettingsPageViewModel", "点击通行证管理！");
        }
        if (TextUtils.isEmpty(com.baidu.navisdk.h.a(false))) {
            TipTool.onCreateToastDialog(this.i, "请添加车辆！");
        } else {
            com.baidu.navisdk.framework.b.a(1, com.baidu.navisdk.h.a(false), true);
        }
    }

    private void F() {
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.j;
        if (aVar != null) {
            aVar.a(5, 3, 0, null);
        }
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_star_voice"));
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.7");
    }

    private void G() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "onClickWeChatItem");
        }
        if (!com.baidu.navisdk.util.common.c.b()) {
            x.b().g4();
        }
    }

    private void H() {
        h(3).setValue(Boolean.TRUE);
    }

    private void c(int i, int i2) {
        if (com.baidu.navisdk.util.common.d.h) {
            TipTool.onCreateToastDialog(this.i, R.string.nsdk_bluetooth_panel_switch_when_calling);
            return;
        }
        int i3 = i2 == 1 ? 1 : i2 == 2 ? 2 : 0;
        if (i3 == BNSettingManager.getBluetoothChannelMode()) {
            return;
        }
        if (i3 == 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.1", "1", null, "1");
            if (BNSettingManager.getBluetoothChannelMode() != i3) {
                BNSettingManager.setBluetoothChannelMode(i3);
                com.baidu.navisdk.bluetooth.b.i().a(0, new b());
            }
            a(i, i2, JarUtils.getResources().getString(R.string.nsdk_bluetooth_panel_default_sub_title));
            return;
        }
        if (i3 == 1) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.1", "2", null, "1");
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.3", "1", null, "1");
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a((BNBaseDialog.OnNaviClickListener) new c(i3), (DialogInterface.OnDismissListener) new d(), false);
        } else if (i3 == 2) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.1", "3", null, "1");
            if (BNSettingManager.getBluetoothChannelMode() != i3) {
                BNSettingManager.setBluetoothChannelMode(i3);
                com.baidu.navisdk.bluetooth.b.i().a(2, new e());
            }
            a(i, i2, JarUtils.getResources().getString(R.string.nsdk_bluetooth_panel_speaker_sub_title));
        }
    }

    private void d(int i, int i2) {
        int i3;
        if (i2 == 0) {
            i3 = 1;
        } else {
            i3 = 2;
            if (i2 != 1) {
                i3 = i2 == 2 ? 3 : 0;
            }
        }
        if (BNCommSettingManager.getInstance().getNaviDayAndNightMode() == i3) {
            return;
        }
        BNCommSettingManager.getInstance().setNaviDayAndNightMode(i3);
        if (i3 == 3) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.5", "2", null, "1");
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_night_mode"));
        } else if (i3 == 1) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.5", "3", null, "1");
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_auto_day_night_mode"));
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.5", "1", null, "1");
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_day_mode"));
        }
        j(i).setValue(Integer.valueOf(i2));
    }

    private void g(int i, int i2) {
        int i3 = i2 == 0 ? 0 : i2 == 1 ? 2 : i2 == 2 ? 3 : -1;
        if (i3 == BNCommSettingManager.getInstance().getVoiceMode()) {
            return;
        }
        if (i3 == 0) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "0", null, "1");
            com.baidu.navisdk.ui.routeguide.subview.a aVar = this.j;
            if (aVar != null) {
                aVar.a(6, 0, 0, null);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_play_inset"));
        } else if (i3 == 2) {
            TTSPlayerControl.playTTS(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_common_notification_open_quiet_mode_voice), 1);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "1", null, "1");
            com.baidu.navisdk.ui.routeguide.subview.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.a(6, 0, 2, null);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_quiet_inset"));
        } else if (i3 == 3) {
            TTSPlayerControl.playTTS(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_nav_voice_mode_switch_off_play_warning_text), 1);
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.7.2", "2", null, "1");
            com.baidu.navisdk.ui.routeguide.subview.a aVar3 = this.j;
            if (aVar3 != null) {
                aVar3.a(6, 0, 3, null);
            }
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_mode_justwarning_inset"));
        }
        j(i).setValue(Integer.valueOf(i2));
    }

    private void h(int i, int i2) {
        if (i2 == 0) {
            BNSettingManager.setHdScreenMode(0);
        } else if (i2 == 1) {
            BNSettingManager.setHdScreenMode(1);
        } else if (i2 == 2) {
            BNSettingManager.setHdScreenMode(2);
        }
    }

    private boolean i(boolean z) {
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.h", "1", "3");
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.h", "0", "3");
        }
        if (!BNCommSettingManager.getInstance().setHdNaviEnable(z)) {
            return false;
        }
        if (z && com.baidu.navisdk.module.cloudconfig.f.c().I.c) {
            z = false;
        }
        BNRouteGuider.getInstance().setHdLaneMapMode(z);
        h(27).setValue(Boolean.valueOf(BNCommSettingManager.getInstance().isHdNaviEnable()));
        return true;
    }

    private void j(int i, int i2) {
        int i3 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                i3 = 1;
            } else if (i2 == 2) {
                i3 = 2;
            }
        }
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "onClickScreenOrientation: " + i3);
        }
        if (i3 == BNCommSettingManager.getInstance().getScreenOrientationMode()) {
            return;
        }
        BNCommSettingManager.getInstance().putScreenOrientationMode(i3);
        j(i).setValue(Integer.valueOf(i2));
        com.baidu.navisdk.module.newguide.controllers.c.a(i3);
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.5.j.5", String.valueOf(i2));
    }

    private boolean k(boolean z) {
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1340", "0", "0", "3");
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1341", "0", "0", "3");
        }
        if (!BNCommSettingManager.getInstance().setNormalHdNaviEnable(z)) {
            return false;
        }
        if (z && com.baidu.navisdk.module.cloudconfig.f.c().U.b) {
            z = false;
        }
        BNRouteGuider.getInstance().setCommonRoadHDLaneMapMode(z);
        return true;
    }

    private boolean m(boolean z) {
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("35.0.1.1424", "1", null, null);
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("35.0.1.1424", "2", null, null);
        }
        h(29).setValue(Boolean.valueOf(z));
        if (!z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.2", null, "", "1");
            com.baidu.navisdk.ui.routeguide.subview.a aVar = this.j;
            if (aVar != null) {
                aVar.c(false);
            }
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.2", "", null, "1");
            if (z.b(com.baidu.navisdk.framework.a.c().a())) {
                com.baidu.navisdk.ui.routeguide.subview.a aVar2 = this.j;
                if (aVar2 != null) {
                    aVar2.c(true);
                }
            } else {
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_its_real_offline));
            }
        }
        return z;
    }

    private boolean n(boolean z) {
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.H) {
            TipTool.onCreateToastDialog(this.i, "服务暂不可用，敬请期待");
            return false;
        }
        if (z) {
            BNSettingManager.setScenicBroadcastOpen(true);
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
            y.d();
        } else {
            BNSettingManager.setScenicBroadcastOpen(false);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J4();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(false);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v3();
        }
        return true;
    }

    @Nullable
    private ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> r() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "getFilterShortcutList: " + this.l);
        }
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList = new ArrayList<>(2);
        if (!com.baidu.navisdk.function.b.FUNC_AR.a() || !com.baidu.navisdk.module.abtest.model.a.y()) {
            arrayList.add(new com.baidu.navisdk.module.newguide.settings.shortcut.beans.a(9));
        }
        if (this.l) {
            arrayList.add(new com.baidu.navisdk.module.newguide.settings.shortcut.beans.a(8));
        }
        return arrayList;
    }

    private MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.a> s() {
        if (this.g == null) {
            this.g = new MutableLiveData<>();
        }
        return this.g;
    }

    private MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.b> t() {
        if (this.h == null) {
            this.h = new MutableLiveData<>();
        }
        return this.h;
    }

    private void u() {
        if (this.m == null) {
            this.m = new MutableLiveData<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        int i;
        String str;
        int bluetoothChannelMode = BNSettingManager.getBluetoothChannelMode();
        if (bluetoothChannelMode == 0) {
            str = JarUtils.getResources().getString(R.string.nsdk_bluetooth_panel_default_sub_title);
            i = 0;
        } else {
            i = 1;
            if (bluetoothChannelMode == 1) {
                str = JarUtils.getResources().getString(R.string.nsdk_bluetooth_panel_phone_sub_title);
            } else {
                i = 2;
                if (bluetoothChannelMode == 2) {
                    str = JarUtils.getResources().getString(R.string.nsdk_bluetooth_panel_speaker_sub_title);
                } else {
                    str = "";
                    i = -1;
                }
            }
        }
        if (i != -1) {
            a(12, i, str);
        }
    }

    private void w() {
        int naviDayAndNightMode = BNSettingManager.getNaviDayAndNightMode();
        int i = 1;
        if (naviDayAndNightMode == 1) {
            i = 0;
        } else if (naviDayAndNightMode != 2) {
            i = 2;
        }
        j(7).setValue(Integer.valueOf(i));
    }

    private void x() {
        int i = 1;
        if (BNSettingManager.getMapMode() == 1) {
            i = 0;
        }
        j(6).setValue(Integer.valueOf(i));
    }

    private void y() {
        int hdScreenMode = BNSettingManager.getHdScreenMode();
        int i = 0;
        if (hdScreenMode != 0) {
            if (hdScreenMode == 1) {
                i = 1;
            } else if (hdScreenMode == 2) {
                i = 2;
            }
        }
        j(30).setValue(Integer.valueOf(i));
    }

    private void z() {
        int i;
        String str;
        int playTTsVoiceMode = BNSettingManager.getPlayTTsVoiceMode();
        if (playTTsVoiceMode == 0) {
            str = JarUtils.getResources().getString(R.string.setting_val_lower);
            i = 0;
        } else {
            i = 1;
            if (playTTsVoiceMode == 1) {
                str = JarUtils.getResources().getString(R.string.setting_val_stop);
            } else {
                str = "";
                i = -1;
            }
        }
        if (i != -1) {
            a(13, i, str);
        }
    }

    public void e(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "onClickItem: " + i);
        }
        if (i == 4) {
            C();
            b(32, com.baidu.navisdk.module.routepreference.d.j().h());
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_modify_carplate"));
        } else {
            if (i == 11) {
                D();
                return;
            }
            if (i == 18) {
                E();
                return;
            }
            if (i == 23) {
                G();
            } else {
                if (i != 25) {
                    return;
                }
                H();
                F();
            }
        }
    }

    public void f(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "onClickShortcutFun: " + com.baidu.navisdk.module.newguide.settings.shortcut.b.a(i));
        }
        if (com.baidu.navisdk.ui.util.g.a()) {
            if (gVar.d()) {
                gVar.e("RGSettingsPageViewModel", "onClickShortcutFun: isFastDoubleClick");
                return;
            }
            return;
        }
        H();
        if (i != 100) {
            switch (i) {
                case 1:
                    com.baidu.navisdk.ui.routeguide.subview.a aVar = this.j;
                    if (aVar != null) {
                        aVar.b();
                    }
                    com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.2");
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_route_search_shortcut_btn"));
                    break;
                case 2:
                    BNCommSettingManager.getInstance().setLocationShareBtnNeedNewTag(false);
                    com.baidu.navisdk.util.statistic.userop.b.r().a("y.0", "3", null, null);
                    com.baidu.navisdk.framework.interfaces.locationshare.a j = com.baidu.navisdk.framework.interfaces.c.p().j();
                    if (j != null && j.l()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("pageSrc", NotificationCompat.CATEGORY_NAVIGATION);
                        bundle.putInt("vehicleType", 1);
                        com.baidu.navisdk.framework.b.c(bundle);
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_location_share"));
                        break;
                    } else {
                        TipTool.onCreateToastDialog(this.i, "服务暂不可用，敬请期待");
                        break;
                    }
                    break;
                case 3:
                    com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.3");
                    if (!com.baidu.navisdk.module.international.a.a(this.i)) {
                        com.baidu.navisdk.module.a.h().a(com.baidu.navisdk.ui.routeguide.b.V().b(), 0, true);
                        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_route_share"));
                        break;
                    } else {
                        return;
                    }
                case 4:
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.u", "2", null, null);
                    com.baidu.navisdk.ui.routeguide.subview.a aVar2 = this.j;
                    if (aVar2 != null) {
                        aVar2.c(2);
                    }
                    if (RGFSMTable.FsmState.BrowseMap.equals(RouteGuideFSM.getInstance().getTopState())) {
                        x.b().a(0L);
                    }
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_reprot_ugc"));
                    break;
                case 5:
                    com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
                    if (V != null) {
                        V.j().f().a(this.j);
                        V.c(false);
                    }
                    com.baidu.navisdk.framework.b.b((Bundle) null);
                    break;
                case 6:
                    F();
                    break;
                case 7:
                    com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.b");
                    BNSettingManager.setFirstCarLogoGuide(true);
                    com.baidu.navisdk.ui.routeguide.subview.a aVar3 = this.j;
                    if (aVar3 != null) {
                        aVar3.i();
                    }
                    com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_carlogo"));
                    com.baidu.navisdk.util.statistic.userop.b.r().a("b.f.1", "3", null, null);
                    break;
                case 8:
                    B();
                    break;
                case 9:
                    com.baidu.navisdk.ui.routeguide.subview.a aVar4 = this.j;
                    if (aVar4 != null) {
                        aVar4.f();
                    }
                    com.baidu.navisdk.util.statistic.userop.b.r().d("3.1.5", "1");
                    break;
            }
        } else {
            j(20).setValue(Integer.valueOf(i));
            com.baidu.navisdk.ui.routeguide.b V2 = com.baidu.navisdk.ui.routeguide.b.V();
            if (V2 != null) {
                V2.c(false);
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("is_new_energy_car", this.l);
            com.baidu.navisdk.framework.b.d(bundle2);
        }
        g(i);
    }

    public void l() {
        h hVar = this.f7328a;
        if (hVar != null) {
            hVar.f();
        }
    }

    public void o() {
        String str;
        MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.a> s = s();
        com.baidu.navisdk.module.newguide.settings.model.a value = s.getValue();
        if (value == null) {
            value = new com.baidu.navisdk.module.newguide.settings.model.a();
        }
        value.f = true;
        value.g = true;
        value.h = !this.l;
        String a2 = com.baidu.navisdk.h.a(false);
        if (!this.l) {
            str = "";
        } else {
            str = com.baidu.navisdk.module.routeresult.logic.plate.a.b().b(1).getPlate(1);
        }
        if (!TextUtils.isEmpty(a2) && (!this.l || !TextUtils.isEmpty(str))) {
            boolean h = com.baidu.navisdk.module.routepreference.d.j().h();
            value.f7274a = h;
            if (this.l) {
                a2 = str;
            }
            value.b = a2;
            value.d = "修改车牌";
            if (h) {
                value.c = "常用车辆，已开启限行避让";
            } else {
                value.c = "常用车辆，未开启限行避让";
            }
            if (com.baidu.navisdk.framework.b.S()) {
                value.e = "(新能源车牌)";
            } else {
                value.e = "";
            }
            if (this.l) {
                value.f = true;
                value.g = true;
            }
        } else {
            if (!this.l) {
                com.baidu.navisdk.module.routepreference.d.j().b(false);
            }
            value.f7274a = false;
            value.b = "车牌信息";
            value.c = "请填写车牌信息，可避让限行路线";
            value.d = "添加车牌";
            value.e = "";
            if (this.l) {
                value.f = false;
                value.g = false;
            }
        }
        s.setValue(value);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        h hVar = this.f7328a;
        if (hVar != null) {
            hVar.a();
        }
    }

    public void p() {
        MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.b> t = t();
        com.baidu.navisdk.module.newguide.settings.model.b value = t.getValue();
        if (value == null) {
            value = new com.baidu.navisdk.module.newguide.settings.model.b();
        }
        value.f7275a = com.baidu.navisdk.module.routepreference.d.j().f();
        value.b = BNSettingManager.getLastRouteSearchMCarPrefer();
        t.setValue(value);
    }

    public void q() {
        int voiceMode = BNSettingManager.getVoiceMode();
        int i = 2;
        if (voiceMode == 2) {
            i = 1;
        } else if (voiceMode != 3) {
            i = 0;
        }
        j(10).setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> b(ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList) {
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList2 = new ArrayList<>(8);
        ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> r = r();
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
            a(arrayList2, r);
        }
        if (arrayList2.size() < 11) {
            ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> c2 = new com.baidu.navisdk.module.newguide.settings.shortcut.repository.a().c();
            Iterator<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> it = arrayList2.iterator();
            while (it.hasNext()) {
                com.baidu.navisdk.module.newguide.settings.shortcut.beans.a next = it.next();
                if (next != null) {
                    c2.remove(next);
                }
            }
            a(c2, r);
            int size = 11 - arrayList2.size();
            for (int i = 0; i < size && i < c2.size(); i++) {
                arrayList2.add(c2.get(i));
            }
        }
        if (com.baidu.navisdk.function.b.FUNC_NAVI_MORESTE.a()) {
            com.baidu.navisdk.module.newguide.settings.shortcut.beans.a a2 = com.baidu.navisdk.module.newguide.settings.shortcut.a.a(100);
            a2.c = com.baidu.navisdk.module.newguide.settings.shortcut.a.c(a2.f7279a);
            arrayList2.add(a2);
        }
        return arrayList2;
    }

    private boolean l(boolean z) {
        com.baidu.navisdk.behavrules.event.b bVar;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "onClickPlateLimit: " + z);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.j.4");
        boolean z2 = false;
        if (!com.baidu.navisdk.util.common.y.d(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "网络连接不可用");
            return false;
        }
        if (BNRoutePlaner.getInstance().B()) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "离线导航车牌限行不可用");
            return false;
        }
        String a2 = com.baidu.navisdk.h.a(false);
        if (TextUtils.isEmpty(a2) && z) {
            com.baidu.navisdk.h.e(com.baidu.navisdk.framework.a.c().a());
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.1", "1", null, "1");
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.1", "0", null, "1");
        }
        com.baidu.navisdk.module.routepreference.d.j().b(z);
        com.baidu.navisdk.behavrules.util.a a3 = com.baidu.navisdk.behavrules.util.a.a();
        if (z) {
            bVar = new com.baidu.navisdk.behavrules.event.b("asr_e_c_open_car_limit_inset");
        } else {
            bVar = new com.baidu.navisdk.behavrules.event.b("asr_e_c_close_car_limit_inset");
        }
        a3.a(bVar);
        o();
        if (this.j != null && !TextUtils.isEmpty(a2)) {
            z2 = this.j.o();
        }
        if (!z2) {
            return true;
        }
        H();
        return true;
    }

    public void a(com.baidu.navisdk.ui.routeguide.subview.a aVar) {
        this.j = aVar;
    }

    private void a(ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList, ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> arrayList2) {
        if (arrayList == null || arrayList.isEmpty() || arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        Iterator<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a> it = arrayList2.iterator();
        while (it.hasNext()) {
            com.baidu.navisdk.module.newguide.settings.shortcut.beans.a next = it.next();
            if (next != null) {
                arrayList.remove(next);
            }
        }
    }

    private boolean h(boolean z) {
        if (z && !com.baidu.navisdk.module.cloudconfig.f.c().c.A) {
            TipTool.onCreateToastDialog(this.i, "当前地区暂不支持停车场推荐服务");
            return false;
        }
        BNSettingManager.setPrefParkSearch(z);
        BNSettingManager.setDestParkClicked();
        if (!z) {
            return true;
        }
        TipTool.onCreateToastDialog(this.i, "已开启停车场推荐服务");
        return true;
    }

    public void k() {
        String str;
        int floatMode = BNCommSettingManager.getInstance().getFloatMode();
        if (floatMode == 0) {
            str = JarUtils.getResources().getString(R.string.nsdk_float_setting_tips_pip);
        } else if (floatMode == 1) {
            str = JarUtils.getResources().getString(R.string.nsdk_float_setting_tips_float);
        } else {
            str = "";
        }
        a(24, floatMode, str);
        h(22).setValue(Boolean.valueOf(BNCommSettingManager.getInstance().getPrefFloatSwitch()));
    }

    private void i(int i, int i2) {
        String str;
        int i3 = (i2 != 0 && i2 == 1) ? 1 : 0;
        if (i3 == BNSettingManager.getPlayTTsVoiceMode()) {
            return;
        }
        if (i3 == 0) {
            BNSettingManager.setPlayTTsVoiceMode(0);
            str = JarUtils.getResources().getString(R.string.setting_val_lower);
        } else if (i3 == 1) {
            BNSettingManager.setPlayTTsVoiceMode(1);
            str = JarUtils.getResources().getString(R.string.setting_val_stop);
        } else {
            str = "";
        }
        a(i, i2, str);
    }

    private boolean j(boolean z) {
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.q", "1", null, "1");
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.q", "2", null, "1");
        }
        BNMapController.getInstance().getMapController().m(z);
        BNSettingManager.setAutoLevelMode(z);
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b(z ? "asr_e_c_open_autolevel" : "asr_e_c_close_autolevel"));
        return true;
    }

    public boolean a(int i, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "onClickSwitchItem: " + z + ",itemType: " + i);
        }
        if (i == 5) {
            return l(z);
        }
        if (i == 9) {
            return j(z);
        }
        if (i == 22) {
            return c(z);
        }
        if (i != 31) {
            switch (i) {
                case 14:
                    return g(z);
                case 15:
                    return h(z);
                case 16:
                    return n(z);
                case 17:
                    return e(z);
                default:
                    switch (i) {
                        case 27:
                            return i(z);
                        case 28:
                            return k(z);
                        case 29:
                            return m(z);
                        default:
                            return false;
                    }
            }
        }
        return d(z);
    }

    private MutableLiveData<Boolean> h(int i) {
        if (this.c == null) {
            this.c = new SparseArray<>(12);
        }
        MutableLiveData<Boolean> mutableLiveData = this.c.get(i);
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this.c.put(i, mutableLiveData2);
        return mutableLiveData2;
    }

    public boolean d(boolean z) {
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.b", "1", null, null);
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.b", "0", null, null);
        }
        BNSettingManager.setSaveParkingSwitch(z);
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b(z ? "asr_e_c_open_save_parking" : "asr_e_c_close_save_parking"));
        h(31).setValue(Boolean.valueOf(z));
        return true;
    }

    public void n() {
        j k;
        if (com.baidu.navisdk.ui.routeguide.b.V() == null || (k = com.baidu.navisdk.ui.routeguide.b.V().k()) == null) {
            return;
        }
        k.c();
    }

    private void e(int i, int i2) {
        int i3 = 0;
        if (i2 != 0 && i2 == 1) {
            i3 = 1;
        }
        BNCommSettingManager.getInstance().setFloatMode(i3);
        k();
    }

    private MutableLiveData<String> k(int i) {
        if (this.e == null) {
            this.e = new SparseArray<>(8);
        }
        MutableLiveData<String> mutableLiveData = this.e.get(i);
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this.e.put(i, mutableLiveData2);
        return mutableLiveData2;
    }

    public boolean e(boolean z) {
        if (z && !l.c(this.i)) {
            x.b().t4();
            return false;
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.b", "1", null, null);
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.b", "0", null, null);
        }
        BNSettingManager.setPowerSaveMode(z ? 0 : 2);
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b(z ? "asr_e_c_open_powersaver" : "asr_e_c_close_powersaver"));
        h(17).setValue(Boolean.valueOf(z));
        return true;
    }

    public void h() {
        if (this.j == null) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGSettingsPageViewModel", "handlerFromCarOwnerBack: mSubViewListener == null");
                return;
            }
            return;
        }
        if (TextUtils.equals(com.baidu.navisdk.h.a(false), this.k)) {
            return;
        }
        H();
        this.j.e();
    }

    public void i() {
        String str;
        String b2 = com.baidu.navisdk.ui.routeguide.module.diyspeak.j.b();
        if (TextUtils.isEmpty(b2)) {
            str = "";
        } else {
            str = "<font color='#999999'>正在使用</font><font color='#3385ff'>" + b2 + "模式</font>";
        }
        k(11).setValue(str);
    }

    public void m() {
        if (!com.baidu.navisdk.util.common.c.b() || BNSettingManager.isPlayVoiceWhenCalling()) {
            com.baidu.navisdk.framework.b.d(false);
            if (TTSPlayerControl.getTTSState() == 3) {
                TTSPlayerControl.resumeVoiceTTSOutput();
            }
        }
        h(23).setValue(Boolean.valueOf(com.baidu.navisdk.util.common.c.b()));
    }

    private MutableLiveData<Integer> j(int i) {
        if (this.d == null) {
            this.d = new SparseArray<>(12);
        }
        MutableLiveData<Integer> mutableLiveData = this.d.get(i);
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this.d.put(i, mutableLiveData2);
        return mutableLiveData2;
    }

    public LiveData<String> d(int i) {
        return k(i);
    }

    private MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.c> i(int i) {
        if (this.f == null) {
            this.f = new SparseArray<>(2);
        }
        MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.c> mutableLiveData = this.f.get(i);
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.c> mutableLiveData2 = new MutableLiveData<>();
        this.f.put(i, mutableLiveData2);
        return mutableLiveData2;
    }

    public LiveData<com.baidu.navisdk.module.newguide.settings.model.b> d() {
        return t();
    }

    public void b(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "loadAllData: " + z);
        }
        h hVar = this.f7328a;
        if (hVar != null && !z) {
            hVar.e();
        }
        o();
        h(9).setValue(Boolean.valueOf(BNSettingManager.isAutoLevelMode()));
        h(15).setValue(Boolean.valueOf(BNSettingManager.getPrefParkSearch()));
        h(17).setValue(Boolean.valueOf(BNSettingManager.getPowerSaveMode() != 2 && l.c(com.baidu.navisdk.ui.routeguide.b.V().b())));
        h(14).setValue(Boolean.valueOf(BNSettingManager.isPlayVoiceWhenCalling()));
        h(16).setValue(Boolean.valueOf(BNSettingManager.isScenicBroadcastOpen()));
        h(27).setValue(Boolean.valueOf(BNCommSettingManager.getInstance().isHdNaviEnable()));
        h(28).setValue(Boolean.valueOf(BNCommSettingManager.getInstance().isNormalHdNaviEnable()));
        h(29).setValue(Boolean.valueOf(BNCommSettingManager.getInstance().isRoadCondOnOrOff()));
        p();
        h(22).setValue(Boolean.valueOf(BNCommSettingManager.getInstance().getPrefFloatSwitch()));
        v();
        w();
        A();
        x();
        q();
        z();
        i();
        k();
        j();
        y();
    }

    public boolean c(boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "onClickBgFloat: " + z);
        }
        if (z && !a(com.baidu.navisdk.framework.a.c().b())) {
            return false;
        }
        BNCommSettingManager.getInstance().setPrefFloatSwitch(z);
        h(22).setValue(Boolean.valueOf(z));
        if (BNCommSettingManager.getInstance().getFloatMode() == 0) {
            if (z) {
                com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.8.5", "1");
                return true;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().d("3.x.8.5", "2");
            return true;
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.x.1", "", null, null);
            return true;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.x.1", null, "", null);
        return true;
    }

    public void j() {
        VoiceInterfaceImplProxy o = com.baidu.navisdk.framework.interfaces.c.p().o();
        if (o == null) {
            return;
        }
        String currentVoice = o.getCurrentVoice();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "loadCurrentUseSuperVoiceInfo: " + currentVoice);
        }
        u();
        if (TextUtils.isEmpty(o.getDownloadedVoiceOuterBeanName(currentVoice))) {
            return;
        }
        com.baidu.navisdk.module.newguide.settings.model.d value = this.m.getValue();
        if (value == null) {
            value = new com.baidu.navisdk.module.newguide.settings.model.d();
        }
        if (TextUtils.equals(currentVoice, "putonghua99")) {
            value.c = R.drawable.nsdk_normal_head_view;
            value.b = null;
        } else {
            value.c = 0;
            value.b = o.getDownloadedVoiceOuterBeanImageUrl(currentVoice);
        }
        if (!TextUtils.isEmpty(o.getDownloadedVoiceOuterBeanName(currentVoice))) {
            value.f7277a = o.getDownloadedVoiceOuterBeanName(currentVoice);
        } else {
            value.f7277a = "";
        }
        this.m.setValue(value);
    }

    private boolean g(boolean z) {
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.2", "1", null, "1");
            BNSettingManager.setPlayVoiceWhenCalling(true);
            if (TTSPlayerControl.getTTSState() == 3) {
                TTSPlayerControl.resumeVoiceTTSOutput();
            }
        } else {
            com.baidu.navisdk.util.statistic.userop.b.r().a("b.a.2", "2", null, "1");
            BNSettingManager.setPlayVoiceWhenCalling(false);
            if (com.baidu.navisdk.util.common.c.b() && com.baidu.navisdk.module.newguide.a.e().d()) {
                com.baidu.navisdk.framework.b.d(true);
            }
        }
        return true;
    }

    public void a(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "onClickRadioItem: " + i + ", position:" + i2);
        }
        if (i == 6) {
            f(i, i2);
            return;
        }
        if (i == 7) {
            d(i, i2);
            return;
        }
        if (i == 8) {
            j(i, i2);
            return;
        }
        if (i == 10) {
            g(i, i2);
            return;
        }
        if (i == 24) {
            e(i, i2);
            return;
        }
        if (i == 30) {
            h(i, i2);
        } else if (i == 12) {
            c(i, i2);
        } else {
            if (i != 13) {
                return;
            }
            i(i, i2);
        }
    }

    public LiveData<ArrayList<com.baidu.navisdk.module.routepreference.j>> e() {
        return this.f7328a.c();
    }

    private void g(int i) {
        String str = i + "";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().d("3.7.1", str);
    }

    public LiveData<Integer> c(int i) {
        return j(i);
    }

    private void a(int i, int i2, String str) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "setIntParamValue: " + i + ", position:" + i2 + ", content:" + str);
        }
        MutableLiveData<com.baidu.navisdk.module.newguide.settings.model.c> i3 = i(i);
        com.baidu.navisdk.module.newguide.settings.model.c value = i3.getValue();
        if (value == null) {
            value = new com.baidu.navisdk.module.newguide.settings.model.c();
        }
        value.f7276a = i2;
        value.b = str;
        i3.setValue(value);
    }

    public LiveData<com.baidu.navisdk.module.newguide.settings.model.a> c() {
        return s();
    }

    public LiveData<com.baidu.navisdk.module.newguide.settings.model.d> g() {
        u();
        return this.m;
    }

    public static boolean a(Activity activity) {
        if (BNCommSettingManager.getInstance().getFloatMode() == 0) {
            if (BNSettingManager.hasPipPermission()) {
                return true;
            }
            try {
                Intent intent = new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS");
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                activity.startActivityForResult(intent, 3006);
                return false;
            } catch (Exception unused) {
                return true;
            }
        }
        if (com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            return true;
        }
        x.b().h4();
        return false;
    }

    public void a(ArrayList<com.baidu.navisdk.module.newguide.settings.model.e> arrayList) {
        h hVar;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "saveGroupSort: " + arrayList);
        }
        if (arrayList == null || arrayList.isEmpty() || (hVar = this.f7328a) == null) {
            return;
        }
        hVar.a(arrayList);
    }

    public void b(int i, int i2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGSettingsPageViewModel", "onClickRoutePrefer: " + i + ",currentPreferValue: " + i2);
        }
        if (com.baidu.navisdk.ui.util.g.a()) {
            return;
        }
        if (!com.baidu.navisdk.util.common.y.d(com.baidu.navisdk.framework.a.c().a())) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "网络连接不可用");
            return;
        }
        if (BNRoutePlaner.getInstance().B()) {
            TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "离线导航路线偏好不可用");
            return;
        }
        int i3 = (i2 & 32) != 0 ? i | 32 : i;
        if (i3 != i2) {
            H();
            com.baidu.navisdk.module.routepreference.d.j().f(i3);
            com.baidu.navisdk.ui.routeguide.asr.c.n().b(false);
            a0.G = 2;
            com.baidu.navisdk.ui.routeguide.control.l.l().i();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.a", Integer.toString(i3), "1", null);
            com.baidu.navisdk.util.statistic.userop.b.r().a("2.i.1", i + "", "3", null);
            p();
        }
    }

    public void a(boolean z) {
        h(2).setValue(Boolean.valueOf(z));
    }

    public LiveData<Boolean> a(int i) {
        return h(i);
    }

    public void a() {
        this.k = com.baidu.navisdk.h.a(false);
    }

    private void f(int i, int i2) {
        if (i2 == 0) {
            if (BNSettingManager.getMapMode() == 1) {
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.1", "", null, "2");
            RouteGuideFSM.getInstance().setFullViewByUser(false);
            RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.Car3D);
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
            BNSettingManager.setMapMode(1);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_3d_inset"));
            j(i).setValue(Integer.valueOf(i2));
            return;
        }
        if (i2 == 1) {
            if (BNSettingManager.getMapMode() == 2) {
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.1", null, "", "2");
            RouteGuideFSM.getInstance().setFullViewByUser(false);
            RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.North2D);
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
            BNSettingManager.setMapMode(2);
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_2d_inset"));
            j(i).setValue(Integer.valueOf(i2));
            return;
        }
        if (i2 == 2) {
            x();
            if (x.b().n2()) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("RGSettingsPageViewModel", "onChangeAngleHUDModeSetting isInterceptToHUDModeOnVdr ");
                }
            } else {
                if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f2()) {
                    TipTool.onCreateToastDialog(this.i, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_hud_not_allowed_fuzzy));
                    return;
                }
                if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().N2()) {
                    TipTool.onCreateToastDialog(this.i, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_hud_not_allowed_fuzzy));
                    return;
                }
                H();
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.5.4");
                RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_HUD_ENTER);
                com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_hud_inset"));
            }
        }
    }

    private void b(int i, boolean z) {
        com.baidu.navisdk.module.routepreference.d.j().a(i, z);
    }

    public LiveData<com.baidu.navisdk.module.newguide.settings.model.c> b(int i) {
        return i(i);
    }

    public LiveData<ArrayList<com.baidu.navisdk.module.newguide.settings.model.e>> b() {
        return this.f7328a.b();
    }

    public LiveData<ArrayList<com.baidu.navisdk.module.newguide.settings.shortcut.beans.a>> f() {
        return this.b;
    }

    public void f(boolean z) {
        h(26).setValue(Boolean.valueOf(z));
    }
}
