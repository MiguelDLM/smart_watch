package com.jieli.eq;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes10.dex */
public class SOSPara {
    public float centerFrequency;
    public boolean enable;
    public float gain;
    private float m_defaultFreq;
    public float qValue;
    public int type;

    public SOSPara(float f) {
        this.enable = true;
        this.m_defaultFreq = f;
        this.centerFrequency = f;
    }

    public void copy(SOSPara sOSPara) {
        this.type = sOSPara.type;
        this.centerFrequency = sOSPara.centerFrequency;
        this.gain = sOSPara.gain;
        this.qValue = sOSPara.qValue;
        this.enable = sOSPara.enable;
    }

    public void reset() {
        this.type = 2;
        this.centerFrequency = this.m_defaultFreq;
        this.gain = 0.0f;
        this.qValue = 1.5f;
        this.enable = true;
    }

    public SOSPara() {
        this.enable = true;
        this.m_defaultFreq = 0.0f;
    }
}
