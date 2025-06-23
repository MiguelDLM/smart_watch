package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;

/* loaded from: classes10.dex */
public class NotifyPrepareEnvCmd extends CommandWithParamAndResponse<Param, CommonResponse> {
    public static final byte ENV_DELETE_FILE = 1;
    public static final byte ENV_FORMAT_DEVICE = 2;
    public static final byte ENV_TRANSFER_LARGE_FILE = 0;

    /* loaded from: classes10.dex */
    public static class NotifyPrepareTransferLargeFileParam extends Param {
        public NotifyPrepareTransferLargeFileParam() {
            super((byte) 0);
        }
    }

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        private byte env;

        public Param(byte b) {
            this.env = b;
        }

        public byte getEnv() {
            return this.env;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return new byte[]{this.env};
        }

        public void setEnv(byte b) {
            this.env = b;
        }
    }

    public NotifyPrepareEnvCmd(Param param) {
        super(33, NotifyPrepareEnvCmd.class.getSimpleName(), param);
    }
}
