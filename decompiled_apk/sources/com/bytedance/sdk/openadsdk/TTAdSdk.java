package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.a;
import com.bytedance.sdk.openadsdk.api.c;
import com.bytedance.sdk.openadsdk.api.plugin.f;
import com.bytedance.sdk.openadsdk.live.b;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.MediationManagerVisitor;
import java.util.Map;

/* loaded from: classes8.dex */
public final class TTAdSdk {
    public static final String BRANCH = "";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final String C_H = "620c6b42a8";
    public static final int EXT_API_VERSION_CODE = 999;
    public static final boolean INCLUDE_LIVE = true;
    public static final String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final boolean IS_BOOST = false;
    public static final boolean IS_P = true;
    public static final String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final int SDK_VERSION_CODE = 6317;
    public static final String SDK_VERSION_NAME = "6.3.1.7";
    public static final String S_C = "main";

    /* renamed from: a, reason: collision with root package name */
    private static final a f10652a = new f();
    private static volatile TTAdConfig b;

    /* loaded from: classes8.dex */
    public interface Callback extends InitCallback {
    }

    @Deprecated
    /* loaded from: classes8.dex */
    public interface InitCallback {
        void fail(int i, String str);

        void success();
    }

    private static void a(Context context, TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            c.a();
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            c.a("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        a(context, "Context is null, please check.");
        a(tTAdConfig, "TTAdConfig is null, please check.");
        TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    public static TTAdManager getAdManager() {
        a aVar = f10652a;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public static IMediationManager getMediationManager() {
        if (f10652a != null) {
            return MediationManagerVisitor.getInstance().getMediationManager();
        }
        return null;
    }

    public static boolean init(Context context, TTAdConfig tTAdConfig) {
        b = tTAdConfig;
        a(context, b);
        return true;
    }

    @Deprecated
    public static boolean isInitSuccess() {
        a aVar = f10652a;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public static boolean isOnePointFiveAdType(TTNativeExpressAd tTNativeExpressAd) {
        Map<String, Object> mediaExtraInfo;
        if (tTNativeExpressAd == null) {
            mediaExtraInfo = null;
        } else {
            try {
                mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo();
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mediaExtraInfo != null && mediaExtraInfo.containsKey("_tt_ad_type_onepointfive")) {
            return ((Boolean) mediaExtraInfo.get("_tt_ad_type_onepointfive")).booleanValue();
        }
        return false;
    }

    public static boolean isSdkReady() {
        a aVar = f10652a;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public static void start(Callback callback) {
        a(b, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        a aVar = f10652a;
        if (aVar == null) {
            callback.fail(4100, "Load initializer failed");
        } else {
            aVar.a(TTAppContextHolder.getContext(), b, callback);
        }
    }

    public static void updateAdConfig(TTAdConfig tTAdConfig) {
        a.c b2;
        if (tTAdConfig == null || (b2 = f10652a.b()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (!bundle.keySet().isEmpty()) {
            b2.getExtra(ValueSet.class, bundle);
        }
        IMediationManager mediationManager = getMediationManager();
        if (mediationManager != null) {
            if (tTAdConfig.getCustomController() != null) {
                mediationManager.updatePrivacyConfig(tTAdConfig.getCustomController());
            }
            Map<String, Object> initExtra = tTAdConfig.getInitExtra();
            if (initExtra != null && !initExtra.isEmpty()) {
                mediationManager.updateLocalExtra(tTAdConfig.getInitExtra());
            }
        }
    }

    public static void updateConfigAuth(TTAdConfig tTAdConfig) {
        Object obj;
        if (tTAdConfig == null) {
            return;
        }
        b.a().a(tTAdConfig.getInjectionAuth());
        Map<String, Object> initExtra = tTAdConfig.getInitExtra();
        if (initExtra != null && (obj = initExtra.get(TTAdConstant.KEY_INIT_FOR_LIVE)) != null && (obj instanceof Map)) {
            b.a().a((Map<String, String>) obj);
        }
    }

    public static void updatePaid(boolean z) {
        a.c b2 = f10652a.b();
        if (b2 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (!bundle.keySet().isEmpty()) {
            b2.getExtra(ValueSet.class, bundle);
        }
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }
}
