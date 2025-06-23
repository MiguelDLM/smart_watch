package com.realsil.sdk.core.bluetooth.connection.le;

import android.annotation.TargetApi;
import android.content.Context;
import com.realsil.sdk.core.c.a;

@TargetApi(18)
/* loaded from: classes11.dex */
public final class BluetoothGattClientManagerImpl extends a {
    public static BluetoothGattClientManagerImpl n;

    public BluetoothGattClientManagerImpl(Context context) {
        super(context);
    }

    public static BluetoothGattClientManagerImpl getInstance() {
        return n;
    }

    public static synchronized void initial(Context context) {
        synchronized (BluetoothGattClientManagerImpl.class) {
            if (n == null) {
                synchronized (BluetoothGattClientManagerImpl.class) {
                    try {
                        if (n == null) {
                            n = new BluetoothGattClientManagerImpl(context.getApplicationContext());
                        }
                    } finally {
                    }
                }
            }
        }
    }
}
