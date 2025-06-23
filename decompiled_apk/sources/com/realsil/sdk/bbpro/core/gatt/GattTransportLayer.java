package com.realsil.sdk.bbpro.core.gatt;

import android.bluetooth.BluetoothDevice;
import com.realsil.sdk.bbpro.core.transportlayer.Command;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayer;
import com.realsil.sdk.core.bluetooth.connection.BluetoothClient;
import com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientCallback;
import com.realsil.sdk.core.bluetooth.connection.le.GattConnParams;
import com.realsil.sdk.core.logger.ZLogger;

/* loaded from: classes11.dex */
public final class GattTransportLayer extends TransportLayer {
    public static volatile GattTransportLayer n;
    public GattLayer l = null;
    public final BluetoothGattClientCallback m = new BluetoothGattClientCallback() { // from class: com.realsil.sdk.bbpro.core.gatt.GattTransportLayer.1
        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public void onConnectionStateChanged(BluetoothClient bluetoothClient, boolean z, int i) {
            if (!z || i == 0) {
                GattTransportLayer.this.a();
            }
            GattTransportLayer.this.a(bluetoothClient.getDevice(), z, i);
        }

        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public void onDataReceive(byte[] bArr) {
            GattTransportLayer.this.a(bArr);
        }

        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public void onDataReceive(BluetoothClient bluetoothClient, byte[] bArr) {
            super.onDataReceive(bluetoothClient, bArr);
            GattTransportLayer.this.a(bArr);
        }
    };

    public GattTransportLayer() {
        c();
        g();
    }

    public static synchronized GattTransportLayer getInstance() {
        GattTransportLayer gattTransportLayer;
        synchronized (GattTransportLayer.class) {
            try {
                if (n == null) {
                    synchronized (GattTransportLayer.class) {
                        try {
                            if (n == null) {
                                n = new GattTransportLayer();
                            }
                        } finally {
                        }
                    }
                }
                gattTransportLayer = n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gattTransportLayer;
    }

    public boolean connect(GattConnParams gattConnParams) {
        b();
        return this.l.connect(gattConnParams);
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public void destroy() {
        super.destroy();
        GattLayer gattLayer = this.l;
        if (gattLayer != null) {
            gattLayer.destroy();
        }
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public void disconnect() {
        super.disconnect();
        GattLayer gattLayer = this.l;
        if (gattLayer != null) {
            gattLayer.closeGatt();
        }
    }

    public final GattLayer g() {
        if (this.l == null) {
            this.l = new GattLayer(this.m);
        }
        return this.l;
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public boolean isConnected(BluetoothDevice bluetoothDevice) {
        GattLayer gattLayer = this.l;
        if (gattLayer == null) {
            ZLogger.w("GattLayer == null");
            return false;
        }
        if (gattLayer.getConnectState() != 2) {
            return false;
        }
        return true;
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public synchronized boolean sendCommandInner(Command command) {
        return sendData(command.encode());
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public synchronized boolean sendData(byte[] bArr) {
        GattLayer gattLayer = this.l;
        if (gattLayer == null) {
            return false;
        }
        return gattLayer.sendData(bArr);
    }
}
