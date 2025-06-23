package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;

/* loaded from: classes10.dex */
public class StartSpeechParam extends BaseParameter {
    private byte freq;
    private byte type;
    private byte way;

    public StartSpeechParam() {
    }

    public byte getFreq() {
        return this.freq;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        return new byte[]{this.type, this.freq, this.way};
    }

    public byte getType() {
        return this.type;
    }

    public byte getWay() {
        return this.way;
    }

    public StartSpeechParam setFreq(byte b) {
        this.freq = b;
        return this;
    }

    public StartSpeechParam setType(byte b) {
        this.type = b;
        return this;
    }

    public StartSpeechParam setWay(byte b) {
        this.way = b;
        return this;
    }

    public StartSpeechParam(byte b, byte b2) {
        this(b, b2, (byte) 1);
    }

    public StartSpeechParam(byte b, byte b2, byte b3) {
        this.type = b;
        this.freq = b2;
        this.way = b3;
    }
}
