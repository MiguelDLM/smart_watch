package com.realsil.sdk.core.bluetooth.connection.legacy;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import androidx.annotation.NonNull;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import java.util.UUID;

/* loaded from: classes11.dex */
public final class SppConnParameters {

    /* renamed from: a, reason: collision with root package name */
    public BluetoothDevice f19497a;
    public BluetoothSocket b;
    public UUID c;
    public boolean d;
    public static final UUID WELL_KNOWN_SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    public static final UUID VENDOR_SPP_UUID = UUID.fromString("6A24EEAB-4B65-4693-986B-3C26C352264F");

    /* loaded from: classes11.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public BluetoothDevice f19498a;
        public BluetoothSocket b;
        public UUID c = SppConnParameters.VENDOR_SPP_UUID;
        public boolean d = false;

        public Builder(@NonNull BluetoothDevice bluetoothDevice) {
            this.f19498a = bluetoothDevice;
        }

        public Builder bluetoothSocket(BluetoothSocket bluetoothSocket) {
            this.b = bluetoothSocket;
            return this;
        }

        public SppConnParameters build() {
            return new SppConnParameters(this.f19498a, this.b, this.c, this.d);
        }

        public Builder freshUuid(boolean z) {
            this.d = z;
            return this;
        }

        public Builder uuid(UUID uuid) {
            if (uuid != null) {
                this.c = uuid;
            }
            return this;
        }
    }

    public SppConnParameters(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, UUID uuid, boolean z) {
        this.f19497a = bluetoothDevice;
        this.b = bluetoothSocket;
        this.c = uuid;
        this.d = z;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.f19497a;
    }

    public BluetoothSocket getBluetoothSocket() {
        return this.b;
    }

    public UUID getUuid() {
        return this.c;
    }

    public boolean isFreshUuid() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SppConnParameters{");
        if (this.f19497a != null) {
            sb.append("\n\tdevice:");
            sb.append(BluetoothHelper.formatAddress(this.f19497a.getAddress(), true));
        }
        if (this.c != null) {
            sb.append("\n\tuuid:");
            sb.append(this.c.toString());
        }
        sb.append("\n\tfreshUuid:");
        sb.append(this.d);
        if (this.b != null) {
            sb.append("\n\tsocket:");
            sb.append(this.b.getRemoteDevice());
        }
        sb.append("\n}");
        return sb.toString();
    }
}
