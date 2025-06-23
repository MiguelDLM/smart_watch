package com.realsil.sdk.core.b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import androidx.annotation.NonNull;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.Objects;

/* loaded from: classes11.dex */
public final class a {
    public static boolean a(@NonNull String str) {
        Objects.requireNonNull(str);
        return BluetoothAdapter.checkBluetoothAddress(str) && (Integer.parseInt(str.split(":")[0], 16) & 192) == 192;
    }

    public static BluetoothAdapter a(Context context) {
        if (context == null) {
            return BluetoothAdapter.getDefaultAdapter();
        }
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            ZLogger.w("Unable to initialize BluetoothManager.");
            return BluetoothAdapter.getDefaultAdapter();
        }
        return bluetoothManager.getAdapter();
    }
}
