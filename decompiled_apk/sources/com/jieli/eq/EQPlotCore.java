package com.jieli.eq;

import androidx.annotation.Keep;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@Keep
/* loaded from: classes10.dex */
public class EQPlotCore {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int[] m_centerFreqs;
    private long m_eqPlotCore;
    private FloatBuffer m_freq2plot;
    private FloatBuffer m_gain2plot;
    private int m_nplot;
    private long m_paraHolder;
    private SOSPara[] m_sosPara;
    private float m_totalGain;

    static {
        System.loadLibrary("jl_eq");
    }

    public EQPlotCore(int i, int i2, int[] iArr) {
        int i3 = i * 4;
        this.m_freq2plot = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.m_gain2plot = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.m_centerFreqs = iArr;
        this.m_sosPara = new SOSPara[i2];
        int i4 = 0;
        while (true) {
            SOSPara[] sOSParaArr = this.m_sosPara;
            if (i4 < sOSParaArr.length) {
                sOSParaArr[i4] = new SOSPara(this.m_centerFreqs[i4]);
                this.m_sosPara[i4].reset();
                i4++;
            } else {
                long allocateParaHolder = allocateParaHolder(sOSParaArr);
                this.m_paraHolder = allocateParaHolder;
                this.m_totalGain = 1.0f;
                this.m_nplot = i;
                this.m_eqPlotCore = allocateEQPlotCore(this.m_freq2plot, i, allocateParaHolder, 3);
                return;
            }
        }
    }

    private native long allocateEQPlotCore(FloatBuffer floatBuffer, int i, long j, int i2);

    private native long allocateParaHolder(SOSPara[] sOSParaArr);

    private native void getEQPlotData(FloatBuffer floatBuffer, long j, long j2, int i, float f);

    private native void nativeUpdateParaFreq(long j, int i, float f);

    private native void nativeUpdateParaGain(long j, int i, float f);

    private native void nativeUpdateParaQVal(long j, int i, float f);

    private native void nativeUpdateParaType(long j, int i, int i2);

    private native void releaseNativeObject(long j, long j2);

    private native void updateParaFreqGain(long j, int i, float f, float f2);

    public float getEQPlotData(float[] fArr, int i) {
        getEQPlotData(this.m_gain2plot, this.m_eqPlotCore, this.m_paraHolder, i, this.m_totalGain);
        float f = this.m_gain2plot.get(0);
        for (int i2 = 0; i2 < this.m_nplot; i2++) {
            f = Math.max(f, this.m_gain2plot.get(i2));
            if (i2 == 0) {
                fArr[0] = this.m_freq2plot.get(i2);
                fArr[1] = this.m_gain2plot.get(i2);
            } else {
                if (i2 == this.m_nplot - 1) {
                    fArr[(r2 * 4) - 6] = this.m_freq2plot.get(i2);
                    fArr[(this.m_nplot * 4) - 5] = this.m_gain2plot.get(i2);
                } else {
                    int i3 = i2 * 4;
                    fArr[i3 - 2] = this.m_freq2plot.get(i2);
                    fArr[i3 - 1] = this.m_gain2plot.get(i2);
                    fArr[i3] = this.m_freq2plot.get(i2);
                    fArr[i3 + 1] = this.m_gain2plot.get(i2);
                }
            }
        }
        return f;
    }

    public SOSPara getPara(int i) {
        return this.m_sosPara[i];
    }

    public SOSPara[] getSOSPara() {
        return this.m_sosPara;
    }

    public void releaseNativeObject() {
        releaseNativeObject(this.m_eqPlotCore, this.m_paraHolder);
    }

    public void setTotalGain(float f) {
        this.m_totalGain = f;
    }

    public void syncPara(int i) {
        nativeUpdateParaFreq(this.m_paraHolder, i, this.m_sosPara[i].centerFrequency);
        nativeUpdateParaGain(this.m_paraHolder, i, this.m_sosPara[i].gain);
        nativeUpdateParaQVal(this.m_paraHolder, i, this.m_sosPara[i].qValue);
        nativeUpdateParaType(this.m_paraHolder, i, this.m_sosPara[i].type);
    }

    public void updatePara(int i, float f, float f2) {
        SOSPara sOSPara = this.m_sosPara[i];
        sOSPara.centerFrequency = f;
        sOSPara.gain = f2;
        updateParaFreqGain(this.m_paraHolder, i, f, f2);
    }

    public void updateParaFreq(int i, float f) {
        this.m_sosPara[i].centerFrequency = f;
        nativeUpdateParaFreq(this.m_paraHolder, i, f);
    }

    public void updateParaGain(int i, float f) {
        this.m_sosPara[i].gain = f;
        nativeUpdateParaGain(this.m_paraHolder, i, f);
    }

    public void updateParaQVal(int i, float f) {
        this.m_sosPara[i].qValue = f;
        nativeUpdateParaQVal(this.m_paraHolder, i, f);
    }

    public void updateParaType(int i, int i2) {
        this.m_sosPara[i].type = i2;
        nativeUpdateParaType(this.m_paraHolder, i, i2);
    }
}
