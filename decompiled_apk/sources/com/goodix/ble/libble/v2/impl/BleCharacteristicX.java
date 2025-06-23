package com.goodix.ble.libble.v2.impl;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.util.Log;
import androidx.annotation.Nullable;
import com.goodix.ble.libble.BleUuid;
import com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic;
import com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor;
import com.goodix.ble.libble.v2.gb.gatt.GBGattService;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureRead;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite;
import com.goodix.ble.libble.v2.gb.procedure.GBProcedure;
import com.goodix.ble.libble.v2.impl.procedure.CharacteristicRead;
import com.goodix.ble.libble.v2.impl.procedure.CharacteristicWrite;
import com.goodix.ble.libble.v2.impl.procedure.NotificationEnable;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes9.dex */
public class BleCharacteristicX implements GBGattCharacteristic, a {
    private BleRemoteDevice e;
    private BleServiceX f;
    private UUID g;
    private BluetoothGattCharacteristic h;

    @Nullable
    private ArrayList<BleDescriptorX> k;
    boolean i = false;
    boolean j = false;
    public boolean needEnableNotify = false;
    public boolean needEnableIndicate = false;
    private Event<byte[]> l = null;
    private Event<byte[]> m = null;
    private Event<byte[]> n = null;
    private Event<byte[]> o = null;

    public BleCharacteristicX(BleRemoteDevice bleRemoteDevice, BleServiceX bleServiceX, UUID uuid) {
        this.e = bleRemoteDevice;
        this.f = bleServiceX;
        this.g = uuid;
    }

