package com.jieli.jl_rcsp.task;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* loaded from: classes10.dex */
public abstract class TaskBase implements ITask {
    public static final int ERR_BUSY = 4352;
    public static final int ERR_COMMAND_RESPONSE = 12292;
    public static final int ERR_CRC_CHECK = 12544;
    public static final int ERR_DEVICE_IN_CALL = 12545;
    public static final int ERR_DEVICE_NOT_CONNECT = 8192;
    public static final int ERR_FUNC_NOT_SUPPORT = 4353;
    public static final int ERR_IO_EXCEPTION = 16389;
    public static final int ERR_MISSING_DATA = 16387;
    public static final int ERR_NO_TARGET_STORAGE = 16384;
    public static final int ERR_PARAM = 4097;
    public static final int ERR_RENAME = 16898;
    public static final int ERR_WAIT_DATA_TIMEOUT = 12290;
    protected static final int MSG_WAITING_FOR_DATA_TIMEOUT = 4386;
    protected static int TIMEOUT = 20000;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f17945a;
    protected TaskListener listener;
    protected final DeviceStatusManager mDeviceStatusManager;
    protected final RcspOpImpl mRcspOp;
    protected final String tag = getClass().getSimpleName();

    public TaskBase(RcspOpImpl rcspOpImpl) throws RuntimeException {
        if (rcspOpImpl != null) {
            this.mRcspOp = rcspOpImpl;
            this.mDeviceStatusManager = DeviceStatusManager.getInstance();
            return;
        }
        throw new RuntimeException("RcspOpImpl can not be null.");
    }

    public BaseError buildResponseBadResult(int i, int i2) {
        return RcspErrorCode.buildJsonError(i, 12293, i2, null);
    }

    public BaseError buildResponseBadState(int i, int i2) {
        return RcspErrorCode.buildJsonError(i, 12292, i2, null);
    }

    public void callbackBegin() {
        this.f17945a = true;
        TaskListener taskListener = this.listener;
        if (taskListener != null) {
            taskListener.onBegin();
        }
    }

    public void callbackCancel(int i) {
        if (!this.f17945a) {
            return;
        }
        this.f17945a = false;
        JL_Log.w(this.tag, "callbackCancel", "reason : " + i);
        TaskListener taskListener = this.listener;
        if (taskListener != null) {
            taskListener.onCancel(i);
        }
    }

    public void callbackError(int i) {
        callbackError(i, WatchError.getErrorDesc(i));
    }

    public void callbackFinish() {
        if (!this.f17945a) {
            return;
        }
        this.f17945a = false;
        JL_Log.d(this.tag, "callbackFinish", "Success");
        TaskListener taskListener = this.listener;
        if (taskListener != null) {
            taskListener.onFinish();
        }
    }

    public void callbackProgress(int i) {
        TaskListener taskListener;
        if (this.f17945a && (taskListener = this.listener) != null) {
            taskListener.onProgress(i);
        }
    }

    public BluetoothDevice getConnectedDevice() {
        return this.mRcspOp.getConnectedDevice();
    }

    public boolean isDeviceInCalling() {
        DeviceInfo deviceInfo = this.mRcspOp.getDeviceInfo();
        if (deviceInfo != null && deviceInfo.getPhoneStatus() == 1) {
            return true;
        }
        return false;
    }

    public boolean isFileTransfer() {
        return this.mDeviceStatusManager.isFileTransfer(getConnectedDevice());
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public boolean isRun() {
        return this.f17945a;
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void setListener(TaskListener taskListener) {
        this.listener = taskListener;
    }

    public void callbackError(int i, String str) {
        this.f17945a = false;
        JL_Log.e(this.tag, "callbackError", RcspUtil.formatString("code : %d(0x%X), %s", Integer.valueOf(i), Integer.valueOf(i), str));
        TaskListener taskListener = this.listener;
        if (taskListener != null) {
            taskListener.onError(i, str);
        }
    }
}
