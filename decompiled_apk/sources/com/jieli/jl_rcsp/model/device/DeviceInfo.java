package com.jieli.jl_rcsp.model.device;

import com.jieli.jl_rcsp.model.device.health.HealthSettingInfo;
import com.jieli.jl_rcsp.model.device.health.SportsInfo;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkInfo;
import com.jieli.jl_rcsp.model.response.TargetInfoResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import java.util.List;

/* loaded from: classes10.dex */
public class DeviceInfo extends TargetInfoResponse {
    private List<DefaultAlarmBell> alarmDefaultBells;
    private byte alarmExpandFlag = 0;
    private AlarmListInfo alarmListInfo;
    private int alarmVersion;
    private List<ChannelInfo> channelInfos;
    private int cluster;
    private byte currentDevIndex;
    private VoiceMode currentVoiceMode;
    private DevStorageInfo devStorageInfo;
    private EqInfo eqInfo;
    private EqPresetInfo eqPresetInfo;
    private ExpandFunction expandFunction;
    private FmStatusInfo fmStatusInfo;
    private float frequency;
    private HealthSettingInfo healthSettingInfo;
    private ID3MusicInfo iD3MusicInfo;
    private boolean isAuxPlay;
    private LightControlInfo lightControlInfo;
    private MusicNameInfo musicNameInfo;
    private MusicStatusInfo musicStatusInfo;
    private NetworkInfo networkInfo;
    private int phoneStatus;
    private String playFileFormat;
    private PlayModeInfo playModeInfo;
    private EqInfo soundCardEqInfo;
    private SportsInfo sportsInfo;
    private List<VoiceMode> voiceModeList;

    public static DeviceInfo convertFromTargetInfo(TargetInfoResponse targetInfoResponse) {
        if (targetInfoResponse == null) {
            return null;
        }
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setVersionName(targetInfoResponse.getVersionName()).setVersionCode(targetInfoResponse.getVersionCode()).setProtocolVersion(targetInfoResponse.getProtocolVersion()).setEdrAddr(targetInfoResponse.getEdrAddr()).setEdrStatus(targetInfoResponse.getEdrStatus()).setEdrProfile(targetInfoResponse.getEdrProfile()).setBleAddr(targetInfoResponse.getBleAddr()).setBleOnly(targetInfoResponse.isBleOnly()).setPlatform(targetInfoResponse.getPlatform()).setLicense(targetInfoResponse.getLicense()).setVolume(targetInfoResponse.getVolume()).setMaxVol(targetInfoResponse.getMaxVol()).setQuantity(targetInfoResponse.getQuantity()).setLowPowerLimit(targetInfoResponse.getLowPowerLimit()).setFunctionMask(targetInfoResponse.getFunctionMask()).setCurFunction(targetInfoResponse.getCurFunction()).setSdkType(targetInfoResponse.getSdkType()).setName(targetInfoResponse.getName()).setPid(targetInfoResponse.getPid()).setVid(targetInfoResponse.getVid()).setUid(targetInfoResponse.getUid()).setMandatoryUpgradeFlag(targetInfoResponse.getMandatoryUpgradeFlag()).setRequestOtaFlag(targetInfoResponse.getRequestOtaFlag()).setUbootVersionCode(targetInfoResponse.getUbootVersionCode()).setUbootVersionName(targetInfoResponse.getUbootVersionName()).setSupportDoubleBackup(targetInfoResponse.isSupportDoubleBackup()).setNeedBootLoader(targetInfoResponse.isNeedBootLoader()).setSingleBackupOtaWay(targetInfoResponse.getSingleBackupOtaWay()).setAllowConnectFlag(targetInfoResponse.getAllowConnectFlag()).setAuthKey(targetInfoResponse.getAuthKey()).setProjectCode(targetInfoResponse.getProjectCode()).setCustomVersionMsg(targetInfoResponse.getCustomVersionMsg()).setEmitterSupport(targetInfoResponse.isEmitterSupport()).setEmitterStatus(targetInfoResponse.getEmitterStatus()).setSupportOfflineShow(targetInfoResponse.isSupportOfflineShow()).setSupportUsb(targetInfoResponse.isSupportUsb()).setSupportSd0(targetInfoResponse.isSupportSd0()).setSupportSd1(targetInfoResponse.isSupportSd1()).setSupportVolumeSync(targetInfoResponse.isSupportVolumeSync()).setSupportPackageCrc16(targetInfoResponse.isSupportPackageCrc16()).setGetFileByNameWithDev(targetInfoResponse.isGetFileByNameWithDev()).setContactsTransferBySmallFile(targetInfoResponse.isContactsTransferBySmallFile()).setExpandMode(targetInfoResponse.getExpandMode()).setBLEToSppWay(targetInfoResponse.isBLEToSppWay()).setExpandFunc(targetInfoResponse.getExpandFunc().getRawData());
        return deviceInfo;
    }