    public void a(BluetoothGattCharacteristic bluetoothGattCharacteristic, ArrayList<String> arrayList) {
        if (bluetoothGattCharacteristic == null) {
            this.h = null;
            ArrayList<BleDescriptorX> arrayList2 = this.k;
            if (arrayList2 != null) {
                Iterator<BleDescriptorX> it = arrayList2.iterator();
                while (it.hasNext()) {
                    it.next().a(null, arrayList);
                }
                return;
            }
            return;
        }
        ILogger logger = this.e.getLogger();
        if (!this.g.equals(bluetoothGattCharacteristic.getUuid())) {
            if (logger != null) {
                logger.w("GBGattCharacteristic", this.g + " is not match to " + bluetoothGattCharacteristic.getUuid());
                return;
            }
            return;
        }
        this.h = bluetoothGattCharacteristic;
        List<BluetoothGattDescriptor> descriptors = bluetoothGattCharacteristic.getDescriptors();
        if (descriptors.isEmpty()) {
            return;
        }
        ArrayList<BleDescriptorX> arrayList3 = this.k;
        if (arrayList3 == null) {
            this.k = new ArrayList<>(descriptors.size());
        } else {
            arrayList3.ensureCapacity(descriptors.size());
        }
        HashMap hashMap = new HashMap(this.k.size());
        Iterator<BleDescriptorX> it2 = this.k.iterator();
        while (it2.hasNext()) {
            BleDescriptorX next = it2.next();
            UUID uuid = next.getUuid();
            ArrayList arrayList4 = (ArrayList) hashMap.get(uuid);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList(4);
                hashMap.put(uuid, arrayList4);
            }
            arrayList4.add(next);
        }
        this.k.clear();
        for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
            UUID uuid2 = bluetoothGattDescriptor.getUuid();
            ArrayList arrayList5 = (ArrayList) hashMap.get(uuid2);
            if (arrayList5 == null || arrayList5.isEmpty()) {
                Log.d("onDiscovered", "    D +->" + uuid2);
                BleDescriptorX bleDescriptorX = new BleDescriptorX(this.e, this, uuid2);
                bleDescriptorX.a(bluetoothGattDescriptor, arrayList);
                this.k.add(bleDescriptorX);
            } else {
                Log.d("onDiscovered", "    D =->" + uuid2);
                BleDescriptorX bleDescriptorX2 = (BleDescriptorX) arrayList5.remove(0);
                bleDescriptorX2.a(bluetoothGattDescriptor, arrayList);
                this.k.add(bleDescriptorX2);
                if (arrayList5.isEmpty()) {
                    hashMap.remove(uuid2);
                }
            }
        }
        Iterator it3 = hashMap.values().iterator();
        while (it3.hasNext()) {
            Iterator it4 = ((ArrayList) it3.next()).iterator();
            while (it4.hasNext()) {
                BleDescriptorX bleDescriptorX3 = (BleDescriptorX) it4.next();
                if (bleDescriptorX3.i) {
                    arrayList.add("Characteristic " + this.g + " does not find required descriptor: " + bleDescriptorX3.getUuid());
                }
                if (bleDescriptorX3.h) {
                    this.k.add(bleDescriptorX3);
                }
                bleDescriptorX3.a(null, arrayList);
            }
        }
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public void clearEventListener(Object obj) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(this.l);
        arrayList.add(this.m);
        arrayList.add(this.n);
        arrayList.add(this.o);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Event event = (Event) it.next();
            if (event != null) {
                event.clear(obj);
            }
        }
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public GBGattDescriptor defineDescriptor(UUID uuid, boolean z) {
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        BleDescriptorX bleDescriptorX = new BleDescriptorX(this.e, this, uuid);
        bleDescriptorX.h = true;
        bleDescriptorX.i = z;
        this.k.add(bleDescriptorX);
        return bleDescriptorX;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public Event<byte[]> evtIndicate() {
        if (this.o == null) {
            synchronized (this) {
                try {
                    if (this.o == null) {
                        this.o = new Event<>(this, 66);
                    }
                } finally {
                }
            }
        }
        return this.o;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public Event<byte[]> evtNotify() {
        if (this.n == null) {
            synchronized (this) {
                try {
                    if (this.n == null) {
                        this.n = new Event<>(this, 55);
                    }
                } finally {
                }
            }
        }
        return this.n;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public Event<byte[]> evtRead() {
        if (this.l == null) {
            synchronized (this) {
                try {
                    if (this.l == null) {
                        this.l = new Event<>(this, 33);
                    }
                } finally {
                }
            }
        }
        return this.l;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public Event<byte[]> evtWritten() {
        if (this.m == null) {
            synchronized (this) {
                try {
                    if (this.m == null) {
                        this.m = new Event<>(this, 44);
                    }
                } finally {
                }
            }
        }
        return this.m;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public List<GBGattDescriptor> getDescriptor(UUID uuid) {
        ArrayList<BleDescriptorX> arrayList = this.k;
        if (arrayList == null || arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<BleDescriptorX> it = this.k.iterator();
        while (it.hasNext()) {
            BleDescriptorX next = it.next();
            if (next.getUuid().equals(uuid)) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public List<GBGattDescriptor> getDescriptors() {
        ArrayList<BleDescriptorX> arrayList = this.k;
        return (arrayList == null || arrayList.isEmpty()) ? Collections.emptyList() : new ArrayList(this.k);
    }

    public BluetoothGattCharacteristic getGattCharacteristic() {
        return this.h;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public int getInstanceId() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.h;
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getInstanceId();
        }
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public int getProperty() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.h;
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getProperties();
        }
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public GBGattService getService() {
        return this.f;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public UUID getUuid() {
        return this.g;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public byte[] getValue() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.h;
        return bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getValue() : new byte[0];
    }

    public boolean isDiscovered() {
        return this.h != null;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public boolean isIndicateEnabled() {
        return a(2);
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public boolean isNotifyEnabled() {
        return a(1);
    }

    @Override // com.goodix.ble.libble.v2.impl.a
    public boolean onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.h;
        if (bluetoothGattCharacteristic2 == null || !bluetoothGattCharacteristic2.equals(bluetoothGattCharacteristic)) {
            return false;
        }
        Event<byte[]> event = i == 1 ? this.l : i == 2 ? this.m : i == 3 ? this.n : i == 4 ? this.o : null;
        if (event != null) {
            event.postEvent(bluetoothGattCharacteristic.getValue());
        }
        return true;
    }

    @Override // com.goodix.ble.libble.v2.impl.a
    public boolean onDescriptorChanged(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        if (this.k == null || (bluetoothGattCharacteristic = this.h) == null || !bluetoothGattCharacteristic.equals(bluetoothGattDescriptor.getCharacteristic())) {
            return false;
        }
        Iterator<BleDescriptorX> it = this.k.iterator();
        while (it.hasNext()) {
            if (it.next().onDescriptorChanged(bluetoothGattDescriptor, i)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public GBGattProcedureRead read() {
        CharacteristicRead characteristicRead = new CharacteristicRead();
        characteristicRead.setRemoteDevice(this.e);
        characteristicRead.setTargetCharacteristic(this);
        ILogger logger = this.e.getLogger();
        if (logger != null) {
            characteristicRead.setLogger(logger);
        }
        return characteristicRead;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public GBGattDescriptor requireDescriptor(UUID uuid, boolean z) {
        BleDescriptorX bleDescriptorX;
        synchronized (this) {
            try {
                ArrayList<BleDescriptorX> arrayList = this.k;
                if (arrayList != null) {
                    Iterator<BleDescriptorX> it = arrayList.iterator();
                    while (it.hasNext()) {
                        bleDescriptorX = it.next();
                        if (bleDescriptorX.getUuid().equals(uuid)) {
                            BleDescriptorX bleDescriptorX2 = bleDescriptorX;
                            bleDescriptorX2.h = true;
                            bleDescriptorX2.i = z;
                            break;
                        }
                    }
                }
                bleDescriptorX = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bleDescriptorX == null ? defineDescriptor(uuid, z) : bleDescriptorX;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public GBProcedure setEnableIndicate(boolean z) {
        NotificationEnable notificationEnable = new NotificationEnable();
        notificationEnable.setRemoteDevice(this.e);
        notificationEnable.setTargetCharacteristic(this);
        notificationEnable.setEnable(z);
        notificationEnable.setForIndicate();
        ILogger logger = this.e.getLogger();
        if (logger != null) {
            notificationEnable.setLogger(logger);
        }
        return notificationEnable;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public GBProcedure setEnableNotify(boolean z) {
        NotificationEnable notificationEnable = new NotificationEnable();
        notificationEnable.setRemoteDevice(this.e);
        notificationEnable.setTargetCharacteristic(this);
        notificationEnable.setEnable(z);
        ILogger logger = this.e.getLogger();
        if (logger != null) {
            notificationEnable.setLogger(logger);
        }
        return notificationEnable;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public void setValue(byte[] bArr) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.h;
        if (bluetoothGattCharacteristic != null) {
            bluetoothGattCharacteristic.setValue(bArr);
        }
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public GBGattProcedureWrite writeByCommand(byte[] bArr, boolean z) {
        CharacteristicWrite characteristicWrite = new CharacteristicWrite();
        characteristicWrite.setRemoteDevice(this.e);
        characteristicWrite.setTargetCharacteristic(this);
        characteristicWrite.setValue(bArr);
        characteristicWrite.setWriteType(z ? 4 : 1);
        ILogger logger = this.e.getLogger();
        if (logger != null) {
            characteristicWrite.setLogger(logger);
        }
        return characteristicWrite;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public GBGattProcedureWrite writeByRequest(byte[] bArr) {
        CharacteristicWrite characteristicWrite = new CharacteristicWrite();
        characteristicWrite.setRemoteDevice(this.e);
        characteristicWrite.setTargetCharacteristic(this);
        characteristicWrite.setValue(bArr);
        characteristicWrite.setWriteType(2);
        ILogger logger = this.e.getLogger();
        if (logger != null) {
            characteristicWrite.setLogger(logger);
        }
        return characteristicWrite;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic
    public boolean writeDirectly(boolean z, boolean z2, byte[] bArr) {
        BleServiceX bleServiceX = this.f;
        if (bleServiceX == null || this.h == null) {
            return false;
        }
        BleGattX gatt = ((BleRemoteDevice) bleServiceX.getRemoteDevice()).getGatt();
        this.h.setWriteType(z ? 2 : z2 ? 4 : 1);
        this.h.setValue(bArr);
        return gatt.tryWriteCharacteristic(this.h);
    }

    private boolean a(int i) {
        BluetoothGattDescriptor descriptor;
        byte[] value;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.h;
        return bluetoothGattCharacteristic != null && (descriptor = bluetoothGattCharacteristic.getDescriptor(BleUuid.CCCD)) != null && (value = descriptor.getValue()) != null && value.length == 2 && value[1] == 0 && ((value[0] & 255) & i) == i;
    }
}
