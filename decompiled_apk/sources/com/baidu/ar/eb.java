package com.baidu.ar;

/* loaded from: classes7.dex */
public class eb {
    public int mSampleRate;
    public String qi;
    public int qj;
    public String qk;
    public String ql;
    public int qm;
    public short qn;
    public short qo;
    public int qp;
    public short qq;
    public short qr;
    public String qs;
    public int qt;

    public String toString() {
        return "WavFileHeader{mChunkID='" + this.qi + "', mChunkSize=" + this.qj + ", mFormat='" + this.qk + "', mSubChunk1ID='" + this.ql + "', mSubChunk1Size=" + this.qm + ", mAudioFormat=" + ((int) this.qn) + ", mNumChannel=" + ((int) this.qo) + ", mSampleRate=" + this.mSampleRate + ", mByteRate=" + this.qp + ", mBlockAlign=" + ((int) this.qq) + ", mBitsPerSample=" + ((int) this.qr) + ", mSubChunk2ID='" + this.qs + "', mSubChunk2Size=" + this.qt + '}';
    }

    public int u(int i) {
        return (i * 1000) / this.qp;
    }
}
