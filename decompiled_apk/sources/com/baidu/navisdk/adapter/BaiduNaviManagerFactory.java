package com.baidu.navisdk.adapter;

import com.baidu.baidunavis.baseline.BNOuterMapViewManager;
import com.baidu.navcore.tts.BaseTTSPlayer;
import com.baidu.navisdk.adapter.IBNOuterSettingManager;
import com.baidu.navisdk.adapter.impl.BNRouteResultManager;
import com.baidu.navisdk.adapter.impl.BaiduNaviManager;
import com.baidu.navisdk.adapter.impl.a;
import com.baidu.navisdk.adapter.impl.b;
import com.baidu.navisdk.adapter.impl.c;
import com.baidu.navisdk.adapter.impl.d;
import com.baidu.navisdk.adapter.impl.f;

/* loaded from: classes7.dex */
public class BaiduNaviManagerFactory {
    public static IBaiduNaviManager getBaiduNaviManager() {
        return BaiduNaviManager.d();
    }

    public static IBNOuterSettingManager.IBNCommonSetting getCommonSettingManager() {
        return b.a();
    }

    public static IBNCruiserManager getCruiserManager() {
        return a.a();
    }

    public static IBNLightNaviManager getLightNaviManager() {
        return f.e();
    }

    public static IBNOuterSettingManager.IBNLightNaviSetting getLightNaviSettingManager() {
        return b.b();
    }

    public static IBNMapManager getMapManager() {
        return BNOuterMapViewManager.getInstance();
    }

    public static IBNOuterSettingManager.IBNProfessionalNaviSetting getProfessionalNaviSettingManager() {
        return b.c();
    }

    public static IBNRouteGuideManager getRouteGuideManager() {
        return c.f();
    }

    public static IBNRoutePlanManager getRoutePlanManager() {
        return d.b();
    }

    public static IBNRouteResultManager getRouteResultManager() {
        return BNRouteResultManager.f();
    }

    public static IBNOuterSettingManager.IBNRouteResultSetting getRouteResultSettingManager() {
        return b.d();
    }

    public static IBNTTSManager getTTSManager() {
        return BaseTTSPlayer.j();
    }
}
