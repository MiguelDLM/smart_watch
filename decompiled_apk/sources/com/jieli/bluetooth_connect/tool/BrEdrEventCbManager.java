package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.os.ParcelUuid;
import com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener;
import com.jieli.bluetooth_connect.tool.BaseCbManager;

/* loaded from: classes10.dex */
public class BrEdrEventCbManager extends BaseCbManager<OnBrEdrListener> implements OnBrEdrListener {
    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean addListener(OnBrEdrListener listener) {
        return super.addListener(listener);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void callbackEvent(BaseCbManager.CallbackImpl<OnBrEdrListener> impl) {
        super.callbackEvent(impl);
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
    public void onA2dpStatus(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.oxXx0IX
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBrEdrListener) obj).onA2dpStatus(device, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
    public void onBrEdrConnection(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.XoX
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBrEdrListener) obj).onBrEdrConnection(device, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
    public void onDeviceUuids(final BluetoothDevice device, final ParcelUuid[] uuids) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.xo0x
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBrEdrListener) obj).onDeviceUuids(device, uuids);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
    public void onEdrService(final boolean isConnected, final int profile, final BluetoothProfile proxy) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.I0oOoX
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBrEdrListener) obj).onEdrService(isConnected, profile, proxy);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.interfaces.listener.OnBrEdrListener
    public void onHfpStatus(final BluetoothDevice device, final int status) {
        callbackEvent(new BaseCbManager.CallbackImpl() { // from class: com.jieli.bluetooth_connect.tool.oxxXoxO
            @Override // com.jieli.bluetooth_connect.tool.BaseCbManager.CallbackImpl
            public final void onCallback(Object obj) {
                ((OnBrEdrListener) obj).onHfpStatus(device, status);
            }
        });
    }

    @Override // com.jieli.bluetooth_connect.tool.BaseCbManager
    public /* bridge */ /* synthetic */ boolean removeListener(OnBrEdrListener listener) {
        return super.removeListener(listener);
    }
}
