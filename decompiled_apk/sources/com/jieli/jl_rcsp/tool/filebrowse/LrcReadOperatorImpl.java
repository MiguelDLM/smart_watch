package com.jieli.jl_rcsp.tool.filebrowse;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_filebrowse.interfaces.OperatCallback;
import com.jieli.jl_filebrowse.interfaces.lrc.LrcReadOperator;
import com.jieli.jl_rcsp.constant.RcspErrorCode;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.file_op.StartLrcGetCmd;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;

/* loaded from: classes10.dex */
public class LrcReadOperatorImpl implements LrcReadOperator {
    public static final String b = "LrcReadOperatorImpl";

    /* renamed from: a, reason: collision with root package name */
    public final RcspOpImpl f18194a;

    /* loaded from: classes10.dex */
    public static class CustomRcspCallback<C extends CommandBase> implements RcspCommandCallback<C> {

        /* renamed from: a, reason: collision with root package name */
        public final String f18195a;
        public final OperatCallback b;

        public CustomRcspCallback(String str, OperatCallback operatCallback) {
            this.f18195a = str;
            this.b = operatCallback;
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onCommandResponse(BluetoothDevice bluetoothDevice, C c) {
            if (c.getStatus() == 0) {
                OperatCallback operatCallback = this.b;
                if (operatCallback != null) {
                    operatCallback.onSuccess();
                    return;
                }
                return;
            }
            onErrCode(bluetoothDevice, RcspErrorCode.buildJsonError(c.getId(), 12292, c.getStatus(), null));
        }

        @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
        public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
            JL_Log.e(LrcReadOperatorImpl.b, this.f18195a, RcspUtil.formatString("device: %s, %s", bluetoothDevice, baseError));
            OperatCallback operatCallback = this.b;
            if (operatCallback != null) {
                operatCallback.onError(baseError.getSubCode());
            }
        }
    }

    public LrcReadOperatorImpl(RcspOpImpl rcspOpImpl) {
        this.f18194a = rcspOpImpl;
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.LrcReadOperator
    public void startLrcRead(OperatCallback operatCallback) {
        RcspOpImpl rcspOpImpl = this.f18194a;
        rcspOpImpl.sendRcspCommand(rcspOpImpl.getTargetDevice(), new StartLrcGetCmd(), new CustomRcspCallback("startLrcRead", operatCallback));
    }
}
