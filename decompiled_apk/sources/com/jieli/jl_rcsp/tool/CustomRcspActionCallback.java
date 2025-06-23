package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* loaded from: classes10.dex */
public class CustomRcspActionCallback<T, C extends CommandBase> implements RcspCommandCallback<C> {
    protected final String funcName;
    protected final OnOperationCallback<T> mCallback;
    protected final IHandleResult<T, C> mParser;

    public CustomRcspActionCallback(String str, OnOperationCallback<T> onOperationCallback, IHandleResult<T, C> iHandleResult) {
        this.funcName = str;
        this.mCallback = onOperationCallback;
        this.mParser = iHandleResult;
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
    public void onCommandResponse(BluetoothDevice bluetoothDevice, C c) {
        int hasResult;
        T t = null;
        if (c == null) {
            IHandleResult<T, C> iHandleResult = this.mParser;
            if (iHandleResult != null) {
                t = iHandleResult.handleResult(bluetoothDevice, null);
            }
            OnOperationCallback<T> onOperationCallback = this.mCallback;
            if (onOperationCallback != null) {
                onOperationCallback.onSuccess(t);
                return;
            }
            return;
        }
        IHandleResult<T, C> iHandleResult2 = this.mParser;
        if (iHandleResult2 == null) {
            hasResult = 0;
        } else {
            hasResult = iHandleResult2.hasResult(bluetoothDevice, c);
        }
        if (c.getStatus() == 0 && hasResult == 0) {
            IHandleResult<T, C> iHandleResult3 = this.mParser;
            if (iHandleResult3 != null) {
                t = iHandleResult3.handleResult(bluetoothDevice, c);
            }
            if (this.mParser != null && t == null) {
                BaseError baseError = new BaseError(12289, WatchError.getErrorDesc(12289));
                baseError.setOpCode(c.getId());
                onErrCode(bluetoothDevice, baseError);
                return;
            } else {
                OnOperationCallback<T> onOperationCallback2 = this.mCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onSuccess(t);
                    return;
                }
                return;
            }
        }
        if (c.getStatus() != 0) {
            onErrCode(bluetoothDevice, RcspErrorCode.buildJsonError(c.getId(), 12292, c.getStatus(), null));
        } else {
            onErrCode(bluetoothDevice, RcspErrorCode.buildJsonError(c.getId(), 12293, hasResult, null));
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
    public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
        JL_Log.e("RcspCommandCallback", this.funcName, RcspUtil.formatString("Device[%s] has an error: %s", bluetoothDevice, baseError));
        OnOperationCallback<T> onOperationCallback = this.mCallback;
        if (onOperationCallback != null) {
            onOperationCallback.onFailed(baseError);
        }
    }
}
