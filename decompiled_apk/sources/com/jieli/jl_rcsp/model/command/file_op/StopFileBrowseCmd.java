package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.model.parameter.StopFileBrowseParam;

/* loaded from: classes10.dex */
public class StopFileBrowseCmd extends CommandWithParamAndResponse<StopFileBrowseParam, CommonResponse> {
    public StopFileBrowseCmd(StopFileBrowseParam stopFileBrowseParam) {
        super(13, StopFileBrowseCmd.class.getSimpleName(), stopFileBrowseParam);
    }
}
