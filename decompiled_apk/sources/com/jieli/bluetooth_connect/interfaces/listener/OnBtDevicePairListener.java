package com.jieli.bluetooth_connect.interfaces.listener;

import android.bluetooth.BluetoothDevice;
import com.jieli.bluetooth_connect.bean.ErrorInfo;

/* loaded from: classes10.dex */
public interface OnBtDevicePairListener {
    void onAdapterStatus(boolean bEnabled, boolean bHasBle);

    void onBtDeviceBond(BluetoothDevice device, int status);

    void onPairError(BluetoothDevice device, ErrorInfo error);
}
