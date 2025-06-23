package com.jieli.bluetooth_connect.bean;

import androidx.annotation.NonNull;
import com.jieli.bluetooth_connect.constant.BluetoothConstant;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes10.dex */
public class BluetoothOption {
    private boolean reconnect;
    private String scanFilterData;

    @Deprecated
    private int priority = 0;

    @Deprecated
    private int timeoutMs = 2000;
    private boolean enterLowPowerMode = false;
    private boolean isUseMultiDevice = false;

    @Deprecated
    private boolean isUseDeviceAuth = true;
    private boolean isNotAssociatedEDR = false;
    private boolean isSkipNoneNameDevice = true;
    private boolean isSupportCTKD = true;
    private String otaScanFilterData = BluetoothConstant.OTA_FILTER_FLAG;
    private int bleScanStrategy = 1;
    private int bleScanMode = 1;
    private int mtu = 20;
    private final Map<String, UUID> bleUUIDMap = new HashMap();
    private boolean isUseBleBondWay = false;
    private boolean isAutoConnectBle = false;
    private boolean isNeedChangeBleMtu = false;
    private boolean isOnlyConnect = false;
    private UUID sppUUID = BluetoothConstant.UUID_SPP;
    private boolean isSupportA2DP = true;

    public BluetoothOption() {
        setBleUUID(BluetoothConstant.UUID_SERVICE, BluetoothConstant.UUID_WRITE, BluetoothConstant.UUID_NOTIFICATION);
    }

    public static BluetoothOption createDefaultOption() {
        return new BluetoothOption().setReconnect(true).setTimeoutMs(2000).setMtu(20).setScanFilterData("JLAISDK");
    }

    public UUID getBleNotificationUUID() {
        UUID uuid = this.bleUUIDMap.get(BluetoothConstant.KEY_BLE_NOTIFICATION_CHARACTERISTIC_UUID);
        if (uuid == null) {
            return BluetoothConstant.UUID_NOTIFICATION;
        }
        return uuid;
    }

    public int getBleScanMode() {
        return this.bleScanMode;
    }

    public int getBleScanStrategy() {
        return this.bleScanStrategy;
    }

    public UUID getBleServiceUUID() {
        UUID uuid = this.bleUUIDMap.get(BluetoothConstant.KEY_BLE_SERVICE_UUID);
        if (uuid == null) {
            return BluetoothConstant.UUID_SERVICE;
        }
        return uuid;
    }

    public UUID getBleWriteUUID() {
        UUID uuid = this.bleUUIDMap.get(BluetoothConstant.KEY_BLE_WRITE_CHARACTERISTIC_UUID);
        if (uuid == null) {
            return BluetoothConstant.UUID_WRITE;
        }
        return uuid;
    }

    public int getMtu() {
        return this.mtu;
    }

    public String getOtaScanFilterData() {
        return this.otaScanFilterData;
    }

    @Deprecated
    public int getPriority() {
        return this.priority;
    }

    public String getScanFilterData() {
        return this.scanFilterData;
    }

    public UUID getSppUUID() {
        return this.sppUUID;
    }

    @Deprecated
    public int getTimeoutMs() {
        return this.timeoutMs;
    }

    public boolean isAutoConnectBle() {
        return this.isAutoConnectBle;
    }

    public boolean isEnterLowPowerMode() {
        return this.enterLowPowerMode;
    }

    public boolean isNeedChangeBleMtu() {
        return this.isNeedChangeBleMtu;
    }

    public boolean isNotAssociatedEDR() {
        return this.isNotAssociatedEDR;
    }

    public boolean isOnlyConnect() {
        return this.isOnlyConnect;
    }

    public boolean isReconnect() {
        return this.reconnect;
    }

    public boolean isSkipNoneNameDevice() {
        return this.isSkipNoneNameDevice;
    }

    public boolean isSupportA2DP() {
        return this.isSupportA2DP;
    }

    public boolean isSupportCTKD() {
        return this.isSupportCTKD;
    }

    public boolean isUseBleBondWay() {
        return this.isUseBleBondWay;
    }

    @Deprecated
    public boolean isUseDeviceAuth() {
        return this.isUseDeviceAuth;
    }

    public boolean isUseMultiDevice() {
        return this.isUseMultiDevice;
    }

    public BluetoothOption setAutoConnectBle(boolean autoConnectBle) {
        this.isAutoConnectBle = autoConnectBle;
        return this;
    }

