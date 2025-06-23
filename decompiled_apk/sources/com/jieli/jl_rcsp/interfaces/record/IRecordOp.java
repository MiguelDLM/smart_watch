package com.jieli.jl_rcsp.interfaces.record;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.RecordParam;
import com.jieli.jl_rcsp.model.RecordState;

/* loaded from: classes8.dex */
public interface IRecordOp {
    void addOnRecordStateCallback(OnRecordStateCallback onRecordStateCallback);

    RecordState getRecordState();

    void release();

    void removeOnRecordStateCallback(OnRecordStateCallback onRecordStateCallback);

    void setSupportPlayTTS(boolean z);

    void setSupportSyncIatText(boolean z);

    void setSupportSyncNlpText(boolean z);

    void startRecord(BluetoothDevice bluetoothDevice, RecordParam recordParam, OnOperationCallback<Boolean> onOperationCallback);

    void stopRecord(BluetoothDevice bluetoothDevice, int i, boolean z, boolean z2, boolean z3, OnOperationCallback<Boolean> onOperationCallback);
}
