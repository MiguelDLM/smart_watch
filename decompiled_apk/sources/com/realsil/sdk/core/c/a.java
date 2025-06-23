package com.realsil.sdk.core.c;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.realsil.sdk.core.RtkCore;
import com.realsil.sdk.core.bluetooth.RtkBluetoothManager;
import com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback;
import com.realsil.sdk.core.bluetooth.connection.le.GattError;
import com.realsil.sdk.core.bluetooth.utils.BluetoothHelper;
import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes11.dex */
public class a {
    public static final String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";
    public static boolean CLOSE_GATT_ENABLED = true;
    public static boolean DUMP_SERVICE = false;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f19506a;
    public boolean b;
    public BluetoothManager c;
    public BluetoothAdapter d;
    public volatile boolean i;
    public Context k;
    public RtkBluetoothManager l;
    public static int SDK_INT = Build.VERSION.SDK_INT;
    public static final UUID CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public final Object j = new Object();
    public final C0906a m = new C0906a();
    public HashMap<String, BluetoothGatt> f = new HashMap<>();
    public HashMap<String, Integer> h = new HashMap<>();
    public HashMap<String, List<BluetoothGattCallback>> g = new HashMap<>();
    public List<String> e = new CopyOnWriteArrayList();

    /* renamed from: com.realsil.sdk.core.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0906a extends RtkBluetoothManagerCallback {
        public C0906a() {
        }

        @Override // com.realsil.sdk.core.bluetooth.RtkBluetoothManagerCallback
        public final void onBluetoothStateChanged(int i) {
            super.onBluetoothStateChanged(i);
            a.a(a.this, i);
        }
    }

    public a(Context context) {
        this.f19506a = false;
        this.b = false;
        this.k = context;
        this.f19506a = RtkCore.DEBUG;
        this.b = RtkCore.VDBG;
        a();
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    public static void a(a aVar, int i) {
        ?? r6;
        aVar.getClass();
        if (i != 10 || Build.VERSION.SDK_INT < 29 || (r6 = aVar.e) == 0 || r6.size() <= 0) {
            return;
        }
        ZLogger.d("Bluetooth is turned off, disconnect all client connections");
        Iterator it = aVar.e.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            BluetoothGatt bluetoothGatt = aVar.getBluetoothGatt(str);
            if (aVar.isConnected(str)) {
                aVar.h.put(str, 0);
                aVar.a(str, bluetoothGatt, 0, 0);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    public void close(String str) {
        if (str == null) {
            return;
        }
        BluetoothGatt bluetoothGatt = this.f.get(str);
        if (bluetoothGatt != null) {
            if (isConnected(str)) {
                if (this.f19506a) {
                    ZLogger.v("disconnect : " + str);
                }
                bluetoothGatt.disconnect();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (CLOSE_GATT_ENABLED) {
                if (this.b) {
                    StringBuilder a2 = com.realsil.sdk.core.a.a.a("closeGatt, addr:=");
                    a2.append(BluetoothHelper.formatAddress(str, true));
                    ZLogger.v(a2.toString());
                }
                bluetoothGatt.close();
            }
            this.f.remove(str);
        }
        HashMap<String, List<BluetoothGattCallback>> hashMap = this.g;
        if (hashMap != null) {
            hashMap.remove(str);
        }
        ?? r0 = this.e;
        if (r0 != 0 && r0.contains(str)) {
            this.e.remove(str);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    public void closeAll() {
        ?? r0 = this.e;
        if (r0 != 0 && r0.size() > 0) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                close((String) it.next());
            }
        }
        RtkBluetoothManager rtkBluetoothManager = this.l;
        if (rtkBluetoothManager != null) {
            rtkBluetoothManager.removeManagerCallback(this.m);
        }
    }

    public synchronized void closeGatt(String str) {
        closeGatt(str, CLOSE_GATT_ENABLED);
    }

    public boolean connect(String str, BluetoothGattCallback bluetoothGattCallback) {
        if (Build.VERSION.SDK_INT >= 23) {
            return connect(str, 2, bluetoothGattCallback);
        }
        return connect(str, 2, bluetoothGattCallback);
    }

    public boolean disconnectGatt(String str) {
        BluetoothGatt bluetoothGatt = this.f.get(str);
        if (bluetoothGatt == null) {
            return false;
        }
        if (isConnected(str)) {
            if (this.f19506a) {
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("disconnect : ");
                a2.append(BluetoothHelper.formatAddress(str, true));
                ZLogger.v(a2.toString());
            }
            bluetoothGatt.disconnect();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                ZLogger.w(e.toString());
            }
        } else {
            a(str, bluetoothGatt, 0, 0);
        }
        return true;
    }

    public BluetoothAdapter getBluetoothAdapter() {
        return this.d;
    }

    public List<String> getBluetoothDeviceAddresss() {
        return this.e;
    }

    public BluetoothGatt getBluetoothGatt(String str) {
        return this.f.get(str);
    }

    public List<BluetoothGattCallback> getCallback(String str) {
        HashMap<String, List<BluetoothGattCallback>> hashMap = this.g;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    public BluetoothDevice getConnectedDevice() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (isConnected(str)) {
                return getBluetoothGatt(str).getDevice();
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    public ArrayList<BluetoothDevice> getConnectedDevices() {
        ArrayList<BluetoothDevice> arrayList = new ArrayList<>();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (isConnected(str)) {
                arrayList.add(getBluetoothGatt(str).getDevice());
            }
        }
        return arrayList;
    }

    public int getConnectionState(String str) {
        return this.h.get(str).intValue();
    }

    public String getDeviceName(String str) {
        BluetoothGatt bluetoothGatt = this.f.get(str);
        if (bluetoothGatt == null) {
            if (this.f19506a) {
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("no bluetoothGatt exist, addr=");
                a2.append(BluetoothHelper.formatAddress(str, true));
                ZLogger.w(a2.toString());
                return null;
            }
            return null;
        }
        return bluetoothGatt.getDevice().getName();
    }

    public BluetoothGattService getService(String str, UUID uuid) {
        BluetoothGattService bluetoothGattService = null;
        for (BluetoothGattService bluetoothGattService2 : getSupportedGattServices(str)) {
            if (bluetoothGattService2.getUuid().equals(uuid)) {
                bluetoothGattService = bluetoothGattService2;
            }
        }
        return bluetoothGattService;
    }

    public List<BluetoothGattService> getSupportedGattServices(String str) {
        ArrayList arrayList = new ArrayList();
        BluetoothGatt bluetoothGatt = getBluetoothGatt(str);
        if (bluetoothGatt == null) {
            return arrayList;
        }
        return bluetoothGatt.getServices();
    }

    public boolean isBluetoothSupported() {
        if (this.d == null && !a()) {
            return false;
        }
        return true;
    }

    public boolean isCallbackRegisted(String str, BluetoothGattCallback bluetoothGattCallback) {
        List<BluetoothGattCallback> callback = getCallback(str);
        if (callback != null && callback.contains(bluetoothGattCallback)) {
            return true;
        }
        return false;
    }

    public boolean isConnected(String str) {
        Integer num = this.h.get(str);
        if (num == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }

    public boolean isHostConnected(String str) {
        BluetoothManager bluetoothManager = this.c;
        if (bluetoothManager == null) {
            if (this.f19506a) {
                ZLogger.w("mBluetoothManager == null");
            }
            return false;
        }
        List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(7);
        if (connectedDevices != null) {
            Iterator<BluetoothDevice> it = connectedDevices.iterator();
            while (it.hasNext()) {
                if (it.next().getAddress().equals(str)) {
                    if (this.b) {
                        StringBuilder a2 = com.realsil.sdk.core.a.a.a("addr: ");
                        a2.append(BluetoothHelper.formatAddress(str, true));
                        a2.append(", Connected.");
                        ZLogger.v(a2.toString());
                    }
                    return true;
                }
            }
        }
        if (this.b) {
            StringBuilder a3 = com.realsil.sdk.core.a.a.a("addr: ");
            a3.append(BluetoothHelper.formatAddress(str, true));
            a3.append(", Disconnected.");
            ZLogger.v(a3.toString());
        }
        return false;
    }

    public boolean readCharacteristic(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.d == null) {
            ZLogger.w("BluetoothAdapter not initialized");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f.get(str);
        if (bluetoothGatt == null) {
            ZLogger.w("unspecified address.");
            return false;
        }
        if (this.b) {
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("addr: ");
            a2.append(BluetoothHelper.formatAddress(str, true));
            ZLogger.d(a2.toString());
        }
        return bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
    }

    public boolean readCharacteristicSync(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.i = false;
        if (!readCharacteristic(str, bluetoothGattCharacteristic)) {
            return false;
        }
        synchronized (this.j) {
            try {
                try {
                    if (!this.i) {
                        if (this.b) {
                            ZLogger.v("wait for 3000ms");
                        }
                        this.j.wait(3000L);
                        if (this.b) {
                            ZLogger.v("wait time reached");
                        }
                    }
                } catch (InterruptedException e) {
                    ZLogger.w(e.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public synchronized void registerCallback(String str, BluetoothGattCallback bluetoothGattCallback) {
        List<BluetoothGattCallback> callback = getCallback(str);
        if (callback == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(bluetoothGattCallback);
            this.g.put(str, copyOnWriteArrayList);
        } else {
            if (!callback.contains(bluetoothGattCallback)) {
                callback.add(bluetoothGattCallback);
                this.g.put(str, callback);
            }
        }
    }

    public boolean requestConnectionPriority(String str, int i) {
        BluetoothGatt bluetoothGatt;
        if (str == null || (bluetoothGatt = this.f.get(str)) == null) {
            return false;
        }
        if (i >= 0 && i <= 2) {
            return bluetoothGatt.requestConnectionPriority(i);
        }
        ZLogger.w("connectionPriority not within valid range");
        return false;
    }

    public boolean setCharacteristicIndication(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        return setCharacteristicIndication(str, bluetoothGattCharacteristic, CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID, z);
    }

    public boolean setCharacteristicNotification(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        return setCharacteristicNotification(str, bluetoothGattCharacteristic, CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR_UUID, z);
    }

    public boolean setCharacteristicNotificationSync(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, UUID uuid, boolean z) {
        this.i = false;
        if (!setCharacteristicNotification(str, bluetoothGattCharacteristic, uuid, z)) {
            return false;
        }
        synchronized (this.j) {
            try {
                try {
                    if (!this.i) {
                        if (this.b) {
                            ZLogger.v("wait for 3000ms");
                        }
                        this.j.wait(3000L);
                        if (this.b) {
                            ZLogger.v("wait time reached");
                        }
                    }
                } catch (InterruptedException e) {
                    ZLogger.w(e.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    public void unRegisterAllCallback(String str) {
        if (this.g.get(str) == null) {
            if (this.f19506a) {
                ZLogger.d("mCallbacks.get(addr) == null");
            }
        } else {
            if (this.f19506a) {
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("addr: ");
                a2.append(BluetoothHelper.formatAddress(str, true));
                ZLogger.v(a2.toString());
            }
            this.g.remove(str);
        }
    }

    public synchronized void unRegisterCallback(String str, BluetoothGattCallback bluetoothGattCallback) {
        List<BluetoothGattCallback> callback = getCallback(str);
        if (callback == null) {
            if (this.f19506a) {
                StringBuilder a2 = com.realsil.sdk.core.a.a.a("callback not registered, addr= ");
                a2.append(BluetoothHelper.formatAddress(str, true));
                ZLogger.v(a2.toString());
            }
            return;
        }
        if (callback.contains(bluetoothGattCallback)) {
            callback.remove(bluetoothGattCallback);
            this.g.put(str, callback);
        }
    }

    public boolean writeCharacteristic(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        int writeCharacteristic;
        if (this.d == null) {
            ZLogger.w("BluetoothAdapter not initialized");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f.get(str);
        if (bluetoothGatt == null) {
            ZLogger.w("unspecified address.");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            writeCharacteristic = bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), bluetoothGattCharacteristic.getWriteType());
            if (writeCharacteristic != 0) {
                return false;
            }
            return true;
        }
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public synchronized boolean writeCharacteristicSync(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.i = false;
        if (!writeCharacteristic(str, bluetoothGattCharacteristic)) {
            return false;
        }
        synchronized (this.j) {
            if (!this.i) {
                if (this.b) {
                    ZLogger.v("wait for 3000ms");
                }
                try {
                    this.j.wait(3000L);
                } catch (InterruptedException e) {
                    ZLogger.w(e.toString());
                }
                if (this.b) {
                    ZLogger.v("wait time reached");
                }
            }
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    public synchronized void closeGatt(String str, boolean z) {
        BluetoothGatt bluetoothGatt;
        if (str == null) {
            ZLogger.d(this.f19506a, "Invalid address");
            return;
        }
        HashMap<String, BluetoothGatt> hashMap = this.f;
        if (hashMap != null) {
            if (z && (bluetoothGatt = hashMap.get(str)) != null) {
                if (this.b) {
                    StringBuilder a2 = com.realsil.sdk.core.a.a.a("closeGatt, addr=");
                    a2.append(BluetoothHelper.formatAddress(str, true));
                    ZLogger.v(a2.toString());
                }
                bluetoothGatt.close();
            }
            this.f.remove(str);
        }
        HashMap<String, List<BluetoothGattCallback>> hashMap2 = this.g;
        if (hashMap2 != null) {
            hashMap2.remove(str);
        }
        ?? r4 = this.e;
        if (r4 != 0) {
            r4.remove(str);
        }
    }

    public boolean setCharacteristicIndication(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, UUID uuid, boolean z) {
        if (this.d == null) {
            ZLogger.w("BluetoothAdapter not initialized");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f.get(str);
        if (bluetoothGatt == null) {
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("BluetoothGatt can not be null, addr=");
            a2.append(BluetoothHelper.formatAddress(str, true));
            ZLogger.w(a2.toString());
            return false;
        }
        if (bluetoothGattCharacteristic == null) {
            ZLogger.w("characteristic is null");
            return false;
        }
        if (this.f19506a) {
            StringBuilder a3 = com.realsil.sdk.core.a.a.a("addr:=");
            a3.append(BluetoothHelper.formatAddress(str, true));
            a3.append(", enabled=");
            a3.append(z);
            ZLogger.d(a3.toString());
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(uuid);
        if (descriptor == null) {
            StringBuilder a4 = com.realsil.sdk.core.a.a.a("descriptor not found, uuid=");
            a4.append(uuid.toString());
            ZLogger.w(a4.toString());
            return false;
        }
        if (z) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        } else {
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        }
        bluetoothGatt.writeDescriptor(descriptor);
        return true;
    }

    public boolean setCharacteristicNotification(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, UUID uuid, boolean z) {
        if (this.d == null) {
            ZLogger.w("BluetoothAdapter not initialized");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.f.get(str);
        if (bluetoothGatt == null) {
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("BluetoothGatt can not be null, addr=");
            a2.append(BluetoothHelper.formatAddress(str, true));
            ZLogger.w(a2.toString());
            return false;
        }
        if (this.f19506a) {
            StringBuilder a3 = com.realsil.sdk.core.a.a.a("addr:=");
            a3.append(BluetoothHelper.formatAddress(str, true));
            a3.append(", enabled=");
            a3.append(z);
            ZLogger.d(a3.toString());
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(uuid);
        if (descriptor == null) {
            StringBuilder a4 = com.realsil.sdk.core.a.a.a("descriptor not found, uuid=");
            a4.append(uuid.toString());
            ZLogger.w(a4.toString());
            return false;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return (z ? bluetoothGatt.writeDescriptor(descriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) : bluetoothGatt.writeDescriptor(descriptor, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) == 0;
        }
        if (z) {
            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        } else {
            descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        }
        return bluetoothGatt.writeDescriptor(descriptor);
    }

    public boolean connect(String str, int i, BluetoothGattCallback bluetoothGattCallback) {
        if (Build.VERSION.SDK_INT >= 26) {
            return connect(str, false, i, 1, bluetoothGattCallback);
        }
        return connect(str, false, i, 1, bluetoothGattCallback);
    }

    public boolean connect(String str, int i, int i2, BluetoothGattCallback bluetoothGattCallback) {
        return connect(str, false, i, i2, bluetoothGattCallback);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.util.List<java.lang.String>, java.util.concurrent.CopyOnWriteArrayList] */
    public boolean connect(String str, boolean z, int i, int i2, BluetoothGattCallback bluetoothGattCallback) {
        BluetoothGatt connectGatt;
        BluetoothGatt bluetoothGatt;
        BluetoothAdapter bluetoothAdapter = this.d;
        if (bluetoothAdapter == null) {
            ZLogger.w("BluetoothAdapter not initialized");
            return false;
        }
        if (str == null) {
            ZLogger.w("unspecified address.");
            return false;
        }
        BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice == null) {
            ZLogger.w("Device not found.  Unable to connect.");
            return false;
        }
        if (this.e.contains(str) && (bluetoothGatt = this.f.get(str)) != null) {
            if (isConnected(str)) {
                if (this.f19506a) {
                    ZLogger.v(BluetoothHelper.formatAddress(str, true) + " already connected");
                }
                registerCallback(str, bluetoothGattCallback);
                if (bluetoothGattCallback != null) {
                    bluetoothGattCallback.onConnectionStateChange(bluetoothGatt, 0, 2);
                }
                return true;
            }
            if (z) {
                registerCallback(str, bluetoothGattCallback);
                if (this.f19506a) {
                    ZLogger.v("re-connect previous device: " + str);
                }
                if (bluetoothGatt.connect()) {
                    this.h.put(str, 1);
                    return true;
                }
                ZLogger.d("reconnect failed.");
                closeGatt(str);
                return false;
            }
            closeGatt(str);
        }
        if (this.f19506a) {
            StringBuilder a2 = com.realsil.sdk.core.a.a.a("create connection to ");
            a2.append(BluetoothHelper.formatAddress(str, true));
            ZLogger.v(a2.toString());
        }
        registerCallback(str, bluetoothGattCallback);
        this.h.put(str, 1);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            connectGatt = remoteDevice.connectGatt(this.k, z, new b(), i, i2);
        } else {
            connectGatt = i3 >= 23 ? remoteDevice.connectGatt(this.k, z, new b(), i) : remoteDevice.connectGatt(this.k, z, new b());
        }
        if (connectGatt == null) {
            ZLogger.d("BluetoothGatt not exist.  Unable to connect.");
            this.h.put(str, 0);
            closeGatt(str);
            return false;
        }
        this.f.put(str, connectGatt);
        if (!this.e.contains(str)) {
            this.e.add(str);
        }
        return true;
    }

    public final boolean a() {
        if (this.c == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) this.k.getSystemService("bluetooth");
            this.c = bluetoothManager;
            if (bluetoothManager == null) {
                ZLogger.w("BLUETOOTH_SERVICE not supported.");
                return false;
            }
        }
        if (this.d == null) {
            BluetoothAdapter a2 = com.realsil.sdk.core.b.a.a(this.k);
            this.d = a2;
            if (a2 == null) {
                ZLogger.w("BluetoothAdapter is not supported");
                return false;
            }
        }
        RtkBluetoothManager rtkBluetoothManager = RtkBluetoothManager.getInstance();
        this.l = rtkBluetoothManager;
        if (rtkBluetoothManager == null) {
            RtkBluetoothManager.initial(this.k);
            this.l = RtkBluetoothManager.getInstance();
        }
        RtkBluetoothManager rtkBluetoothManager2 = this.l;
        if (rtkBluetoothManager2 != null) {
            rtkBluetoothManager2.addManagerCallback(this.m);
        } else {
            ZLogger.w("BluetoothProfileManager not initialized");
        }
        ZLogger.d("initialize success");
        return true;
    }

    /* loaded from: classes11.dex */
    public class b extends BluetoothGattCallback {
        public b() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String address = bluetoothGatt.getDevice().getAddress();
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (a.this.f19506a) {
                if (value != null) {
                    ZLogger.d(String.format(Locale.US, ">> onCharacteristicChanged(%s): %s\n(%d)%s", BluetoothHelper.formatAddress(address, true), bluetoothGattCharacteristic.getUuid(), Integer.valueOf(value.length), DataConverter.bytes2Hex(value)));
                } else {
                    ZLogger.d(String.format(Locale.US, ">> onCharacteristicChanged(%s): %s", BluetoothHelper.formatAddress(address, true), bluetoothGattCharacteristic.getUuid()));
                }
            }
            List<BluetoothGattCallback> list = a.this.g.get(address);
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator<BluetoothGattCallback> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onCharacteristicRead(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr, int i) {
            List<BluetoothGattCallback> list;
            String address = bluetoothGatt.getDevice().getAddress();
            if (a.this.f19506a) {
                ZLogger.d(String.format(Locale.US, "<< onCharacteristicRead(%s): %s, %s \n\t(%d)%s", BluetoothHelper.formatAddress(address, true), bluetoothGattCharacteristic.getUuid(), GattError.parse(i), Integer.valueOf(bArr.length), DataConverter.bytes2Hex(bArr)));
            }
            synchronized (a.this.j) {
                a.this.i = true;
                a.this.j.notifyAll();
            }
            if (Build.VERSION.SDK_INT < 33 || (list = a.this.g.get(address)) == null || list.size() <= 0) {
                return;
            }
            Iterator<BluetoothGattCallback> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bArr, i);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            String address = bluetoothGatt.getDevice().getAddress();
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (a.this.f19506a) {
                if (value != null) {
                    ZLogger.d(String.format(Locale.US, "<< onCharacteristicWrite(%s):%s %s\n(%d)%s", BluetoothHelper.formatAddress(address, true), GattError.parse(i), bluetoothGattCharacteristic.getUuid(), Integer.valueOf(value.length), DataConverter.bytes2Hex(value)));
                } else {
                    ZLogger.d(String.format(Locale.US, "<< onCharacteristicWrite(%s):%s %s", BluetoothHelper.formatAddress(address, true), GattError.parse(i), bluetoothGattCharacteristic.getUuid()));
                }
            }
            synchronized (a.this.j) {
                a.this.i = true;
                a.this.j.notifyAll();
            }
            List<BluetoothGattCallback> list = a.this.g.get(address);
            if (list != null && list.size() > 0) {
                Iterator<BluetoothGattCallback> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            BluetoothDevice device = bluetoothGatt.getDevice();
            if (device == null) {
                return;
            }
            String address = device.getAddress();
            ZLogger.v(String.format(Locale.US, ">> onConnectionStateChange(%s), status: %s , newState: %s", BluetoothHelper.formatAddress(address, true), GattError.parseConnectionError(i), BluetoothHelper.parseProfileState(i2)));
            if (i == 0) {
                if (i2 == 2) {
                    a.this.h.put(address, 2);
                    a.this.f.put(address, bluetoothGatt);
                } else {
                    a.this.h.put(address, 0);
                }
            } else {
                a.this.h.put(address, 0);
            }
            a.this.a(address, bluetoothGatt, i, i2);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onDescriptorRead(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, int i, @NonNull byte[] bArr) {
            List<BluetoothGattCallback> list;
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i, bArr);
            String address = bluetoothGatt.getDevice().getAddress();
            if (a.this.f19506a) {
                ZLogger.d(String.format(Locale.US, "<< onDescriptorRead(%s):%s, %s\n(%d)%s", BluetoothHelper.formatAddress(address, true), GattError.parse(i), bluetoothGattDescriptor.getUuid(), Integer.valueOf(bArr.length), DataConverter.bytes2Hex(bArr)));
            }
            if (Build.VERSION.SDK_INT < 33 || (list = a.this.g.get(address)) == null || list.size() <= 0) {
                return;
            }
            Iterator<BluetoothGattCallback> it = list.iterator();
            while (it.hasNext()) {
                it.next().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i, bArr);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            String address = bluetoothGatt.getDevice().getAddress();
            UUID uuid = bluetoothGattDescriptor.getCharacteristic().getUuid();
            byte[] value = bluetoothGattDescriptor.getValue();
            if (a.this.f19506a) {
                if (value != null) {
                    ZLogger.d(String.format(Locale.US, "<< onDescriptorWrite(%s):%s {\nCharacteristic:%s\nDescriptor:%s\nvalue:(%d)%s\n}", BluetoothHelper.formatAddress(address, true), GattError.parse(i), uuid, bluetoothGattDescriptor.getUuid(), Integer.valueOf(value.length), DataConverter.bytes2Hex(value)));
                } else {
                    ZLogger.d(String.format(Locale.US, "<< onDescriptorWrite(%s):%s {\nCharacteristic:%s\nDescriptor:%s}", BluetoothHelper.formatAddress(address, true), GattError.parse(i), uuid, bluetoothGattDescriptor.getUuid()));
                }
            }
            synchronized (a.this.j) {
                a.this.i = true;
                a.this.j.notifyAll();
            }
            List<BluetoothGattCallback> list = a.this.g.get(address);
            if (list != null && list.size() > 0) {
                Iterator<BluetoothGattCallback> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @TargetApi(21)
        public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            String address = bluetoothGatt.getDevice().getAddress();
            ZLogger.d(String.format(Locale.US, ">> onMtuChanged(%s) mtu=%d, addr=%s", GattError.parse(i2), Integer.valueOf(i), BluetoothHelper.formatAddress(address, true)));
            List<BluetoothGattCallback> list = a.this.g.get(address);
            if (list != null && list.size() > 0) {
                Iterator<BluetoothGattCallback> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onMtuChanged(bluetoothGatt, i, i2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @RequiresApi(api = 26)
        public final void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyRead(bluetoothGatt, i, i2, i3);
            String address = bluetoothGatt.getDevice().getAddress();
            ZLogger.d(String.format(Locale.US, "<< onPhyRead(%s) %s: txPhy=%d, rxPhy=%d", BluetoothHelper.formatAddress(address, true), GattError.parse(i3), Integer.valueOf(i), Integer.valueOf(i2)));
            List<BluetoothGattCallback> list = a.this.g.get(address);
            if (list != null && list.size() > 0) {
                Iterator<BluetoothGattCallback> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onPhyRead(bluetoothGatt, i, i2, i3);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @RequiresApi(api = 26)
        public final void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyUpdate(bluetoothGatt, i, i2, i3);
            String address = bluetoothGatt.getDevice().getAddress();
            ZLogger.d(String.format(Locale.US, ">> onPhyUpdate(%s) %s: txPhy=%d, rxPhy=%d", BluetoothHelper.formatAddress(address, true), GattError.parse(i3), Integer.valueOf(i), Integer.valueOf(i2)));
            List<BluetoothGattCallback> list = a.this.g.get(address);
            if (list != null && list.size() > 0) {
                Iterator<BluetoothGattCallback> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onPhyUpdate(bluetoothGatt, i, i2, i3);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onReadRemoteRssi(bluetoothGatt, i, i2);
            if (a.this.f19506a) {
                ZLogger.v(String.format(Locale.US, "onReadRemoteRssi(%s):rssi=%d, status=%d", BluetoothHelper.formatAddress(bluetoothGatt.getDevice().getAddress(), true), Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
            super.onReliableWriteCompleted(bluetoothGatt, i);
            if (a.this.f19506a) {
                ZLogger.v(String.format(Locale.US, "onReliableWriteCompleted(%s):status=%d", BluetoothHelper.formatAddress(bluetoothGatt.getDevice().getAddress(), true), Integer.valueOf(i)));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onServiceChanged(@NonNull BluetoothGatt bluetoothGatt) {
            List<BluetoothGattCallback> list;
            super.onServiceChanged(bluetoothGatt);
            String address = bluetoothGatt.getDevice().getAddress();
            if (a.this.f19506a) {
                ZLogger.v(String.format("onServiceChanged(%s)", BluetoothHelper.formatAddress(address, true)));
            }
            if (Build.VERSION.SDK_INT >= 31 && (list = a.this.g.get(address)) != null && list.size() > 0) {
                Iterator<BluetoothGattCallback> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onServiceChanged(bluetoothGatt);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            String address = bluetoothGatt.getDevice().getAddress();
            ZLogger.d(String.format(Locale.US, ">> onServicesDiscovered(%s), status=%s", BluetoothHelper.formatAddress(address, true), GattError.parse(i)));
            if (a.DUMP_SERVICE) {
                ZLogger.v(BluetoothHelper.dumpBluetoothGattService(bluetoothGatt));
            }
            List<BluetoothGattCallback> list = a.this.g.get(address);
            if (list != null && list.size() > 0) {
                Iterator<BluetoothGattCallback> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onServicesDiscovered(bluetoothGatt, i);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            if (a.this.f19506a) {
                ZLogger.v(String.format(Locale.US, "onDescriptorRead(%s):%s, status=%d", BluetoothHelper.formatAddress(bluetoothGatt.getDevice().getAddress(), true), bluetoothGattDescriptor.getUuid(), Integer.valueOf(i)));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onCharacteristicChanged(@NonNull BluetoothGatt bluetoothGatt, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr) {
            List<BluetoothGattCallback> list;
            String address = bluetoothGatt.getDevice().getAddress();
            if (a.this.f19506a) {
                ZLogger.d(String.format(Locale.US, ">> onCharacteristicChanged(%s):%s\n(%d)%s", BluetoothHelper.formatAddress(address, true), bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bArr.length), DataConverter.bytes2Hex(bArr)));
            }
            if (Build.VERSION.SDK_INT < 33 || (list = a.this.g.get(address)) == null || list.size() <= 0) {
                return;
            }
            Iterator<BluetoothGattCallback> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bArr);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            String address = bluetoothGatt.getDevice().getAddress();
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (a.this.f19506a) {
                if (value != null) {
                    ZLogger.d(String.format(Locale.US, "<< onCharacteristicRead(%s): %s, %s \n\t(%d)%s", BluetoothHelper.formatAddress(address, true), bluetoothGattCharacteristic.getUuid(), GattError.parse(i), Integer.valueOf(value.length), DataConverter.bytes2Hex(value)));
                } else {
                    ZLogger.d(String.format(Locale.US, "<< onCharacteristicRead(%s): %s,%s", BluetoothHelper.formatAddress(address, true), bluetoothGattCharacteristic.getUuid(), GattError.parse(i)));
                }
            }
            synchronized (a.this.j) {
                a.this.i = true;
                a.this.j.notifyAll();
            }
            List<BluetoothGattCallback> list = a.this.g.get(address);
            if (list == null || list.size() <= 0) {
                return;
            }
            Iterator<BluetoothGattCallback> it = list.iterator();
            while (it.hasNext()) {
                it.next().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            }
        }
    }

    public final void a(String str, BluetoothGatt bluetoothGatt, int i, int i2) {
        List<BluetoothGattCallback> list = this.g.get(str);
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<BluetoothGattCallback> it = list.iterator();
        while (it.hasNext()) {
            it.next().onConnectionStateChange(bluetoothGatt, i, i2);
        }
    }
}
