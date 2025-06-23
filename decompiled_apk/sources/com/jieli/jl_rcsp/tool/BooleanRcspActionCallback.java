package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.base.CommandBase;

/* loaded from: classes10.dex */
public class BooleanRcspActionCallback extends CustomRcspActionCallback<Boolean, CommandBase> {
    public BooleanRcspActionCallback(String str, OnOperationCallback<Boolean> onOperationCallback) {
        super(str, onOperationCallback, new IHandleResult<Boolean, CommandBase>() { // from class: com.jieli.jl_rcsp.tool.BooleanRcspActionCallback.1
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                return 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public Boolean handleResult(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                return Boolean.TRUE;
            }
        });
    }
}
