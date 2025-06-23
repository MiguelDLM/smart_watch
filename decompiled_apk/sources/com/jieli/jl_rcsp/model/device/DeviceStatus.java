package com.jieli.jl_rcsp.model.device;

import com.jieli.jl_rcsp.model.response.ADVInfoResponse;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import com.jieli.jl_rcsp.model.response.GetLowLatencySettingsResponse;
import com.jieli.jl_rcsp.model.response.TargetInfoResponse;

/* loaded from: classes10.dex */
public class DeviceStatus {
    public static final int MODE_LOW_POWER = 3;
    public static final int MODE_MANDATORY_UPGRADE = 2;
    public static final int MODE_NORMAL = 1;
    public static final int MODE_UNKNOWN = 0;
    private DeviceConfiguration deviceConfigure;
    private boolean isAuthDevice;
    private boolean isDataTransfer;
    private boolean isEnableLatencyMode;
    private boolean isFileTransfer;
    private boolean isTwsConnected;
    private ADVInfoResponse mADVInfo;
    private String mDevMD5;
    private DeviceInfo mDeviceInfo;
    private ExternalFlashMsgResponse mExtFlashMSg;
    private GetLowLatencySettingsResponse mLatencySettings;
    private VoiceData mVoiceData;
    private int status;
    private int maxCommunicationMtu = 530;
    private int maxReceiveMtu = 530;
    private int workMode = 0;

    public ADVInfoResponse getADVInfo() {
        return this.mADVInfo;
    }

    public String getDevMD5() {
        return this.mDevMD5;
    }

    public DeviceConfiguration getDeviceConfigure() {
        return this.deviceConfigure;
    }

    public DeviceInfo getDeviceInfo() {
        return this.mDeviceInfo;
    }

    public ExternalFlashMsgResponse getExtFlashMSg() {
        return this.mExtFlashMSg;
    }

    public GetLowLatencySettingsResponse getLatencySettings() {
        return this.mLatencySettings;
    }

    public int getMaxCommunicationMtu() {
        return this.maxCommunicationMtu;
    }

    public int getMaxReceiveMtu() {
        return this.maxReceiveMtu;
    }

    public int getStatus() {
        return this.status;
    }

    public VoiceData getVoiceData() {
        return this.mVoiceData;
    }

    public int getWorkMode() {
        return this.workMode;
    }

    public boolean isAuthDevice() {
        return this.isAuthDevice;
    }

    public boolean isDataTransfer() {
        return this.isDataTransfer;
    }

    public boolean isEnableLatencyMode() {
        return this.isEnableLatencyMode;
    }

    public boolean isEnterLowPowerMode() {
        if (this.workMode == 3) {
            return true;
        }
        return false;
    }

    public boolean isFileTransfer() {
        return this.isFileTransfer;
    }

    public boolean isMandatoryUpgrade() {
        if (this.workMode == 2) {
            return true;
        }
        return false;
    }

    public boolean isTwsConnected() {
        return this.isTwsConnected;
    }

    public DeviceStatus setADVInfo(ADVInfoResponse aDVInfoResponse) {
        boolean z;
        this.mADVInfo = aDVInfoResponse;
        if (aDVInfoResponse != null && aDVInfoResponse.getLeftDeviceQuantity() > 0 && aDVInfoResponse.getRightDeviceQuantity() > 0) {
            z = true;
        } else {
            z = false;
        }
        setTwsConnected(z);
        return this;
    }

    public DeviceStatus setAuthDevice(boolean z) {
        this.isAuthDevice = z;
        return this;
    }

    public DeviceStatus setDataTransfer(boolean z) {
        this.isDataTransfer = z;
        return this;
    }

    public DeviceStatus setDevMD5(String str) {
        this.mDevMD5 = str;
        return this;
    }

    public DeviceStatus setDeviceConfigure(DeviceConfiguration deviceConfiguration) {
        this.deviceConfigure = deviceConfiguration;
        return this;
    }

    public DeviceStatus setDeviceInfo(TargetInfoResponse targetInfoResponse) {
        if (targetInfoResponse instanceof DeviceInfo) {
            this.mDeviceInfo = (DeviceInfo) targetInfoResponse;
        } else {
            this.mDeviceInfo = DeviceInfo.convertFromTargetInfo(targetInfoResponse);
        }
        return this;
    }

    public DeviceStatus setEnableLatencyMode(boolean z) {
        this.isEnableLatencyMode = z;
        return this;
    }

    public DeviceStatus setExtFlashMSg(ExternalFlashMsgResponse externalFlashMsgResponse) {
        this.mExtFlashMSg = externalFlashMsgResponse;
        return this;
    }

    public DeviceStatus setFileTransfer(boolean z) {
        this.isFileTransfer = z;
        return this;
    }

    public DeviceStatus setLatencySettings(GetLowLatencySettingsResponse getLowLatencySettingsResponse) {
        this.mLatencySettings = getLowLatencySettingsResponse;
        return this;
    }

    public DeviceStatus setMaxCommunicationMtu(int i) {
        this.maxCommunicationMtu = i;
        return this;
    }

    public DeviceStatus setMaxReceiveMtu(int i) {
        this.maxReceiveMtu = i;
        return this;
    }

    public DeviceStatus setStatus(int i) {
        this.status = i;
        return this;
    }

    public DeviceStatus setTwsConnected(boolean z) {
        this.isTwsConnected = z;
        return this;
    }

    public DeviceStatus setVoiceData(VoiceData voiceData) {
        this.mVoiceData = voiceData;
        return this;
    }

    public DeviceStatus setWorkMode(int i) {
        this.workMode = i;
        return this;
    }

    public String toString() {
        return "DeviceStatus{status=" + this.status + ", isAuthDevice=" + this.isAuthDevice + ", isEnableLatencyMode=" + this.isEnableLatencyMode + ", isFileTransfer=" + this.isFileTransfer + ", isDataTransfer=" + this.isDataTransfer + ", workState=" + this.workMode + ", mDeviceInfo=" + this.mDeviceInfo + ", mADVInfo=" + this.mADVInfo + ", mDevMD5='" + this.mDevMD5 + "', mLatencySettings=" + this.mLatencySettings + ", maxCommunicationMtu=" + this.maxCommunicationMtu + ", maxReceiveMtu=" + this.maxReceiveMtu + ", mVoiceData=" + this.mVoiceData + ", isTwsConnected=" + this.isTwsConnected + ", mExtFlashMSg=" + this.mExtFlashMSg + ", deviceConfigure=" + this.deviceConfigure + '}';
    }
}
