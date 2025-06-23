package com.realsil.sdk.core.bluetooth.impl;

import android.bluetooth.BluetoothAdapter;
import com.realsil.sdk.core.logger.ZLogger;
import java.lang.reflect.Method;

/* loaded from: classes11.dex */
public class BluetoothAdapterImpl {
    public static final String ACTION_BLE_ACL_CONNECTED = "android.bluetooth.adapter.action.BLE_ACL_CONNECTED";
    public static final String ACTION_BLE_ACL_DISCONNECTED = "android.bluetooth.adapter.action.BLE_ACL_DISCONNECTED";

    public static int getConnectionState(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter == null) {
            ZLogger.w("BT is not enabled");
            return 0;
        }
        try {
            Method method = bluetoothAdapter.getClass().getMethod("getConnectionState", null);
            method.setAccessible(true);
            return ((Integer) method.invoke(bluetoothAdapter, null)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