    public static DeviceInfo mergeTargetInfos(DeviceInfo deviceInfo, DeviceInfo deviceInfo2) {
        if (deviceInfo == null) {
            return deviceInfo2;
        }
        deviceInfo2.setVoiceModeList(deviceInfo.getVoiceModeList()).setCurrentVoiceMode(deviceInfo.getCurrentVoiceMode()).setAlarmVersion(deviceInfo.getAlarmVersion()).setAlarmDefaultBells(deviceInfo.getAlarmDefaultBells()).setAlarmExpandFlag(deviceInfo.getAlarmExpandFlag()).setAlarmListInfo(deviceInfo.getAlarmListInfo()).setMusicNameInfo(deviceInfo.getMusicNameInfo()).setMusicStatusInfo(deviceInfo.getMusicStatusInfo()).setPlayModeInfo(deviceInfo.getPlayModeInfo()).setPlayFileFormat(deviceInfo.getPlayFileFormat()).setPhoneStatus(deviceInfo.getPhoneStatus()).setEqInfo(deviceInfo.getEqInfo()).setEqPresetInfo(deviceInfo.getEqPresetInfo()).setSoundCardEqInfo(deviceInfo.getSoundCardEqInfo()).setLightControlInfo(deviceInfo.getLightControlInfo()).setCluster(deviceInfo.getCluster()).setCurrentDevIndex(deviceInfo.getCurrentDevIndex()).setFrequency(deviceInfo.getFrequency()).setFmStatusInfo(deviceInfo.getFmStatusInfo()).setAuxPlay(deviceInfo.isAuxPlay()).setiD3MusicInfo(deviceInfo.getiD3MusicInfo()).setHealthSettingInfo(deviceInfo.getHealthSettingInfo()).setSportsInfo(deviceInfo.getSportsInfo()).setNetworkInfo(deviceInfo.getNetworkInfo());
        return deviceInfo2;
    }

    public boolean checkDevModeExist(byte b) {
        if (b > 32) {
            return false;
        }
        byte intToByte = CHexConver.intToByte((int) Math.pow(2.0d, CHexConver.byteToInt(b)));
        if ((getFunctionMask() & intToByte) != intToByte) {
            return false;
        }
        return true;
    }

    public List<DefaultAlarmBell> getAlarmDefaultBells() {
        return this.alarmDefaultBells;
    }

    public byte getAlarmExpandFlag() {
        return this.alarmExpandFlag;
    }

    public AlarmListInfo getAlarmListInfo() {
        return this.alarmListInfo;
    }

    public int getAlarmVersion() {
        return this.alarmVersion;
    }

    public List<ChannelInfo> getChannelInfos() {
        return this.channelInfos;
    }

    public int getCluster() {
        return this.cluster;
    }

    public byte getCurrentDevIndex() {
        return this.currentDevIndex;
    }

    public VoiceMode getCurrentVoiceMode() {
        return this.currentVoiceMode;
    }

    public DevStorageInfo getDevStorageInfo() {
        return this.devStorageInfo;
    }

