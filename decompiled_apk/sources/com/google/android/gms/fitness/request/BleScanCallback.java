package com.google.android.gms.fitness.request;

import androidx.annotation.NonNull;
import com.google.android.gms.fitness.data.BleDevice;

@Deprecated
/* loaded from: classes9.dex */
public abstract class BleScanCallback {
    public abstract void onDeviceFound(@NonNull BleDevice bleDevice);

    public abstract void onScanStopped();
}
