package com.baidu.ar.baidumap;

import android.opengl.EGLContext;
import com.baidu.ar.obr.OBRConfig;

/* loaded from: classes7.dex */
public class MapDuMixParams {
    private boolean bd = false;
    private EGLContext be = null;
    private OBRConfig bp = null;
    private int height;
    private String lT;
    private double[] lU;
    private String mBuildingId;
    private int width;

    public String getBuildingId() {
        return this.mBuildingId;
    }

    public String getCuid() {
        return this.lT;
    }

    public int getHeight() {
        return this.height;
    }

    public double[] getInitGPSInfo() {
        return this.lU;
    }

    public OBRConfig getOBRConfig() {
        return this.bp;
    }

    public EGLContext getShareContext() {
        return this.be;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isUseTextureIO() {
        return this.bd;
    }

    public void setBuildingId(String str) {
        this.mBuildingId = str;
    }

    public void setCuid(String str) {
        this.lT = str;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setInitGPSInfo(double[] dArr) {
        this.lU = dArr;
    }

    public void setOBRConfig(OBRConfig oBRConfig) {
        this.bp = oBRConfig;
    }

    public void setShareContext(EGLContext eGLContext) {
        this.be = eGLContext;
    }

    public void setUseTextureIO(boolean z) {
        this.bd = z;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