    public EqInfo getEqInfo() {
        return this.eqInfo;
    }

    public EqPresetInfo getEqPresetInfo() {
        return this.eqPresetInfo;
    }

    public ExpandFunction getExpandFunction() {
        return this.expandFunction;
    }

    public FmStatusInfo getFmStatusInfo() {
        return this.fmStatusInfo;
    }

    public float getFrequency() {
        return this.frequency;
    }

    public HealthSettingInfo getHealthSettingInfo() {
        return this.healthSettingInfo;
    }

    public LightControlInfo getLightControlInfo() {
        return this.lightControlInfo;
    }

    public MusicNameInfo getMusicNameInfo() {
        return this.musicNameInfo;
    }

    public MusicStatusInfo getMusicStatusInfo() {
        return this.musicStatusInfo;
    }

    public NetworkInfo getNetworkInfo() {
        return this.networkInfo;
    }

    public int getPhoneStatus() {
        return this.phoneStatus;
    }

    public String getPlayFileFormat() {
        return this.playFileFormat;
    }

    public PlayModeInfo getPlayModeInfo() {
        return this.playModeInfo;
    }

    public EqInfo getSoundCardEqInfo() {
        return this.soundCardEqInfo;
    }

    public SportsInfo getSportsInfo() {
        return this.sportsInfo;
    }

    public List<VoiceMode> getVoiceModeList() {
        return this.voiceModeList;
    }

    public ID3MusicInfo getiD3MusicInfo() {
        return this.iD3MusicInfo;
    }

    public boolean isAuxEnable() {
        return checkDevModeExist((byte) 3);
    }

    public boolean isAuxPlay() {
        return this.isAuxPlay;
    }

    public boolean isBtEnable() {
        if (getFunctionMask() != 0 && !checkDevModeExist((byte) 0)) {
            return false;
        }
        return true;
    }

    public boolean isDevMusicEnable() {
        return checkDevModeExist((byte) 1);
    }

    public boolean isFmEnable() {
        return checkDevModeExist((byte) 4);
    }

    public boolean isFmTxEnable() {
        return checkDevModeExist((byte) 6);
    }

    public boolean isLightEnable() {
        return checkDevModeExist((byte) 5);
    }

    public boolean isMandatoryUpgrade() {
        if (getMandatoryUpgradeFlag() == 1) {
            return true;
        }
        return false;
    }

    public boolean isRTCEnable() {
        return checkDevModeExist((byte) 2);
    }

    public DeviceInfo setAlarmDefaultBells(List<DefaultAlarmBell> list) {
        this.alarmDefaultBells = list;
        return this;
    }

    public DeviceInfo setAlarmExpandFlag(byte b) {
        this.alarmExpandFlag = b;
        return this;
    }

    public DeviceInfo setAlarmListInfo(AlarmListInfo alarmListInfo) {
        this.alarmListInfo = alarmListInfo;
        return this;
    }

    public DeviceInfo setAlarmVersion(int i) {
        this.alarmVersion = i;
        return this;
    }

    public DeviceInfo setAuxPlay(boolean z) {
        this.isAuxPlay = z;
        return this;
    }

    public DeviceInfo setChannelInfos(List<ChannelInfo> list) {
        this.channelInfos = list;
        return this;
    }

    public DeviceInfo setCluster(int i) {
        this.cluster = i;
        return this;
    }

    public DeviceInfo setCurrentDevIndex(byte b) {
        this.currentDevIndex = b;
        return this;
    }

    public DeviceInfo setCurrentVoiceMode(VoiceMode voiceMode) {
        this.currentVoiceMode = voiceMode;
        return this;
    }

    public DeviceInfo setDevStorageInfo(DevStorageInfo devStorageInfo) {
        this.devStorageInfo = devStorageInfo;
        return this;
    }

    public DeviceInfo setEqInfo(EqInfo eqInfo) {
        this.eqInfo = eqInfo;
        return this;
    }

