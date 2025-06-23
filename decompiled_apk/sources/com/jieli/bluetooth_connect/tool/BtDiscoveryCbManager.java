package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener;
import com.jieli.bluetooth_connect.tool.BaseCbManager;

/* loaded from: classes10.dex */
public class BtDiscoveryCbManager extends BaseCbManager<OnBtDiscoveryListener> implements OnBtDiscoveryListener {
    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean addListener(OnBtDiscoveryListener listener) {
        return super.addListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void callbackEvent(BaseCbManager.CallbackImpl<OnBtDiscoveryListener> impl) {
        super.callbackEvent(impl);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
    public void onDiscoveryDevice(final BluetoothDevice device, final BleScanMessage bleScanMessage) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.I0X0x0oIo
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDiscoveryListener) obj).onDiscoveryDevice(device, bleScanMessage);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
    public void onDiscoveryError(final ErrorInfo error) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.XX0
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDiscoveryListener) obj).onDiscoveryError(ErrorInfo.this);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
    public void onDiscoveryStatusChange(final boolean isBle, final boolean bStart) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.xXOx
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDiscoveryListener) obj).onDiscoveryStatusChange(isBle, bStart);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBtDiscoveryListener
    public void onShowProductDialog(final BluetoothDevice device, final BleScanMessage bleScanMessage) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.oX
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBtDiscoveryListener) obj).onShowProductDialog(device, bleScanMessage);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean removeListener(OnBtDiscoveryListener listener) {
        return super.removeListener(listener);
    }
}
