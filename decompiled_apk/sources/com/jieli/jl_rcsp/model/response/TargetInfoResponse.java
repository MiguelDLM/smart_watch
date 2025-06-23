package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class TargetInfoResponse extends CommonResponse {
    private int allowConnectFlag;
    private String authKey;
    private String bleAddr;
    private boolean bleOnly;
    private String customVersionMsg;
    private String edrAddr;
    private int emitterStatus;
    private boolean emitterSupport;
    private int expandMode;
    private int functionMask;
    private boolean isBLEToSppWay;
    private boolean isNeedBootLoader;
    private boolean isSupportDoubleBackup;
    private String license;
    private int mandatoryUpgradeFlag;
    private int maxVol;

    @Deprecated
    private String name;
    private int pid;
    private String projectCode;
    private String protocolVersion;
    private int quantity;
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
    private int platform = -1;
    private int lowPowerLimit = 30;
    private byte curFunction = 0;
    private boolean supportOfflineShow = false;
    private boolean supportUsb = true;
    private boolean supportSd0 = true;
    private boolean supportSd1 = true;
    private boolean hideNetRadio = false;
    private boolean supportVolumeSync = false;
    private boolean supportPackageCrc16 = false;
    private boolean getFileByNameWithDev = false;
    private boolean contactsTransferBySmallFile = false;
    private final ExpandFunc expandFunc = new ExpandFunc();

    public int getAllowConnectFlag() {
        return this.allowConnectFlag;
    }

    public String getAuthKey() {
        return this.authKey;
    }

    public String getBleAddr() {
        return this.bleAddr;
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

    public int getEmitterStatus() {
        return this.emitterStatus;
    }

    public ExpandFunc getExpandFunc() {
        return this.expandFunc;
    }

    public int getExpandMode() {
        return this.expandMode;
    }

    public int getFunctionMask() {
        return this.functionMask;
    }

    public String getLicense() {
        return this.license;
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

    @Deprecated
    public String getName() {
        return this.name;
    }

    public int getPid() {
        return this.pid;
    }

    public int getPlatform() {
        return this.platform;
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

    public boolean isBLEToSppWay() {
        return this.isBLEToSppWay;
    }

    public boolean isBanEq() {
        return this.expandFunc.isBanEq();
    }

    public boolean isBleOnly() {
        return this.bleOnly;
    }

    public boolean isContactsTransferBySmallFile() {
        return this.contactsTransferBySmallFile;
    }

    public boolean isEmitterSupport() {
        return this.emitterSupport;
    }

    public boolean isGameMode() {
        return this.expandFunc.isGameMode();
    }

    public boolean isGetFileByNameWithDev() {
        return this.getFileByNameWithDev;
    }

    public boolean isHideNetRadio() {
        return this.hideNetRadio;
    }

    public boolean isNeedBootLoader() {
        return this.isNeedBootLoader;
    }

    public boolean isSupportAdaptiveANC() {
        return this.expandFunc.isSupportAdaptiveANC();
    }

    public boolean isSupportAnc() {
        return this.expandFunc.isSupportAnc();
    }

    public boolean isSupportDevConfigure() {
        return this.expandFunc.isSupportDevConfigure();
    }

    public boolean isSupportDoubleBackup() {
        return this.isSupportDoubleBackup;
    }

    public boolean isSupportExternalFlashTransfer() {
        return this.expandFunc.isSupportExternalFlashTransfer();
    }

    public boolean isSupportHearingAssist() {
        return this.expandFunc.isSupportHearingAssist();
    }

    public boolean isSupportMD5() {
        return this.expandFunc.isSupportMD5();
    }

    public boolean isSupportOfflineShow() {
        return this.supportOfflineShow;
    }

    public boolean isSupportPackageCrc16() {
        return this.supportPackageCrc16;
    }

    public boolean isSupportReadErrorMSg() {
        return this.expandFunc.isSupportReadErrorMSg();
    }

    public boolean isSupportSd0() {
        return this.supportSd0;
    }

    public boolean isSupportSd1() {
        return this.supportSd1;
    }

    public boolean isSupportSearchDevice() {
        return this.expandFunc.isSupportSearchDevice();
    }

    public boolean isSupportSoundCard() {
        return this.expandFunc.isSupportSoundCard();
    }

    public boolean isSupportUsb() {
        return this.supportUsb;
    }

    public boolean isSupportVolumeSync() {
        return this.supportVolumeSync;
    }

    public TargetInfoResponse setAllowConnectFlag(int i) {
        this.allowConnectFlag = i;
        return this;
    }

    public TargetInfoResponse setAuthKey(String str) {
        this.authKey = str;
        return this;
    }

    public TargetInfoResponse setBLEToSppWay(boolean z) {
        this.isBLEToSppWay = z;
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

    public TargetInfoResponse setContactsTransferBySmallFile(boolean z) {
        this.contactsTransferBySmallFile = z;
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

    public TargetInfoResponse setEmitterStatus(int i) {
        this.emitterStatus = i;
        return this;
    }

    public TargetInfoResponse setEmitterSupport(boolean z) {
        this.emitterSupport = z;
        return this;
    }

    public TargetInfoResponse setExpandFunc(byte[] bArr) {
        this.expandFunc.parseData(bArr);
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

    public TargetInfoResponse setGetFileByNameWithDev(boolean z) {
        this.getFileByNameWithDev = z;
        return this;
    }

    public TargetInfoResponse setHideNetRadio(boolean z) {
        this.hideNetRadio = z;
        return this;
    }

    public TargetInfoResponse setLicense(String str) {
        this.license = str;
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

    @Deprecated
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

    public TargetInfoResponse setPlatform(int i) {
        this.platform = i;
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

    public TargetInfoResponse setRequestOtaFlag(int i) {
        this.requestOtaFlag = i;
        return this;
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

    public TargetInfoResponse setSupportOfflineShow(boolean z) {
        this.supportOfflineShow = z;
        return this;
    }

    public TargetInfoResponse setSupportPackageCrc16(boolean z) {
        this.supportPackageCrc16 = z;
        return this;
    }

    public TargetInfoResponse setSupportSd0(boolean z) {
        this.supportSd0 = z;
        return this;
    }

    public TargetInfoResponse setSupportSd1(boolean z) {
        this.supportSd1 = z;
        return this;
    }

    public TargetInfoResponse setSupportUsb(boolean z) {
        this.supportUsb = z;
        return this;
    }

    public TargetInfoResponse setSupportVolumeSync(boolean z) {
        this.supportVolumeSync = z;
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

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "TargetInfoResponse{versionName='" + this.versionName + "', versionCode=" + this.versionCode + ", protocolVersion='" + this.protocolVersion + "', edrAddr='" + this.edrAddr + "', edrStatus=" + this.edrStatus + ", edrProfile=" + this.edrProfile + ", bleAddr='" + this.bleAddr + "', platform=" + this.platform + ", license='" + this.license + "', volume=" + this.volume + ", maxVol=" + this.maxVol + ", quantity=" + this.quantity + ", lowPowerLimit=" + this.lowPowerLimit + ", functionMask=" + this.functionMask + ", curFunction=" + ((int) this.curFunction) + ", sdkType=" + this.sdkType + ", name='" + this.name + "', pid=" + this.pid + ", vid=" + this.vid + ", uid=" + this.uid + ", mandatoryUpgradeFlag=" + this.mandatoryUpgradeFlag + ", requestOtaFlag=" + this.requestOtaFlag + ", ubootVersionCode=" + this.ubootVersionCode + ", ubootVersionName='" + this.ubootVersionName + "', isSupportDoubleBackup=" + this.isSupportDoubleBackup + ", isNeedBootLoader=" + this.isNeedBootLoader + ", singleBackupOtaWay=" + this.singleBackupOtaWay + ", allowConnectFlag=" + this.allowConnectFlag + ", authKey='" + this.authKey + "', projectCode='" + this.projectCode + "', customVersionMsg='" + this.customVersionMsg + "', bleOnly=" + this.bleOnly + ", emitterSupport=" + this.emitterSupport + ", emitterStatus=" + this.emitterStatus + ", supportOfflineShow=" + this.supportOfflineShow + ", supportUsb=" + this.supportUsb + ", supportSd0=" + this.supportSd0 + ", supportSd1=" + this.supportSd1 + ", hideNetRadio=" + this.hideNetRadio + ", supportVolumeSync=" + this.supportVolumeSync + ", expandMode=" + this.expandMode + ", supportPackageCrc16 = " + this.supportPackageCrc16 + ", getFileByNameWithDev = " + this.getFileByNameWithDev + ", contactsTransferBySmallFile = " + this.contactsTransferBySmallFile + ", isBLEToSppWay = " + this.isBLEToSppWay + ", expandFunc = " + this.expandFunc + "} ";
    }
}
