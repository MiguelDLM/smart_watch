package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtBleListener;
import com.jieli.bluetooth_connect.tool.BaseCbManager;
import java.util.UUID;

/* loaded from: classes10.dex */
public class BleEventCbManager extends BaseCbManager<OnBtBleListener> {
    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean addListener(OnBtBleListener listener) {
        return super.addListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void callbackEvent(BaseCbManager.CallbackImpl<OnBtBleListener> impl) {
        super.callbackEvent(impl);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    public void onBleBond(final BluetoothDevice device, final int bondStatus) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.xoXoI
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleBond(device, bondStatus);
            }
        });
    }

    public void onBleConnection(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.xxIXOIIO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleConnection(device, status);
            }
        });
    }

    public void onBleDataNotify(final BluetoothDevice device, final UUID serviceUuid, final UUID characteristicsUuid, final byte[] data) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.II0XooXoX
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleDataNotify(device, serviceUuid, characteristicsUuid, data);
            }
        });
    }

    public void onBleMtuChanged(final BluetoothDevice device, final int block, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.oO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleMtuChanged(device, block, status);
            }
        });
    }

    public void onBleNotificationStatus(final BluetoothDevice device, final UUID serviceUuid, final UUID characteristicUuid, final boolean bEnabled) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.OxI
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleNotificationStatus(device, serviceUuid, characteristicUuid, bEnabled);
            }
        });
    }

    public void onBleWriteStatus(final BluetoothDevice device, final UUID serviceUuid, final UUID characteristicsUuid, final byte[] data, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.Oxx0IOOO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onBleWriteStatus(device, serviceUuid, characteristicsUuid, data, status);
            }
        });
    }

    public void onCharacteristicChanged(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.OOXIXo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onCharacteristicChanged(gatt, characteristic);
            }
        });
    }

    public void onCharacteristicRead(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.o00
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onCharacteristicRead(gatt, characteristic, status);
            }
        });
    }

    public void onCharacteristicWrite(final BluetoothGatt gatt, final BluetoothGattCharacteristic characteristic, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.IXxxXO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onCharacteristicWrite(gatt, characteristic, status);
            }
        });
    }

    public void onConnectionStateChange(final BluetoothGatt gatt, final int status, final int newState) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.x0xO0oo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onConnectionStateChange(gatt, status, newState);
            }
        });
    }

    public void onConnectionUpdatedCallback(final BluetoothGatt gatt, final int interval, final int latency, final int timeout, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.oxoX
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onConnectionUpdatedCallback(gatt, interval, latency, timeout, status);
            }
        });
    }

    public void onDescriptorRead(final BluetoothGatt gatt, final BluetoothGattDescriptor descriptor, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.ooOOo0oXI
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onDescriptorRead(gatt, descriptor, status);
            }
        });
    }

    public void onDescriptorWrite(final BluetoothGatt gatt, final BluetoothGattDescriptor descriptor, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.XO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onDescriptorWrite(gatt, descriptor, status);
            }
        });
    }

    public void onMtuChanged(final BluetoothGatt gatt, final int mtu, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.X0o0xo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onMtuChanged(gatt, mtu, status);
            }
        });
    }

    @RequiresApi(api = 26)
    public void onPhyRead(final BluetoothGatt gatt, final int txPhy, final int rxPhy, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.IIXOooo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                I0Io.oIX0oI((OnBtBleListener) obj, gatt, txPhy, rxPhy, status);
            }
        });
    }

    @RequiresApi(api = 26)
    public void onPhyUpdate(final BluetoothGatt gatt, final int txPhy, final int rxPhy, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.x0XOIxOo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onPhyUpdate(gatt, txPhy, rxPhy, status);
            }
        });
    }

    public void onReadRemoteRssi(final BluetoothGatt gatt, final int rssi, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.OxxIIOOXO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onReadRemoteRssi(gatt, rssi, status);
            }
        });
    }

    public void onReliableWriteCompleted(final BluetoothGatt gatt, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.xoIox
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onReliableWriteCompleted(gatt, status);
            }
        });
    }

    @RequiresApi(api = 31)
    public void onServiceChanged(@NonNull final BluetoothGatt gatt) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.oOoXoXO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                oIX0oI.oIX0oI((OnBtBleListener) obj, gatt);
            }
        });
    }

    public void onServicesDiscovered(final BluetoothGatt gatt, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.oI0IIXIo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onServicesDiscovered(gatt, status);
            }
        });
    }

    public void onSwitchBleDevice(final BluetoothDevice device) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.Oxx0xo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtBleListener) obj).onSwitchBleDevice(device);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean removeListener(OnBtBleListener listener) {
        return super.removeListener(listener);
    }
}
