package com.jieli.jl_rcsp.model.command.speech;

import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.parameter.StopSpeechParam;
import com.jieli.jl_rcsp.model.response.StopSpeechResponse;

/* loaded from: classes10.dex */
public class StopSpeechCmd extends CommandWithParamAndResponse<StopSpeechParam, StopSpeechResponse> {

    /* loaded from: classes10.dex */
    public static class ReplyParam extends StopSpeechParam {
        private boolean isPlayTTS;
        private boolean isSyncIatText;
        private boolean isSyncNlpText;

        public ReplyParam(boolean z, boolean z2, boolean z3) {
            this.isSyncIatText = z;
            this.isSyncNlpText = z2;
            this.isPlayTTS = z3;
        }

        @Override // com.jieli.jl_rcsp.model.parameter.StopSpeechParam, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return new byte[]{(byte) ((this.isSyncIatText ? 1 : 0) + ((this.isSyncNlpText ? 1 : 0) << 1) + ((this.isPlayTTS ? 1 : 0) << 2))};
        }
    }

    public StopSpeechCmd(StopSpeechParam stopSpeechParam) {
        super(5, StopSpeechCmd.class.getSimpleName(), stopSpeechParam);
    }
}
