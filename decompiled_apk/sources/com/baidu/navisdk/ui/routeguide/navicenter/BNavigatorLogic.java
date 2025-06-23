package com.baidu.navisdk.ui.routeguide.navicenter;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.baidu.navisdk.adapter.BNaviCommonParams;
import com.baidu.navisdk.bluetooth.b;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.mapcontrol.BNDynamicOverlay;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.mapcontrol.MapParams;
import com.baidu.navisdk.comapi.mapcontrol.NavMapManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.comapi.trajectory.NaviTrajectory;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.module.navisafeguard.a;
import com.baidu.navisdk.module.vdr.a;
import com.baidu.navisdk.pronavi.base.RGBaseUiFrame;
import com.baidu.navisdk.pronavi.base.logic.RGBaseLogicFrame;
import com.baidu.navisdk.pronavi.car.logic.RGCarLogicFrame;
import com.baidu.navisdk.pronavi.car.ui.RGCarUiFrame;
import com.baidu.navisdk.pronavi.hd.hdnavi.map.RGHDBaseMapHelper;
import com.baidu.navisdk.pronavi.newenergy.logic.RGNewEnergyLogicFrame;
import com.baidu.navisdk.pronavi.newenergy.ui.RGNewEnergyUiFrame;
import com.baidu.navisdk.pronavi.othervehicle.logic.RGOldSettingCarLogicFrame;
import com.baidu.navisdk.pronavi.othervehicle.ui.RGOldSettingCarUiFrame;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.a;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.routesearchfilterview.BNRouteNearbySearchUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.f0;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.n;
import com.baidu.navisdk.util.common.n0;
import com.baidu.navisdk.util.common.s0;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.jar.style.BNInflaterFactory;
import com.baidu.navisdk.util.listener.BatteryStatusReceiver;
import com.baidu.navisdk.util.listener.RGScreenStatusReceiver;
import com.baidu.navisdk.util.listener.RingModeStatusReceiver;
import com.baidu.navisdk.util.listener.UsbListener;
import com.baidu.navisdk.util.statistic.ProNaviStatItem;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.navisdk.yellowtipdata.model.a;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.j;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import com.garmin.fit.xOxOoo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class BNavigatorLogic extends com.baidu.navisdk.pageframe.a<RGBaseUiFrame<?>, RGBaseLogicFrame> implements com.baidu.navisdk.framework.interfaces.i {
    public static volatile boolean z0 = false;
    private long G;
    private Runnable J;
    private View M;
    private com.baidu.navisdk.util.logic.f Q;
    private com.baidu.navisdk.model.datastruct.g R;
    private com.baidu.navisdk.ui.routeguide.utils.g X;
    private Context d;
    private LifecycleOwner e;
    private ViewModelStore f;
    private RoutePlanNode h0;
    private com.baidu.navisdk.framework.interfaces.pronavi.j i0;
    private BNMapObserver l;
    private com.baidu.navisdk.ui.routeguide.navicenter.c l0;
    private BNDynamicOverlay.OnClickListener m;
    private com.baidu.navisdk.ui.routeguide.navidiff.c m0;
    private long n0;
    private com.baidu.navisdk.comapi.routeguide.g o;
    private com.baidu.navisdk.comapi.routeguide.e p;
    private com.baidu.navisdk.comapi.routeguide.b q;
    private com.baidu.navisdk.comapi.routeguide.f q0;
    private com.baidu.navisdk.framework.interfaces.pronavi.o r;
    protected com.baidu.navisdk.ui.routeguide.subview.a s;
    private com.baidu.navisdk.framework.interfaces.pronavi.i t;
    private com.baidu.navisdk.framework.interfaces.pronavi.n u;
    private com.baidu.navisdk.framework.interfaces.pronavi.f v;
    private com.baidu.navisdk.ui.routeguide.navicenter.a x;
    private com.baidu.navisdk.ui.routeguide.heatmonitor.j z;
    public boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private boolean j = true;
    private boolean k = false;
    private com.baidu.navisdk.util.task.a w = null;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private int F = 2;
    private boolean H = false;
    private final com.baidu.navisdk.ui.routeguide.pip.b I = new com.baidu.navisdk.ui.routeguide.pip.b();
    private SharedPreferences.OnSharedPreferenceChangeListener K = new k(this);
    protected FrameLayout L = null;
    private boolean N = false;
    private boolean O = true;
    private boolean P = false;
    private int S = 0;
    private boolean T = false;
    private long U = 0;
    private String V = null;
    private Bundle W = null;
    private volatile boolean Y = true;
    private volatile boolean Z = false;
    private volatile boolean a0 = false;
    private boolean b0 = true;
    private volatile boolean c0 = false;
    private boolean d0 = false;
    private boolean e0 = false;
    private boolean f0 = false;
    private volatile boolean g0 = false;
    private ContentObserver j0 = null;

    /* renamed from: o0, reason: collision with root package name */
    private final a.InterfaceC0201a f9030o0 = new y();
    private ContentObserver p0 = null;
    private final n.b r0 = new z();
    private Handler s0 = new a("BNavigator");
    private final com.baidu.navisdk.comapi.base.d t0 = new c("Naving5");
    private final com.baidu.navisdk.comapi.geolocate.a u0 = new d();
    private final a.b v0 = new e();
    private final com.baidu.navisdk.comapi.commontool.b w0 = new l();

    /* renamed from: x0, reason: collision with root package name */
    private final BroadcastReceiver f9031x0 = new BroadcastReceiver() { // from class: com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic.21
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (RouteGuideParams.ACTION_QUITNAVI.equals(intent.getAction())) {
                BNavigatorLogic.this.m0();
            }
        }
    };
    private long y0 = 0;
    private final a0 k0 = new a0();
    private final com.baidu.navisdk.comapi.routeplan.v2.a n = new com.baidu.navisdk.ui.routeguide.navicenter.impl.h(this);
    private final com.baidu.navisdk.framework.interfaces.lightnavi.a y = (com.baidu.navisdk.framework.interfaces.lightnavi.a) com.baidu.navisdk.framework.interfaces.c.p().a("LightRouteGuideScene");
    private final com.baidu.navisdk.module.pronavi.model.f A = new com.baidu.navisdk.module.pronavi.model.f();

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.what;
            if (i != 1003) {
                if (i != 10901) {
                    if (i != 10921) {
                        if (i != 10931) {
                            if (i != 10941) {
                                if (i != 10961) {
                                    if (i == 10971 && BNavigatorLogic.z0) {
                                        BNavigatorLogic.this.M0();
                                        BNavigatorLogic.this.o1();
                                        return;
                                    }
                                    return;
                                }
                                if (com.baidu.navisdk.j.d() || com.baidu.navisdk.j.c()) {
                                    com.baidu.navisdk.ui.routeguide.control.x.b().t0().b();
                                    return;
                                }
                                return;
                            }
                            TipTool.onCreateToastDialog(com.baidu.navisdk.ui.routeguide.b.V().b(), JarUtils.getResources().getString(R.string.nsdk_string_rg_tts_volume_too_low));
                            return;
                        }
                        com.baidu.navisdk.ui.routeguide.control.x.b().E(com.baidu.navisdk.ui.routeguide.model.a0.I().j());
                        return;
                    }
                    if (message.arg1 == 1) {
                        com.baidu.navisdk.ui.routeguide.control.x.b().i();
                        return;
                    }
                    return;
                }
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "mHandler MSG_TYPE_OPEN_BLUETOOTH_SCO");
                }
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().l(2);
                return;
            }
            if (message.arg1 == 0) {
                com.baidu.navisdk.model.datastruct.s b = ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).b();
                if (b != null && b.e.length() > 0) {
                    com.baidu.navisdk.poisearch.model.b.m().a(b);
                    com.baidu.navisdk.ui.routeguide.control.x.b().z0 = true;
                    com.baidu.navisdk.ui.routeguide.control.x.b().W4();
                    com.baidu.navisdk.ui.routeguide.control.x.b().j4();
                    return;
                }
                return;
            }
            if (BNavigatorLogic.this.d != null) {
                TipTool.onCreateToastDialog(BNavigatorLogic.this.d, com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_pp_no_data_no_network));
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class a0 {

        /* renamed from: a, reason: collision with root package name */
        private com.baidu.navisdk.util.worker.f<String, String> f9034a;
        private com.baidu.navisdk.util.task.b<String, String> b;
        private com.baidu.navisdk.util.task.b<String, String> c;
        private com.baidu.navisdk.util.worker.f<String, String> d;
        private com.baidu.navisdk.util.worker.f<String, String> e;
        private com.baidu.navisdk.util.worker.f f;
        private com.baidu.navisdk.util.worker.f g;
        private Runnable h;
        private com.baidu.navisdk.util.worker.f<String, String> i;
        private com.baidu.navisdk.util.worker.f<String, String> j;
        private com.baidu.navisdk.util.worker.f<String, String> k;

        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.util.worker.f<String, String> {
            public a(a0 a0Var, String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                int bluetoothChannelMode = BNCommSettingManager.getInstance().getBluetoothChannelMode();
                if (bluetoothChannelMode == 0) {
                    return null;
                }
                com.baidu.navisdk.bluetooth.b.i().a(bluetoothChannelMode);
                return null;
            }
        }

        /* loaded from: classes8.dex */
        public class b extends com.baidu.navisdk.util.worker.f<String, String> {
            public b(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                BNavigatorLogic.s(BNavigatorLogic.this);
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(com.baidu.navisdk.util.worker.g.TAG, "mNotConnectedToConnectedTask --> notConnectedToConnectedRetryCount = " + BNavigatorLogic.this.F);
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "测试toast: 恢复网络，开始第" + (3 - BNavigatorLogic.this.F) + "次重算!!!");
                }
                BNRouteGuider.getInstance().calcOtherRoute(4);
                if (BNavigatorLogic.this.F <= 0) {
                    return null;
                }
                com.baidu.navisdk.util.worker.c.a().a(a0.this.k, new com.baidu.navisdk.util.worker.e(2, 0), 60000L);
                return null;
            }
        }

        /* loaded from: classes8.dex */
        public class c extends com.baidu.navisdk.util.worker.f<String, String> {
            public c(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                if (BNavigatorLogic.z0 && !RGFSMTable.FsmState.ArriveDest.equals(RouteGuideFSM.getInstance().getTopState()) && !com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
                    if (BNavigatorLogic.this.c0 || !BNavigatorLogic.this.e0) {
                        if (!BNavigatorLogic.this.f0) {
                            BNavigatorLogic.this.Y0();
                            Bundle bundle = new Bundle();
                            if (com.baidu.navisdk.j.d()) {
                                bundle.putBoolean("not_set_mapstate", BNavigatorLogic.this.c0);
                            } else {
                                bundle.putBoolean("not_set_mapstate", false);
                            }
                            RouteGuideFSM.getInstance().runInitialState(bundle);
                        } else {
                            BNavigatorLogic.this.f0 = false;
                            RouteGuideFSM.getInstance().run(RouteGuideFSM.getInstance().getLastestMap2DOr3DStateFromLocal());
                        }
                        com.baidu.navisdk.module.perform.b.d().c("sdk_routeguide_fsm_anim_end");
                    } else {
                        BNavigatorLogic.this.c0 = false;
                        BNavigatorLogic.this.e0 = false;
                        BNavigatorLogic.this.f0 = true;
                        BNavigatorLogic.this.Y0();
                        RouteGuideFSM.getInstance().runFirstFullViewSate();
                        com.baidu.navisdk.util.worker.c.a().a(a0.this.f9034a, new com.baidu.navisdk.util.worker.e(2, 0), BNRoutePlaner.getInstance().d() == 39 ? 5000 : 3000);
                    }
                    return null;
                }
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e(com.baidu.navisdk.util.worker.g.TAG, "FsmRunInitialStateTask return");
                }
                return null;
            }
        }

        /* loaded from: classes8.dex */
        public class d extends com.baidu.navisdk.util.worker.f<String, String> {
            public d(a0 a0Var, String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                com.baidu.navisdk.ui.routeguide.control.x.b().K1();
                com.baidu.navisdk.ui.routeguide.control.x.b().P1();
                return null;
            }
        }

        /* loaded from: classes8.dex */
        public class e extends com.baidu.navisdk.util.task.b<String, String> {

            /* loaded from: classes8.dex */
            public class a extends TimerTask {
                public a() {
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    com.baidu.navisdk.framework.interfaces.k k;
                    if (!BNavigatorLogic.z0) {
                        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar.d()) {
                            gVar.e(com.baidu.navisdk.util.worker.g.TAG, "carOrderTryAgain return navi end");
                            return;
                        }
                        return;
                    }
                    if (!BNavigatorLogic.this.d0() && (k = com.baidu.navisdk.framework.interfaces.c.p().k()) != null) {
                        k.B();
                        com.baidu.navisdk.util.statistic.userop.b.r().a("20.0.4.1568", null, null, null);
                        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar2.d()) {
                            gVar2.e(com.baidu.navisdk.util.worker.g.TAG, "carOrderTryAgain");
                        }
                    }
                }
            }

            public e(String str, String str2, int i) {
                super(str, str2, i);
            }

            @Override // com.baidu.navisdk.util.task.b
            public void a() {
                if (!BNavigatorLogic.z0) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e(com.baidu.navisdk.util.worker.g.TAG, "initFirstRGInfoTask return navi end");
                        return;
                    }
                    return;
                }
                boolean d0 = BNavigatorLogic.this.d0();
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e(com.baidu.navisdk.util.worker.g.TAG, "initFirstRGInfoTask isRoutePlanReady: " + d0);
                }
                if (d0 && !com.baidu.navisdk.ui.routeguide.model.a0.I().t) {
                    Bundle bundle = new Bundle();
                    JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
                    if (gVar2.d()) {
                        gVar2.e(com.baidu.navisdk.util.worker.g.TAG, "isFirstDataOk --> getFirstRouteGuideInfo bundle = " + bundle);
                    }
                    com.baidu.navisdk.ui.routeguide.model.a0.I().a(bundle);
                    com.baidu.navisdk.ui.routeguide.control.x.b().P1();
                    return;
                }
                com.baidu.navisdk.ui.routeguide.control.x.b().Y3();
                new Timer().schedule(new a(), 500L);
            }
        }

        /* loaded from: classes8.dex */
        public class f extends com.baidu.navisdk.util.task.b<String, String> {
            public f(String str, String str2, int i) {
                super(str, str2, i);
            }

            @Override // com.baidu.navisdk.util.task.b
            public void a() {
                if (BNavigatorLogic.z0) {
                    BNavigatorLogic.this.V0();
                    f0.d().b(502);
                    BNRoutePlaner.getInstance().a(true);
                } else {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e(com.baidu.navisdk.util.worker.g.TAG, "initOtherTask return navi end");
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public class g extends com.baidu.navisdk.util.worker.f<String, String> {
            public g(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                if (BNSettingManager.isShowJavaLog()) {
                    TipTool.onCreateToastDialog(com.baidu.navisdk.ui.routeguide.b.V().b(), "提示：丢星超过60秒重新添加系统Gps监听");
                }
                BNavigatorLogic.this.g = true;
                com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.6", null, null, null);
                SDKDebugFileUtil.get(SDKDebugFileUtil.NAVING_FLPLOC_FILENAME).add("lost Satellites more than 60s ReAddGpsLocation");
                BNavigatorLogic.this.q0();
                BNavigatorLogic.this.i();
                return null;
            }
        }

        /* loaded from: classes8.dex */
        public class h extends com.baidu.navisdk.util.worker.f<String, String> {
            public h(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                Bundle k = com.baidu.navisdk.ui.routeguide.model.a0.I().k();
                int a2 = com.baidu.navisdk.util.common.h.a();
                int b = com.baidu.navisdk.util.common.h.b();
                if (k != null && k.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist)) {
                    a2 = k.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist);
                }
                if (k != null && k.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime)) {
                    b = k.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
                }
                com.baidu.navisdk.ui.routeguide.control.x.b().f(com.baidu.navisdk.ui.routeguide.model.a0.I().c(a2, b));
                com.baidu.navisdk.ui.routeguide.control.x.b().c5();
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) a0.this.e, false);
                com.baidu.navisdk.util.worker.c.a().a(a0.this.e, new com.baidu.navisdk.util.worker.e(2, 0), 60000L);
                return null;
            }
        }

        /* loaded from: classes8.dex */
        public class i extends com.baidu.navisdk.util.worker.f<String, String> {
            public i(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                com.baidu.navisdk.ui.routeguide.control.x.b().K1();
                BNavigatorLogic.this.x0();
                return null;
            }
        }

        /* loaded from: classes8.dex */
        public class j implements Runnable {
            public j() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "loc_car");
                }
                RouteGuideFSM.getInstance().setFullViewByUser(false);
                BNavigatorLogic.this.G().l();
            }
        }

        /* loaded from: classes8.dex */
        public class k extends com.baidu.navisdk.util.worker.f<String, String> {
            public k(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                if (BNavigatorLogic.this.d == null) {
                    return null;
                }
                TipTool.onCreateToastDialog(BNavigatorLogic.this.d, JarUtils.getResources().getString(R.string.nsdk_string_rg_mock_gps_open));
                return null;
            }
        }

        public a0() {
        }

        public com.baidu.navisdk.util.task.b<String, String> d() {
            if (this.b == null) {
                this.b = new e("initFirstRGInfoTask", null, 0);
            }
            return this.b;
        }

        public com.baidu.navisdk.util.worker.f e() {
            if (this.f == null) {
                this.f = new d(this, "execute-mInitFirstRGInfoTask", null);
            }
            return this.f;
        }

        public com.baidu.navisdk.util.task.b<String, String> f() {
            if (this.c == null) {
                this.c = new f("initOtherTask", null, 0);
            }
            return this.c;
        }

        public com.baidu.navisdk.util.worker.f<String, String> g() {
            if (this.i == null) {
                this.i = new k("mockToastTask", null);
            }
            return this.i;
        }

        public com.baidu.navisdk.util.worker.f<String, String> h() {
            if (this.k == null) {
                this.k = new b("mNotConnectedToConnectedTask", null);
            }
            return this.k;
        }

        public com.baidu.navisdk.util.worker.f<String, String> i() {
            if (this.d == null) {
                this.d = new g("ReAddGpsLocationTask", null);
            }
            return this.d;
        }

        public com.baidu.navisdk.util.worker.f<String, String> j() {
            if (this.e == null) {
                this.e = new h("refreshTotalRemainDistTimeTask", null);
            }
            return this.e;
        }

        public com.baidu.navisdk.util.worker.f k() {
            if (this.g == null) {
                this.g = new i("execute-startNaviReally", null);
            }
            return this.g;
        }

        public com.baidu.navisdk.util.worker.f<String, String> a() {
            if (this.j == null) {
                this.j = new a(this, "BNBluetoothAudio-setPlayMode", null);
            }
            return this.j;
        }

        public Runnable b() {
            if (this.h == null) {
                this.h = new j();
            }
            return this.h;
        }

        public com.baidu.navisdk.util.worker.f<String, String> c() {
            if (this.f9034a == null) {
                this.f9034a = new c("FsmRunInitialStateTask", null);
            }
            return this.f9034a;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.f<String, String> {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            BNavigatorLogic.this.N0();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.util.worker.loop.b {
        public c(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            observe(4099);
        }

        @Override // com.baidu.navisdk.util.worker.loop.b
        public void onMessage(Message message) {
            if (message.what == 4099) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", " mRouteGuideUiHandler MSG_NAVI_ROUTE_PLAN_RESULT:" + BNavigatorLogic.this.a0);
                }
                if (message.arg1 == 0 && !BNavigatorLogic.this.a0) {
                    if (!com.baidu.navisdk.ui.routeguide.model.a0.I().t) {
                        Bundle bundle = new Bundle();
                        JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
                        com.baidu.navisdk.ui.routeguide.model.a0.I().a(bundle);
                    }
                    if (com.baidu.navisdk.ui.routeguide.model.a0.I().t) {
                        com.baidu.navisdk.ui.routeguide.control.x.b().K1();
                        com.baidu.navisdk.ui.routeguide.control.x.b().P1();
                    }
                }
                com.baidu.navisdk.vi.b.b(BNavigatorLogic.this.t0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends com.baidu.navisdk.comapi.geolocate.a {

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a(d dVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().P4();
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.baidu.navisdk.model.datastruct.g f9046a;

            public b(d dVar, com.baidu.navisdk.model.datastruct.g gVar) {
                this.f9046a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
                if (k != null) {
                    k.a(com.baidu.navisdk.module.pronavi.model.g.o().b(), com.baidu.navisdk.module.pronavi.model.g.o().k);
                }
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().P4();
                com.baidu.navisdk.ui.routeguide.control.x.b().S4();
                if (com.baidu.navisdk.ui.routeguide.model.q.d().c() && !com.baidu.navisdk.ui.routeguide.model.q.d().b() && com.baidu.navisdk.ui.routeguide.model.q.d().a(this.f9046a.c)) {
                    com.baidu.navisdk.ui.routeguide.control.s.T().a(false);
                }
            }
        }

        public d() {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.a, com.baidu.navisdk.comapi.geolocate.b
        public void onGpsStatusChange(boolean z, boolean z2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.a()) {
                gVar.a("From app: onGpsStatusChange enabled=" + z + ", available=" + z2);
            }
            if (gVar.b()) {
                TipTool.onCreateToastDialog(com.baidu.navisdk.ui.routeguide.b.V().b(), "来自应用: onGpsStatusChange enabled=" + z + ", available=" + z2);
                SDKDebugFileUtil.get(SDKDebugFileUtil.SYSLOC_FILENAME).add("From app: onGpsStatusChange enabled=" + z + ", available=" + z2);
            }
            com.baidu.navisdk.module.pronavi.model.g.o().g = z;
            BNavigatorLogic.this.t0.post(new a(this));
            com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                k.a(com.baidu.navisdk.module.pronavi.model.g.o().b(), com.baidu.navisdk.module.pronavi.model.g.o().k);
            }
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar) {
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x024f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0288  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x02e0  */
        /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0294  */
        @Override // com.baidu.navisdk.comapi.geolocate.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g r37, com.baidu.navisdk.model.datastruct.g r38) {
            /*
                Method dump skipped, instructions count: 740
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.navicenter.BNavigatorLogic.d.onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g, com.baidu.navisdk.model.datastruct.g):void");
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.b {

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a(e eVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().P4();
                com.baidu.navisdk.ui.routeguide.control.x.b().S4();
            }
        }

        public e() {
        }

        @Override // com.baidu.navisdk.module.vdr.a.b
        public void a(String str, com.baidu.navisdk.framework.interfaces.opendatasturct.a aVar) {
            if (aVar != null) {
                com.baidu.navisdk.module.pronavi.model.g.o().a(aVar.s);
                BNavigatorLogic.this.t0.post(new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends Handler {
        public f(BNavigatorLogic bNavigatorLogic) {
        }
    }

    /* loaded from: classes8.dex */
    public class g extends ContentObserver {
        public g(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "LOCATION_PROVIDERS_ALLOWED onChange");
            }
            if (com.baidu.navisdk.util.common.q.i()) {
                if (BNavigatorLogic.this.f0()) {
                    BNavigatorLogic.this.m();
                    return;
                }
                return;
            }
            BNavigatorLogic.this.m();
        }
    }

    /* loaded from: classes8.dex */
    public class h extends Handler {
        public h(BNavigatorLogic bNavigatorLogic) {
        }
    }

    /* loaded from: classes8.dex */
    public class i extends ContentObserver {
        public i(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            BNavigatorLogic.this.a(true);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements BNRoutePlaner.f {
        public j(BNavigatorLogic bNavigatorLogic) {
        }

        @Override // com.baidu.navisdk.comapi.routeplan.BNRoutePlaner.f
        public void a(ArrayList<RoutePlanNode> arrayList) {
            com.baidu.navisdk.comapi.commontool.c.c().a(arrayList, com.baidu.navisdk.module.vehiclemanager.b.i().b(), BNRoutePlaner.getInstance().l(), com.baidu.navisdk.module.routepreference.d.j().b());
        }
    }

    /* loaded from: classes8.dex */
    public class k implements SharedPreferences.OnSharedPreferenceChangeListener {
        public k(BNavigatorLogic bNavigatorLogic) {
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNavigatorLogic", "onSharedPreferenceChanged->sp-key:" + str);
            }
            com.baidu.navisdk.framework.interfaces.k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (BNCommSettingManager.getInstance().getKeyByVehicle(SettingParams.Key.NAVI_VOICE_MODE).equalsIgnoreCase(str) && k != null) {
                k.m(BNCommSettingManager.getInstance().getVoiceMode());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements com.baidu.navisdk.comapi.commontool.b {
        public l() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            if (i == 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return;
                            }
                        }
                    }
                    BNavigatorLogic.this.l(false);
                    BNRouteGuider.getInstance().messageCallback(12, 0, 0, com.baidu.navisdk.module.pronavi.message.d.NIGHT);
                    return;
                }
                BNavigatorLogic.this.l(true);
                BNRouteGuider.getInstance().messageCallback(12, 0, 0, com.baidu.navisdk.module.pronavi.message.d.DAY);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends TTSPlayerControl.f {
        public m(BNavigatorLogic bNavigatorLogic) {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(String str) {
            TTSPlayerControl.setStopVoiceOutput(false);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("XDVoice", " onPlayEnd resumeVoiceTTSOutput");
            }
            TTSPlayerControl.removeTTSPlayStateListener(this);
        }
    }

    /* loaded from: classes8.dex */
    public class n extends com.baidu.navisdk.util.worker.f<String, String> {
        public n(BNavigatorLogic bNavigatorLogic, String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("XDVoice", " play 5s later, resumeVoiceTTSOutput");
            }
            TTSPlayerControl.setStopVoiceOutput(false);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class o implements b.InterfaceC0174b {
        public o() {
        }

        @Override // com.baidu.navisdk.bluetooth.b.InterfaceC0174b
        public void a(String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(com.baidu.navisdk.bluetooth.b.h, "queryDeviceName success, name=" + str);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.r.1", "-1", null, null);
            BNavigatorLogic.this.d1();
        }

        @Override // com.baidu.navisdk.bluetooth.b.InterfaceC0174b
        public void onFail() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(com.baidu.navisdk.bluetooth.b.h, "queryDeviceName error");
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.r.1", null, null, null);
        }
    }

    /* loaded from: classes8.dex */
    public class q extends com.baidu.navisdk.util.worker.f<String, String> {
        public q(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            String string = JarUtils.getResources().getString(R.string.bluetooth_enter_tips, BNavigatorLogic.this.K0());
            if (BNavigatorLogic.this.c() == null) {
                return null;
            }
            TipTool.onCreateToastDialog2(BNavigatorLogic.this.c(), string);
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BNavigatorLogic.this.J = null;
            BNavigatorLogic.this.s.n();
        }
    }

    /* loaded from: classes8.dex */
    public class s implements a.b {
        public s(BNavigatorLogic bNavigatorLogic) {
        }

        @Override // com.baidu.navisdk.module.navisafeguard.a.b
        public void a(boolean z) {
            if (z) {
                com.baidu.navisdk.ui.routeguide.control.x.b().I(true);
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.v.7");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements i0.f {
        public t() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            BNavigatorLogic.this.t1();
        }
    }

    /* loaded from: classes8.dex */
    public class u implements Runnable {
        public u(BNavigatorLogic bNavigatorLogic) {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BNavigatorLogic.z0) {
                new com.baidu.navisdk.ui.routeguide.control.z().a("ugcvalidate");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v implements a.r0 {
        public v() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.a.r0
        public int a(AudioManager audioManager, int i) {
            return BNavigatorLogic.this.a(audioManager, i);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.a.r0
        public int b(AudioManager audioManager, int i) {
            return BNavigatorLogic.this.b(audioManager, i);
        }
    }

    /* loaded from: classes8.dex */
    public class w implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f9057a;
        final /* synthetic */ int b;

        public w(boolean z, int i) {
            this.f9057a = z;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "handleActionWhenExitNavi doTask bg onStart :" + this.f9057a);
            }
            boolean z = this.f9057a;
            if (z) {
                if (z) {
                    com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410344", "410344");
                } else {
                    com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410343", "410343");
                }
            }
            BNavigatorLogic.this.b(this.b, true);
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "handleActionWhenExitNavi doTask bg end");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x extends com.baidu.navisdk.util.worker.f<String, String> {
        public x(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (BNavigatorLogic.this.r != null) {
                try {
                    com.baidu.navisdk.framework.b.a(2, (Object) null);
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class y implements a.InterfaceC0201a {
        public y() {
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if (obj instanceof com.baidu.navisdk.framework.message.bean.o) {
                BNavigatorLogic.this.f(((com.baidu.navisdk.framework.message.bean.o) obj).f6832a);
                return;
            }
            if (obj instanceof com.baidu.navisdk.framework.message.bean.p) {
                BNavigatorLogic.this.g(((com.baidu.navisdk.framework.message.bean.p) obj).f6833a);
                return;
            }
            if (obj instanceof com.baidu.navisdk.framework.message.bean.w) {
                int a2 = s0.a(com.baidu.navisdk.framework.a.c().a());
                if (a2 == 1) {
                    com.baidu.navisdk.framework.c.b().a(13, 14);
                } else if (a2 == 3) {
                    com.baidu.navisdk.framework.c.b().a(13, 14);
                }
            }
        }
    }

    public BNavigatorLogic() {
        this.s = null;
        this.s = new com.baidu.navisdk.ui.routeguide.navicenter.impl.j(this);
    }

    private void E0() {
        UsbListener.b(this.s0);
        UsbListener.b(this.d);
        BatteryStatusReceiver.b(this.d);
        RingModeStatusReceiver.b(this.d);
        try {
            this.d.unregisterReceiver(this.f9031x0);
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "unregisterReceiver(mNavQuitReceiver)-> e: " + e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        int i2;
        int i3;
        com.baidu.navisdk.module.base.a.b(1);
        this.h0 = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).o();
        boolean z2 = false;
        b(false);
        if (I() == 3) {
            BNMapController.getInstance().setMapFuncTruckLimitInfo(com.baidu.navisdk.module.trucknavi.a.f7574a, true);
            com.baidu.navisdk.module.trucknavi.b.b().a();
        }
        if (com.baidu.navisdk.j.c()) {
            f0.d().a().postDelayed(new u(this), 3000L);
        } else {
            new com.baidu.navisdk.ui.routeguide.control.z().a("ugcvalidate");
        }
        if (s().f()) {
            a("4");
        } else if (s().g()) {
            a("3");
        } else {
            a("1");
        }
        k(true);
        com.baidu.navisdk.framework.interfaces.pronavi.o oVar = this.r;
        if (oVar != null) {
            oVar.b();
        }
        com.baidu.navisdk.naviresult.a.d().a().a(!this.A.o());
        com.baidu.navisdk.module.vdr.a.d(1);
        Bundle k2 = com.baidu.navisdk.ui.routeguide.model.a0.I().k();
        if (k2 != null && k2.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist)) {
            i2 = k2.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalDist);
        } else {
            i2 = 0;
        }
        if (k2 != null && k2.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime)) {
            i3 = k2.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
        } else {
            i3 = 0;
        }
        ProNaviStatItem.O().a(i3, i2);
        ProNaviStatItem.O().b(BNSettingManager.getTTSCopyTime());
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic_", "" + fVar.f);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.1", com.baidu.navisdk.util.statistic.userop.b.r().b(fVar.a(this.d, false), HelpFormatter.DEFAULT_OPT_PREFIX, ","), "0", com.baidu.navisdk.util.statistic.userop.b.r().b(fVar.b(this.d, false), HelpFormatter.DEFAULT_OPT_PREFIX, ","));
        k();
        BNMapController.getInstance().setSimpleModeGuide(!com.baidu.navisdk.ui.routeguide.utils.b.x());
        if (com.baidu.navisdk.framework.b.M()) {
            BNRouteNearbySearchUtils.INSTANCE.startQuery();
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c cVar = this.l0;
        if (cVar != null) {
            cVar.b().a().f();
        }
        int vDRSwitchStatus = JNIGuidanceControl.getInstance().getVDRSwitchStatus(1);
        if (vDRSwitchStatus == 1) {
            z2 = true;
        }
        com.baidu.navisdk.module.vdr.a.b = z2;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "vdrSwitchStatustatus :" + vDRSwitchStatus);
        }
        if (TextUtils.isEmpty(com.baidu.navisdk.module.pronavi.a.o)) {
            ProNaviStatItem.O().s();
        }
        com.baidu.navisdk.util.statistic.u.n().k();
        if (!com.baidu.navisdk.j.c()) {
            p();
        }
        com.baidu.navisdk.ui.routeguide.mapmode.control.a.w();
        o();
        if (com.baidu.navisdk.j.d()) {
            com.baidu.navisdk.util.statistic.n.o().k();
            com.baidu.navisdk.module.vmsr.c.f().a(com.baidu.navisdk.framework.a.c().a());
        }
        com.baidu.navisdk.ui.routeguide.model.t.s().g();
        com.baidu.navisdk.ui.routeguide.model.d.g().c();
        if (com.baidu.navisdk.function.b.FUNC_DIY_SPEAK_MUSIC_MONITOR.a()) {
            com.baidu.navisdk.ui.routeguide.module.diyspeak.e.f.b().c();
        }
        com.baidu.navisdk.ui.routeguide.brule.a.d().a();
        com.baidu.navisdk.ui.routeguide.brule.a.d().c();
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_enter_navi"));
        com.baidu.navisdk.asr.query.a.a(com.baidu.navisdk.framework.a.c().a()).a();
        com.baidu.navisdk.module.vdr.a.f7604a = BNSettingManager.isVDRMockForDebugEnabled();
        com.baidu.navisdk.module.navifeedback.a.a();
        if (!BNCommSettingManager.getInstance().isPlayVoiceWhenCalling() && com.baidu.navisdk.util.common.c.b() && com.baidu.navisdk.module.newguide.a.e().d() && com.baidu.navisdk.module.cloudconfig.f.c().y.f7105a) {
            com.baidu.navisdk.framework.b.d(true);
            com.baidu.navisdk.util.statistic.userop.b.r().d("b.a.4", "1");
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().o0().f();
        com.baidu.navisdk.ui.routeguide.module.convoy.a.d().b();
    }

    private void G0() {
        boolean V = V();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "isEndNodeIParkType-> " + V);
        }
        if (V) {
            boolean isEnabled = BluetoothAdapter.getDefaultAdapter().isEnabled();
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "isBluetoothEnable-> enable:" + isEnabled);
            }
            if (!isEnabled) {
                r1();
            }
        }
    }

    private void H0() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(RGFSMTable.FsmParamsKey.ORIENTATION_CHANGE, true);
        boolean s2 = com.baidu.navisdk.ui.routeguide.utils.b.s();
        bundle.putBoolean(RGFSMTable.FsmParamsKey.IS_AR_NAVI, s2);
        bundle.putBoolean(RGFSMTable.FsmParamsKey.IS_NEED_EXECUTE_GLASS_FMS, !s2);
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_PORT_LAND_SCREEN_CHANGED, bundle);
    }

    private boolean I0() {
        return com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.a();
    }

    private void J0() {
        try {
            RouteGuideFSM.getInstance().setFullViewByUser(false);
            String latestMap2DOr3DState = RouteGuideFSM.getInstance().getLatestMap2DOr3DState();
            if (latestMap2DOr3DState != null && latestMap2DOr3DState.equals(RGFSMTable.FsmState.North2D)) {
                BNCommSettingManager.getInstance().setMapMode(2);
            } else if (BNCommSettingManager.getInstance().getMapMode() != 3) {
                BNCommSettingManager.getInstance().setMapMode(1);
            }
        } catch (Exception e2) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                e2.printStackTrace();
                LogUtil.printException("BNavigatorLogic", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String K0() {
        String d2 = com.baidu.navisdk.bluetooth.b.i().d();
        if (d2.length() > 30) {
            return d2.substring(0, 30) + "...";
        }
        return d2;
    }

    private void L0() {
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        a.d g2;
        if (!com.baidu.navisdk.util.common.z.b(com.baidu.navisdk.framework.a.c().a())) {
            com.baidu.navisdk.ui.routeguide.control.s.T().K();
        }
        int i3 = BNRoutePlaner.getInstance().g().e().f;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "handleFirstGuideNotification() --> entry=" + i3);
        }
        boolean isEmpty = TextUtils.isEmpty(com.baidu.navisdk.module.pronavi.a.o);
        boolean z5 = !isEmpty;
        if (i3 != 5 && i3 != 39 && i3 != 15 && i3 != 22 && i3 != 35 && i3 != 103) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (isEmpty && z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "handleFirstGuideNotification() --> isEnterWithMrsl = " + z5 + ", isDirectEntry = " + z2 + ", isDirectToNav = " + z3);
        }
        if (z3) {
            com.baidu.navisdk.ui.routeguide.model.t.s().a(true);
            Bundle bundle = new Bundle();
            ArrayList<Bundle> arrayList = new ArrayList<>();
            JNIGuidanceControl.getInstance().getNotificationYBarMsg(bundle, arrayList);
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "handleFirstGuideNotification() --> outBundle=" + bundle);
                if (arrayList.size() < 1) {
                    gVar.e("BNavigatorLogic", "handleFirstGuideNotification() --> childList invalid");
                } else {
                    Iterator<Bundle> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Bundle next = it.next();
                        com.baidu.navisdk.util.common.g.PRO_NAV.e("BNavigatorLogic", "handleFirstGuideNotification() --> childList b:" + next);
                    }
                }
            }
            if (!bundle.isEmpty() && (g2 = com.baidu.navisdk.yellowtipdata.model.a.c().g((i2 = bundle.getInt("tipId", -1)))) != null) {
                if (i2 == 48) {
                    com.baidu.navisdk.ui.routeguide.control.s.T().b(bundle);
                } else if (2 == g2.c()) {
                    com.baidu.navisdk.ui.routeguide.control.s.T().a(bundle, arrayList);
                } else if (i2 == 46) {
                    com.baidu.navisdk.ui.routeguide.model.t.s().o();
                    com.baidu.navisdk.ui.routeguide.model.t.s().a(false);
                } else if (i2 != 33 || !com.baidu.navisdk.module.pronavi.a.q) {
                    if (i2 == 3 && (!com.baidu.navisdk.j.d() || !com.baidu.navisdk.ui.routeguide.control.s.T().z())) {
                        return;
                    } else {
                        com.baidu.navisdk.ui.routeguide.control.s.T().a(bundle);
                    }
                }
            }
        }
        if (com.baidu.navisdk.module.pronavi.a.j != 2 && BNRoutePlaner.getInstance().B() && com.baidu.navisdk.module.pronavi.a.p != 1) {
            com.baidu.navisdk.ui.routeguide.control.x.b().J(true);
        }
        if (com.baidu.navisdk.module.pronavi.a.p == 9) {
            z4 = true;
        } else {
            z4 = false;
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().a(true, z4);
        if (BNCommSettingManager.getInstance().getPrefRoutPlanMode() == 2) {
            if (BNRoutePlaner.getInstance().g() != null && BNRoutePlaner.getInstance().B()) {
                com.baidu.navisdk.ui.routeguide.control.s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_rg_offline_route_plan_succeed_tips), true);
            } else if (!BNRoutePlaner.getInstance().B()) {
                com.baidu.navisdk.ui.routeguide.control.s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_rg_offline_to_online_succeed_tips), true);
            }
        } else if (com.baidu.navisdk.ui.routeguide.model.a0.C && com.baidu.navisdk.ui.routeguide.control.s.T().f() == -1) {
            com.baidu.navisdk.ui.routeguide.control.s.T().I();
            com.baidu.navisdk.ui.routeguide.model.a0.C = false;
        }
        com.baidu.navisdk.ui.routeguide.module.diyspeak.e.f.f();
        BNSettingManager.removeKey("navi_user_travel_bottom_panel_guide");
        if (b1()) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M3();
            BNCommSettingManager.getInstance().setDayNightGuideHasShow();
        }
        if (com.baidu.navisdk.module.pronavi.a.j != 2 && !this.A.i() && com.baidu.navisdk.ui.routeguide.asr.c.n().m() && BNCommSettingManager.getInstance().getFirstVoiceNotifyGuide() && n0.a(this.d, "android.permission.RECORD_AUDIO") && com.baidu.navisdk.module.cloudconfig.f.c().c.v == 0) {
            com.baidu.navisdk.ui.routeguide.control.s.T().E();
        }
        VoiceInterfaceImplProxy o2 = com.baidu.navisdk.framework.interfaces.c.p().o();
        if (o2 != null && o2.isCloudDefaultTTSSwitched() && !o2.isCloudDefaultTTSSwitchNotificationShow()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().t0().c();
        }
        if (o2 != null && com.baidu.navisdk.ui.routeguide.control.x.b().t0().a()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().V4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "handleNaviPeriodEvent->");
        }
        com.baidu.navisdk.util.worker.c.a().c(new b("handleNaviPeriodEvent", null), new com.baidu.navisdk.util.worker.e(99, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "handleNaviPeriodEventInAsync->");
        }
        com.baidu.navisdk.comapi.commontool.c.c().a(this.d, System.currentTimeMillis() / 1000);
        ProNaviStatItem.O().q();
        VoiceInterfaceImplProxy o2 = com.baidu.navisdk.framework.interfaces.c.p().o();
        if (o2 != null) {
            o2.checkSwitchDefaultVoiceForMemory();
        }
        b(false);
    }

    private boolean O0() {
        com.baidu.navisdk.framework.interfaces.lightnavi.a aVar = this.y;
        if (aVar != null && aVar.x()) {
            return true;
        }
        return false;
    }

    private void P0() {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.navisdk.bluetooth.b.i().e();
        int bluetoothChannelMode = BNCommSettingManager.getInstance().getBluetoothChannelMode();
        if (bluetoothChannelMode != 0) {
            com.baidu.navisdk.bluetooth.b.i().a(bluetoothChannelMode);
        }
        boolean f2 = com.baidu.navisdk.bluetooth.b.i().f();
        if (com.baidu.navisdk.framework.b.K()) {
            BNRouteGuider.getInstance().setBlueToothStatus(f2, BNSettingManager.getInt("BlueToothBlankRate", -1));
        }
        if (f2) {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J().f();
            com.baidu.navisdk.bluetooth.b.i().a(this.d, new o());
        }
        com.baidu.navisdk.bluetooth.b.i().a(new p());
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(com.baidu.navisdk.bluetooth.b.h, "bluetooth onCreateView : " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void Q0() {
        BNRouteGuider.getInstance().enableExpandmapDownload(BNCommSettingManager.getInstance().getPrefRealEnlargementNavi());
    }

    private void R0() {
        com.baidu.navisdk.util.logic.g.j().a(this.d);
        i();
    }

    private void S0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "time initMapView onStart");
        }
        com.baidu.navisdk.ui.routeguide.control.b.k().b();
        this.l = new com.baidu.navisdk.ui.routeguide.map.a(this, g());
        this.m = new com.baidu.navisdk.ui.routeguide.map.b(this);
        com.baidu.navisdk.ui.routeguide.control.b.k().a(this.l);
        BNMapController.getDynamicOverlay().addClickedListener(this.m);
        com.baidu.navisdk.ui.routeguide.control.b.k().a(false, false);
        com.baidu.navisdk.poisearch.c.a();
        com.baidu.navisdk.poisearch.c.b();
        com.baidu.navisdk.ui.routeguide.mapmode.subview.u.K0();
        BNMapController.getInstance().setPreFinishStatus(false);
        com.baidu.nplatform.comapi.map.j mapController = BNMapController.getInstance().getMapController();
        if (mapController != null) {
            try {
                mapController.m(BNCommSettingManager.getInstance().isAutoLevelMode());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        BNMapController.getInstance().setNightMode(!com.baidu.navisdk.ui.util.b.c());
        BNMapController.getInstance().setRedLineRender(BNCommSettingManager.getInstance().getShowCarLogoToEnd());
        if (!this.A.o()) {
            BNMapController.getInstance().setCompassVisible(BNCommSettingManager.getInstance().isShowCarDirCompass());
        }
        if (TextUtils.isEmpty(com.baidu.navisdk.module.pronavi.a.o)) {
            if (!JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(JNIGuidanceControl.getInstance().getSelectRouteIdx())) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e("BNavigatorLogic", "time initMapView clear route layer");
                }
                BNMapController.getInstance().clearLayer(10);
                BNMapController.getInstance().clearLayer(8);
                BNMapController.getInstance().clearLayer(35);
            }
        }
        NavMapManager.getInstance().setOverlookGestureEnable(true);
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e("BNavigatorLogic", "time initMapView end");
        }
    }

    private void T0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RouteGuideParams.ACTION_QUITNAVI);
        try {
            this.d.registerReceiver(this.f9031x0, intentFilter);
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "initNavQuitReceiver Exception -> " + e2);
            }
        }
    }

    private com.baidu.navisdk.util.task.a U0() {
        com.baidu.navisdk.util.task.a c2 = com.baidu.navisdk.util.task.a.c();
        c2.b(this.k0.d());
        c2.b(this.k0.f());
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        boolean z2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RouteGuide", "initLogic START");
        }
        com.baidu.navisdk.vi.b.a(this.t0, 0);
        if (!O0()) {
            com.baidu.navisdk.util.statistic.m.d().b(com.baidu.navisdk.ui.routeguide.b.V().b());
            TTSPlayerControl.clearTagMap();
        }
        if (!com.baidu.navisdk.util.logic.j.r().B) {
            com.baidu.navisdk.util.logic.j.r().n();
        }
        S();
        R();
        O();
        T0();
        if (com.baidu.navisdk.module.a.h().a() != null) {
            com.baidu.navisdk.model.modelfactory.b a2 = com.baidu.navisdk.module.a.h().a();
            int i2 = com.baidu.navisdk.module.pronavi.a.j;
            if (i2 != 1 && i2 != 5 && i2 != 6) {
                z2 = false;
            } else {
                z2 = true;
            }
            a2.d = z2;
        }
        com.baidu.navisdk.module.pronavi.model.h.c = false;
        a(false);
        P();
        BNMapController.getInstance().setNaviStatus(true);
        BNMapController.getInstance().notifyOrientation(com.baidu.navisdk.ui.routeguide.control.x.b().s2());
        o0();
        com.baidu.navisdk.i.b().a();
        h1();
        if (gVar.d()) {
            gVar.e("RouteGuide", "initLogic end");
        }
    }

    private void W0() {
        com.baidu.navisdk.ui.routeguide.utils.g gVar = this.X;
        if (gVar != null) {
            gVar.c();
        }
    }

    private void X0() {
        int i2;
        ArrayList<RoutePlanNode> k2 = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).k();
        com.baidu.navisdk.module.pronavi.model.f fVar = this.A;
        if (fVar != null) {
            i2 = fVar.f();
        } else {
            i2 = 0;
        }
        com.baidu.navisdk.comapi.commontool.c.c().a(k2, com.baidu.navisdk.module.vehiclemanager.b.i().b(), i2, com.baidu.navisdk.module.routepreference.d.j().b());
        if (2 != com.baidu.navisdk.module.pronavi.a.j) {
            com.baidu.navisdk.comapi.commontool.c.c().a(this.d, System.currentTimeMillis() / 1000);
            com.baidu.navisdk.comapi.commontool.c.c().a(this.d, com.baidu.navisdk.comapi.commontool.c.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        RouteGuideFSM.getInstance().setInitialState(RGFSMTable.FsmState.SimpleGuide);
    }

    private void Z0() {
        int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
        if (voiceMode != 2 && voiceMode != 3) {
            if (com.baidu.navisdk.ui.routeguide.b.V().b() != null && com.baidu.navisdk.util.common.d.c(com.baidu.navisdk.ui.routeguide.b.V().b()) <= 0) {
                com.baidu.navisdk.ui.routeguide.model.a0.I().s = true;
                return;
            } else if (com.baidu.navisdk.util.common.d.d()) {
                com.baidu.navisdk.ui.routeguide.model.a0.I().s = true;
                return;
            } else {
                com.baidu.navisdk.ui.routeguide.model.a0.I().s = false;
                return;
            }
        }
        com.baidu.navisdk.ui.routeguide.model.a0.I().s = true;
    }

    private void a1() {
        this.l0 = new com.baidu.navisdk.ui.routeguide.navicenter.c();
    }

    private boolean b1() {
        if (!com.baidu.navisdk.ui.routeguide.control.x.b().a2() || com.baidu.navisdk.module.dynamicui.a.f.a().d() || com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M2() || BNCommSettingManager.getInstance().containsKey(SettingParams.Key.NAVI_MODE_DAY_AND_NIGHT) || BNCommSettingManager.getInstance().isDayNightGuideHasShowed() || com.baidu.navisdk.ui.routeguide.mapmode.a.o5().r2() || com.baidu.navisdk.comapi.commontool.a.getInstance().a()) {
            return false;
        }
        if (BNCommSettingManager.getInstance().getNaviDayAndNightMode() == 2) {
            return true;
        }
        BNCommSettingManager.getInstance().setDayNightGuideHasShow();
        return false;
    }

    private boolean c1() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.y0 < ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            this.y0 = currentTimeMillis;
            return true;
        }
        this.y0 = currentTimeMillis;
        return false;
    }

    private boolean d(int i2) {
        return i2 == 5301;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new q("", null), new com.baidu.navisdk.util.worker.e(99, 0));
    }

    private boolean e(int i2) {
        return i2 == 5300;
    }

    private void e1() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "onConnectedToNotConnected --> 网络断开！！！");
        }
        com.baidu.navisdk.framework.c.b().a(18, 14);
        com.baidu.navisdk.ui.routeguide.control.s.T().K();
        com.baidu.navisdk.ui.routeguide.control.x.b().o(false);
    }

    private void f1() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "onNotConnectedToConnected --> 网络恢复！！！");
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().o(true);
        com.baidu.navisdk.ui.routeguide.control.s.T().v();
        com.baidu.navisdk.framework.c.b().a(17, 14);
        int prefRoutPlanMode = BNCommSettingManager.getInstance().getPrefRoutPlanMode();
        if (prefRoutPlanMode != 0 && prefRoutPlanMode != 2) {
            if (!com.baidu.navisdk.ui.routeguide.control.s.T().k(110) && this.k0 != null && BNRoutePlaner.getInstance().B()) {
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.h(), true);
                this.F = 2;
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "onNotConnectedToConnected --> 恢复网络，开始自动重算!!!");
                    TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "测试toast: 恢复网络，开始第" + (3 - this.F) + "次重算!!!");
                }
                BNRouteGuider.getInstance().calcOtherRoute(4);
                com.baidu.navisdk.util.worker.c.a().a(this.k0.h(), new com.baidu.navisdk.util.worker.e(2, 0), 60000L);
                return;
            }
            return;
        }
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "onNotConnectedToConnected --> 完全离线或者离线算路优先不会在网络恢复时转在线！！！");
        }
    }

    private void g1() {
        com.baidu.navisdk.module.pronavi.model.f fVar = this.A;
        if (fVar != null && fVar.m()) {
            Bundle bundle = new Bundle();
            boolean routeDrivingInfo = BNRouteGuider.getInstance().getRouteDrivingInfo(bundle);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "refreshNeRemainMileage: " + routeDrivingInfo + "," + bundle);
            }
            long j2 = 0;
            if (bundle.containsKey(xOxOoo.f15470o00)) {
                long j3 = bundle.getLong(xOxOoo.f15470o00, -1L);
                if (j3 >= 0) {
                    j2 = (int) j3;
                }
            }
            if (j2 >= 1000) {
                BNSettingManager.setNewEnergyRemainMileage(com.baidu.navisdk.module.routeresult.logic.plate.a.b().b(I()).a().f7484a);
            }
        }
    }

    private void h1() {
        UsbListener.a(this.d);
        UsbListener.a(this.s0);
        BatteryStatusReceiver.a(this.d);
        RingModeStatusReceiver.a(this.d);
    }

    private void i1() {
        com.baidu.nplatform.comapi.basestruct.b mapStatus = BNMapController.getInstance().getMapStatus();
        if (mapStatus != null) {
            mapStatus.i = 0L;
            mapStatus.j = 0L;
            mapStatus.n = 0.0f;
            mapStatus.m = 0.0f;
            BNMapController.getInstance().setMapStatus(mapStatus, j.b.eAnimationNone, -1, true);
        }
    }

    private void j1() {
        String a2 = BNRoutePlaner.getInstance().a("", "");
        com.baidu.navisdk.util.statistic.t.u().c(a2);
        ProNaviStatItem.O().d(a2);
        com.baidu.navisdk.util.statistic.userop.b.r().d(a2);
    }

    private void k1() {
        com.baidu.navisdk.ui.routeguide.model.a0.I().E();
        com.baidu.navisdk.ui.routeguide.model.g.h().f();
        com.baidu.navisdk.module.pronavi.model.g.o().m();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().B3();
        com.baidu.navisdk.poisearch.model.b.m().l();
        com.baidu.navisdk.poisearch.model.a.k().i();
        com.baidu.navisdk.ui.routeguide.model.m.y().w();
        com.baidu.navisdk.ui.routeguide.navicenter.a aVar = this.x;
        if (aVar != null) {
            aVar.d();
            this.x = null;
        }
        com.baidu.navisdk.ui.routeguide.model.l.f().e();
        com.baidu.navisdk.ui.routeguide.model.j.e().d();
    }

    private void l1() {
        com.baidu.navisdk.ui.routeguide.control.b.k().a(true, true);
        if (this.l != null) {
            com.baidu.navisdk.ui.routeguide.control.b.k().b(this.l);
            this.l = null;
        }
        if (this.m != null) {
            BNMapController.getDynamicOverlay().removeClickedListener(this.m);
            this.m = null;
        }
        BNMapController.getInstance().setPreFinishStatus(false);
    }

    private void m1() {
        VDeviceAPI.setScreenAlwaysOn(false);
    }

    private void n1() {
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("XDVoice", "hud show, not restore");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().q2()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("XDVoice", "menu more show, not restore");
                return;
            }
            return;
        }
        if (!com.baidu.navisdk.framework.b.V()) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("XDVoice", "stack not empty, not restore");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().L2()) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("XDVoice", "ugc report is visibility, not restore");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.control.i.g().c(1009)) {
            com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar5.d()) {
                gVar5.e("XDVoice", "plate setting is visibility, not restore");
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.asr.c.n().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        Handler handler = this.s0;
        if (handler != null) {
            handler.removeMessages(10971);
            this.s0.sendEmptyMessageDelayed(10971, 60000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p1() {
        if (this.s0 == null || !com.baidu.navisdk.module.pronavi.a.n || !com.baidu.navisdk.module.pronavi.model.i.f().c() || BNRoutePlaner.getInstance().d() == 22 || O0()) {
            return false;
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "shouldShowStartAnimation true");
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1() {
        if (2 != com.baidu.navisdk.module.pronavi.a.j && !BNRoutePlaner.getInstance().B() && !com.baidu.navisdk.ui.routeguide.control.x.b().r2() && !com.baidu.navisdk.ui.routeguide.control.x.b().t2() && !com.baidu.navisdk.ui.routeguide.control.x.b().Y1() && !com.baidu.navisdk.ui.routeguide.control.x.b().M2() && !com.baidu.navisdk.module.dynamicui.a.f.a().d() && com.baidu.navisdk.ui.routeguide.b.V().C() && com.baidu.navisdk.ui.routeguide.control.x.b().s2() && BNCommSettingManager.getInstance().getFirstGuide(SettingParams.FirstGuideKey.LONG_TUNNEL_TIPS, true)) {
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getRouteInfoInUniform(21, 0, bundle);
            boolean z2 = bundle.getBoolean("bHasLongTunnel", false);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "handleFirstGuideNotification-> hasLongTunnel=" + z2);
            }
            if (z2 && com.baidu.navisdk.j.d()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().F4();
                BNCommSettingManager.getInstance().saveFirstGuide(SettingParams.FirstGuideKey.LONG_TUNNEL_TIPS, false);
            }
        }
    }

    private void r1() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "showOpenBluetoothNotification->");
        }
        if (!com.baidu.navisdk.ui.routeguide.control.s.T().b(129)) {
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "showOpenBluetoothNotification allowOperableNotificationShow return false!");
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().k(129).D(100).d(JarUtils.getResources().getDrawable(R.drawable.nsdk_notification_indoor_park_bluetooth_icon)).a("终点支持蓝牙定位停车场导航，是否现在开启蓝牙?").z(2).v(20000).y(false).A(false).g("去设置").f("知道了").a(new t()).y();
    }

    public static /* synthetic */ int s(BNavigatorLogic bNavigatorLogic) {
        int i2 = bNavigatorLogic.F;
        bNavigatorLogic.F = i2 - 1;
        return i2;
    }

    private void s1() {
        if (this.A.l == 1 && this.L != null) {
            if (this.J == null) {
                this.J = new r();
            }
            this.L.postDelayed(this.J, 600L);
        }
        this.A.l = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "startBluetoothSetting->");
        }
        com.baidu.navisdk.framework.a.c().b().startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u1() {
        if (!O0()) {
            this.Y = true;
        }
        this.N = BNRouteGuider.getInstance().startRouteGuide(this.Y, com.baidu.navisdk.module.pronavi.a.p);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.e()) {
            gVar.g("BNavigatorLogic", "startRouteGuide: mIsStartRouteGuideSuc --> " + this.N);
        }
        BNRoutePlaner.getInstance().p(2);
        com.baidu.navisdk.ui.routeguide.control.x.b().o0().o();
        com.baidu.navisdk.naviresult.a.d().a().b(false);
        if (this.N) {
            this.Y = false;
        }
        return this.N;
    }

    private void v1() {
        BNRouteGuider.getInstance().stopRouteGuide();
        com.baidu.navisdk.ugc.interaction.c.a().a(2);
        BNRoutePlaner.getInstance().p(10);
    }

    private void w1() {
        int i2 = com.baidu.navisdk.module.pronavi.a.j;
        if (i2 != 1 && i2 != 5) {
            return;
        }
        Activity b2 = com.baidu.navisdk.ui.routeguide.b.V().b();
        if (b2 == null) {
            b2 = com.baidu.navisdk.framework.a.c().b();
        }
        if (b2 != null && this.p0 != null) {
            b2.getContentResolver().unregisterContentObserver(this.p0);
        }
    }

    private void x1() {
        com.baidu.navisdk.framework.message.a.a().a(this.f9030o0);
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.f A() {
        if (this.v == null) {
            synchronized (this) {
                try {
                    if (this.v == null) {
                        this.v = new com.baidu.navisdk.ui.routeguide.navicenter.impl.a();
                    }
                } finally {
                }
            }
        }
        return this.v;
    }

    public void A0() {
        com.baidu.navisdk.ui.routeguide.utils.g gVar = this.X;
        if (gVar != null) {
            gVar.b();
            this.X = null;
        }
    }

    public com.baidu.navisdk.module.pronavi.model.f B() {
        return this.A;
    }

    public void B0() {
        try {
            BNRouteGuider.getInstance().setGpsStatusListener(null);
            BNRouteGuider.getInstance().setOnRGInfoListener(null);
            BNRouteGuider.getInstance().setRGSubStatusListener(null);
        } catch (Throwable unused) {
        }
    }

    public com.baidu.navisdk.ui.routeguide.pip.b C() {
        return this.I;
    }

    public void C0() {
        if (Build.VERSION.SDK_INT >= 23) {
            return;
        }
        Activity b2 = com.baidu.navisdk.ui.routeguide.b.V().b();
        if (b2 == null) {
            b2 = com.baidu.navisdk.framework.a.c().b();
        }
        if (b2 != null && this.j0 != null && b2.getContentResolver() != null) {
            b2.getContentResolver().unregisterContentObserver(this.j0);
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.g(), false);
    }

    public com.baidu.navisdk.ui.routeguide.subview.a D() {
        return this.s;
    }

    public void D0() {
        int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
        if (voiceMode == 3) {
            com.baidu.navisdk.ui.routeguide.module.diyspeak.e.f.b(voiceMode);
            return;
        }
        if (voiceMode == 2) {
            com.baidu.navisdk.ui.routeguide.module.diyspeak.e.f.b(voiceMode);
            return;
        }
        com.baidu.navisdk.ui.routeguide.module.diyspeak.e eVar = com.baidu.navisdk.ui.routeguide.module.diyspeak.e.f;
        int c2 = eVar.c();
        if (c2 == 6) {
            eVar.a(c2, BNCommSettingManager.getInstance().getDiyCustomModeValue());
        } else {
            eVar.b(c2);
        }
    }

    public int E() {
        return this.A.d();
    }

    public int F() {
        return com.baidu.navisdk.module.vehiclemanager.b.i().a();
    }

    public com.baidu.navisdk.ui.routeguide.navicenter.impl.d G() {
        if (this.u == null) {
            synchronized (this) {
                try {
                    if (this.u == null) {
                        this.u = new com.baidu.navisdk.ui.routeguide.navicenter.impl.d(this);
                    }
                } finally {
                }
            }
        }
        return (com.baidu.navisdk.ui.routeguide.navicenter.impl.d) this.u;
    }

    @Nullable
    public com.baidu.navisdk.framework.interfaces.y[] H() {
        if (g() != null) {
            return g().m();
        }
        return null;
    }

    public int I() {
        return com.baidu.navisdk.module.vehiclemanager.b.i().b();
    }

    public ViewModelStore J() {
        return this.f;
    }

    public void K() {
        com.baidu.navisdk.ui.routeguide.model.i.s().r();
        com.baidu.navisdk.ui.routeguide.control.x.b().j();
    }

    public boolean L() {
        return this.a0;
    }

    public boolean M() {
        return this.Z;
    }

    public void N() {
        com.baidu.navisdk.module.pronavi.model.i.f().b = false;
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().k(true);
        BNMapController.getInstance().recoveryHighLightRoute();
    }

    public void O() {
        int i2 = com.baidu.navisdk.module.pronavi.a.j;
        if ((i2 == 1 || i2 == 5) && com.baidu.navisdk.ui.routeguide.b.V().b() != null) {
            if (this.p0 == null) {
                this.p0 = new g(new f(this));
            }
            Uri uriFor = Settings.Secure.getUriFor("location_providers_allowed");
            if (uriFor != null && com.baidu.navisdk.ui.routeguide.b.V().b().getContentResolver() != null) {
                try {
                    com.baidu.navisdk.ui.routeguide.b.V().b().getContentResolver().registerContentObserver(uriFor, false, this.p0);
                } catch (Exception unused) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("BNavigatorLogic", "registerContentObserver Exception");
                    }
                }
            }
        }
    }

    public void P() {
        if (Build.VERSION.SDK_INT < 23 && com.baidu.navisdk.ui.routeguide.b.V().b() != null) {
            if (this.j0 == null) {
                this.j0 = new i(new h(this));
            }
            if (com.baidu.navisdk.ui.routeguide.b.V().b() != null && com.baidu.navisdk.ui.routeguide.b.V().b().getContentResolver() != null) {
                com.baidu.navisdk.ui.routeguide.b.V().b().getContentResolver().registerContentObserver(Settings.Secure.getUriFor("mock_location"), false, this.j0);
            }
        }
    }

    public void Q() {
        int i2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "time initOnBGThread onStart");
        }
        com.baidu.navisdk.util.statistic.i.f9373a = SystemClock.elapsedRealtime();
        BNSettingManager.setQuitForExceptionInNaviMode(true);
        if (com.baidu.navisdk.function.b.FUNC_BLUETOOTH_SOUND.a()) {
            P0();
        }
        BNRoutePlaner.getInstance().a(new j(this));
        if (this.A.o()) {
            BNMapController.getInstance().setStrategyVisible(true);
            BNRouteGuider.getInstance().setNaviMode(4);
        } else {
            BNRouteGuider.getInstance().setNaviMode(1);
        }
        BNMapController.getInstance().showTrafficMap(BNCommSettingManager.getInstance().isRoadCondOnOrOff(), false);
        Z0();
        com.baidu.navisdk.s.c();
        X0();
        j1();
        ProNaviStatItem.O().f(com.baidu.navisdk.module.pronavi.a.p);
        int e2 = this.A.e();
        if (e2 == 3) {
            ProNaviStatItem.O().c(2);
        } else if (e2 == 4) {
            ProNaviStatItem.O().c(3);
        } else if (e2 == 5) {
            ProNaviStatItem.O().c(4);
        } else if (e2 == 7) {
            ProNaviStatItem.O().c(5);
        } else {
            ProNaviStatItem.O().c(0);
        }
        com.baidu.navisdk.util.common.n.d().b(100);
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.1.1", com.baidu.navisdk.util.common.y.a(this.d) + "", null, null);
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            BNRouteGuider.getInstance().updateInstantConfigParams(true, com.baidu.navisdk.module.pronavi.model.i.h, 1);
        }
        if (O0()) {
            ProNaviStatItem.O().n(8);
        } else {
            com.baidu.navisdk.ugc.report.data.datarepository.g.c().a();
            ProNaviStatItem O = ProNaviStatItem.O();
            if (2 == com.baidu.navisdk.module.pronavi.a.j) {
                i2 = 9;
            } else {
                i2 = 1;
            }
            O.n(i2);
        }
        Q0();
        if (com.baidu.navisdk.module.offscreen.a.g) {
            com.baidu.navisdk.module.offscreen.a.m().g();
        }
        if (2 == com.baidu.navisdk.module.pronavi.a.j) {
            BNMapController.getInstance().setAnimationGlobalSwitch(true);
        }
        com.baidu.navisdk.util.common.n.d().b(30);
        RGScreenStatusReceiver.a(this.d);
        com.baidu.navisdk.ui.routeguide.model.q.d().a(false);
        R0();
        W0();
        if (com.baidu.navisdk.module.cloudconfig.a.b().b("set_rgc_cen_freq", true)) {
            if (T()) {
                com.baidu.navisdk.framework.b.j(2);
            } else {
                com.baidu.navisdk.framework.b.j(1);
            }
        }
        com.baidu.navisdk.ui.routeguide.tts.a.a().a(this.d, com.baidu.navisdk.function.b.FUNC_SUPPORT_TTS_VOLUME_INCREASE.a());
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "time initOnBGThread onStart end");
        }
    }

    public void R() {
        boolean z2;
        int i2 = com.baidu.navisdk.module.pronavi.a.j;
        if (i2 != 1 && i2 != 5) {
            if (i2 == 2) {
                BNRouteGuider.getInstance().setLocateMode(2);
            }
        } else {
            BNRouteGuider.getInstance().setLocateMode(1);
        }
        D0();
        com.baidu.navisdk.ui.routeguide.utils.b.B();
        if (!com.baidu.navisdk.ui.routeguide.utils.b.s() && !this.A.h()) {
            z2 = false;
        } else {
            z2 = true;
        }
        com.baidu.navisdk.ui.routeguide.utils.b.e(z2);
        BNRoutePlaner.getInstance().a(this.n, true);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.baidu.navisdk.pronavi.ui.base.b, com.baidu.navisdk.pronavi.base.a] */
    public void S() {
        com.baidu.navisdk.j.d();
        this.q = new com.baidu.navisdk.ui.routeguide.navicenter.impl.f(this);
        this.o = new com.baidu.navisdk.ui.routeguide.navicenter.impl.g(this);
        this.p = new com.baidu.navisdk.ui.routeguide.navicenter.impl.i(this);
        BNRouteGuider.getInstance().setGpsStatusListener(this.q);
        BNRouteGuider.getInstance().setOnRGInfoListener(this.o);
        BNRouteGuider.getInstance().setRGSubStatusListener(this.p);
        if (g() != null) {
            BNRouteGuider.getInstance().setMessageDispatcher(g().b().s());
            BNRouteGuider.getInstance().setRGNaviSubStatus(g());
        }
    }

    public boolean T() {
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            return true;
        }
        return false;
    }

    public boolean U() {
        return this.i;
    }

    public boolean V() {
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null && fVar.g() != null) {
            return com.baidu.navisdk.util.common.h.c(fVar.g().getParkType());
        }
        return false;
    }

    public boolean W() {
        return this.A.i();
    }

    public boolean X() {
        return this.A.k();
    }

    public boolean Y() {
        return this.B;
    }

    public boolean Z() {
        return this.g0;
    }

    @Override // com.baidu.navisdk.pageframe.a, com.baidu.navisdk.framework.interfaces.i
    public void a(Context context, Bundle bundle) {
    }

    public boolean a0() {
        return this.I.c();
    }

    public boolean b0() {
        String str = com.baidu.navisdk.module.cloudconfig.f.c().c.I;
        if (!l0.c(str) && str.contains(Build.MODEL)) {
            return true;
        }
        return false;
    }

    public boolean c0() {
        return this.k;
    }

    public boolean d0() {
        boolean judgeRouteInfoAllReady;
        if (!TextUtils.isEmpty(com.baidu.navisdk.module.pronavi.a.o)) {
            judgeRouteInfoAllReady = JNIGuidanceControl.getInstance().isBuildRouteReady(false, com.baidu.navisdk.module.pronavi.a.o);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.e()) {
                gVar.g("BNavigatorLogic", "isRoutePlanReady: 二片 --> isReady: " + judgeRouteInfoAllReady);
            }
        } else {
            judgeRouteInfoAllReady = JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(JNIGuidanceControl.getInstance().getSelectRouteIdx());
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.e()) {
                gVar2.g("BNavigatorLogic", "isRoutePlanReady: 全量 --> isReady: " + judgeRouteInfoAllReady);
            }
        }
        return judgeRouteInfoAllReady;
    }

    public boolean e0() {
        return this.N;
    }

    public boolean f0() {
        return this.j;
    }

    public boolean g0() {
        return this.H;
    }

    public void h0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "jumpWhenRoutePlanFail");
        }
        m0();
        if (this.r != null) {
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new x("jumpWhenRoutePlanFail-" + BNavigatorLogic.class.getSimpleName(), null), new com.baidu.navisdk.util.worker.e(2, 0));
        }
    }

    public void i0() {
        boolean z2;
        if (com.baidu.navisdk.ui.routeguide.b.V().k() != null && com.baidu.navisdk.ugc.report.data.datarepository.g.c().b() && !com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k()) {
            this.C = true;
            com.baidu.navisdk.framework.interfaces.pronavi.j k2 = com.baidu.navisdk.ui.routeguide.b.V().k();
            this.D = n();
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                if (k2 != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                gVar.e("BNavigatorLogic", String.format("naviQuitCheck: %s, endRecordOk: %s, hasUgcDynamicMark: %s", Boolean.valueOf(z2), Boolean.valueOf(this.D), Boolean.valueOf(com.baidu.navisdk.ugc.report.data.datarepository.g.c().b())));
            }
            if (this.D) {
                v1();
                this.b0 = false;
                com.baidu.navisdk.ui.routeguide.control.x.b().k4();
                return;
            }
        } else if (com.baidu.navisdk.naviresult.a.d().a(com.baidu.navisdk.comapi.trajectory.j.TRAJECTORY_FROM_NAVI, com.baidu.navisdk.comapi.trajectory.i.END_RECORD_REASON_OTHER)) {
            this.C = true;
            this.D = n();
        } else {
            this.E = true;
            this.C = true;
            this.D = false;
        }
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.s;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    public void j0() {
        if (com.baidu.navisdk.ui.util.g.a()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "onClickCarLogo: isFastDoubleClick");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("BNavigatorLogic", "onClickCarLogo: ");
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c cVar = this.l0;
        if (cVar != null) {
            cVar.a().c();
        }
    }

    public void k0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "onNavPageToBackground -> ");
        }
        this.k = false;
        com.baidu.navisdk.asr.d.B().a(1);
        com.baidu.navisdk.ui.routeguide.asr.c.n().c(true);
        com.baidu.navisdk.module.powersavemode.f.o().onBackground();
        com.baidu.navisdk.ui.routeguide.control.x.b().h3();
        com.baidu.navisdk.ui.routeguide.utils.g gVar2 = this.X;
        if (gVar2 != null) {
            gVar2.e();
        }
    }

    public void l0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("XDVoice", "playOpeningFromVoiceIfNeeded");
        }
        Bundle bundle = new Bundle();
        BNRouteGuider.getInstance().getRouteInfoInUniform(4, 3, bundle);
        String string = bundle.getString("usWayRoadName");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        TTSPlayerControl.addTTSPlayStateListener(new m(this));
        TTSPlayerControl.playTTS(string, 1);
        TTSPlayerControl.setStopVoiceOutput(true);
        com.baidu.navisdk.util.worker.c.a().a(new n(this, "playOpeningFromVoiceIfNeeded", null), new com.baidu.navisdk.util.worker.e(200, 0), 5000L);
    }

    public void m0() {
        a(3, false, (Bundle) null);
    }

    public void n0() {
        SDKDebugFileUtil.get(SDKDebugFileUtil.NAVING_FLPLOC_FILENAME).add("reAddGpsLocation");
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.i(), false);
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) this.k0.i(), new com.baidu.navisdk.util.worker.e(2, 0));
    }

    public void o0() {
        com.baidu.navisdk.framework.message.a.a().b(this.f9030o0, com.baidu.navisdk.framework.message.bean.o.class, new Class[0]);
        com.baidu.navisdk.framework.message.a.a().a(this.f9030o0, com.baidu.navisdk.framework.message.bean.p.class, new Class[0]);
        com.baidu.navisdk.framework.message.a.a().a(this.f9030o0, com.baidu.navisdk.framework.message.bean.w.class, new Class[0]);
        j(com.baidu.navisdk.util.common.z.f9254a);
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onActivityResult(int i2, int i3, Intent intent) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "onActivityResult: " + i2 + "," + i3);
        }
        if (i2 != 4104 && i2 != 3001 && i2 != 3006) {
            if (i2 == 4101) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(i2, i3, intent);
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().g(i2)) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().c(i2, i3, intent);
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().h(i2)) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().d(i2, i3, intent);
                return;
            }
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f(i2)) {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().b(i2, i3, intent);
                return;
            }
            if (i2 == 4102) {
                com.baidu.navisdk.ui.routeguide.asr.a.a(i2);
                return;
            }
            if (i2 == 4108) {
                com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().s();
                return;
            }
            if (i2 == 4109) {
                if (i3 == -1 && intent != null) {
                    com.baidu.navisdk.util.logic.n.a(com.baidu.navisdk.framework.a.c().b()).a(intent.getData());
                    return;
                }
                return;
            }
            if (g() != null) {
                g().a(i2, i3, intent);
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(i2, i3, intent);
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onConfigurationChanged(Configuration configuration) {
        if (c() != null) {
            ScreenUtil.getInstance().init(c());
        }
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        Configuration a2 = aVar.a(configuration, c());
        if (aVar.h()) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().a(c());
        }
        a(a2, true);
    }

    @Override // com.baidu.navisdk.pageframe.a, com.baidu.navisdk.framework.interfaces.i
    public void onDestroy() {
        FrameLayout frameLayout;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "BNavigatorLogic onDestroy: " + com.baidu.navisdk.module.vehiclemanager.b.i().b());
        }
        this.d0 = false;
        this.k = false;
        Runnable runnable = this.J;
        if (runnable != null && (frameLayout = this.L) != null) {
            frameLayout.removeCallbacks(runnable);
        }
        RouteGuideFSM.getInstance().setUiState(null);
        super.onDestroy();
        A0();
        a(c(), false);
        com.baidu.navisdk.skyeye.a.n().e();
        com.baidu.navisdk.ui.routeguide.control.a.d().a();
        com.baidu.navisdk.ui.routeguide.asr.a.b();
        com.baidu.navisdk.bluetooth.b.i().g();
        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().t();
        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().x();
        BNRouteGuider.getInstance().setMessageDispatcher(null);
        BNRouteGuider.getInstance().setRGNaviSubStatus(null);
        com.baidu.navisdk.ui.routeguide.control.x.a();
        com.baidu.navisdk.ui.routeguide.control.b.i();
        RouteGuideFSM.destory();
        com.baidu.navisdk.module.pronavi.a.a();
        com.baidu.navisdk.ui.routeguide.model.y.b();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().A3();
        com.baidu.navisdk.ui.routeguide.ace.a.m().k();
        this.I.d();
        com.baidu.navisdk.util.logic.n.a(this.d).a();
        com.baidu.navisdk.pronavi.util.a.h.j();
        B0();
        z0();
        this.s0.removeMessages(10961);
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "removeNaviPeriodMsg->");
        }
        this.s0.removeMessages(10971);
        this.s0.removeMessages(10931);
        this.s0.removeMessages(10951);
        this.s0 = null;
        this.L = null;
        com.baidu.navisdk.util.common.u.a(this);
        com.baidu.navisdk.util.common.u.b();
        com.baidu.navisdk.framework.interfaces.locationshare.a j2 = com.baidu.navisdk.framework.interfaces.c.p().j();
        if (j2 != null && com.baidu.navisdk.j.d()) {
            j2.g();
        }
        com.baidu.navisdk.framework.c.b().a();
        com.baidu.navisdk.function.c.a(com.baidu.navisdk.q.a(1));
        s().h();
        com.baidu.navisdk.ui.routeguide.module.convoy.a.d().a();
        this.e = null;
        this.f = null;
        com.baidu.navisdk.skyeye.b.a().b(new com.baidu.navisdk.skyeye.event.f(16));
        com.baidu.navisdk.framework.message.a.a().d(new com.baidu.navisdk.skyeye.event.f(16));
    }

    @Override // com.baidu.navisdk.pageframe.a, com.baidu.navisdk.framework.interfaces.i
    public void onPause() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "onPause: " + com.baidu.navisdk.module.vehiclemanager.b.i().b());
        }
        super.onPause();
        this.j = false;
        com.baidu.navisdk.ui.routeguide.utils.g gVar2 = this.X;
        if (gVar2 != null) {
            gVar2.g();
        }
        com.baidu.navisdk.skyeye.a.n().e();
        com.baidu.navisdk.ui.routeguide.control.x.b().i3();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().o0().k();
        com.baidu.navisdk.ui.routeguide.asr.c.n().a();
    }

    @Override // com.baidu.navisdk.pageframe.a, com.baidu.navisdk.framework.interfaces.i
    public void onResume() {
        com.baidu.navisdk.util.task.a aVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("RouteGuide", "onResume START: " + com.baidu.navisdk.module.vehiclemanager.b.i().b());
        }
        boolean z2 = true;
        this.j = true;
        this.b0 = true;
        if (com.baidu.navisdk.ui.routeguide.b.V().b() != null && !com.baidu.navisdk.ui.routeguide.b.V().b().isFinishing()) {
            super.onResume();
            com.baidu.navisdk.ui.routeguide.utils.g gVar2 = this.X;
            if (gVar2 != null) {
                gVar2.h();
            }
            if (L()) {
                a(com.baidu.navisdk.pronavi.util.a.h.a(c().getResources().getConfiguration(), c()), false);
                if (com.baidu.navisdk.module.offscreen.a.g && com.baidu.navisdk.module.offscreen.a.h) {
                    BNMapController.getInstance().onPause();
                }
                BNRoutePlaner.getInstance().a(this.n, true);
            }
            com.baidu.navisdk.module.powersavemode.f.o().onResume();
            com.baidu.navisdk.ui.routeguide.control.x.b().k3();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().o0().l();
            JNIGuidanceControl.getInstance().setGroundMode(2);
            if (this.O && (aVar = this.w) != null) {
                aVar.b();
            }
            com.baidu.navisdk.skyeye.a.n().j();
            n1();
            if (com.baidu.navisdk.j.d()) {
                com.baidu.navisdk.module.vmsr.c.f().a();
            }
            if (2 == com.baidu.navisdk.module.pronavi.a.j) {
                com.baidu.navisdk.ui.routeguide.asr.c.n().b(7, false);
            }
            try {
                int streamVolume = ((AudioManager) c().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getStreamVolume(3);
                com.baidu.navisdk.ui.routeguide.mapmode.a o5 = com.baidu.navisdk.ui.routeguide.mapmode.a.o5();
                if (streamVolume > 0) {
                    z2 = false;
                }
                o5.U(z2);
            } catch (Exception e2) {
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar3.d()) {
                    gVar3.e("BNavigatorLogic", "getStreamVolume Exception: " + e2.getMessage());
                }
            }
            if (!this.O && !com.baidu.navisdk.j.d() && !com.baidu.navisdk.ui.routeguide.model.a0.I().t()) {
                LogUtil.out("BNavigatorLogic", "gps not fix: reAddGpsLocation");
                n0();
            }
            this.O = false;
            s1();
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("RouteGuide", "onResume end");
            }
            com.baidu.navisdk.module.perform.b.d().c("pro_navi_page_resume_end");
        }
    }

    @Override // com.baidu.navisdk.pageframe.a, com.baidu.navisdk.framework.interfaces.i
    public void onStart() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("BNavigatorLogic", "BNavigator.onStart():" + com.baidu.navisdk.module.vehiclemanager.b.i().b());
        }
        this.U = SystemClock.elapsedRealtime();
        super.onStart();
        ProNaviStatItem.O().u();
        VDeviceAPI.setScreenAlwaysOn(true);
        this.i = false;
        com.baidu.navisdk.comapi.commontool.c.c().c(this.d);
    }

    @Override // com.baidu.navisdk.pageframe.a, com.baidu.navisdk.framework.interfaces.i
    public void onStop() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "BNavigator.onStop(): " + com.baidu.navisdk.module.vehiclemanager.b.i().b());
        }
        if (z0 && this.b0 && L() && 2 != BNCommSettingManager.getInstance().getVoiceMode() && 3 != BNCommSettingManager.getInstance().getVoiceMode() && BNCommSettingManager.getInstance().isPlayBackgroundSpeak()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!this.T || elapsedRealtime - this.U > 60000) {
                this.T = true;
                if (!com.baidu.navisdk.j.d()) {
                    TTSPlayerControl.playTTS("百度导航持续为您服务", 0);
                } else {
                    TTSPlayerControl.playTTS("<usraud>百度地图将持续为您导航</usraud>", 0);
                }
                BNCommSettingManager.getInstance().setPlayBackgroundSpeak(false);
            }
            this.U = elapsedRealtime;
        }
        ProNaviStatItem.O().t();
        VDeviceAPI.setScreenAlwaysOn(false);
        com.baidu.navisdk.module.powersavemode.f.o().onStop();
        this.i = true;
        com.baidu.navisdk.ugc.dialog.h.i();
        com.baidu.navisdk.comapi.commontool.c.c().b(this.d);
        com.baidu.navisdk.ui.routeguide.control.x.b().m3();
        super.onStop();
    }

    public void p0() {
        if (this.f0) {
            this.f0 = false;
            com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.c(), false);
            com.baidu.navisdk.ui.routeguide.model.g.h().c(false);
        }
    }

    public void q0() {
        com.baidu.navisdk.util.logic.f fVar = this.Q;
        if (fVar != null) {
            fVar.b(this.u0);
            this.Q.i();
        }
    }

    public void r0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "removeOpenBTSCOMessages");
        }
        Handler handler = this.s0;
        if (handler != null) {
            handler.removeMessages(ErrorCode.MSP_ERROR_TUV_GETHIDPARAM);
        }
    }

    public void s0() {
        com.baidu.navisdk.module.vdr.a.b(this.v0);
    }

    public void t0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "resetNaviData");
        }
        this.c0 = false;
        k1();
        com.baidu.navisdk.module.navisafeguard.a.c().b();
    }

    public void u0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "resetWithReCalcRoute");
        }
        com.baidu.navisdk.ui.routeguide.model.a0.C = true;
        com.baidu.navisdk.ui.routeguide.model.a0.D = false;
    }

    public void v0() {
        if (this.X == null && !com.baidu.navisdk.module.pronavi.a.s) {
            com.baidu.navisdk.ui.routeguide.utils.g gVar = new com.baidu.navisdk.ui.routeguide.utils.g(c());
            this.X = gVar;
            gVar.c();
            this.X.h();
        }
    }

    public void w0() {
        com.baidu.navisdk.comapi.commontool.a.getInstance().addObserver(this.w0);
    }

    public boolean x0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "time startNaviReally onStart");
        }
        this.d0 = true;
        this.G = System.currentTimeMillis();
        if (com.baidu.navisdk.module.abtest.model.d.s() != null) {
            com.baidu.navisdk.module.abtest.model.d.s().a(0, 2);
        }
        com.baidu.navisdk.ui.routeguide.model.a0.C = true;
        if (!O0()) {
            com.baidu.navisdk.module.pronavi.model.h.d = false;
            com.baidu.navisdk.module.pronavi.model.h.e = false;
        }
        this.s0.removeMessages(10931);
        this.s0.sendEmptyMessageDelayed(10931, 30000L);
        if (!com.baidu.navisdk.j.c()) {
            this.s0.removeMessages(10961);
            this.s0.sendEmptyMessageDelayed(10961, 10000L);
        }
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "sendNaviPeriodMsg->");
        }
        o1();
        com.baidu.navisdk.ui.routeguide.control.x.b().i();
        com.baidu.navisdk.ui.routeguide.control.x.b().v(0);
        com.baidu.navisdk.ui.routeguide.control.x.b().A(BNCommSettingManager.getInstance().getVoiceMode());
        d().j().e("BNRoadConditionService").a(1).a();
        com.baidu.navisdk.ui.routeguide.control.x.b().b5();
        com.baidu.navisdk.ui.routeguide.model.y.d();
        L0();
        m();
        w0();
        if (!com.baidu.navisdk.j.c()) {
            BNPowerSaver.getInstance().a(com.baidu.navisdk.ui.routeguide.b.V().b());
            if (BNCommSettingManager.getInstance().getPowerSaveMode() != 2) {
                com.baidu.navisdk.module.powersavemode.f.o().c();
            }
        }
        com.baidu.navisdk.ui.routeguide.c.g().a(false);
        f0.d().b(505);
        if (this.z == null) {
            this.z = new com.baidu.navisdk.ui.routeguide.heatmonitor.j();
        }
        if (!T()) {
            this.z.b();
        }
        if (this.A.l()) {
            i(1);
        }
        com.baidu.navisdk.ui.routeguide.ace.a.m().j();
        com.baidu.navisdk.module.perform.b.d().c("sdk_routeguide_start_nav_really");
        return true;
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.j y() {
        return this.i0;
    }

    public void y0() {
        a0 a0Var;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "stopCarLocCountDown()");
        }
        if (this.s0 != null && (a0Var = this.k0) != null && a0Var.b() != null) {
            try {
                this.s0.removeCallbacks(this.k0.b());
            } catch (Exception unused) {
            }
        }
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.i z() {
        if (this.t == null) {
            synchronized (this) {
                try {
                    if (this.t == null) {
                        this.t = new com.baidu.navisdk.ui.routeguide.navicenter.impl.b(this);
                    }
                } finally {
                }
            }
        }
        return this.t;
    }

    public void z0() {
        com.baidu.navisdk.comapi.commontool.a.getInstance().deleteObserver(this.w0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("BNavigatorLogic", "networkChange " + i2);
        }
        j(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z2) {
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.C) {
            BNInflaterFactory.getInstance().updateStyle(z2);
            boolean z3 = !z2;
            BNMapController.getInstance().setNightMode(z3);
            com.baidu.navisdk.ui.routeguide.control.x.b().p(z2);
            if (g() != null) {
                g().a(z2);
            }
            com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b b2 = com.baidu.navisdk.ui.routeguide.utils.b.b(false);
            if (b2 != null) {
                b2.c(z3);
            }
        }
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("BNavigatorLogic", "onDayNightChanged isDay:" + z2 + ", tmpIsDay :" + com.baidu.navisdk.ui.util.b.b());
        }
    }

    public void g(boolean z2) {
        this.B = z2;
    }

    public void h(boolean z2) {
        this.g0 = z2;
    }

    public BNavigatorLogic i(boolean z2) {
        this.P = z2;
        return this;
    }

    public void j(boolean z2) {
        this.H = z2;
    }

    public void k() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "cancelNotConnectedToConnectedTask --> notConnectedToConnectedRetryCount = " + this.F);
        }
        if (this.k0 == null) {
            return;
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.h(), true);
        this.F = 2;
    }

    public void m() {
        int i2;
        if (!this.A.i() && !a0() && !com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k() && ((i2 = com.baidu.navisdk.module.pronavi.a.j) == 1 || i2 == 5)) {
            boolean b2 = com.baidu.navisdk.util.logic.c.k().b(this.d);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "isGpsEnable:" + b2);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.9", b2 ? "1" : "2", null, null);
            if (!b2 && BNSettingManager.isShowRemindDialog()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().S3();
            } else {
                com.baidu.navisdk.ui.routeguide.control.x.b().q();
            }
        } else {
            com.baidu.navisdk.ui.routeguide.control.x.b().q();
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().o4();
    }

    public boolean n() {
        return com.baidu.navisdk.comapi.trajectory.c.c().a().a(a((Context) com.baidu.navisdk.ui.routeguide.b.V().b(), this.P, false), com.baidu.navisdk.comapi.trajectory.j.TRAJECTORY_FROM_NAVI) == 0;
    }

    public void o() {
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            return;
        }
        if (com.baidu.navisdk.naviresult.a.d().a().d() >= 0) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "checkNormalRouteTime: getNormalArriveTimeMillies --> " + com.baidu.navisdk.naviresult.a.d().a().d());
                return;
            }
            return;
        }
        if (d0()) {
            com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
            if (fVar.o() == null) {
                return;
            }
            if (fVar.o().mFrom != 3) {
                com.baidu.navisdk.naviresult.a.d().a().a(false, 0L, 0L);
                return;
            }
            int selectRouteIdx = JNIGuidanceControl.getInstance().getSelectRouteIdx();
            int t2 = BNRoutePlaner.getInstance().t();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < t2; i4++) {
                Bundle bundle = new Bundle();
                BNRoutePlaner.getInstance().a(i4, bundle);
                String string = bundle.getString("pusLabelName");
                int i5 = bundle.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
                if (i4 == selectRouteIdx) {
                    i3 = i5;
                }
                if (string != null && string.equals("常规路线")) {
                    i2 = i5;
                }
            }
            com.baidu.navisdk.naviresult.a.d().a().a(true, i3 * 1000, i2 * 1000);
        }
    }

    public void p() {
        Handler handler;
        int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
        if (com.baidu.navisdk.ui.routeguide.b.V().b() == null || 2 == voiceMode) {
            return;
        }
        try {
            AudioManager audioManager = (AudioManager) com.baidu.navisdk.ui.routeguide.b.V().b().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager == null) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "checkTTsVolume fail mAudioManager is null");
                    return;
                }
                return;
            }
            if (audioManager.getStreamMaxVolume(3) - (audioManager.getStreamVolume(3) * 2) <= 0 || (handler = this.s0) == null) {
                return;
            }
            handler.sendEmptyMessage(10941);
        } catch (Exception unused) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("BNavigatorLogic", "checkTTsVolume Exception");
            }
        }
    }

    public a0 q() {
        return this.k0;
    }

    public Context r() {
        return this.d;
    }

    public com.baidu.navisdk.ui.routeguide.navidiff.c s() {
        if (this.m0 == null) {
            synchronized (com.baidu.navisdk.ui.routeguide.navidiff.c.class) {
                try {
                    if (this.m0 == null) {
                        this.m0 = new com.baidu.navisdk.ui.routeguide.navidiff.c();
                    }
                } finally {
                }
            }
        }
        return this.m0;
    }

    public Handler t() {
        return this.s0;
    }

    public LifecycleOwner u() {
        return this.e;
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.o v() {
        return this.r;
    }

    public com.baidu.navisdk.ui.routeguide.navicenter.a w() {
        if (this.x == null) {
            this.x = new com.baidu.navisdk.ui.routeguide.navicenter.a();
        }
        return this.x;
    }

    @Nullable
    public com.baidu.navisdk.ui.routeguide.navicenter.c x() {
        return this.l0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i2) {
        if (i2 == 1) {
            e1();
        } else {
            f1();
        }
    }

    private void h(int i2) {
        com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b bVar;
        com.baidu.navisdk.ui.routeguide.ar.a aVar;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "quitNaviUI destPage:" + i2);
        }
        if (RouteGuideParams.getRouteGuideMode() == 1) {
            i(2);
        }
        com.baidu.navisdk.ui.routeguide.navicenter.c cVar = this.l0;
        if (cVar != null) {
            bVar = cVar.c(false);
            aVar = this.l0.a(false);
        } else {
            bVar = null;
            aVar = null;
        }
        if (bVar != null) {
            bVar.i();
        }
        if (aVar != null) {
            aVar.i();
        }
        RGHDBaseMapHelper.Companion.resetWinRoundQuitNavi(com.baidu.navisdk.ui.routeguide.control.x.b().s2());
        z0 = false;
        b(true);
        if (BNRouteGuider.getInstance().getRemainDist() < 200) {
            com.baidu.navisdk.comapi.commontool.c.c().a(this.d, com.baidu.navisdk.comapi.commontool.c.e);
        } else {
            com.baidu.navisdk.comapi.commontool.c.c().a(this.d, com.baidu.navisdk.comapi.commontool.c.d);
        }
        g1();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().N4();
        com.baidu.navisdk.module.performance.memory.a.b().a();
        com.baidu.navisdk.util.task.a aVar2 = this.w;
        if (aVar2 != null) {
            aVar2.a();
            this.w = null;
        }
        com.baidu.navisdk.module.vdr.a.d(0);
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        if (!com.baidu.navisdk.j.d() && O0()) {
            BNRouteGuider.getInstance().naviSwitchingCalcRoute(1);
        }
        v1();
        com.baidu.navisdk.framework.interfaces.pronavi.o oVar = this.r;
        if (oVar != null) {
            oVar.a();
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.j(), false);
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.i(), false);
        com.baidu.nplatform.comapi.map.i.d().c();
        com.baidu.nplatform.comapi.map.i.d().b();
        BNMapController.getInstance().setNaviStatus(false);
        com.baidu.navisdk.vi.b.b(this.t0);
        BNRoutePlaner.getInstance().b(this.n);
        f0.d().b(this.r0);
        f0.d().a(501);
        f0.d().a(502);
        f0.d().a(503);
        f0.d().a(504);
        f0.d().a(505);
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.e(), false);
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.k(), false);
        com.baidu.navisdk.framework.interfaces.pronavi.n nVar = this.u;
        if (nVar != null) {
            nVar.onDestroy();
        }
        com.baidu.nplatform.comapi.map.j mapController = BNMapController.getInstance().getMapController();
        if (mapController != null) {
            mapController.G();
        }
        com.baidu.navisdk.ugc.dialog.h.j();
        com.baidu.navisdk.ui.routeguide.control.x.b().r();
        com.baidu.navisdk.ui.routeguide.control.x.b().o3();
        com.baidu.navisdk.ui.routeguide.control.x.b().a1();
        com.baidu.navisdk.ui.routeguide.control.x.b().b3();
        com.baidu.navisdk.ui.routeguide.control.x.b().h1();
        com.baidu.navisdk.ui.routeguide.control.x.b().L0();
        com.baidu.navisdk.ui.routeguide.control.x.b().f1();
        com.baidu.navisdk.ui.routeguide.control.x.b().F1();
        com.baidu.navisdk.module.powersavemode.f.o().b();
        BNPowerSaver.getInstance().c();
        if (BNCommSettingManager.getInstance().getBluetoothChannelMode() != 0) {
            com.baidu.navisdk.bluetooth.b.i().a(0);
        }
        com.baidu.navisdk.util.common.d.i = false;
        com.baidu.navisdk.module.a.h().a(com.baidu.navisdk.ui.routeguide.b.V().b(), 1, false);
        com.baidu.navisdk.module.a.h().n = false;
        if (com.baidu.navisdk.module.offscreen.a.g) {
            com.baidu.navisdk.module.offscreen.a.m().j();
        }
        com.baidu.navisdk.ui.routeguide.control.f.k().e();
        com.baidu.navisdk.ui.routeguide.control.x.b().p3();
        com.baidu.navisdk.ui.routeguide.control.s.T().R();
        com.baidu.navisdk.util.logic.g.j().i();
        if (com.baidu.navisdk.j.d()) {
            com.baidu.navisdk.module.vmsr.c.f().b();
        }
        t0();
        com.baidu.navisdk.ui.routeguide.heatmonitor.j jVar = this.z;
        if (jVar != null) {
            jVar.c();
            this.z = null;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().M2()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().H1();
            return;
        }
        BNRouteGuider.getInstance().setGuideEndType(0);
        l1();
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "quitNaviUI END:");
        }
    }

    private void i(int i2) {
        Bundle bundle = new Bundle();
        String a2 = BNRoutePlaner.getInstance().a("", "");
        String E = com.baidu.navisdk.framework.b.E();
        String d2 = com.baidu.navisdk.framework.b.d("");
        bundle.putString("baiduId", E);
        bundle.putString("sessionId", a2);
        if (!TextUtils.isEmpty(d2)) {
            bundle.putString("baiduName", d2);
        }
        String e2 = com.baidu.navisdk.framework.b.e();
        if (!TextUtils.isEmpty(e2)) {
            bundle.putString("bduss", e2);
        }
        bundle.putInt("unSid", 1);
        bundle.putInt("enNaviMode", 1);
        bundle.putInt("enTripMode", 1);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.COMMON;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "setAccountDataToEngine bundle:" + bundle);
        }
        boolean infoInUniform = BNRouteGuider.getInstance().setInfoInUniform(7, i2, bundle);
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "setAccountDataToEngine result:" + infoInUniform);
        }
    }

    private void j(int i2) {
        int i3 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                i3 = 2;
            } else if (i2 == 2) {
                i3 = 1;
            } else if (i2 == 3) {
                i3 = 3;
            }
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.n.1", "1", i3 + "", null);
    }

    public void c(boolean z2) {
        this.a0 = z2;
    }

    public boolean c(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "time naviStarted onStart");
        }
        boolean z2 = false;
        this.T = false;
        z0 = true;
        com.baidu.baidunavis.maplayer.e.k().b(false);
        com.baidu.navisdk.ui.routeguide.control.e eVar = com.baidu.navisdk.ui.routeguide.control.e.o;
        eVar.b((RoutePlanNode) null);
        eVar.f();
        com.baidu.navisdk.module.performance.memory.a.b().a(I(), X());
        if (bundle != null) {
            String string = bundle.getString("clbduss");
            boolean z3 = bundle.getBoolean("bNormol");
            if (gVar.d()) {
                gVar.e("RouteGuide", "naviStarted bduss " + string + " bNormol " + z3);
            }
            BNRouteGuider.getInstance().updateSpecVoiceText(string, z3);
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().P3();
        com.baidu.navisdk.ui.routeguide.control.x.b().N3();
        this.w = U0();
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "time naviStarted end");
        }
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(5, com.baidu.navisdk.function.b.FUNC_XIAODU.a());
        com.baidu.navisdk.module.navisafeguard.a.c().a(r(), I(), s().c(), new s(this));
        com.baidu.navisdk.framework.b.b(false);
        if (com.baidu.navisdk.module.vehiclemanager.b.i().f() && com.baidu.navisdk.module.vehiclemanager.b.i().a() == 0) {
            z2 = true;
        }
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "getSceneType -> " + E() + ", isCar = " + z2);
        }
        if (E() == 1 && z2) {
            G0();
        }
        if (BNCommSettingManager.getInstance().getMapMode() == 3) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("bShow", true);
            BNMapController.getInstance().setMapFuncInfoMapStrategy(6, bundle2);
        }
        BNSettingManager.registerOnSharedPreferenceChangeListener(this.K);
        return true;
    }

    public void d(boolean z2) {
        this.Z = z2;
    }

    public void e(boolean z2) {
        this.b0 = z2;
    }

    public void j() {
        com.baidu.navisdk.module.vdr.a.a(this.v0);
    }

    /* loaded from: classes8.dex */
    public class z extends n.b {

        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.util.worker.f<String, String> {
            public a(String str, String str2) {
                super(str, str2);
            }

            @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
            public String execute() {
                BNavigatorLogic.this.q1();
                return null;
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BNavigatorLogic.this.c(0);
            }
        }

        public z() {
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public void a() {
            a(501);
            a(502);
            a(503);
            a(504);
            a(505);
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public String b() {
            return "Navi-SDK-Inpage-Init";
        }

        @Override // com.baidu.navisdk.util.common.n.b
        public void a(Message message) {
            switch (message.what) {
                case 501:
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.e()) {
                        gVar.g("RouteGuide", "INIT_VIEW START");
                    }
                    BNavigatorLogic.this.Q();
                    if (gVar.d()) {
                        gVar.e("RouteGuide", "INIT_VIEW end");
                        return;
                    }
                    return;
                case 502:
                    if (BNavigatorLogic.this.a0) {
                        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                        if (gVar2.d()) {
                            gVar2.e("BNavigatorLogic", "REALLY_START hasCalcRouteOk");
                            return;
                        }
                        return;
                    }
                    boolean judgeRouteInfoAllReady = JNIGuidanceControl.getInstance().judgeRouteInfoAllReady(JNIGuidanceControl.getInstance().getSelectRouteIdx());
                    com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar3.e()) {
                        gVar3.g("BNavigatorLogic", "REALLY_START judgeRouteInfoAllReady isReady:" + judgeRouteInfoAllReady);
                    }
                    if (!judgeRouteInfoAllReady) {
                        com.baidu.navisdk.comapi.routeplan.v2.d g = BNRoutePlaner.getInstance().g();
                        if (g.c() == 1 || g.c() == 3) {
                            if (gVar3.e()) {
                                gVar3.g("RouteGuide", "REALLY_START RoutePlan has fail currentState :" + g.c());
                            }
                            if (TextUtils.isEmpty(com.baidu.navisdk.module.pronavi.a.o)) {
                                BNavigatorLogic.this.s0.post(new b());
                                return;
                            } else {
                                if (gVar3.d()) {
                                    gVar3.e("BNavigatorLogic", "REALLY_START pRGMrsl != null return");
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    TTSPlayerControl.setStopVoiceOutput(false);
                    if (BNRoutePlaner.getInstance().d() == 39) {
                        BNavigatorLogic.this.l0();
                    }
                    BNavigatorLogic bNavigatorLogic = BNavigatorLogic.this;
                    bNavigatorLogic.a0 = bNavigatorLogic.u1();
                    if (!BNavigatorLogic.this.a0) {
                        if (gVar3.e()) {
                            gVar3.g("BNavigatorLogic", "REALLY_START judgeRouteInfoAllReady startRouteGuide fail");
                            return;
                        }
                        return;
                    }
                    com.baidu.navisdk.ui.routeguide.asr.c.n().b(7, com.baidu.navisdk.module.pronavi.a.j != 2);
                    if (!com.baidu.navisdk.ui.routeguide.model.a0.I().t) {
                        Bundle bundle = new Bundle();
                        JNIGuidanceControl.getInstance().getFirstRouteGuideInfo(bundle);
                        com.baidu.navisdk.ui.routeguide.model.a0.I().a(bundle);
                        com.baidu.navisdk.util.worker.c.a().a(BNavigatorLogic.this.k0.e(), new com.baidu.navisdk.util.worker.e(2, 0));
                    }
                    f0.d().a(503);
                    f0.d().b(503);
                    return;
                case 503:
                    BNavigatorLogic bNavigatorLogic2 = BNavigatorLogic.this;
                    bNavigatorLogic2.e0 = bNavigatorLogic2.p1();
                    com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) BNavigatorLogic.this.k0.c(), new com.baidu.navisdk.util.worker.e(2, 0));
                    if (BNavigatorLogic.this.d0) {
                        return;
                    }
                    com.baidu.navisdk.util.worker.c.a().a(BNavigatorLogic.this.k0.k(), new com.baidu.navisdk.util.worker.e(2, 0));
                    return;
                case 504:
                    com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar4.d()) {
                        gVar4.e("RouteGuide", "showLongTunnelGuide");
                    }
                    com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.f) new a("SYNC_OPERATION-", null), new com.baidu.navisdk.util.worker.e(99, 0));
                    if (gVar4.d()) {
                        gVar4.e("RouteGuide", "SYNC_OPERATION end");
                        return;
                    }
                    return;
                case 505:
                    BNavigatorLogic.this.F0();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.navisdk.pageframe.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RGBaseUiFrame<?> b2() {
        com.baidu.navisdk.module.pronavi.model.f fVar = this.A;
        if (fVar != null && fVar.m()) {
            return new RGNewEnergyUiFrame(new com.baidu.navisdk.pronavi.newenergy.a(c(), com.baidu.navisdk.framework.data.a.b(), this.A, this.s, new com.baidu.navisdk.pageframe.store.c(), this.L, e()), this.L);
        }
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            return new RGCarUiFrame(new com.baidu.navisdk.pronavi.car.a(c(), com.baidu.navisdk.framework.data.a.b(), this.A, this.s, new com.baidu.navisdk.pageframe.store.c(), this.L, e()), this.L);
        }
        return new RGOldSettingCarUiFrame(new com.baidu.navisdk.pronavi.car.a(c(), com.baidu.navisdk.framework.data.a.b(), this.A, this.s, new com.baidu.navisdk.pageframe.store.c(), this.L, e()), this.L);
    }

    public void f(boolean z2) {
        l(z2);
    }

    private void k(boolean z2) {
        com.baidu.navisdk.comapi.routeguide.f fVar = this.q0;
        if (fVar != null) {
            fVar.a(z2);
        }
    }

    /* loaded from: classes8.dex */
    public class p implements com.baidu.navisdk.bluetooth.c {
        public p() {
        }

        private void d() {
            if (BNCommSettingManager.getInstance().getBluetoothChannelMode() != 0 && !com.baidu.navisdk.bluetooth.b.i().f()) {
                com.baidu.navisdk.bluetooth.b.i().h();
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J().n();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().A(false);
        }

        @Override // com.baidu.navisdk.bluetooth.c
        public void a(boolean z, String str) {
            if (z) {
                return;
            }
            com.baidu.navisdk.util.worker.c.a().a(BNavigatorLogic.this.k0.a(), new com.baidu.navisdk.util.worker.e(99, 0), 3000L);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e(com.baidu.navisdk.bluetooth.b.h, "blue connect success, device name=" + str);
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.r.1", "-1", null, null);
            BNavigatorLogic.this.d1();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J().f();
            if (com.baidu.navisdk.framework.b.K()) {
                BNRouteGuider.getInstance().setBlueToothStatus(true, BNSettingManager.getInt("BlueToothBlankRate", -1));
            }
        }

        @Override // com.baidu.navisdk.bluetooth.c
        public void b() {
        }

        @Override // com.baidu.navisdk.bluetooth.c
        public void c() {
            if (!com.baidu.navisdk.util.common.d.h && BNCommSettingManager.getInstance().getBluetoothChannelMode() == 1) {
                com.baidu.navisdk.bluetooth.b.i().a(0);
            }
        }

        @Override // com.baidu.navisdk.bluetooth.c
        public void a(boolean z) {
            if (z) {
                return;
            }
            TipTool.onCreateToastDialog(BNavigatorLogic.this.d, "已断开蓝牙 " + BNavigatorLogic.this.K0());
            d();
            if (com.baidu.navisdk.framework.b.K()) {
                BNRouteGuider.getInstance().setBlueToothStatus(false, BNSettingManager.getInt("BlueToothBlankRate", -1));
            }
        }

        @Override // com.baidu.navisdk.bluetooth.c
        public void a() {
            TipTool.onCreateToastDialog(BNavigatorLogic.this.d, "已断开蓝牙 " + BNavigatorLogic.this.K0());
            d();
        }

        @Override // com.baidu.navisdk.bluetooth.c
        public void a(String str) {
            BNavigatorLogic.this.d1();
        }
    }

    public void a(Boolean bool) {
        bool.booleanValue();
    }

    public void a(com.baidu.navisdk.framework.interfaces.pronavi.o oVar) {
        this.r = oVar;
    }

    @Override // com.baidu.navisdk.pageframe.a
    @NonNull
    public RGBaseLogicFrame a() {
        com.baidu.navisdk.pronavi.logic.a aVar = new com.baidu.navisdk.pronavi.logic.a(c(), com.baidu.navisdk.framework.data.a.b(), new com.baidu.navisdk.pageframe.store.b());
        com.baidu.navisdk.module.pronavi.model.f fVar = this.A;
        if (fVar != null && fVar.m()) {
            return new RGNewEnergyLogicFrame(aVar);
        }
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            return new RGCarLogicFrame(aVar);
        }
        return new RGOldSettingCarLogicFrame(aVar);
    }

    public void l() {
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            com.baidu.navisdk.module.newguide.controllers.c.a();
            return;
        }
        com.baidu.navisdk.ui.routeguide.utils.g gVar = this.X;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void a(ViewModelStore viewModelStore, LifecycleOwner lifecycleOwner) {
        this.f = viewModelStore;
        this.e = lifecycleOwner;
    }

    private void b(int i2, Bundle bundle) {
        if (SystemClock.elapsedRealtime() - this.n0 < 800) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "handleActionWhenExitNavi->限制多次调用!");
                return;
            }
            return;
        }
        this.n0 = SystemClock.elapsedRealtime();
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.a()) {
            gVar2.a("BNavigatorLogic", "handleActionWhenExitNavi,destPage:" + i2);
        }
        ProNaviStatItem.O().i(com.baidu.navisdk.naviresult.a.d().a().j() ? 1 : 2);
        boolean z2 = false;
        if (com.baidu.navisdk.module.cloudconfig.a.b().b("is_open_perform_monitor", false)) {
            com.baidu.navisdk.module.perform.b.d().b();
            com.baidu.navisdk.module.perform.b.d().c("on_quit_nav_click");
        }
        if (gVar2.d()) {
            gVar2.e("RouteGuide", "MapSwitchGLSurfaceView handleActionWhenExitNavi===========");
        }
        com.baidu.navisdk.ui.routeguide.control.e eVar = com.baidu.navisdk.ui.routeguide.control.e.o;
        eVar.a();
        com.baidu.navisdk.naviresult.a.d().a().a(eVar.c());
        int e2 = com.baidu.navisdk.naviresult.a.e();
        boolean b2 = com.baidu.navisdk.naviresult.a.b(e2);
        com.baidu.navisdk.naviresult.a.d().a().c(e2);
        com.baidu.navisdk.naviresult.a.d().a().c(b2);
        com.baidu.navisdk.naviresult.a.d().a().k();
        if (com.baidu.navisdk.ui.routeguide.control.x.b().x2()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().J4();
        }
        h(i2);
        if (gVar2.d()) {
            gVar2.e("BNavigatorLogic", "handleActionWhenExitNavi  BNRoutePlaner = " + BNRoutePlaner.getInstance());
        }
        BNRoutePlaner.getInstance().q();
        f0.d().a().post(new w(b2, i2));
        if (this.r == null) {
            if (gVar2.d()) {
                gVar2.e("BNavigatorLogic", "handleActionWhenExitNavi mBNavigatorListener == null!!");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.statistic.q.a(8, "on_quit_nav_anim_end", System.currentTimeMillis());
        if (3 == i2) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("locate_mode", com.baidu.navisdk.module.pronavi.a.j);
            bundle2.putBoolean("walknavi", b2);
            this.h = BNRouteGuider.getInstance().isDestHitWanDa(false);
            if (gVar2.d()) {
                gVar2.e("BNavigatorLogic", "handleActionWhenExitNavi  isWanda " + this.h);
            }
            bundle2.putBoolean("is_wanda", this.h);
            bundle2.putBoolean("has_end_record", this.C);
            bundle2.putBoolean("is_arrive_dest", this.P);
            bundle2.putBoolean("end_record_ok", this.D);
            bundle2.putInt("back_page_orientation", com.baidu.navisdk.module.pronavi.model.h.f7469a);
            bundle2.putInt("enter_navi_from", com.baidu.navisdk.module.pronavi.a.p);
            bundle2.putBoolean("end_arrived", com.baidu.navisdk.naviresult.a.d().a().j());
            if (Y()) {
                bundle2.putBoolean("navi.end.ugcpage", true);
            }
            bundle2.putInt("back_page_for_vehicle_type", I());
            if (gVar2.d()) {
                gVar2.e("BNavigatorLogic", "handleActionWhenExitNavi  BNavConfig.pPageFrom " + com.baidu.navisdk.module.pronavi.a.p);
            }
            if (this.A.i()) {
                if (gVar2.d()) {
                    gVar2.e("BNavigatorLogic", "handleActionWhenExitNavi  isFromHiCar = BNavigator.isFromHiCar");
                }
                z2 = true;
            }
            if (this.A.n()) {
                bundle2.putBoolean("back_page_go_back_home", true);
                z2 = true;
            }
            if (z2) {
                bundle2.putBoolean("back_page_go_to_where", true);
            }
            bundle2.putInt("page_from_scene", this.A.d());
            com.baidu.navisdk.ui.routeguide.control.w.a(bundle2);
            String str = com.baidu.navisdk.module.cloudconfig.f.c().w.l;
            boolean z3 = com.baidu.navisdk.module.cloudconfig.f.c().w.k;
            if (!TextUtils.isEmpty(str)) {
                NaviTrajectory a2 = com.baidu.navisdk.comapi.trajectory.c.c().a().a(com.baidu.navisdk.comapi.trajectory.c.c().a().a());
                StringBuilder sb = new StringBuilder(str);
                try {
                    sb.append(str.endsWith(LocationInfo.NA) ? "distance=" : "&distance=");
                    sb.append(a2 != null ? a2.mDistance : -1.0f);
                    sb.append("&truck_type=");
                    sb.append(com.baidu.navisdk.module.trucknavi.logic.plate.c.g().a().f7582a);
                    sb.append("&truck_ext=");
                    sb.append(URLEncoder.encode(com.baidu.navisdk.module.trucknavi.logic.plate.c.g().a().q, "UTF-8"));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                }
                bundle2.putString("h5Url", sb.toString());
            } else {
                bundle2.putString("h5Url", "");
            }
            bundle2.putBoolean("truckEnd2H5ResultPage", z3);
            com.baidu.navisdk.framework.b.a(1, bundle2);
        } else if (2 == i2) {
            com.baidu.navisdk.framework.b.a(16, bundle);
        } else if (4 == i2) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("commute_from_type", 7);
            bundle3.putInt("commute_jump_type", -1);
            bundle3.putString("source_page", com.baidu.navisdk.module.pronavi.a.r);
            bundle3.putBoolean("is_from_car_pro_navi", true);
            bundle3.putInt("commute_enter_page_type", 2);
            bundle3.putInt(BNaviCommonParams.RoutePlanKey.SUB_VEHICLE, F());
            bundle3.putInt("route_index", BNRouteGuider.getInstance().convertToTabIndex(JNIGuidanceControl.getInstance().getSelectRouteIdx()));
            Bundle bundle4 = new Bundle();
            BNRoutePlaner.getInstance().c(bundle4);
            bundle3.putString(JNISearchConst.JNI_ROUTE_MRSL, bundle4.getString("mrsl", ""));
            com.baidu.navisdk.module.pronavi.model.f fVar = this.A;
            if (fVar != null) {
                bundle3.putInt(BNaviCommonParams.RoutePlanKey.SUB_VEHICLE, fVar.f());
            }
            com.baidu.navisdk.framework.b.a(35, bundle3);
        }
        com.baidu.navisdk.ugc.replenishdetails.d.o().n();
        com.baidu.navisdk.module.perform.b.d().c("on_quit_nav_end");
        com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar3.d()) {
            gVar3.e("BNavigatorLogic", "handleActionWhenExitNavi end");
        }
    }

    @Override // com.baidu.navisdk.pageframe.a, com.baidu.navisdk.framework.interfaces.i
    public View a(Activity activity, Bundle bundle, View view) {
        com.baidu.navisdk.framework.interfaces.locationshare.a j2;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("BNavigatorLogic onCreateView," + com.baidu.navisdk.module.vehiclemanager.b.i().b());
            LogUtil.e("BaiduMapScreenInfo", activity.getResources().getDisplayMetrics() + "," + activity.getResources().getConfiguration());
        }
        com.baidu.navisdk.skyeye.b.a().b(new com.baidu.navisdk.skyeye.event.d(16));
        com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
        aVar.a(activity.getResources().getConfiguration(), activity);
        this.d = activity.getApplicationContext();
        ScreenUtil.getInstance().init(activity);
        this.j = true;
        this.k = true;
        this.a0 = false;
        this.c0 = false;
        this.f0 = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.g0 = false;
        this.Z = false;
        this.O = true;
        if (view != null) {
            this.M = view;
        }
        com.baidu.navisdk.naviresult.a.d().b();
        com.baidu.navisdk.module.pronavi.model.i.f().b = false;
        a1();
        com.baidu.navisdk.module.pronavi.model.h.f7469a = aVar.f();
        FrameLayout frameLayout = this.L;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        try {
            FrameLayout frameLayout2 = (FrameLayout) JarUtils.inflate(activity, R.layout.nsdk_layout_rg_main_layout, null);
            this.L = frameLayout2;
            if (frameLayout2 == null) {
                com.baidu.navisdk.skyeye.a.n().a(gVar, "mParentView == null");
                return null;
            }
            if (gVar.a()) {
                gVar.a("BNavigatorLogic", "当前手机型号：" + Build.MODEL + "，isMeta20= " + b0() + "， SDK_INT = " + Build.VERSION.SDK_INT + ", 云端列表: " + com.baidu.navisdk.module.cloudconfig.f.c().c.I);
            }
            if (Build.VERSION.SDK_INT >= 28) {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            b(bundle);
            com.baidu.navisdk.ui.routeguide.mapmode.subview.a.c().b(activity);
            a(activity, true);
            if (!com.baidu.navisdk.module.pronavi.a.s) {
                this.X = new com.baidu.navisdk.ui.routeguide.utils.g(activity);
            }
            super.a(activity, bundle);
            a(this.L, this.M, aVar.f());
            super.a(activity, bundle, view);
            com.baidu.navisdk.ui.routeguide.utils.c.a(f());
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().Q1();
            RouteGuideFSM.getInstance().setUiState(g());
            S0();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J().b(false);
            com.baidu.navisdk.ui.routeguide.asr.a.c();
            f0.d().a(this.r0);
            f0.d().b(501);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(new v());
            l(com.baidu.navisdk.comapi.commontool.a.getInstance().a(BNCommSettingManager.getInstance().getNaviDayAndNightMode()));
            gVar.a("current TTS volume:" + TTSPlayerControl.getCurrentVolume());
            if (com.baidu.navisdk.j.d() && (j2 = com.baidu.navisdk.framework.interfaces.c.p().j()) != null && !com.baidu.navisdk.util.common.x.s()) {
                j2.a(new com.baidu.navisdk.ui.routeguide.module.locationshare.a());
                j2.a();
            }
            if (aVar.i()) {
                com.baidu.navisdk.util.statistic.userop.b.r().b("w.s.1.1");
            }
            BNMapController.getInstance().enterNavi();
            com.baidu.navisdk.ui.routeguide.ace.a.m().h();
            return this.L;
        } catch (Exception e2) {
            this.L = null;
            com.baidu.navisdk.skyeye.a.n().a(com.baidu.navisdk.util.common.g.PRO_NAV, "onCreateViewException" + e2.getLocalizedMessage());
            return null;
        }
    }

    public void i() {
        if (5 == com.baidu.navisdk.module.pronavi.a.j) {
            this.Q = com.baidu.navisdk.util.logic.a.j();
        }
        int i2 = com.baidu.navisdk.module.pronavi.a.j;
        if (1 == i2 || 6 == i2) {
            this.Q = com.baidu.navisdk.util.logic.c.k();
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.3", "1", null, null);
        }
        if (this.Q == null && 2 != com.baidu.navisdk.module.pronavi.a.j) {
            this.Q = com.baidu.navisdk.util.logic.c.k();
            com.baidu.navisdk.util.statistic.userop.b.r().a("8.3.3", "1", null, null);
        }
        if (this.Q != null) {
            com.baidu.navisdk.util.logic.g.j().a(this.Q);
            if (!com.baidu.navisdk.util.logic.j.r().B) {
                com.baidu.navisdk.util.logic.j.r().n();
            }
            if (this.Q.a(this.d)) {
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.i(), false);
            } else {
                com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.i(), false);
                com.baidu.navisdk.util.worker.c.a().a(this.k0.i(), new com.baidu.navisdk.util.worker.e(2, 0), 5000L);
            }
            this.Q.a(this.u0);
        }
    }

    public void c(int i2) {
        int i3;
        com.baidu.navisdk.ui.routeguide.subview.a aVar;
        com.baidu.navisdk.ui.routeguide.navicenter.c cVar = this.l0;
        if (cVar != null) {
            cVar.m().a((String) null, 0);
        }
        if (!L()) {
            com.baidu.navisdk.ui.routeguide.model.a0.I().u = true;
            com.baidu.navisdk.ui.routeguide.control.x.b().o4();
            com.baidu.navisdk.ui.routeguide.control.s.T().n(i2);
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().m1();
        if (z0 && (((i3 = com.baidu.navisdk.ui.routeguide.model.a0.G) == 1 || i3 == 6) && (aVar = this.s) != null)) {
            aVar.d();
        }
        a(false, i2);
        com.baidu.navisdk.ui.routeguide.asr.c.n().b(true);
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
    }

    @Override // com.baidu.navisdk.pageframe.a
    public boolean h() {
        com.baidu.navisdk.util.statistic.q.a(8, "on_quit_back_press", System.currentTimeMillis());
        if (super.h()) {
            return true;
        }
        com.baidu.navisdk.framework.interfaces.k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
        if (k2 != null && k2.onBackPressed()) {
            return true;
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().M2()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().H1();
        } else if (com.baidu.navisdk.ui.routeguide.control.x.b().i2()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().T0();
        } else {
            if (com.baidu.navisdk.ui.routeguide.control.x.b().E2()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().v();
                com.baidu.navisdk.ui.routeguide.subview.a aVar = this.s;
                if (aVar != null) {
                    aVar.a(false);
                }
                return true;
            }
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().T1()) {
                com.baidu.navisdk.ui.routeguide.control.x.b().E0();
            } else if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().q2()) {
                if (!com.baidu.navisdk.ui.routeguide.control.x.b().T2()) {
                    return true;
                }
                com.baidu.navisdk.ui.routeguide.control.x.b().w0();
                b(1);
                com.baidu.navisdk.ui.routeguide.control.x.b().I().r();
            } else {
                if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v2()) {
                    com.baidu.navisdk.ui.routeguide.control.x.b().t1();
                    int a2 = com.baidu.navisdk.module.routepreference.c.a(com.baidu.navisdk.module.vehiclemanager.b.i().b());
                    if (s().a(a2)) {
                        com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.a", Integer.toString(a2), "1", null);
                        com.baidu.navisdk.ui.routeguide.control.l.l().i();
                    }
                    return true;
                }
                if (com.baidu.navisdk.ui.routeguide.control.x.b().v1()) {
                    return true;
                }
                if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().U1()) {
                    com.baidu.navisdk.ui.routeguide.mapmode.a.o5().A(false);
                }
                if (RGFSMTable.FsmState.EnlargeRoadmap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                    RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
                } else if (RGFSMTable.FsmState.Colladamap.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                    RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
                } else if (com.baidu.navisdk.ui.routeguide.control.x.b().L2()) {
                    com.baidu.navisdk.ui.routeguide.control.x.b().n3();
                } else if (com.baidu.navisdk.ui.routeguide.control.x.b().S1()) {
                    com.baidu.navisdk.ui.routeguide.control.x.b().a3();
                } else if (com.baidu.navisdk.ui.routeguide.control.x.b().v2()) {
                    com.baidu.navisdk.ui.routeguide.control.x.b().t1();
                    com.baidu.navisdk.ui.routeguide.control.x.b().c();
                    com.baidu.navisdk.ui.routeguide.control.x.b().C(true);
                } else if (com.baidu.navisdk.ui.routeguide.control.x.b().I2()) {
                    com.baidu.navisdk.ui.routeguide.control.x.b().a(true);
                } else if (com.baidu.navisdk.ui.routeguide.control.s.T().l(113)) {
                    com.baidu.navisdk.ui.routeguide.control.s.T().w();
                } else if (com.baidu.navisdk.ui.routeguide.control.s.T().l(109)) {
                    com.baidu.navisdk.ui.routeguide.control.s.T().u();
                } else if (com.baidu.navisdk.ui.routeguide.control.s.T().l(106)) {
                    com.baidu.navisdk.ui.routeguide.control.s.T().t();
                } else if (RGFSMTable.FsmState.NearbySearch.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                    RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
                } else if (RGFSMTable.FsmState.DynamicLayer.equals(RouteGuideFSM.getInstance().getCurrentState())) {
                    RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BTN_CLICK_BACK);
                } else if (com.baidu.navisdk.ui.routeguide.control.s.T().l(132)) {
                    com.baidu.navisdk.ui.routeguide.control.s.T().q();
                } else if (com.baidu.navisdk.ui.routeguide.control.i.g().c(1006)) {
                    com.baidu.navisdk.ui.routeguide.control.i.g().b(1006);
                } else if (com.baidu.navisdk.ui.routeguide.control.i.g().c(1009)) {
                    com.baidu.navisdk.ui.routeguide.control.i.g().b(1009);
                } else {
                    if (com.baidu.navisdk.ui.routeguide.control.x.b().j3()) {
                        return true;
                    }
                    if (g() != null && g().d()) {
                        return true;
                    }
                    if (this.A.j()) {
                        this.A.a(true);
                    } else {
                        this.A.a(false);
                        if (!c1()) {
                            TipTool.onCreateToastDialog(com.baidu.navisdk.ui.routeguide.b.V().b(), JarUtils.getResources().getString(R.string.nsdk_string_rg_double_back_quit));
                        }
                    }
                    com.baidu.navisdk.util.statistic.userop.b.r().a("1.5", "1", null, null);
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.a", "1", com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().k() ? "2" : "1", null);
                    com.baidu.navisdk.module.abtest.model.k.x().t();
                    i0();
                }
                new com.baidu.navisdk.ui.routeguide.routeplan.b(com.baidu.navisdk.ui.routeguide.b.V().b(), null).dismissWaitProgressDialog();
            }
        }
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00b8 -> B:38:0x00bf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00ba -> B:38:0x00bf). Please report as a decompilation issue!!! */
    private void a(Activity activity, boolean z2) {
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "setShowWhenLocked->NE_Locate_Mode_RouteDemoGPS!return!!");
                return;
            }
            return;
        }
        if (E() != 1) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("BNavigatorLogic", "setShowWhenLocked->非正常导航场景，否则不需要该功能");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.module.pronavi.a.p != 6) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("BNavigatorLogic", "setShowWhenLocked->非OpenApi进入，不需要该功能");
                return;
            }
            return;
        }
        if (!com.baidu.navisdk.module.cloudconfig.f.c().c.T) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("BNavigatorLogic", "setShowWhenLocked->showWhenLocked=false!!!return!!");
                return;
            }
            return;
        }
        com.baidu.navisdk.util.common.g gVar5 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar5.d()) {
            gVar5.e("BNavigatorLogic", "setShowWhenLocked-> isVivo:" + com.baidu.navisdk.util.common.q.j() + "， isHuawei：" + com.baidu.navisdk.framework.b.P());
        }
        if (com.baidu.navisdk.util.common.q.j() || com.baidu.navisdk.framework.b.P()) {
            try {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 28) {
                    activity.setShowWhenLocked(z2);
                } else if (i2 >= 27) {
                    if (z2) {
                        activity.getWindow().addFlags(524288);
                    } else {
                        activity.getWindow().clearFlags(524288);
                    }
                }
            } catch (Exception e2) {
                if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                    LogUtil.printException("setShowWhenLocked", e2);
                }
            }
        }
    }

    public void a(int i2, boolean z2, Bundle bundle) {
        z0 = false;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            LogUtil.printCallStack();
        }
        i1();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.v.b", z2 ? "1" : "0", i2 + "");
        if (z2) {
            TTSPlayerControl.stopVoiceTTSOutput();
            if (gVar.a()) {
                gVar.a("BNavigatorLogic", "forceQuitNav: destPage --> " + i2);
            }
            h(i2);
            BNRoutePlaner.getInstance().q();
            b(i2, false);
        } else {
            b(i2, bundle);
        }
        if (com.baidu.navisdk.framework.b.z()) {
            com.baidu.navisdk.framework.b.d(false);
            if (TTSPlayerControl.getTTSState() == 3) {
                TTSPlayerControl.resumeVoiceTTSOutput();
            }
            com.baidu.navisdk.util.statistic.userop.b.r().d("b.a.4", "2");
        }
        BNSettingManager.unregisterOnSharedPreferenceChangeListener(this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(int i2, boolean z2) {
        String str;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("BNavigatorLogic", "quitNavLogic destPage:" + i2 + " isNormalQuit" + z2);
        }
        this.g0 = false;
        this.a0 = false;
        com.baidu.navisdk.ui.routeguide.module.convoy.a.c = false;
        com.baidu.navisdk.module.pronavi.model.i.f().b = false;
        com.baidu.navisdk.ui.routeguide.model.x.A().f8982a = false;
        com.baidu.navisdk.ui.routeguide.model.a0.C = false;
        com.baidu.navisdk.ui.routeguide.model.a0.D = false;
        com.baidu.navisdk.ui.routeguide.model.a0.E = false;
        com.baidu.navisdk.ugc.external.d.n = false;
        com.baidu.navisdk.util.logic.j.r().r = false;
        com.baidu.navisdk.ui.routeguide.model.a.c().b();
        com.baidu.navisdk.ui.routeguide.model.t.s().q();
        com.baidu.navisdk.ui.routeguide.model.d.g().e();
        com.baidu.navisdk.ui.routeguide.control.l.l().k();
        com.baidu.navisdk.ui.routeguide.navicenter.c cVar = this.l0;
        if (cVar != null) {
            cVar.e().onDestroy();
        }
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.c(), false);
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.k0.a(), false);
        k(false);
        q0();
        if (this.A.o()) {
            BNMapController.getInstance().setCompassVisible(true);
            BNMapController.getInstance().setStrategyVisible(false);
        }
        w1();
        C0();
        x1();
        r0();
        E0();
        com.baidu.navisdk.framework.b.d0();
        com.baidu.navisdk.util.logic.k.getInstance().a();
        com.baidu.navisdk.ui.routeguide.control.d.e.h();
        if (com.baidu.navisdk.module.pronavi.a.j == 2 && com.baidu.navisdk.module.pronavi.model.i.f().c()) {
            com.baidu.navisdk.module.pronavi.model.i.f().d();
        }
        BNSettingManager.setQuitForExceptionInNaviMode(false);
        B0();
        BNMapController.getInstance().setHighLightRoute(0, 0);
        com.baidu.navisdk.ui.routeguide.model.g.h().c(false);
        int currentRouteGPCnt = BNRouteGuider.getInstance().getCurrentRouteGPCnt();
        this.S = currentRouteGPCnt;
        if (currentRouteGPCnt != 0) {
            ProNaviStatItem.O().e(this.S);
        }
        VoiceInterfaceImplProxy o2 = com.baidu.navisdk.framework.interfaces.c.p().o();
        if (o2 != null) {
            str = o2.getCurrentVoice();
            o2.resetDefaultVoiceForMemory();
        } else {
            str = null;
        }
        if (str == null) {
            str = "2-0";
        } else if (str.equals("9999")) {
            str = "9999";
        }
        ProNaviStatItem.O().e(str);
        com.baidu.navisdk.util.statistic.i.c = (SystemClock.elapsedRealtime() - com.baidu.navisdk.util.statistic.i.f9373a) / 1000;
        com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410273", "410273");
        String currentUUID = JNITrajectoryControl.sInstance.getCurrentUUID();
        if (!l0.c(currentUUID)) {
            ProNaviStatItem.O().c(JNITrajectoryControl.sInstance.getTrajectoryLength(currentUUID));
        } else {
            ProNaviStatItem.O().c(0L);
        }
        ProNaviStatItem.O().j(com.baidu.navisdk.util.common.y.a(this.d));
        ProNaviStatItem.O().C();
        ProNaviStatItem.O().E();
        ProNaviStatItem.O().D();
        ProNaviStatItem.O().F();
        com.baidu.navisdk.util.common.n.d().b(101);
        BNMapController.getInstance().setEnlargedStatus(false);
        com.baidu.navisdk.ui.routeguide.control.q.c().a();
        a(String.valueOf(0));
        J0();
        m1();
        y0();
        int i3 = 3;
        if (o2 != null) {
            int voicePersonality = o2.getVoicePersonality();
            if (voicePersonality == 0) {
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410367", "410367");
            } else if (voicePersonality == 1) {
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410368", "410368");
            } else if (voicePersonality == 3) {
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410388", "410388");
            } else {
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410369", "410369");
            }
        }
        com.baidu.navisdk.ui.routeguide.control.n.d().c();
        com.baidu.navisdk.module.routepreference.i.j().f();
        RGScreenStatusReceiver.a();
        com.baidu.navisdk.ui.routeguide.control.r.i().a();
        BNRouteNearbySearchUtils.INSTANCE.stopQuery();
        com.baidu.navisdk.ui.routeguide.navicenter.c cVar2 = this.l0;
        if (cVar2 != null) {
            cVar2.n();
            this.l0 = null;
        }
        com.baidu.navisdk.module.a.h().e();
        com.baidu.navisdk.ui.routeguide.module.diyspeak.e eVar = com.baidu.navisdk.ui.routeguide.module.diyspeak.e.f;
        eVar.b().d();
        com.baidu.navisdk.ui.routeguide.brule.a.d().b();
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_quit_navi"));
        s().i();
        com.baidu.navisdk.module.carlogo.control.c.c().a(true);
        com.baidu.navisdk.ui.routeguide.tts.a.a().i();
        if (this.E) {
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "endRecordInThread");
            }
            int a2 = com.baidu.navisdk.comapi.trajectory.c.c().a().a(a(com.baidu.navisdk.framework.a.c().a(), this.P, false), com.baidu.navisdk.comapi.trajectory.j.TRAJECTORY_FROM_NAVI);
            if (com.baidu.navisdk.module.pronavi.a.j != 2 && a2 == 0) {
                if (3 != this.A.d()) {
                    i3 = 7 == this.A.d() ? 4 : com.baidu.navisdk.module.pronavi.a.v;
                }
                com.baidu.navisdk.comapi.trajectory.b.a();
                com.baidu.navisdk.comapi.trajectory.b.a(false, i3);
            }
        }
        if (com.baidu.navisdk.module.abtest.model.d.s() != null) {
            com.baidu.navisdk.module.abtest.model.d.s().a(2, System.currentTimeMillis() - this.G);
        }
        if (com.baidu.navisdk.module.cloudconfig.a.b().b("set_rgc_cen_freq", true)) {
            com.baidu.navisdk.framework.b.j(0);
        }
        eVar.b(false);
        com.baidu.navisdk.framework.b.b(true);
        try {
            com.baidu.navisdk.ui.routeguide.control.x.b().o0().p();
        } catch (Exception e2) {
            com.baidu.navisdk.util.common.g.PRO_NAV.a("uninitUgcParamConfig err :" + e2.getLocalizedMessage());
        }
        this.h0 = null;
        if (!O0()) {
            com.baidu.navisdk.util.statistic.userop.b.r().n();
            com.baidu.navisdk.util.common.n.d().b(250);
        }
        com.baidu.navisdk.framework.interfaces.lightnavi.a aVar = this.y;
        if (aVar != null) {
            aVar.m(false);
        }
        BNRoutePlaner.getInstance().a((BNRoutePlaner.f) null);
        if (i2 != 4) {
            com.baidu.navisdk.module.base.a.a(1);
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("BNavigatorLogic", "quitNavLogic END");
        }
    }

    private void a(String str) {
        com.baidu.navisdk.framework.interfaces.pronavi.o oVar = this.r;
        if (oVar != null) {
            oVar.a(str);
        }
    }

    private String a(int i2, int i3) {
        if (i3 == 5300) {
            return com.baidu.navisdk.ui.util.b.h(R.string.nsdk_vdr_intercept_recal_route_tip);
        }
        if (i3 == 5301) {
            return com.baidu.navisdk.ui.util.b.h(R.string.nsdk_intercept_pre_yawing_route_tip);
        }
        return com.baidu.navisdk.ui.util.b.h(i2);
    }

    public void a(boolean z2, int i2) {
        String str;
        String a2;
        String a3;
        String string;
        String a4;
        String h2;
        int i3;
        String string2;
        String string3;
        com.baidu.navisdk.framework.interfaces.k k2 = com.baidu.navisdk.framework.interfaces.c.p().k();
        str = "";
        switch (com.baidu.navisdk.ui.routeguide.model.a0.G) {
            case 1:
                if (z2) {
                    a2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_success);
                } else {
                    I0();
                    a2 = a(R.string.nsdk_string_rg_add_via_fail, i2);
                }
                if (k2 != null && k2.l0() != null) {
                    k.b l0 = k2.l0();
                    if (z2) {
                        l0.a(1, null, -1);
                    } else {
                        l0.b(1, null, -1);
                    }
                }
                com.baidu.navisdk.ui.routeguide.control.s.T().a(a2, z2);
                if (com.baidu.navisdk.poisearch.model.a.k().f() == 1) {
                    if (!TextUtils.isEmpty(com.baidu.navisdk.asr.d.B().a(z2))) {
                        com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.a(com.baidu.navisdk.asr.d.B().a(z2), true));
                        break;
                    } else {
                        com.baidu.navisdk.module.asr.i.b(com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.e.d().a(z2));
                        break;
                    }
                }
                break;
            case 2:
            case 4:
            case 7:
            case 12:
            default:
                if (z2) {
                    if (BNCommSettingManager.getInstance().getPrefRoutPlanMode() == 2) {
                        com.baidu.navisdk.comapi.routeplan.v2.d g2 = BNRoutePlaner.getInstance().g();
                        if (g2 != null && g2.i()) {
                            com.baidu.navisdk.ui.routeguide.control.s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_rg_offline_route_plan_succeed_tips), true);
                            break;
                        } else if (!BNRoutePlaner.getInstance().B()) {
                            com.baidu.navisdk.ui.routeguide.control.s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_rg_offline_to_online_succeed_tips), true);
                            break;
                        }
                    } else if (com.baidu.navisdk.ui.routeguide.model.a0.C && com.baidu.navisdk.ui.routeguide.control.s.T().f() != 1) {
                        com.baidu.navisdk.ui.routeguide.control.s.T().I();
                        com.baidu.navisdk.ui.routeguide.model.a0.C = false;
                        break;
                    }
                } else {
                    com.baidu.navisdk.ui.routeguide.control.s.T().a(a(R.string.nsdk_string_rg_route_plan_fail, i2), false);
                    break;
                }
                break;
            case 3:
                if (z2) {
                    if (s().e()) {
                        a3 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_car_limit_open);
                    } else {
                        a3 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_car_limit_close);
                    }
                } else {
                    a3 = a(R.string.nsdk_string_rg_route_plan_fail, i2);
                }
                com.baidu.navisdk.ui.routeguide.control.s.T().a(a3, z2);
                com.baidu.navisdk.ui.routeguide.model.a0.C = false;
                break;
            case 5:
                if (z2) {
                    com.baidu.navisdk.ui.routeguide.control.s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_rg_voice_change_route_success, com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.d.l().c()), true);
                } else {
                    if (e(i2)) {
                        string = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_vdr_intercept_recal_route_tip);
                    } else if (d(i2)) {
                        string = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_intercept_pre_yawing_route_tip);
                    } else {
                        string = JarUtils.getResources().getString(R.string.asr_rg_error_planing_select_route, com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.d.l().c());
                    }
                    com.baidu.navisdk.ui.routeguide.control.s.T().a(string, false);
                }
                if (k2 != null && k2.l0() != null) {
                    k.b l02 = k2.l0();
                    if (z2) {
                        l02.a(10, null, -1);
                        break;
                    } else {
                        l02.b(10, null, -1);
                        break;
                    }
                }
                break;
            case 6:
                if (z2) {
                    a4 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_del_via_success);
                } else {
                    a4 = a(R.string.nsdk_string_rg_del_via_fail, i2);
                }
                if (com.baidu.navisdk.module.asr.busi.d.a()) {
                    com.baidu.navisdk.module.asr.busi.d.b(false);
                    com.baidu.navisdk.module.asr.busi.d.a(z2);
                }
                if (k2 != null && k2.l0() != null) {
                    k.b l03 = k2.l0();
                    com.baidu.navisdk.module.nearbysearch.model.b bVar = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE;
                    RoutePlanNode c2 = bVar.c();
                    int d2 = bVar.d();
                    if (z2) {
                        l03.a(6, c2, d2);
                    } else {
                        l03.b(6, c2, d2);
                    }
                }
                com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.g();
                com.baidu.navisdk.ui.routeguide.control.s.T().a(a4, z2);
                break;
            case 8:
                if (z2) {
                    h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_success);
                } else {
                    I0();
                    h2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_add_via_fail);
                }
                com.baidu.navisdk.ui.routeguide.control.s.T().a(h2, z2);
                if (z2) {
                    com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.b.b().a().c();
                    break;
                } else {
                    com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.b.b().a().b();
                    break;
                }
            case 9:
                if (z2) {
                    com.baidu.navisdk.comapi.routeplan.v2.d g3 = BNRoutePlaner.getInstance().g();
                    if (g3 != null && g3.e() != null && g3.e().b != null && !TextUtils.isEmpty(g3.e().b.mName)) {
                        str = g3.e().b.mName;
                    }
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e("BNavigatorLogic", "TYPE_AVOID_POOR_DEST,dest:" + str);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        com.baidu.navisdk.ui.routeguide.control.s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_rg_add_restore_dest_success_text, str), true);
                        break;
                    }
                } else {
                    com.baidu.navisdk.ui.routeguide.control.s.T().a(a(R.string.nsdk_string_rg_add_restore_dest_fail_text, i2), false);
                    break;
                }
                break;
            case 10:
                if (z2) {
                    com.baidu.navisdk.ui.routeguide.control.s.T().a(JarUtils.getResources().getString(R.string.nsdk_string_rg_sdk_change_route_success), true);
                    break;
                } else {
                    com.baidu.navisdk.ui.routeguide.control.s.T().a(a(R.string.nsdk_string_rg_route_plan_fail, i2), false);
                    break;
                }
            case 11:
                if (z2) {
                    i3 = R.string.nsdk_road_cond_refresh_succ;
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.2.1", "1", null, null);
                } else {
                    i3 = R.string.nsdk_road_cond_refresh_fail;
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.6.2.1", "2", null, null);
                }
                com.baidu.navisdk.ui.routeguide.control.s.T().a(JarUtils.getResources().getString(i3), z2, 5000);
                break;
            case 13:
                if (z2) {
                    string2 = JarUtils.getResources().getString(R.string.nsdk_string_rg_voice_change_route_success, com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.e.d().a());
                    com.baidu.navisdk.ui.routeguide.control.e eVar = com.baidu.navisdk.ui.routeguide.control.e.o;
                    eVar.a();
                    eVar.b((RoutePlanNode) null);
                } else if (e(i2)) {
                    string2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_vdr_intercept_recal_route_tip);
                } else if (d(i2)) {
                    string2 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_intercept_pre_yawing_route_tip);
                } else {
                    string2 = JarUtils.getResources().getString(R.string.asr_rg_error_planing_select_route, com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.e.d().a());
                }
                com.baidu.navisdk.ui.routeguide.control.s.T().a(string2, z2);
                if (com.baidu.navisdk.poisearch.model.a.k().f() == 1) {
                    if (!TextUtils.isEmpty(com.baidu.navisdk.asr.d.B().a(z2))) {
                        com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.a(com.baidu.navisdk.asr.d.B().a(z2), true));
                        break;
                    } else {
                        com.baidu.navisdk.module.asr.i.b(com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.e.d().a(z2));
                        break;
                    }
                }
                break;
            case 14:
                RoutePlanNode c3 = com.baidu.navisdk.ui.routeguide.control.l.l().c();
                str = c3 != null ? c3.getName() : "";
                if (z2) {
                    if (TextUtils.isEmpty(str)) {
                        string3 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_sdk_change_route_success);
                    } else {
                        string3 = JarUtils.getResources().getString(R.string.nsdk_string_rg_voice_change_route_success, str);
                    }
                } else if (e(i2)) {
                    string3 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_vdr_intercept_recal_route_tip);
                } else if (d(i2)) {
                    string3 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_intercept_pre_yawing_route_tip);
                } else if (TextUtils.isEmpty(str)) {
                    string3 = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_route_plan_fail);
                } else {
                    string3 = JarUtils.getResources().getString(R.string.asr_rg_error_planing_select_route, str);
                }
                com.baidu.navisdk.ui.routeguide.control.s.T().a(string3, z2);
                break;
        }
        if (z2) {
            com.baidu.navisdk.ui.routeguide.control.s.T().a(true, com.baidu.navisdk.module.pronavi.a.p == 9);
        }
    }

    public void b(boolean z2) {
        if (com.baidu.navisdk.j.d()) {
            if (com.baidu.navisdk.module.vehiclemanager.b.i().b() != 1) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
                if (gVar.d()) {
                    gVar.e("sendParamsToDuHelper, not car");
                    return;
                }
                return;
            }
            if (com.baidu.navisdk.module.pronavi.a.j == 2) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
                if (gVar2.d()) {
                    gVar2.e("sendParamsToDuHelper, is demo");
                    return;
                }
                return;
            }
            if (this.A.d() != 1) {
                com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
                if (gVar3.d()) {
                    gVar3.e("sendParamsToDuHelper scene is" + this.A.d());
                    return;
                }
                return;
            }
            try {
                Bundle bundle = new Bundle();
                JSONObject jSONObject = new JSONObject();
                com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
                RoutePlanNode routePlanNode = this.h0;
                if (routePlanNode != null) {
                    jSONObject.put("start_pt", a(routePlanNode));
                }
                if (fVar.g() != null) {
                    jSONObject.put("end_pt", a(fVar.g()));
                }
                ArrayList<com.baidu.navisdk.module.nearbysearch.model.a> e2 = com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.e();
                if (e2.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i2 = 0; i2 < e2.size(); i2++) {
                        jSONArray.put(a(e2.get(i2)));
                    }
                    jSONObject.put("way_pt", jSONArray);
                }
                jSONObject.put("is_arrival", com.baidu.navisdk.naviresult.a.d().a().j() ? 1 : 0);
                jSONObject.put("is_closed", z2 ? 1 : 0);
                jSONObject.put("remaining_dis", com.baidu.navisdk.ui.routeguide.model.a0.I().l());
                String currentUUID = JNITrajectoryControl.sInstance.getCurrentUUID();
                if (!l0.c(currentUUID)) {
                    jSONObject.put("travelled_dis", JNITrajectoryControl.sInstance.getTrajectoryLength(currentUUID));
                } else {
                    jSONObject.put("travelled_dis", 0);
                }
                com.baidu.navisdk.model.datastruct.g a2 = com.baidu.navisdk.util.logic.g.j().a();
                if (a2 != null) {
                    jSONObject.put("cur_loc", com.baidu.navisdk.util.common.o.c(a2.b, a2.f6926a));
                }
                jSONObject.put("cur_tm", (int) (System.currentTimeMillis() / 1000));
                com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.ROUTE_GUIDE;
                if (gVar4.d()) {
                    gVar4.e("sendParamsToDuHelper " + jSONObject);
                }
                bundle.putString("ai_cardata", jSONObject.toString());
                com.baidu.navisdk.framework.b.g(bundle);
            } catch (Exception unused) {
            }
        }
    }

    private JSONObject a(RoutePlanNode routePlanNode) {
        if (routePlanNode == null) {
            return null;
        }
        String c2 = com.baidu.navisdk.util.common.o.c(routePlanNode.getLongitudeE6() / 100000.0d, routePlanNode.getLatitudeE6() / 100000.0d);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loc", c2);
            jSONObject.put("city_id", routePlanNode.getDistrictID());
            jSONObject.put("uid", routePlanNode.getUID());
            jSONObject.put("name", routePlanNode.getName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void b(Bundle bundle) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("parseConfigParams-> configParams:");
            sb.append(bundle == null ? null : bundle.toString());
            gVar.e("BNavigatorLogic", sb.toString());
        }
        if (bundle == null) {
            return;
        }
        this.A.a(bundle);
        int i2 = 0;
        if (bundle.containsKey("car_result_has_show_anim")) {
            this.c0 = bundle.getBoolean("car_result_has_show_anim");
        } else {
            this.c0 = false;
        }
        int g2 = this.A.g();
        int d2 = this.A.d();
        com.baidu.navisdk.ui.routeguide.utils.c.f(this.A.g());
        com.baidu.navisdk.function.c.a(com.baidu.navisdk.q.a(g2, d2));
        s().e(g2);
        com.baidu.navisdk.module.vehiclemanager.b.i().a(g2, this.A.f(), 6);
        if (com.baidu.navisdk.module.newguide.a.e().d()) {
            com.baidu.navisdk.module.pronavi.a.s = true;
        }
        if (this.A.o()) {
            i2 = 1;
        } else if (this.A.f() == 1) {
            i2 = 2;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a(g2, i2);
        G().d(this.A.p());
        com.baidu.navisdk.ui.routeguide.control.w.b(bundle);
        if (TextUtils.isEmpty(this.A.c())) {
            return;
        }
        String str = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g().mUID;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().b(this.A.c());
        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().a(str);
    }

    private String a(Context context, boolean z2, boolean z3) {
        if (!z2 || context == null) {
            return "未知路";
        }
        String a2 = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).a(context, z3);
        return !TextUtils.isEmpty(a2) ? a2 : "未知路";
    }

    public void a(boolean z2) {
        if (Build.VERSION.SDK_INT < 23 && com.baidu.navisdk.ui.routeguide.b.V().b() != null) {
            int i2 = Settings.Secure.getInt(com.baidu.navisdk.ui.routeguide.b.V().b().getContentResolver(), "mock_location", 0);
            if (i2 == 1 && com.baidu.navisdk.module.a.h().a() != null) {
                com.baidu.navisdk.module.a.h().a().d = false;
            }
            if (i2 != 1 || com.baidu.navisdk.module.pronavi.model.h.c) {
                return;
            }
            com.baidu.navisdk.module.pronavi.model.h.c = true;
            if (!z2) {
                com.baidu.navisdk.util.worker.c.a().a(this.k0.g(), new com.baidu.navisdk.util.worker.e(2, 0), 10000L);
                return;
            }
            Context context = this.d;
            if (context != null) {
                TipTool.onCreateToastDialog(context, JarUtils.getResources().getString(R.string.nsdk_string_rg_mock_gps_open));
            }
        }
    }

    public void a(ViewGroup viewGroup, View view, int i2) {
        com.baidu.navisdk.ui.routeguide.control.x.b().a(c(), viewGroup, view, this.s, i2);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().I().b(false);
        this.I.a(this.d, viewGroup);
    }

    private void a(Configuration configuration, boolean z2) {
        boolean isInPictureInPictureMode;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.a()) {
            gVar.a("BNavigatorLogic", "onRotationEvent changed to " + configuration.orientation + "old:" + com.baidu.navisdk.module.pronavi.model.h.f7469a);
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.MAP;
        if (gVar2.d()) {
            gVar2.e("kpkkikkpk", "onConfigurationChanged:" + configuration.orientation);
        }
        if (c() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            isInPictureInPictureMode = c().isInPictureInPictureMode();
            if (isInPictureInPictureMode) {
                return;
            }
        }
        if (z2 && U() && L()) {
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "onRotationEvent changed isBackground ");
                return;
            }
            return;
        }
        int i2 = configuration.orientation;
        BNMapController.getInstance().notifyOrientation(i2 == 1);
        if (i2 != com.baidu.navisdk.module.pronavi.model.h.f7469a) {
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "Orientation changed!");
            }
            ScreenUtil.getInstance().resetStatusBarHeight(c());
            com.baidu.navisdk.ui.routeguide.utils.g gVar3 = this.X;
            if (gVar3 != null) {
                gVar3.a(true, configuration);
            }
            com.baidu.navisdk.ui.routeguide.control.x.b().s();
            com.baidu.navisdk.util.statistic.userop.b.r().b("1.6");
            if (i2 == 1) {
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410275", "410275");
            } else {
                com.baidu.navisdk.comapi.statistics.b.f().a(com.baidu.navisdk.framework.a.c().a(), "410274", "410274");
            }
            if (i2 == 2) {
                ProNaviStatItem.O().H();
            } else {
                ProNaviStatItem.O().E();
            }
            com.baidu.navisdk.module.pronavi.model.h.f7469a = i2;
            com.baidu.navisdk.ui.routeguide.model.g.h().a(true);
            boolean a2 = com.baidu.navisdk.ui.routeguide.model.g.h().a();
            String b2 = com.baidu.navisdk.ui.routeguide.model.g.h().b();
            com.baidu.navisdk.ui.routeguide.ace.a.m().a(configuration.orientation);
            com.baidu.navisdk.ui.routeguide.control.x.b().a(configuration);
            if (g() != null) {
                g().a(configuration, this.L);
            }
            H0();
            if (a2 && !RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.NearbySearch) && com.baidu.navisdk.module.cloudconfig.f.c().p.f7137a) {
                G().c(false);
            }
            if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.NearbySearch) && com.baidu.navisdk.poisearch.model.a.k().h()) {
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "onActionMapStatus --> ORIENTATION_CHANGE");
                }
                if (com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.d.l().e()) {
                    com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.d.l().j();
                } else if (com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.b.b().a().d()) {
                    com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.b.b().a().a();
                } else {
                    com.baidu.navisdk.ui.routeguide.control.r.i().a(com.baidu.navisdk.poisearch.model.a.k().j, true);
                }
                BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), true);
            }
            if (RouteGuideParams.NavState.NAV_STATE_OPERATE.equals(b2)) {
                if (com.baidu.navisdk.poisearch.model.b.m().k()) {
                    com.baidu.navisdk.ui.routeguide.control.x.b().s4();
                } else if (com.baidu.navisdk.poisearch.model.b.m().h()) {
                    com.baidu.navisdk.ui.routeguide.control.x.b().u4();
                } else if (!RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.NearbySearch)) {
                    com.baidu.navisdk.ui.routeguide.control.r.i().f();
                }
            }
            com.baidu.navisdk.ui.routeguide.control.s.T().A();
            com.baidu.navisdk.ui.routeguide.control.i.g().e();
            com.baidu.navisdk.ui.routeguide.model.g.h().a(false);
        } else {
            ScreenUtil.getInstance().init(c());
            com.baidu.navisdk.pronavi.util.a aVar = com.baidu.navisdk.pronavi.util.a.h;
            if (aVar.i()) {
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "onConfigurationChanged3: isWideScreen");
                }
                ScreenUtil.getInstance().resetStatusBarHeight(c());
                com.baidu.navisdk.ui.routeguide.control.x.b().l3();
                H0();
            }
            if (aVar.g()) {
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "onConfigurationChanged4: isChangeFoldState");
                }
                if (!aVar.i()) {
                    ScreenUtil.getInstance().resetStatusBarHeight(c());
                    com.baidu.navisdk.ui.routeguide.control.x.b().l3();
                    H0();
                }
                com.baidu.navisdk.ui.routeguide.control.x.b().C3();
                com.baidu.navisdk.ui.routeguide.control.x.b().G3();
            }
            com.baidu.navisdk.ui.routeguide.utils.g gVar4 = this.X;
            if (gVar4 != null) {
                gVar4.a(false, configuration);
            }
        }
        if (com.baidu.navisdk.ui.routeguide.control.x.b().K2() && com.baidu.navisdk.j.d()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().a(this.V, this.W, true);
        }
        if (com.baidu.navisdk.ui.routeguide.model.g.i) {
            com.baidu.navisdk.ui.routeguide.control.x.b().w4();
        }
        com.baidu.navisdk.i.b().a();
        if (com.baidu.navisdk.ui.routeguide.model.g.j) {
            com.baidu.navisdk.ui.routeguide.control.x.b().x4();
        }
        if (com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.d.l().e()) {
            com.baidu.navisdk.ui.routeguide.asr.xdvoice.busi.d.l().j();
        }
        com.baidu.navisdk.ugc.replenishdetails.d.o().k();
        if (com.baidu.navisdk.pronavi.util.a.h.i()) {
            com.baidu.navisdk.util.statistic.userop.b.r().b("w.s.1.1");
        }
        BNMapController.getInstance().setSimpleModeGuide(!com.baidu.navisdk.ui.routeguide.utils.b.x());
    }

    public void b(int i2) {
        boolean e2 = s().e();
        boolean z2 = (s().b() & 32) != 0;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNavigatorLogic", "judgePlateChange -> isCurOpen = " + e2 + ", isLastOpen = " + z2);
        }
        if (e2 != z2) {
            if (e2 && TextUtils.isEmpty(s().c())) {
                s().a(false);
                return;
            } else {
                com.baidu.navisdk.ui.routeguide.model.a0.G = 3;
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().G(7);
            }
        }
        com.baidu.navisdk.ui.routeguide.subview.a aVar = this.s;
        if (aVar != null) {
            aVar.h();
        }
    }

    public int b(AudioManager audioManager, int i2) {
        a(audioManager);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("adjustVolume Up", "volume = " + TTSPlayerControl.getCurrentVolume());
        }
        int streamVolume = audioManager.getStreamVolume(3);
        audioManager.adjustStreamVolume(3, 1, 8);
        int streamVolume2 = audioManager.getStreamVolume(3);
        int currentVolume = TTSPlayerControl.getCurrentVolume();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(streamVolume2, streamVolume, i2, currentVolume, true);
        if (com.baidu.navisdk.function.b.FUNC_SUPPORT_TTS_VOLUME_INCREASE.a()) {
            int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "adjustVolumeUpKeyDown voiceMode: " + voiceMode);
            }
            if (voiceMode == 0) {
                com.baidu.navisdk.ui.routeguide.tts.a.a().a(this.d.getApplicationContext(), streamVolume, streamVolume2, true, i2, currentVolume);
            }
        }
        return streamVolume2;
    }

    public void a(int i2, Bundle bundle) {
        com.baidu.navisdk.model.datastruct.t tVar;
        ArrayList<com.baidu.navisdk.model.datastruct.s> g2;
        com.baidu.navisdk.model.datastruct.s sVar;
        GeoPoint geoPoint;
        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
            if (com.baidu.navisdk.poisearch.model.a.k().e() > -1) {
                BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
                BNMapController.getInstance().updateLayer(4);
                if (com.baidu.navisdk.poisearch.model.a.k().e() == i2) {
                    com.baidu.navisdk.ui.routeguide.control.x.b().g1();
                    com.baidu.navisdk.ui.routeguide.control.x.b().q1();
                    com.baidu.navisdk.ui.routeguide.control.x.b().B0();
                    com.baidu.navisdk.poisearch.model.b.m().d(false);
                    com.baidu.navisdk.poisearch.model.b.m().b(false);
                    com.baidu.navisdk.poisearch.model.b.m().a(false);
                    com.baidu.navisdk.poisearch.model.a.k().j();
                    return;
                }
                com.baidu.navisdk.poisearch.model.a.k().j();
            }
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.TOUCH_MAP);
            List<com.baidu.navisdk.model.datastruct.t> d2 = ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).d();
            if (d2 == null || d2.size() < 1 || (tVar = d2.get(0)) == null || (g2 = tVar.g()) == null || i2 < 0 || i2 >= g2.size() || (geoPoint = (sVar = g2.get(i2)).k) == null || !geoPoint.isValid()) {
                return;
            }
            if (TextUtils.isEmpty(sVar.g)) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "handleBkgClick return searchPoi mAddress is null");
                    return;
                }
                return;
            }
            if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.c(sVar.k)) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e("BNavigatorLogic", "handleBkgClick return isViaPoint");
                    return;
                }
                return;
            }
            int i3 = (bundle == null || !bundle.containsKey(MapParams.PoiSearchKey.KEY_BKG_CLICK_TYPE)) ? 0 : bundle.getInt(MapParams.PoiSearchKey.KEY_BKG_CLICK_TYPE);
            sVar.v = i3;
            boolean z2 = (bundle == null || !bundle.containsKey(MapParams.PoiSearchKey.KEY_BKG_ROUTE_VIA_FAST_LABEL)) ? false : bundle.getBoolean(MapParams.PoiSearchKey.KEY_BKG_ROUTE_VIA_FAST_LABEL);
            sVar.w = z2;
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.3.4", "" + (i3 + 1), null, null);
            if (z2) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("2.a.a", "2", null, null);
            }
            BNMapController.getInstance().focusItem(4, i2, true);
            com.baidu.navisdk.poisearch.model.b.m().b(sVar.k);
            com.baidu.navisdk.poisearch.model.b.m().a(sVar);
            com.baidu.navisdk.ui.routeguide.control.x.b().z0 = false;
            com.baidu.navisdk.ui.routeguide.control.x.b().W4();
            com.baidu.navisdk.ui.routeguide.control.x.b().j4();
            com.baidu.navisdk.poisearch.model.a.k().c(i2);
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.p.2", null, "2", null);
        com.baidu.navisdk.ui.routeguide.control.f.k().a(i2);
    }

    public void a(com.baidu.navisdk.model.datastruct.n nVar) {
        GeoPoint geoPoint;
        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
            BNMapController.getInstance().focusItem(4, com.baidu.navisdk.poisearch.model.a.k().e(), false);
            BNMapController.getInstance().updateLayer(4);
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().g1();
        com.baidu.navisdk.ui.routeguide.control.x.b().q1();
        com.baidu.navisdk.poisearch.model.b.m().d(false);
        com.baidu.navisdk.poisearch.model.b.m().b(false);
        com.baidu.navisdk.poisearch.model.a.k().j();
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.TOUCH_MAP);
        if (nVar == null || TextUtils.isEmpty(nVar.f6936a) || (geoPoint = nVar.d) == null || !geoPoint.isValid()) {
            return;
        }
        if (com.baidu.navisdk.module.nearbysearch.model.b.INSTANCE.c(nVar.d)) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "handleBkgClick return isViaPoint");
                return;
            }
            return;
        }
        com.baidu.navisdk.poisearch.model.b.m().b(nVar.d);
        com.baidu.navisdk.poisearch.model.b.m().a(nVar);
        com.baidu.navisdk.ui.routeguide.control.x.b().W4();
        com.baidu.navisdk.ui.routeguide.control.x.b().u4();
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.g.3.1", BNRouteNearbySearchUtils.getRouteAroundOpsTypeByStyleId(nVar.c), null, null);
    }

    public void a(int i2, boolean z2) {
        com.baidu.navisdk.ui.routeguide.model.x.A().f8982a = false;
        String str = com.baidu.navisdk.ui.routeguide.model.x.A().r + "";
        int j2 = com.baidu.navisdk.ui.routeguide.model.x.A().j();
        if (i2 == 3) {
            String str2 = z2 ? "2" : "0";
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.7", "" + j2, str2, str);
            a(com.baidu.navisdk.ui.routeguide.model.x.A().k());
            com.baidu.navisdk.ui.routeguide.control.s.T().a(true, i2);
            return;
        }
        com.baidu.navisdk.ui.routeguide.control.s.T().a(false, i2);
        com.baidu.navisdk.ui.routeguide.control.s.T().D();
        String str3 = z2 ? "3" : "1";
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.s.7", "" + j2, str3, str);
        String h2 = com.baidu.navisdk.ui.util.b.h(R.string.asr_rg_switch_route_cancel);
        if (z2) {
            TTSPlayerControl.playXDTTSText(h2, 1);
        } else {
            TTSPlayerControl.playTTS(h2, 1);
        }
        if (j2 == 9) {
            com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_weak_fast_route_no"));
        }
    }

    public void a(int i2) {
        if (i2 < 0) {
            return;
        }
        BNRoutePlaner.getInstance().n(i2);
        BNMapController.getInstance().updateLayer(10);
        BNMapController.getInstance().clearLayer(23);
    }

    public void a(String str, boolean z2, Bundle bundle) {
        if (com.baidu.navisdk.poisearch.model.a.k().h()) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNavigatorLogic", "showUgcDetailViewSource return by isRouteSearchMode");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.ui.routeguide.model.a0.I().D()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("BNavigatorLogic", "showUgcDetailViewSource return isyawing");
                return;
            }
            return;
        }
        if (!z2) {
            Context context = this.d;
            if (context != null) {
                TipTool.onCreateToastDialog(context, "感谢您的反馈，我们将尽快处理");
                return;
            }
            return;
        }
        com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        this.V = str;
        this.W = bundle;
        com.baidu.navisdk.ui.routeguide.control.x.b().a(str, bundle, false);
    }

    public void a(Bundle bundle) {
        if (!com.baidu.navisdk.ui.util.b.b() && com.baidu.navisdk.ui.routeguide.b.V().b() != null) {
            com.baidu.navisdk.framework.b.a(com.baidu.navisdk.ui.routeguide.b.V().b().getWindow(), com.baidu.navisdk.ui.util.b.b());
        }
        this.k = true;
        this.b0 = true;
        String string = (bundle == null || !bundle.containsKey("from_page")) ? null : bundle.getString("from_page");
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append("onNavPageToTop -> bundle = ");
            sb.append(bundle == null ? "null" : bundle.toString());
            gVar.e("BNavigatorLogic", sb.toString());
        }
        com.baidu.navisdk.ui.routeguide.control.x.b().a(string);
        if (com.baidu.navisdk.ui.routeguide.control.x.b().q2()) {
            com.baidu.navisdk.ui.routeguide.control.x.b().g3();
        } else if (!l0.c(string)) {
            if (string.equals("componentPanoClose")) {
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "onNavPageToTop -> FROM_COMPONENT_PANO");
                }
            } else if (string.equals("location_share")) {
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "onNavPageToTop -> FROM_LOCATION_SHARE");
                }
            } else if (string.equals("car_owner_plate_setting")) {
                if (gVar.d()) {
                    gVar.e("BNavigatorLogic", "onNavPageToTop -> FROM_CAR_OWNER_PLATE_SETTING");
                }
                if (!com.baidu.navisdk.module.newguide.a.e().d()) {
                    b(0);
                }
            }
        }
        com.baidu.navisdk.module.powersavemode.f.o().onForeground();
        com.baidu.navisdk.ui.routeguide.asr.c.n().k();
        com.baidu.navisdk.ui.routeguide.utils.g gVar2 = this.X;
        if (gVar2 != null) {
            gVar2.f();
        } else if (com.baidu.navisdk.module.newguide.a.e().d()) {
            com.baidu.navisdk.module.newguide.controllers.c.b();
        }
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.c("asr_e_s_back_to_navi"));
    }

    public int a(AudioManager audioManager, int i2) {
        a(audioManager);
        int streamVolume = audioManager.getStreamVolume(3);
        audioManager.adjustStreamVolume(3, -1, 8);
        int streamVolume2 = audioManager.getStreamVolume(3);
        int currentVolume = TTSPlayerControl.getCurrentVolume();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().a(streamVolume2, streamVolume, i2, currentVolume, false);
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("adjustVolume Down", "volume = " + currentVolume);
        }
        if (com.baidu.navisdk.function.b.FUNC_SUPPORT_TTS_VOLUME_INCREASE.a()) {
            com.baidu.navisdk.ui.routeguide.tts.a.a().a(this.d.getApplicationContext(), streamVolume, streamVolume2, false, i2, currentVolume);
        }
        return streamVolume2;
    }

    private void a(AudioManager audioManager) {
        audioManager.adjustStreamVolume(3, 0, 0);
    }

    public void a(String str, String str2, double d2, double d3, int i2) {
        com.baidu.navisdk.ui.routeguide.control.indoorpark.c.F().a(str, str2, d2, d3, i2);
    }
}
