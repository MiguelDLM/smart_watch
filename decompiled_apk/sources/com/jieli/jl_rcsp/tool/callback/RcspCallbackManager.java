package com.jieli.jl_rcsp.tool.callback;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.tool.callback.BaseCallbackManager;

/* loaded from: classes10.dex */
public class RcspCallbackManager extends BaseCallbackManager<OnRcspCallback> {
    public void onConnectStateChange(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.Oxx0IOOO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onConnectStateChange(bluetoothDevice, i);
            }
        });
    }

    public void onMandatoryUpgrade(final BluetoothDevice bluetoothDevice) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.II0xO0
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onMandatoryUpgrade(bluetoothDevice);
            }
        });
    }

    public void onPutDataToDataHandler(final BluetoothDevice bluetoothDevice, final byte[] bArr) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.XO
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onPutDataToDataHandler(bluetoothDevice, bArr);
            }
        });
    }

    public void onRcspCommand(final BluetoothDevice bluetoothDevice, final CommandBase commandBase) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.I0Io
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onRcspCommand(bluetoothDevice, commandBase);
            }
        });
    }

    public void onRcspDataCmd(final BluetoothDevice bluetoothDevice, final CommandBase commandBase) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.oxoX
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onRcspDataCmd(bluetoothDevice, commandBase);
            }
        });
    }

    public void onRcspError(final BluetoothDevice bluetoothDevice, final BaseError baseError) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.oIX0oI
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onRcspError(bluetoothDevice, baseError);
            }
        });
    }

    public void onRcspInit(final BluetoothDevice bluetoothDevice, final boolean z) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.X0o0xo
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onRcspInit(bluetoothDevice, z);
            }
        });
    }

    public void onSwitchConnectedDevice(final BluetoothDevice bluetoothDevice) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: com.jieli.jl_rcsp.tool.callback.II0XooXoX
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspCallback) obj).onSwitchConnectedDevice(bluetoothDevice);
            }
        });
    }
}
