package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.device.BatteryInfo;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkInfo;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class WatchCallbackManager extends OnWatchCallback {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<OnWatchCallback> f18054a = new ArrayList<>();
    public final Handler b = new Handler(Looper.getMainLooper());

    /* loaded from: classes10.dex */
    public class OnWatchRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final WatchCallbackImpl f18055a;

        public OnWatchRunnable(WatchCallbackImpl watchCallbackImpl) {
            this.f18055a = watchCallbackImpl;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!WatchCallbackManager.this.f18054a.isEmpty() && this.f18055a != null) {
                Iterator it = new ArrayList(WatchCallbackManager.this.f18054a).iterator();
                while (it.hasNext()) {
                    this.f18055a.onCallback((OnWatchCallback) it.next());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface WatchCallbackImpl {
        void onCallback(OnWatchCallback onWatchCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
    public void onBigDataError(final BluetoothDevice bluetoothDevice, final BaseError baseError) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.O0xOxO
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onBigDataError(bluetoothDevice, baseError);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
    public void onConnectStateChange(final BluetoothDevice bluetoothDevice, final int i) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.XIxXXX0x0
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onConnectStateChange(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
    public void onCurrentWatchInfo(final BluetoothDevice bluetoothDevice, final String str) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.x0xO0oo
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onCurrentWatchInfo(bluetoothDevice, str);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
    public void onDevicePower(final BluetoothDevice bluetoothDevice, final BatteryInfo batteryInfo) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.x0XOIxOo
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onDevicePower(bluetoothDevice, batteryInfo);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
    public void onExternalFlashMsg(final BluetoothDevice bluetoothDevice, final ExternalFlashMsgResponse externalFlashMsgResponse) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.xoXoI
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onExternalFlashMsg(bluetoothDevice, externalFlashMsgResponse);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
    public void onExternalFlashWriteFlag(final BluetoothDevice bluetoothDevice, final boolean z) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.XI0IXoo
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onExternalFlashWriteFlag(bluetoothDevice, z);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
    public void onMandatoryUpgrade(final BluetoothDevice bluetoothDevice) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.o00
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onMandatoryUpgrade(bluetoothDevice);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
    public void onNetworkModuleException(final BluetoothDevice bluetoothDevice, final NetworkInfo networkInfo) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.oO
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onNetworkModuleException(bluetoothDevice, networkInfo);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
    public void onRcspCommand(final BluetoothDevice bluetoothDevice, final CommandBase commandBase) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.IIXOooo
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onRcspCommand(bluetoothDevice, commandBase);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
    public void onRcspDataCmd(final BluetoothDevice bluetoothDevice, final CommandBase commandBase) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.oI0IIXIo
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onRcspDataCmd(bluetoothDevice, commandBase);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
    public void onRcspError(final BluetoothDevice bluetoothDevice, final BaseError baseError) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.OxI
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onRcspError(bluetoothDevice, baseError);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
    public void onRcspInit(final BluetoothDevice bluetoothDevice, final boolean z) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.xxX
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onRcspInit(bluetoothDevice, z);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
    public void onReceiveBigData(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.Oxx0xo
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onReceiveBigData(bluetoothDevice, i, bArr);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
    public void onResourceUpdateUnfinished(final BluetoothDevice bluetoothDevice) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.OxxIIOOXO
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onResourceUpdateUnfinished(bluetoothDevice);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
    public void onWatchSystemException(final BluetoothDevice bluetoothDevice, final int i) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.X0IIOO
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onWatchSystemException(bluetoothDevice, i);
            }
        });
    }

    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
    public void onWatchSystemInit(final int i) {
        a(new WatchCallbackImpl() { // from class: com.jieli.jl_rcsp.tool.IXxxXO
            @Override // com.jieli.jl_rcsp.tool.WatchCallbackManager.WatchCallbackImpl
            public final void onCallback(OnWatchCallback onWatchCallback) {
                onWatchCallback.onWatchSystemInit(i);
            }
        });
    }

    public void registerWatchCallback(OnWatchCallback onWatchCallback) {
        if (onWatchCallback != null && !this.f18054a.contains(onWatchCallback)) {
            this.f18054a.add(onWatchCallback);
        }
    }

    public void release() {
        this.f18054a.clear();
        this.b.removeCallbacksAndMessages(null);
    }

    public void unregisterWatchCallback(OnWatchCallback onWatchCallback) {
        if (onWatchCallback != null) {
            this.f18054a.remove(onWatchCallback);
        }
    }

    public final void a(WatchCallbackImpl watchCallbackImpl) {
        if (watchCallbackImpl == null) {
            return;
        }
        OnWatchRunnable onWatchRunnable = new OnWatchRunnable(watchCallbackImpl);
        if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
            this.b.post(onWatchRunnable);
        } else {
            onWatchRunnable.run();
        }
    }
}
