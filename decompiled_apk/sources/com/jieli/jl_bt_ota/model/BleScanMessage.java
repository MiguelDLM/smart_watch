package com.jieli.jl_bt_ota.model;

import com.jieli.jl_bt_ota.util.CHexConver;
import java.io.Serializable;

/* loaded from: classes10.dex */
public class BleScanMessage implements Serializable {
    private int battery;
    private int deviceType;
    private int deviceVersion;
    private String identify;
    private boolean isEnableConnect = true;
    private boolean isOTA;
    private String oldBleAddress;
    private int pid;
    private byte[] rawData;
    private int rssi;
    private int uid;
    private int version;
    private int vid;

    public int getBattery() {
        return this.battery;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getDeviceVersion() {
        return this.deviceVersion;
    }

    public String getIdentify() {
        return this.identify;
    }

    public String getOldBleAddress() {
        return this.oldBleAddress;
    }

    public int getPid() {
        return this.pid;
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    public int getRssi() {
        return this.rssi;
    }

    public int getUid() {
        return this.uid;
    }

    public int getVersion() {
        return this.version;
    }

    public int getVid() {
        return this.vid;
    }

    public boolean isEnableConnect() {
        return this.isEnableConnect;
    }

    public boolean isOTA() {
        return this.isOTA;
    }

    public BleScanMessage setBattery(int i) {
        this.battery = i;
        return this;
    }

    public BleScanMessage setDeviceType(int i) {
        this.deviceType = i;
        return this;
    }

    public BleScanMessage setDeviceVersion(int i) {
        this.deviceVersion = i;
        return this;
    }

    public BleScanMessage setEnableConnect(boolean z) {
        this.isEnableConnect = z;
        return this;
    }

    public BleScanMessage setIdentify(String str) {
        this.identify = str;
        return this;
    }

    public BleScanMessage setOTA(boolean z) {
        this.isOTA = z;
        return this;
    }

    public BleScanMessage setOldBleAddress(String str) {
        this.oldBleAddress = str;
        return this;
    }

    public BleScanMessage setPid(int i) {
        this.pid = i;
        return this;
    }

    public BleScanMessage setRawData(byte[] bArr) {
        this.rawData = bArr;
        return this;
    }

    public BleScanMessage setRssi(int i) {
        this.rssi = i;
        return this;
    }

    public BleScanMessage setUid(int i) {
        this.uid = i;
        return this;
    }

    public BleScanMessage setVersion(int i) {
        this.version = i;
        return this;
    }

    public BleScanMessage setVid(int i) {
        this.vid = i;
        return this;
    }

    public String toString() {
        return "BleScanMessage{rawData=" + CHexConver.byte2HexStr(this.rawData) + ", rssi=" + this.rssi + ", isEnableConnect=" + this.isEnableConnect + ", vid=" + this.vid + ", uid=" + this.uid + ", pid=" + this.pid + ", identify='" + this.identify + "', version=" + this.version + ", oldBleAddress='" + this.oldBleAddress + "', isOTA=" + this.isOTA + ", deviceType=" + this.deviceType + ", deviceVersion=" + this.deviceVersion + ", battery=" + this.battery + '}';
    }
}
