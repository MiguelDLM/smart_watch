package com.jieli.bluetooth_connect.interfaces.callback;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattService;
import android.os.ParcelUuid;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import java.util.List;
import java.util.UUID;

/* loaded from: classes10.dex */
public interface IBluetoothEventCallback {
    void onA2dpStatus(BluetoothDevice device, int status);

    void onAdapterStatus(boolean bEnabled, boolean bHasBle);

    void onBleConnection(BluetoothDevice device, int status);

    void onBleDataBlockChanged(BluetoothDevice device, int block, int status);

    void onBleDataNotification(BluetoothDevice device, UUID serviceUuid, UUID characteristicsUuid, byte[] data);

    void onBleNotificationStatus(BluetoothDevice device, UUID serviceUuid, UUID characteristicUuid, boolean bEnabled);

    void onBleServiceDiscovery(BluetoothDevice device, int status, List<BluetoothGattService> services);

    void onBleWriteStatus(BluetoothDevice device, UUID serviceUuid, final UUID characteristicsUuid, byte[] data, int status);

    void onBondStatus(BluetoothDevice device, int status);

    void onBtDeviceConnectStatus(BluetoothDevice device, int status);

    void onConnection(BluetoothDevice device, int status);

    void onConnectionUpdated(BluetoothGatt gatt, int interval, int latency, int timeout, int status);

    void onDeviceUuidsDiscovery(BluetoothDevice device, ParcelUuid[] uuids);

    void onDiscovery(BluetoothDevice device, BleScanMessage bleScanMessage);

    void onDiscoveryStatus(boolean bBle, boolean bStart);

    void onError(ErrorInfo error);

    void onHfpStatus(BluetoothDevice device, int status);

    void onHistoryRecordChange(int op, HistoryRecord record);

    void onShowDialog(BluetoothDevice device, BleScanMessage bleScanMessage);

    void onSppDataNotification(BluetoothDevice device, UUID sppUUID, byte[] data);

    void onSppStatus(BluetoothDevice device, int status);

    void onSwitchConnectedDevice(BluetoothDevice device);
}
