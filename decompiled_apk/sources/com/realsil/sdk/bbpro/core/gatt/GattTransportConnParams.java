package com.realsil.sdk.bbpro.core.gatt;

import android.bluetooth.BluetoothDevice;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes11.dex */
public final class GattTransportConnParams {

    /* renamed from: a, reason: collision with root package name */
    public BluetoothDevice f19459a;

    /* loaded from: classes11.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public BluetoothDevice f19460a;
        public UUID b;
        public UUID c;
        public UUID d;

        public Builder(BluetoothDevice bluetoothDevice) {
            this.f19460a = bluetoothDevice;
        }

        public Builder bluetoothDevice(BluetoothDevice bluetoothDevice) {
            this.f19460a = bluetoothDevice;
            return this;
        }

        public GattTransportConnParams build() {
            Objects.requireNonNull(this.f19460a, "bluetoothDevice cannot be null");
            return new GattTransportConnParams(this.f19460a);
        }

        public Builder rxUuid(UUID uuid) {
            this.d = uuid;
            return this;
        }

        public Builder serviceUuid(UUID uuid) {
            this.b = uuid;
            return this;
        }

        public Builder txUuid(UUID uuid) {
            this.c = uuid;
            return this;
        }
    }

    public GattTransportConnParams(BluetoothDevice bluetoothDevice) {
        this.f19459a = bluetoothDevice;
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.f19459a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GattTransportConnParams{\n");
        if (this.f19459a != null) {
            sb.append("\n\tdevice:");
            sb.append(BluetoothHelper.formatAddress(this.f19459a.getAddress(), true));
        }
        sb.append("\n}");
        return sb.toString();
    }
}
