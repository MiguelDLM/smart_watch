package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.StartFileBrowseParam;
import com.jieli.jl_rcsp.model.response.StartFileBrowseResponse;

/* loaded from: classes10.dex */
public class StartFileBrowseCmd extends CommandWithParamAndResponse<StartFileBrowseParam, StartFileBrowseResponse> {
    public StartFileBrowseCmd(StartFileBrowseParam startFileBrowseParam) {
        super(12, StartFileBrowseCmd.class.getSimpleName(), startFileBrowseParam);
    }
}
