package com.vtrump.vtble;

import android.R;
import android.annotation.SuppressLint;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes13.dex */
public class VTBluetoothLeService extends Service {

    /* renamed from: OxI, reason: collision with root package name */
    public static final String f27359OxI = "VTBluetoothLeService";

    /* renamed from: IXxxXO, reason: collision with root package name */
    public BluetoothAdapter f27361IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public BluetoothManager f27362Oo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f27364OxxIIOOXO;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f27368xoXoI;

    /* renamed from: XO, reason: collision with root package name */
    public String f27365XO = "tag_status";

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public HashMap<String, BluetoothGatt> f27363Oxx0xo = new HashMap<>();

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public HashMap<String, R.integer> f27367oI0IIXIo = new HashMap<>();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final BluetoothGattCallback f27360IIXOooo = new II0xO0();

    /* renamed from: o00, reason: collision with root package name */
    public final IBinder f27366o00 = new oIX0oI();

    /* loaded from: classes13.dex */
    public class II0xO0 extends BluetoothGattCallback {
        public II0xO0() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String uuid = bluetoothGattCharacteristic.getService().getUuid().toString();
            String uuid2 = bluetoothGattCharacteristic.getUuid().toString();
            byte[] value = bluetoothGattCharacteristic.getValue();
            VTDevice I0oOIX2 = xoXoI.OOXIxO0().I0oOIX(bluetoothGatt.getDevice().getAddress());
            if (I0oOIX2 != null) {
                I0oOIX2.oOoXoXO(uuid, uuid2, value);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            String uuid = bluetoothGattCharacteristic.getService().getUuid().toString();
            String uuid2 = bluetoothGattCharacteristic.getUuid().toString();
            byte[] value = bluetoothGattCharacteristic.getValue();
            Oxx0xo.oIX0oI(VTBluetoothLeService.f27359OxI, "onCharacteristicRead: " + IXxxXO.oIX0oI(uuid2, uuid2) + ", value = " + xxX.Oxx0xo(value));
            if (i == 0) {
                xoXoI.OOXIxO0().I0oOIX(bluetoothGatt.getDevice().getAddress()).ooOOo0oXI(uuid, uuid2, value);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            String uuid = bluetoothGattCharacteristic.getService().getUuid().toString();
            String uuid2 = bluetoothGattCharacteristic.getUuid().toString();
            Oxx0xo.oIX0oI(VTBluetoothLeService.f27359OxI, "onWrite: " + IXxxXO.oIX0oI(uuid2, uuid2) + ",data:" + xxX.IIXOooo(bluetoothGattCharacteristic.getValue()));
            if (i == 0) {
                VTDevice I0oOIX2 = xoXoI.OOXIxO0().I0oOIX(bluetoothGatt.getDevice().getAddress());
                Log.d(VTBluetoothLeService.f27359OxI, "onCharacteristicWrite: " + I0oOIX2);
                if (I0oOIX2 != null) {
                    I0oOIX2.x0XOIxOo(uuid, uuid2);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (i2 == 2) {
                bluetoothGatt.requestConnectionPriority(1);
                VTBluetoothLeService.this.II0XooXoX("com.vtble.service..ACTION_GATT_CONNECTED", address);
                Oxx0xo.I0Io(VTBluetoothLeService.f27359OxI, "  Connected to GATT server:" + address);
                VTBluetoothLeService.this.f27364OxxIIOOXO = 0;
                boolean discoverServices = bluetoothGatt.discoverServices();
                Oxx0xo.I0Io(VTBluetoothLeService.f27359OxI, "discoverServices  result:" + discoverServices);
                return;
            }
            if (i2 == 0) {
                Oxx0xo.II0xO0(VTBluetoothLeService.f27359OxI, "Disconnected from GATT server:" + address + ", status = " + i);
                VTBluetoothLeService.this.II0XooXoX("com.vtble.service..ACTION_GATT_DISCONNECTED", address);
                if (i == 133) {
                    bluetoothGatt.disconnect();
                    bluetoothGatt.close();
                }
                if (VTBluetoothLeService.this.f27368xoXoI) {
                    return;
                }
                bluetoothGatt.close();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            Oxx0xo.oIX0oI(VTBluetoothLeService.f27359OxI, "onReadRemoteRssi, rssi: " + i + ", status: " + i2);
            if (i2 == 0) {
                xoXoI.OOXIxO0().I0oOIX(bluetoothGatt.getDevice().getAddress()).oxoX(i);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i == 0) {
                Oxx0xo.X0o0xo(VTBluetoothLeService.f27359OxI, "onServicesDiscovered successed address = " + bluetoothGatt.getDevice().getAddress());
                VTBluetoothLeService.this.II0XooXoX("com.vtble.service..ACTION_GATT_SERVICES_DISCOVERED", bluetoothGatt.getDevice().getAddress());
                return;
            }
            Oxx0xo.X0o0xo(VTBluetoothLeService.f27359OxI, "onServicesDisc overed received: " + i);
            bluetoothGatt.disconnect();
        }
    }

    /* loaded from: classes13.dex */
    public class oIX0oI extends Binder {
        public oIX0oI() {
        }

        public VTBluetoothLeService oIX0oI() {
            return VTBluetoothLeService.this;
        }
    }

    public final void II0XooXoX(String str, String str2) {
        Intent intent = new Intent(str);
        intent.putExtra("com.vtble.service..EXTRA_ADDRESS", str2);
        Oxx0xo.oxoX(f27359OxI, "broadcast address = " + str2);
        sendBroadcast(intent);
    }

    public BluetoothGattCharacteristic II0xO0(String str, String str2, String str3) {
        List<BluetoothGattCharacteristic> characteristics;
        BluetoothGatt bluetoothGatt = this.f27363Oxx0xo.get(str);
        if (bluetoothGatt != null && bluetoothGatt.getServices() != null && str2 != null && str3 != null) {
            for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                if (str2.equalsIgnoreCase(bluetoothGattService.getUuid().toString()) && (characteristics = bluetoothGattService.getCharacteristics()) != null) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                        if (str3.equalsIgnoreCase(bluetoothGattCharacteristic.getUuid().toString())) {
                            return bluetoothGattCharacteristic;
                        }
                    }
                }
            }
        }
        return null;
    }

