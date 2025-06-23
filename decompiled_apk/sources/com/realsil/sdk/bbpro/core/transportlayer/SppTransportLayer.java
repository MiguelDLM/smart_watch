package com.realsil.sdk.bbpro.core.transportlayer;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.ParcelUuid;
import com.realsil.sdk.bbpro.core.Utils;
import com.realsil.sdk.core.bluetooth.connection.BluetoothClient;
import com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSpp;
import com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSppCallback;
import com.realsil.sdk.core.bluetooth.connection.legacy.SppConnParameters;
import com.realsil.sdk.core.bluetooth.impl.BluetoothDeviceImpl;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes11.dex */
public final class SppTransportLayer extends TransportLayer {
    public static volatile SppTransportLayer o;
    public BluetoothSpp l;
    public UUID m = TransportConnParams.VENDOR_SPP_UUID;
    public final BluetoothSppCallback n = new BluetoothSppCallback() { // from class: com.realsil.sdk.bbpro.core.transportlayer.SppTransportLayer.1
        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public void onConnectionStateChanged(BluetoothClient bluetoothClient, boolean z, int i) {
            String str;
            super.onConnectionStateChanged(bluetoothClient, z, i);
            BluetoothDevice device = bluetoothClient.getDevice();
            if (device != null) {
                str = device.getAddress();
            } else {
                str = null;
            }
            if (TransportLayer.k) {
                ZLogger.v(String.format(Locale.US, "%s status: %b 0x%04X", BluetoothHelper.formatAddress(str, true), Boolean.valueOf(z), Integer.valueOf(i)));
            }
            if (!z || i == 0) {
                SppTransportLayer.this.a();
            }
            SppTransportLayer.this.a(device, z, i);
        }

        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public void onDataReceive(byte[] bArr) {
            SppTransportLayer.this.a(bArr);
        }

        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public void onDataReceive(BluetoothClient bluetoothClient, byte[] bArr) {
            super.onDataReceive(bluetoothClient, bArr);
            SppTransportLayer.this.a(bArr);
        }
    };

    public SppTransportLayer() {
        c();
    }

    public static synchronized SppTransportLayer getInstance() {
        SppTransportLayer sppTransportLayer;
        synchronized (SppTransportLayer.class) {
            try {
                if (o == null) {
                    synchronized (SppTransportLayer.class) {
                        try {
                            if (o == null) {
                                o = new SppTransportLayer();
                            }
                        } finally {
                        }
                    }
                }
                sppTransportLayer = o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sppTransportLayer;
    }

    public final boolean a(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, UUID uuid, int i) {
        if (bluetoothDevice == null) {
            return false;
        }
        if (g().isConnected(bluetoothDevice)) {
            BluetoothSppCallback bluetoothSppCallback = this.n;
            if (bluetoothSppCallback != null) {
                bluetoothSppCallback.onConnectionStateChanged(g(), true, 2);
            }
            return true;
        }
        b();
        if (TransportLayer.k) {
            BluetoothDeviceImpl.dumpSupportedUuids(bluetoothDevice);
        }
        ParcelUuid uuid2 = Utils.getUuid(bluetoothDevice.getUuids(), uuid, true);
        if (uuid2 == null) {
            if (i == 1) {
                ZLogger.w(TransportLayer.D, "not find pref spp: " + uuid);
                return false;
            }
            uuid2 = TransportConnParams.WELL_KNOWN_SPP_UUID;
            ZLogger.v(TransportLayer.D, "use well-known spp: " + uuid2.toString());
        } else {
            ZLogger.v(TransportLayer.D, "use pref spp: " + uuid);
        }
        this.m = uuid2.getUuid();
        return g().connect(new SppConnParameters.Builder(bluetoothDevice).bluetoothSocket(bluetoothSocket).uuid(uuid2.getUuid()).build());
    }

    public boolean connect(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket) {
        return a(bluetoothDevice, bluetoothSocket, this.m, 0);
    }

    public void destory() {
        destroy();
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public void destroy() {
        super.destroy();
        BluetoothSpp bluetoothSpp = this.l;
        if (bluetoothSpp != null) {
            bluetoothSpp.destroy();
            this.l = null;
        }
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public void disconnect() {
        super.disconnect();
        BluetoothSpp bluetoothSpp = this.l;
        if (bluetoothSpp != null) {
            bluetoothSpp.stop();
        }
    }

    public final BluetoothSpp g() {
        if (this.l == null) {
            this.l = new BluetoothSpp(this.n);
        }
        return this.l;
    }

    public int getConnectionState() {
        return g().getConnectionState();
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public boolean isConnected(BluetoothDevice bluetoothDevice) {
        BluetoothSpp bluetoothSpp = this.l;
        if (bluetoothSpp == null) {
            return false;
        }
        return bluetoothSpp.isConnected(bluetoothDevice);
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public synchronized boolean sendCommandInner(Command command) {
        return sendData(command.encode());
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public boolean sendData(byte[] bArr) {
        return g().write(bArr);
    }

    public boolean connect(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, UUID uuid) {
        return a(bluetoothDevice, bluetoothSocket, uuid, 0);
    }

    public boolean connect(TransportConnParams transportConnParams) {
        if (transportConnParams == null) {
            ZLogger.w("connParams can not be null");
            return false;
        }
        return a(transportConnParams.getBluetoothDevice(), transportConnParams.getBluetoothSocket(), transportConnParams.getUuid(), transportConnParams.getTransport());
    }
}