    public DeviceInfo setEqPresetInfo(EqPresetInfo eqPresetInfo) {
        this.eqPresetInfo = eqPresetInfo;
        return this;
    }

    public DeviceInfo setExpandFunction(ExpandFunction expandFunction) {
        this.expandFunction = expandFunction;
        return this;
    }

    public DeviceInfo setFmStatusInfo(FmStatusInfo fmStatusInfo) {
        this.fmStatusInfo = fmStatusInfo;
        return this;
    }

    public DeviceInfo setFrequency(float f) {
        this.frequency = f;
        return this;
    }

    public DeviceInfo setHealthSettingInfo(HealthSettingInfo healthSettingInfo) {
        this.healthSettingInfo = healthSettingInfo;
        return this;
    }

    public DeviceInfo setLightControlInfo(LightControlInfo lightControlInfo) {
        this.lightControlInfo = lightControlInfo;
        return this;
    }

    public DeviceInfo setMusicNameInfo(MusicNameInfo musicNameInfo) {
        this.musicNameInfo = musicNameInfo;
        return this;
    }

    public DeviceInfo setMusicStatusInfo(MusicStatusInfo musicStatusInfo) {
        this.musicStatusInfo = musicStatusInfo;
        return this;
    }

    public DeviceInfo setNetworkInfo(NetworkInfo networkInfo) {
        this.networkInfo = networkInfo;
        return this;
    }

    public DeviceInfo setPhoneStatus(int i) {
        this.phoneStatus = i;
        return this;
    }

    public DeviceInfo setPlayFileFormat(String str) {
        this.playFileFormat = str;
        return this;
    }

    public DeviceInfo setPlayModeInfo(PlayModeInfo playModeInfo) {
        this.playModeInfo = playModeInfo;
        return this;
    }

    public DeviceInfo setSoundCardEqInfo(EqInfo eqInfo) {
        this.soundCardEqInfo = eqInfo;
        return this;
    }

    public DeviceInfo setSportsInfo(SportsInfo sportsInfo) {
        this.sportsInfo = sportsInfo;
        return this;
    }

    public DeviceInfo setVoiceModeList(List<VoiceMode> list) {
        this.voiceModeList = list;
        return this;
    }

    public DeviceInfo setiD3MusicInfo(ID3MusicInfo iD3MusicInfo) {
        this.iD3MusicInfo = iD3MusicInfo;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.response.TargetInfoResponse, com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "DeviceInfo{alarmListInfo=" + this.alarmListInfo + ", alarmDefaultBells=" + this.alarmDefaultBells + ", alarmVersion=" + this.alarmVersion + ", alarmExpandFlag=" + ((int) this.alarmExpandFlag) + ", musicNameInfo=" + this.musicNameInfo + ", musicStatusInfo=" + this.musicStatusInfo + ", playModeInfo=" + this.playModeInfo + ", isAuxPlay=" + this.isAuxPlay + ", playFileFormat='" + this.playFileFormat + "', cluster=" + this.cluster + ", currentDevIndex=" + ((int) this.currentDevIndex) + ", eqPresetInfo=" + this.eqPresetInfo + ", eqInfo=" + this.eqInfo + ", devStorageInfo=" + this.devStorageInfo + ", lightControlInfo=" + this.lightControlInfo + ", soundCardEqInfo=" + this.soundCardEqInfo + ", channelInfos=" + this.channelInfos + ", fmStatusInfo=" + this.fmStatusInfo + ", frequency=" + this.frequency + ", iD3MusicInfo=" + this.iD3MusicInfo + ", currentVoiceMode=" + this.currentVoiceMode + ", voiceModeList=" + this.voiceModeList + ", phoneStatus=" + this.phoneStatus + ", expandFunction=" + this.expandFunction + ", healthSettingInfo=" + this.healthSettingInfo + ", sportsInfo=" + this.sportsInfo + ", networkInfo=" + this.networkInfo + "} \n" + super.toString();
    }
}
