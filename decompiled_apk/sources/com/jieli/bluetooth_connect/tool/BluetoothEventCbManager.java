package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattService;
import android.os.ParcelUuid;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback;
import com.jieli.bluetooth_connect.tool.BaseCbManager;
import java.util.List;
import java.util.UUID;

/* loaded from: classes10.dex */
public class BluetoothEventCbManager extends BaseCbManager<IBluetoothEventCallback> implements IBluetoothEventCallback {
    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean addListener(IBluetoothEventCallback listener) {
        return super.addListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void callbackEvent(BaseCbManager.CallbackImpl<IBluetoothEventCallback> impl) {
        super.callbackEvent(impl);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onA2dpStatus(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.X00IoxXI
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onA2dpStatus(device, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onAdapterStatus(final boolean bEnabled, final boolean bHasBle) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.OI0
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onAdapterStatus(bEnabled, bHasBle);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleConnection(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.x0o
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleConnection(device, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleDataBlockChanged(final BluetoothDevice device, final int block, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.xII
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleDataBlockChanged(device, block, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleDataNotification(final BluetoothDevice device, final UUID serviceUuid, final UUID characteristicsUuid, final byte[] data) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.XIxXXX0x0
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleDataNotification(device, serviceUuid, characteristicsUuid, data);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleNotificationStatus(final BluetoothDevice device, final UUID serviceUuid, final UUID characteristicUuid, final boolean bEnabled) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.XX
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleNotificationStatus(device, serviceUuid, characteristicUuid, bEnabled);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleServiceDiscovery(final BluetoothDevice device, final int status, final List<BluetoothGattService> services) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.XOxIOxOx
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleServiceDiscovery(device, status, services);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBleWriteStatus(final BluetoothDevice device, final UUID serviceUuid, final UUID characteristicsUuid, final byte[] data, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.IoOoX
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBleWriteStatus(device, serviceUuid, characteristicsUuid, data, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBondStatus(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.oo0xXOI0I
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBondStatus(device, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onBtDeviceConnectStatus(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.oOXoIIIo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onBtDeviceConnectStatus(device, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onConnection(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.XI0IXoo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onConnection(device, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onConnectionUpdated(final BluetoothGatt gatt, final int interval, final int latency, final int timeout, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.X0IIOO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onConnectionUpdated(gatt, interval, latency, timeout, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onDeviceUuidsDiscovery(final BluetoothDevice device, final ParcelUuid[] uuids) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.Xx000oIo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onDeviceUuidsDiscovery(device, uuids);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onDiscovery(final BluetoothDevice device, final BleScanMessage bleScanMessage) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.XxX0x0xxx
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onDiscovery(device, bleScanMessage);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onDiscoveryStatus(final boolean bBle, final boolean bStart) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.xxX
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onDiscoveryStatus(bBle, bStart);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onError(final ErrorInfo error) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.IO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onError(ErrorInfo.this);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onHfpStatus(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.ooXIXxIX
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onHfpStatus(device, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onHistoryRecordChange(final int op, final HistoryRecord record) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.IIX0o
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onHistoryRecordChange(op, record);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onShowDialog(final BluetoothDevice device, final BleScanMessage bleScanMessage) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.xI
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onShowDialog(device, bleScanMessage);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onSppDataNotification(final BluetoothDevice device, final UUID sppUUID, final byte[] data) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.O0xOxO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onSppDataNotification(device, sppUUID, data);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onSppStatus(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.o0
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onSppStatus(device, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.callback.IBluetoothEventCallback
    public void onSwitchConnectedDevice(final BluetoothDevice device) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.xXxxox0I
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((IBluetoothEventCallback) obj).onSwitchConnectedDevice(device);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean removeListener(IBluetoothEventCallback listener) {
        return super.removeListener(listener);
    }
}
