package com.jieli.jl_rcsp.interfaces.cmd;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;

/* loaded from: classes8.dex */
public interface ICmdHandler {
    CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket);
}
