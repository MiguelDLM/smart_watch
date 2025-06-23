package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.model.parameter.LargeFileTransferOpParam;

/* loaded from: classes10.dex */
public class LargeFileTransferOpCmd extends CommandWithParam<LargeFileTransferOpParam> {
    public LargeFileTransferOpCmd(LargeFileTransferOpParam largeFileTransferOpParam) {
        super(29, LargeFileTransferOpCmd.class.getSimpleName(), largeFileTransferOpParam);
    }
}
