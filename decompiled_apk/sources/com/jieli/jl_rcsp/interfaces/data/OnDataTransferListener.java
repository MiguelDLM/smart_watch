package com.jieli.jl_rcsp.interfaces.data;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.base.BaseError;

/* loaded from: classes8.dex */
public interface OnDataTransferListener {
    void onError(BluetoothDevice bluetoothDevice, BaseError baseError);

    void onReceiveData(BluetoothDevice bluetoothDevice, int i, byte[] bArr);
}
