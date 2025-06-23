package com.baidu.ar;

import android.opengl.EGLContext;
import com.baidu.ar.obr.OBRConfig;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class DefaultParams {
    private String aX;
    private String aY;
    private String bk;
    private boolean bl;
    private boolean aZ = true;
    private boolean ba = true;
    private boolean bb = true;
    private boolean bc = true;
    private boolean bd = false;
    private EGLContext be = null;
    private String bf = null;
    private JSONObject bg = null;
    private boolean bh = true;
    private boolean bi = false;
    private boolean bj = true;
    private boolean au = true;
    private String bm = "wss://dusee.baidu.com/digitalhuman-ws";
    private String bn = "i-kgqiz7g0gv22a";
    private String bo = "app_key";
    private OBRConfig bp = null;

    public void enableLog(boolean z) {
        this.bh = z;
    }

    public String get3dShaderDBPath() {
        return this.bk;
    }

    public String getDigitalSocketUrl() {
        return this.bm;
    }

    public String getDigitalUnitAppId() {
        return this.bn;
    }

    public String getDigitalUnitAppKey() {
        return this.bo;
    }

    public String getFaceAlgoModelPath() {
        return this.aX;
    }

    public JSONObject getGradingConfig() {
        return this.bg;
    }

    public String getMdlAlgoModelPath() {
        return this.aY;
    }

    public OBRConfig getOBRConfig() {
        return this.bp;
    }

    public String getRenderPipeline() {
        return this.bf;
    }

    public EGLContext getShareContext() {
        return this.be;
    }

    public boolean isDigitalArEnable() {
        return this.bl;
    }

    public boolean isDigitalSocketEnable() {
        return this.au;
    }

    public boolean isLogEnable() {
        return this.bh;
    }

    public boolean isRecordAutoCrop() {
        return this.bj;
    }

    public boolean isUseBeautyFilter() {
        return this.ba;
    }

    public boolean isUseFaceFilter() {
        return this.bb;
    }

    public boolean isUseInputSizeInEngine() {
        return this.aZ;
    }

    public boolean isUseMakeupFilter() {
        return this.bc;
    }

    public boolean isUseTextureIO() {
        return this.bd;
    }

    public boolean isUserPlayAudio() {
        return this.bi;
    }

    public void set3dShaderPath(String str) {
        this.bk = str;
    }

    public void setDigitalArEnable(boolean z) {
        this.bl = z;
    }

    public void setDigitalSocketEnable(boolean z) {
        this.au = z;
    }

    public void setDigitalSocketUrl(String str) {
        this.bm = str;
    }

    public void setDigitalUnitAppId(String str) {
        this.bn = str;
    }

    public void setDigitalUnitAppKey(String str) {
        this.bo = str;
    }

    public void setFaceAlgoModelPath(String str) {
        this.aX = str;
    }

    public void setGradingConfig(JSONObject jSONObject) {
        this.bg = jSONObject;
    }

    public void setMdlAlgoModelPath(String str) {
        this.aY = str;
    }

    public void setOBRConfig(OBRConfig oBRConfig) {
        this.bp = oBRConfig;
    }

    public void setRecordAutoCrop(boolean z) {
        this.bj = z;
    }

    public void setRenderPipeline(String str) {
        this.bf = str;
    }

    public void setShareContext(EGLContext eGLContext) {
        this.be = eGLContext;
    }

    public void setUseBeautyFilter(boolean z) {
        this.ba = z;
    }

    public void setUseFaceFilter(boolean z) {
        this.bb = z;
    }

    public void setUseInputSizeInEngine(boolean z) {
        this.aZ = z;
    }

    public void setUseMakeupFilter(boolean z) {
        this.bc = z;
    }

    public void setUseTextureIO(boolean z) {
        this.bd = z;
    }

    public void setUserPlayAudio(boolean z) {
        this.bi = z;
    }
}
