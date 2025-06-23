package com.jieli.jl_rcsp.interfaces.setting;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.device.settings.SettingData;
import com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction;

/* loaded from: classes8.dex */
public interface OnSettingFunctionListener {
    void onSettingData(BluetoothDevice bluetoothDevice, SettingData settingData);

    void onSettingFunction(BluetoothDevice bluetoothDevice, SettingFunction settingFunction);
}
