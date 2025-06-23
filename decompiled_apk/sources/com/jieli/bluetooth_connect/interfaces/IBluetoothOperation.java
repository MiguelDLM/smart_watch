package com.jieli.bluetooth_connect.interfaces;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.bluetooth_connect.interfaces.callback.BluetoothEventCallback;
import com.jieli.bluetooth_connect.interfaces.callback.OnHistoryRecordCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes10.dex */
public interface IBluetoothOperation extends IBluetoothPair {
    void clearHistoryRecords();

    boolean connectBLEDevice(BluetoothDevice device);

    boolean connectBtDevice(BluetoothDevice device, int connectWay);

    boolean connectBtDeviceWithoutRecord(BluetoothDevice device, int connectWay);

    boolean connectByProfiles(BluetoothDevice device);

    void connectHistoryRecord(HistoryRecord record, OnHistoryRecordCallback callback);

    boolean connectSPPDevice(BluetoothDevice device);

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    void destroy();

    boolean disconnectBLEDevice(BluetoothDevice device);

    void disconnectBtDevice(BluetoothDevice device);

    boolean disconnectByProfiles(BluetoothDevice device);

    boolean disconnectSPPDevice(BluetoothDevice device);

    void fastConnect();

    BluetoothDevice getActivityBluetoothDevice();

    int getBleMtu(BluetoothDevice device);

    BluetoothOption getBluetoothOption();

    BluetoothGatt getConnectedBluetoothGatt();

    BluetoothDevice getConnectedDevice();

    List<BluetoothDevice> getConnectedDeviceList();

    List<BluetoothDevice> getConnectedSppList();

    BluetoothDevice getConnectingBrEdrDevice();

    BluetoothDevice getConnectingDevice();

    BluetoothGatt getDeviceGatt(BluetoothDevice device);

    ArrayList<BluetoothDevice> getDiscoveredBluetoothDevices();

    HistoryRecord getHistoryRecord(String devAddress);

    List<HistoryRecord> getHistoryRecordList();

    String getMappedDeviceAddress(String deviceAddress);

    int getScanType();

    boolean isBrEdrConnecting();

    boolean isConnectedBLEDevice(BluetoothDevice device);

    int isConnectedByA2dp(BluetoothDevice device);

    int isConnectedByHfp(BluetoothDevice device);

    int isConnectedByProfile(BluetoothDevice device);

    boolean isConnectedDevice(BluetoothDevice device);

    boolean isConnectedSppDevice(BluetoothDevice device);

    boolean isConnecting();

    boolean isReconnectDevice();

    boolean isScanning();

    boolean registerBluetoothCallback(BluetoothEventCallback bluetoothCallback);

    void removeHistoryRecord(String address, OnHistoryRecordCallback callback);

    boolean requestBleMtu(BluetoothDevice device, int mtu);

    boolean sendDataToDevice(BluetoothDevice device, byte[] data);

    boolean setActivityBluetoothDevice(BluetoothDevice device);

    @Override // com.jieli.bluetooth_connect.interfaces.IBluetoothBase
    void setBluetoothOption(BluetoothOption bluetoothOption);

    void setConnectedDevice(BluetoothDevice device);

    boolean startBLEScan(long timeout);

    boolean startConnectByBreProfiles(BluetoothDevice breDevice);

    boolean startDeviceScan(int type, long timeout);

    boolean startDeviceScan(long timeout);

    boolean stopBLEScan();

    boolean stopDeviceScan();

    void stopReconnect();

    boolean unregisterBluetoothCallback(BluetoothEventCallback bluetoothCallback);

    boolean writeDataToBLEDevice(BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] writeData);

    boolean writeDataToSppDevice(BluetoothDevice device, byte[] data);
}
