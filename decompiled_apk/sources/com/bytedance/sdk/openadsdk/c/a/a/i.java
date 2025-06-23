package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public final class i extends TTCustomController implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10722a;
    private TTCustomController b;

    public i(Bridge bridge) {
        this.f10722a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    public void a(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean alist() {
        return ((Boolean) this.f10722a.call(262103, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTCustomController tTCustomController = this.b;
        if (tTCustomController == null) {
            return null;
        }
        switch (i) {
            case 262101:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseLocation()));
            case 262102:
                return (T) tTCustomController.getTTLocation();
            case 262103:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.alist()));
            case 262104:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUsePhoneState()));
            case 262105:
                return (T) tTCustomController.getDevImei();
            case 262106:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseWifiState()));
            case 262107:
                return (T) tTCustomController.getMacAddress();
            case 262108:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseWriteExternal()));
            case 262109:
                return (T) tTCustomController.getDevOaid();
            case 262110:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUseAndroidId()));
            case 262111:
                return (T) Boolean.class.cast(Boolean.valueOf(tTCustomController.isCanUsePermissionRecordAudio()));
            case 262112:
                return (T) tTCustomController.getAndroidId();
            default:
                a(i, valueSet, cls);
                return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getAndroidId() {
        return (String) this.f10722a.call(262112, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevImei() {
        return (String) this.f10722a.call(262105, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        return (String) this.f10722a.call(262109, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getMacAddress() {
        return (String) this.f10722a.call(262107, xXxxox0I.II0xO0(0).OOXIXo(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public IMediationPrivacyConfig getMediationPrivacyConfig() {
        return (IMediationPrivacyConfig) this.f10722a.values().objectValue(262113, IMediationPrivacyConfig.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public LocationProvider getTTLocation() {
        return (LocationProvider) this.f10722a.call(262102, xXxxox0I.II0xO0(0).OOXIXo(), LocationProvider.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseAndroidId() {
        return ((Boolean) this.f10722a.call(262110, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        return ((Boolean) this.f10722a.call(262101, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePermissionRecordAudio() {
        return ((Boolean) this.f10722a.call(262111, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        return ((Boolean) this.f10722a.call(262104, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        return ((Boolean) this.f10722a.call(262106, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWriteExternal() {
        return ((Boolean) this.f10722a.call(262108, xXxxox0I.II0xO0(0).OOXIXo(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return xXxxox0I.f31020I0Io;
    }

    public i(TTCustomController tTCustomController) {
        this.b = tTCustomController;
        this.f10722a = xXxxox0I.f31021oxoX;
    }
}
