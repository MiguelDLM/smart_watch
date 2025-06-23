package com.jieli.jl_rcsp.interfaces.rcsp;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;

/* loaded from: classes8.dex */
public interface RcspCommandCallback<T extends CommandBase> {
    void onCommandResponse(BluetoothDevice bluetoothDevice, T t);

    void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError);
}
