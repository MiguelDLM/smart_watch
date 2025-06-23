package com.jieli.jl_rcsp.model.command;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParam;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class NotifyTTSPlayStateCmd extends CommandWithParam<Param> {

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        private int ttsState;

        public Param(int i) {
            this.ttsState = i;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return new byte[]{CHexConver.intToByte(this.ttsState)};
        }
    }

    public NotifyTTSPlayStateCmd(Param param) {
        super(17, NotifyTTSPlayStateCmd.class.getSimpleName(), param);
    }
}
