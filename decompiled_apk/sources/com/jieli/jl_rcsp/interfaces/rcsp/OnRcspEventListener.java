package com.jieli.jl_rcsp.interfaces.rcsp;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.LtvBean;
import com.jieli.jl_rcsp.model.device.AlarmBean;
import com.jieli.jl_rcsp.model.device.AlarmListInfo;
import com.jieli.jl_rcsp.model.device.BatteryInfo;
import com.jieli.jl_rcsp.model.device.ChannelInfo;
import com.jieli.jl_rcsp.model.device.DefaultAlarmBell;
import com.jieli.jl_rcsp.model.device.DevStorageInfo;
import com.jieli.jl_rcsp.model.device.DynamicLimiterParam;
import com.jieli.jl_rcsp.model.device.EqInfo;
import com.jieli.jl_rcsp.model.device.EqPresetInfo;
import com.jieli.jl_rcsp.model.device.FmStatusInfo;
import com.jieli.jl_rcsp.model.device.ID3MusicInfo;
import com.jieli.jl_rcsp.model.device.LightControlInfo;
import com.jieli.jl_rcsp.model.device.MusicNameInfo;
import com.jieli.jl_rcsp.model.device.MusicStatusInfo;
import com.jieli.jl_rcsp.model.device.PlayModeInfo;
import com.jieli.jl_rcsp.model.device.ReverberationParam;
import com.jieli.jl_rcsp.model.device.VoiceMode;
import com.jieli.jl_rcsp.model.device.VolumeInfo;
import com.jieli.jl_rcsp.model.device.health.HealthData;
import com.jieli.jl_rcsp.model.device.health.HealthSettingInfo;
import com.jieli.jl_rcsp.model.device.health.SportsInfo;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class OnRcspEventListener {
    public void onAlarmDefaultBellListChange(BluetoothDevice bluetoothDevice, List<DefaultAlarmBell> list) {
    }

    public void onAlarmListChange(BluetoothDevice bluetoothDevice, AlarmListInfo alarmListInfo) {
    }

    public void onAlarmNotify(BluetoothDevice bluetoothDevice, AlarmBean alarmBean) {
    }

    public void onAlarmStop(BluetoothDevice bluetoothDevice, AlarmBean alarmBean) {
    }

    public void onAuxStatusChange(BluetoothDevice bluetoothDevice, boolean z) {
    }

    public void onBatteryChange(BluetoothDevice bluetoothDevice, BatteryInfo batteryInfo) {
    }

    public void onCurrentVoiceMode(BluetoothDevice bluetoothDevice, VoiceMode voiceMode) {
    }

    public void onDevStorageInfoChange(BluetoothDevice bluetoothDevice, DevStorageInfo devStorageInfo) {
    }

    public void onDeviceModeChange(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onDynamicLimiter(BluetoothDevice bluetoothDevice, DynamicLimiterParam dynamicLimiterParam) {
    }

    public void onEqChange(BluetoothDevice bluetoothDevice, EqInfo eqInfo) {
    }

    public void onEqPresetChange(BluetoothDevice bluetoothDevice, EqPresetInfo eqPresetInfo) {
    }

    public void onExpandFunction(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
    }

    public void onFileFormatChange(BluetoothDevice bluetoothDevice, String str) {
    }

    public void onFmChannelsChange(BluetoothDevice bluetoothDevice, List<ChannelInfo> list) {
    }

    public void onFmStatusChange(BluetoothDevice bluetoothDevice, FmStatusInfo fmStatusInfo) {
    }

    public void onFrequencyTx(BluetoothDevice bluetoothDevice, float f) {
    }

    public void onHealthDataChange(BluetoothDevice bluetoothDevice, HealthData healthData) {
    }

    public void onHealthSettingChange(BluetoothDevice bluetoothDevice, HealthSettingInfo healthSettingInfo) {
    }

    public void onHighAndBassChange(BluetoothDevice bluetoothDevice, int i, int i2) {
    }

    public void onID3MusicInfo(BluetoothDevice bluetoothDevice, ID3MusicInfo iD3MusicInfo) {
    }

    public void onLightControlInfo(BluetoothDevice bluetoothDevice, LightControlInfo lightControlInfo) {
    }

    public void onMusicNameChange(BluetoothDevice bluetoothDevice, MusicNameInfo musicNameInfo) {
    }

    public void onMusicStatusChange(BluetoothDevice bluetoothDevice, MusicStatusInfo musicStatusInfo) {
    }

    public void onPeripheralsConnectStatusChange(BluetoothDevice bluetoothDevice, boolean z, String str) {
    }

    public void onPeripheralsModeChange(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onPhoneCallStatusChange(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onPlatformInterfaceInfoChange(BluetoothDevice bluetoothDevice, Map<Integer, List<LtvBean>> map) {
    }

    public void onPlayModeChange(BluetoothDevice bluetoothDevice, PlayModeInfo playModeInfo) {
    }

    public void onReverberation(BluetoothDevice bluetoothDevice, ReverberationParam reverberationParam) {
    }

    public void onSensorLogDataChange(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
    }

    public void onSoundCardEqChange(BluetoothDevice bluetoothDevice, EqInfo eqInfo) {
    }

    public void onSoundCardStatusChange(BluetoothDevice bluetoothDevice, long j, byte[] bArr) {
    }

    public void onSportInfoChange(BluetoothDevice bluetoothDevice, SportsInfo sportsInfo) {
    }

    public void onSportsState(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onVoiceModeList(BluetoothDevice bluetoothDevice, List<VoiceMode> list) {
    }

    public void onVolumeChange(BluetoothDevice bluetoothDevice, VolumeInfo volumeInfo) {
    }
}
