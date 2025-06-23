package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.SearchDevParam;
import com.jieli.jl_rcsp.model.response.SearchDevResponse;

/* loaded from: classes10.dex */
public class SearchDevCmd extends CommandWithParamAndResponse<SearchDevParam, SearchDevResponse> {
    public SearchDevCmd(SearchDevParam searchDevParam) {
        super(25, SearchDevCmd.class.getSimpleName(), searchDevParam);
    }
}
