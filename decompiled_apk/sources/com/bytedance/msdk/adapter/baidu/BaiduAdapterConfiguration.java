package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.internal.cn;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.BaiduMobAds.BuildConfig;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;

/* loaded from: classes8.dex */
public class BaiduAdapterConfiguration extends MediationInitImpl {

    /* renamed from: XO, reason: collision with root package name */
    public volatile boolean f10374XO = false;

    private void a() {
        BaiduAdapterUtil.printPrivacyLog(this.mInitConfig);
        MobadsPermissionSettings.setPermissionReadDeviceID(this.mInitConfig.isCanUsePhoneState());
        MobadsPermissionSettings.setPermissionLocation(this.mInitConfig.isCanUseLocation());
        MobadsPermissionSettings.setPermissionStorage(this.mInitConfig.isCanUseWriteExternal());
        MobadsPermissionSettings.setPermissionAppList(this.mInitConfig.appList());
        MobadsPermissionSettings.setLimitPersonalAds(this.mInitConfig.isLimitPersonalAds());
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitImpl
    public <T> T callFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8101) {
            return BuildConfig.ADAPTER_VERSION;
        }
        if (i == 8104) {
            try {
                return (T) AdSettings.getSDKVersion();
            } catch (Throwable th) {
                th.printStackTrace();
                return cn.d;
            }
        }
        if (i == 8105) {
            return (T) this.mInitConfig.getGromoreVersion();
        }
        if (i != 8124) {
            return null;
        }
        this.mInitConfig.setMediationCustomControllerValueSet((ValueSet) valueSet.objectValue(8517, ValueSet.class));
        a();
        return null;
    }

    public final boolean oIX0oI(Context context, String str, boolean z, String str2) {
        if (context != null && str != null) {
            try {
                BDAdConfig.Builder https = new BDAdConfig.Builder().setAppsid(str).setHttps(z);
                if (!TextUtils.isEmpty(str2)) {
                    https.setWXAppid(str2);
                }
                https.build(context).init();
                a();
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitImpl
    public void realInitAdn(Context context, MediationInitConfig mediationInitConfig) {
        synchronized (BaiduAdapterConfiguration.class) {
            try {
                if (!this.f10374XO) {
                    if (oIX0oI(context, mediationInitConfig.getAppId(), mediationInitConfig.getHttps(), mediationInitConfig.getWxAppId())) {
                        this.f10374XO = true;
                    } else {
                        notifyFail("baidu init fail");
                    }
                }
                notifySuccess();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
