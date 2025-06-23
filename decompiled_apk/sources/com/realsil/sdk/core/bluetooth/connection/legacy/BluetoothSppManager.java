package com.realsil.sdk.core.bluetooth.connection.legacy;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import com.realsil.sdk.core.bluetooth.connection.BluetoothClient;
import com.realsil.sdk.core.bluetooth.connection.legacy.SppConnParameters;
import com.realsil.sdk.core.logger.ZLogger;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public final class BluetoothSppManager {
    public static UUID UUID_SECURE = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    public static volatile BluetoothSppManager f;
    public BluetoothSpp b;
    public volatile boolean c;
    public final Object d = new Object();
    public final a e = new a();

    /* renamed from: a, reason: collision with root package name */
    public List<BluetoothSppCallback> f19495a = new CopyOnWriteArrayList();

    /* loaded from: classes11.dex */
    public class a extends BluetoothSppCallback {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSppCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List<com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSppCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public final void onConnectionStateChanged(BluetoothClient bluetoothClient, boolean z, int i) {
            super.onConnectionStateChanged(bluetoothClient, z, i);
            synchronized (BluetoothSppManager.this.f19495a) {
                try {
                    ?? r1 = BluetoothSppManager.this.f19495a;
                    if (r1 != 0 && r1.size() > 0) {
                        Iterator it = BluetoothSppManager.this.f19495a.iterator();
                        while (it.hasNext()) {
                            ((BluetoothSppCallback) it.next()).onConnectionStateChanged(bluetoothClient, z, i);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSppCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List<com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSppCallback>, java.util.concurrent.CopyOnWriteArrayList] */
        @Override // com.realsil.sdk.core.bluetooth.connection.BluetoothClientCallback
        public final void onDataReceive(BluetoothClient bluetoothClient, byte[] bArr) {
            super.onDataReceive(bluetoothClient, bArr);
            synchronized (BluetoothSppManager.this.f19495a) {
                try {
                    ?? r1 = BluetoothSppManager.this.f19495a;
                    if (r1 != 0 && r1.size() > 0) {
                        Iterator it = BluetoothSppManager.this.f19495a.iterator();
                        while (it.hasNext()) {
                            ((BluetoothSppCallback) it.next()).onDataReceive(bluetoothClient, bArr);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static BluetoothSppManager getInstance() {
        return f;
    }

    public static synchronized void initialize() {
        synchronized (BluetoothSppManager.class) {
            if (f == null) {
                synchronized (BluetoothSppManager.class) {
                    try {
                        if (f == null) {
                            f = new BluetoothSppManager();
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public final BluetoothSpp a() {
        if (this.b == null) {
            this.b = new BluetoothSpp(UUID_SECURE, this.e);
        }
        return this.b;
    }

    public synchronized boolean connect(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, BluetoothSppCallback bluetoothSppCallback) {
        register(bluetoothSppCallback);
        if (getConnectionState() == 2) {
            BluetoothDevice device = a().getDevice();
            if (device != null && device.equals(bluetoothDevice)) {
                bluetoothSppCallback.onConnectionStateChanged(a(), true, 2);
                return true;
            }
            ZLogger.d("current connected device is conflict with the connecting device");
        }
        boolean connect = a().connect(new SppConnParameters.Builder(bluetoothDevice).bluetoothSocket(bluetoothSocket).build());
        if (!connect) {
            unregister(bluetoothSppCallback);
        }
        return connect;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSppCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public void destroy() {
        synchronized (this.f19495a) {
            try {
                ?? r1 = this.f19495a;
                if (r1 != 0) {
                    r1.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        disconnect();
    }

    public void disconnect() {
        a().stop();
    }

    public int getConnectionState() {
        return a().getConnectionState();
    }

    public void notifyAck() {
        synchronized (this.d) {
            this.c = true;
            this.d.notifyAll();
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSppCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List<com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSppCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSppCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public void register(BluetoothSppCallback bluetoothSppCallback) {
        synchronized (this.f19495a) {
            try {
                if (this.f19495a == null) {
                    this.f19495a = new CopyOnWriteArrayList();
                }
                if (!this.f19495a.contains(bluetoothSppCallback)) {
                    this.f19495a.add(bluetoothSppCallback);
                }
                ZLogger.v("callback's size=" + this.f19495a.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized boolean sendPacket(byte[] bArr, boolean z) {
        if (bArr == null) {
            return false;
        }
        if (!z) {
            try {
                this.c = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!a().write(bArr)) {
            ZLogger.w("send spp data failed");
            return false;
        }
        if (z) {
            return true;
        }
        synchronized (this.d) {
            if (this.c) {
                return true;
            }
            try {
                this.d.wait(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.c;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List<com.realsil.sdk.core.bluetooth.connection.legacy.BluetoothSppCallback>, java.util.concurrent.CopyOnWriteArrayList] */
    public void unregister(BluetoothSppCallback bluetoothSppCallback) {
        synchronized (this.f19495a) {
            try {
                ?? r1 = this.f19495a;
                if (r1 != 0) {
                    r1.remove(bluetoothSppCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean write(byte[] bArr) {
        return a().write(bArr);
    }

    public synchronized boolean connect(BluetoothDevice bluetoothDevice, BluetoothSppCallback bluetoothSppCallback) {
        register(bluetoothSppCallback);
        if (getConnectionState() == 2) {
            BluetoothDevice device = a().getDevice();
            if (device != null && device.equals(bluetoothDevice)) {
                ZLogger.d("connection already connected");
                bluetoothSppCallback.onConnectionStateChanged(a(), true, 2);
                return true;
            }
            ZLogger.d("current connected device is conflict with the connecting device");
        }
        boolean connect = a().connect(new SppConnParameters.Builder(bluetoothDevice).build());
        if (!connect) {
            unregister(bluetoothSppCallback);
        }
        return connect;
    }
}
