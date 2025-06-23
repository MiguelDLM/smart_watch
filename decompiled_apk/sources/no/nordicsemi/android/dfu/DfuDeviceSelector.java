package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;
import android.os.ParcelUuid;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* loaded from: classes6.dex */
public interface DfuDeviceSelector {
    @RequiresApi(21)
    List<ScanFilter> getScanFilters(@NonNull ParcelUuid parcelUuid);

    boolean matches(@NonNull BluetoothDevice bluetoothDevice, int i, @NonNull byte[] bArr, @NonNull String str, @NonNull String str2);
}
