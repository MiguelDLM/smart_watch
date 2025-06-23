package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes6.dex */
class DfuDefaultDeviceSelector implements DfuDeviceSelector {
    @Override // no.nordicsemi.android.dfu.DfuDeviceSelector
    public /* synthetic */ List getScanFilters(ParcelUuid parcelUuid) {
        return X0o0xo.oIX0oI(this, parcelUuid);
    }

    @Override // no.nordicsemi.android.dfu.DfuDeviceSelector
    public boolean matches(@NonNull BluetoothDevice bluetoothDevice, int i, @NonNull byte[] bArr, @NonNull String str, @NonNull String str2) {
        if (!str.equals(bluetoothDevice.getAddress()) && !str2.equals(bluetoothDevice.getAddress())) {
            return false;
        }
        return true;
    }
}
