package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.IBluetoothCallback;
import com.jieli.jl_bt_ota.model.BleScanMessage;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* loaded from: classes10.dex */
public class BtEventCallbackHelper extends BaseCallbackHelper<IBluetoothCallback> implements IBluetoothCallback {
    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onA2dpStatus(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.II0xO0
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onA2dpStatus(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onAdapterStatus(final boolean z, final boolean z2) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.X0o0xo
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onAdapterStatus(z, z2);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onBleDataBlockChanged(final BluetoothDevice bluetoothDevice, final int i, final int i2) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.I0Io
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onBleDataBlockChanged(bluetoothDevice, i, i2);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onBtDeviceConnection(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.xxIXOIIO
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onBtDeviceConnection(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onConnection(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.oxoX
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onConnection(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onDiscovery(final BluetoothDevice bluetoothDevice, final BleScanMessage bleScanMessage) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.oIX0oI
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onDiscovery(bluetoothDevice, bleScanMessage);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onDiscoveryStatus(final boolean z, final boolean z2) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.II0XooXoX
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onDiscoveryStatus(z, z2);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onError(final BaseError baseError) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.xoIox
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onError(BaseError.this);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onHfpStatus(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.OOXIXo
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onHfpStatus(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onMandatoryUpgrade(final BluetoothDevice bluetoothDevice) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.XO
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onMandatoryUpgrade(bluetoothDevice);
            }
        });
    }

    @Override // com.jieli.jl_bt_ota.interfaces.IBluetoothCallback
    public void onReceiveCommand(final BluetoothDevice bluetoothDevice, final CommandBase commandBase) {
        callbackEvent(new ICallbackHandler() { // from class: com.jieli.jl_bt_ota.tool.Oxx0IOOO
            @Override // com.jieli.jl_bt_ota.tool.ICallbackHandler
            public final void onHandle(Object obj) {
                ((IBluetoothCallback) obj).onReceiveCommand(bluetoothDevice, commandBase);
            }
        });
    }
}
