package com.baidu.navisdk.pronavi.hd.normal.logic;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class b implements com.baidu.navisdk.pronavi.hd.normal.i.a, com.baidu.navisdk.module.pronavi.abs.b {
    private com.baidu.navisdk.pronavi.hd.normal.map.a b;

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.pronavi.hd.normal.data.b f7759a = new com.baidu.navisdk.pronavi.hd.normal.data.b(1);
    private final com.baidu.navisdk.framework.lifecycle.b<com.baidu.navisdk.pronavi.hd.normal.data.c> c = new com.baidu.navisdk.framework.lifecycle.b<>();
    private final com.baidu.navisdk.framework.lifecycle.b<Boolean> d = new com.baidu.navisdk.framework.lifecycle.b<>();
    private final com.baidu.navisdk.pronavi.hd.normal.data.a e = new com.baidu.navisdk.pronavi.hd.normal.data.a(R.drawable.nsdk_rg_normal_hd_map_shadow);
    private boolean f = true;
    private final X0IIOO g = XIxXXX0x0.I0Io(LazyThreadSafetyMode.NONE, new c());
    private int h = -1;
    private int i = 8;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements oIX0oI<com.baidu.navisdk.pronavi.hd.normal.logic.a> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final com.baidu.navisdk.pronavi.hd.normal.logic.a invoke() {
            com.baidu.navisdk.pronavi.hd.normal.logic.a aVar = new com.baidu.navisdk.pronavi.hd.normal.logic.a();
            aVar.b = b.this.f(1).getSecond().intValue();
            aVar.c = b.this.f(2).getFirst().intValue();
            aVar.d = b.this.e.g();
            aVar.e = b.this.e.c();
            return aVar;
        }
    }

    static {
        new a(null);
    }

    private final void h(int i) {
        this.d.setValue(Boolean.valueOf(i == 0 && c() && this.f7759a.d() == 0));
    }

    private final int j(int i) {
        return i == 1 ? 2 : 0;
    }

    private final int k(int i) {
        return i == 2 ? 1 : 0;
    }

    private final String l() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "handleAsrOpen: " + this.f7759a);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1340", "1", "1", "0");
        BNCommSettingManager bNCommSettingManager = BNCommSettingManager.getInstance();
        IIX0o.oO(bNCommSettingManager, "BNCommSettingManager.getInstance()");
        if (!bNCommSettingManager.isNormalHdNaviEnable()) {
            BNCommSettingManager bNCommSettingManager2 = BNCommSettingManager.getInstance();
            IIX0o.oO(bNCommSettingManager2, "BNCommSettingManager.getInstance()");
            bNCommSettingManager2.setNormalHdNaviEnable(true);
            BNRouteGuider.getInstance().setCommonRoadHDLaneMapMode(true);
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1340", "0", "1", "1");
            return "好的，已为您开启车道级导航开关";
        }
        if (!c()) {
            return "抱歉，当前路段暂不支持车道指引模式";
        }
        if (this.f7759a.d() == 0) {
            a(2);
            com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1340", "1", "1", "1");
            return "好的，已为您开启智能车道指引模式";
        }
        return "当前功能已开启";
    }

    private final void m() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "loadDiyResourceIfNeed: " + this.f);
        }
        if (!this.f) {
            return;
        }
        String str = f.c().U.d;
        IIX0o.oO(str, "CloudlConfigDataModel.ge…HdNaviConfig.hdCarLogoUrl");
        a(15, str);
    }

    private final void n() {
        if (this.h == 1) {
            this.f7759a.a(-1);
            Message message = new Message();
            message.arg1 = this.h;
            message.arg2 = -100;
            a(message);
            this.h = -1;
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public boolean c() {
        return this.f7759a.b() == 2;
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    @OOXIXo
    public Pair<Integer, Integer> d(int i) {
        if (i == 2) {
            return new Pair<>(Integer.valueOf(this.e.f()), Integer.valueOf(this.e.e()));
        }
        return new Pair<>(Integer.valueOf(this.e.l()), Integer.valueOf(this.e.k()));
    }

    @Override // com.baidu.navisdk.pronavi.logic.i.a
    public void e(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "onOrientationChange: " + i);
        }
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar = this.b;
        if (aVar != null) {
            this.f7759a.d(i);
            Pair<Integer, Integer> g = g(i);
            aVar.a(i, g.getFirst().intValue(), g.getSecond().intValue());
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    @OOXIXo
    public Pair<Integer, Integer> f(int i) {
        if (i == 2) {
            return this.e.d();
        }
        return this.e.j();
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    @OOXIXo
    public Pair<Integer, Integer> g(int i) {
        if (i == 2) {
            return new Pair<>(Integer.valueOf(this.e.c()), Integer.valueOf(this.e.b()));
        }
        return new Pair<>(Integer.valueOf(this.e.i()), Integer.valueOf(this.e.g()));
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void i() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "onDrivingRouteChange: ");
        }
        if (this.f7759a.c() != 0 || this.b != null) {
            a(0, true, true);
        }
        this.f7759a.a(0);
        this.f7759a.b(0);
        this.h = -1;
        h(0);
    }

    @Override // com.baidu.navisdk.pronavi.logic.i.a
    public void onDestroy() {
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar = this.b;
        if (aVar != null) {
            aVar.onDestroy();
        }
        this.b = null;
        this.f = true;
    }

    @Override // com.baidu.navisdk.pronavi.logic.i.a
    public void onPause() {
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar = this.b;
        if (aVar != null) {
            aVar.onPause();
        }
    }

    @Override // com.baidu.navisdk.pronavi.logic.i.a
    public void onResume() {
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar = this.b;
        if (aVar != null) {
            aVar.onResume();
        }
    }

    @Override // com.baidu.navisdk.pronavi.logic.i.a
    public void onStartYawing() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "onStartYawing ");
        }
        i();
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "release: ");
        }
        this.h = -1;
        this.f7759a.a();
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void setShowRect(int i, boolean z) {
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar = this.b;
        if (aVar != null) {
            aVar.setShowRect(i, z);
        }
    }

    /* renamed from: com.baidu.navisdk.pronavi.hd.normal.logic.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0322b implements com.baidu.navisdk.module.carlogo.listeners.c {
        final /* synthetic */ int b;

        public C0322b(int i) {
            this.b = i;
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(@OOXIXo String url) {
            IIX0o.x0xO0oo(url, "url");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGHDResource", "loadAndSetDiyResource downloadHDLogo.onFailed: " + url);
            }
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(@OOXIXo String url, @OOXIXo String filePath) {
            IIX0o.x0xO0oo(url, "url");
            IIX0o.x0xO0oo(filePath, "filePath");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGNormalHdFunc", "loadAndSetDiyResource downloadHDLogo(), filePath = " + filePath + ",url = " + url);
            }
            com.baidu.navisdk.pronavi.hd.normal.map.a aVar = b.this.b;
            if (aVar != null) {
                aVar.a(this.b, filePath, (String) null);
            }
            b.this.f = false;
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.c
        public void a(int i, @OOXIXo String url) {
            IIX0o.x0xO0oo(url, "url");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("RGNormalHdFunc", "loadAndSetDiyResource downloadHDLogo(), url =" + url + ", progress = " + i);
            }
        }
    }

    private final com.baidu.navisdk.framework.interfaces.pronavi.hd.f j() {
        return (com.baidu.navisdk.framework.interfaces.pronavi.hd.f) this.g.getValue();
    }

    private final String k() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "handleAsrClose: " + this.f7759a);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1341", "1", "1", "0");
        if (this.f7759a.b() != 2) {
            return "当前功能已关闭";
        }
        if (this.f7759a.d() == 0 && this.f7759a.c() == 0) {
            return "当前功能已关闭";
        }
        a(0);
        com.baidu.navisdk.util.statistic.userop.b.r().a("11.0.1.1341", "1", "1", "1");
        return "好的，已为您关闭智能车道指引模式";
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    @OOXIXo
    public LiveData<Boolean> b() {
        return this.d;
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void c(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "updateNormalHDUiState: " + i);
        }
        j().f6817a = i;
        if (this.f7759a.c() != i) {
            this.f7759a.b(i);
            h(i);
            BNRouteGuider.getInstance().setCommonRoadHDLaneBoardEnabled(i == 2);
            if (i == 2) {
                ProNaviStatItem.O().l(a0.I().l());
            } else {
                ProNaviStatItem.O().k(a0.I().l());
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void a(@OOXIXo Message msg) {
        IIX0o.x0xO0oo(msg, "msg");
        int j = j(msg.arg1);
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "handleEngineMessage: arg1: " + msg.arg1 + ", arg2:" + msg.arg2 + ", toState: " + j + ", oldState:" + this.f7759a.b());
        }
        if (j == this.f7759a.b()) {
            return;
        }
        this.f7759a.a(j);
        if (i(j)) {
            if (gVar.d()) {
                gVar.e("RGNormalHdFunc", "handleEngineMessage isTempShieldNormalHDNavi");
            }
            this.h = msg.arg1;
            return;
        }
        this.h = -1;
        h(this.f7759a.c());
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "handleEngineMessage: " + this.f7759a);
        }
        if (this.f7759a.d() == 0) {
            return;
        }
        if (j == 2) {
            com.baidu.navisdk.util.statistic.userop.b.r().d("11.0.8.1369", "0");
        }
        if (j != this.f7759a.c()) {
            a(j, true, true);
        } else {
            if (j != 0 || this.b == null) {
                return;
            }
            a(j, true, true);
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void b(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "setHDMapFps: " + this.i + org.apache.commons.text.oIX0oI.f33048oxoX + i);
        }
        if (i < 0) {
            return;
        }
        this.i = i;
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar = this.b;
        if (aVar != null) {
            aVar.setMapFps(i);
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public int d() {
        return this.e.h();
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    @OOXIXo
    public LiveData<com.baidu.navisdk.pronavi.hd.normal.data.c> f() {
        return this.c;
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public boolean g() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "isShieldGuidePanelArsResponse: ");
        }
        return this.f7759a.e() == 2 && e();
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public int h() {
        com.baidu.navisdk.ui.routeguide.mapmode.subview.a c2 = com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c();
        IIX0o.oO(c2, "DisplayCutoutManager.getInstance()");
        return (c2.a() + JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp)) - this.e.a().right;
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public boolean e() {
        return this.f7759a.c() == 2;
    }

    private final boolean i(int i) {
        if (i != 2) {
            return false;
        }
        if (com.baidu.navisdk.ui.routeguide.utils.b.v()) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("RGNormalHdFunc", "isTempShieldNormalHDNavi: isPipMode");
            }
            return true;
        }
        com.baidu.navisdk.ui.routeguide.b V = com.baidu.navisdk.ui.routeguide.b.V();
        IIX0o.oO(V, "BNavigator.getInstance()");
        com.baidu.navisdk.pronavi.ui.base.b s = V.s();
        if (s != null && s.I()) {
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("RGNormalHdFunc", "isTempShieldNormalHDNavi FsmState.DynamicLayer isShowChargeStationList:");
            }
            return true;
        }
        if (s != null && s.L()) {
            g gVar3 = g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("RGNormalHdFunc", "isTempShieldNormalHDNavi FsmState.DynamicLayer isShowParkRecList:");
            }
            return true;
        }
        if (s == null || !s.K()) {
            return false;
        }
        g gVar4 = g.PRO_NAV;
        if (gVar4.d()) {
            gVar4.e("RGNormalHdFunc", "isTempShieldNormalHDNavi FsmState.DynamicLayer isShowParkPanelList:");
        }
        return true;
    }

    private final void a(int i, boolean z, boolean z2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "changeUiState: " + this.f7759a.c() + org.apache.commons.text.oIX0oI.f33048oxoX + i + ", " + z2);
        }
        if (com.baidu.navisdk.function.b.FUNC_NORMAL_HD_NAVI_SETTING_ITEM.a()) {
            com.baidu.navisdk.pronavi.hd.normal.data.c value = this.c.getValue();
            if (value == null) {
                value = new com.baidu.navisdk.pronavi.hd.normal.data.c(i);
                value.a(z);
            } else {
                value.a(i);
                value.a(z);
            }
            value.a(z2 ? 500L : 0L);
            this.c.setValue(value);
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "onUserSwitchState:" + this.f7759a + org.apache.commons.text.oIX0oI.f33048oxoX + i);
        }
        if (i != 0 && !c()) {
            if (gVar.d()) {
                gVar.e("RGNormalHdFunc", "onUserSwitchState: no hd data");
                return;
            }
            return;
        }
        this.f7759a.c(i);
        if (this.f7759a.c() != i) {
            a(i, true, true);
            if (i == 2) {
                com.baidu.navisdk.util.statistic.userop.b.r().d("11.0.8.1369", "1");
            }
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    @oOoXoXO
    public View a(@OOXIXo Context context, int i) {
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar;
        IIX0o.x0xO0oo(context, "context");
        if (this.b == null) {
            this.b = new com.baidu.navisdk.pronavi.hd.normal.map.a();
        }
        this.f7759a.d(i);
        Pair<Integer, Integer> g = g(i);
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar2 = this.b;
        View a2 = aVar2 != null ? aVar2.a(context, g.getFirst().intValue(), g.getSecond().intValue(), i) : null;
        int i2 = this.i;
        if (i2 > -1 && (aVar = this.b) != null) {
            aVar.setMapFps(i2);
        }
        m();
        return a2;
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    @OOXIXo
    public com.baidu.navisdk.framework.interfaces.pronavi.hd.f a() {
        return j();
    }

    private final void a(int i, String str) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "loadAndSetDiyResource: " + i + ", " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.navisdk.module.carlogo.control.c.c().b(Integer.MAX_VALUE - i, str, new C0322b(i), false, 200, false);
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void a(boolean z) {
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar = this.b;
        if (aVar != null) {
            aVar.setMapNightMode(z);
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void a(int i, boolean z) {
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar = this.b;
        if (aVar != null) {
            aVar.onHdStateSwitch(0, i, z);
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void a(int i, int i2, boolean z) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "setMapStatus:toHDState:" + i + ",duration：" + i2 + ',' + z + TokenParser.SP);
        }
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar = this.b;
        if (aVar != null) {
            aVar.setMapStatus(i, i2, z);
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void a(boolean z, int i, boolean z2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "setMapAerialAnimation: " + z + ", " + i + ", " + z2);
        }
        com.baidu.navisdk.pronavi.hd.normal.map.a aVar = this.b;
        if (aVar != null) {
            aVar.a(z, i, z2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r4.equals("half_scene") != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return l();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        if (r4.equals("all_scene") != false) goto L38;
     */
    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    @OXOo.oOoXoXO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(@OXOo.oOoXoXO java.lang.String r4) {
        /*
            r3 = this;
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.PRO_NAV
            boolean r1 = r0.d()
            if (r1 == 0) goto L1e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleAsrAction: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RGNormalHdFunc"
            r0.e(r2, r1)
        L1e:
            com.baidu.navisdk.module.cloudconfig.f r0 = com.baidu.navisdk.module.cloudconfig.f.c()
            com.baidu.navisdk.module.cloudconfig.f$j0 r0 = r0.U
            boolean r0 = r0.b
            if (r0 != 0) goto L8e
            boolean r0 = com.baidu.navisdk.util.common.x.s()
            if (r0 != 0) goto L8e
            com.baidu.navisdk.function.b r0 = com.baidu.navisdk.function.b.FUNC_NORMAL_HD_NAVI_SETTING_ITEM
            boolean r0 = r0.a()
            if (r0 != 0) goto L37
            goto L8e
        L37:
            boolean r0 = com.baidu.navisdk.ui.routeguide.utils.b.s()
            if (r0 == 0) goto L40
            java.lang.String r4 = "AR导航不支持车道级引导模式"
            return r4
        L40:
            if (r4 != 0) goto L43
            goto L8c
        L43:
            int r0 = r4.hashCode()
            r1 = -89294738(0xfffffffffaad786e, float:-4.50355E35)
            if (r0 == r1) goto L7f
            r1 = -81917568(0xfffffffffb1e0980, float:-8.205756E35)
            if (r0 == r1) goto L76
            r1 = 3417674(0x34264a, float:4.789181E-39)
            if (r0 == r1) goto L69
            r1 = 94756344(0x5a5ddf8, float:1.5598064E-35)
            if (r0 == r1) goto L5c
            goto L8c
        L5c:
            java.lang.String r0 = "close"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L8c
            java.lang.String r4 = r3.k()
            goto L8d
        L69:
            java.lang.String r0 = "open"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L8c
            java.lang.String r4 = r3.l()
            goto L8d
        L76:
            java.lang.String r0 = "half_scene"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L8c
            goto L87
        L7f:
            java.lang.String r0 = "all_scene"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L8c
        L87:
            java.lang.String r4 = r3.l()
            goto L8d
        L8c:
            r4 = 0
        L8d:
            return r4
        L8e:
            java.lang.String r4 = "暂不支持该指令"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.pronavi.hd.normal.logic.b.a(java.lang.String):java.lang.String");
    }

    @Override // com.baidu.navisdk.pronavi.logic.i.a
    public void a(@oOoXoXO String str, @oOoXoXO String str2, @oOoXoXO Bundle bundle) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "onFSMStateChange: " + str + "->" + str2 + ", " + bundle);
        }
        if (this.h == 1) {
            if ((!IIX0o.Oxx0IOOO(RGFSMTable.FsmState.Pip, str) || IIX0o.Oxx0IOOO(RGFSMTable.FsmState.Pip, str2)) && (!IIX0o.Oxx0IOOO(RGFSMTable.FsmState.DynamicLayer, str) || IIX0o.Oxx0IOOO(RGFSMTable.FsmState.DynamicLayer, str2))) {
                return;
            }
            n();
        }
    }

    @Override // com.baidu.navisdk.pronavi.hd.normal.i.a
    public void a(@OOXIXo String str, boolean z) {
        IIX0o.x0xO0oo(str, "case");
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGNormalHdFunc", "exitNormalHDNavi: " + str + ", " + z);
        }
        this.h = k(this.f7759a.b());
        a(0, true, false);
    }
}
