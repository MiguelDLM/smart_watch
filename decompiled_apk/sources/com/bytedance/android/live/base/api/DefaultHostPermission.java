package com.bytedance.android.live.base.api;

/* loaded from: classes8.dex */
public class DefaultHostPermission implements IHostPermission {
    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        return true;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getAndroidID() {
        return null;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevImei() {
        return null;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevOaid() {
        return null;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getMacAddress() {
        return null;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public LocationProvider getTTLocation() {
        return null;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanGetAndUseAndroidID() {
        return true;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        return true;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        return true;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        return true;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        return true;
    }
}
