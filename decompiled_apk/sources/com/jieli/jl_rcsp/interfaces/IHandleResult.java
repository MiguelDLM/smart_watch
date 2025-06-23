package com.jieli.jl_rcsp.interfaces;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.base.CommandBase;

/* loaded from: classes8.dex */
public interface IHandleResult<T, C extends CommandBase> {
    T handleResult(BluetoothDevice bluetoothDevice, C c);

    int hasResult(BluetoothDevice bluetoothDevice, C c);
}
