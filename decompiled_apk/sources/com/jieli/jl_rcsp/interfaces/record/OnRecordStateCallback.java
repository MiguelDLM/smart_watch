package com.jieli.jl_rcsp.interfaces.record;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.RecordState;

/* loaded from: classes8.dex */
public interface OnRecordStateCallback {
    void onStateChange(BluetoothDevice bluetoothDevice, RecordState recordState);
}
