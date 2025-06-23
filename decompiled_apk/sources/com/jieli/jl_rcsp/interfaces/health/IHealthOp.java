package com.jieli.jl_rcsp.interfaces.health;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.HealthDataQuery;
import com.jieli.jl_rcsp.model.RealTimeSportsData;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr;
import com.jieli.jl_rcsp.model.device.health.SportsInfo;
import java.util.List;

/* loaded from: classes8.dex */
public interface IHealthOp {
    void configHealthSettings(BluetoothDevice bluetoothDevice, IHealthSettingToAttr iHealthSettingToAttr, OnOperationCallback<Boolean> onOperationCallback);

    void configHealthSettings(BluetoothDevice bluetoothDevice, List<AttrBean> list, OnOperationCallback<Boolean> onOperationCallback);

    void pauseSports(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback);

    void readHealthData(BluetoothDevice bluetoothDevice, HealthDataQuery healthDataQuery, OnOperationCallback<Boolean> onOperationCallback);

    void readHealthSettings(BluetoothDevice bluetoothDevice, int i, OnOperationCallback<Boolean> onOperationCallback);

    void readRealTimeSportsData(BluetoothDevice bluetoothDevice, OnOperationCallback<RealTimeSportsData> onOperationCallback);

    void readSportsInfo(BluetoothDevice bluetoothDevice, OnOperationCallback<SportsInfo> onOperationCallback);

    void resumeSports(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback);

    void startSports(BluetoothDevice bluetoothDevice, int i, OnOperationCallback<Boolean> onOperationCallback);

    void stopSports(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback);
}
