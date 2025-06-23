package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class StopSpeechParam extends BaseParameter {
    private byte reason;
    private boolean isSyncIatText = false;
    private boolean isSyncNlpText = false;
    private boolean isPlayTTS = false;

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[]{this.reason, (byte) ((this.isSyncIatText ? 1 : 0) + ((this.isSyncNlpText ? 1 : 0) << 1) + ((this.isPlayTTS ? 1 : 0) << 2))};
    }

    public byte getReason() {
        return this.reason;
    }

    public boolean isPlayTTS() {
        return this.isPlayTTS;
    }

    public boolean isSyncIatText() {
        return this.isSyncIatText;
    }

    public boolean isSyncNlpText() {
        return this.isSyncNlpText;
    }

    public StopSpeechParam setPlayTTS(boolean z) {
        this.isPlayTTS = z;
        return this;
    }

    public StopSpeechParam setReason(byte b) {
        this.reason = b;
        return this;
    }

    public StopSpeechParam setSyncIatText(boolean z) {
        this.isSyncIatText = z;
        return this;
    }

    public StopSpeechParam setSyncNlpText(boolean z) {
        this.isSyncNlpText = z;
        return this;
    }
}
