package com.baidu.navisdk.adapter.impl;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import com.baidu.baidunavis.baseline.BNOuterMapViewManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.map.AppResList;
import com.baidu.mapsdkplatform.comapi.map.VersionInfo;
import com.baidu.navisdk.adapter.BaiduNaviManagerFactory;
import com.baidu.navisdk.adapter.IBaiduNaviManager;
import com.baidu.navisdk.adapter.impl.base.BNaviAuthManager;
import com.baidu.navisdk.adapter.impl.base.mapsensor.b;
import com.baidu.navisdk.adapter.struct.BNaviInitConfig;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.framework.interfaces.s;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.logic.j;
import com.baidu.platform.comapi.JNIInitializer;

/* loaded from: classes7.dex */
public final class BaiduNaviManager implements IBaiduNaviManager {
    private static final String e = "BaiduNaviManager";
    private static BaiduNaviManager f;

    /* renamed from: a, reason: collision with root package name */
    private Context f6484a = null;
    private long b = 0;
    private final b.c c = new b.c() { // from class: com.baidu.navisdk.adapter.impl.BaiduNaviManager.1
        @Override // com.baidu.navisdk.adapter.impl.base.mapsensor.b.InterfaceC0160b
        public void onSensorChanged(int i) {
        }

        @Override // com.baidu.navisdk.adapter.impl.base.mapsensor.b.c
        public void onSensorChanged(int i, float[] fArr) {
            if (SystemClock.elapsedRealtime() - BaiduNaviManager.this.b < 80) {
                return;
            }
            BaiduNaviManager.this.b = SystemClock.elapsedRealtime();
            BaiduNaviManager.this.a(i);
            BaiduNaviManager.this.a(i, (float) Math.toDegrees(fArr[1]), (float) Math.toDegrees(fArr[2]));
        }
    };
    private final com.baidu.navisdk.comapi.geolocate.a d = new com.baidu.navisdk.comapi.geolocate.a() { // from class: com.baidu.navisdk.adapter.impl.BaiduNaviManager.2
        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar) {
        }

