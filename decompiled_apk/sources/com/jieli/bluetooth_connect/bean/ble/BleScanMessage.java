package com.jieli.bluetooth_connect.bean.ble;

import com.jieli.bluetooth_connect.util.CHexConverter;
import java.io.Serializable;

/* loaded from: classes10.dex */
public class BleScanMessage implements Serializable {
    private int action;
    private int chargingBinMode;
    private int chargingBinQuantity;
    private int chargingBinStatus;
    private int connectWay;
    private String edrAddr;
    private int edrStatus;
    private String flagContent;
    private byte[] hash;
    private boolean isDeviceCharging;
    private boolean isLeftCharging;
    private boolean isOTA;
    private boolean isRightCharging;
    private boolean isSupportChargingCase;
    private int leftDeviceQuantity;
    private int mainDevFlag;
    private byte[] otaADVReserve;
    private int otaADVVersion;
    private String otaBleAddress;
    private int pairedFlag;
    private byte[] phoneVirtualAddress;
    private int pid;
    private byte[] rawData;
    private int rightDeviceQuantity;
    private int rssi;
    private int seq;
    private boolean showDialog;
    private int twsFlag;
    private int uid;
    private int version;
    private int vid;
    private int deviceType = -1;
    private boolean isEnableConnect = true;

    private int formatQuantity(int quantity) {
        if (quantity < 0) {
            quantity = 0;
        }
        if (quantity > 100) {
            return 100;
        }
        return quantity;
    }

    public boolean baseEquals(BleScanMessage other) {
        if (other == null || other.getEdrAddr() == null || !other.getEdrAddr().equals(this.edrAddr) || other.getVid() != this.vid || other.getUid() != this.uid || other.getPid() != this.pid) {
            return false;
        }
        return true;
    }

    public int getAction() {
        return this.action;
    }

    public int getChargingBinMode() {
        return this.chargingBinMode;
    }

    public int getChargingBinQuantity() {
        return this.chargingBinQuantity;
    }

    public int getChargingBinStatus() {
        return this.chargingBinStatus;
    }