    public synchronized boolean OOXIXo(String str, boolean z) {
        this.f27368xoXoI = z;
        String str2 = f27359OxI;
        Oxx0xo.oxoX(str2, "connect start : " + str + ", autoConnect: " + z);
        BluetoothAdapter bluetoothAdapter = this.f27361IXxxXO;
        if (bluetoothAdapter != null && str != null) {
            BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
            if (remoteDevice == null) {
                Oxx0xo.X0o0xo(str2, "Device not found.  Unable to connect.");
                return false;
            }
            if (xoXoI.OOXIxO0().O0()) {
                this.f27368xoXoI = false;
            }
            int i = Build.VERSION.SDK_INT;
            BluetoothGatt connectGatt = i >= 26 ? remoteDevice.connectGatt(this, this.f27368xoXoI, this.f27360IIXOooo, 2, 1) : i >= 23 ? remoteDevice.connectGatt(this, this.f27368xoXoI, this.f27360IIXOooo, 2) : remoteDevice.connectGatt(this, this.f27368xoXoI, this.f27360IIXOooo);
            if (connectGatt != null) {
                this.f27363Oxx0xo.put(remoteDevice.getAddress(), connectGatt);
            }
            return true;
        }
        Oxx0xo.X0o0xo(str2, "BluetoothAdapter not initialized or unspecified address.");
        return false;
    }

    public void Oxx0IOOO(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        if (this.f27361IXxxXO == null) {
            Oxx0xo.X0o0xo(f27359OxI, "BluetoothAdapter not initialized");
            return;
        }
        BluetoothGatt bluetoothGatt = this.f27363Oxx0xo.get(str);
        bluetoothGattCharacteristic.setWriteType(z ? 2 : 1);
        if (bluetoothGatt != null) {
            String uuid = bluetoothGattCharacteristic.getUuid().toString();
            boolean writeCharacteristic = bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            Oxx0xo.oIX0oI(f27359OxI, "writeCharacteristic: " + IXxxXO.oIX0oI(uuid, uuid) + ", value: " + xxX.Oxx0xo(bluetoothGattCharacteristic.getValue()) + ", result: " + writeCharacteristic + ", Response: " + z + ",now: " + System.currentTimeMillis() + ",thread: " + Thread.currentThread().getName());
        }
    }

    public void X0o0xo(String str) {
        if (this.f27361IXxxXO == null) {
            Oxx0xo.X0o0xo(f27359OxI, "BluetoothAdapter not initialized");
            return;
        }
        BluetoothGatt bluetoothGatt = this.f27363Oxx0xo.get(str);
        if (bluetoothGatt == null) {
            Oxx0xo.oIX0oI(f27359OxI, "Do nothing for disconnect, address: " + str);
            return;
        }
        bluetoothGatt.disconnect();
        if (!this.f27368xoXoI) {
            bluetoothGatt.close();
            this.f27363Oxx0xo.remove(str);
            II0XooXoX("com.vtble.service..ACTION_GATT_DISCONNECTED", str);
        }
        Oxx0xo.oIX0oI(f27359OxI, "disconnect, gatt size: " + this.f27363Oxx0xo.size());
    }

