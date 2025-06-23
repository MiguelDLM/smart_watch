package com.jieli.jl_rcsp.interfaces.alarm;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.command.AlarmExpandCmd;
import com.jieli.jl_rcsp.model.device.AlarmBean;
import com.jieli.jl_rcsp.model.device.AuditionParam;
import java.util.List;

/* loaded from: classes8.dex */
public interface IRTCOp {
    void addOrModifyAlarm(BluetoothDevice bluetoothDevice, AlarmBean alarmBean, OnOperationCallback<Boolean> onOperationCallback);

    void auditionAlarmBell(BluetoothDevice bluetoothDevice, AuditionParam auditionParam, OnOperationCallback<Boolean> onOperationCallback);

    void deleteAlarm(BluetoothDevice bluetoothDevice, AlarmBean alarmBean, OnOperationCallback<Boolean> onOperationCallback);

    void readAlarmBellArgs(BluetoothDevice bluetoothDevice, byte b, OnOperationCallback<List<AlarmExpandCmd.BellArg>> onOperationCallback);

    void readAlarmDefaultBellList(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback);

    void readAlarmList(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback);

    void setAlarmBellArg(BluetoothDevice bluetoothDevice, AlarmExpandCmd.BellArg bellArg, OnOperationCallback<Boolean> onOperationCallback);

    void stopAlarmBell(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback);

    void stopPlayAlarmBell(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback);

    void syncTime(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback);
}
