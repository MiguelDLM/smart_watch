package com.bytedance.sdk.openadsdk.mediation.bridge;

import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;

/* loaded from: classes8.dex */
public abstract class MediationCustomController {
    public boolean alist() {
        return true;
    }

    public String getAndroidId() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public String getMacAddress() {
        return null;
    }

    public MediationPrivacyConfig getMediationPrivacyConfig() {
        return null;
    }

    public IMediationLocation getTTLocation() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }
}
