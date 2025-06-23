package com.baidu.navisdk.module.init;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.baidunavis.baseline.BNOuterMapViewManager;
import com.baidu.mobads.sdk.internal.bn;
import com.baidu.navisdk.adapter.impl.BNVdrController;
import com.baidu.navisdk.carresult.CarResultPage;
import com.baidu.navisdk.challenge.BNChallengeRecordPageProxy;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.NavMapManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.commute.BNCommutePageController;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.im.ChatRoomProxy;
import com.baidu.navisdk.im.util.xml.PrefUtils;
import com.baidu.navisdk.jni.nativeif.JNIOfflineDataControl;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.locationshare.impl.BNLocationShareImpl;
import com.baidu.navisdk.locationshare.network.HttpRequestManager;
import com.baidu.navisdk.model.datastruct.EngineCommonConfig;
import com.baidu.navisdk.module.longlink.JNILonglinkControl;
import com.baidu.navisdk.motorresult.MotorResultPage;
import com.baidu.navisdk.neresult.NeResultPage;
import com.baidu.navisdk.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.offlinedata.ui.BNDownloadUIManager;
import com.baidu.navisdk.speedynavi.SpeedyNaviInterfaceImpl;
import com.baidu.navisdk.speedynavi.map.SpeedyMapViewImpl;
import com.baidu.navisdk.truckpro.TruckProPage;
import com.baidu.navisdk.truckresult.TruckResultPage;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.debug.CmdDebugModeGetURL;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.m0;
import com.baidu.navisdk.util.common.u;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.http.center.k;
import com.baidu.navisdk.util.statistic.r;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class b {
    public static final String h = "b";
    private static b i;
    private static final c.a j = new i();

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.init.c f7184a = null;
    private boolean b = false;
    private volatile boolean c = false;
    private volatile boolean d = false;
    private final Object e = new Object();
    private final List<com.baidu.navisdk.framework.interfaces.b> f = Collections.synchronizedList(new ArrayList());
    private final MutableLiveData<Integer> g = new MutableLiveData<>(0);

    /* loaded from: classes7.dex */
    public class a implements com.baidu.navisdk.module.longlink.a {
        public a(b bVar) {
        }

        @Override // com.baidu.navisdk.module.longlink.a
        public void a(String str, int i, boolean z, String str2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
            if (gVar.d()) {
                gVar.e("lyrebird", "longlink onSuccess moduleName: " + str + ",content:" + str2 + ", msgID:" + i + ", isPush:" + z);
            }
            if (!TextUtils.isEmpty(str) && str.equals("lyrebird")) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.12.a.1", "2", null, null);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        com.baidu.navisdk.framework.b.i(new JSONObject(str2).getJSONObject("yellow_banner").toString());
                    } catch (Exception e) {
                        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.INIT;
                        if (gVar2.c()) {
                            gVar2.a("", e);
                            gVar2.e("lyrebird", "long link parse error");
                        }
                    }
                    com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
                    if (h != null && h.x0()) {
                        s.T().a("您录制的语音包可以下载使用了", true);
                    }
                }
            }
        }

        @Override // com.baidu.navisdk.module.longlink.a
        public void b(String str, int i, boolean z, String str2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
            if (gVar.d()) {
                gVar.e("lyrebird", "longlink onFail moduleName: " + str + ",content:" + str2 + ", msgID:" + i + ", isPush:" + z);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.module.init.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0241b extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7185a;
        final /* synthetic */ com.baidu.navisdk.module.init.c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0241b(String str, String str2, Context context, com.baidu.navisdk.module.init.c cVar) {
            super(str, str2);
            this.f7185a = context;
            this.b = cVar;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            try {
                b.this.b(this.f7185a, this.b);
                return null;
            } catch (Throwable th) {
                LogUtil.out(b.h, th.toString());
                return null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7186a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, Context context) {
            super(str, str2);
            this.f7186a = context;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            b.this.c(this.f7186a);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BNDownloadUIManager.OnNewVersionListener {
        public d(b bVar) {
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.util.worker.f<String, String> {
        public e(b bVar, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
            if (gVar.d()) {
                gVar.e(com.baidu.navisdk.util.worker.g.TAG, "initAfterEngineInited()  updateUserInfo, bduss=" + com.baidu.navisdk.framework.b.e() + ", uid=" + com.baidu.navisdk.framework.b.E() + ", islogin=" + (com.baidu.navisdk.framework.b.e0() ? 1 : 0));
            }
            try {
                JNITrajectoryControl.sInstance.updateUserInfo(com.baidu.navisdk.framework.b.e(), com.baidu.navisdk.framework.b.E(), com.baidu.navisdk.framework.b.e0() ? 1 : 0);
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends com.baidu.navisdk.util.worker.f<String, String> {
        public f(b bVar, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.module.cloudconfig.d dVar = new com.baidu.navisdk.module.cloudconfig.d();
            dVar.a(new com.baidu.navisdk.module.cloudconfig.b());
            dVar.a();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class g extends com.baidu.navisdk.util.worker.f<String, String> {
        public g(b bVar, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.module.tingphone.control.a.d();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class h extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7187a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, String str2, Context context) {
            super(str, str2);
            this.f7187a = context;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            try {
            } catch (Throwable th) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
                if (gVar.c()) {
                    gVar.a("", th);
                }
            }
            if (y.d(this.f7187a) && JNIOfflineDataControl.getInstance().checkNewVer(new Bundle(), new int[35])) {
                return null;
            }
            b.this.b(this.f7187a);
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements c.a {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.baidu.navisdk.framework.interfaces.c.a
        public com.baidu.navisdk.framework.interfaces.h a(String str) {
            char c;
            switch (str.hashCode()) {
                case -2141095305:
                    if (str.equals("RoutePreferSetting")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1955300159:
                    if (str.equals("truck_pro_page")) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case -1777719372:
                    if (str.equals("custom_navi")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case -1763919704:
                    if (str.equals("FutureTrip")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -1713563679:
                    if (str.equals("challenge_record_page")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -1686472601:
                    if (str.equals("RoutePlanInterface")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case -1676226247:
                    if (str.equals("lyrebird")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -1630430653:
                    if (str.equals("LightRouteGuideScene")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1514985092:
                    if (str.equals("voice_page")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case -1148451149:
                    if (str.equals("speedy_navi")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case -1100387161:
                    if (str.equals("motor_result_page")) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case -783691628:
                    if (str.equals("commute_page")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -710614639:
                    if (str.equals("truck_result_page")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case -659357359:
                    if (str.equals("truck_perimeter_page")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case -507712388:
                    if (str.equals("photo_page")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case -505057559:
                    if (str.equals("ne_result_page")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case -504308539:
                    if (str.equals("open_sdk")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case -327700242:
                    if (str.equals("asr_manager")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -129775493:
                    if (str.equals("route_result_page")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 25134133:
                    if (str.equals("speedy_map_view")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 65428978:
                    if (str.equals("guide_page")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 70966867:
                    if (str.equals("nav_2_voice_square")) {
                        c = TokenParser.SP;
                        break;
                    }
                    c = 65535;
                    break;
                case 76256182:
                    if (str.equals("sdk_route_result_page")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 138802901:
                    if (str.equals("location_share")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 494840766:
                    if (str.equals("DiySpeak")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 696552434:
                    if (str.equals("route_nearby_search")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 961480198:
                    if (str.equals("shortcut_fun")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    c = 65535;
                    break;
                case 1043568189:
                    if (str.equals("cruiser")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 1896160953:
                    if (str.equals("nav_result")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case 1924450387:
                    if (str.equals("ABTest")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1948386815:
                    if (str.equals("sdk_vdr")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case 1985941072:
                    if (str.equals("setting")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 2024019467:
                    if (str.equals("Common")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return new com.baidu.navisdk.ui.routeguide.a();
                case 1:
                    return new com.baidu.navisdk.lightnavi.a();
                case 2:
                    if (!com.baidu.navisdk.j.d()) {
                        return null;
                    }
                    return new CarResultPage();
                case 3:
                    return new com.baidu.navcore.carresult.a();
                case 4:
                    return new com.baidu.navisdk.nearbysearch.b();
                case 5:
                    return new com.baidu.navisdk.framework.interfaces.impl.e();
                case 6:
                    return new com.baidu.navisdk.framework.interfaces.impl.b();
                case 7:
                    if (!com.baidu.navisdk.j.d()) {
                        return null;
                    }
                    return new BNLocationShareImpl();
                case '\b':
                    return new com.baidu.navisdk.ui.routeguide.module.diyspeak.d();
                case '\t':
                    return new com.baidu.navisdk.framework.interfaces.impl.d();
                case '\n':
                    return new com.baidu.navisdk.framework.interfaces.impl.a();
                case 11:
                    return new com.baidu.navisdk.module.routepreference.f();
                case '\f':
                    return new BNChallengeRecordPageProxy();
                case '\r':
                    if (!com.baidu.navisdk.j.d()) {
                        return null;
                    }
                    return new BNCommutePageController();
                case 14:
                    return new com.baidu.navisdk.framework.interfaces.impl.c();
                case 15:
                    return new com.baidu.navisdk.module.trucknavi.view.support.module.perimeter.views.a();
                case 16:
                    return new com.baidu.navisdk.ui.photoview.a();
                case 17:
                case 21:
                default:
                    return null;
                case 18:
                    return new SpeedyNaviInterfaceImpl();
                case 19:
                    return new SpeedyMapViewImpl();
                case 20:
                    return new com.baidu.navisdk.comapi.routeplan.d();
                case 22:
                    return new com.baidu.navisdk.cruise.a();
                case 23:
                    return new com.baidu.navisdk.framework.interfaces.impl.f();
                case 24:
                    if (com.baidu.navisdk.j.d()) {
                        return null;
                    }
                    return new BNVdrController();
                case 25:
                    return new com.baidu.navisdk.d();
                case 26:
                    return new com.baidu.navisdk.module.newguide.settings.shortcut.c();
                case 27:
                    return new com.baidu.navisdk.module.newguide.settings.d();
                case 28:
                    return new NeResultPage();
                case 29:
                    return new TruckResultPage();
                case 30:
                    return new MotorResultPage();
                case 31:
                    return new TruckProPage();
                case ' ':
                    return new com.baidu.navisdk.module.voicesquare.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements com.baidu.navisdk.module.longlink.a {

        /* loaded from: classes7.dex */
        public class a extends com.baidu.navisdk.util.worker.f<String, String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f7188a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(j jVar, String str, String str2, int i) {
                super(str, str2);
                this.f7188a = i;
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
                if (gVar.d()) {
                    gVar.e(com.baidu.navisdk.util.worker.g.TAG, "收到云端配置push，重新请求配置信息");
                }
                com.baidu.navisdk.module.cloudconfig.d dVar = new com.baidu.navisdk.module.cloudconfig.d();
                dVar.a(new com.baidu.navisdk.module.cloudconfig.b());
                dVar.a(this.f7188a);
                return null;
            }
        }

        public j(b bVar) {
        }

        @Override // com.baidu.navisdk.module.longlink.a
        public void a(String str, int i, boolean z, String str2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
            if (gVar.d()) {
                gVar.e(b.h, "onSuccess moduleName: " + str + ",content:" + str2 + ", msgID:" + i + ", isPush:" + z);
            }
            if (!TextUtils.isEmpty(str) && str.equals("ABTest")) {
                if (gVar.d()) {
                    gVar.e(b.h, "onSuccess->");
                }
                int i2 = 1003;
                if (!l0.c(str2)) {
                    try {
                        int parseInt = Integer.parseInt(new JSONObject(str2).getString("request_type"));
                        if (parseInt == 1) {
                            i2 = 1001;
                        } else if (parseInt == 2) {
                            i2 = 1002;
                        }
                    } catch (JSONException e) {
                        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.INIT;
                        if (gVar2.c()) {
                            gVar2.a("", e);
                        }
                    }
                }
                com.baidu.navisdk.util.worker.c.a().b(new a(this, b.h + "_PUSH", null, i2), new com.baidu.navisdk.util.worker.e(200, 0), 0L);
            }
        }

        @Override // com.baidu.navisdk.module.longlink.a
        public void b(String str, int i, boolean z, String str2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
            if (gVar.d()) {
                gVar.e(b.h, "onSuccess moduleName: " + str + ",content:" + str2 + ", msgID:" + i + ", isPush:" + z);
            }
        }
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        try {
            CmdDebugModeGetURL.initDebugUrl();
        } catch (Throwable unused) {
        }
        try {
            com.baidu.navisdk.module.userclassification.f.a().a(context);
        } catch (Throwable unused2) {
        }
        try {
            BNOfflineDataManager.getInstance().initDownloadAndUpdateUIIfNeed(true);
            BNOfflineDataManager.getInstance();
            BNDownloadUIManager.checkNewVersion(context, false, new d(this));
            com.baidu.navisdk.framework.b.c(this.f7184a.n);
        } catch (Throwable unused3) {
        }
        try {
            com.baidu.navisdk.util.logic.j.r().b(context);
        } catch (Throwable unused4) {
        }
        try {
            com.baidu.navisdk.framework.interfaces.c.p().a().I();
            i();
        } catch (Throwable unused5) {
        }
        try {
            com.baidu.navisdk.util.statistic.userop.b.r();
            com.baidu.navisdk.comapi.statistics.b.f().d();
        } catch (Throwable unused6) {
        }
        com.baidu.navisdk.util.worker.c.a().b(new e(this, "CarNavi-UpdateUserInfo", null), new com.baidu.navisdk.util.worker.e(200, 0), 10000L);
        com.baidu.navisdk.util.worker.c.a().b(new f(this, "CarNavi-CloudConfig", null), new com.baidu.navisdk.util.worker.e(200, 0), 1000L);
        com.baidu.navisdk.util.worker.c.a().b(new g(this, "CarNavi-TingPhone", null), new com.baidu.navisdk.util.worker.e(200, 0), 12000L);
        b(context);
        com.baidu.navisdk.module.asr.g.b();
    }

    private void f(Context context) {
        com.baidu.navisdk.util.statistic.rookie.a.d().a();
        if (BNSettingManager.isNoviceMode()) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("13.1.0");
        }
        if (!e0.a(context).a("first_init_time_stamp")) {
            e0.a(context).b("first_init_time_stamp", System.currentTimeMillis());
            return;
        }
        long a2 = e0.a(context).a("first_init_time_stamp", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = !a0.g(context) ? 1 : 0;
        if (currentTimeMillis - a2 >= bn.d) {
            if (e0.a(context).a(SettingParams.Key.HAS_TURN_ON_ROOKIE_MODE)) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("13.3.0", Integer.toString(1), Integer.toString(i2));
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("13.3.0", Integer.toString(0), Integer.toString(i2));
            }
        }
    }

    public static b g() {
        if (i == null) {
            synchronized (b.class) {
                i = new b();
            }
        }
        return i;
    }

    private boolean h() {
        try {
            return com.baidu.navisdk.g.a().a(a(), null);
        } catch (Throwable th) {
            com.baidu.navisdk.skyeye.a n = com.baidu.navisdk.skyeye.a.n();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
            n.a(gVar, "initEngine err:" + th.getLocalizedMessage());
            if (gVar.c()) {
                gVar.a("", th);
                return false;
            }
            return false;
        }
    }

    private void i() {
        JNILonglinkControl.getInstance().registerLongLink(new JNILonglinkControl.c(4, "ABTest"), new j(this));
        JNILonglinkControl.getInstance().registerLongLink(new JNILonglinkControl.c(6, "lyrebird"), new a(this));
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, com.baidu.navisdk.module.init.c cVar) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
        String str = h;
        gVar.a(str, "initInThread onStart");
        com.baidu.navisdk.framework.interfaces.b bVar = cVar.e;
        if (bVar != null) {
            bVar.initStart();
        }
        synchronized (this.e) {
            try {
                if (this.d) {
                    com.baidu.navisdk.framework.interfaces.b bVar2 = cVar.e;
                    if (bVar2 != null) {
                        bVar2.initSuccess(false);
                    }
                    gVar.a(str, "initBaseEngine() return 2 inited");
                    return;
                }
                if (this.c) {
                    if (cVar.e != null) {
                        if (gVar.e()) {
                            gVar.g(str, "initBaseEngine() return 3 , listen is added to list.");
                        }
                        this.f.add(cVar.e);
                    }
                    gVar.a(str, "initBaseEngine() return 3 is initing.");
                    return;
                }
                this.c = true;
                this.d = false;
                this.g.postValue(0);
                this.f7184a = cVar;
                b.a aVar = cVar.i;
                if (aVar != null) {
                    com.baidu.navisdk.framework.b.a(aVar);
                }
                if (this.f7184a.b() != null) {
                    com.baidu.navisdk.framework.b.a(this.f7184a.b());
                }
                com.baidu.navisdk.module.page.a.b().a(this.f7184a.j);
                if (com.baidu.navisdk.j.d()) {
                    f();
                    if (!e()) {
                        this.c = false;
                        this.d = false;
                        this.g.postValue(2);
                        com.baidu.navisdk.framework.interfaces.b bVar3 = this.f7184a.e;
                        if (bVar3 != null) {
                            bVar3.initFailed(3);
                        }
                        gVar.a(str, "onCreateView failed for so");
                        return;
                    }
                }
                r.s().p();
                r.s().r();
                com.baidu.navisdk.framework.a.c().a(context.getApplicationContext());
                TipTool.setContext(context.getApplicationContext());
                c();
                a0.a(context, m0.j().a(), false, com.baidu.navisdk.j.a());
                a0.a(this.f7184a.c);
                VDeviceAPI.init(context, m0.j().c(), m0.j().b());
                ScreenUtil.getInstance().init(context);
                BNSettingManager.init(context);
                LogUtil.setLoggable(BNSettingManager.isShowJavaLog());
                com.baidu.navisdk.util.common.g.b(BNSettingManager.isShowJavaLog());
                com.baidu.navisdk.util.http.center.b.a(this.f7184a.h);
                com.baidu.navisdk.h.b(context);
                com.baidu.navisdk.h.a(context);
                com.baidu.navisdk.util.http.b.d().b();
                if (this.f7184a.o != null) {
                    com.baidu.navisdk.debug.d.g().a(this.f7184a.o);
                }
                com.baidu.navisdk.skyeye.a.n().f();
                com.baidu.navisdk.skyeye.a.n().l();
                if (h()) {
                    d(context);
                } else {
                    a(7);
                }
                if (BNSettingManager.isLeakEnabled()) {
                    u.a();
                }
                if (BNSettingManager.isLocationShareOnline()) {
                    HttpRequestManager.getInstance().performMapEntryRequest((String) null, (k) null);
                    BNSettingManager.setLocationShareOnline(false);
                }
                com.baidu.navisdk.module.operationactivities.b.a();
                com.baidu.navisdk.module.dynamicui.d.b().a();
                com.baidu.navisdk.module.brule.c.a();
                PrefUtils.setPrefInt(context, "passportindex", 1);
                ChatRoomProxy.bindService();
                a(context);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void d(Context context) {
        com.baidu.navisdk.util.common.g.INIT.a(h, "handleEngineInitSuccess");
        this.c = false;
        this.d = true;
        this.g.postValue(1);
        try {
            com.baidu.navisdk.h.b(true);
        } catch (Throwable unused) {
        }
        e(context);
        com.baidu.navisdk.module.perform.b.d().a("navi_init");
        com.baidu.navisdk.skyeye.a.n().b(true);
        com.baidu.navisdk.framework.interfaces.b bVar = this.f7184a.e;
        if (bVar != null) {
            bVar.initSuccess(true);
        }
        if (this.f.size() > 0) {
            synchronized (this.f) {
                try {
                    for (int size = this.f.size() - 1; size >= 0; size--) {
                        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
                        if (gVar.e()) {
                            gVar.g("handleEngineInitSuccess() dispatch to listen" + size);
                        }
                        this.f.get(size).initSuccess(false);
                        this.f.remove(size);
                    }
                } finally {
                }
            }
        }
        com.baidu.navisdk.framework.message.a.a().c(new com.baidu.navisdk.framework.message.bean.b(true));
        com.baidu.navisdk.util.worker.c.a().c(new c("CarNavi-Init-Delay", null, context), new com.baidu.navisdk.util.worker.e(2, 1));
    }

    private void e(Context context) {
        com.baidu.navisdk.framework.interfaces.k k;
        b();
        BNRoutePlaner.getInstance().a(context);
        BNRoutePlaner.getInstance().a(new com.baidu.navisdk.framework.interfaces.impl.g());
        com.baidu.navisdk.ugc.utils.f fVar = com.baidu.navisdk.ugc.utils.f.c;
        fVar.a((com.baidu.navisdk.ugc.e) new com.baidu.navisdk.framework.interfaces.impl.h());
        fVar.a((com.baidu.navisdk.ugc.f) new com.baidu.navisdk.framework.interfaces.impl.h());
        g(context);
        NavMapManager.getInstance().init();
        r.s().n();
        try {
            if (com.baidu.navisdk.j.d() || !BNOuterMapViewManager.getInstance().getGLSurfaceView().getController().isDuplicate() || (k = com.baidu.navisdk.framework.interfaces.c.p().k()) == null) {
                return;
            }
            BNMapController.getInstance().enterCarPlayMode(k.N());
        } catch (Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
            if (gVar.c()) {
                gVar.c(h, th.toString());
            }
        }
    }

    public boolean a(Context context, com.baidu.navisdk.module.init.c cVar) {
        com.baidu.navisdk.debug.b.a(context);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
        String str = h;
        gVar.a(str, "BNInitManager init");
        if (context != null && cVar.a()) {
            com.baidu.navisdk.module.perform.b.d().a("app_start_time");
            com.baidu.navisdk.module.perform.b.d().b("navi_init");
            com.baidu.navisdk.j.a(false);
            com.baidu.navisdk.j.a("onsdk");
            TipTool.setIsForBaiduMap(false);
            com.baidu.navisdk.util.worker.loop.c.a(cVar.f);
            com.baidu.navisdk.util.worker.c.a(cVar.g);
            m0.j().a(context, cVar.f7189a, cVar.b);
            if (!com.baidu.navisdk.j.d()) {
                try {
                    BNOuterMapViewManager.getInstance().preInitMapView();
                } catch (Throwable th) {
                    LogUtil.out(h, th.getMessage());
                    if (com.baidu.navisdk.framework.a.c().a() == null) {
                        cVar.e.initFailed(6);
                    } else {
                        cVar.e.initFailed(2);
                    }
                    return false;
                }
            }
            com.baidu.navisdk.util.worker.c.a().c(new C0241b("CarNavi-Init", null, context, cVar), new com.baidu.navisdk.util.worker.e(2, 1));
            return true;
        }
        gVar.a(str, "params are invalid.");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = ""
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.UnsupportedEncodingException -> L74
            r2.<init>()     // Catch: java.io.UnsupportedEncodingException -> L74
            java.lang.String r3 = "&mb="
            r2.append(r3)     // Catch: java.io.UnsupportedEncodingException -> L74
            java.lang.String r3 = com.baidu.navisdk.vi.VDeviceAPI.getPhoneType()     // Catch: java.io.UnsupportedEncodingException -> L74
            java.lang.String r3 = java.net.URLEncoder.encode(r3, r0)     // Catch: java.io.UnsupportedEncodingException -> L74
            r2.append(r3)     // Catch: java.io.UnsupportedEncodingException -> L74
            java.lang.String r2 = r2.toString()     // Catch: java.io.UnsupportedEncodingException -> L74
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.UnsupportedEncodingException -> L72
            r3.<init>()     // Catch: java.io.UnsupportedEncodingException -> L72
            r3.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r4 = "&sv="
            r3.append(r4)     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r4 = com.baidu.navisdk.vi.VDeviceAPI.getAppPackageVersion()     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r4 = java.net.URLEncoder.encode(r4, r0)     // Catch: java.io.UnsupportedEncodingException -> L72
            r3.append(r4)     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r2 = r3.toString()     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.UnsupportedEncodingException -> L72
            r3.<init>()     // Catch: java.io.UnsupportedEncodingException -> L72
            r3.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r4 = "&pcn="
            r3.append(r4)     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r4 = com.baidu.navisdk.vi.VDeviceAPI.getAppPackageName()     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r4 = java.net.URLEncoder.encode(r4, r0)     // Catch: java.io.UnsupportedEncodingException -> L72
            r3.append(r4)     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r2 = r3.toString()     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.UnsupportedEncodingException -> L72
            r3.<init>()     // Catch: java.io.UnsupportedEncodingException -> L72
            r3.append(r2)     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r4 = "&kv="
            r3.append(r4)     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r4 = com.baidu.navisdk.vi.VDeviceAPI.getSDKVersion()     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r0 = java.net.URLEncoder.encode(r4, r0)     // Catch: java.io.UnsupportedEncodingException -> L72
            r3.append(r0)     // Catch: java.io.UnsupportedEncodingException -> L72
            java.lang.String r0 = r3.toString()     // Catch: java.io.UnsupportedEncodingException -> L72
            goto L82
        L72:
            r0 = move-exception
            goto L76
        L74:
            r0 = move-exception
            r2 = r1
        L76:
            com.baidu.navisdk.util.common.g r3 = com.baidu.navisdk.util.common.g.INIT
            boolean r4 = r3.c()
            if (r4 == 0) goto L81
            r3.a(r1, r0)
        L81:
            r0 = r2
        L82:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "&os=android"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "&net="
            r1.append(r0)
            int r6 = com.baidu.navisdk.util.common.y.c(r6)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r6 = "&channel="
            r0.append(r6)
            java.lang.String r6 = com.baidu.navisdk.util.common.a0.g
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r6 = "&vn="
            r0.append(r6)
            int r6 = android.os.Build.VERSION.SDK_INT
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            com.baidu.navisdk.comapi.routeplan.BNRoutePlaner r0 = com.baidu.navisdk.comapi.routeplan.BNRoutePlaner.getInstance()
            r0.c(r6)
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.INIT
            boolean r1 = r0.d()
            if (r1 == 0) goto Lfd
            java.lang.String r1 = com.baidu.navisdk.module.init.b.h
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "setRoutePlanStatistcsUrl() url="
            r2.append(r3)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r0.e(r1, r6)
        Lfd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.module.init.b.g(android.content.Context):void");
    }

    public void c() {
        com.baidu.navisdk.framework.interfaces.c.p().a(j);
    }

    public void f() {
        for (int i2 = 0; i2 < 2; i2++) {
            try {
            } catch (Throwable th) {
                this.b = false;
                com.baidu.navisdk.util.common.g.INIT.e(h, "loadNaviSO exception : " + th.getCause());
                th.printStackTrace();
            }
            if (com.baidu.navisdk.framework.b.g("gnustl_shared") && com.baidu.navisdk.framework.b.g("app_BaiduVIlib") && com.baidu.navisdk.framework.b.g("app_BaiduNaviApplib")) {
                this.b = true;
                break;
            }
            this.b = false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
        if (gVar.d()) {
            gVar.e(h, "static load so. sIsNaviSoLoadSuccess=" + this.b);
        }
    }

    private void a(Context context) {
        f(context);
    }

    private void a(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
        if (gVar.d()) {
            gVar.e(h, "handleEngineInitFailed()");
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("7.2", "1", null, null);
        this.c = false;
        this.d = false;
        this.g.postValue(2);
        com.baidu.navisdk.skyeye.a.n().b(false);
        com.baidu.navisdk.framework.interfaces.b bVar = this.f7184a.e;
        if (bVar != null) {
            bVar.initFailed(i2);
        }
        if (this.f.size() > 0) {
            synchronized (this.f) {
                try {
                    for (int size = this.f.size() - 1; size >= 0; size--) {
                        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.INIT;
                        if (gVar2.d()) {
                            gVar2.e(h, "handleEngineInitFailed() dispatch to listen" + size);
                        }
                        this.f.get(size).initFailed(i2);
                        this.f.remove(size);
                    }
                } finally {
                }
            }
        }
        com.baidu.navisdk.framework.message.a.a().c(new com.baidu.navisdk.framework.message.bean.b(false));
    }

    public EngineCommonConfig a() {
        EngineCommonConfig engineCommonConfig = new EngineCommonConfig();
        engineCommonConfig.mSearchNetMode = BNSettingManager.getPrefSearchMode();
        engineCommonConfig.mGuidanceNetMode = 0;
        engineCommonConfig.mMapEngineNetMode = 0;
        engineCommonConfig.mOtherEngineNetMode = 0;
        engineCommonConfig.mStrProductName = VDeviceAPI.APP_PRODUCT_KIND;
        engineCommonConfig.mRootPath = m0.j().e();
        engineCommonConfig.mStrMapPath = m0.j().e() + File.separator + m0.j().d();
        engineCommonConfig.mStrAppFolderName = m0.j().d();
        engineCommonConfig.mStrPath = m0.j().c();
        engineCommonConfig.mTTSEngineVersion = String.valueOf(com.baidu.navisdk.framework.b.C());
        try {
            engineCommonConfig.mMengMengDaTTSPath = this.f7184a.m;
        } catch (Throwable unused) {
        }
        return engineCommonConfig;
    }

    public void b() {
        com.baidu.navisdk.h.d = this.f7184a.l;
        com.baidu.navisdk.h.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        com.baidu.navisdk.util.worker.c.a().b(new h("CarNavi-checkXiJiang", null, context), new com.baidu.navisdk.util.worker.e(200, 0), 43200000L);
    }
}
