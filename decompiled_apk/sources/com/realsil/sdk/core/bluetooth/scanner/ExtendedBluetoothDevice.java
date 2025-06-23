package com.realsil.sdk.core.bluetooth.scanner;

import android.bluetooth.BluetoothDevice;
import com.realsil.sdk.core.bluetooth.utils.BluetoothUuid;

/* loaded from: classes11.dex */
public class ExtendedBluetoothDevice {
    public static final boolean DEVICE_IS_BONDED = true;
    public static final boolean DEVICE_NOT_BONDED = false;
    public static final int NO_RSSI = -1000;

    /* renamed from: a, reason: collision with root package name */
    public int f19500a;
    public boolean b;
    public BluetoothDevice device;
    public boolean isBonded;
    public boolean isConnected;
    public String name;
    public int rssi;
    public byte[] scanRecord;
    public SpecScanRecord specScanRecord;
    public long timestamp;

    /* loaded from: classes11.dex */
    public static class AddressComparator {
        public String address;

        public boolean equals(Object obj) {
            if (obj instanceof ExtendedBluetoothDevice) {
                return this.address.equals(((ExtendedBluetoothDevice) obj).device.getAddress());
            }
            return super.equals(obj);
        }
    }

    public ExtendedBluetoothDevice(BluetoothDevice bluetoothDevice, String str) {
        this(bluetoothDevice, str, -1000, false, false, null);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExtendedBluetoothDevice) {
            return this.device.getAddress().equals(((ExtendedBluetoothDevice) obj).device.getAddress());
        }
        return super.equals(obj);
    }

    public int getConnectState() {
        return this.f19500a;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public String getName() {
        return this.name;
    }

    public int getRssi() {
        return this.rssi;
    }

    public byte[] getScanRecord() {
        return this.scanRecord;
    }

    public SpecScanRecord getSpecScanRecord() {
        return this.specScanRecord;
    }

    public boolean isBonded() {
        return this.isBonded;
    }

    public boolean isConnect() {
        return this.isConnected;
    }

    public boolean isHogp() {
        return this.b;
    }

    public void setBonded(boolean z) {
        this.isBonded = z;
    }

    public void setConnect(boolean z) {
        this.isConnected = z;
    }

    public void setConnectState(int i) {
        boolean z;
        this.f19500a = i;
        if (i == 2) {
            z = true;
        } else {
            z = false;
        }
        this.isConnected = z;
    }

    public void setDevice(BluetoothDevice bluetoothDevice) {
        this.device = bluetoothDevice;
    }

    public void setHogp(boolean z) {
        this.b = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public void setScanRecord(byte[] bArr) {
        this.scanRecord = bArr;
        SpecScanRecord parseFromBytes = SpecScanRecord.parseFromBytes(bArr);
        this.specScanRecord = parseFromBytes;
        if (parseFromBytes != null && parseFromBytes.getServiceUuids() != null) {
            this.b = this.specScanRecord.getServiceUuids().contains(BluetoothUuid.HOGP);
        }
    }

    public ExtendedBluetoothDevice(BluetoothDevice bluetoothDevice, String str, int i) {
        this(bluetoothDevice, str, i, false, false, null);
    }

    public ExtendedBluetoothDevice(BluetoothDevice bluetoothDevice, String str, int i, boolean z, boolean z2) {
        this(bluetoothDevice, str, i, z, z2, null);
    }

    public ExtendedBluetoothDevice(BluetoothDevice bluetoothDevice, String str, int i, boolean z, boolean z2, byte[] bArr) {
        this.device = bluetoothDevice;
        this.name = str;
        this.rssi = i;
        this.isBonded = z;
        this.isConnected = z2;
        setScanRecord(bArr);
    }
}
