package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class SetDevStorageCmd extends CommandWithParamAndResponse<SetDevStorageParam, CommonResponse> {

    /* loaded from: classes10.dex */
    public static class SetDevStorageParam extends BaseParameter {
        private final int devHandler;

        public SetDevStorageParam(int i) {
            this.devHandler = i;
        }

        public int getDevHandler() {
            return this.devHandler;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(this.devHandler));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    public SetDevStorageCmd(int i) {
        super(216, SetDevStorageCmd.class.getSimpleName(), new SetDevStorageParam(i));
    }
}
