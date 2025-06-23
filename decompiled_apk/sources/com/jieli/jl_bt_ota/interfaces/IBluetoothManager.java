package com.jieli.jl_bt_ota.interfaces;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.response.TargetInfoResponse;

/* loaded from: classes10.dex */
public interface IBluetoothManager {
    void connectBluetoothDevice(BluetoothDevice bluetoothDevice);

    void disconnectBluetoothDevice(BluetoothDevice bluetoothDevice);

    void errorEventCallback(BaseError baseError);

    BluetoothGatt getConnectedBluetoothGatt();

    BluetoothDevice getConnectedDevice();

    void onBtDeviceConnection(BluetoothDevice bluetoothDevice, int i);

    void onError(BaseError baseError);

    void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2);

    void onReceiveDeviceData(BluetoothDevice bluetoothDevice, byte[] bArr);

    void queryMandatoryUpdate(IActionCallback<TargetInfoResponse> iActionCallback);

    void receiveDataFromDevice(BluetoothDevice bluetoothDevice, byte[] bArr);

    boolean sendDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr);
}
