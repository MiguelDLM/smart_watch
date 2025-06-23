package com.jieli.jl_rcsp.task.smallfile;

import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.model.command.file_op.SmallFileTransferCmd;
import com.jieli.jl_rcsp.task.smallfile.AddFileTask;
import com.jieli.jl_rcsp.task.smallfile.QueryFileTask;

/* loaded from: classes10.dex */
public class UpdateFileTask extends AddFileTask {
    public final Param d;

    /* loaded from: classes10.dex */
    public static class Param extends AddFileTask.Param {
        public final short d;

        public Param(byte b, short s, byte[] bArr) {
            super(b, bArr);
            this.d = s;
        }

        public short getId() {
            return this.d;
        }
    }

    public UpdateFileTask(RcspOpImpl rcspOpImpl, Param param) throws RuntimeException {
        super(rcspOpImpl, param);
        this.d = param;
        this.c = new QueryFileTask.File(param.type, param.d, param.size);
    }

    @Override // com.jieli.jl_rcsp.task.smallfile.AddFileTask
    public SmallFileTransferCmd.Param a(short s, short s2, byte[] bArr, short s3) {
        Param param = this.d;
        return new SmallFileTransferCmd.UpdateFileParam(param.type, param.d, s, s2, bArr, s3);
    }
}
