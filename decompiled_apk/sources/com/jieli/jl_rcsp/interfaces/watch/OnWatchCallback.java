package com.jieli.jl_rcsp.interfaces.watch;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.device.BatteryInfo;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkInfo;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;

/* loaded from: classes8.dex */
public abstract class OnWatchCallback extends OnRcspCallback {
    public void onBigDataError(BluetoothDevice bluetoothDevice, BaseError baseError) {
    }

    public void onCurrentWatchInfo(BluetoothDevice bluetoothDevice, String str) {
    }

    public void onDevicePower(BluetoothDevice bluetoothDevice, BatteryInfo batteryInfo) {
    }

    public void onExternalFlashMsg(BluetoothDevice bluetoothDevice, ExternalFlashMsgResponse externalFlashMsgResponse) {
    }

    public void onExternalFlashWriteFlag(BluetoothDevice bluetoothDevice, boolean z) {
    }

    public void onNetworkModuleException(BluetoothDevice bluetoothDevice, NetworkInfo networkInfo) {
    }

    public void onReceiveBigData(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
    }

    public void onResourceUpdateUnfinished(BluetoothDevice bluetoothDevice) {
    }

    public void onWatchSystemException(BluetoothDevice bluetoothDevice, int i) {
    }

    public void onWatchSystemInit(int i) {
    }
}
