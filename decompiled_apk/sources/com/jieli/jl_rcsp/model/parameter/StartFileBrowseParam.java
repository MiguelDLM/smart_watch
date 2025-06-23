package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_filebrowse.bean.PathData;
import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class StartFileBrowseParam extends BaseParameter {
    private PathData pathData;

    public StartFileBrowseParam(PathData pathData) {
        this.pathData = pathData;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        PathData pathData = this.pathData;
        if (pathData == null) {
            return new byte[0];
        }
        return pathData.toData();
    }

    public PathData getPathData() {
        return this.pathData;
    }

    public StartFileBrowseParam setPathData(PathData pathData) {
        this.pathData = pathData;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "StartFileBrowseParam{pathData=" + this.pathData + '}';
    }
}
