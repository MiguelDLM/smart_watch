package com.realsil.sdk.core.bluetooth.connection.le;

import com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback;

/* loaded from: classes11.dex */
public abstract class BluetoothGattClientCallback extends BluetoothClientCallback {
    public static final int CONNECT_ERROR = 1;
    public static final int DISCOVERY_SERVICE_FAILED = 2;
    public static final int DISCOVERY_SERVICE_TIMEOUT = 3;
    public static final int ENABLE_CCCD_EXCEPTION = 5;
    public static final int ENABLE_CCCD_FAILED = 4;
    public static final int ENABLE_CCCD_TIMEOUT = 6;
}
