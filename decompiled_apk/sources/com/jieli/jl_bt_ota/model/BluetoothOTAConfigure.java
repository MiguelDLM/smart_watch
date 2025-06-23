package com.jieli.jl_bt_ota.model;

import androidx.annotation.NonNull;
import com.jieli.jl_bt_ota.interfaces.rcsp.ICmdSnGenerator;

/* loaded from: classes10.dex */
public class BluetoothOTAConfigure {
    public static final int PREFER_BLE = 0;
    public static final int PREFER_SPP = 1;
    private byte[] firmwareFileData;
    private String firmwareFilePath;
    private boolean isPriorityCallbackOtaFinish;
    private boolean isUseAuthDevice;

    @Deprecated
    private String scanFilterData;
    private ICmdSnGenerator snGenerator;
    private int priority = 0;
    private boolean isUseReconnect = false;
    private int bleIntervalMs = 500;
    private int timeoutMs = 3000;
    private boolean isUseJLServer = false;
    private int mtu = 20;
    private boolean isNeedChangeMtu = false;
    private int bleScanMode = 0;

    public static BluetoothOTAConfigure createDefault() {
        return new BluetoothOTAConfigure().setPriority(0).setBleIntervalMs(500).setTimeoutMs(3000).setUseAuthDevice(false).setUseReconnect(false).setMtu(20).setUseJLServer(false).setNeedChangeMtu(false);
    }

    public int getBleIntervalMs() {
        return this.bleIntervalMs;
    }

    public int getBleScanMode() {
        return this.bleScanMode;
    }

    public byte[] getFirmwareFileData() {
        return this.firmwareFileData;
    }

    public String getFirmwareFilePath() {
        return this.firmwareFilePath;
    }

    public int getMtu() {
        return this.mtu;
    }

    public int getPriority() {
        return this.priority;
    }

    @Deprecated
    public String getScanFilterData() {
        return this.scanFilterData;
    }

    public ICmdSnGenerator getSnGenerator() {
        return this.snGenerator;
    }

    public int getTimeoutMs() {
        return this.timeoutMs;
    }

    public boolean isNeedChangeMtu() {
        return this.isNeedChangeMtu;
    }

    public boolean isPriorityCallbackOtaFinish() {
        return this.isPriorityCallbackOtaFinish;
    }

    public boolean isUseAuthDevice() {
        return this.isUseAuthDevice;
    }

    public boolean isUseJLServer() {
        return this.isUseJLServer;
    }

    public boolean isUseReconnect() {
        return this.isUseReconnect;
    }

    public BluetoothOTAConfigure setBleIntervalMs(int i) {
        this.bleIntervalMs = i;
        return this;
    }

    public BluetoothOTAConfigure setBleScanMode(int i) {
        this.bleScanMode = i;
        return this;
    }

    public BluetoothOTAConfigure setFirmwareFileData(byte[] bArr) {
        this.firmwareFileData = bArr;
        return this;
    }

    public BluetoothOTAConfigure setFirmwareFilePath(String str) {
        this.firmwareFilePath = str;
        return this;
    }

    public BluetoothOTAConfigure setMtu(int i) {
        this.mtu = i;
        return this;
    }

    public BluetoothOTAConfigure setNeedChangeMtu(boolean z) {
        this.isNeedChangeMtu = z;
        return this;
    }

    public BluetoothOTAConfigure setPriority(int i) {
        this.priority = i;
        return this;
    }

    public BluetoothOTAConfigure setPriorityCallbackOtaFinish(boolean z) {
        this.isPriorityCallbackOtaFinish = z;
        return this;
    }

    @Deprecated
    public BluetoothOTAConfigure setScanFilterData(String str) {
        this.scanFilterData = str;
        return this;
    }

    public BluetoothOTAConfigure setSnGenerator(ICmdSnGenerator iCmdSnGenerator) {
        this.snGenerator = iCmdSnGenerator;
        return this;
    }

    public BluetoothOTAConfigure setTimeoutMs(int i) {
        if (i < 500) {
            i = 500;
        }
        this.timeoutMs = i;
        return this;
    }

    public BluetoothOTAConfigure setUseAuthDevice(boolean z) {
        this.isUseAuthDevice = z;
        return this;
    }

    public BluetoothOTAConfigure setUseJLServer(boolean z) {
        this.isUseJLServer = z;
        return this;
    }

    public BluetoothOTAConfigure setUseReconnect(boolean z) {
        this.isUseReconnect = z;
        return this;
    }

    @NonNull
    public String toString() {
        int length;
        StringBuilder sb = new StringBuilder();
        sb.append("BluetoothOTAConfigure{priority=");
        sb.append(this.priority);
        sb.append(", isUseReconnect=");
        sb.append(this.isUseReconnect);
        sb.append(", isUseAuthDevice=");
        sb.append(this.isUseAuthDevice);
        sb.append(", bleIntervalMs=");
        sb.append(this.bleIntervalMs);
        sb.append(", timeoutMs=");
        sb.append(this.timeoutMs);
        sb.append(", isUseJLServer=");
        sb.append(this.isUseJLServer);
        sb.append(", firmwareFilePath='");
        sb.append(this.firmwareFilePath);
        sb.append('\'');
        sb.append(", scanFilterData='");
        sb.append(this.scanFilterData);
        sb.append('\'');
        sb.append(", mtu=");
        sb.append(this.mtu);
        sb.append(", isNeedChangeMtu=");
        sb.append(this.isNeedChangeMtu);
        sb.append(", bleScanMode=");
        sb.append(this.bleScanMode);
        sb.append(", firmwareFileData= ");
        byte[] bArr = this.firmwareFileData;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        sb.append(length);
        sb.append(", snGenerator=");
        sb.append(this.snGenerator);
        sb.append(", isPriorityCallbackOtaFinish=");
        sb.append(this.isPriorityCallbackOtaFinish);
        sb.append('}');
        return sb.toString();
    }
}
