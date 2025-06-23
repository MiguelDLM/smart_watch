package com.goodix.ble.libble.v2.impl;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.Nullable;
import com.goodix.ble.libble.v2.gb.gatt.GBGattCharacteristic;
import com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureRead;
import com.goodix.ble.libble.v2.gb.procedure.GBGattProcedureWrite;
import com.goodix.ble.libble.v2.impl.procedure.DescriptorRead;
import com.goodix.ble.libble.v2.impl.procedure.DescriptorWrite;
import com.goodix.ble.libcomx.ILogger;
import com.goodix.ble.libcomx.event.Event;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes9.dex */
public class BleDescriptorX implements GBGattDescriptor, a {
    private UUID e;
    private BleCharacteristicX f;
    private BleRemoteDevice g;
    boolean h = false;
    boolean i = false;
    private Event<byte[]> j = null;
    private Event<byte[]> k = null;

    @Nullable
    private BluetoothGattDescriptor l;

    public BleDescriptorX(BleRemoteDevice bleRemoteDevice, BleCharacteristicX bleCharacteristicX, UUID uuid) {
        this.g = bleRemoteDevice;
        this.f = bleCharacteristicX;
        this.e = uuid;
    }

    public void a(BluetoothGattDescriptor bluetoothGattDescriptor, ArrayList<String> arrayList) {
        if (bluetoothGattDescriptor == null) {
            this.l = null;
            return;
        }
        if (this.e.equals(bluetoothGattDescriptor.getUuid())) {
            this.l = bluetoothGattDescriptor;
            return;
        }
        ILogger logger = this.g.getLogger();
        if (logger != null) {
            logger.w("GBGattDescriptor", this.e + " is not match to " + bluetoothGattDescriptor.getUuid());
        }
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor
    public void clearEventListener(Object obj) {
        Event<byte[]> event = this.j;
        if (event != null) {
            event.clear(obj);
        }
        Event<byte[]> event2 = this.k;
        if (event2 != null) {
            event2.clear(obj);
        }
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor
    public Event<byte[]> evtRead() {
        if (this.j == null) {
            synchronized (this) {
                try {
                    if (this.j == null) {
                        this.j = new Event<>(this, 4353);
                    }
                } finally {
                }
            }
        }
        return this.j;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor
    public Event<byte[]> evtWritten() {
        if (this.k == null) {
            synchronized (this) {
                try {
                    if (this.k == null) {
                        this.k = new Event<>(this, GBGattDescriptor.EVT_WRITTEN);
                    }
                } finally {
                }
            }
        }
        return this.k;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor
    public GBGattCharacteristic getCharacteristic() {
        return this.f;
    }

    @Nullable
    public BluetoothGattDescriptor getGattDescriptor() {
        return this.l;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor
    public int getInstanceId() {
        return 0;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor
    public UUID getUuid() {
        return this.e;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor
    public byte[] getValue() {
        BluetoothGattDescriptor bluetoothGattDescriptor = this.l;
        return bluetoothGattDescriptor != null ? bluetoothGattDescriptor.getValue() : new byte[0];
    }

    @Override // com.goodix.ble.libble.v2.impl.a
    public boolean onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        return false;
    }

    @Override // com.goodix.ble.libble.v2.impl.a
    public boolean onDescriptorChanged(BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        BluetoothGattDescriptor bluetoothGattDescriptor2 = this.l;
        if (bluetoothGattDescriptor2 == null || !bluetoothGattDescriptor2.equals(bluetoothGattDescriptor)) {
            return false;
        }
        Event<byte[]> event = i == 1 ? this.j : i == 2 ? this.k : null;
        if (event != null) {
            event.postEvent(this.l.getValue());
        }
        return true;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor
    public GBGattProcedureRead read() {
        DescriptorRead descriptorRead = new DescriptorRead();
        descriptorRead.setRemoteDevice(this.g);
        descriptorRead.setTargetDescriptor(this);
        ILogger logger = this.g.getLogger();
        if (logger != null) {
            descriptorRead.setLogger(logger);
        }
        return descriptorRead;
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor
    public void setValue(byte[] bArr) {
        BluetoothGattDescriptor bluetoothGattDescriptor = this.l;
        if (bluetoothGattDescriptor != null) {
            bluetoothGattDescriptor.setValue(bArr);
        }
    }

    @Override // com.goodix.ble.libble.v2.gb.gatt.GBGattDescriptor
    public GBGattProcedureWrite write(byte[] bArr) {
        DescriptorWrite descriptorWrite = new DescriptorWrite();
        descriptorWrite.setRemoteDevice(this.g);
        descriptorWrite.setTargetDescriptor(this);
        descriptorWrite.setValue(bArr);
        ILogger logger = this.g.getLogger();
        if (logger != null) {
            descriptorWrite.setLogger(logger);
        }
        return descriptorWrite;
    }
}
