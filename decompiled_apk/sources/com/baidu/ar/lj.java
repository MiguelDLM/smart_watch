package com.baidu.ar;

/* loaded from: classes7.dex */
public class lj implements ll {
    protected static final float[] Eg = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    protected lm DF;
    protected int mPreviewHeight;
    protected int mPreviewWidth;

    public lj(lm lmVar, int i, int i2) {
        this.DF = lmVar;
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
    }

    @Override // com.baidu.ar.ll
    public boolean i(float[] fArr) {
        lm lmVar = this.DF;
        lmVar.a(lmVar.a((lb) null), this.mPreviewWidth / 2, this.mPreviewHeight / 2, Eg, 1000.0f);
        return true;
    }
}