    public void XO(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f27361IXxxXO == null) {
            Oxx0xo.X0o0xo(f27359OxI, "BluetoothAdapter not initialized");
            return;
        }
        boolean readCharacteristic = this.f27363Oxx0xo.get(str).readCharacteristic(bluetoothGattCharacteristic);
        String uuid = bluetoothGattCharacteristic.getUuid().toString();
        Oxx0xo.oIX0oI(f27359OxI, "readCharacteristic: " + IXxxXO.oIX0oI(uuid, uuid) + ", address: " + str + ", response: " + readCharacteristic + ",," + uuid);
    }

    public void oO(String str) {
        if (this.f27361IXxxXO == null) {
            Oxx0xo.X0o0xo(f27359OxI, "BluetoothAdapter not initialized");
            return;
        }
        BluetoothGatt bluetoothGatt = this.f27363Oxx0xo.get(str);
        if (bluetoothGatt != null) {
            bluetoothGatt.readRemoteRssi();
        }
    }

    public List<BluetoothGattService> oOoXoXO(String str) {
        BluetoothGatt bluetoothGatt = this.f27363Oxx0xo.get(str);
        if (bluetoothGatt != null) {
            return bluetoothGatt.getServices();
        }
        Log.d(f27359OxI, "getSupportedGattServices: null");
        return null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f27366o00;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        ooOOo0oXI();
        Log.d(f27359OxI, "onUnbind: vtbleservice");
        return super.onUnbind(intent);
    }

    public void ooOOo0oXI() {
        Iterator<String> it = this.f27363Oxx0xo.keySet().iterator();
        while (it.hasNext()) {
            this.f27363Oxx0xo.get(it.next()).close();
        }
    }

    public void x0XOIxOo() {
        if (this.f27361IXxxXO == null) {
            Oxx0xo.X0o0xo(f27359OxI, "BluetoothAdapter not initialized");
            return;
        }
        for (String str : this.f27363Oxx0xo.keySet()) {
            BluetoothGatt bluetoothGatt = this.f27363Oxx0xo.get(str);
            Oxx0xo.oxoX(f27359OxI, "VTBlluetoothService" + bluetoothGatt);
            bluetoothGatt.disconnect();
            bluetoothGatt.close();
            this.f27363Oxx0xo.remove(str);
        }
    }

    public boolean x0xO0oo() {
        String str;
        String str2 = f27359OxI;
        Oxx0xo.oxoX(str2, "initialize");
        if (this.f27362Oo == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.f27362Oo = bluetoothManager;
            if (bluetoothManager == null) {
                str = "Unable to initialize BluetoothManager.";
                Oxx0xo.II0xO0(str2, str);
                return false;
            }
        }
        BluetoothAdapter adapter = this.f27362Oo.getAdapter();
        this.f27361IXxxXO = adapter;
        if (adapter != null) {
            return true;
        }
        str = "Unable to obtain a BluetoothAdapter.";
        Oxx0xo.II0xO0(str2, str);
        return false;
    }

    @SuppressLint({"InlinedApi"})
    public void xxIXOIIO(String str, String str2, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        if (this.f27361IXxxXO == null) {
            Oxx0xo.X0o0xo(f27359OxI, "BluetoothAdapter not initialized");
            return;
        }
        BluetoothGatt bluetoothGatt = this.f27363Oxx0xo.get(str);
        boolean characteristicNotification = bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        String uuid = bluetoothGattCharacteristic.getUuid().toString();
        Oxx0xo.oIX0oI(f27359OxI, "setCharacteristicNotification: " + IXxxXO.oIX0oI(uuid, uuid) + ", enable: " + z + ", isNotify: " + characteristicNotification);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(IXxxXO.f27146II0xO0));
        for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
            Log.e(f27359OxI, "BluetoothGattDescriptor: " + bluetoothGattDescriptor.getUuid().toString());
        }
        if (descriptor == null) {
            Oxx0xo.oxoX(f27359OxI, "setCharacteristicNotification descriptor is null");
            return;
        }
        descriptor.setValue(z ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        boolean writeDescriptor = bluetoothGatt.writeDescriptor(descriptor);
        Log.d(f27359OxI, "notify: set " + writeDescriptor);
    }
}
