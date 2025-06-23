package com.baidu.ar.arplay.core.engine;

/* loaded from: classes7.dex */
public class ARPEngineParams {
    private float mDensity;
    private int mInputHeight;
    private int mInputWidth;
    private boolean mIsFrontCamera = true;
    private int mOutputHeight;
    private int mOutputWidth;
    private String mShaderDBPath;

    public float getDensity() {
        return this.mDensity;
    }

    public int getInputHeight() {
        return this.mInputHeight;
    }

    public int getInputWidth() {
        return this.mInputWidth;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public String getShaderDBPath() {
        return this.mShaderDBPath;
    }

    public boolean isIsFrontCamera() {
        return this.mIsFrontCamera;
    }

    public void setDensity(float f) {
        this.mDensity = f;
    }

    public void setInputHeight(int i) {
        this.mInputHeight = i;
    }

    public void setInputWidth(int i) {
        this.mInputWidth = i;
    }

    public void setIsFrontCamera(boolean z) {
        this.mIsFrontCamera = z;
    }

    public void setOutputHeight(int i) {
        this.mOutputHeight = i;
    }

    public void setOutputWidth(int i) {
        this.mOutputWidth = i;
    }

    public void setShaderDBPath(String str) {
        this.mShaderDBPath = str;
    }
}
