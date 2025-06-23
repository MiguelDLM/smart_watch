package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.device.DeviceConfiguration;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.device.DeviceStatus;
import com.jieli.jl_rcsp.model.device.VoiceData;
import com.jieli.jl_rcsp.model.response.ADVInfoResponse;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import com.jieli.jl_rcsp.model.response.GetLowLatencySettingsResponse;
import com.jieli.jl_rcsp.model.response.TargetInfoResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class DeviceStatusManager {
    public static volatile DeviceStatusManager b;

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, DeviceStatus> f18003a = Collections.synchronizedMap(new HashMap());

    public static DeviceStatusManager getInstance() {
        if (b == null) {
            synchronized (DeviceStatusManager.class) {
                try {
                    if (b == null) {
                        b = new DeviceStatusManager();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final ADVInfoResponse a(ADVInfoResponse aDVInfoResponse, ADVInfoResponse aDVInfoResponse2) {
        if (aDVInfoResponse != null && aDVInfoResponse2 != null) {
            if (aDVInfoResponse2.getVid() >= 0 && aDVInfoResponse2.getVid() != aDVInfoResponse.getVid()) {
                aDVInfoResponse.setVid(aDVInfoResponse2.getVid());
            }
            if (aDVInfoResponse2.getUid() >= 0 && aDVInfoResponse2.getUid() != aDVInfoResponse.getUid()) {
                aDVInfoResponse.setUid(aDVInfoResponse2.getUid());
            }
            if (aDVInfoResponse2.getPid() >= 0 && aDVInfoResponse2.getPid() != aDVInfoResponse.getPid()) {
                aDVInfoResponse.setPid(aDVInfoResponse2.getPid());
            }
            if (aDVInfoResponse2.getDeviceName() != null && !aDVInfoResponse2.getDeviceName().equals(aDVInfoResponse.getDeviceName())) {
                aDVInfoResponse.setDeviceName(aDVInfoResponse2.getDeviceName());
            }
            if (aDVInfoResponse2.getLeftDeviceQuantity() >= 0 && aDVInfoResponse2.getLeftDeviceQuantity() != aDVInfoResponse.getLeftDeviceQuantity()) {
                aDVInfoResponse.setLeftDeviceQuantity(aDVInfoResponse2.getLeftDeviceQuantity());
            }
            if (aDVInfoResponse2.getRightDeviceQuantity() >= 0 && aDVInfoResponse2.getRightDeviceQuantity() != aDVInfoResponse.getRightDeviceQuantity()) {
                aDVInfoResponse.setRightDeviceQuantity(aDVInfoResponse2.getRightDeviceQuantity());
            }
            if (aDVInfoResponse2.getChargingBinQuantity() >= 0 && aDVInfoResponse2.getChargingBinQuantity() != aDVInfoResponse.getChargingBinQuantity()) {
                aDVInfoResponse.setChargingBinQuantity(aDVInfoResponse2.getChargingBinQuantity());
            }
            if (aDVInfoResponse2.isLeftCharging() != aDVInfoResponse.isLeftCharging()) {
                aDVInfoResponse.setLeftCharging(aDVInfoResponse2.isLeftCharging());
            }
            if (aDVInfoResponse2.isRightCharging() != aDVInfoResponse.isRightCharging()) {
                aDVInfoResponse.setRightCharging(aDVInfoResponse2.isRightCharging());
            }
            if (aDVInfoResponse2.isDeviceCharging() != aDVInfoResponse.isDeviceCharging()) {
                aDVInfoResponse.setDeviceCharging(aDVInfoResponse2.isDeviceCharging());
            }
            if (aDVInfoResponse2.getWorkModel() >= 0 && aDVInfoResponse2.getWorkModel() != aDVInfoResponse.getWorkModel()) {
                aDVInfoResponse.setWorkModel(aDVInfoResponse2.getWorkModel());
            }
            if (aDVInfoResponse2.getMicChannel() >= 0 && aDVInfoResponse2.getMicChannel() != aDVInfoResponse.getMicChannel()) {
                aDVInfoResponse.setMicChannel(aDVInfoResponse2.getMicChannel());
            }
            if (aDVInfoResponse2.getKeySettingsList() != null && !aDVInfoResponse2.getKeySettingsList().isEmpty()) {
                aDVInfoResponse.setKeySettingsList(aDVInfoResponse2.getKeySettingsList());
            }
            if (aDVInfoResponse2.getLedSettingsList() != null && !aDVInfoResponse2.getLedSettingsList().isEmpty()) {
                aDVInfoResponse.setLedSettingsList(aDVInfoResponse2.getLedSettingsList());
                return aDVInfoResponse;
            }
            return aDVInfoResponse;
        }
        if (aDVInfoResponse == null) {
            if (aDVInfoResponse2 != null) {
                return aDVInfoResponse2;
            }
            return null;
        }
        return aDVInfoResponse;
    }

    public ADVInfoResponse getAdvInfo(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return null;
        }
        return deviceStatus.getADVInfo();
    }

    public String getDevMD5(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return null;
        }
        return deviceStatus.getDevMD5();
    }

    public DeviceConfiguration getDeviceConfigure(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return null;
        }
        return deviceStatus.getDeviceConfigure();
    }

    public int getDeviceConnectStatus(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return 0;
        }
        return deviceStatus.getStatus();
    }

    public DeviceInfo getDeviceInfo(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return null;
        }
        return deviceStatus.getDeviceInfo();
    }

    public DeviceStatus getDeviceStatus(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        return getDeviceStatus(bluetoothDevice.getAddress());
    }

    public VoiceData getDeviceVoiceConfig(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return null;
        }
        return deviceStatus.getVoiceData();
    }

    public int getDeviceWorkMode(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return 3;
        }
        return deviceStatus.getWorkMode();
    }

    public ExternalFlashMsgResponse getExtFlashMsg(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return null;
        }
        return deviceStatus.getExtFlashMSg();
    }

    public GetLowLatencySettingsResponse getLatencySettings(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return null;
        }
        return deviceStatus.getLatencySettings();
    }

    public int getMaxCommunicationMtu(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus != null && deviceStatus.getMaxCommunicationMtu() > 0) {
            return deviceStatus.getMaxCommunicationMtu();
        }
        return 530;
    }

    public int getMaxReceiveMtu(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus != null && deviceStatus.getMaxReceiveMtu() > 0) {
            return deviceStatus.getMaxReceiveMtu();
        }
        return 530;
    }

    public boolean isAuthBtDevice(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return false;
        }
        return deviceStatus.isAuthDevice();
    }

    public boolean isDataTransfer(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return false;
        }
        return deviceStatus.isDataTransfer();
    }

    public boolean isDoubleBackupUpgrade(BluetoothDevice bluetoothDevice) {
        DeviceInfo deviceInfo;
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null || (deviceInfo = deviceStatus.getDeviceInfo()) == null) {
            return false;
        }
        return deviceInfo.isSupportDoubleBackup();
    }

    public boolean isEnableLatencyMode(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return false;
        }
        return deviceStatus.isEnableLatencyMode();
    }

    public boolean isEnterLowPowerMode(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return false;
        }
        return deviceStatus.isEnterLowPowerMode();
    }

    public boolean isFileTransfer(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return false;
        }
        return deviceStatus.isFileTransfer();
    }

    public boolean isMandatoryUpgrade(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return false;
        }
        return deviceStatus.isMandatoryUpgrade();
    }

    public boolean isTwsConnected(BluetoothDevice bluetoothDevice) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return false;
        }
        return deviceStatus.isTwsConnected();
    }

    public void release() {
        this.f18003a.clear();
        b = null;
    }

    public DeviceStatus removeDeviceStatus(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        return removeDeviceStatus(bluetoothDevice.getAddress());
    }

    public void updateDataTransfer(BluetoothDevice bluetoothDevice, boolean z) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus != null && deviceStatus.isDataTransfer() != z) {
            deviceStatus.setDataTransfer(z);
            updateDeviceStatus(bluetoothDevice, deviceStatus);
        }
    }

    public void updateDeviceAdvInfo(BluetoothDevice bluetoothDevice, ADVInfoResponse aDVInfoResponse) {
        if (aDVInfoResponse == null) {
            return;
        }
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            deviceStatus = new DeviceStatus();
            deviceStatus.setADVInfo(aDVInfoResponse);
        } else {
            deviceStatus.setADVInfo(a(deviceStatus.getADVInfo(), aDVInfoResponse));
        }
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateDeviceConfigure(BluetoothDevice bluetoothDevice, DeviceConfiguration deviceConfiguration) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return;
        }
        deviceStatus.setDeviceConfigure(deviceConfiguration);
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateDeviceConnectStatus(BluetoothDevice bluetoothDevice, int i) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            deviceStatus = new DeviceStatus();
        }
        deviceStatus.setStatus(i);
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateDeviceInfo(BluetoothDevice bluetoothDevice, DeviceInfo deviceInfo) {
        boolean z;
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            deviceStatus = new DeviceStatus();
        }
        int i = 1;
        if (deviceInfo != null && deviceInfo.isMandatoryUpgrade()) {
            z = true;
        } else {
            z = false;
        }
        DeviceInfo deviceInfo2 = deviceStatus.getDeviceInfo();
        if (deviceInfo2 != null) {
            deviceStatus.setDeviceInfo(DeviceInfo.mergeTargetInfos(deviceInfo2, deviceInfo));
        } else {
            deviceStatus.setDeviceInfo(deviceInfo);
        }
        if (z) {
            i = 2;
        }
        deviceStatus.setWorkMode(i);
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateDeviceIsAuth(BluetoothDevice bluetoothDevice, boolean z) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            deviceStatus = new DeviceStatus();
        }
        deviceStatus.setAuthDevice(z);
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateDeviceIsEnableLatencyMode(BluetoothDevice bluetoothDevice, boolean z) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return;
        }
        deviceStatus.setEnableLatencyMode(z);
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateDeviceIsEnterLowPowerMode(BluetoothDevice bluetoothDevice, boolean z) {
        int i;
        if (z) {
            i = 3;
        } else {
            i = 1;
        }
        updateWorkMode(bluetoothDevice, i);
    }

    public void updateDeviceLowLatencySettings(BluetoothDevice bluetoothDevice, GetLowLatencySettingsResponse getLowLatencySettingsResponse) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return;
        }
        deviceStatus.setLatencySettings(getLowLatencySettingsResponse);
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateDeviceMD5(BluetoothDevice bluetoothDevice, String str) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return;
        }
        deviceStatus.setDevMD5(str);
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateDeviceMaxCommunicationMtu(BluetoothDevice bluetoothDevice, int i) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            deviceStatus = new DeviceStatus();
        }
        deviceStatus.setMaxCommunicationMtu(i);
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateDeviceMaxReceiveMtu(BluetoothDevice bluetoothDevice, int i) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            deviceStatus = new DeviceStatus();
        }
        deviceStatus.setMaxReceiveMtu(i);
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateDeviceStatus(BluetoothDevice bluetoothDevice, DeviceStatus deviceStatus) {
        if (bluetoothDevice != null) {
            updateDeviceStatus(bluetoothDevice.getAddress(), deviceStatus);
        }
    }

    public void updateDeviceTargetInfo(BluetoothDevice bluetoothDevice, TargetInfoResponse targetInfoResponse) {
        updateDeviceInfo(bluetoothDevice, DeviceInfo.convertFromTargetInfo(targetInfoResponse));
    }

    public void updateDeviceVoiceConfig(BluetoothDevice bluetoothDevice, VoiceData voiceData) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            return;
        }
        if (voiceData == null || !voiceData.equals(deviceStatus.getVoiceData())) {
            deviceStatus.setVoiceData(voiceData);
            updateDeviceStatus(bluetoothDevice, deviceStatus);
        }
    }

    public void updateExtFlashMsg(BluetoothDevice bluetoothDevice, ExternalFlashMsgResponse externalFlashMsgResponse) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus == null) {
            deviceStatus = new DeviceStatus();
        }
        deviceStatus.setExtFlashMSg(externalFlashMsgResponse);
        updateDeviceStatus(bluetoothDevice, deviceStatus);
    }

    public void updateFileTransfer(BluetoothDevice bluetoothDevice, boolean z) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus != null && deviceStatus.isFileTransfer() != z) {
            deviceStatus.setFileTransfer(z);
            updateDeviceStatus(bluetoothDevice, deviceStatus);
        }
    }

    public void updateWorkMode(BluetoothDevice bluetoothDevice, int i) {
        DeviceStatus deviceStatus = getDeviceStatus(bluetoothDevice);
        if (deviceStatus != null && deviceStatus.getWorkMode() != i) {
            deviceStatus.setWorkMode(i);
            updateDeviceStatus(bluetoothDevice, deviceStatus);
        }
    }

    public DeviceStatus getDeviceStatus(String str) {
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            return this.f18003a.get(str);
        }
        return null;
    }

    public DeviceStatus removeDeviceStatus(String str) {
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            return this.f18003a.remove(str);
        }
        return null;
    }

    public void updateDeviceStatus(String str, DeviceStatus deviceStatus) {
        if (!BluetoothAdapter.checkBluetoothAddress(str) || deviceStatus == null) {
            return;
        }
        this.f18003a.put(str, deviceStatus);
    }
}
