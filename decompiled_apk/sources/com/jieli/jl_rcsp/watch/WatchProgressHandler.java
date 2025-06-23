package com.jieli.jl_rcsp.watch;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspEventListener;
import com.jieli.jl_rcsp.interfaces.watch.IWatchManager;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.external_flash.ExternalFlashIOCtrlCmd;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.response.ExternalFlashIOCtrlResponse;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.jieli.jl_rcsp.watch.WatchProgressHandler;
import com.jieli.jl_rcsp.watch.fatfs.FatFsWatch;
import com.jieli.jl_rcsp.watch.rcsp.RcspWatch;

/* loaded from: classes10.dex */
public class WatchProgressHandler implements OnFatFileProgressListener {
    public static final int OP_CREATE_FILE = 1;
    public static final int OP_DELETE_FILE = 2;
    public static final int OP_REPLACE_FILE = 3;
    public static final int OP_RESTORE_SYS = 4;
    public static final String i = "WatchProgressHandler";

    /* renamed from: a, reason: collision with root package name */
    public final RcspOpImpl f18243a;
    public final IWatchManager b;
    public final int c;
    public final OnFatFileProgressListener d;
    public final Handler e = new Handler(Looper.getMainLooper());
    public int f = -1;
    public final CustomRcspActionCallback<Boolean, ExternalFlashIOCtrlCmd> g = new CustomRcspActionCallback<>("handleStopEvent", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.WatchProgressHandler.3
        @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
        public void onFailed(BaseError baseError) {
            WatchProgressHandler.this.a(baseError.getSubCode());
        }

        @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
        public void onSuccess(Boolean bool) {
            if (!(WatchProgressHandler.this.b instanceof RcspWatch) || WatchProgressHandler.this.c != 1) {
                WatchProgressHandler.this.b.jumpToUpdateResource(true, WatchProgressHandler.this.h);
            } else {
                WatchProgressHandler watchProgressHandler = WatchProgressHandler.this;
                watchProgressHandler.a(watchProgressHandler.f);
            }
        }
    }, new IHandleResult<Boolean, ExternalFlashIOCtrlCmd>() { // from class: com.jieli.jl_rcsp.watch.WatchProgressHandler.4
        @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
        public Boolean handleResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
            return Boolean.TRUE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
        public int hasResult(BluetoothDevice bluetoothDevice, ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd) {
            ExternalFlashIOCtrlResponse externalFlashIOCtrlResponse;
            if (externalFlashIOCtrlCmd == null || (externalFlashIOCtrlResponse = (ExternalFlashIOCtrlResponse) externalFlashIOCtrlCmd.getResponse()) == null) {
                return -1;
            }
            return externalFlashIOCtrlResponse.getResult();
        }
    });
    public final OnWatchOpCallback<Boolean> h = new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.watch.WatchProgressHandler.5
        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
        public void onFailed(BaseError baseError) {
            WatchProgressHandler.this.a(baseError.getSubCode());
        }

        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
        public void onSuccess(Boolean bool) {
            WatchProgressHandler watchProgressHandler = WatchProgressHandler.this;
            watchProgressHandler.a(watchProgressHandler.f);
        }
    };

    /* renamed from: com.jieli.jl_rcsp.watch.WatchProgressHandler$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass2 implements OnOperationCallback<ExternalFlashMsgResponse> {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i) {
            WatchProgressHandler watchProgressHandler = WatchProgressHandler.this;
            watchProgressHandler.a(watchProgressHandler.f);
            WatchProgressHandler.this.b.getCallback().onWatchSystemException(WatchProgressHandler.this.f18243a.getTargetDevice(), i);
        }

        @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
        public void onFailed(BaseError baseError) {
            JL_Log.w(WatchProgressHandler.i, "handleWatchSysException", "onFailed = " + baseError);
            WatchProgressHandler watchProgressHandler = WatchProgressHandler.this;
            watchProgressHandler.a(watchProgressHandler.f);
        }

        @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
        public void onSuccess(ExternalFlashMsgResponse externalFlashMsgResponse) {
            final int sysStatus = externalFlashMsgResponse.getSysStatus();
            JL_Log.w(WatchProgressHandler.i, "handleWatchSysException", "SysStatus = " + sysStatus);
            if (sysStatus == 0) {
                WatchProgressHandler.this.b();
                return;
            }
            if (WatchProgressHandler.this.b instanceof FatFsWatch) {
                ((FatFsWatch) WatchProgressHandler.this.b).destroyFatFileSystem();
            }
            WatchProgressHandler.this.e.postDelayed(new Runnable() { // from class: com.jieli.jl_rcsp.watch.oIX0oI
                @Override // java.lang.Runnable
                public final void run() {
                    WatchProgressHandler.AnonymousClass2.this.a(sysStatus);
                }
            }, 1000L);
        }
    }

    public WatchProgressHandler(IWatchManager iWatchManager, int i2, OnFatFileProgressListener onFatFileProgressListener) {
        this.b = iWatchManager;
        this.f18243a = (RcspOpImpl) iWatchManager.getRcspOp();
        this.c = i2;
        this.d = onFatFileProgressListener;
    }

    @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
    public void onProgress(float f) {
        OnFatFileProgressListener onFatFileProgressListener = this.d;
        if (onFatFileProgressListener != null) {
            onFatFileProgressListener.onProgress(f);
        }
    }

    @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
    public void onStart(String str) {
        OnFatFileProgressListener onFatFileProgressListener = this.d;
        if (onFatFileProgressListener != null) {
            onFatFileProgressListener.onStart(str);
        }
    }

    @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
    public void onStop(int i2) {
        this.f = i2;
        if (i2 != 0 && this.b.isSysException()) {
            a(i2, this.b.isSysException());
        } else if (this.b instanceof RcspWatch) {
            a(this.f);
        } else {
            b();
        }
    }

    public final void b() {
        int i2 = this.c;
        if (i2 == 1) {
            RcspOpImpl rcspOpImpl = this.f18243a;
            rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), CommandBuilder.buildExternalFlashInsertNewFileEndCmd(), this.g);
        } else if (i2 != 2) {
            this.b.jumpToUpdateResource(true, this.h);
        } else {
            RcspOpImpl rcspOpImpl2 = this.f18243a;
            rcspOpImpl2.sendRcspCommand(rcspOpImpl2.getTargetDevice(), CommandBuilder.buildExternalFlashDeleteFileEndCmd(), this.g);
        }
    }

    public final void c() {
        JL_Log.d(i, "handleWatchSysException", "query system status by device.");
        WatchBase.queryExtFlashMsgForDevice(this.f18243a, new AnonymousClass2());
    }

    public final void a(int i2) {
        int fatfsToWatchErr = WatchError.fatfsToWatchErr(i2);
        JL_Log.w(i, "callbackOpStop", RcspUtil.formatString("result : %d(0x%X), code = %d(0x%X)", Integer.valueOf(i2), Integer.valueOf(i2), Integer.valueOf(fatfsToWatchErr), Integer.valueOf(fatfsToWatchErr)));
        OnFatFileProgressListener onFatFileProgressListener = this.d;
        if (onFatFileProgressListener != null) {
            onFatFileProgressListener.onStop(fatfsToWatchErr);
        }
    }

    public final void a(int i2, boolean z) {
        String str = i;
        JL_Log.i(str, "handleStopEventBySysException", "result = " + i2 + ", isSysException : " + z);
        DeviceInfo deviceInfo = this.f18243a.getDeviceInfo();
        if (this.c != 4 && z && deviceInfo != null) {
            JL_Log.d(str, "handleStopEventBySysException", "Obtain the current phone Status : " + deviceInfo.getPhoneStatus());
            if (deviceInfo.getPhoneStatus() == 1) {
                JL_Log.d(str, "handleStopEventBySysException", "add OnRcspEventListener, waiting for phone status.");
                this.f18243a.registerOnRcspEventListener(new OnRcspEventListener() { // from class: com.jieli.jl_rcsp.watch.WatchProgressHandler.1
                    @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspEventListener
                    public void onPhoneCallStatusChange(BluetoothDevice bluetoothDevice, int i3) {
                        JL_Log.i(WatchProgressHandler.i, "handleStopEventBySysException", "onPhoneCallStatusChange : " + i3);
                        if (i3 == 0) {
                            WatchProgressHandler.this.f18243a.unregisterOnRcspEventListener(this);
                            WatchProgressHandler.this.c();
                        }
                    }
                });
                return;
            } else {
                c();
                return;
            }
        }
        a(i2);
    }
}