        @Override // com.baidu.navisdk.comapi.geolocate.b
        public void onWGS84LocationChange(com.baidu.navisdk.model.datastruct.g gVar, com.baidu.navisdk.model.datastruct.g gVar2) {
            int i;
            if (gVar.k == 1) {
                int i2 = gVar.l;
                if (i2 == 1) {
                    i = 1;
                } else if (i2 == 0) {
                    i = 2;
                } else {
                    i = 0;
                }
                BNRouteGuider.getInstance().triggerStartLocationData((int) (gVar.b * 100000.0d), (int) (gVar.f6926a * 100000.0d), (float) gVar.h, gVar.c, gVar.e, gVar.f, 1.0f, 0, i, gVar.j);
            }
        }
    };

    public static BaiduNaviManager d() {
        if (f == null) {
            f = new BaiduNaviManager();
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        BaiduNaviManagerFactory.getCommonSettingManager().setDIYImageStatus(true, 0);
        BaiduNaviManagerFactory.getCommonSettingManager().setDIYImageStatus(true, 1);
        BaiduNaviManagerFactory.getCommonSettingManager().setDIYImageStatus(true, 2);
        BaiduNaviManagerFactory.getCommonSettingManager().setDIYImageStatus(true, 3);
        if (!BNaviAuthManager.getInstance().hasHdNaviPermission()) {
            c.f().a();
        } else {
            c.f().d();
        }
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public void enableOutLog(boolean z) {
        com.baidu.navisdk.util.common.g.c0 = z;
        LogUtil.OUT_LOGGABLE = z;
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public void externalLocation(boolean z) {
        if (z) {
            LogUtil.out("gps", "externalLocation 1");
            j.r().i();
            com.baidu.navisdk.j.b(true);
        } else {
            LogUtil.out("gps", "externalLocation 0");
            com.baidu.navisdk.j.b(false);
            j.r().a(this.f6484a);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public String getCUID() {
        return a0.e();
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public String getSDKVersion() {
        return com.baidu.navisdk.j.b();
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public void init(final Context context, final BNaviInitConfig bNaviInitConfig) {
        final IBaiduNaviManager.INaviInitListener naviInitListener = bNaviInitConfig.getNaviInitListener();
        if (LogUtil.OUT_LOGGABLE) {
            LogUtil.out(e, "init() context=" + context + ", naviInitListener=" + naviInitListener);
        }
        if (context == null) {
            LogUtil.out(e, "init() return for null.");
            if (naviInitListener != null) {
                naviInitListener.initFailed(1);
                return;
            }
            return;
        }
        if (isInited()) {
            LogUtil.out(e, "init() return for inited.");
            if (naviInitListener != null) {
                naviInitListener.initSuccess();
                return;
            }
            return;
        }
        this.f6484a = context.getApplicationContext();
        com.baidu.navisdk.framework.a.c().a(this.f6484a);
        String sdcardRootPath = bNaviInitConfig.getSdcardRootPath();
        if (sdcardRootPath == null) {
            sdcardRootPath = context.getExternalFilesDir(null).getPath();
        }
        final String str = sdcardRootPath;
        com.baidu.navcore.model.a.b().a(str, "BaiduNavi");
        com.baidu.navcore.model.a.b().a();
        new Thread("Nav-Auth") { // from class: com.baidu.navisdk.adapter.impl.BaiduNaviManager.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                LogUtil.out(BaiduNaviManager.e, "Nav-Auth thread start.");
                BaiduNaviManager.this.b();
                JNIInitializer.attach((Application) context.getApplicationContext(), true, false, false, true);
                JNIInitializer.initEngine();
                JNIInitializer.initEngineResource(new AppResList());
                BNaviAuthManager.getInstance().authenticate(new LBSAuthManagerListener() { // from class: com.baidu.navisdk.adapter.impl.BaiduNaviManager.3.1
                    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
                    public void onAuthResult(int i, String str2) {
                        BNaviAuthManager.getInstance().setAuthManagerListener(null);
                        IBaiduNaviManager.INaviInitListener iNaviInitListener = naviInitListener;
                        if (iNaviInitListener != null) {
                            iNaviInitListener.onAuthResult(i, str2);
                            if (i != 0) {
                                naviInitListener.initFailed(10);
                                return;
                            }
                        }
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        BaiduNaviManager.this.a(context, str, bNaviInitConfig);
                    }
                });
            }
        }.start();
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public void initSensor() {
        LogUtil.out(e, "initSensor");
        try {
            com.baidu.navisdk.adapter.impl.base.mapsensor.b.c().b();
            com.baidu.navisdk.adapter.impl.base.mapsensor.b.c().a(this.c);
        } catch (Throwable th) {
            if (LogUtil.LOGGABLE) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public boolean isInited() {
        return com.baidu.navisdk.module.init.a.a();
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public void setGpsNeverClose(boolean z) {
        BNSettingManager.setGpsNeverClose(z);
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public void setVdrEnable(boolean z) {
        s l = com.baidu.navisdk.framework.interfaces.c.p().l();
        if (l != null) {
            l.k(z);
        }
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public void startLocationMonitor() {
        j.r().a(this.d);
        j.r().a(a());
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public void stopLocationMonitor() {
        j.r().b(this.d);
        j.r().i();
    }

    @Override // com.baidu.navisdk.adapter.IBaiduNaviManager
    public void unInitSensor() {
        LogUtil.out(e, "unInitSensor");
        try {
            com.baidu.navisdk.adapter.impl.base.mapsensor.b.h();
        } catch (Throwable th) {
            if (LogUtil.LOGGABLE) {
                th.printStackTrace();
            }
        }
    }

    public void b() {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        for (int i = 0; i < 2 && !a("app_BaiduNaviApplib"); i++) {
        }
    }

    public boolean a(String str) {
        System.loadLibrary(str);
        return true;
    }

    public Context a() {
        return this.f6484a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, BNaviInitConfig bNaviInitConfig) {
        final IBaiduNaviManager.INaviInitListener naviInitListener = bNaviInitConfig.getNaviInitListener();
        i.a().a(context, str, "BaiduNavi", "arm", new com.baidu.navisdk.framework.interfaces.b() { // from class: com.baidu.navisdk.adapter.impl.BaiduNaviManager.4
            @Override // com.baidu.navisdk.framework.interfaces.b
            public void initFailed(int i) {
                LogUtil.out(BaiduNaviManager.e, "engineInitFail");
                com.baidu.navisdk.util.statistic.userop.b.r().a("4.0.20.1671", "0", i + "");
                IBaiduNaviManager.INaviInitListener iNaviInitListener = naviInitListener;
                if (iNaviInitListener != null) {
                    iNaviInitListener.initFailed(i);
                }
            }

            @Override // com.baidu.navisdk.framework.interfaces.b
            public void initStart() {
                LogUtil.out(BaiduNaviManager.e, "engineInitStart");
                IBaiduNaviManager.INaviInitListener iNaviInitListener = naviInitListener;
                if (iNaviInitListener != null) {
                    iNaviInitListener.initStart();
                }
            }

            @Override // com.baidu.navisdk.framework.interfaces.b
            public void initSuccess(boolean z) {
                LogUtil.out(BaiduNaviManager.e, "engineInitSuccess");
                BNOuterMapViewManager.getInstance().unRegisterLongLink();
                BaiduNaviManager.this.initSensor();
                BaiduNaviManager.this.e();
                boolean routePlanTokenParam = JNIGuidanceControl.getInstance().setRoutePlanTokenParam(BNaviAuthManager.getInstance().getToken());
                LogUtil.out(BaiduNaviManager.e, "setRoutePlanTokenParam success = " + routePlanTokenParam);
                com.baidu.navisdk.util.statistic.userop.b.r().d("4.0.20.1671", "1");
                IBaiduNaviManager.INaviInitListener iNaviInitListener = naviInitListener;
                if (iNaviInitListener != null) {
                    iNaviInitListener.initSuccess();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (com.baidu.navisdk.module.init.a.a()) {
            BNRoutePlaner.getInstance().a(i, 1.0d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2, float f3, float f4) {
        if (com.baidu.navisdk.module.init.a.a()) {
            BNRoutePlaner.getInstance().a(f2, f3, f4);
        }
    }
}
