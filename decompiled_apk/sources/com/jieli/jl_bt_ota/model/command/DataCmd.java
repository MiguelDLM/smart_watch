package com.jieli.jl_bt_ota.model.command;

import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.model.base.CommonResponse;
import com.jieli.jl_bt_ota.model.parameter.DataParam;

/* loaded from: classes10.dex */
public class DataCmd extends CommandBase<DataParam, CommonResponse> {
    public DataCmd(DataParam dataParam) {
        this(1, dataParam);
    }

    public DataCmd(int i, DataParam dataParam) {
        super(1, DataCmd.class.getSimpleName(), i);
        setParam(dataParam);
    }
}
