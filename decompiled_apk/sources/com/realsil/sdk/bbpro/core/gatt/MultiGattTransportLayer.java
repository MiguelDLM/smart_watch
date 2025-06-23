package com.realsil.sdk.bbpro.core.gatt;

import android.bluetooth.BluetoothDevice;
import com.realsil.sdk.bbpro.core.transportlayer.Command;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayer;
import com.realsil.sdk.core.bluetooth.connection.BluetoothClient;
import com.realsil.sdk.core.bluetooth.connection.le.BluetoothGattClientCallback;
import com.realsil.sdk.core.bluetooth.connection.le.GattConnParams;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes11.dex */
public final class MultiGattTransportLayer extends TransportLayer {
    public static volatile MultiGattTransportLayer o;
    public HashMap<String, GattLayer> m;
    public final Object l = new Object();
    public final BluetoothGattClientCallback n = new BluetoothGattClientCallback() { // from class: com.realsil.sdk.bbpro.core.gatt.MultiGattTransportLayer.1
        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public void onConnectionStateChanged(BluetoothClient bluetoothClient, boolean z, int i) {
            if (!z || i == 0) {
                MultiGattTransportLayer.this.a();
            }
            MultiGattTransportLayer.this.a(bluetoothClient.getDevice(), z, i);
        }

        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public void onDataReceive(byte[] bArr) {
            MultiGattTransportLayer.this.a(bArr);
        }

        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public void onDataReceive(BluetoothClient bluetoothClient, byte[] bArr) {
            MultiGattTransportLayer.this.a(bArr);
        }
    };

    public MultiGattTransportLayer() {
        c();
        this.m = new HashMap<>();
    }

    public static synchronized MultiGattTransportLayer getInstance() {
        MultiGattTransportLayer multiGattTransportLayer;
        synchronized (MultiGattTransportLayer.class) {
            try {
                if (o == null) {
                    synchronized (MultiGattTransportLayer.class) {
                        try {
                            if (o == null) {
                                o = new MultiGattTransportLayer();
                            }
                        } finally {
                        }
                    }
                }
                multiGattTransportLayer = o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return multiGattTransportLayer;
    }

    public final synchronized GattLayer a(String str, boolean z) {
        GattLayer gattLayer;
        synchronized (this.l) {
            try {
                HashMap<String, GattLayer> hashMap = this.m;
                if (hashMap != null) {
                    gattLayer = hashMap.get(str);
                } else {
                    gattLayer = null;
                }
                if (gattLayer == null && z) {
                    gattLayer = new GattLayer(this.n);
                    this.m.put(str, gattLayer);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gattLayer;
    }

    public boolean connect(GattConnParams gattConnParams) {
        GattLayer a2;
        b();
        String address = gattConnParams.getAddress();
        synchronized (this) {
            a2 = a(address, true);
        }
        return a2.connect(gattConnParams);
    }

    public void destory() {
        destroy();
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public void destroy() {
        super.destroy();
        synchronized (this.l) {
            try {
                HashMap<String, GattLayer> hashMap = this.m;
                if (hashMap != null) {
                    Iterator<GattLayer> it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        it.next().destroy();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void disconnect(BluetoothDevice bluetoothDevice) {
        synchronized (this.l) {
            try {
                GattLayer a2 = a(bluetoothDevice.getAddress(), false);
                if (a2 != null) {
                    ZLogger.v("pending to disconnect :" + bluetoothDevice.getAddress());
                    a2.disconnect();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public boolean isConnected(BluetoothDevice bluetoothDevice) {
        synchronized (this.l) {
            try {
                boolean z = false;
                GattLayer a2 = a(bluetoothDevice.getAddress(), false);
                if (a2 == null) {
                    return false;
                }
                if (a2.getConnectState() == 2) {
                    z = true;
                }
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public synchronized boolean sendCommandInner(Command command) {
        String dst = command.getDst();
        synchronized (this) {
        }
        return a(dst, true).sendData(command.encode());
        return a(dst, true).sendData(command.encode());
    }

    @Override // com.realsil.sdk.bbpro.core.transportlayer.TransportLayer
    public void disconnect() {
        super.disconnect();
        synchronized (this.l) {
            try {
                HashMap<String, GattLayer> hashMap = this.m;
                if (hashMap != null) {
                    Iterator<GattLayer> it = hashMap.values().iterator();
                    while (it.hasNext()) {
                        it.next().closeGatt();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
