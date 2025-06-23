package com.jieli.jl_bt_ota.model.response;

import androidx.annotation.NonNull;
import com.jieli.jl_bt_ota.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class TargetInfoResponse extends CommonResponse {
    private int allowConnectFlag;
    private String authKey;
    private String bleAddr;
    private boolean bleOnly;
    private int communicationMtu;
    private byte curFunction;
    private String customVersionMsg;
    private String edrAddr;
    private int expandMode;
    private int functionMask;
    private boolean isGameMode;
    private boolean isNeedBootLoader;
    private boolean isSupportDoubleBackup;
    private boolean isSupportMD5;
    private int mandatoryUpgradeFlag;
    private int maxVol;
    private String name;
    private int pid;
    private String projectCode;
    private String protocolVersion;
    private int quantity;
    private int receiveMtu;
    private int requestOtaFlag;
    private int sdkType;
    private int singleBackupOtaWay;
    private int ubootVersionCode;
    private String ubootVersionName;
    private int uid;
    private int versionCode;
    private String versionName;
    private int vid;
    private int volume;
    private int edrStatus = 0;
    private int edrProfile = 0;
    private int lowPowerLimit = 30;

    public int getAllowConnectFlag() {
        return this.allowConnectFlag;
    }

    public String getAuthKey() {
        return this.authKey;
    }

    public String getBleAddr() {
        return this.bleAddr;
    }

    public int getCommunicationMtu() {
        return this.communicationMtu;
    }

    public byte getCurFunction() {
        return this.curFunction;
    }

    public String getCustomVersionMsg() {
        return this.customVersionMsg;
    }

    public String getEdrAddr() {
        return this.edrAddr;
    }

    public int getEdrProfile() {
        return this.edrProfile;
    }

    public int getEdrStatus() {
        return this.edrStatus;
    }

    public int getExpandMode() {
        return this.expandMode;
    }

    public int getFunctionMask() {
        return this.functionMask;
    }

    public int getLowPowerLimit() {
        return this.lowPowerLimit;
    }

    public int getMandatoryUpgradeFlag() {
        return this.mandatoryUpgradeFlag;
    }

    public int getMaxVol() {
        return this.maxVol;
    }

    public String getName() {
        return this.name;
    }

    public int getPid() {
        return this.pid;
    }

    public String getProjectCode() {
        return this.projectCode;
    }

    public String getProtocolVersion() {
        return this.protocolVersion;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getReceiveMtu() {
        return this.receiveMtu;
    }

    public int getRequestOtaFlag() {
        return this.requestOtaFlag;
    }

    public int getSdkType() {
        return this.sdkType;
    }

    public int getSingleBackupOtaWay() {
        return this.singleBackupOtaWay;
    }

    public int getUbootVersionCode() {
        return this.ubootVersionCode;
    }

    public String getUbootVersionName() {
        return this.ubootVersionName;
    }

    public int getUid() {
        return this.uid;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public int getVid() {
        return this.vid;
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean isBleOnly() {
        return this.bleOnly;
    }

    public boolean isGameMode() {
        return this.isGameMode;
    }

    public boolean isMandatoryUpgrade() {
        if (getMandatoryUpgradeFlag() == 1) {
            return true;
        }
        return false;
    }

    public boolean isNeedBootLoader() {
        return this.isNeedBootLoader;
    }

    public boolean isSupportDoubleBackup() {
        return this.isSupportDoubleBackup;
    }

    public boolean isSupportMD5() {
        return this.isSupportMD5;
    }

    public TargetInfoResponse setAllowConnectFlag(int i) {
        this.allowConnectFlag = i;
        return this;
    }

    public TargetInfoResponse setAuthKey(String str) {
        this.authKey = str;
        return this;
    }

    public TargetInfoResponse setBleAddr(String str) {
        this.bleAddr = str;
        return this;
    }

    public TargetInfoResponse setBleOnly(boolean z) {
        this.bleOnly = z;
        return this;
    }

    public TargetInfoResponse setCommunicationMtu(int i) {
        this.communicationMtu = i;
        return this;
    }

    public TargetInfoResponse setCurFunction(byte b) {
        this.curFunction = b;
        return this;
    }

    public TargetInfoResponse setCustomVersionMsg(String str) {
        this.customVersionMsg = str;
        return this;
    }

    public TargetInfoResponse setEdrAddr(String str) {
        this.edrAddr = str;
        return this;
    }

    public TargetInfoResponse setEdrProfile(int i) {
        this.edrProfile = i;
        return this;
    }

    public TargetInfoResponse setEdrStatus(int i) {
        this.edrStatus = i;
        return this;
    }

    public TargetInfoResponse setExpandMode(int i) {
        this.expandMode = i;
        return this;
    }

    public TargetInfoResponse setFunctionMask(int i) {
        this.functionMask = i;
        return this;
    }

    public TargetInfoResponse setGameMode(boolean z) {
        this.isGameMode = z;
        return this;
    }

    public TargetInfoResponse setLowPowerLimit(int i) {
        this.lowPowerLimit = i;
        return this;
    }

    public TargetInfoResponse setMandatoryUpgradeFlag(int i) {
        this.mandatoryUpgradeFlag = i;
        return this;
    }

    public TargetInfoResponse setMaxVol(int i) {
        this.maxVol = i;
        return this;
    }

    public TargetInfoResponse setName(String str) {
        this.name = str;
        return this;
    }

    public TargetInfoResponse setNeedBootLoader(boolean z) {
        this.isNeedBootLoader = z;
        return this;
    }

    public TargetInfoResponse setPid(int i) {
        this.pid = i;
        return this;
    }

    public TargetInfoResponse setProjectCode(String str) {
        this.projectCode = str;
        return this;
    }

    public TargetInfoResponse setProtocolVersion(String str) {
        this.protocolVersion = str;
        return this;
    }

    public TargetInfoResponse setQuantity(int i) {
        this.quantity = i;
        return this;
    }

    public TargetInfoResponse setReceiveMtu(int i) {
        this.receiveMtu = i;
        return this;
    }

    public void setRequestOtaFlag(int i) {
        this.requestOtaFlag = i;
    }

    public TargetInfoResponse setSdkType(int i) {
        this.sdkType = i;
        return this;
    }

    public TargetInfoResponse setSingleBackupOtaWay(int i) {
        this.singleBackupOtaWay = i;
        return this;
    }

    public TargetInfoResponse setSupportDoubleBackup(boolean z) {
        this.isSupportDoubleBackup = z;
        return this;
    }

    public TargetInfoResponse setSupportMD5(boolean z) {
        this.isSupportMD5 = z;
        return this;
    }

    public TargetInfoResponse setUbootVersionCode(int i) {
        this.ubootVersionCode = i;
        return this;
    }

    public TargetInfoResponse setUbootVersionName(String str) {
        this.ubootVersionName = str;
        return this;
    }

    public TargetInfoResponse setUid(int i) {
        this.uid = i;
        return this;
    }

    public TargetInfoResponse setVersionCode(int i) {
        this.versionCode = i;
        return this;
    }

    public TargetInfoResponse setVersionName(String str) {
        this.versionName = str;
        return this;
    }

    public TargetInfoResponse setVid(int i) {
        this.vid = i;
        return this;
    }

    public TargetInfoResponse setVolume(int i) {
        this.volume = i;
        return this;
    }

    @Override // com.jieli.jl_bt_ota.model.base.CommonResponse
    @NonNull
    public String toString() {
        return "TargetInfoResponse{versionName='" + this.versionName + "', versionCode=" + this.versionCode + ", protocolVersion='" + this.protocolVersion + "', edrAddr='" + this.edrAddr + "', edrStatus=" + this.edrStatus + ", edrProfile=" + this.edrProfile + ", bleAddr='" + this.bleAddr + "', volume=" + this.volume + ", maxVol=" + this.maxVol + ", quantity=" + this.quantity + ", lowPowerLimit=" + this.lowPowerLimit + ", functionMask=" + this.functionMask + ", curFunction=" + ((int) this.curFunction) + ", sdkType=" + this.sdkType + ", name='" + this.name + "', pid=" + this.pid + ", vid=" + this.vid + ", uid=" + this.uid + ", mandatoryUpgradeFlag=" + this.mandatoryUpgradeFlag + ", requestOtaFlag=" + this.requestOtaFlag + ", ubootVersionCode=" + this.ubootVersionCode + ", ubootVersionName='" + this.ubootVersionName + "', isSupportDoubleBackup=" + this.isSupportDoubleBackup + ", isNeedBootLoader=" + this.isNeedBootLoader + ", singleBackupOtaWay=" + this.singleBackupOtaWay + ", allowConnectFlag=" + this.allowConnectFlag + ", authKey='" + this.authKey + "', projectCode='" + this.projectCode + "', customVersionMsg='" + this.customVersionMsg + "', bleOnly=" + this.bleOnly + ", isSupportMD5=" + this.isSupportMD5 + ", isGameMode=" + this.isGameMode + ", expandMode=" + this.expandMode + ", communicationMtu=" + this.communicationMtu + ", receiveMtu=" + this.receiveMtu + "} ";
    }
}
