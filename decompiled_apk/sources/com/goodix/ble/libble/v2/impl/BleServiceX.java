package com.goodix.ble.libble.v2.impl;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Log;
import androidx.annotation.Nullable;
import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic;
import com.goodix.ble.libble.v2.gb.gatt.GBGattService;
import com.goodix.ble.libcomx.ILogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes9.dex */
public class BleServiceX implements GBGattService, a {
    private BleRemoteDevice e;
    private UUID f;
    private BluetoothGattService g;
    boolean h = false;
    boolean i = false;

    @Nullable
    private ArrayList<BleCharacteristicX> j;

    public BleServiceX(BleRemoteDevice bleRemoteDevice, UUID uuid) {
        this.e = bleRemoteDevice;
        this.f = uuid;
    }

    public void a(BluetoothGattService bluetoothGattService, ArrayList<String> arrayList) {
        if (bluetoothGattService == null) {
            this.g = null;
            ArrayList<BleCharacteristicX> arrayList2 = this.j;
            if (arrayList2 != null) {
                Iterator<BleCharacteristicX> it = arrayList2.iterator();
                while (it.hasNext()) {
                    it.next().a(null, arrayList);
                }
                return;
            }
            return;
        }
        ILogger logger = this.e.getLogger();
        if (!this.f.equals(bluetoothGattService.getUuid())) {
            if (logger != null) {
                logger.w("GBGattService", this.f + " is not match to " + bluetoothGattService.getUuid());
                return;
            }
            return;
        }
        this.g = bluetoothGattService;
        List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
        if (characteristics.isEmpty()) {
            return;
        }
        ArrayList<BleCharacteristicX> arrayList3 = this.j;
        if (arrayList3 == null) {
            this.j = new ArrayList<>(characteristics.size());
        } else {
            arrayList3.ensureCapacity(characteristics.size());
        }
        HashMap hashMap = new HashMap(this.j.size());
        Iterator<BleCharacteristicX> it2 = this.j.iterator();
        while (it2.hasNext()) {
            BleCharacteristicX next = it2.next();
            UUID uuid = next.getUuid();
            ArrayList arrayList4 = (ArrayList) hashMap.get(uuid);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList(4);
                hashMap.put(uuid, arrayList4);
            }
            arrayList4.add(next);
        }
        this.j.clear();
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
            UUID uuid2 = bluetoothGattCharacteristic.getUuid();
            ArrayList arrayList5 = (ArrayList) hashMap.get(uuid2);
            if (arrayList5 == null || arrayList5.isEmpty()) {
                Log.d("onDiscovered", "  C +->  " + uuid2);
                BleCharacteristicX bleCharacteristicX = new BleCharacteristicX(this.e, this, uuid2);
                bleCharacteristicX.a(bluetoothGattCharacteristic, arrayList);
                this.j.add(bleCharacteristicX);
            } else {
                Log.d("onDiscovered", "  C =->  " + uuid2);
                BleCharacteristicX bleCharacteristicX2 = (BleCharacteristicX) arrayList5.remove(0);
                bleCharacteristicX2.a(bluetoothGattCharacteristic, arrayList);
                this.j.add(bleCharacteristicX2);
                if (arrayList5.isEmpty()) {
                    hashMap.remove(uuid2);
                }
            }
        }
        Iterator it3 = hashMap.values().iterator();
        while (it3.hasNext()) {
            Iterator it4 = ((ArrayList) it3.next()).iterator();
            while (it4.hasNext()) {
                BleCharacteristicX bleCharacteristicX3 = (BleCharacteristicX) it4.next();
                if (bleCharacteristicX3.j) {
                    arrayList.add("Service " + this.f + " does not find required characteristic: " + bleCharacteristicX3.getUuid());
                }
                if (bleCharacteristicX3.i) {
                    this.j.add(bleCharacteristicX3);
                }
                bleCharacteristicX3.a(null, arrayList);
            }
        }
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattService
    public void clearEventListener(Object obj) {
        ArrayList<BleCharacteristicX> arrayList = this.j;
        if (arrayList != null) {
            Iterator<BleCharacteristicX> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().clearEventListener(obj);
            }
        }
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattService
    public GBGattCharacteristic defineCharacteristic(UUID uuid, boolean z, boolean z2, boolean z3) {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        BleCharacteristicX bleCharacteristicX = new BleCharacteristicX(this.e, this, uuid);
        bleCharacteristicX.i = true;
        bleCharacteristicX.j = z;
        bleCharacteristicX.needEnableNotify = z3;
        bleCharacteristicX.needEnableIndicate = z2;
        this.j.add(bleCharacteristicX);
        return bleCharacteristicX;
    }

    public boolean equals(BluetoothGattService bluetoothGattService) {
        BluetoothGattService bluetoothGattService2;
        if (bluetoothGattService == null || (bluetoothGattService2 = this.g) == null) {
            return false;
        }
        if (bluetoothGattService == bluetoothGattService2) {
            return true;
        }
        return bluetoothGattService.getUuid().equals(this.g.getUuid()) && bluetoothGattService.getInstanceId() == this.g.getInstanceId();
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattService
    public List<GBGattCharacteristic> getCharacteristic(UUID uuid) {
        ArrayList<BleCharacteristicX> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<BleCharacteristicX> it = this.j.iterator();
        while (it.hasNext()) {
            BleCharacteristicX next = it.next();
            if (next.getUuid().equals(uuid)) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public ArrayList<BleCharacteristicX> getCharacteristicList() {
        ArrayList<BleCharacteristicX> arrayList = this.j;
        return arrayList == null ? new ArrayList<>(0) : arrayList;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattService
    public List<GBGattCharacteristic> getCharacteristics() {
        ArrayList<BleCharacteristicX> arrayList = this.j;
        return (arrayList == null || arrayList.isEmpty()) ? Collections.emptyList() : new ArrayList(this.j);
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattService
    public List<GBGattService> getIncludeService() {
        ArrayList arrayList = new ArrayList();
        BluetoothGattService bluetoothGattService = this.g;
        if (bluetoothGattService != null) {
            Iterator<BluetoothGattService> it = bluetoothGattService.getIncludedServices().iterator();
            while (it.hasNext()) {
                for (GBGattService gBGattService : this.e.getService(it.next().getUuid())) {
                    if (!arrayList.contains(gBGattService)) {
                        arrayList.add(gBGattService);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattService
    public int getInstanceId() {
        BluetoothGattService bluetoothGattService = this.g;
        if (bluetoothGattService != null) {
            return bluetoothGattService.getInstanceId();
        }
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattService
    public GBRemoteDevice getRemoteDevice() {
        return this.e;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattService
    public UUID getUuid() {
        return this.f;
    }

    public boolean isDiscovered() {
        return this.g != null;
    }

    @Override // com.goodix.ble.libble.v2.impl.a
    public boolean onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattService bluetoothGattService;
        if (this.j == null || (bluetoothGattService = this.g) == null || !bluetoothGattService.equals(bluetoothGattCharacteristic.getService())) {
            return false;
        }
        Iterator<BleCharacteristicX> it = this.j.iterator();
        while (it.hasNext()) {
            if (it.next().onCharacteristicChanged(bluetoothGattCharacteristic, i)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.goodix.ble.libble.v2.impl.a
    public boolean onDescriptorChanged(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        BluetoothGattService bluetoothGattService;
        if (this.j == null || (bluetoothGattService = this.g) == null || !bluetoothGattService.equals(bluetoothGattDescriptor.getCharacteristic().getService())) {
            return false;
        }
        Iterator<BleCharacteristicX> it = this.j.iterator();
        while (it.hasNext()) {
            if (it.next().onDescriptorChanged(bluetoothGattDescriptor, i)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattService
    public GBGattCharacteristic requireCharacteristic(UUID uuid, boolean z, boolean z2, boolean z3) {
        BleCharacteristicX bleCharacteristicX;
        synchronized (this) {
            try {
                ArrayList<BleCharacteristicX> arrayList = this.j;
                if (arrayList != null) {
                    Iterator<BleCharacteristicX> it = arrayList.iterator();
                    while (it.hasNext()) {
                        bleCharacteristicX = it.next();
                        if (bleCharacteristicX.getUuid().equals(uuid)) {
                            if (bleCharacteristicX instanceof BleCharacteristicX) {
                                BleCharacteristicX bleCharacteristicX2 = bleCharacteristicX;
                                bleCharacteristicX2.i = true;
                                bleCharacteristicX2.j = z;
                                bleCharacteristicX2.needEnableNotify = z3;
                                bleCharacteristicX2.needEnableIndicate = z2;
                            }
                        }
                    }
                }
                bleCharacteristicX = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bleCharacteristicX == null ? defineCharacteristic(uuid, z, z2, z3) : bleCharacteristicX;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattService
    public boolean undefineService() {
        if (!this.h) {
            return false;
        }
        this.h = false;
        this.i = false;
        a(null, null);
        return this.e.getServiceList().remove(this);
    }
}
