package com.jieli.jl_rcsp.model.command.data;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.DataParam;

/* loaded from: classes10.dex */
public class DataHasResponseCmd extends CommandWithParamAndResponse<DataParam, CommonResponse> {
    public DataHasResponseCmd(DataParam dataParam) {
        super(1, DataHasResponseCmd.class.getSimpleName(), dataParam);
    }
}
