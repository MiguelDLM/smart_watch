package com.jieli.jl_rcsp.interfaces.nfc;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.device.NfcMsg;
import java.util.List;

/* loaded from: classes8.dex */
public interface OnNfcEventCallback {
    void onDefaultNfc(BluetoothDevice bluetoothDevice, short s);

    void onModifyNfcMsg(BluetoothDevice bluetoothDevice, NfcMsg nfcMsg);

    void onNfcMsgChange(BluetoothDevice bluetoothDevice, List<NfcMsg> list);

    void onRequestSynNfcMsg(BluetoothDevice bluetoothDevice);
}
