package com.jieli.watchtesttool.tool.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Handler;
import android.os.Looper;
import com.jieli.bluetooth_connect.bean.ErrorInfo;
import com.jieli.bluetooth_connect.bean.ble.BleScanMessage;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class BtEventCbManager {
    private final ArrayList<BluetoothEventListener> mListeners = new ArrayList<>();
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes10.dex */
    public static abstract class BtEventCbImpl {
        private BtEventCbImpl() {
        }

        public abstract void onCallback(BluetoothEventListener bluetoothEventListener);
    }

    /* loaded from: classes10.dex */
    public class BtEventCbRunnable implements Runnable {
        private final BtEventCbImpl mBtEventCb;

        @Override // java.lang.Runnable
        public void run() {
            if (this.mBtEventCb != null && !BtEventCbManager.this.mListeners.isEmpty()) {
                Iterator it = new ArrayList(BtEventCbManager.this.mListeners).iterator();
                while (it.hasNext()) {
                    BluetoothEventListener bluetoothEventListener = (BluetoothEventListener) it.next();
                    if (bluetoothEventListener != null) {
                        this.mBtEventCb.onCallback(bluetoothEventListener);
                    }
                }
            }
        }

        private BtEventCbRunnable(BtEventCbImpl btEventCbImpl) {
            this.mBtEventCb = btEventCbImpl;
        }
    }

    private void callbackEvent(BtEventCbImpl btEventCbImpl) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.mHandler.post(new BtEventCbRunnable(btEventCbImpl));
        } else {
            new BtEventCbRunnable(btEventCbImpl).run();
        }
    }

    public void addBluetoothEventListener(BluetoothEventListener bluetoothEventListener) {
        if (bluetoothEventListener != null && !this.mListeners.contains(bluetoothEventListener)) {
            this.mListeners.add(bluetoothEventListener);
        }
    }

    public void destroy() {
        this.mListeners.clear();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void onAdapterStatus(final boolean z) {
        callbackEvent(new BtEventCbImpl() { // from class: com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.BtEventCbImpl
            public void onCallback(BluetoothEventListener bluetoothEventListener) {
                bluetoothEventListener.onAdapterStatus(z);
            }
        });
    }

    public void onBleMtuChange(final BluetoothGatt bluetoothGatt, final int i, final int i2) {
        callbackEvent(new BtEventCbImpl() { // from class: com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.BtEventCbImpl
            public void onCallback(BluetoothEventListener bluetoothEventListener) {
                bluetoothEventListener.onBleMtuChange(bluetoothGatt, i, i2);
            }
        });
    }

    public void onBtDiscovery(final BluetoothDevice bluetoothDevice, final BleScanMessage bleScanMessage) {
        callbackEvent(new BtEventCbImpl() { // from class: com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.BtEventCbImpl
            public void onCallback(BluetoothEventListener bluetoothEventListener) {
                bluetoothEventListener.onBtDiscovery(bluetoothDevice, bleScanMessage);
            }
        });
    }

    public void onBtDiscoveryStatus(final boolean z, final boolean z2) {
        callbackEvent(new BtEventCbImpl() { // from class: com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.BtEventCbImpl
            public void onCallback(BluetoothEventListener bluetoothEventListener) {
                bluetoothEventListener.onBtDiscoveryStatus(z, z2);
            }
        });
    }

    public void onConnection(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BtEventCbImpl() { // from class: com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.BtEventCbImpl
            public void onCallback(BluetoothEventListener bluetoothEventListener) {
                bluetoothEventListener.onConnection(bluetoothDevice, i);
            }
        });
    }

    public void onError(final ErrorInfo errorInfo) {
        callbackEvent(new BtEventCbImpl() { // from class: com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.BtEventCbImpl
            public void onCallback(BluetoothEventListener bluetoothEventListener) {
                bluetoothEventListener.onError(errorInfo);
            }
        });
    }

    public void onReceiveData(final BluetoothDevice bluetoothDevice, final byte[] bArr) {
        callbackEvent(new BtEventCbImpl() { // from class: com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.BtEventCbImpl
            public void onCallback(BluetoothEventListener bluetoothEventListener) {
                bluetoothEventListener.onReceiveData(bluetoothDevice, bArr);
            }
        });
    }

    public void onShowDialog(final BluetoothDevice bluetoothDevice, final BleScanMessage bleScanMessage) {
        callbackEvent(new BtEventCbImpl() { // from class: com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.BtEventCbImpl
            public void onCallback(BluetoothEventListener bluetoothEventListener) {
                bluetoothEventListener.onShowDialog(bluetoothDevice, bleScanMessage);
            }
        });
    }

    public void onSwitchConnectedDevice(final BluetoothDevice bluetoothDevice) {
        callbackEvent(new BtEventCbImpl() { // from class: com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.jieli.watchtesttool.tool.bluetooth.BtEventCbManager.BtEventCbImpl
            public void onCallback(BluetoothEventListener bluetoothEventListener) {
                bluetoothEventListener.onSwitchConnectedDevice(bluetoothDevice);
            }
        });
    }

    public void removeBluetoothEventListener(BluetoothEventListener bluetoothEventListener) {
        if (bluetoothEventListener != null) {
            this.mListeners.remove(bluetoothEventListener);
        }
    }
}