    public BluetoothOption setBleScanMode(int bleScanMode) {
        this.bleScanMode = bleScanMode;
        return this;
    }

    public BluetoothOption setBleScanStrategy(int bleScanStrategy) {
        this.bleScanStrategy = bleScanStrategy;
        return this;
    }

    public BluetoothOption setBleUUID(UUID serviceUUID, UUID writeCharacteristicUUID, UUID notificationCharacteristicUUID) {
        this.bleUUIDMap.put(BluetoothConstant.KEY_BLE_SERVICE_UUID, serviceUUID);
        this.bleUUIDMap.put(BluetoothConstant.KEY_BLE_WRITE_CHARACTERISTIC_UUID, writeCharacteristicUUID);
        this.bleUUIDMap.put(BluetoothConstant.KEY_BLE_NOTIFICATION_CHARACTERISTIC_UUID, notificationCharacteristicUUID);
        return this;
    }

    public BluetoothOption setEnterLowPowerMode(boolean enterLowPowerMode) {
        this.enterLowPowerMode = enterLowPowerMode;
        return this;
    }

    public BluetoothOption setMtu(int mtu) {
        this.mtu = BluetoothUtil.formatBleMtu(mtu);
        return this;
    }

    public BluetoothOption setNeedChangeBleMtu(boolean needChangeBleMtu) {
        this.isNeedChangeBleMtu = needChangeBleMtu;
        return this;
    }

    public BluetoothOption setNotAssociatedEDR(boolean notAssociatedEDR) {
        this.isNotAssociatedEDR = notAssociatedEDR;
        return this;
    }

    public BluetoothOption setOnlyConnect(boolean onlyConnect) {
        this.isOnlyConnect = onlyConnect;
        return this;
    }

    public BluetoothOption setOtaScanFilterData(String otaScanFilterData) {
        this.otaScanFilterData = otaScanFilterData;
        return this;
    }

    @Deprecated
    public BluetoothOption setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public BluetoothOption setReconnect(boolean reconnect) {
        this.reconnect = reconnect;
        return this;
    }

    public BluetoothOption setScanFilterData(String scanFilterData) {
        this.scanFilterData = scanFilterData;
        return this;
    }

    public BluetoothOption setSkipNoneNameDevice(boolean skipNoneNameDevice) {
        this.isSkipNoneNameDevice = skipNoneNameDevice;
        return this;
    }

    public BluetoothOption setSppUUID(UUID sppUUID) {
        this.sppUUID = sppUUID;
        return this;
    }

    public BluetoothOption setSupportA2DP(boolean supportA2DP) {
        this.isSupportA2DP = supportA2DP;
        return this;
    }

    public BluetoothOption setSupportCTKD(boolean supportCTKD) {
        this.isSupportCTKD = supportCTKD;
        return this;
    }

    @Deprecated
    public BluetoothOption setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
        return this;
    }

    public BluetoothOption setUseBleBondWay(boolean useBleBondWay) {
        this.isUseBleBondWay = useBleBondWay;
        return this;
    }

    @Deprecated
    public BluetoothOption setUseDeviceAuth(boolean useDeviceAuth) {
        this.isUseDeviceAuth = useDeviceAuth;
        return this;
    }

    public BluetoothOption setUseMultiDevice(boolean useMultiDevice) {
        this.isUseMultiDevice = useMultiDevice;
        return this;
    }

    @NonNull
    public String toString() {
        return "BluetoothOption{priority=" + this.priority + ", reconnect=" + this.reconnect + ", timeoutMs=" + this.timeoutMs + ", scanFilterData='" + this.scanFilterData + "', mtu=" + this.mtu + ", enterLowPowerMode=" + this.enterLowPowerMode + ", bleScanStrategy=" + this.bleScanStrategy + ", bleScanMode=" + this.bleScanMode + ", bleUUIDMap=" + this.bleUUIDMap + ", sppUUID=" + this.sppUUID + ", isUseBleBondWay=" + this.isUseBleBondWay + ", isAutoConnectBle=" + this.isAutoConnectBle + ", isUseDeviceAuth=" + this.isUseDeviceAuth + ", isNotAssociatedEDR=" + this.isNotAssociatedEDR + ", isOnlyConnect=" + this.isOnlyConnect + ", isSkipNoneNameDevice=" + this.isSkipNoneNameDevice + ", isSupportA2DP=" + this.isSupportA2DP + ", isSupportCTKD=" + this.isSupportCTKD + '}';
    }
}
