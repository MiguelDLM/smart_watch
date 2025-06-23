package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import android.location.Location;
import com.baidu.mobads.sdk.internal.cn;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import java.util.List;
import xoIox.x0XOIxOo;

/* loaded from: classes8.dex */
public class KsAdapterConfiguration extends MediationInitImpl {

    /* renamed from: XO, reason: collision with root package name */
    public volatile boolean f10500XO = false;

    /* renamed from: Oo, reason: collision with root package name */
    public final KsCustomController f10499Oo = new KsCustomController() { // from class: com.bytedance.msdk.adapter.ks.KsAdapterConfiguration.2
        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadInstalledPackages() {
            return KsAdapterConfiguration.this.mInitConfig.appList();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadLocation() {
            return KsAdapterConfiguration.this.mInitConfig.isCanUseLocation();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseMacAddress() {
            return KsAdapterConfiguration.this.mInitConfig.isCanUseMacAddress();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseNetworkState() {
            return KsAdapterConfiguration.this.mInitConfig.isCanUseWifiState();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseOaid() {
            return KsAdapterConfiguration.this.mInitConfig.isCanUseOaid();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUsePhoneState() {
            return KsAdapterConfiguration.this.mInitConfig.isCanUsePhoneState();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseStoragePermission() {
            return KsAdapterConfiguration.this.mInitConfig.isCanUseWriteExternal();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getAndroidId() {
            return KsAdapterConfiguration.this.mInitConfig.getAndroidId();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getImei() {
            return KsAdapterConfiguration.this.mInitConfig.getDevImei();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String[] getImeis() {
            List<String> devImeis = KsAdapterConfiguration.this.mInitConfig.getDevImeis();
            if (devImeis == null) {
                return super.getImeis();
            }
            int size = devImeis.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = devImeis.get(i);
            }
            return strArr;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public List<String> getInstalledPackages() {
            return KsAdapterConfiguration.this.mInitConfig.getAppList();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public Location getLocation() {
            IMediationLocation location = KsAdapterConfiguration.this.mInitConfig.getLocation();
            if (location == null) {
                return null;
            }
            Location location2 = new Location("");
            location2.setLatitude(location.getLatitude());
            location2.setLongitude(location.getLongitude());
            return location2;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getMacAddress() {
            return KsAdapterConfiguration.this.mInitConfig.getMacAddress();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getOaid() {
            return KsAdapterConfiguration.this.mInitConfig.getDevOaid();
        }
    };

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitImpl
    public <T> T callFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8101) {
            return BuildConfig.ADAPTER_VERSION;
        }
        if (i == 8104) {
            try {
                return (T) KsAdSDK.getSDKVersion();
            } catch (Throwable unused) {
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
        setPrivacyConfig();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitImpl
    public void realInitAdn(final Context context, final MediationInitConfig mediationInitConfig) {
        synchronized (KsAdapterConfiguration.class) {
            try {
                if (this.f10500XO) {
                    notifySuccess();
                } else {
                    final String appId = mediationInitConfig.getAppId();
                    final String appName = mediationInitConfig.getAppName();
                    try {
                        if (context == null || appId == null) {
                            notifyFail("context or appId is empty");
                        } else {
                            Thread thread = new Thread(new Runnable() { // from class: com.bytedance.msdk.adapter.ks.KsAdapterConfiguration.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        KsAdSDK.init(context, new SdkConfig.Builder().appId(appId).appName(appName).customController(KsAdapterConfiguration.this.f10499Oo).build());
                                        if (x0XOIxOo.OOXIXo("3.3.61")) {
                                            KsAdSDK.start();
                                        }
                                        KsAdSDK.setPersonalRecommend(!mediationInitConfig.isLimitPersonalAds());
                                        KsAdSDK.setProgrammaticRecommend(mediationInitConfig.isProgrammaticRecommend());
                                        KsAdapterConfiguration.this.f10500XO = true;
                                        KsAdapterConfiguration.this.notifySuccess();
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                        KsAdapterConfiguration.this.notifyFail("ks init fail in other thread");
                                    }
                                }
                            });
                            thread.setName("ks-init-thread");
                            thread.start();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        notifyFail("ks init fail");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setPrivacyConfig() {
        try {
            if (this.f10500XO) {
                KsAdSDK.setPersonalRecommend(!this.mInitConfig.isLimitPersonalAds());
                KsAdSDK.setProgrammaticRecommend(this.mInitConfig.isProgrammaticRecommend());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
