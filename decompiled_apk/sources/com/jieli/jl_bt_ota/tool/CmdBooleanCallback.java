package com.jieli.jl_bt_ota.tool;

import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* loaded from: classes10.dex */
public class CmdBooleanCallback extends CmdResultCallback<Boolean> {
    public CmdBooleanCallback(String str, IActionCallback<Boolean> iActionCallback) {
        super(str, iActionCallback, new IHandleResult<Boolean>() { // from class: com.jieli.jl_bt_ota.tool.CmdBooleanCallback.1
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public int hasResult(CommandBase commandBase) {
                return 0;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.jieli.jl_bt_ota.interfaces.rcsp.IHandleResult
            public Boolean handleResult(CommandBase commandBase) {
                return Boolean.TRUE;
            }
        });
    }
}
