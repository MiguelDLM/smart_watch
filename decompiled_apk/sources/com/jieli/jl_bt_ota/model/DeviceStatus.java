package com.jieli.jl_bt_ota.model;

import com.jieli.jl_bt_ota.model.response.TargetInfoResponse;

/* loaded from: classes10.dex */
public class DeviceStatus {
    private boolean isAuthDevice;
    private boolean isEnterLowPowerMode;
    private boolean isMandatoryUpgrade;
    private String mDevMD5;
    private TargetInfoResponse mTargetInfo;
    private int status;

    public String getDevMD5() {
        return this.mDevMD5;
    }

    public int getStatus() {
        return this.status;
    }

    public TargetInfoResponse getTargetInfo() {
        return this.mTargetInfo;
    }

    public boolean isAuthDevice() {
        return this.isAuthDevice;
    }

    public boolean isEnterLowPowerMode() {
        return this.isEnterLowPowerMode;
    }

    public boolean isMandatoryUpgrade() {
        return this.isMandatoryUpgrade;
    }

    public DeviceStatus setAuthDevice(boolean z) {
        this.isAuthDevice = z;
        return this;
    }

    public DeviceStatus setDevMD5(String str) {
        this.mDevMD5 = str;
        return this;
    }

    public DeviceStatus setEnterLowPowerMode(boolean z) {
        this.isEnterLowPowerMode = z;
        return this;
    }

    public DeviceStatus setMandatoryUpgrade(boolean z) {
        this.isMandatoryUpgrade = z;
        return this;
    }

    public DeviceStatus setStatus(int i) {
        this.status = i;
        return this;
    }

    public DeviceStatus setTargetInfo(TargetInfoResponse targetInfoResponse) {
        this.mTargetInfo = targetInfoResponse;
        return this;
    }

    public String toString() {
        return "DeviceStatus{status=" + this.status + ", isAuthDevice=" + this.isAuthDevice + ", isEnterLowPowerMode=" + this.isEnterLowPowerMode + ", isMandatoryUpgrade=" + this.isMandatoryUpgrade + ", mTargetInfo=" + this.mTargetInfo + ", mDevMD5='" + this.mDevMD5 + "'}";
    }
}
