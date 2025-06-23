package com.jieli.jl_bt_ota.interfaces;

import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.CommandBase;

/* loaded from: classes10.dex */
public interface CommandCallback {
    void onCommandResponse(CommandBase commandBase);

    void onErrCode(BaseError baseError);
}
