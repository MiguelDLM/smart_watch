package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class BatchCmd extends CommandBase<Param, Response> {
    public static final byte OP_CANCEL = -127;
    public static final byte OP_START = 0;
    public static final byte OP_STOP = Byte.MIN_VALUE;

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        private final byte op;
        private final byte[] param;

        public Param(byte b, byte[] bArr) {
            this.op = b;
            this.param = bArr;
        }

        public byte getOp() {
            return this.op;
        }

        public byte[] getParam() {
            return this.param;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            byte[] bArr = this.param;
            byte[] bArr2 = new byte[bArr.length + 2];
            bArr2[0] = this.op;
            bArr2[1] = (byte) bArr.length;
            System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
            return bArr2;
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse {
        private final byte op;
        private final byte ret;

        public Response(byte b, byte b2) {
            this.op = b;
            this.ret = b2;
        }

        public byte getOp() {
            return this.op;
        }

        public byte getRet() {
            return this.ret;
        }
    }

    public BatchCmd(Param param) {
        this(2, param);
    }

    public BatchCmd(int i, Param param) {
        super(38, BatchCmd.class.getSimpleName(), i);
        setParam(param);
    }
}
