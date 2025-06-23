package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd;

/* loaded from: classes10.dex */
public class BooleanNfcActionCallback extends CustomRcspActionCallback<Boolean, CommandBase> {
    public BooleanNfcActionCallback(String str, OnOperationCallback<Boolean> onOperationCallback) {
        super(str, onOperationCallback, new IHandleResult<Boolean, CommandBase>() { // from class: com.jieli.jl_rcsp.tool.BooleanNfcActionCallback.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                NFCOperationCmd.Response response;
                if ((commandBase instanceof NFCOperationCmd) && (response = (NFCOperationCmd.Response) ((NFCOperationCmd) commandBase).getResponse()) != null) {
                    return response.getResult();
                }
                return 1;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public Boolean handleResult(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                return Boolean.TRUE;
            }
        });
    }
}