    public int getConnectWay() {
        return this.connectWay;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getEdrAddr() {
        return this.edrAddr;
    }

    public int getEdrStatus() {
        return this.edrStatus;
    }

    public String getFlagContent() {
        return this.flagContent;
    }

    public byte[] getHash() {
        return this.hash;
    }

    public int getLeftDeviceQuantity() {
        return this.leftDeviceQuantity;
    }

    public int getMainDevFlag() {
        return this.mainDevFlag;
    }

    public byte[] getOtaADVReserve() {
        return this.otaADVReserve;
    }

    public int getOtaADVVersion() {
        return this.otaADVVersion;
    }

    public String getOtaBleAddress() {
        return this.otaBleAddress;
    }

    public int getPairedFlag() {
        return this.pairedFlag;
    }

    public byte[] getPhoneVirtualAddress() {
        return this.phoneVirtualAddress;
    }

    public int getPid() {
        return this.pid;
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    public int getRightDeviceQuantity() {
        return this.rightDeviceQuantity;
    }

    public int getRssi() {
        return this.rssi;
    }

    public int getSeq() {
        return this.seq;
    }

    public int getTwsFlag() {
        return this.twsFlag;
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

    public boolean isDeviceCharging() {
        return this.isDeviceCharging;
    }

    public boolean isEnableConnect() {
        return this.isEnableConnect;
    }

    public boolean isLeftCharging() {
        return this.isLeftCharging;
    }

    public boolean isOTA() {
        return this.isOTA;
    }

    public boolean isRightCharging() {
        return this.isRightCharging;
    }

    public boolean isShowDialog() {
        return this.showDialog;
    }

    public boolean isSupportChargingCase() {
        return this.isSupportChargingCase;
    }

    public BleScanMessage setAction(int action) {
        this.action = action;
        return this;
    }

    public BleScanMessage setChargingBinMode(int chargingBinMode) {
        this.chargingBinMode = chargingBinMode;
        return this;
    }

    public BleScanMessage setChargingBinQuantity(int chargingBinQuantity) {
        this.chargingBinQuantity = formatQuantity(chargingBinQuantity);
        return this;
    }

    public BleScanMessage setChargingBinStatus(int chargingBinStatus) {
        this.chargingBinStatus = chargingBinStatus;
        return this;
    }

    public BleScanMessage setConnectWay(int connectWay) {
        this.connectWay = connectWay;
        return this;
    }

    public BleScanMessage setDeviceCharging(boolean deviceCharging) {
        this.isDeviceCharging = deviceCharging;
        return this;
    }

    public BleScanMessage setDeviceType(int deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public BleScanMessage setEdrAddr(String edrAddr) {
        this.edrAddr = edrAddr;
        return this;
    }

    public BleScanMessage setEdrStatus(int edrStatus) {
        this.edrStatus = edrStatus;
        return this;
    }

    public BleScanMessage setEnableConnect(boolean enableConnect) {
        this.isEnableConnect = enableConnect;
        return this;
    }

    public BleScanMessage setFlagContent(String flagContent) {
        this.flagContent = flagContent;
        return this;
    }

    public BleScanMessage setHash(byte[] hash) {
        this.hash = hash;
        return this;
    }

    public BleScanMessage setLeftCharging(boolean charging) {
        this.isLeftCharging = charging;
        return this;
    }

    public BleScanMessage setLeftDeviceQuantity(int quantity) {
        this.leftDeviceQuantity = formatQuantity(quantity);
        return this;
    }

    public BleScanMessage setMainDevFlag(int mainDevFlag) {
        this.mainDevFlag = mainDevFlag;
        return this;
    }

    public BleScanMessage setOTA(boolean OTA) {
        this.isOTA = OTA;
        return this;
    }

    public BleScanMessage setOtaADVReserve(byte[] otaADVReserve) {
        this.otaADVReserve = otaADVReserve;
        return this;
    }

    public BleScanMessage setOtaADVVersion(int otaADVVersion) {
        this.otaADVVersion = otaADVVersion;
        return this;
    }

    public BleScanMessage setOtaBleAddress(String otaBleAddress) {
        this.otaBleAddress = otaBleAddress;
        return this;
    }

    public BleScanMessage setPairedFlag(int pairedFlag) {
        this.pairedFlag = pairedFlag;
        return this;
    }

    public BleScanMessage setPhoneVirtualAddress(byte[] phoneVirtualAddress) {
        this.phoneVirtualAddress = phoneVirtualAddress;
        return this;
    }

    public BleScanMessage setPid(int pid) {
        this.pid = pid;
        return this;
    }

    public BleScanMessage setRawData(byte[] rawData) {
        this.rawData = rawData;
        return this;
    }

    public BleScanMessage setRightCharging(boolean rightCharging) {
        this.isRightCharging = rightCharging;
        return this;
    }

    public BleScanMessage setRightDeviceQuantity(int rightDeviceQuantity) {
        this.rightDeviceQuantity = formatQuantity(rightDeviceQuantity);
        return this;
    }

    public BleScanMessage setRssi(int rssi) {
        this.rssi = rssi;
        return this;
    }

    public BleScanMessage setSeq(int seq) {
        this.seq = seq;
        return this;
    }

    public BleScanMessage setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
        return this;
    }

    public BleScanMessage setSupportChargingCase(boolean supportChargingCase) {
        this.isSupportChargingCase = supportChargingCase;
        return this;
    }

    public BleScanMessage setTwsFlag(int twsFlag) {
        this.twsFlag = twsFlag;
        return this;
    }

    public BleScanMessage setUid(int uid) {
        this.uid = uid;
        return this;
    }

    public BleScanMessage setVersion(int version) {
        this.version = version;
        return this;
    }

    public BleScanMessage setVid(int vid) {
        this.vid = vid;
        return this;
    }

    public String toString() {
        return "BleScanMessage{flagContent='" + this.flagContent + "', pairedFlag=" + this.pairedFlag + ", pid=" + this.pid + ", vid=" + this.vid + ", uid=" + this.uid + ", deviceType=" + this.deviceType + ", version=" + this.version + ", showDialog=" + this.showDialog + ", edrAddr='" + this.edrAddr + "', edrStatus=" + this.edrStatus + ", leftDeviceQuantity=" + this.leftDeviceQuantity + ", isLeftCharging=" + this.isLeftCharging + ", rightDeviceQuantity=" + this.rightDeviceQuantity + ", isRightCharging=" + this.isRightCharging + ", chargingBinQuantity=" + this.chargingBinQuantity + ", isDeviceCharging=" + this.isDeviceCharging + ", twsFlag=" + this.twsFlag + ", chargingBinStatus=" + this.chargingBinStatus + ", mainDevFlag=" + this.mainDevFlag + ", action=" + this.action + ", seq=" + this.seq + ", chargingBinMode=" + this.chargingBinMode + ", isSupportChargingCase=" + this.isSupportChargingCase + ", rssi=" + this.rssi + ", isEnableConnect=" + this.isEnableConnect + ", connectWay=" + this.connectWay + ", isOTA=" + this.isOTA + ", otaADVVersion=" + this.otaADVVersion + ", otaBleAddress='" + this.otaBleAddress + "', otaADVReserve=" + CHexConverter.byte2HexStr(this.otaADVReserve) + '}';
    }
}
