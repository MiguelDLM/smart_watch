package com.google.android.gms.fitness;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

@Deprecated
/* loaded from: classes9.dex */
public interface BleApi {
    @NonNull
    @RequiresPermission("android.permission.BLUETOOTH")
    PendingResult<Status> claimBleDevice(@NonNull GoogleApiClient googleApiClient, @NonNull BleDevice bleDevice);

    @NonNull
    @RequiresPermission("android.permission.BLUETOOTH")
    PendingResult<Status> claimBleDevice(@NonNull GoogleApiClient googleApiClient, @NonNull String str);

    @NonNull
    @RequiresPermission("android.permission.BLUETOOTH_ADMIN")
    PendingResult<BleDevicesResult> listClaimedBleDevices(@NonNull GoogleApiClient googleApiClient);

    @NonNull
    @RequiresPermission("android.permission.BLUETOOTH_ADMIN")
    @Deprecated
    PendingResult<Status> startBleScan(@NonNull GoogleApiClient googleApiClient, @NonNull StartBleScanRequest startBleScanRequest);

    @NonNull
    @RequiresPermission("android.permission.BLUETOOTH_ADMIN")
    PendingResult<Status> stopBleScan(@NonNull GoogleApiClient googleApiClient, @NonNull BleScanCallback bleScanCallback);

    @NonNull
    @RequiresPermission("android.permission.BLUETOOTH")
    PendingResult<Status> unclaimBleDevice(@NonNull GoogleApiClient googleApiClient, @NonNull BleDevice bleDevice);

    @NonNull
    @RequiresPermission("android.permission.BLUETOOTH")
    PendingResult<Status> unclaimBleDevice(@NonNull GoogleApiClient googleApiClient, @NonNull String str);
}
