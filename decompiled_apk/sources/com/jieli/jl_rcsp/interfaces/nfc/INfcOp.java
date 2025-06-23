package com.jieli.jl_rcsp.interfaces.nfc;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd;
import com.jieli.jl_rcsp.task.TaskListener;

/* loaded from: classes8.dex */
public interface INfcOp {
    void addNfcFile(BluetoothDevice bluetoothDevice, String str, int i, TaskListener taskListener);

    void addOnNfcEventCallback(OnNfcEventCallback onNfcEventCallback);

    void getDefaultNfc(BluetoothDevice bluetoothDevice, int i, OnOperationCallback<Short> onOperationCallback);

    void modifyNfcMsg(BluetoothDevice bluetoothDevice, NFCOperationCmd.ModifyMsgParam modifyMsgParam, OnOperationCallback<Boolean> onOperationCallback);

    void removeNfcMsg(BluetoothDevice bluetoothDevice, int i, short s, OnOperationCallback<Boolean> onOperationCallback);

    void removeOnNfcEventCallback(OnNfcEventCallback onNfcEventCallback);

    void setDefaultNfc(BluetoothDevice bluetoothDevice, int i, short s, OnOperationCallback<Boolean> onOperationCallback);

    void syncNfcMsg(BluetoothDevice bluetoothDevice, int i, OnSyncNfcMsgListener onSyncNfcMsgListener);
}
