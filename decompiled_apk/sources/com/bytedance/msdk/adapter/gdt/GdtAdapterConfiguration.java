package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import com.baidu.mobads.sdk.internal.cn;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.HashMap;
import java.util.Map;
import xxIXOIIO.oIX0oI;

/* loaded from: classes8.dex */
public class GdtAdapterConfiguration extends MediationInitImpl {

    /* renamed from: Oo, reason: collision with root package name */
    public MediationInitConfig f10472Oo;

    /* renamed from: XO, reason: collision with root package name */
    public volatile boolean f10473XO = false;

    public final boolean II0xO0(Context context, String str) {
        if (context != null && str != null) {
            try {
                GDTAdSdk.initWithoutStart(context, str);
                GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration.1
                    @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
                    public void onStartFailed(Exception exc) {
                    }

                    @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
                    public void onStartSuccess() {
                    }
                });
                setPrivacyConfig();
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.util.Map, java.util.HashMap] */
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitImpl
    public <T> T callFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8101) {
            return BuildConfig.ADAPTER_VERSION;
        }
        if (i == 8103) {
            Map map = (Map) valueSet.objectValue(8006, Map.class);
            if (map != null) {
                try {
                    ?? r5 = (T) new HashMap();
                    String str = (String) map.get("slot_id");
                    String buyerId = GDTAdSdk.getGDTAdManger().getBuyerId(null);
                    String sDKInfo = GDTAdSdk.getGDTAdManger().getSDKInfo(str);
                    r5.put("buyerId", buyerId);
                    r5.put("sdkInfo", sDKInfo);
                    return r5;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return null;
        }
        if (i == 8104) {
            try {
                return (T) SDKStatus.getIntegrationSDKVersion();
            } catch (Throwable unused) {
                return cn.d;
            }
        }
        if (i == 8105) {
            return (T) this.f10472Oo.getGromoreVersion();
        }
        if (i == 8124) {
            this.f10472Oo.setMediationCustomControllerValueSet((ValueSet) valueSet.objectValue(8517, ValueSet.class));
            try {
                setPrivacyConfig();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } else if (i == 8126) {
            return (T) Integer.valueOf(showOpenOrInstallAppDialog());
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitImpl
    public void realInitAdn(Context context, MediationInitConfig mediationInitConfig) {
        this.f10472Oo = mediationInitConfig;
        synchronized (GdtAdapterConfiguration.class) {
            try {
                if (!this.f10473XO) {
                    if (II0xO0(context, mediationInitConfig.getAppId())) {
                        this.f10473XO = true;
                    } else {
                        notifyFail("gdt init fail");
                    }
                }
                notifySuccess();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setPrivacyConfig() {
        oIX0oI.I0Io(this.f10472Oo);
        boolean isLimitPersonalAds = this.f10472Oo.isLimitPersonalAds();
        boolean isCanUseMacAddress = this.f10472Oo.isCanUseMacAddress();
        boolean isCanUsePhoneState = this.f10472Oo.isCanUsePhoneState();
        boolean isCanUseAndroidId = this.f10472Oo.isCanUseAndroidId();
        HashMap hashMap = new HashMap();
        hashMap.put("mac_address", Boolean.valueOf(isCanUseMacAddress));
        hashMap.put("android_id", Boolean.valueOf(isCanUseAndroidId));
        hashMap.put("device_id", Boolean.valueOf(isCanUsePhoneState));
        GlobalSetting.setAgreeReadPrivacyInfo(hashMap);
        GlobalSetting.setPersonalizedState(isLimitPersonalAds ? 1 : 0);
    }

    public int showOpenOrInstallAppDialog() {
        try {
            return GDTAdSdk.getGDTAdManger().showOpenOrInstallAppDialog(new GDTAppDialogClickListener() { // from class: com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration.2
                @Override // com.qq.e.ads.dfa.GDTAppDialogClickListener
                public void onButtonClick(int i) {
                    if (GdtAdapterConfiguration.this.f10472Oo == null || GdtAdapterConfiguration.this.f10472Oo.getInitCallback() == null) {
                        return;
                    }
                    MediationValueSetBuilder create = MediationValueSetBuilder.create();
                    create.add(8095, i);
                    GdtAdapterConfiguration.this.f10472Oo.getInitCallback().call(8212, create.build(), Void.class);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }
}
