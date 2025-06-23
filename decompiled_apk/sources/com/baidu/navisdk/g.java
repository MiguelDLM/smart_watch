package com.baidu.navisdk;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.jni.nativeif.JNINaviManager;
import com.baidu.navisdk.jni.nativeif.JNIVoicePersonalityControl;
import com.baidu.navisdk.model.datastruct.EngineCommonConfig;
import com.baidu.navisdk.module.longlink.JNILonglinkControl;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.m0;
import com.baidu.nplatform.comjni.engine.AppEngine;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class g {
    private static volatile g c;

    /* renamed from: a, reason: collision with root package name */
    private JNINaviManager f6857a;
    public boolean b;

    private g() {
        this.f6857a = null;
        this.f6857a = JNINaviManager.sInstance;
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            try {
                if (c == null) {
                    synchronized (g.class) {
                        try {
                            if (c == null) {
                                c = new g();
                            }
                        } finally {
                        }
                    }
                }
                gVar = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    public void b(int i) {
        JNINaviManager jNINaviManager = this.f6857a;
        if (jNINaviManager == null) {
            return;
        }
        try {
            jNINaviManager.updateAppSource(i);
        } catch (Throwable th) {
            if (com.baidu.navisdk.util.common.g.F_BASE.c()) {
                com.baidu.navisdk.util.common.g.F_BASE.c("changeNaviStatisticsNetworkStatus e:" + th.getLocalizedMessage());
            }
        }
    }

    public boolean a(EngineCommonConfig engineCommonConfig, Handler handler) {
        return a(engineCommonConfig);
    }

    @SuppressLint({"WrongConstant"})
    public boolean a(EngineCommonConfig engineCommonConfig) {
        VoiceInterfaceImplProxy o;
        String str;
        LogUtil.e("Common", "initEngineBySync");
        com.baidu.navisdk.util.statistic.r.s().q();
        m0.j().g();
        Bundle h = m0.j().h();
        h.putBoolean("showlog", BNSettingManager.isShowNativeLog());
        com.baidu.navisdk.module.perform.b.d().b("navi_init_engine");
        LogUtil.e("Common", "initEngineBySync InitEngine start");
        boolean InitEngine = AppEngine.InitEngine(h);
        LogUtil.e("Common", "initEngineBySync InitEngine flag :" + InitEngine);
        if (!InitEngine) {
            AppEngine.UnInitEngine();
            return false;
        }
        LogUtil.e("Common", "NaviEngineManager initNaviManager");
        LogUtil.e("Common", "NaviEngineManager initNaviManager engineCommonConfig" + engineCommonConfig);
        int init = JNINaviManager.sInstance.init(engineCommonConfig);
        LogUtil.e("Common", "NaviEngineManager initNaviManager ret : " + init);
        if (init == 0) {
            a().b = true;
            JNILonglinkControl.getInstance().initLonglinkServer();
            LogUtil.e("Common", "NaviEngineManager initSubSysHandle GUIDANCE");
            a().a(1);
            LogUtil.e("Common", "NaviEngineManager initSubSysHandle VOICE_TTS");
            a().a(8);
            int prefRoutPlanMode = BNSettingManager.getPrefRoutPlanMode();
            if (prefRoutPlanMode != 2) {
                prefRoutPlanMode = 3;
            }
            int[] iArr = {1, 2, 3};
            int[] iArr2 = {prefRoutPlanMode, com.baidu.navisdk.module.motorbike.preferences.a.u0().A(), com.baidu.navisdk.module.trucknavi.preferences.a.r0().w()};
            if (LogUtil.LOGGABLE) {
                LogUtil.e("Common", "initEngineBySync set vehicles: " + Arrays.toString(iArr) + ", netModes:" + Arrays.toString(iArr2));
            }
            JNIGuidanceControl.getInstance().setMultiRoutePlanUserSetting(BNCommSettingManager.getInstance().getForceSwitch(3), iArr2, iArr, BNCommSettingManager.getInstance().getYawingUseMode(3));
            if (j.d()) {
                BNRouteGuider.getInstance().setLightMossPreferMode(BNSettingManager.getLightCommutePreferMode());
            }
            LogUtil.e("Common", "NaviEngineManager mMengMengDa");
            if (j.d() && (str = engineCommonConfig.mMengMengDaTTSPath) != null && str.length() > 0) {
                LogUtil.e("", "NaviEngineManager copy mengmengda.path=" + engineCommonConfig.mMengMengDaTTSPath);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                LogUtil.e("", "NaviEngineManager copy mengmengda.copyOK=" + JNIVoicePersonalityControl.sInstance.CopyMaiDouPath(engineCommonConfig.mMengMengDaTTSPath) + ", time=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
            }
            if (j.d() && (o = com.baidu.navisdk.framework.interfaces.c.p().o()) != null) {
                o.initTTSSpecText();
            }
            LogUtil.e("Common", "NaviEngineManager after onCreateView Engine");
            BNRoutePlaner.destory();
            BNRoutePlaner.getInstance();
        }
        com.baidu.navisdk.module.perform.b.d().a("navi_init_engine");
        if (!j.d()) {
            com.baidu.navisdk.util.statistic.r.s().n();
        }
        com.baidu.navisdk.util.statistic.r.s().o();
        return init == 0;
    }

    public int a(int i) {
        JNINaviManager jNINaviManager = this.f6857a;
        if (jNINaviManager == null) {
            return 0;
        }
        try {
            jNINaviManager.initSubSystem(i);
        } catch (Throwable th) {
            if (com.baidu.navisdk.util.common.g.F_BASE.c()) {
                com.baidu.navisdk.util.common.g.F_BASE.c("changeNaviStatisticsNetworkStatus e:" + th.getLocalizedMessage());
            }
        }
        return 0;
    }
}
