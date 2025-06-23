package com.baidu.ar;

import android.graphics.SurfaceTexture;

/* loaded from: classes7.dex */
public class DuMixSource {
    private String bZ;
    private String ca;
    private SurfaceTexture cb;
    private int cc;
    private int cd;
    private boolean ce;
    private BusinessType cf;
    private int mArType;
    private boolean mFrontCamera;
    private double[] mGPSInfo;
    private String mResFilePath;

    public DuMixSource(SurfaceTexture surfaceTexture, int i, int i2) {
        this(surfaceTexture, i, i2, BusinessType.CAMEXP);
    }

    public String getArKey() {
        return this.bZ;
    }

    public int getArType() {
        return this.mArType;
    }

    public String getBaiduMapCuid() {
        return this.ca;
    }

    public BusinessType getBusinessType() {
        return this.cf;
    }

    public SurfaceTexture getCameraSource() {
        return this.cb;
    }

    public double[] getGPSInfo() {
        return this.mGPSInfo;
    }

    public String getResFilePath() {
        return this.mResFilePath;
    }

    public int getSourceHeight() {
        return this.cd;
    }

    public int getSourceWidth() {
        return this.cc;
    }

    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    public boolean isNeedDrawBackground() {
        return this.ce;
    }

    public void setArKey(String str) {
        this.bZ = str;
    }

    public void setArType(int i) {
        this.mArType = i;
    }

    public void setBaiduMapCuid(String str) {
        this.ca = str;
    }

    public void setCameraSource(SurfaceTexture surfaceTexture) {
        this.cb = surfaceTexture;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setGPSInfo(double[] dArr) {
        this.mGPSInfo = dArr;
    }

    public void setNeedDrawBackground(boolean z) {
        this.ce = z;
    }

    public void setResFilePath(String str) {
        this.mResFilePath = str;
    }

    public void setSourceHeight(int i) {
        this.cd = i;
    }

    public void setSourceWidth(int i) {
        this.cc = i;
    }

    public DuMixSource(SurfaceTexture surfaceTexture, int i, int i2, BusinessType businessType) {
        this.mArType = -1;
        this.mResFilePath = "";
        this.mFrontCamera = false;
        this.cc = 0;
        this.cd = 0;
        this.ce = true;
        BusinessType businessType2 = BusinessType.CAMEXP;
        this.cb = surfaceTexture;
        this.cc = i;
        this.cd = i2;
        this.cf = businessType;
    }

    public DuMixSource(DuMixSource duMixSource) {
        this.mArType = -1;
        this.mResFilePath = "";
        this.mFrontCamera = false;
        this.cc = 0;
        this.cd = 0;
        this.ce = true;
        this.cf = BusinessType.CAMEXP;
        this.bZ = duMixSource.getArKey();
        this.mArType = duMixSource.getArType();
        this.mResFilePath = duMixSource.getResFilePath();
        this.cb = duMixSource.getCameraSource();
        this.cc = duMixSource.getSourceWidth();
        this.cd = duMixSource.getSourceHeight();
        this.mGPSInfo = duMixSource.getGPSInfo();
        this.ce = duMixSource.isNeedDrawBackground();
        this.cf = duMixSource.cf;
    }
}
