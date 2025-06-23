package com.jieli.jl_rcsp.interfaces.setting;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.command.setting.PublicSettingsCmd;

/* loaded from: classes8.dex */
public interface ISettingFunction {
    void addOnSettingFunctionListener(OnSettingFunctionListener onSettingFunctionListener);

    void removeOnSettingFunctionListener(OnSettingFunctionListener onSettingFunctionListener);

    void settingFunction(BluetoothDevice bluetoothDevice, PublicSettingsCmd.Param param, OnOperationCallback<PublicSettingsCmd.Response> onOperationCallback);
}
