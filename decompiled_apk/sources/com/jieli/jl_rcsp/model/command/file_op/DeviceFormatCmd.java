package com.jieli.jl_rcsp.model.command.file_op;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class DeviceFormatCmd extends CommandWithParamAndResponse<Param, Response> {

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        private int devHandle;

        public Param(int i) {
            this.devHandle = i;
        }

        public int getDevHandle() {
            return this.devHandle;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return CHexConver.intToBigBytes(this.devHandle);
        }

        public void setDevHandle(int i) {
            this.devHandle = i;
        }
    }

    /* loaded from: classes10.dex */
    public static class Response extends CommonResponse {
        private int reason;

        public Response(int i) {
            this.reason = i;
        }

        public int getReason() {
            return this.reason;
        }

        public void setReason(int i) {
            this.reason = i;
        }
    }

    public DeviceFormatCmd(Param param) {
        super(34, DelDevFileCmd.class.getSimpleName(), param);
    }
}
