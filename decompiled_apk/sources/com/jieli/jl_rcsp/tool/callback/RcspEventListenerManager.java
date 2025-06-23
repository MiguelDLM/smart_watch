package com.jieli.jl_rcsp.tool.callback;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspEventListener;
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
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class RcspEventListenerManager extends BaseCallbackManager<OnRcspEventListener> {
    public void onAlarmDefaultBellListChange(final BluetoothDevice bluetoothDevice, final List<DefaultAlarmBell> list) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.IXxxXO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onAlarmDefaultBellListChange(bluetoothDevice, list);
            }
        });
    }

    public void onAlarmListChange(final BluetoothDevice bluetoothDevice, final AlarmListInfo alarmListInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.Xx000oIo
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onAlarmListChange(bluetoothDevice, alarmListInfo);
            }
        });
    }

    public void onAlarmNotify(final BluetoothDevice bluetoothDevice, final AlarmBean alarmBean) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.x0o
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onAlarmNotify(bluetoothDevice, alarmBean);
            }
        });
    }

    public void onAlarmStop(final BluetoothDevice bluetoothDevice, final AlarmBean alarmBean) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.ooXIXxIX
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onAlarmStop(bluetoothDevice, alarmBean);
            }
        });
    }

    public void onAuxStatusChange(final BluetoothDevice bluetoothDevice, final boolean z) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.oO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onAuxStatusChange(bluetoothDevice, z);
            }
        });
    }

    public void onBatteryChange(final BluetoothDevice bluetoothDevice, final BatteryInfo batteryInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.xI
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onBatteryChange(bluetoothDevice, batteryInfo);
            }
        });
    }

    public void onCurrentVoiceMode(final BluetoothDevice bluetoothDevice, final VoiceMode voiceMode) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.o0
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onCurrentVoiceMode(bluetoothDevice, voiceMode);
            }
        });
    }

    public void onDevStorageInfoChange(final BluetoothDevice bluetoothDevice, final DevStorageInfo devStorageInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.XI0IXoo
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onDevStorageInfoChange(bluetoothDevice, devStorageInfo);
            }
        });
    }

    public void onDeviceModeChange(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.OxxIIOOXO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onDeviceModeChange(bluetoothDevice, i);
            }
        });
    }

    public void onDynamicLimiter(final BluetoothDevice bluetoothDevice, final DynamicLimiterParam dynamicLimiterParam) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.oo0xXOI0I
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onDynamicLimiter(bluetoothDevice, dynamicLimiterParam);
            }
        });
    }

    public void onEqChange(final BluetoothDevice bluetoothDevice, final EqInfo eqInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.x0XOIxOo
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onEqChange(bluetoothDevice, eqInfo);
            }
        });
    }

    public void onEqPresetChange(final BluetoothDevice bluetoothDevice, final EqPresetInfo eqPresetInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.ooOOo0oXI
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onEqPresetChange(bluetoothDevice, eqPresetInfo);
            }
        });
    }

    public void onExpandFunction(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.x0xO0oo
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onExpandFunction(bluetoothDevice, i, bArr);
            }
        });
    }

    public void onFileFormatChange(final BluetoothDevice bluetoothDevice, final String str) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.xoIox
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onFileFormatChange(bluetoothDevice, str);
            }
        });
    }

    public void onFmChannelsChange(final BluetoothDevice bluetoothDevice, final List<ChannelInfo> list) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.XxX0x0xxx
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onFmChannelsChange(bluetoothDevice, list);
            }
        });
    }

    public void onFmStatusChange(final BluetoothDevice bluetoothDevice, final FmStatusInfo fmStatusInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.xXxxox0I
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onFmStatusChange(bluetoothDevice, fmStatusInfo);
            }
        });
    }

    public void onFrequencyTx(final BluetoothDevice bluetoothDevice, final float f) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.O0xOxO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onFrequencyTx(bluetoothDevice, f);
            }
        });
    }

    public void onHealthDataChange(final BluetoothDevice bluetoothDevice, final HealthData healthData) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.xoXoI
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onHealthDataChange(bluetoothDevice, healthData);
            }
        });
    }

    public void onHealthSettingChange(final BluetoothDevice bluetoothDevice, final HealthSettingInfo healthSettingInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.oOoXoXO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onHealthSettingChange(bluetoothDevice, healthSettingInfo);
            }
        });
    }

    public void onHighAndBassChange(final BluetoothDevice bluetoothDevice, final int i, final int i2) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.xxIXOIIO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onHighAndBassChange(bluetoothDevice, i, i2);
            }
        });
    }

    public void onID3MusicInfo(final BluetoothDevice bluetoothDevice, final ID3MusicInfo iD3MusicInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.xII
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onID3MusicInfo(bluetoothDevice, iD3MusicInfo);
            }
        });
    }

    public void onLightControlInfo(final BluetoothDevice bluetoothDevice, final LightControlInfo lightControlInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.o00
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onLightControlInfo(bluetoothDevice, lightControlInfo);
            }
        });
    }

    public void onMusicNameChange(final BluetoothDevice bluetoothDevice, final MusicNameInfo musicNameInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.XOxIOxOx
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onMusicNameChange(bluetoothDevice, musicNameInfo);
            }
        });
    }

    public void onMusicStatusChange(final BluetoothDevice bluetoothDevice, final MusicStatusInfo musicStatusInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.IO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onMusicStatusChange(bluetoothDevice, musicStatusInfo);
            }
        });
    }

    public void onPeripheralsConnectStatusChange(final BluetoothDevice bluetoothDevice, final boolean z, final String str) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.oI0IIXIo
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onPeripheralsConnectStatusChange(bluetoothDevice, z, str);
            }
        });
    }

    public void onPeripheralsModeChange(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.IIX0o
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onPeripheralsModeChange(bluetoothDevice, i);
            }
        });
    }

    public void onPhoneCallStatusChange(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.IIXOooo
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onPhoneCallStatusChange(bluetoothDevice, i);
            }
        });
    }

    public void onPlatformInterfaceInfoChange(final BluetoothDevice bluetoothDevice, final Map<Integer, List<LtvBean>> map) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.XIxXXX0x0
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onPlatformInterfaceInfoChange(bluetoothDevice, map);
            }
        });
    }

    public void onPlayModeChange(final BluetoothDevice bluetoothDevice, final PlayModeInfo playModeInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.OxI
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onPlayModeChange(bluetoothDevice, playModeInfo);
            }
        });
    }

    public void onReverberation(final BluetoothDevice bluetoothDevice, final ReverberationParam reverberationParam) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.X00IoxXI
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onReverberation(bluetoothDevice, reverberationParam);
            }
        });
    }

    public void onSensorLogDataChange(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.xxX
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onSensorLogDataChange(bluetoothDevice, i, bArr);
            }
        });
    }

    public void onSoundCardEqChange(final BluetoothDevice bluetoothDevice, final EqInfo eqInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.OOXIXo
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onSoundCardEqChange(bluetoothDevice, eqInfo);
            }
        });
    }

    public void onSoundCardStatusChange(final BluetoothDevice bluetoothDevice, final long j, final byte[] bArr) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.Oxx0xo
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onSoundCardStatusChange(bluetoothDevice, j, bArr);
            }
        });
    }

    public void onSportInfoChange(final BluetoothDevice bluetoothDevice, final SportsInfo sportsInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.OI0
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onSportInfoChange(bluetoothDevice, sportsInfo);
            }
        });
    }

    public void onSportsState(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.IoOoX
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onSportsState(bluetoothDevice, i);
            }
        });
    }

    public void onVoiceModeList(final BluetoothDevice bluetoothDevice, final List<VoiceMode> list) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.X0IIOO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onVoiceModeList(bluetoothDevice, list);
            }
        });
    }

    public void onVolumeChange(final BluetoothDevice bluetoothDevice, final VolumeInfo volumeInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.oOXoIIIo
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onVolumeChange(bluetoothDevice, volumeInfo);
            }
        });
    }
}
